package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 	WebDriver driver;
	 	String projectPath = System.getProperty("user.dir");
	 	
	 	
	 	protected WebDriver getWebBrowser(String broswerName) {
	 		BrowserList broswerList = BrowserList.valueOf(broswerName.toUpperCase());
	 	
	 	switch (broswerList) {
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;
		case FIREFOX:
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new IllegalArgumentException("Browser name is invalid");
		}
	 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 	driver.manage().window().maximize();
		return driver;
	 }
	 	
	 	
	 	protected WebDriver getWebBrowser(String broswerName, String urlValue) {
	 		BrowserList broswerList = BrowserList.valueOf(broswerName.toUpperCase());
	 	
	 	switch (broswerList) {
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;
		case FIREFOX:
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new IllegalArgumentException("Browser name is invalid");
		}
	 	driver.get(urlValue);
	 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 	driver.manage().window().maximize();
		return driver;
	 }
	 	
	 	protected int getRandomNumber() {
			Random rand = new Random();
			return rand.nextInt(999999);
		}
	 	
	 	protected void sleepInSecond(long second) {
	 		try {
				Thread.sleep(second * 1000);;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	}
	}	

