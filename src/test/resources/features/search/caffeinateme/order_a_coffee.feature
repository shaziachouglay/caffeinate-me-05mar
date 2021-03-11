Feature: Order a coffee

  In order to save time when i pick up my morning coffee
  As a coffee lover
  I want to be able to order my coffee in advance

  Scenario: Buyer orders a coffee when they are close to the coffee shop
    Given Cathy is 100 meters from the coffee shop
    When Cathy orders a large capuccino
    Then Barry should recieve the order
    And Barry should know that the order is Urgent
