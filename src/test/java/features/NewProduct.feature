#Author: vr@123@gmal.com

@Product
Feature: ProductAPI's validation
  I want to use this template for my feature file
      
  Scenario: Get All Product Details  
  When I hit "GetProductsAPI" http request with Get method
  Then the "statusCode" in response give "SUCCESS"
  
  
  
  Scenario Outline: Create,update product, product config and get product details
  
   Given Add product payload with "<productName>" "<status>" "<description>"
    When I hit "AddProductAPI" http request with POST method
    Then the API give Success
    And update status of product as Inactive with Post method using "UpdateProductAPI"
    And update configuration of product with Post method using "UpdateProductConfigAPI"
  	And same productName maps to productName using "GetProductAPI"
  	
  	
  Examples:
	|productName| status  | description       |
	|Nov26112021  | Active  | new productnewyr  |
  	
  	
  	
  	
  	
  	
  	
  

