# mobiquityTest

Hello!!

Here you can find the automation test of the assignment

Project is made basically using:
  - Java 8
  - Cucumber
  - Junit
  - Selenium
  - Maven

There are three features:
  - Login.feature : It is testing the login and logout functionality
  - AddEmployee.feature : It is testing the add employee functionality
  - EditEmployee.feature :  It is testing the edit employee functionality

There is a file called Configuration.properties in the resources directory. In this file it can be configured:
  - Web browser for the test
  - Default time out time
  - Test environment (currently only one PROD is configured)

Depending on the IDE used and the plugins the project can be run either:
- Running directly the features or scenarios (will run features or scenarios by demand)
- Running the test runner class (mobiquity.RunCucumberTest) (will run sequentialy the features)
- Using maven (will run test in parallel and create a more friendly report):
  * mvn clean compile (to clean a compile the project)
  * mvn verify (to actually run the test)

Reports can be found in the target folder once executed (depending on the way you execute the test different reports may appear). There are multiple reports but best one should be located in ..target/cucumber-report-html/cucumber-html-reports:
![Report example 1](https://github.com/jarvcol/mobiquityTest/blob/master/reportImg/report1.png)

![Report example 2](https://github.com/jarvcol/mobiquityTest/blob/master/reportImg/report2.png)

Please note that project is made:
 - Using Behavior Driven Development (BDD) based on the bonus points list and choosing Cucumber as one of the most popular and supported tools for that. 
 - Using Java, because is a well known language and strong language.
 - Junit as one of the most popular, supported and popular test frameworks for Java. It also allows to generate multiple report files that along with plugins creates better reports 

Most importan test like (add, edit, delete, login and logout) were intended to be covered. As those are the principal functionalities of the application.

Design of the page were intended to have a single UserMainPage which has (contains) multiple pages like the list view, and the employee form (which can be derived in add and edit forms).

Test results are mostly passed; but I have seen some failed test results specially in the edit and delete test. I have not been able to determine why as each time those cases were run individually or in debug mode they do not fail.

Application had some weird behaviors (issues) like the password not being cleared after logout and employee list duplication after one employee is deleted. I tried to workaround those like clearing the inputs in the login and trying to force the list of employees update after a deletion, but the first one was succesful and the later was not. Instead of forcing the update I ended up login out and loggin in again (faster and easiest).

Hope the project is to your liking.

Regards.

