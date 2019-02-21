package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonFunc.BaseDriver;
import utilities.TestDataLoader;

/**
 * @author jotba
 * Contains LogOutPage objects and respective actions
 */
 
public class LogOutPage extends BaseDriver {
	
	
	@FindBy(id="ctl00_logout")
	WebElement logOutBtn;
	
	WebDriver _driver;
	TestDataLoader tdLoad = new TestDataLoader();
	
	public LogOutPage(){
		_driver = initialization();
		PageFactory.initElements(_driver, this);
	}
	
	public boolean checkIFLoggedIn() {
		if(_driver.getTitle().equals("Web Orders"))
			return true;
		else
			return false;
	}
	
	public void logOut(){
		logOutBtn.click();
		_driver.quit();
		
	}

}
