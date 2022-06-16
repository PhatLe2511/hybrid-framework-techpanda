package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.Navigation.SideBarPageObject;

public class RecurringProfilesPageObject extends SideBarPageObject{
	WebDriver driver;
	
	public RecurringProfilesPageObject (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
