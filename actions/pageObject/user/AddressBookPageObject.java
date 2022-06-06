package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AddressBookPageObject extends BasePage{
	WebDriver driver;
	
	public AddressBookPageObject (WebDriver driver) {
		this.driver = driver;
	}

}
