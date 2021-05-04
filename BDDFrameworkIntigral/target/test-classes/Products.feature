@product
Feature: Product scenarios

  Scenario: Validate single cart addition and notification badge
    Given I'm logged in
    Then I validate single cart addition
    Then I validate notification badge

  Scenario: Validate single cart removal
    Then I validate single cart removal

  Scenario Outline: Validate product info on Products page
    Then the product is listed with title "<title>" and price "<price>"

    Examples: 
      | title             | price |
      | Sauce Labs Onesie | $7.99 |

  Scenario Outline: Validate product info on Product Details page
    When I click product title "<title>"
    Then I should be on product details page with title "<title>", price "<price>" and description "<description>"

    Examples: 
      | title               | price  | description                                                                                                                            |
      | Sauce Labs Backpack | $29.99 | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection. |
