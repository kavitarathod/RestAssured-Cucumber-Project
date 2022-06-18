
Feature: Create a new Post using /posts endpoint
	@PostFeature
  Scenario Outline: Make a new post
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"
    Then Verify the Response Time of the Request API
    And I try to verify the response value "userId" is "1"
    And I try to verify the response value "title" is "new post"
    And I try to verify the response value "body" is "new post"

    Examples: 
      | TestName         | URL    | ContentType      | RequestBody            		| RequestMethod | StatusCode |
      | Make a new Post 1| /posts | application/json | com/testData/testPost.json | POST          |        201 |
      
	@PostFeature
  Scenario Outline: Make a new Post
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"
    Then Verify the Response Time of the Request API
    And I try to verify the response value "userId" is "25"
    And I try to verify the response value "title" is "new post"
    And I try to verify the response value "body" is "new post"

    Examples: 
      | TestName          | URL     | ContentType      | RequestBody             		 | RequestMethod | StatusCode |
      | Make a new Post 2 | /posts  | application/json | com/testData/testPost2.json | POST          |        201 |
      
