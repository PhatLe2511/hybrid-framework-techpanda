package com.techpanda.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_2_Apply_BasePage_Part_III extends BasePage{
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
  
  @BeforeClass
  public void beforeClass() {
	  if(osName.toUpperCase().startsWith("MAC")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/BrowserDrivers/geckodriver");
			System.setProperty("webdriver.chrome.driver", projectPath + "/BrowserDrivers/chromedriver");
		}else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDrivers\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDrivers\\chromedriver.exe");
		}
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();  
  }
  
  	@BeforeMethod
  	public void BeforeMethod() {
  		openPageUrl(driver, "http://live.techpanda.org");
  	}
  
  
  	@Test
	public void TC_01_Login_Empty_Data() {
  		clickToElement(driver, "//div[@class='footer-container']//a[text()='My Account']");
  		sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='email']", "");
  		sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='password']", "");
  		clickToElement(driver, "//button[@title='Login']");
		
  		Assert.assertEquals(getElementText(driver, "//div[@id='advice-required-entry-email']"), "This is a required field.");
		Assert.assertEquals(getElementText(driver, "//div[@id='advice-required-entry-pass']"), "This is a required field.");
	}
	
	@Test
	public void TC_02_Invalid_Email() {
		
		clickToElement(driver, "//div[@class='footer-container']//a[text()='My Account']");
  		sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='email']", "thanhphat@1241");
  		sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='password']", "123456");
  		clickToElement(driver, "//button[@title='Login']");
		Assert.assertEquals(getElementText(driver,"//div[@id='advice-validate-email-email']"), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
	@Test
	public void TC_03_Invalid_Password() {
		
		clickToElement(driver, "//div[@class='footer-container']//a[text()='My Account']");
  		sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='email']", "thanhphat@gmail.com");
  		sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='password']", "123");
  		clickToElement(driver, "//button[@title='Login']");
		
		Assert.assertEquals(getElementText(driver,"//div[@id='advice-validate-password-pass']"), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test
	public void TC_04_Incorrect_Email_Password() {
		
		clickToElement(driver, "//div[@class='footer-container']//a[text()='My Account']");
  		sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='email']", "thanhphat@gmail.com");
  		sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='password']", "123123123123");
  		clickToElement(driver, "//button[@title='Login']");
		
		Assert.assertEquals(getElementText(driver, "//li[@class='error-msg']//span"), "Invalid login or password.");
	}
  
  
  
  
  
  public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}
  

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
