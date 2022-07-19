package com.techpanda.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObject.user.CreateNewAccountPageObject;
import pageObject.user.DashboardPageObject;
import pageObject.user.PageGeneratorManager;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;

public class Common_Register_Cookie extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	CreateNewAccountPageObject createNewAccountPage;
	DashboardPageObject dashboardPage;
	public static String email = "thanhphat" + getRandomNumber() + "@gmail.com";
	public static String password = "123456789";
	public static Set<Cookie> loggedCookie;
	
	@Parameters({"Browser" , "url"})
	@BeforeTest
	public void Register(String browserName, String url) {
		driver = getWebBrowser(browserName, url);
		homePage = PageGeneratorManager.getUserHomePageObject(driver);
		String firstName = "Le";
		String lastName = "Phat";
		
		loginPage = homePage.clickToMyAccountLink();
		
		createNewAccountPage = loginPage.clickOnCreateNewAccountButton();
		
		createNewAccountPage.inputToFirstName(firstName);
	
		createNewAccountPage.inputToLastName(lastName);
		
		createNewAccountPage.inputToEmailAddress(email);
		
		createNewAccountPage.inputToPasswordField(password);
		
		createNewAccountPage.inputToConfirmPasswordField(password);
		
		dashboardPage = createNewAccountPage.clickOnRegisterButton();
		
		dashboardPage.clickOnAccountButton();
		homePage = dashboardPage.clickOnLogOutButton(driver);
		
		loginPage = homePage.clickToMyAccountLink();
		
		loginPage.inputToEmailTextBox(email);
		  
		loginPage.inputToPasswordTextBox(password);
		  
		dashboardPage = loginPage.clickToLoginButton();
		
		loggedCookie = loginPage.getAllCookies(driver);
		System.out.println(loggedCookie);
		
		driver.quit();
	}

}