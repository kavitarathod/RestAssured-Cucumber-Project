
Feature: Create a Comment to the Existing Post using /comments endpoint

	@CommentFeature
  Scenario Outline: Test the Comment Feature.
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"
    Then Verify the Response Time of the Request API
    And I try to verify the response value "postId" is "1"
    And I try to verify the response value "name" is "Test User 1"
    And I try to verify the response value "email" is "xyz@xyz.com"
    And I try to verify the response value "body" is "new Comment #1"

    Examples: 
      | TestName                        | URL       | ContentType      | RequestBody                   | RequestMethod | StatusCode |
      | Make a new Comment to Post ID 1 | /comments | application/json | com/testData/testComment.json | POST          |        201 |

	@CommentFeature
  Scenario Outline: Test the Comment Feature.
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"
    Then Verify the Response Time of the Request API
    And I try to verify the response value "postId" is "2"
    And I try to verify the response value "name" is "Test User 2"
    And I try to verify the response value "email" is "abc@abc.com"
    And I try to verify the response value "body" is "new Comment #2"

    Examples: 
      | TestName                        | URL      | ContentType      | RequestBody                    | RequestMethod | StatusCode |
      | Make a new Comment to Post ID 2 | /comments| application/json | com/testData/testComment2.json | POST          |        201 |
      
 