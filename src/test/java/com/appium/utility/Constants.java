package com.appium.utility;

import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import  java.util.List;
import java.util.Map;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
public class Constants {
	
	public static String RANDOM_VALUE = "";
	public static Reusables key;
	public static MobileDriver<MobileElement> driver;
	public static Properties CONFIG;
	public static Properties DBCONFIG;
    public static Properties IOSLoginOR;
    public static Properties IOSDashOR;
    public static Properties IOSRecipientOR;
    public static Properties IOSRegstOR;
    public static Properties IOSMyCardOR;
    public static Properties IOSAddWalletOR;
    public static Properties IOSSendMoneyOR;
    public static Properties IOSAccountOR;
    public static Properties IOS3DSOR;
    public static Properties IOSExtAppData;
    public static Properties IOSTestData;
    public static Properties TorFxTestData;
    public static DesiredCapabilities androidDc;
    public static DesiredCapabilities IOSDC;
    public static DesiredCapabilities IOSDC1;
	public static String appiumServerUrl;
	public static String KEYWORD_PASS ="PASS";
    public static String KEYWORD_FAIL ="FAIL";
    public static WebDriverWait wait;
    public static int waitInSeconds;
    public static int modifyWaitInSeconds;
    public static String appActivityName;
    public static String IOSbundleId;
	public static String appPackageName;
	public static String scenarioName;
	public static String custLegalEntity;
	public static int logInFailCount=0;
	public static List<MobileElement>ListOfMobEle; 
	public static String Data[];
	public static Map<String,String> DataMap;
	public static String TempData;
	public static Properties BrowserCONFIG;
	//Android constant file contents
	  public static Properties AndroidCDAppLogin;
	   public static Properties CDAppDashboard;
	   public static Properties AndroidCDAppRegistrationOR;
	   public static URL Androidurl;
	   public static String androidActivityName;
	    public static String androidPackageName;
	    public static String androidCustomerName;
	    public static Properties AndroidExtAppData;
	    public static Properties AndroidTestData;
	    public static String CustLegalEntity;
	    public static Properties AndroidCDAppRecipient;
		public static AndroidDriver<MobileElement> androidDriver;
		public static Properties AndroidCDAppAccountOR;
	    public static Properties AndroidCDAppSendMoney;
	    public static Properties AndroidCDAppWalletOR;
	    public static Properties AndroidCDApp3DSOR;
	    public static String TagNames = " ";

}
