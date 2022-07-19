package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.techpanda.common.Common_Register;

import commons.BaseTest;
import pageObject.user.AccountInformationPageObject;
import pageObject.user.CreateNewAccountPageObject;
import pageObject.user.DashboardPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.PageGeneratorManager;

@Test
public class Level_17_Edit_Information extends BaseTest{
	
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	CreateNewAccountPageObject createNewAccountPage;
	AccountInformationPageObject accountInformationPage;
  
  @Parameters({"Browser", "url"})
  @BeforeClass
  public void beforeClass(String browserName, String url) {
	  driver = getWebBrowser(browserName, url);
	  homePage = PageGeneratorManager.getUserHomePageObject(driver);
	  
	  log.info("Pre-condition - Step 1: Click on My Account Link");
	  loginPage = homePage.clickToMyAccountLink();
	  
	  log.info("Pre-condition - Step 2: Input to Email textbox");
	  loginPage.inputToEmailTextBox(Common_Register.email);
	  
	  log.info("Pre-condition - Step 3: Input to Password textbox");
	  loginPage.inputToPasswordTextBox(Common_Register.password);
	  
	  log.info("Pre-condition - Step 4: Click to Login button");
	  dashboardPage = loginPage.clickToLoginButton();
  }
  	
  	
  	@Test
  	public void TC_08_Edit_Information() {
  		
  		log.info("Edit account Information - Step 1: Open Account information page");
  		accountInformationPage = dashboardPage.openAccountInformation("Account Information");
  		
  		log.info("Edit account Information - Step 2: Edit first name textbox");
  		accountInformationPage.editFirstNameTextBox("Thanh");
  		
  		log.info("Edit account Information - Step 3: Edit last name textbox");
  		accountInformationPage.editLastNameTextBox("Phat");
  		
  		log.info("Edit account Information - Step 4: Input into current password textbox");
  		accountInformationPage.inputToCurrentPasswordTextBox(Common_Register.password);
  		
  		log.info("Edit account Information - Step 5: Click on save button");
  		dashboardPage = accountInformationPage.clickOnSaveButton();
  		
  		log.info("Edit account Information - Step 6: Verify Success message");
  		verifyEquals(dashboardPage.getEditSuccessMessage(), "The account information has been saved.");
  	}

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
