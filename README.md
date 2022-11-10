# Smart Reporting UI automation challenge

![fluxo de trabalho de exemplo](https://github.com/MateusPasqualini/smartreporting-ui-challenge/workflows/Java%20CI%20with%20Maven/badge.svg)

## Required software

* [Java JDK 8+](https://jdk.java.net/java-se-ri/8-MR3)
* [Maven](https://maven.apache.org/download.cgi)

## Running the tests

### Running the test suites locally

to run the suite simply run the maven test lifecycle

```
mvn clean test
```

### Generating the test report

there are two ways to generate the reports:

* `mvn allure:serve`: will open the HTML report into the browser (it will run on a local port. default:52608)
* `mvn allure:report`: will generate the HTML port at `target/site/allure-maven-plugin` folder

## Libraries

* [Selenium WebDriver](https://www.selenium.dev/) library for automating web-based applications
* [TestNG](https://testng.org/doc/) to support the test creation
* [Allure Report](https://docs.qameta.io/allure/) as the testing report strategy
* [Hamcrest](http://hamcrest.org/) for more flexible and readable assertions
* [Lombok](https://projectlombok.org/) framework that utilizes annotations to reduce code verbosity

## Patterns applied

* Page Factory
* Page Generator
* Test Data Factory
* Data Provider
* Builder
* Request and Response Specification
* Base Test

## Pipeline

This project uses [GitHub Actions](https://github.com/features/actions) to run the all the tests in a pipeline.

In this project we have a fairly simple pipeline with two stages:

```
build -> End to End 
```

to the trigger the CI/CD, it can be either done with push to the main branch or pull request to the main branch also. It
can also be triggered manually, by going into the Actions tab, entering an existing workflow and re-running it.

## Approach in selecting the scenarios

For the approach in creating the automated scenarios for the UI 
the scenarios were chosen based on the proposed challenge functionalities.


```
Scenario 1 
Title:  Add Computer - Add new computer in the application
Precondition: being in the home page

Given that I want to add a new computer
When I click the "Add a new computer" button
And fill the form with a new computer data
And I click "Create this computer"
Then I must be redirected do the Home page with a successful message

Reproduction:
    1. Click on the "Add a new computer" button
    2. In the field: "Computer name" insert a valid computer name
    3. In the field: "Introduced" insert a valid date for the computer
    4. In the field: "Discontinued" insert a valid date for the computer 
    5. In the field: "Company" Select from the dropdown the company for the computer
    6. Click on the "Create this computer" button
Expected result: Must redirect to the home page and display an alert with
the "Done ! Computer [computer name] has been created" message  
 

Scenario 2
Title:  Filter computer - Filter existing computers by name
Precondition: pre-existing computer in the application

Given that I want to find a computer
When I filter by It's name
Then the application must display the computers filtered

Reproduction:
    1. In the field: "Filter by computer name" insert valid computer name
    2. Click on the "Filter by name" button
Expected result: Must display the computers that match that name 

Scenario 3
Title:  Edit computer - Edit pre-existing computers
Precondition: pre-existing computer in the application

Given that I want to edit a computer
When I select a computer
And change the form data
Then I must be redirected do the Home page with a successful message

Reproduction:
    1. Select the computer
    2. In the field: "Computer name" insert a valid computer name
    3. In the field: "Introduced" insert a valid date for the computer
    4. In the field: "Discontinued" insert a valid date for the computer 
    5. In the field: "Company" Select from the dropdown the company for the computer
    6. Click on the "Save this computer" button
Expected result: Must redirect to the home page and display an alert with
the "Done ! Computer [computer name edited] has been updated" message
