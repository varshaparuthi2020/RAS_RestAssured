#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)

Feature: Validate End to end product API case
Scenario Outline: Verify if product is added and fetched successfully or not
Given Add product payload with "<productName>" "<status>" "<description>"
When user calls "AddProductAPI" with "POST" http request
Then the API got success with status code 200
Then "statusCode" in response body is "SUCCESS"
And "message" in response body is "Product has been saved successfully"
And verify productName created maps to "<productName>" using "GetProductAPI"

Examples:
	|productName| status  | description       |
	|nwedv88    | Active  | new productnewyr  |
	#|newpd002  | InActive| another product   |
	

