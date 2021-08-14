# Week 2 Review
1. [EU5 Cucumber Prep](#eu5-cucumber-prep)
    1. [Cucumber DDT](#cucumber-ddt)
    2. [Cucumber Rerun Failed Scenario](#cucumber-rerun-failed-scenario)
    3. [Cucumber Parallel Execution](#cucumber-parallel-execution)
    4. [Filtering the test from the maven cmd](#filtering-the-test-from-the-maven-cmd)
2. [EU5 Jenkins Prep](#eu5-jenkins-prep)
    1. [Create AWS Account](#create-aws-account)
    2. [Create EC2 Machine](#create-ec2-machine)
    3. [Setup Jenkins](#setup-jenkins)

# EU5 Cucumber Prep

## Cucumber DDT
- **Scenario outline with example**
 ```feature
  Scenario Outline: Different user types
  Given user is at login page 
  When the user logged in as "<userType>"
  Then the user should see "Dashboard" page
  Examples:
    | userType      |
    | driver        |
    | store manager |
    | sales manager |
  ```

## Cucumber Rerun Failed Scenario
1. Add a line in cucumber option to specify how cucumber store failed steps in feature `rerun:target/rerun.txt` in `cucumberOptions`
```java
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/vytrack/step_definitions",
        dryRun = false,
        tags = "@login"
)
public class CukesRunner {
}
```
2. Add a **runner class** for failed scenario by pointing to those scenario in cucumber options
```java
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-html-report"},
        features = "@target/rerun.txt",
        glue = "com/vytrack/step_definitions"
)
public class FailedTestRunner {
}
```
3. Update `sure-fire-plugin` to include this runner
```xml
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.22.2</version>
        <configuration>
            <parallel>methods</parallel>
            <useUnlimitedThreads>true</useUnlimitedThreads>
            <testFailureIgnore>true</testFailureIgnore>
            <runOrder>Alphabetical</runOrder>
            <includes>
                <include>**/*CukesRunner.java</include>
                <include>**/*FailedTestRunner.java</include>
            </includes>
        </configuration>
    </plugin>
```

## Cucumber Parallel Execution
1. Update Driver for **Thread Safety**
```java
public class Driver {
    private Driver() {
    }
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    public static WebDriver get() {
        if (driverPool.get() == null) {

            String browser = 
                  System.getProperty("browser") != null 
                    ? browser = System.getProperty("browser") 
                    : ConfigurationReader.get("browser");
            
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                // case other browsers omitted
                // selenium grid options goes here for future classes
                case "remote_chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setCapability("platform", Platform.ANY);
                    try {
                        driverPool.set(new RemoteWebDriver(new URL("http://3.236.102.181:4444/wd/hub"),chromeOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
            }
        }
        return driverPool.get();
    }
    public static void closeDriver() {
        driverPool.get().quit();
        driverPool.remove();
    }
}
```

2. **`pom.xml` update**
```xml
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.22.2</version>
        <configuration>
            <parallel>methods</parallel>
            <useUnlimitedThreads>true</useUnlimitedThreads>
            <testFailureIgnore>true</testFailureIgnore>
            <runOrder>Alphabetical</runOrder>
            <includes>
                <include>**/*CukesRunner.java</include>
            </includes>
        </configuration>
    </plugin>
```
---

## Filtering the test from the maven cmd
```bash
mvn test -Dcucumber.filter.tags=@yourTagHere
```





# EU5 Jenkins Prep

## Create AWS Account
Follow instruction to create account just like facebook

## Create EC2 Machine
1. Navigate to `EC2` service
2. Launch new EC2 instance
3. Search for `Cybertek Latest` AMI
4. Add Security group to open ports:
    1. **`8081`** for jenkins
    2. **`8000`** for spartan practice app
    3. **`7000`** for spartan practice app with auth
    4. **`1521`** for database
    5. **`1000`** for HR ORDS API
5. Click next till final step and wait until it's ready
6. Use newly generated IP Adderss to access Jenkins
    1. for example **`YourIP:8081`**


## Setup Jenkins
1. Use default passport to bypass to next step
2. Create your own username password and all set
3. Select `Manage Plugins` to install `Cucumber Report`
4. Optionally specify `JDK` - `Maven` - `git` localtion in global tools setting
5. Create FreeStyle Jenkins Job
    1. Specify project location
    2. Specify run internal using cron expression
    3. Add Build Step to run maven goal
        1. **`clean verify -Dcucumber.filter.tags=@`**
        2. add optional cucumber options if needed like
            - `-Dcucumber.filter.tags=@calculator`
    4. Add post build step for cucumber report with default options
    5. Optionally add email step to send jenkins result