package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CreateNewAccountPageUI;

public class CreateNewAccountPageObject extends BasePage {
	
	WebDriver driver;
	
	public CreateNewAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstName(String firstName) {
		waitForElementVisible(driver, CreateNewAccountPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, CreateNewAccountPageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}

	public void inputToLastName(String lastName) {
		waitForElementVisible(driver, CreateNewAccountPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, CreateNewAccountPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	public void inputToEmailAddress(String emailAddress) {
		sendKeyToElement(driver, CreateNewAccountPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPasswordField(String password) {
		sendKeyToElement(driver, CreateNewAccountPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordField(String confirmPassword) {
		sendKeyToElement(driver, CreateNewAccountPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}

	public DashboardPageObject clickOnRegisterButton() {
		clickToElement(driver, CreateNewAccountPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getDashboardPageObject(driver);
	}
}
