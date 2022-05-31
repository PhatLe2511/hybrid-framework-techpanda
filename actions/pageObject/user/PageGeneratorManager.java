package pageObject.user;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static CreateNewAccountPageObject getCreateNewAccountPageObject(WebDriver driver) {
		return new CreateNewAccountPageObject(driver);
	}
	
	public static DashboardPageObject getDashboardPageObject(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	public static AccountInformationPageObject getAccountInformationPageObject(WebDriver driver) {
		return new AccountInformationPageObject(driver);
	}

}
