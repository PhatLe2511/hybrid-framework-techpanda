package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.BasePageUI;
import pageUIs.user.UserHomePageUI;

public class UserHomePageObject extends BasePage{
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public UserLoginPageObject openLoginPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.HEADER_MY_ACCOUNT);
		clickToElement(driver, BasePageUI.HEADER_MY_ACCOUNT);
		return PageGeneratorManager.getUserLoginPageObject(driver);
	}
	
	public UserLoginPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserLoginPageObject(driver);
	}
	
	public boolean homePageImage() {
		waitForElementVisible(driver, UserHomePageUI.HOME_PAGE_IMAGE);
		return isElementDisplayed(driver, UserHomePageUI.HOME_PAGE_IMAGE);
	}

}

