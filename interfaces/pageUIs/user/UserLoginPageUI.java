package pageUIs.user;

public class UserLoginPageUI {
	
	public static final  String EMAIL_TEXTBOX = "xpath=//div[@class='col-2 registered-users']//input[@type='email']";
	
	public static final String PASSWORD_TEXTBOX = "xpath=//div[@class='col-2 registered-users']//input[@type='password']";
	
	public static final String LOGIN_BUTTON = "xpath=//button[@title='Login']";
	
	public static final String EMPTY_EMAIL_ERROR_MESSAGE = "xpath=//div[@id='advice-required-entry-email']";
	
	public static final String EMPTY_PASSWORD_ERROR_MESSAGE = "xpath=//div[@id='advice-required-entry-pass']";
	
	public static final String INVALID_EMAIL_ERROR_MESSAGE = "xpath=//div[@id='advice-validate-email-email']";
	
	public static final String INVALID_PASSWORD_ERROR_MESSAGE = "xpath=//div[@id='advice-validate-password-pass']";
	
	public static final String INCORRECT_USERNAME_PASSWORD_ERROR_MESSAGE = "xpath=//li[@class='error-msg']//span";
	
	public static final String CREATE_NEW_ACCOUNT_BUTTON = "xpath=//div[@class='col2-set']//div[@class='buttons-set']/a";
	
	
}
