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

	public void inputToHeaderTextBox(String headerName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX, headerName);
		sendKeyToElement(driver, HomePageUI.HEADER_TEXTBOX, value, headerName);
	}

	public void pressEnterToSearch(String headerName) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX, Keys.ENTER, headerName);
	}

	public void pressActionIcon(String countryName, String actionIcon) {
		waitForElementClickable(driver, HomePageUI.ACTION_ICONS, countryName, actionIcon);
		clickToElement(driver, HomePageUI.ACTION_ICONS, countryName, actionIcon);
	}

	public void pressOkInEditRecord() {
		waitForElementClickable(driver, HomePageUI.OK_BUTTON_IN_EDIT_RECORD);
		clickToElement(driver, HomePageUI.OK_BUTTON_IN_EDIT_RECORD);
	}

	public void clickToPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_NUMBER, pageNumber);
	}

	public boolean isPageNumberSelected(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.ACTIVED_PAGE_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.ACTIVED_PAGE_NUMBER, pageNumber);
	}

	public boolean validateRowValues(String femalesNumber, String countryName, String malesNumber, String totalNumber) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE, femalesNumber, countryName, malesNumber, totalNumber);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE, femalesNumber, countryName, malesNumber, totalNumber);
	}

	public boolean isImageloaded(String fileName) {
		waitForElementVisible(driver, HomePageUI.LOADED_FILE, fileName);
		return isElementDisplayed(driver, HomePageUI.LOADED_FILE, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtonElements = getElements(driver, HomePageUI.START_BUTTON);
		
		for (WebElement startButton : startButtonElements) {
			waitForElementClickable(driver, startButton);
			startButton.click();
			sleepInSecond(2);
		}
		
	}

	public boolean isImageUploaded(String fileName) {
		waitForElementVisible(driver, HomePageUI.UPLOADED_FILE, fileName);
		return isElementDisplayed(driver, HomePageUI.UPLOADED_FILE, fileName);
	}

	public void clickToLoadDataButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
	}

	public void enterToRowTextBox(String headerName, String rowNumber, String valueToInput) {
		int indexName = getListElementSize(driver, HomePageUI.HEADER_INDEX_BY_NAME, headerName) + 1;
		
		waitForElementVisible(driver, HomePageUI.CELL_TEXTBOX_BY_HEADER_INDEX, rowNumber, String.valueOf(indexName));
		System.out.println(HomePageUI.CELL_TEXTBOX_BY_HEADER_INDEX);
		
		sendKeyToElement(driver, HomePageUI.CELL_TEXTBOX_BY_HEADER_INDEX, valueToInput, rowNumber, String.valueOf(indexName)); 
	}
	
	
}
