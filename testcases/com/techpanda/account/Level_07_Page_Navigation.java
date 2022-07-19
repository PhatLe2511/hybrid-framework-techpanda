package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.user.AboutUsPageObject;
import pageObject.user.AccountInformationPageObject;
import pageObject.user.AddressBookPageObject;
import pageObject.user.BillingAgreementsPageObject;
import pageObject.user.ContactUsPageObject;
import pageObject.user.CreateNewAccountPageObject;
import pageObject.user.DashboardPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.MyAccountPageObject;
import pageObject.user.MyApplicationsPageObject;
import pageObject.user.MyOrderPageObject;
import pageObject.user.MyProductReviewPageObject;
import pageObject.user.MyWishlistPageObject;
import pageObject.user.PageGeneratorManager;
import pageObject.user.RecurringProfilesPageObject;
import pageObject.user.SearchTermsPageObject;

@Test
public class Level_07_Page_Navigation extends BaseTest{
	
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	MyOrderPageObject myOrderPage;
	MyWishlistPageObject myWishList;
	DashboardPageObject dashboardPage;
	AddressBookPageObject addressBookPage;
	AboutUsPageObject aboutUsPage;
	ContactUsPageObject contactUsPage;
	SearchTermsPageObject searchTermsPage;
	MyAccountPageObject footerMyAccountPage;
	MyApplicationsPageObject myApplicationsPage;
	MyProductReviewPageObject myProductReviewsPage;
	CreateNewAccountPageObject createNewAccountPage;
	BillingAgreementsPageObject billingAgreementsPage;
	RecurringProfilesPageObject recurringProfilesPage;
	AccountInformationPageObject accountInformationPage;
	
  @Parameters({"Browser"})
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getWebBrowser(browserName);
	  driver.get("http://live.techpanda.org/");
	  homePage = PageGeneratorManager.getUserHomePageObject(driver);
  }
  
  @Test
	public void TC_01_Login_Valid_Password() {

		loginPage = homePage.openLoginPage(driver);
		
		loginPage.inputToEmailTextBox("thanhphat635895@gmail.com");
		loginPage.inputToPasswordTextBox("123456789");
		dashboardPage = loginPage.clickToLoginButton(); 
  }  
  	@Test
  	public void TC_02_Page_Navigation() {
  		
  		accountInformationPage = dashboardPage.openAccountInformation("Account Information");
  		
  		addressBookPage = accountInformationPage.openAddressBookPage();
  		
  		myOrderPage = addressBookPage.openMyOrderPage();
  		
  		billingAgreementsPage = myOrderPage.openBillingAgreementsPage();
  		
  		recurringProfilesPage = billingAgreementsPage.openRecurringProfilesPage();
  		
  		myProductReviewsPage = recurringProfilesPage.openMyProductReviewPage();
  		
  		myWishList = myProductReviewsPage.openMyWishlistPage();
  		
  		myApplicationsPage = myWishList.openMyApplicationsPageObject();
  		
  		dashboardPage = myApplicationsPage.openMyDashboardPage();
  		
  	}
  	
  	@Test
  	public void TC_03_Footer_Page_Navigation() {
  		aboutUsPage = dashboardPage.getFooterContainerPage(driver).openAboutUsPage();
  		
  		contactUsPage = aboutUsPage.openContactUsPage();
  		
  		searchTermsPage = contactUsPage.openSearchTermsPage();
  		
  		footerMyAccountPage = searchTermsPage.openMyAccountPage();
  		
  		
  	}

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
