package pageObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.AdminHomePageUI;

public class AdminHomePageObject extends BasePage{
	WebDriver driver;
	
	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnCloseButtonOnPopup() {
		waitForElementVisible(driver, AdminHomePageUI.MESSAGE_POPUP);
		waitForElementClickable(driver, AdminHomePageUI.CLOSE_BUTTON_ON_MESSAGE_POPUP);
		clickToElement(driver, AdminHomePageUI.CLOSE_BUTTON_ON_MESSAGE_POPUP);
	}
	
}
