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

public class Level_02_Apply_BasePage_Part_II {
	
	WebDriver driver;
	BasePage basePage;
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
		basePage = BasePage.getBasePageInstance();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();  
  }
  
  	@BeforeMethod
  	public void BeforeMethod() {
  		basePage.openPageUrl(driver, "http://live.techpanda.org");
  	}
  
  
  	@Test
	public void TC_01_Login_Empty_Data() {
  		basePage.clickToElement(driver, "//div[@class='footer-container']//a[text()='My Account']");
  		basePage.sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='email']", "");
  		basePage.sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='password']", "");
  		basePage.clickToElement(driver, "//button[@title='Login']");
		
  		Assert.assertEquals(basePage.getElementText(driver, "//div[@id='advice-required-entry-email']"), "This is a required field.");
		Assert.assertEquals(basePage.getElementText(driver, "//div[@id='advice-required-entry-pass']"), "This is a required field.");
	}
	
	@Test
	public void TC_02_Invalid_Email() {
		
		basePage.clickToElement(driver, "//div[@class='footer-container']//a[text()='My Account']");
  		basePage.sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='email']", "thanhphat@1241");
  		basePage.sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='password']", "123456");
  		basePage.clickToElement(driver, "//button[@title='Login']");
		Assert.assertEquals(basePage.getElementText(driver,"//div[@id='advice-validate-email-email']"), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
	@Test
	public void TC_03_Invalid_Password() {
		
		basePage.clickToElement(driver, "//div[@class='footer-container']//a[text()='My Account']");
  		basePage.sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='email']", "thanhphat@gmail.com");
  		basePage.sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='password']", "123");
  		basePage.clickToElement(driver, "//button[@title='Login']");
		
		Assert.assertEquals(basePage.getElementText(driver,"//div[@id='advice-validate-password-pass']"), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test
	public void TC_04_Incorrect_Email_Password() {
		
		basePage.clickToElement(driver, "//div[@class='footer-container']//a[text()='My Account']");
  		basePage.sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='email']", "thanhphat@gmail.com");
  		basePage.sendKeyToElement(driver, "//div[@class='col-2 registered-users']//input[@type='password']", "123123123123");
  		basePage.clickToElement(driver, "//button[@title='Login']");
		
		Assert.assertEquals(basePage.getElementText(driver, "//li[@class='error-msg']//span"), "Invalid login or password.");
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
