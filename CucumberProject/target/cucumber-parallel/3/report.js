$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Whizdom-Trainings/Online Training Workspace/Recording_Dec17/CucumberProject/src/test/resources/com/qtpselenium/rediff/Portfolio.feature");
formatter.feature({
  "name": "Title of your feature",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Portfolio"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open Mozilla",
  "keyword": "Given "
});
formatter.match({
  "location": "GenericSteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I go to loginURL",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.navigate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I Login inside application",
  "rows": [
    {
      "cells": [
        "ashishthakur1983",
        "pass@1234"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.login(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating a Portfolio",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Portfolio"
    },
    {
      "name": "@CreatePortFolio"
    }
  ]
});
formatter.step({
  "name": "I click createPortFolio_id and wait for portfolioName_id",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.clickAndWait(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I clear portfolioName_id",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.clear(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I type Port12345 in portfolioName_id field",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.type(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on portFolioSubmit_id",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});