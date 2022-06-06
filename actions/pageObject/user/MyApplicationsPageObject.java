package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyApplicationsPageObject extends BasePage{
	WebDriver driver;
	
	public MyApplicationsPageObject (WebDriver driver) {
		this.driver = driver;
	}
}
