$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/nec/Documents/sachi/Selenium_Code/code/Cucumber Framework/CucumberProject/src/test/resources/com/discovery/videos/Favourites.feature");
formatter.feature({
  "name": "Select videos from recommended videos and",
  "description": "  add to favourites and then validate in my videos",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Favourites"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Entering into DiscoveryGO",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Favourites"
    }
  ]
});
formatter.step({
  "name": "I open \u003cBrowser\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I go to discoveryURL",
  "keyword": "And "
});
formatter.step({
  "name": "I click on discoveryGo_xpath",
  "keyword": "And "
});
formatter.step({
  "name": "Navigation to the DiscoveryGO page should be \u003cResult\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "I scrollFull to recommendedSection_xpath",
  "keyword": "And "
});
formatter.step({
  "name": "I click on firstvideotile_xpath",
  "keyword": "And "
});
formatter.step({
  "name": "I click on addtofavouritesFromPage_xpath",
  "keyword": "And "
});
formatter.step({
  "name": "I navigate back to previous page",
  "keyword": "And "
});
formatter.step({
  "name": "I click on secondvideotile_xpath",
  "keyword": "And "
});
formatter.step({
  "name": "I click on secondaddtofavouritesFromPage_xpath",
  "keyword": "And "
});
formatter.step({
  "name": "I navigate back to previous page",
  "keyword": "And "
});
formatter.step({
  "name": "I click on menu_xpath",
  "keyword": "And "
});
formatter.step({
  "name": "I click on myvideos_xpath",
  "keyword": "And "
});
formatter.step({
  "name": "I scrollHalf to favouritefirstvideo_xpath",
  "keyword": "And "
});
formatter.step({
  "name": "\u003cExpectedVideo1Text\u003e should be visible in myvideos favouritefirstvideo_xpath",
  "keyword": "Then "
});
formatter.step({
  "name": "\u003cExpectedVideo2Text\u003e should be visible in myvideos favouritesecondvideo_xpath",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Browser",
        "Result",
        "ExpectedVideo1Text",
        "ExpectedVideo2Text"
      ]
    },
    {
      "cells": [
        "Chrome",
        "success",
        "Shark Week",
        "Serengeti"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Entering into DiscoveryGO",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Favourites"
    },
    {
      "name": "@Favourites"
    }
  ]
});
formatter.step({
  "name": "I open Chrome",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I go to discoveryURL",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I click on discoveryGo_xpath",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Navigation to the DiscoveryGO page should be success",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I scrollFull to recommendedSection_xpath",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I click on firstvideotile_xpath",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I click on addtofavouritesFromPage_xpath",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I navigate back to previous page",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I click on secondvideotile_xpath",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I click on secondaddtofavouritesFromPage_xpath",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I navigate back to previous page",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I click on menu_xpath",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I click on myvideos_xpath",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I scrollHalf to favouritefirstvideo_xpath",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Shark Week should be visible in myvideos favouritefirstvideo_xpath",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Serengeti should be visible in myvideos favouritesecondvideo_xpath",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});