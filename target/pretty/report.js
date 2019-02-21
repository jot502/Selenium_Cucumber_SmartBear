$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/SmartBearValidations.feature");
formatter.feature({
  "line": 1,
  "name": "Verify Login SmartBear Web Application",
  "description": "This feature verifies the basic login function in SmartBear app",
  "id": "verify-login-smartbear-web-application",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Verify a valid SmartBear app customer can login successfully",
  "description": "",
  "id": "verify-login-smartbear-web-application;verify-a-valid-smartbear-app-customer-can-login-successfully",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I login as valid customer",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I launch the SmartBear app",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I am able to do login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.i_am_a_valid_customer_with_SmartBear_app()"
});
formatter.result({
  "duration": 8809721577,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDef.i_login_to_application()"
});
formatter.result({
  "duration": 4537913545,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDef.i_am_able_to_login_successfully()"
});
formatter.result({
  "duration": 12134252,
  "status": "passed"
});
});