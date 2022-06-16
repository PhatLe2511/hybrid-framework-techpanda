package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.Navigation.FooterContainerPageObject;

public class ContactUsPageObject extends FooterContainerPageObject{
	WebDriver driver;
	
	public ContactUsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
}
