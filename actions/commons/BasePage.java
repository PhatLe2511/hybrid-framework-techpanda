package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.Navigation.FooterContainerPageObject;
import pageObject.admin.AdminLoginPageObject;
import pageObject.user.PageGeneratorManager;
import pageObject.user.UserHomePageObject;
import pageUIs.admin.AdminHomePageUI;
import pageUIs.jQuery.HomePageUI;
import pageUIs.user.DashboardPageUI;

public class BasePage {
	
	public static BasePage getBasePageInstance() {
		return new BasePage();
	}
	
	public void switchToWindowByID(WebDriver driver, String expectedID) {
		Set<String> allTabIDs = driver.getWindowHandles();
		
		for (String id : allTabIDs) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void getTabTitle(WebDriver driver, String expectedTitle) {
		Set<String> allTabTitle = driver.getWindowHandles();
		
		for (String tabTitle : allTabTitle) {
			driver.switchTo().window(tabTitle);
			
			String actualTitle = driver.getTitle();
			
			if (actualTitle.equals(expectedTitle)) {	
				break;
			}
		}
		
	}
	
	public boolean closeAllWindowsWithoutParent(WebDriver driver, String ParentID) {

		Set<String> allWindows = driver.getWindowHandles();
		
		for (String runWindows : allWindows) {
			if (!runWindows.equals(ParentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(ParentID);
		if(driver.getWindowHandles().size() == 1)
			return true;
		else 
			return false;
	}
	
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss(); 
	}
	
	public void sendKeysToAlert(WebDriver driver, String valuetoSendKey) {
		waitForAlertPresence(driver).sendKeys(valuetoSendKey); 
	}
 	
	public String getAlertText(WebDriver driver) {
		 return driver.switchTo().alert().getText();
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String... values) {
		getElement(driver, castRestParamater(locator, values)).click();
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String keyToSend) {
		WebElement  element = getElement(driver, locator);
		element.clear();
		element.sendKeys(keyToSend);
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String keyToSend, String... values) {
		WebElement  element = getElement(driver, castRestParamater(locator, values));
		element.clear();
		element.sendKeys(keyToSend);
	}
	
	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	
	public String getElementText(WebDriver driver, String locator, String... values) {
		return getElement(driver, castRestParamater(locator, values)).getText();
	}
	
	public void selectInDefaultDropDown(WebDriver driver, String locator, String  itemText) {
		Select select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}
	
	public String getFirstSelectedItem(WebDriver driver, String locator) {
		Select select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isMultipleDropDown(WebDriver driver, String locator) {
		Select select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}
	
	public void selectInCustomDropDownList(WebDriver driver, String parentLocator, String childLocator, String expectedText) {
		getElement(driver, parentLocator).click();
		
		List<WebElement> allNumbers = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		
		for (WebElement number : allNumbers) {
			String actualText = number.getText();
			
			if (actualText.equals(expectedText)) {
				
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", number);
				
				sleepInSecond(3);
				
				number.click();
				
				sleepInSecond(3);
		
				break;
			}
		}
	}
	
	public String getElementAttribute(WebDriver driver, String Locator, String attributeName) {
		return getElement(driver, Locator).getAttribute(attributeName); 
	}
	
	public String getElementCssValue(WebDriver driver, String Locator, String propertyName) {
		return getElement(driver, Locator).getCssValue(propertyName);
	}
	
	public int getListElementSize(WebDriver driver, String Locator) {
		return getElements(driver, Locator).size();
	}
	
	public int getListElementSize(WebDriver driver, String Locator, String... dynamicLocator) {
		return getElements(driver, castRestParamater(Locator, dynamicLocator)).size();
	}
	
	public String getHexaColorByRgbaColor(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	 
	public void checkToCheckBoxOrRadio(WebDriver driver, String Locator) {
		WebElement element = getElement(driver, Locator);
		if (!element.isSelected()){
			element.click();
		}
	}
	
	public void unCheckToCheckBox(WebDriver driver, String Locator) {
		WebElement element = getElement(driver, Locator);
		if (element.isSelected()) {
			element.click();
		} 
	}
  	
	public boolean isElementDisplayed(WebDriver driver, String Locator) {
		return getElement(driver, Locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String Locator, String... values) {
		return getElement(driver, castRestParamater(Locator, values)).isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver, String Locator) {
		return getElement(driver, Locator).isSelected();
	}
	
	public boolean isElementEnabled(WebDriver driver, String Locator) {
		return getElement(driver, Locator).isEnabled();
	} 
	
	public void switchToIframe(WebDriver driver, String Locator) {
		driver.switchTo().frame(getElement(driver, Locator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void doubleClickToElement(WebDriver driver, String Locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getElement(driver, Locator)).perform();
	}
	
	public void hoverToElement(WebDriver driver, String Locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, Locator)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String Locator) {
		Actions action = new Actions(driver);
		action.contextClick(getElement(driver, Locator)).perform();
	}
	
	public void dragAndDropToElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String Locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, Locator), key).perform(); 
	}
	
	public void pressKeyToElement(WebDriver driver, String Locator, Keys key, String... values) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, castRestParamater(Locator, values)), key).perform(); 
	}
	
	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}
	
	public void hightlightElement(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castRestParamater(locator, values))));
	}
	
	public void waitForElementPresence(WebDriver driver, String locator) {
		new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForElementPresence(WebDriver driver, String locator, String... values) {
		new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(getByLocator(castRestParamater(locator, values))));
	} 
	
	public boolean waitForElementInvisible(WebDriver driver, String locator) {
		return new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	
	public boolean waitForElementInvisible(WebDriver driver, String locator, String... values) {
		return new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParamater(locator, values))));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, WebElement element) { 
		new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
	}
 	
	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.elementToBeClickable(getByLocator(castRestParamater(locator, values))));
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.alertIsPresent());
	}
	
	public Set<Cookie> getAllCookies(WebDriver driver){
		return driver.manage().getCookies();
	}
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}
	
	
	public By getByLocator(String locator) {
		By by;
	if (locator.startsWith("xpath=") ||locator.startsWith("Xpath=") || locator.startsWith("XPATH=") || locator.startsWith("XPath=")) {
		by = By.xpath(locator.substring(6));
	}else if (locator.startsWith("css=") || locator.startsWith("Css=") || locator.startsWith("CSS=")) {
		by = By.cssSelector(locator.substring(4));
	}else if (locator.startsWith("id=") || locator.startsWith("ID=") || locator.startsWith("Id=")) {
		by = By.id(locator.substring(3));
	}else if (locator.startsWith("name=") || locator.startsWith("NAME=") || locator.startsWith("Name=")) {
		by = By.name(locator.substring(5));
	}else {
		throw new RuntimeException("Locator is not valid!");
	}
	return by;
}
	
	public void uploadMultipleFile(WebDriver driver, String... fileNames) {
		String uploadFilePath = GlobalConstants.UPLOAD_PATH;
		
		String fullFileName = "";
		
		for (String file : fileNames) {
			fullFileName = fullFileName + uploadFilePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, HomePageUI.ADD_FILE_BUTTON).sendKeys(fullFileName);
	}
	
	public String castRestParamater(String locator, String... dynamicLocator) {
		locator = String.format(locator, (Object[]) dynamicLocator);
		return locator;
	}
	
	public FooterContainerPageObject getFooterContainerPage(WebDriver driver) {
		return new FooterContainerPageObject(driver);
		
	}
	
	public AdminLoginPageObject openAdminLoginPage(WebDriver driver, String adminUrl) {
		openPageUrl(driver, adminUrl);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	public UserHomePageObject openUserHomePage(WebDriver driver, String userUrl) {
		openPageUrl(driver, userUrl);
		return PageGeneratorManager.getUserHomePageObject(driver);
		}
	
	public AdminLoginPageObject clickLogOutButton(WebDriver driver) {
		waitForElementClickable(driver, AdminHomePageUI.LOG_OUT_BUTTON);
		clickToElement(driver, AdminHomePageUI.LOG_OUT_BUTTON);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	public UserHomePageObject clickOnLogOutButton(WebDriver driver) {
		waitForElementPresence(driver, DashboardPageUI.LOGOUT_BUTTON);
		clickToElement(driver, DashboardPageUI.LOGOUT_BUTTON);
		return PageGeneratorManager.getUserHomePageObject(driver);
	}
	
	
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
}
