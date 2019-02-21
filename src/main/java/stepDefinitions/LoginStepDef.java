package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;


/**
 * @author jotba
 * Step Definition class to invoke and perform actions corresponding to LOGIN Order Scenario
 */
public class LoginStepDef {
	
	
	LoginPage loginPage = new LoginPage();	
	
	@Given("^User can login as valid customer$")
	public void user_is_valid_customer_with_SmartBear_app() {
	    loginPage.setCredentials();
	}

	@When("^User is on login page$")
	public void user_login_app() {
	    loginPage.login();  
	}

	@Then("^User login is successful$")
	public void user_able_to_login_successfully(){
	    String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Web Orders");
	}

	
}
