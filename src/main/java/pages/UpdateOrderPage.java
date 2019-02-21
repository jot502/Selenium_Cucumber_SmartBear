package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonFunc.BaseDriver;
import utilities.TestDataLoader;


/**
 * @author jotba
 * Contains UpdateOrder Page Objects and respective actions
 */
public class UpdateOrderPage extends BaseDriver{
	
	WebDriver _driver;
	TestDataLoader tdLoad = new TestDataLoader();
	
	@FindBy(xpath="//li/a[contains(text(),'View all orders')]")
	WebElement viewAllOrderBtn;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
	WebElement cardNum;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_UpdateButton")
	WebElement updateBtn;
	
	
	
	public UpdateOrderPage(){
		_driver = initialization();
		PageFactory.initElements(_driver, this);
	}
	
	public void listAllOrders(){
		viewAllOrderBtn.click();		
	}
	
	
	// Made runtime Xpath using TestData values.
	// This can be implemented in Different package file for enterprise level frameworks
	// Used here for simplification and easy of usage.
	public void editOrderDet() {		
		String orderSelectXpath = "//table[@id='ctl00_MainContent_orderGrid']//td[text()='" + tdLoad.searchParameter("AddressInfo", "CustName")
		+"']//parent::tr/td";
		String editBtnXpath = "//table[@id='ctl00_MainContent_orderGrid']//td[text()='" + tdLoad.searchParameter("AddressInfo", "CustName")
				+"']//parent::tr//td/input[@alt='Edit']";
		_driver.findElement(By.xpath(orderSelectXpath)).click();
		_driver.findElement(By.xpath(editBtnXpath)).click();
	}
	
	
	public void updateCardNum() {
		cardNum.clear();
		cardNum.sendKeys(tdLoad.searchParameter("PaymentInfo", "UpdatedCardNo"));
		updateBtn.click();
	}
	
	public String verifyUpdatedCardNo() {
		editOrderDet();
		return cardNum.getAttribute("value");
		
	}
	
	

}
