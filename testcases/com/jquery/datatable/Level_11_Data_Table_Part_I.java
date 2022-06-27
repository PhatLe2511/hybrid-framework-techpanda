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
	  homePage.inputToHeaderTextBox("Country", "Afghanistan");
	  homePage.pressEnterToSearch("Country");
	  Assert.assertTrue(homePage.validateRowValues("384187", "Afghanistan", "407124", "791312"));
	  homePage.refreshCurrentPage(driver);
	  homePage.sleepInSecond(3);
	  
	  homePage.inputToHeaderTextBox("Females", "777");
	  homePage.pressEnterToSearch("Females");
	  Assert.assertTrue(homePage.validateRowValues("777", "Antigua and Barbuda", "803", "1580"));
	  homePage.refreshCurrentPage(driver);
	  homePage.sleepInSecond(3);
	  
	  homePage.inputToHeaderTextBox("Males", "756");
	  homePage.pressEnterToSearch("Males");
	  Assert.assertTrue(homePage.validateRowValues("750", "Aruba", "756", "1504"));
	  homePage.refreshCurrentPage(driver);
	  homePage.sleepInSecond(3);
	  
	  homePage.inputToHeaderTextBox("Total", "553353");
	  homePage.pressEnterToSearch("Total");
	  Assert.assertTrue(homePage.validateRowValues("276880", "Angola", "276472", "553353"));
	  homePage.refreshCurrentPage(driver);
	  homePage.sleepInSecond(3);
	  
	  
} 
  
  @Test
  public void TC_02() {
	  homePage.pressActionIcon("Afghanistan", "edit");
	  homePage.pressOkInEditRecord();
	  
	  homePage.pressActionIcon("Afghanistan", "remove");
	  homePage.sleepInSecond(3);
	  
	  homePage.pressActionIcon("Angola", "edit");
	  homePage.pressOkInEditRecord();
	  
	  homePage.pressActionIcon("Angola", "remove");
	  homePage.sleepInSecond(3);
	  
	  homePage.pressActionIcon("Armenia", "edit");
	  homePage.pressOkInEditRecord();
	  
	  homePage.pressActionIcon("Armenia", "remove");
	  homePage.sleepInSecond(3);
  }
  
  @Test
  public void TC_03() {
	  homePage.clickToPageNumber("4");
	  Assert.assertTrue(homePage.isPageNumberSelected("4"));
	  homePage.sleepInSecond(3);
	  
	  homePage.clickToPageNumber("10");
	  Assert.assertTrue(homePage.isPageNumberSelected("10"));
	  homePage.sleepInSecond(3);
	  
	  homePage.clickToPageNumber("24");
	  Assert.assertTrue(homePage.isPageNumberSelected("24"));
	  homePage.sleepInSecond(3);
  }

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
