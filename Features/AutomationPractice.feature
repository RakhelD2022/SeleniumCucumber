Feature: Login

  Scenario: Select the highest price item and add it to the cart
    Given User Launch Chrome Browser
    And Opens URL "http://automationpractice.com/index.php"
    And clicks on the Dresses Menu
    Then User selects the highest priced item
    And Verify that product is added to the cart and close the window