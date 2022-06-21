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
public class Level_09_Dynamic_Locator_I extends BaseTest{
	
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
	
	String url;
	
  @Parameters({"Browser", "url"})
  @BeforeClass
  public void beforeClass(String browserName, String url) {
	  this.url = url;
	  driver = getWebBrowser(browserName, this.url);
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
  		
  		dashboardPage.openSideBarByLink("Account Information");
  		accountInformationPage = PageGeneratorManager.getAccountInformationPageObject(driver);
  		
  		accountInformationPage.openSideBarByLink("Address Book");
  		addressBookPage = PageGeneratorManager.getAddressBookPageObject(driver);
  		
  		addressBookPage.openSideBarByLink("My Orders");
  		myOrderPage = PageGeneratorManager.getMyOrderPageObject(driver);
  		
  		myOrderPage.openSideBarByLink("Billing Agreements");
  		billingAgreementsPage = PageGeneratorManager.getBillingAgreementsPageObject(driver);
  		
  		billingAgreementsPage.openSideBarByLink("Recurring Profiles");
  		recurringProfilesPage = PageGeneratorManager.getRecurringProfilesPageObject(driver);
  		
  		recurringProfilesPage.openSideBarByLink("My Product Reviews");
  		myProductReviewsPage = PageGeneratorManager.getMyProductReviewPageObject(driver);
  		
  		myWishList = myProductReviewsPage.openMyWishlistPage();
  		
  		myWishList.openSideBarByLink("My Applications");
  		myApplicationsPage = PageGeneratorManager.getMyApplicationsPageObject(driver);
  		
  		myApplicationsPage.openSideBarByLink("Account Dashboard");
  		dashboardPage = PageGeneratorManager.getDashboardPageObject(driver);
  		
  	}
  	
  	@Test
  	public void TC_03_Footer_Page_Navigation() {
  		dashboardPage.getFooterContainerPage(driver).openFooterContainerLink("About Us");
  		aboutUsPage = PageGeneratorManager.getAboutUsPageObject(driver);
  		
  		aboutUsPage.openFooterContainerLink("Contact Us");
  		contactUsPage = PageGeneratorManager.getContactUsPageObject(driver);
  		
  		contactUsPage.openFooterContainerLink("Search Terms");
  		searchTermsPage = PageGeneratorManager.getSearchTermsPageObject(driver);
  		
  		searchTermsPage.openFooterContainerLink("My Account");
  		footerMyAccountPage = PageGeneratorManager.getFooterMyAccountPageObject(driver);	
  	}

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
