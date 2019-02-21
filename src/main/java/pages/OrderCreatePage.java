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
 *
 */
public class OrderCreatePage extends BaseDriver {
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
	WebElement selectProduct;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
	WebElement quantity;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtUnitPrice")
	WebElement pricePerUnit;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtDiscount")
	WebElement discount;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtTotal")
	WebElement total;
	
	@FindBy(xpath="//input[@value='Calculate']")
	WebElement calButton;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtName")
	WebElement custNumber;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
	WebElement streetAddr;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
	WebElement city;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
	WebElement state;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
	WebElement zipCode;
	
	@FindBy(xpath = "//table[@id='ctl00_MainContent_fmwOrder_cardList']//td/input[@value='Visa']")
	WebElement cardType;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
	WebElement cardNum;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
	WebElement expiryDate;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
	WebElement processBtn;
	
	@FindBy(xpath= "//input[@value='Reset']")
	WebElement resetBtn;
	
	@FindBy(xpath= "//strong[contains(text(),'New order has been successfully added.')]")
	WebElement orderSuccessMsg;
	
	@FindBy(xpath="//li/a[contains(text(),'Order')]")
	WebElement createOrderBtn;
	
	WebDriver _driver;
	TestDataLoader tdLoad = new TestDataLoader();
	
	
	public OrderCreatePage(){
		_driver = initialization();
		PageFactory.initElements(_driver, this);
	}
	
	public void clickCreateButton(){
		createOrderBtn.click();		
	}
	
	
	public void enterProductInfo(){
		selectProduct.sendKeys(tdLoad.searchParameter("ProductInfo", "Product"));
		quantity.sendKeys(tdLoad.searchParameter("ProductInfo", "Quantity"));
		calButton.click();		
	}
	
	public void enterAddrInfo() {
		custNumber.sendKeys(tdLoad.searchParameter("AddressInfo", "CustName"));
		streetAddr.sendKeys(tdLoad.searchParameter("AddressInfo", "Street"));
		state.sendKeys(tdLoad.searchParameter("AddressInfo", "State"));
		city.sendKeys(tdLoad.searchParameter("AddressInfo", "City"));
		zipCode.sendKeys(tdLoad.searchParameter("AddressInfo", "Zip"));			
	}
	
	public void paymentInfo() {
		String cardTypeXPath = "//table[@id='ctl00_MainContent_fmwOrder_cardList']//td/input[@value='" + 
				tdLoad.searchParameter("PaymentInfo", "Card")  +"']";
		_driver.findElement(By.xpath(cardTypeXPath)).click();
		cardNum.sendKeys(tdLoad.searchParameter("PaymentInfo", "CardNo"));
		expiryDate.sendKeys(tdLoad.searchParameter("PaymentInfo", "ExpiryDate"));
		processBtn.click();
	}
	
	public String validateNewOrderCreation() {
		return orderSuccessMsg.getText();		
	}

}
