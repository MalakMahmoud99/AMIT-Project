@test
Feature:Ensure that the user can sign up without errors.
  Scenario:Verify that User Can Sign Up Successfully
    When Click on the Sign up button
    And Fill in the username
    And password in the signup form
    And Click on Sign Up
    Then  A success message should be displayed: "Sign up successful"

    Scenario: Verify that user can't sign up with existing data
      When Click on the Sign up button
      And Fill in the username
      And password in the signup form
      And Click on Sign Up
      Then an error message appears

