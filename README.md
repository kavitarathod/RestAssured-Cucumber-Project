# RestAssured_Java_Project

**Tools/Framework/Libraries**  
Java - JDK 1.8
Maven - build tool
TestNG - test runner
Cucumber - BDD/Gherkin style feature files
Rest assured - Rest api verification library

**Dependency Management**
Below are the version used in the project:
<properties>  
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<cumcumber.version>7.3.2</cumcumber.version>  
		<testNG.version>7.5</testNG.version>  
		<restassured.version>5.1.0</restassured.version>  
		<jsonSimple.version>1.1.1</jsonSimple.version>  
		<java.version>1.8</java.version>  
</properties>  
Refer the pom.xml file in the Root directory of the project.

**Run the tests using maven**  
Import the project as Maven Project and run the tests using the below command
*mvn test -Dcucumber.options="src/test/resources/feature"*
or
Run the **TestRunner.java** under the package com.runner as the TestNG test.

**REST API**  
This project is aimed at calling Jsonplaceholder' API to validate the /Users, /posts and /comments API Request.This is written in a feature file using Cucumber.  
Each line of the scenario is tied to backend code that actually executes the line (step).  

**Example Verify JSON GET Request**
Testing a simple response containing some JSON data.

Request URL: https://jsonplaceholder.typicode.com/users/1
Request Method: GET
Response Content-Type: application/json
Response Body:
*{  
  "id": 1,  
  "name": "Leanne Graham",  
  "username": "Bret",  
  "email": "Sincere@april.biz",  
  "address": {  
    "street": "Kulas Light",  
    "suite": "Apt. 556",  
    "city": "Gwenborough",  
    "zipcode": "92998-3874",  
    "geo": {  
      "lat": "-37.3159",  
      "lng": "81.1496"  
    }  
  },  
  "phone": "1-770-736-8031 x56442",  
  "website": "hildegard.org",  
  "company": {  
    "name": "Romaguera-Crona",  
    "catchPhrase": "Multi-layered client-server neural-net",  
    "bs": "harness real-time e-markets"  
  }  
}*  
Status Code: 200 OK

***Request not found***
Request URL: https://jsonplaceholder.typicode.com/users/25
Request Method: GET
Response Body:
{
  
}
Status Code: 404 Not Found  

**Cucumber HTML Report**
Refer the /target folder for the cucumber html reports

**Postman Collection**
Refer the file Postman Collection.postman_collection.json in the Root Folder project.



