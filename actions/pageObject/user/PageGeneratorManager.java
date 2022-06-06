package pageObject.user;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
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
	
	

}
