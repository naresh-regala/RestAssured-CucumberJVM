# RestAssured-CucumberJVM
- template for Rest Assured + CucumberJVM

## Gradle command to run tests
- To run only Sanity test cases use: gradlew -DbaseURI="https://reqres.in/api" -Dcucumber.filter.tags="@Sanity" runCucumberTests
- To run only Regression test cases use: gradlew -DbaseURI="https://reqres.in/api" -Dcucumber.filter.tags="@Regression" runCucumberTests

## Find Reports in target folder

 ### To Run on GitHub using GitHub Actions Pipeline
 - You can run the scripts on github using GitHub Actions. You can find the .yml file in current project .github/workflows



