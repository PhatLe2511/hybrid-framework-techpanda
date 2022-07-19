package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.admin.AdminHomePageObject;
import pageObject.admin.AdminLoginPageObject;
import pageObject.user.DashboardPageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.PageGeneratorManager;
import pageObject.user.UserHomePageObject;

public class Level_10_Global_Contants extends BaseTest{
	
	WebDriver driver;
	AdminHomePageObject adminHomePage;
	AdminLoginPageObject adminLoginPage;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	DashboardPageObject dashboardPage;
	
	String userUrl, adminUrl;
	
  @Parameters({"Browser"})
  @BeforeClass
  public void beforeClass(String browserName) {
	  this.userUrl = GlobalConstants.LIVE_USER_URL;
	  this.adminUrl = GlobalConstants.LIVE_ADMIN_URL;
	  
	  driver = getWebBrowser(browserName, this.userUrl);
	  userHomePage = PageGeneratorManager.getUserHomePageObject(driver);
  }
  
  @Test
  public void TC_01_Switch_Roles() {
	  	userLoginPage = userHomePage.clickToMyAccountLink();
		userLoginPage.inputToEmailTextBox(GlobalConstants.USER_USERNAME);
		userLoginPage.inputToPasswordTextBox(GlobalConstants.USER_PASSWORD);
		dashboardPage = userLoginPage.clickToLoginButton();
		
		dashboardPage.clickOnAccountButton();
		
		userHomePage = dashboardPage.clickOnLogOutButton(driver);
	  
		adminLoginPage = userHomePage.openAdminLoginPage(driver, GlobalConstants.LIVE_ADMIN_URL);
		  
		adminLoginPage.inputToUserNameTextBox(GlobalConstants.ADMIN_USERNAME);
		  
		adminLoginPage.inputToPasswordTextBox(GlobalConstants.ADMIN_PASSWORD);
		  
		adminHomePage = adminLoginPage.clickOnLoginButton();
		  
		adminHomePage.clickOnCloseButtonOnPopup();
		  
		adminLoginPage = adminHomePage.clickLogOutButton(driver);
		  
		userHomePage = adminLoginPage.openUserHomePage(driver, GlobalConstants.LIVE_USER_URL);
		  
		userLoginPage = userHomePage.clickToMyAccountLink();
		userLoginPage.inputToEmailTextBox(GlobalConstants.USER_USERNAME);
		userLoginPage.inputToPasswordTextBox(GlobalConstants.USER_PASSWORD);
		dashboardPage = userLoginPage.clickToLoginButton();
} 
  

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
