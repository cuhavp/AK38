Selenium Java Basic AK38 with maven project

## Setup
1. Required JDK 11+
2. Install Maven
3. Install Chrome browser
4. Install Firefox Browser

## How to run
```shell
mvn clean test -Dtestsuite=todo-mvc.testplan.xml
```

## Framework Structure
```shell
.
├── JavaScriptAlert_TestPlan.xml
├── Readme.md
├── assets
│   └── githubActionReport.png
├── pom.xml
├── src
│   └── test
│       ├── java
│       │   └── com
│       │       └── tvn
│       │           ├── BaseTest.java
│       │           ├── BodyMassIndexTest.java
│       │           ├── browser
│       │           │   ├── OpenChromeBrowserTest.java
│       │           │   ├── OpenFirefoxBrowserTest.java
│       │           │   └── OpenSafariBrowserTest.java
│       │           ├── elements
│       │           │   ├── CheckboxTest.java
│       │           │   ├── ContextMenuTest.java
│       │           │   ├── DropDownTest.java
│       │           │   ├── GoogleSearchTest.java
│       │           │   ├── HoverTest.java
│       │           │   ├── HyperLinkTest.java
│       │           │   ├── JavaScriptAlertTest.java
│       │           │   ├── LoadingTest.java
│       │           │   ├── LoginTest.java
│       │           │   ├── NestedFrameTest.java
│       │           │   ├── Person.java
│       │           │   ├── Row.java
│       │           │   ├── TableTest.java
│       │           │   └── TodoTest.java
│       │           └── pages
│       │               ├── BasePage.java
│       │               ├── BodyMassIndexPage.java
│       │               ├── LoginPage.java
│       │               ├── SecurePage.java
│       │               └── TodoPage.java
│       └── resources
│           └── characters.json
└── todo-mvc.testplan.xml
```
*Suffix Rule*
- **Page.java --> define **page object class** and under [pages](/src/test/java/com/tvn/pages) package
- **Test.java --> define **test cases class**
- **.testplan.xml --> define **test plan to execute**

## Github Action Report
![Report](assets/githubActionReport.png)
