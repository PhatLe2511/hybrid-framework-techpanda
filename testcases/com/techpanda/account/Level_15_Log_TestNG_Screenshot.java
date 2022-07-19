package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.user.AccountInformationPageObject;
import pageObject.user.CreateNewAccountPageObject;
import pageObject.user.DashboardPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.PageGeneratorManager;

@Test
public class Level_15_Log_TestNG_Screenshot extends BaseTest{
	
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	CreateNewAccountPageObject createNewAccountPage;
	AccountInformationPageObject accountInformationPage;
	String firstName = "Le";
	String lastName = "Phat";
	String fullName = firstName + " " + lastName;
	String email = "thanhphat" + getRandomNumber() + "@gmail.com";
  
  @Parameters({"Browser", "url"})
  @BeforeClass
  public void beforeClass(String browserName, String url) {
	  driver = getWebBrowser(browserName, url);
	  homePage = PageGeneratorManager.getUserHomePageObject(driver);
  }
  

  
  	@Test
  	public void TC_01_Login_Empty_Data() {
  		log.info("Login - Step 1: Click on My Account Link");
  		loginPage = homePage.clickToMyAccountLink();
  		
  		log.info("Login - Step 2: Input empty to Email Textbox");
  		loginPage.inputToEmailTextBox("");
  		
  		log.info("Login - Step 3: Input empty to Password Textbox");
  		loginPage.inputToPasswordTextBox("");
  		
  		log.info("Login - Step 4: Click on Login button");
  		loginPage.clickToLoginButton();
		
  		log.info("Login - Step 5: Verify Error message at email textbox when empty");
  		Assert.assertEquals(loginPage.getRequiredMailErrorMessage(), "This is a required fie");
  		
  		log.info("Login - Step 6: Verify Error message at password textbox when empty");
  		Assert.assertEquals(loginPage.getRequiredPasswordErrorMessage(), "This is a required fiel");
	}
	
  	@Test
	public void TC_02_Login_With_Invalid_Email() {
  		log.info("Login - Step 1: Click on My Account Link");
  		loginPage = homePage.clickToMyAccountLink();
  		
  		log.info("Login - Step 2: Input invalid email to email textbox");
  		loginPage.inputToEmailTextBox("thanhphat@1241");
  		
  		log.info("Login - Step 3: Input valid password to password textbox");
  		loginPage.inputToPasswordTextBox("123456");
  		
  		log.info("Login - Step 4: Click on Login button");
  		loginPage.clickToLoginButton();
		
  		log.info("Login - Step 5: Verify error message when inputting invalid email");
  		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.co");
	}
  	
  	
  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
