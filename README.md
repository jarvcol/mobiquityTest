# mobiquityTest

Hello!!.

Here you can the automation test of the task

Project is made using java 8, cucumber, junit and selenium. For more details please refer to POM dependencies

There are three features:
  - Login.feature : It is testing the login and logout functionality
  - AddEmployee.feature : It is testing the add employee functionality
  - EditEmployee.feature :  It is testing the edit employee functionality

There is a file called Configuration.properties in the resources directory. In this file it can be configured:
  - Web browser for the test
  - Default time out time
  - Test environment (currently only one PROD is configured)

Please download and follow this commands to prepare and run the test.
mvn clean compile
mvn verify

Reports can be found in the target folder once executed (depending on the way you execute the test different reports may appear). There are multiple reports but best one should be located in ..target/cucumber-report-html/cucumber-html-reports:
![report](https://github.com/jarvcol/mobiquityTest/tree/master/reportImg/report1.png)

![report](https://github.com/jarvcol/mobiquityTest/tree/master/reportImg/report2.png)

Please note that project is made on Behavior Driven Development (BDD) based on the bonus points list.

Most importan test like (add, edit, delete, login and logout) were intended to be covered; some of them may fail on execution due to what seems to be some instability on the test application but I have not enough time to check it.

Some process I had to workaroung like clearing the inputs in the login and trying to force the list of employees update after a deletion, but the first one was succesful and the later was not. Instead of forcing the update I ended up login out and loggin in again (faster and easiest).
