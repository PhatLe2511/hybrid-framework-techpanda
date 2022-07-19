package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManagerJquery;

public class Level_11_Data_Table_Part_I extends BaseTest{
	
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
	  homePage.inputToHeaderTextbox("384187", "Females");
	  homePage.inputToHeaderTextbox("Afghanistan", "Country");
	  homePage.inputToHeaderTextbox("407124", "Males");
	  homePage.inputToHeaderTextbox("791312", "Total");
	  homePage.pressEnterToSearch("Males");
	  
	  Assert.assertTrue(homePage.isValueDisplayed("384187", "Afghanistan", "407124", "791312"));
	  
} 
  
  @Test
  public void TC_02() {
	  
  }
  
  @Test
  public void TC_03() {
	  
  }

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
