package com.cucumber.stepdefinition;

import java.io.FileInputStream;
import java.util.*;

import com.appium.utility.Constants;
import com.appium.utility.Reusables;
import com.utility.LogCapture;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.JavascriptExecutor;

public class BaseStep {


	@Before
	public void intialization(Scenario scenario) {

		try {
			// To initialize scenario name for screenshot
			Constants.scenarioName = scenario.getName();
			Collection<String> tags = scenario.getSourceTagNames();
			for (String tag : tags) {
				String temp;
				temp = tag.replaceAll("[,]", "");
				Constants.TagNames = Constants.TagNames + temp + " | ";
			}
			LogCapture.info(Constants.TagNames);
			// Creating object ReusableFunction class
			Constants.key = new Reusables();
			Constants.DataMap = new HashMap();
			// Config properties
			System.out.println(System.getProperty("user.dir"));
			FileInputStream fs;

			fs = new FileInputStream(System.getProperty("user.dir") + "/src/Config/config.properties");
			Constants.CONFIG = new Properties();
			Constants.CONFIG.load(fs);

			// DB config properties
			fs = new FileInputStream(System.getProperty("user.dir") + "/src/Config/dbconfig.properties");
			Constants.DBCONFIG = new Properties();
			Constants.DBCONFIG.load(fs);

			// Load TestData
			fs = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/IOSTestData.properties");
			Constants.IOSTestData = new Properties();
			Constants.IOSTestData.load(fs);

			// Loading login page OR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/CDIOS/IOSLoginOR.properties");
			Constants.IOSLoginOR = new Properties();
			Constants.IOSLoginOR.load(fs);

			// Loading login page OR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/CDIOS/IOSExtAppOR.properties");
			Constants.IOSExtAppData = new Properties();
			Constants.IOSExtAppData.load(fs);

			// Loading dash board page OR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/CDIOS/IOSDashOR.properties");
			Constants.IOSDashOR = new Properties();
			Constants.IOSDashOR.load(fs);

			// Loading dash board page OR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/CDIOS/IOSRecipientOR.properties");
			Constants.IOSRecipientOR = new Properties();
			Constants.IOSRecipientOR.load(fs);

			// Loading Registration page OR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/CDIOS/IOSRegistrationOR.properties");
			Constants.IOSRegstOR = new Properties();
			Constants.IOSRegstOR.load(fs);

			// Loading Add Card,View Card OR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/CDIOS/IOSMyCardOR.properties");
			Constants.IOSMyCardOR = new Properties();
			Constants.IOSMyCardOR.load(fs);

			// Loading Add Wallet OR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/CDIOS/IOSAddWalletOR.properties");
			Constants.IOSAddWalletOR = new Properties();
			Constants.IOSAddWalletOR.load(fs);

			// Loading Send Money OR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/CDIOS/IOSSendMoneyOR.properties");
			Constants.IOSSendMoneyOR = new Properties();
			Constants.IOSSendMoneyOR.load(fs);

			// Loading Account OR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/CDIOS/IOSAccountOR.properties");
			Constants.IOSAccountOR = new Properties();
			Constants.IOSAccountOR.load(fs);

			// Loading 3DS OR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/Pages/CDIOS/IOS3DSOR.properties");
			Constants.IOS3DSOR = new Properties();
			Constants.IOS3DSOR.load(fs);

			// Writing log in log4j-test-automation.log file
			LogCapture.startLog("-------------------------Test Case Validation Started-------------------------");

			//Loading browser stack config file
			
			fs = new FileInputStream(System.getProperty("user.dir") + "/src/Config/browserstackConfig.properties");
			Constants.BrowserCONFIG = new Properties();
			Constants.BrowserCONFIG.load(fs);
			
			// ********Android baseStep************************

			// Loading login page OR
			fs = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/java/com/pages/CDAndroid/AndroidCDAppLoginOR.properties");
			Constants.AndroidCDAppLogin = new Properties();
			Constants.AndroidCDAppLogin.load(fs);

			// Loading Recipients
			fs = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/java/com/pages/CDAndroid/AndroidCDAppRecipients.properties");
			Constants.AndroidCDAppRecipient = new Properties();
			Constants.AndroidCDAppRecipient.load(fs);

			// Lodind Dashboard
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/pages/CDAndroid/AndroidDashOR.properties");
			Constants.CDAppDashboard = new Properties();
			Constants.CDAppDashboard.load(fs);

			// Loading external page OR
			fs = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/java/com/pages/CDAndroid/AndroidExternalAppOR.properties");
			Constants.AndroidExtAppData = new Properties();
			Constants.AndroidExtAppData.load(fs);

			// Load TestData
			fs = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/AndroidTestData.properties");
			Constants.AndroidTestData = new Properties();
			Constants.AndroidTestData.load(fs);

			// Loading account OR
			fs = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/java/com/pages/CDAndroid/AndroidCDAppAccountOR.properties");
			Constants.AndroidCDAppAccountOR = new Properties();
			Constants.AndroidCDAppAccountOR.load(fs);

			// Loading registration OR
			fs = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/java/com/pages/CDAndroid/AndroidCDAppRegistration.properties");
			Constants.AndroidCDAppRegistrationOR = new Properties();
			Constants.AndroidCDAppRegistrationOR.load(fs);

			// Loading send money OR
			fs = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/java/com/pages/CDAndroid/AndroidCDAppSendMoney.properties");
			Constants.AndroidCDAppSendMoney = new Properties();
			Constants.AndroidCDAppSendMoney.load(fs);

			// Loading wallet OR
			fs = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/java/com/pages/CDAndroid/AndroidCDAppWalletOR.properties");
			Constants.AndroidCDAppWalletOR = new Properties();
			Constants.AndroidCDAppWalletOR.load(fs);

			// Loading 3ds OR
			fs = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/pages/CDAndroid/AndroidCDApp3DSOR.properties");
			Constants.AndroidCDApp3DSOR = new Properties();
			Constants.AndroidCDApp3DSOR.load(fs);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to run base step : " + e.getMessage());
		}
	}

	@After
	public static void finish(Scenario scenario) {
		LogCapture.endLog("-------------------------Test Case Validation Ended--------------------");
		// To close all driver session
		String status = scenario.getStatus();
		/*if (status.equalsIgnoreCase("Failed")){
			JavascriptExecutor jse = (JavascriptExecutor)Constants.driver;
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Demo Test\"}}");
		}else if (status.equalsIgnoreCase("Passed")){
			JavascriptExecutor jse = (JavascriptExecutor)Constants.driver;
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"Passed\", \"reason\": \"Demo Test\"}}");
		}else if (status.equalsIgnoreCase("Pending")){
			JavascriptExecutor jse = (JavascriptExecutor)Constants.driver;
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Demo Test\"}}");
		}*/
		Constants.driver.quit();

	}

	// public static void writeExtentReport() {
	// Reporter.loadXMLConfig(new
	// File("/Users/automation/Desktop/AppiumWorkSpace/IOS-Mobile/extent-config.xml"));
	// }

	// public static void writeExtentReport() {
	// Reporter.loadXMLConfig(new File(Constants.key.getReportConfigPath()));
	//
	// }

}
