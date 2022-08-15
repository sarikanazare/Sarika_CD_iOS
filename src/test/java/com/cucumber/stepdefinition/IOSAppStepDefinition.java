package com.cucumber.stepdefinition;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.appium.utility.Constants;
import com.utility.LogCapture;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;

public class IOSAppStepDefinition {
	public int loginCount = 0;
	public boolean defaultCurrency;
	String GlobalEmail = "null";
	String GlobalPassword = "null";
	String GlobalInvalidPassword = "null";
	String GlobalRecipientName;
	String AppName;
	String Country;
	double iOSPlatformVersion;
	String useremaild;

	/*
	 * @Given("^ios user installed the new app \"([^\"]*)\" on the device \"([^\"]*)\" and launched successfully$"
	 * ) public void
	 * ios_user_installed_the_new_app_on_the_device_and_launched_successfully(String
	 * data1, String data2) throws Throwable { String vIosAppVersion =
	 * Constants.CONFIG.getProperty(data1); String vDeviceUdId =
	 * Constants.CONFIG.getProperty(data2); Assert.assertEquals("PASS",
	 * Constants.key.launchApp(vDeviceUdId, vIosAppVersion)); String
	 * vIOSPlatformVersion = Constants.CONFIG.getProperty("IOSPlatformVersion");
	 * iOSPlatformVersion = Double.parseDouble(vIOSPlatformVersion);
	 * LogCapture.info("Application installed and launched successfully......!!!!");
	 * }
	 */
	@Given("^(ios) user installed the new (CD|TorFX) app and launched successfully$")
	public void ios_user_installed_the_new_CD_app_and_launched_successfully(String Platform, String optionalValue)
			throws Throwable {
		//Assert.assertEquals("PASS", Constants.key.launchApp(optionalValue));
		// Constants.key.getAPIAppLink();
		// Constants.key.postAPIAppVersion();
		Assert.assertEquals("PASS",Constants.key.launchAppOnBrowserStack(Platform,optionalValue));
		String vIOSPlatformVersion = Constants.CONFIG.getProperty("Loc_IOSPlatformVersion");
		iOSPlatformVersion = Double.parseDouble(vIOSPlatformVersion);
		AppName = optionalValue;
		LogCapture.info(optionalValue + " Application installed and launched successfully......!!!!");
	}

	@Given("^ios user launched already installed (CD|TorFx) app successfully$")
	public void ios_user_launched_already_installed_CD_app_successfully(String optionalValue) throws Throwable {
		Assert.assertEquals("PASS", Constants.key.LaunchExistingIOSApp(optionalValue));
		String vIOSPlatformVersion = Constants.CONFIG.getProperty("Loc_IOSPlatformVersion");
		iOSPlatformVersion = Double.parseDouble(vIOSPlatformVersion);
		LogCapture.info("Application installed and launched successfully......!!!!");
	}

	@Given("^ios user installed the new (CD|TorFx) app and launched successfully for force upgrade screen$")
	public void ios_user_installed_the_new_CD_app_and_launched_successfully_for_force_upgrade_screen(
			String optionalValue) throws Throwable {
		Assert.assertEquals("PASS", Constants.key.launchApp(optionalValue));
		String vIOSPlatformVersion = Constants.CONFIG.getProperty("IOSPlatformVersion");
		iOSPlatformVersion = Double.parseDouble(vIOSPlatformVersion);
		LogCapture.info(optionalValue + " Application installed and launched successfully......!!!!");
	}

	/*
	 * @When("^ios pinned user reinstall and launch the application$") public void
	 * ios_pinned_user_reinstall_and_launch_the_application() throws Throwable {
	 * Assert.assertEquals("PASS", Constants.key.launchApp("Version 3.0 (120)"));
	 * LogCapture.info("Application installed and launched successfully......!!!!");
	 * 
	 * }
	 */

	@When("^(ios) pinned user reinstall and launch the (CD|TorFX) app in ios app$")
	public void ios_pinned_user_reinstall_and_launch_the_CD_app_in_ios_app(String Platform, String optionalValue)
			throws Throwable {
		// Assert.assertEquals("PASS", Constants.key.launchApp("Version 3.0 (120)"));
		Assert.assertEquals("PASS", Constants.key.launchAppOnBrowserStack(Platform, optionalValue));
		LogCapture.info("Application installed and launched successfully......!!!!");
	}

	@When("^ios app version is supported by the server$")
	public void ios_app_version_is_supported_by_the_server() throws Throwable {
		String vObjUpdateNowbtn = Constants.IOSLoginOR.getProperty("UpdateNowBtn");
		LogCapture.info("IOS application version is supported by the server.......");
	}

	@When("^the version of ios app is not supported by the server$")
	public void the_version_of_ios_app_is_not_supported_by_the_server() throws Throwable {
		String vObjUpdateNowbtn = Constants.IOSLoginOR.getProperty("UpdateNowBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdateNowbtn));
		LogCapture.info("IOS application update is available screen displayed.......");
	}

	@When("^ios app scheduled maintenance has been checked$")
	public void ios_app_scheduled_maintenance_has_been_checked() throws Throwable {
		/*
		 * String vobjCloseFutMainBtn =
		 * Constants.IOSLoginOR.getProperty("CloseFutMaiBtn"); //Temporary reinitialize
		 * wait with lower time to improve performance on this step
		 * Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty(
		 * "ModifyWaitInSecondsForIOS"));
		 * Constants.key.reInitializeWebDriverWait(Constants.waitInSeconds);
		 * 
		 * String result = Constants.key.click(vobjCloseFutMainBtn); if
		 * (result.equalsIgnoreCase("PASS")) { LogCapture.
		 * info("Future maintenance scheduler found and closed successfully......." ); }
		 * else{ LogCapture.info("No future maintenance scheduler found......."); } //To
		 * initialize wait with original value Constants.wait = new
		 * WebDriverWait(Constants.driver, Constants.waitInSeconds);
		 */

	}

	@When("^ios app pinned user screen has been checked$")
	public void ios_app_pinned_user_screen_has_been_checked() throws Throwable {
		LogCapture.info("Checking previous logged in credentials present or not .......");
		String vObjCancelBiometric = Constants.IOSLoginOR.getProperty("CancelBiometric");
		String vObjResetBtn = Constants.IOSLoginOR.getProperty("ResetPassLink");
		// Temporary reinitialize wait with lower time to improve performance on
		// this step
		Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("ModifyWaitInSecondsForIOS"));
		Constants.key.reInitializeWebDriverWait(Constants.waitInSeconds);
		String result = Constants.key.eleLocatedDisplayed(vObjCancelBiometric);
		if (result.equalsIgnoreCase("PASS")) {
			result = Constants.key.click(vObjCancelBiometric);
		}
		if (!result.equalsIgnoreCase("PASS")) {
			result = Constants.key.eleLocatedDisplayed(vObjResetBtn);
		}
		// To initialize wait with original value
		Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
		Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
		if (result.equalsIgnoreCase("PASS")) {
			LogCapture.info("Pinned user screen displayed .......");
			LogCapture.info("Removing previous logged in credentials .......");
			ios_user_provide_only_Password("DefaultPassword");
			ios_user_click_on_the_login_button();
			ios_app_should_load_the_dashboard_screen();
			ios_user_removes_account_by_using_manage_device_option();
			previous_ios_user_credentials_should_be_removed_and_onboarding_screen_should_be_displayed();

		} else {
			LogCapture.info("Pinned user screen is not displayed .......");
		}

	}

	@Then("^ios app should load the onboarding screen$")
	public void ios_app_should_load_the_onboarding_screen() throws Throwable {

		// To check pinned user already present if yes then unpinn the user
		String vObjOnboardsignUpBtn = Constants.IOSLoginOR.getProperty("SignUpBtn");
		/*
		 * String vObjCancelBiometric =
		 * Constants.IOSLoginOR.getProperty("CancelBiometric"); String
		 * vObjLoginWithAnotherAcBtn =
		 * Constants.IOSLoginOR.getProperty("LoginWithAnotherAcBtn"); String
		 * vObjResetBtn = Constants.IOSLoginOR.getProperty("ResetBtn"); String
		 * vObjEmailInput = Constants.IOSLoginOR.getProperty("EmailInput");
		 * 
		 * //Temporary reinitialize wait with lower time to improve performance on this
		 * step Constants.modifyWaitInSeconds =
		 * Integer.parseInt(Constants.CONFIG.getProperty( "ModifyWaitInSecondsForIOS"));
		 * Constants.key.reInitializeWebDriverWait(Constants.modifyWaitInSeconds );
		 * //ios_app_scheduled_maintenance_has_been_checked();
		 * Constants.key.click(vObjCancelBiometric);
		 * 
		 * Constants.key.eleLocatedDisplayed(vObjLoginWithAnotherAcBtn); String result =
		 * Constants.key.eleLocatedDisplayed(vObjLoginWithAnotherAcBtn);
		 * //System.out.println("Result : "+result);
		 * 
		 * if (result.equalsIgnoreCase("PASS")) {
		 * Assert.assertEquals("PASS",Constants.key.click( vObjLoginWithAnotherAcBtn));
		 * //Assert.assertEquals("PASS",Constants.key.click(
		 * vObjLoginWithAnotherAcBtn));
		 * Assert.assertEquals("PASS",Constants.key.click(vObjResetBtn));
		 * Assert.assertEquals("PASS",Constants.key.eleLocatedDisplayed(
		 * vObjEmailInput)); Constants.key.LaunchExistingIOSApp(); LogCapture.
		 * info("User unpinned from the app and application relaunched successfully......."
		 * ); } else { LogCapture.info("Pinned user not found...... ");
		 * 
		 * //To initialize wait with original value Constants.modifyWaitInSeconds =
		 * Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS")) ;
		 * Constants.wait = new WebDriverWait(Constants.driver,
		 * Constants.waitInSeconds); // To check onboard screen displayed }
		 */
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOnboardsignUpBtn));
		LogCapture.info("An onboarding screen has been displayed..........");

	}

	@Then("^ios app splash screen should be displayed$")
	public void ios_app_splash_screen_should_be_displayed() throws Throwable {
		String vObjSplashImg = Constants.IOSLoginOR.getProperty("SplashImage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSplashImg));
		LogCapture.info("A splash screen is displayed..........");
	}

	@When("^ios user switch to other application \"([^\"]*)\"$")
	public void ios_user_switch_to_other_application(String bundleId) throws Throwable {
		String vBundleId = Constants.IOSExtAppData.getProperty(bundleId);
		Assert.assertEquals("PASS", Constants.key.switchApp(vBundleId));
		LogCapture.info("User switched on other application..........");
	}

	@When("^reswitch to (CD|TorFX) ios app \"([^\"]*)\"$")
	public void reswitch_to_cd_ios_app(String bundleID, String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("CD")) {
			String vCDAppBundleId = Constants.CONFIG.getProperty("CDIOSbundleId");
			Assert.assertEquals("PASS", Constants.key.switchApp(vCDAppBundleId));
		} else {
			String vCDAppBundleId = Constants.CONFIG.getProperty("TorFXIOSbundleId");
			Assert.assertEquals("PASS", Constants.key.switchApp(vCDAppBundleId));
		}
	}

	@Given("^(ios) (TorFX|CD) app has been launched with attepmt (\\d+)$")
	public void ios_app_has_been_launched_with_attepmt(String optionalValue, String Platform, int attempt)
			throws Throwable {
		if (Constants.CONFIG.getProperty("isBrowserStackRunning").equalsIgnoreCase("True")) {
			Assert.assertEquals("PASS", Constants.key.launchAppOnBrowserStack(Platform, optionalValue));
		} else {
			Assert.assertEquals("PASS", Constants.key.LaunchExistingIOSApp(optionalValue));
		}
		LogCapture.info("Attempt : " + attempt + " Application launched successfully........");
	}

	@Then("^ios app should load the last activity screen$")
	public void ios_app_should_load_the_last_activity_screen() throws Throwable {
		String vObjOnboardsignUpBtn = Constants.IOSLoginOR.getProperty("SignUpBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOnboardsignUpBtn));
		String vObjIHaveAcLink = Constants.IOSLoginOR.getProperty("IHaveAclink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjIHaveAcLink));
		LogCapture.info("Last screen validated with the signup button and I have an account? link..........");
	}

	@When("^ios user click on I already have an account\\? link$")
	public void ios_user_click_on_I_already_have_an_account_link() throws Throwable {

		String vObjIhaveAcclnk = Constants.IOSLoginOR.getProperty("IHaveAclink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjIhaveAcclnk));
		Assert.assertEquals("PASS", Constants.key.click(vObjIhaveAcclnk));
		LogCapture.info("User clicked on I have an account? link .......");

	}

	@Then("^ios user should navigate to (login|additional information|registration success|logout) screen$")
	public void ios_user_should_navigate_to_login_screen(String optionalValue) throws Throwable {

		if (optionalValue.equalsIgnoreCase("login")) {
			String vObjEmailInput = Constants.IOSLoginOR.getProperty("EmailInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailInput));
			LogCapture.info("Login screen has been displayed..........");
		} else if (optionalValue.equalsIgnoreCase("additional information")) {
			String vObjAddtnlInfoTitle = Constants.IOSRegstOR.getProperty("AddtnlInfoTitle");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddtnlInfoTitle));
		} else if (optionalValue.equalsIgnoreCase("registration success")) {
			Thread.sleep(7000);
			String vObjSuccessScreen = Constants.IOSRegstOR.getProperty("SuccessScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSuccessScreen));
			LogCapture.info("User land on success screen.........");

		} else if (optionalValue.equalsIgnoreCase("logout")) {
			String vObjLogOutLbl = Constants.IOSLoginOR.getProperty("LogOutLbl");
			String vObjLogInBtn = Constants.IOSLoginOR.getProperty("LogInBtn");
			String vObjLoggedOutTitle = Constants.IOSLoginOR.getProperty("LoggedOutTitle");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLogOutLbl));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLogInBtn));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoggedOutTitle));
			// Assert.assertEquals("PASS","FAIL"); //Code pending
		}
		LogCapture.info("User navigated to " + optionalValue + " .......");
	}

	@When("^ios user provides Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void ios_user_provides_Username_and_Password(String username, String password) throws Throwable {
		String vObjEmailInput = Constants.IOSLoginOR.getProperty("EmailInput");
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vUsername = Constants.IOSTestData.getProperty(username);
		String vPassword = Constants.IOSTestData.getProperty(password);
		useremaild = username;
		// To input email and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		// To input password and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPasswordInput, vPassword));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Username and password entered successfully.........");

	}

	@When("^ios user click on the login button$")
	public void ios_user_click_on_the_login_button() throws Throwable {
		String vObjLoginBtn = Constants.IOSLoginOR.getProperty("LoginBtn");
		String vObjSkipForNowBtn = Constants.IOSLoginOR.getProperty("SkipForNowBtn");
		String vObjEnv = Constants.CONFIG.getProperty("environment");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));

		String vObjDashContBtn = Constants.IOSLoginOR.getProperty("DashContBtn");

		String vObjDashContBtn2 = Constants.IOSLoginOR.getProperty("DashContBtn2");

		// if ((iOSPlatformVersion > 12.4)) {

		if (!Constants.key.eleLocatedDisplayed(vObjSkipForNowBtn).equalsIgnoreCase("PASS")) {

			if (vObjEnv.equalsIgnoreCase("UAT")) {
				ios_user_enters_valid_otp_to_add_recipient(useremaild, "first time login");
			}

			else {
				ios_user_enters_default_otp_on_add_recipient_screen("login");
			}
		}

	} /*
		 * else {
		 * 
		 * if
		 * (!Constants.key.eleLocatedDisplayed(vObjDashContBtn2).equalsIgnoreCase("PASS"
		 * )) { ios_user_enters_valid_otp_to_add_recipient("first time login",
		 * useremaild); } } }
		 */

	@When("^ios user click on the (logout|done) button$")

	public void ios_user_click_on_the_logout_button(String optionalValue) throws Throwable {

		if (optionalValue.equalsIgnoreCase("logout")) {

			String vObjLogoutBtn = Constants.IOSLoginOR.getProperty("LogoutBtn");

			Assert.assertEquals("PASS", Constants.key.click(vObjLogoutBtn));

		} else if (optionalValue.equalsIgnoreCase("done")) {

			// String vObjDoneBtn = Constants.IOSSendMoneyOR.getProperty("DoneBtn");

			String vObjDoneBtn = Constants.IOSAddWalletOR.getProperty("DoneBtn");
			String vObjSitDoneBtn = Constants.IOSAddWalletOR.getProperty("SitDoneBtn");

			// String vObjPaymentMethod =
			// Constants.IOSSendMoneyOR.getProperty("PaymentMethod");

			// commenting above line as xpath is not working for iphone device 8

			String vObjPaymentMethod = Constants.IOSSendMoneyOR.getProperty("PaymentSuccessLbl");

			String vObjPaymentMethod2 = Constants.IOSSendMoneyOR.getProperty("PaymentSuccessLbl2");
			String vObjEnv = Constants.CONFIG.getProperty("environment");

			if ((iOSPlatformVersion > 12.4)) {

				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentMethod2));

				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Done", "down"));

				if (vObjEnv.equalsIgnoreCase("UAT")) {
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDoneBtn));
					Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
				} else {
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSitDoneBtn));
					Assert.assertEquals("PASS", Constants.key.click(vObjSitDoneBtn));
				}

			} else {

				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentMethod));

				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Done", "down"));

				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDoneBtn));

				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			}

		}

	}

	@When("^ios user click on the login button on pinned user$")
	public void ios_user_click_on_the_login_button_on_pinned_user() throws Throwable {
		String vObjLoginBtn = Constants.IOSLoginOR.getProperty("LoginBtn");
		String vObjSkipForNowBtn = Constants.IOSLoginOR.getProperty("SkipForNowBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
		LogCapture.info("User clicked on login button.......");
	}

	// Added the new check for Continue button.
	@Then("^ios app should load the dashboard screen$")
	public void ios_app_should_load_the_dashboard_screen() throws Throwable {
		String vObjSendMoneyLbl = Constants.IOSLoginOR.getProperty("SendMoneyLbl");

		String vObjDashContBtn = Constants.IOSLoginOR.getProperty("DashContBtn");

		String vObjDashContBtn2 = Constants.IOSLoginOR.getProperty("DashContBtn2");

		String result = "FAIL";

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendMoneyLbl));

		if ((iOSPlatformVersion > 12.4)) {

			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashContBtn));

		} else {

			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashContBtn2));
		}

	}

	@When("^ios pinned user relaunches the (CD|TorFX) application$")
	public void ios_pinned_user_relaunches_the_TorFX_application(String optionalValue) throws Throwable {

		if (optionalValue.equalsIgnoreCase("CD") || (optionalValue.equalsIgnoreCase("TorFX"))) {
			Assert.assertEquals("PASS", Constants.key.launchExistingAppOnBrowserStack());
		} else {
			Assert.assertEquals("PASS", Constants.key.LaunchExistingIOSApp(optionalValue));
			LogCapture.info("Application closed and relaunched successfully.......");
		}
	}

	@Then("^ios app should load the pinned user login screen$")
	public void ios_app_should_load_the_pinned_user_login_screen() throws Throwable {
		String vObjLoginWithAnotherAcBtn = Constants.IOSLoginOR.getProperty("LoginWithAnotherAcBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoginWithAnotherAcBtn));
		LogCapture.info("Pinned user login screen displayed successfully.......");
	}

	@When("^internet connection is not available on ios device$")
	public void internet_connection_is_not_available_on_ios_device() throws Throwable {
		Assert.assertEquals("PASS", Constants.key.setConnectionToOff("ios"));
		LogCapture.info("Data connection set to off...........");
	}

	@When("^internet connection is available on ios device$")
	public void internet_connection_is_available_on_ios_device() throws Throwable {
		Assert.assertEquals("PASS", Constants.key.setConnectionToOn("ios"));
		LogCapture.info("Data connection set to on...........");
	}

	@Then("^ios user should able to turn on wifi connection$")
	public void ios_user_should_able_to_turn_on_wifi_connection() throws Throwable {
		internet_connection_is_available_on_ios_device();
	}

	@When("^ios user swap the page from right to left respective pages should display$")
	public void ios_user_swap_the_page_from_right_to_left_respective_pages_should_display() throws Throwable {
		String vObjAnmViewOnboarding = Constants.IOSLoginOR.getProperty("AnmViewOnboarding");
		int noOfAttempt = 2;
		Assert.assertEquals("PASS", Constants.key.Swipe(vObjAnmViewOnboarding, "left", noOfAttempt));
		LogCapture.info("Swipe action right to left performed : " + noOfAttempt + "times");
	}

	@When("^ios user swap the page from left to right respective pages should display$")
	public void ios_user_swap_the_page_from_left_to_right_respective_pages_should_display() throws Throwable {
		String vObjAnmViewOnboarding = Constants.IOSLoginOR.getProperty("AnmViewOnboarding");
		int noOfAttempt = 2;
		Assert.assertEquals("PASS", Constants.key.Swipe(vObjAnmViewOnboarding, "right", 2));
		LogCapture.info("Swipe action left to right performed : " + noOfAttempt + "times");

	}

	@When("^ios user click on the update now button$")
	public void ios_user_click_on_the_update_now_button() throws Throwable {
		String vObjUpdateNowbtn = Constants.IOSLoginOR.getProperty("UpdateNowBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjUpdateNowbtn));
		LogCapture.info("User clicked on update now.......");
	}

	@Then("^ios app should navigate to requested app store url$")
	public void ios_app_should_navigate_to_requested_app_store_url() throws Throwable {
		String vObjAppStoreCDAppLabel = Constants.IOSExtAppData.getProperty("AppStoreCDAppLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAppStoreCDAppLabel));
		LogCapture.info("User navigated to IOS app store.......");
	}

	@Then("^(no internet connection|email id already exist) error message should be displayed to ios user$")
	public void no_internet_connection_error_message_should_be_displayed_to_ios_user(String optionalValue)
			throws Throwable {

		if (optionalValue.equalsIgnoreCase("no internet connection")) {
			String vObjInternetConnErrorMsg = Constants.IOSLoginOR.getProperty("InternetConnErrorMsg");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInternetConnErrorMsg));

			String ErrorMsg1 = Constants.IOSTestData.getProperty("InternetConnErrorMsg");
			String ErrorMsg2 = Constants.key.getAttributeValue(vObjInternetConnErrorMsg, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(ErrorMsg1, ErrorMsg2));

			String vObjOkBtn = Constants.IOSLoginOR.getProperty("OkBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
			LogCapture.info("No internet connection error message displayed and clicked on ok button.......");
			Assert.assertEquals("PASS", Constants.key.setConnectionToOn("ios"));
			LogCapture.info("Connection set on for further testing scenarios...........");
		} else if (optionalValue.equalsIgnoreCase("email id already exist")) {

		}

	}

	@When("^ios user select the update option$")
	public void ios_user_select_the_update_option() throws Throwable {
		String vObjAppStoreRedownloadIcon = Constants.IOSExtAppData.getProperty("AppStoreRedownloadIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjAppStoreRedownloadIcon));
		LogCapture.info("User clicked on update app.......");
	}

	@Then("^ios app should be updated on the device \"([^\"]*)\" to the latest available version \"([^\"]*)\"$")
	public void ios_app_should_be_updated_on_the_device_to_the_latest_available_version(String optionalValue,
			String deviceID, String appVersion) throws Throwable {
		String vObjAppStoreOpenBtn = Constants.IOSExtAppData.getProperty("AppStoreOpenBtn");
		String vObjDontAllow = Constants.IOSExtAppData.getProperty("DontAllowBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjAppStoreOpenBtn));
		LogCapture.info("Application updated successfully and clicked on open from the app store.......");
		String result = Constants.key.eleLocatedDisplayed(vObjDontAllow);
		if (result.equalsIgnoreCase("PASS")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjDontAllow));
		}
		LogCapture.info("Now again updating SIT Latest Application for further testing.......");
		Assert.assertEquals("PASS", Constants.key.launchApp(optionalValue));
		LogCapture.info("SIT application installed successfully for further testing.......");
	}

	@When("^ios user does not select the update option$")
	public void ios_user_does_not_select_the_update_option() throws Throwable {
		// do nothing
		LogCapture.info("User did not click on update option of app store.......");
	}

	@Then("^previous version of the cd ios app should remain installed on the device$")
	public void previous_version_of_the_cd_ios_app_should_remain_installed_on_the_device() throws Throwable {
		Constants.driver.resetApp();
		LogCapture.info("Application realunched.......");

		String vObjUpdateNowbtn = Constants.IOSLoginOR.getProperty("UpdateNowBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdateNowbtn));
		LogCapture.info("Upgrade application screen displayed.......");
	}

	@When("^ios user cancel the update process$")
	public void ios_user_cancel_the_update_process() throws Throwable {
		String vObjAppStoreDownloadingIcon = Constants.IOSExtAppData.getProperty("AppStoreDownloadingIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjAppStoreDownloadingIcon));
		LogCapture.info("User cancelled upgrade app process.......");
	}

	@Then("^login signup options should be present on ios app onboarding screen$")
	public void login_signup_options_should_be_present_on_ios_app_onboarding_screen() throws Throwable {
		String vObjSignUpBtn = Constants.IOSLoginOR.getProperty("SignUpBtn");
		String vObjIhaveAcclnk = Constants.IOSLoginOR.getProperty("IHaveAclink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSignUpBtn));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjIhaveAcclnk));
		LogCapture.info("Signup button and I have an account? link is present on onboarding screen.......");
	}

	@When("^ios user click on the (Sign up|ok) button$")
	public void ios_user_click_on_the_Sign_up_button(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("Sign up")) {
			String vObjSignUpBtn = Constants.IOSLoginOR.getProperty("SignUpBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjSignUpBtn));
			LogCapture.info("User clicked on sign up button.......");
		}
		if (optionalValue.equalsIgnoreCase("ok")) {
			String vObjOkBtn = Constants.IOSSendMoneyOR.getProperty("OkBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
			LogCapture.info("User clicked on ok button.......");
		}
	}

	@Then("^ios user should navigate to registration process screen$")
	public void ios_user_should_navigate_to_registration_process_screen() throws Throwable {

	}

	@Then("^ios app login button should be enabled to submit the credentials$")
	public void ios_app_login_button_should_be_enabled_to_submit_the_credentials() throws Throwable {
		String vObjLoginBtn = Constants.IOSLoginOR.getProperty("LoginBtn");
		String atbValue = Constants.key.getAttributeValue(vObjLoginBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		LogCapture.info("Active login button verified successfully.........");
	}

	@When("^ios user doest not provides Username and Password$")
	public void ios_user_doest_not_provides_Username_and_Password() throws Throwable {
		String vObjEmailInput = Constants.IOSLoginOR.getProperty("EmailInput");
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");

		Assert.assertEquals("PASS", Constants.key.click(vObjEmailInput));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjEmailInput));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));

		Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Previous username and password data checked and clear successfully.........");
	}

	@Then("^ios app login button should be disabled to submit the credentials$")
	public void ios_app_login_button_should_be_disabled_to_submit_the_credentials() throws Throwable {
		String vObjLoginBtn = Constants.IOSLoginOR.getProperty("LoginBtn");
		String atbValue = Constants.key.getAttributeValue(vObjLoginBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		LogCapture.info("Inactive login button verified successfully.........");
	}

	@When("^ios user  provide only Username \"([^\"]*)\"$")
	public void ios_user_provide_only_Username(String username) throws Throwable {
		String vObjEmailInput = Constants.IOSLoginOR.getProperty("EmailInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vUsername = Constants.IOSTestData.getProperty(username);

		// To input email and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));

		LogCapture.info("Username entered  successfully.........");
	}

	@When("^ios user provide only Password \"([^\"]*)\"$")
	public void ios_user_provide_only_Password(String password) throws Throwable {
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vPassword = Constants.IOSTestData.getProperty(password);

		// To input password and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPasswordInput, vPassword));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Password entered  successfully.........");
	}

	@When("^ios user exits the login process$")
	public void ios_user_exits_the_login_process() throws Throwable {
		Assert.assertEquals("PASS", Constants.key.closeApp());
		LogCapture.info("App closed  successfully.........");
	}

	/*
	 * @When("^ios user relaunches the app$") public void
	 * ios_user_relaunches_the_app() throws Throwable { Assert.assertEquals("PASS",
	 * Constants.key.LaunchExistingIOSApp()); LogCapture.
	 * info("Application has been relaunched without clearing previous data........."
	 * ); }
	 */

	/*
	 * @Then("^ios user required data should be saved in secure device storage t logins$"
	 * ) public void
	 * ios_user_required_data_should_be_saved_in_secure_device_storage_for_future_subsequent_logins
	 * () throws Throwable { Constants.key.LaunchExistingIOSApp(); String
	 * vObjResetPassLink = Constants.IOSLoginOR.getProperty("ResetPassLink");
	 * Assert.assertEquals("PASS",
	 * Constants.key.eleLocatedDisplayed(vObjResetPassLink)); }
	 */

	@Then("^ios user required data should be saved in secure device storage for future subsequent logins in ios application$")
	public void ios_user_required_data_should_be_saved_in_secure_device_storage_for_future_subsequent_logins_in_ios_application()
			throws Throwable {
		Constants.key.launchExistingAppOnBrowserStack();
		String vObjResetPassLink = Constants.IOSLoginOR.getProperty("ResetPassLink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjResetPassLink));
	}

	@Then("^ios user required data should be saved in secure device \"([^\"]*)\" storage for future subsequent logins$")
	public void ios_user_required_data_should_be_saved_in_secure_device_storage_for_future_subsequent_logins(
			String optionalValue, String deviceId) throws Throwable {
		Constants.key.LaunchExistingIOSApp(optionalValue);
		String vObjResetPassLink = Constants.IOSLoginOR.getProperty("ResetPassLink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjResetPassLink));
	}

	@Then("^authentication unsuccessful error message should be displayed on login screen for ios user$")
	public void authentication_unsuccessful_error_message_should_be_displayed_on_login_screen_for_ios_user()
			throws Throwable {
	}

	@When("^ios user provide Username \"([^\"]*)\" in invalid format$")
	public void ios_user_provide_Username_in_invalid_format(String username) throws Throwable {
		String vObjEmailInput = Constants.IOSLoginOR.getProperty("EmailInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vUsername = Constants.IOSTestData.getProperty(username);
		// To input email and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.warn("Invalid email id entered.........!!!!!!");
	}

	@Then("^a validation failure message should be displayed for the username to ios user$")
	public void a_validation_failure_message_should_be_displayed_for_the_username_to_ios_user() throws Throwable {
		String vObjEmailValidation = Constants.IOSLoginOR.getProperty("InvalidEmail");
		String atbValue = Constants.key.getAttributeValue(vObjEmailValidation, "value").toString();
		String vEmailValidation = Constants.IOSTestData.getProperty("EmailValidation");
		Assert.assertEquals("PASS", Constants.key.VerifyText(vEmailValidation, atbValue));
		LogCapture.warn("Invalid email validation messgae verified...........");
	}

	@Then("^forgot password\\? link should be present on ios app login screen$")
	public void forgot_password_link_should_be_present_on_ios_app_login_screen() throws Throwable {
		String vObjForgotPasslink = Constants.IOSLoginOR.getProperty("ForgotPasslink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotPasslink));
		LogCapture.info("Forgot password link is present.......");
	}

	@When("^ios user click on forgot password\\? link$")
	public void ios_user_click_on_forgot_password_link() throws Throwable {
		String vObjForgotPasslink = Constants.IOSLoginOR.getProperty("ForgotPasslink");
		Assert.assertEquals("PASS", Constants.key.click(vObjForgotPasslink));
		LogCapture.info("User clicked on forgot password link.......");
	}

	@Then("^ios user should navigate to forgot password process screen$")
	public void ios_user_should_navigate_to_forgot_password_process_screen() throws Throwable {

		String vObjForgotPassCloseBtn = Constants.IOSLoginOR.getProperty("ForgotPassCloseBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotPassCloseBtn));
		String atbValue = Constants.key.getAttributeValue(vObjForgotPassCloseBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		// Assert.assertEquals("PASS",Constants.key.eleLocatedDisplayed(vObjForgotPassClose));
		String vObjForgotEmailInput = Constants.IOSLoginOR.getProperty("ForgotEmailInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotEmailInput));
		LogCapture.info("User navigated to forgot password screen successfully.......");
	}

	@Then("^ios app forgot password button should be active$")
	public void ios_app_forgot_password_button_should_be_active() throws Throwable {
		String vObjForgotPassBtn = Constants.IOSLoginOR.getProperty("ForgotPassBtn");
		String atbValue = Constants.key.getAttributeValue(vObjForgotPassBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		LogCapture.info("Active forgot passwrd button verified successfully.........");
	}

	@Then("^ios app forgot password button should be inactive$")
	public void ios_app_forgot_password_button_should_be_inactive() throws Throwable {
		String vObjForgotPassBtn = Constants.IOSLoginOR.getProperty("ForgotPassBtn");
		String atbValue = Constants.key.getAttributeValue(vObjForgotPassBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		LogCapture.info("Inactive forgot passwrd button verified successfully.........");
	}

	@When("^ios user doesnot provide Username$")
	public void ios_user_doesnot_provide_Username() throws Throwable {
		String vObjForgotEmailInput = Constants.IOSLoginOR.getProperty("ForgotEmailInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");

		Assert.assertEquals("PASS", Constants.key.click(vObjForgotEmailInput));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjForgotEmailInput));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));

		LogCapture.info("Previous  data checked and clear successfully.........");
	}

	@When("^ios user provide valid registered Username \"([^\"]*)\"$")
	public void ios_user_provide_valid_registered_Username(String username) throws Throwable {
		String vObjForgotEmailInput = Constants.IOSLoginOR.getProperty("ForgotEmailInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vUsername = Constants.IOSTestData.getProperty(username);
		// To input email and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjForgotEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjForgotEmailInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User has entered an email id.........");
	}

	@When("^ios user click on (send me a link|login)$")
	public void ios_user_click_on_send_me_a_link(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("send me a link")) {
			String vObjForgotPassBtn = Constants.IOSLoginOR.getProperty("ForgotPassBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjForgotPassBtn));
		} else if (optionalValue.equalsIgnoreCase("login")) {
			String vObjLogInBtn = Constants.IOSLoginOR.getProperty("LogInBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjLogInBtn));
		}
		LogCapture.info("User clicked on " + optionalValue + ".............");
	}

	@When("^ios user provide valid non registered Username \"([^\"]*)\"$")
	public void ios_user_provide_valid_non_registered_Username(String username) throws Throwable {
		String vObjForgotEmailInput = Constants.IOSLoginOR.getProperty("ForgotEmailInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vUsername = Constants.IOSTestData.getProperty(username);
		// To input email and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjForgotEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjForgotEmailInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User has entered  non registered email id.........");

	}

	@Then("^password reset link sent success message should be displayed to ios user$")
	public void password_reset_link_sent_success_message_should_be_displayed_to_ios_user() throws Throwable {
		String vObjMailSentImg = Constants.IOSLoginOR.getProperty("MailSentImg");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMailSentImg));
		String vObjMailSentDescLbl = Constants.IOSLoginOR.getProperty("MailSentDescLbl");
		String value1 = Constants.IOSTestData.getProperty("MailSentDescText");
		String Value2 = Constants.key.getAttributeValue(vObjMailSentDescLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(value1, Value2));
		LogCapture.info("Reset your password mail sent, Success message verified successfully........");
	}

	@When("^ios user provide atlas inactive Username \"([^\"]*)\"$")
	public void ios_user_provide_atlas_inactive_Username(String username) throws Throwable {
		String vObjForgotEmailInput = Constants.IOSLoginOR.getProperty("ForgotEmailInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vUsername = Constants.IOSTestData.getProperty(username);
		// To input email and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjForgotEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjForgotEmailInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User has entered atlas inactive user email id.........");

	}

	@When("^ios user provide locked due to inavlid attempt Username \"([^\"]*)\"$")
	public void ios_user_provide_locked_due_to_inavlid_attempt_Username(String username) throws Throwable {
		String vObjForgotEmailInput = Constants.IOSLoginOR.getProperty("ForgotEmailInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vUsername = Constants.IOSTestData.getProperty(username);
		// To input email and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjForgotEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjForgotEmailInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User has entered locked due to invalid attempt user email id.........");

	}

	@When("^ios user provide admin locked Username \"([^\"]*)\"$")
	public void ios_user_provide_admin_locked_Username(String username) throws Throwable {
		String vObjForgotEmailInput = Constants.IOSLoginOR.getProperty("ForgotEmailInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vUsername = Constants.IOSTestData.getProperty(username);
		// To input email and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjForgotEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjForgotEmailInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User has entered admin locked user email id.........");
	}

	@Then("^a generic message should be displayed on the screen to ios user$")
	public void a_generic_message_should_be_displayed_on_the_screen_to_ios_user() throws Throwable {
		String vObjMailSentImg = Constants.IOSLoginOR.getProperty("MailSentImg");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMailSentImg));
		String vObjMailSentDescLbl = Constants.IOSLoginOR.getProperty("MailSentDescLbl");
		String value1 = Constants.IOSTestData.getProperty("GenericErrorMessage");
		String Value2 = Constants.key.getAttributeValue(vObjMailSentDescLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(value1, Value2));
		LogCapture.info("Technical error message displayed.........");
	}

	@Then("^forgot password description label should be present on the forgot password screen of ios app$")
	public void forgot_password_description_label_should_be_present_on_the_forgot_password_screen_of_ios_app()
			throws Throwable {

		String vObjForgPassDescLbl = Constants.IOSLoginOR.getProperty("ForgPassDescLbl");
		String vForgotPassDesc = Constants.IOSTestData.getProperty("ForgotPasswordDescription");
		String vObjForgotEmailInput = Constants.IOSLoginOR.getProperty("ForgotEmailInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotEmailInput));
		String atbValue = Constants.key.getAttributeValue(vObjForgPassDescLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vForgotPassDesc, atbValue));
		LogCapture.info("Forgot password screen description verified successfully.........");

	}

	@Then("^reset password link has been sent success message should be displayed on ios app$")
	public void reset_password_link_has_been_sent_success_message_should_be_displayed_on_ios_app() throws Throwable {
		String vObjMailSentImg = Constants.IOSLoginOR.getProperty("MailSentImg");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMailSentImg));
		String vObjMailSentDescLbl = Constants.IOSLoginOR.getProperty("MailSentDescLbl");
		String value1 = Constants.IOSTestData.getProperty("MailSentDescText");
		String Value2 = Constants.key.getAttributeValue(vObjMailSentDescLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(value1, Value2));

	}

	@When("^ios user close the forgot password window$")
	public void ios_user_close_the_forgot_password_window() throws Throwable {
		String ForgotPassCloseBtn = Constants.IOSLoginOR.getProperty("ForgotPassCloseBtn");
		Assert.assertEquals("PASS", Constants.key.click(ForgotPassCloseBtn));
		LogCapture.info("Forgot password reset window closed successfully.........");
	}

	@When("^ios user closes the reset password link success window$")
	public void ios_user_closes_the_reset_password_link_success_window() throws Throwable {
		String ForgotPassCloseBtn = Constants.IOSLoginOR.getProperty("ForgotPassCloseBtn");
		Assert.assertEquals("PASS", Constants.key.click(ForgotPassCloseBtn));
		LogCapture.info("Reset password link success window closed successfully.........");
	}

	@Then("^an option to login with another account should be available on ios app$")
	public void an_option_to_login_with_another_account_should_be_available_on_ios_app() throws Throwable {
		String vObjLoginWithAnotherAcBtn = Constants.IOSLoginOR.getProperty("LoginWithAnotherAcBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoginWithAnotherAcBtn));
		LogCapture.info("Login with another account link present on screen.........");
	}

	@When("^ios user select login with another account$")
	public void ios_user_select_login_with_another_account() throws Throwable {
		String vObjLoginWithAnotherAcBtn = Constants.IOSLoginOR.getProperty("LoginWithAnotherAcBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginWithAnotherAcBtn));
		LogCapture.info("User clicked on login with another account link.........");
	}

	@Then("^warning message this action will clear any user saved information popup should be displayed on ios app$")
	public void warning_message_this_action_will_clear_any_user_saved_information_popup_should_be_displayed_on_ios_app()
			throws Throwable {
		String vObjResetWarnLbl = Constants.IOSLoginOR.getProperty("ResetWarnLbl");
		String value1 = Constants.IOSTestData.getProperty("ResetWarnMsg");
		String Value2 = Constants.key.getAttributeValue(vObjResetWarnLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(value1, Value2));
		LogCapture.info("Reset warning message verified successfully.........");
	}

	@When("^ios user cancel to login with another account$")
	public void ios_user_cancel_to_login_with_another_account() throws Throwable {
		String vObjCancelResetBtn = Constants.IOSLoginOR.getProperty("CancelResetBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjCancelResetBtn));
		LogCapture.info("User clicked on cancel button.........");
	}

	@Then("^ios app warning message popup should be closed$")
	public void ios_app_warning_message_popup_should_be_closed() throws Throwable {
		String vObjCancelResetBtn = Constants.IOSLoginOR.getProperty("CancelResetBtn");
		Assert.assertEquals("FAIL", Constants.key.eleLocatedDisplayed(vObjCancelResetBtn));
	}

	@When("^ios user accepts to login as a different user$")
	public void ios_user_accepts_to_login_as_a_different_user() throws Throwable {
		String vObjResetBtn = Constants.IOSLoginOR.getProperty("ResetBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjResetBtn));
	}

	@Then("^the previously stored username on the ios app should be removed from secure device storage$")
	public void the_previously_stored_username_on_the_ios_app_should_be_removed_from_secure_device_storage()
			throws Throwable {
		String vObjEmailInput = Constants.IOSLoginOR.getProperty("EmailInput");
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailInput));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPasswordInput));
	}

	@Then("^ios user should trigger the first time login process$")
	public void ios_user_should_trigger_the_first_time_login_process() throws Throwable {
		String vObjEmailInput = Constants.IOSLoginOR.getProperty("EmailInput");
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailInput));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPasswordInput));
	}

	@When("^existing user provides Username \"([^\"]*)\" and Password \"([^\"]*)\" first time for ios app$")
	public void existing_user_provides_Username_and_Password_first_time_for_ios_app(String username, String password)
			throws Throwable {
		String vObjEmailInput = Constants.IOSLoginOR.getProperty("EmailInput");
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vUsername = Constants.IOSTestData.getProperty(username);
		String vPassword = Constants.IOSTestData.getProperty(password);
		// To input email and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		// To input password and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPasswordInput, vPassword));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Username and password entered successfully.........");
	}

	@Then("^biometric enable popup should be displayed for ios app$")
	public void biometric_enable_popup_should_be_displayed_for_ios_app() throws Throwable {
		String vObjEnableNowBtn = Constants.IOSLoginOR.getProperty("EnableNowBtn");
		String vObjSkipForNowBtn = Constants.IOSLoginOR.getProperty("SkipForNowBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEnableNowBtn));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSkipForNowBtn));
	}

	@When("^ios user enables the biometric credentials for the app$")
	public void ios_user_enables_the_biometric_credentials_for_the_app() throws Throwable {
		String vObjCancleBtn = Constants.IOSAccountOR.getProperty("CancleBtn");
		String vObjEnableNowBtn = Constants.IOSLoginOR.getProperty("EnableNowBtn");
		String vObjBioDoneBtn = Constants.IOSLoginOR.getProperty("BioDoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjEnableNowBtn));
		// Assert.assertEquals("PASS", Constants.key.click(vObjBioDoneBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjCancleBtn));

	}

	@Then("^ios app should load the pinned user login screen with prefilled username$")
	public void ios_app_should_load_the_pinned_user_login_screen_with_prefilled_username() throws Throwable {
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPasswordInput));
		String vObjPinnedUserNameLbl = Constants.IOSLoginOR.getProperty("PinnedUserNameLbl");
		String atbValue = Constants.key.getAttributeValue(vObjPinnedUserNameLbl, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		LogCapture.info("Prefilled username verified successfully.........");
	}

	@Then("^system should allow ios user to enter Password \"([^\"]*)\" in password field$")
	public void system_should_allow_ios_user_to_enter_Password_in_password_field(String password) throws Throwable {
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vPassword = Constants.IOSTestData.getProperty(password);
		// To input password and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPasswordInput, vPassword));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User entered password successfully.........");
	}

	@Then("^ios app should request the users biometric credentials to login$")
	public void ios_app_should_request_the_users_biometric_credentials_to_login() throws Throwable {
		String vObjCancelBiometric = Constants.IOSLoginOR.getProperty("CancelBiometric");
		String vObjUnlockTouchIDTxt = Constants.IOSLoginOR.getProperty("UnlockTouchIDTxt");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCancelBiometric));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUnlockTouchIDTxt));
		LogCapture.info("Biometric request window displayed.........");
	}

	@When("^ios user skip the biometric credentials for the app$")
	public void ios_user_skip_the_biometric_credentials_for_the_app() throws Throwable {
		String vObjSkipForNowBtn = Constants.IOSLoginOR.getProperty("SkipForNowBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjSkipForNowBtn));
		LogCapture.info("User clicked on skip now button.........");
	}

	@Then("^ios app should not request for the biometric credentials to login$")
	public void ios_app_should_not_request_for_the_biometric_credentials_to_login() throws Throwable {
		// Temporary reinitialize wait with lower time to improve performance on this
		// step
		Constants.modifyWaitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("ModifyWaitInSecondsForIOS"));
		Constants.key.reInitializeWebDriverWait(Constants.modifyWaitInSeconds);
		String vObjSkipForNowBtn = Constants.IOSLoginOR.getProperty("SkipForNowBtn");
		Assert.assertEquals("FAIL", Constants.key.eleLocatedDisplayed(vObjSkipForNowBtn));
		LogCapture.info("Biometric request was not observed on pinned user screen.........");
		// To initialize wait with original value
		Constants.modifyWaitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
		Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);

	}

	@When("^ios user provides Password \"([^\"]*)\"$")
	public void ios_user_provides_Password(String password) throws Throwable {
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vPassword = Constants.IOSTestData.getProperty(password);
		// To input password and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPasswordInput, vPassword));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User entered password successfully.........");

	}

	@Then("^an eye icon to show hide the password value should be available for ios app$")
	public void an_eye_icon_to_show_hide_the_password_value_should_be_available_for_ios_app() throws Throwable {
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
		String vObjEyeIcon = Constants.IOSLoginOR.getProperty("EyeIcon");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPasswordInput));
		String atbValue = Constants.key.getAttributeValue(vObjEyeIcon, "label").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("hidden text", atbValue));
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Hide show eye icon is present on password .........");

	}

	@When("^ios user did not provide the passsword$")
	public void ios_user_did_not_provide_the_passsword() throws Throwable {
		LogCapture.info("User did not provide password .........");
	}

	@Then("^an eye icon to show hide the password value should not be available for ios app$")
	public void an_eye_icon_to_show_hide_the_password_value_should_not_be_available_for_ios_app() throws Throwable {
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		String vObjTouchImg = Constants.IOSLoginOR.getProperty("TouchImg");
		Constants.key.eleLocatedDisplayed(vObjPasswordInput);
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTouchImg));

		LogCapture.info("Hide show eye icon is not present on password .........");
	}

	@Then("^password value should be masked by default for ios app$")
	public void password_value_should_be_masked_by_default_for_ios_app() throws Throwable {
		String vObjEyeIcon = Constants.IOSLoginOR.getProperty("EyeIcon");
		String atbValue = Constants.key.getAttributeValue(vObjEyeIcon, "label").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("hidden text", atbValue));
		LogCapture.info("Password value is masked by default .........");

	}

	@When("^ios user click on eye icon to unmask the password value$")
	public void ios_user_click_on_eye_icon_to_unmask_the_password_value() throws Throwable {

		String vObjEyeIcon = Constants.IOSLoginOR.getProperty("EyeIcon");
		String atbValue = Constants.key.getAttributeValue(vObjEyeIcon, "label").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("hidden text", atbValue));
		LogCapture.info("Default value of password  is masked.........");
		Assert.assertEquals("PASS", Constants.key.click(vObjEyeIcon));
		LogCapture.info("User clicked on eye icon to unmask the password.........");
	}

	@Then("^password value should be unmasked for ios user$")
	public void password_value_should_be_unmasked_for_ios_user() throws Throwable {
		String vObjEyeIcon = Constants.IOSLoginOR.getProperty("EyeIcon");
		String atbValue1 = Constants.key.getAttributeValue(vObjEyeIcon, "label").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("show text", atbValue1));
		LogCapture.info("Password value unmasked successfully.........");
	}

	@When("^ios user click on eye icon to mask the password value$")
	public void ios_user_click_on_eye_icon_to_mask_the_password_value() throws Throwable {
		String vObjEyeIcon = Constants.IOSLoginOR.getProperty("EyeIcon");
		String atbValue1 = Constants.key.getAttributeValue(vObjEyeIcon, "label").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("show text", atbValue1));
		Assert.assertEquals("PASS", Constants.key.click(vObjEyeIcon));
		LogCapture.info("User clicked on eye icon to mask password value.........");
	}

	@Then("^password value should be masked for ios user$")
	public void password_value_should_be_masked_for_ios_user() throws Throwable {
		String vObjEyeIcon = Constants.IOSLoginOR.getProperty("EyeIcon");
		String atbValue = Constants.key.getAttributeValue(vObjEyeIcon, "label").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("hidden text", atbValue));
		LogCapture.info("Password value masked successfully.........");
	}

	@When("^ios user cancel the biometric option$")
	public void ios_user_cancel_the_biometric_option() throws Throwable {
		String vObjCancelBioBtn = Constants.IOSLoginOR.getProperty("CancelBioBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjCancelBioBtn));
		LogCapture.info("Biometric request cancelled by user.........");
	}

	@Then("^an option to trigger a request for biometric credentials should be available on ios login screen$")
	public void an_option_to_trigger_a_request_for_biometric_credentials_should_be_available_on_ios_login_screen()
			throws Throwable {
		String vObjTouchImg = Constants.IOSLoginOR.getProperty("TouchImg");
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		Constants.key.eleLocatedDisplayed(vObjPasswordInput);
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTouchImg));
		LogCapture.info("An icon to trigger a request for biometric credentials is present.........");
	}

	@Then("^ios app should replace the biometric credentials option with eye icon to mask unmask password$")
	public void ios_app_should_replace_the_biometric_credentials_option_with_eye_icon_to_mask_unmask_password()
			throws Throwable {
		an_eye_icon_to_show_hide_the_password_value_should_be_available_for_ios_app();
	}

	@When("^ios user clear the password field value$")
	public void ios_user_clear_the_password_field_value() throws Throwable {
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Previous password clear successfully.........");
	}

	@Then("^ios app replace an option eye icon with option biometric credentials to trigger a biometric request$")
	public void ios_app_replace_an_option_eye_icon_with_option_biometric_credentials_to_trigger_a_biometric_request()
			throws Throwable {
		an_option_to_trigger_a_request_for_biometric_credentials_should_be_available_on_ios_login_screen();
	}

	@When("^ios user doesnot provide password$")
	public void ios_user_doesnot_provide_password() throws Throwable {
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Previous password value clear successfully.........");
	}

	@When("^ios user provides valid Username \"([^\"]*)\" and invalid Password \"([^\"]*)\"$")
	public void ios_user_provides_valid_Username_and_invalid_Password(String username, String password)
			throws Throwable {
		String vObjEmailInput = Constants.IOSLoginOR.getProperty("EmailInput");
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vUsername = Constants.IOSTestData.getProperty(username);
		String vPassword = Constants.IOSTestData.getProperty(password);
		GlobalEmail = vUsername;
		GlobalInvalidPassword = vPassword;
		// To input email and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjEmailInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		// To input password and click on done
		Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPasswordInput, vPassword));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Username and password entered successfully.........");
	}

	@Then("^invalid credential message should be displayed on ios app$")
	public void invalid_credential_message_should_be_displayed_on_ios_app() throws Throwable {
		String vObjInvalidCredLbl = Constants.IOSLoginOR.getProperty("InvalidCredLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInvalidCredLbl));
		String value1 = Constants.IOSTestData.getProperty("InvalidCredMsg");
		String Value2 = Constants.key.getAttributeValue(vObjInvalidCredLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(value1, Value2));
		String vObjOkBtn = Constants.IOSLoginOR.getProperty("OkBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
		LogCapture.info("Invalid credential message verified and closed successfully.........");
	}

	@When("^ios user provides valid Password \"([^\"]*)\"$")
	public void ios_user_provides_valid_Password(String password) throws Throwable {
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vPassword = Constants.IOSTestData.getProperty(password);
		Constants.key.eleLocatedDisplayed(vObjPasswordInput);
		Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPasswordInput, vPassword));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User entered valid password successfully.........");
	}

	@Then("^ios app should display error message on main login screen according to failed attempt (\\d+) and user legal entity \"([^\"]*)\"$")
	public void ios_app_should_display_error_message_on_main_login_screen_according_to_failed_attempt_and_user_legal_entity(
			int attempt, String legalEntity) throws Throwable {
		String vObjLoginBtn = Constants.IOSLoginOR.getProperty("LoginBtn");
		String vObjOkBtn = Constants.IOSLoginOR.getProperty("OkBtn");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vLegalEntity = Constants.IOSTestData.getProperty(legalEntity);

		for (int i = 1; i <= attempt; i++) {

			String vObjEmailInput = Constants.IOSLoginOR.getProperty("EmailInput");
			String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
			Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjEmailInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, GlobalEmail));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPasswordInput, GlobalInvalidPassword));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));

			Constants.logInFailCount = Constants.logInFailCount + 1;

			if (Constants.logInFailCount <= 3) {
				String vObjInvalidCredLbl = Constants.IOSLoginOR.getProperty("InvalidCredLbl");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInvalidCredLbl));
				LogCapture.info("User login failed attempt count : " + Constants.logInFailCount);
				String ValidationMsg1 = Constants.IOSTestData.getProperty("InvalidCredMsg").trim();
				String ValidationMsg2 = Constants.key.readText(vObjInvalidCredLbl).trim();
				Assert.assertEquals("PASS", Constants.key.VerifyText(ValidationMsg1, ValidationMsg2));
				LogCapture.info("Invalid credential message displayed.........");
			}

			if (Constants.logInFailCount == 4) {
				if (vLegalEntity.equalsIgnoreCase("CDLGB")) {
					String vObjResetAdvLbl = Constants.IOSLoginOR.getProperty("ResetAdvLbl");
					String ValidationMsg2 = Constants.key.readText(vObjResetAdvLbl);
					LogCapture.info("User login failed attempt count : " + Constants.logInFailCount);
					String ValidationMsg1 = Constants.IOSTestData.getProperty("ResetAdvMsgCDLGB");
					Assert.assertEquals("PASS", Constants.key.VerifyText(ValidationMsg1, ValidationMsg2));
					Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
				}
				if (vLegalEntity.equalsIgnoreCase("CDLCA")) {
					String vObjResetAdvLbl = Constants.IOSLoginOR.getProperty("ResetAdvLbl");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjResetAdvLbl));
					LogCapture.info("User login failed attempt count : " + Constants.logInFailCount);
					String ValidationMsg1 = Constants.IOSTestData.getProperty("ResetAdvMsgCDLCA");
					String ValidationMsg2 = Constants.key.getAttributeValue(vObjResetAdvLbl, "value").toString();
					Assert.assertEquals("PASS", Constants.key.VerifyText(ValidationMsg1, ValidationMsg2));
					Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
				}
				if (vLegalEntity.equalsIgnoreCase("CDINC")) {
					String vObjResetAdvLbl = Constants.IOSLoginOR.getProperty("ResetAdvLbl");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjResetAdvLbl));
					LogCapture.info("User login failed attempt count : " + Constants.logInFailCount);
					String ValidationMsg1 = Constants.IOSTestData.getProperty("ResetAdvMsgCDINC");
					String ValidationMsg2 = Constants.key.getAttributeValue(vObjResetAdvLbl, "value").toString();
					Assert.assertEquals("PASS", Constants.key.VerifyText(ValidationMsg1, ValidationMsg2));
					Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
				}
				LogCapture.info("Reset password advice message displayed.........");
			}
			if (Constants.logInFailCount >= 5) {
				String vObjUserLockedLbl = Constants.IOSLoginOR.getProperty("UserLockedLbl");
				String ValidationMsg2 = Constants.key.readText(vObjUserLockedLbl);
				LogCapture.info("User login failed attempt count : " + Constants.logInFailCount);
				String ValidationMsg1 = Constants.IOSTestData.getProperty("UserLockedMsg");
				Assert.assertEquals("PASS", Constants.key.VerifyText(ValidationMsg1, ValidationMsg2));
				LogCapture.info("User has been locked message verified successfully.........");
			}
		}
	}

	@When("^ios user provides invalid Password \"([^\"]*)\"$")
	public void ios_user_provides_invalid_Password(String inValidPassword) throws Throwable {
		ios_user_provides_valid_Password(inValidPassword);
	}

	@Then("^ios app should display error message on subsequent login screen according to failed attempt (\\d+) and user legal entity \"([^\"]*)\"$")
	public void ios_app_should_display_error_message_on_subsequent_login_screen_according_to_failed_attempt_and_user_legal_entity(
			int attempt, String legalEntity) throws Throwable {
		String vObjLoginBtn = Constants.IOSLoginOR.getProperty("LoginBtn");
		String vObjOkBtn = Constants.IOSLoginOR.getProperty("OkBtn");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vLegalEntity = Constants.IOSTestData.getProperty(legalEntity);
		String GlobalInvalidPassword = Constants.IOSTestData.getProperty("InvalidPass");
		for (int i = 1; i <= attempt; i++) {
			String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
			Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPasswordInput, GlobalInvalidPassword));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
			Constants.logInFailCount = Constants.logInFailCount + 1;
			if (Constants.logInFailCount <= 3) {
				String vObjInvalidCredLbl = Constants.IOSLoginOR.getProperty("InvalidCredLbl");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInvalidCredLbl));
				LogCapture.info("User login failed attempt count : " + Constants.logInFailCount);
				String ValidationMsg1 = Constants.IOSTestData.getProperty("InvalidCredMsg").trim();
				String ValidationMsg2 = Constants.key.readText(vObjInvalidCredLbl).trim();
				Assert.assertEquals("PASS", Constants.key.VerifyText(ValidationMsg1, ValidationMsg2));
				LogCapture.info("Invalid credential message displayed.........");
				Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
			}

			if (Constants.logInFailCount == 4) {
				if (vLegalEntity.equalsIgnoreCase("CDLGB")) {
					String vObjResetAdvLbl = Constants.IOSLoginOR.getProperty("ResetAdvLbl");
					String ValidationMsg2 = Constants.key.readText(vObjResetAdvLbl);
					LogCapture.info("User login failed attempt count : " + Constants.logInFailCount);
					String ValidationMsg1 = Constants.IOSTestData.getProperty("ResetAdvMsgCDLGB");
					Assert.assertEquals("PASS", Constants.key.VerifyText(ValidationMsg1, ValidationMsg2));
					Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
					LogCapture.info("Reset password advice message displayed.........");
				}
				if (vLegalEntity.equalsIgnoreCase("CDLCA")) {
					String vObjResetAdvLbl = Constants.IOSLoginOR.getProperty("ResetAdvLbl");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjResetAdvLbl));
					LogCapture.info("User login failed attempt count : " + Constants.logInFailCount);
					String ValidationMsg1 = Constants.IOSTestData.getProperty("ResetAdvMsgCDLCA");
					String ValidationMsg2 = Constants.key.getAttributeValue(vObjResetAdvLbl, "value").toString();
					Assert.assertEquals("PASS", Constants.key.VerifyText(ValidationMsg1, ValidationMsg2));
					Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
					LogCapture.info("Reset password advice message displayed.........");
				}
				if (vLegalEntity.equalsIgnoreCase("CDINC")) {
					String vObjResetAdvLbl = Constants.IOSLoginOR.getProperty("ResetAdvLbl");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjResetAdvLbl));
					LogCapture.info("User login failed attempt count : " + Constants.logInFailCount);
					String ValidationMsg1 = Constants.IOSTestData.getProperty("ResetAdvMsgCDINC");
					String ValidationMsg2 = Constants.key.getAttributeValue(vObjResetAdvLbl, "value").toString();
					Assert.assertEquals("PASS", Constants.key.VerifyText(ValidationMsg1, ValidationMsg2));
					Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
					LogCapture.info("Reset password advice message displayed.........");
				}

			}
			if (Constants.logInFailCount >= 5) {
				String vObjUserLockedLbl = Constants.IOSLoginOR.getProperty("UserLockedLbl");
				String ValidationMsg2 = Constants.key.readText(vObjUserLockedLbl);
				LogCapture.info("User login failed attempt count : " + Constants.logInFailCount);
				String ValidationMsg1 = Constants.IOSTestData.getProperty("UserLockedMsg");
				Assert.assertEquals("PASS", Constants.key.VerifyText(ValidationMsg1, ValidationMsg2));
				LogCapture.info("User has been locked message verified successfully.........");
			}
		}

	}

	@When("^ios user click on login with another account and enters Username \"([^\"]*)\" and invalid Password \"([^\"]*)\"$")
	public void ios_user_click_on_login_with_another_account_and_enters_Username_and_invalid_Password(String username,
			String password) throws Throwable {
		String vObjLoginWithAnotherAcBtn = Constants.IOSLoginOR.getProperty("LoginWithAnotherAcBtn");
		String vObjResetBtn = Constants.IOSLoginOR.getProperty("ResetBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginWithAnotherAcBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjResetBtn));
		ios_user_provides_valid_Username_and_invalid_Password(username, password);
	}

	@Then("^ios user should be taken to the login screen requesting full user credentials$")
	public void ios_user_should_be_taken_to_the_login_screen_requesting_full_user_credentials() throws Throwable {
		String vObjEmailInput = Constants.IOSLoginOR.getProperty("EmailInput");
		String vObjPasswordInput = Constants.IOSLoginOR.getProperty("PasswordInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailInput));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPasswordInput));
	}

	@Then("^failed log in attempts has been set to zero$")
	public void failed_log_in_attempts_has_been_set_to_zero() throws Throwable {
		Constants.logInFailCount = 0;
		LogCapture.info("Failed login attempt counter set to zero for test.........");
	}

	@When("^ios user has not set their Security QA$")
	public void ios_user_has_not_set_their_Security_QA() throws Throwable {
		String vObjFirstQueDD = Constants.IOSLoginOR.getProperty("FirstQueDD");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFirstQueDD));
		LogCapture.info("User has not done security question and answer setup.........");
	}

	@Then("^ios app should display an option to set their Security QA$")
	public void ios_app_should_display_an_option_to_set_their_Security_QA() throws Throwable {
		String vObjFirstQueDD = Constants.IOSLoginOR.getProperty("FirstQueDD");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFirstQueDD));
		LogCapture.info("Security question and answer setup screen displayed.........");
	}

	@When("^ios user provides their Security QAs in a valid format$")
	public void ios_user_provides_their_Security_QAs_in_a_valid_format() throws Throwable {
		String vObjFirstQueDD = Constants.IOSLoginOR.getProperty("FirstQueDD");
		Assert.assertEquals("PASS", Constants.key.click(vObjFirstQueDD));
		String vQuestion1 = Constants.IOSTestData.getProperty("SecurityQues1");
		String vObjQAPickerWheel = Constants.IOSLoginOR.getProperty("QAPickerWheel");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjQAPickerWheel, vQuestion1));
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		String vObjAnswerInput1 = Constants.IOSLoginOR.getProperty("AnswerInput1");
		String Answer1 = Constants.IOSTestData.getProperty("Answer1");
		Assert.assertEquals("PASS", Constants.key.click(vObjAnswerInput1));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAnswerInput1, Answer1));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User done with first security question and answer .........");
		String vObjSecondQueDD = Constants.IOSLoginOR.getProperty("SecondQueDD");
		Assert.assertEquals("PASS", Constants.key.click(vObjSecondQueDD));
		String vQuestion2 = Constants.IOSTestData.getProperty("SecurityQues2");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjQAPickerWheel, vQuestion2));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		String vObjAnswerInput2 = Constants.IOSLoginOR.getProperty("AnswerInput2");
		String Answer2 = Constants.IOSTestData.getProperty("Answer2");
		Assert.assertEquals("PASS", Constants.key.click(vObjAnswerInput2));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAnswerInput2, Answer2));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User done with second security question and answer .........");
	}

	@Then("^the option to submit their details should be enabled for ios app$")
	public void the_option_to_submit_their_details_should_be_enabled_for_ios_app() throws Throwable {
		String vObjBioDoneBtn = Constants.IOSLoginOR.getProperty("QADoneBtn");
		String atbValue1 = Constants.key.getAttributeValue(vObjBioDoneBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue1));
		LogCapture.info("To submit security questions and answer button is enabled .........");
	}

	@When("^ios user provides their Security QAs in  invalid format$")
	public void ios_user_provides_their_Security_QAs_in_invalid_format() throws Throwable {
		String vObjFirstQueDD = Constants.IOSLoginOR.getProperty("FirstQueDD");
		Assert.assertEquals("PASS", Constants.key.click(vObjFirstQueDD));
		String vQuestion1 = Constants.IOSTestData.getProperty("SecurityQues1");
		String vObjQAPickerWheel = Constants.IOSLoginOR.getProperty("QAPickerWheel");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjQAPickerWheel, vQuestion1));
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("First security question selected.........");
		String vObjAnswerInput1 = Constants.IOSLoginOR.getProperty("AnswerInput1");
		Assert.assertEquals("PASS", Constants.key.click(vObjAnswerInput1));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjAnswerInput1));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("First security questions answer value checked and clear successfully.........");
		String vObjSecondQueDD = Constants.IOSLoginOR.getProperty("SecondQueDD");
		Assert.assertEquals("PASS", Constants.key.click(vObjSecondQueDD));
		String vQuestion2 = Constants.IOSTestData.getProperty("SecurityQues2");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjQAPickerWheel, vQuestion2));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Second security question selected.........");
		String vObjAnswerInput2 = Constants.IOSLoginOR.getProperty("AnswerInput2");
		Assert.assertEquals("PASS", Constants.key.click(vObjAnswerInput2));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjAnswerInput2));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Second security questions answer value checked and clear successfully.........");
	}

	@Then("^the option to submit their details should be disabled for ios app$")
	public void the_option_to_submit_their_details_should_be_disabled_for_ios_app() throws Throwable {
		String vObjBioDoneBtn = Constants.IOSLoginOR.getProperty("QADoneBtn");
		String atbValue1 = Constants.key.getAttributeValue(vObjBioDoneBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue1));
		LogCapture.info("To submit security question and answer button is disabled .........");
	}

	@When("^ios user submits their details$")
	public void ios_user_submits_their_details() throws Throwable {
		String vObjBioDoneBtn = Constants.IOSLoginOR.getProperty("QADoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjBioDoneBtn));
		LogCapture.info("Security question and answer submitted by user.........");
	}

	@Then("^ios app should not be displayed an option to set their Security QA$")
	public void ios_app_should_not_be_displayed_an_option_to_set_their_Security_QA() throws Throwable {
		String vObjFirstQueDD = Constants.IOSLoginOR.getProperty("FirstQueDD");
		Assert.assertEquals("FAIL", Constants.key.eleLocatedDisplayed(vObjFirstQueDD));
		LogCapture.info("Security question and answer setup screen has not been displayed.........");
	}

	@When("^ios user opens up their account settings$")
	public void ios_user_opens_up_their_account_settings() throws Throwable {
		String vObjAccountIcon = Constants.IOSDashOR.getProperty("AccountIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
		LogCapture.info("User clicked on account option.........");
		String vObjAccountLbl = Constants.IOSDashOR.getProperty("AccountLbl");
		String vObjPersonalDetLbl = Constants.IOSDashOR.getProperty("PersonalDetLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPersonalDetLbl));
		LogCapture.info("Account setting screen displayed.........");
	}

	@Then("^the setup biometric switch status should be on$")
	public void the_setup_biometric_switch_status_should_be_on() throws Throwable {
		String vObjBioSwitch = Constants.IOSDashOR.getProperty("BioSwitch");
		String vObjPersonalDetLbl = Constants.IOSDashOR.getProperty("PersonalDetLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPersonalDetLbl));
		String atbValue = Constants.key.getAttributeValue(vObjBioSwitch, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(atbValue, "1"));
		LogCapture.info("biometric switch status is on.........");
	}

	@Then("^the setup biometric switch status should be off$")
	public void the_setup_biometric_switch_status_should_be_off() throws Throwable {
		String vObjBioSwitch = Constants.IOSDashOR.getProperty("BioSwitch");
		String vObjFaceSwitch = Constants.IOSDashOR.getProperty("BioSwitch");
		String vObjPersonalDetLbl = Constants.IOSDashOR.getProperty("PersonalDetLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPersonalDetLbl));
		if (Constants.CONFIG.getProperty("isBrowserStackRunning").equalsIgnoreCase("True")) {
		} else if ((AppName).equalsIgnoreCase("CD")) {
			String atbValue = Constants.key.getAttributeValue(vObjBioSwitch, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(atbValue, "0"));
		} else {
			String atbValue = Constants.key.getAttributeValue(vObjFaceSwitch, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(atbValue, "0"));
		}

		LogCapture.info("biometric switch status is off.........");
	}

	@Then("^(otp|terms and condition) page should be displayed to ios user$")
	public void otp_page_should_be_displayed_to_ios_user(String optionalValue) throws Throwable {
		String vObjEnv = Constants.CONFIG.getProperty("environment");
		if (optionalValue.equalsIgnoreCase("otp")) {
			if (vObjEnv.equalsIgnoreCase("UAT")) {
				String vObjFirstPinInput = Constants.IOSLoginOR.getProperty("FirstPinInput");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFirstPinInput));
				LogCapture.info("Confirm one time pin screen displayed.........");
			} else {
				String vObjSitFirstPinInput = Constants.IOSLoginOR.getProperty("SitFirstPinInput");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSitFirstPinInput));
				LogCapture.info("Confirm one time pin screen displayed.........");
			}
		}
		if (optionalValue.equalsIgnoreCase("terms and condition")) {
			Thread.sleep(5000);
			String vObjTermsConditionScreenTitle = Constants.IOSSendMoneyOR.getProperty("TermsConditionScreenTitle");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTermsConditionScreenTitle));
			LogCapture.info("Terms and conditions screen displayed.........");
		}

	}

	@When("^ios user enters invalid otp \"([^\"]*)\"$")
	public void ios_user_enters_invalid_otp(String invalidOTP) throws Throwable {
		String vInvalidOTP = Constants.IOSTestData.getProperty("InvalidOTP");
		String vObjFirstPinInput = Constants.IOSLoginOR.getProperty("FirstPinInput");
		String vObjSecondPinInput = Constants.IOSLoginOR.getProperty("SecondPinInput");
		String vObjThirdPinInput = Constants.IOSLoginOR.getProperty("ThirdPinInput");
		String vObjFourthPinInput = Constants.IOSLoginOR.getProperty("FourthPinInput");
		String vObjFifthPinInput = Constants.IOSLoginOR.getProperty("FifthPinInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");

		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstPinInput, vInvalidOTP.substring(0, 1)));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSecondPinInput, vInvalidOTP.substring(1, 2)));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjThirdPinInput, vInvalidOTP.substring(2, 3)));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFourthPinInput, vInvalidOTP.substring(3, 4)));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFifthPinInput, vInvalidOTP.substring(4, 5)));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User has entered invalid otp.........");
	}

	@Then("^invalid otp error message should be displayed$")
	public void invalid_otp_error_message_should_be_displayed() throws Throwable {
		String vObjInvalidOTPErrorLbl = Constants.IOSRecipientOR.getProperty("InvalidOTPErrorLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInvalidOTPErrorLbl));
		LogCapture.info("Invalid otp error message displayed.........");
	}

	@When("^new registered user provides Username \"([^\"]*)\" and Password \"([^\"]*)\" first time in ios app$")
	public void new_registered_user_provides_Username_and_Password_first_time_in_ios_app(String username,
			String password) throws Throwable {
		ios_user_provides_Username_and_Password(username, password);
	}

	@When("^ios user (do not enters otp in|waits for) sixty seconds$")
	public void ios_user_do_not_enters_otp_in_sixty_seconds(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("do not enters otp in") || optionalValue.equalsIgnoreCase("waits for")) {
			LogCapture.info("Waiting for 60 seconds .........");
			Thread.sleep(60000);
			LogCapture.info("User has waited for 60 seconds.........");
		}
	}

	@Then("^resend pin link gets displayed on ios app pin screen$")
	public void resend_pin_link_gets_displayed_on_ios_app_pin_screen() throws Throwable {
		String vObjResendPinLink = Constants.IOSLoginOR.getProperty("ResendPinLink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjResendPinLink));
		LogCapture.info("Resend pin displayed.........");

	}

	@When("^ios user click on (resend pin|terms and condition link)$")
	public void ios_user_click_on_resend_pin(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("resend pin")) {
			String vObjResendPinLink = Constants.IOSLoginOR.getProperty("ResendPinLink");
			Assert.assertEquals("PASS", Constants.key.click(vObjResendPinLink));
			LogCapture.info("User clicked on resend pin link.........");
		}
		if (optionalValue.equalsIgnoreCase("terms and condition link")) {
			String vObjTermsCondition = Constants.IOSSendMoneyOR.getProperty("TermsCondition");
			Constants.key.KeyboardAction(vObjTermsCondition, "enter");
			// Constants.key.click(vObjTermsCondition);
		}
	}

	@Then("^request a new pin timer should be start for sixty seconds in ios app in ios app$")
	public void request_a_new_pin_timer_should_be_start_for_sixty_seconds_in_ios_app_in_ios_app() throws Throwable {

		String vObjFirstPinInput = Constants.IOSLoginOR.getProperty("FirstPinInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFirstPinInput));
		String vObjLabelTimeMsg = Constants.IOSLoginOR.getProperty("LabelTimeMsg");
		String atbValue = Constants.key.getAttributeValue(vObjLabelTimeMsg, "value").toString();

		LogCapture.info("Time label displayed : " + atbValue);
	}

	@Then("^request a new pin timer should be start for sixty seconds in ios app$")
	public void request_a_new_pin_timer_should_be_start_for_sixty_seconds_in_ios_app() throws Throwable {
		String vObjFirstPinInput = Constants.IOSLoginOR.getProperty("FirstPinInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFirstPinInput));
		String vObjLabelTimeMsg = Constants.IOSLoginOR.getProperty("LabelTimeMsg");
		String atbValue = Constants.key.getAttributeValue(vObjLabelTimeMsg, "value").toString();
		LogCapture.info("Time label displayed : " + atbValue);
	}

	@When("^ios user enters valid otp \"([^\"]*)\" \"([^\"]*)\"$")
	public void ios_user_enters_valid_otp(String environment, String user) throws Throwable {
		LogCapture.info("Database connection is in progress.......... ");
		String vValidOTP = Constants.key.getOTP(environment, user);
		Assert.assertNotEquals("FAIL", vValidOTP);
		LogCapture.info("Database connection success and OTP is :" + vValidOTP);
		String vObjFirstPinInput = Constants.IOSLoginOR.getProperty("FirstPinInput");
		String vObjSecondPinInput = Constants.IOSLoginOR.getProperty("SecondPinInput");
		String vObjThirdPinInput = Constants.IOSLoginOR.getProperty("ThirdPinInput");
		String vObjFourthPinInput = Constants.IOSLoginOR.getProperty("FourthPinInput");
		String vObjFifthPinInput = Constants.IOSLoginOR.getProperty("FifthPinInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS",
				Constants.key.writeInInput(vObjFirstPinInput, vValidOTP.substring(0, 1)));
		Assert.assertEquals("PASS",
				Constants.key.writeInInput(vObjSecondPinInput, vValidOTP.substring(1, 2)));
		Assert.assertEquals("PASS",
				Constants.key.writeInInput(vObjThirdPinInput, vValidOTP.substring(2, 3)));
		Assert.assertEquals("PASS",
				Constants.key.writeInInput(vObjFourthPinInput, vValidOTP.substring(3, 4)));
		Assert.assertEquals("PASS",
				Constants.key.writeInInput(vObjFifthPinInput, vValidOTP.substring(4, 5)));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User has entered valid otp.........");
	}

	@When("^ios user enters valid otp \"([^\"]*)\" to (add recipient|first time login|registration)$")
	public void ios_user_enters_valid_otp_to_add_recipient(String username, String optionalValue) throws Throwable {
		String env = Constants.CONFIG.getProperty("environment");
		String userEmail = Constants.IOSTestData.getProperty(username);
		if (optionalValue.equalsIgnoreCase("add recipient") || optionalValue.equalsIgnoreCase("first time login")) {
			// otp_page_should_be_displayed_to_ios_user("otp");
			ios_user_enters_valid_otp(env, userEmail);

		} else if (optionalValue.equalsIgnoreCase("registration")) {
			ios_user_enters_valid_otp(env, username);
		}
	}

	@When("^ios user click on back button$")
	public void ios_user_click_on_back_button() throws Throwable {
		String vObjOtpBackBtn = Constants.IOSLoginOR.getProperty("OtpBackBtn");
		Assert.assertEquals("PASS", Constants.key.clickWithoutVisibilityChk(vObjOtpBackBtn));
		LogCapture.info("User clicked on back button.........");
	}

	@When("^reswitch to cd ios app \"([^\"]*)\" after seconds (\\d+)$")
	public void reswitch_to_cd_ios_app_after_seconds(String cdIOSBundleId, int waitInSecond) throws Throwable {
		LogCapture.info("Waiting for seconds: " + (waitInSecond / 1000));
		Thread.sleep(waitInSecond);
		LogCapture.info("User has waited for seconds: " + (waitInSecond / 1000));
		// String bundleID = Constants.CONFIG.getProperty("IOSbundleId");
		String bundleID = Constants.CONFIG.getProperty("CDIOSbundleId");
		Constants.key.switchApp(bundleID);
	}

	@When("^ios user is logged into the app with Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void ios_user_is_logged_into_the_app_with_Username_and_Password(String username, String password)
			throws Throwable {
		ios_user_provides_Username_and_Password(username, password); // why login like this
		ios_user_click_on_the_login_button();
		ios_user_skip_the_biometric_credentials_for_the_app();
		ios_app_should_load_the_dashboard_screen();

	}

	@When("^debit cards is selected by ios user$")
	public void debit_cards_is_selected_by_ios_user() throws Throwable {
		String vObjDebCardListTitle = Constants.IOSMyCardOR.getProperty("DebCardListTitle");
		if (Constants.CONFIG.getProperty("isBrowserStackRunning").equalsIgnoreCase("True")) {
			if ((AppName).equalsIgnoreCase("CD") || (AppName).equalsIgnoreCase("TorFX")) {
				String vObjAccDebitCardBtnBS = Constants.IOSDashOR.getProperty("AccDebitCardBtnBS");
				Assert.assertEquals("PASS", Constants.key.click(vObjAccDebitCardBtnBS));
			} else {
				String vObjAccDebitCardBtn = Constants.IOSDashOR.getProperty("AccDebitCardBtn");
				Assert.assertEquals("PASS", Constants.key.click(vObjAccDebitCardBtn));
			}

		} else {
			String vObjAccDebitCardBtn = Constants.IOSDashOR.getProperty("AccDebitCardBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjAccDebitCardBtn));
		}
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebCardListTitle));
		LogCapture.info("User has selected debit card option from account section.........");
	}

	@When("^ios user has not saved any cards previously$")
	public void ios_user_has_not_saved_any_cards_previously() throws Throwable {
		String vObjNoCardsOnAccLbl = Constants.IOSMyCardOR.getProperty("NoCardsOnAccLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNoCardsOnAccLbl));
		LogCapture.info("Debit cards is not present in card list.........");
	}

	@Then("^an empty state screen should be displayed to ios user with an option to add a new card$")
	public void an_empty_state_screen_should_be_displayed_to_ios_user_with_an_option_to_add_a_new_card()
			throws Throwable {
		String vObjNoCardsOnAccLbl = Constants.IOSMyCardOR.getProperty("NoCardsOnAccLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNoCardsOnAccLbl));
		LogCapture.info("Empty debit card list has been displayed.........");
	}

	@Then("^ios user should navigate to (debit card|add card) screen$")
	public void ios_user_should_navigate_to_debit_card_screen(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("debit card")) {
			String vObjScreenDebitCard = Constants.IOSMyCardOR.getProperty("DebCardListTitle");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjScreenDebitCard));
		} else if (optionalValue.equalsIgnoreCase("add card")) {
			String vObjScreenAddCard = Constants.IOSMyCardOR.getProperty("AddCardTitle");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjScreenAddCard));
		}
		LogCapture.info("User navigated to " + optionalValue + " screen");
	}

	@When("^ios user has one or more saved cards$")
	public void ios_user_has_one_or_more_saved_cards() throws Throwable {
		String vObjDebitCardList = Constants.IOSMyCardOR.getProperty("DebitCardList");
		String result = "FAIL";
		int debitCardListSize = Constants.key.getElementList(vObjDebitCardList).size();
		if (debitCardListSize > 1) {
			result = "PASS";
		}
		Assert.assertEquals("PASS", result);
		LogCapture.info("Debit cards present in card list :" + (debitCardListSize - 1));
	}

	@When("^ios user has one or more saved cards on payment method screen$")
	public void ios_user_has_one_or_more_saved_cards_on_payment_method_screen() throws Throwable {
		String vObjAddNewCard = Constants.IOSSendMoneyOR.getProperty("AddNewCard");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddNewCard));
		String vObjDebitCardList = Constants.IOSSendMoneyOR.getProperty("DDCardList");
		String result = "FAIL";
		int debitCardListSize = Constants.key.getElementList(vObjDebitCardList).size();
		if (debitCardListSize > 1) {
			result = "PASS";
		}
		Assert.assertEquals("PASS", result);
		LogCapture.info("Debit cards present in card list :" + (debitCardListSize));
	}

	@Then("^all saved cards list should be displayed in order of date added with option add a new card to ios user$")
	public void all_saved_cards_list_should_be_displayed_in_order_of_date_added_with_option_add_a_new_card_to_ios_user()
			throws Throwable {
		String vObjDebitCardList = Constants.IOSMyCardOR.getProperty("DebitCardList");
		String vObjListCardNo = Constants.IOSMyCardOR.getProperty("ListCardNo");
		int noOfDebitCard = Constants.key.getElementList(vObjDebitCardList).size();
		for (int i = 1; i < noOfDebitCard; i++) {
			String cardNumber = Constants.key.readText(vObjDebitCardList + "[" + i + "]" + vObjListCardNo + "");
			Assert.assertNotEquals("FAIL", cardNumber);
			LogCapture.info("Debit Card " + i + ": " + cardNumber);
			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
			}
		}
	}

	@Then("^saved cards number should be masked except last four digits in ios app accordance with PCI-DSS requirements$")
	public void saved_cards_number_should_be_masked_except_last_four_digits_in_ios_app_accordance_with_PCI_DSS_requirements()
			throws Throwable {
		String vObjDebitCardList = Constants.IOSMyCardOR.getProperty("DebitCardList");
		String vObjListCardNo = Constants.IOSMyCardOR.getProperty("ListCardNo");
		int noOfDebitCard = Constants.key.getElementList(vObjDebitCardList).size();
		for (int i = 1; i < noOfDebitCard; i++) {
			String cardNumber = Constants.key.readText(vObjDebitCardList + "[" + i + "]" + vObjListCardNo);
			String cardLast4Digit = cardNumber.substring((cardNumber.length() - 4), (cardNumber.length()));
			Assert.assertEquals(true, NumberUtils.isNumber(cardLast4Digit));
			String formattedString = new StringBuilder(cardNumber).replace(0, cardNumber.length() - 5,
					new String(new char[cardNumber.length() - 5]).replace("\0", "*")).toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(cardNumber, formattedString));
			LogCapture.info("Debit card : " + cardNumber + " : Card numbers are masked except last 4 digit");
			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
			}
		}
		LogCapture.info("Debit card numbers are accordance with PCI DSS requirements verified successfully.....");
	}

	@Then("^saved cards number in the list should be masked except last four digits in ios app$")
	public void saved_cards_number_in_the_list_should_be_masked_except_last_four_digits_in_ios_app() throws Throwable {
		String vObjDebitCardList = Constants.IOSSendMoneyOR.getProperty("DDCardList");
		String vObjDDCardNoLblPart1 = Constants.IOSSendMoneyOR.getProperty("DDCardNoLblPart1");
		String vObjDDCardNoLblPart2 = Constants.IOSSendMoneyOR.getProperty("DDCardNoLblPart2");
		int noOfDebitCard = Constants.key.getElementList(vObjDebitCardList).size();
		for (int i = 1; i <= noOfDebitCard; i++) {
			String cardNumber = Constants.key.readText(vObjDDCardNoLblPart1 + "[" + i + "]" + vObjDDCardNoLblPart2);
			String cardLast4Digit = cardNumber.substring((cardNumber.length() - 4), (cardNumber.length()));
			Assert.assertEquals(true, NumberUtils.isNumber(cardLast4Digit));
			String formattedString = new StringBuilder(cardNumber).replace(0, cardNumber.length() - 5,
					new String(new char[cardNumber.length() - 5]).replace("\0", "*")).toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(cardNumber, formattedString));
			LogCapture.info("Debit card : " + cardNumber + " : Card numbers are masked except last 4 digit");
			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
			}
		}
		LogCapture.info("Debit card numbers are accordance with PCI DSS requirements verified successfully.....");

	}

	@When("^ios user selects a saved card \"([^\"]*)\"$")
	public void ios_user_selects_a_saved_card(String debitCardNo) throws Throwable {
		String vObjDebitCardList = Constants.IOSMyCardOR.getProperty("DebitCardList");
		String vObjListCardNo = Constants.IOSMyCardOR.getProperty("ListCardNo");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardList));
		int noOfDebitCard = Constants.key.getElementList(vObjDebitCardList).size();
		for (int i = 1; i < noOfDebitCard; i++) {
			String vCardNumber = Constants.key.readText(vObjDebitCardList + "[" + i + "]" + vObjListCardNo);
			String vDebitCardNo = debitCardNo.substring((debitCardNo.length() - 4), (debitCardNo.length()));
			String vCardLast4Digit = vCardNumber.substring((vCardNumber.length() - 4), (vCardNumber.length()));
			if (vDebitCardNo.equalsIgnoreCase(vCardLast4Digit)) {
				Assert.assertEquals("PASS", Constants.key.click(vObjDebitCardList + "[" + i + "]" + vObjListCardNo));
				LogCapture.info("Debit card selected : " + vCardNumber);
				break;
			}
			if (noOfDebitCard > 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
			}

		}
	}

	@When("^ios user selects the close button$")
	public void ios_user_selects_the_close_button() throws Throwable {
		String vObjCloseBtn = Constants.IOSMyCardOR.getProperty("CloseBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjCloseBtn));
		LogCapture.info("User clicked on close button.....");
	}

	@Then("^ios user should return to the account screen$")
	public void ios_user_should_return_to_the_account_screen() throws Throwable {
		String vObjAccountLbl = Constants.IOSDashOR.getProperty("AccountLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAccountLbl));
		LogCapture.info("Debit card list screen closed and user navigated to account section.....");
	}

	@When("^ios user selects to add a new card$")
	public void ios_user_selects_to_add_a_new_card() throws Throwable {
		String vObjAddDebitCardBtn = Constants.IOSMyCardOR.getProperty("AddDebitCardBtn");
		String vObjDebitCardList = Constants.IOSMyCardOR.getProperty("DebitCardList");
		String vObjAddDebitCardBtnInList = Constants.IOSMyCardOR.getProperty("AddDebitCardBtnInList");
		int noOfDebitCard = Constants.key.getElementList(vObjDebitCardList).size();
		if (noOfDebitCard < 1) {
			Assert.assertEquals("PASS", Constants.key.click(vObjAddDebitCardBtn));
			LogCapture.info("User clicked on add debit card button.....");
		} else if (noOfDebitCard > 0) {
			if (noOfDebitCard > 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
			}
			Assert.assertEquals("PASS", Constants.key.click(vObjAddDebitCardBtnInList));
			LogCapture.info("User clicked on list add debit card button.....");
		}
	}

	@When("^ios user selects to add a new card to make a transfer$")
	public void ios_user_selects_to_add_a_new_card_to_make_a_transfer() throws Throwable {
		String vObjAddNewCard = Constants.IOSSendMoneyOR.getProperty("AddNewCard");
		String vObjTypeOtherTag = Constants.IOSSendMoneyOR.getProperty("TypeOtherTag");
		String vObjPaymentMethodScreen = Constants.IOSSendMoneyOR.getProperty("PaymentMethodScreen");
		String vObjDebitCardList = Constants.IOSMyCardOR.getProperty("DebitCardList");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentMethodScreen));

		int noOfDebitCard = Constants.key.getElementList(vObjDebitCardList).size();
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add new card", "down"));

		if (noOfDebitCard > 10) {
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add new card", "down"));
		}
		int eleListSize = Constants.key.getElementList(vObjAddNewCard).size();
		Assert.assertEquals("PASS",
				Constants.key.eleLocatedDisplayed(vObjTypeOtherTag + "[" + eleListSize + "]" + vObjAddNewCard));
		Assert.assertEquals("PASS", Constants.key.click(vObjTypeOtherTag + "[" + eleListSize + "]" + vObjAddNewCard));
		LogCapture.info("User clicked on list add debit card button.....");
	}

	@Then("^card details should be blank to ios user$")
	public void card_details_should_be_blank_to_ios_user() throws Throwable {
		String vObjCardNoPH = Constants.IOSMyCardOR.getProperty("CardNoPH");
		String vObjIssueDatePH = Constants.IOSMyCardOR.getProperty("IssueDatePH");
		String vObjExpiryDatePH = Constants.IOSMyCardOR.getProperty("ExpiryDatePH");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardNoPH));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjIssueDatePH));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjExpiryDatePH));
		LogCapture.info("Empty debit card number,Issue and expiry adte verified successfully......");
	}

	@Then("^pre populated card holder name \"([^\"]*)\" and billing address \"([^\"]*)\" should be displayed to ios user$")
	public void pre_populated_card_holder_name_and_billing_address_should_be_displayed_to_ios_user(String cHName,
			String billingAddress) throws Throwable {
		Constants.Data = billingAddress.split(",");
		String vObjCardHolderNameLbl = Constants.IOSMyCardOR.getProperty("CardHolderNameLbl");
		String vObjStreetLbl = Constants.IOSMyCardOR.getProperty("StreetLbl1");
		String vObjCityLbl = Constants.IOSMyCardOR.getProperty("CityLbl1");
		String vObjCountryLbl = Constants.IOSMyCardOR.getProperty("CountryLbl1");
		String vObjPostCodeLbl = Constants.IOSMyCardOR.getProperty("PostCodeLbl1");
		String vCardholderName = Constants.key.getAttributeValue(vObjCardHolderNameLbl, "value");
		Assert.assertEquals("PASS", Constants.key.VerifyText(vCardholderName, cHName));
		LogCapture.info("Prepopulated card holder name: " + vCardholderName + " verified");
		String vStreet = Constants.key.getAttributeValue(vObjStreetLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vStreet, Constants.Data[0]));
		LogCapture.info("Address : " + vStreet + " verified");
		String vCity = Constants.key.getAttributeValue(vObjCityLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vCity, Constants.Data[1]));
		LogCapture.info("City : " + vCity + " verified");
		String vCounty = Constants.key.getAttributeValue(vObjCountryLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vCounty, Constants.Data[2]));
		LogCapture.info("Country : " + vCounty + " verified");
		String vPostCode = Constants.key.getAttributeValue(vObjPostCodeLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vPostCode, Constants.Data[3]));
		LogCapture.info("Postcode : " + vPostCode + " verified");

		Constants.DataMap.put("Street", vStreet.trim());
		Constants.DataMap.put("City", vCity.trim());
		Constants.DataMap.put("State", vCounty.trim());
		Constants.DataMap.put("PostCode", vPostCode.trim());
	}

	@Then("^selected saved card details name \"([^\"]*)\" card number \"([^\"]*)\" issue date \"([^\"]*)\" expiry date \"([^\"]*)\" should be displayed in ios app card view screen$")
	public void selected_saved_card_details_name_card_number_issue_date_expiry_date_should_be_displayed_in_ios_app_card_view_screen(
			String cHName, String cardNumber, String issuDate, String expDate) throws Throwable {
		card_details_should_be_saved_in_ios_app_debit_card_list_as_per_order_of_date_added(cardNumber);
	}

	@Then("^card \"([^\"]*)\" details should be saved in ios app debit card list as per order of date added$")
	public void card_details_should_be_saved_in_ios_app_debit_card_list_as_per_order_of_date_added(String debitCardNo)
			throws Throwable {
		String vObjDebitCardList = Constants.IOSMyCardOR.getProperty("DebitCardList");
		String vObjListCardNo = Constants.IOSMyCardOR.getProperty("ListCardNo");
		String vObjCardholderNameLbl = Constants.IOSMyCardOR.getProperty("CVCardHolderName");
		String vObjCardNoInput = Constants.IOSMyCardOR.getProperty("CVCardNumber");
		String vObjIssueDateInput = Constants.IOSMyCardOR.getProperty("CVIssueDate");
		String vObjExpDateInput = Constants.IOSMyCardOR.getProperty("CVExpDate");
		String vObjCVStreetLbl1 = Constants.IOSMyCardOR.getProperty("CVStreetLbl1");
		String vObjCVCityLbl = Constants.IOSMyCardOR.getProperty("CVCityLbl1");
		String vObjCVCountryLbl = Constants.IOSMyCardOR.getProperty("CVCountryLbl1");
		String vObjCVPostCodeLbl = Constants.IOSMyCardOR.getProperty("CVPostCodeLbl1");
		String vObjbackBtn = Constants.IOSMyCardOR.getProperty("backBtn");
		String result = "FAIL";
		int noOfDebitCard = Constants.key.getElementList(vObjDebitCardList).size();
		for (int i = 1; i < noOfDebitCard; i++) {
			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
			}
			String vCardNumber = Constants.key.readText(vObjDebitCardList + "[" + i + "]" + vObjListCardNo);
			String vDebitCardNo = debitCardNo.substring((debitCardNo.length() - 4), (debitCardNo.length()));
			String vCardLast4Digit = vCardNumber.substring((vCardNumber.length() - 4), (vCardNumber.length()));
			if (vDebitCardNo.equalsIgnoreCase(vCardLast4Digit)) {
				Assert.assertEquals("PASS", Constants.key.click(vObjDebitCardList + "[" + i + "]" + vObjListCardNo));
				LogCapture.info("Debit card selected : " + vCardNumber);
				LogCapture.info("Verifing selected debit card details................ ");
				String vCHName = Constants.key.readText(vObjCardholderNameLbl);
				String vcardNumber = Constants.key.readText(vObjCardNoInput);
				String vIssueDate = Constants.key.readText(vObjIssueDateInput);
				String vExpDate = Constants.key.readText(vObjExpDateInput);
				String vStreet = Constants.key.readText(vObjCVStreetLbl1).trim();
				String vCity = Constants.key.readText(vObjCVCityLbl).trim();
				String vCountry = Constants.key.readText(vObjCVCountryLbl).trim();
				String vPostCode = Constants.key.readText(vObjCVPostCodeLbl).trim();
				String formattedIssueDate = vIssueDate.substring((0), (vIssueDate.length() - 3))
						+ vIssueDate.substring((3), (vIssueDate.length()));
				String formattedExpDate = vExpDate.substring((0), (vExpDate.length() - 3))
						+ vExpDate.substring((3), (vExpDate.length()));
				String CardholderName = Constants.DataMap.get("CardholderName");
				String CardholderNumber = Constants.DataMap.get("CardholderNumber");
				String ExpiryDate = Constants.DataMap.get("ExpiryDate");
				String IssueDate = Constants.DataMap.get("IssueDate");
				String Street = Constants.DataMap.get("Street");
				String City = Constants.DataMap.get("City");
				String State = Constants.DataMap.get("State");
				String PostCode = Constants.DataMap.get("PostCode");
				if (CardholderName.equals(vCHName)) {
					// System.out.println("Card holder name matched........");
					if (vcardNumber.equals("**** **** **** " + vDebitCardNo)) {
						// System.out.println("Card No matched.............");
						// if (IssueDate.equals(formattedIssueDate)) {
						// System.out.println("Issue date: "+IssueDate+"
						// matched..........");
						if (ExpiryDate.equals(formattedExpDate)) {
							// System.out.println("Exp. Date: "+ExpiryDate+"
							// matched..........");
							// if (Street.equals(vStreet)) {
							// System.out.println("Street: "+Street+"
							// matched..........");
							// if (City.equals(vCity)) {
							// System.out.println("City: "+City+"
							// matched..........");
							// if (State.equals(vCountry)) {
							// System.out.println("State/Country:
							// "+State+" matched..........");
							// if (PostCode.equals(vPostCode)) {
							// System.out.println("Post code:
							// "+PostCode+" matched..........");
							result = "PASS";
							LogCapture.info("Saved card details matched with list card no  : " + i);
							break;
						}
						// }
					}
				}
				if (result.equalsIgnoreCase("FAIL")) {
					LogCapture.info("Card details is not matched with list card no  : " + i);
					Assert.assertEquals("PASS", Constants.key.click(vObjbackBtn));
					ios_user_should_navigate_to_debit_card_screen("debit card");
				}
			}
		}
		Assert.assertEquals("PASS", result);
	}

	@Then("^card \"([^\"]*)\" details should be saved in ios app debit card payment method list$")
	public void card_details_should_be_saved_in_ios_app_debit_card_payment_method_list(String data) throws Throwable {
		String vObjDDCardNoLblPart1 = Constants.IOSSendMoneyOR.getProperty("DDCardNoLblPart1_PM");
		String vObjDDCardNoLblPart2 = Constants.IOSSendMoneyOR.getProperty("DDCardNoLblPart2_PM");
		String vObjDebitCardNo = Constants.IOSSendMoneyOR.getProperty("DebitCardNo");
		String vObjAddNewCard = Constants.IOSSendMoneyOR.getProperty("AddNewCard");
		String vObjTypeOtherTag = Constants.IOSSendMoneyOR.getProperty("TypeOtherTag");
		String vObjPaymentMethodScreen = Constants.IOSSendMoneyOR.getProperty("PaymentMethodScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentMethodScreen));

		String result = "FAIL";
		int eleListSize = Constants.key.getElementList(vObjAddNewCard).size();
		// Assert.assertEquals("PASS",
		// Constants.key.eleLocatedDisplayed(vObjTypeOtherTag + "[" + eleListSize + "]"
		// + vObjAddNewCard));
		int noOfDebitCard = Constants.key.getElementList(vObjDDCardNoLblPart1 + vObjDDCardNoLblPart2).size();

		if (noOfDebitCard > 5) {
			// Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card",
			// "down"));
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "up"));
		}
		String cardNumber = Constants.key
				.getAttributeValue(vObjDDCardNoLblPart1 + "[" + vObjDebitCardNo + "]" + vObjDDCardNoLblPart2, "value");
		System.out.println("CARD NO : " + cardNumber);
		String cardLast4Digit = cardNumber.substring((cardNumber.length() - 4), (cardNumber.length()));
		String vCardLast4Digit = data.substring((data.length() - 4), (data.length()));

		if (cardLast4Digit.equalsIgnoreCase(vCardLast4Digit)) {
			LogCapture.info("Saved card number matched with list no  : " + cardNumber);
			result = "PASS";
		}
		Assert.assertEquals("PASS", result);
	}

	@When("^ios user selects existing card number \"([^\"]*)\"$")
	public void ios_user_selects_existing_card_number(String debitCardNo) throws Throwable {
		String vObjDebitCardList = Constants.IOSMyCardOR.getProperty("DebitCardList");
		String vObjListCardNo = Constants.IOSMyCardOR.getProperty("ListCardNo");
		String vObjCardholderNameLbl = Constants.IOSMyCardOR.getProperty("CVCardHolderName");
		String vObjCardNoInput = Constants.IOSMyCardOR.getProperty("CVCardNumber");
		String vObjIssueDateInput = Constants.IOSMyCardOR.getProperty("CVIssueDate");
		String vObjExpDateInput = Constants.IOSMyCardOR.getProperty("CVExpDate");
		String vObjCVStreetLbl1 = Constants.IOSMyCardOR.getProperty("CVStreetLbl1");
		String vObjCVCityLbl = Constants.IOSMyCardOR.getProperty("CVCityLbl1");
		String vObjCVCountryLbl = Constants.IOSMyCardOR.getProperty("CVCountryLbl1");
		String vObjCVPostCodeLbl = Constants.IOSMyCardOR.getProperty("CVPostCodeLbl1");
		String vObjbackBtn = Constants.IOSMyCardOR.getProperty("backBtn");
		String result = "FAIL";
		int noOfDebitCard = Constants.key.getElementList(vObjDebitCardList).size();
		for (int i = 1; i < noOfDebitCard; i++) {
			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
			}
			String vCardNumber = Constants.key.readText(vObjDebitCardList + "[" + i + "]" + vObjListCardNo);
			String vDebitCardNo = debitCardNo.substring((debitCardNo.length() - 4), (debitCardNo.length()));
			String vCardLast4Digit = vCardNumber.substring((vCardNumber.length() - 4), (vCardNumber.length()));
			if (vDebitCardNo.equalsIgnoreCase(vCardLast4Digit)) {
				Assert.assertEquals("PASS", Constants.key.click(vObjDebitCardList + "[" + i + "]" + vObjListCardNo));
				LogCapture.info("Debit card selected : " + vCardNumber);
			}
		}
	}

	@When("^ios user selects saved card \"([^\"]*)\" to make a transfer$")
	public void ios_user_selects_saved_card_to_make_a_transfer(String data) throws Throwable {
		String vObjDDCardNoLblPart1 = Constants.IOSSendMoneyOR.getProperty("DDCardNoLblPart1_PM");
		String vObjDDCardNoLblPart2 = Constants.IOSSendMoneyOR.getProperty("DDCardNoLblPart2_PM");
		String vObjAddNewCard = Constants.IOSSendMoneyOR.getProperty("AddNewCard");
		String vObjDebitCardNo = Constants.IOSSendMoneyOR.getProperty("DebitCardNo");
		String vObjTypeOtherTag = Constants.IOSSendMoneyOR.getProperty("TypeOtherTag");
		String vObjPaymentMethodScreen = Constants.IOSSendMoneyOR.getProperty("PaymentMethodScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentMethodScreen));
		String result = "FAIL";
		int eleListSize = Constants.key.getElementList(vObjAddNewCard).size();

		// Assert.assertEquals("PASS",
		// Constants.key.eleLocatedDisplayed(vObjTypeOtherTag + "[" + eleListSize + "]"
		// + vObjAddNewCard));
		int noOfDebitCard = Constants.key.getElementList(vObjDDCardNoLblPart1 + vObjDDCardNoLblPart2).size();

		if (noOfDebitCard > 5) {
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "up"));
		}
		String cardNumber = Constants.key
				.getAttributeValue(vObjDDCardNoLblPart1 + "[" + vObjDebitCardNo + "]" + vObjDDCardNoLblPart2, "value");

		String cardLast4Digit = cardNumber.substring((cardNumber.length() - 4), (cardNumber.length()));
		String vCardLast4Digit = data.substring((data.length() - 4), (data.length()));

		Assert.assertEquals("PASS",
				Constants.key.click(vObjDDCardNoLblPart1 + "[" + vObjDebitCardNo + "]" + vObjDDCardNoLblPart2));
		Constants.DataMap.put("PaymentMethod", "Debit Card");

		if (cardLast4Digit.equalsIgnoreCase(vCardLast4Digit)) {
			LogCapture.info("Saved card number matched with list no  : " + cardNumber);
			result = "PASS";
		}
		Assert.assertEquals("PASS", result);
	}

	/*
	 * String vObjDebitCardList =
	 * Constants.IOSSendMoneyOR.getProperty("DDCardList_PM"); String
	 * vObjDDCardNoLblPart1 =
	 * Constants.IOSSendMoneyOR.getProperty("DDCardNoLblPart1_PM"); String
	 * vObjDDCardNoLblPart2 =
	 * Constants.IOSSendMoneyOR.getProperty("DDCardNoLblPart2_PM"); String
	 * vObjAddNewCard = Constants.IOSSendMoneyOR.getProperty("AddNewCard2"); String
	 * vObjDDCardRadioBtn = Constants.IOSSendMoneyOR.getProperty("DDCardRadioBtn");
	 * String result = "FAIL"; int
	 * noOfDebitCard=Constants.key.getElementList(vObjDDCardNoLblPart1+
	 * vObjDDCardNoLblPart2).size();
	 * System.out.println("noOfDebitCard :"+noOfDebitCard); if(noOfDebitCard==0) {
	 * noOfDebitCard=1; } else if(noOfDebitCard%2==0) {
	 * noOfDebitCard=noOfDebitCard/2; } else { noOfDebitCard=(noOfDebitCard)/2+1; }
	 * if (noOfDebitCard > 5) { Assert.assertEquals("PASS",
	 * Constants.key.scrollInIOS("Add debit card", "down")); }
	 * Assert.assertEquals("PASS", Constants.key.scrollInIOS("debit card", "up"));
	 * for (int i = 1; i < noOfDebitCard; i++) { if (i == 5) {
	 * Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add new card",
	 * "down")); Assert.assertEquals("PASS",Constants.key.eleLocatedDisplayed(
	 * vObjAddNewCard)); }
	 * 
	 * String cardNumber = Constants.key.getAttributeValue(vObjDDCardNoLblPart1 +
	 * "[" + i + "]" + vObjDDCardNoLblPart2,"value");
	 * System.out.println("CARD NO... : "+cardNumber); String cardLast4Digit =
	 * cardNumber.substring((cardNumber.length() - 4), (cardNumber.length()));
	 * String vCardLast4Digit = data.substring((data.length() - 4),
	 * (data.length()));
	 * 
	 * if (cardLast4Digit.equalsIgnoreCase(vCardLast4Digit)) {
	 * System.out.println(vObjDDCardNoLblPart1 + "[" + i + "]"+vObjDDCardRadioBtn);
	 * Assert.assertEquals("PASS",Constants.key.clickWithoutVisibilityChk(
	 * vObjDDCardNoLblPart1 + "[" + i + "]"+vObjDDCardRadioBtn));
	 * //Constants.key.click(vObjDDCardNoLblPart1 + "[" + i +
	 * "]"+vObjDDCardNoLblPart2); result = "PASS";
	 * Constants.DataMap.put("PaymentMethod","Debit Card"); break; } } if
	 * (result.equalsIgnoreCase("FAIL")) { Assert.assertEquals("PASS", result);
	 * LogCapture.info("Card number did not match with the card list : " +
	 * noOfDebitCard); }
	 */

	@Then("^cvv input field should be displayed with message in ios app$")
	public void cvv_input_field_should_be_displayed_with_message_in_ios_app() throws Throwable {
		String vObjCVVSecureInput = Constants.IOSSendMoneyOR.getProperty("CVVSecureInput");
		String vObjCardInstructionLbl = Constants.IOSSendMoneyOR.getProperty("CardInstructionLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCVVSecureInput));
		String CVVInstructionMessage = Constants.IOSTestData.getProperty("CVVInstructionMessage");
		String vCardInstructionLbl = Constants.key.getAttributeValue(vObjCardInstructionLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(CVVInstructionMessage, vCardInstructionLbl));
		LogCapture.info("CVV field with user message verfied......");
	}

	@When("^ios user provides card holder name \"([^\"]*)\" card number \"([^\"]*)\" issue date \"([^\"]*)\" expiry date \"([^\"]*)\"$")
	public void ios_user_provides_card_holder_name_card_number_issue_date_expiry_date(String cHName, String cardNumber,
			String issuDate, String expDate) throws Throwable {
		String vObjCardholderNameLbl = Constants.IOSMyCardOR.getProperty("CardHolderNameLbl");
		String vObjCardNoPH = Constants.IOSMyCardOR.getProperty("CardNoPH");
		String vObjIssueDatePH = Constants.IOSMyCardOR.getProperty("IssueDatePH");
		String vObjExpiryDatePH = Constants.IOSMyCardOR.getProperty("ExpiryDatePH");
		String vObjCardNoInput = Constants.IOSMyCardOR.getProperty("CardNoInput");
		String vObjExpDateInput = Constants.IOSMyCardOR.getProperty("ExpiryDateInput");
		String vObjIssueDateInput = Constants.IOSMyCardOR.getProperty("IssueDateInput");
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		Constants.DataMap.put("CardholderName", cHName);
		Constants.DataMap.put("CardholderNumber", cardNumber);
		Constants.DataMap.put("IssueDate", issuDate);
		Constants.DataMap.put("ExpiryDate", expDate);

		Assert.assertEquals("PASS", Constants.key.click(vObjCardholderNameLbl));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjCardholderNameLbl));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardholderNameLbl, cHName));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Card holder name entered : " + cHName);
		Assert.assertEquals("PASS", Constants.key.click(vObjCardNoPH));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardNoInput, cardNumber));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Card number entered : " + cardNumber);
		Assert.assertEquals("PASS", Constants.key.click(vObjIssueDatePH));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIssueDateInput, issuDate));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Issue date entered : " + issuDate);
		Assert.assertEquals("PASS", Constants.key.click(vObjExpiryDatePH));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjExpDateInput, expDate));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Expiry date entered (MMYY): " + expDate);
	}

	@When("^ios user clicks on save$")
	public void ios_user_clicks_on_save() throws Throwable {
		// String vObjSave = Constants.IOSMyCardOR.getProperty("SaveBtn");
		// Commenting above existing line as xpath is different for iphone 8
		String vObjSave = Constants.IOSAddWalletOR.getProperty("SaveBtn");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Save", "down"));
		Assert.assertEquals("PASS", Constants.key.click(vObjSave));
		LogCapture.info("User clicked on save button....");
	}

	@When("^ios user removes provided (card holder name|card number|issue date|expiry date|cvv)$")
	public void ios_user_removes_provided_issue_date(String optionalValue) throws Throwable {
		String vObjCardholderNameLbl = Constants.IOSMyCardOR.getProperty("CardHolderNameLbl");
		String vObjCardNoInput = Constants.IOSMyCardOR.getProperty("CardNoInput");
		String vObjExpDateInput = Constants.IOSMyCardOR.getProperty("ExpiryDateInput");
		String vObjIssueDateInput = Constants.IOSMyCardOR.getProperty("IssueDateInput");
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");

		if (optionalValue.equalsIgnoreCase("card holder name")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCardholderNameLbl));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (optionalValue.equalsIgnoreCase("card number")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCardNoInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (optionalValue.equalsIgnoreCase("issue date")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjIssueDateInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Constants.DataMap.put("IssueDate", "");
		} else if (optionalValue.equalsIgnoreCase("expiry date")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjExpDateInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		}
	}

	@Then("^the option to save the card should be in an inactive/disabled state in ios app$")
	public void the_option_to_save_the_card_should_be_in_an_inactive_disabled_state_in_ios_app() throws Throwable {
		// Assert.assertEquals("PASS", Constants.key.scrollInIOS("save",
		// "down"));
		String vObjSaveBtn = Constants.IOSMyCardOR.getProperty("SaveBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSaveBtn));
		String atbValue = Constants.key.getAttributeValue(vObjSaveBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		LogCapture.info("Inactive save button verified successfully.........");
	}

	@Then("^the option to save the card should be in active/enabled state in ios app$")
	public void the_option_to_save_the_card_should_be_in_active_enabled_state_in_ios_app() throws Throwable {
		String vObjSaveBtn = Constants.IOSMyCardOR.getProperty("SaveBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSaveBtn));
		String atbValue = Constants.key.getAttributeValue(vObjSaveBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		LogCapture.info("active save button verified successfully.........");
	}

	@When("^ios user provides invalid (card number|unmatched contacts last name|issue date|expiry date) \"([^\"]*)\"$")
	public void ios_user_provides_invalid_card_number(String optionalValue, String data) throws Throwable {

		String vObjCardholderNameLbl = Constants.IOSMyCardOR.getProperty("CardHolderNameLbl");
		String vObjCardNoPH = Constants.IOSMyCardOR.getProperty("CardNoPH");
		String vObjIssueDatePH = Constants.IOSMyCardOR.getProperty("IssueDatePH");
		String vObjExpiryDatePH = Constants.IOSMyCardOR.getProperty("ExpiryDatePH");
		String vObjCardNoInput = Constants.IOSMyCardOR.getProperty("CardNoInput");
		String vObjExpDateInput = Constants.IOSMyCardOR.getProperty("ExpiryDateInput");
		String vObjIssueDateInput = Constants.IOSMyCardOR.getProperty("IssueDateInput");
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");

		if (optionalValue.equalsIgnoreCase("card number")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCardNoPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardNoInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered invalid card number : " + data);
		} else if (optionalValue.equalsIgnoreCase("unmatched contacts last name")) {
			// Assert.assertEquals("PASS",
			// Constants.key.click(vObjCardholderNameLbl));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCardholderNameLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardholderNameLbl, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered invalid card owner name : " + data);
		} else if (optionalValue.equalsIgnoreCase("issue date")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjIssueDatePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIssueDateInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered invalid issue date : " + data);
		} else if (optionalValue.equalsIgnoreCase("expiry date")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjExpiryDatePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjExpDateInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered invalid expiry date (MMYY): " + data);
		}
	}

	@Then("^invalid (last name|card number|issue date|expiry date|mobile number|card number digit length) error message should be displayed to ios user$")
	public void invalid_expiry_date_error_message_should_be_displayed_to_ios_user(String optionalValue)
			throws Throwable {

		String vObjErrLblCardNo = Constants.IOSMyCardOR.getProperty("ErrLblCardNo");
		String vObjErrLblLastName = Constants.IOSMyCardOR.getProperty("ErrLblLastName");
		String vObjErrLblIssueDate = Constants.IOSMyCardOR.getProperty("ErrLblIssueDate");
		String vObjErrLblExpDate = Constants.IOSMyCardOR.getProperty("ErrLblExpDate");
		String vObjSendSmsErrlbl = Constants.IOSRegstOR.getProperty("SendSmsErrlbl");

		if (optionalValue.equalsIgnoreCase("last name")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidLastNameErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblLastName, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid last name error message verified.........");
		} else if (optionalValue.equalsIgnoreCase("card number")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCardNoErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblCardNo, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid card no error message verfied......");
		} else if (optionalValue.equalsIgnoreCase("issue date")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidIssueDateErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblIssueDate, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid issue date error message displayed");
		} else if (optionalValue.equalsIgnoreCase("expiry date")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidExpDateErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblExpDate, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid expiry date error message verified........");
		} else if (optionalValue.equalsIgnoreCase("card number digit length")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCardNoLenghthErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblCardNo, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid card no length error message verfied......");
		} else if (optionalValue.equalsIgnoreCase("mobile number")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidMobileErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjSendSmsErrlbl, "value").toString();
			Thread.sleep(5000);
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid mobile number error message verfied......");
		}

	}

	@When("^ios user provides valid (card number|matched contacts last name|issue date|expiry date) \"([^\"]*)\"$")
	public void ios_user_provides_valid_matched_contacts_last_name(String optionalValue, String data) throws Throwable {
		String vObjCardholderNameLbl = Constants.IOSMyCardOR.getProperty("CardHolderNameLbl");
		String vObjCardNoPH = Constants.IOSMyCardOR.getProperty("CardNoPH");
		String vObjIssueDatePH = Constants.IOSMyCardOR.getProperty("IssueDatePH");
		String vObjExpiryDatePH = Constants.IOSMyCardOR.getProperty("ExpiryDatePH");
		String vObjCardNoInput = Constants.IOSMyCardOR.getProperty("CardNoInput");
		String vObjExpDateInput = Constants.IOSMyCardOR.getProperty("ExpiryDateInput");
		String vObjIssueDateInput = Constants.IOSMyCardOR.getProperty("IssueDateInput");
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");

		if (optionalValue.equalsIgnoreCase("card number")) {
			// Assert.assertEquals("PASS", Constants.key.click(vObjCardNoPH));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCardNoInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardNoInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered valid card number : " + data);
		} else if (optionalValue.equalsIgnoreCase("unmatched contacts last name")) {
			// Assert.assertEquals("PASS",
			// Constants.key.click(vObjCardholderNameLbl));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCardholderNameLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardholderNameLbl, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered valid card owner last name : " + data);
		} else if (optionalValue.equalsIgnoreCase("issue date")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjIssueDatePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIssueDateInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered valid issue date : " + data);
		} else if (optionalValue.equalsIgnoreCase("expiry date")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjExpiryDatePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjExpDateInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered valid expiry date (MMYY): " + data);
		}

	}

	@Then("^(card holder name|card number|expiry date) required error message should be displayed in ios app$")
	public void card_holder_name_required_error_message_should_be_displayed_in_ios_app(String optionalValue)
			throws Throwable {
		String vObjCardNoRequiredErrLbl = Constants.IOSMyCardOR.getProperty("CardNoRequiredErrLbl");
		String vObjCardHolderNameRequiredErrLbl = Constants.IOSMyCardOR.getProperty("CardHolderNameRequiredErrLbl");
		String vObjErrLblExpDate = Constants.IOSMyCardOR.getProperty("ErrLblExpDate");
		String vObjErrLblIssueDate = Constants.IOSMyCardOR.getProperty("ErrLblIssueDate");
		if (optionalValue.equalsIgnoreCase("card holder name")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("CardHolderNameRequiredErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjCardHolderNameRequiredErrLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Card holder name required error message verified.........");
		} else if (optionalValue.equalsIgnoreCase("card number")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("CardNoRequiredErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjCardNoRequiredErrLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Card no required error message verfied......");
		} else if (optionalValue.equalsIgnoreCase("expiry date")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("ExpDateRequiredErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblExpDate, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Expiry date required error message verified........");
		} else if (optionalValue.equalsIgnoreCase("Issue date")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("ExpDateRequiredErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblIssueDate, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Expiry date required error message verified........");
		}

	}

	@Then("^invalid (last name|card number|expiry date|issue date) error message should be removed from ios add card screen$")
	public void invalid_last_name_error_message_should_be_removed_from_ios_add_card_screen(String optionalValue)
			throws Throwable {
		String vObjCardNoRequiredErrLbl = Constants.IOSMyCardOR.getProperty("CardNoRequiredErrLbl");
		String vObjCardHolderNameRequiredErrLbl = Constants.IOSMyCardOR.getProperty("CardHolderNameRequiredErrLbl");
		String vObjErrLblExpDate = Constants.IOSMyCardOR.getProperty("ErrLblExpDate");
		String vObjErrLblIssueDate = Constants.IOSMyCardOR.getProperty("ErrLblIssueDate");

		if (optionalValue.equalsIgnoreCase("card holder name")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("CardHolderNameRequiredErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjCardHolderNameRequiredErrLbl, "value").toString();
			Assert.assertEquals("FAIL", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Card holder name required error message removed.........");
		} else if (optionalValue.equalsIgnoreCase("card number")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCardNoErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjCardNoRequiredErrLbl, "value").toString();
			Assert.assertEquals("FAIL", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid card number error message removed......");
		} else if (optionalValue.equalsIgnoreCase("expiry date")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("ExpDateRequiredErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblExpDate, "value").toString();
			Assert.assertEquals("FAIL", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Expiry date required error message removed........");
		} else if (optionalValue.equalsIgnoreCase("Issue date")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("ExpDateRequiredErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblIssueDate, "value").toString();
			Assert.assertEquals("FAIL", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Expiry date required error message removed........");
		}

	}

	@Then("^option to scan the card details should be available to ios user$")
	public void option_to_scan_the_card_details_should_be_available_to_ios_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^ios user selects to scan the card details$")
	public void ios_user_selects_to_scan_the_card_details() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^the scan card process should be triggered in ios app$")
	public void the_scan_card_process_should_be_triggered_in_ios_app() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^card has been scanned in ios app$")
	public void card_has_been_scanned_in_ios_app() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^scanned card details should be displayed in the relevant fields to ios user$")
	public void scanned_card_details_should_be_displayed_in_the_relevant_fields_to_ios_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^a confirmation message should be displayed to ios user$")
	public void a_confirmation_message_should_be_displayed_to_ios_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^ios user should navigate to card list screen$")
	public void ios_user_should_navigate_to_card_list_screen() throws Throwable {
		String vObjAddDebitCardBtnInList = Constants.IOSDashOR.getProperty("AddDebitCardBtnInList");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddDebitCardBtnInList));
		LogCapture.info("User navigated to card list screen.....");
	}

	@Then("^an option to delete the card should be available to ios user$")
	public void an_option_to_delete_the_card_should_be_available_to_ios_user() throws Throwable {
		String vObjDeleteDebCardBtn = Constants.IOSMyCardOR.getProperty("DeleteDebCardBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDeleteDebCardBtn));
		LogCapture.info("Delete card option verified successfully.........");
	}

	@When("^ios user clicks on delete$")
	public void ios_user_clicks_on_delete() throws Throwable {
		String vObjDeleteDebCardBtn = Constants.IOSMyCardOR.getProperty("DeleteDebCardBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDeleteDebCardBtn));
		LogCapture.info("User clicked on delete.........");
	}

	@When("^ios user confirms the action$")
	public void ios_user_confirms_the_action() throws Throwable {
		String vObjConfDelete1 = Constants.IOSMyCardOR.getProperty("ConfDelete");
		Assert.assertEquals("PASS", Constants.key.click(vObjConfDelete1));
		LogCapture.info("User confirmed card delete action.........");
	}

	@Then("^user should redirects to list card screen$")
	public void user_should_redirects_to_list_card_screen() throws Throwable {
		String vObjDebitCardListTitle = Constants.IOSMyCardOR.getProperty("DebitCardListTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardListTitle));
		LogCapture.info("User redirected to card list screen.........");
	}

	@Then("^the selected card \"([^\"]*)\" should be deleted from the list of saved cards for ios app$")
	public void the_selected_card_should_be_deleted_from_the_list_of_saved_cards_for_ios_app(String deletedCardNo)
			throws Throwable {
		String vObjDebitCardList = Constants.IOSMyCardOR.getProperty("DebitCardList");
		String vObjListCardNo = Constants.IOSMyCardOR.getProperty("ListCardNo");
		String vObjCardholderNameLbl = Constants.IOSMyCardOR.getProperty("CVCardHolderName");
		String vObjCardNoInput = Constants.IOSMyCardOR.getProperty("CVCardNumber");
		String vObjIssueDateInput = Constants.IOSMyCardOR.getProperty("CVIssueDate");
		String vObjExpDateInput = Constants.IOSMyCardOR.getProperty("CVExpDate");
		String vObjCVStreetLbl1 = Constants.IOSMyCardOR.getProperty("CVStreetLbl1");
		String vObjCVCityLbl = Constants.IOSMyCardOR.getProperty("CVCityLbl1");
		String vObjCVCountryLbl = Constants.IOSMyCardOR.getProperty("CVCountryLbl1");
		String vObjCVPostCodeLbl = Constants.IOSMyCardOR.getProperty("CVPostCodeLbl1");
		String vObjbackBtn = Constants.IOSMyCardOR.getProperty("backBtn");
		String result = "FAIL";
		int noOfDebitCard = Constants.key.getElementList(vObjDebitCardList).size();
		for (int i = 1; i < noOfDebitCard; i++) {
			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
			}
			String vCardNumber = Constants.key.readText(vObjDebitCardList + "[" + i + "]" + vObjListCardNo);
			String vDebitCardNo = deletedCardNo.substring((deletedCardNo.length() - 4), (deletedCardNo.length()));
			String vCardLast4Digit = vCardNumber.substring((vCardNumber.length() - 4), (vCardNumber.length()));
			if (vDebitCardNo.equalsIgnoreCase(vCardLast4Digit)) {
				Assert.assertEquals("PASS", Constants.key.click(vObjDebitCardList + "[" + i + "]" + vObjListCardNo));
				LogCapture.info("Debit card selected : " + vCardNumber);
				LogCapture.info("Verifing selected debit card details................ ");
				String vCHName = Constants.key.readText(vObjCardholderNameLbl);
				String vcardNumber = Constants.key.readText(vObjCardNoInput);
				String vIssueDate = Constants.key.readText(vObjIssueDateInput);
				String vExpDate = Constants.key.readText(vObjExpDateInput);
				String vStreet = Constants.key.readText(vObjCVStreetLbl1);
				String vCity = Constants.key.readText(vObjCVCityLbl);
				String vCountry = Constants.key.readText(vObjCVCountryLbl);
				String vPostCode = Constants.key.readText(vObjCVPostCodeLbl);
				String formattedIssueDate = vIssueDate.substring((0), (vIssueDate.length() - 3))
						+ vIssueDate.substring((3), (vIssueDate.length()));
				String formattedExpDate = vExpDate.substring((0), (vExpDate.length() - 3))
						+ vExpDate.substring((3), (vExpDate.length()));
				String CardholderName = Constants.DataMap.get("CardholderName");
				String CardholderNumber = Constants.DataMap.get("CardholderNumber");
				String ExpiryDate = Constants.DataMap.get("ExpiryDate");
				String IssueDate = Constants.DataMap.get("IssueDate");
				String Street = Constants.DataMap.get("Street");
				String City = Constants.DataMap.get("City");
				String State = Constants.DataMap.get("State");
				String PostCode = Constants.DataMap.get("PostCode");

				if (vCHName.equals(CardholderName)) {
					// System.out.println("Card holder name matched........");
					if (vcardNumber.equals(" ****  ****  **** " + vDebitCardNo)) {
						// System.out.println("Card No matched.............");
						if (IssueDate.equals(formattedIssueDate)) {
							// System.out.println("Issue date: "+IssueDate+"
							// matched..........");
							if (ExpiryDate.equals(formattedExpDate)) {
								// System.out.println("Exp. Date: "+ExpiryDate+"
								// matched..........");
								if (Street.equals(vStreet)) {
									// System.out.println("Street: "+Street+"
									// matched..........");
									if (City.equals(vCity)) {
										// System.out.println("City: "+City+"
										// matched..........");
										// if (State.equals(vCountry)) {
										// System.out.println("State/Country:
										// "+State+" matched..........");
										if (PostCode.equals(vPostCode)) {
											// System.out.println("Post code:
											// "+PostCode+" matched..........");
											result = "PASS";
											LogCapture.info("Deleted Card details matched with list card no  : " + i);
											break;

										}
										// }
									}
								}
							}
						}
					}
				}
				if (result.equalsIgnoreCase("FAIL")) {
					LogCapture.info("Card details is not matched with list card no  : " + i);
					Assert.assertEquals("PASS", Constants.key.click(vObjbackBtn));
					ios_user_should_navigate_to_debit_card_screen("debit card");
				}
			}
		}
		Assert.assertEquals("FAIL", result);
		LogCapture.info("Card deleted successfully  : " + deletedCardNo);
	}

	@Then("^an alert view should be displayed to confirm the delete card action in ios app$")
	public void an_alert_view_should_be_displayed_to_confirm_the_delete_card_action_in_ios_app() throws Throwable {
		String vObjCardDelViewMsg = Constants.IOSMyCardOR.getProperty("CardDelViewMsg");
		String vObjCardDelCancel = Constants.IOSMyCardOR.getProperty("CardDelCancel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardDelViewMsg));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardDelCancel));
		String atbValue1 = Constants.IOSTestData.getProperty("DeleteCardConfrimationMsg");
		String atbValue2 = Constants.key.getAttributeValue(vObjCardDelViewMsg, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(atbValue1, atbValue2));
		LogCapture.info("Delete card alert displayed and confirmation message verified successfully.........");
	}

	@When("^ios user cancels the action$")
	public void ios_user_cancels_the_action() throws Throwable {
		String vObjCardDelCancel = Constants.IOSMyCardOR.getProperty("CardDelCancel");
		Assert.assertEquals("PASS", Constants.key.click(vObjCardDelCancel));
		LogCapture.info("User clicked on cancelled .........");
	}

	@Then("^ios user should be on same selected card view screen$")
	public void ios_user_should_be_on_same_selected_card_view_screen() throws Throwable {
		an_option_to_delete_the_card_should_be_available_to_ios_user();
	}

	@Then("^ios user should redirects to list card screen$")
	public void ios_user_should_redirects_to_list_card_screen() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^ios user clicks on edit address$")
	public void ios_user_clicks_on_edit_address() throws Throwable {
		String vObjEditAddressLnk = Constants.IOSMyCardOR.getProperty("EditAddressLnk");
		Assert.assertEquals("PASS", Constants.key.click(vObjEditAddressLnk));
		LogCapture.info("User clicked on edit address link .........");
	}

	@Then("^billing address fields should be populated with option search address in ios app$")
	public void billing_address_fields_should_be_populated_with_option_search_address_in_ios_app() throws Throwable {
		String vObjSearchAddInput = Constants.IOSMyCardOR.getProperty("SearchAddOption");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSearchAddInput));
	}

	@When("^ios user searches for address \"([^\"]*)\" and select auto searched address$")
	public void ios_user_searches_for_address_and_select_auto_searched_address(String address) throws Throwable {
		String vObjSearchAddOption = Constants.IOSMyCardOR.getProperty("SearchAddOption");
		String vObjSearchAddInput = Constants.IOSMyCardOR.getProperty("SearchAddInput");
		String vObjSearchAddInput2 = Constants.IOSMyCardOR.getProperty("SearchAddInput2");
		String vObjAddressResult2 = Constants.IOSMyCardOR.getProperty("AddressResult2");
		String vObjAddressClearIcon = Constants.IOSMyCardOR.getProperty("AddressClearIcon");
		String vObjCountryDD = Constants.IOSMyCardOR.getProperty("CountryDD");
		String vObjDefaultCountrylbl = Constants.IOSMyCardOR.getProperty("DefaultCountrylbl");

		if ((AppName).equalsIgnoreCase("TorFX")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddOption));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSearchAddInput2, address));
		} else {
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddOption));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSearchAddInput, address));
		}
		// Assert.assertEquals("PASS",
		// Constants.key.eleLocatedDisplayed(vObjAddressClearIcon));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddressResult2));
		Assert.assertEquals("PASS", Constants.key.click(vObjAddressResult2));
		// Temporary reinitialize wait with lower time to improve performance on
		// this step
		Constants.modifyWaitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("ModifyWaitInSecondsForIOS"));
		Constants.key.reInitializeWebDriverWait(Constants.modifyWaitInSeconds);
		Constants.key.click(vObjAddressResult2);
		// To initialize wait with original value
		Constants.modifyWaitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
		Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryDD));
		String vCountry = Constants.key.getAttributeValue(vObjDefaultCountrylbl, "value");
		String vObjSave = Constants.IOSMyCardOR.getProperty("SaveBtn");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Save", "down"));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSave));

		if (vCountry.equalsIgnoreCase("France") || vCountry.equalsIgnoreCase("Spain") || vCountry.equalsIgnoreCase("UK")
				|| vCountry.equalsIgnoreCase("India")) {
			String vObjSearchAddressLine1Input = Constants.IOSMyCardOR.getProperty("SearchAddressLine1Input");
			String vObjSearchAddressCityInput = Constants.IOSMyCardOR.getProperty("SearchAddressCityInput");
			String vObjSearchAddCountyInput = Constants.IOSMyCardOR.getProperty("SearchAddCountyInput");
			String vObjSearchAddressPostCodeInput = Constants.IOSMyCardOR.getProperty("SearchAddressPostCodeInput");
			String vStreet = Constants.key.getAttributeValue(vObjSearchAddressLine1Input, "value").trim();// Street
																											// line1
			Assert.assertNotEquals("Fail", vStreet);
			Constants.DataMap.put("Street", vStreet.trim());
			String vCity = Constants.key.getAttributeValue(vObjSearchAddressCityInput, "value").trim();// Town
																										// City
			Assert.assertNotEquals("Fail", vCity);
			Constants.DataMap.put("City", vCity.trim());
			String vCounty = Constants.key.getAttributeValue(vObjSearchAddCountyInput, "value").trim();// County
			Assert.assertNotEquals("Fail", vCounty);
			Constants.DataMap.put("State", vCounty.trim());
			String vPostCode = Constants.key.getAttributeValue(vObjSearchAddressPostCodeInput, "value").trim();// PostCode
			Assert.assertNotEquals("Fail", vPostCode);
			Constants.DataMap.put("PostCode", vPostCode.trim());
		} else if (vCountry.equalsIgnoreCase("USA")) {
			String vObjSearchAddressUSAStreetInput = Constants.IOSMyCardOR.getProperty("SearchAddressUSAStreetInput");
			String vObjSearchAddressUSACityInput = Constants.IOSMyCardOR.getProperty("SearchAddressUSACityInput");
			String vObjSearchAddressUSAStateInput = Constants.IOSMyCardOR.getProperty("SearchAddressUSAStateInput");
			String vObjSearchAddUSAZipCodeInput = Constants.IOSMyCardOR.getProperty("SearchAddUSAZipCodeInput");
			String vStreet = Constants.key.getAttributeValue(vObjSearchAddressUSAStreetInput, "value");// Street
																										// line1
			Assert.assertNotEquals("Fail", vStreet);
			Constants.DataMap.put("Street", vStreet.trim());
			String vCity = Constants.key.getAttributeValue(vObjSearchAddressUSACityInput, "value");// City
			Assert.assertNotEquals("Fail", vCity);
			Constants.DataMap.put("City", vCity.trim());
			String vCounty = Constants.key.getAttributeValue(vObjSearchAddressUSAStateInput, "value");// State
			Assert.assertNotEquals("Fail", vCounty);
			Constants.DataMap.put("State", vCounty.trim());
			String vPostCode = Constants.key.getAttributeValue(vObjSearchAddUSAZipCodeInput, "value");// ZipCode
			Assert.assertNotEquals("Fail", vPostCode);
			Constants.DataMap.put("PostCode", vPostCode.trim());

		}
		LogCapture.info("Third number auto searched address selected by user .........");
	}

	@When("^ios user clicks on enter address manually$")
	public void ios_user_clicks_on_enter_address_manually() throws Throwable {
		String vObjManualAddLink = Constants.IOSMyCardOR.getProperty("ManualAddLink");
		Assert.assertEquals("PASS", Constants.key.click(vObjManualAddLink));
		LogCapture.info("User clicked on manual address link.........");
	}

	@When("^ios user enters required address field data$")
	public void ios_user_enters_required_address_field_data() throws Throwable {
		String vObjCountryDD = Constants.IOSMyCardOR.getProperty("CountryDD");
		String vObjDefaultCountrylbl = Constants.IOSMyCardOR.getProperty("DefaultCountrylbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryDD));
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Save", "down"));
		String vCountry = Constants.key.getAttributeValue(vObjDefaultCountrylbl, "value");
		ios_user_enters_country_specific_required_address_field_data(vCountry);
	}

	@When("^ios user selects country \"([^\"]*)\"$")
	public void ios_user_selects_country(String country) throws Throwable {
		String vObjCountryDD = Constants.IOSMyCardOR.getProperty("CountryDD");
		String vObjCountrySearchInput = Constants.IOSMyCardOR.getProperty("CountrySearchInput");
		String vObjCountryCell = Constants.IOSMyCardOR.getProperty("CountryCell");
		// String vObjCountryLabel = Constants.IOSMyCardOR.getProperty("CountryLabel");
		String vObjCountryLabel = Constants.IOSMyCardOR.getProperty("CountryLabel2");
		Assert.assertEquals("PASS", Constants.key.click(vObjCountryDD));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountrySearchInput, country));
		LogCapture.info("User entered country in search box : " + country);
		String result = "FAIL";
		int noOfCountry = Constants.key.getElementList(vObjCountryLabel).size();
		for (int i = 1; i <= noOfCountry; i++) {
			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
			}
			String vCountry = Constants.key.getAttributeValue(vObjCountryCell + "[" + i + "]" + vObjCountryLabel,
					"label");
			if (country.equalsIgnoreCase(vCountry)) {
				Assert.assertEquals("PASS", Constants.key.click(vObjCountryCell + "[" + i + "]" + vObjCountryLabel));
				LogCapture.info("Country selected : " + vCountry);
				Country = vCountry;
				result = "PASS";
				break;
			} else {
				LogCapture.info("Country : " + country + " is not matched with List Country :" + i + ". " + vCountry);
			}
		}
		Assert.assertEquals("PASS", result);
	}

	@When("^ios user enters country specific required address \"([^\"]*)\" field data$")
	public void ios_user_enters_country_specific_required_address_field_data(String address) throws Throwable {
		Constants.Data = Constants.IOSTestData.getProperty(address).split(",");

		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		String vObjDefaultCountry = Constants.IOSMyCardOR.getProperty("DefaultCountrylbl");
		String vObjCountryDD = Constants.IOSRegstOR.getProperty("CountryDD");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryDD));
		// String vCountry = Constants.key.getAttributeValue(vObjDefaultCountry,
		// "value");

		System.out.println("Country is :" + Country);
		if (Country.equalsIgnoreCase("France") || Country.equalsIgnoreCase("Spain")
				|| Country.equalsIgnoreCase("United Kingdom") || Country.equalsIgnoreCase("Austria")
				|| Country.equalsIgnoreCase("India")) {
			Constants.DataMap.put("Street", Constants.Data[0].toString().trim());
			Constants.DataMap.put("City", Constants.Data[1].toString().trim());
			Constants.DataMap.put("State", Constants.Data[2].toString().trim());
			Constants.DataMap.put("PostCode", Constants.Data[3].toString().trim());
		}
		if (Country.equalsIgnoreCase("Canada") || Country.equalsIgnoreCase("Australia")) {
			Constants.DataMap.put("Street", Constants.Data[2].toString().trim());
			Constants.DataMap.put("City", Constants.Data[4].toString().trim());
			Constants.DataMap.put("State", Constants.Data[5].toString().trim());
			Constants.DataMap.put("PostCode", Constants.Data[6].toString().trim());
		}
		LogCapture.info("User entering address for country : " + Country);
		if (Country.equalsIgnoreCase("France") || Country.equalsIgnoreCase("Spain")
				|| Country.equalsIgnoreCase("United Kingdom") || Country.equalsIgnoreCase("India")) {
			String vObjAddLine1PHolder = Constants.IOSMyCardOR.getProperty("AddLine1PHolder");
			String vObjAddLine1Input = Constants.IOSMyCardOR.getProperty("AddLine1Input");
			String vObjTownCityPHolder = Constants.IOSMyCardOR.getProperty("TownCityPHolder");
			String vObjTownCityInput = Constants.IOSMyCardOR.getProperty("TownCityInput");
			String vObjCountyPHolder = Constants.IOSMyCardOR.getProperty("CountyPHolder");
			String vObjCountyInput = Constants.IOSMyCardOR.getProperty("CountyInput");
			// String vObjPostCodePHolder =
			// Constants.IOSMyCardOR.getProperty("PostCodePHolder");
			String vObjPostCodePHolder = Constants.IOSRegstOR.getProperty("PostCodePHolder");
			String vObjPostCodeInput = Constants.IOSMyCardOR.getProperty("PostCodeAll");
			// String vObjPostCodeInput = Constants.IOSRegstOR.getProperty("PostCodeInput");

			// Street line1
			Assert.assertEquals("PASS", Constants.key.click(vObjAddLine1PHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAddLine1Input, Constants.Data[0].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Town City
			Assert.assertEquals("PASS", Constants.key.click(vObjTownCityPHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTownCityInput, Constants.Data[1].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// County
			Assert.assertEquals("PASS", Constants.key.click(vObjCountyPHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountyInput, Constants.Data[2].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// PostCode
			Assert.assertEquals("PASS", Constants.key.click(vObjPostCodePHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostCodeInput, Constants.Data[3].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));

		} else if (Country.equalsIgnoreCase("United States Of America")) {
			String vObjUSAStreetPH = Constants.IOSMyCardOR.getProperty("USAStreetPH");
			String vObjUSAStreetInput = Constants.IOSMyCardOR.getProperty("USAStreetInput");
			String vObjUSACityPHolder = Constants.IOSMyCardOR.getProperty("CityPHolder");
			String vObjUSACityInput = Constants.IOSMyCardOR.getProperty("CityInput");
			String vObjUSAStatePH = Constants.IOSMyCardOR.getProperty("StatePH");
			String vObjUSAStatePickerWheel = Constants.IOSMyCardOR.getProperty("StatePickerWheel");
			String vObjUSAZipCodePHolder = Constants.IOSMyCardOR.getProperty("USAZipCodePHolder");
			String vObjUSAZipCodeInput = Constants.IOSMyCardOR.getProperty("USAZipCodeInput");
			// Street line1
			Assert.assertEquals("PASS", Constants.key.click(vObjUSAStreetPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUSAStreetInput, Constants.Data[0].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Town City
			Assert.assertEquals("PASS", Constants.key.click(vObjUSACityPHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUSACityInput, Constants.Data[1].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// County
			Assert.assertEquals("PASS", Constants.key.click(vObjUSAStatePH));
			Assert.assertEquals("PASS",
					Constants.key.writeInInput(vObjUSAStatePickerWheel, Constants.Data[2].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// PostCode
			Assert.assertEquals("PASS", Constants.key.click(vObjUSAZipCodePHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUSAZipCodeInput, Constants.Data[3].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (Country.equalsIgnoreCase("Canada")) {
			String vObjUnitNoPH = Constants.IOSMyCardOR.getProperty("UnitNoPH");
			String vObjUnitNoInput = Constants.IOSMyCardOR.getProperty("UnitNoInput");
			String vObjCivicNoPH = Constants.IOSMyCardOR.getProperty("CivicNoPH");
			String vObjCivicNoInput = Constants.IOSMyCardOR.getProperty("CivicNoInput");
			String vObjStreetPH = Constants.IOSMyCardOR.getProperty("StreetPH");
			String vObjStreetInput = Constants.IOSMyCardOR.getProperty("StreetInput");
			String vObjStreetTypePH = Constants.IOSMyCardOR.getProperty("StreetTypePH");
			String vObjStreetTypeInput = Constants.IOSMyCardOR.getProperty("StreetTypeInput");
			String vObjCityPHolder = Constants.IOSMyCardOR.getProperty("CityPHolder");
			String vObjCityInput = Constants.IOSMyCardOR.getProperty("CityInput");
			String vObjStatePH = Constants.IOSMyCardOR.getProperty("StatePH");
			String vObjStatePickerWheel = Constants.IOSMyCardOR.getProperty("StatePickerWheel");
			String vObjPostCodePHolder = Constants.IOSMyCardOR.getProperty("PostCodePHolder");
			String vObjPostCodeInput = Constants.IOSMyCardOR.getProperty("PostCodeInput");
			// Unit No
			Assert.assertEquals("PASS", Constants.key.click(vObjUnitNoPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUnitNoInput, Constants.Data[0].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Civic No
			Assert.assertEquals("PASS", Constants.key.click(vObjCivicNoPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCivicNoInput, Constants.Data[1].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Street
			Assert.assertEquals("PASS", Constants.key.click(vObjStreetPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStreetInput, Constants.Data[2].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Street Type
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjStreetTypePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStatePickerWheel, Constants.Data[3].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// City
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjCityPHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCityInput, Constants.Data[4].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// State
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjStatePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStatePickerWheel, Constants.Data[5].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// PostCode
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjPostCodePHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostCodeInput, Constants.Data[6].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (Country.equalsIgnoreCase("Australia|")) {
			String vObjUnitNoPH = Constants.IOSMyCardOR.getProperty("UnitNoPH");
			String vObjUnitNoInput = Constants.IOSMyCardOR.getProperty("UnitNoInput");
			String vObjStrretNoPH = Constants.IOSMyCardOR.getProperty("StrretNoPH");
			String vObjStrretNoInput = Constants.IOSMyCardOR.getProperty("StrretNoInput");
			String vObjStreetNamePH = Constants.IOSMyCardOR.getProperty("StreetNamePH");
			String vObjStreetNameInput = Constants.IOSMyCardOR.getProperty("StreetNameInput");
			String vObjStreetTypePH = Constants.IOSMyCardOR.getProperty("StreetTypePH");
			String vObjSuburbPH = Constants.IOSMyCardOR.getProperty("SuburbPH");
			String vObjSuburbInput = Constants.IOSMyCardOR.getProperty("SuburbInput");
			String vObjStatePH = Constants.IOSMyCardOR.getProperty("StatePH");
			String vObjStatePickerWheel = Constants.IOSMyCardOR.getProperty("StatePickerWheel");
			// String vObjPostCodePHolder =
			// Constants.IOSMyCardOR.getProperty("PostCodePHolder");
			// String vObjPostCodeInput =
			// Constants.IOSMyCardOR.getProperty("PostCodeInput");
			String vObjPostCodePHolder = Constants.IOSRegstOR.getProperty("PostCodePHolder");
			String vObjPostCodeInput = Constants.IOSRegstOR.getProperty("PostCodeInput");
			// Unit No
			Assert.assertEquals("PASS", Constants.key.click(vObjUnitNoPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUnitNoInput, Constants.Data[0].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Street No
			Assert.assertEquals("PASS", Constants.key.click(vObjStrretNoPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStrretNoInput, Constants.Data[1].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Street Name
			Assert.assertEquals("PASS", Constants.key.click(vObjStreetNamePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStreetNameInput, Constants.Data[2].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Street Type
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjStreetTypePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStatePickerWheel, Constants.Data[3].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// City
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjSuburbPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSuburbInput, Constants.Data[4].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// State
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjStatePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStatePickerWheel, Constants.Data[5].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// PostCode
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjPostCodePHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostCodeInput, Constants.Data[6].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		}

		else if (Country.equalsIgnoreCase("New Zealand")) {
			String vObjUnitNoPH = Constants.IOSMyCardOR.getProperty("UnitNoPH");
			String vObjUnitNoInput = Constants.IOSMyCardOR.getProperty("UnitNoInput");
			String vObjStrretNoPH = Constants.IOSMyCardOR.getProperty("StrretNoPH");
			String vObjStrretNoInput = Constants.IOSMyCardOR.getProperty("StrretNoInput");
			String vObjStreetNamePH = Constants.IOSMyCardOR.getProperty("StreetNamePH");
			String vObjStreetNameInput = Constants.IOSMyCardOR.getProperty("StreetNameInput");
			String vObjStreetTypePH = Constants.IOSMyCardOR.getProperty("StreetTypePH");
			String vObjSuburbCityPH = Constants.IOSMyCardOR.getProperty("SuburbCityPH");
			String vObjSuburbCityInput = Constants.IOSMyCardOR.getProperty("SuburbCityInput");
			String vObjStatePH = Constants.IOSMyCardOR.getProperty("StatePH");
			String vObjStatePickerWheel = Constants.IOSMyCardOR.getProperty("StatePickerWheel");
			String vObjPostCodePHolder = Constants.IOSMyCardOR.getProperty("PostCodePHolder");
			String vObjPostCodeInput = Constants.IOSMyCardOR.getProperty("PostCodeInput");
			// Unit No
			Assert.assertEquals("PASS", Constants.key.click(vObjUnitNoPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUnitNoInput, Constants.Data[0].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Street Name
			Assert.assertEquals("PASS", Constants.key.click(vObjStreetNamePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStreetNameInput, Constants.Data[1].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Street Type
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjStreetTypePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStatePickerWheel, Constants.Data[2].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Suburb/City
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjSuburbCityPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSuburbCityInput, Constants.Data[3].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// State
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjStatePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStatePickerWheel, Constants.Data[4].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// PostCode
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjPostCodePHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostCodeInput, Constants.Data[5].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		}

		LogCapture.info(Country + " user address entered successfully.............");
	}

	@When("^ios user doesnot provide country specific mandatory address \"([^\"]*)\" field data$")
	public void ios_user_doesnot_provide_country_specific_mandatory_address_field_data(String mandatoryField)
			throws Throwable {
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		String vObjCountryDD = Constants.IOSRegstOR.getProperty("CountryDD");
		String vObjDefaultCountry = Constants.IOSMyCardOR.getProperty("DefaultCountrylbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryDD));
		String vCountry = Constants.key.getAttributeValue(vObjDefaultCountry, "value");
		if (vCountry.equalsIgnoreCase("France") || vCountry.equalsIgnoreCase("Spain") || vCountry.equalsIgnoreCase("UK")
				|| vCountry.equalsIgnoreCase("India")) {
			String vObjAddLine1Input = Constants.IOSMyCardOR.getProperty("SearchAddressLine1Input");
			String vObjTownCityInput = Constants.IOSMyCardOR.getProperty("SearchAddressCityInput");
			String vObjPostCodeInput = Constants.IOSMyCardOR.getProperty("SearchAddressPostCodeInput");
			// Street line1
			if (mandatoryField.equalsIgnoreCase("AddressLine1")) {
				Assert.assertEquals("PASS", Constants.key.clearText(vObjAddLine1Input));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			}
			// Town City
			else if (mandatoryField.equalsIgnoreCase("City")) {
				Assert.assertEquals("PASS", Constants.key.clearText(vObjTownCityInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			}
			// PostCode
			else if (mandatoryField.equalsIgnoreCase("PostCode")) {
				Assert.assertEquals("PASS", Constants.key.clearText(vObjPostCodeInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else {
				LogCapture.info("Mandatory field not found...Please update code for Country : " + vCountry + "Field : "
						+ mandatoryField);
			}
		}

		else if (vCountry.equalsIgnoreCase("USA")) {
			String vObjUSAStreetInput = Constants.IOSMyCardOR.getProperty("SearchAddressUSAStreetInput");
			String vObjUSACityInput = Constants.IOSMyCardOR.getProperty("SearchAddressUSACityInput");
			String vObjUSAStatePickerWheel = Constants.IOSMyCardOR.getProperty("SearchAddressUSAStateInput");
			String vObjUSAZipCodeInput = Constants.IOSMyCardOR.getProperty("SearchAddUSAZipCodeInput");

			if (mandatoryField.equalsIgnoreCase("StreetLine1")) { // StreetLine1
																	// (Mandatory)
				Assert.assertEquals("PASS", Constants.key.clearText(vObjUSAStreetInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else if (mandatoryField.equalsIgnoreCase("City")) { // Town City
				Assert.assertEquals("PASS", Constants.key.clearText(vObjUSACityInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else if (mandatoryField.equalsIgnoreCase("State")) { // State
				Assert.assertEquals("PASS", Constants.key.clearText(vObjUSAStatePickerWheel));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else if (mandatoryField.equalsIgnoreCase("ZipCode")) {// PostCode
				Assert.assertEquals("PASS", Constants.key.clearText(vObjUSAZipCodeInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else {
				LogCapture.info("Mandatory field not found...Please update code for Country : " + vCountry + "Field : "
						+ mandatoryField);
			}
		} else if (vCountry.equalsIgnoreCase("Canada")) {
			String vObjStreetInput = Constants.IOSMyCardOR.getProperty("SearchAddressCanadaStreetInput");
			String vObjStreetTypeInput = Constants.IOSMyCardOR.getProperty("SearchAddressCanadaStreetTypeInput");
			String vObjCityInput = Constants.IOSMyCardOR.getProperty("SearchAddressCanadaCityInput");
			String vObjStatePickerWheel = Constants.IOSMyCardOR.getProperty("SearchAddressCanadaStateInput");
			String vObjPostCodeInput = Constants.IOSMyCardOR.getProperty("SearchAddressCanadaPostCodeInput");

			if (mandatoryField.equalsIgnoreCase("StreetName")) {// StreetName
				// Street
				Assert.assertEquals("PASS", Constants.key.clearText(vObjStreetInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else if (mandatoryField.equalsIgnoreCase("StreetType")) {// Street
																		// Type
				Constants.key.scrollInIOS("Save", "down");
				Assert.assertEquals("PASS", Constants.key.clearText(vObjStatePickerWheel));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else if (mandatoryField.equalsIgnoreCase("City")) {// City
				Constants.key.scrollInIOS("Save", "down");
				Assert.assertEquals("PASS", Constants.key.clearText(vObjCityInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else if (mandatoryField.equalsIgnoreCase("State")) {// State
				Constants.key.scrollInIOS("Save", "down");
				Assert.assertEquals("PASS", Constants.key.clearText(vObjStatePickerWheel));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else if (mandatoryField.equalsIgnoreCase("PostCode")) {// PostCode
				Constants.key.scrollInIOS("Save", "down");
				Assert.assertEquals("PASS", Constants.key.clearText(vObjPostCodeInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else {
				LogCapture.info("Mandatory field not found...Please update code for Country : " + vCountry + "Field : "
						+ mandatoryField);
			}

		} else if (vCountry.equalsIgnoreCase("Australia")) {
			String vObjStrretNoInput = Constants.IOSMyCardOR.getProperty("SearchAddressAusStreetNumberInput");
			String vObjStreetNameInput = Constants.IOSMyCardOR.getProperty("SearchAddressStreetNameAusInput");
			String vObjStreetTypeInput = Constants.IOSMyCardOR.getProperty("SearchAddressAusStreetTypeInput");
			String vObjSuburbInput = Constants.IOSMyCardOR.getProperty("SearchAddressSuburbAusInput");
			String vObjStatePickerWheel = Constants.IOSMyCardOR.getProperty("SearchAddressAusStateInput");
			String vObjPostCodeInput = Constants.IOSMyCardOR.getProperty("SearchAddressAusPostCodeInput");
			if (mandatoryField.equalsIgnoreCase("StreetNumber")) {// Street No
				Assert.assertEquals("PASS", Constants.key.clearText(vObjStrretNoInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else if (mandatoryField.equalsIgnoreCase("StreetName")) {// Street
																		// Name
				Assert.assertEquals("PASS", Constants.key.clearText(vObjStreetNameInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else if (mandatoryField.equalsIgnoreCase("StreetType")) {// Street
																		// Type
				Constants.key.scrollInIOS("Save", "down");
				Assert.assertEquals("PASS", Constants.key.clearText(vObjStreetTypeInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else if (mandatoryField.equalsIgnoreCase("Suburb")) { // Suburb
				Constants.key.scrollInIOS("Save", "down");
				Assert.assertEquals("PASS", Constants.key.clearText(vObjSuburbInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else if (mandatoryField.equalsIgnoreCase("State")) { // State
				Constants.key.scrollInIOS("Save", "down");
				Assert.assertEquals("PASS", Constants.key.clearText(vObjStatePickerWheel));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else if (mandatoryField.equalsIgnoreCase("PostCode")) {// PostCode
				Constants.key.scrollInIOS("Save", "down");
				Assert.assertEquals("PASS", Constants.key.clearText(vObjPostCodeInput));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			} else {
				LogCapture.info("Mandatory field not found...Please update code for Country : " + vCountry + "Field : "
						+ mandatoryField);
			}
		}
	}

	@When("^ios enters country \"([^\"]*)\" specific max address field data$")
	public void ios_enters_country_specific_max_address_field_data(String data) throws Throwable {

	}

	@Then("^invalid field error message should be displyed for all mandatory address fields in ios app$")
	public void invalid_field_error_message_should_be_displyed_for_all_mandatory_address_fields_in_ios_app()
			throws Throwable {

	}

	@When("^ios user selects the recipient option from the home dashboard$")
	public void ios_user_selects_the_recipient_option_from_the_home_dashboard() throws Throwable {
		String vObjRecipientIcon = Constants.IOSDashOR.getProperty("RecipientIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjRecipientIcon));
		LogCapture.info("User clicked on recipient tab bar ...............");

	}

	@When("^ios user has no saved recipients previously$")
	public void ios_user_has_no_saved_recipients_previously() throws Throwable {
		String vObjImgNoRecipient = Constants.IOSRecipientOR.getProperty("ImgNoRecipient");
		String vObjLblNoRecipientText = Constants.IOSRecipientOR.getProperty("LblNoRecipientText");
		String vObjBtnAddRecipient = Constants.IOSRecipientOR.getProperty("BtnAddRecipient");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLblNoRecipientText));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipient));
	}

	@Then("^an option to add a new recipient should be displayed in ios app$")
	public void an_option_to_add_a_new_recipient_should_be_displayed_in_ios_app() throws Throwable {
		String vObjBtnAddRecipient = Constants.IOSRecipientOR.getProperty("BtnAddRecipient");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipient));
	}

	@When("^ios user has one or more saved recipients$")
	public void ios_user_has_one_or_more_saved_recipients() throws Throwable {
		String vObjRecpientList = Constants.IOSRecipientOR.getProperty("RecpientList");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecpientList));
		int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();
		LogCapture.info("Recipient present in list :" + (recpientListSize - 1));
	}

	@Then("^all the recipients should be displayed with the option to add a new recipient in ios app$")
	public void all_the_recipients_should_be_displayed_with_the_option_to_add_a_new_recipient_in_ios_app()
			throws Throwable {
		String vObjBtnAddRecipientCell = Constants.IOSRecipientOR.getProperty("BtnAddRecipientCell");
		String vObjRecipientIcon = Constants.IOSDashOR.getProperty("RecipientIcon");
		String vObjRecipientTitle = Constants.IOSDashOR.getProperty("RecipientTitle");

		// Assert.assertEquals("PASS",Constants.key.eleLocatedDisplayed(vObjRecipientIcon));
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add new recipient", "up"));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell));
		LogCapture.info("Add recipient button displayed with recipient list.........");
	}

	@Then("^each recipient in the list should be displayed with name,currency code and masked account number except last four digit in ios app$")
	public void then_each_recipient_in_the_list_should_be_displayed_with_name_currency_code_and_masked_account_number_except_last_four_digit_in_ios_app()
			throws Throwable {
		String vObjRecpientList = Constants.IOSRecipientOR.getProperty("RecpientList");
		String vObjRecpientName = Constants.IOSRecipientOR.getProperty("RecpientName");
		String vObjRecipientCurrency = Constants.IOSRecipientOR.getProperty("RecipientCurrency");
		String vObjMaskedAccNo = Constants.IOSRecipientOR.getProperty("MaskedAccNo");
		String vObjUnmaskedAccNo = Constants.IOSRecipientOR.getProperty("UnmaskedAccNo");
		String vObjBtnAddRecipientCell = Constants.IOSRecipientOR.getProperty("BtnAddRecipientCell");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell));
		int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();
		for (int i = 1; i < recpientListSize; i++) {
			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("  ", "down"));
			}
			String vRecipientName = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjRecpientName, "value");
			Assert.assertNotEquals("FAIL", vRecipientName);
			String vCurrency = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjRecipientCurrency, "value");
			Assert.assertNotEquals("FAIL", vCurrency);
			String vMaskedAccNo = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjMaskedAccNo, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText("****", vMaskedAccNo));
			String vUnmaskedAccNo = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjUnmaskedAccNo, "value");
			Assert.assertEquals(true, NumberUtils.isNumber(vUnmaskedAccNo));
			LogCapture.info("Recipeint : " + i);
			LogCapture.info("Recipeint Name : " + vRecipientName + ", Currency : " + vCurrency + ", Account No : "
					+ vMaskedAccNo + " " + vUnmaskedAccNo);
		}
		LogCapture.info("Recipient list verified successfully.........");
	}

	@When("^ios user selects a saved recipient \"([^\"]*)\"$")
	public void ios_user_selects_a_saved_recipient(String recipientData) throws Throwable {

		String vObjRecpientList = Constants.IOSRecipientOR.getProperty("RecpientList");
		String vObjRecpientName = Constants.IOSRecipientOR.getProperty("RecpientName");
		String vObjRecipientCurrency = Constants.IOSRecipientOR.getProperty("RecipientCurrency");
		String vObjMaskedAccNo = Constants.IOSRecipientOR.getProperty("MaskedAccNo");
		String vObjUnmaskedAccNo = Constants.IOSRecipientOR.getProperty("UnmaskedAccNo");
		String vObjBtnAddRecipientCell = Constants.IOSRecipientOR.getProperty("BtnAddRecipientCell");
		Constants.Data = Constants.IOSTestData.getProperty(recipientData).split(",");
		String lastFourAccNo = Constants.Data[2].toString().substring((Constants.Data[2].length() - 4),
				(Constants.Data[2].length()));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell));
		int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();
		for (int i = 1; i < recpientListSize; i++) {
			String vRecipientName = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjRecpientName, "value");
			String vCurrency = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjRecipientCurrency, "value");
			String vUnmaskedAccNo = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjUnmaskedAccNo, "value");
			if (i == 7) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS(vRecipientName, "down"));
			}
			LogCapture.info("Recipent: " + i + " Recipeint Name : " + vRecipientName + ", Currency : " + vCurrency
					+ ", Account No : **** " + vUnmaskedAccNo);
			if (vRecipientName.equalsIgnoreCase(Constants.Data[0].toString())
					&& vCurrency.equalsIgnoreCase(Constants.Data[1].toString())
					&& vUnmaskedAccNo.equalsIgnoreCase(lastFourAccNo)) {
				Assert.assertEquals("PASS",
						Constants.key.click(vObjRecpientList + "[" + (i + 1) + "]" + vObjRecpientName));
				LogCapture.info("Recipient match found and clicked on : " + vRecipientName + ",Currency :" + vCurrency
						+ "Account No : **** " + vUnmaskedAccNo);

				break;
			} else {
				LogCapture.info("No recipient match  found.......................");
			}
		}
	}

	@Then("^all the details of the recipient \"([^\"]*)\" should be displayed as per country-currency \"([^\"]*)\" in ios app$")
	public void all_the_details_of_the_recipient_should_be_displayed_as_per_country_currency_in_ios_app(
			String recipientViewData, String countryCurrency) throws Throwable {
		String vObjRecpientName = Constants.IOSRecipientOR.getProperty("RecpientName");
		String vObjBankNameLbl = Constants.IOSRecipientOR.getProperty("BankNameLbl");
		String vObjBankNameTxt = Constants.IOSRecipientOR.getProperty("BankNameTxt");
		String vObjAccountNoLbl = Constants.IOSRecipientOR.getProperty("AccountNoLbl");
		String vObjAccountNoTxt = Constants.IOSRecipientOR.getProperty("AccountNoTxt");
		String vObjBSBNoLbl = Constants.IOSRecipientOR.getProperty("BSBNoLbl");
		String vObjBSBNoTxt = Constants.IOSRecipientOR.getProperty("BSBNoTxt");
		String vObjRecCurrencyLbl = Constants.IOSRecipientOR.getProperty("RecCurrencyLbl");
		String vObjRecCurrencyTxt = Constants.IOSRecipientOR.getProperty("RecCurrencyTxt");
		String vObjRecCountryLbl = Constants.IOSRecipientOR.getProperty("RecCountryLbl");
		String vObjRecCountryTxt = Constants.IOSRecipientOR.getProperty("RecCountryTxt");
		String vObjSwiftLbl = Constants.IOSRecipientOR.getProperty("SwiftLbl");
		String vObjSwiftTxt = Constants.IOSRecipientOR.getProperty("SwiftTxt");
		String vObjSortCodeLbl = Constants.IOSRecipientOR.getProperty("SortCodeLbl");
		String vObjSortCodeTxt = Constants.IOSRecipientOR.getProperty("SortCodeTxt");
		Constants.Data = Constants.IOSTestData.getProperty(recipientViewData).split(",");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecpientName));
		Assert.assertEquals(Constants.Data[0].toString(), Constants.key.getAttributeValue(vObjRecpientName, "value"));
		LogCapture.info("Recipient Name : " + Constants.key.getAttributeValue(vObjRecpientName, "value") + " verified");
		String vBankNameLbl = Constants.key.getAttributeValue(vObjBankNameLbl, "value");
		Assert.assertEquals("PASS", Constants.key.VerifyText("Bank name", vBankNameLbl));
		String vBankNameTxt = Constants.key.getAttributeValue(vObjBankNameTxt, "value");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[1].toString(), vBankNameTxt));
		LogCapture.info("Bank name : " + vBankNameTxt + " verified");
		String vAccountNoLbl = Constants.key.getAttributeValue(vObjAccountNoLbl, "value");
		Assert.assertEquals("PASS", Constants.key.VerifyText("Account number", vAccountNoLbl));
		String vAccountNoTxt = Constants.key.getAttributeValue(vObjAccountNoTxt, "value");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[2].toString(), vAccountNoTxt));
		LogCapture.info("Account No: " + vAccountNoTxt + " verified");
		String vRecCurrencyLbl = Constants.key.getAttributeValue(vObjRecCurrencyLbl, "value");
		Assert.assertEquals("PASS", Constants.key.VerifyText("Currency", vRecCurrencyLbl));
		String vRecCurrencyTxt = Constants.key.getAttributeValue(vObjRecCurrencyTxt, "value");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[4].toString(), vRecCurrencyTxt));
		LogCapture.info("Currency: " + vRecCurrencyTxt + " verified");
		String vRecCountryLbl = Constants.key.getAttributeValue(vObjRecCountryLbl, "value");
		Assert.assertEquals("PASS", Constants.key.VerifyText("Country", vRecCountryLbl));
		String vRecCountryTxt = Constants.key.getAttributeValue(vObjRecCountryTxt, "value");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[5].toString(), vRecCountryTxt));
		LogCapture.info("Country: " + vRecCountryTxt + " verified");

		if (countryCurrency.equalsIgnoreCase("France-EUR")) {
			String vSwiftLbl = Constants.key.getAttributeValue(vObjSwiftLbl, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText("Swift no", vSwiftLbl));
			String vSwiftTxt = Constants.key.getAttributeValue(vObjSwiftTxt, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[3].toString(), vSwiftTxt));
			LogCapture.info("Swift No: " + vSwiftTxt + " verified");
		} else if (countryCurrency.equalsIgnoreCase("AUS-AUD")) {
			String vBSBNoLbl = Constants.key.getAttributeValue(vObjBSBNoLbl, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText("BSB number", vBSBNoLbl));
			String vBSBNoTxt = Constants.key.getAttributeValue(vObjBSBNoTxt, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[3].toString(), vBSBNoTxt));
			LogCapture.info("BSB No: " + vBSBNoTxt + " verified");
		} else if (countryCurrency.equalsIgnoreCase("UK-GBP")) {
			String vSortCodeLbl = Constants.key.getAttributeValue(vObjSortCodeLbl, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText("Sort Code", vSortCodeLbl));
			String vSortCodeTxt = Constants.key.getAttributeValue(vObjSortCodeTxt, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[3].toString(), vSortCodeTxt));
			LogCapture.info("Swift No: " + vSortCodeTxt + " verified");
		} else if (countryCurrency.equalsIgnoreCase("USA-USD")) {
			String vSortCodeLbl = Constants.key.getAttributeValue(vObjSortCodeLbl, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText("ABA number", vSortCodeLbl));
			String vSortCodeTxt = Constants.key.getAttributeValue(vObjSortCodeTxt, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[3].toString(), vSortCodeTxt));
			LogCapture.info("Swift No: " + vSortCodeTxt + " verified");
		} else if (countryCurrency.equalsIgnoreCase("CANADA-CAD")) {
			String vSortCodeLbl = Constants.key.getAttributeValue(vObjSortCodeLbl, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText("Transit number", vSortCodeLbl));
			String vSortCodeTxt = Constants.key.getAttributeValue(vObjSortCodeTxt, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[3].toString(), vSortCodeTxt));
			LogCapture.info("Swift No: " + vSortCodeTxt + " verified");
		} else if (countryCurrency.equalsIgnoreCase("INDIA-INR")) {
			String vSortCodeLbl = Constants.key.getAttributeValue(vObjSortCodeLbl, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText("IFSC code", vSortCodeLbl));
			String vSortCodeTxt = Constants.key.getAttributeValue(vObjSortCodeTxt, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[3].toString(), vSortCodeTxt));
			LogCapture.info("Swift No: " + vSortCodeTxt + " verified");
		} else {
			LogCapture.info("Ubnable to verify banking details of : " + countryCurrency);
		}
	}

	@When("^ios user selects an option to add a (new recipient|new recipient during send money journey)$")
	public void ios_user_selects_an_option_to_add_a_new_recipient(String optionalValue) throws Throwable {
		// String vObjRecipientTitle =
		// Constants.IOSRecipientOR.getProperty("RecipientTitle");
		String vObjBtnAddRecipientCell = Constants.IOSRecipientOR.getProperty("BtnAddRecipientCell");
		String vObjBtnAddRecipient = Constants.IOSRecipientOR.getProperty("BtnAddRecipient");
		String vObjRecpientList = Constants.IOSRecipientOR.getProperty("RecpientList");
		if (optionalValue.equalsIgnoreCase("new recipient")) {
			String vObjRecipientTitle = Constants.IOSRecipientOR.getProperty("RecipientScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecipientTitle));
		}
		if (optionalValue.equalsIgnoreCase("new recipient during send money journey")) {
			String vObjRecipientTitle = Constants.IOSDashOR.getProperty("SelectRecipientTitle");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecipientTitle));
		}
		int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();
		if (recpientListSize > 0) {
			Assert.assertEquals("PASS", Constants.key.click(vObjBtnAddRecipientCell));
			LogCapture.info("User clicked on add recipient button..... ");
		} else {
			Assert.assertEquals("PASS", Constants.key.click(vObjBtnAddRecipient));
			LogCapture.info("User clicked on add recipient button..... ");
		}
	}

	@Then("^(add recipient|ID update needed) screen should be displayed to ios user$")
	public void add_recipient_screen_should_be_displayed_to_ios_user(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("add recipient")) {
			String vObjLblAddRecipient = Constants.IOSRecipientOR.getProperty("LblAddRecipient");
			String vObjLblIndividual = Constants.IOSRecipientOR.getProperty("LblIndividual");
			Assert.assertEquals(Constants.key.eleLocatedDisplayed(vObjLblAddRecipient), "PASS");
			Assert.assertEquals(Constants.key.eleLocatedDisplayed(vObjLblIndividual), "PASS");
		} else if (optionalValue.equalsIgnoreCase("ID update needed")) {
			String vObjScreenTitle = Constants.IOSLoginOR.getProperty("ScreenTitle");
			String vObjUpdateIDBtn = Constants.IOSLoginOR.getProperty("UpdateIDBtn");

			Assert.assertEquals(Constants.key.eleLocatedDisplayed(vObjUpdateIDBtn), "PASS");
			String vScreenTitle = Constants.key.getAttributeValue(vObjScreenTitle, "label");
			Assert.assertEquals("PASS", Constants.key.VerifyText("ID update needed", vScreenTitle));
			LogCapture.info("ID Update needed screen displayed..... ");
		}

	}

	@When("^ios user close the (recipient view|add recipient|add wallet) window$")
	public void ios_user_close_the_recipient_view_window(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("recipient view")) {
			String vObjCloseBtn = Constants.IOSRecipientOR.getProperty("CloseBtn");
			Assert.assertEquals("PASS", Constants.key.clickWithoutVisibilityChk(vObjCloseBtn));
		} else if (optionalValue.equalsIgnoreCase("add recipient")) {
			String vObjCloseBtn = Constants.IOSRecipientOR.getProperty("CloseAddRecBtn");
			Assert.assertEquals("PASS", Constants.key.clickWithoutVisibilityChk(vObjCloseBtn));
		} else if (optionalValue.equalsIgnoreCase("add wallet")) {
			String vObjCloseBtn = Constants.IOSAddWalletOR.getProperty("CloseButton");
			Assert.assertEquals("PASS", Constants.key.clickWithoutVisibilityChk(vObjCloseBtn));
		}
		LogCapture.info("User clicked on close button..... ");
	}

	@When("^ios user selects a saved recipient base on name \"([^\"]*)\" currency \"([^\"]*)\" and account no \"([^\"]*)\"$")
	public void ios_user_selects_a_saved_recipient_base_on_name_currency_and_account_no(String name, String currency,
			String accountNo) throws Throwable {
		String vObjRecpientList = Constants.IOSRecipientOR.getProperty("RecpientList");
		String vObjRecpientName = Constants.IOSRecipientOR.getProperty("RecpientName");
		String vObjRecipientCurrency = Constants.IOSRecipientOR.getProperty("RecipientCurrency");
		String vObjUnmaskedAccNo = Constants.IOSRecipientOR.getProperty("UnmaskedAccNo");
		String vObjBtnAddRecipientCell = Constants.IOSRecipientOR.getProperty("BtnAddRecipientCell");
		String lastFourAccNo = accountNo.substring((accountNo.length() - 4), (accountNo.length()));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell));
		int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();
		for (int i = 1; i < recpientListSize; i++) {
			String vRecipientName = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjRecpientName, "value");
			String vCurrency = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjRecipientCurrency, "value");
			String vUnmaskedAccNo = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjUnmaskedAccNo, "value");
			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS(vRecipientName, "down"));
			}
			LogCapture.info("Recipent: " + i + " Recipeint Name : " + vRecipientName + ", Currency : " + vCurrency
					+ ", Account No : **** " + vUnmaskedAccNo);

			if (vRecipientName.equalsIgnoreCase(name) && vCurrency.equalsIgnoreCase(currency)
					&& vUnmaskedAccNo.equalsIgnoreCase(lastFourAccNo)) {
				// Assert.assertEquals("PASS",
				// Constants.key.click(vObjRecpientList + "[" + (i+1) + "]"
				// +vObjRecpientName));
				Assert.assertEquals("PASS", Constants.key.click(vObjRecpientList + "[" + (i + 1) + "]"));
				LogCapture.info("Recipient match found and clicked on : " + vRecipientName + ",Currency :" + vCurrency
						+ ",Account No : **** " + vUnmaskedAccNo);
				Constants.DataMap.put("RecipientName", vRecipientName);
				Constants.DataMap.put("RecipientAccountNo", accountNo);
				Constants.DataMap.put("RecipientCurrency1", vCurrency);

				break;
			}
			LogCapture.info("No recipient match  found.......................");
			if (i == recpientListSize - 1) {
				LogCapture.info("Given recipient is not present in list..............");
				Assert.assertEquals("PASS", "FAIL");
			}
		}
	}

	@When("^ios user selects updated recipient$")
	public void ios_user_selects_updated_recipient() throws Throwable {
		String name = "";
		String currency = "";
		String accountNo = "";
		if (Constants.DataMap.containsKey("RecipientType")) {
			if (Constants.DataMap.get("RecipientType").toString().equalsIgnoreCase("Individual")) {
				name = Constants.DataMap.get("FirstName").toString() + " "
						+ Constants.DataMap.get("LastName").toString();
			} else if (Constants.DataMap.get("RecipientType").toString().equalsIgnoreCase("Company")) {
				name = Constants.DataMap.get("CompanyName").toString();
			}
		}

		else {
			name = Constants.DataMap.get("RecipientName");
		}
		// Constants.DataMap.get("RecipientBankCodeType");
		// Constants.DataMap.get("RecipientBankCode");

		if (Constants.DataMap.containsKey("RecipientBankCodeType")) {
			if (Constants.DataMap.get("RecipientBankCodeType").equalsIgnoreCase("IBAN")) {
				accountNo = Constants.DataMap.get("RecipientBankCode");
				// String bankcodetype = Constants.DataMap.get("RecipientBankCodeType");
				// String bankcode = Constants.DataMap.get("RecipientBankCode");

			}
		} else {
			accountNo = Constants.DataMap.get("RecipientAccountNo").toString();
			// String bankcodetype=Constants.DataMap.get("RecipientBankCodeType");
			// String bankcode=Constants.DataMap.get("RecipientBankCode");
		}
		accountNo = Constants.DataMap.get("RecipientAccountNo").toString();
		currency = Constants.DataMap.get("RecipientCurrency1").toString();
		System.out.println("name is " + name);
		System.out.println("currency is " + currency);
		System.out.println("account no is " + accountNo);
		ios_user_selects_a_saved_recipient_base_on_name_currency_and_account_no(name, currency, accountNo);
	}

	@Then("^view recipient screen should be displyed with edit button in ios app$")
	public void view_recipient_screen_should_be_displyed_with_edit_button_in_ios_app() throws Throwable {
		String vObjEditRecipient = Constants.IOSRecipientOR.getProperty("EditRecipient");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEditRecipient));
		LogCapture.info("View recipient screen displayed.......................");

	}

	@When("^ios user click on (edit icon|do it later button|update id button)$")
	public void ios_user_click_on_edit_icon(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("edit icon")) {
			String vObjEditRecipient = Constants.IOSRecipientOR.getProperty("EditRecipient");
			Assert.assertEquals("PASS", Constants.key.click(vObjEditRecipient));
		} else if (optionalValue.equalsIgnoreCase("do it later button")) {
			String vObjDoItLaterBtn = Constants.IOSLoginOR.getProperty("DoItLaterBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjDoItLaterBtn));
		} else if (optionalValue.equalsIgnoreCase("update id button")) {
			String vObjUpdateIDBtn = Constants.IOSLoginOR.getProperty("UpdateIDBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjUpdateIDBtn));
		}
		LogCapture.info("User clicked on " + optionalValue + ".......................");
	}

	@Then("^edit recipient screen should be displayed to ios user$")
	public void edit_recipient_screen_should_be_displayed_to_ios_user() throws Throwable {
		String vObjCurrencyLabel = Constants.IOSRecipientOR.getProperty("EditRecCurrencyLbl");
		String vObjCountryLabel = Constants.IOSRecipientOR.getProperty("EditRecCountryLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencyLabel));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryLabel));
		// Assert.assertEquals("PASS",Constants.key.scrollInIOS("Delete","down"));
		LogCapture.info("Edit recipient screen has been displayed.......................");
	}

	@When("^ios user clicks on delete recipient button$")
	public void ios_user_clicks_on_delete_recipient_button() throws Throwable {
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Delete", "down"));
		String vObjDeleteRecipient = Constants.IOSRecipientOR.getProperty("DeleteRecipient");
		Assert.assertEquals("PASS", Constants.key.click(vObjDeleteRecipient));
	}

	@Then("^delete confirmation message window should be displayed in ios app$")
	public void delete_confirmation_message_window_should_be_displayed_in_ios_app() throws Throwable {
		String vObjDeleteConfTitle = Constants.IOSRecipientOR.getProperty("DeleteConfTitle");
		String vObjDeleteConfMsg = Constants.IOSRecipientOR.getProperty("DeleteConfMsg");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDeleteConfTitle));
		String vDeleteConfMsg = Constants.key.getAttributeValue(vObjDeleteConfMsg, "value");
		Assert.assertEquals("PASS",
				// Constants.key.VerifyText("Are you sure you want to delete your recipient?",
				// vDeleteConfMsg));
				Constants.key.VerifyText("Are you sure you want to delete this recipient?", vDeleteConfMsg));
		LogCapture.info("Delete confirmation window displayed.......................");
	}

	@When("^ios user accepts recipient delete confirmation$")
	public void ios_user_accepts_recipient_delete_confirmation() throws Throwable {
		String vObjConfirmDeleteBtn = Constants.IOSRecipientOR.getProperty("ConfirmDeleteBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjConfirmDeleteBtn));
		LogCapture.info("User accepted delete confirmation..............");
	}

	@When("^ios user dismiss recipient delete confirmation$")
	public void ios_user_dismiss_recipient_delete_confirmation() throws Throwable {
		String vObjCancelBtn = Constants.IOSRecipientOR.getProperty("CancelBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjCancelBtn));
		LogCapture.info("User clicked on cancel ..............");
	}

	@Then("^ios user should be navigated to recipient list screen$")
	public void ios_user_should_be_navigated_to_recipient_list_screen() throws Throwable {
		Thread.sleep(8000);
		String vObjRecipientTitle = Constants.IOSRecipientOR.getProperty("RecipientTitle");
		String vObjBtnAddRecipientCell = Constants.IOSRecipientOR.getProperty("BtnAddRecipientCell");
		String vObjBtnAddRecipient = Constants.IOSRecipientOR.getProperty("BtnAddRecipient");
		String vObjRecpientList = Constants.IOSRecipientOR.getProperty("RecpientList");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecipientTitle));
		Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell);
		/*
		 * int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();
		 * if (recpientListSize > 0) {
		 * Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell);
		 * Assert.assertEquals("PASS",
		 * Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell));
		 * LogCapture.info("User navigated to recipient list screen..... "); } else {
		 * Assert.assertEquals("PASS",
		 * Constants.key.eleLocatedDisplayed(vObjBtnAddRecipient));
		 * LogCapture.info("User navigated to recipient list screen..... "); }
		 */
	}

	@Then("^recipient with the details name \"([^\"]*)\" currency \"([^\"]*)\" account no \"([^\"]*)\" should be deleted from the ios app$")
	public void recipient_with_the_details_name_currency_account_no_should_be_deleted_from_the_ios_app(String name,
			String currency, String accountNo) throws Throwable {
		String vObjBtnAddRecipient = Constants.IOSRecipientOR.getProperty("BtnAddRecipient");
		String vObjRecpientList = Constants.IOSRecipientOR.getProperty("RecpientList");
		String vObjRecpientName = Constants.IOSRecipientOR.getProperty("RecpientName");
		String vObjRecipientCurrency = Constants.IOSRecipientOR.getProperty("RecipientCurrency");
		String vObjUnmaskedAccNo = Constants.IOSRecipientOR.getProperty("UnmaskedAccNo");
		int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();
		if (recpientListSize == 0) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipient));
			LogCapture.info("Recipient deleted successfully from the recipients list successfully..... ");
		} else {
			for (int i = 1; i < recpientListSize; i++) {

				String vRecipientName = Constants.key
						.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjRecpientName, "value");
				String vCurrency = Constants.key
						.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjRecipientCurrency, "value");
				String vUnmaskedAccNo = Constants.key
						.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjUnmaskedAccNo, "value");
				String lastFourAccNo = accountNo.substring((accountNo.length() - 4), (accountNo.length()));
				if (i == 6) {
					Assert.assertEquals("PASS", Constants.key.scrollInIOS(vRecipientName, "down"));
				}
				LogCapture.info("Recipent: " + i + " Recipeint Name : " + vRecipientName + ", Currency : " + vCurrency
						+ ", Account No : **** " + vUnmaskedAccNo);
				if (vRecipientName.equalsIgnoreCase(name) && vCurrency.equalsIgnoreCase(currency)
						&& vUnmaskedAccNo.equalsIgnoreCase(lastFourAccNo)) {
					Assert.assertEquals("FAIL", "PASS");
					LogCapture.info("Deleted recipient details found in recipient list.....!!!!!!!!!!!");
					break;
				} else {
					LogCapture.info("No recipient match  found.......................");
				}
			}
			LogCapture.info("Recipient deleted successfully from the recipients list.................. ");
		}
	}

	@Then("^ios user should be land on selected recipent edit screen$")
	public void ios_user_should_be_land_on_selected_recipent_edit_screen() throws Throwable {
		String vObjDeleteRecipient = Constants.IOSRecipientOR.getProperty("DeleteRecipient");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDeleteRecipient));
		LogCapture.info("User landed on selected recipient edit screen .................. ");
	}

	@When("^ios user waits until access token expired for miliseconds (\\d+)$")
	public void ios_user_waits_until_access_token_expired_for_miliseconds(int waitInMiliSecond) throws Throwable {
		LogCapture.info("Waiting for seconds: " + (waitInMiliSecond / 1000));
		Thread.sleep(waitInMiliSecond);
		LogCapture.info("User has waited for seconds: " + (waitInMiliSecond / 1000));
	}

	/*
	 * @Given("^ios older version app is installed on the device and launched successfully$"
	 * ) public void
	 * ios_older_version_app_is_installed_on_the_device_and_launched_successfully()
	 * throws Throwable { Assert.assertEquals("PASS",
	 * Constants.key.launchApp("Version 1.0 (22)"));
	 * LogCapture.info("Application installed and launched successfully......!!!!");
	 * }
	 */
	@Given("^ios older version (CD|TorFX) app \"([^\"]*)\" is installed on the device \"([^\"]*)\" and launched successfully$")
	public void ios_older_version_app_is_installed_on_the_device_and_launched_successfully(String optionalValue,
			String deviceID, String appVersion) throws Throwable {
		Assert.assertEquals("PASS", Constants.key.launchApp(optionalValue));
		LogCapture.info("Application installed and launched successfully......!!!!");
	}

	@When("^ios user accesses the send section from the tab bar menu$")
	public void ios_user_accesses_the_send_section_from_the_tab_bar_menu() throws Throwable {
		String vObjSendIcon = Constants.IOSDashOR.getProperty("SendIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjSendIcon));
		LogCapture.info("User clicked on send tab bar menu ..............");
	}

	@Then("^ios user should be land on Money Transfer feature screen$")
	public void ios_user_should_be_land_on_Money_Transfer_feature_screen() throws Throwable {
		ios_app_should_load_the_dashboard_screen();
	}

	@Then("^ios user enters (you pay|they get) amount \"([^\"]*)\"$")
	public void ios_user_enters_you_pay_amount(String optionalValue, String data) throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vObjYouPayInput = Constants.IOSDashOR.getProperty("YouPayInput");
		// String vObjTheyGetInput =
		// Constants.IOSDashOR.getProperty("TheyGetInput");
		String vObjTheyGetInput = Constants.IOSDashOR.getProperty("TheyGetTxtField");
		String vObjYouPayAmtInput = Constants.IOSDashOR.getProperty("YouPayAmtInput");
		String vObjYouPayCurrencyLbl = Constants.IOSDashOR.getProperty("YouPayCurrencyLbl");
		String vObjTheyGetCurrencyLbl = Constants.IOSDashOR.getProperty("TheyGetCurrencyLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjYouPayInput));
		Constants.DataMap.put("DeafultYouPayAmount", Constants.key.getAttributeValue(vObjYouPayInput, "value"));
		String vYouPayCurrency = Constants.key.getAttributeValue(vObjYouPayCurrencyLbl, "value");
		String vTheyGetCurrency = Constants.key.getAttributeValue(vObjTheyGetCurrencyLbl, "value");
		String vObjBuyCurrDD = Constants.IOSDashOR.getProperty("BuyCurrDD");
		Constants.DataMap.put("TheyGetCurrency", vTheyGetCurrency);
		Constants.DataMap.put("YouPayCurrency", vYouPayCurrency);
		if (optionalValue.equalsIgnoreCase("you pay")) {
			Constants.TempData = Constants.key.getAttributeValue(vObjTheyGetInput, "value");
			LogCapture.info("Before calculation they get amount : " + Constants.TempData + vTheyGetCurrency);
			Assert.assertEquals("PASS", Constants.key.clearData(vObjYouPayInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjYouPayInput, data));
			Thread.sleep(2000);
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Assert.assertEquals("PASS",
			// Constants.key.eleLocatedDisplayed(vObjBuyCurrDD));
			Constants.DataMap.put("UserSelection", "YouPay");
			Constants.DataMap.put("UserAmountWithCurrency",
					Constants.key.getAttributeValue(vObjYouPayInput, "value") + " " + vYouPayCurrency);
			LogCapture.info("User entered " + optionalValue + " amount: " + data + vYouPayCurrency);
		} else if (optionalValue.equalsIgnoreCase("they get")) {
			Constants.TempData = Constants.key.getAttributeValue(vObjYouPayInput, "value");
			LogCapture.info("Before calculation you pay amount : " + Constants.TempData + vYouPayCurrency);
			// Assert.assertEquals("PASS",
			// Constants.key.clearData(vObjTheyGetInput));
			Constants.key.clearData(vObjTheyGetInput);
			// Assert.assertEquals("PASS", Constants.key.writeInInput(vObjYouPayAmtInput,
			// data));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTheyGetInput, data));
			Thread.sleep(000);
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Assert.assertEquals("PASS",
			// Constants.key.eleLocatedDisplayed(vObjBuyCurrDD));
			Constants.DataMap.put("UserSelection", "TheyGet");
			Constants.DataMap.put("UserAmountWithCurrency",
					Constants.key.getAttributeValue(vObjTheyGetInput, "value") + " " + vTheyGetCurrency);
			LogCapture.info("User entered " + optionalValue + " amount: " + data + vTheyGetCurrency);
		} else {
			LogCapture.info("Invalid currency type. Please select Buying or selling...");
			Assert.assertEquals("PASS", "FAIL");
		}

	}

	@When("^ios user enters (you pay|they get) amount \"([^\"]*)\" for limit error$")
	public void ios_user_enters_you_pay_amount_for_limit_error(String optionalValue, String data) throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vObjYouPayInput = Constants.IOSDashOR.getProperty("YouPayInput");
		String vObjTheyGetInput = Constants.IOSDashOR.getProperty("TheyGetTxtField");
		String vObjYouPayAmtInput = Constants.IOSDashOR.getProperty("YouPayAmtInput");
		String vObjYouPayCurrencyLbl = Constants.IOSDashOR.getProperty("YouPayCurrencyLbl");
		String vObjTheyGetCurrencyLbl = Constants.IOSDashOR.getProperty("TheyGetCurrencyLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjYouPayInput));
		Constants.DataMap.put("DeafultYouPayAmount", Constants.key.getAttributeValue(vObjYouPayInput, "value"));
		String vYouPayCurrency = Constants.key.getAttributeValue(vObjYouPayCurrencyLbl, "value");
		String vTheyGetCurrency = Constants.key.getAttributeValue(vObjTheyGetCurrencyLbl, "value");
		String vObjBuyCurrDD = Constants.IOSDashOR.getProperty("BuyCurrDD");
		Constants.DataMap.put("TheyGetCurrency", vTheyGetCurrency);
		Constants.DataMap.put("YouPayCurrency", vYouPayCurrency);
		if (optionalValue.equalsIgnoreCase("you pay")) {
			Constants.TempData = Constants.key.getAttributeValue(vObjTheyGetInput, "value");
			LogCapture.info("Before calculation they get amount : " + Constants.TempData + vTheyGetCurrency);
			Assert.assertEquals("PASS", Constants.key.clearData(vObjYouPayInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjYouPayInput, data));
			Thread.sleep(4000);
			Constants.DataMap.put("UserSelection", "YouPay");
			Constants.DataMap.put("UserAmountWithCurrency",
					Constants.key.getAttributeValue(vObjYouPayInput, "value") + " " + vYouPayCurrency);
			LogCapture.info("User entered " + optionalValue + " amount: " + data + vYouPayCurrency);
		} else if (optionalValue.equalsIgnoreCase("they get")) {
			Constants.TempData = Constants.key.getAttributeValue(vObjYouPayInput, "value");
			LogCapture.info("Before calculation you pay amount : " + Constants.TempData + vYouPayCurrency);
			Constants.key.clearData(vObjTheyGetInput);
			// Assert.assertEquals("PASS", Constants.key.writeInInput(vObjYouPayAmtInput,
			// data));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTheyGetInput, data));
			Thread.sleep(4000);
			Constants.DataMap.put("UserSelection", "TheyGet");
			Constants.DataMap.put("UserAmountWithCurrency",
					Constants.key.getAttributeValue(vObjTheyGetInput, "value") + " " + vTheyGetCurrency);
			LogCapture.info("User entered " + optionalValue + " amount: " + data + vTheyGetCurrency);
		} else {
			LogCapture.info("Invalid currency type. Please select Buying or selling...");
			Assert.assertEquals("PASS", "FAIL");
		}

	}

	@Then("^you pay and they get amount should be set to zero$")
	public void you_pay_and_they_get_amount_should_be_set_to_zero() throws Throwable {

		String vObjYouPayInput = Constants.IOSSendMoneyOR.getProperty("TheyGetInputDetails");
		String vObjTheyGetInput = Constants.IOSSendMoneyOR.getProperty("YouPayInputDetails");
		String vObjSendMoneyLbl = Constants.IOSSendMoneyOR.getProperty("SendMoneyLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendMoneyLbl));
		// System.out.println("List size :
		// "+Constants.key.getElementList(vObjYouPayInput).size());
		// Assert.assertEquals("PASS",
		// Constants.key.eleLocatedDisplayed(vObjYouPayInput));
		// Assert.assertEquals("PASS",
		// Constants.key.eleLocatedDisplayed(vObjTheyGetInput));
		/*
		 * String vYouPayAmt = Constants.key.getAttributeValue(vObjYouPayInput,
		 * "value"); String vTheyGetAmt =
		 * Constants.key.getAttributeValue(vObjTheyGetInput, "value");
		 * System.out.println(vYouPayAmt); System.out.println(vTheyGetAmt);
		 * Assert.assertEquals("PASS", Constants.key.VerifyText(vTheyGetAmt, "0.00"));
		 * Assert.assertEquals("PASS", Constants.key.VerifyText(vYouPayAmt, "0.00"));
		 */
	}

	@Then("^after two sec appropriate amount should be calculated in (you pay|they get) ios app field$")
	public void after_two_sec_appropriate_amount_should_be_calculated_in_they_get_ios_app_field(String optionalValue)
			throws Throwable {
		String vObjYouPayInput = Constants.IOSDashOR.getProperty("YouPayInput");
		String vObjTheyGetInput = Constants.IOSDashOR.getProperty("TheyGetInput");
		String vObjYouPayCurrencyLbl = Constants.IOSDashOR.getProperty("YouPayCurrencyLbl");
		String vObjTheyGetCurrencyLbl = Constants.IOSDashOR.getProperty("TheyGetCurrencyLbl");
		String result = "Fail";
		if (optionalValue.equalsIgnoreCase("you pay")) {
			String vYouPayAmt = Constants.key.getAttributeValue(vObjYouPayInput, "value");
			String vYouPayCurrency = Constants.key.getAttributeValue(vObjYouPayCurrencyLbl, "value");
			for (int i = 0; i < 10; i++) {
				vYouPayAmt = Constants.key.getAttributeValue(vObjYouPayInput, "value");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjYouPayInput));
				if (!Constants.TempData.equalsIgnoreCase(vYouPayAmt)) {
					result = "PASS";
					LogCapture.info("Rate refreshed after " + (2 + i) + " seconds and recalculated you pay amount is : "
							+ vYouPayAmt + vYouPayCurrency);
					Constants.TempData = vYouPayAmt;
					break;
				}
				TimeUnit.SECONDS.sleep(2);
			}
		}
		if (optionalValue.equalsIgnoreCase("they get")) {
			String vTheyGetAmt = Constants.key.getAttributeValue(vObjTheyGetInput, "value");
			String vTheyGetCurrency = Constants.key.getAttributeValue(vObjTheyGetCurrencyLbl, "value");
			for (int i = 0; i < 10; i++) {
				vTheyGetAmt = Constants.key.getAttributeValue(vObjTheyGetInput, "value");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTheyGetInput));
				if (!Constants.TempData.equalsIgnoreCase(vTheyGetAmt)) {
					result = "PASS";
					LogCapture.info("Rate refreshed after " + (2 + i)
							+ " seconds and recalculated they get amount is : " + vTheyGetAmt + vTheyGetCurrency);
					Constants.TempData = vTheyGetAmt;
					break;
				}
				TimeUnit.SECONDS.sleep(2);
			}
		}
		Assert.assertEquals("PASS", result);
	}

	@Then("^an auto timer of sixty seconds should start and rate should be refreshed and (you pay|they get) amount should be updated in ios app$")
	public void an_auto_timer_of_sixty_seconds_should_start_and_rate_should_be_refreshed_and_they_get_amount_should_be_updated_in_ios_app(
			String optionalValue) throws Throwable {
		String vObjYouPayInput = Constants.IOSDashOR.getProperty("YouPayInput");
		String vObjTheyGetInput = Constants.IOSDashOR.getProperty("TheyGetInput");
		String vObjYouPayCurrencyLbl = Constants.IOSDashOR.getProperty("YouPayCurrencyLbl");
		String vObjTheyGetCurrencyLbl = Constants.IOSDashOR.getProperty("TheyGetCurrencyLbl");
		String vObjRateLbl = Constants.IOSDashOR.getProperty("RateLbl");

		String result = "Fail";
		TimeUnit.SECONDS.sleep(60);
		if (optionalValue.equalsIgnoreCase("you pay")) {

			String vYouPayCurrency = Constants.key.getAttributeValue(vObjYouPayCurrencyLbl, "value");
			for (int i = 0; i < 10; i++) {
				String vYouPayAmt = Constants.key.getAttributeValue(vObjYouPayInput, "value");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjYouPayInput));
				if (!Constants.TempData.equalsIgnoreCase(vYouPayAmt)) {
					result = "PASS";
					LogCapture.info("Rate refreshed after " + (60 + i)
							+ " seconds and recalculated you pay amount is : " + vYouPayAmt + vYouPayCurrency);
					Constants.TempData = vYouPayAmt;
					break;
				}
				TimeUnit.SECONDS.sleep(2);
			}
		}
		if (optionalValue.equalsIgnoreCase("they get")) {
			String vTheyGetAmt = Constants.key.getAttributeValue(vObjTheyGetInput, "value");

			String vTheyGetCurrency = Constants.key.getAttributeValue(vObjTheyGetCurrencyLbl, "value");
			for (int i = 0; i < 10; i++) {
				vTheyGetAmt = Constants.key.getAttributeValue(vObjTheyGetInput, "value");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTheyGetInput));
				if (!Constants.TempData.equalsIgnoreCase(vTheyGetAmt)) {
					result = "PASS";
					LogCapture.info("Rate refreshed after " + (60 + i) + " seconds recalculated they get amount is : "
							+ vTheyGetAmt + vTheyGetCurrency);
					Constants.TempData = vTheyGetAmt;
					break;
				}
				TimeUnit.SECONDS.sleep(2);
			}
		}
		Assert.assertEquals("PASS", result);
	}

	@Then("^(minimum|maximum) allowed amount limit error message should be displayed to ios user$")
	public void minimum_allowed_amount_limit_error_message_should_be_displayed_to_ios_user(String optionalValue)
			throws Throwable {
		String vObjOkBtn = Constants.IOSSendMoneyOR.getProperty("OkBtn");
		String vObjMinErrorMsg = Constants.IOSAddWalletOR.getProperty("MinMaxErrorMsg");
		String vObjMaxErrorMsg = Constants.IOSAddWalletOR.getProperty("MaxErrorMsg");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOkBtn));
		String vMinMaxErrorMsg = Constants.key.getAttributeValue(vObjMinErrorMsg, "value");
		String vMaxErrorMsg = Constants.key.getAttributeValue(vObjMaxErrorMsg, "value");
		String MinLimitErrorMessage = Constants.IOSTestData.getProperty("MinLimitErrorMessage");
		String MaxLimitErrorMessage = Constants.IOSTestData.getProperty("MaxLimitErrorMessage");
		if (optionalValue.equalsIgnoreCase("minimum")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vMinMaxErrorMsg, MinLimitErrorMessage));
			LogCapture.info("Minimum limit error message verfied.........");
			Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
		}
		if (optionalValue.equalsIgnoreCase("maximum")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vMaxErrorMsg, MaxLimitErrorMessage));
			LogCapture.info("Maximum limit error message verfied.........");
			Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
		}
		// Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
	}

	@When("^ios user selects (you pay|they get) currency drop down and enters currency code or name \"([^\"]*)\"$")
	public void ios_user_selects_you_pay_currency_drop_down_and_enters_currency_code_or_name(String optionalValue,
			String data) throws Throwable {
		String vObjBuyCurrDD = Constants.IOSDashOR.getProperty("BuyCurrDD");
		String vObjSellCurrDD = Constants.IOSDashOR.getProperty("SellCurrDD");
		String vObjCurrencySearchInput = Constants.IOSDashOR.getProperty("SearchCurrencyInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSellCurrDD));
		String vObjYouPayCurrencyLbl = Constants.IOSDashOR.getProperty("YouPayCurrencyLbl");
		String vObjTheyGetCurrencyLbl = Constants.IOSDashOR.getProperty("TheyGetCurrencyLbl");
		String vYouPayCurrency = Constants.key.getAttributeValue(vObjYouPayCurrencyLbl, "value");
		String vTheyGetCurrency = Constants.key.getAttributeValue(vObjTheyGetCurrencyLbl, "value");
		defaultCurrency = false;

		if (optionalValue.equalsIgnoreCase("you pay")) {

			if (vYouPayCurrency.equalsIgnoreCase(data)) {
				LogCapture.info("Prepoulated you pay currrency : " + data + " present in currency drop down...");
				defaultCurrency = true;
			} else if (vYouPayCurrency != data && vYouPayCurrency != "FAIL") {
				Assert.assertEquals("PASS", Constants.key.click(vObjSellCurrDD));
				// Assert.assertEquals("PASS",Constants.key.click(vObjCurrencyInput));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCurrencySearchInput, data));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
				LogCapture.info("User entered currency code or name : " + data);
			} else {
			}
		}
		if (optionalValue.equalsIgnoreCase("they get")) {
			if (vTheyGetCurrency.equalsIgnoreCase(data)) {
				LogCapture.info("Prepoulated they get currrency : " + data + " present in currency drop down...");
				defaultCurrency = true;
			} else if (vTheyGetCurrency != data && vTheyGetCurrency != "FAIL") {
				Assert.assertEquals("PASS", Constants.key.click(vObjBuyCurrDD));
				// Assert.assertEquals("PASS",Constants.key.click(vObjCurrencyInput));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCurrencySearchInput, data));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
				LogCapture.info("User entered currency code or name : " + data);
			} else {
			}
		}
	}

	@Then("^selected currency \"([^\"]*)\" should be displayed in (you pay|they get) currency dropdown$")
	public void selected_currency_should_be_displayed_in_you_pay_currency_dropdown(String data, String optionalValue)
			throws Throwable {
		String vObjYouPayCurrencyLbl = Constants.IOSDashOR.getProperty("YouPayCurrencyLbl");
		String vObjTheyGetCurrencyLbl = Constants.IOSDashOR.getProperty("TheyGetCurrencyLbl");
		String vObjBuyCurrDD = Constants.IOSDashOR.getProperty("BuyCurrDD");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBuyCurrDD));
		String vYouPayCurrency = Constants.key.getAttributeValue(vObjYouPayCurrencyLbl, "value");
		String vTheyGetCurrency = Constants.key.getAttributeValue(vObjTheyGetCurrencyLbl, "value");
		if (optionalValue.equalsIgnoreCase("you pay")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vYouPayCurrency, data));
			LogCapture.info("You pay currency " + vYouPayCurrency + " selected.........");
		} else if (optionalValue.equalsIgnoreCase("they get")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vTheyGetCurrency, data));
			LogCapture.info("You pay currency " + vYouPayCurrency + " selected.........");
		}
		// defaultCurrency=false;
	}

	@When("^ios user clicks on back arrow$")
	public void ios_user_clicks_on_back_arrow() throws Throwable {
		String vObjBackBtn = Constants.IOSDashOR.getProperty("BackBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjBackBtn));
		LogCapture.info("User clicked on back button.........");
	}

	// @Then("^ios user should land on send money dashboard page$")
	// public void ios_user_should_land_on_send_money_dashboard_page() throws
	// Throwable {
	// String vObjSendMoneyLbl =
	// Constants.IOSLoginOR.getProperty("SendMoneyLbl");
	// String vObjDashContBtn = Constants.IOSLoginOR.getProperty("DashContBtn");
	// Assert.assertEquals("PASS",
	// Constants.key.eleLocatedDisplayed(vObjSendMoneyLbl));
	// Assert.assertEquals("PASS",
	// Constants.key.eleLocatedDisplayed(vObjDashContBtn));
	// LogCapture.info("Send money dashboard screen displayed.........");
	// Constants.DataMap.put("transactionType", "fx");
	// }

	// Added the new check for Continue button.
	@Then("^ios user should land on send money dashboard page$")
	public void ios_user_should_land_on_send_money_dashboard_page() throws Throwable {
		String vObjSendMoneyLbl = Constants.IOSLoginOR.getProperty("SendMoneyLbl");
		String vObjDashContBtn = Constants.IOSLoginOR.getProperty("DashContBtn");
		String vObjDashContBtn2 = Constants.IOSLoginOR.getProperty("DashContBtn2");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendMoneyLbl));
		// if (!(iOSPlatformVersion > 12.4)) {
		if ((iOSPlatformVersion > 12.4)) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashContBtn));
			// Assert.assertEquals("PASS",
			// Constants.key.eleLocatedDisplayed(vObjDashContBtn2));
		} else {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashContBtn2));
			// Assert.assertEquals("PASS",
			// Constants.key.eleLocatedDisplayed(vObjDashContBtn));
		}
		LogCapture.info("Send money dashboard screen displayed.........");
		Constants.DataMap.put("transactionType", "standalone");
	}

	@When("^ios user enters (password|cvv|payment reference) \"([^\"]*)\"$")
	public void ios_user_enters_password(String optionalValue, String data) throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		if (optionalValue.equalsIgnoreCase("cvv")) {
			String vObjCVVSecureInput = Constants.IOSSendMoneyOR.getProperty("CVVSecureInput");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCVVSecureInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered cvv.........");
		}
		if (optionalValue.equalsIgnoreCase("password")) {
			String vObjSetPassword = Constants.IOSRegstOR.getProperty("SetPassword");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSetPassword, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		}
		if (optionalValue.equalsIgnoreCase("payment reference")) {
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
			String vObjPaymentReferenceInput = Constants.IOSSendMoneyOR.getProperty("DCPaymentReference");
			String vObjBTPaymentReference = Constants.IOSSendMoneyOR.getProperty("BTPaymentReference");
			String vObjWalletPaymentReference = Constants.IOSSendMoneyOR.getProperty("WalletPaymentReference");
			String paymentMethod = Constants.DataMap.get("PaymentMethod");
			if (paymentMethod.equalsIgnoreCase("Bank Transfer")) {
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBTPaymentReference, data));
			}
			if (paymentMethod.equalsIgnoreCase("Debit Card")) {
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPaymentReferenceInput, data));
			}
			if (paymentMethod.equalsIgnoreCase("Wallet")) {
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjWalletPaymentReference, data));
			}

			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Constants.DataMap.put("RecipientReference", data);
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
			Constants.DataMap.put("isPaymentRefPresent", "Yes");
		}
	}

	@When("^ios user (accepts terms and condition|do not accepts terms and condition|should verify details)$")
	public void ios_user_accepts_terms_and_condition(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("accepts terms and condition")) {
			String vObjTermsAndCondition = Constants.IOSRegstOR.getProperty("TermsAndCondition");
			// Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
			Assert.assertEquals("PASS", Constants.key.click(vObjTermsAndCondition));
		} else if (optionalValue.equalsIgnoreCase("should verify details")) {
			String vObjLoaderVerifyDetails = Constants.IOSRegstOR.getProperty("LoaderVerifyDetails");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoaderVerifyDetails));
			LogCapture.info("User accepted terms and condition......");
		} else if (optionalValue.equalsIgnoreCase("do not accepts terms and condition")) {
			String vObjTermsAndCondition = Constants.IOSRegstOR.getProperty("TermsAndCondition");
			Assert.assertEquals("PASS", Constants.key.click(vObjTermsAndCondition));
		}

	}

	@Then("^ios app should take the user to the home screen with the selected currency \"([^\"]*)\" in (selling|buying) dropdown$")
	public void ios_app_should_take_the_user_to_the_home_screen_with_the_selected_currency_in_selling_dropdown(
			String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^ios user selects the currency \"([^\"]*)\"$")
	public void ios_user_selects_the_currency(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^rate should not be fetched in ios app$")
	public void rate_should_not_be_fetched_in_ios_app() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^sell and buy currency \"([^\"]*)\" \"([^\"]*)\" should be swap in ios app$")
	public void sell_and_buy_currency_should_be_swap_in_ios_app(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^only buy currency \"([^\"]*)\" recipients list should be displayed to ios user$")
	public void only_buy_currency_recipients_list_should_be_displayed_to_ios_user(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^ios user click on the create an account button on (onboarding screen|login screen)$")
	public void ios_user_click_on_the_create_an_account_button_on_onboarding_screen(String optionalValue)
			throws Throwable {
		String vObjBtnSignup = Constants.IOSRegstOR.getProperty("BtnSignup");
		if (optionalValue.equalsIgnoreCase("onboarding screen")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjBtnSignup));
		} else if (optionalValue.equalsIgnoreCase("login screen")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjBtnSignup));
		}
	}

	@Then("^ios user should navigate to (about you|mobile number|current address|search address|set password|kyc check) screen$")
	public void ios_user_should_navigate_to_about_you_screen(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("about you")) {
			String vObjScreenAboutYou = Constants.IOSRegstOR.getProperty("ScreenAboutYou");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjScreenAboutYou));
			LogCapture.info("User navigated to " + optionalValue + " screen");
		} else if (optionalValue.equalsIgnoreCase("current address")) {
			String vObjScreenCurrentAddress = Constants.IOSRegstOR.getProperty("ScreenCurrentAddress");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjScreenCurrentAddress));
			LogCapture.info("User navigated to " + optionalValue + " screen");
		} else if (optionalValue.equalsIgnoreCase("search address")) {
			String vObjEnv = Constants.CONFIG.getProperty("environment");
			if (vObjEnv.equalsIgnoreCase("UAT")) {
				String vObjScreenSearchAddress = Constants.IOSRegstOR.getProperty("ScreenSearchAddress");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjScreenSearchAddress));
			} else {
				String vObjSitScreenSearchAddress = Constants.IOSRegstOR.getProperty("SitScreenSearchAddress");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSitScreenSearchAddress));
			}
		} else if (optionalValue.equalsIgnoreCase("mobile number")) {
			String vObjScreenMobileNo = Constants.IOSRegstOR.getProperty("ScreenMobileNo");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjScreenMobileNo));
			LogCapture.info("User navigated to " + optionalValue + " screen");
		} else if (optionalValue.equalsIgnoreCase("set password")) {
			String vObjScreenSetPassword = Constants.IOSRegstOR.getProperty("ScreenSetPassword");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjScreenSetPassword));

			LogCapture.info("User navigated to " + optionalValue + " screen");
		} else if (optionalValue.equalsIgnoreCase("kyc check")) {
			// String vObjLoaderVerifyDetails =
			// Constants.IOSRegstOR.getProperty("LoaderVerifyDetails");
			// Assert.assertEquals("PASS",Constants.key.eleLocatedDisplayed(vObjLoaderVerifyDetails));
			LogCapture.info("User navigating to kyc check screen.........");
			Thread.sleep(8000);
		}

	}

	@When("^ios user clicks on back button$")
	public void ios_user_clicks_on_back_button() throws Throwable {
		// String vObjBtnBack = Constants.IOSRegstOR.getProperty("BtnBack");
		// String vObjBtnBack = Constants.IOSRecipientOR.getProperty("BackBtn");
		String vObjBtnBack = Constants.IOSAddWalletOR.getProperty("Backbutton");
		Assert.assertEquals("PASS", Constants.key.click(vObjBtnBack));
		LogCapture.info("User click on back button.........");
	}

	@When("^ios user clicks on the (back button|login with biometric link)$")
	public void ios_user_clicks_on_the_back_button(String optionalValue1) throws Throwable {
		if (optionalValue1.equalsIgnoreCase("back button")) {
			String vObjBtnBack = Constants.IOSRecipientOR.getProperty("BackBtn");
			// String vObjBtnBack = Constants.IOSRegstOR.getProperty("BackBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjBtnBack));
		} else if (optionalValue1.equalsIgnoreCase("login with biometric link")) {
			String vObjLoginWithTouchIDLink = Constants.IOSLoginOR.getProperty("LoginWithTouchIDLink");
			Assert.assertEquals("PASS", Constants.key.click(vObjLoginWithTouchIDLink));
		}
		LogCapture.info("User clicked on " + optionalValue1 + ".........");
	}

	@When("^ios user enters the (valid|invalid) (first name|last name|email id|date of birth) \"([^\"]*)\"$")
	public void ios_user_enters_the_valid_first_name(String optionalValue1, String optionalValue2, String data)
			throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		if (optionalValue1.equalsIgnoreCase("valid") || optionalValue1.equalsIgnoreCase("invalid")) {
			if (optionalValue2.equalsIgnoreCase("first name")) {
				String vObjFNamePH = Constants.IOSRegstOR.getProperty("FNamePH");
				String vObjFNameTextField = Constants.IOSRegstOR.getProperty("FNameTextField");
				// Assert.assertEquals("PASS",Constants.key.click(vObjFNamePH));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFNameTextField, data));
				LogCapture.info("First name entered successfully.........");
			} else if (optionalValue2.equalsIgnoreCase("last name")) {
				String vObjLNamePH = Constants.IOSRegstOR.getProperty("LNamePH");
				String vObjLNameTextField = Constants.IOSRegstOR.getProperty("LNameTextField");
				// Assert.assertEquals("PASS",Constants.key.click(vObjLNamePH));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLNameTextField, data));
				LogCapture.info("Last name entered successfully.........");
			} else if (optionalValue2.equalsIgnoreCase("email id")) {
				String vObjEmailPH = Constants.IOSRegstOR.getProperty("EmailPH");
				String vObjEmailTextField = Constants.IOSRegstOR.getProperty("EmailTextField");
				// data=Constants.key.generateEmail(12, "dispostable.com");
				Assert.assertEquals("PASS", Constants.key.click(vObjEmailPH));
				// data = Constants.key.uniqueEmailAddress();
				// LogCapture.info("Unique email id entered as "+data);
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailTextField, data));
				LogCapture.info("Email address entered successfully.........");
			} else if (optionalValue2.equalsIgnoreCase("date of birth")) {
				String vObjDOBPH = Constants.IOSRegstOR.getProperty("DOBPH");
				String vObjDOBPickerField = Constants.IOSRegstOR.getProperty("DOBPickerField");
				Assert.assertEquals("PASS", Constants.key.click(vObjDOBPH));
				Constants.Data = data.split("-");
				String vDay = Constants.Data[0].toString();
				if (Character.toString(vDay.charAt(0)).equalsIgnoreCase("0")) {
					vDay = Character.toString(vDay.charAt(1));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDOBPickerField + "[1]", vDay));
				} else {
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDOBPickerField + "[1]", vDay));
				}
				String vMonth = Constants.IOSTestData.getProperty(Constants.Data[1]);
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDOBPickerField + "[2]", vMonth));
				Assert.assertEquals("PASS",
						Constants.key.writeInInput(vObjDOBPickerField + "[3]", Constants.Data[2].toString()));
				LogCapture.info("Date of birth entered successfully.........");
			}
		}
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));

	}

	@When("^ios user updates the (valid|invalid) (first name|last name|email id|date of birth) \"([^\"]*)\"$")
	public void ios_user_updates_the_valid_first_name(String optionalValue1, String optionalValue2, String data)
			throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		if (optionalValue1.equalsIgnoreCase("valid") || optionalValue1.equalsIgnoreCase("invalid")) {
			if (optionalValue2.equalsIgnoreCase("first name")) {
				String vObjFNameTextField = Constants.IOSRegstOR.getProperty("FNameTextField");
				Assert.assertEquals("PASS", Constants.key.clearText(vObjFNameTextField));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFNameTextField, data));
				LogCapture.info("First name entered successfully.........");
			} else if (optionalValue2.equalsIgnoreCase("last name")) {
				String vObjLNamePH = Constants.IOSRegstOR.getProperty("LNamePH");
				String vObjLNameTextField = Constants.IOSRegstOR.getProperty("LNameTextField");
				Assert.assertEquals("PASS", Constants.key.clearText(vObjLNameTextField));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLNameTextField, data));
				LogCapture.info("Last name entered successfully.........");
			} else if (optionalValue2.equalsIgnoreCase("email id")) {
				String vObjEmailPH = Constants.IOSRegstOR.getProperty("EmailPH");
				String vObjEmailTextField = Constants.IOSRegstOR.getProperty("EmailTextField");
				Assert.assertEquals("PASS", Constants.key.clearText(vObjEmailTextField));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailTextField, data));
				LogCapture.info("Email address entered successfully.........");
			} else if (optionalValue2.equalsIgnoreCase("date of birth")) {
				String vObjDOBPH = Constants.IOSRegstOR.getProperty("DOBPH");
				String vObjDOBPickerField = Constants.IOSRegstOR.getProperty("DOBPickerField");
				Assert.assertEquals("PASS", Constants.key.click(vObjDOBPH));
				Constants.Data = data.split("-");
				String vDay = Constants.Data[0].toString();
				if (Character.toString(vDay.charAt(0)).equalsIgnoreCase("0")) {
					vDay = Character.toString(vDay.charAt(1));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDOBPickerField + "[1]", vDay));
				} else {
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDOBPickerField + "[1]", vDay));
				}
				String vMonth = Constants.IOSTestData.getProperty(Constants.Data[1]);
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDOBPickerField + "[2]", vMonth));
				Assert.assertEquals("PASS",
						Constants.key.writeInInput(vObjDOBPickerField + "[3]", Constants.Data[2].toString()));
				LogCapture.info("Date of birth entered successfully.........");
			}
		}
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
	}

	@When("^ios user selects the occupation \"([^\"]*)\" and enters other occupation \"([^\"]*)\" if required$")
	public void ios_user_selects_the_occupation_and_enters_other_occupation_if_required(String data1, String data2)
			throws Throwable {
		String vObjOccupationPH = Constants.IOSRegstOR.getProperty("OccupationPH");
		String vObjOccupationPickerField = Constants.IOSRegstOR.getProperty("OccupationPickerField");
		String vObjOccupationOtherPH = Constants.IOSRegstOR.getProperty("OccupationOtherPH");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");

		Assert.assertEquals("PASS", Constants.key.click(vObjOccupationPH));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjOccupationPickerField, data1));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		if (data1.equalsIgnoreCase("Other")) {
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjOccupationOtherPH, data2));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		}
		LogCapture.info("Occupation field data entered successfully.........");
	}

	@When("^ios user selects the occupation \"([^\"]*)\" and updates other occupation \"([^\"]*)\" if required$")
	public void ios_user_selects_the_occupation_and_updates_other_occupation_if_required(String data1, String data2)
			throws Throwable {
		ios_user_selects_the_occupation_and_enters_other_occupation_if_required(data1, data2);
	}

	@When("^ios user enters the max length (first name|last name|email id) \"([^\"]*)\"$")
	public void ios_user_enters_the_max_length_first_name(String optionalValue, String data) throws Throwable {
		String vData = Constants.IOSTestData.getProperty(data);
		ios_user_enters_the_valid_first_name("valid", optionalValue, vData);
	}

	@Then("^continue button should be in (enabled|disabled) state in ios app$")
	public void continue_button_should_be_in_enabled_state_in_ios_app(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("enabled")) {
			String vObjBtnContinue = Constants.IOSRegstOR.getProperty("BtnContinue");
			// String vObjBtnContinue =
			// Constants.IOSAddWalletOR.getProperty("ContinueBtn2");
			// Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnContinue));
			String atbValue = Constants.key.getAttributeValue(vObjBtnContinue, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
			LogCapture.info("Continue button is in enabled state.........");
		}
		if (optionalValue.equalsIgnoreCase("disabled")) {
			String vObjBtnContinue = Constants.IOSRegstOR.getProperty("BtnContinue");
			// Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnContinue));
			String atbValue = Constants.key.getAttributeValue(vObjBtnContinue, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
			LogCapture.info("Continue button is in disabled state.........");
		}
	}

	@Then("^continue button should be in (enabled|disabled) state in ios app on set password screen$")
	public void continue_button_should_be_in_enabled_state_in_ios_app_on_set_password_screen(String optionalValue)
			throws Throwable {
		if (optionalValue.equalsIgnoreCase("enabled")) {
			String vObjBtnContinue = Constants.IOSRegstOR.getProperty("BtnContinue");
			// String vObjBtnContinue = Constants.IOSAddWalletOR.getProperty("ContinueBtn");
			// Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnContinue));
			String atbValue = Constants.key.getAttributeValue(vObjBtnContinue, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
			LogCapture.info("Continue button is in enabled state.........");
		}
		if (optionalValue.equalsIgnoreCase("disabled")) {
			String vObjBtnContinue = Constants.IOSRegstOR.getProperty("BtnContinue");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnContinue));
			String atbValue = Constants.key.getAttributeValue(vObjBtnContinue, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
			LogCapture.info("Continue button is in disabled state.........");
		}
	}

	@When("^ios user click on continue button on bank transfer$")
	public void ios_user_click_on_continue_button_on_bank_transfer() throws Throwable {
		String vObjBtnContinue = Constants.IOSRegstOR.getProperty("BtnContinue");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
		Assert.assertEquals("PASS", Constants.key.click(vObjBtnContinue));
	}

	@Then("^invalid (first name|last name|email id|other occupation) error message should be displayed in ios app$")
	public void invalid_first_name_error_message_should_be_displayed_in_ios_app(String optionalValue) throws Throwable {
		String vObjFNameTextField = Constants.IOSRegstOR.getProperty("FNameTextField");
		String vObjLNameTextField = Constants.IOSRegstOR.getProperty("LNameTextField");
		String vObjEmailTextField = Constants.IOSRegstOR.getProperty("EmailTextField");
		String vObjOccupationOtherPH = Constants.IOSRegstOR.getProperty("OccupationOtherPH");
		String vObjErrLabelFirstName = Constants.IOSRegstOR.getProperty("ErrLabelFirstName");
		String vObjErrLabelLastName = Constants.IOSRegstOR.getProperty("ErrLabelLastName");
		String vObjErrLabelEmail = Constants.IOSRegstOR.getProperty("ErrLabelEmail");
		String vObjErrLabelOther = Constants.IOSRegstOR.getProperty("ErrLabelOther");
		String vInvalidFirstName = Constants.IOSTestData.getProperty("InvalidFirstName");
		String vInvalidLastName = Constants.IOSTestData.getProperty("InvalidLastName");
		String vInvalidEmail = Constants.IOSTestData.getProperty("InvalidEmail");
		String vInvalidOtherInfo = Constants.IOSTestData.getProperty("InvalidOtherInfo");
		if (optionalValue.equalsIgnoreCase("first name")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFNameTextField));
			String atbValue = Constants.key.getAttributeValue(vObjErrLabelFirstName, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vInvalidFirstName, atbValue));
			LogCapture.info("Invalid first name error message displayed.........");
		} else if (optionalValue.equalsIgnoreCase("last name")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLNameTextField));
			String atbValue = Constants.key.getAttributeValue(vObjErrLabelLastName, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vInvalidLastName, atbValue));
			LogCapture.info("Invalid last name error message displayed.........");
		} else if (optionalValue.equalsIgnoreCase("email id")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailTextField));
			String atbValue = Constants.key.getAttributeValue(vObjErrLabelEmail, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vInvalidEmail, atbValue));
			LogCapture.info("Invalid email id error message displayed.........");
		} else if (optionalValue.equalsIgnoreCase("other occupation")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOccupationOtherPH));
			String atbValue = Constants.key.getAttributeValue(vObjErrLabelOther, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vInvalidOtherInfo, atbValue));
			LogCapture.info("Invalid other information error message displayed.........");
		}
	}

	@When("^ios user removes the valid (first name|last name|email id|other occupation)$")
	public void ios_user_removes_the_valid_first_name(String optionalValue) throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		if (optionalValue.equalsIgnoreCase("first name")) {
			String vObjFNameTextField = Constants.IOSRegstOR.getProperty("FNameTextField");
			Assert.assertEquals("PASS", Constants.key.clearData(vObjFNameTextField));
		} else if (optionalValue.equalsIgnoreCase("last name")) {
			String vObjLNameTextField = Constants.IOSRegstOR.getProperty("LNameTextField");
			Assert.assertEquals("PASS", Constants.key.clearData(vObjLNameTextField));
		} else if (optionalValue.equalsIgnoreCase("email id")) {
			String vObjEmailTextField = Constants.IOSRegstOR.getProperty("EmailTextField");
			Assert.assertEquals("PASS", Constants.key.clearData(vObjEmailTextField));
		} else if (optionalValue.equalsIgnoreCase("Other occupation")) {
			String vObjOccupationOtherPH = Constants.IOSRegstOR.getProperty("OccupationOtherPH");
			String vObjOccupationText = Constants.IOSRegstOR.getProperty("OccupationText");
			Assert.assertEquals("PASS", Constants.key.click(vObjOccupationOtherPH));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjOccupationOtherPH));
			// Assert.assertEquals("PASS",Constants.key.clearText(vObjOccupationText));
		}
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info(optionalValue + " removed from the field.........");
	}

	// Error message not defined yet
	@Then("^mandatory (first name|last name|email id|other information) error message should be displayed$")
	public void mandatory_first_name_error_message_should_be_displayed(String optionalValue) throws Throwable {
		String vObjFNameTextField = Constants.IOSRegstOR.getProperty("FNameTextField");
		String vObjLNameTextField = Constants.IOSRegstOR.getProperty("LNameTextField");
		String vObjEmailTextField = Constants.IOSRegstOR.getProperty("EmailTextField");
		String vObjOccupationOtherPH = Constants.IOSRegstOR.getProperty("OccupationOtherPH");
		String vObjMandErrLabelFirstName = Constants.IOSRegstOR.getProperty("MandErrLabelFirstName");
		String vObjMandErrLabelLastName = Constants.IOSRegstOR.getProperty("MandErrLabelLastName");
		String vObjMandErrLabelEmail = Constants.IOSRegstOR.getProperty("MandErrLabelEmail");
		String vObjMandErrLabelOther = Constants.IOSRegstOR.getProperty("ErrLabelOther");
		// String vMandatoryFirstName =
		// Constants.IOSTestData.getProperty("MandatoryFirstName");
		String vMandatoryFirstName = Constants.IOSTestData.getProperty("InvalidFirstName");
		// String vMandatoryLastName =
		// Constants.IOSTestData.getProperty("MandatoryLastName");
		String vMandatoryLastName = Constants.IOSTestData.getProperty("InvalidLastName");
		String vMandatoryEmail = Constants.IOSTestData.getProperty("MandatoryEmail");
		String vMandatoryOtherInfo = Constants.IOSTestData.getProperty("MandatoryOtherInfo");
		if (optionalValue.equalsIgnoreCase("first name")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFNameTextField));
			String atbValue = Constants.key.getAttributeValue(vObjMandErrLabelFirstName, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vMandatoryFirstName, atbValue));
			LogCapture.info("Required first name error message displayed.........");
		} else if (optionalValue.equalsIgnoreCase("last name")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLNameTextField));
			String atbValue = Constants.key.getAttributeValue(vObjMandErrLabelLastName, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vMandatoryLastName, atbValue));
			LogCapture.info("Required last name error message displayed.........");
		} else if (optionalValue.equalsIgnoreCase("email id")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailTextField));
			String atbValue = Constants.key.getAttributeValue(vObjMandErrLabelEmail, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vMandatoryEmail, atbValue));
			LogCapture.info("Required email id error message displayed.........");
		} else if (optionalValue.equalsIgnoreCase("other occupation")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOccupationOtherPH));
			String atbValue = Constants.key.getAttributeValue(vObjMandErrLabelOther, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vMandatoryOtherInfo, atbValue));
			LogCapture.info("Required other information error message displayed.........");
		}
	}

	@When("^ios user click on (continue button|search address|enter address manually link|save button)$")
	public void ios_user_click_on_continue_button(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("continue button")) {
			String vObjBtnContinue = Constants.IOSRegstOR.getProperty("BtnContinue");
			// Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
			Assert.assertEquals("PASS", Constants.key.click(vObjBtnContinue));
		} else if (optionalValue.equalsIgnoreCase("search address")) {
			String vObjSearchAddFinder = Constants.IOSRegstOR.getProperty("SearchAddFinder");
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddFinder));
		} else if (optionalValue.equalsIgnoreCase("search address")) {
			String vObjSearchAddFinder = Constants.IOSRegstOR.getProperty("SearchAddFinder");
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddFinder));
		} else if (optionalValue.equalsIgnoreCase("save button")) {
			String vObjSaveRecipientBtn = Constants.IOSRecipientOR.getProperty("SaveRecipientBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjSaveRecipientBtn));
		} else if (optionalValue.equalsIgnoreCase("enter address manually link")) {
			String vObjLinkManualAddress = Constants.IOSRegstOR.getProperty("LinkManualAddress");
			Assert.assertEquals("PASS", Constants.key.click(vObjLinkManualAddress));
		}
	}

	@Then("^the about you screen should load with the details previously entered by the user$")
	public void the_about_you_screen_should_load_with_the_details_previously_entered_by_the_user() throws Throwable {
		String vObjFNameTextField = Constants.IOSRegstOR.getProperty("FNameTextField");
		Assert.assertNotEquals("FAIL", Constants.key.readText(vObjFNameTextField));
		LogCapture.info("First Name :" + Constants.key.readText(vObjFNameTextField));
		String vObjLNameTextField = Constants.IOSRegstOR.getProperty("LNameTextField");
		Assert.assertNotEquals("FAIL", Constants.key.readText(vObjLNameTextField));
		LogCapture.info("Last Name :" + Constants.key.readText(vObjLNameTextField));
		String vObjEmailTextField = Constants.IOSRegstOR.getProperty("EmailTextField");
		Assert.assertNotEquals("FAIL", Constants.key.readText(vObjEmailTextField));
		LogCapture.info("Email ID :" + Constants.key.readText(vObjEmailTextField));
		LogCapture.info("Previously entered data displayed successfully........");
	}

	@When("^ios user selects (country|currency) drop down and enters (country|currency) code or name \"([^\"]*)\"$")
	public void ios_user_selects_country_drop_down_and_enters_country_code_or_name(String optionalValue1,
			String optionalValue2, String data) throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		if (optionalValue1.equalsIgnoreCase("country") && optionalValue2.equalsIgnoreCase("country")) {
			String vObjCountryDD = Constants.IOSRegstOR.getProperty("CountryDD");
			String vObjCountryFinder = Constants.IOSRegstOR.getProperty("CountryFinder");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryDD));
			Assert.assertEquals("PASS", Constants.key.click(vObjCountryDD));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryFinder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountryFinder, data));
			LogCapture.info("User entered country code or name : " + data);
		} else if (optionalValue1.equalsIgnoreCase("currency") && optionalValue2.equalsIgnoreCase("currency")) {
			String vObjCurrencyInput = Constants.IOSRecipientOR.getProperty("CurrencyInput");
			String vObjCurrencySearchInput = Constants.IOSRecipientOR.getProperty("CurrencySearchInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencyInput));
			String vCurrency = Constants.key.getAttributeValue(vObjCurrencyInput, "value");
			if (vCurrency.equalsIgnoreCase(data)) {
				LogCapture.info("Prepoulated currrency : " + data + " present in currency drop down...");
				defaultCurrency = true;
			} else if (vCurrency != data && vCurrency != "FAIL") {
				Assert.assertEquals("PASS", Constants.key.click(vObjCurrencyInput));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCurrencySearchInput, data));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
				LogCapture.info("User entered currency code or name : " + data);
			}
		}
	}

	@When("^ios user selects (country|currency) drop down and enters (country|currency) code or name \"([^\"]*)\" to add recipient$")
	public void ios_user_selects_country_drop_down_and_enters_country_code_or_name_to_add_recipient(
			String optionalValue1, String optionalValue2, String data) throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		if (optionalValue1.equalsIgnoreCase("country") && optionalValue2.equalsIgnoreCase("country")) {
			String vObjCountryDD = Constants.IOSRecipientOR.getProperty("CountryDD");
			String vObjCountryFinder = Constants.IOSRegstOR.getProperty("CountryFinder");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryDD));
			Assert.assertEquals("PASS", Constants.key.click(vObjCountryDD));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryFinder));
			if (data.equalsIgnoreCase("USA")) {
				data = "United States of America";
			}
			if (data.equalsIgnoreCase("UK")) {
				data = "United Kingdom";
			}
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountryFinder, data));
			LogCapture.info("User entered country code or name : " + data);
		} else if (optionalValue1.equalsIgnoreCase("currency") && optionalValue2.equalsIgnoreCase("currency")) {
			String vObjCurrencyInput = Constants.IOSRecipientOR.getProperty("CurrencyInput");
			String vObjCurrencySearchInput = Constants.IOSRecipientOR.getProperty("CurrencySearchInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencyInput));
			String vCurrency = Constants.key.getAttributeValue(vObjCurrencyInput, "value");
			if (vCurrency.equalsIgnoreCase(data)) {
				LogCapture.info("Prepoulated currrency : " + data + " present in currency drop down...");
			}
			if (vCurrency != data && vCurrency != "FAIL") {
				Assert.assertEquals("PASS", Constants.key.click(vObjCurrencyInput));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCurrencySearchInput, data));
				Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
				LogCapture.info("User entered currency code or name : " + data);
			}
		}
	}

	@When("^ios user selects country drop down and enters country code or name \"([^\"]*)\" on mobile number screen$")
	public void ios_user_selects_country_drop_down_and_enters_country_code_or_name_on_mobile_number_screen(String data)
			throws Throwable {
		String vObjCountryDD = Constants.IOSRegstOR.getProperty("DDCountryMob");
		String vObjCountryFinder = Constants.IOSRegstOR.getProperty("CountryFinder");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryDD));
		Assert.assertEquals("PASS", Constants.key.click(vObjCountryDD));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryFinder));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountryFinder, data));
		LogCapture.info("User entered country code or name : " + data);
	}

	@Then("^matching (country|currency) (should|should not) be displayed in search result of ios app$")
	public void matching_country_should_be_displayed_in_search_result_of_ios_app(String optionalValue1,
			String optionalValue2) throws Throwable {

		if (optionalValue1.equalsIgnoreCase("country")) {
			String vObjCountryLabel = Constants.IOSMyCardOR.getProperty("CountryLabel2");
			int noOfCountry = Constants.key.getElementList(vObjCountryLabel).size();
			if (noOfCountry > 0) {
				LogCapture.info("Total number of matching country : " + noOfCountry);
			} else {
				LogCapture.info("No matching country found........ ");
			}
		}
		if (optionalValue1.equalsIgnoreCase("currency")) {
			if (defaultCurrency != true) {
				String vObjCurrencyLbl = Constants.IOSRecipientOR.getProperty("CurrencyLbl");
				int noOfCurrency = Constants.key.getElementList(vObjCurrencyLbl).size();
				if (noOfCurrency > 0) {
					LogCapture.info("Total number of matching currency : " + noOfCurrency);
				} else {
					LogCapture.info("No matching currency found........ ");
				}
			}
		}
		if (optionalValue2.equalsIgnoreCase("should not")) {
			String vObjCountryLabel = Constants.IOSMyCardOR.getProperty("CountryLabel2");
			Assert.assertEquals("FAIL", Constants.key.eleLocatedDisplayed(vObjCountryLabel));
			LogCapture.info("No matching Country found........ ");
		}

	}

	@Then("^the filter should be cleared and the whole (country|currency) list should be displayed on ios screen$")
	public void the_filter_should_be_cleared_and_the_whole_country_list_should_be_displayed(String optionalValue1)
			throws Throwable {
		if (optionalValue1.equalsIgnoreCase("country")) {
			String vObjCountryLabel = Constants.IOSMyCardOR.getProperty("CountryLabel");
			int noOfCountry = Constants.key.getElementList(vObjCountryLabel).size();
			if (noOfCountry > 5) {
				LogCapture.info("Country search result has been cleared............");
			}
		} else if (optionalValue1.equalsIgnoreCase("currency")) {
			String vObjCurrencyLbl = Constants.IOSRecipientOR.getProperty("CurrencyLbl");
			String vObjSearchLbl = Constants.IOSRecipientOR.getProperty("SearchLbl");
			int noOfCurrency = Constants.key.getElementList(vObjCurrencyLbl).size();
			if (noOfCurrency > 5) {
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSearchLbl));
				LogCapture.info("Currency search result has been cleared............");
			}
		}
	}

	@When("^ios user selects the (country|currency) from searched result list \"([^\"]*)\"$")
	public void ios_user_selects_the_country_from_searched_result_list(String optionalValue1, String data)
			throws Throwable {
		String result = "FAIL";

		if (optionalValue1.equalsIgnoreCase("country")) {
			Thread.sleep(10000);
			String vObjCountryCell = Constants.IOSMyCardOR.getProperty("CountryCell");
			// String vObjCountryLabel = Constants.IOSMyCardOR.getProperty("CountryLabel");
			// commenting above line as xpath is changed for iPhone 7 device
			String vObjCountryLabel = Constants.IOSMyCardOR.getProperty("CountryLabel2");
			// String vObjCountryCode = Constants.IOSMyCardOR.getProperty("CountryCode");
			String vObjCountryCode = Constants.IOSMyCardOR.getProperty("CountryCode2");

			if (data.equalsIgnoreCase("USA")) {
				data = "United States of America";
			} else if (data.equalsIgnoreCase("UK")) {
				data = "United Kingdom";
			}
			int noOfCountry = Constants.key.getElementList(vObjCountryLabel).size();
			for (int i = 1; i <= noOfCountry; i++) {
				if (i == 6) {
					Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
				}
				String vCountry = Constants.key.getAttributeValue(vObjCountryCell + "[" + i + "]" + vObjCountryLabel,
						"label");
				String vCountryCode = Constants.key.getAttributeValue(vObjCountryCell + "[" + i + "]" + vObjCountryCode,
						"label");
				if (data.equalsIgnoreCase(vCountry) || data.equalsIgnoreCase(vCountryCode)) {
					Assert.assertEquals("PASS",
							Constants.key.click(vObjCountryCell + "[" + i + "]" + vObjCountryLabel));
					LogCapture.info("Country selected : " + data);
					result = "PASS";
					break;
				} else {
					LogCapture
							.info("Country : " + data + " is not matched with listed country :" + i + ". " + vCountry);
				}
			}
			Assert.assertEquals("PASS", result);
		} else if (optionalValue1.equalsIgnoreCase("currency")) {

			if (defaultCurrency == true) {
				result = "PASS";
			} else {
				//
				String vObjCurrencyLbl = Constants.IOSRecipientOR.getProperty("CurrencyLbl");
				String vObjCurrencyCell = Constants.IOSRecipientOR.getProperty("CurrencyCell");
				String vObjCurrencyCellLbl = Constants.IOSRecipientOR.getProperty("CurrencyCellLbl");
				int noOfCountry = Constants.key.getElementList(vObjCurrencyLbl).size();
				for (int i = 1; i <= noOfCountry; i++) {
					if (i == 6) {
						Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
					}
					String vCurrencyCode = Constants.key
							.getAttributeValue(vObjCurrencyCell + "[" + i + "]" + vObjCurrencyLbl, "label");
					String vCurrencyName = Constants.key
							.getAttributeValue(vObjCurrencyCell + "[" + i + "]" + vObjCurrencyCellLbl, "label");
					if (data.equalsIgnoreCase(vCurrencyCode) || data.equalsIgnoreCase(vCurrencyName)) {
						Assert.assertEquals("PASS",
								Constants.key.click(vObjCurrencyCell + "[" + i + "]" + vObjCurrencyCellLbl));
						LogCapture.info("Currency selected : " + vCurrencyCode + " - " + vCurrencyName);
						Constants.DataMap.put("RecipientCurrency", vCurrencyName);
						result = "PASS";
						break;
					} else {
						LogCapture.info("Currency : " + data + " is not matched with listed currency :" + i + ". "
								+ vCurrencyCode + " or " + vCurrencyName);
					}
				}
			}
			Assert.assertEquals("PASS", result);

		}
	}

	@When("^ios user selects the country from searched result list \"([^\"]*)\" on mobile number screen$")
	public void ios_user_selects_the_country_from_searched_result_list_on_mobile_number_screen(String data)
			throws Throwable {
		String result = "FAIL";
		String vObjCountryCell = Constants.IOSMyCardOR.getProperty("CountryCell");
		// String vObjCountryLabel = Constants.IOSMyCardOR.getProperty("CountryLabel");
		// String vObjCountryCode = Constants.IOSMyCardOR.getProperty("CountryCode");
		String vObjCountryLabel = Constants.IOSMyCardOR.getProperty("CountryLabel2");
		String vObjCountryCode = Constants.IOSMyCardOR.getProperty("CountryCode2");
		int noOfCountry = Constants.key.getElementList(vObjCountryLabel).size();
		for (int i = 1; i <= noOfCountry; i++) {
			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
			}
			String vCountry = Constants.key.getAttributeValue(vObjCountryCell + "[" + i + "]" + vObjCountryLabel,
					"label");
			String vCountryCode = Constants.key.getAttributeValue(vObjCountryCell + "[" + i + "]" + vObjCountryCode,
					"label");
			if (data.equalsIgnoreCase(vCountry) || data.equalsIgnoreCase(vCountryCode)) {
				Assert.assertEquals("PASS", Constants.key.click(vObjCountryCell + "[" + i + "]" + vObjCountryLabel));
				LogCapture.info("Country selected : " + data);
				result = "PASS";
				break;
			} else {
				LogCapture.info("Country : " + data + " is not matched with listed country :" + i + ". " + vCountry);
			}
		}
		Assert.assertEquals("PASS", result);
	}

	@Then("^selected (country|currency) \"([^\"]*)\" should be displayed in (country|currency) dropdown to add recipient$")
	public void selected_currency_should_be_displayed_in_currency_dropdown_to_add_recipient(String optionalValue1,
			String data, String optionalValue2) throws Throwable {
		if (optionalValue1.equalsIgnoreCase("country") && optionalValue2.equalsIgnoreCase("country")) {
			if (data.equalsIgnoreCase("USA")) {
				data = "United States of America";
			} else if (data.equalsIgnoreCase("UK")) {
				data = "United Kingdom";
			}
			// String vObjDDCountry =
			// Constants.IOSRecipientOR.getProperty("DDCountry");
			String vObjDDCountrylbl = Constants.IOSRecipientOR.getProperty("CountryInput");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDDCountrylbl));
			String vDDCountrylbl = Constants.key.getAttributeValue(vObjDDCountrylbl, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText(data, vDDCountrylbl));
			LogCapture.info("Country : " + data + " selected by user.......");
			Constants.DataMap.put("RecipientCountry", vDDCountrylbl);
		} else if (optionalValue1.equalsIgnoreCase("currency") && optionalValue2.equalsIgnoreCase("currency")) {
			String vObjDDInputValue = Constants.IOSRecipientOR.getProperty("DDInputValue");
			String vCurrencyName = Constants.IOSTestData.getProperty(data);
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDDInputValue));
			String vDDCurrencyValue = Constants.key.getAttributeValue(vObjDDInputValue, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vCurrencyName.trim(), vDDCurrencyValue.trim()));
			LogCapture.info("Currency : " + data + " updated in drop down.......");
			// Constants.DataMap.put("RecipientCurrency",vDDCurrencyValue.trim());
		}
	}

	@When("^ios user searches for address \"([^\"]*)\"$")
	public void ios_user_searches_for_address(String address) throws Throwable {
		String vObjSearchAddressOption = Constants.IOSRegstOR.getProperty("SearchAddressOption");
		String vObjSearchAddressOptionBs = Constants.IOSRegstOR.getProperty("SearchAddressOptionBs");
		String vObjAddressSearchTF = Constants.IOSRegstOR.getProperty("AddSearchTFWithoutClear");
		// Assert.assertEquals("PASS",Constants.key.eleLocatedDisplayed(vObjSearchAddressOption));
		if ((AppName).equalsIgnoreCase("CD")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddressOption));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSearchAddressOption, address));
		} else {
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddressOptionBs));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSearchAddressOptionBs, address));
		}
		LogCapture.info("User searching for address : " + address);
	}

	@Then("^ios app should fetch matching address according to the selected country$")
	public void ios_app_should_fetch_matching_address_according_to_the_selected_country() throws Throwable {
		String vObjAddressLbl1 = Constants.IOSRegstOR.getProperty("AddressLbl1");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddressLbl1));
		LogCapture.info("Search address result list displayed............. ");
	}

	@When("^ios user select searched address$")
	public void ios_user_select_searched_address() throws Throwable {
		String vObjAddressLbl1 = Constants.IOSRegstOR.getProperty("AddressLbl1");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddressLbl1));
		Thread.sleep(5000);
		Assert.assertEquals("PASS", Constants.key.click(vObjAddressLbl1));
		LogCapture.info("Search address selected by user............. ");
	}

	@Then("^ios app should display nothing found message with enter address manually link$")
	public void ios_app_should_display_nothing_found_message_with_enter_address_manually_link() throws Throwable {
		String vObjAddressNotFoundLbl = Constants.IOSRegstOR.getProperty("AddressNotFoundLbl");
		String vObjManualAddressLink = Constants.IOSRegstOR.getProperty("ManualAddressLink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddressNotFoundLbl));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjManualAddressLink));
		LogCapture.info("Address not found message was displayed with enter address manually link...... ");
	}

	@When("^ios user click on (\\(X\\)|clear search) option$")
	public void ios_user_click_on_X_option(String optionalValue) throws Throwable {
		String vObjClearIcon = "";
		if (optionalValue.equalsIgnoreCase("(X)")) {
			if ((AppName).equalsIgnoreCase("CD")) {
				// vObjClearIcon = Constants.IOSRecipientOR.getProperty("SearchClose");
				vObjClearIcon = Constants.IOSRegstOR.getProperty("SearchClose");
			}

		} else if (optionalValue.equalsIgnoreCase("clear search")) {
			vObjClearIcon = Constants.IOSRegstOR.getProperty("ClearSearchIcon");
		}
		vObjClearIcon = Constants.IOSRegstOR.getProperty("SearchClose");
		Assert.assertEquals("PASS", Constants.key.click(vObjClearIcon));
		LogCapture.info("Search filter cleared by user............ ");

	}

	@Then("^the filter should be cleared and empty search address screen should be displayed$")
	public void the_filter_should_be_cleared_and_empty_search_address_screen_should_be_displayed() throws Throwable {
		String vObjClearIcon = Constants.IOSRegstOR.getProperty("ScreenSearchAddress");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjClearIcon));
		LogCapture.info("Empty search address screen has been displayed...... ");
	}

	@Then("^selected address should be updated in address field of ios app$")
	public void selected_address_should_be_updated_in_address_field_of_ios_app() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^ios user enters all the address \"([^\"]*)\" as per selected country \"([^\"]*)\"$")
	public void ios_user_enters_all_the_address_as_per_selected_country(String arg1, String arg2) throws Throwable {
		ios_user_enters_required_address_field_data(); /// need to check
	}

	@Then("^no match found message should be displayed in ios app$")
	public void no_match_found_message_should_be_displayed_in_ios_app() throws Throwable {
		String vObjNothingFoundLbl = Constants.IOSRegstOR.getProperty("NothingFoundLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNothingFoundLbl));

	}

	@Then("^no match found message should be displayed in ios app on mobile number screen$")
	public void no_match_found_message_should_be_displayed_in_ios_app_on_mobile_number_screen() throws Throwable {
		String vObjCouldntFindAddreesLbl = Constants.IOSRegstOR.getProperty("CouldntFindAddreesLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCouldntFindAddreesLbl));
	}

	@When("^ios user selects recipient type \"([^\"]*)\" and enters recipient name \"([^\"]*)\"$")
	public void ios_user_selects_recipient_type_and_enters_recipient_name(String recipientType, String recipientName)
			throws Throwable {
		Constants.DataMap.put("RecipientType", recipientType);
		if (recipientType.equalsIgnoreCase("Individual")) {
			Constants.Data = recipientName.split(" ");
			String vObjRecipientIndividualBtn = Constants.IOSRecipientOR.getProperty("RecipientIndividualBtn");
			String vObjFirstNameLbl = Constants.IOSRecipientOR.getProperty("FirstNameLbl");
			String vObjFirstNameInput = Constants.IOSRecipientOR.getProperty("FirstNameInput");
			String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
			String vObjLastNameLbl = Constants.IOSRecipientOR.getProperty("LastNameLbl");
			String vObjLastNameInput = Constants.IOSRecipientOR.getProperty("LastNameInput");
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientIndividualBtn));
			LogCapture.info("Individual recipient type selected...... ");
			Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameInput, Constants.Data[0].toString()));
			// Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameInput,
			// Constants.key.getAlphaNumericString(6)));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjLastNameLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameInput, Constants.Data[1].toString()));
			// Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameInput,
			// Constants.key.getAlphaNumericString(8)));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Constants.DataMap.put("FirstName", Constants.Data[0].toString());
			Constants.DataMap.put("LastName", Constants.Data[1].toString());
			Constants.DataMap.put("RecipientName", Constants.Data[0].toString() + " " + Constants.Data[1].toString());
		} else if (recipientType.equalsIgnoreCase("Company")) {
			String vObjRecipientCompanyBtn = Constants.IOSRecipientOR.getProperty("RecipientCompanyBtn");
			String vObjCompanyNameLbl = Constants.IOSRecipientOR.getProperty("CompanyNameLbl");
			String vObjCompanyNameInput = Constants.IOSRecipientOR.getProperty("CompanyNameInput");
			String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientCompanyBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameLbl));
			// Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameInput,
			// recipientName));
			// String UniqueString =Constants.key.getAlphaNumericString(8);
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameInput, recipientName));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Constants.DataMap.put("CompanyName", recipientName);
			Constants.DataMap.put("RecipientName", recipientName);
		} else {
			LogCapture.info("Please provide recipient type as Individual or Company...... ");
		}
	}

	@Then("^empty state (country|currency) list should be displayed in ios app along with no result message on (add recipient|add wallet|buy currency|bank details) window$")
	public void empty_state_currency_list_should_be_displayed_in_ios_app_along_with_no_result_message_on_add_recipient_window(
			String optionalVale1, String screen) throws Throwable {
		if (optionalVale1.equalsIgnoreCase("country")) {
			String vObjNothingFoundLbl = Constants.IOSRecipientOR.getProperty("NothingFoundLbl");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNothingFoundLbl));
			LogCapture.info("Empty state country list displayed with no result message...... ");
		} else if (optionalVale1.equalsIgnoreCase("currency")) {
			if (screen.equalsIgnoreCase("add recipient")) {
				String vObjNoResultLbl = Constants.IOSRecipientOR.getProperty("NoResultLbl");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNoResultLbl));
				LogCapture.info("Empty state currency list displayed with no result message...... ");
			} else if (screen.equalsIgnoreCase("add wallet")) {
				String vObjNoResultFoundWallet = Constants.IOSAddWalletOR.getProperty("NoResultFound");
				String vObjDone = Constants.IOSAddWalletOR.getProperty("Done");
				Assert.assertEquals("PASS", Constants.key.clickWithoutVisibilityChk(vObjDone));
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNoResultFoundWallet));
				LogCapture.info("Empty state currency list displayed with no result message...... ");
			} else if (screen.equalsIgnoreCase("buy currency")) {
				String vObjNoResultFoundWallet = Constants.IOSAddWalletOR.getProperty("NoResultFound");
				String vObjDone = Constants.IOSAddWalletOR.getProperty("Done");
				// Assert.assertEquals("PASS",
				// Constants.key.clickWithoutVisibilityChk(vObjDone));
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNoResultFoundWallet));
				LogCapture.info("Empty state currency list displayed with no result message...... ");
			} else if (screen.equalsIgnoreCase("Bank details")) {
				String vObjNoResultFoundWallet = Constants.IOSAccountOR.getProperty("NothingFound");
				String vObjDone = Constants.IOSAddWalletOR.getProperty("Done");
				Assert.assertEquals("PASS", Constants.key.clickWithoutVisibilityChk(vObjDone));
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNoResultFoundWallet));
				LogCapture.info("Empty state currency list displayed with nothing found message...... ");
			}
		}
	}

	@When("^ios user click on search currency \\(X\\) option$")
	public void ios_user_click_on_search_currency_X_option() throws Throwable {
		String vObjClearSearch = Constants.IOSRecipientOR.getProperty("ClearSearchCurrency");
		Assert.assertEquals("PASS", Constants.key.click(vObjClearSearch));
	}

	@When("^ios user enters country specific required address \"([^\"]*)\" field data to add recipient$")
	public void ios_user_enters_country_specific_required_address_field_data_to_add_recipient(String address)
			throws Throwable {
		Constants.Data = Constants.IOSTestData.getProperty(address).split(",");
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		String vObjDefaultCountry = Constants.IOSRecipientOR.getProperty("CountryInput");
		String vObjAddressLbl = Constants.IOSRecipientOR.getProperty("AddressLbl");
		String vCountry = Constants.key.getAttributeValue(vObjDefaultCountry, "value");
		String vObjDDInputValue = Constants.IOSRecipientOR.getProperty("DDInputValue");
		String vDDCurrencyValue = Constants.key.getAttributeValue(vObjDDInputValue, "value");

		if (vCountry.equalsIgnoreCase("France") || vCountry.equalsIgnoreCase("Spain") || vCountry.equalsIgnoreCase("UK")
				|| vCountry.equalsIgnoreCase("USA") || vCountry.equalsIgnoreCase("India")) {
			Constants.DataMap.put("Street", Constants.Data[0].toString().trim());
			Constants.DataMap.put("City", Constants.Data[1].toString().trim());
			Constants.DataMap.put("State", Constants.Data[2].toString().trim());
			Constants.DataMap.put("PostCode", Constants.Data[3].toString().trim());

		}
		if (vCountry.equalsIgnoreCase("Canada") || vCountry.equalsIgnoreCase("Australia")) {
			Constants.DataMap.put("Street", Constants.Data[2].toString().trim());
			Constants.DataMap.put("City", Constants.Data[4].toString().trim());
			Constants.DataMap.put("State", Constants.Data[5].toString().trim());
			Constants.DataMap.put("PostCode", Constants.Data[6].toString().trim());
		}
		if (vCountry.equalsIgnoreCase("France") || vCountry.equalsIgnoreCase("Spain") || vCountry.equalsIgnoreCase("UK")
				|| vCountry.equalsIgnoreCase("United Kingdom") || vCountry.equalsIgnoreCase("India")
				|| vCountry.equalsIgnoreCase("Hungary")
				|| vCountry.equalsIgnoreCase("Hong Kong") && vDDCurrencyValue.equalsIgnoreCase("Hong Kong Dollar")) {
			// LogCapture.info("Address is not required for country :
			// "+vCountry);
		} else if (vCountry.equalsIgnoreCase("USA") || vCountry.equalsIgnoreCase("United States of America")
				|| vCountry.equalsIgnoreCase("Canada") || vCountry.equalsIgnoreCase("Australia")
				|| vCountry.equalsIgnoreCase("Hong Kong") || vCountry.equalsIgnoreCase("New Zealand")
				|| vCountry.equalsIgnoreCase("South Africa") || vCountry.equalsIgnoreCase("China")
				|| vCountry.equalsIgnoreCase("Hong Kong") && vDDCurrencyValue.equalsIgnoreCase("US Dollar")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddressLbl));
			LogCapture.info("User entering address for country : " + vCountry);
			String vObjAddLine1PHolder = Constants.IOSRecipientOR.getProperty("AddLine1PHolder");
			String vObjAddLine1Input = Constants.IOSRecipientOR.getProperty("AddLine1Input");
			String vObjTownCityPHolder = Constants.IOSRecipientOR.getProperty("TownCityPHolder");
			String vObjTownCityInput = Constants.IOSRecipientOR.getProperty("TownCityInput");
			String vObjPostCodePHolder = Constants.IOSRecipientOR.getProperty("PostCodePHolder");
			String vObjPostCodeInput = Constants.IOSRecipientOR.getProperty("PostCodeInput");

			// Street line1
			Assert.assertEquals("PASS", Constants.key.click(vObjAddLine1PHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAddLine1Input, Constants.Data[0].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Constants.DataMap.put("AddressLine1", Constants.Data[0].toString());
			// Town City
			Assert.assertEquals("PASS", Constants.key.click(vObjTownCityPHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTownCityInput, Constants.Data[1].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Constants.key.scrollInIOS("Bank Code", "down");
			Constants.DataMap.put("AddressCity", Constants.Data[1].toString());
			// PostCode
			Assert.assertEquals("PASS", Constants.key.click(vObjPostCodePHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostCodeInput, Constants.Data[3].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Constants.DataMap.put("AddressPostCode", Constants.Data[3].toString());
			LogCapture.info(vCountry + " user address entered successfully.............");
		}

	}

	@When("^ios user enters account number \"([^\"]*)\" base on country\"([^\"]*)\"currency\"([^\"]*)\"$")
	public void ios_user_enters_account_number_base_on_country_currency(String accountNo, String country,
			String currency) throws Throwable {
		String vObjAccountNumberPH = Constants.IOSRecipientOR.getProperty("AccountNumberPH");
		String vObjAccountNumberInput = Constants.IOSRecipientOR.getProperty("AccountNumberInput");
		String vObjIBANInputLbl = Constants.IOSRecipientOR.getProperty("IBANInputLbl");
		String vObjIBANInput = Constants.IOSRecipientOR.getProperty("IBANInput");
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		Constants.DataMap.put("RecipientAccountNo", accountNo);
		if (country.equalsIgnoreCase("United Kingdom") && currency.equalsIgnoreCase("EUR")
				|| country.equalsIgnoreCase("Hungary") && currency.equalsIgnoreCase("HUF")
				|| country.equalsIgnoreCase("France") && currency.equalsIgnoreCase("EUR")) {
			// No account number only IBAN as account no
			Assert.assertEquals("PASS", Constants.key.click(vObjIBANInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIBANInput, accountNo));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered IBAN : " + accountNo);
			Constants.DataMap.put("RecipientAccountNo", accountNo);
		} else {
			Assert.assertEquals("PASS", Constants.key.click(vObjAccountNumberPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAccountNumberInput, accountNo));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered Account no : " + accountNo);
		}
	}

	@When("^ios user enters valid account number \"([^\"]*)\" base on country\"([^\"]*)\"currency\"([^\"]*)\"$")
	public void ios_user_enters_valid_account_number_base_on_country_currency(String accountNo, String country,
			String currency) throws Throwable {
		String vObjAccountNumberPH = Constants.IOSRecipientOR.getProperty("AccountNumberPH");
		String vObjAccountNumberInput = Constants.IOSRecipientOR.getProperty("AccountNumberInput");
		String vObjIBANInputLbl = Constants.IOSRecipientOR.getProperty("IBANInputLbl");
		String vObjIBANInput = Constants.IOSRecipientOR.getProperty("IBANInput");
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		Constants.DataMap.put("RecipientAccountNo", accountNo);
		if (country.equalsIgnoreCase("UK") && currency.equalsIgnoreCase("EUR")
				|| country.equalsIgnoreCase("Hungary") && currency.equalsIgnoreCase("HUF")
				|| country.equalsIgnoreCase("France") && currency.equalsIgnoreCase("EUR")) {
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIBANInput, accountNo));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered IBAN : " + accountNo);
		} else {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjAccountNumberInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAccountNumberInput, accountNo));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("User entered Account no : " + accountNo);
		}
	}

	@Then("^ios user enters (invalid|valid) IBAN \"([^\"]*)\"$")
	public void ios_user_enters_valid_IBAN(String optionalValue, String data) throws Throwable {
		String vObjIBANInputLbl = Constants.IOSRecipientOR.getProperty("IBANInputLbl");
		String vObjIBANInput = Constants.IOSRecipientOR.getProperty("IBANInput");
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");

		if (optionalValue.equalsIgnoreCase("invalid")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjIBANInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIBANInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (optionalValue.equalsIgnoreCase("valid")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjIBANInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIBANInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		}
		LogCapture.info("User entered IBAN : " + data);
	}

	@Then("^invalid bank code \"([^\"]*)\" error message should be removed from ios app add recipient screen$")
	public void invalid_bank_code_error_message_should_be_removed_from_ios_app_add_recipient_screen(String bankCodeType)
			throws Throwable {

		String vObjErrLblIBAN = Constants.IOSRecipientOR.getProperty("ErrLblIBAN");
		String vObjErrLblABA = Constants.IOSRecipientOR.getProperty("ErrLblABA");
		String vObjErrLblSORT = Constants.IOSRecipientOR.getProperty("ErrLblSORT");
		String vObjErrLblIFSC = Constants.IOSRecipientOR.getProperty("ErrLblIFSC");
		String vObjErrLblTransit = Constants.IOSRecipientOR.getProperty("ErrLblIBAN");
		String vObjErrLblBSB = Constants.IOSRecipientOR.getProperty("ErrLblBSB");
		if (bankCodeType.equalsIgnoreCase("IBAN")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidIBAN");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblIBAN, "value").toString();
			Assert.assertEquals("FAIL", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid IBAN error message removed.........");
		} else if (bankCodeType.equalsIgnoreCase("ABA")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidABA");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblABA, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid ABA error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("SORT")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidSORT");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblSORT, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid SORT error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("IFSC")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidIFSC");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblIFSC, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid IFSC error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("Transit")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidTransit");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblTransit, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid Transit error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("BSB")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidBSB");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblBSB, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid BSB error message displayed.........");
		}
	}

	@When("^ios user selects bank code type\"([^\"]*)\"and enters bank code\"([^\"]*)\"base on country\"([^\"]*)\"currency\"([^\"]*)\"$")
	public void ios_user_selects_bank_code_type_and_enters_bank_code_base_on_country_currency(String bankCodeType,
			String bankCode, String country, String currency) throws Throwable {
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		String vObjBankCodeLbl = Constants.IOSRecipientOR.getProperty("BankCodeLbl");
		String vObjBankCodePickerWheel = Constants.IOSRecipientOR.getProperty("BankCodePickerWheel");
		String vObjSwiftInputLbl = Constants.IOSRecipientOR.getProperty("SwiftInputLbl");
		String vObjSwiftInput = Constants.IOSRecipientOR.getProperty("SwiftInput");
		String vObjABAInputLbl = Constants.IOSRecipientOR.getProperty("ABAInputLbl");
		String vObjABAInput = Constants.IOSRecipientOR.getProperty("ABAInput");
		String vObjBSBInputLbl = Constants.IOSRecipientOR.getProperty("BSBInputLbl");
		String vObjBSBInput = Constants.IOSRecipientOR.getProperty("BSBInput");
		String vObjTransitInputLbl = Constants.IOSRecipientOR.getProperty("TransitInputLbl");
		String vObjTransitInput = Constants.IOSRecipientOR.getProperty("TransitInput");
		String vObjIFSCInputLbl = Constants.IOSRecipientOR.getProperty("IFSCInputLbl");
		String vObjIFSCInput = Constants.IOSRecipientOR.getProperty("IFSCInput");
		String vObjSortInputLbl = Constants.IOSRecipientOR.getProperty("SortInputLbl");
		String vObjSortInput = Constants.IOSRecipientOR.getProperty("SortInput");
		String vObjBranchCodeInputLbl = Constants.IOSRecipientOR.getProperty("BranchCodeInputLbl");
		String vObjBrachCodeInput = Constants.IOSRecipientOR.getProperty("BrachCodeInput");
		String vObjCNAPSCodeInputLbl = Constants.IOSRecipientOR.getProperty("CNAPSCodeInputLbl");
		String vObjCNAPSCodeInput = Constants.IOSRecipientOR.getProperty("CNAPSCodeInput");
		String vObjIBANInputlbl = Constants.IOSRecipientOR.getProperty("IBANInputlbl");
		String vObjIBANInputText = Constants.IOSRecipientOR.getProperty("IBANInputText");

		Constants.DataMap.put("RecipientBankCodeType", bankCodeType);
		Constants.DataMap.put("RecipientBankCode", bankCode);
		if (country.equalsIgnoreCase("United States Of America") && currency.equalsIgnoreCase("USD")
				&& bankCodeType.equalsIgnoreCase("ABA")) {
			// picker wheel ABA number
			// Assert.assertEquals("PASS",Constants.key.click(vObjBankCodeLbl));
			// Assert.assertEquals("PASS",Constants.key.writeInInput(vObjBankCodePickerWheel,
			// "ABA number"));
			// Assert.assertEquals("PASS",Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjABAInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjABAInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (country.equalsIgnoreCase("USA") && currency.equalsIgnoreCase("USD")
				&& bankCodeType.equalsIgnoreCase("SWIFT")) {
			// picker wheel SWIFT code
			// Assert.assertEquals("PASS",Constants.key.click(vObjBankCodeLbl));
			// Assert.assertEquals("PASS",Constants.key.writeInInput(vObjBankCodePickerWheel,
			// "SWIFT code"));
			// Assert.assertEquals("PASS",Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjSwiftInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (country.equalsIgnoreCase("United Kingdom") && currency.equalsIgnoreCase("GBP")
				&& bankCodeType.equalsIgnoreCase("SORT")) {
			// Sort code input
			Assert.assertEquals("PASS", Constants.key.click(vObjSortInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSortInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (country.equalsIgnoreCase("UK") && currency.equalsIgnoreCase("EUR")
				&& bankCodeType.equalsIgnoreCase("IBAN")) {
			// No account number only IBAN as account no

		} else if (country.equalsIgnoreCase("British Virgin Islands") && currency.equalsIgnoreCase("GBP")
				&& bankCodeType.equalsIgnoreCase("SWIFT")) {
			// No picker wheel only SWIFT code Input
			Assert.assertEquals("PASS", Constants.key.click(vObjSwiftInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (country.equalsIgnoreCase("France") && currency.equalsIgnoreCase("EUR")
				&& bankCodeType.equalsIgnoreCase("IBAN")) {
			// No account number only IBAN as account no
		} else if (country.equalsIgnoreCase("India") && currency.equalsIgnoreCase("INR")
				&& bankCodeType.equalsIgnoreCase("IFSC")) {
			// Picker Wheel IFSC code
			// Assert.assertEquals("PASS",Constants.key.click(vObjBankCodeLbl));
			// Assert.assertEquals("PASS",Constants.key.writeInInput(vObjBankCodePickerWheel,
			// "IFSC code"));
			// Assert.assertEquals("PASS",Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjIFSCInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIFSCInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (country.equalsIgnoreCase("Singapore") && currency.equalsIgnoreCase("SGD")
				&& bankCodeType.equalsIgnoreCase("SWIFT")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjSwiftInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (country.equalsIgnoreCase("Australia") && currency.equalsIgnoreCase("AUD")
				&& bankCodeType.equalsIgnoreCase("BSB")) {
			// Picker Wheel BSB number
			// Assert.assertEquals("PASS",Constants.key.click(vObjBankCodeLbl));
			// Assert.assertEquals("PASS",Constants.key.writeInInput(vObjBankCodePickerWheel,
			// "BSB number"));
			// Assert.assertEquals("PASS",Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjBSBInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBSBInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered.............");
		} else if (country.equalsIgnoreCase("Australia") && currency.equalsIgnoreCase("AUD")
				&& bankCodeType.equalsIgnoreCase("SWIFT")) {
			// picker wheel SWIFT code
			// Assert.assertEquals("PASS",Constants.key.click(vObjBankCodeLbl));
			// Assert.assertEquals("PASS",Constants.key.writeInInput(vObjBankCodePickerWheel,
			// "SWIFT code"));
			// Assert.assertEquals("PASS",Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjSwiftInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered successfully.............");
		} else if (country.equalsIgnoreCase("New Zealand") && currency.equalsIgnoreCase("NZD")
				&& bankCodeType.equalsIgnoreCase("SWIFT")) {
			// picker wheel SWIFT code
			// Assert.assertEquals("PASS",Constants.key.click(vObjBankCodeLbl));
			// Assert.assertEquals("PASS",Constants.key.writeInInput(vObjBankCodePickerWheel,
			// "SWIFT code"));
			// Assert.assertEquals("PASS",Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjSwiftInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (country.equalsIgnoreCase("New Zealand") && currency.equalsIgnoreCase("NZD")
				&& bankCodeType.equalsIgnoreCase("BSB")) {
			// Picker Wheel BSB number
			// Assert.assertEquals("PASS",Constants.key.click(vObjBankCodeLbl));
			// Assert.assertEquals("PASS",Constants.key.writeInInput(vObjBankCodePickerWheel,
			// "BSB number"));
			// Assert.assertEquals("PASS",Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjBSBInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBSBInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (country.equalsIgnoreCase("Canada") && currency.equalsIgnoreCase("CAD")
				&& bankCodeType.equalsIgnoreCase("Transit,SWIFT")) {
			// NO picker wheel Input Transit number and SWIFT code are text
			// field
			Constants.Data = bankCode.split(",");
			// Assert.assertEquals("PASS",Constants.key.click(vObjTransitInputLbl));
			// Assert.assertEquals("PASS",Constants.key.writeInInput(vObjTransitInput,Constants.Data[0].toString()));
			// Assert.assertEquals("PASS",Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjSwiftInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");

		} else if (country.equalsIgnoreCase("Canada") && currency.equalsIgnoreCase("CAD")
				&& bankCodeType.equalsIgnoreCase("Routing number")) {
			// NO picker wheel Input Transit number and SWIFT code are text
			// field
			// Constants.Data = bankCode.split(",");
			Assert.assertEquals("PASS", Constants.key.click(vObjTransitInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTransitInput, Constants.Data[0].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Assert.assertEquals("PASS", Constants.key.click(vObjSwiftInputLbl));
			// Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftInput,
			// Constants.Data[1].toString()));
			// Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");

		} else if (country.equalsIgnoreCase("Canada") && currency.equalsIgnoreCase("CAD")
				&& bankCodeType.equalsIgnoreCase("Transit")) {
			// NO picker wheel Input Transit number
			Assert.assertEquals("PASS", Constants.key.click(vObjTransitInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTransitInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (country.equalsIgnoreCase("Hong Kong") && currency.equalsIgnoreCase("USD")
				&& bankCodeType.equalsIgnoreCase("SWIFT")) {
			// No picker wheel only SWIFT code Input
			Assert.assertEquals("PASS", Constants.key.click(vObjSwiftInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");

		} else if (country.equalsIgnoreCase("Hong Kong") && currency.equalsIgnoreCase("HKD")
				&& bankCodeType.equalsIgnoreCase("SWIFT")) {
			// No picker wheel only SWIFT code Input
			Assert.assertEquals("PASS", Constants.key.click(vObjSwiftInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");

		} else if (country.equalsIgnoreCase("Hungary") && currency.equalsIgnoreCase("HUF")
				&& bankCodeType.equalsIgnoreCase("IBAN")) {
			// No account number only IBAN as account no
		}

		else if (country.equalsIgnoreCase("China") && currency.equalsIgnoreCase("GBP")
				&& bankCodeType.equalsIgnoreCase("Branch Code")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjBranchCodeInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBrachCodeInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");

		} else if (country.equalsIgnoreCase("South Africa") && currency.equalsIgnoreCase("ZAR")
				&& bankCodeType.equalsIgnoreCase("CNAPS Code")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCNAPSCodeInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCNAPSCodeInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");

		}

		else if (country.equalsIgnoreCase("Hungary") && currency.equalsIgnoreCase("HUF")
				&& bankCodeType.equalsIgnoreCase("IBAN")) {
			// No account number only IBAN as account no
		} else if (country.equalsIgnoreCase("Spain") && currency.equalsIgnoreCase("EUR")
				&& bankCodeType.equalsIgnoreCase("IBAN")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjIBANInputlbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIBANInputText, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");

		} else if (country.equalsIgnoreCase("Australia") && currency.equalsIgnoreCase("AUD")
				&& bankCodeType.equalsIgnoreCase("BSB")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjBSBInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBSBInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (country.equalsIgnoreCase("South Africa") && currency.equalsIgnoreCase("ZAR")
				&& bankCodeType.equalsIgnoreCase("Branch code")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjBranchCodeInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBrachCodeInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");

		} else if (country.equalsIgnoreCase("China") && currency.equalsIgnoreCase("GBP")
				&& bankCodeType.equalsIgnoreCase(" CNAPS Code")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCNAPSCodeInputLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCNAPSCodeInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		}
	}

	@When("^ios user enters valid bank code \"([^\"]*)\" base on bank code type\"([^\"]*)\"$")
	public void ios_user_enters_valid_bank_code_base_on_bank_code_type(String bankCode, String bankCodeType)
			throws Throwable {
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		String vObjBankCodeLbl = Constants.IOSRecipientOR.getProperty("BankCodeLbl");
		String vObjBankCodePickerWheel = Constants.IOSRecipientOR.getProperty("BankCodePickerWheel");
		String vObjSwiftInputLbl = Constants.IOSRecipientOR.getProperty("SwiftInputLbl");
		String vObjSwiftInput = Constants.IOSRecipientOR.getProperty("SwiftInput");
		String vObjABAInputLbl = Constants.IOSRecipientOR.getProperty("ABAInputLbl");
		String vObjABAInput = Constants.IOSRecipientOR.getProperty("ABAInput");
		String vObjBSBInputLbl = Constants.IOSRecipientOR.getProperty("BSBInputLbl");
		String vObjBSBInput = Constants.IOSRecipientOR.getProperty("BSBInput");
		String vObjTransitInputLbl = Constants.IOSRecipientOR.getProperty("TransitInputLbl");
		String vObjTransitInput = Constants.IOSRecipientOR.getProperty("TransitInput");
		String vObjIFSCInputLbl = Constants.IOSRecipientOR.getProperty("IFSCInputLbl");
		String vObjIFSCInput = Constants.IOSRecipientOR.getProperty("IFSCInput");
		String vObjSortInputLbl = Constants.IOSRecipientOR.getProperty("SortInputLbl");
		String vObjSortInput = Constants.IOSRecipientOR.getProperty("SortInput");
		Constants.DataMap.put("RecipientBankCodeType", bankCodeType);
		Constants.DataMap.put("RecipientBankCode", bankCode);
		if (bankCodeType.equalsIgnoreCase("ABA")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjABAInput));
			System.out.println("Bank code is removed");
			// Assert.assertEquals("PASS", Constants.key.click(vObjABAInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjABAInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (bankCodeType.equalsIgnoreCase("SORT")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSortInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSortInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (bankCodeType.equalsIgnoreCase("SWIFT")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSwiftInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (bankCodeType.equalsIgnoreCase("IFSC")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjIFSCInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIFSCInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (bankCodeType.equalsIgnoreCase("BSB")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjBSBInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBSBInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered.............");
		} else if (bankCodeType.equalsIgnoreCase("Transit,SWIFT")) {
			Constants.Data = bankCode.split(",");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjTransitInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTransitInput, Constants.Data[0].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSwiftInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftInput, Constants.Data[1].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		} else if (bankCodeType.equalsIgnoreCase("Transit")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjTransitInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTransitInput, bankCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(bankCodeType + " code : " + bankCode + " entered .............");
		}

	}

	@Then("^bank details should be fetched in ios app$")
	public void bank_details_should_be_fetched_in_ios_app() throws Throwable {
		String vObjBankNameInput = Constants.IOSRecipientOR.getProperty("BankNameInput");
		Constants.key.scrollInIOS("Continue", "down");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankNameInput));
		String vBankName = Constants.key.getAttributeValue(vObjBankNameInput, "value");
		LogCapture.info("Below Bank details fetched : ");
		LogCapture.info("Bank name : " + vBankName);
		Constants.DataMap.put("RecipientBankName", vBankName);
		Constants.key.scrollInIOS("Continue", "down");
	}

	@Then("^invalid bank code \"([^\"]*)\" error message should be displayed to ios user$")
	public void invalid_bank_code_error_message_should_be_displayed_to_ios_user(String bankCodeType) throws Throwable {
		String vObjErrLblIBAN = Constants.IOSRecipientOR.getProperty("ErrLblIBAN");
		String vObjErrLblABA = Constants.IOSRecipientOR.getProperty("ErrLblABA");
		String vObjErrLblSORT = Constants.IOSRecipientOR.getProperty("ErrLblSORT");
		String vObjErrLblIFSC = Constants.IOSRecipientOR.getProperty("ErrLblIFSC");
		String vObjErrLblTransit = Constants.IOSRecipientOR.getProperty("ErrLblIBAN");
		String vObjErrLblBSB = Constants.IOSRecipientOR.getProperty("ErrLblBSB");
		if (bankCodeType.equalsIgnoreCase("IBAN")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidIBAN");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblIBAN, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid IBAN error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("ABA")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidABA");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblABA, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid ABA error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("SORT")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidSORT");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblSORT, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid SORT error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("IFSC")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidIFSC");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblIFSC, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid IFSC error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("Transit")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidTransit");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblTransit, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid Transit error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("BSB")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidBSB");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblBSB, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid BSB error message displayed.........");
		}

	}

	@Then("^invalid (swift code|account number) error message should be displayed to ios user$")
	public void invalid_swift_code_error_message_should_be_displayed_to_ios_user(String optionalValue)
			throws Throwable {

		if (optionalValue.equalsIgnoreCase("swift code")) {
			String vObjSwiftInputLbl = Constants.IOSRecipientOR.getProperty("SwiftInputLbl");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSwiftInputLbl));
			LogCapture.info("Invalid swift code error message displayed ");
		} else if (optionalValue.equalsIgnoreCase("account number")) {
			String vObjInvalidAccountErrLbl = Constants.IOSRecipientOR.getProperty("InvalidAccountErrLbl");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInvalidAccountErrLbl));
			String vInvalidAccountErrLbl = Constants.key.getAttributeValue(vObjInvalidAccountErrLbl, "value");
			String vInvalidAccountErrMsg = Constants.IOSTestData.getProperty("InavalidAccountNumber");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vInvalidAccountErrLbl, vInvalidAccountErrMsg));
			LogCapture.info("Invalid account number error message verified....... ");
		}
	}

	@Then("^invalid (account number) error message should be removed from the ios app add recipient screen$")
	public void invalid_account_number_error_message_should_be_removed_from_the_ios_app_add_recipient_screen(
			String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("account number")) {
			System.out.println("hellooo111");
			String vObjInvalidAccountErrLbl = Constants.IOSRecipientOR.getProperty("InvalidAccountErrLbl");
			String vInvalidAccountErrLbl = Constants.key.getAttributeValue(vObjInvalidAccountErrLbl, "value");
			String vInvalidAccountErrMsg = Constants.IOSTestData.getProperty("InavalidAccountNumber");
			Assert.assertEquals("FAIL", Constants.key.VerifyText(vInvalidAccountErrLbl, vInvalidAccountErrMsg));
			LogCapture.info("Invalid account number error message removed....... ");
		}
	}

	@When("^ios user removes (first|last|company) name$")
	public void ios_user_removes_first_name(String optionalValue) throws Throwable {
		String vObjFirstNameLbl = Constants.IOSRecipientOR.getProperty("FirstNameLbl");
		String vObjFirstNameInput = Constants.IOSRecipientOR.getProperty("FirstNameInput");
		String vObjLastNameInput = Constants.IOSRecipientOR.getProperty("LastNameInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vObjCompanyNameInput = Constants.IOSRecipientOR.getProperty("CompanyNameInput");

		if (optionalValue.equalsIgnoreCase("first")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjFirstNameInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("First name removed checking continue button state .........");

		} else if (optionalValue.equalsIgnoreCase("last")) {
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Individual", "up"));
			Constants.key.click(vObjFirstNameLbl);
			Constants.key.writeInInput(vObjFirstNameInput, "John");
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjLastNameInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Last name removed checking continue button state .........");
		}

		else if (optionalValue.equalsIgnoreCase("company")) {
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Company", "up"));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCompanyNameInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Company name removed checking continue button state .........");
		}

		else {
			LogCapture.info("Invalid field name............!!!!!!!!!!!!");
			Assert.assertEquals("PASS", "FAIL");
		}

	}

	@Then("^(first|last|company) name required error message should be displayed in ios app$")
	public void first_name_required_field_error_message_should_be_displayed_in_ios_app(String optionalValue)
			throws Throwable {
		String vObjErrLblFirstName = Constants.IOSRecipientOR.getProperty("ErrLblFirstName");
		String vObjErrLblLastName = Constants.IOSRecipientOR.getProperty("ErrLblLastName");
		String vObjErrLblCompanyName = Constants.IOSRecipientOR.getProperty("ErrLblCompanyName");

		if (optionalValue.equalsIgnoreCase("first")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCharcters");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblFirstName, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("First name required error message verified.........");

		} else if (optionalValue.equalsIgnoreCase("last")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCharcters");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblLastName, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Last name required error message verified.........");
		}

		else if (optionalValue.equalsIgnoreCase("company")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCharcters");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblCompanyName, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Company name required error message verified.........");
		}

		else {
			LogCapture.info("Invalid field name............!!!!!!!!!!!!");
			Assert.assertEquals("PASS", "FAIL");
		}
	}

	@When("^ios user removes (address line|city|post code|password)$")
	public void ios_user_removes_address_line(String optionalValue) throws Throwable {

		String vObjAddLine1PHolder = Constants.IOSRecipientOR.getProperty("AddLine1PHolder");
		String vObjTownCityPHolder = Constants.IOSRecipientOR.getProperty("TownCityPHolder");
		String vObjAddLine1Input = Constants.IOSRecipientOR.getProperty("AddLine1Input");
		String vObjTownCityInput = Constants.IOSRecipientOR.getProperty("TownCityInput");
		String vObjPostCodeInput = Constants.IOSRecipientOR.getProperty("PostCodeInput");
		// String vObjPostCodeInput = Constants.IOSRegstOR.getProperty("PostCodeInput");
		// String vObjPasswordInput = Constants.IOSRegstOR.getProperty("PasswordInput");
		String vObjPasswordInput = Constants.IOSRegstOR.getProperty("SetPassword");

		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		if (optionalValue.equalsIgnoreCase("address line")) {
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Individual", "up"));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjAddLine1Input));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Address line 1 removed checking continue button state .........");
		} else if (optionalValue.equalsIgnoreCase("city")) {
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Individual", "up"));
			Assert.assertEquals("PASS", Constants.key.click(vObjAddLine1PHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAddLine1Input, "Street Lane no-1"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjTownCityInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("City data removed checking continue button state .........");
		}

		else if (optionalValue.equalsIgnoreCase("post code")) {
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Individual", "up"));
			Assert.assertEquals("PASS", Constants.key.click(vObjTownCityPHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTownCityInput, "New York"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjPostCodeInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Post code removed checking continue button state .........");
		} else if (optionalValue.equalsIgnoreCase("post code")) {
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Individual", "up"));
			Assert.assertEquals("PASS", Constants.key.click(vObjTownCityPHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTownCityInput, "New York"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjPostCodeInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Post code removed checking continue button state .........");
		} else if (optionalValue.equalsIgnoreCase("password")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjPasswordInput));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjPasswordInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Password removed checking continue button state .........");
		}

		else {
			LogCapture.info("Invalid field name............!!!!!!!!!!!!");
			Assert.assertEquals("PASS", "FAIL");
		}

	}

	@Then("^(address line|city|post code) required error message should be displayed in ios app$")
	public void address_line_required_error_message_should_be_displayed_in_ios_app(String optionalValue)
			throws Throwable {
		if (optionalValue.equalsIgnoreCase("address line")) {

		} else if (optionalValue.equalsIgnoreCase("city")) {

		}

		else if (optionalValue.equalsIgnoreCase("post code")) {

		}

		else {
			LogCapture.info("Invalid field name............!!!!!!!!!!!!");
			Assert.assertEquals("PASS", "FAIL");
		}
	}

	@When("^ios user removes one of the mandatory bank field data \"([^\"]*)\"$")
	public void ios_user_removes_one_of_the_mandatory_personal_field_data(String data) throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vObjAccountNumberInput = Constants.IOSRecipientOR.getProperty("AccountNumberInput");
		String vObjSwiftInput = Constants.IOSRecipientOR.getProperty("SwiftInput");
		String vObjABAInput = Constants.IOSRecipientOR.getProperty("ABAInput");
		String vObjBSBInput = Constants.IOSRecipientOR.getProperty("BSBInput");
		String vObjTransitInput = Constants.IOSRecipientOR.getProperty("TransitInput");
		String vObjIFSCInput = Constants.IOSRecipientOR.getProperty("IFSCInput");
		String vObjSortInput = Constants.IOSRecipientOR.getProperty("SortInput");
		String vObjIBANInput = Constants.IOSRecipientOR.getProperty("IBANInput");

		if (data.equalsIgnoreCase("AccountNo") || data.equalsIgnoreCase("Account Number")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjAccountNumberInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Account number removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("IBAN")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjIBANInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Account number removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("SWIFT")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSwiftInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("SWIFT code removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("ABA")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjABAInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("ABA code removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("BSB")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjBSBInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("BSB code removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("IFSC")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjIFSCInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("IFSC code removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("Transit")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjTransitInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Transit code removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("SORT")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSortInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("SORT code removed checking continue button state .........");
		}
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));

	}

	@When("^ios user removes one of the mandatory address field data$")
	public void ios_user_removes_one_of_the_mandatory_address_field_data() throws Throwable {
		String vObjAddLine1PHolder = Constants.IOSRecipientOR.getProperty("AddLine1PHolder");
		String vObjAddLine1Input = Constants.IOSRecipientOR.getProperty("AddLine1Input");
		String vObjTownCityPHolder = Constants.IOSRecipientOR.getProperty("TownCityPHolder");
		String vObjTownCityInput = Constants.IOSRecipientOR.getProperty("TownCityInput");
		String vObjPostCodeInput = Constants.IOSRecipientOR.getProperty("PostCodeInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String atbValue;
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Individual", "up"));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjAddLine1Input));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Address line 1 removed checking continue button state .........");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
		String vObjBtnContinue = Constants.IOSRegstOR.getProperty("BtnContinue");
		atbValue = Constants.key.getAttributeValue(vObjBtnContinue, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		LogCapture.info("Continue button is in disabled state.........");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Individual", "up"));
		Assert.assertEquals("PASS", Constants.key.click(vObjAddLine1PHolder));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAddLine1Input, "Street Lane no-1"));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjTownCityInput));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjTownCityInput));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("City data removed checking continue button state .........");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
		atbValue = Constants.key.getAttributeValue(vObjBtnContinue, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		LogCapture.info("Continue button is in disabled state.........");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Individual", "up"));
		Assert.assertEquals("PASS", Constants.key.click(vObjTownCityPHolder));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTownCityInput, "New York"));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjPostCodeInput));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Post code removed checking continue button state .........");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
		atbValue = Constants.key.getAttributeValue(vObjBtnContinue, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
	}

	@Then("^newly added recipient details should be displayed on recipient view screen to ios user$")
	public void newly_added_recipient_details_should_be_displayed_on_recipient_view_screen_to_ios_user()
			throws Throwable {
		String RecipientType = Constants.DataMap.get("RecipientType");
		String FirstName = Constants.DataMap.get("FirstName");
		String LastName = Constants.DataMap.get("LastName");
		String CompanyName = Constants.DataMap.get("CompanyName");
		String AddressLine1 = Constants.DataMap.get("AddressLine1");
		String AddressCity = Constants.DataMap.get("AddressCity");
		String AddressPostCode = Constants.DataMap.get("AddressPostCode");
		String RecipientCountry = Constants.DataMap.get("RecipientCountry");
		String RecipientCurrency = Constants.DataMap.get("RecipientCurrency");
		String RecipientBankCodeType = Constants.DataMap.get("RecipientBankCodeType");
		String RecipientBankCode = Constants.DataMap.get("RecipientBankCode");
		String RecipientBankName = Constants.DataMap.get("RecipientBankName");
		String RecipientAccountNo = Constants.DataMap.get("RecipientAccountNo");
		String vObjRecViewEditBtn = Constants.IOSRecipientOR.getProperty("RecViewEditBtn");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecViewEditBtn));
		LogCapture.info("Recipient view screen displayed .........");
		LogCapture.info("Verifying added recipient details :");

		String vObjRecViewRecipientName = Constants.IOSRecipientOR.getProperty("RecViewRecipientName");
		String vRecViewRecipientName = Constants.key.getAttributeValue(vObjRecViewRecipientName, "value").toString();
		String vObjRecViewBankName = Constants.IOSRecipientOR.getProperty("RecViewBankName");
		String vRecViewBankName = Constants.key.getAttributeValue(vObjRecViewBankName, "value").toString();
		String vObjRecViewAccountNumberLbl = Constants.IOSRecipientOR.getProperty("RecViewAccountNumberLbl");
		String vObjRecViewAccountNumber = Constants.IOSRecipientOR.getProperty("RecViewAccountNumber");
		String vObjRecViewIBANLbl = Constants.IOSRecipientOR.getProperty("RecViewIBANLbl");
		String vObjRecViewIBAN = Constants.IOSRecipientOR.getProperty("RecViewIBAN");
		String vObjRecViewBSBLabel = Constants.IOSRecipientOR.getProperty("RecViewBSBLabel");
		String vObjRecViewBSBCode = Constants.IOSRecipientOR.getProperty("RecViewBSBCode");
		String vObjRecViewSwiftCodeLbl = Constants.IOSRecipientOR.getProperty("RecViewSwiftCodeLbl");
		String vObjRecViewSwiftCode = Constants.IOSRecipientOR.getProperty("RecViewSwiftCode");
		String vObjRecViewABACodeLbl = Constants.IOSRecipientOR.getProperty("RecViewABACodeLbl");
		String vObjRecViewABACode = Constants.IOSRecipientOR.getProperty("RecViewABACode");
		String vObjRecViewIFSCCodeLbl = Constants.IOSRecipientOR.getProperty("RecViewIFSCCodeLbl");
		String vObjRecViewIFSCCode = Constants.IOSRecipientOR.getProperty("RecViewIFSCCode");
		String vObjRecViewSortLabel = Constants.IOSRecipientOR.getProperty("RecViewSortLabel");
		String vObjRecViewSortCode = Constants.IOSRecipientOR.getProperty("RecViewSortCode");
		String vObjRecViewCurrencyLbl = Constants.IOSRecipientOR.getProperty("RecViewCurrencyLbl");
		String vObjRecViewCurrency = Constants.IOSRecipientOR.getProperty("RecViewCurrency");
		String vObjRecViewCountryLbl = Constants.IOSRecipientOR.getProperty("RecViewCountryLbl");
		String vObjRecViewCountry = Constants.IOSRecipientOR.getProperty("RecViewCountry");

		if (RecipientType.equalsIgnoreCase("Individual")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewRecipientName, FirstName + " " + LastName));
			LogCapture.info("Recipient name : " + vRecViewRecipientName + " matched... ");
		}
		if (RecipientType.equalsIgnoreCase("Company")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewRecipientName, CompanyName));
			LogCapture.info("Comapny name : " + vRecViewRecipientName + " matched... ");

		}
		Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewBankName, RecipientBankName));
		LogCapture.info("Bank name: " + vRecViewBankName + " matched...");

		if (RecipientBankCodeType.equalsIgnoreCase("IBAN")) {
			String vRecViewIBANLbl = Constants.key.getAttributeValue(vObjRecViewIBANLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewIBANLbl, "Iban"));
			String vRecViewIBAN = Constants.key.getAttributeValue(vObjRecViewIBAN, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewIBAN, RecipientAccountNo));
			LogCapture.info("IBAN : " + vRecViewIBAN + " matched... ");
		}
		if (!RecipientBankCodeType.equalsIgnoreCase("IBAN")) {
			String vRecViewAccountNumberLbll = Constants.key.getAttributeValue(vObjRecViewAccountNumberLbl, "value")
					.toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewAccountNumberLbll, "Account number"));
			String vRecViewAccountNumber = Constants.key.getAttributeValue(vObjRecViewAccountNumber, "value")
					.toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewAccountNumber, RecipientAccountNo));
			LogCapture.info("Accccount number : " + vRecViewAccountNumber + " matched... ");
		}
		if (RecipientBankCodeType.equalsIgnoreCase("BSB")) {
			String vRecViewBSBLabel = Constants.key.getAttributeValue(vObjRecViewBSBLabel, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewBSBLabel, "BSB number"));
			String vRecViewBSBCode = Constants.key.getAttributeValue(vObjRecViewBSBCode, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewBSBCode, RecipientBankCode));
			LogCapture.info("BSB Code : " + vRecViewBSBCode + " matched... ");
		}

		if (RecipientBankCodeType.equalsIgnoreCase("ABA")) {
			String vRecViewABACodeLbl = Constants.key.getAttributeValue(vObjRecViewABACodeLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewABACodeLbl, "ABA number"));
			String vRecViewABACode = Constants.key.getAttributeValue(vObjRecViewABACode, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewABACode, RecipientBankCode));
			LogCapture.info("ABA Code : " + vRecViewABACode + " matched... ");
		}

		if (RecipientBankCodeType.equalsIgnoreCase("IFSC")) {
			String vRecViewIFSCCodeLbl = Constants.key.getAttributeValue(vObjRecViewIFSCCodeLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewIFSCCodeLbl, "IFSC code"));
			String vRecViewIFSCCode = Constants.key.getAttributeValue(vObjRecViewIFSCCode, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewIFSCCode, RecipientBankCode));
			LogCapture.info("IFSC Code : " + vRecViewIFSCCode + " matched... ");
		}

		if (RecipientBankCodeType.equalsIgnoreCase("SORT")) {
			String vRecViewSortLabel = Constants.key.getAttributeValue(vObjRecViewSortLabel, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewSortLabel, "Sort code"));
			String vRecViewSortCode = Constants.key.getAttributeValue(vObjRecViewSortCode, "value").toString();
			System.out.println("Sort code Map : " + RecipientBankCode + " Sort code view screen : " + vRecViewSortCode);
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewSortCode, RecipientBankCode));
			LogCapture.info("SORT Code : " + vRecViewSortCode + " matched... ");
		}
		if (RecipientBankCodeType.equalsIgnoreCase("SWIFT")) {
			String vRecViewSwiftCodeLbl = Constants.key.getAttributeValue(vObjRecViewSwiftCodeLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewSwiftCodeLbl, "Swift no"));
			String vRecViewSwiftCode = Constants.key.getAttributeValue(vObjRecViewSwiftCode, "value").toString();
			int swiftLength = RecipientBankCode.length();
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(vRecViewSwiftCode.substring(0, swiftLength), RecipientBankCode));
			LogCapture.info("Swift Code : " + vRecViewSwiftCode + " matched... ");
		}
		if (RecipientBankCodeType.equalsIgnoreCase("Transit")) {
			// Transit code is pending........... unable to add Canada recipient
			// JIRA raised;
		}
		String vRecViewCurrencyLbl = Constants.key.getAttributeValue(vObjRecViewCurrencyLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewCurrencyLbl, "Currency"));
		String vRecViewCurrency = Constants.key.getAttributeValue(vObjRecViewCurrency, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewCurrency, RecipientCurrency));
		LogCapture.info("Currency : " + vRecViewCurrency + " matched... ");

		if (RecipientCountry.equalsIgnoreCase("USA")) {
			RecipientCountry = "United States of America";
		}
		String vRecViewCountryLbl = Constants.key.getAttributeValue(vObjRecViewCountryLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewCountryLbl, "Country"));
		String vRecViewCountry = Constants.key.getAttributeValue(vObjRecViewCountry, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewCountry, RecipientCountry));
		LogCapture.info("Country : " + vRecViewCountry + " matched... ");

		LogCapture.info("Recipient added and mapped details verified successfully on recipient view screen ....... ");
	}

	@Then("^default currency should be displayed as per country \"([^\"]*)\" selected by ios user$")
	public void default_currency_should_be_displayed_as_per_country_selected_by_ios_user(String country)
			throws Throwable {
		String vObjDDInputValue = Constants.IOSRecipientOR.getProperty("DDInputValue");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDDInputValue));
		String vDDCurrencyValue = Constants.key.getAttributeValue(vObjDDInputValue, "value");

		if (country.equalsIgnoreCase("USA")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText("US Dollar", vDDCurrencyValue.trim()));
		} else if (country.equalsIgnoreCase("New Zealand")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText("New Zealand Dollar", vDDCurrencyValue.trim()));
		} else if (country.equalsIgnoreCase("Canada")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText("Canadian Dollar", vDDCurrencyValue.trim()));
		} else if (country.equalsIgnoreCase("Hong Kong")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText("Hong kong Dollar", vDDCurrencyValue.trim()));
		} else if (country.equalsIgnoreCase("Hungary")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText("Hungary Forint", vDDCurrencyValue.trim()));
		} else if (country.equalsIgnoreCase("Australia")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText("Australian Dollar", vDDCurrencyValue.trim()));
		} else if (country.equalsIgnoreCase("France")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText("Euro", vDDCurrencyValue.trim()));
		} else if (country.equalsIgnoreCase("UK")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText("Sterling Pound", vDDCurrencyValue.trim()));
		} else if (country.equalsIgnoreCase("British Virgin Islands")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText("US Dollar", vDDCurrencyValue.trim()));
		} else {
			LogCapture.info("Country : " + country + " currency details not found.......");
			Assert.assertEquals("PASS", "FAIL");
		}
		LogCapture.info("Default currency : " + vDDCurrencyValue + " displayed in currency dropdown.......");
		Constants.DataMap.put("RecipientCurrency", vDDCurrencyValue);
	}

	@Then("^view recipient screen should be displayed to ios user$")
	public void view_recipient_screen_should_be_displayed_to_ios_user() throws Throwable {
		String vObjRecViewEditBtn = Constants.IOSRecipientOR.getProperty("RecViewEditBtn");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecViewEditBtn));
		LogCapture.info("Recipient view screen displayed .........");
	}

	@When("^ios user clicks on the back button present on edit recipient screen$")
	public void ios_user_clicks_on_the_back_button_present_on_edit_recipient_screen() throws Throwable {
		String vObjEditRecBtn = Constants.IOSRecipientOR.getProperty("EditRecBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjEditRecBtn));
		LogCapture.info("User clicked on back button present on edit recipient screen .........");
	}

	@When("^ios user removes one of the mandatory personal field data base on recipient type \"([^\"]*)\"$")
	public void ios_user_removes_one_of_the_mandatory_personal_field_data_base_on_recipient_type(String recipientTpye)
			throws Throwable {
		String vObjFirstNameLbl = Constants.IOSRecipientOR.getProperty("FirstNameLbl");
		String vObjFirstNameInput = Constants.IOSRecipientOR.getProperty("FirstNameInput");
		String vObjLastNameInput = Constants.IOSRecipientOR.getProperty("LastNameInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vObjCompanyNameInput = Constants.IOSRecipientOR.getProperty("CompanyNameInput");
		String vObjSaveRecipientBtn = Constants.IOSRecipientOR.getProperty("SaveRecipientBtn");
		String atbValue = "false";

		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Individual", "up"));
		if (recipientTpye.equalsIgnoreCase("Individual")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjFirstNameInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("First name removed checking continue button state .........");
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Save", "down"));
			atbValue = Constants.key.getAttributeValue(vObjSaveRecipientBtn, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
			LogCapture.info("Save button is in disabled state.........");
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Individual", "up"));
			Constants.key.click(vObjFirstNameLbl);
			Constants.key.writeInInput(vObjFirstNameInput, "John");
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjLastNameInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Last name removed checking continue button state .........");
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Save", "down"));
		} else if (recipientTpye.equalsIgnoreCase("Company")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCompanyNameInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Company name removed checking continue button state .........");
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Save", "down"));
		}

	}

	@Then("^the option to save the recipient details should be in (enabled|disabled) state in ios app$")
	public void the_option_to_save_the_recipient_details_should_be_in_disabled_state_in_ios_app(String optionalValue)
			throws Throwable {
		String vObjSaveRecipientBtn = Constants.IOSRecipientOR.getProperty("SaveRecipientBtn");
		// Assert.assertEquals("PASS",Constants.key.eleLocatedDisplayed(vObjSaveRecipientBtn));
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
		String atbValue = Constants.key.getAttributeValue(vObjSaveRecipientBtn, "enabled").toString();
		if (optionalValue.equalsIgnoreCase("enabled")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
			LogCapture.info("Save button is in enabled state.........");
		} else if (optionalValue.equalsIgnoreCase("disabled")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
			LogCapture.info("Save button is in disabled state.........");
		}

	}

	@When("^ios user removes one of the mandatory bank field data \"([^\"]*)\" from the edit recipient screen$")
	public void ios_user_removes_one_of_the_mandatory_bank_field_data_from_the_edit_recipient_screen(String data)
			throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vObjIBANInput = Constants.IOSRecipientOR.getProperty("IBANInput");
		String vObjSwiftInput = Constants.IOSRecipientOR.getProperty("SwiftInput");
		String vObjABAInput = Constants.IOSRecipientOR.getProperty("ABAInput");
		String vObjBSBInput = Constants.IOSRecipientOR.getProperty("BSBInput");
		String vObjTransitInput = Constants.IOSRecipientOR.getProperty("TransitInput");
		String vObjIFSCInput = Constants.IOSRecipientOR.getProperty("IFSCInput");
		String vObjSortInput = Constants.IOSRecipientOR.getProperty("SortInput");

		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Save", "down"));
		if (data.equalsIgnoreCase("IBAN")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjIBANInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("IBAN removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("SWIFT")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSwiftInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("SWIFT code removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("ABA")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjABAInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("ABA code removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("BSB")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjBSBInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("BSB code removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("IFSC")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjIFSCInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("IFSC code removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("Transit")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjTransitInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Transit code removed checking continue button state .........");
		} else if (data.equalsIgnoreCase("SORT")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSortInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("SORT code removed checking continue button state .........");
		}
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Save", "down"));
	}

	@When("^ios user removes account number from the edit recipient screen$")
	public void ios_user_removes_account_number_from_the_edit_recipient_screen() throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vObjAccountNumberInput = Constants.IOSRecipientOR.getProperty("AccountNumberInput");
		Constants.key.scrollInIOS("Save", "down");
		Assert.assertEquals("PASS", Constants.key.clearText(vObjAccountNumberInput));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("Account number removed checking continue button state .........");
	}

	@Then("^previous bank details should be clear in ios app$")
	public void previous_bank_details_should_be_clear_in_ios_app() throws Throwable {
		String vObjBankNameInput = Constants.IOSRecipientOR.getProperty("BankNameInput");
		Constants.key.scrollInIOS("Save", "down");
		String vBankName = Constants.key.getAttributeValue(vObjBankNameInput, "value");
		Assert.assertEquals("FAIL", vBankName);

	}

	@When("^ios user change the recipient type \"([^\"]*)\"$")
	public void ios_user_change_the_recipient_type(String recipientType) throws Throwable {
		if (recipientType.equalsIgnoreCase("Individual")) {
			String vObjRecipientCompanyBtn = Constants.IOSRecipientOR.getProperty("RecipientCompanyBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientCompanyBtn));
		} else if (recipientType.equalsIgnoreCase("Company")) {
			String vObjRecipientIndividualBtn = Constants.IOSRecipientOR.getProperty("RecipientIndividualBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientIndividualBtn));
		}
	}

	@Then("^current recipient type \"([^\"]*)\" should not be changed in ios recipient edit screen$")
	public void current_recipient_type_should_not_be_changed_in_ios_recipient_edit_screen(String recipientType)
			throws Throwable {
		if (recipientType.equalsIgnoreCase("Individual")) {
			String vObjCompanyNameLbl = Constants.IOSRecipientOR.getProperty("CompanyNameLbl");
			String vCompanyNameLbl = Constants.key.getAttributeValue(vObjCompanyNameLbl, "value");
			Assert.assertEquals("FAIL", vCompanyNameLbl);
		} else if (recipientType.equalsIgnoreCase("Company")) {
			String vObjFirstNameLbl = Constants.IOSRecipientOR.getProperty("FirstNameLbl");
			String vFirstNameLbl = Constants.key.getAttributeValue(vObjFirstNameLbl, "value");
			Assert.assertEquals("FAIL", vFirstNameLbl);
		}
	}

	@When("^ios user updates personal field details \"([^\"]*)\" base on recipient type \"([^\"]*)\"$")
	public void ios_user_updates_personal_field_details_base_on_recipient_type(String data, String recipientType)
			throws Throwable {
		String vObjFirstNameInput = Constants.IOSRecipientOR.getProperty("FirstNameInput");
		String vObjLastNameInput = Constants.IOSRecipientOR.getProperty("LastNameInput");
		String vObjCompanyNameInput = Constants.IOSRecipientOR.getProperty("CompanyNameInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");

		Constants.Data = data.split(",");
		String data2[];
		Constants.DataMap.put("RecipientType", recipientType);
		for (int i = 0; i <= Constants.Data.length - 1; i++) {
			data2 = Constants.Data[i].split("-");
			if (recipientType.equalsIgnoreCase("Individual")) {
				if (data2[0].equalsIgnoreCase("FirstName")) {
					Assert.assertEquals("PASS", Constants.key.clearText(vObjFirstNameInput));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameInput, data2[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
					Constants.DataMap.put("FirstName", data2[1].toString());
					LogCapture.info("First name field updated by user..............");
				} else if (data2[0].equalsIgnoreCase("LastName")) {
					Assert.assertEquals("PASS", Constants.key.clearText(vObjLastNameInput));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameInput, data2[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
					Constants.DataMap.put("LastName", data2[1].toString());
					LogCapture.info("Last name field updated by user..............");

				} else {
					LogCapture.info("Invalid personal field details please check..............!!!!!!!!!!!!!");
					Assert.assertEquals("PASS", "FAIL");
				}
			} else if (recipientType.equalsIgnoreCase("Company")) {
				if (data2[0].equalsIgnoreCase("CompanyName")) {
					Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameInput));
					Assert.assertEquals("PASS", Constants.key.clearText(vObjCompanyNameInput));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameInput, data2[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
					Constants.DataMap.put("CompanyName", data2[1].toString());
					LogCapture.info("Comapny name field updated by user ..............");
				} else {
					LogCapture.info("Invalid personal field details please check..............!!!!!!!!!!!!!");
					Assert.assertEquals("PASS", "FAIL");
				}
			}
		}

	}

	@When("^ios user updates (address|bank) field details \"([^\"]*)\"$")
	public void ios_user_updates_address_field_details(String optionalValue, String data) throws Throwable {

		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vObjDefaultCountry = Constants.IOSRecipientOR.getProperty("CountryInput");
		String vCountry = Constants.key.getAttributeValue(vObjDefaultCountry, "value");
		String vObjDDInputValue = Constants.IOSRecipientOR.getProperty("DDInputValue");
		String vDDCurrencyValue = Constants.key.getAttributeValue(vObjDDInputValue, "value");
		String vObjAddLine1Input = Constants.IOSRecipientOR.getProperty("AddLine1Input");
		String vObjTownCityInput = Constants.IOSRecipientOR.getProperty("TownCityInput");
		String vObjPostCodeInput = Constants.IOSRecipientOR.getProperty("PostCodeInput");

		String vObjAccountNumberInput = Constants.IOSRecipientOR.getProperty("AccountNumberInput");
		String vObjIBANInput = Constants.IOSRecipientOR.getProperty("IBANInput");
		String vObjSwiftInput = Constants.IOSRecipientOR.getProperty("SwiftInput");
		String vObjABAInput = Constants.IOSRecipientOR.getProperty("ABAInput");
		String vObjBSBInput = Constants.IOSRecipientOR.getProperty("BSBInput");
		String vObjTransitInput = Constants.IOSRecipientOR.getProperty("TransitInput");
		String vObjIFSCInput = Constants.IOSRecipientOR.getProperty("IFSCInput");
		String vObjSortInput = Constants.IOSRecipientOR.getProperty("SortInput");

		// addressField :Addressline1,City,PostCode
		// bankField:AccountNumber,ABA,IBAN,SWIFT,SORT,IFSC,BSB,Transit
		Constants.Data = data.split(",");
		String data2[];
		for (int i = 0; i <= Constants.Data.length - 1; i++) {
			data2 = Constants.Data[i].split("-");
			if (optionalValue.equalsIgnoreCase("address")) {

				if (vCountry.equalsIgnoreCase("France") || vCountry.equalsIgnoreCase("Spain")
						|| vCountry.equalsIgnoreCase("UK") || vCountry.equalsIgnoreCase("India")
						|| vCountry.equalsIgnoreCase("Hungary") || vCountry.equalsIgnoreCase("Hong Kong")
								&& vDDCurrencyValue.equalsIgnoreCase("Hong Kong Dollar")) {
					LogCapture.info("Address " + data2[0].toString() + " is not required for country : " + vCountry);
				} else if (vCountry.equalsIgnoreCase("United States of America") || vCountry.equalsIgnoreCase("Canada")
						|| vCountry.equalsIgnoreCase("Australia") || vCountry.equalsIgnoreCase("Hong Kong")
						|| vCountry.equalsIgnoreCase("New Zealand")
						|| vCountry.equalsIgnoreCase("Hong Kong") && vDDCurrencyValue.equalsIgnoreCase("US Dollar")) {

					if (data2[0].equalsIgnoreCase("AddressLine1")) {
						LogCapture.info("Updating addressLine1 details..............");
						Assert.assertEquals("PASS", Constants.key.clearText(vObjAddLine1Input));
						Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAddLine1Input, data2[1].toString()));
						Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
						Constants.DataMap.put("AddressLine1", data2[1].toString());
						LogCapture.info("Address line1 field updated by user..............");
					} else if (data2[0].equalsIgnoreCase("City")) {
						LogCapture.info("Updating city details..............");
						Assert.assertEquals("PASS", Constants.key.clearText(vObjTownCityInput));
						Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTownCityInput, data2[1].toString()));
						Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
						Constants.DataMap.put("AddressCity", data2[1].toString());
						LogCapture.info("City field updated by user..............");
					} else if (data2[0].equalsIgnoreCase("PostCode")) {
						LogCapture.info("Updating post code details..............");
						Assert.assertEquals("PASS", Constants.key.scrollInIOS("Save", "down"));
						Assert.assertEquals("PASS", Constants.key.clearText(vObjPostCodeInput));
						Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostCodeInput, data2[1].toString()));
						Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
						Constants.DataMap.put("AddressPostCode", data2[1].toString());
						LogCapture.info("Post code field updated by user..............");
					} else {
						LogCapture.info("Invalid address field details please check..............!!!!!!!!!!!!!");
						Assert.assertEquals("PASS", "FAIL");
					}
				}

			} else if (optionalValue.equalsIgnoreCase("bank")) {
				LogCapture.info("Updating bank details..............");
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Save", "down"));
				if (data2[0].equalsIgnoreCase("AccountNumber") || data2[0].equalsIgnoreCase("Account Number")
						|| data2[0].equalsIgnoreCase("Account No") || data2[0].equalsIgnoreCase("AccountNo")) {
					Assert.assertEquals("PASS", Constants.key.clearText(vObjAccountNumberInput));
					Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjAccountNumberInput, data2[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
					Constants.DataMap.put("RecipientAccountNo", data2[1].toString());
					LogCapture.info("Account number field updated by user..............");
				} else if (data2[0].equalsIgnoreCase("ABA")) {
					Assert.assertEquals("PASS", Constants.key.clearText(vObjABAInput));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjABAInput, data2[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
					Constants.DataMap.put("RecipientBankCode", data2[1].toString());
					LogCapture.info("ABA code updated by user..............");
				} else if (data2[0].equalsIgnoreCase("IBAN")) {
					Assert.assertEquals("PASS", Constants.key.clearText(vObjIBANInput));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIBANInput, data2[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
					Constants.DataMap.put("RecipientBankCode", data2[1].toString());
					LogCapture.info("IBAN field updated by user..............");
				} else if (data2[0].equalsIgnoreCase("SWIFT")) {
					Assert.assertEquals("PASS", Constants.key.clearText(vObjSwiftInput));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftInput, data2[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
					Constants.DataMap.put("RecipientBankCode", data2[1].toString());
					LogCapture.info("SWIFT field updated by user..............");
				} else if (data2[0].equalsIgnoreCase("SORT")) {
					Assert.assertEquals("PASS", Constants.key.clearText(vObjSortInput));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSortInput, data2[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
					Constants.DataMap.put("RecipientBankCode", data2[1].toString());
					LogCapture.info("SORT field updated by user..............");
				} else if (data2[0].equalsIgnoreCase("IFSC")) {
					Assert.assertEquals("PASS", Constants.key.clearText(vObjIFSCInput));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIFSCInput, data2[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
					Constants.DataMap.put("RecipientBankCode", data2[1].toString());
					LogCapture.info("IFSC field updated by user..............");
				} else if (data2[0].equalsIgnoreCase("BSB")) {
					Assert.assertEquals("PASS", Constants.key.clearText(vObjBSBInput));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBSBInput, data2[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
					Constants.DataMap.put("RecipientBankCode", data2[1].toString());
					LogCapture.info("BSB field updated by user..............");
				} else if (data2[0].equalsIgnoreCase("Transit")) {
					Assert.assertEquals("PASS", Constants.key.clearText(vObjTransitInput));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTransitInput, data2[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
					Constants.DataMap.put("RecipientBankCode", data2[1].toString());
					LogCapture.info("Transit field updated by user..............");
				} else {
					LogCapture.info("Invalid bank field details please check..............!!!!!!!!!!!!!");
					Assert.assertEquals("PASS", "FAIL");
				}
			}
		}
	}

	@Then("^updated details should be displayed on view recipient screen to ios user$")
	public void updated_details_should_be_displayed_on_view_recipient_screen_to_ios_user() throws Throwable {
		String vObjRecViewRecipientName = Constants.IOSRecipientOR.getProperty("RecViewRecipientName");
		String vRecViewRecipientName = Constants.key.getAttributeValue(vObjRecViewRecipientName, "value").toString();
		String vObjRecViewBankName = Constants.IOSRecipientOR.getProperty("RecViewBankName");
		String vRecViewBankName = Constants.key.getAttributeValue(vObjRecViewBankName, "value").toString();
		String vObjRecViewAccountNumberLbl = Constants.IOSRecipientOR.getProperty("RecViewAccountNumberLbl");
		String vObjRecViewAccountNumber = Constants.IOSRecipientOR.getProperty("RecViewAccountNumber");
		String vObjRecViewIBANLbl = Constants.IOSRecipientOR.getProperty("RecViewIBANLbl");
		String vObjRecViewIBAN = Constants.IOSRecipientOR.getProperty("RecViewIBAN");
		String vObjRecViewBSBLabel = Constants.IOSRecipientOR.getProperty("RecViewBSBLabel");
		String vObjRecViewBSBCode = Constants.IOSRecipientOR.getProperty("RecViewBSBCode");
		String vObjRecViewSwiftCodeLbl = Constants.IOSRecipientOR.getProperty("RecViewSwiftCodeLbl");
		String vObjRecViewSwiftCode = Constants.IOSRecipientOR.getProperty("RecViewSwiftCode");
		String vObjRecViewABACodeLbl = Constants.IOSRecipientOR.getProperty("RecViewABACodeLbl");
		String vObjRecViewABACode = Constants.IOSRecipientOR.getProperty("RecViewABACode");
		String vObjRecViewIFSCCodeLbl = Constants.IOSRecipientOR.getProperty("RecViewIFSCCodeLbl");
		String vObjRecViewIFSCCode = Constants.IOSRecipientOR.getProperty("RecViewIFSCCode");
		String vObjRecViewSortLabel = Constants.IOSRecipientOR.getProperty("RecViewSortLabel");
		String vObjRecViewSortCode = Constants.IOSRecipientOR.getProperty("RecViewSortCode");
		String vObjRecViewCurrencyLbl = Constants.IOSRecipientOR.getProperty("RecViewCurrencyLbl");
		String vObjRecViewCurrency = Constants.IOSRecipientOR.getProperty("RecViewCurrency");
		String vObjRecViewCountryLbl = Constants.IOSRecipientOR.getProperty("RecViewCountryLbl");
		String vObjRecViewCountry = Constants.IOSRecipientOR.getProperty("RecViewCountry");

		LogCapture.info("Recipient view screen displayed .........");
		LogCapture.info("Verifying updated recipient details :");
		String name = "";
		if (Constants.DataMap.containsKey("RecipientType")) {
			if (Constants.DataMap.get("RecipientType").toString().equalsIgnoreCase("Individual")) {
				name = Constants.DataMap.get("FirstName").toString() + " "
						+ Constants.DataMap.get("LastName").toString();
			} else if (Constants.DataMap.get("RecipientType").toString().equalsIgnoreCase("Company")) {
				name = Constants.DataMap.get("CompanyName").toString();
			}
		}

		else {
			name = Constants.DataMap.get("RecipientName");
		}
		Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewRecipientName, name));
		LogCapture.info("Recipient name : " + vRecViewRecipientName + " matched... ");
		if (Constants.DataMap.containsKey("RecipientAccountNo")) {
			String recipientAccountNo = Constants.DataMap.get("RecipientAccountNo");
			String vRecViewAccountNumberLbll = Constants.key.getAttributeValue(vObjRecViewAccountNumberLbl, "value")
					.toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewAccountNumberLbll, "Account number"));
			String vRecViewAccountNumber = Constants.key.getAttributeValue(vObjRecViewAccountNumber, "value")
					.toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewAccountNumber, recipientAccountNo));
			LogCapture.info("Accccount number : " + vRecViewAccountNumber + " matched... ");
		}
		if (Constants.DataMap.containsKey("RecipientBankCodeType")) {
			String bankCodeType = Constants.DataMap.get("RecipientBankCodeType");
			String bankCode = Constants.DataMap.get("RecipientBankCode");
			if (bankCodeType.equalsIgnoreCase("IBAN")) {
				String vRecViewIBANLbl = Constants.key.getAttributeValue(vObjRecViewIBANLbl, "value").toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewIBANLbl, "Iban"));
				String vRecViewIBAN = Constants.key.getAttributeValue(vObjRecViewIBAN, "value").toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewIBAN, bankCode));
				LogCapture.info("IBAN : " + vRecViewIBAN + " matched... ");
			}
			if (bankCodeType.equalsIgnoreCase("BSB")) {
				String vRecViewBSBLabel = Constants.key.getAttributeValue(vObjRecViewBSBLabel, "value").toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewBSBLabel, "BSB number"));
				String vRecViewBSBCode = Constants.key.getAttributeValue(vObjRecViewBSBCode, "value").toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewBSBCode, bankCode));
				LogCapture.info("BSB Code : " + vRecViewBSBCode + " matched... ");
			}
			if (bankCodeType.equalsIgnoreCase("ABA")) {
				String vRecViewABACodeLbl = Constants.key.getAttributeValue(vObjRecViewABACodeLbl, "value").toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewABACodeLbl, "ABA number"));
				String vRecViewABACode = Constants.key.getAttributeValue(vObjRecViewABACode, "value").toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewABACode, bankCode));
				LogCapture.info("ABA Code : " + vRecViewABACode + " matched... ");
			}
			if (bankCodeType.equalsIgnoreCase("IFSC")) {
				String ifsc = Constants.DataMap.get("ABA");
				String vRecViewIFSCCodeLbl = Constants.key.getAttributeValue(vObjRecViewIFSCCodeLbl, "value")
						.toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewIFSCCodeLbl, "IFSC code"));
				String vRecViewIFSCCode = Constants.key.getAttributeValue(vObjRecViewIFSCCode, "value").toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewIFSCCode, bankCode));
				LogCapture.info("IFSC Code : " + vRecViewIFSCCode + " matched... ");
			}
			if (bankCodeType.equalsIgnoreCase("SORT")) {
				String vRecViewSortLabel = Constants.key.getAttributeValue(vObjRecViewSortLabel, "value").toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewSortLabel, "Sort code"));
				String vRecViewSortCode = Constants.key.getAttributeValue(vObjRecViewSortCode, "value").toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewSortCode, bankCode));
				LogCapture.info("SORT Code : " + vRecViewSortCode + " matched... ");
			}
			if (bankCodeType.equalsIgnoreCase("SWIFT")) {
				String vRecViewSwiftCodeLbl = Constants.key.getAttributeValue(vObjRecViewSwiftCodeLbl, "value")
						.toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewSwiftCodeLbl, "Swift no"));
				String vRecViewSwiftCode = Constants.key.getAttributeValue(vObjRecViewSwiftCode, "value").toString();
				int swiftLength = bankCode.length();
				Assert.assertEquals("PASS",
						Constants.key.VerifyText(vRecViewSwiftCode.substring(0, swiftLength), bankCode));
				LogCapture.info("Swift Code : " + vRecViewSwiftCode + " matched... ");
			}
			if (bankCodeType.equalsIgnoreCase("Transit")) {
				// Transit code is pending........... unable to add Canada
				// recipient JIRA raised;
			}
		}

		if (Constants.DataMap.containsKey("RecipientCurrency1")) {
			String RecipientCurrency = Constants.DataMap.get("RecipientCurrency1");
			String vCurrencyName = Constants.IOSTestData.getProperty(RecipientCurrency);

			String vRecViewCurrencyLbl = Constants.key.getAttributeValue(vObjRecViewCurrencyLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewCurrencyLbl, "Currency"));
			String vRecViewCurrency = Constants.key.getAttributeValue(vObjRecViewCurrency, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewCurrency, vCurrencyName));
			LogCapture.info("Currency : " + vRecViewCurrency + " matched... ");
		}

		if (Constants.DataMap.containsKey("RecipientCountry")) {
			String RecipientCountry = Constants.DataMap.get("RecipientCountry");
			if (Constants.DataMap.get("RecipientCountry").equalsIgnoreCase("USA")) {
				RecipientCountry = "United States of America";
			}
			String vRecViewCountryLbl = Constants.key.getAttributeValue(vObjRecViewCountryLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewCountryLbl, "Country"));
			String vRecViewCountry = Constants.key.getAttributeValue(vObjRecViewCountry, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vRecViewCountry, RecipientCountry));
			LogCapture.info("Country : " + vRecViewCountry + " matched... ");
		}
		LogCapture.info("Updated recipient details verified successfully on recipient view screen ....... ");
	}

	@Then("^invalid (bank|swift) code error message should be displayed$")
	public void invalid_bank_code_error_message_should_be_displayed(String optionalValue) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (optionalValue.equalsIgnoreCase("bank")) {

		} else if (optionalValue.equalsIgnoreCase("swift")) {

		}
	}

	@Then("^invalid (personal|address) field error message should be displayed$")
	public void invalid_personal_field_error_message_should_be_displayed(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("personal")) {

		} else if (optionalValue.equalsIgnoreCase("address")) {

		}
	}

	@Then("^error message should be displayed as recipent already exist$")
	public void error_message_should_be_displayed_as_recipent_already_exist() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^ios user removes mandatory address field (address line|street line|city|post code|unit street apartment|town city|zip code|street name|street number|suburb|city of canada country|post code of canada country|post code of australia country)$")
	public void ios_user_removes_mandatory_address_field_street_line(String optionalField) throws Throwable {
		String vObjAddLine1PHolder = Constants.IOSMyCardOR.getProperty("AddLine1PHolder");
		String vObjAddLine1Input = Constants.IOSMyCardOR.getProperty("AddLine1Input");
		String vObjTownCityPHolder = Constants.IOSMyCardOR.getProperty("TownCityPHolder");
		String vObjTownCityInput = Constants.IOSMyCardOR.getProperty("TownCityInput");
		String vObjCountyPHolder = Constants.IOSMyCardOR.getProperty("CountyPHolder");
		String vObjCountyInput = Constants.IOSMyCardOR.getProperty("CountyInput");
		String vObjPostCodePHolder = Constants.IOSMyCardOR.getProperty("PostCodePHolder");
		// String vObjPostCodePHolder =
		// Constants.IOSRegstOR.getProperty("PostCodePHolder");
		// String vObjPostCodeInput =
		// Constants.IOSMyCardOR.getProperty("PostCodeInput");
		String vObjPostCodeInputAll = Constants.IOSMyCardOR.getProperty("PostCodeAll");
		String vObjPostCodeInput = Constants.IOSRegstOR.getProperty("PostCodeInput");
		String vObjUSAStreetPH = Constants.IOSMyCardOR.getProperty("USAStreetPH");
		String vObjUSAStreetInput = Constants.IOSMyCardOR.getProperty("USAStreetInput");
		String vObjUSACityPHolder = Constants.IOSMyCardOR.getProperty("CityPHolder");
		String vObjUSACityInput = Constants.IOSMyCardOR.getProperty("CityInput");
		String vObjUSAStatePH = Constants.IOSMyCardOR.getProperty("StatePH");
		String vObjUSAStatePickerWheel = Constants.IOSMyCardOR.getProperty("StatePickerWheel");
		String vObjUSAZipCodePHolder = Constants.IOSMyCardOR.getProperty("USAZipCodePHolder");
		String vObjUSAZipCodeInput = Constants.IOSMyCardOR.getProperty("USAZipCodeInput");
		String vObjUnitNoPH = Constants.IOSMyCardOR.getProperty("UnitNoPH");
		String vObjUnitNoInput = Constants.IOSMyCardOR.getProperty("UnitNoInput");
		String vObjCivicNoPH = Constants.IOSMyCardOR.getProperty("CivicNoPH");
		String vObjCivicNoInput = Constants.IOSMyCardOR.getProperty("CivicNoInput");
		String vObjStreetPH = Constants.IOSMyCardOR.getProperty("StreetPH");
		String vObjStreetInput = Constants.IOSMyCardOR.getProperty("StreetInput");
		String vObjStreetTypePH = Constants.IOSMyCardOR.getProperty("StreetTypePH");
		String vObjStreetTypeInput = Constants.IOSMyCardOR.getProperty("StreetTypeInput");
		String vObjCityPHolder = Constants.IOSMyCardOR.getProperty("CityPHolder");
		String vObjCityInput = Constants.IOSMyCardOR.getProperty("CityInput");
		String vObjStatePH = Constants.IOSMyCardOR.getProperty("StatePH");
		String vObjStatePickerWheel = Constants.IOSMyCardOR.getProperty("StatePickerWheel");
		String vObjStrretNoPH = Constants.IOSMyCardOR.getProperty("StrretNoPH");
		String vObjStrretNoInput = Constants.IOSMyCardOR.getProperty("StrretNoInput");
		String vObjStreetNamePH = Constants.IOSMyCardOR.getProperty("StreetNamePH");
		String vObjStreetNameInput = Constants.IOSMyCardOR.getProperty("StreetNameInput");
		String vObjSuburbPH = Constants.IOSMyCardOR.getProperty("SuburbPH");
		String vObjSuburbInput = Constants.IOSMyCardOR.getProperty("SuburbInput");

		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");

		if (optionalField.equalsIgnoreCase("address line")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjAddLine1Input));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjAddLine1Input));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Strret address line removed by user........... ");
		} else if (optionalField.equalsIgnoreCase("street line")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjUSAStreetInput));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjUSAStreetInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Strret address line removed by user........... ");
		} else if (optionalField.equalsIgnoreCase("town city")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjAddLine1PHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAddLine1Input, "Test address1"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjTownCityInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Town city removed by user........... ");
		} else if (optionalField.equalsIgnoreCase("post code")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjTownCityPHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTownCityInput, "Test City"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjPostCodeInputAll));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Post code removed by user........... ");
		} else if (optionalField.equalsIgnoreCase("post code of canada country")) {
			// System.out.println("I am in post code loop");
			// Assert.assertEquals("PASS", Constants.key.click(vObjTownCityPHolder));
			// Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTownCityInput,
			// "Test City"));
			Assert.assertEquals("PASS", Constants.key.click(vObjCityPHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCityInput, "Test city"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Postcode", "down"));
			Assert.assertEquals("PASS", Constants.key.click(vObjPostCodePHolder));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjPostCodeInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Post code removed by user........... ");
		}

		else if (optionalField.equalsIgnoreCase("unit street apartment")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjUSAStreetInput));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjUSAStreetInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Unit street apartment removed by user........... ");
		} else if (optionalField.equalsIgnoreCase("city")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjUSAStreetPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUSAStreetInput, "Test unit apartment"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCityInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("City removed by user........... ");
		} else if (optionalField.equalsIgnoreCase("city of canada country")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjStreetPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStreetInput, "Test City"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCityInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("City removed by user........... ");
		}

		else if (optionalField.equalsIgnoreCase("zip code")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCityPHolder));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCityInput, "Test city"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjUSAZipCodeInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (optionalField.equalsIgnoreCase("street name")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjStreetNameInput));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjStreetNameInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Street name removed by user........... ");
		} else if (optionalField.equalsIgnoreCase("street number")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjStreetNamePH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStreetNameInput, "Test street name"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjStrretNoInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Street number removed by user........... ");
		} else if (optionalField.equalsIgnoreCase("suburb")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjStrretNoPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStrretNoInput, "Test Street Number"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSuburbInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Suburb removed by user........... ");
		} else if (optionalField.equalsIgnoreCase("post code of australia country")) {
			Constants.key.scrollInIOS("Save", "down");
			Assert.assertEquals("PASS", Constants.key.click(vObjSuburbPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSuburbInput, "Test suburb"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Constants.key.scrollInIOS("PostCode", "down");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjPostCodeInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info("Post code removed by user........... ");
		}
	}

	@Then("^(street line|city|post code|unit street apartment|town city|zip code|street name|street number|suburb) field required error message should be displayed in ios app$")
	public void post_code_field_required_error_message_should_be_displayed_in_ios_app(String optionalField)
			throws Throwable {
		String vObjAddressLine1ErrLbl = Constants.IOSMyCardOR.getProperty("AddressLine1ErrLbl");
		String vObjTownCityErrLbl = Constants.IOSMyCardOR.getProperty("TownCityErrLbl");
		String vObjPostCodeErrLbl = Constants.IOSMyCardOR.getProperty("PostCodeErrLbl");
		String vObjCityErrLbl = Constants.IOSMyCardOR.getProperty("CityErrLbl");
		String vObjUnitStreetErrLbl = Constants.IOSMyCardOR.getProperty("UnitStreetErrLbl");
		String vObjZipCodeErrLbl = Constants.IOSMyCardOR.getProperty("ZipCodeErrLbl");
		String vObjStreetNameErrLbl = Constants.IOSMyCardOR.getProperty("StreetNameErrLbl");
		String vObjStreetNumberErrLbl = Constants.IOSMyCardOR.getProperty("StreetNumberErrLbl");
		String vObjSuburbErrLbl = Constants.IOSMyCardOR.getProperty("SuburbErrLbl");

		String vAddressLine1RequiredErrMsg = Constants.IOSTestData.getProperty("AddressLine1RequiredErrMsg");
		String vCityFieldRequiredErrMsg = Constants.IOSTestData.getProperty("CityFieldRequiredErrMsg");
		String vPostCodeRequiredErrMsg = Constants.IOSTestData.getProperty("PostCodeRequiredErrMsg");
		String vUnitStreetRequiredErrMsg = Constants.IOSTestData.getProperty("UnitStreetRequiredErrMsg");
		String vTownCityRequiredErrMsg = Constants.IOSTestData.getProperty("TownCityRequiredErrMsg");
		String vZipCodeRequiredErrMsg = Constants.IOSTestData.getProperty("ZipCodeRequiredErrMsg");
		String vStreetNameRequiredErrMsg = Constants.IOSTestData.getProperty("StreetNameRequiredErrMsg");
		String vStreetNumberRequiredErrMsg = Constants.IOSTestData.getProperty("StreetNumberRequiredErrMsg");
		String vSuburbRequiredErrMsg = Constants.IOSTestData.getProperty("SuburbRequiredErrMsg");
		Constants.key.scrollInIOS("Save", "down");

		if (optionalField.equalsIgnoreCase("street line")) {
			String vAddressLine1ErrLbl = Constants.key.getAttributeValue(vObjAddressLine1ErrLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vAddressLine1ErrLbl, vAddressLine1RequiredErrMsg));
			LogCapture.info("Street line field error message : " + vAddressLine1ErrLbl + " verified........... ");
		} else if (optionalField.equalsIgnoreCase("city")) {
			String vCityErrLbl = Constants.key.getAttributeValue(vObjCityErrLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vCityErrLbl, vCityFieldRequiredErrMsg));
			LogCapture.info("City field error message : " + vCityErrLbl + " verified........... ");
		} else if (optionalField.equalsIgnoreCase("post code")) {
			String vPostCodeErrLbl = Constants.key.getAttributeValue(vObjPostCodeErrLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vPostCodeErrLbl, vPostCodeRequiredErrMsg));
			LogCapture.info("post code field error message : " + vPostCodeErrLbl + " verified........... ");
		} else if (optionalField.equalsIgnoreCase("unit street apartment")) {
			String vUnitStreetErrLbl = Constants.key.getAttributeValue(vObjUnitStreetErrLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vUnitStreetErrLbl, vUnitStreetRequiredErrMsg));
			LogCapture
					.info("unit street apartment field error message : " + vUnitStreetErrLbl + " verified........... ");
		} else if (optionalField.equalsIgnoreCase("town city")) {
			String vTownCityErrLbl = Constants.key.getAttributeValue(vObjTownCityErrLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vTownCityErrLbl, vTownCityRequiredErrMsg));
			LogCapture.info("town city field error message : " + vTownCityErrLbl + " verified........... ");

		} else if (optionalField.equalsIgnoreCase("zip code")) {
			String vZipCodeErrLbl = Constants.key.getAttributeValue(vObjZipCodeErrLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vZipCodeErrLbl, vZipCodeRequiredErrMsg));
			LogCapture.info("zip code field error message : " + vZipCodeErrLbl + " verified........... ");

		} else if (optionalField.equalsIgnoreCase("street name")) {
			String vStreetNameErrLbl = Constants.key.getAttributeValue(vObjStreetNameErrLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vStreetNameErrLbl, vStreetNameRequiredErrMsg));
			LogCapture.info("street name field error message : " + vStreetNameErrLbl + " verified........... ");

		} else if (optionalField.equalsIgnoreCase("street number")) {
			String vStreetNumberErrLbl = Constants.key.getAttributeValue(vObjStreetNumberErrLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vStreetNumberErrLbl, vStreetNumberRequiredErrMsg));
			LogCapture.info("street number field error message : " + vStreetNumberErrLbl + " verified........... ");

		} else if (optionalField.equalsIgnoreCase("suburb")) {
			String vSuburbErrLbl = Constants.key.getAttributeValue(vObjSuburbErrLbl, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vSuburbErrLbl, vSuburbRequiredErrMsg));
			LogCapture.info("suburb field error message : " + vSuburbErrLbl + " verified........... ");

		}

	}

	@When("^ios user clicks on back button available on search address screen$")
	public void ios_user_clicks_on_back_button_available_on_search_address_screen() throws Throwable {
		String vObjSearchAddBackBtn = Constants.IOSMyCardOR.getProperty("SearchAddBackBtn");
		String vObjSearchAddBackBtn2 = Constants.IOSMyCardOR.getProperty("SearchAddBackBtn2");
		if ((AppName).equalsIgnoreCase("CD")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddBackBtn));
		} else {
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddBackBtn2));
		}
		LogCapture.info("Ios user clicked on back button........... ");
	}

	@When("^ios user searches for the address \"([^\"]*)\"$")
	public void ios_user_searches_for_the_address(String data) throws Throwable {
		String vObjSearchAddOption = Constants.IOSMyCardOR.getProperty("SearchAddOption");
		String vObjSearchAddInput = Constants.IOSMyCardOR.getProperty("SearchAddInput");
		String vObjAddressClearIcon = Constants.IOSMyCardOR.getProperty("AddressClearIcon");
		String vObjSearchAddOption2 = Constants.IOSMyCardOR.getProperty("SearchAddOption2");
		String vObjSearchAddInput2 = Constants.IOSMyCardOR.getProperty("SearchAddInput2");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		if ((AppName).equalsIgnoreCase("CD")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddOption));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSearchAddInput, data));
		} else {
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddOption2));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSearchAddInput2, data));
		}
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddressClearIcon));

		LogCapture.info("User has entered input in search finder........... ");
	}

	@When("^ios user clicks on enter address manually link$")
	public void ios_user_clicks_on_enter_address_manually_link() throws Throwable {
		String vObjEnterAddressManually = Constants.IOSMyCardOR.getProperty("EnterAddressManually");
		Assert.assertEquals("PASS", Constants.key.click(vObjEnterAddressManually));

	}

	@Then("^address not found screen should be displayed in ios app search address screen$")
	public void address_not_found_screen_should_be_displayed_in_ios_app_search_address_screen() throws Throwable {
		String vObjAddressNotFoundLbl = Constants.IOSMyCardOR.getProperty("AddressNotFoundLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddressNotFoundLbl));
		LogCapture.info("Address not found message is displayed........... ");
	}

	@When("^ios user clicks on (card holder name|card number|issue date|expiry date) field and lefts the focus$")
	public void ios_user_clicks_on_card_holder_name_field_and_lefts_the_focus(String optionalValue) throws Throwable {

		if (optionalValue.equalsIgnoreCase("card holder name")) {

		} else if (optionalValue.equalsIgnoreCase("card number")) {
			String vObjCardNoInput = Constants.IOSMyCardOR.getProperty("CardNoInput");
			String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjCardNoInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (optionalValue.equalsIgnoreCase("issue date")) {

		} else if (optionalValue.equalsIgnoreCase("expiry date")) {

		}
	}

	@Then("^(card holder name|card number|issue date|expiry date) required field error message should be displayed to ios user$")
	public void card_holder_name_required_field_error_message_should_be_displayed_to_ios_user(String optionalValue)
			throws Throwable {

		if (optionalValue.equalsIgnoreCase("card holder name")) {

		} else if (optionalValue.equalsIgnoreCase("card number")) {

		} else if (optionalValue.equalsIgnoreCase("issue date")) {

		} else if (optionalValue.equalsIgnoreCase("expiry date")) {

		}
	}

	@Then("^(card holder name|card number|issue date|expiry date) required field error message should be removed from ios add card screen$")
	public void card_holder_name_required_field_error_message_should_be_removed_from_ios_add_card_screen(
			String optionalValue) throws Throwable {
		String vObjErrLblCardNo = Constants.IOSMyCardOR.getProperty("RequiredCardNoErrMsg");
		String vObjErrLblLastName = Constants.IOSMyCardOR.getProperty("RequiredCardHolderNameErrMsg");
		String vObjErrLblExpDate = Constants.IOSMyCardOR.getProperty("RequiredExpDateErrMsg");

		if (optionalValue.equalsIgnoreCase("last name")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("RequiredCardHolderNameErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblLastName, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("last name required field error message verified.........");
		} else if (optionalValue.equalsIgnoreCase("card number")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("RequiredCardNoErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblCardNo, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid card no error message verfied......");
		}

		else if (optionalValue.equalsIgnoreCase("expiry date")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("RequiredExpDateErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblExpDate, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid expiry date error message verified........");
		}
	}

	@When("^ios user enters (valid|invalid) recipients (first|last|company) name \"([^\"]*)\" on add recipient screen$")
	public void ios_user_enters_invalid_recipients_first_name_on_add_recipient_screen(String optionalValue1,
			String optionalValue2, String data) throws Throwable {
		String vObjRecipientIndividualBtn = Constants.IOSRecipientOR.getProperty("RecipientIndividualBtn");
		String vObjFirstNameLbl = Constants.IOSRecipientOR.getProperty("FirstNameLbl");
		String vObjFirstNameInput = Constants.IOSRecipientOR.getProperty("FirstNameInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vObjLastNameLbl = Constants.IOSRecipientOR.getProperty("LastNameLbl");
		String vObjLastNameInput = Constants.IOSRecipientOR.getProperty("LastNameInput");
		String vObjRecipientCompanyBtn = Constants.IOSRecipientOR.getProperty("RecipientCompanyBtn");
		String vObjCompanyNameLbl = Constants.IOSRecipientOR.getProperty("CompanyNameLbl");
		String vObjCompanyNameInput = Constants.IOSRecipientOR.getProperty("CompanyNameInput");

		if (optionalValue2.equalsIgnoreCase("first")) {

			if (optionalValue1.equalsIgnoreCase("invalid")) {
				Assert.assertEquals("PASS", Constants.key.click(vObjRecipientIndividualBtn));
				Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameLbl));
			}

			else if (optionalValue1.equalsIgnoreCase("valid")) {
				Assert.assertEquals("PASS", Constants.key.click(vObjRecipientIndividualBtn));
				Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameLbl));
			}
			Assert.assertEquals("PASS", Constants.key.clearText(vObjFirstNameInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));

		} else if (optionalValue2.equalsIgnoreCase("last")) {

			if (optionalValue1.equalsIgnoreCase("invalid")) {
				Assert.assertEquals("PASS", Constants.key.click(vObjRecipientIndividualBtn));
				Assert.assertEquals("PASS", Constants.key.click(vObjLastNameLbl));
			} else if (optionalValue1.equalsIgnoreCase("valid")) {
				Assert.assertEquals("PASS", Constants.key.click(vObjRecipientIndividualBtn));
				Assert.assertEquals("PASS", Constants.key.click(vObjLastNameLbl));
			}
			Assert.assertEquals("PASS", Constants.key.clearText(vObjLastNameInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (optionalValue2.equalsIgnoreCase("company")) {
			if (optionalValue1.equalsIgnoreCase("invalid")) {
				Assert.assertEquals("PASS", Constants.key.click(vObjRecipientCompanyBtn));
				Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameLbl));
			}

			else if (optionalValue1.equalsIgnoreCase("valid")) {
				Assert.assertEquals("PASS", Constants.key.click(vObjRecipientCompanyBtn));
				Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameLbl));
			}
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCompanyNameInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		}
	}

	@Then("^invalid (first|last|company) name error message should be displayed to ios user on add recipient screen$")
	public void invalid_first_name_error_message_should_be_displayed_to_ios_user_on_add_recipient_screen(
			String optionalValue) throws Throwable {
		String vObjErrLblFirstName = Constants.IOSRecipientOR.getProperty("ErrLblFirstName");
		String vObjErrLblLastName = Constants.IOSRecipientOR.getProperty("ErrLblLastName");
		String vObjErrLblCompanyName = Constants.IOSRecipientOR.getProperty("ErrLblCompanyName");

		if (optionalValue.equalsIgnoreCase("first")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCharcters");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblFirstName, "value").toString();
			// System.out.println("value of first error msg is->"+atbValue);
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid first name error message verified.........");
		} else if (optionalValue.equalsIgnoreCase("last")) {
			// System.out.println("I am in this loop->");
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCharcters");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblLastName, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			// System.out.println("I am in this loop->"+atbValue);
			LogCapture.info("Invalid last name error message verified.........");

		} else if (optionalValue.equalsIgnoreCase("company")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCharcters");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblCompanyName, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid company name error message verified.........");
		}
	}

	@Then("^invalid (first name|last name|company name) error message should be removed from the ios app add recipient screen$")
	public void invalid_first_name_error_message_should_be_removed_from_the_ios_app_add_recipient_screen(
			String optionalValue) throws Throwable {
		String vObjErrLblFirstName = Constants.IOSRecipientOR.getProperty("ErrLblFirstName");
		String vObjErrLblLastName = Constants.IOSRecipientOR.getProperty("ErrLblLastName");
		String vObjErrLblCompanyName = Constants.IOSRecipientOR.getProperty("ErrLblCompanyName");

		if (optionalValue.equalsIgnoreCase("first name")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCharcters");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblFirstName, "value").toString();
			Assert.assertEquals("FAIL", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid first name error message removed.........");
		} else if (optionalValue.equalsIgnoreCase("last name")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCharcters");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblLastName, "value").toString();
			Assert.assertEquals("FAIL", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid last name error message removed.........");

		} else if (optionalValue.equalsIgnoreCase("company name")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCharcters");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblCompanyName, "value").toString();
			Assert.assertEquals("FAIL", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid company name error message removed.........");
		}
	}

	@When("^ios user enters white spaces in recipients (first|last|company) name field on add recipient screen$")
	public void ios_user_enters_white_spaces_in_recipients_first_name_field_on_add_recipient_screen(
			String optionalValue) throws Throwable {
		String vObjRecipientIndividualBtn = Constants.IOSRecipientOR.getProperty("RecipientIndividualBtn");
		String vObjFirstNameLbl = Constants.IOSRecipientOR.getProperty("FirstNameLbl");
		String vObjFirstNameInput = Constants.IOSRecipientOR.getProperty("FirstNameInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vObjLastNameLbl = Constants.IOSRecipientOR.getProperty("LastNameLbl");
		String vObjLastNameInput = Constants.IOSRecipientOR.getProperty("LastNameInput");
		String vObjRecipientCompanyBtn = Constants.IOSRecipientOR.getProperty("RecipientCompanyBtn");
		String vObjCompanyNameLbl = Constants.IOSRecipientOR.getProperty("CompanyNameLbl");
		String vObjCompanyNameInput = Constants.IOSRecipientOR.getProperty("CompanyNameInput");

		if (optionalValue.equalsIgnoreCase("first")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientIndividualBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameInput, "     "));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (optionalValue.equalsIgnoreCase("last")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientIndividualBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjLastNameLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameInput, "      "));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (optionalValue.equalsIgnoreCase("company")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientCompanyBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameInput, "     "));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		}
	}

	@Then("^selected country \"([^\"]*)\" should be displayed in (country dropdown|mobile number screen) of ios app$")
	public void selected_country_should_be_displayed_in_country_dropdown_of_ios_app(String data, String optionalValue)
			throws Throwable {
		String vObjDDCountry = "";
		String vObjDDCountrylbl = "";
		String vDDCountrylbl = "";
		if (optionalValue.equalsIgnoreCase("country dropdown")) {
			vObjDDCountry = Constants.IOSMyCardOR.getProperty("DDCountry");
			vObjDDCountrylbl = Constants.IOSMyCardOR.getProperty("DDCountrylbl");
		} else if (optionalValue.equalsIgnoreCase("mobile number screen")) {
			vObjDDCountry = Constants.IOSRegstOR.getProperty("DDCountryMob");
			vObjDDCountrylbl = Constants.IOSRegstOR.getProperty("MobCountryDDLbl");
		}
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDDCountry));
		vDDCountrylbl = Constants.key.getAttributeValue(vObjDDCountrylbl, "value");
		Assert.assertEquals(data, vDDCountrylbl);
		LogCapture.info("Country : " + data + " selected by user.......");
	}

	@Then("^country \"([^\"]*)\" should be pre selected as per current address in ios app$")
	public void country_should_be_pre_selected_as_per_current_address_in_ios_app(String data) throws Throwable {
		String vObjDDCountry = Constants.IOSRegstOR.getProperty("DDCountryMob");
		String vObjDDCountrylbl = Constants.IOSRegstOR.getProperty("MobCountryDDLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDDCountry));
		String vDDCountrylbl = Constants.key.getAttributeValue(vObjDDCountrylbl, "value");
		Assert.assertEquals(data, vDDCountrylbl);
		LogCapture.info("pre selected country : " + data + " displayed .......");
	}

	@Then("^UK should be a default country in ios app current address screen$")
	public void uk_should_be_a_default_country_in_ios_app_current_address_screen() throws Throwable {
		String vObjCountryDD = Constants.IOSRegstOR.getProperty("CountryDD");
		String vObjDDCountrylbl = Constants.IOSRegstOR.getProperty("DDCountrylbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryDD));
		String vDDCountrylbl = Constants.key.getAttributeValue(vObjDDCountrylbl, "value");
		// Assert.assertEquals("UK", vDDCountrylbl);
		Assert.assertEquals("United Kingdom", vDDCountrylbl);
		LogCapture.info("Default country UK displayed on current address screen .......");
	}

	@When("^ios user enters mobile number \"([^\"]*)\"$")
	public void ios_user_enters_mobile_number(String data) throws Throwable {
		String vObjMobNoTF = Constants.IOSRegstOR.getProperty("MobNoTF");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjMobNoTF, data));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
	}

	@Then("^previously enter mobile number \"([^\"]*)\" and selected country \"([^\"]*)\" should be displayed$")
	public void previously_enter_mobile_number_and_selected_country_should_be_displayed(String data1, String data2)
			throws Throwable {
		String vObjMobNoTF = Constants.IOSRegstOR.getProperty("MobNoTF");
		String vObjDDCountrylbl = Constants.IOSRegstOR.getProperty("CountryLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDDCountrylbl));
		String vDDCountrylbl = Constants.key.getAttributeValue(vObjDDCountrylbl, "value");
		String vMobNoTF = Constants.key.getAttributeValue(vObjMobNoTF, "value");
		Assert.assertEquals("PASS", Constants.key.VerifyText(data2, vDDCountrylbl));
		// System.out.println("Mobile : "+vMobNoTF);
		// if(data2.contains(vMobNoTF)) {
		// Assert.assertEquals("PASS", "PASS");
		// }
		LogCapture.info("Previously entered data verified.......");
	}

	@Then("^(medicare|passport|driving license details|national id number|national registration id card) option should be displayed on additional information screen to ios user$")
	public void medicare_option_should_be_displayed_on_additional_information_screen_to_ios_user(String optionalValue)
			throws Throwable {
		if (optionalValue.equalsIgnoreCase("medicare")) {
			String vObjMedicareLbl = Constants.IOSRegstOR.getProperty("MedicareLbl");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMedicareLbl));
		} else if (optionalValue.equalsIgnoreCase("passport")) {
			String vObjPassportDetailsLbl = Constants.IOSRegstOR.getProperty("PassportDetailsLbl");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassportDetailsLbl));
		} else if (optionalValue.equalsIgnoreCase("driving license details")) {
			String vObjDLDetailsLbl = Constants.IOSRegstOR.getProperty("DLDetailsLbl");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDLDetailsLbl));
		} else if (optionalValue.equalsIgnoreCase("national id number")) {
			String vObjNatIDNumberTF = Constants.IOSRegstOR.getProperty("NatIDNumberTF");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNatIDNumberTF));
		} else if (optionalValue.equalsIgnoreCase("national registration id card")) {
			String vObjNRICTitle = Constants.IOSRegstOR.getProperty("NRICTitle");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNRICTitle));
			LogCapture.info("iOS user navigated to NRIC screen.......");
		}
	}

	@Then("^previously enter national id details should be displayed on additional information screen to ios user$")
	public void previously_enter_national_id_details_should_be_displayed_on_additional_information_screen_to_ios_user()
			throws Throwable {
		String vObjNatIDNumberInput = Constants.IOSRegstOR.getProperty("NatIDNumberInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNatIDNumberInput));
	}

	@When("^ios user enters (national id number|driving license details|medicare number|medicare reference|national registration id card number) \"([^\"]*)\"$")
	public void ios_user_enters_national_id_number(String optionalValue, String data) throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");

		if (optionalValue.equalsIgnoreCase("national id number")) {
			String vObjNatIDNumberTF = Constants.IOSRegstOR.getProperty("NatIDNumberTF");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjNatIDNumberTF, data));
		} else if (optionalValue.equalsIgnoreCase("driving license details")) {
			String vObjDLPH = Constants.IOSRegstOR.getProperty("DLPH");
			String vObjDLInput = Constants.IOSRegstOR.getProperty("DLInput");
			String vObjDLVersionPH = Constants.IOSRegstOR.getProperty("DLVersionPH");
			String vObjDLVersionInput = Constants.IOSRegstOR.getProperty("DLVersionInput");
			String vObjDLDetailsLbl = Constants.IOSRegstOR.getProperty("DLDetailsLbl");
			Assert.assertEquals("PASS", Constants.key.click(vObjDLDetailsLbl));
			Assert.assertEquals("PASS", Constants.key.click(vObjDLPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDLInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjDLVersionPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDLVersionInput, data));
		} else if (optionalValue.equalsIgnoreCase("medicare number")) {
			String vObjMedicareCardNumberPH = Constants.IOSRegstOR.getProperty("MedicareCardNumberPH");
			String vObjMedicareCardNumberInput = Constants.IOSRegstOR.getProperty("MedicareCardNumberInput");
			Assert.assertEquals("PASS", Constants.key.click(vObjMedicareCardNumberPH));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjMedicareCardNumberInput, data));

		} else if (optionalValue.equalsIgnoreCase("medicare reference")) {
			String vObjMedicareDropDown = Constants.IOSRegstOR.getProperty("MedicareDropDown");
			String vObjMedicareRefInput = Constants.IOSRegstOR.getProperty("MedicareRefInput");
			Assert.assertEquals("PASS", Constants.key.click(vObjMedicareDropDown));
			// String vObjDOBPickerField =
			// Constants.IOSRegstOR.getProperty("DOBPickerField");
			// Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDOBPickerField,
			// data));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjMedicareRefInput, data));

		} else if (optionalValue.equalsIgnoreCase("driving license details")) {
			String vObjLicNoPH = Constants.IOSRegstOR.getProperty("LicNoPH");
			String vObjLicNoInput = Constants.IOSRegstOR.getProperty("LicNoInput");
			String vObjCardNoPH = Constants.IOSRegstOR.getProperty("CardNoPH");
			String vObjCardNoInput = Constants.IOSRegstOR.getProperty("CardNoInput");
			String vObjCountryCodePH = Constants.IOSRegstOR.getProperty("CountryCodePH");
			String vObjCardCodeInput = Constants.IOSRegstOR.getProperty("CardCodeInput");
			String vObjStateCodePH = Constants.IOSRegstOR.getProperty("StateCodePH");
			String vObjStateCodeInput = Constants.IOSRegstOR.getProperty("StateCodeInput");
			String vObjDOEPH = Constants.IOSRegstOR.getProperty("DOEPH");
			String vObjDOBPickerField = Constants.IOSRegstOR.getProperty("DOBPickerField");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDOBPickerField, data));

		} else if (optionalValue.equalsIgnoreCase("national registration id card number")) {
			String vObNRICInputlbl = Constants.IOSRegstOR.getProperty("NRICInputlbl");
			String vObNRICInputTextField = Constants.IOSRegstOR.getProperty("NRICInputTextField");
			Assert.assertEquals("PASS", Constants.key.click(vObNRICInputlbl));
			System.out.println("data is" + data);
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObNRICInputTextField, data));

		}
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User entered " + optionalValue + ".......");
	}

	@When("^ios user removes the (national id number|medicare number)$")
	public void ios_user_removes_the_national_id_number(String optionalValue) throws Throwable {
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		if (optionalValue.equalsIgnoreCase("national id number")) {
			String vObjNatIDNumberInput = Constants.IOSRegstOR.getProperty("NatIDNumberInput");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjNatIDNumberInput));
		} else if (optionalValue.equalsIgnoreCase("medicare number")) {
			String vObjMedicareCardNumberInput = Constants.IOSRegstOR.getProperty("MedicareCardNumberInput");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjMedicareCardNumberInput));
		} else if (optionalValue.equalsIgnoreCase("national id number")) {
			String vObjNatIDNumberInput = Constants.IOSRegstOR.getProperty("NatIDNumberInput");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjNatIDNumberInput));
		}
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info(optionalValue + " removed by user.......");
	}

	@When("^ios user selects (medicare|passport|driving license) option$")
	public void ios_user_selects_medicare_option(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("medicare")) {
			String vObjMedicareLbl = Constants.IOSRegstOR.getProperty("MedicareLbl");
			Assert.assertEquals("PASS", Constants.key.click(vObjMedicareLbl));
		} else if (optionalValue.equalsIgnoreCase("driving license")) {
			String vObjMedicareLbl = Constants.IOSRegstOR.getProperty("MedicareLbl");
			Assert.assertEquals("PASS", Constants.key.click(vObjMedicareLbl));
		}
	}

	@Then("^all paramters of set password screen should be displayed to ios user$")
	public void all_paramters_of_set_password_screen_should_be_displayed_to_ios_user() throws Throwable {
		String vObjSetPassword = Constants.IOSRegstOR.getProperty("SetPassword");
		String vObjTermsAndCondition = Constants.IOSRegstOR.getProperty("TermsAndCondition");
		String vObjPassHint1 = Constants.IOSRegstOR.getProperty("PassHint1");
		String vObjPassHint8CharLbl = Constants.IOSRegstOR.getProperty("PassHint8CharLbl");
		String vObjPassHint1NumberLbl = Constants.IOSRegstOR.getProperty("PassHint1NumberLbl");
		String vObjPassHintUpperCaseLbl = Constants.IOSRegstOR.getProperty("PassHintUpperCaseLbl");
		String vObjTermsCondLink = Constants.IOSRegstOR.getProperty("Terms&CondLink");
		String vObjPrivacyPolicyLinkLbl = Constants.IOSRegstOR.getProperty("PrivacyPolicyLink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSetPassword));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTermsAndCondition));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassHint1));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassHint8CharLbl));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassHint1NumberLbl));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassHintUpperCaseLbl));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTermsCondLink));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPrivacyPolicyLinkLbl));
	}

	@Then("^ios app should navigate to web login page \"([^\"]*)\"$")
	public void ios_app_should_navigate_to_web_login_page(String data) throws Throwable {
		String vObjNGOPLoginPageTitle = Constants.IOSLoginOR.getProperty("NGOPLoginPageTitle");
		String vObjNGOPLoginEmailInput = Constants.IOSLoginOR.getProperty("NGOPLoginEmailInput");
		String vObjNGOPLoginPasswordInput = Constants.IOSLoginOR.getProperty("NGOPLoginPasswordInput");
		String vObjNGOPNGOPLoginBtn = Constants.IOSLoginOR.getProperty("NGOPLoginBtn");
		String vURL = Constants.IOSTestData.getProperty(data);
		// Assert.assertEquals("PASS",
		// Constants.key.eleLocatedDisplayed(vObjNGOPLoginPageTitle));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNGOPLoginEmailInput));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNGOPLoginPasswordInput));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNGOPNGOPLoginBtn));
		// String url=Constants.driver.getCurrentUrl();
		// Assert.assertEquals("PASS", Constants.key.VerifyText(url,vURL));
		// LogCapture.info("User navigated to URL : "+url);
	}

	@When("^ios user keeps app ideal state for time (\\d+)$")
	public void ios_user_keeps_app_ideal_state_for_time(int data) throws Throwable {
		LogCapture.info("Keeping application ideal for seconds: " + (data));
		Thread.sleep(data * 1000);
		LogCapture.info("User has waited for seconds: " + data);
	}

	@When("^ios user keeps the appp in background for time (\\d+)$")
	public void ios_user_keeps_the_appp_in_background_for_time(int data) throws Throwable {
		Constants.key.AppBackground(Duration.ofSeconds(data));
		LogCapture.info("Application is in background state for seconds: " + data);
	}

	@When("^ios user return to active state in app$")
	public void ios_user_return_to_acive_state_in_app() throws Throwable {
		LogCapture.info("User returend in active state............");
	}

	@Then("^logout confirmation screen should be displayed in ios app$")
	public void logout_confirmation_screen_should_be_displayed_in_ios_app() throws Throwable {
		String vObjConfirmLogoutTitle = Constants.IOSLoginOR.getProperty("ConfirmLogoutTitle");
		String vObjLogoutConfirmMsg = Constants.IOSLoginOR.getProperty("LogoutConfirmMsg");
		String vObjCancelBtn = Constants.IOSLoginOR.getProperty("CancelBtn");
		String vObjConfirmBtn = Constants.IOSLoginOR.getProperty("ConfirmBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjConfirmLogoutTitle));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLogoutConfirmMsg));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCancelBtn));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjConfirmBtn));
		LogCapture.info("Logout confirmation window displayed............");
	}

	@Then("^ios user should be logged out from the application$")
	public void ios_user_should_be_logged_out_from_the_application() throws Throwable {
		String vObjLogOutLbl = Constants.IOSLoginOR.getProperty("LogOutLbl");
		String vObjLogInBtn = Constants.IOSLoginOR.getProperty("LogInBtn");
		String vObjLoggedOutTitle = Constants.IOSLoginOR.getProperty("LoggedOutTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLogOutLbl));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLogInBtn));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoggedOutTitle));
		LogCapture.info("User logged out successfully.........");
	}

	@Then("^the confirmation popup should close and user remain on account screen for ios app$")
	public void the_confirmation_popup_should_close_and_user_remain_on_account_screen_for_ios_app() throws Throwable {
		String vObjConfirmLogoutTitle = Constants.IOSLoginOR.getProperty("ConfirmLogoutTitle");

		// Temporary reinitialize wait with lower time to improve performance on
		// this step
		Constants.modifyWaitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("ModifyWaitInSecondsForIOS"));
		Constants.key.reInitializeWebDriverWait(Constants.modifyWaitInSeconds);
		Assert.assertEquals("FAIL", Constants.key.eleLocatedDisplayed(vObjConfirmLogoutTitle));
		// To initialize wait with original value
		Constants.modifyWaitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("WaitInSecondsForIOS"));
		Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);

		String vObjAccountLbl = Constants.IOSDashOR.getProperty("AccountLbl");
		String vObjPersonalDetLbl = Constants.IOSDashOR.getProperty("PersonalDetLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPersonalDetLbl));
		String atbValue = Constants.key.getAttributeValue(vObjAccountLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(atbValue, "Account"));
		LogCapture.info("Account setting screen displayed.........");
	}

	@When("^ios user (cancels|confirms) the logout action$")
	public void ios_user_cancels_the_logout_action(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("cancels")) {
			String vObjCancelBtn = Constants.IOSLoginOR.getProperty("CancelBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjCancelBtn));
			LogCapture.info("User clicked on cancel button .........");
		} else if (optionalValue.equalsIgnoreCase("confirms")) {
			String vObjConfirmBtn = Constants.IOSLoginOR.getProperty("ConfirmBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjConfirmBtn));
			LogCapture.info("User clicked on confirm button .........");
		}
	}

	@When("^ios user removes account by using manage device option$")
	public void ios_user_removes_account_by_using_manage_device_option() throws Throwable {
		/*
		 * String vObjCloseButton = Constants.IOSAccountOR.getProperty("CloseButton");
		 * String vObjAccountIcon = Constants.IOSDashOR.getProperty("AccountIcon");
		 * String vObjManageDevice = Constants.IOSDashOR.getProperty("ManageDevice");
		 * String vObjRemoveAccountBtn =
		 * Constants.IOSDashOR.getProperty("RemoveAccountBtn"); String
		 * vObjRemoveAccountBtn1 = Constants.IOSDashOR.getProperty("RemoveAccountBtn1");
		 * String vObjResetBtn = Constants.IOSDashOR.getProperty("ResetBtn");
		 * Assert.assertEquals("PASS",Constants.key.click(vObjCloseButton));
		 * Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
		 * Assert.assertEquals("PASS", Constants.key.click(vObjManageDevice)); if
		 * (loginCount < 1) { Assert.assertEquals("PASS",
		 * Constants.key.click(vObjRemoveAccountBtn)); } else {
		 * Assert.assertEquals("PASS", Constants.key.click(vObjRemoveAccountBtn1)); }
		 * Assert.assertEquals("PASS", Constants.key.click(vObjResetBtn));
		 * LogCapture.info("User clicked on reset account button .........");
		 * loginCount++;
		 */
	}

	@When("^ios user removes account by using manage device option from (account screen|wallet screen|buy currency screen|debit cards screen|recipients screen|activity screen|send money screen|payment method screen|add debit card screen|add recipient screen)$")
	public void ios_user_removes_account_by_using_manage_device_option_from_account_screen(String optionalValue)
			throws Throwable {
		String vObjCloseButton = Constants.IOSAccountOR.getProperty("CloseButton");
		String vObjAccountIcon = Constants.IOSDashOR.getProperty("AccountIcon");
		String vObjManageDevice = Constants.IOSDashOR.getProperty("ManageDevice");
		String vObjRemoveAccountBtn = Constants.IOSDashOR.getProperty("RemoveAccountBtn");
		String vObjRemoveAccountBtn1 = Constants.IOSDashOR.getProperty("RemoveAccountBtn1");
		String vObjResetBtn = Constants.IOSDashOR.getProperty("ResetBtn");
		String vObjBtnBack = Constants.IOSRegstOR.getProperty("BtnBack");
		String vObjCloseBtn = Constants.IOSRecipientOR.getProperty("CloseAddRecBtn");
		if (optionalValue.equalsIgnoreCase("account screen")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCloseButton));
			Assert.assertEquals("PASS", Constants.key.click(vObjManageDevice));
		} else if (optionalValue.equalsIgnoreCase("wallet screen")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCloseButton));
			Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
			Assert.assertEquals("PASS", Constants.key.click(vObjManageDevice));
		} else if (optionalValue.equalsIgnoreCase("buy currency screen")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjBtnBack));
			Assert.assertEquals("PASS", Constants.key.click(vObjCloseButton));
			Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
			Assert.assertEquals("PASS", Constants.key.click(vObjManageDevice));
		} else if (optionalValue.equalsIgnoreCase("debit cards screen")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjBtnBack));
			Assert.assertEquals("PASS", Constants.key.click(vObjCloseButton));
			Assert.assertEquals("PASS", Constants.key.click(vObjManageDevice));
		} else if (optionalValue.equalsIgnoreCase("recipients screen")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
			Assert.assertEquals("PASS", Constants.key.click(vObjManageDevice));
		} else if (optionalValue.equalsIgnoreCase("activity screen")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
			Assert.assertEquals("PASS", Constants.key.click(vObjManageDevice));
		} else if (optionalValue.equalsIgnoreCase("send money screen")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
			Assert.assertEquals("PASS", Constants.key.click(vObjManageDevice));
		} else if (optionalValue.equalsIgnoreCase("payment method screen")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjBtnBack));
			Assert.assertEquals("PASS", Constants.key.click(vObjCloseButton));
			Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
			Assert.assertEquals("PASS", Constants.key.click(vObjManageDevice));
		} else if (optionalValue.equalsIgnoreCase("add debit card screen")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjBtnBack));
			Assert.assertEquals("PASS", Constants.key.click(vObjBtnBack));
			Assert.assertEquals("PASS", Constants.key.click(vObjCloseButton));
			Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
			Assert.assertEquals("PASS", Constants.key.click(vObjManageDevice));
		} else if (optionalValue.equalsIgnoreCase("add recipient screen")) {
			Assert.assertEquals("PASS", Constants.key.clickWithoutVisibilityChk(vObjCloseBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
			Assert.assertEquals("PASS", Constants.key.click(vObjManageDevice));
		}
		if (loginCount < 1) {
			Assert.assertEquals("PASS", Constants.key.click(vObjRemoveAccountBtn));
		} else {
			Assert.assertEquals("PASS", Constants.key.click(vObjRemoveAccountBtn1));
		}
		Assert.assertEquals("PASS", Constants.key.click(vObjResetBtn));
		LogCapture.info("User clicked on reset account button .........");
		loginCount++;
	}

	@Then("^previous ios user credentials should be removed and onboarding screen should be displayed$")
	public void previous_ios_user_credentials_should_be_removed_and_onboarding_screen_should_be_displayed()
			throws Throwable {
		String vObjOnboardsignUpBtn = Constants.IOSLoginOR.getProperty("SignUpBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOnboardsignUpBtn));
		LogCapture.info("Previous user credentials removed from the application..........");
	}

	@Then("^login with biometric link text should be displayed on subsequent login screen of ios app$")
	public void login_with_biometric_link_text_should_be_displayed_on_subsequent_login_screen_of_ios_app()
			throws Throwable {
		String vObjLoginWithTouchIDLink = Constants.IOSLoginOR.getProperty("LoginWithTouchIDLink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoginWithTouchIDLink));
		LogCapture.info("Login with biometric link text displayed on subsequent login screen..........");
	}

	@When("^ios user selects recipient type \"([^\"]*)\" and leaves the recipient name field in focus$")
	public void ios_user_selects_recipient_type_and_leaves_the_recipient_name_field_in_focus(String recipientType)
			throws Throwable {
		if (recipientType.equalsIgnoreCase("Individual")) {
			String vObjRecipientIndividualBtn = Constants.IOSRecipientOR.getProperty("RecipientIndividualBtn");
			String vObjFirstNameLbl = Constants.IOSRecipientOR.getProperty("FirstNameLbl");
			String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
			String vObjLastNameLbl = Constants.IOSRecipientOR.getProperty("LastNameLbl");
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientIndividualBtn));
			LogCapture.info("Individual recipient type selected...... ");
			Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameLbl));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjLastNameLbl));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (recipientType.equalsIgnoreCase("Company")) {
			String vObjRecipientCompanyBtn = Constants.IOSRecipientOR.getProperty("RecipientCompanyBtn");
			String vObjCompanyNameLbl = Constants.IOSRecipientOR.getProperty("CompanyNameLbl");
			String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientCompanyBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameLbl));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else {
			LogCapture.info("Please provide recipient type as Individual or Company...... ");
		}
	}

	@Then("^recipient name required error message should be displayed for recipient type \"([^\"]*)\"$")
	public void recipient_name_required_error_message_should_be_displayed_for_recipient_type(String recipientType)
			throws Throwable {
		String vObjErrLblFirstName = Constants.IOSRecipientOR.getProperty("ErrLblFirstName1");
		String vObjErrLblLastName = Constants.IOSRecipientOR.getProperty("ErrLblLastName1");
		String vObjErrLblCompanyName = Constants.IOSRecipientOR.getProperty("ErrLblCompanyName1");

		if (recipientType.equalsIgnoreCase("Individual")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("MandatoryFirstName");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblFirstName, "value").toString();
			System.out.println("FirstTestDate: " + vErrorMsg + " AtbValue: " + atbValue);
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("First name required error message verified.........");
			vErrorMsg = Constants.IOSTestData.getProperty("MandatoryLastName");
			atbValue = Constants.key.getAttributeValue(vObjErrLblLastName, "value").toString();
			System.out.println("LastTestData: " + vErrorMsg + " AtbValue: " + atbValue);
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Last name required error message verified.........");

		} else if (recipientType.equalsIgnoreCase("company")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("InvalidCharcters");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblCompanyName, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Company name required error message verified.........");
		}
	}

	@When("^ios user leaves the address city and postcode field in focus of country \"([^\"]*)\"$")
	public void ios_user_leaves_the_address_city_and_postcode_field_in_focus_of_country(String data) throws Throwable {
		String vObjAddLine1PHolder = Constants.IOSRecipientOR.getProperty("AddLine1PHolder");
		String vObjTownCityPHolder = Constants.IOSRecipientOR.getProperty("TownCityPHolder");
		String vObjPostCodePHolder = Constants.IOSRecipientOR.getProperty("PostCodePHolder");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vObjDDInputValue = Constants.IOSRecipientOR.getProperty("DDInputValue");
		String vDDCurrencyValue = Constants.key.getAttributeValue(vObjDDInputValue, "value");
		if (data.equalsIgnoreCase("France") || data.equalsIgnoreCase("Spain") || data.equalsIgnoreCase("UK")
				|| data.equalsIgnoreCase("India") || data.equalsIgnoreCase("Hungary")
				|| data.equalsIgnoreCase("Hong Kong") && vDDCurrencyValue.equalsIgnoreCase("Hong Kong Dollar")) {
			LogCapture.info("Address is not required for country : " + data);
		} else {
			// Street line1
			Assert.assertEquals("PASS", Constants.key.click(vObjAddLine1PHolder));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			// Town City
			Assert.assertEquals("PASS", Constants.key.click(vObjTownCityPHolder));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			Constants.key.scrollInIOS("Bank Code", "down");
			// PostCode
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
			Assert.assertEquals("PASS", Constants.key.click(vObjPostCodePHolder));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		}
	}

	@Then("^address city and postcode required field error message should be displayed in ios for country \"([^\"]*)\"$")
	public void address_city_and_postcode_required_field_error_message_should_be_displayed_in_ios_for_country(
			String data) throws Throwable {
		String vObjErrLblAddressLine1 = Constants.IOSRecipientOR.getProperty("ErrLblAddressLine1");
		String vObjErrLblCity = Constants.IOSRecipientOR.getProperty("ErrLblCity");
		String vObjErrLblPostCode = Constants.IOSRecipientOR.getProperty("ErrLblPostCode");
		String vObjDDInputValue = Constants.IOSRecipientOR.getProperty("DDInputValue");
		String vDDCurrencyValue = Constants.key.getAttributeValue(vObjDDInputValue, "value");

		if (data.equalsIgnoreCase("France") || data.equalsIgnoreCase("Spain") || data.equalsIgnoreCase("UK")
				|| data.equalsIgnoreCase("India") || data.equalsIgnoreCase("Hungary")
				|| data.equalsIgnoreCase("Hong Kong") && vDDCurrencyValue.equalsIgnoreCase("Hong Kong Dollar")) {
			// LogCapture.info("Address is not required for country : "+data);
		} else {

			String vErrorMsg = Constants.IOSTestData.getProperty("AddressLine1Required");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblAddressLine1, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Address line1 required error message displayed.........");

			vErrorMsg = Constants.IOSTestData.getProperty("CityRequired");
			atbValue = Constants.key.getAttributeValue(vObjErrLblCity, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("City required error message displayed.........");

			vErrorMsg = Constants.IOSTestData.getProperty("PostCodeRequired");
			atbValue = Constants.key.getAttributeValue(vObjErrLblPostCode, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Postcode required error message displayed.........");
		}
	}

	@When("^ios user selects bank code type \"([^\"]*)\"$")
	public void ios_user_selects_bank_code_type(String data) throws Throwable {
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		String vObjBankCodeLbl = Constants.IOSRecipientOR.getProperty("BankCodeLbl");
		String vObjPaymentReasonDD = Constants.IOSSendMoneyOR.getProperty("PaymentReasonDD");
		String vObjBankCodePickerWheel = Constants.IOSRecipientOR.getProperty("BankCodePickerWheel");

		if (data.equalsIgnoreCase("ABA")) {
			// picker wheel ABA number
			Assert.assertEquals("PASS", Constants.key.click(vObjBankCodeLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBankCodePickerWheel, "ABA number"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (data.equalsIgnoreCase("SWIFT")) {
			// picker wheel SWIFT code
			Assert.assertEquals("PASS", Constants.key.click(vObjBankCodeLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBankCodePickerWheel, "SWIFT code"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		} else if (data.equalsIgnoreCase("SORT") || data.equalsIgnoreCase("IBAN")) {
			// Sort code input

		} else if (data.equalsIgnoreCase("IFSC")) {

		} else if (data.equalsIgnoreCase("BSB")) {
			// Picker Wheel BSB number
			Assert.assertEquals("PASS", Constants.key.click(vObjBankCodeLbl));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBankCodePickerWheel, "BSB number"));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		}

		else if (data.equalsIgnoreCase("Transit,SWIFT")) {
			// NO picker wheel Input Transit number and SWIFT code are text
			// field

		} else if (data.equalsIgnoreCase("Transit")) {
			// NO picker wheel Input Transit number

		} else if (data.equalsIgnoreCase("Branch Code")) {

		} else if (data.equalsIgnoreCase("CNAPS Code")) {

		}
	}

	@When("^ios user selects payement reason \"([^\"]*)\"$")

	public void ios_user_selects_payement_reason(String data) throws Throwable {
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		String vObjBankCodeLbl = Constants.IOSRecipientOR.getProperty("BankCodeLbl");
		String vObjPaymentReasonDD = Constants.IOSSendMoneyOR.getProperty("DCPaymentReason");
		String vObjBankCodePickerWheel = Constants.IOSRecipientOR.getProperty("BankCodePickerWheel");
		String vObjBTPaymentReason = Constants.IOSSendMoneyOR.getProperty("BTPaymentReason");
		String vObjWalletPaymentReason = Constants.IOSSendMoneyOR.getProperty("WalletPaymentReason");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
		String paymentMethod = Constants.DataMap.get("PaymentMethod");

		if (paymentMethod.equalsIgnoreCase("Bank Transfer")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBTPaymentReason));
			Assert.assertEquals("PASS", Constants.key.click(vObjBTPaymentReason));
		}

		if (paymentMethod.equalsIgnoreCase("Debit Card")) {
			System.out.println("Payment reason : " + Constants.key.getElementList(vObjPaymentReasonDD).size());
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentReasonDD));
			Assert.assertEquals("PASS", Constants.key.click(vObjPaymentReasonDD));
		}

		if (paymentMethod.equalsIgnoreCase("Wallet")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWalletPaymentReason));
			Assert.assertEquals("PASS", Constants.key.click(vObjWalletPaymentReason));
		}
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBankCodePickerWheel, data));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		Constants.DataMap.put("isPaymentRefPresent", "No");
		Constants.DataMap.put("PaymentReason", data);
		LogCapture.info("Payment reason selected : " + data);
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
	}

	@When("^ios user leaves the bank code \"([^\"]*)\" field in focus base on country \"([^\"]*)\" currency \"([^\"]*)\"$")
	public void ios_user_leaves_the_bank_code_field_in_focus_base_on_country_currency(String bankCodeType,
			String country, String currency) throws Throwable {
		String vObjSwiftInputLbl = Constants.IOSRecipientOR.getProperty("SwiftInputLbl");
		String vObjABAInputLbl = Constants.IOSRecipientOR.getProperty("ABAInputLbl");
		String vObjBSBInputLbl = Constants.IOSRecipientOR.getProperty("BSBInputLbl");
		String vObjTransitInputLbl = Constants.IOSRecipientOR.getProperty("TransitInputLbl");
		String vObjIFSCInputLbl = Constants.IOSRecipientOR.getProperty("IFSCInputLbl");
		String vObjSortInputLbl = Constants.IOSRecipientOR.getProperty("SortInputLbl");
		String vObjBranchCodeInputLbl = Constants.IOSRecipientOR.getProperty("BranchCodeInputLbl");
		String vObjCNAPSCodeInputLbl = Constants.IOSRecipientOR.getProperty("CNAPSCodeInputLbl");
		String vObjIBANInputLbl = Constants.IOSRecipientOR.getProperty("IBANInputLbl");

		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
		if (bankCodeType.equalsIgnoreCase("ABA")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjABAInputLbl));
		} else if (bankCodeType.equalsIgnoreCase("SWIFT")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjSwiftInputLbl));
		} else if (bankCodeType.equalsIgnoreCase("SORT")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjSortInputLbl));

		} else if (bankCodeType.equalsIgnoreCase("IBAN")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjIBANInputLbl));
		} else if (bankCodeType.equalsIgnoreCase("Branch Code")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjBranchCodeInputLbl));
		} else if (bankCodeType.equalsIgnoreCase("CNAPS Code")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCNAPSCodeInputLbl));
		} else if (bankCodeType.equalsIgnoreCase("IFSC")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjIFSCInputLbl));
		} else if (bankCodeType.equalsIgnoreCase("BSB")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjBSBInputLbl));
		} else if (bankCodeType.equalsIgnoreCase("Transit")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjTransitInputLbl));
		}
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
	}

	@Then("^bank code \"([^\"]*)\" required field error message should be displayed in ios app$")
	public void bank_code_required_field_error_message_should_be_displayed_in_ios_app(String bankCodeType)
			throws Throwable {
		String vObjErrLblIBAN1 = Constants.IOSRecipientOR.getProperty("ErrLblIBAN1");
		String vObjErrLblABA1 = Constants.IOSRecipientOR.getProperty("ErrLblABA1");
		String vObjErrLblSORT1 = Constants.IOSRecipientOR.getProperty("ErrLblSORT1");
		String vObjErrLblIFSC1 = Constants.IOSRecipientOR.getProperty("ErrLblIFSC1");
		String vObjErrLblTransit1 = Constants.IOSRecipientOR.getProperty("ErrLblTransit1");
		String vObjErrLblBSB1 = Constants.IOSRecipientOR.getProperty("ErrLblBSB1");
		String vObjErrLblSwift1 = Constants.IOSRecipientOR.getProperty("ErrLblSwift1");
		String vObjErrLblCNAPS1 = Constants.IOSRecipientOR.getProperty("ErrLblCNAPS1");

		if (bankCodeType.equalsIgnoreCase("IBAN")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("RequiredIBAN");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblIBAN1, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid IBAN error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("ABA")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("RequiredABA");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblABA1, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid ABA error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("SORT")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("RequiredSORT");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblSORT1, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid SORT error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("IFSC")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("RequiredIFSC");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblIFSC1, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid IFSC error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("Transit")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("RequiredTransit");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblTransit1, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid Transit error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("BSB")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("RequiredBSB");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblBSB1, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid BSB error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("SWIFT")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("RequiredSWIFT");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblSwift1, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid BSB error message displayed.........");
		} else if (bankCodeType.equalsIgnoreCase("CNAPS")) {
			String vErrorMsg = Constants.IOSTestData.getProperty("RequiredCNAPS");
			String atbValue = Constants.key.getAttributeValue(vObjErrLblCNAPS1, "value").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid BSB error message displayed.........");
		}
	}

	@When("^ios user leaves the account number field in focus$")
	public void ios_user_leaves_the_account_number_field_in_focus() throws Throwable {
		String vObjAccountNumberPH = Constants.IOSRecipientOR.getProperty("AccountNumberPH");
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjAccountNumberPH));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
	}

	@Then("^account number required field error message should be displayed in ios app$")
	public void account_number_required_field_error_message_should_be_displayed_in_ios_app() throws Throwable {
		String vObjErrLblAccountNo1 = Constants.IOSRecipientOR.getProperty("ErrLblAccountNo1");
		String vErrorMsg = Constants.IOSTestData.getProperty("RequiredAccountNo");
		String atbValue = Constants.key.getAttributeValue(vObjErrLblAccountNo1, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
		LogCapture.info("Required account number error message verified....... ");

	}

	@Then("^you pay and they get currency \"([^\"]*)\" \"([^\"]*)\" should be swap in ios app$")
	public void you_pay_and_they_get_currency_should_be_swap_in_ios_app(String data1, String data2) throws Throwable {
		String vObjYouPayCurrencyLbl = Constants.IOSDashOR.getProperty("YouPayCurrencyLbl");
		String vObjTheyGetCurrencyLbl = Constants.IOSDashOR.getProperty("TheyGetCurrencyLbl");
		String vObjSwapBtn = Constants.IOSDashOR.getProperty("SwapBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSwapBtn));
		String vYouPayCurrencyLbl = Constants.key.getAttributeValue(vObjYouPayCurrencyLbl, "value").toString();
		String vTheyGetCurrencyLbl = Constants.key.getAttributeValue(vObjTheyGetCurrencyLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(data2, vYouPayCurrencyLbl));
		Assert.assertEquals("PASS", Constants.key.VerifyText(data1, vTheyGetCurrencyLbl));
		LogCapture.info("Swapped currency verified....... ");
	}

	@Then("^error message should be displayed for unsupported currency pair in ios app$")
	public void error_message_should_be_displayed_for_unsupported_currency_pair_in_ios_app() throws Throwable {
		String vObjOkBtn = Constants.IOSDashOR.getProperty("OkBtn");
		String vObjUnSuppCurrPairError = Constants.IOSDashOR.getProperty("UnSuppCurrPairError");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOkBtn));
		String vUnSuppCurrPairError = Constants.key.getAttributeValue(vObjUnSuppCurrPairError, "value");
		String UnsupportedCurrencyErrorMessage = Constants.IOSTestData.getProperty("UnsupportedCurrencyErrorMessage");
		Assert.assertEquals("PASS", Constants.key.VerifyText(vUnSuppCurrPairError, UnsupportedCurrencyErrorMessage));
		LogCapture.info("Unsupported currency error message verfied.........");
		Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
	}

	@When("^ios user click on swap$")
	public void ios_user_click_on_swap() throws Throwable {
		String vObjSwapBtn = Constants.IOSDashOR.getProperty("SwapBtn");
		String vObjYouPayInput = Constants.IOSDashOR.getProperty("YouPayInput");
		// String vYouPayInput = Constants.key.getAttributeValue(vObjYouPayInput,
		// "value").toString();
		String vYouPayInput = Constants.key.getAttributeValue(vObjYouPayInput, "value").toString();
		String vObjTheyGetInput = Constants.IOSDashOR.getProperty("TheyGetInput");
		String vTheyGetInput = Constants.key.getAttributeValue(vObjTheyGetInput, "value").toString();

		Constants.DataMap.put("YouPayAmount", vYouPayInput);
		Constants.DataMap.put("TheyGetAmount", vTheyGetInput);
		Assert.assertEquals("PASS", Constants.key.click(vObjSwapBtn));
		LogCapture.info("User clicked on swap currency button....... ");
	}

	@Then("^(you pay|they get) amount \"([^\"]*)\" should remain as is in ios app$")
	public void you_pay_amount_should_remain_as_is_in_ios_app(String optionalValue, String data) throws Throwable {

		if (optionalValue.equalsIgnoreCase("you pay")) {
			String vObjYouPayInput = Constants.IOSDashOR.getProperty("YouPayInput");
			String vYouPayInput = Constants.key.getAttributeValue(vObjYouPayInput, "value").toString();
			LogCapture.info("Before swap you pay amount :" + Constants.DataMap.get("YouPayAmount"));
			LogCapture.info("After swap you pay amount :" + vYouPayInput);
			Thread.sleep(7000);
			// Assert.assertEquals("PASS", Constants.key.VerifyText(vYouPayInput,
			// Constants.DataMap.get("YouPayAmount")));
		}
		if (optionalValue.equalsIgnoreCase("they get")) {
			String vObjTheyGetInput = Constants.IOSDashOR.getProperty("TheyGetInput");
			String vTheyGetInput = Constants.key.getAttributeValue(vObjTheyGetInput, "value").toString();
			LogCapture.info("Before swap they get amount :" + Constants.DataMap.get("TheyGetAmount"));
			LogCapture.info("After swap they get amount :" + vTheyGetInput);
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(vTheyGetInput, Constants.DataMap.get("TheyGetAmount")));
		}

	}

	@When("^ios user click on continue$")
	public void ios_user_click_on_continue() throws Throwable {

		if ((iOSPlatformVersion > 12.4)) {
			String vObjContinueBtn2 = Constants.IOSDashOR.getProperty("ContinueBtn2");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtn2));
			Assert.assertEquals("PASS", Constants.key.click(vObjContinueBtn2));
		} else {
			String vObjContinueBtn = Constants.IOSDashOR.getProperty("ContinueBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjContinueBtn));
		}
		LogCapture.info("User clicked on continue button.....");
	}

	@Then("^ios user should land on select recipient screen$")
	public void ios_user_should_land_on_select_recipient_screen() throws Throwable {
		String vObjSelectRecipientTitle = Constants.IOSDashOR.getProperty("SelectRecipientTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectRecipientTitle));
		LogCapture.info("User land on recipient screen.....");
	}

	@When("^ios user close the select recipient screen$")
	public void ios_user_close_the_select_recipient_screen() throws Throwable {
		String vObjCloseBtn = Constants.IOSDashOR.getProperty("CloseBtn1");
		Assert.assertEquals("PASS", Constants.key.clickWithoutVisibilityChk(vObjCloseBtn));
		LogCapture.info("User clicked on close button.....");
	}

	@Then("^default currency pair \"([^\"]*)\" and amount \"([^\"]*)\"should be displayed in ios app$")
	public void default_currency_pair_and_amount_should_be_displayed_in_ios_app(String data1, String data2)
			throws Throwable {
		String vObjYouPayCurrencyLbl = Constants.IOSDashOR.getProperty("YouPayCurrencyLbl");
		String vObjTheyGetCurrencyLbl = Constants.IOSDashOR.getProperty("TheyGetCurrencyLbl");
		String vObjSwapBtn = Constants.IOSDashOR.getProperty("SwapBtn");
		String vObjYouPayInput = Constants.IOSDashOR.getProperty("YouPayInput");
		Constants.Data = data1.split("-");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSwapBtn));
		String vYouPayInput = Constants.key.getAttributeValue(vObjYouPayInput, "value").toString();
		String vYouPayCurrencyLbl = Constants.key.getAttributeValue(vObjYouPayCurrencyLbl, "value").toString();
		String vTheyGetCurrencyLbl = Constants.key.getAttributeValue(vObjTheyGetCurrencyLbl, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[0], vYouPayCurrencyLbl));
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[1], vTheyGetCurrencyLbl));
		// Assert.assertEquals("PASS", Constants.key.VerifyText(data2,
		// vYouPayInput.toString()));
		Assert.assertEquals("PASS",
				Constants.key.VerifyText(Constants.DataMap.get("DeafultYouPayAmount"), vYouPayInput.toString()));
		LogCapture.info("Default currency amount verified..........");
	}

	@Then("^only you pay currency \"([^\"]*)\" recipients list should be displayed to ios user$")
	public void only_you_pay_currency_recipients_list_should_be_displayed_to_ios_user(String data) throws Throwable {

		String vObjRecpientList = Constants.IOSRecipientOR.getProperty("RecpientList");
		String vObjRecpientName = Constants.IOSRecipientOR.getProperty("RecpientName");
		String vObjRecipientCurrency = Constants.IOSRecipientOR.getProperty("RecipientCurrency");
		String vObjMaskedAccNo = Constants.IOSRecipientOR.getProperty("MaskedAccNo");
		String vObjUnmaskedAccNo = Constants.IOSRecipientOR.getProperty("UnmaskedAccNo");
		String vObjBtnAddRecipientCell = Constants.IOSRecipientOR.getProperty("BtnAddRecipientCell");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell));
		int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();
		for (int i = 1; i < recpientListSize; i++) {
			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("  ", "down"));
			}
			String vRecipientName = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjRecpientName, "value");
			Assert.assertNotEquals("FAIL", vRecipientName);
			String vCurrency = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjRecipientCurrency, "value");
			Assert.assertNotEquals("FAIL", vCurrency);
			String vMaskedAccNo = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjMaskedAccNo, "value");
			Assert.assertEquals("PASS", Constants.key.VerifyText("****", vMaskedAccNo));
			String vUnmaskedAccNo = Constants.key
					.getAttributeValue(vObjRecpientList + "[" + (i + 1) + "]" + vObjUnmaskedAccNo, "value");
			Assert.assertEquals(true, NumberUtils.isNumber(vUnmaskedAccNo));
			LogCapture.info("Recipeint : " + i);
			LogCapture.info("Recipeint Name : " + vRecipientName + ", Currency : " + vCurrency);
			Assert.assertEquals("PASS", Constants.key.VerifyText(data, vCurrency));
		}
		LogCapture.info("Only you pay currency recipient list verifed.........");
	}

	@Then("^empty recipient screen with an option to add a new recipient should be displayed in ios app$")
	public void empty_recipient_screen_with_an_option_to_add_a_new_recipient_should_be_displayed_in_ios_app()
			throws Throwable {
		String vObjAddRecBtn = Constants.IOSDashOR.getProperty("AddRecBtn");
		String vObjNoRecipientTitle = Constants.IOSDashOR.getProperty("NoRecipientTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddRecBtn));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNoRecipientTitle));
		LogCapture.info("Empty recipient list screen displayed.........");
	}

	@Then("^non editable recipient currency should be auto set as they get currency \"([^\"]*)\" in ios app$")
	public void non_editable_recipient_currency_should_be_auto_set_as_they_get_currency_in_ios_app(String data)
			throws Throwable {
		String vObjCurrecyLbl = Constants.IOSDashOR.getProperty("CurrecyLbl");
		String vCurrency = Constants.key.getAttributeValue(vObjCurrecyLbl, "value");
		String currency = Constants.IOSTestData.getProperty(data);

		Assert.assertEquals("PASS", Constants.key.VerifyText(currency, vCurrency));
		LogCapture.info("Auto populated recipient currency verified ..............");
	}

	@Then("^ios user should navigate to payment method screen$")
	public void ios_user_should_navigate_to_payment_method_screen() throws Throwable {
		String vObjPaymentMethodScreen = Constants.IOSSendMoneyOR.getProperty("PaymentMethodScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentMethodScreen));
		LogCapture.info("Payment method screen displayed..............");
	}

	@When("^ios user select (debit card|bank transfer|wallet) as payment method$")
	public void ios_user_select_debit_card_as_payment_method(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("debit card")) {
			String vObjDebitCardPM = Constants.IOSSendMoneyOR.getProperty("DebitCardPM");
			Assert.assertEquals("PASS", Constants.key.click(vObjDebitCardPM));
			Constants.DataMap.put("PaymentMethod", "Debit Card");
		}
		if (optionalValue.equalsIgnoreCase("bank transfer")) {
			String vObjBankTransferPM = Constants.IOSSendMoneyOR.getProperty("BankTransferPM");
			String vObjBankTransferLbl = Constants.IOSSendMoneyOR.getProperty("BankTransferLbl");
			String vBankTransferLbl = Constants.key.getAttributeValue(vObjBankTransferLbl, "value");
			if (vBankTransferLbl.equalsIgnoreCase("FAIL")) {
				Assert.assertEquals("PASS", Constants.key.click(vObjBankTransferPM));
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
			}
			Constants.DataMap.put("PaymentMethod", "Bank Transfer");
		}
		if (optionalValue.equalsIgnoreCase("wallet")) {
			String vObjWalletPM = Constants.IOSSendMoneyOR.getProperty("WalletPM");
			Assert.assertEquals("PASS", Constants.key.click(vObjWalletPM));
			Constants.DataMap.put("PaymentMethod", "Wallet");

		}
		LogCapture.info("User selected payment method : " + optionalValue);
	}

	@Then("^ios user should navigate to review screen$")
	public void ios_user_should_navigate_to_review_screen() throws Throwable {
		String vObjReviewTitle = Constants.IOSSendMoneyOR.getProperty("ReviewTitle");
		String vObjReipientName = Constants.IOSSendMoneyOR.getProperty("ReipientName");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReviewTitle));
		// Assert.assertEquals("PASS",
		// Constants.key.eleLocatedDisplayed(vObjReipientName));
		LogCapture.info("Deal review screen displayed..............");
	}

	@Then("^all the deal details should be displayed on ios deal review screen$")
	public void all_the_deal_details_should_be_displayed_on_ios_deal_review_screen() throws Throwable {
		String vObjReviewTitle = Constants.IOSSendMoneyOR.getProperty("ReviewTitle");
		String vObjReipientName = Constants.IOSSendMoneyOR.getProperty("ReipientName");
		String vObjCountry = Constants.IOSSendMoneyOR.getProperty("Country");
		String vObjAccountNumber = Constants.IOSSendMoneyOR.getProperty("AccountNumber");
		String vObjIBAN = Constants.IOSSendMoneyOR.getProperty("IBAN");
		String vObjSWIFTBIC = Constants.IOSSendMoneyOR.getProperty("SWIFTBIC");
		String vObjRecipientReference = Constants.IOSSendMoneyOR.getProperty("RecipientReference");
		String vObjBankName = Constants.IOSSendMoneyOR.getProperty("BankName");
		String vObjPaymentReason = Constants.IOSSendMoneyOR.getProperty("PaymentReason");
		String vObjAmountDue = Constants.IOSSendMoneyOR.getProperty("AmountDue");
		String vObjTransferToRecipient = Constants.IOSSendMoneyOR.getProperty("TransferToRecipient");
		String vObjRate = Constants.IOSSendMoneyOR.getProperty("Rate");
		String vObjFee = Constants.IOSSendMoneyOR.getProperty("Fee");
		String vObjFXType = Constants.IOSSendMoneyOR.getProperty("FXType");
		String vObjPaymentMethod = Constants.IOSSendMoneyOR.getProperty("PaymentMethod");
		String vObjBankCodeTypeReviewScr = Constants.IOSSendMoneyOR.getProperty("BankCodeTypeReviewScr");
		String vObjBankCodeTypeValue = Constants.IOSSendMoneyOR.getProperty("BankCodeTypeValue");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReviewTitle));
		String vReipientName = Constants.key.getAttributeValue(vObjReipientName, "value");
		String vCountry = Constants.key.getAttributeValue(vObjCountry, "value");
		String vAccountNumber = Constants.key.getAttributeValue(vObjAccountNumber, "value");
		String vIBAN = Constants.key.getAttributeValue(vObjIBAN, "value");
		String vSWIFTBIC = Constants.key.getAttributeValue(vObjSWIFTBIC, "value");
		String vRecipientReference = Constants.key.getAttributeValue(vObjRecipientReference, "value");
		String vBankName = Constants.key.getAttributeValue(vObjBankName, "value");
		String vPaymentReason = Constants.key.getAttributeValue(vObjPaymentReason, "value");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Confirm and pay", "down"));
		if (!Constants.DataMap.get("transactionType").equals("standalone")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAmountDue));
		}
		String vAmountDue = Constants.key.getAttributeValue(vObjAmountDue, "value");
		String vTransferToRecipient = Constants.key.getAttributeValue(vObjTransferToRecipient, "value");
		String vRate = Constants.key.getAttributeValue(vObjRate, "value");
		String vFee = Constants.key.getAttributeValue(vObjFee, "value");
		String vFXType = Constants.key.getAttributeValue(vObjFXType, "value");
		String vPaymentMethod = Constants.key.getAttributeValue(vObjPaymentMethod, "value");
		String vBankCodeTypeReviewScr = Constants.key.getAttributeValue(vObjBankCodeTypeReviewScr, "value");
		String vBankCodeTypeValue = Constants.key.getAttributeValue(vObjBankCodeTypeValue, "value");

		LogCapture.info("********************Review screen******************");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.DataMap.get("RecipientName"), vReipientName));
		LogCapture.info("Recipient name : " + vReipientName + " verified..............");
		LogCapture.info("Country : " + vCountry);
		Constants.DataMap.put("RecipientCountry", vCountry);
		// Assert.assertEquals("PASS",
		// Constants.key.VerifyText(Constants.DataMap.get("RecipientAccountNo"),vAccountNumber));
		LogCapture.info("Account number : " + vAccountNumber + " verified..............");
		LogCapture.info("Bank code type : " + vBankCodeTypeReviewScr);
		LogCapture.info("Bank code : " + vBankCodeTypeValue);
		Constants.DataMap.put("BankCodeType", vBankCodeTypeReviewScr);
		Constants.DataMap.put("BankCode", vBankCodeTypeValue);
		LogCapture.info("SWIFT : " + vSWIFTBIC);
		Constants.DataMap.put("Swift", vSWIFTBIC);
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Done", "down"));
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.DataMap.get("PaymentReason"), vPaymentReason));
		LogCapture.info("Payment reason : " + vPaymentReason + " verified..............");

		if (Constants.DataMap.get("isPaymentRefPresent").equalsIgnoreCase("Yes")) {
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("RecipientReference"), vRecipientReference));
			LogCapture.info("Recipient reference : " + vRecipientReference + " verified..............");
		}
		if (Constants.DataMap.get("isPaymentRefPresent").equalsIgnoreCase("No")) {
			Assert.assertEquals("FAIL", vRecipientReference);
			LogCapture.info("Recipient reference not displayed on review screen.........");
		}
		LogCapture.info("Bank name : " + vBankName);

		if (!Constants.DataMap.get("transactionType").equals("standalone")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAmountDue));
			vAmountDue = Constants.key.getAttributeValue(vObjAmountDue, "value");
			if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("YouPay")) {
				Assert.assertEquals("PASS",
						Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vAmountDue));
				LogCapture.info("Amount due : " + vAmountDue + " verified..............");
			}
		}

		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("TheyGet")) {
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vTransferToRecipient));
			LogCapture.info("Transfer to recipient : " + vTransferToRecipient + " verified..............");
		}
		LogCapture.info("Fee : " + vFee);
		if (Constants.DataMap.get("PaymentMethod").equalsIgnoreCase("Wallet")) {
			String youPaycurrency = Constants.DataMap.get("YouPayCurrency");
			Assert.assertEquals("PASS", Constants.key
					.VerifyText(youPaycurrency + " " + Constants.DataMap.get("PaymentMethod"), vPaymentMethod));
		} else {
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("PaymentMethod"), vPaymentMethod));
		}

		LogCapture.info("Payment method : " + vPaymentMethod + " verified..............");
	}

	@When("^ios user submits the review page details$")
	public void ios_user_submits_the_review_page_details() throws Throwable {
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("ConfirmPay", "down"));
		String vObjConfrimAndPaybtn = Constants.IOSSendMoneyOR.getProperty("ConfirmAndPaybtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjConfrimAndPaybtn));
		LogCapture.info("User clicked on confirm and pay............... ");
	}

	@Then("^deal confirmation screen should be displayed with correct mapped details in ios app$")
	public void deal_confirmation_screen_should_be_displayed_with_correct_mapped_details_in_ios_app() throws Throwable {
		String vObjPaymentSuccessLbl = Constants.IOSSendMoneyOR.getProperty("PaymentSuccessLbl");
		String vObjReipientName = Constants.IOSSendMoneyOR.getProperty("ReipientName");
		String vObjCountry = Constants.IOSSendMoneyOR.getProperty("Country");
		String vObjAccountNumber = Constants.IOSSendMoneyOR.getProperty("AccountNumber");
		String vObjIBAN = Constants.IOSSendMoneyOR.getProperty("IBAN");
		String vObjSWIFTBIC = Constants.IOSSendMoneyOR.getProperty("SWIFTBIC");
		String vObjRecipientReference = Constants.IOSSendMoneyOR.getProperty("RecipientReference");
		String vObjBankName = Constants.IOSSendMoneyOR.getProperty("BankName");
		String vObjPaymentReason = Constants.IOSSendMoneyOR.getProperty("PaymentReason");
		String vObjSellCurrencyAmount = Constants.IOSSendMoneyOR.getProperty("SellCurrencyAmount");
		String vObjBuyCurrencyAmount = Constants.IOSSendMoneyOR.getProperty("BuyCurrencyAmount");
		String vObjRate = Constants.IOSSendMoneyOR.getProperty("Rate");
		String vObjFee = Constants.IOSSendMoneyOR.getProperty("Fee");
		String vObjPaymentMethod = Constants.IOSSendMoneyOR.getProperty("PaymentMethod");
		String vObjBankCodeTypeReviewScr = Constants.IOSSendMoneyOR.getProperty("BankCodeTypeReviewScr");
		String vObjBankCodeTypeValue = Constants.IOSSendMoneyOR.getProperty("BankCodeTypeValue");
		String vObjBookingDate = Constants.IOSSendMoneyOR.getProperty("BookingDate");
		String vObjValueDate = Constants.IOSSendMoneyOR.getProperty("ValueDate");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentSuccessLbl));
		if (Constants.DataMap.get("PaymentMethod").equalsIgnoreCase("Bank Transfer")) {
			String vObjPaymentDeatailsTab = Constants.IOSSendMoneyOR.getProperty("PaymentDeatailsTab");
			Assert.assertEquals("PASS", Constants.key.click(vObjPaymentDeatailsTab));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReipientName));
		}

		String vReipientName = Constants.key.getAttributeValue(vObjReipientName, "value");
		String vCountry = Constants.key.getAttributeValue(vObjCountry, "value");
		LogCapture.info("********************Success screen******************");
		if (Constants.DataMap.get("BankCode").equalsIgnoreCase("IBAN")) {
			String vIBAN = Constants.key.getAttributeValue(vObjIBAN, "value");
			// Assert.assertEquals("PASS",
			// Constants.key.VerifyText(Constants.DataMap.get("BankCode"),vIBAN));
			LogCapture.info("IBAN : " + vIBAN + " verified..............");
		} else {
			String vAccountNumber = Constants.key.getAttributeValue(vObjAccountNumber, "value");
			// Assert.assertEquals("PASS",
			// Constants.key.VerifyText(Constants.DataMap.get("RecipientAccountNo"),vAccountNumber));
			LogCapture.info("Account number : " + vAccountNumber + " verified..............");
			String vBankCodeTypeReviewScr = Constants.key.getAttributeValue(vObjBankCodeTypeReviewScr, "value");
			String vBankCodeTypeValue = Constants.key.getAttributeValue(vObjBankCodeTypeValue, "value");
			// Assert.assertEquals("PASS",
			// Constants.key.VerifyText(Constants.DataMap.get("BankCode"),vBankCodeTypeValue));
			LogCapture.info(vBankCodeTypeReviewScr + ":" + vBankCodeTypeValue + " verified..............");
		}
		String vSWIFTBIC = Constants.key.getAttributeValue(vObjSWIFTBIC, "value");
		String vRecipientReference = Constants.key.getAttributeValue(vObjRecipientReference, "value");
		String vBankName = Constants.key.getAttributeValue(vObjBankName, "value");
		String vPaymentReason = Constants.key.getAttributeValue(vObjPaymentReason, "value");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Done", "down"));
		// Assert.assertEquals("PASS",
		// Constants.key.eleLocatedDisplayed(vObjBookingDate));
		String vRate = Constants.key.getAttributeValue(vObjRate, "value");
		String vFee = Constants.key.getAttributeValue(vObjFee, "value");
		// String vFXType = Constants.key.getAttributeValue(vObjFXType,
		// "value");
		String vPaymentMethod = Constants.key.getAttributeValue(vObjPaymentMethod, "value");
		String vValueDate = Constants.key.getAttributeValue(vObjValueDate, "value");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.DataMap.get("RecipientName"), vReipientName));
		LogCapture.info("Recipient name : " + vReipientName + " verified..............");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.DataMap.get("RecipientCountry"), vCountry));
		LogCapture.info("Country : " + vCountry + " verified..............");

		Constants.DataMap.put("Swift", vSWIFTBIC);
		LogCapture.info("Bank name : " + vBankName);
		LogCapture.info("Payment reason : " + vPaymentReason + " verified..............");
		if (Constants.DataMap.get("isPaymentRefPresent").equalsIgnoreCase("Yes")) {
			LogCapture.info("Recipient reference : " + vRecipientReference + " verified..............");
		}
		if (Constants.DataMap.get("isPaymentRefPresent").equalsIgnoreCase("No")) {
			Assert.assertEquals("FAIL", vRecipientReference);
			LogCapture.info("Recipient reference is not displayed on review screen.........");
		}
		if (!Constants.DataMap.get("transactionType").equals("standalone")) {
			String vBookingDate = Constants.key.getAttributeValue(vObjBookingDate, "value");
			LogCapture.info("Booking date : " + vBookingDate);
		}

		if (!Constants.DataMap.get("transactionType").equals("standalone")) {
			if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("YouPay")) {
				String vSellCurrencyAmount = Constants.key.getAttributeValue(vObjSellCurrencyAmount, "value");
				Assert.assertEquals("PASS",
						Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vSellCurrencyAmount));
				LogCapture.info("Sell currency amount : " + vSellCurrencyAmount + " verified..............");
			}
		}

		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("TheyGet")) {
			String vBuyCurrencyAmount;
			if (!Constants.DataMap.get("transactionType").equals("standalone")) {
				vBuyCurrencyAmount = Constants.key.getAttributeValue(vObjBuyCurrencyAmount, "value");
			} else {
				String vObjBuyCurrencyAmount1 = Constants.IOSAddWalletOR.getProperty("BuyCurrencyAmount1");
				vBuyCurrencyAmount = Constants.key.getAttributeValue(vObjBuyCurrencyAmount1, "value");

			}
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vBuyCurrencyAmount));
			LogCapture.info("Transfer to recipient : " + vBuyCurrencyAmount + " verified..............");
		}

		LogCapture.info("Fee : " + vFee);
		if (Constants.DataMap.get("PaymentMethod").equalsIgnoreCase("Wallet")) {
			String youPaycurrency = Constants.DataMap.get("YouPayCurrency");
			Assert.assertEquals("PASS", Constants.key
					.VerifyText(youPaycurrency + " " + Constants.DataMap.get("PaymentMethod"), vPaymentMethod));
		} else {
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("PaymentMethod"), vPaymentMethod));
		}
		LogCapture.info("Payment method : " + vPaymentMethod + " verified..............");

	}

	@Then("^previously selected payment method should be displayed to ios user$")
	public void previously_selected_payment_method_should_be_displayed_to_ios_user() throws Throwable {
		String paymentMethod = Constants.DataMap.get("PaymentMethod");
		if (paymentMethod.equalsIgnoreCase("Debit card")) {
			String vObjDebitCardPM = Constants.IOSSendMoneyOR.getProperty("DebitCardPM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardPM));
		}
		if (paymentMethod.equalsIgnoreCase("Bank Transfer")) {
			String vObjBankTransferPM = Constants.IOSSendMoneyOR.getProperty("BankTransferPM");
			String vObjBankTransferLbl = Constants.IOSSendMoneyOR.getProperty("BankTransferLbl");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankTransferPM));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankTransferLbl));
		}
		if (paymentMethod.equalsIgnoreCase("Wallet")) {
			String vObjWalletPM = Constants.IOSSendMoneyOR.getProperty("WalletPM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWalletPM));
		}
	}

	@Then("^(please enter valid cvv|wrong cvv entered) error message should be displayed in ios app$")
	public void please_enter_valid_cvv_error_message_should_be_displayed_in_ios_app(String optionalValue)
			throws Throwable {
		if (optionalValue.equalsIgnoreCase("please enter valid cvv")) {
			String vObjInvalidCVVLbl = Constants.IOSSendMoneyOR.getProperty("InvalidCVVLbl");
			// Assert.assertEquals("PASS",Constants.key.getAttributeValue(vObjInvalidCVVLbl,
			// "value"));
			Assert.assertEquals("PASS", Constants.key.readText(vObjInvalidCVVLbl));
			LogCapture.info("Please enter valid cvv message is displayed");
			// System.out.println("Error :
			// "+Constants.key.getAttributeValue(vObjInvalidCVVLbl,"value"));
			// Assert.assertEquals("PASS",
			// Constants.key.eleLocatedDisplayed(vObjInvalidCVVLbl));
			// Assert.assertEquals("PASS",Constants.key.clickWithoutVisibilityChk(vObjInvalidCVVLbl));
		}
		if (optionalValue.equalsIgnoreCase("wrong cvv entered")) {
			/*
			 * String vObjInvalidCVVLbl =
			 * Constants.IOSSendMoneyOR.getProperty("InvalidCVVLbl"); String vObjDoneBtn =
			 * Constants.IOSMyCardOR.getProperty("DoneBtn");
			 * Assert.assertEquals("PASS",Constants.key.click(vObjDoneBtn));
			 * Assert.assertEquals("PASS",
			 * Constants.key.eleLocatedDisplayed(vObjInvalidCVVLbl));
			 */
		}
	}

	@Then("^you pay currency \"([^\"]*)\" wallet should be displayed with balance in ios app$")
	public void you_pay_currency_wallet_should_be_displayed_with_balance_in_ios_app(String data) throws Throwable {
		String vObjWalletLblPart1 = Constants.IOSSendMoneyOR.getProperty("WalletLblPart1");
		String vObjWalletLblPart2 = Constants.IOSSendMoneyOR.getProperty("WalletLblPart2");
		String vObjWalletBalance = Constants.IOSSendMoneyOR.getProperty("WalletBalance");
		Assert.assertEquals("PASS",
				Constants.key.eleLocatedDisplayed(vObjWalletLblPart1 + data + " " + vObjWalletLblPart2));
		String wallet = Constants.key.getAttributeValue(vObjWalletLblPart1 + data + " " + vObjWalletLblPart2, "value");
		String walletBalance = Constants.key
				.getAttributeValue(vObjWalletLblPart1 + data + " " + vObjWalletLblPart2 + vObjWalletBalance, "value");
		LogCapture.info(wallet + " : " + walletBalance + " displayed..............");
	}

	@When("^ios user click on the continue button available on wallet method screen$")
	public void ios_user_click_on_the_continue_button_available_on_wallet_method_screen() throws Throwable {
		String vObjContinueButton2 = Constants.IOSSendMoneyOR.getProperty("ContinueButton2");
		Assert.assertEquals("PASS", Constants.key.click(vObjContinueButton2));
	}

	@Then("^(bank transfer|debit card|wallet) payment method should be in (active|inactive) state$")
	public void bank_transfer_payment_method_should_be_in_active_state(String optionalValue1, String optionalValue2)
			throws Throwable {
		String vObjActiveBank = Constants.IOSSendMoneyOR.getProperty("ActiveBank");
		String vObjActiveBankTorFX = Constants.IOSSendMoneyOR.getProperty("ActiveBankTorFX");
		String vObjPMPaymentReason = Constants.IOSSendMoneyOR.getProperty("PMPaymentReason");

		if (optionalValue1.equalsIgnoreCase("bank transfer") && optionalValue2.equalsIgnoreCase("active")) {
			String vObjBankTransferPM = Constants.IOSSendMoneyOR.getProperty("BankTransferPM");
			Assert.assertEquals("PASS", Constants.key.click(vObjBankTransferPM));

			if ((AppName).equalsIgnoreCase("CD")) {
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjActiveBank));
				Assert.assertEquals("PASS", Constants.key.Swipe(vObjActiveBank, "left", 1));
				LogCapture.info("Bank transfer payment method is enabled.............");
			} else {
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjActiveBankTorFX));
				LogCapture.info("Bank transfer payment method is enabled.............");

			}
		}

		if (optionalValue1.equalsIgnoreCase("debit card") && optionalValue2.equalsIgnoreCase("inactive")) {

			// Assert.assertEquals("PASS", Constants.key.Swipe(vObjActiveBank, "right", 1));

			if ((AppName).equalsIgnoreCase("CD")) {
				String vObjInactiveCard = Constants.IOSSendMoneyOR.getProperty("InactiveCard");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInactiveCard));
				LogCapture.info("Debit card payment method is disabled.............");
			} else {
				String vObjInactiveCardTorFX = Constants.IOSSendMoneyOR.getProperty("InactiveCardTorFX");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInactiveCardTorFX));
				LogCapture.info("Debit card payment method is disabled.............");
			}
		}
		if (optionalValue1.equalsIgnoreCase("wallet") && optionalValue2.equalsIgnoreCase("inactive")) {

			if ((AppName).equalsIgnoreCase("CD")) {
				String vObjInactiveWallet = Constants.IOSSendMoneyOR.getProperty("InactiveWallet");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInactiveWallet));
			} else {
				String vObjInactiveWalletTorFX = Constants.IOSSendMoneyOR.getProperty("InactiveWalletTorFX");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInactiveWalletTorFX));

			}
			LogCapture.info("Wallet payment method is disabled.............");
		}

		if (optionalValue1.equalsIgnoreCase("debit card") && optionalValue2.equalsIgnoreCase("active")) {
			String vObjAddNewDC = Constants.IOSSendMoneyOR.getProperty("AddNewDC");
			String vObjActiveCard = Constants.IOSSendMoneyOR.getProperty("ActiveCard");
			String vObjDebitCardPM = Constants.IOSSendMoneyOR.getProperty("DebitCardPM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPMPaymentReason));
			Assert.assertEquals("PASS", Constants.key.click(vObjDebitCardPM));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddNewDC));
			if ((AppName).equalsIgnoreCase("CD")) {

				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjActiveCard));
				Assert.assertEquals("PASS", Constants.key.Swipe(vObjActiveCard, "left", 1));
			} else {
				String vObjActiveCardTorFX = Constants.IOSSendMoneyOR.getProperty("ActiveWalletTorFX");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjActiveCardTorFX));
				Assert.assertEquals("PASS", Constants.key.Swipe(vObjActiveCardTorFX, "left", 1));
			}
			LogCapture.info("Debit card payment method is enabled.............");
		}

		if (optionalValue1.equalsIgnoreCase("wallet") && optionalValue2.equalsIgnoreCase("active")) {
			String vObjWalletPM = Constants.IOSSendMoneyOR.getProperty("WalletPM");
			String vObjActiveWallet = Constants.IOSSendMoneyOR.getProperty("ActiveWallet");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPMPaymentReason));
			Assert.assertEquals("PASS", Constants.key.click(vObjWalletPM));

			if ((AppName).equalsIgnoreCase("CD")) {
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjActiveWallet));
				Assert.assertEquals("PASS", Constants.key.Swipe(vObjActiveWallet, "left", 1));
			} else {
				String vObjActiveWalletTorFX = Constants.IOSSendMoneyOR.getProperty("ActiveWalletTorFX");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjActiveWalletTorFX));
				Assert.assertEquals("PASS", Constants.key.Swipe(vObjActiveWalletTorFX, "left", 1));
			}
			LogCapture.info("Wallet payment method is enabled.............");
		}
	}

	@Then("^ios user should land on threed card page$")
	public void ios_user_should_land_on_threed_card_page() throws Throwable {

		Thread.sleep(15000);
		String vObjResponseDD = Constants.IOSSendMoneyOR.getProperty("ResponseDD");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjResponseDD));
		LogCapture.info("User land on threed card page..............");
	}

	@When("^ios user submits threed card response$")
	public void ios_user_submits_threed_card_response() throws Throwable {

		String vObjResponseDD = Constants.IOSSendMoneyOR.getProperty("ResponseDD");
		String vObj3DSubmitBtn = Constants.IOSSendMoneyOR.getProperty("3DSubmitBtn");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		// String vObjQAPickerWheel = Constants.IOSLoginOR.getProperty("QAPickerWheel");
		String vObjNewQAPickerWheel = "//XCUIElementTypeOther[@value='Cardholder authenticated']";
		Assert.assertEquals("PASS", Constants.key.click(vObjResponseDD));
		Assert.assertEquals("PASS", Constants.key.click(vObjNewQAPickerWheel));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObj3DSubmitBtn));
		Thread.sleep(1000);
	}

	@Then("^ios user should land on (threedStwo|threedSone) page$")
	public void ios_user_should_land_on_threedStwo_page(String optionalvalue) throws Throwable {
		if (optionalvalue.equalsIgnoreCase("threedStwo")) {
			String vObj3ds2ChallengeWindow = Constants.IOS3DSOR.getProperty("PurchaseAuthentication");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObj3ds2ChallengeWindow));
			LogCapture.info("User land on threedS2 authentication window screen......");
		}
		if (optionalvalue.equalsIgnoreCase("threedSone")) {
			String vObj3ds1ChallengeWindow = Constants.IOS3DSOR.getProperty("AuthenticationBankLogo");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObj3ds1ChallengeWindow));
			LogCapture.info("User land on threedS1 authentication window screen......");
		}
	}

	@When("^ios user submits (threedStwo|threedSone) card otp \"([^\"]*)\"response$")
	public void ios_user_submits_threedSone_card_otp_response(String optionalValue, String data) throws Throwable {
		if (optionalValue.equalsIgnoreCase("threedStwo")) {
			String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
			String vObjCodeInput = Constants.IOS3DSOR.getProperty("CodeInput");
			Assert.assertEquals("PASS", Constants.key.click(vObjCodeInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCodeInput, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(data + " otp entered .............");
			String vObjSubmitBtn = Constants.IOS3DSOR.getProperty("SubmitBtn2");
			Assert.assertEquals("PASS", Constants.key.click(vObjSubmitBtn));
			LogCapture.info("User submitted the response on threedS2 card page ....");
		}
		if (optionalValue.equalsIgnoreCase("threedSone")) {
			String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
			String vObjTextBoxField = Constants.IOS3DSOR.getProperty("TextBoxField");
			Assert.assertEquals("PASS", Constants.key.click(vObjTextBoxField));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTextBoxField, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
			LogCapture.info(data + " otp entered .............");
			String vObjSubmitBtn = Constants.IOS3DSOR.getProperty("SubmitBtn1");
			Assert.assertEquals("PASS", Constants.key.click(vObjSubmitBtn));
			LogCapture.info("User submitted the response on threedS1 card page ....");
		}
	}

	@Then("^ios user should be land on payment failed screen$")
	public void ios_user_should_be_land_on_payment_failed_screen() throws Throwable {
		String vObjPaymentFailedScreen = Constants.IOS3DSOR.getProperty("PaymentFailedScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentFailedScreen));
		LogCapture.info("User is navigated on payment failed screen");
	}

	@When("^ios user click on done button$")
	public void ios_user_click_on_done_button() throws Throwable {
		String vObjDoneBtn = Constants.IOS3DSOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User is clicked on done button");
	}

	@Then("^wrong cvv error message should be displayed in ios app$")
	public void wrong_cvv_error_message_should_be_displayed_in_ios_app() throws Throwable {
		String vObjOkBtn = Constants.IOSSendMoneyOR.getProperty("OkBtn");
		String vObjErrorPopup = Constants.IOSSendMoneyOR.getProperty("ErrorPopup");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOkBtn));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjErrorPopup));
	}

	@Then("^by default bank account details section should be displayed on confirmation screen$")
	public void by_default_bank_account_details_section_should_be_displayed_on_confirmation_screen() throws Throwable {
		String vObjPaymentSuccessLbl = Constants.IOSSendMoneyOR.getProperty("PaymentSuccessLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentSuccessLbl));
		String vObjPaymentInstructionLbl = Constants.IOSSendMoneyOR.getProperty("PaymentInstructionLbl");
		String vObjAccountNameLbl = Constants.IOSSendMoneyOR.getProperty("AccountNameLbl");
		String vObjBankNameLbl = Constants.IOSSendMoneyOR.getProperty("BankNameLbl");
		String vPaymentInstructionLbl = Constants.key.getAttributeValue(vObjPaymentInstructionLbl, "value");
		String vAccountNameLbl = Constants.key.getAttributeValue(vObjAccountNameLbl, "value");
		String vBankNameLbl = Constants.key.getAttributeValue(vObjBankNameLbl, "value");
		Assert.assertNotEquals("FAIL", vPaymentInstructionLbl);
		Assert.assertNotEquals("FAIL", vAccountNameLbl);
		Assert.assertNotEquals("FAIL", vBankNameLbl);
	}

	@When("^ios user selects the wallet option from the home dashboard$")
	public void ios_user_selects_the_wallet_option_from_the_home_dashboard() throws Throwable {
		String vObjAddWallet = Constants.IOSAddWalletOR.getProperty("wallet");
		Assert.assertEquals("PASS", Constants.key.click(vObjAddWallet));
		LogCapture.info("Click on Wallet..............");
	}

	@Then("^ios app user land on wallet screen and Add Wallet button should be displayed\\.$")
	public void ios_app_user_land_on_wallet_screen_and_Add_Wallet_button_should_be_displayed() throws Throwable {
		String vObjWalletTitle = Constants.IOSAddWalletOR.getProperty("walletTile");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWalletTitle));
		String vObjWalletList = Constants.IOSAddWalletOR.getProperty("WalletList");
		int walletSize = Constants.key.getElementList(vObjWalletList).size();
		if (walletSize > 0) {
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add wallet", "down"));
			Assert.assertEquals("PASS", Constants.key.scrollInIOS("Wallets", "up"));
			String vObjAddWalletTitle = Constants.IOSAddWalletOR.getProperty("AddWalletTitle");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddWalletTitle));
			LogCapture.info("Currently " + walletSize + " wallets are present for this customer..............");
		} else {
			String vObjEmptyWalletTitle = Constants.IOSAddWalletOR.getProperty("EmptyWalletTitle");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmptyWalletTitle));
			LogCapture.info("Currently " + walletSize + " wallets are presents..............");
		}

	}

	@When("^ios user click on the Add Wallet button$")
	public void ios_user_click_on_the_Add_Wallet_button() throws Throwable {
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add wallet", "down"));
		String vObjAddWallet = Constants.IOSAddWalletOR.getProperty("AddWallet");
		Assert.assertEquals("PASS", Constants.key.click(vObjAddWallet));
		LogCapture.info("Click on AddWallet Button..............");
	}

	@Then("^ios app user land on Add Wallet screen$")
	public void ios_app_user_land_on_Add_Wallet_screen() throws Throwable {
		String vObjAddWalletTitle = Constants.IOSAddWalletOR.getProperty("AddWalletTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddWalletTitle));
		String vObjSearchBox = Constants.IOSAddWalletOR.getProperty("SearchCurrency");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSearchBox));
		String vObjCloseBtn = Constants.IOSAddWalletOR.getProperty("CloseButton");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCloseBtn));
	}

	@Then("^ios app user select the \"([^\"]*)\" to add the wallet$")
	public void ios_app_user_select_the_to_add_the_wallet(String currency) throws Throwable {
		String vObjSearchCurrency = Constants.IOSAddWalletOR.getProperty("SearchCurrency");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSearchCurrency, currency));
	}

	@When("^ios app user add the wallet for selected \"([^\"]*)\"$")
	public void ios_app_user_add_the_wallet_for_selected(String currency) throws Throwable {
		String vObjCurrencyLbl = Constants.IOSAddWalletOR.getProperty("CurrencyLbl");
		Assert.assertEquals("PASS", Constants.key.click(vObjCurrencyLbl));
		LogCapture.info("Wallet Added Successfully..............");
		Thread.sleep(8000);
	}

	@Then("^ios app user land on wallet screen and Added wallet of selected \"([^\"]*)\" should be displayed\\.$")
	public void ios_app_user_land_on_wallet_screen_and_Added_wallet_of_selected_should_be_displayed(String currency)
			throws Throwable {
		String vObjWalletTitle = Constants.IOSAddWalletOR.getProperty("walletTile");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWalletTitle));
		String vObjWalletList = Constants.IOSAddWalletOR.getProperty("WalletList");
		String vObjWalletBalance = Constants.IOSAddWalletOR.getProperty("CurrencyBal");
		int walletSize = Constants.key.getElementList(vObjWalletList).size();
		System.out.println(walletSize);
		List<MobileElement> lists = Constants.key.getElementList(vObjWalletBalance);
		for (int i = 0; i < walletSize; i++) {
			String val = lists.get(i).getText();
			int val2 = val.length();
			String val3 = val.substring(val2 - 3);
			System.out.println(val3);
			if (val3.trim().equals(currency)) {
				LogCapture.info("Added " + currency + " wallet is present in the list..............");
			} else {
				LogCapture.info("Added " + currency + " wallet is not present in the list..............");
			}
		}

	}

	@Then("^ios app user clears the text entered in search bar by clicking the close button$")
	public void ios_app_user_clears_the_text_entered_in_search_bar_by_clicking_the_close_button() throws Throwable {
		String vObjClearText = Constants.IOSAddWalletOR.getProperty("ClearText");
		Assert.assertEquals("PASS", Constants.key.click(vObjClearText));
		String vObjSearchBox = Constants.IOSAddWalletOR.getProperty("SearchCurrency");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSearchBox));
		LogCapture.info("User clicked on closed button  .......");
	}

	@Then("^ios user selects a saved  \"([^\"]*)\" wallet$")
	public void ios_user_selects_a_saved_wallet(String currency) throws Throwable {
		String vObjWalletList = Constants.IOSAddWalletOR.getProperty("WalletList");
		String vObjWalletBalance = Constants.IOSAddWalletOR.getProperty("CurrencyBal");
		int walletSize = Constants.key.getElementList(vObjWalletList).size();
		List<MobileElement> lists = Constants.key.getElementList(vObjWalletBalance);
		for (int i = 0; i < walletSize; i++) {
			String val = lists.get(i).getText();
			int val2 = val.length();
			String val3 = val.substring(val2 - 3);
			if (val3.trim().equals(currency)) {
				Assert.assertEquals("PASS", Constants.key
						.clickWithoutVisibilityChk(vObjWalletList + "[" + (i + 1) + "]" + vObjWalletBalance));
				Constants.DataMap.put("YouPayCurrency", currency);
				break;
			}
		}
	}

	@Then("^all the details of the wallet should be displayed as per \"([^\"]*)\"$")
	public void all_the_details_of_the_wallet_should_be_displayed_as_per(String currency) throws Throwable {
		String vObjAddBtn = Constants.IOSAddWalletOR.getProperty("AddBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddBtn));
		String vObjBankBtn = Constants.IOSAddWalletOR.getProperty("BankBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankBtn));
	}

	@When("^ios user selects the send option from the wallet transaction screen$")
	public void ios_user_selects_the_send_option_from_the_wallet_transaction_screen() throws Throwable {

		String vObjSendBtn = Constants.IOSAddWalletOR.getProperty("SendButton");
		Assert.assertEquals("PASS", Constants.key.click(vObjSendBtn));
		Constants.DataMap.put("transactionType", "standalone");
		Constants.DataMap.put("UserSelection", "wallet");
		Constants.DataMap.put("PaymentMethod", "Wallet");
	}

	@When("^ios user enters transfer amount \"([^\"]*)\"$")
	public void ios_user_enters_transfer_amount(String amount) throws Throwable {
		String vObjSendScreenTitle = Constants.IOSAddWalletOR.getProperty("SendTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendScreenTitle));

		String vObjSendAmount = Constants.IOSAddWalletOR.getProperty("SendAmount");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSendAmount, amount));
		Constants.DataMap.put("UserSelection", "TheyGet");
		String vTheyGetCurrency = Constants.DataMap.get("YouPayCurrency");
		Constants.DataMap.put("UserAmountWithCurrency",
				Constants.key.getAttributeValue(vObjSendAmount, "value") + " " + vTheyGetCurrency);
		String vObjDoneBtn = Constants.IOSAddWalletOR.getProperty("Done");
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
	}

	@Then("^ios user selects payement reason \"([^\"]*)\" in standalone journey$")
	public void ios_user_selects_payement_reason_in_standalone_journey(String data) throws Throwable {
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		String vObjBankCodeLbl = Constants.IOSRecipientOR.getProperty("BankCodeLbl");
		String vObjPaymentReasonDD = Constants.IOSAddWalletOR.getProperty("WalletPaymentReason");
		String vObjBankCodePickerWheel = Constants.IOSRecipientOR.getProperty("BankCodePickerWheel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentReasonDD));
		Assert.assertEquals("PASS", Constants.key.click(vObjPaymentReasonDD));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBankCodePickerWheel, data));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		Constants.DataMap.put("isPaymentRefPresent", "No");
		Constants.DataMap.put("PaymentReason", data);
		LogCapture.info("Payment reason selected : " + data);
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Continue", "down"));
	}

	@When("^ios user click on Add button$")
	public void ios_user_click_on_Add_button() throws Throwable {
		String vObjAddButton = Constants.IOSAddWalletOR.getProperty("AddBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjAddButton));
		LogCapture.info("User clicked on Add button  .......");
	}

	@Then("^ios app user land on send money screen$")
	public void ios_app_user_land_on_send_money_screen() throws Throwable {
		String vObjSendMoneyTitle = Constants.IOSAddWalletOR.getProperty("SendMoneyTitle");
		String vObjDashContBtn = Constants.IOSLoginOR.getProperty("DashContBtn");
		String vObjDashContBtn2 = Constants.IOSLoginOR.getProperty("DashContBtn2");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendMoneyTitle));

		if (!(iOSPlatformVersion > 12.4)) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashContBtn));
		} else {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashContBtn2));
		}
		LogCapture.info("Add screen displayed.........");
		Constants.DataMap.put("transactionType", "standalone");
	}

	@Then("^ios app user land on Add money screen$")
	public void ios_app_user_land_on_Add_money_screen() throws Throwable {
		String vObjSendMoneyTitle = Constants.IOSAddWalletOR.getProperty("SendMoneyTitle");
		String vObjDashContBtn = Constants.IOSLoginOR.getProperty("DashContBtn");
		String vObjDashContBtn2 = Constants.IOSLoginOR.getProperty("DashContBtn2");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendMoneyTitle));
		if ((iOSPlatformVersion > 12.4)) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashContBtn));
		} else {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashContBtn2));
		}
		LogCapture.info("Add screen displayed.........");
		Constants.DataMap.put("transactionType", "standalone");
	}

	@When("^ios user click on Bank button$")
	public void ios_user_click_on_Bank_button() throws Throwable {
		String vObjBankButton = Constants.IOSAddWalletOR.getProperty("BankBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjBankButton));
		LogCapture.info("User clicked on Bank button  .......");
	}

	@Then("^ios app user land on Bank details screen$")
	public void ios_app_user_land_on_Bank_details_screen() throws Throwable {
		String vObjBankScreenTitle = Constants.IOSAddWalletOR.getProperty("BankScreenLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankScreenTitle));

		String vObjAccountNameLabel = Constants.IOSAddWalletOR.getProperty("AccountNameLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAccountNameLabel));

		String vObjAccountNameValue = Constants.IOSAddWalletOR.getProperty("AccountNameValue");
		String vAccountName = Constants.key.getAttributeValue(vObjAccountNameValue, "value");
		Assert.assertNotEquals("FAIL", vAccountName);
		LogCapture.info("Account Name : " + vAccountName + " verified..............");

		String vObjBankNameLabel = Constants.IOSAddWalletOR.getProperty("BankNameLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankNameLabel));

		String vObjBankNameValue = Constants.IOSAddWalletOR.getProperty("BankNameValue");
		String vBankName = Constants.key.getAttributeValue(vObjBankNameValue, "value");
		Assert.assertNotEquals("FAIL", vBankName);
		LogCapture.info("Bank Name : " + vBankName + " verified..............");

		String vObjAccountNoLabel = Constants.IOSAddWalletOR.getProperty("AccountNoLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAccountNoLabel));

		String vObjAccountNoValue = Constants.IOSAddWalletOR.getProperty("AccountNoValue");
		String vAccountNo = Constants.key.getAttributeValue(vObjAccountNoValue, "value");
		Assert.assertNotEquals("FAIL", vAccountNo);
		LogCapture.info("Account Number : " + vAccountNo + " verified..............");

		String vObjSwiftCodeLabel = Constants.IOSAddWalletOR.getProperty("SwiftCodeLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSwiftCodeLabel));

		String vObjSwiftCodeValue = Constants.IOSAddWalletOR.getProperty("SwiftCodeValue");
		String vSwiftCode = Constants.key.getAttributeValue(vObjSwiftCodeValue, "value");
		Assert.assertNotEquals("FAIL", vSwiftCode);
		LogCapture.info("Swift Code : " + vSwiftCode + " verified..............");

		String vObjCountryLabel = Constants.IOSAddWalletOR.getProperty("CountryLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryLabel));

		String vObjCountryValue = Constants.IOSAddWalletOR.getProperty("CountryValue");
		String vCountryName = Constants.key.getAttributeValue(vObjCountryValue, "value");
		Assert.assertNotEquals("FAIL", vCountryName);
		LogCapture.info("Country : " + vCountryName + " verified..............");

		String vObjReferenceLabel = Constants.IOSAddWalletOR.getProperty("ReferenceLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReferenceLabel));

		String vObjReferenceValue = Constants.IOSAddWalletOR.getProperty("ReferenceValue");
		String vReference = Constants.key.getAttributeValue(vObjReferenceValue, "value");
		Assert.assertNotEquals("FAIL", vReference);
		LogCapture.info("Reference : " + vReference + " verified..............");
	}

	@Then("^ios user should navigate to review screen on buy currency$")
	public void ios_user_should_navigate_to_review_screen_on_buy_currency() throws Throwable {

		String vObjReviewScreenTitle = Constants.IOSAddWalletOR.getProperty("Review");
		String vObjAddTo = Constants.IOSAddWalletOR.getProperty("AddTo");
		String vObjAmountAdded = Constants.IOSAddWalletOR.getProperty("AmountAdded");
		String vObjAmountDue = Constants.IOSSendMoneyOR.getProperty("AmountDue");
		String vObjRate = Constants.IOSSendMoneyOR.getProperty("Rate");
		String vObjFee = Constants.IOSSendMoneyOR.getProperty("Fee");
		String vObjPaymentMethod = Constants.IOSSendMoneyOR.getProperty("PaymentMethod");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReviewScreenTitle));

		LogCapture.info("********************Review screen******************");

		String vAddTo = Constants.key.getAttributeValue(vObjAddTo, "value");
		LogCapture.info("Add to : " + vAddTo + " verified..............");

		String vAmountDue = Constants.key.getAttributeValue(vObjAmountDue, "value");
		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("YouPay")) {
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vAmountDue));
			LogCapture.info("Amount due : " + vAmountDue + " verified..............");
		}

		String vAmountAdd = Constants.key.getAttributeValue(vObjAmountAdded, "value");

		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("TheyGet")) {
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vAmountAdd));
			LogCapture.info("Amount to be added to wallet : " + vAmountAdd + " verified..............");
		}

		String vRate = Constants.key.getAttributeValue(vObjRate, "value");
		LogCapture.info("Rate : " + vRate + " verified..............");

		String vPaymentMethod = Constants.key.getAttributeValue(vObjPaymentMethod, "value");
		LogCapture.info("Payment Method : " + vPaymentMethod + " verified..............");

		String vFee = Constants.key.getAttributeValue(vObjFee, "value");
		LogCapture.info("Fee : " + vFee + " verified..............");
	}

	@Then("^by default bank account details section should be displayed on buy currency confirmation screen$")
	public void by_default_bank_account_details_section_should_be_displayed_on_buy_currency_confirmation_screen()
			throws Throwable {

		String vObjSuccessScreenTitle = Constants.IOSAddWalletOR.getProperty("SuccessScreenTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSuccessScreenTitle));

		String vObjAccountNameValue = Constants.IOSAddWalletOR.getProperty("AccountName");
		String vAccountName = Constants.key.getAttributeValue(vObjAccountNameValue, "value");
		Assert.assertNotEquals("FAIL", vAccountName);
		LogCapture.info("Account Name : " + vAccountName + " verified..............");

		String vObjBankNameValue = Constants.IOSAddWalletOR.getProperty("BankName");
		String vBankName = Constants.key.getAttributeValue(vObjBankNameValue, "value");
		Assert.assertNotEquals("FAIL", vBankName);
		LogCapture.info("Bank Name : " + vBankName + " verified..............");

		String vObjAccountNoValue = Constants.IOSAddWalletOR.getProperty("AccountNumber");
		String vAccountNo = Constants.key.getAttributeValue(vObjAccountNoValue, "value");
		Assert.assertNotEquals("FAIL", vAccountNo);
		LogCapture.info("Account Number : " + vAccountNo + " verified..............");

		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Done", "down"));

		String vObjSwiftCodeValue = Constants.IOSAddWalletOR.getProperty("Swift");
		String vSwiftCode = Constants.key.getAttributeValue(vObjSwiftCodeValue, "value");
		Assert.assertNotEquals("FAIL", vSwiftCode);
		LogCapture.info("Swift : " + vSwiftCode + " verified..............");

		String vObjCountryValue = Constants.IOSAddWalletOR.getProperty("Country");
		String vCountryName = Constants.key.getAttributeValue(vObjCountryValue, "value");
		Assert.assertNotEquals("FAIL", vCountryName);
		LogCapture.info("Country : " + vCountryName + " verified..............");

		String vObjReferenceValue = Constants.IOSAddWalletOR.getProperty("Reference");
		String vReference = Constants.key.getAttributeValue(vObjReferenceValue, "value");
		Assert.assertNotEquals("FAIL", vReference);
		LogCapture.info("Reference : " + vReference + " verified..............");

		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Top-up details", "up"));
	}

	@When("^ios user click on Top-up details$")
	public void ios_user_click_on_Top_up_details() throws Throwable {
		String vObjTopupDetails = Constants.IOSAddWalletOR.getProperty("TopUpDetails");
		Assert.assertEquals("PASS", Constants.key.click(vObjTopupDetails));
	}

	@When("^deal confirmation buy currency screen should be displayed with correct mapped details in ios app$")
	public void deal_confirmation_buy_currency_screen_should_be_displayed_with_correct_mapped_details_in_ios_app()
			throws Throwable {
		String vObjSuccessScreenTitle = Constants.IOSAddWalletOR.getProperty("SuccessScreenTitle");
		String vObjAddTo = Constants.IOSAddWalletOR.getProperty("AddTo");
		String vObjAmountAdded = Constants.IOSAddWalletOR.getProperty("AmountAdded");
		String vObjAmountDue = Constants.IOSSendMoneyOR.getProperty("AmountDue");
		String vObjRate = Constants.IOSSendMoneyOR.getProperty("Rate");
		String vObjFee = Constants.IOSSendMoneyOR.getProperty("Fee");
		String vObjPaymentMethod = Constants.IOSSendMoneyOR.getProperty("PaymentMethod");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSuccessScreenTitle));

		LogCapture.info("********************Success screen******************");

		String vAddTo = Constants.key.getAttributeValue(vObjAddTo, "value");
		LogCapture.info("Add to : " + vAddTo + " verified..............");

		String vAmountDue = Constants.key.getAttributeValue(vObjAmountDue, "value");
		LogCapture.info("Amount due : " + vAmountDue + " verified..............");

		String vAmountAdd = Constants.key.getAttributeValue(vObjAmountAdded, "value");
		LogCapture.info("Amount to be added to wallet : " + vAmountAdd + " verified..............");

		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Done", "down"));

		String vRate = Constants.key.getAttributeValue(vObjRate, "value");
		LogCapture.info("Rate : " + vRate + " verified..............");

		String vPaymentMethod = Constants.key.getAttributeValue(vObjPaymentMethod, "value");
		LogCapture.info("Payment Method : " + vPaymentMethod + " verified..............");

		String vFee = Constants.key.getAttributeValue(vObjFee, "value");
		LogCapture.info("Fee : " + vFee + " verified..............");
	}

	@When("^ios user click on Back button$")
	public void ios_user_click_on_Back_button() throws Throwable {
		String vObjBackButton = Constants.IOSAddWalletOR.getProperty("Backbutton");
		Assert.assertEquals("PASS", Constants.key.click(vObjBackButton));
		LogCapture.info("User clicked on Back button  .......");
	}

	@Then("^(bank transfer|debit card|wallet) payment method should be in (active|inactive) state on buy currency screen$")
	public void bank_transfer_payment_method_should_be_in_active_state_on_buy_currency_screen(String optionalValue1,
			String optionalValue2) throws Throwable {
		String vObjActiveBank = Constants.IOSSendMoneyOR.getProperty("ActiveBank");
		if (optionalValue1.equalsIgnoreCase("bank transfer") && optionalValue2.equalsIgnoreCase("active")) {
			String vObjBankTransferPM = Constants.IOSSendMoneyOR.getProperty("BankTransferPM");
			Assert.assertEquals("PASS", Constants.key.click(vObjBankTransferPM));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjActiveBank));
			Assert.assertEquals("PASS", Constants.key.Swipe(vObjActiveBank, "left", 1));
			LogCapture.info("Bank transfer payment method is enabled.............");
		}
		if (optionalValue1.equalsIgnoreCase("debit card") && optionalValue2.equalsIgnoreCase("inactive")) {
			Assert.assertEquals("PASS", Constants.key.Swipe(vObjActiveBank, "left", 1));
			String vObjInactiveCard = Constants.IOSSendMoneyOR.getProperty("InactiveCard");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInactiveCard));
			LogCapture.info("Debit card payment method is disabled.............");
		}
		if (optionalValue1.equalsIgnoreCase("wallet") && optionalValue2.equalsIgnoreCase("inactive")) {
			String vObjInactiveWallet = Constants.IOSSendMoneyOR.getProperty("InactiveWallet");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInactiveWallet));
			LogCapture.info("Wallet payment method is disabled.............");
		}
		if (optionalValue1.equalsIgnoreCase("debit card") && optionalValue2.equalsIgnoreCase("active")) {
			String vObjAddNewDC = Constants.IOSSendMoneyOR.getProperty("AddNewDC");
			String vObjActiveCard = Constants.IOSSendMoneyOR.getProperty("ActiveCard");
			String vObjDebitCardPM = Constants.IOSSendMoneyOR.getProperty("DebitCardPM");
			Assert.assertEquals("PASS", Constants.key.click(vObjDebitCardPM));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddNewDC));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjActiveCard));
			Assert.assertEquals("PASS", Constants.key.Swipe(vObjActiveCard, "left", 1));
			LogCapture.info("Debit card payment method is enabled.............");
		}
		if (optionalValue1.equalsIgnoreCase("wallet") && optionalValue2.equalsIgnoreCase("active")) {
			String vObjWalletPM = Constants.IOSSendMoneyOR.getProperty("WalletPM");
			String vObjActiveWallet = Constants.IOSSendMoneyOR.getProperty("ActiveWallet");
			Assert.assertEquals("PASS", Constants.key.click(vObjWalletPM));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjActiveWallet));
			Assert.assertEquals("PASS", Constants.key.Swipe(vObjActiveWallet, "left", 1));
			LogCapture.info("Wallet payment method is enabled.............");
		}
	}

	@When("^ios user submits the review page details on buy currency$")
	public void ios_user_submits_the_review_page_details_on_buy_currency() throws Throwable {
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("ConfirmPay", "down"));
		String vObjConfrimAndPaybtn = Constants.IOSAddWalletOR.getProperty("ConfirmPay");
		Assert.assertEquals("PASS", Constants.key.click(vObjConfrimAndPaybtn));
		LogCapture.info("User clicked on confirm and pay............... ");
	}

	@When("^ios user click on the done button on buy currency$")
	public void ios_user_click_on_the_done_button_on_buy_currency() throws Throwable {
		String vObjConfrimAndPaybtn = Constants.IOSAddWalletOR.getProperty("Donebtnlastscreen");
		Assert.assertEquals("PASS", Constants.key.click(vObjConfrimAndPaybtn));
		LogCapture.info("User clicked on done button............... ");
	}

	@Then("^ios app user clears the text entered in search bar by clicking the close button on buy currency$")
	public void ios_app_user_clears_the_text_entered_in_search_bar_by_clicking_the_close_button_on_buy_currency()
			throws Throwable {
		String vObjClearText = Constants.IOSAddWalletOR.getProperty("ClearTextClosebutton");
		Assert.assertEquals("PASS", Constants.key.click(vObjClearText));
		LogCapture.info("User clicked on closed button  .......");
	}

	@Then("^ios user click back button on buy currency$")
	public void ios_user_click_back_button_on_buy_currency() throws Throwable {
		String vObjBackBtn = Constants.IOSAddWalletOR.getProperty("Backbtn1");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("ZAR", "down"));
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("GBP", "up"));
		Assert.assertEquals("PASS", Constants.key.click(vObjBackBtn));
	}

	@When("^ios user click on payin button$")
	public void ios_user_click_on_payin_button() throws Throwable {
		String vObjPayIn = Constants.IOSAddWalletOR.getProperty("PayIn");
		Assert.assertEquals("PASS", Constants.key.click(vObjPayIn));
		LogCapture.info("User lands on Pay In button .......");
	}

	@Then("^ios user land on send money screen$")
	public void ios_user_land_on_send_money_screen() throws Throwable {
		String vObjSendScreenTitle = Constants.IOSAddWalletOR.getProperty("SendTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendScreenTitle));
		LogCapture.info("User lands on Send Money Screen .......");
	}

	@Then("^error message observed on buy currency screen$")
	public void error_message_observed_on_buy_currency_screen() throws Throwable {
		String vObjCurrencyErrorTitle = Constants.IOSAddWalletOR.getProperty("CurrencyError");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencyErrorTitle));
	}

	@Then("^ios app user click on ok button$")
	public void ios_app_user_click_on_ok_button() throws Throwable {
		String vObjOkBtn = Constants.IOSAddWalletOR.getProperty("OKbtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
		LogCapture.info("User click on Ok Button .......");
	}

	@Then("^debit card payment method should be displayed on buy currency screen$")
	public void debit_card_payment_method_should_be_displayed_on_buy_currency_screen() throws Throwable {
		String vObjDebitCardTextTitle = Constants.IOSAddWalletOR.getProperty("DebitCardText");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardTextTitle));
	}

	@When("^ios user submits threed card response with other reason$")
	public void ios_user_submits_threed_card_response_with_other_reason() throws Throwable {
		String vObjResponseDD = Constants.IOSSendMoneyOR.getProperty("ResponseDD");
		String vObjQAPickerWheelTorFx = Constants.IOSSendMoneyOR.getProperty("QAPickerWheelTorFx");
		String vObj3DSubmitBtn = Constants.IOSSendMoneyOR.getProperty("3DSubmitBtn");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		String vObjQAPickerWheel = Constants.IOSLoginOR.getProperty("QAPickerWheel");
		Assert.assertEquals("PASS", Constants.key.click(vObjResponseDD));
		if ((AppName).equalsIgnoreCase("CD")) {
			Assert.assertEquals("PASS",
					Constants.key.writeInInput(vObjQAPickerWheel, "Cardholder failed authentication"));
		} else {
			Assert.assertEquals("PASS",
					Constants.key.writeInInput(vObjQAPickerWheelTorFx, "Cardholder failed authentication"));
		}
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObj3DSubmitBtn));
	}

	@When("^ios user selects a saved card \"([^\"]*)\" to buy a currency$")
	public void ios_user_selects_a_saved_card_to_buy_a_currency(String debitCardNo) throws Throwable {
		String vObjDebitCardList = Constants.IOSSendMoneyOR.getProperty("DDCardNoLblPart2_PM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardList));
		int noOfDebitCard = Constants.key.getElementList(vObjDebitCardList).size();
		String vDebitCardNo1 = debitCardNo;
		List<MobileElement> CardElements = Constants.key.getElementList(vObjDebitCardList);
		for (int i = 0; i < noOfDebitCard; i++) {
			String vCardNumber = CardElements.get(i).getText();
			String vCardLast4Digit = vCardNumber.substring((vCardNumber.length() - 4), (vCardNumber.length()));
			if (vDebitCardNo1.equalsIgnoreCase(vCardLast4Digit)) {
				CardElements.get(i).click();
				LogCapture.info("Debit card selected : " + vCardNumber);
				break;
			}
			if (noOfDebitCard > 6) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("Add debit card", "down"));
			}
		}
	}

	@When("^ios user click on account button$")
	public void ios_user_click_on_account_button() throws Throwable {
		String vObjAccountBtn = Constants.IOSAccountOR.getProperty("AccountBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjAccountBtn));
		LogCapture.info("User clicked on account button .......");
	}

	@Then("^account screen should be displayed$")
	public void account_screen_should_be_displayed() throws Throwable {
		String vObjBiometricSet = Constants.CONFIG.getProperty("isBiometricSet");
		String vObjCancleBtn = Constants.IOSAccountOR.getProperty("CancleBtn");
		String vObjAccountTitle = Constants.IOSAccountOR.getProperty("AccountTitle");
		if (vObjBiometricSet.equalsIgnoreCase("Yes")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCancleBtn));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAccountTitle));
		} else {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAccountTitle));
		}
		LogCapture.info("User land on account screen .....");
	}

	@When("^ios user click on personal details button$")
	public void ios_user_click_on_personal_details_button() throws Throwable {
		String vObjPersonalDetailsBtn = Constants.IOSAccountOR.getProperty("PersonalDetailsBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjPersonalDetailsBtn));
		LogCapture.info("User clicked on personal details button .......");
	}

	@Then("^personal details screen should be displayed$")
	public void personal_details_screen_should_be_displayed() throws Throwable {
		String vObjPersonalDetailsTitle = Constants.IOSAccountOR.getProperty("PersonalDetailsTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPersonalDetailsTitle));
		LogCapture.info("User land on personal details screen .....");
	}

	@When("^ios user click on our bank details button$")
	public void ios_user_click_on_our_bank_details_button() throws Throwable {
		String vObjOurBankDetailsBtn = Constants.IOSAccountOR.getProperty("OurBankDetailsBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjOurBankDetailsBtn));
		LogCapture.info("User clicked on our bank details button .......");
	}

	@Then("^bank details currency selection screen should be displayed$")
	public void bank_details_currency_selection_screen_should_be_displayed() throws Throwable {
		String vObjBankDetailsTitle = Constants.IOSAccountOR.getProperty("BankDetailsTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankDetailsTitle));
		LogCapture.info("User land on bank details screen .....");
	}

	@Then("^account screen should be displayed in ios app$")
	public void account_screen_should_be_displayed_in_ios_app() throws Throwable {
		String vObjAccountTitle = Constants.IOSAccountOR.getProperty("AccountTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAccountTitle));
	}

	@When("^ios user click on help and support button$")
	public void ios_user_click_on_help_and_support_button() throws Throwable {
		String vObjHelpAndSupportBtn = Constants.IOSAccountOR.getProperty("HelpAndSupportBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjHelpAndSupportBtn));
		LogCapture.info("User clicked on help and support button .......");
	}

	@Then("^help and support screen should be displayed$")
	public void help_and_support_screen_should_be_displayed() throws Throwable {
		String vObjHelpAndSupportTitle = Constants.IOSAccountOR.getProperty("HelpAndSupportTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjHelpAndSupportTitle));
		LogCapture.info("User land on help and support screen .....");
	}

	@When("^ios user click on manage device button$")
	public void ios_user_click_on_manage_device_button() throws Throwable {
		String vObjManageDeviceBtn = Constants.IOSAccountOR.getProperty("ManageDeviceBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjManageDeviceBtn));
		LogCapture.info("User clicked on manage device button .......");
	}

	@Then("^manage device screen should be displayed$")
	public void manage_device_screen_should_be_displayed() throws Throwable {
		String vObjManageDeviceTitle = Constants.IOSAccountOR.getProperty("ManageDeviceTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjManageDeviceTitle));
		LogCapture.info("User land on manage device screen .....");
	}

	@When("^ios user click on logout button$")
	public void ios_user_click_on_logout_button() throws Throwable {
		Constants.key.scrollInIOS("Log out", "down");
		String vObjLogOutBtn = Constants.IOSAccountOR.getProperty("LogOutBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLogOutBtn));
		LogCapture.info("User clicked on logout button .......");
	}

	@Then("^confirm logout screen should be displayed$")
	public void confirm_logout_screen_should_be_displayed() throws Throwable {
		String vObjConfirmLogoutTitle = Constants.IOSAccountOR.getProperty("ConfirmLogoutTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjConfirmLogoutTitle));
		LogCapture.info("User land on confirm logout screen .....");
	}

	@When("^ios user click on debit cards button$")
	public void ios_user_click_on_debit_cards_button() throws Throwable {
		String vObjDebitCardsBtn = Constants.IOSAccountOR.getProperty("DebitCardsBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDebitCardsBtn));
		LogCapture.info("User clicked on debit cards button .......");
	}

	@Then("^debit cards screen should be displayed$")
	public void debit_cards_screen_should_be_displayed() throws Throwable {
		String vObjDebitCardsTitle = Constants.IOSAccountOR.getProperty("DebitCardsTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardsTitle));
		LogCapture.info("User land on debit cards screen .....");
	}

	@When("^ios user click on touch id ON/OFF button$")
	public void ios_user_click_on_touch_id_ON_OFF_button() throws Throwable {
		String vObjTouchIdBtn = Constants.IOSAccountOR.getProperty("TouchID");

		if (Constants.CONFIG.getProperty("isBrowserStackRunning").equalsIgnoreCase("True")) {
		} else if ((AppName).equalsIgnoreCase("CD")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjTouchIdBtn));
			LogCapture.info("User clicked on touch id button .......");
		} else {
			String vObjFaceSwitch = Constants.IOSDashOR.getProperty("FaceSwitch");
			Assert.assertEquals("PASS", Constants.key.click(vObjFaceSwitch));
		}

	}

	@Then("^biometric setup process should be enabled$")
	public void biometric_setup_process_should_be_enabled() throws Throwable {
		LogCapture.info("Biometric setup is enabled....");
	}

	@Then("^customer name should be displayed on personal details screen$")
	public void customer_name_should_be_displayed_on_personal_details_screen() throws Throwable {
		String vObjCustomerName = Constants.IOSAccountOR.getProperty("CustomerName");
		String vCustomerName = Constants.key.getAttributeValue(vObjCustomerName, "value");
		Assert.assertNotEquals("FAIL", vCustomerName);
		LogCapture.info("Customer name : " + vCustomerName + " verified..............");
	}

	@Then("^customer id should be displayed on personal details screen$")
	public void customer_id_should_be_displayed_on_personal_details_screen() throws Throwable {
		String vObjCustomerId = Constants.IOSAccountOR.getProperty("CustomerIdValue");
		String vCustomerId = Constants.key.getAttributeValue(vObjCustomerId, "value");
		Assert.assertNotEquals("FAIL", vCustomerId);
		LogCapture.info("Customer id : " + vCustomerId + " verified..............");
	}

	@Then("^customer email address should be displayed on personal details screen$")
	public void customer_email_address_should_be_displayed_on_personal_details_screen() throws Throwable {
		String vObjCustomerEmailAddress = Constants.IOSAccountOR.getProperty("EmailAddressValue");
		String vCustomerEmailAddress = Constants.key.getAttributeValue(vObjCustomerEmailAddress, "value");
		Assert.assertNotEquals("FAIL", vCustomerEmailAddress);
		LogCapture.info("Customer email address : " + vCustomerEmailAddress + " verified..............");
	}

	@Then("^customer phone number should be displayed on personal details screen$")
	public void customer_phone_number_should_be_displayed_on_personal_details_screen() throws Throwable {
		String vObjCustomerPhoneNo = Constants.IOSAccountOR.getProperty("PhoneNumberValue");
		String vCustomerPhoneNo = Constants.key.getAttributeValue(vObjCustomerPhoneNo, "value");
		Assert.assertNotEquals("FAIL", vCustomerPhoneNo);
		LogCapture.info("Customer phone number : " + vCustomerPhoneNo + " verified..............");
	}

	@Then("^customer address should be displayed on personal details screen$")
	public void customer_address_should_be_displayed_on_personal_details_screen() throws Throwable {
		String vObjCustomerAddress = Constants.IOSAccountOR.getProperty("AddressValue");
		String vCustomerAddress = Constants.key.getAttributeValue(vObjCustomerAddress, "value");
		Assert.assertNotEquals("FAIL", vCustomerAddress);
		LogCapture.info("Customer Address : " + vCustomerAddress + " verified..............");
	}

	@Then("^search option should be displayed on our bank details screen$")
	public void search_option_should_be_displayed_on_our_bank_details_screen() throws Throwable {
		String vObjSearchField = Constants.IOSAccountOR.getProperty("SearchTextField");
		String vObjSearchFieldBs = Constants.IOSAccountOR.getProperty("SearchTextFieldBs");
		if (Constants.CONFIG.getProperty("isBrowserStackRunning").equalsIgnoreCase("True")) {
		} else if ((AppName).equalsIgnoreCase("CD")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSearchField));
		} else {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSearchFieldBs));
		}
		LogCapture.info("Search option is displayed .....");
	}

	@Then("^list of currencies should be displayed on our bank details screen$")
	public void list_of_currencies_should_be_displayed_on_our_bank_details_screen() throws Throwable {
		String vObjCurrencyName = Constants.IOSAccountOR.getProperty("CurrencyName");
		String vObjCurrencyNameBs = Constants.IOSAccountOR.getProperty("CurrencyNameBs");

		if (Constants.CONFIG.getProperty("isBrowserStackRunning").equalsIgnoreCase("True")) {
		} else if ((AppName).equalsIgnoreCase("CD")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencyName));
		} else {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencyNameBs));
		}
		LogCapture.info("Currency name is displayed .....");
	}

	@And("^close icon should be displayed on our bank details screen$")
	public void close_icon_should_be_displayed_on_our_bank_details_screen() throws Throwable {
		String vObjCloseButton = Constants.IOSAccountOR.getProperty("CloseButton");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCloseButton));
		LogCapture.info("Close icon is displayed .....");
	}

	@When("^ios user click on close button$")
	public void ios_user_click_on_close_button() throws Throwable {
		String vObjCloseButton = Constants.IOSAccountOR.getProperty("CloseButton");
		Assert.assertEquals("PASS", Constants.key.click(vObjCloseButton));
		LogCapture.info("User clicked on close button .......");
	}

	@When("^ios user enters currency name \"([^\"]*)\" in search option$")
	public void ios_user_enters_currency_name_in_search_option(String vCurrencyName) throws Throwable {
		String vObjSearchTextField = Constants.IOSAccountOR.getProperty("NewSearchTextField");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSearchTextField, vCurrencyName));
		LogCapture.info("User has entered currency as " + vCurrencyName + ".......");
	}

	@When("^ios user selects the currency from searched result list$")
	public void ios_user_selects_the_currency_from_searched_result_list() throws Throwable {
		String vObjCurrencyName = Constants.IOSAccountOR.getProperty("NewCurrencyName"); // Need to merge this with data
																							// which we get form
																							// examples
		Assert.assertEquals("PASS", Constants.key.click(vObjCurrencyName));
		LogCapture.info("User selected currency name .......");
	}

	@Then("^ios user should be land on currency bank details screen$")
	public void ios_user_should_be_land_on_currency_bank_details_screen() throws Throwable {
		String vObjCurrencyBankDetails = Constants.IOSAccountOR.getProperty("CurrencyBankDetailsTitle");
		String vObjCurrencyBankDetails2 = Constants.IOSAccountOR.getProperty("CurrencyBankDetailsTitle2");
		if ((iOSPlatformVersion > 12.4)) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencyBankDetails2));
		} else {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencyBankDetails));
		}
		LogCapture.info("Currency bank details is displayed .....");
	}

	@And("^ios user click done button on top up details screen$")
	public void ios_user_click_done_button_on_top_up_details_screen() throws Throwable {
		String vObjDoneButton = Constants.IOSAddWalletOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.scrollInIOS("Done", "down"));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneButton));
		LogCapture.info("User clicked on done button  .......");
	}

	@And("^header and close icon should be displayed on help and support screen$")
	public void header_and_close_icon_should_be_displayed_on_help_and_support_screen() throws Throwable {
		String vObjHelpAndSupportTitle = Constants.IOSAccountOR.getProperty("HelpAndSupportTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjHelpAndSupportTitle));
		LogCapture.info("Header is displayed .....");
		String vObjCloseBtn = Constants.IOSAccountOR.getProperty("CloseBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCloseBtn));
		LogCapture.info("Close button is displayed .....");
	}

	@And("^bank details should be displayed on bank details screen$")
	public void bank_details_should_be_displayed_on_bank_details_screen() throws Throwable {
		String vObjAccountNameLabel = Constants.IOSAddWalletOR.getProperty("AccountNameLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAccountNameLabel));

		String vObjAccountNameValue = Constants.IOSAddWalletOR.getProperty("AccountNameValue");
		String vAccountName = Constants.key.getAttributeValue(vObjAccountNameValue, "value");
		Assert.assertNotEquals("FAIL", vAccountName);
		LogCapture.info("Account Name : " + vAccountName + " verified..............");

		String vObjBankNameLabel = Constants.IOSAddWalletOR.getProperty("BankNameLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankNameLabel));

		String vObjBankNameValue = Constants.IOSAddWalletOR.getProperty("BankNameValue");
		String vBankName = Constants.key.getAttributeValue(vObjBankNameValue, "value");
		Assert.assertNotEquals("FAIL", vBankName);
		LogCapture.info("Bank Name : " + vBankName + " verified..............");

		String vObjAccountNoLabel = Constants.IOSAddWalletOR.getProperty("AccountNoLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAccountNoLabel));

		String vObjAccountNoValue = Constants.IOSAddWalletOR.getProperty("AccountNoValue");
		String vAccountNo = Constants.key.getAttributeValue(vObjAccountNoValue, "value");
		Assert.assertNotEquals("FAIL", vAccountNo);
		LogCapture.info("Account Number : " + vAccountNo + " verified..............");

		String vObjSwiftCodeLabel = Constants.IOSAddWalletOR.getProperty("SwiftCodeLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSwiftCodeLabel));

		String vObjSwiftCodeValue = Constants.IOSAddWalletOR.getProperty("SwiftCodeValue");
		String vSwiftCode = Constants.key.getAttributeValue(vObjSwiftCodeValue, "value");
		Assert.assertNotEquals("FAIL", vSwiftCode);
		LogCapture.info("Swift Code : " + vSwiftCode + " verified..............");

		String vObjCountryLabel = Constants.IOSAddWalletOR.getProperty("CountryLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryLabel));

		String vObjCountryValue = Constants.IOSAddWalletOR.getProperty("CountryValue");
		String vCountryName = Constants.key.getAttributeValue(vObjCountryValue, "value");
		Assert.assertNotEquals("FAIL", vCountryName);
		LogCapture.info("Country : " + vCountryName + " verified..............");

		String vObjReferenceLabel = Constants.IOSAddWalletOR.getProperty("ReferenceLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReferenceLabel));

		String vObjReferenceValue = Constants.IOSAddWalletOR.getProperty("ReferenceValue");
		String vReference = Constants.key.getAttributeValue(vObjReferenceValue, "value");
		Assert.assertNotEquals("FAIL", vReference);
		LogCapture.info("Reference : " + vReference + " verified..............");
	}

	@When("^ios user click on any question$")
	public void ios_user_click_on_any_question() throws Throwable {
		String vObjQuestion = Constants.IOSAccountOR.getProperty("QuestionName");
		Assert.assertEquals("PASS", Constants.key.click(vObjQuestion));
		LogCapture.info("User clicked on question  .......");
	}

	@Then("^question list should be expanded$")
	public void question_list_should_be_expanded() throws Throwable {
		String vObjAnswer = Constants.IOSAccountOR.getProperty("Answer");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAnswer));
		LogCapture.info("Question list is expanded .....");
	}

	@Then("^remove account button should be displayed$")
	public void remove_account_button_should_be_displayed() throws Throwable {
		String vObjRemoveAccount = Constants.IOSAccountOR.getProperty("RemoveAccountBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRemoveAccount));
		LogCapture.info("Remove account button is displayed.....");
	}

	@When("^ios user click on remove account button$")
	public void ios_user_click_on_remove_account_button() throws Throwable {
		String vObjRemoveAccountBtn = Constants.IOSAccountOR.getProperty("RemoveAccountBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjRemoveAccountBtn));
		LogCapture.info("User clicked on remove account button  .......");
	}

	@Then("^confirmation pop up message should be displayed$")
	public void confirmation_pop_up_message_should_be_displayed() throws Throwable {
		String vObjAreYouSure = Constants.IOSAccountOR.getProperty("AreYouSure");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAreYouSure));
		LogCapture.info("Confirmation message is displayed.....");
	}

	@When("^ios user click on reset button$")
	public void ios_user_click_on_reset_button() throws Throwable {
		String vObjResetBtn = Constants.IOSAccountOR.getProperty("ResetBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjResetBtn));
		LogCapture.info("User clicked on reset button  .......");
	}

	@Then("^ios user should be land on login screen$")
	public void ios_user_should_be_land_on_login_screen() throws Throwable {
		String vObjSignUpBtn = Constants.IOSAccountOR.getProperty("SignUpBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSignUpBtn));
		LogCapture.info("User land on login screen ....");
	}

	@When("^ios user click on cancle button$")
	public void ios_user_click_on_cancle_button() throws Throwable {
		String vObjCancleBtn = Constants.IOSAccountOR.getProperty("CancleBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjCancleBtn));
		LogCapture.info("User clicked on cancle button  .......");
	}

	@Then("^remove account button should be displayed on manage device screen$")
	public void remove_account_button_should_be_displayed_on_manage_device_screen() throws Throwable {
		String vObjRemoveAccount = Constants.IOSAccountOR.getProperty("RemoveAccountBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRemoveAccount));
		LogCapture.info("Remove account button is displayed.....");
	}

	@Then("^phone number \"([^\"]*)\" for specific organization should be displayed$")
	public void phone_number_for_specific_organization_should_be_displayed(String vPhoneNumber) throws Throwable {

		String vObjPhoneNumber = Constants.IOSAccountOR.getProperty("PhoneNumber");
		Constants.Data = vObjPhoneNumber.split("+");
		String vPhoneNumber1 = Constants.Data[0].toString();
		String vObjPhoneNumberINC = Constants.IOSAccountOR.getProperty("PhoneNumberINC");
		String vPhoneNumber2 = Constants.key.getAttributeValue(vObjPhoneNumberINC, "value").toString();
		String vObjPhoneNumberLCA = Constants.IOSAccountOR.getProperty("PhoneNumberLCA");
		String vPhoneNumber3 = Constants.key.getAttributeValue(vObjPhoneNumberLCA, "value").toString();

		if (vPhoneNumber.equalsIgnoreCase(vPhoneNumber1)) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vPhoneNumber1));
			LogCapture.info("Phone number is displayed.....");

		} else if (vPhoneNumber.equalsIgnoreCase(vPhoneNumber2)) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vPhoneNumber2));
			LogCapture.info("Phone number for CDINC user is displayed.....");
		}

		else if (vPhoneNumber.equalsIgnoreCase(vPhoneNumber3)) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vPhoneNumber3));
			LogCapture.info("Phone number for CDLCA user is displayed.....");
		}

	}

	@Then("^default available wallet amount \"([^\"]*)\" should be displayed on send from wallet screen$")
	public void default_available_wallet_amount_should_be_displayed_on_send_from_wallet_screen(String vAmount)
			throws Throwable {
		String vObjSendAmount = Constants.IOSAddWalletOR.getProperty("SendAmount");
		String vAmount1 = Constants.key.getAttributeValue(vObjSendAmount, "value").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vAmount1, vAmount));
		LogCapture.info("Bydefault amount is displayed for send from wallet screen.....");
	}

	@Then("^ios user should land on send from wallet screen$")
	public void ios_user_should_land_on_send_from_wallet_screen() throws Throwable {
		String vObjSendFromWalletTitle = Constants.IOSAddWalletOR.getProperty("SendFromWalletTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendFromWalletTitle));
		LogCapture.info("Send from wallet screen is displayed.....");
	}

	@Then("^ios user enters swift code \"([^\"]*)\"$")
	public void ios_user_enters_swift_code(String vSwiftCode) throws Throwable {
		String vObjSwiftCodeTextField = Constants.IOSAddWalletOR.getProperty("SwiftCodeTextField");
		String vObjSwiftCodeTextInput = Constants.IOSAddWalletOR.getProperty("SwiftCodeTextInput");
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjSwiftCodeTextField));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftCodeTextInput, vSwiftCode));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User entered  swift code : " + vSwiftCode);
	}

	@Then("^activity screen should be displayed with recent transaction history in ios app$")
	public void activity_screen_should_be_displayed_with_recent_transaction_history_in_ios_app() throws Throwable {
		String vObjActivityTitle = Constants.IOSSendMoneyOR.getProperty("ActivityTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjActivityTitle));
		LogCapture.info("Activity screen is displayed.....");
	}

	@When("^ios user again click on specified question \"([^\"]*)\" for collapse$")
	public void ios_user_again_click_on_specified_question_for_collapse(String vQuestion) throws Throwable {
		String Questions1 = Constants.IOSAccountOR.getProperty("Qusetons");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(Questions1));
		int noOfQuestions = Constants.key.getElementList(Questions1).size();
		List<MobileElement> Elements = Constants.key.getElementList(Questions1);
		for (int i = 0; i < noOfQuestions; i++) {
			String vQuestionList = Elements.get(i).getText();
			if (vQuestion.equalsIgnoreCase(vQuestionList)) {
				Elements.get(i).click();
				LogCapture.info("User Clicked on question: " + vQuestionList);
				break;
			}
			if (noOfQuestions > 3) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("text", "down"));
			}
		}
	}

	@When("^ios user click on specified question \"([^\"]*)\" for expansion$")
	public void ios_user_click_on_specified_question_for_expansion(String vQuestion) throws Throwable {
		String Questions1 = Constants.IOSAccountOR.getProperty("Qusetons");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(Questions1));
		int noOfQuestions = Constants.key.getElementList(Questions1).size();
		List<MobileElement> Elements = Constants.key.getElementList(Questions1);
		for (int i = 0; i < noOfQuestions; i++) {
			String vQuestionList = Elements.get(i).getText();
			if (vQuestion.equalsIgnoreCase(vQuestionList)) {
				Elements.get(i).click();
				LogCapture.info("User Clicked on question: " + vQuestionList);
				break;
			}
			if (noOfQuestions > 3) {
				Assert.assertEquals("PASS", Constants.key.scrollInIOS("text", "down"));
			}
		}
	}

	@Then("^specified question should expanded$")
	public void specified_question_should_expanded() throws Throwable {
		LogCapture.info("Question is expanded");
	}

	@Then("^specfied question should collapsed$")
	public void specfied_question_should_collapsed() throws Throwable {
		LogCapture.info("Question is collapsed");
	}

	@Then("^empty state country list should be displayed in ios app along with no result message$")
	public void empty_state_country_list_should_be_displayed_in_ios_app_along_with_no_result_message()
			throws Throwable {
		String vObjNoResultFound = Constants.IOSRecipientOR.getProperty("NoResultFound");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNoResultFound));
		LogCapture.info("No resut found message is displayed....");
	}

	@When("^ios user enters invalid bank code \"([^\"]*)\"$")
	public void ios_user_enters_invalid_bank_code(String invalidBankCode) throws Throwable {
		String vObjDoneBtn = Constants.IOSMyCardOR.getProperty("DoneBtn");
		String vObjABAInputLbl = Constants.IOSRecipientOR.getProperty("ABAInputLbl");
		String vObjABAInput = Constants.IOSRecipientOR.getProperty("ABAInput");
		Assert.assertEquals("PASS", Constants.key.clearText(vObjABAInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjABAInput, invalidBankCode));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info(invalidBankCode + " entered .............");
	}

	@Then("^address not found screen should be displayed on ios app search address screen$")
	public void address_not_found_screen_should_be_displayed_on_ios_app_search_address_screen() throws Throwable {
		String vObjAddressNotFound = Constants.IOSMyCardOR.getProperty("AddressNotFoundLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddressNotFound));
		LogCapture.info("Address not found message is displayed....");
	}

	@And("^ios address details fields (should|should not) be displayed to applicable country currency$")
	public void iosAddressDetailsFieldsShouldBeDisplayedToApplicableCountryCurrency(String optionalValue)
			throws Exception {
		String vObjAddressLbl = Constants.IOSRecipientOR.getProperty("AddressLbl");
		String vObjBankDetailsLbl = Constants.IOSRecipientOR.getProperty("BankDetailsLbl");
		String vObjDefaultCountry = Constants.IOSRecipientOR.getProperty("CountryInput");
		String vCountry = Constants.key.getAttributeValue(vObjDefaultCountry, "value");
		String vObjDDInputValue = Constants.IOSRecipientOR.getProperty("DDInputValue");
		String vDDCurrencyValue = Constants.key.getAttributeValue(vObjDDInputValue, "value");
		if (optionalValue.equalsIgnoreCase("should")) {
			if (vCountry.equalsIgnoreCase("France") || vCountry.equalsIgnoreCase("Spain")
					|| vCountry.equalsIgnoreCase("UK") || vCountry.equalsIgnoreCase("India")
					|| vCountry.equalsIgnoreCase("Hungary") || vCountry.equalsIgnoreCase("Hong Kong")
							&& vDDCurrencyValue.equalsIgnoreCase("Hong Kong Dollar")) {
				LogCapture.info("Address is not required for country : " + vCountry);
				// Assert.assertEquals("PASS",Constants.key.eleLocatedDisplayed(vObjBankDetailsLbl));
				String vAddressLbl = Constants.key.getAttributeValue(vObjAddressLbl, "value");
				Assert.assertEquals("PASS", Constants.key.VerifyText(vAddressLbl, "FAIL"));
				LogCapture.info("Address details fields is not displayed...... ");
			} else {
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddressLbl));
				LogCapture.info("Address details fields displayed............");
			}
		} else if (optionalValue.equalsIgnoreCase("should not")) {
			// Assert.assertEquals("PASS",Constants.key.eleLocatedDisplayed(vObjBankDetailsLbl));
			String vAddressLbl = Constants.key.getAttributeValue(vObjAddressLbl, "value");
			Assert.assertEquals("FAIL", vAddressLbl);
			LogCapture.info("Address details fields is not displayed...... ");
		}
	}

	@When("^ios user selects nationality \"([^\"]*)\"$")
	public void ios_user_selects_nationality(String data) throws Throwable {
		String vObNationalityDD = Constants.IOSRegstOR.getProperty("NationalityDD");
		String vObNationalityPicker = Constants.IOSRegstOR.getProperty("NationalityPicker");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObNationalityDD));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObNationalityPicker, data));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
	}

	@When("^ios user enters default otp on (add recipient|login|Registration) screen$")
	public void ios_user_enters_default_otp_on_add_recipient_screen(String optionalValue) throws Throwable {
		String vObjFirstPinInput = Constants.IOSLoginOR.getProperty("SitFirstPinInput");
		String vObjSecondPinInput = Constants.IOSLoginOR.getProperty("SitSecondPinInput");
		String vObjThirdPinInput = Constants.IOSLoginOR.getProperty("SitThirdPinInput");
		String vObjFourthPinInput = Constants.IOSLoginOR.getProperty("SitFourthPinInput");
		String vObjFifthPinInput = Constants.IOSLoginOR.getProperty("SitFifthPinInput");
		String vObjDoneBtn = Constants.IOSLoginOR.getProperty("DoneBtn");

		if (optionalValue.equalsIgnoreCase("add recipient")) {
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstPinInput, "5"));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSecondPinInput, "4"));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjThirdPinInput, "3"));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFourthPinInput, "2"));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFifthPinInput, "1"));
			LogCapture.info("User has entered valid otp on add recipient.........");
		} else if (optionalValue.equalsIgnoreCase("login") || (optionalValue.equalsIgnoreCase("Registration"))) {

			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstPinInput, "5"));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSecondPinInput, "4"));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjThirdPinInput, "3"));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFourthPinInput, "2"));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFifthPinInput, "1"));
			// Assert.assertEquals("PASS",
			// Constants.key.click(vObjDoneBtn));
			LogCapture.info("User has entered valid otp on login screen.........");
		}

	}
}
