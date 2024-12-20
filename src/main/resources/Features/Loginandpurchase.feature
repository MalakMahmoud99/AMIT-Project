@test
Feature: Verify that Two Products Are Purchased Successfully
  Scenario: user can login and purchase
    When user click on login
    And enter his name
    And enter his password
    And click on login
    Then Login done successfully

    When Click on Laptops under categories on the homepage
     And Choose Product 1
     And Click on the Add to Cart button
    Then Product 1 is added to the cart with confirmation

    When back to laptops page
    And Choose Product2
    And Click on the Add to Cart button
    Then Product 2 is added to the cart with confirmation

    When click on the cart
    Then Both products are visible in the cart, with their respective titles and prices

    Then The total amount is calculated correctly based on the prices of both products

    When Click on the Place order button
    And Verify that the total amount is calculated correctly on the placeholder page
    And Fill in Name
    And Country
    And City
    And Credit Card Number
    And Month and year
    And Click on the Purchase button
    Then A success message should be displayed: "Thank you for your purchase!"

  Scenario: user can't use an expired credit card
    When user click on login
    And enter his name
    And enter his password
    And click on login
    Then Login done successfully

    When Click on Laptops under categories on the homepage
    And Choose Product 1
    And Click on the Add to Cart button
    Then Product 1 is added to the cart with confirmation

    When back to laptops page
    And Choose Product2
    And Click on the Add to Cart button
    Then Product 2 is added to the cart with confirmation

    When click on the cart
    Then Both products are visible in the cart, with their respective titles and prices

    Then The total amount is calculated correctly based on the prices of both products
    When Click on the Place order button
    And Verify that the total amount is calculated correctly on the placeholder page
    And Fill in Name
    And Country
    And City
    And Credit Card Number
    And invalid Month and year
    And Click on the Purchase button
    Then an error message about credit appears


    Scenario: user can't login using invalid credentials
      When user click on login
      And enter invalid name
      And enter his password
      And click on login
      Then an error msg appears


