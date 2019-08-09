$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Whizdom-Trainings/Online Training Workspace/Recording_Dec17/CucumberProject/src/test/resources/com/qtpselenium/rediff/Login.feature");
formatter.feature({
  "name": "Logging into Rediff Money",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Logging into Rediff",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.step({
  "name": "I open \u003cBrowser\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I go to loginURL",
  "keyword": "And "
});
formatter.step({
  "name": "I Login inside application",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "ashishthakur1983",
        "pass@1234"
      ]
    }
  ]
});
formatter.step({
  "name": "Login should be \u003cResult\u003e",
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
        "Result"
      ]
    },
    {
      "cells": [
        "Mozilla",
        "success"
      ]
    },
    {
      "cells": [
        "Chrome",
        "success"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Logging into Rediff",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open Chrome",
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
formatter.step({
  "name": "Login should be success",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.validateLogin(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});