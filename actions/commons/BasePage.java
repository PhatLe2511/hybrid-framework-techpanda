package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String keyToSend) {
		WebElement  element = getElement(driver, locator);
		element.clear();
		element.sendKeys(keyToSend);
	}
	
	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
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
	
	public void sendKeysToElement(WebDriver driver, String Locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, Locator), key).perform(); 
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
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementPresence(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
	} 
	
	public boolean waitForElementInvisible(WebDriver driver, String locator) {
		return new WebDriverWait(driver, longTimeout).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
 	
	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, longTimeout).until(ExpectedConditions.alertIsPresent());
	}
	
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private long longTimeout = 30;
		
}
