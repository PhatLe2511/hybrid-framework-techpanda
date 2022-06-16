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

	public void editFirstNameTextBox() {
		waitForElementVisible(driver, AccountInformationPageUI.FIRST_NAME_TEXT_BOX);
		sendKeyToElement(driver, AccountInformationPageUI.FIRST_NAME_TEXT_BOX, "Thanh");
	}

	public void editLastNameTextBox() {
		sendKeyToElement(driver, AccountInformationPageUI.LAST_NAME_TEXT_BOX, "Phat");
	}

	public void inputToCurrentPasswordTextBox() {
		sendKeyToElement(driver, AccountInformationPageUI.CURRENT_PASSWORD_TEXT_BOX, "123456789");
	}

	public DashboardPageObject clickOnSaveButton() {
		clickToElement(driver, AccountInformationPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getDashboardPageObject(driver);
		
	}
}
