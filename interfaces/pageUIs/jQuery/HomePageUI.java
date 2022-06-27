package pageUIs.jQuery;

public class HomePageUI {
	
	public static final String HEADER_TEXTBOX = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	
	public static final String ACTION_ICONS = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td/button[contains(@class,'%s')]";
	
	public static final String OK_BUTTON_IN_EDIT_RECORD = "css=form.qgrd-modal-form input.qgrd-modal-submit";
	
	public static final String PAGE_NUMBER = "xpath=//a[text()='%s']";
	
	public static final String ACTIVED_PAGE_NUMBER = "xpath=//a[contains(@class,'active') and text()='%s']";
	
	public static final String ROW_VALUE = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	
	public static final String LOAD_DATA_BUTTON = "CSS=button#btnLoad";
	
	public static final String HEADER_INDEX_BY_NAME = "xpath=//td[text()='%s']/preceding-sibling::td";
	
	public static final String CELL_TEXTBOX_BY_HEADER_INDEX = "xpath=//tr[%s]//td[%s]/input";

	public static final String ADD_FILE_BUTTON = "css=input[type='file']";
	
	public static final String LOADED_FILE = "xpath=//p[@class='name' and text()='%s']";
	
	public static final String UPLOADED_FILE = "xpath=//p[@class='name']/a[text()='%s']";
	
	public static final String START_BUTTON = "xpath=//button//span[text()='Start']";
	
}
