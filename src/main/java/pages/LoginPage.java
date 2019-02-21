package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonFunc.BaseDriver;
import utilities.TestDataLoader;

/**
 * @author jotba
 *Contains LoginPage objects and respective actions
 */
public class LoginPage extends BaseDriver{
	
	@FindBy(id ="ctl00_MainContent_username")
	@CacheLookup
	WebElement username;
	
	@FindBy(id="ctl00_MainContent_password")
	WebElement password;
	
	@FindBy(id="ctl00_MainContent_login_button")
	WebElement loginBtn;
	
	String _uName = null;
	String _passWord = null;
	WebDriver _driver;
	TestDataLoader tdLoad = new TestDataLoader();
	
	public LoginPage(){
		_driver = initialization();
		PageFactory.initElements(_driver, this);
	}
	
	public String validateLoginPageTitle(){
		return _driver.getTitle();
		
	}
	
	public void setCredentials() {
		_uName =  tdLoad.searchParameter("ApplicationDetails", "UserName");
		_passWord = tdLoad.searchParameter("ApplicationDetails", "Password");
		
	}
	
	public void login(){
		_driver.get(tdLoad.searchParameter("ApplicationDetails", "AppURL"));
		username.sendKeys(_uName);
		password.sendKeys(_passWord);
		loginBtn.click();
	}
	

}
