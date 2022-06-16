package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserLoginPageUI;


public class UserLoginPageObject extends BasePage{
	
	WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public DashboardPageObject clickToLoginButton() {
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardPageObject(driver);
	}

	public String getRequiredMailErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
	}

	public String getRequiredPasswordErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
		
	}

	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
	}

	public String getInvalidPasswordErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
	}

	public Object getIncorrectEmailPasswordErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.INCORRECT_USERNAME_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.INCORRECT_USERNAME_PASSWORD_ERROR_MESSAGE);
	}

	public CreateNewAccountPageObject clickOnCreateNewAccountButton() {
		waitForElementVisible(driver, UserLoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, UserLoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		return PageGeneratorManager.getCreateNewAccountPageObject(driver);
		
	}
	
	
}
