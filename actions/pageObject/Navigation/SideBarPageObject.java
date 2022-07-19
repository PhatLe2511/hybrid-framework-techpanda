package pageObject.Navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.user.AccountInformationPageObject;
import pageObject.user.AddressBookPageObject;
import pageObject.user.BillingAgreementsPageObject;
import pageObject.user.DashboardPageObject;
import pageObject.user.MyApplicationsPageObject;
import pageObject.user.MyOrderPageObject;
import pageObject.user.MyProductReviewPageObject;
import pageObject.user.MyWishlistPageObject;
import pageObject.user.PageGeneratorManager;
import pageObject.user.RecurringProfilesPageObject;
import pageUIs.user.BasePageUI;

public class SideBarPageObject extends BasePage{
	WebDriver driver;
	
	public SideBarPageObject (WebDriver driver) {
		this.driver = driver;
	}
	
	public DashboardPageObject openMyDashboardPage() {
		waitForElementClickable(driver, BasePageUI.MY_DASHBOARD);
		clickToElement(driver, BasePageUI.MY_DASHBOARD);
		return PageGeneratorManager.getDashboardPageObject(driver);
	}
	
	public AccountInformationPageObject openAccountInformation(String pageName) {
		waitForElementPresence(driver, BasePageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		return PageGeneratorManager.getAccountInformationPageObject(driver);
	}
	
	public AddressBookPageObject openAddressBookPage() {
		waitForElementClickable(driver, BasePageUI.ADDRESS_BOOK);
		clickToElement(driver, BasePageUI.ADDRESS_BOOK);
		return PageGeneratorManager.getAddressBookPageObject(driver);
	}
	
	public MyOrderPageObject openMyOrderPage() {
		waitForElementClickable(driver, BasePageUI.MY_ORDERS);
		clickToElement(driver, BasePageUI.MY_ORDERS);
		return PageGeneratorManager.getMyOrderPageObject(driver);
	}
	
	public BillingAgreementsPageObject openBillingAgreementsPage() {
		waitForElementClickable(driver, BasePageUI.BILLING_AGREEMENTS);
		clickToElement(driver, BasePageUI.BILLING_AGREEMENTS);
		return PageGeneratorManager.getBillingAgreementsPageObject(driver);
	}
	
	public RecurringProfilesPageObject openRecurringProfilesPage() {
		waitForElementClickable(driver, BasePageUI.RECURRING_PROFILES);
		clickToElement(driver, BasePageUI.RECURRING_PROFILES);
		return PageGeneratorManager.getRecurringProfilesPageObject(driver);
	}
	
	public MyProductReviewPageObject openMyProductReviewPage() {
		waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEWS);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEWS);
		return PageGeneratorManager.getMyProductReviewPageObject(driver);
	}
	
	public MyWishlistPageObject openMyWishlistPage() {
		waitForElementClickable(driver, BasePageUI.MY_WISHLIST);
		clickToElement(driver, BasePageUI.MY_WISHLIST);
		return PageGeneratorManager.getMyWishlistPageObject(driver);
	}
	
	public MyApplicationsPageObject openMyApplicationsPageObject() {
		waitForElementClickable(driver, BasePageUI.MY_APPLICATIONS);
		clickToElement(driver, BasePageUI.MY_APPLICATIONS);
		return PageGeneratorManager.getMyApplicationsPageObject(driver);
	}
	
	public void openSideBarByLink(String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
	}
	
}
