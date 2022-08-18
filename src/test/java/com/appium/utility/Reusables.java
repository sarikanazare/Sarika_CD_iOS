package com.appium.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.cucumber.listener.Reporter;
import com.utility.LogCapture;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import org.openqa.selenium.Dimension;
import io.appium.java_client.MobileDriver;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Reusables {

	public String emailID;

	// public String launchApp() throws Exception {
	public String launchApp(String app) throws Exception {
		try {
			String appVersion = "";
			// Writing logs in log file
			LogCapture.info("Application setup started............");
			// Checking platform for setting up desired capabilities
			if (Constants.CONFIG.getProperty("platformName").equalsIgnoreCase("Android")) { // Why
																							// PlatformName
				// Reading properties file and setting up desired capabilities
				// for android platform
				Constants.androidDc = new DesiredCapabilities();
				Constants.androidDc.setCapability("deviceName", Constants.CONFIG.getProperty("Loc_AndroidDeviceName"));
				Constants.androidDc.setCapability("udid", Constants.CONFIG.getProperty("Loc_AndroidDeviceUdId"));
				Constants.androidDc.setCapability("platformVersion",
						Constants.CONFIG.getProperty("Loc_AndroidPlatformVersion"));
				Constants.androidDc.setCapability("skipUnlock", "true");

				Constants.androidDc.setCapability("appVersion", Constants.CONFIG.getProperty("AndroidPlatformVersion"));
				Constants.androidDc.setCapability("uiautomator2ServerInstallTimeout", 800000);
				Constants.androidDc.setCapability("noReset", "false");
				Constants.appiumServerUrl = Constants.CONFIG.getProperty("appiumServerUrl");
				Constants.androidDc.setCapability("platformName", Constants.CONFIG.getProperty("platformName"));

				if (app.equalsIgnoreCase("CD")) {
					Constants.androidDc.setCapability("appActivity",
							Constants.CONFIG.getProperty("CDAndroidAppActivity:"));
					Constants.androidDc.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")
							+ "/Applications/CDAndroid/" + Constants.CONFIG.getProperty("CDAndroidAppVersion"));
					Constants.androidDc.setCapability("appPackage",
							Constants.CONFIG.getProperty("AndroidCDAppPackage"));
				} else if (app.equalsIgnoreCase("TorFX")) {
					Constants.androidDc.setCapability("appActivity",
							Constants.CONFIG.getProperty("TorFXAndroidAppActivity:"));
					Constants.androidDc.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")
							+ "/Applications/TorFxAndroid/" + Constants.CONFIG.getProperty("TorFXAndroidAppVersion"));
					Constants.androidDc.setCapability("appPackage",
							Constants.CONFIG.getProperty("AndroidTorFxPackage"));
				}

				Constants.appiumServerUrl = Constants.CONFIG.getProperty("Loc_appiumServerUrl");
				// creating android driver instance
				Constants.driver = new AndroidDriver<MobileElement>(new URL(Constants.appiumServerUrl),
						Constants.androidDc);
				// WebdriverWait implementation
				int waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("waitInSecondforAndroid")); // Why
																												// form
																												// congif
				Constants.wait = new WebDriverWait(Constants.driver, waitInSeconds);
				takeSnapShot();

			}

			else if (Constants.CONFIG.getProperty("platformName").equalsIgnoreCase("iOS")) {
				// Reading properties file and setting up desired capabilities
				// for iOS platform
				Constants.IOSDC = new DesiredCapabilities();
				Constants.IOSDC.setCapability(MobileCapabilityType.DEVICE_NAME,
						Constants.CONFIG.getProperty("Loc_IOSDeviceName"));
				Constants.IOSDC.setCapability(MobileCapabilityType.UDID,
						Constants.CONFIG.getProperty("Loc_IOSDeviceUdId"));
				Constants.IOSDC.setCapability(MobileCapabilityType.PLATFORM_NAME,
						Constants.CONFIG.getProperty("platformName"));
				Constants.IOSDC.setCapability(MobileCapabilityType.PLATFORM_VERSION,
						Constants.CONFIG.getProperty("Loc_IOSPlatformVersion"));
				Constants.IOSDC.setCapability(MobileCapabilityType.NO_RESET, false);
				Constants.IOSDC.setCapability(MobileCapabilityType.FULL_RESET, false);
				// Constants.IOSDC.setCapability(MobileCapabilityType.FULL_RESET,true);
				Constants.IOSDC.setCapability(MobileCapabilityType.AUTOMATION_NAME,
						Constants.CONFIG.getProperty("automationName"));

				Constants.IOSDC.setCapability("useNewWDA", false);
				Constants.IOSDC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 90000);
				Constants.IOSDC.setCapability("xcodeOrgId", Constants.CONFIG.getProperty("xcodeOrgId"));
				Constants.IOSDC.setCapability("xcodeSigningId", Constants.CONFIG.getProperty("xcodeSigningId"));

				// LogCapture.info("Appplication installation process
				// started.........");
				// iOS app path to install on device
				// Constants.IOSDC.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")
				// + "/Application/CDIOSApplication/Version 3.0
				// (19)/CDHApplication.app");
				if (app.equalsIgnoreCase("CD")) {
					appVersion = Constants.CONFIG.getProperty("iOSCDAppVersion");
					Constants.IOSDC.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")
							+ "/Application/CDIOSApplication/" + appVersion + "/CDHApplication.app");
					Constants.IOSDC.setCapability("bundleId", Constants.CONFIG.getProperty("CDIOSbundleId"));
				} else if (app.equalsIgnoreCase("TorFx")) {
					appVersion = Constants.CONFIG.getProperty("iOSTorFXAppVersion");
					Constants.IOSDC.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")
							+ "/Application/TorFXIOSApplication/" + appVersion + "/TorFx.app");
					Constants.IOSDC.setCapability("bundleId", Constants.CONFIG.getProperty("TorFXIOSbundleId"));
				}
				Constants.appiumServerUrl = Constants.CONFIG.getProperty("Loc_appiumServerUrl");
				Constants.driver = new IOSDriver<MobileElement>(new URL(Constants.appiumServerUrl), Constants.IOSDC);
				// Webdriver wait implementation
				Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
				Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
				takeSnapShot();

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LogCapture.info(
					"Installation or launching app process failed...Please check provided configuration details.........!!!!");
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;

	}

	// To launch existing app without resetting data -------> Reset App and
	// No_Reset capabilities not working in IOS physical devices
	public String LaunchExistingIOSApp(String app) {
		try {
			// Reading properties file and setting up desired capabilities
			// for iOS platform
			Constants.IOSDC = new DesiredCapabilities();
			Constants.IOSDC.setCapability(MobileCapabilityType.DEVICE_NAME,
					Constants.CONFIG.getProperty("Loc_IOSDeviceName"));
			Constants.IOSDC.setCapability(MobileCapabilityType.UDID, Constants.CONFIG.getProperty("Loc_IOSDeviceUdId"));
			Constants.IOSDC.setCapability(MobileCapabilityType.PLATFORM_NAME,
					Constants.CONFIG.getProperty("platformName"));
			Constants.IOSDC.setCapability(MobileCapabilityType.PLATFORM_VERSION,
					Constants.CONFIG.getProperty("Loc_IOSPlatformVersion"));
			// Constants.IOSDC.setCapability(MobileCapabilityType.NO_RESET,
			// false);
			// Constants.IOSDC.setCapability(MobileCapabilityType.FULL_RESET,
			// false);
			Constants.IOSDC.setCapability(MobileCapabilityType.AUTOMATION_NAME,
					Constants.CONFIG.getProperty("automationName"));
			Constants.IOSDC.setCapability("useNewWDA", false);
			Constants.IOSDC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 90000);
			Constants.IOSDC.setCapability("xcodeOrgId", Constants.CONFIG.getProperty("xcodeOrgId"));
			Constants.IOSDC.setCapability("xcodeSigningId", Constants.CONFIG.getProperty("xcodeSigningId"));
			Constants.IOSDC.setCapability("unicodeKeyboard", true);

			if (app.equalsIgnoreCase("CD")) {
				Constants.IOSDC.setCapability("bundleId", Constants.CONFIG.getProperty("CDIOSbundleId"));
			} else if (app.equalsIgnoreCase("TorFX")) {
				Constants.IOSDC.setCapability("bundleId", Constants.CONFIG.getProperty("TorFXIOSbundleId"));
			}

			// to create ios driver instance
			Constants.appiumServerUrl = Constants.CONFIG.getProperty("Loc_appiumServerUrl");
			Constants.driver = new IOSDriver<MobileElement>(new URL(Constants.appiumServerUrl), Constants.IOSDC);
			// Webdriver wait implementation
			Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
			Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
			takeSnapShot();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			LogCapture.info(
					"launching already instlled app process failed...Please check provided configuration details.........!!!!");
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public String LaunchExistingAndroidApp(String app) {
		try {
			// Reading properties file and setting up desired capabilities
			// for Android platform
			Constants.androidDc = new DesiredCapabilities();
			Constants.androidDc.setCapability("deviceName", Constants.CONFIG.getProperty("Loc_AndroidDeviceName"));
			Constants.androidDc.setCapability("udid", Constants.CONFIG.getProperty("Loc_AndroidDeviceUdId"));
			Constants.androidDc.setCapability("platformVersion",
					Constants.CONFIG.getProperty("Loc_AndroidPlatformVersion"));
			Constants.androidDc.setCapability("skipUnlock", "true");
			if (app.equalsIgnoreCase("CD")) {
				Constants.androidDc.setCapability("appPackage", Constants.CONFIG.getProperty("AndroidCDAppPackage"));
			} else if (app.equalsIgnoreCase("TorFX")) {
				Constants.androidDc.setCapability("appPackage", Constants.CONFIG.getProperty("AndroidTorFxPackage"));
			}
			Constants.androidDc.setCapability("appActivity", Constants.CONFIG.getProperty("CDAndroidAppActivity"));
			Constants.androidDc.setCapability("appVersion", Constants.CONFIG.getProperty("AndroidPlatformVersion"));
			Constants.androidDc.setCapability("uiautomator2ServerInstallTimeout", 1800000);
			Constants.androidDc.setCapability("unicodeKeyboard", true);
			Constants.androidDc.setCapability("noReset", "false");
			Constants.appiumServerUrl = Constants.CONFIG.getProperty("Loc_appiumServerUrl");
			Constants.androidDc.setCapability("platformName", Constants.CONFIG.getProperty("platformName"));

			Constants.appiumServerUrl = Constants.CONFIG.getProperty("Loc_appiumServerUrl");
			// creating android driver instance

			Constants.driver = new AndroidDriver<MobileElement>(new URL(Constants.appiumServerUrl),
					Constants.androidDc);
			// WebdriverWait implementation

			int waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("waitInSecondforAndroid"));
			Constants.wait = new WebDriverWait(Constants.driver, waitInSeconds);
			takeSnapShot();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LogCapture.info(
					"launching already instlled app process failed...Please check provided configuration details.........!!!!");
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// App center integration reusables
	public String getAppDownloadUrl(String app) {
		File file = new File(System.getProperty("user.dir") + "/src/Config/browserstackConfig.properties");
		try (FileInputStream in = new FileInputStream(file)) {
			String appValueGet = Constants.BrowserCONFIG.getProperty("AppDownloadUrl");
			if (appValueGet.isEmpty() || appValueGet == null) {
				Constants.BrowserCONFIG.setProperty("AppDownloadUrl", app);
			} else {
				System.out.println("iOS App Link is not changed");
			}
			FileOutputStream out = new FileOutputStream(file);
			Constants.BrowserCONFIG.store(out, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return app;
	}

	public String getAppVersion(String app) {
		File file = new File(System.getProperty("user.dir") + "/src/Config/browserstackConfig.properties");
		try (FileInputStream in = new FileInputStream(file)) {
			String appValueGet = Constants.BrowserCONFIG.getProperty("AppVersion");
			if (appValueGet.isEmpty() || appValueGet == null) {
				Constants.BrowserCONFIG.setProperty("AppVersion", app);
			} else {
				System.out.println("iOS App Version is not changed");
			}
			FileOutputStream out = new FileOutputStream(file);
			Constants.BrowserCONFIG.store(out, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return app;
	}

	public void getAPIAppLink() {
		// System.out.println("USER IN GET API METHOD IN POINT");
		String Token = Constants.CONFIG.getProperty("AppCenterAPIToken");
		String OwnerName = Constants.CONFIG.getProperty("OwnerName");
		String Name = Constants.CONFIG.getProperty("Name");

		RestAssured.baseURI = "https://api.appcenter.ms";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("X-Api-Token", Token);
		httpRequest.pathParam("owner.name", OwnerName);
		httpRequest.pathParam("name", Name);

		Response response = httpRequest.get("/v0.1/apps/{owner.name}/{name}/releases/latest");
		ResponseBody body = response.getBody();
		String bodyStringValue = body.asString();
		Assert.assertTrue(bodyStringValue.contains("download_url"));
		JsonPath jsonPathEvaluator = response.jsonPath();
		String appURL = jsonPathEvaluator.get("download_url");
		System.out.println(appURL);

		getAppDownloadUrl(appURL);
		// System.out.println("USER IS ON GET API METHOD END POINT");
	}

	public void postAPIAppVersion() {
		// System.out.println("USER IS ON POST API METHOD IN POINT");
		HashMap<String, String> map = new HashMap<String, String>();

		String appDownloadUrl = Constants.BrowserCONFIG.getProperty("AppDownloadUrl");
		map.put("url", appDownloadUrl);
		// System.out.println(appDownloadUrl);

		String Username = Constants.CONFIG.getProperty("BS_Username");
		String Password = Constants.CONFIG.getProperty("BS_AccessToken");

		RestAssured.baseURI = "https://api-cloud.browserstack.com/app-automate";
		RestAssured.basePath = "/upload";

		Response res = given().auth().preemptive().basic(Username, Password).contentType(ContentType.JSON).body(map)
				.when().post().then().statusCode(200).statusLine("HTTP/1.1 200 OK").extract().response();

		ResponseBody bodyy = res.getBody();
		String bodyStringValue = bodyy.asString();

		Assert.assertTrue(bodyStringValue.contains("app_url"));

		JsonPath jsonPathEvaluator = res.jsonPath();
		String appVersion = jsonPathEvaluator.get("app_url");
		System.out.println(appVersion);

		getAppVersion(appVersion);
		// System.out.println("USER IS ON POST API METHOD END POINT");
	}

	public String launchAppOnBrowserStack(String Platform, String app) throws Exception {
		String username = Constants.CONFIG.getProperty("BS_Username");
		String accesskey = Constants.CONFIG.getProperty("BS_AccessToken");

		try {
			// Writing logs in log file

			LogCapture.info("Application setup started on browser stack............");
			SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String DateTime = formatDateTime.format(new Date());
			SimpleDateFormat formatDayMonth = new SimpleDateFormat("dd MMMM");
			String DayMonth = formatDayMonth.format(new Date());
			SimpleDateFormat formatTimeStamp = new SimpleDateFormat("hh:mm:ss");
			String TimeStamp = formatTimeStamp.format(new Date());
			// Checking platform for setting up desired capabilities
			if (Platform.equalsIgnoreCase("Android")) {

				// Reading properties file and setting up desired capabilities
				// for iOS platform
				String AndroidDeviceName = Constants.CONFIG.getProperty("BS_AndroidDevice");
				String AndroidDeviceVersion = Constants.CONFIG.getProperty("BS_AndroidPlatformVersion");

				LogCapture.info("Opening " + app + " Application on " + Platform + " Device " + AndroidDeviceName
						+ " Version " + AndroidDeviceVersion + " ............");
				Constants.androidDc = new DesiredCapabilities();

				Constants.androidDc.setCapability("device", AndroidDeviceName);
				Constants.androidDc.setCapability("os_version", AndroidDeviceVersion);
				Constants.androidDc.setCapability("project", "CD Android");
				// Constants.androidDc.setCapability("build", "Android - "+day);
				// Constants.androidDc.setCapability("name", date + " - "+
				// Constants.TagNames);
				// Constants.IOSDC.setCapability("browserstack.debug", "true");
				// Constants.androidDc.setCapability("build", "Android -
				// "+DayMonth);
				// Constants.androidDc.setCapability("name", TimeStamp + " - "+
				// Constants.TagNames);
				Constants.androidDc.setCapability("build", DateTime);
				Constants.androidDc.setCapability("name", "CD Android");
				Constants.androidDc.setCapability("platformName", Constants.CONFIG.getProperty("platformName"));
				Constants.androidDc.setCapability("unicodeKeyboard", true);
				Constants.androidDc.setCapability("noReset", true);

				if (app.equalsIgnoreCase("CD")) {
					// Browserstack app path
					LogCapture.info("Installing " + app + " Application............");
					Constants.androidDc.setCapability(MobileCapabilityType.APP,
							"bs://" + Constants.CONFIG.getProperty("BS_AndroidCDAppVersion"));
				} else if (app.equalsIgnoreCase("TorFX")) {
					LogCapture.info("Installing " + app + " Application............");
					Constants.androidDc.setCapability(MobileCapabilityType.APP,
							"bs://" + Constants.CONFIG.getProperty("BS_AndroidTorFXAppVersion"));
				}
				Constants.driver = new AndroidDriver<MobileElement>(
						new URL("https://" + username + ":" + accesskey + "@hub-cloud.browserstack.com/wd/hub"),
						Constants.androidDc);
				// Webdriver wait implementation
				Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
				Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
				takeSnapShot();
			}

			else if (Platform.equalsIgnoreCase("iOS")) {
				// Reading properties file and setting up desired capabilities
				// for iOS platform

				String iOSDeviceName = Constants.CONFIG.getProperty("BS_iOSDevice");
				String iOSDeviceVersion = Constants.CONFIG.getProperty("BS_iOSPlatformVersion");
				LogCapture.info("Opening " + app + " Application on " + Platform + " Device " + iOSDeviceName
						+ " Version " + iOSDeviceVersion + " ............");
				Constants.IOSDC = new DesiredCapabilities();
				Constants.IOSDC.setCapability("device", iOSDeviceName);
				Constants.IOSDC.setCapability("os_version", iOSDeviceVersion);
				Constants.IOSDC.setCapability("project", "CD iOS");
				// Constants.IOSDC.setCapability("build", "iOS - "+day);
				// Constants.IOSDC.setCapability("name", date + " - "+
				// Constants.TagNames);
				// Constants.IOSDC.setCapability("browserstack.debug", "true");
				Constants.IOSDC.setCapability("build", "iOS _" + DayMonth);
				// Constants.androidDc.setCapability("name", TimeStamp + " - "+
				// Constants.TagNames);
				// Constants.IOSDC.setCapability("build", DateTime);
				Constants.IOSDC.setCapability("name", "CD iOS");
				if (app.equalsIgnoreCase("CD")) {
					// Browserstack app path
					// Constants.IOSDC.setCapability(MobileCapabilityType.APP,
					// Constants.BrowserCONFIG.getProperty("AppVersion"));
					LogCapture.info("Installing " + app + " Application............");
					Constants.IOSDC.setCapability(MobileCapabilityType.APP,
							"bs://" + Constants.CONFIG.getProperty("BS_iOSCDAppVersion"));

				} else if (app.equalsIgnoreCase("TorFX")) {
					LogCapture.info("Installing " + app + " Application............");
					Constants.IOSDC.setCapability(MobileCapabilityType.APP,
							"bs://" + Constants.CONFIG.getProperty("BS_iOSTorFXAppVersion"));
				}
				Constants.driver = new IOSDriver<MobileElement>(
						new URL("https://" + username + ":" + accesskey + "@hub-cloud.browserstack.com/wd/hub"),
						Constants.IOSDC);
				// Webdriver wait implementation
				Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
				Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
				takeSnapShot();

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LogCapture.info(
					"Installation or launching app process failed...Please check provided configuration details.........!!!!");
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;

	}

	public String launchExistingAppOnBrowserStack() throws Exception {

		try {

			Constants.driver.closeApp();

			Constants.driver.launchApp();

		} catch (Exception e) {

			System.out.println(e.getMessage());

			LogCapture.info(

					"Installation or launching app process failed...Please check provided configuration details.........!!!!");

			return Constants.KEYWORD_FAIL;

		}

		return Constants.KEYWORD_PASS;

	}

	public String launchExistingAppOnBrowserStackAndroid() throws Exception {
		try {
			Constants.driver.closeApp();
			Constants.driver.launchApp();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LogCapture.info(
					"Installation or launching app process failed...Please check provided configuration details.........!!!!");
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// Method to write input
	public String writeInInput(String objectPath, String data) throws Exception {
		try {
			// Assert.assertEquals(Constants.KEYWORD_PASS,
			// eleLocatedDisplayed(objectPath));
			// Constants.driver.findElement(By.xpath(objectPath)).clear();
			Constants.driver.findElement(By.xpath(objectPath)).sendKeys(data);
			takeSnapShot();
		} catch (Exception e) {
			System.out.println("Unable to write " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// Method to clear input data
	public String clearData(String objectPath) throws Exception {
		try {
			Assert.assertEquals(Constants.KEYWORD_PASS, eleLocatedDisplayed(objectPath));
			Constants.driver.findElement(By.xpath(objectPath)).clear();
		} catch (Exception e) {
			// System.out.println("Unable to write " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// Method to click on element
	public String click(String objectPath) throws Exception {
		try {
			Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectPath)));
			// Constants.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objectPath)));
			Constants.driver.findElement(By.xpath(objectPath)).click();
			takeSnapShot();
		} catch (Exception e) {
			takeSnapShot();
			System.out.println("Unable to click : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// Click method without visibility check
	// Below code commented because for some element visible property is false
	// and
	// enabled property is true
	public String clickWithoutVisibilityChk(String objectPath) throws Exception {
		try {
			// Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectPath)));
			// Constants.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objectPath)));
			Constants.driver.findElement(By.xpath(objectPath)).click();
			takeSnapShot();
		} catch (Exception e) {
			takeSnapShot();
			System.out.println("Unable to click : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public String jsClick(String objectPath) throws Exception {
		try {

			MobileElement ele = Constants.driver.findElement(By.xpath("//*[@label=\"Remove account\"]"));
			// MobileElement ele=
			// Constants.driver.findElement(By.xpath(objectPath));
			JavascriptExecutor executor = (JavascriptExecutor) Constants.driver;
			executor.executeScript("arguments[0].click();", ele);
			takeSnapShot();
		} catch (Exception e) {
			takeSnapShot();
			System.out.println("Unable to click : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// Method to check element located and displayed on device
	public String eleLocatedDisplayed(String objectPath) throws Exception {
		try {
			Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectPath)));
			Constants.driver.findElement(By.xpath(objectPath)).isDisplayed();
			takeSnapShot();
		} catch (Exception e) {
			System.out.println("Unable to locate : " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// Method to take screenshot
	public static void takeSnapShot() throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String dateString = format.format(new Date());
		String vScenarioN = Constants.scenarioName;
		String fileWithPath = System.getProperty("user.dir") + "/Screenshot/" + "_" + vScenarioN + "_" + dateString
				+ ".png";
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) Constants.driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		Reporter.addScreenCaptureFromPath(fileWithPath);
	}

	// To read attribute value
	public String getAttributeValue(String objectPath, String attributeName) throws Exception {
		String attributeValue;
		try {
			attributeValue = Constants.driver.findElement(By.xpath(objectPath)).getAttribute(attributeName);
			if (attributeValue.isEmpty()) {
				return Constants.KEYWORD_FAIL;
			}
			return attributeValue;
		} catch (Exception e) {
			// System.out.println("Unable to get attribute value " +
			// e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
	}

	// To read the text of element
	public String readText(String objectPath) throws Exception {
		try {
			Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectPath)));
			String textValue = Constants.driver.findElement(By.xpath(objectPath)).getText();
			takeSnapShot();
			return textValue;
		} catch (Exception e) {
			System.out.println("Unable to read text " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
	}

	// To Read current activity and package
	public String setCurrentActivityPackage() {
		if (Constants.androidDc.getCapability("platformName").toString().equalsIgnoreCase("Android")) {
			try {
				Constants.appActivityName = ((AndroidDriver<MobileElement>) Constants.driver).currentActivity();
				Constants.appPackageName = ((AndroidDriver<MobileElement>) Constants.driver).getCurrentPackage();
				LogCapture.info("Application activity and package name read successfully....");
			} catch (Exception e) {
				LogCapture.info("Error while reading activity and package name....");
				return Constants.KEYWORD_FAIL;
			}
		}
		return Constants.KEYWORD_PASS;
	}

	// To switch on application bundle id/package
	public String switchApp(String packageName) {
		try {
			Constants.driver.activateApp(packageName);
			takeSnapShot();
			LogCapture.info("User switched on application : " + packageName);
		} catch (Exception e) {
			LogCapture.info("Error while switching pakage : " + packageName + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// Switch wifi and data connection off

	public String setConnectionToOff(String platform) {
		String wifiStatus;
		// String mobileSim;
		// String mobileDataStatus;
		if (platform.equalsIgnoreCase("Android")) {
			AndroidDriver<MobileElement> aDriver = (AndroidDriver<MobileElement>) Constants.driver;
			try {
				aDriver.setConnection(new ConnectionStateBuilder().withDataDisabled().withWiFiDisabled().build());
				LogCapture.info("Switching off the connection: " + aDriver.getConnection());
			} catch (Exception e) {
				LogCapture.info("Connection could not be switch off");
				return Constants.KEYWORD_FAIL;
			}
		} else if (platform.equalsIgnoreCase("IOS")) {

			try {
				String iphoneSettingbundleId = Constants.IOSExtAppData.getProperty("iphoneSettingBundleId");
				switchApp(iphoneSettingbundleId);
				wifiStatus = getAttributeValue(Constants.IOSExtAppData.getProperty("WifiSwitch"), "value");
				if (wifiStatus.equalsIgnoreCase("Fail")) {
					Constants.key.click(Constants.IOSExtAppData.getProperty("WifiSettingOpt"));
					wifiStatus = getAttributeValue(Constants.IOSExtAppData.getProperty("WifiSwitch"), "value");
				}
				if (wifiStatus.equalsIgnoreCase("0")) {
					System.out.println("Wifi switch off");
				} else if (wifiStatus.equalsIgnoreCase("1")) {
					click(Constants.IOSExtAppData.getProperty("WifiSwitch"));
				}
				// Constants.driver.resetApp();
				switchApp(Constants.CONFIG.getProperty("IOSbundleId"));
			} catch (Exception e) {
				return Constants.KEYWORD_FAIL;
			}
		}

		/*
		 * mobileSim =getAttribute("//XCUIElementTypeCell[@name='Mobile Data']",
		 * "value");
		 * 
		 * if(mobileSim.equalsIgnoreCase("No SIM")){ System.out.
		 * println("SIM Card not inserted...Unable to on mobile data...!!!!"); }
		 * 
		 * else if(mobileSim.equalsIgnoreCase("SIM")){ //Code not implemented
		 * for mobile data connection }
		 */

		return Constants.KEYWORD_PASS;

	}

	// To switch on/off wi-fi and mobile data connection

	public String setConnectionToOn(String platform) throws Exception {
		String wifiStatus;
		// String mobileSim;
		// String mobileDataStatus;
		if (platform.equalsIgnoreCase("Android")) {
			AndroidDriver<MobileElement> aDriver = (AndroidDriver<MobileElement>) Constants.driver;
			try {
				aDriver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
				LogCapture.info("Switching on the connection: " + aDriver.getConnection());

			} catch (Exception e) {
				LogCapture.info("Connection could not be switch on");
				return Constants.KEYWORD_FAIL;
			}
		}

		if (platform.equalsIgnoreCase("IOS")) {

			String iphoneSettingbundleId = Constants.IOSExtAppData.getProperty("iphoneSettingBundleId");
			switchApp(iphoneSettingbundleId);
			wifiStatus = getAttributeValue(Constants.IOSExtAppData.getProperty("WifiSwitch"), "value");
			if (wifiStatus.equalsIgnoreCase("Fail")) {
				Constants.key.click(Constants.IOSExtAppData.getProperty("WifiSettingOpt"));
				wifiStatus = getAttributeValue(Constants.IOSExtAppData.getProperty("WifiSwitch"), "value");
			}
			if (wifiStatus.equalsIgnoreCase("0")) {
				Constants.key.click(Constants.IOSExtAppData.getProperty("WifiSwitch"));
				// Swipe("//XCUIElementTypeStaticText[@name='Wi-Fi']",
				// "right",1);
			} else if (wifiStatus.equalsIgnoreCase("1")) {
				System.out.println("Wifi switch on");
				// Swipe("//XCUIElementTypeStaticText[@name='Wi-Fi']",
				// "right",1);
			}
			Constants.driver.resetApp();
			switchApp((Constants.CONFIG.getProperty("bundleId")));
		}
		/*
		 * mobileSim =getAttribute("//XCUIElementTypeCell[@name='Mobile Data']",
		 * "value");
		 * 
		 * if(mobileSim.equalsIgnoreCase("No SIM")){ System.out.
		 * println("SIM Card not inserted...Unable to on mobile data...!!!!"); }
		 * 
		 * else if(mobileSim.equalsIgnoreCase("SIM")){ //Code not implemented
		 * for mobile data connection }
		 */
		return Constants.KEYWORD_PASS;
	}

	// To swipe left/right/up/down
	public String Swipe(String vObjEle, String direction, int count) {

		try {
			for (int i = 0; i < count; i++) {
				JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("direction", direction);
				MobileElement element = Constants.driver.findElement(By.xpath(vObjEle));
				params.put("element", element);
				js.executeScript("mobile: swipe", params);
				// System.out.println("Swipe_" + direction + "_" + (i + 1));
				takeSnapShot();
			}
		} catch (Exception e) {
			System.out.println("Unable to swipe :" + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// To compare two strings
	public String VerifyText(String value1, String value2) throws Exception {
		if (value1 != null && value2 != null) {
			if (value1.trim().equalsIgnoreCase(value2.trim())) {
				takeSnapShot();
				return Constants.KEYWORD_PASS;
			} else {
				System.out.println("Value1 :" + value1 + " doesnot match with Value2 :" + value2);
				takeSnapShot();
				return Constants.KEYWORD_FAIL;
			}
		} else {
			System.out.println("Unable to compare....");
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
	}

	// To clear input text
	public String clearText(String vObjEle) {
		try {
			Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(vObjEle)));
			Constants.driver.findElement(By.xpath(vObjEle)).clear();
		} catch (Exception e) {
			System.out.println("Unable to clear : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// To close app
	public String closeApp() {
		try {
			Constants.driver.closeApp();
		} catch (Exception e) {
			System.out.println("Unable to close : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// To re-initialize web driver wait
	public String reInitializeWebDriverWait(int data) {
		try {

			Constants.wait = new WebDriverWait(Constants.driver, data);
		} catch (Exception e) {
			System.out.println("Unable to re-intialize wait : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public List<MobileElement> getElementList(String vObjEle) {
		List<MobileElement> elementList = Constants.driver.findElements(By.xpath(vObjEle));
		return elementList;
	}

	public String scrollInIOS(String eleText, String direction) throws Exception {
		try {
			MobileElement element = (MobileElement) Constants.driver.findElement(By.className("XCUIElementTypeTable"));
			String elementID = element.getId();
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put(eleText, elementID); // Only for ‘scroll in
													// element’
			scrollObject.put("direction", direction);
			((JavascriptExecutor) Constants.driver).executeScript("mobile:scroll", scrollObject);
			return Constants.KEYWORD_PASS;
		} catch (Exception e) {
			System.out.println("Unable to locate : " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
	}

	public String scrollInIOS1(String eleText, String direction) throws Exception {
		try {
			MobileElement element = (MobileElement) Constants.driver
					.findElement(By.className("XCUIElementTypeStaticText"));
			String elementID = element.getId();
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("terms and conditions", elementID); // Only for
																	// ‘scroll
																	// in
																	// element’
			// scrollObject.put("direction", direction);
			((JavascriptExecutor) Constants.driver).executeScript("mobile:tap", scrollObject);
			return Constants.KEYWORD_PASS;
		} catch (Exception e) {
			System.out.println("Unable to locate : " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
	}

	public String getOTP(String object, String data) throws Exception {
		// For connection
		Connection connection = null;
		// For Statement object
		PreparedStatement ps;
		String DB_URL = null;
		// For Database Username
		String DB_USER = null;
		// For Database Password
		String DB_PASSWORD = null;
		String query = null;
		// To store OTP
		String OTP = null;
		if (object.equalsIgnoreCase("SIT")) {
			DB_URL = "jdbc:sqlserver://" + Constants.DBCONFIG.getProperty("SITDB_URL") + ":"
					+ Constants.DBCONFIG.getProperty("SITDB_PORT");
			DB_USER = Constants.DBCONFIG.getProperty("SITDB_User");
			DB_PASSWORD = Constants.DBCONFIG.getProperty("SITDB_Password");
			// Statement object to send the SQL statement to the Database
			query = "SELECT TOP  1 Pin FROM [NGOP-SIT].dbo.CustomerPin  where Email =? ORDER by CreatedOn  DESC";
			// "jdbc:sqlserver://172.31.4.93:1433
		} else if (object.equalsIgnoreCase("UAT")) {
			DB_URL = "jdbc:sqlserver://" + Constants.DBCONFIG.getProperty("UATDB_URL") + ":"
					+ Constants.DBCONFIG.getProperty("UATDB_PORT");
			DB_USER = Constants.DBCONFIG.getProperty("UATDB_User");
			DB_PASSWORD = Constants.DBCONFIG.getProperty("UATDB_Password");
			// Statement object to send the SQL statement to the Database
			query = "SELECT TOP  1 Pin FROM [ngop].dbo.CustomerPin  where Email =? ORDER by CreatedOn  DESC";
		}
		try {
			String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(dbClass).newInstance();
			// Get connection to DB
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			ps = connection.prepareStatement(query);
			ps.setNString(1, data);
			ResultSet res = ps.executeQuery();
			// Get the contents of CustomerPin table from DB
			while (res.next()) {
				OTP = res.getString("Pin");
				break;
				// System.out.println("OTP :" + OTP);
			}
			return OTP;
		} catch (Exception e) {
			System.out.println("Unable to fetch OTP from Database : " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		} finally {
			// Close DB connection
			if (connection != null) {
				connection.close();
			}
		}
	}

	public String AppBackground(Duration duration) {
		try {
			Constants.driver.runAppInBackground(duration);

		} catch (Exception e) {
			System.out.println("App is not in background : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public static String getAlphaNumericString(int n) {
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n); // create StringBuffer size of
													// AlphaNumericString

		for (int i = 0; i < n; i++) {
			// generate a random number between 0 to AlphaNumericString variable
			// length
			int index = (int) (AlphaNumericString.length() * Math.random());

			sb.append(AlphaNumericString.charAt(index)); // add Character one by
															// one in end of sb
		}
		return sb.toString();
	}

	public static String generateEmail(int length, String domain) {
		return getAlphaNumericString(length) + "@" + domain;
	}

	public String KeyboardAction(String object, String data) throws Exception {
		try {
			if (data.equalsIgnoreCase("enter")) {
				Constants.driver.findElement(By.xpath(object)).sendKeys(Keys.ENTER);
				takeSnapShot();
			} else if (data.equalsIgnoreCase("tab")) {
				Constants.driver.findElement(By.xpath(object)).sendKeys(Keys.TAB);
				takeSnapShot();
			} else if (data.equalsIgnoreCase("space")) {
				Constants.driver.findElement(By.xpath(object)).sendKeys(Keys.SPACE);
				takeSnapShot();
			} else if (data.equalsIgnoreCase("downArrow")) {
				Constants.driver.findElement(By.xpath(object)).sendKeys(Keys.ARROW_DOWN);
				takeSnapShot();
			} else if (data.equalsIgnoreCase("selectall")) {
				Constants.driver.findElement(By.xpath(object)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				takeSnapShot();
			}
			return Constants.KEYWORD_PASS;
		} catch (Exception e) {
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}

	}

	// *****************Android Missing Reusables***********************

	// Reading current device platform version to identify whether appium
	// supports
	// or not
	public String verifyPlatformVersion() {

		String platformVersion = null;
		if (Constants.CONFIG.getProperty("platformName").equalsIgnoreCase("Android")) {
			AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) Constants.driver;
			platformVersion = driver.getCapabilities().getCapability("AndroidPlatformVersion").toString();
			int version = 0;
			if (platformVersion != null)
				version = Integer.parseInt(platformVersion.split(".")[0]);
			if (version <= 5)
				return Constants.KEYWORD_FAIL;
		}

		else if (Constants.CONFIG.getProperty("platformName").equalsIgnoreCase("IOS")) {
			IOSDriver<MobileElement> driver = (IOSDriver<MobileElement>) Constants.driver;
			platformVersion = driver.getCapabilities().getCapability("AndroidPlatformVersion").toString();
			// IOS code not implemented will implement when testing started on
			// IOS
		}
		return Constants.KEYWORD_PASS;
	}

	public String getAppVersion() {
		String appVersion = null;
		if (Constants.CONFIG.getProperty("platformName").equalsIgnoreCase("Android")) {
			AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) Constants.driver;
			appVersion = driver.getCapabilities().getCapability("AndroidAppVersion").toString();
		}

		else if (Constants.CONFIG.getProperty("platformName").equalsIgnoreCase("IOS")) {
			IOSDriver<MobileElement> driver = (IOSDriver<MobileElement>) Constants.driver;
			appVersion = driver.getCapabilities().getCapability("AndroidAppVersion").toString();
		}
		return appVersion;
	}

	public String click(MobileElement element) throws Exception {
		try {
			element.click();
			takeSnapShot();
		} catch (Exception e) {
			takeSnapShot();
			System.out.println("Unable to click : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// Need to check for Android
	// To check element is clickable
	public String elementClickable(String objectPath) {

		try {
			Constants.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objectPath)));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Not able to click on : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// To check element is active or not
	public String isElementActive(String objectPath) throws Exception {

		try {
			Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectPath)));
			Constants.driver.findElement(By.xpath(objectPath)).isEnabled();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element is inactive : " + e.getMessage());
			takeSnapShot();

			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public String isElementPresent(String objectPath, int waitInSeconds) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(Constants.driver, waitInSeconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectPath)));
			Constants.driver.findElement(By.xpath(objectPath));

		} catch (Exception e) {
			System.out.println("Element is not Present ");
			takeSnapShot();

			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public String swipeHorizontal(int startPercentage, int finalPercentage, int anchorPercentage) {
		try {
			Dimension size = Constants.driver.manage().window().getSize();
			int anchor = (size.height * anchorPercentage) / 100;
			int startPoint = (size.width * startPercentage) / 100;
			int endPoint = (size.width * finalPercentage) / 100;
			scroll(startPoint, anchor, endPoint, anchor);
			LogCapture.info("Able to swap Horizonatlly....");
		} catch (Exception e) {
			LogCapture.info("Unable to swipe horizontally");
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public String swipeVertical(int startPercentage, int finalPercentage, int anchorPercentage) {
		try {
			Dimension size = Constants.driver.manage().window().getSize();
			int anchor = (size.width * anchorPercentage) / 100;
			int startPoint = (size.height * startPercentage) / 100;
			int endPoint = (size.height * finalPercentage) / 100;
			scroll(anchor, startPoint, anchor, endPoint);
		} catch (Exception e) {
			LogCapture.info("Unable to swipe verticallys");
			return Constants.KEYWORD_FAIL;
		}

		return Constants.KEYWORD_PASS;
	}

	private void scroll(int startX, int startY, int endX, int endY) {
		new TouchAction((MobileDriver) Constants.driver).press(point(startX, startY))
				.waitAction(waitOptions(ofMillis(1000))).moveTo(point(endX, endY)).release().perform();
	}

	public String activateAppWithoutReset(String packageName) {

		try {
			Constants.driver.closeApp();
			Constants.driver.activateApp(Constants.CONFIG.getProperty("AndroidCDAppPackage"));

		} catch (Exception e) {
			System.out.println("Unable to close and activate app : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}

		return Constants.KEYWORD_PASS;
	}

	// To check future maintenance and close popup window
	public void checkCloseFutMaintWindow() throws Exception {

		String CloseFutureMainBtn = Constants.AndroidCDAppLogin.getProperty("CloseFutMaiBtn");
		String result = Constants.key.click(CloseFutureMainBtn);
		if (result.equalsIgnoreCase("PASS")) {
			LogCapture.info("Future maintenancece scheduled window found and closed successfully.......");
		} else if (result.equalsIgnoreCase("FAIL")) {
			LogCapture.info("No future maintenance scheduled found.......");
			takeSnapShot();
		}
	}

	public String VerifyTextContains(String value1, String value2) {
		if (value1 != null && value2 != null) {
			if (value1.toLowerCase().contains(value2.toLowerCase())) {
				return Constants.KEYWORD_PASS;
			} else {
				System.out.println("Value1 : " + value1 + " doesnot match with Value2 : " + value2);
				return Constants.KEYWORD_FAIL;
			}
		} else {
			System.out.println(value1 + "- not contains - " + value2);
			return Constants.KEYWORD_FAIL;
		}

	}

	public String selectList(String object, String data) throws Exception {
		try {
			int attempt = 0;
			Select objSelect = new Select(Constants.driver.findElement(By.xpath(object)));
			if (!data.equals(Constants.RANDOM_VALUE)) {
				objSelect.selectByVisibleText(data);
				takeSnapShot();
			} else {
				WebElement droplist = Constants.driver.findElement(By.xpath(object));
				List<WebElement> droplist_contents = droplist.findElements(By.tagName("option"));
				Random num = new Random();
				int index = num.nextInt(droplist_contents.size());
				String selectedVal = droplist_contents.get(index).getText();
				objSelect.selectByVisibleText(selectedVal);
				takeSnapShot();
			}

		} catch (Exception e) {
			takeSnapShot();
			return Constants.KEYWORD_FAIL + "---Could not select from the List---" + e.getMessage();

		}
		return Constants.KEYWORD_PASS;
	}

	public String scrollDownUI(String eleText) throws Exception {
		try {
			Constants.androidDriver = ((AndroidDriver<MobileElement>) Constants.driver);
			Constants.androidDriver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ eleText + "\").instance(0))");

		} catch (Exception e) {
			System.out.println("Unable to locate : " + e.getMessage());
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public String notexist(String object, String data) throws Exception {
		try {
			Constants.driver.findElement(By.xpath(object));
			takeSnapShot();
		} catch (Exception e) {
			takeSnapShot();
			return Constants.KEYWORD_PASS;
		}
		return Constants.KEYWORD_FAIL + "object exist ";
	}

	public String scrollToExactElement(String str) throws Exception {
		try {
			Thread.sleep(5000);

			((AndroidDriver<MobileElement>) Constants.driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
							+ str + "\").instance(0))")
					.click();
		} catch (Exception e) {
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public String reInitializeWebDriverWait() {
		try {
			Constants.modifyWaitInSeconds = Integer
					.parseInt(Constants.CONFIG.getProperty("ModifyWaitInSecondsForAndroid"));
			Constants.wait = new WebDriverWait(Constants.driver, Constants.modifyWaitInSeconds);
		} catch (Exception e) {
			System.out.println("Unable to re-intialize wait : " + e.getMessage());
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public String pause(String object, String data) throws NumberFormatException, InterruptedException {
		long time = (long) Double.parseDouble(object);
		Thread.sleep(time * 1000L);
		return Constants.KEYWORD_PASS;

	}

	public String uniqueEmailAddress() throws Exception {
		try {
			String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);
			emailID = "xyz" + userName + "@gmail.com";
			LogCapture.info("emailID is " + ": " + emailID);
		} catch (Exception e) {
			takeSnapShot();
			return Constants.KEYWORD_FAIL;
		}
		return emailID;
	}
	// ************** Reusable for jenkins ************

	public String launchAppANDROIDBrowserstack(String bDevice, String bVersion) throws Exception {
		String username = Constants.CONFIG.getProperty("BS_Username");
		String accesskey = Constants.CONFIG.getProperty("BS_AccessToken");

		try {
			LogCapture.info("Android Application setup started on browser stack............");
			SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String DateTime = formatDateTime.format(new Date());
			SimpleDateFormat formatDayMonth = new SimpleDateFormat("dd MMMM");
			String DayMonth = formatDayMonth.format(new Date());
			SimpleDateFormat formatTimeStamp = new SimpleDateFormat("hh:mm:ss");
			String TimeStamp = formatTimeStamp.format(new Date());
			if (Constants.CONFIG.getProperty("platformNameAndroid").equalsIgnoreCase("Android")) {
				// String AndroidDeviceName =
				// Constants.CONFIG.getProperty("BS_AndroidDevice");
				// String AndroidDeviceVersion =
				// Constants.CONFIG.getProperty("BS_AndroidPlatformVersion");
				// LogCapture.info("Opening "+app+" Application on "+Platform+"
				// Device "+AndroidDeviceName+" Version "+AndroidDeviceVersion+"
				// ............");
				Constants.androidDc = new DesiredCapabilities();
				Constants.androidDc.setCapability("device", bDevice);
				Constants.androidDc.setCapability("os_version", bVersion);
				Constants.androidDc.setCapability("project", "CD Android");
				Constants.androidDc.setCapability("build", DateTime);
				Constants.androidDc.setCapability("name", "CD Android");
				Constants.androidDc.setCapability("unicodeKeyboard", true);
				Constants.androidDc.setCapability("noReset", true);
				// Taking app name from config . Early we pass it from stepdef
				String app = Constants.CONFIG.getProperty("CDApp");
				if (app.equalsIgnoreCase("CD")) {
					// Browserstack app path
					LogCapture.info("Installing " + app + " Application............");
					Constants.androidDc.setCapability(MobileCapabilityType.APP,
							"bs://" + Constants.CONFIG.getProperty("BS_AndroidCDAppVersion"));
				} else if (app.equalsIgnoreCase("TorFX")) {
					LogCapture.info("Installing " + app + " Application............");
					Constants.androidDc.setCapability(MobileCapabilityType.APP,
							"bs://" + Constants.CONFIG.getProperty("BS_AndroidTorFXAppVersion"));
				}
				Constants.driver = new AndroidDriver<MobileElement>(
						new URL("https://" + username + ":" + accesskey + "@hub-cloud.browserstack.com/wd/hub"),
						Constants.androidDc);
				Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
				Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
				takeSnapShot();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LogCapture.info(
					"Installation or launching app process failed...Please check provided configuration details.........!!!!");
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	public String launchAppIOSBrowserstack(String bDevice, String bVersion) throws Exception {
		String username = Constants.CONFIG.getProperty("BS_Username");
		String accesskey = Constants.CONFIG.getProperty("BS_AccessToken");
		try {
			SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String DateTime = formatDateTime.format(new Date());
			SimpleDateFormat formatDayMonth = new SimpleDateFormat("dd MMMM");
			String DayMonth = formatDayMonth.format(new Date());
			SimpleDateFormat formatTimeStamp = new SimpleDateFormat("hh:mm:ss");
			String TimeStamp = formatTimeStamp.format(new Date());
			if (Constants.CONFIG.getProperty("platformNameIOS").equalsIgnoreCase("iOS")) {
				String app = Constants.CONFIG.getProperty("CDApp");
				// String iOSDeviceName =
				// Constants.CONFIG.getProperty("BS_iOSDevice");
				// String iOSDeviceVersion =
				// Constants.CONFIG.getProperty("BS_iOSPlatformVersion");
				// LogCapture.info("Opening " + app + " Application on " +
				// Platform + " Device " + iOSDeviceName
				// + " Version " + iOSDeviceVersion + " ............");
				Constants.IOSDC = new DesiredCapabilities();
				Constants.IOSDC.setCapability("device", bDevice);
				Constants.IOSDC.setCapability("os_version", bVersion);
				Constants.IOSDC.setCapability("project", "CD iOS");
				// Constants.TagNames);
				// Constants.IOSDC.setCapability("browserstack.debug", "true");
				// Constants.IOSDC.setCapability("build", "iOS _" + DayMonth);
				// Constants.androidDc.setCapability("name", TimeStamp + " - "+
				// Constants.TagNames);
				Constants.IOSDC.setCapability("build", DateTime);
				Constants.IOSDC.setCapability("name", "CD iOS");

				if (app.equalsIgnoreCase("CD")) {
					// Browserstack app path
					// Constants.IOSDC.setCapability(MobileCapabilityType.APP,
					// Constants.BrowserCONFIG.getProperty("AppVersion"));
					LogCapture.info("Installing " + app + " Application............");
					Constants.IOSDC.setCapability(MobileCapabilityType.APP,
							"bs://" + Constants.CONFIG.getProperty("BS_iOSCDAppVersion"));

				} else if (app.equalsIgnoreCase("TorFX")) {
					LogCapture.info("Installing " + app + " Application............");
					Constants.IOSDC.setCapability(MobileCapabilityType.APP,
							"bs://" + Constants.CONFIG.getProperty("BS_iOSTorFXAppVersion"));
				}
				Constants.driver = new IOSDriver<MobileElement>(
						new URL("https://" + username + ":" + accesskey + "@hub-cloud.browserstack.com/wd/hub"),
						Constants.IOSDC);
				// Webdriver wait implementation
				Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
				Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
				takeSnapShot();

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LogCapture.info(
					"Installation or launching app process failed...Please check provided configuration details.........!!!!");
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;
	}

	// Same method like existing android launch app on local device
	public String launchAppUsingDeviceId(String device) throws Exception {
		try {
			// Writing logs in log file
			LogCapture.info("Application setup started............");
			// Checking platform for setting up desired capabilities
			if (Constants.CONFIG.getProperty("platformNameAndroid").equalsIgnoreCase("Android")) {
				// Reading properties file and setting up desired capabilities
				// for android platform
				Constants.androidDc = new DesiredCapabilities();
				// Constants.AndroidDC.setCapability(MobileCapabilityType.DEVICE_NAME,Constants.CONFIG.getProperty("deviceName"));
				Constants.androidDc.setCapability(MobileCapabilityType.UDID, device);
				Constants.androidDc.setCapability(MobileCapabilityType.PLATFORM_VERSION,
						Constants.CONFIG.getProperty("platformVersion"));
				Constants.androidDc.setCapability("skipUnlock", "true");
				Constants.androidDc.setCapability("appPackage", Constants.CONFIG.getProperty("appPackage"));
				Constants.androidDc.setCapability("appActivity", Constants.CONFIG.getProperty("appActivity"));
				Constants.androidDc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 90000);
				Constants.androidDc.setCapability(MobileCapabilityType.NO_RESET, "false");
				Constants.appiumServerUrl = Constants.CONFIG.getProperty("appiumServerUrl");

				// creating android driver instance
				Constants.driver = new AndroidDriver<MobileElement>(new URL(Constants.appiumServerUrl),
						Constants.androidDc);
				// WebdriverWait implementation
				int waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("waitInSeconds"));
				System.out.println(waitInSeconds);
				Constants.wait = new WebDriverWait(Constants.driver, waitInSeconds);
				takeSnapShot();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LogCapture.info(
					"Installation or launching app process failed...Please check provided configuration details.........!!!!");
			return Constants.KEYWORD_FAIL;
		}
		return Constants.KEYWORD_PASS;

	}

}
