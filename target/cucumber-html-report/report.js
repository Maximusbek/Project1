$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Google.feature");
formatter.feature({
  "name": "Google Home Page",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search from google",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to Google",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.GoogleSteps.user_navigates_to_Google()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/amazon.feature");
formatter.feature({
  "name": "Amazon automation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Amazon Home Page",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to Amazon Home page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.AmazonSteps.user_navigates_to_Amazon_Home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});