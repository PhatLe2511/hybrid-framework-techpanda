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
public class Level_03_Design_Pattern{
	
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
		
  }
  

  
  	@Test
  	public void TC_01_Login_Empty_Data() {
  		
  		homePage = new HomePageObject(driver);
  		homePage.clickToMyAccountLink();
  		
  		loginPage = new LoginPageObject(driver);
  		loginPage.inputToEmailTextBox("");
  		loginPage.inputToPasswordTextBox("");
  		loginPage.clickToLoginButton();
		
  		Assert.assertEquals(loginPage.getRequiredPasswordErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getRequiredPasswordErrorMessage(), "This is a required field.");
	}
	
  	@Test
	public void TC_02_Login_With_Invalid_Email() {
  		
  		homePage = new HomePageObject(driver);
  		homePage.clickToMyAccountLink();
  		
  		loginPage = new LoginPageObject(driver);
  		loginPage.inputToEmailTextBox("thanhphat@1241");
  		loginPage.inputToPasswordTextBox("123456");
  		loginPage.clickToLoginButton();
		
  		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
  	@Test
	public void TC_03_Login_With_Invalid_Password() {
		
  		homePage = new HomePageObject(driver);
  		homePage.clickToMyAccountLink();
  		
  		loginPage = new LoginPageObject(driver);
  		loginPage.inputToEmailTextBox("thanhphat@gmail.com");
  		loginPage.inputToPasswordTextBox("123");
  		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
  	
  	@Test
	public void TC_04_Create_New_Account() {
  		homePage = new HomePageObject(driver);
  		homePage.clickToMyAccountLink();
  		
  		loginPage = new LoginPageObject(driver);
  		loginPage.clickOnCreateNewAccountButton();
  		
  		createNewAccountPage = new CreateNewAccountPageObject(driver);
  		createNewAccountPage.inputToFirstName(firstName);
		
  		createNewAccountPage.inputToLastName(lastName);
  		
  		createNewAccountPage.inputToEmailAddress(email);
  		
  		createNewAccountPage.inputToPasswordField("123456789");
  		
  		createNewAccountPage.inputToConfirmPasswordField("123456789");
  		
  		createNewAccountPage.clickOnRegisterButton();
		
  		dashboardPage = new DashboardPageObject(driver);
		Assert.assertEquals(dashboardPage.getRegisterMessage(), "Thank you for registering with Main Website Store.");
		Assert.assertEquals(dashboardPage.getDashBoardTitle(), "MY DASHBOARD");
		Assert.assertEquals(dashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");
		
		dashboardPage.clickOnAccountButton();
		dashboardPage.clickOnLogOutButton();
		
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.homePageImage());
		
	}
  	
  	@Test
	public void TC_05_Login_With_Incorrect_Email() {
		
  		homePage = new HomePageObject(driver);
  		homePage.clickToMyAccountLink();
  		
  		loginPage = new LoginPageObject(driver);
  		loginPage.inputToEmailTextBox("thanhphatttt@gmail.com");
  		loginPage.inputToPasswordTextBox("123456789");
  		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getIncorrectEmailPasswordErrorMessage(), "Invalid login or password.");
	}
  	
  	@Test
	public void TC_06_Login_With_Incorrect_Password() {
		
  		homePage = new HomePageObject(driver);
  		homePage.clickToMyAccountLink();
  		
  		loginPage = new LoginPageObject(driver);
  		loginPage.inputToEmailTextBox(email);
  		loginPage.inputToPasswordTextBox(String.valueOf(getRandomNumber()));
  		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getIncorrectEmailPasswordErrorMessage(), "Invalid login or password.");
	}
	
  	@Test
	public void TC_07_Login_Valid_Password() {
  		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountLink();
  		
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox(email);
  		loginPage.inputToPasswordTextBox("123456789");
  		loginPage.clickToLoginButton();
		
  		dashboardPage = new DashboardPageObject(driver);
  		Assert.assertEquals(dashboardPage.getDashBoardTitle(), "MY DASHBOARD");
		Assert.assertEquals(dashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");
		Assert.assertTrue(dashboardPage.getContactInformation().contains(fullName));
		Assert.assertTrue(dashboardPage.getContactInformation().contains(email));
	}
  
  
  
  public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}
  

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
