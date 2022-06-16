package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.admin.AdminHomePageObject;
import pageObject.admin.AdminLoginPageObject;
import pageObject.user.DashboardPageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.PageGeneratorManager;
import pageObject.user.UserHomePageObject;

public class Level_08_Switch_Role extends BaseTest{
	
	WebDriver driver;
	AdminHomePageObject adminHomePage;
	AdminLoginPageObject adminLoginPage;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	DashboardPageObject dashboardPage;
	
	String userUrl, adminUrl;
	
  @Parameters({ "Browser", "userUrl" , "adminUrl" })
  @BeforeClass
  public void beforeClass(String browserName, String userUrl, String adminUrl) {
	  this.userUrl = userUrl;
	  this.adminUrl = adminUrl;
	  
	  driver = getWebBrowser(browserName, this.userUrl);
	  userHomePage = PageGeneratorManager.getUserHomePageObject(driver);
  }
  
  @Test
  public void TC_01_Switch_Roles() {
	  	userLoginPage = userHomePage.clickToMyAccountLink();
		userLoginPage.inputToEmailTextBox("thanhphat635895@gmail.com");
		userLoginPage.inputToPasswordTextBox("123456789");
		dashboardPage = userLoginPage.clickToLoginButton();
		
		dashboardPage.clickOnAccountButton();
		
		userHomePage = dashboardPage.clickOnLogOutButton(driver);
	  
		adminLoginPage = userHomePage.openAdminLoginPage(driver, adminUrl);
		  
		adminLoginPage.inputToUserNameTextBox("user01");
		  
		adminLoginPage.inputToPasswordTextBox("guru99com");
		  
		adminHomePage = adminLoginPage.clickOnLoginButton();
		  
		adminHomePage.clickOnCloseButtonOnPopup();
		  
		adminLoginPage = adminHomePage.clickLogOutButton(driver);
		  
		userHomePage = adminLoginPage.openUserHomePage(driver, userUrl);
		  
		userLoginPage = userHomePage.clickToMyAccountLink();
		userLoginPage.inputToEmailTextBox("thanhphat635895@gmail.com");
		userLoginPage.inputToPasswordTextBox("123456789");
		dashboardPage = userLoginPage.clickToLoginButton();
} 
  

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
