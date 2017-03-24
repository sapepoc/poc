Feature: Wash Trades
	I want to use this template for my feature file

Scenario: Identify wash trades
Given set of trades 
When Wash Trade rule is applied
Then following response is given
	| Type | Client | Security | Volume |
	| Buy  | Sapient| Airtel   | 40     | 
	| Buy  | HCL    | Airtel   | 50     | 
	And Wash trade event is generated