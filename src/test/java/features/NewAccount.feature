#Author: vr@123@gmal.com

@Account
Feature: Pool and Loan Account creation
  I want to create pool account for respective product

  Scenario Outline: Pool and Loan Account creation 
    Given add account payload with <productId>,"<accountType>","<accountNumber>"
    When I hit "AddAccountAPI" with post http request
    Then account should generated with statusCode "SUCCESS"
    And message should displayed as "Account has been successfully saved."

    Examples: 
      | productId  |accountType | accountNumber  |
      | 12580 		 |LOAN        | LA26112021         |
      | 12580			 |POOL				| PA2622021         |


	Scenario Outline: Get All Account Details  
		Given get accounts url with <productId>,"<productName>"
    When I ran "GetAccountsAPI" with post http method
    Then accounts should generated with status Code 200
    
    Examples: 
      | productId  | productName |
      | 12580 		 | Hello000    |
     
     
  Scenario: Account creation,updation and get updated details
  
  Given add account payload with <productId>,"<accountType>","<accountNumber>"
    When I hit "AddAccountAPI" with post http request
    Then account should generated with statusCode "SUCCESS"
    And update status of account as "INACTIVE" with Post method using "UpdateAccountAPI"
    And get productname using "GetProductAPI"
    And same status maps to "status" using "GetAccountAPI"
  	
  	
  Examples:
	|productId| accountType  | accountNumber|
	|12580    | loan         | A26112021    |
  
