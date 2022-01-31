# To run only Sanity test cases use: gradlew -DbaseURI="https://reqres.in/api" -Dcucumber.filter.tags="@Sanity" runCucumberTests
# To run only Regression test cases use: gradlew -DbaseURI="https://reqres.in/api" -Dcucumber.filter.tags="@Regression" runCucumberTests
Feature: to verify CRUD Operations

@Regression @Sanity
Scenario: Verify GET operation
 Given Api baseURI and USERID "2"
 When user request user details using USERID
 Then user api should be responded with "200"
 And USERID should match with id in the Reponse
 And useremail should be "janet.weaver@reqres.in"
 
 @Regression
 Scenario: Verify user not found operation
 Given Api baseURI and USERID "23"
 When user request user details using USERID
 Then user api should be responded with "404"
 
 @Regression @Sanity
Scenario: Verify POST operation
 Given Api baseURI and name "naresh" and job "qa engineer"
 When create user api is called
 Then user api should be responded with "201"
 

 