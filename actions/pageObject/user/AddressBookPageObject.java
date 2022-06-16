package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.Navigation.SideBarPageObject;

public class AddressBookPageObject extends SideBarPageObject{
	WebDriver driver;
	
	public AddressBookPageObject (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
