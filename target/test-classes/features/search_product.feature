Feature: Search
 As a user I want to search and place the order 

@OffersPage
  Scenario Outline: User search for products in home page and in Top deals page
    Given User navigate to Green Cart Landing Page
    When User enter <Name> on search field
    And Extract actual name of the product
    And  User navigate to Top deals page
    And User enter <Name> on Top deals page search field and extract name of the product
    Then User validate the name of the product
  
Examples:

|Name|
|tom|
|beet|
