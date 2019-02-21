package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.LogOutPage;
import utilities.TestDataLoader;


/**
 * @author jotba
 * Step Definition class to invoke and perform actions corresponding to LOGOUT Order Scenario
 */
public class LogOutStepDef {
	
	LogOutPage logOutPage = new LogOutPage();
	TestDataLoader tdLoad = new TestDataLoader();
	
	@Given("^User is logged in the app$")
	public void check_user_is_already_loggedIn() {
		Assert.assertTrue(logOutPage.checkIFLoggedIn());
	}

	@Then("^User is able to logout successfully$")
	public void user_is_able_logout() {
		logOutPage.logOut();  
	}

}
