package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonFunc.BaseDriver;
import utilities.TestDataLoader;

/**
 * @author jotba
 * Contains DeleteOrderPage objects and respective actions
 *
 */
public class DeleteOrderPage extends BaseDriver {
	
	//Initiating references
	WebDriver _driver;
	TestDataLoader tdLoad = new TestDataLoader();
	String orderSelectChkBoxXPath="";
	
	//Respective Page Objects
	@FindBy(xpath="//li/a[contains(text(),'View all orders')]")
	WebElement viewAllOrderBtn;
	
	@FindBy(id="ctl00_MainContent_btnDelete")
	WebElement deleteBtn;
		
	
	public DeleteOrderPage(){
		_driver = initialization();
		PageFactory.initElements(_driver, this);
	}
	
	public void listAllOrders(){
		viewAllOrderBtn.click();		
	}
	
	public void selectOrderToBeDeleted() {
		orderSelectChkBoxXPath = "//table[@id='ctl00_MainContent_orderGrid']//td[text()='" + tdLoad.searchParameter("AddressInfo", "CustName") 
				+"']//parent::tr/td";
		_driver.findElement(By.xpath(orderSelectChkBoxXPath)).click();
		deleteBtn.click();
	}
	
	//Function to verify if order is deleted, we can move this logic to generic utilities
	//Have used this for highlighting purpose, as this is not recommended way for Exceptional handling
	public boolean verifyDeletedOrder() {
		try{
			_driver.findElement(By.xpath(orderSelectChkBoxXPath)).isDisplayed();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
		
	}

}
