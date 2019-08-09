#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Favourites
Feature: Select videos from recommended videos and
  add to favourites and then validate in my videos

  @Favourites
  Scenario Outline: Entering into DiscoveryGO
    Given I open <Browser>
    And I go to discoveryURL
    And I click on discoveryGo_xpath
    Then Navigation to the DiscoveryGO page should be <Result>
    And I scrollFull to recommendedSection_xpath
    And I click on firstvideotile_xpath
    And I click on addtofavouritesFromPage_xpath
    And I navigate back to previous page
    And I click on secondvideotile_xpath
    And I click on secondaddtofavouritesFromPage_xpath
    And I navigate back to previous page
    And I click on menu_xpath
    And I click on myvideos_xpath
    And I scrollHalf to favouritefirstvideo_xpath
    Then <ExpectedVideo1Text> should be visible in myvideos favouritefirstvideo_xpath
    Then <ExpectedVideo2Text> should be visible in myvideos favouritesecondvideo_xpath

    Examples: 
      | Browser | Result  | ExpectedVideo1Text | ExpectedVideo2Text |
      | Chrome  | success | Shark Week         | Serengeti          |
