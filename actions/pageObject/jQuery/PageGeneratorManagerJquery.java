package pageObject.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerJquery {
	
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
