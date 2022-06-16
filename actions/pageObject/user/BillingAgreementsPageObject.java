package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.Navigation.SideBarPageObject;

public class BillingAgreementsPageObject extends SideBarPageObject{
	WebDriver driver;
	
	public BillingAgreementsPageObject (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
