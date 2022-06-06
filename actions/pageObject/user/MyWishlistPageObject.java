package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyWishlistPageObject extends BasePage{
	WebDriver driver;
	
	public MyWishlistPageObject (WebDriver driver) {
		this.driver = driver;
	}
}
