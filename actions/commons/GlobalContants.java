package commons;

public class GlobalContants {
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	
	public static final String DEV_USER_URL = "http://dev.techpanda.org/";
	public static final String STAGING_USER_URL = "http://staging.techpanda.org/";
	public static final String LIVE_USER_URL = "http://live.techpanda.org/";
	
	public static final String DEV_ADMIN_URL = "http://dev.techpanda.org/index.php/backendlogin";
	public static final String STAGING_ADMIN_URL = "http://staging.techpanda.org/index.php/backendlogin";
	public static final String LIVE_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";
	
	public static final String ADMIN_USERNAME ="user01";
	public static final String ADMIN_PASSWORD ="guru99com";
	public static final String USER_USERNAME ="thanhphat635895@gmail.com";
	public static final String USER_PASSWORD ="123456789";
	
	
	//Time out
	public static final int SHORT_TIMEOUT = 10;
	public static final int LONG_TIMEOUT = 30;
	
	//So lan retry test case
	public static final int RETRY_NUMBER = 2;
	
	public static final String UPLOAD_PATH = PROJECT_PATH + "/uploadFiles/" ;
	public static final String DOWNLOAD_PATH = PROJECT_PATH + "/downloadFiles/" ;
	
	public static final String BROWSER_LOG_PATH = PROJECT_PATH + "/browserLogs/" ;
	public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + "/browserExtensions/" ;
	
	//html report file
	public static final String REPORTNG_PATH = PROJECT_PATH + "/htmlReportNG/" ;
	public static final String EXTENT_PATH = PROJECT_PATH + "/htmlExtent/" ;
	public static final String ALLURE_PATH = PROJECT_PATH + "/htmlAllure/" ;
	
	
}
