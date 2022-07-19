package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 	public BaseTest() {
		log = LogFactory.getLog(getClass());
	}

		WebDriver driver;
	 	protected final Log log;
	 	
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
	 	driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
	 	driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
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
	 	driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
	 	driver.manage().window().maximize();
		return driver;
	 }

	 	public WebDriver getDriver() {
	 		return this.driver;
	 	}
	 	
 	 	protected static int getRandomNumber() {
			Random rand = new Random();
			return rand.nextInt(999999);
		}
	 	
	 	protected void sleepInSecond(long second) {
	 		try {
				Thread.sleep(second * 1000);;
			} catch (InterruptedException e) {
			}
	 	}
	
	 	protected boolean verifyTrue(boolean condition) {
	 		boolean status = true;
	 		try {
				Assert.assertTrue(condition);
				log.info("--------------Passed---------------");
			} catch (Throwable e) {
				status = false;
				log.info("--------------Failed---------------");
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
	 		return status;
	 	}
	 	
	 	protected boolean verifyFalse(boolean condition) {
	 		boolean status = true;
	 		try {
				Assert.assertFalse(condition);
				log.info("--------------Passed---------------");
			} catch (Throwable e) {
				status = false;
				log.info("--------------Failed---------------");
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
	 		return status;
	 	}
	 	
	 	protected boolean verifyEquals(Object actual, Object expected) {
			boolean status = true;
			try {
				Assert.assertEquals(actual, expected);
				log.info(" -------------------------- PASSED -------------------------- ");
			} catch (Throwable e) {
				status = false;
				log.info(" -------------------------- FAILED -------------------------- ");
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
			return status;
		}
}	

