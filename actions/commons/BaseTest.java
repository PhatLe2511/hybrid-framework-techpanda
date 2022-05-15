package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	public WebDriver getWebBrowser(String browserName) {
		
		switch (browserName) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "/BrowserDrivers/geckodriver");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "/BrowserDrivers/chromedriver");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "/BrowserDrivers/msedgedriver");
			driver = new EdgeDriver();
			break;

		default:
			throw new RuntimeException("Browser name is invalid");
		}
		

		driver.manage().window().maximize();  
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/");
		
		return driver;
	}
	
}
