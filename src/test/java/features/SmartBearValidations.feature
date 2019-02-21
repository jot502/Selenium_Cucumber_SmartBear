Feature: Validate the SmartBear Web Application
These features verifies the basic functional flow in SmartBear app
 
Scenario: Verify a valid SmartBear app customer can login successfully
Given User can login as valid customer 
When User is on login page
Then User login is successful

Scenario: Verify if Customer is able to place a new order
Given User can enter new order details
When New order tab is opened
Then User is able to add required order details 

Scenario: Verify if Created Order can be updated/modified
Given User can edit the details for existing order
When List of all orders is displayed
Then User is able to edit order details 

Scenario: Verify if existing Order can be deleted
Given User Lists All Order List
When User is able to delete selected order
Then Verify if the Order is deleted

Scenario: Verify if the LogOut function is working
Given User is logged in the app
Then User is able to logout successfully
