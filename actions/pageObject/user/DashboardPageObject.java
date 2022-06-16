package pageObject.user;

import org.openqa.selenium.WebDriver;
import pageObject.Navigation.SideBarPageObject;
import pageUIs.user.DashboardPageUI;

public class DashboardPageObject extends SideBarPageObject{
	
	WebDriver driver;
	
	public DashboardPageObject (WebDriver driver) {
		super(driver);
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

	public String getContactInformation() {	
		return getElementText(driver, DashboardPageUI.CONTACT_INFORMATION);
	}

	public String getEditSuccessMessage() {
		return getElementText(driver, DashboardPageUI.EDIT_SUCCESSFUL_MESSAGE);
	}

}
