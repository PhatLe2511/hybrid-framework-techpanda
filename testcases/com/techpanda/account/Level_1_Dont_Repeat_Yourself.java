package com.techpanda.account;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Level_1_Dont_Repeat_Yourself {
	
	WebDriver driver;
	BasePage basePage;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
  @Test
  public void f() {
  }
  @BeforeClass
  public void beforeClass() {
	  if(osName.toUpperCase().startsWith("MAC")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/BrowserDrivers/geckodriver");
			System.setProperty("webdriver.chrome.driver", projectPath + "/BrowserDrivers/chromedriver");
		}else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDrivers\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDrivers\\chromedriver.exe");
		}
		driver = new ChromeDriver();
		basePage = new BasePage( );
		driver.manage().window().maximize();  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
