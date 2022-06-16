package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.Navigation.SideBarPageObject;

public class MyOrderPageObject extends SideBarPageObject{
	WebDriver driver;
	
	public MyOrderPageObject (WebDriver driver) {
		super(driver);
;		this.driver = driver;
	}
}
