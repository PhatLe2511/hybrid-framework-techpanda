package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.Navigation.SideBarPageObject;

public class MyApplicationsPageObject extends SideBarPageObject{
	WebDriver driver;
	
	public MyApplicationsPageObject (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
