package com.techpanda.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Account_01_register {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
  @Test
  public void f() {
  }
  @BeforeClass
  public void beforeClass() {
	  if(osName.toUpperCase().startsWith("MAC")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/BrowserDrivers/geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", projectPath + "/BrowserDrivers/chromedriver.exe");
		}else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDrivers\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDrivers\\chromedriver.exe");
		}
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();  
  }

  @AfterClass
  public void afterClass() {
  }

}
