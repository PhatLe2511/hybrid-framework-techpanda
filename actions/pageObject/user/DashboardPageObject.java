package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.DashboardPageUI;

public class DashboardPageObject extends BasePage{
	
	WebDriver driver;
	
	public DashboardPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public String getRegisterMessage() {
		waitForElementVisible(driver, DashboardPageUI.REGISTER_SUCCESSFUL_MESSAGE);
		return getElementText(driver, DashboardPageUI.REGISTER_SUCCESSFUL_MESSAGE);
	}

	public String getDashBoardTitle() {
		return getElementText(driver, DashboardPageUI.DASHBOARD_TITLE);
	}

	public String getWelcomeMessage() {
		return getElementText(driver, DashboardPageUI.WELCOME_MESSAGE);
	}

	public void clickOnAccountButton() {
		clickToElement(driver, DashboardPageUI.ACCOUNT_FIELD);
	}

	public HomePageObject clickOnLogOutButton() {
		waitForElementPresence(driver, DashboardPageUI.LOGOUT_BUTTON);
		clickToElement(driver, DashboardPageUI.LOGOUT_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public String getContactInformation() {	
		return getElementText(driver, DashboardPageUI.CONTACT_INFORMATION);
	}

	public String getEditSuccessMessage() {
		return getElementText(driver, DashboardPageUI.EDIT_SUCCESSFUL_MESSAGE);
	}

}
