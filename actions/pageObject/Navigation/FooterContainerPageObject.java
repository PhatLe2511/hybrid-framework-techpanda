package pageObject.Navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.user.AboutUsPageObject;
import pageObject.user.ContactUsPageObject;
import pageObject.user.MyAccountPageObject;
import pageObject.user.PageGeneratorManager;
import pageObject.user.SearchTermsPageObject;
import pageUIs.user.BasePageUI;

public class FooterContainerPageObject extends BasePage{
	WebDriver driver;
	
	
	public FooterContainerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public AboutUsPageObject openAboutUsPage() {
		waitForElementClickable(driver, BasePageUI.FOOTER_ABOUT_US);
		clickToElement(driver, BasePageUI.FOOTER_ABOUT_US);
		return PageGeneratorManager.getAboutUsPageObject(driver);
	}
	
	public ContactUsPageObject openContactUsPage() {
		waitForElementClickable(driver, BasePageUI.FOOTER_CONTACT_US);
		clickToElement(driver, BasePageUI.FOOTER_CONTACT_US);
		return PageGeneratorManager.getContactUsPageObject(driver);
	}
	
	public SearchTermsPageObject openSearchTermsPage() {
		waitForElementClickable(driver, BasePageUI.FOOTER_SEARCH_TERMS);
		clickToElement(driver, BasePageUI.FOOTER_SEARCH_TERMS);
		return PageGeneratorManager.getSearchTermsPageObject(driver);
	}
	
	public MyAccountPageObject openMyAccountPage() {
		waitForElementClickable(driver, BasePageUI.FOOTER_SEARCH_TERMS);
		clickToElement(driver, BasePageUI.FOOTER_SEARCH_TERMS);
		return PageGeneratorManager.getFooterMyAccountPageObject(driver);
	}
	
	public void openFooterContainerLink(String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_FOOTER_CONTAINER_LINK, pageName);
		clickToElement(driver, 	BasePageUI.DYNAMIC_FOOTER_CONTAINER_LINK, pageName);
	}
	
	public FooterContainerPageObject openFooterContainerLinks(String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_FOOTER_CONTAINER_LINK, pageName);
		clickToElement(driver, 	BasePageUI.DYNAMIC_FOOTER_CONTAINER_LINK, pageName);
		
		//Bad Coding, chỉ apply cho những page ít menu
		if (pageName.equals("About Us")) {
			return PageGeneratorManager.getAboutUsPageObject(driver);
		}else if (pageName.equals("Contact Us")) {
			return PageGeneratorManager.getContactUsPageObject(driver);
		}else if (pageName.equals("Search Terms")) {
			return PageGeneratorManager.getSearchTermsPageObject(driver);
		}else if (pageName.equals("My Account")) {
			return PageGeneratorManager.getFooterMyAccountPageObject(driver);
		} else {
		return null;
		}
	}
}
