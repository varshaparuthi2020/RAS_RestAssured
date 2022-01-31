Feature: Validating Product API's

#Scenario: Verify if product is added successfully or not
#Given Add product payload
#When user calls "AddprodcutAPI" with Post http request
#Then the API got success with status code 200
#And "statusCode" in response body is "SUCCESS"
#And "message" in response body is "Product has been saved successfully"


# Below testcase is using datadriven approach

#Scenario Outline: Verify if product is added successfully or not
#Given Add product payload with "<productName>" "<status>" "<description>"
#When user calls "AddProductAPI" with "POST" http request
#Then the API got success with status code 200
#And "statusCode" in response body is "SUCCESS"
#And "message" in response body is "Product has been saved successfully"
#
#
#Examples:
#	|productName| status  | description       |
#	|newpod001  | Active  | new product yeeeee|
#	|newpod002  | InActive| another product   |

	
#Scenario:Get all Product Details

#Given get product api
#When usr calls Get Api with Get http request
#Then thh API got succcess with status code 200