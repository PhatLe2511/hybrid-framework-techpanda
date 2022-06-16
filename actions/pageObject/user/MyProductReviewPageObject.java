package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.Navigation.SideBarPageObject;

public class MyProductReviewPageObject extends SideBarPageObject{
	WebDriver driver;
	
	public MyProductReviewPageObject (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
