package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.OrderCreatePage;


/**
 * @author jotba
 * Step Definition class to invoke and perform actions corresponding to CREATE Order Scenario
 */
public class OrderCreationStepDef{
	
	OrderCreatePage orderCreate = new  OrderCreatePage();

	@Given("^User can enter new order details$")
	public void user_begin_order_creation() {
	   orderCreate.clickCreateButton();
	}

	@When("^New order tab is opened$")
	public void user_add_new_order_details() {
	    orderCreate.enterProductInfo();
		orderCreate.enterAddrInfo();
		orderCreate.paymentInfo();
	}

	@Then("^User is able to add required order details$")
	public void new_order_creation_verification(){
	    String title = orderCreate.validateNewOrderCreation();
		Assert.assertEquals(title, "New order has been successfully added.");
	}
	
	
}
