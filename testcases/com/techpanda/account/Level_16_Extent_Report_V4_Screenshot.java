package com.techpanda.account;

import java.lang.reflect.Method;

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
public class Level_16_Extent_Report_V4_Screenshot extends BaseTest{
	
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
  		
  		
  		loginPage = homePage.clickToMyAccountLink();
  		
  	
  		loginPage.inputToEmailTextBox("");
  		
  		
  		loginPage.inputToPasswordTextBox("");
  		
  		
  		loginPage.clickToLoginButton();
		
  		
  		Assert.assertEquals(loginPage.getRequiredMailErrorMessage(), "This is a required fie");
  		
  		
  		Assert.assertEquals(loginPage.getRequiredPasswordErrorMessage(), "This is a required fiel");
	}
	
  	@Test
	public void TC_02_Login_With_Invalid_Email(Method method) {
  		
  		
  		loginPage = homePage.clickToMyAccountLink();
  		
  		
  		loginPage.inputToEmailTextBox("thanhphat@1241");
  		
  		
  		loginPage.inputToPasswordTextBox("123456");
  		
  		
  		loginPage.clickToLoginButton();
		
  		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.co");
	}
  	
  	
  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
