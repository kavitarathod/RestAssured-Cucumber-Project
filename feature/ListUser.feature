
Feature: Validate the Get Users API  
		
		@GetUser
    Scenario Outline: Validate the /users endpoint using a valid user ID
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"
    Then Verify the Response Time of the Request API
    And content type should be in "JSON" format
    And I try to verify the response value "name" is "Leanne Graham"
    And I try to verify the response value "phone" is "1-770-736-8031 x56442"
    And I try to verify the response value "id" is "1"

    Examples: 
      | TestName        | URL        | ContentType      | RequestBody | RequestMethod | StatusCode |
      | Valid User Test | /users/1   | application/json |             | GET           |        200 |
      
   	@GetUser
    Scenario Outline: Validate the /users endpoint using a valid username parameter
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"
    Then Verify the Response Time of the Request API
    
    Examples: 
      | TestName        | URL                          | ContentType      | RequestBody | RequestMethod | StatusCode |
      | Valid User Test | /users?username=Antonette    | application/json |             | GET           |        200 |

  	@GetUser
  	Scenario Outline: Validate the /users endpoint using a Invalid user ID
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"
    Then Verify the Response Time of the Request API
    
    Examples: 
      | TestName          | URL       | ContentType      | RequestBody  | RequestMethod | StatusCode |
      | Invalid User Test | /users/25 | application/json |              | GET            |       404 |
    