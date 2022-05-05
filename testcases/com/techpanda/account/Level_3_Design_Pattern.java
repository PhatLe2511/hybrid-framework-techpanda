package com.techpanda.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.user.CreateNewAccountPageObject;
import pageObject.user.DashboardPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;

@Test
public class Level_3_Design_Pattern{
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	HomePageObject homePage;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	CreateNewAccountPageObject createNewAccountPage;
	String firstName = "Le";
	String lastName = "Phat";
	String fullName = firstName + " " + lastName;
	String email = "thanhphat" + getRandomNumber() + "@gmail.com";
  
  @BeforeClass
  public void beforeClass() {
	  if(osName.toUpperCase().startsWith("MAC")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/BrowserDrivers/geckodriver");
			System.setProperty("webdriver.chrome.driver", projectPath + "/BrowserDrivers/chromedriver");
		}else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDrivers\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDrivers\\chromedriver.exe");
		}
		
		driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();  
		
		driver.get("http://live.techpanda.org/");
		
		homePage = new HomePageObject(driver);
  }
  

  
  	@Test
  	public void TC_01_Login_Empty_Data() {
  		
  		loginPage = new LoginPageObject(driver);
  		
  		homePage.clickToMyAccountLink();
  		loginPage.inputToEmailTextBox("");
  		loginPage.inputToPasswordTextBox("");
  		loginPage.clickToLoginButton();
		
  		Assert.assertEquals(loginPage.getRequiredPasswordErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getRequiredPasswordErrorMessage(), "This is a required field.");
	}
	
  	@Test
	public void TC_02_Invalid_Email() {
  		homePage.clickToMyAccountLink();
  		loginPage.inputToEmailTextBox("thanhphat@1241");
  		loginPage.inputToPasswordTextBox("123456");
  		loginPage.clickToLoginButton();
		
  		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
  	@Test
	public void TC_03_Invalid_Password() {
		
  		homePage.clickToMyAccountLink();
  		loginPage.inputToEmailTextBox("thanhphat@gmail.com");
  		loginPage.inputToPasswordTextBox("123");
  		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
  	
  	@Test
	public void TC_04_Incorrect_Email_Password() {
		
  		homePage.clickToMyAccountLink();
  		loginPage.inputToEmailTextBox("thanhphat@gmail.com");
  		loginPage.inputToPasswordTextBox("123123123123");
  		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getIncorrectEmailPasswordErrorMessage(), "Invalid login or password.");
	}
  	
  	@Test
	public void TC_05_Create_New_Account() {
  		createNewAccountPage = new CreateNewAccountPageObject(driver);
  		
  		dashboardPage = new DashboardPageObject(driver);
  		
  		homePage.clickToMyAccountLink();
  		
  		loginPage.clickOnCreateNewAccountButton();
  		
  		
  		createNewAccountPage.inputToFirstName(firstName);
		
  		createNewAccountPage.inputToLastName(lastName);
  		
  		createNewAccountPage.inputToEmailAddress(email);
  		
  		createNewAccountPage.inputToPasswordField("123456789");
  		
  		createNewAccountPage.inputToConfirmPasswordField("123456789");
  		
  		createNewAccountPage.clickOnRegisterButton();
		
		
		Assert.assertEquals(dashboardPage.getRegisterMessage(), "Thank you for registering with Main Website Store.");
		Assert.assertEquals(dashboardPage.getDashBoardTitle(), "MY DASHBOARD");
		Assert.assertEquals(dashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");
		
		dashboardPage.clickOnAccountButton();
		
		dashboardPage.clickOnLogOutButton();
		
		Assert.assertTrue(homePage.homePageImage());
		
	}
	
  	@Test
	public void TC_06_Login_Valid_Password() {
		homePage.clickToMyAccountLink();
  		loginPage.inputToEmailTextBox(email);
  		loginPage.inputToPasswordTextBox("123456789");
  		loginPage.clickToLoginButton();
		
		
  		Assert.assertEquals(dashboardPage.getDashBoardTitle(), "MY DASHBOARD");
		Assert.assertEquals(dashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");
	
		Assert.assertTrue(dashboardPage.getContactInformation().contains(fullName));
		Assert.assertTrue(dashboardPage.getContactInformation().contains(email));
	}
  
  
  
  public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}
  

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
