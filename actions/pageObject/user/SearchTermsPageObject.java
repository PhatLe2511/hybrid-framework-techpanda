package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.Navigation.FooterContainerPageObject;

public class SearchTermsPageObject extends FooterContainerPageObject{
	
	WebDriver driver;
	
	public SearchTermsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
