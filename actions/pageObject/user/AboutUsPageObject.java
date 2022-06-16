package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.Navigation.FooterContainerPageObject;

public class AboutUsPageObject extends FooterContainerPageObject{
	WebDriver driver;
	
	
	public AboutUsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	
}
