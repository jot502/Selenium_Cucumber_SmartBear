package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DeleteOrderPage;
import utilities.TestDataLoader;


/**
 * @author jotba
 * Step Definition class to invoke and perform actions corresponding to DELETE Order Scenario
 *
 */
public class DeleteOrderStepDef {
	
	DeleteOrderPage deleteOrderPage = new DeleteOrderPage();
	TestDataLoader tdLoad = new TestDataLoader();
	
	@Given("^User Lists All Order List$")
	public void user_begin_order_deletion() {
		deleteOrderPage.listAllOrders();
	}

	@When("^User is able to delete selected order$")
	public void user_select_order_delete() {
		deleteOrderPage.selectOrderToBeDeleted();		
	}

	@Then("^Verify if the Order is deleted$")
	public void order_delete_verification(){
	   boolean orderFoundStatus = deleteOrderPage.verifyDeletedOrder();
	   Assert.assertFalse(orderFoundStatus);
	}	

}
