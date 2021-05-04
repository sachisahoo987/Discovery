@addtocart
Feature: Add products to cart

  Scenario: Validate checkout process positive flow
    Given I'm logged in
    Then I validate single cart addition
    And I click on cart
    And I click on checkout
    And I continue to final page
    And I click on finish to finish the order checkout
    And I validate if order checkout is sucess
    And I Navigate back to homepage
    
    Scenario: Validate checkout process cancellation flow
    Then I validate single cart addition
    And I click on cart
    And I click on checkout
    And I continue to final page
    And I click on cancel on final page and validate if order got cancelled