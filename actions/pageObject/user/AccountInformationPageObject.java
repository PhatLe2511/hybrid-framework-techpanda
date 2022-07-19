package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.Navigation.SideBarPageObject;
import pageUIs.user.AccountInformationPageUI;

public class AccountInformationPageObject extends SideBarPageObject{
	WebDriver driver;
	
	public AccountInformationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void editFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, AccountInformationPageUI.FIRST_NAME_TEXT_BOX);
		sendKeyToElement(driver, AccountInformationPageUI.FIRST_NAME_TEXT_BOX, firstName);
	}

	public void editLastNameTextBox(String lastName) {
		sendKeyToElement(driver, AccountInformationPageUI.LAST_NAME_TEXT_BOX, lastName);
	}

	public void inputToCurrentPasswordTextBox(String password) {
		sendKeyToElement(driver, AccountInformationPageUI.CURRENT_PASSWORD_TEXT_BOX, password);
	}

	public DashboardPageObject clickOnSaveButton() {
		clickToElement(driver, AccountInformationPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getDashboardPageObject(driver);
		
	}
}
