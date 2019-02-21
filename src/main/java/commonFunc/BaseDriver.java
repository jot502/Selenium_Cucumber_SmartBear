package commonFunc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author jotba
 * Constructor Function : Reading the configuration file
 * Initialization Func: To read the browser type and initialize the browser driver
 * Returns: Web Driver
 *
 */
public class BaseDriver {

	public static WebDriver driver;
	public static Properties prop;

	public BaseDriver(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/"
					+ "config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public WebDriver initialization(){
		String browserName = prop.getProperty("browser");
		if(driver == null) {
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("firefox")){
				System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxDriverPath"));	
				driver = new FirefoxDriver(); 
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		return driver;

	}

}