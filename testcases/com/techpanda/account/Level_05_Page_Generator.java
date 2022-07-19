package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.user.AccountInformationPageObject;
import pageObject.user.CreateNewAccountPageObject;
import pageObject.user.DashboardPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.PageGeneratorManager;

@Test
public class Level_05_Page_Generator extends BaseTest{
	
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	CreateNewAccountPageObject createNewAccountPage;
	AccountInformationPageObject accountInformationPage;
	String firstName = "Le";
	String lastName = "Phat";
	String fullName = firstName + " " + lastName;
	String email = "thanhphat" + getRandomNumber() + "@gmail.com";
  
  @Parameters({"Browser"})
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getWebBrowser(browserName);
	  driver.get("http://live.techpanda.org/");
	  homePage = PageGeneratorManager.getUserHomePageObject(driver);
  }
  

  
  	@Test
  	public void TC_01_Login_Empty_Data() {
  	
  		loginPage = homePage.clickToMyAccountLink();
  		
  		loginPage.inputToEmailTextBox("");
  		loginPage.inputToPasswordTextBox("");
  		loginPage.clickToLoginButton();
		
  		Assert.assertEquals(loginPage.getRequiredPasswordErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getRequiredPasswordErrorMessage(), "This is a required field.");
	}
	
  	@Test
	public void TC_02_Login_With_Invalid_Email() {
  		
  		loginPage = homePage.clickToMyAccountLink();
  
  		loginPage.inputToEmailTextBox("thanhphat@1241");
  		loginPage.inputToPasswordTextBox("123456");
  		loginPage.clickToLoginButton();
		
  		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
  	@Test
	public void TC_03_Login_With_Invalid_Password() {
		
  		loginPage = homePage.clickToMyAccountLink();
  		
  		loginPage.inputToEmailTextBox("thanhphat@gmail.com");
  		loginPage.inputToPasswordTextBox("123");
  		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
  	
  	@Test
	public void TC_04_Create_New_Account() {
  		loginPage = homePage.clickToMyAccountLink();
  		
  		createNewAccountPage = loginPage.clickOnCreateNewAccountButton();
  		
  		createNewAccountPage.inputToFirstName(firstName);
		
  		createNewAccountPage.inputToLastName(lastName);
  		
  		createNewAccountPage.inputToEmailAddress(email);
  		
  		createNewAccountPage.inputToPasswordField("123456789");
  		
  		createNewAccountPage.inputToConfirmPasswordField("123456789");
  		
  		dashboardPage = createNewAccountPage.clickOnRegisterButton();

		Assert.assertEquals(dashboardPage.getRegisterMessage(), "Thank you for registering with Main Website Store.");
		Assert.assertEquals(dashboardPage.getDashBoardTitle(), "MY DASHBOARD");
		Assert.assertEquals(dashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");
		
		dashboardPage.clickOnAccountButton();
		homePage = dashboardPage.clickOnLogOutButton(driver);
		
		Assert.assertTrue(homePage.homePageImage());
		
	}
  	
  	@Test
	public void TC_05_Login_With_Incorrect_Email() {
		
  		loginPage = homePage.clickToMyAccountLink();
  		
  		loginPage.inputToEmailTextBox("thanhphatttt@gmail.com");
  		loginPage.inputToPasswordTextBox("123456789");
  		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getIncorrectEmailPasswordErrorMessage(), "Invalid login or password.");
	}
  	
  	@Test
	public void TC_06_Login_With_Incorrect_Password() {
		
  		loginPage = homePage.clickToMyAccountLink();
  		
  		loginPage.inputToEmailTextBox(email);
  		loginPage.inputToPasswordTextBox(String.valueOf(getRandomNumber()));
  		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getIncorrectEmailPasswordErrorMessage(), "Invalid login or password.");
	}
	
  	@Test
	public void TC_07_Login_Valid_Password() {

  		loginPage = homePage.clickToMyAccountLink();
  		
		loginPage.inputToEmailTextBox(email);
  		loginPage.inputToPasswordTextBox("123456789");
  		dashboardPage = loginPage.clickToLoginButton();
		
  		Assert.assertEquals(dashboardPage.getDashBoardTitle(), "MY DASHBOARD");
		Assert.assertEquals(dashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");
		Assert.assertTrue(dashboardPage.getContactInformation().contains(fullName));
		Assert.assertTrue(dashboardPage.getContactInformation().contains(email));
		
		dashboardPage.clickOnAccountButton();
		dashboardPage.clickOnLogOutButton(driver);
	}
  	
  	
  	@Test
  	public void TC_08_Edit_Information() {
  		loginPage = homePage.clickToMyAccountLink();
  		
  		loginPage.inputToEmailTextBox(email);
  		loginPage.inputToPasswordTextBox("123456789");
  		
  		dashboardPage = loginPage.clickToLoginButton();
  		
  		accountInformationPage = dashboardPage.openAccountInformation("Account Information");
  		
  		accountInformationPage.editFirstNameTextBox("Thanh");
  		accountInformationPage.editLastNameTextBox("Phat");
  		accountInformationPage.inputToCurrentPasswordTextBox("123456789");
  		dashboardPage = accountInformationPage.clickOnSaveButton();
  		
  		Assert.assertEquals(dashboardPage.getEditSuccessMessage(), "The account information has been saved.");
  		
  	}

  @AfterClass
  public void afterClass() {
	   driver.quit();
  }

}
