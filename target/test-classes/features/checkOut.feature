Feature: Order
 Place the order for products

@PlaceOrder
  Scenario Outline: User search for products in home page and place order 
    Given User navigate to Green Cart Landing Page
    When User enter <Name> on search field
    And Add <Num> Items of the selected product to cart
    And User checkout the order 
    Then User validate the name of the product
    And Verify user has ability to enter promo code and place the order 
    And User place the order
  
Examples:

|Name||Num|
|tom||3|

