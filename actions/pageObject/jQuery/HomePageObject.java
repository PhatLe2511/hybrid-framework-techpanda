package pageObject.jQuery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validateRowValues(String femalesNumber, String countryName, String malesNumber, String totalNumber) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE, femalesNumber, countryName, malesNumber, totalNumber);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE, femalesNumber, countryName, malesNumber, totalNumber);
	}


	public void clickToLoadDataButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
	}

	public void enterToRowTextBox(String headerName, String rowNumber, String valueToInput) {
		int indexName = getListElementSize(driver, HomePageUI.HEADER_INDEX_BY_NAME, headerName) + 1;
		
		waitForElementVisible(driver, HomePageUI.CELL_TEXTBOX_BY_HEADER_INDEX, rowNumber, String.valueOf(indexName));
		sendKeyToElement(driver, HomePageUI.CELL_TEXTBOX_BY_HEADER_INDEX, valueToInput, rowNumber, String.valueOf(indexName)); 
	}

	public boolean isFileLoaded(String fileNames) {
		waitForElementVisible(driver, HomePageUI.LOADED_FILE, fileNames);
		return isElementDisplayed(driver, HomePageUI.LOADED_FILE, fileNames);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getElements(driver, HomePageUI.START_BUTTON);
		
		for (WebElement startButton : startButtons) {
			waitForElementClickable(driver, HomePageUI.START_BUTTON);
			startButton.click();
			sleepInSecond(2);
		}
		
	}

	public boolean isFileUploaded(String fileNames) {
		waitForElementVisible(driver, HomePageUI.UPLOADED_FILE, fileNames);
		return isElementDisplayed(driver, HomePageUI.UPLOADED_FILE, fileNames);
	}

	
	public void inputToHeaderTextbox(String valueToInput, String headerNames) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX, headerNames);
		sendKeyToElement(driver, HomePageUI.HEADER_TEXTBOX, valueToInput, headerNames);
		
	}

	public void pressEnterToSearch(String headerNames) {
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX, Keys.ENTER, headerNames);
	}

	public boolean isValueDisplayed(String femaleValues, String countryName, String malevalues, String totalValues) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE, femaleValues, countryName, malevalues, totalValues);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE, femaleValues, countryName, malevalues, totalValues);
	}


	
	
}
