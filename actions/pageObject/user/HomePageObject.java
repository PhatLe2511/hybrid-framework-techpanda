package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public LoginPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getLoginPageObject(driver);
	}
	
	public boolean homePageImage() {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_IMAGE);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_IMAGE);
	}


}

