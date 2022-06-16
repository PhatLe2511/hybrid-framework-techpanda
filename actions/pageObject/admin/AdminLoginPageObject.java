package pageObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.user.PageGeneratorManager;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	WebDriver driver;
	
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUserNameTextBox(String username) {
		waitForElementPresence(driver, AdminLoginPageUI.ADMIN_USERNAME_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.ADMIN_USERNAME_TEXTBOX, username);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementPresence(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX, password);
	}

	public AdminHomePageObject clickOnLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		return PageGeneratorManager.getAdminHomePage(driver);
	}
	
}
 