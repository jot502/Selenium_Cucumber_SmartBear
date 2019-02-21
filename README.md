# Project Description

This project validates the SmartBear Application functionality using Selenium, Cucumber and Gradle.

## Prerequisite

1. Web-Browser driver to be placed in local directory and to be updated it tne config.properties
2. Gradle 4.X or higher version installed
3. GitBash (Not mandatory)


## Usage

```java
./gradlew test_run

```

## Remarks
This projects just shows the workflow of UI testing using Selenium and Cucumber frameworks.
For ease of coding and highlighting capabilities, i have implemented Gradle Task - "test_run", which generates a JSON report file 
which can be directly plugged in any CI/CD or Automation Reporting
For other reporting formats, please change the gradle task in build.gradle.

Also note as this is a dummy projects so havent actually implemented Log reporting. 
However this an be implemented for any actual AUT framework.
Other framework features like generic utilities and consolidating common page objects can be implemented in any enterprose framework.
 

## Contributions
Pull requests are welcome. Request to discuss prior for any change or issues.