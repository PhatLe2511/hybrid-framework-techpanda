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

public class Level_12_Upload_Files extends BaseTest{
	
	WebDriver driver;
	HomePageObject homePage;
	String apiImage= "api.jpg";
	String appiumImage= "appium.jpg";
	String seleniumImage= "selenium.jpg";
	
  @Parameters({"Browser", "url"})
  @BeforeClass
  public void beforeClass(String browserName, String url) {
	  
	  driver = getWebBrowser(browserName, url);
	  homePage = PageGeneratorManagerJquery.getHomePageObject(driver);
  }
  
  @Test
  public void TC_01_Upload_One_File() {
	  homePage.uploadMultipleFile(driver, apiImage);
	  
	  Assert.assertTrue(homePage.isFileLoaded(apiImage));
	  
	  homePage.clickToStartButton();
	  
	  Assert.assertTrue(homePage.isFileUploaded(apiImage));
} 
  
  @Test
  public void TC_02_Upload_Multiple_File() {
	  
	  homePage.refreshCurrentPage(driver);
	  homePage.uploadMultipleFile(driver, apiImage, seleniumImage, appiumImage);
	  
	  Assert.assertTrue(homePage.isFileLoaded(apiImage));
	  Assert.assertTrue(homePage.isFileLoaded(seleniumImage));
	  Assert.assertTrue(homePage.isFileLoaded(appiumImage));
	  
	  homePage.clickToStartButton();
	  homePage.clickToStartButton();
	  homePage.clickToStartButton();
	  
	  Assert.assertTrue(homePage.isFileUploaded(apiImage));
	  Assert.assertTrue(homePage.isFileUploaded(seleniumImage));
	  Assert.assertTrue(homePage.isFileUploaded(appiumImage));
  }

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
