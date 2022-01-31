#Author: vr@123@gmal.com

@Transaction
Feature: Transaction Validation

  Scenario: I want to add balance in pool account using transaction api
  Given create Transaction payload with <toAccountId>,<productId>,<amount>
  When I run "AddTransactionAPI" with post http request
  Then statusCode should be "SUCCESS"

  Examples: 
  | toAccountId     | productId  | amount |
  |     12498       |   12495    | 28000  |
   		
   		
   Scenario: I want to create transation from Pool to loan account and vice versa
    Given create Transaction payload with <fromAccountId>, <toAccountId>, <productId> , <amount>
    When I run "AddTransactionAPI" with post http request
    Then statusCode should be "SUCCESS"
    And fetch balance using "GetBalanceAPI" 
    And fetch ledger details using "GetLedgerAPI"

    Examples: 
      |fromAccountId| toAccountId     | productId  | amount     |
   		|    12498    |     12499       |   12495    | 45		      |
			|		 12499		|			12498				|		12495		 | 44			    |
			
			
	
