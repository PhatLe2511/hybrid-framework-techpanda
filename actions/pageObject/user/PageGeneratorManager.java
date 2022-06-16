package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.admin.AdminHomePageObject;
import pageObject.admin.AdminLoginPageObject;

public class PageGeneratorManager {
	
	
	public static UserHomePageObject getUserHomePageObject(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPageObject(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static CreateNewAccountPageObject getCreateNewAccountPageObject(WebDriver driver) {
		return new CreateNewAccountPageObject(driver);
	}
	
	public static DashboardPageObject getDashboardPageObject(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	public static AccountInformationPageObject getAccountInformationPageObject(WebDriver driver) {
		return new AccountInformationPageObject(driver);
	}
	
	public static AddressBookPageObject getAddressBookPageObject(WebDriver driver) {
		return new AddressBookPageObject(driver);
	}
	
	public static MyOrderPageObject getMyOrderPageObject(WebDriver driver) {
		return new MyOrderPageObject(driver);
	}
	
	public static BillingAgreementsPageObject getBillingAgreementsPageObject(WebDriver driver) {
		return new BillingAgreementsPageObject(driver);
	}
	
	public static RecurringProfilesPageObject getRecurringProfilesPageObject(WebDriver driver) {
		return new RecurringProfilesPageObject(driver);
	}
	
	public static MyProductReviewPageObject getMyProductReviewPageObject(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}
	
	public static MyWishlistPageObject getMyWishlistPageObject(WebDriver driver) {
		return new MyWishlistPageObject(driver);
	}
	
	public static MyApplicationsPageObject getMyApplicationsPageObject(WebDriver driver) {
		return new MyApplicationsPageObject(driver);
	}
	
	public static AboutUsPageObject getAboutUsPageObject(WebDriver driver) {
		return new AboutUsPageObject(driver);
	}
	
	public static ContactUsPageObject getContactUsPageObject(WebDriver driver) {
		return new ContactUsPageObject(driver);
	}

	public static SearchTermsPageObject getSearchTermsPageObject(WebDriver driver) {
		return new SearchTermsPageObject(driver);
	}
	
	public static MyAccountPageObject getFooterMyAccountPageObject(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);	
	}
	
	public static AdminHomePageObject getAdminHomePage(WebDriver driver) {
		
		return new AdminHomePageObject(driver);
		
	}
}
