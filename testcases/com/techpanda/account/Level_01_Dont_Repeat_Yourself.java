package com.techpanda.account;

import org.testng.annotations.Test;

//import commons.BasePage;
//
//import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;

public class Level_01_Dont_Repeat_Yourself {
	
 

  
  @Test
  public void TC_01() {
	  for (int i = 1 ; i <= 100 ; i++) {
		  System.out.println("cho mình xin lại sđt ik" + i);
	  }
  }
  

}
