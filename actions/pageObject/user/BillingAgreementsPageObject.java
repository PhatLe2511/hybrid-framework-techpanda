package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class BillingAgreementsPageObject extends BasePage{
	WebDriver driver;
	
	public BillingAgreementsPageObject (WebDriver driver) {
		this.driver = driver;
	}
}
