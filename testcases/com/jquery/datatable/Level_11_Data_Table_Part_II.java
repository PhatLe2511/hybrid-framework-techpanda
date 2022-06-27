package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManagerJquery;

public class Level_11_Data_Table_Part_II extends BaseTest{
	
	WebDriver driver;
	HomePageObject homePage;
	
  @Parameters({"Browser", "url"})
  @BeforeClass
  public void beforeClass(String browserName, String url) {
	  
	  driver = getWebBrowser(browserName, url);
	  homePage = PageGeneratorManagerJquery.getHomePageObject(driver);
  }
  
  @Test
  public void TC_01() {
	  homePage.clickToLoadDataButton();
	  
	  homePage.enterToRowTextBox("Price", "4", "138.2");
  }

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
