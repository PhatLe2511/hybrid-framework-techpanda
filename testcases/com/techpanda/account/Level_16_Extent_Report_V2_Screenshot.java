package com.techpanda.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObject.user.AccountInformationPageObject;
import pageObject.user.CreateNewAccountPageObject;
import pageObject.user.DashboardPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
//import reportConfig.ExtentTestManager;
import pageObject.user.PageGeneratorManager;

@Test
public class Level_16_Extent_Report_V2_Screenshot extends BaseTest{
	
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
  	public void TC_01_Login_Empty_Data(Method method) {
//  		ExtentTestManager.startTest(method.getName(), "TC_01_Login_Empty_Data");
//  		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 1: Click on My Account Link");
//  		loginPage = homePage.clickToMyAccountLink();
//  		
//  		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 2: Input empty to Email Textbox");
//  		loginPage.inputToEmailTextBox("");
//  		
//  		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 3: Input empty to Password Textbox");
//  		loginPage.inputToPasswordTextBox("");
//  		
//  		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 4: Click on Login button");
//  		loginPage.clickToLoginButton();
//		
//  		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 5: Verify Error message at email textbox when empty");
//  		Assert.assertEquals(loginPage.getRequiredMailErrorMessage(), "This is a required fie");
//  		
//  		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 6: Verify Error message at password textbox when empty");
//  		Assert.assertEquals(loginPage.getRequiredPasswordErrorMessage(), "This is a required fiel");
	}
	
  	@Test
	public void TC_02_Login_With_Invalid_Email(Method method) {
//  		ExtentTestManager.startTest(method.getName(), "TC_02_Login_With_Invalid_Email");
//  		
//  		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 1: Click on My Account Link");
//  		loginPage = homePage.clickToMyAccountLink();
//  		
//  		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 2: Input invalid email to email textbox");
//  		loginPage.inputToEmailTextBox("thanhphat@1241");
//  		
//  		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 3: Input valid password to password textbox");
//  		loginPage.inputToPasswordTextBox("123456");
//  		
//  		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 4: Click on Login button");
//  		loginPage.clickToLoginButton();
//		
//  		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 5: Verify error message when inputting invalid email");
//  		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.co");
	}
  	
  	
  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
