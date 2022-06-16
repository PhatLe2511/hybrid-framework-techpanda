package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.Navigation.SideBarPageObject;

public class MyWishlistPageObject extends SideBarPageObject{
	WebDriver driver;
	
	public MyWishlistPageObject (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
