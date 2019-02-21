package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.UpdateOrderPage;
import utilities.TestDataLoader;


/**
 * @author jotba
 * Step Definition class to invoke and perform actions corresponding to Update Order Scenario
 */
public class UpdateOrderStepDef {
	
	UpdateOrderPage updateOrderPage = new UpdateOrderPage();
	TestDataLoader tdLoad = new TestDataLoader();
	
	@Given("^User can edit the details for existing order$")
	public void user_begin_order_modification() {
	    updateOrderPage.listAllOrders();
	}

	@When("^List of all orders is displayed$")
	public void user_update_order_details() {
	    updateOrderPage.editOrderDet();
	    updateOrderPage.updateCardNum();		
	}

	@Then("^User is able to edit order details$")
	public void order_update_verification(){
	   String title = updateOrderPage.verifyUpdatedCardNo();
	   Assert.assertEquals(title, tdLoad.searchParameter("PaymentInfo", "UpdatedCardNo"));		
	}
	

}
