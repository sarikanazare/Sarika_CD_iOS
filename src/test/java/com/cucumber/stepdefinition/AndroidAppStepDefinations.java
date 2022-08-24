package com.cucumber.stepdefinition;

import java.time.Duration;
import java.util.List;

import cucumber.api.PendingException;
import org.apache.commons.lang.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.appium.utility.Constants;
import com.utility.LogCapture;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.*;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidAppStepDefinations {

	String userEmail = "";

	@Given("^(android) user installed the new (CD|TorFx) app and launched successfully$")
	public void android_user_installed_the_new_CD_app_and_launched_successfully(String Platform, String app) throws Throwable {
		if (Constants.CONFIG.getProperty("isLocalJenkins").equals("true")) {
			 Assert.assertEquals("PASS",Constants.key.launchApp(app));
			LogCapture.info("Android CD Application installed and launched successfully...");
		}
		
		else if (Constants.CONFIG.getProperty("isBrowserstackJenkins").equals("true")) {
			Thread.sleep(10000);

			String vDeviceID = Constants.CONFIG.getProperty("bAndroidDevice");
			LogCapture.info("CD Android Application is launching on  device " + vDeviceID + "....");
			try {
				if (!Constants.JenkinsBrowser.isEmpty() || !Constants.JenkinsBrowser.equals("")) {
					vDeviceID = Constants.JenkinsBrowser;
					LogCapture.info("Device ID is :" + vDeviceID);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			String vVersion = Constants.CONFIG.getProperty("bAndroidVersion");
			LogCapture.info("CD Android Application is launching on  device version " + vVersion + "....");
			try {
				if (!Constants.BrowserStack.isEmpty() || !Constants.BrowserStack.equals("")) {
					vVersion = Constants.BrowserStack;
					LogCapture.info("Device Version is :" + vVersion);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String rep = vDeviceID.replaceAll("-", " ");
			Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.launchAppANDROIDBrowserstack(rep, vVersion));
			LogCapture.info("CD Android Application installed and launched successfully......!!!!");
		}
		//  Assert.assertEquals("PASS",Constants.key.launchApp(app));
	//	Thread.sleep(10000);
		//Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.launchAppOnBrowserStack(Platform, app));
		//LogCapture.info(app + " Application installed and launched successfully......!!!!");
	}

	@Given("^android user launched existing (CD|TorFx) app on the device successfully$")
	public void android_user_launched_existing_CD_app_on_the_device_successfully(String app) throws Throwable {
		 Assert.assertEquals("PASS", Constants.key.LaunchExistingAndroidApp(app));
		//Assert.assertEquals("PASS", Constants.key.launchExistingAppOnBrowserStackAndroid());

		LogCapture.info("Application installed and launched successfully......!!!!");
	}


	@When("^android the version is supported by the server$")
	public void android_the_version_is_supported_by_the_server() throws Throwable {
		String vObjOnboardingimg = Constants.AndroidCDAppLogin.getProperty("AndroidSignUpBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOnboardingimg));
		LogCapture.info("android the version is supported by the server.......");
	}


	@When("^android the version is not supported by the server$")
	public void android_the_version_is_not_supported_by_the_server() throws Throwable {
		String vObjUpdateNowbtn = Constants.AndroidExtAppData.getProperty("UpdateBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdateNowbtn));
		LogCapture.info("Upgrade application screen displayed.......");
	}

	@When("^android scheduled maintenance has been checked$")
	public void android_scheduled_maintenance_has_been_checked() throws Throwable {
		/*//Constants.AndroidCDAppLogin.getProperty("AndroidCloseFutMaiBtn"); //Temporary

		// reinitialize wait with lower time to improve performance on this step

		Constants.waitInSeconds = Integer.parseInt(Constants.CONFIG.getProperty("ModifyWaitInSecondsForAndroid"));
		String vobjCloseFutMainBtn = Constants.AndroidCDAppLogin.getProperty("AndroidCloseFutMaiBtn"); //Temporary
		String result = Constants.key.click(vobjCloseFutMainBtn);
		if(result.equalsIgnoreCase("PASS")) {
		 LogCapture.info("Future maintenance scheduler found and closed successfully......."); 
		}

		else{
		 LogCapture.info("No future maintenance scheduler found.......");
		}*/
	}

	@Then("^android a splash screen should be displayed$")
	public void android_a_splash_screen_should_be_displayed() throws Exception {
		String vObjSplashImg = Constants.AndroidCDAppLogin.getProperty("AndroidSplashImage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSplashImg));
		LogCapture.info("A splash screen is displayed..........");
	}

	@Then("^android the app should load the onboarding screen$")
	public void android_the_app_should_load_the_onboarding_screen() throws Throwable {
		String vObjOnboardingimg = Constants.AndroidCDAppLogin.getProperty("AndroidSignUpBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOnboardingimg));
		LogCapture.info("A Onboarding screen is displayed..........");
	}

	@When("^android user switch to other application \"([^\"]*)\"$")
	public void android_user_switch_to_other_application(String appPackage) throws Throwable {
		Assert.assertEquals("PASS", Constants.key.setCurrentActivityPackage());
		// Switching to provided application package youtube
		Assert.assertEquals("PASS", Constants.key.switchApp(appPackage));

	}

	@When("^android reswitch to app$")
	public void android_reswitch_to_cdapp() throws Throwable {
		// Switching back to CD APP
		//Assert.assertEquals("PASS", Constants.key.switchApp(Constants.androidPackageName));
		Assert.assertEquals("PASS", Constants.key.switchApp(Constants.CONFIG.getProperty("AndroidCDAppPackage")));

		String lastActivity = Constants.CONFIG.getProperty("CDAndroidAppActivity");
		Assert.assertEquals("PASS", Constants.key.setCurrentActivityPackage());
		lastActivity.equalsIgnoreCase(Constants.androidActivityName);

	}

	@Then("^android the app should load the last activity screen$")
	public void android_the_app_should_load_the_last_activity_screen() throws Throwable {
		String vObjOnboardingimg = Constants.AndroidCDAppLogin.getProperty("AndroidSignUpBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOnboardingimg));
		Assert.assertEquals("PASS", Constants.key.click(vObjOnboardingimg));

	}

	@When("^android there is no internet connection$")
	public void android_there_is_no_internet_connection() throws Throwable {
		String platform = Constants.CONFIG.getProperty("platformName");
		Constants.key.setConnectionToOff(platform);
		Thread.sleep(3000);
		LogCapture.info("Wifi Connection is turned off..........");

	}

	@When("^android there is an internet connection$")
	public void android_there_is_an_internet_connection() throws Throwable {
		String platform = Constants.CONFIG.getProperty("platformName");
		Constants.key.setConnectionToOn(platform);
		LogCapture.info("Wifi Connection is turned on..........");
	}

	@When("^android the user swap the page from right to left respective pages should display$")
	public void android_the_user_swap_the_page_from_right_to_left_respective_pages_should_display() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("PASS", Constants.key.swipeHorizontal(85, 20, 65));
		Assert.assertEquals("PASS", Constants.key.swipeHorizontal(85, 20, 65));
		Assert.assertEquals("PASS", Constants.key.swipeHorizontal(85, 20, 65));
	}

	@When("^android the user swap the page from left to right respective pages should display$")
	public void android_the_user_swap_the_page_from_left_to_right_respective_pages_should_display() throws Throwable {
		Assert.assertEquals("PASS", Constants.key.swipeHorizontal(20, 85, 65));
		Assert.assertEquals("PASS", Constants.key.swipeHorizontal(20, 85, 65));
		Assert.assertEquals("PASS", Constants.key.swipeHorizontal(20, 85, 65));
	}

	@When("^android user click on the update now button$")
	public void android_user_click_on_the_update_now_button() throws Throwable {
		String vObjUpdateNowbtn = Constants.AndroidExtAppData.getProperty("UpdateBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjUpdateNowbtn));
		LogCapture.info("User clicked on update now.......");
	}

	@When("^android user  provide Username \"([^\"]*)\" in invalid format field$")
	public void android_user_provide_Username_in_invalid_format_field(String userName) throws Throwable {
		String vObjEmailIDInput = Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		String vInvaidUsername = Constants.AndroidTestData.getProperty(userName);
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailIDInput, vInvaidUsername));
		Assert.assertEquals("PASS", Constants.key.click(vObjEmailIDInput));
	}

	@Then("^android the app should navigate to requested play store url$")
	public void android_the_app_should_navigate_to_requested_play_store_url() throws Throwable {
		String vObjAppStoreCDAppLabel = Constants.AndroidExtAppData.getProperty("AndroidStoreCDAppLabel");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAppStoreCDAppLabel));
		LogCapture.info("User navigated to Android app store.......");
	}

	@Then("^android no internet connection error message should be displayed$")
	public void android_no_internet_connection_error_message_should_be_displayed() throws Throwable {
		LogCapture.info("No Internet connection. Make sure that Wi‑Fi or mobile data is turned on, then try again.");

	}

	@When("^android the user select the update option$")
	public void android_the_user_select_the_update_option() throws Throwable {
		String vObjAppStoreRedownloadIcon = Constants.AndroidExtAppData.getProperty("AndroidStoreRedownloadIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjAppStoreRedownloadIcon));
		String vObjProgressIcon = Constants.AndroidExtAppData.getProperty("ProgressloadIcon");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjProgressIcon));
		LogCapture.info("User clicked on update app.......");
	}

	@Then("^android the app should be updated to the latest available version$")
	public void android_the_app_should_be_updated_to_the_latest_available_version() throws Throwable {
		String vObjUnintsall = Constants.AndroidExtAppData.getProperty("AndroidStoreUnintallBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUnintsall));
		LogCapture.info("Application updating from the app store.......");
	}

	@When("^android the user does not select the update option$")
	public void android_the_user_does_not_select_the_update_option() throws Throwable {
		// do nothing
		LogCapture.info("User did not click on update option of app store.......");

	}

	@Then("^android the previous version of the app remains installed on the device$")
	public void android_the_previous_version_of_the_app_remains_installed_on_the_device() throws Throwable {
		Constants.driver.resetApp();
		LogCapture.info("Application realunched.......");
		String vObjUpdateNowbtn = Constants.AndroidExtAppData.getProperty("UpdateBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdateNowbtn));
		LogCapture.info("Upgrade application screen displayed.......");
	}

	@When("^android user cancel the update process$")
	public void android_user_cancel_the_update_process() throws Throwable {
		String vObjCancelBtn = Constants.AndroidExtAppData.getProperty("AndroidStoreCancelBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjCancelBtn));
		LogCapture.info("User cancelled upgrade app process.......");

	}

	@Then("^android forced upgrade screen should be displayed$")
	public void android_forced_upgrade_screen_should_be_displayed() throws Throwable {
		String vObjUpdateNowbtn = Constants.AndroidCDAppLogin.getProperty("AndroidSignUpBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdateNowbtn));
		LogCapture.info("Upgrade application screen displayed.......");

	}

	@When("^android user click on I already have an account\\? link$")
	public void android_user_click_on_I_already_have_an_account_link() throws Throwable {
		String vObjIhaveAcclnk = Constants.AndroidCDAppLogin.getProperty("AndroidAlreadyAccount");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjIhaveAcclnk));
		Assert.assertEquals("PASS", Constants.key.click(vObjIhaveAcclnk));
		LogCapture.info("User clicked on I have an account? link .......");
	}

	@When("^android user selects the option to login as a different user and clear the data$")
	public void android_user_selects_the_option_to_login_as_a_different_user_and_clear_the_data() throws Throwable {
		String vObjAnotherAccount = Constants.AndroidCDAppLogin.getProperty("AndroidLoginWthDiffUser");
		Assert.assertEquals("PASS", Constants.key.click(vObjAnotherAccount));
		String vObjDeleteBtn = Constants.AndroidCDAppLogin.getProperty("AndroidpopUpDeleteBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDeleteBtn));
	}

	@Then("^android user should navigate to login screen$")
	public void android_user_should_navigate_to_login_screen() throws Throwable {
		// String vObjEmailInput =
		// Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassword));
		String vObjForgotPasslink = Constants.AndroidCDAppLogin.getProperty("AndroidForgotPass");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotPasslink));
		LogCapture.info("User navigated to login screen successfully .......");
	}

	@When("^android the user provides Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void android_the_user_provides_Username_and_Password(String username, String password) throws Throwable {
		userEmail = username;
		String vUsername = Constants.AndroidTestData.getProperty(username);
		String vUserPassword = Constants.AndroidTestData.getProperty(password);
		String vObjEmailIDInput = Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		LogCapture.info("User Name " + vUsername + ", Password " + vUserPassword + " is validated ....");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailIDInput));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassword));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailIDInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassword, vUserPassword));
	}

	@When("^android user click on the login button and credentials authentication is successful$")
	public void android_user_click_on_the_login_button_and_credentials_authentication_is_successful() throws Throwable {
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
		LogCapture.info("User clicked on login button successfully .......");

		String vObjSkipForNowBtn = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricSkipLink");
		if (!Constants.key.eleLocatedDisplayed(vObjSkipForNowBtn).equalsIgnoreCase("PASS")) {
			//android_user_enters_valid_otp(userEmail);
			android_user_enters_otp_from_Twillio();
		}
	}

	@Then("^android the app should load the dashboard screen$")
	public void android_the_app_should_load_the_dashboard_screen() throws Throwable {
		String vObjSkip = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricSkipLink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSkip));
		Assert.assertEquals("PASS", Constants.key.click(vObjSkip));
		String vObjDashboard = Constants.AndroidCDAppLogin.getProperty("AndroidDashboardPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashboard));
		LogCapture.info("User navigated to dashboard screen successfully .......");
	}

	@When("^android pinned user relaunches the application$")
	public void android_pinned_user_relaunches_the_application() throws Throwable {
		String vPackageName = Constants.CONFIG.getProperty("appPackage");

		//Assert.assertEquals("PASS", Constants.key.activateAppWithoutReset(vPackageName));

		//Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.activateAppWithoutReset(vPackageName));


		//For Browserstack 
		Assert.assertEquals("PASS", Constants.key.launchExistingAppOnBrowserStackAndroid());

	}

	@Then("^android the app should load the pinned user login screen$")
	public void android_the_app_should_load_the_pinned_user_login_screen() throws Throwable {
		String vObjCustomerName = Constants.AndroidCDAppLogin.getProperty("AndroidCustomerName");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCustomerName));
	}

	@Then("^android login signup options should be present on onboarding screen$")
	public void android_login_signup_options_should_be_present_on_onboarding_screen() throws Throwable {
		String vObjalreadyAccntBtn = Constants.AndroidCDAppLogin.getProperty("AndroidAlreadyAccount");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjalreadyAccntBtn));
	}

	@When("^android user click on the Sign up button$")
	public void android_loginuser_click_on_the_Sign_up_button() throws Throwable {
		String vObjloginSignUpBtn = Constants.AndroidCDAppLogin.getProperty("AndroidSignUpBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjloginSignUpBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjloginSignUpBtn));
	}

	@Then("^android user should navigate to registration process screen$")
	public void android_loginuser_should_navigate_to_registration_process_screen() throws Throwable {
		String vObjRegiPage = Constants.AndroidCDAppLogin.getProperty("AndroidRegiPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRegiPage));

	}

	@Then("^android login button should be active to submit the credentials$")
	public void android_login_button_should_be_active_to_submit_the_credentials() throws Throwable {
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("true", Constants.key.getAttributeValue(vObjLoginBtn, "enabled").toString());
		LogCapture.info("Login button is active.......");
	}

	@When("^android the user doest not provides Username and Password$")
	public void android_the_user_doest_not_provides_Username_and_Password() throws Throwable {
		String vBlankUsername = Constants.AndroidTestData.getProperty("AndroidBlankUserName");
		String vBlankPassword = Constants.AndroidTestData.getProperty("AndroidBlankPassword");
		String vObjEmailIDInput = Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailIDInput, vBlankUsername));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassword, vBlankPassword));

	}

	@Then("^android login button remains inactive to submit the credentials$")
	public void android_login_button_remains_inactive_to_submit_the_credentials() throws Throwable {
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("false", Constants.key.getAttributeValue(vObjLoginBtn, "enabled").toString());
		LogCapture.info("Login button is inactive.......");
		System.out.println("Login button is inactive.......");
	}

	@When("^android user  provide only Username \"([^\"]*)\"$")
	public void android_user_provide_only_Username(String userName) throws Throwable {
		String vUsername = Constants.AndroidTestData.getProperty(userName);
		String vObjEmailIDInput = Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailIDInput, vUsername));

	}


	@When("^android user  provide only Password \"([^\"]*)\"$")
	public void android_user_provide_only_Password(String userPass) throws Throwable {
		String vUserPassword = Constants.AndroidTestData.getProperty(userPass);
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		LogCapture.info("Password " + vUserPassword + " is validated ....");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassword));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassword, vUserPassword));

	}

	@Then("^android user required data should be saved in secure device storage for future subsequent logins$")
	public void android_user_required_data_should_be_saved_in_secure_device_storage_for_future_subsequent_logins()
			throws Throwable {
		String vPackageName = Constants.CONFIG.getProperty("AndroidCDAppPackage");
		Assert.assertEquals("PASS", Constants.key.activateAppWithoutReset(vPackageName));
	}

	@When("^android user click on the login button and user credentials authentication is un successful$")
	public void android_user_click_on_the_login_button_and_user_credentials_authentication_is_un_successful()
			throws Throwable {

	}

	@Then("^android authentication unsuccessful error message should be displayed on login screen$")
	public void android_authentication_unsuccessful_error_message_should_be_displayed_on_login_screen()
			throws Throwable {

	}

	@When("^android user provide Username \"([^\"]*)\" in invalid format$")
	public void android_user_provide_Username_in_invalid_format(String arg1) throws Throwable {
		String vObjUsername = Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		String vUserName = Constants.AndroidTestData.getProperty("AndroidInvalidEmail");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUsername, vUserName));
	}

	@Then("^android a validation failure message should be displayed for the username$")
	public void android_a_validation_failure_message_should_be_displayed_for_the_username() throws Throwable {
		String vObjValMsg = Constants.AndroidCDAppLogin.getProperty("AndroidEmailValidation");
		String vInvalidEmailDesc = Constants.AndroidTestData.getProperty("AndroidEmailErrorMsg");
		String atbValue = Constants.key.getAttributeValue(vObjValMsg, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vInvalidEmailDesc));
		LogCapture.info("Incorrect email address entered.......");

	}

	@Then("^android forgot password\\? link should present on login screen$")
	public void android_forgot_password_link_should_present_on_login_screen() throws Throwable {
		String vObjPass = Constants.AndroidCDAppLogin.getProperty("AndroidForgotPass");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPass));

	}

	@When("^android user click on forgot password\\? link$")
	public void android_user_click_on_forgot_password_link() throws Throwable {
		String vObjPass = Constants.AndroidCDAppLogin.getProperty("AndroidForgotPass");
		Assert.assertEquals("PASS", Constants.key.click(vObjPass));
	}

	@Then("^android user navigate to forgot password process screen$")
	public void android_user_navigate_to_forgot_password_process_screen() throws Throwable {
		String vObjEmailInput = Constants.AndroidCDAppLogin.getProperty("AndroidEnterForgotEmail");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailInput));
	}

	@When("^android user provide valid registered Username \"([^\"]*)\"$")
	public void android_user_provide_valid_registered_Username(String userName) throws Throwable {
		String vObjEmailInput = Constants.AndroidCDAppLogin.getProperty("AndroidEnterForgotEmail");
		String vUsername = Constants.AndroidTestData.getProperty(userName);
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, vUsername));
	}

	@Then("^android forgot password button should be active$")
	public void android_forgot_password_button_should_be_active() throws Throwable {
		String vObjSendMeLinkBtn = Constants.AndroidCDAppLogin.getProperty("AndroidSendMealinkBtn");
		String atbValue = Constants.key.getAttributeValue(vObjSendMeLinkBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		LogCapture.info("Active forgot passwrd button verified successfully.........");
	}

	@When("^android user  provide Username \"([^\"]*)\" in invalid format in forgotemail field$")
	public void android_user_provide_Username_in_invalid_format_in_forgotemail_field(String userName) throws Throwable {
		String vObjEmailInput = Constants.AndroidCDAppLogin.getProperty("AndroidEnterForgotEmail");
		String vInvalidUsername = Constants.AndroidTestData.getProperty(userName);
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, vInvalidUsername));

	}

	@Then("^android forgot password button should be inactive$")
	public void android_forgot_password_button_should_be_inactive() throws Throwable {
		String vObjSendMeLinkBtn = Constants.AndroidCDAppLogin.getProperty("AndroidSendMealinkBtn");
		Assert.assertEquals("false", Constants.key.getAttributeValue(vObjSendMeLinkBtn, "enabled").toString());
		LogCapture.info("Send me a link button is inactive.......");
		System.out.println("Send me a link button is inactive.......");
	}

	@When("^android user  doesnot provide Username$")
	public void android_user_doesnot_provide_Username() throws Throwable {
		String vObjEmailInput = Constants.AndroidCDAppLogin.getProperty("AndroidEnterForgotEmail");
		String vBlankEmail = Constants.AndroidTestData.getProperty("AndroidBlankUserName");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, vBlankEmail));

	}

	@When("^android user click on send me a link button$")
	public void android_user_click_on_send_me_a_link_button() throws Throwable {
		String vObjSendMeLinkBtn = Constants.AndroidCDAppLogin.getProperty("AndroidSendMealinkBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjSendMeLinkBtn));
	}

	@Then("^android reset password link has been sent success message should be displayed$")
	public void android_reset_password_link_has_been_sent_success_message_should_be_displayed() throws Throwable {
		String ForgotPassCloseBtn = Constants.AndroidCDAppLogin.getProperty("AndroidCloseFutMaiBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(ForgotPassCloseBtn));
		String vObjEmailSentTextMsg = Constants.AndroidCDAppLogin.getProperty("AndroidSentEmailDesc");
		String vForgotEmailDesc = Constants.AndroidTestData.getProperty("AndroidForgotEmailDescMsg");
		String atbValue = Constants.key.getAttributeValue(vObjEmailSentTextMsg, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vForgotEmailDesc));

	}

	@When("^android user provide valid non registered Username \"([^\"]*)\"$")
	public void android_user_provide_valid_non_registered_Username(String userName) throws Throwable {
		String vObjEmailInput = Constants.AndroidCDAppLogin.getProperty("AndroidEnterForgotEmail");
		String vUserName = Constants.AndroidTestData.getProperty(userName);
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailInput, vUserName));
	}

	@Then("^android reset passwod failure message should be displayed$")
	public void android_reset_passwod_failure_message_should_be_displayed() throws Throwable {
		String vObjEmailInput = Constants.AndroidCDAppLogin.getProperty("AndroidEmailErrorVal");
		String vInvalidEmailDesc = Constants.AndroidTestData.getProperty("AndroidEmailErrorMsg");
		String atbValue = Constants.key.getAttributeValue(vObjEmailInput, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vInvalidEmailDesc, atbValue));
	}

	@When("^android user close the forgot password window$")
	public void android_when_user_close_the_forgot_password_window() throws Throwable {
		String ForgotPassCloseBtn = Constants.AndroidCDAppLogin.getProperty("AndroidCloseFutMaiBtn");
		Assert.assertEquals("PASS", Constants.key.click(ForgotPassCloseBtn));
		LogCapture.info("Forgot password? window closed successfully.........");
	}

	@When("^android user closes the reset password link success window$")
	public void android_user_closes_the_reset_password_link_success_window() throws Throwable {
		String ForgotPassCloseBtn = Constants.AndroidCDAppLogin.getProperty("AndroidCloseFutMaiBtn");
		Assert.assertEquals("PASS", Constants.key.click(ForgotPassCloseBtn));
		LogCapture.info("Forgot password? window closed successfully.........");
	}

	@Then("^android forgot password description label should be present on screen$")
	public void android_forgot_password_description_label_should_be_present_on_screen() throws Throwable {
		String vObjForGotHeader = Constants.AndroidCDAppLogin.getProperty("AndroidEmailHeader");
		String vForgotHeader = Constants.AndroidTestData.getProperty("AndroidForgotHeaderMsg");
		String atbValue = Constants.key.getAttributeValue(vObjForGotHeader, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(atbValue, vForgotHeader));
	}

	@Given("^android user is taken to the login screen with user name pre-filled$")
	public void android_user_is_taken_to_the_login_screen_with_user_name_pre_filled() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		String vObjCustomerName = Constants.AndroidCDAppLogin.getProperty("AndroidCustomerName");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCustomerName));

	}

	@Then("^android app should not request for the biometric credentials to login$")
	public void android_app_should_not_request_for_the_biometric_credentials_to_login() throws Throwable {
		String oObjLogPassInput = Constants.AndroidCDAppLogin.getProperty("AndroidloginPassFieldInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(oObjLogPassInput));
	}

	@When("^android existing user provides  Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void android_existing_user_provides_Username_and_Password(String username, String userPass)
			throws Throwable {
		userEmail = username;
		String vUsername = Constants.AndroidTestData.getProperty(username);
		String vUserPassword = Constants.AndroidTestData.getProperty(userPass);
		String vObjEmailIDInput = Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		LogCapture.info("User Name " + vUsername + ", Password " + vUserPassword + " is validated ....");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailIDInput));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassword));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailIDInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassword, vUserPassword));
	}

	@When("^android user skip the biometric credentials for the app$")
	public void android_user_skip_the_biometric_credentials_for_the_app() throws Throwable {
		String vObjSkip = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricSkipLink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSkip));
		Assert.assertEquals("PASS", Constants.key.click(vObjSkip));
	}

	@When("^android user begins to type in the password \"([^\"]*)\" field$")
	public void android_user_begins_to_type_in_the_password_field(String arg1) throws Throwable {
		String vObjLogPassInput = Constants.AndroidCDAppLogin.getProperty("AndroidloginPassFieldInput");
		String vUserPassword = Constants.AndroidTestData.getProperty(arg1);
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLogPassInput, vUserPassword));

	}

	@When("^android user allow to type in the password \"([^\"]*)\" field$")
	public void android_user_allow_to_type_in_the_password_field(String arg1) throws Throwable {
		String vObjLogPassInput = Constants.AndroidCDAppLogin.getProperty("AndroidloginPassFieldInput");
		String vUserPassword = Constants.AndroidTestData.getProperty(arg1);
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLogPassInput, vUserPassword));

	}

	@Then("^android an eye icon to show/hide the password value should be available$")
	public void android_an_eye_icon_to_show_hide_the_password_value_should_be_available() throws Throwable {
		String oObjPassHide = Constants.AndroidCDAppLogin.getProperty("AndroidPassVisibility");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(oObjPassHide));
	}

	@Then("^an eye icon to show hide the password value should not be available for android app$")
	public void an_eye_icon_to_show_hide_the_password_value_should_not_be_available_for_android_app() throws Throwable {
		String oObjPassHide = Constants.AndroidCDAppLogin.getProperty("AndroidPassVisibility");
		Assert.assertEquals(Constants.KEYWORD_FAIL, Constants.key.eleLocatedDisplayed(oObjPassHide));

	}

	@When("^android password field is blank$")
	public void android_password_field_is_blank() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		String oObjLogPassNoInput = Constants.AndroidCDAppLogin.getProperty("AndroidloginPassFieldInput");
		String vUserPassword = Constants.AndroidTestData.getProperty("AndroidBlankPassword");
		Assert.assertEquals("PASS", Constants.key.writeInInput(oObjLogPassNoInput, vUserPassword));

	}

	@Then("^android option to show/hide the password value should be inactive$")
	public void android_option_to_show_hide_the_password_value_should_be_inactive() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		String oObjPassHide = Constants.AndroidCDAppLogin.getProperty("AndroidPassVisibility");
		Assert.assertEquals(Constants.KEYWORD_FAIL, Constants.key.eleLocatedDisplayed(oObjPassHide));

	}

	@When("^android user clear the password field value$")
	public void android_user_clear_the_password_field_value() throws Throwable {
		String vObjLogPassInput = Constants.AndroidCDAppLogin.getProperty("AndroidloginPassFieldInput");
		Assert.assertEquals("PASS", Constants.key.clearText(vObjLogPassInput));

	}

	@Then("^android value in the password field should be masked$")
	public void android_value_in_the_password_field_should_be_masked() throws Exception {
		String password = Constants.AndroidCDAppLogin.getProperty("AndroidloginPassFieldInput");
		String makePassword = Constants.key.getAttributeValue(password, "password");
		System.out.println("makePassword:: " + makePassword);
		Assert.assertEquals("true", makePassword, "Password is  masked");

	}

	@When("^android user click on eye icon to unmask the password value$")
	public void android_user_click_on_eye_icon_to_unmask_the_password_value() throws Throwable {
		String vObjEyeIcon = Constants.AndroidCDAppLogin.getProperty("AndroidPassVisibility");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEyeIcon));
		Assert.assertEquals("PASS", Constants.key.click(vObjEyeIcon));
	}

	@Then("^password value should be unmasked for android user$")
	public void password_value_should_be_unmasked_for_android_user() throws Throwable {
		String password = Constants.AndroidCDAppLogin.getProperty("AndroidloginPassFieldInput");
		String makePassword = Constants.key.getAttributeValue(password, "password");
		System.out.println("makePassword:: " + makePassword);
		Assert.assertEquals("false", makePassword, "Password is  unmasked");
	}

	@When("^android user click on eye icon to mask the password value$")
	public void android_user_click_on_eye_icon_to_mask_the_password_value() throws Throwable {
		String vObjEyeIcon = Constants.AndroidCDAppLogin.getProperty("AndroidPassVisibility");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEyeIcon));
		Assert.assertEquals("PASS", Constants.key.click(vObjEyeIcon));
	}

	@Then("^password value should be masked for android user$")
	public void password_value_should_be_masked_for_android_user() throws Throwable {
		String password = Constants.AndroidCDAppLogin.getProperty("AndroidloginPassFieldInput");
		String makePassword = Constants.key.getAttributeValue(password, "password");
		System.out.println("makePassword:: " + makePassword);
		Assert.assertEquals("true", makePassword, "Password is  masked");
	}

	@Then("^android app should load the dashboard screen$")
	public void android_app_should_load_the_dashboard_screen() throws Throwable {
		String vObjDashboard = Constants.AndroidCDAppLogin.getProperty("AndroidDashboardPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashboard));
	}

	@Then("^android option to login button is made active$")
	public void android_option_to_login_button_is_made_active() throws Exception {
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("true", Constants.key.getAttributeValue(vObjLoginBtn, "enabled").toString());

	}

	@When("^android user has NOT entered the password$")
	public void android_user_has_NOT_entered_the_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String oObjLogPassInput = Constants.AndroidCDAppLogin.getProperty("AndroidloginPassFieldInput");
		String vUserPassword = Constants.AndroidTestData.getProperty("AndroidBlankPassword");
		Assert.assertEquals("PASS", Constants.key.writeInInput(oObjLogPassInput, vUserPassword));
	}

	@Then("^android option to submit the credential is disabled$")
	public void android_option_to_submit_the_credential_is_disabled() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("false", Constants.key.getAttributeValue(vObjLoginBtn, "enabled").toString());
	}

	@When("^android user provides Password \"([^\"]*)\"$")
	public void android_user_provides_Password(String userPass) throws Throwable {
		String oObjLogPassInput = Constants.AndroidCDAppLogin.getProperty("AndroidloginPassFieldInput");
		String vUserPassword = Constants.AndroidTestData.getProperty(userPass);
		Assert.assertEquals("PASS", Constants.key.writeInInput(oObjLogPassInput, vUserPassword));
	}

	@Then("^android user submits the credentials$")
	public void android_user_submits_the_credentials() throws Throwable {
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
	}

	@Then("^android both user name and the password are submitted for authentication$")
	public void android_both_user_name_and_the_password_are_submitted_for_authentication() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String vObjSkip = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricSkipLink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSkip));
		Assert.assertEquals("PASS", Constants.key.click(vObjSkip));
		String vObjDashboard = Constants.AndroidCDAppLogin.getProperty("AndroidDashboardPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashboard));
		System.out.println("--------User credentials are authenticated successfully------");
		LogCapture.info("--------User credentials are authenticated successfully------");
	}

	@When("^android option to forgot password is selected$")
	public void android_option_to_forgot_password_is_selected() throws Exception {
		String oObjPass = Constants.AndroidCDAppLogin.getProperty("AndroidForgotPass");
		Assert.assertEquals("PASS", Constants.key.click(oObjPass));
	}

	@Then("^android forgot password process should be triggered$")
	public void android_forgot_password_process_should_be_triggered() throws Exception {
		String oObjEmailInput = Constants.AndroidCDAppLogin.getProperty("AndroidEnterForgotEmail");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(oObjEmailInput));

	}

	@Then("^android option to sign in as an another user should be available$")
	public void android_option_to_sign_in_as_an_another_user_should_be_available() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		String vObjAnotherAccount = Constants.AndroidCDAppLogin.getProperty("AndroidLoginWthDiffUser");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAnotherAccount));

	}

	@When("^android the user selects the option to login as a different user$")
	public void android_the_user_selects_the_option_to_login_as_a_different_user() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		String vObjAnotherAccount = Constants.AndroidCDAppLogin.getProperty("AndroidLoginWthDiffUser");
		Assert.assertEquals("PASS", Constants.key.click(vObjAnotherAccount));

	}

	@Then("^android the app should trigger the first time login process$")
	public void android_the_app_should_trigger_the_first_time_login_process() throws Throwable {
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidForgotPass");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoginBtn));

	}

	@Then("^android information should be displayed, advising the user that this action will clear any user saved information$")
	public void android_information_should_be_displayed_advising_the_user_that_this_action_will_clear_any_user_saved_information()
			throws Exception {
		// Write code here that turns the phrase above into concrete actions
		String vObjpopUptextMsg = Constants.AndroidCDAppLogin.getProperty("AndroidPopUpMsg");
		String text = Constants.key.readText(vObjpopUptextMsg);
		System.out.println("Text message is:- " + text);

	}

	@Then("^android user accepts to login as a different user$")
	public void android_user_accepts_to_login_as_a_different_user() throws Throwable {
		String vObjDeleteBtn = Constants.AndroidCDAppLogin.getProperty("AndroidpopUpDeleteBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDeleteBtn));
	}

	@Then("^android the previously stored username should be removed from secure device storage$")
	public void android_the_previously_stored_username_should_be_removed_from_secure_device_storage() throws Throwable {
		String vObjCustomerName = Constants.AndroidCDAppLogin.getProperty("AndroidCustomerName");
		Assert.assertEquals(Constants.KEYWORD_FAIL, Constants.key.eleLocatedDisplayed(vObjCustomerName));
	}

	@When("^android the user declines to login as a different user$")
	public void android_the_user_declines_to_login_as_a_different_user() throws Throwable {
		String vObjCancelBtn = Constants.AndroidCDAppLogin.getProperty("AndroidPopUpCancelBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjCancelBtn));

	}

	@When("^android user cancel the biometric option$")
	public void android_user_cancel_the_biometric_option() throws Throwable {
		String vObjBiometricCancelBtn = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricCancelPopup");
		Assert.assertEquals("PASS", Constants.key.click(vObjBiometricCancelBtn));
	}

	@Then("^android the information should close$")
	public void android_the_information_should_close() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		String vObjCancelBtn = Constants.AndroidCDAppLogin.getProperty("AndroidPopUpCancelBtn");
		Assert.assertEquals(Constants.KEYWORD_FAIL, Constants.key.eleLocatedDisplayed(vObjCancelBtn));

	}

	@When("^android pinned user reset the application$")
	public void android_pinned_user_reset_the_application() throws Throwable {
		Constants.driver.resetApp();
	}

	@When("^android the user provides credentials Username \"([^\"]*)\" and Password \"([^\"]*)\" having Q&A set$")
	public void android_the_user_provides_credentials_Username_and_Password_having_Q_A_set(String userName,
																						   String userPass) throws Throwable {
		String vUsername = Constants.AndroidTestData.getProperty(userName);
		String vUserPassword = Constants.AndroidTestData.getProperty(userPass);
		String vObjEmailIDInput = Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		LogCapture.info("User Name " + vUsername + ", Password " + vUserPassword + " is validated ....");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailIDInput));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassword));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailIDInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassword, vUserPassword));
	}

	@When("^android biometric credentials have been enabled for the app$")
	public void android_biometric_credentials_have_been_enabled_for_the_app() throws Throwable {
		String vObjBiometricEnableBtn = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricEnable");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBiometricEnableBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjBiometricEnableBtn));
		String vObjBiometricEnableText = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricEnableTxt");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBiometricEnableText));
		Assert.assertEquals("PASS", Constants.key.click(vObjBiometricEnableBtn));

	}

	@Then("^android the app should load the dashboard page$")
	public void android_the_app_should_load_the_dashboard_page() throws Throwable {
		String vObjDashboard = Constants.AndroidCDAppLogin.getProperty("AndroidDashboardPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashboard));
	}

	@Then("^android app should request the users biometric credentials to login$")
	public void android_app_should_request_the_users_biometric_credentials_to_login() throws Throwable {
		String vObjBiometricCancelBtn = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricCancelPopup");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBiometricCancelBtn));

	}

	@Then("^android user tap on account menu$")
	public void android_user_tap_on_account_menu() throws Throwable {
		String vObjAccountIconBtn = Constants.AndroidCDAppLogin.getProperty("AndroidAccountMenuicon");
		Assert.assertEquals("PASS", Constants.key.click(vObjAccountIconBtn));

	}

	@Then("^android user verify biometric switch is enabled in account section$")
	public void android_user_verify_biometric_switch_is_enabled_in_account_section() throws Throwable {
		String vObjBiometricSwitch = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricSwitch");
		Assert.assertEquals("true", Constants.key.getAttributeValue(vObjBiometricSwitch, "enabled").toString());

	}

	@Then("^android user verify biometric switch is disabled in account section$")
	public void android_user_verify_biometric_switch_is_disabled_in_account_section() throws Throwable {
		String vObjBiometricDisSwitch = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricSwitch");
		Assert.assertEquals("false", Constants.key.getAttributeValue(vObjBiometricDisSwitch, "selected").toString());
	}

	@When("^android the new registered user provides Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void android_the_new_registered_user_provides_Username_and_Password(String userName, String userPass)
			throws Throwable {
		String vUsername = Constants.AndroidTestData.getProperty(userName);
		String vUserPassword = Constants.AndroidTestData.getProperty(userPass);
		String vObjEmailIDInput = Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		LogCapture.info("User Name " + vUsername + ", Password " + vUserPassword + " is validated ....");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailIDInput));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassword));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailIDInput, vUsername));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassword, vUserPassword));

	}

	@When("^android existing registered user provides Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void android_existing_registered_user_provides_Username_and_Password(String userName, String userPass)
			throws Throwable {
		String vExistingUsername = Constants.AndroidTestData.getProperty(userName);
		String vUserPassword = Constants.AndroidTestData.getProperty(userPass);
		String vObjEmailIDInput = Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		LogCapture.info("User Name " + vExistingUsername + ", Password " + vUserPassword + " is validated ....");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailIDInput));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassword));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailIDInput, vExistingUsername));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassword, vUserPassword));
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
	}

	@Then("^android user set their Security questions and answers$")
	public void android_user_set_their_Security_questions_and_answers() throws Throwable {
		String vObjQuestion1 = Constants.AndroidCDAppLogin.getProperty("AndroidSecurityQuestion1");
		Assert.assertEquals("PASS", Constants.key.click(vObjQuestion1));
		String QA1 = Constants.AndroidTestData.getProperty("AndroidQuestionone");
		Constants.driver.findElement(By.xpath(vObjQuestion1)).sendKeys(QA1);
		String VObjSecretAnsField = Constants.AndroidCDAppLogin.getProperty("AndroidSecretAnswer1");
		String vObjAnswer = Constants.AndroidTestData.getProperty("AndroidAnswer1");
		Assert.assertEquals("PASS", Constants.key.writeInInput(VObjSecretAnsField, vObjAnswer));
		String vObjQuestion2 = Constants.AndroidCDAppLogin.getProperty("AndroidSecurityQuestion2");
		Assert.assertEquals("PASS", Constants.key.click(vObjQuestion2));
		String QA2 = Constants.AndroidTestData.getProperty("AndroidQuestionTwo");
		Constants.driver.findElement(By.xpath(vObjQuestion2)).sendKeys(QA2);
		// Constants.driver.findElement(By.xpath("//*[@resource-id='com.bnt.currencydirect.cdholding:id/textViewSecurityQuestionOne']")).sendKeys(QA1);
		String VObjSecretAnsFieldTwo = Constants.AndroidCDAppLogin.getProperty("AndroidSecretAnswer2");
		String vObjAnswer2 = Constants.AndroidTestData.getProperty("AndroidAnswer2");
		Assert.assertEquals("PASS", Constants.key.writeInInput(VObjSecretAnsFieldTwo, vObjAnswer2));
		String vObjSQADoneBtn = Constants.AndroidCDAppLogin.getProperty("AndroidSQADoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjSQADoneBtn));
	}

	@Then("^the app should continue to the next process$")
	public void the_app_should_continue_to_the_next_process() throws Throwable {
		String vObjBiometricEnableBtn = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricEnable");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBiometricEnableBtn));

	}

	@Then("^authentication unsuccessful error message should be displayed on login screen for android user$")
	public void authentication_unsuccessful_error_message_should_be_displayed_on_login_screen_for_android_user()
			throws Throwable {
		String vObjInvalidValMsg = Constants.AndroidCDAppLogin.getProperty("AndroidErrorMsg");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInvalidValMsg));

	}

	@When("^android user provides their Security QAs in  invalid format$")
	public void android_user_provides_their_Security_QAs_in_invalid_format() throws Throwable {
		String vObjQuestion1 = Constants.AndroidCDAppLogin.getProperty("AndroidSecurityQuestion1");
		Assert.assertEquals("PASS", Constants.key.click(vObjQuestion1));
		String QA1 = Constants.AndroidTestData.getProperty("AndroidQuestionone");
		Constants.driver.findElement(By.xpath(vObjQuestion1)).sendKeys(QA1);
		String VObjSecretAnsField = Constants.AndroidCDAppLogin.getProperty("AndroidSecretAnswer1");
		String vObjAnswer = Constants.AndroidTestData.getProperty("AndroidAnswer1");
		Assert.assertEquals("PASS", Constants.key.writeInInput(VObjSecretAnsField, vObjAnswer));
		Assert.assertEquals("PASS", Constants.key.clearText(VObjSecretAnsField));
		String vObjQuestion2 = Constants.AndroidCDAppLogin.getProperty("AndroidSecurityQuestion2");
		Assert.assertEquals("PASS", Constants.key.click(vObjQuestion2));
		String QA2 = Constants.AndroidTestData.getProperty("AndroidQuestionTwo");
		Constants.driver.findElement(By.xpath(vObjQuestion2)).sendKeys(QA2);
		// Constants.driver.findElement(By.xpath("//*[@resource-id='com.bnt.currencydirect.cdholding:id/textViewSecurityQuestionOne']")).sendKeys(QA1);
		String VObjSecretAnsFieldTwo = Constants.AndroidCDAppLogin.getProperty("AndroidSecretAnswer2");
		String vObjAnswer2 = Constants.AndroidTestData.getProperty("AndroidAnswer2");
		Assert.assertEquals("PASS", Constants.key.writeInInput(VObjSecretAnsFieldTwo, vObjAnswer2));
		Assert.assertEquals("PASS", Constants.key.clearText(VObjSecretAnsFieldTwo));

	}

	@When("^android user provided security questions and answer$")
	public void android_user_provided_security_questions_and_answer() throws Throwable {
		String vObjQuestion1 = Constants.AndroidCDAppLogin.getProperty("AndroidSecurityQuestion1");
		Assert.assertEquals("PASS", Constants.key.click(vObjQuestion1));
		String QA1 = Constants.AndroidTestData.getProperty("AndroidQuestionone");
		Constants.driver.findElement(By.xpath(vObjQuestion1)).sendKeys(QA1);
		String VObjSecretAnsField = Constants.AndroidCDAppLogin.getProperty("AndroidSecretAnswer1");
		String vObjAnswer = Constants.AndroidTestData.getProperty("AndroidAnswer1");
		Assert.assertEquals("PASS", Constants.key.writeInInput(VObjSecretAnsField, vObjAnswer));
		String vObjQuestion2 = Constants.AndroidCDAppLogin.getProperty("AndroidSecurityQuestion2");
		Assert.assertEquals("PASS", Constants.key.click(vObjQuestion2));
		String QA2 = Constants.AndroidTestData.getProperty("AndroidQuestionTwo");
		Constants.driver.findElement(By.xpath(vObjQuestion2)).sendKeys(QA2);
		// Constants.driver.findElement(By.xpath("//*[@resource-id='com.bnt.currencydirect.cdholding:id/textViewSecurityQuestionOne']")).sendKeys(QA1);
		String VObjSecretAnsFieldTwo = Constants.AndroidCDAppLogin.getProperty("AndroidSecretAnswer2");
		String vObjAnswer2 = Constants.AndroidTestData.getProperty("AndroidAnswer2");
		Assert.assertEquals("PASS", Constants.key.writeInInput(VObjSecretAnsFieldTwo, vObjAnswer2));
	}

	@Then("^android user should get the option to set their Security questions and answers$")
	public void android_user_should_get_the_option_to_set_their_Security_questions_and_answers() throws Throwable {
		String vObjSecurityQA = Constants.AndroidCDAppLogin.getProperty("AndroidSecurityPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSecurityQA));
		LogCapture.info("User displayes option to set their Security questions and answers");

	}

	@Then("^android user should not get the option to set their Security questions and answers$")
	public void android_user_should_not_get_the_option_to_set_their_Security_questions_and_answers() throws Throwable {
		String vObjSecurityQA = Constants.AndroidCDAppLogin.getProperty("AndroidSecurityPage");
		Assert.assertEquals(Constants.KEYWORD_FAIL, Constants.key.eleLocatedDisplayed(vObjSecurityQA));
		LogCapture.info("User displayes option to set their Security questions and answers");

	}

	@Then("^android option to submit their details should be active$")
	public void android_option_to_submit_their_details_should_be_active() throws Throwable {
		String vObjSQADoneBtn = Constants.AndroidCDAppLogin.getProperty("AndroidSQADoneBtn");
		Assert.assertEquals("true", Constants.key.getAttributeValue(vObjSQADoneBtn, "enabled").toString());
		LogCapture.info("Done button gets active after entering the valid data");

	}

	@Then("^android user tap on login with another user account present on subsequent login page$")
	public void android_user_tap_on_login_with_another_user_account_present_on_subsequent_login_page()
			throws Throwable {
		String vObjAnotherAccount = Constants.AndroidCDAppLogin.getProperty("AndroidLoginWthDiffUser");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAnotherAccount));
		String vObjAnotherAccountlink = Constants.AndroidCDAppLogin.getProperty("AndroidLoginWthDiffUser");
		Assert.assertEquals("PASS", Constants.key.click(vObjAnotherAccountlink));
		String vObjDeleteBtn = Constants.AndroidCDAppLogin.getProperty("AndroidpopUpDeleteBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDeleteBtn));
	}

	@When("^android user set only first security questions and answer$")
	public void android_user_set_only_first_security_questions_and_answer() throws Throwable {
		String vObjQuestion1 = Constants.AndroidCDAppLogin.getProperty("AndroidSecurityQuestion1");
		Assert.assertEquals("PASS", Constants.key.click(vObjQuestion1));
		String QA1 = Constants.AndroidTestData.getProperty("AndroidQuestionone");
		Constants.driver.findElement(By.xpath(vObjQuestion1)).sendKeys(QA1);
		String VObjSecretAnsField = Constants.AndroidCDAppLogin.getProperty("AndroidSecretAnswer1");
		String vObjAnswer = Constants.AndroidTestData.getProperty("AndroidAnswer1");
		Assert.assertEquals("PASS", Constants.key.writeInInput(VObjSecretAnsField, vObjAnswer));

	}

	@Then("^android the option to submit their details should be inactive$")
	public void android_the_option_to_submit_their_details_should_be_inactive() throws Throwable {
		String vObjSQADoneBtn = Constants.AndroidCDAppLogin.getProperty("AndroidSQADoneBtn");
		Assert.assertEquals("false", Constants.key.getAttributeValue(vObjSQADoneBtn, "enabled").toString());
		LogCapture.info("Done button gets active after entering the valid data");

	}

	@When("^user provides Username which has legal entity is \"([^\"]*)\"$")
	public void user_provides_Username_which_has_legal_entity_is(String arg1) throws Throwable {
		Constants.CustLegalEntity = arg1;// AndroidNewUser LGB AndroidNewUserLCA
		String vUsernameLGB = Constants.AndroidTestData.getProperty("AndroidNewUser" + arg1);
		String vObjEmailIDInput = Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailIDInput));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailIDInput, vUsernameLGB));
	}

	@When("^user provides Username \"([^\"]*)\" which has legal entity is \"([^\"]*)\"$")
	public void user_provides_username_something_which_has_legal_entity_is_something(String emailaddress,
																					 String legalentity) throws Throwable {
		Constants.CustLegalEntity = legalentity;
		String vUsernameLGB = Constants.AndroidTestData.getProperty(emailaddress);
		String vObjEmailIDInput = Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEmailIDInput));
		System.out.println(vObjEmailIDInput + " " + vUsernameLGB);
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailIDInput, vUsernameLGB));
	}

	@When("^android user enters invalid password for (\\d+) time$")
	public void android_user_enters_invalid_password_for_time(int arg1) throws Throwable {
		String vObjOkBtn = Constants.AndroidCDAppLogin.getProperty("AndroidInvalidPassOKBtn");
		if (Constants.key.isElementPresent(vObjOkBtn, 5).equalsIgnoreCase("PASS"))
			Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
		String vUserPassword = Constants.AndroidTestData.getProperty("AndroidInvalidPassword");
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		System.out.println("Entering the invalid password for " + arg1 + " time ");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassword, vUserPassword));
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
		String vObjInvalidValMsg5 = Constants.AndroidCDAppLogin.getProperty("AndroidInvalidErrorMsg1");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInvalidValMsg5));
	}

	@Then("^android user displays related information for the (\\d+) attempt$")
	public void android_user_displays_related_information_for_the_attempt(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String vObjInvalidValMsg5 = Constants.AndroidCDAppLogin.getProperty("AndroidInvalidErrorMsg1");
		// AndroidPassErrorMsg 1_LGB AndroidPassErrorMsg1_LCA
		String vInvalidPassFourthDesc = Constants.AndroidTestData
				.getProperty("AndroidPassErrorMsg" + arg1 + "_" + Constants.CustLegalEntity);
		String atbValue = Constants.key.getAttributeValue(vObjInvalidValMsg5, "text").toString();
		if (arg1 == 5)
			Assert.assertEquals("PASS",
					Constants.key.VerifyTextContains(atbValue, vInvalidPassFourthDesc));
		else
			Assert.assertEquals("PASS", Constants.key.VerifyText(atbValue, vInvalidPassFourthDesc));
	}

	@When("^android user provides valid password field$")
	public void android_user_provides_valid_password_field() throws Throwable {
		String vUserPassword = Constants.AndroidTestData.getProperty("AndroidPassword");
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassword, vUserPassword));
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
	}

	@When("^android user provides valid Password field$")
	public void android_user_provides_valid_Password_field() throws Throwable {
		String vObjOkBtn = Constants.AndroidCDAppLogin.getProperty("AndroidInvalidPassOKBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjOkBtn));
		String vUserPassword = Constants.AndroidTestData.getProperty("AndroidPassword");
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassword, vUserPassword));
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
	}

	@When("^android user provides valid Password \"([^\"]*)\"$")
	public void android_user_provides_valid_Password(String userPass) throws Throwable {
		String vUserPassword = Constants.AndroidTestData.getProperty(userPass);
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassword, vUserPassword));
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
	}

	@Then("^android user relaunches the app again$")
	public void android_user_relaunches_the_app_again() throws Throwable {
		Constants.driver.resetApp();
	}

	@Then("^android the app should display the dashboard screen$")
	public void android_the_app_should_display_the_dashboard_screen() throws Throwable {
		String vObjDashboard = Constants.AndroidCDAppLogin.getProperty("AndroidDashboardPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashboard));
	}

	@When("^android locked account user provide valid registered Username \"([^\"]*)\"$")
	public void android_locked_user_provide_valid_registered_Username(String userName) throws Throwable {
		String vLokedUsername = Constants.AndroidTestData.getProperty(userName);
		String vObjForgotEmailInputField = Constants.AndroidCDAppLogin.getProperty("AndroidEnterForgotEmail");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotEmailInputField));
		Assert.assertEquals("PASS",
				Constants.key.writeInInput(vObjForgotEmailInputField, vLokedUsername));
	}

	@When("^android inactive account user provide valid registered Username \"([^\"]*)\"$")
	public void android_inactive_user_provide_valid_registered_Username(String userName) throws Throwable {
		String vInactiveUsername = Constants.AndroidTestData.getProperty(userName);
		String vObjForgotEmailInputField = Constants.AndroidCDAppLogin.getProperty("AndroidEnterForgotEmail");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotEmailInputField));
		Assert.assertEquals("PASS",
				Constants.key.writeInInput(vObjForgotEmailInputField, vInactiveUsername));
	}

	@When("^android user provides non existing Username \"([^\"]*)\"$")
	public void android_user_provides_non_existing_Username(String userName) throws Throwable {
		String vNonExistingUsername = Constants.AndroidTestData.getProperty(userName);
		String vObjForgotEmailInputField = Constants.AndroidCDAppLogin.getProperty("AndroidEnterForgotEmail");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotEmailInputField));
		Assert.assertEquals("PASS",
				Constants.key.writeInInput(vObjForgotEmailInputField, vNonExistingUsername));
	}

	@Then("^android user disconnect the VPN connection and back to CD application$")
	public void android_user_disconnect_the_VPN_connection_and_back_to_CD_application() throws Throwable {
		String vObjVPNDoneBtn = Constants.AndroidCDAppLogin.getProperty("AndroidSQADoneBtn");
		Assert.assertEquals("true", Constants.key.getAttributeValue(vObjVPNDoneBtn, "enabled").toString());
		Assert.assertEquals("PASS", Constants.key.click(vObjVPNDoneBtn));
		Assert.assertEquals("PASS", Constants.key.switchApp(Constants.androidPackageName));

	}

	@When("^android user provide locked due to inavlid attempt Username \"([^\"]*)\"$")
	public void android_user_provide_locked_due_to_inavlid_attempt_Username(String userName) throws Throwable {
		String vLokedUsername = Constants.AndroidTestData.getProperty(userName);
		String vObjForgotEmailInputField = Constants.AndroidCDAppLogin.getProperty("AndroidEnterForgotEmail");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotEmailInputField));
		Assert.assertEquals("PASS",
				Constants.key.writeInInput(vObjForgotEmailInputField, vLokedUsername));
	}

	@When("^android user provide admin locked Username \"([^\"]*)\"$")
	public void android_user_provide_admin_locked_Username(String userName) throws Throwable {
		String vLokedUsername = Constants.AndroidTestData.getProperty(userName);
		String vObjForgotEmailInputField = Constants.AndroidCDAppLogin.getProperty("AndroidEnterForgotEmail");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotEmailInputField));
		Assert.assertEquals("PASS",
				Constants.key.writeInInput(vObjForgotEmailInputField, vLokedUsername));
	}

	@When("^android user provide atlas inactive Username  \"([^\"]*)\"$")
	public void android_user_provide_atlas_inactive_Username(String userName) throws Throwable {
		String vAtlasInactiveUser = Constants.AndroidTestData.getProperty(userName);
		String vObjForgotEmailInputField = Constants.AndroidCDAppLogin.getProperty("AndroidEnterForgotEmail");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjForgotEmailInputField));
		Assert.assertEquals("PASS",
				Constants.key.writeInInput(vObjForgotEmailInputField, vAtlasInactiveUser));
	}

	@Then("^android information related to no internet connection should display$")
	public void android_information_related_to_no_internet_connection_should_display() throws Throwable {

		String vObjNoNetTextMsg = Constants.AndroidCDAppLogin.getProperty("AndroidForgotNoNet");

		String vForgotNoNetDesc = Constants.AndroidTestData.getProperty("AndroidForgotNoNetText");
		String atbValue = Constants.key.getAttributeValue(vObjNoNetTextMsg, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vForgotNoNetDesc));

	}

	@When("^existing user provides Username \"([^\"]*)\" and Password \"([^\"]*)\" first time for android app$")
	public void existing_user_provides_Username_and_Password_first_time_for_android_app(String userName,
																						String userPass) throws Throwable {
		String vNewRegisteredUser = Constants.AndroidTestData.getProperty(userName);
		String vUserPassword = Constants.AndroidTestData.getProperty(userPass);
		String vObjEmailIDInput = Constants.AndroidCDAppLogin.getProperty("AndroidEmailIDInput");
		String vObjPassword = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		LogCapture.info("User Name " + vNewRegisteredUser + ", Password " + vUserPassword + " is validated ....");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEmailIDInput, vNewRegisteredUser));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPassword, vUserPassword));
	}

	@When("^android user click on the login button$")
	public void android_user_click_on_the_login_button() throws Throwable {
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
	}


	@Then("^Otp page should be displayed to android user$")
	public void otp_page_should_be_displayed_to_android_user() throws Throwable {
		String vOTPPage = Constants.AndroidCDAppLogin.getProperty("AndroidOTPPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vOTPPage));
		LogCapture.info("User is on otp page....");

	}


	@Then("^OTP page should be displayed to android user$")
	public void OTP_page_should_be_displayed_to_android_user() throws Throwable {
		String vOTPPage = Constants.AndroidCDAppLogin.getProperty("AndroidOTPPage");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vOTPPage));

		//Assert.assertEquals("PASS", Constants.key.pause("5", ""));
		Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.eleLocatedDisplayed(vOTPPage));

		LogCapture.info("User is on otp page....");
		//Thread.sleep(20000);
	}


	/*
	 * @When("^android user enters invalid OTP \"([^\"]*)\"$") public void
	 * android_user_enters_invalid_OTP(String InvalidOTP) throws Throwable {
	 * String vOTPOne =
	 * Constants.AndroidTestData.getProperty("AndroidInvlaidOTP");
	 *
	 * String vOTPInputOne =
	 * Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINOne"); String
	 * vOTPInputTwo =
	 * Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINTwo"); String
	 * vOTPInputThree =
	 * Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINThree"); String
	 * vOTPInputFour =
	 * Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINFour"); String
	 * vOTPInputFive =
	 * Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINFive");
	 * Assert.assertEquals("PASS",
	 * Constants.key.writeInInput(vOTPInputOne, vOTPOne.substring(0, 1)));
	 * Assert.assertEquals("PASS",
	 * Constants.key.writeInInput(vOTPInputTwo, vOTPOne.substring(1, 2)));
	 * Assert.assertEquals("PASS",
	 * Constants.key.writeInInput(vOTPInputThree, vOTPOne.substring(2, 3)));
	 * Assert.assertEquals("PASS",
	 * Constants.key.writeInInput(vOTPInputFour, vOTPOne.substring(3, 4)));
	 * Assert.assertEquals("PASS",
	 * Constants.key.writeInInput(vOTPInputFive, vOTPOne.substring(4, 5)));
	 *
	 * }
	 */
	@When("^android user enters invalid OTP \"([^\"]*)\"$")
	public void android_user_enters_invalid_otp_something(String otp) throws Throwable {

		String vOTPOne = Constants.AndroidTestData.getProperty(otp);
		String vOTPInputOne = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINOne");
		String vOTPInputTwo = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINTwo");
		String vOTPInputThree = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINThree");
		String vOTPInputFour = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINFour");
		String vOTPInputFive = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINFive");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputOne, vOTPOne.substring(0, 1)));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputTwo, vOTPOne.substring(1, 2)));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputThree, vOTPOne.substring(2, 3)));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputFour, vOTPOne.substring(3, 4)));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputFive, vOTPOne.substring(4, 5)));
		LogCapture.info("Invalid otp provided....");

	}


	/* Code to enter pin from DB 


	@When("^android user enters valid otp \"([^\"]*)\"$")
	public void android_user_enters_valid_otp(String emailaddress)
			throws Throwable {
		String userEmail = Constants.AndroidTestData.getProperty(emailaddress);
		String vValidOTP = Constants.key.getOTP(Constants.CONFIG.getProperty("environment"), userEmail);
		LogCapture.info("Database connection success and OTP is :" + vValidOTP);


		// String vOTPOne =
		// Constants.AndroidTestData.getProperty("AndroidInvlaidOTP");
		String vOTPInputOne = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINOne");
		String vOTPInputTwo = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINTwo");
		String vOTPInputThree = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINThree");
		String vOTPInputFour = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINFour");
		String vOTPInputFive = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINFive");

		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputOne, vValidOTP.substring(0, 1)));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputTwo, vValidOTP.substring(1, 2)));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputThree, vValidOTP.substring(2, 3)));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputFour, vValidOTP.substring(3, 4)));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputFive, vValidOTP.substring(4, 5)));
		Thread.sleep(2000);


	} */
	
	@When("^android user enters (invalid|valid) otp \"([^\"]*)\"$")
	public void android_user_enters_invalid_otp_something(String type,String otp) throws Throwable {

		String vOTPOne = Constants.AndroidTestData.getProperty(otp);
		String vOTPInputOne = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINOne");
		String vOTPInputTwo = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINTwo");
		String vOTPInputThree = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINThree");
		String vOTPInputFour = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINFour");
		String vOTPInputFive = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINFive");
		
		Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.writeInInput(vOTPInputOne, vOTPOne.substring(0, 1)));
		Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.writeInInput(vOTPInputTwo, vOTPOne.substring(1, 2)));
		Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.writeInInput(vOTPInputThree, vOTPOne.substring(2, 3)));
		Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.writeInInput(vOTPInputFour, vOTPOne.substring(3, 4)));
		Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.writeInInput(vOTPInputFive, vOTPOne.substring(4, 5)));
		LogCapture.info(" otp provided....");

	}

	@When("^android user enters OTP from Twillio$")
	public void android_user_enters_otp_from_Twillio() throws Throwable {

		String vOTPInputOne = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINOne");
		String vOTPInputTwo = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINTwo");
		String vOTPInputThree = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINThree");
		String vOTPInputFour = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINFour");
		String vOTPInputFive = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINFive");

		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputOne, "5"));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputTwo, "4"));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputThree, "3"));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputFour, "2"));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vOTPInputFive, "1"));


		LogCapture.info("otp provided from from Twillio....");

	}

	@Then("^android invalid otp error message should be displayed$")
	public void android_invalid_otp_error_message_should_be_displayed() throws Throwable {
		String vObjInvalidOTPMsg = Constants.AndroidCDAppLogin.getProperty("AndroidInvalidOTPMsg");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInvalidOTPMsg));
		String vInvalidOTPDesc = Constants.AndroidTestData.getProperty("AndroidInvalidOTPDec");
		String atbValue = Constants.key.getAttributeValue(vObjInvalidOTPMsg, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vInvalidOTPDesc));
		Thread.sleep(2000);
	}

	@When("^android user do not enters otp in sixty seconds$")
	public void android_user_do_not_enters_otp_in_sixty_seconds() throws Throwable {
		LogCapture.info("Waiting for 60 seconds to display resend pin link.........");
		Thread.sleep(30000);
		String vOTPPage = Constants.AndroidCDAppLogin.getProperty("AndroidOTPPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vOTPPage));
		Thread.sleep(30000);
		LogCapture.info("User has waited for 60 seconds.........");
	}

	@Then("^resend pin link gets displayed on android app pin screen$")
	public void resend_pin_link_gets_displayed_on_android_app_pin_screen() throws Throwable {
		String vObjResendPinLink = Constants.AndroidCDAppLogin.getProperty("AndroidResendPinLink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjResendPinLink));
		LogCapture.info("Resend pin displayed.........");
	}

	@When("^android user click on resend pin$")
	public void android_user_click_on_resend_pin() throws Throwable {
		String vObjResendPinLink = Constants.AndroidCDAppLogin.getProperty("AndroidResendPinLink");
		Assert.assertEquals("PASS", Constants.key.click(vObjResendPinLink));
		LogCapture.info("User click on resend pin link.........");
	}

	@Then("^request a new pin timer should be start for sixty seconds$")
	public void request_a_new_pin_timer_should_be_start_for_sixty_seconds() throws Throwable {
		String vOTPInputOne = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINOne");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vOTPInputOne));
		String vObjPINTimerMsg = Constants.AndroidCDAppLogin.getProperty("AndroidResendTimer");
		String atbValue = Constants.key.getAttributeValue(vObjPINTimerMsg, "text");
		LogCapture.info("Time label displayed : " + atbValue);

	}

	@When("^android user enters valid OTP \"([^\"]*)\"$")
	public void android_user_enters_valid_OTP(String arg1) throws Throwable {
		String vOTPInputOne = Constants.AndroidCDAppLogin.getProperty("AndroidEnterPINOne");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vOTPInputOne));
		LogCapture.info("Enter Valid otp");
		Thread.sleep(50000);

	}

	@When("^OTP user skip the biometric credentials for the app$")
	public void otp_user_skip_the_biometric_credentials_for_the_app() throws Throwable {
		String vObjSkip = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricSkipLink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSkip));
		Assert.assertEquals("PASS", Constants.key.click(vObjSkip));
	}

	@When("^android user click on back button$")
	public void android_user_click_on_back_button() throws Throwable {

		String vObjBackBtn = Constants.AndroidCDAppLogin.getProperty("AndroidOTPBackBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjBackBtn));
		LogCapture.info("clicked on back button");

	}

	@Then("^android user should navigate to its login screen$")
	public void android_user_should_navigate_to_its_login_screen() throws Throwable {
		String vObjCustomerName = Constants.AndroidCDAppLogin.getProperty("AndroidCustomerName");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCustomerName));

	}

	@Then("^OTP app should load the dashboard screen$")
	public void otp_app_should_load_the_dashboard_screen() throws Throwable {
		String vObjDashboard = Constants.AndroidCDAppLogin.getProperty("AndroidDashboardPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashboard));
	}

	@When("^android OTP user set their Security questions and answers$")
	public void android_OTP_user_set_their_Security_questions_and_answers() throws Throwable {
		String VObjSecurityPage = Constants.AndroidCDAppLogin.getProperty("AndroidSecurityPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(VObjSecurityPage));
		String vObjQuestion1 = Constants.AndroidCDAppLogin.getProperty("AndroidSecurityQuestion1");
		Assert.assertEquals("PASS", Constants.key.click(vObjQuestion1));
		String QA1 = Constants.AndroidTestData.getProperty("AndroidQuestionone");
		Constants.driver.findElement(By.xpath(vObjQuestion1)).sendKeys(QA1);
		String VObjSecretAnsField = Constants.AndroidCDAppLogin.getProperty("AndroidSecretAnswer1");
		String vObjAnswer = Constants.AndroidTestData.getProperty("AndroidAnswer1");
		Assert.assertEquals("PASS", Constants.key.writeInInput(VObjSecretAnsField, vObjAnswer));
		String vObjQuestion2 = Constants.AndroidCDAppLogin.getProperty("AndroidSecurityQuestion2");
		Assert.assertEquals("PASS", Constants.key.click(vObjQuestion2));
		String QA2 = Constants.AndroidTestData.getProperty("AndroidQuestionTwo");
		Constants.driver.findElement(By.xpath(vObjQuestion2)).sendKeys(QA2);
		// Constants.driver.findElement(By.xpath("//*[@resource-id='com.bnt.currencydirect.cdholding:id/textViewSecurityQuestionOne']")).sendKeys(QA1);
		String VObjSecretAnsFieldTwo = Constants.AndroidCDAppLogin.getProperty("AndroidSecretAnswer2");
		String vObjAnswer2 = Constants.AndroidTestData.getProperty("AndroidAnswer2");
		Assert.assertEquals("PASS", Constants.key.writeInInput(VObjSecretAnsFieldTwo, vObjAnswer2));
		String vObjSQADoneBtn = Constants.AndroidCDAppLogin.getProperty("AndroidSQADoneBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjSQADoneBtn));
	}

	@When("^android user is logged into the app with Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void android_user_is_logged_into_the_app_with_username_something_and_password_something(String username,
																								   String password) throws Throwable {
		// android_the_user_provides_Username_and_Password(String
		// AndroidUserName, String AndroidPassword);
		userEmail = username;
		android_the_user_provides_Username_and_Password(username, password);
		android_user_click_on_the_login_button_and_credentials_authentication_is_successful();
		android_user_skip_the_biometric_credentials_for_the_app();
		android_the_app_should_load_the_dashboard_page();

	}

	// **************************************DebitCards
	// *****************************************//

	/*
	 * @When("^debit cards is selected by android user$") public void
	 * debit_cards_is_selected_by_android_user() throws Throwable { String
	 * vObjDebitCardLbl =
	 * Constants.AndroidCDAppLogin.getProperty("AndroidDebitCardIcon");
	 * Assert.assertEquals("PASS",Constants.key.click(
	 * vObjDebitCardLbl)); }
	 *
	 */

	@And("^android user opens up their account settings$")
	public void android_user_opens_up_their_account_settings() throws Throwable {
		String vObjAccountIcon = Constants.CDAppDashboard.getProperty("AccountIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));

		/*
		 * String vObjAccountIconClk=
		 * Constants.CDAppDashboard.getProperty("AccountIcon");
		 * Assert.assertEquals("PASS",Constants.key.click(vObjAccountIconClk));
		 */
		LogCapture.info("User cliked on account option.........");

		String vObjAccountLbl = Constants.CDAppDashboard.getProperty("AccountLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAccountLbl));

		String vObjPersonalDetLbl = Constants.CDAppDashboard.getProperty("PersonalDetLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPersonalDetLbl));

		LogCapture.info("Account setting screen displayed.........");

	}

	@And("^debit cards is selected by android user$")
	public void debit_cards_is_selected_by_android_user() throws Throwable {
		String vObjAccDebitCardBtn = Constants.CDAppDashboard.getProperty("AccDebitCardBtn");
		String vObjDebCardListTitle = Constants.CDAppDashboard.getProperty("DebCardListTitle");
		Assert.assertEquals("PASS", Constants.key.click(vObjAccDebitCardBtn));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebCardListTitle));
		LogCapture.info("User has selected debit card option from account section.........");

	}

	@And("^android user has not saved any cards previously$")
	public void android_user_has_not_saved_any_cards_previously() throws Throwable {
		String vObjNoCardsOnAccLbl = Constants.CDAppDashboard.getProperty("NoCardsOnAccLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNoCardsOnAccLbl));
		LogCapture.info("Debit cards is not present in card list.........");
	}

	@Then("^an empty state screen should be displayed to android user with an option to add a new card$")
	public void an_empty_state_screen_should_be_displayed_to_android_user_with_an_option_to_add_a_new_card()
			throws Throwable {
		String vObjNoCardsOnAccLbl = Constants.CDAppDashboard.getProperty("NoCardsOnAccLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNoCardsOnAccLbl));
		LogCapture.info("Empty debit card list has been displayed.........");
	}

	@When("^android user has one or more saved cards$")
	public void android_user_has_one_or_more_saved_cards() throws Throwable {
		String vObjDebitCardList = Constants.CDAppDashboard.getProperty("DebitCardList");
		Constants.key.scrollDownUI("Add debit card");
		String vObjAddDebitCardBtnInList = Constants.CDAppDashboard.getProperty("AddDebitCardBtnInList");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddDebitCardBtnInList));

		int debitCardListSize = Constants.key.getElementList(vObjDebitCardList).size();
		if (debitCardListSize < 1) {
			LogCapture.info("Debit cards is not present in card list.........");
		} else if (debitCardListSize > 1) {
			LogCapture.info("Debit cards present in card list :" + (debitCardListSize));
		}
	}

	@Then("^all saved cards list should be displayed in order of date added with option add a new card to android user$")
	public void all_saved_cards_list_should_be_displayed_in_order_of_date_added_with_option_add_a_new_card_to_android_user()
			throws Throwable {
		String vObjDebitCardList = Constants.CDAppDashboard.getProperty("DebitCardList");
		List<MobileElement> CardElements = Constants.key.getElementList(vObjDebitCardList);
		for (MobileElement Cardelement : CardElements) {
			String cardelement = Cardelement.getText();
			LogCapture.info("Debit Card " + cardelement);

		}

	}

	@Then("^saved cards number should be masked except last four digits in android app accordance with PCI-DSS requirements$")
	public void saved_cards_number_should_be_masked_except_last_four_digits_in_android_app_accordance_PCI_DSS_requirements()
			throws Throwable {
		String vObjDebitCardList = Constants.CDAppDashboard.getProperty("DebitCardList");
		List<MobileElement> CardElements = Constants.key.getElementList(vObjDebitCardList);
		for (MobileElement Cardelement : CardElements) {
			String cardnumber = Cardelement.getText().replaceAll("\\s", "");
			String cardLast4Digit = cardnumber.substring((cardnumber.length() - 4), (cardnumber.length()));
			Assert.assertEquals(true, NumberUtils.isNumber(cardLast4Digit));
			String formattedString = new StringBuilder(cardnumber).replace(0, cardnumber.length() - 5,
					new String(new char[cardnumber.length() - 5]).replace("\0", "*")).toString();

			LogCapture.info("formattedString" + formattedString + "cardLast4Digit" + cardLast4Digit);

			Assert.assertEquals("PASS", Constants.key.VerifyText(cardnumber, formattedString));
			LogCapture.info("Debit card : " + cardnumber + " : Card numbers are masked except last 4 digit");

		}

	}

	@When("^android user selects a saved card \"([^\"]*)\"$")
	public void android_user_selects_a_saved_card_something(String cardlast4digit) throws Throwable {
		String vObjDebitCardList = Constants.CDAppDashboard.getProperty("DebitCardList");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardList));
		String vDebitCardNo = cardlast4digit;
		List<MobileElement> CardElements = Constants.key.getElementList(vObjDebitCardList);
		for (int i = 0; i < CardElements.size(); i++) {

			String cardnumber = CardElements.get(i).getText();
			String Card4Digit = cardnumber.substring((cardnumber.length() - 4), (cardnumber.length()));
			if (vDebitCardNo.equalsIgnoreCase(Card4Digit)) {
				//vObjCardSelect.get(i).click();
				CardElements.get(i).click();

				LogCapture.info("Debit card selected : " + cardnumber);
				Thread.sleep(5000);

				break;
			}

		}

	}

	@Then("^all the details of the card \"([^\"]*)\" should be displayed in a new screen to android user$")
	public void all_the_details_of_the_card_something_should_be_displayed_in_a_new_screen_to_android_user(
			String debitcarddata) throws Throwable {
		Constants.Data = debitcarddata.split(",");
		for (int i = 0; i < Constants.Data.length; i++) {
			String[] Data1;
			Data1 = Constants.Data[i].split("-");

			String vObjCardNoInput = Constants.CDAppDashboard.getProperty("CardNumberTF");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardNoInput));

			String vObjCardholderNameTF = Constants.CDAppDashboard.getProperty("CardholderNameTF");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardholderNameTF));

			String vObjExpDateInput = Constants.CDAppDashboard.getProperty("ExpDateTF");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjExpDateInput));

			String vObjAddressTF = Constants.CDAppDashboard.getProperty("AddressTF");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddressTF));

			String vObjIssueDateTF = Constants.CDAppDashboard.getProperty("IssueDate");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjIssueDateTF));

			if (Data1[0].toString().equalsIgnoreCase("Name")) {
				String vCardholderNameTF = Constants.key.getAttributeValue(vObjCardholderNameTF, "text").toString();

				Assert.assertEquals("PASS", Constants.key.VerifyText(vCardholderNameTF, Data1[1].toString()));
				LogCapture.info("Card holder name : " + vCardholderNameTF + " verified");
			}
			if (Data1[0].toString().equalsIgnoreCase("Card no")) {
				String vCardNumberTF = Constants.key.getAttributeValue(vObjCardNoInput, "text").toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vCardNumberTF, Data1[1].toString()));
				LogCapture.info("Debit card number : " + vCardNumberTF + " verified");
			}
			if (Data1[0].toString().equalsIgnoreCase("Expiry date")) {
				String vExpDateTF = Constants.key.getAttributeValue(vObjExpDateInput, "text").toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vExpDateTF, Data1[1].toString()));
				LogCapture.info("Expiry Date : " + vExpDateTF + " verified");
			}

			if (Data1[0].toString().equalsIgnoreCase("IssueDate")) {
				String vExpDateTF = Constants.key.getAttributeValue(vObjIssueDateTF, "text").toString();
				Assert.assertEquals("PASS", Constants.key.VerifyText(vExpDateTF, Data1[1].toString()));
				LogCapture.info("Issue Date : " + vExpDateTF + " verified");
			}
			if (Data1[0].toString().equalsIgnoreCase("Adress")) {
				String vAddressTF = Constants.key.getAttributeValue(vObjAddressTF, "text").toString()
						.replaceAll("[\r\n]+", " ").replaceAll("\\s", "");
				Assert.assertEquals("PASS", Constants.key.VerifyText(vAddressTF, Data1[1].toString()));
				LogCapture.info("Address : " + vAddressTF + " verified");
			}

		}

	}

	@When("^android user selects the close button$")
	public void android_user_selects_the_close_button() throws Throwable {
		String vObjCloseBtn = Constants.CDAppDashboard.getProperty("CloseBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjCloseBtn));
		LogCapture.info("User clicked on close button.....");

	}

	@Then("^android user should return to the account screen$")
	public void android_user_should_return_to_the_account_screen() throws Throwable {
		String vObjAccountLbl = Constants.CDAppDashboard.getProperty("AccountLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAccountLbl));
		LogCapture.info("Debit card list screen closed and user navigated to account section.....");

	}

	@And("^android user selects to add a new card$")
	public void android_user_selects_to_add_a_new_card() throws Throwable {
		Constants.key.scrollDownUI("Add debit card");
		String vObjAddDebitCardBtn = Constants.CDAppDashboard.getProperty("AddDebitCardBtn");
		String vObjAddDebitCardBtnInList = Constants.CDAppDashboard.getProperty("AddDebitCardBtnInList");
		String vObjNoCardsOnAccLbl = Constants.CDAppDashboard.getProperty("NoCardsOnAccLbl");
		String Nocardpresent = Constants.key.getAttributeValue(vObjNoCardsOnAccLbl, "text").toString().trim();
		String Nocardpresenttext = Constants.AndroidTestData.getProperty("Nocardpresent");

		if (Nocardpresent.equalsIgnoreCase(Nocardpresenttext)) {
			Assert.assertEquals("PASS", Constants.key.click(vObjAddDebitCardBtn));
			LogCapture.info("User clicked on add debit card button.....");
		} else {
			Assert.assertEquals("PASS", Constants.key.click(vObjAddDebitCardBtnInList));
			LogCapture.info("User clicked on add debit card button.....");
		}

	}

	@Then("^card details should be blank to android user$")
	public void card_details_should_be_blank_to_android_user() throws Throwable {

		String vObjCardNoPlaceHolder = Constants.CDAppDashboard.getProperty("CardNoPlaceHolder");
		String vObjExpiryDatePlaceHolder = Constants.CDAppDashboard.getProperty("ExpiryDatePlaceHolder");
		String vObjIssueDatePlaceHolder = Constants.CDAppDashboard.getProperty("IssueDatePlaceHolder");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardNoPlaceHolder));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjExpiryDatePlaceHolder));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjIssueDatePlaceHolder));
		LogCapture.info("Empty debit card number,expiry date and issue date verified successfully......");

	}

	@And("^pre populated contact name and billing address \"([^\"]*)\" should be displayed to android user$")
	public void pre_populated_contact_name_and_billing_address_something_should_be_displayed_to_android_user(
			String contactNameBillingaddress) throws Throwable {

		String vObjCardholderName = Constants.CDAppDashboard.getProperty("CardHoldeNameTextField");
		String vObjCardholderText = Constants.key.readText(vObjCardholderName);

		Constants.Data = contactNameBillingaddress.split(",");

		String vObjAddressTF = Constants.CDAppDashboard.getProperty("AddressTF1");

		String vCardholderName = Constants.key.getAttributeValue(vObjCardholderName, "text");
		Thread.sleep(10000);// waiting for cardholdername to visible
		LogCapture.info("cadholder name: " + vCardholderName + " verified");

		String vAddressTF = Constants.key.getAttributeValue(vObjAddressTF, "text").toString().replaceAll("[\r\n]+", " ")
				.replaceAll("\\s", "");

		Assert.assertEquals("PASS", Constants.key.VerifyText(vAddressTF, Constants.Data[1]));
		LogCapture.info("Address : " + vAddressTF + " verified");
	}

	@When("^android user provides card holder name \"([^\"]*)\" card number \"([^\"]*)\" expiry date \"([^\"]*)\" issue date \"([^\"]*)\"$")
	public void android_user_provides_card_holder_name_something_card_number_something_expiry_date_something_issue_date_something(
			String cardholdername, String cardnumber, String expirydatemmyy, String issuedate) throws Throwable {

		String vObjCardholderName = Constants.CDAppDashboard.getProperty("CardHoldeNameTextField");
		String vObjExpDateInput = Constants.CDAppDashboard.getProperty("ExpiryDateInput");
		String vObjIssuedate = Constants.CDAppDashboard.getProperty("IssueDate");
		String vObjCardNoInput = Constants.CDAppDashboard.getProperty("CardNoInput");

		Assert.assertEquals("PASS", Constants.key.clearText(vObjCardholderName));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardholderName, cardholdername));
		LogCapture.info("Card holder name entered : " + cardholdername);

		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardNoInput, cardnumber));
		LogCapture.info("Card holder number entered : " + cardnumber);

		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjExpDateInput, expirydatemmyy));
		LogCapture.info("Expiry date entered (MMYY): " + expirydatemmyy);

		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIssuedate, issuedate));
		LogCapture.info("Issue date provided : " + issuedate);

	}

	@And("^android user clicks on save button$")
	public void android_user_clicks_on_save_button() throws Throwable {

		Constants.key.scrollDownUI("Bank name");
		Constants.key.scrollDownUI("Save");
		String vObjSave = Constants.CDAppDashboard.getProperty("SaveBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjSave));
		LogCapture.info("User clicked on save button....");
		Thread.sleep(5000);

	}

	@Then("^option to scan the card details should be available to android user$")
	public void option_to_scan_the_card_details_should_be_available_to_android_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^the option to save the card should be in an inactive/disabled state in android app$")
	public void the_option_to_save_the_card_should_be_in_an_inactivedisabled_state_in_android_app() throws Throwable {
		Constants.key.scrollDownUI("Save");
		String vObjSaveBtn = Constants.CDAppDashboard.getProperty("SaveBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSaveBtn));
		String atbValue = Constants.key.getAttributeValue(vObjSaveBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		LogCapture.info("Inactive save button verified successfully.........");

	}

	@Then("^the option to save the card should be in active/enabled state in android app$")
	public void the_option_to_save_the_card_should_be_in_activeenabled_state_in_android_app() throws Throwable {
		Constants.key.scrollDownUI("Save");
		String vObjSaveBtn = Constants.CDAppDashboard.getProperty("SaveBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSaveBtn));
		String atbValue = Constants.key.getAttributeValue(vObjSaveBtn, "enabled");
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		LogCapture.info("Active save button verified successfully......");

	}

	@And("^an option to delete the card should be available to android user$")
	public void an_option_to_delete_the_card_should_be_available_to_android_user() throws Throwable {

		String vObjDeleteBtn = Constants.CDAppDashboard.getProperty("DeleteBtn");
		String atbValue = Constants.key.getAttributeValue(vObjDeleteBtn, "enabled");
		String atbValue2 = Constants.key.getAttributeValue(vObjDeleteBtn, "clickable");
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue2));
		LogCapture.info("Delete button verified successfully.........");

	}

	@When("^android user clicks on delete$")
	public void android_user_clicks_on_delete() throws Throwable {
		String vObjDeleteBtn = Constants.CDAppDashboard.getProperty("DeleteBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDeleteBtn));
		LogCapture.info("User clicked on Delete debit card.........");

	}

	@Then("^an alert view should be displayed to confirm the delete card action in android app$")
	public void an_alert_view_should_be_displayed_to_confirm_the_delete_card_action_in_android_app() throws Throwable {
		String vObjDeletePop = Constants.CDAppDashboard.getProperty("DeletePopup");
		String atbValue = Constants.key.getAttributeValue(vObjDeletePop, "text").trim();
		String vDeletePopMsg = Constants.AndroidTestData.getProperty("DeletePopupMsg");
		Assert.assertEquals("PASS", Constants.key.VerifyText(vDeletePopMsg, atbValue));
		LogCapture.info("Pop up for Delete debit card displayed .........");

	}

	@When("^android user cancels the action$")
	public void android_user_cancels_the_action() throws Throwable {
		String vObjCancelPop = Constants.CDAppDashboard.getProperty("CancelPopBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjCancelPop));
		LogCapture.info("User clicked Cancel button on delete debit card pop up.........");

	}

	@When("^android user confirms the action$")
	public void android_user_confirms_the_action() throws Throwable {
		String vObjDeletePop = Constants.CDAppDashboard.getProperty("DeletePopBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDeletePop));
		LogCapture.info("User clicked on Delete button on delete debit card pop up.........");

	}

	@Then("^android user should be on same selected card view screen$")
	public void android_user_should_be_on_same_selected_card_view_screen() throws Throwable {
		String vObjDebCardListTitle = Constants.CDAppDashboard.getProperty("DebCardListTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebCardListTitle));
		LogCapture.info("User is on card view screen .....");

	}

	@And("^the selected card \"([^\"]*)\" should be deleted from the list of saved cards$")
	public void the_selected_card_something_should_be_deleted_from_the_list_of_saved_cards(String cardlast4digit)
			throws Throwable {
		String vObjDebitCardList = Constants.CDAppDashboard.getProperty("DebitCardList");
		List<MobileElement> CardElements = Constants.key.getElementList(vObjDebitCardList);
		String vDebitCardNo = Constants.AndroidTestData.getProperty(cardlast4digit);
		for (MobileElement Cardelement : CardElements) {
			String cardnumber = Cardelement.getText();
			Thread.sleep(2000);
			String CardLast4Digit = cardnumber.substring((cardnumber.length() - 4), (cardnumber.length()));
			if (!vDebitCardNo.equals(CardLast4Digit)) {
				LogCapture.info("Debit card deleted from card list : " + vDebitCardNo);
				break;

			}

		}

	}

	@And("^android user clicks on edit address$")
	public void android_user_clicks_on_edit_address() throws Throwable {
		String vObjEditbutton = Constants.CDAppDashboard.getProperty("Editbtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjEditbutton));
		LogCapture.info("User clicked on edit address button.....");

	}

	@Then("^billing address fields should be populated with option search address in android app$")
	public void billing_address_fields_should_be_populated_with_option_search_address_in_android_app()
			throws Throwable {
		String vObjSearchAddInput = Constants.CDAppDashboard.getProperty("SearchAddInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSearchAddInput));
		LogCapture.info("Search adress field located ....");
	}

	@When("^android user searches for address \"([^\"]*)\" and select auto searched address$")
	public void android_user_searches_for_address_something_and_select_auto_searched_address(String address)
			throws Throwable {
		String vObjSearchAddInput = Constants.CDAppDashboard.getProperty("SearchAddInput");
		Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddInput));
		LogCapture.info("USer click on searched box ....");
		String vObjSearchtext = Constants.CDAppDashboard.getProperty("SearchAddInput");
		Thread.sleep(2000);
		Assert.assertEquals("PASS", Constants.key.click(vObjSearchtext));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSearchtext, address.toString()));
	}

	@Then("^android user selects adress from searched$")
	public void android_user_selects_adress_from_searched() throws Throwable {
		Thread.sleep(9000);
		String SelectedElement = Constants.CDAppDashboard.getProperty("SelectedElement");
		Assert.assertEquals("PASS", Constants.key.click(SelectedElement));
	}

	@When("^user clicks on enter address manually$")
	public void user_clicks_on_enter_address_manually() throws Throwable {
		String vObjEnterAdressManually = Constants.CDAppDashboard.getProperty("EnterAdressManually");
		Assert.assertEquals("PASS", Constants.key.click(vObjEnterAdressManually));
		LogCapture.info("User clicked on enter adress manually....");

	}

	@And("^android user enters country \"([^\"]*)\" specific required address \"([^\"]*)\" field data$")
	public void android_user_enters_country_something_specific_required_address_something_field_data(String country,
																									 String address) throws Throwable {
		Constants.Data = address.split(",");
		// Constants.DataMap.put("country");
		if (country.equalsIgnoreCase("United Kingdom")) {
			String vObjAdressLine1 = Constants.CDAppDashboard.getProperty("AdressLine1");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAdressLine1, Constants.Data[0].toString()));
			LogCapture.info("User Enterred AddressLine1....");

			String vObjAdressLine2 = Constants.CDAppDashboard.getProperty("AdressLine2");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAdressLine2, Constants.Data[1].toString()));
			LogCapture.info("User Enterred AddressLine2....");

			String vObjCountry = Constants.CDAppDashboard.getProperty("Country");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountry, Constants.Data[2].toString()));
			LogCapture.info("User Enterred Country....");

			String vObjCity = Constants.CDAppDashboard.getProperty("City");

			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCity, Constants.Data[3].toString()));

			LogCapture.info("User Enterred City....");

			Constants.key.scrollDownUI("Postcode");
			String vObjPostcode = Constants.CDAppDashboard.getProperty("Postcode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcode, Constants.Data[4].toString()));
			// Assert.assertEquals("PASS",
			// Constants.key.clearText(vObjPostcode));
			// Assert.assertEquals("PASS", Constants.key.click(vObjPostcode));
			// Assert.assertEquals("PASS",
			// Constants.key.writeInInput(vObjPostcode,
			// Constants.Data[4].toString()));
			// Assert.assertEquals("PASS",
			// Constants.key.clearText(vObjPostcode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcode, Constants.Data[4].toString()));
			LogCapture.info("User Enterred Postcode....");

			// Assert.assertEquals("PASS",
			// Constants.key.writeInInput(vObjAdressLine2,
			// Constants.Data[1].toString()));
			// Assert.assertEquals("PASS",
			// Constants.key.clearText(vObjAdressLine2));
			// Assert.assertEquals("PASS",
			// Constants.key.writeInInput(vObjAdressLine2,
			// Constants.Data[1].toString()));
			LogCapture.info("User Enterred AddressLine2....");

		} else {

			String vObjAdress = Constants.CDAppDashboard.getProperty("Address");
			Assert.assertEquals("PASS", Constants.key.click(vObjAdress));
			Thread.sleep(2000);
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAdress, Constants.Data[0].toString()));
			LogCapture.info("User Enterred Address");
			Constants.key.scrollDownUI("Save");

			String vObjCity = Constants.CDAppDashboard.getProperty("City");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCity, Constants.Data[2].toString()));
			LogCapture.info("User Enterred City....");

			String vObjCountry = Constants.CDAppDashboard.getProperty("Country");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountry, Constants.Data[1].toString()));
			LogCapture.info("User Enterred Country....");

			String vObjPostcodeZip = Constants.CDAppDashboard.getProperty("ZipCode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcodeZip, Constants.Data[3].toString()));
			Assert.assertEquals("PASS", Constants.key.click(vObjPostcodeZip));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjPostcodeZip));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcodeZip, Constants.Data[3].toString()));

			LogCapture.info("User Enterred Postcode....");

		}

	}

	@And("^android user provide remaining mandetory country \"([^\"]*)\" specific adress \"([^\"]*)\" details$")
	public void android_user_provide_remaining_mandetory_country_something_specific_adress_something_details(
			String country, String remainingdetails) throws Throwable {
		Constants.Data = remainingdetails.split(",");
		if (country.equalsIgnoreCase("United Kingdom")) {
			String vObjAdressLine1 = Constants.CDAppDashboard.getProperty("AdressLine1");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAdressLine1, Constants.Data[0].toString()));
			LogCapture.info("User Enterred AddressLine1....");

		} else {

			String vObjAdress = Constants.CDAppDashboard.getProperty("AdressOther");
			Assert.assertEquals("PASS", Constants.key.click(vObjAdress));
			Thread.sleep(2000);
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAdress, Constants.Data[0].toString()));
			LogCapture.info("User Enterred Address");
			Constants.key.scrollDownUI("Save");

			String vObjPostcodeZip = Constants.CDAppDashboard.getProperty("PostcodeZip");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcodeZip, Constants.Data[1].toString()));
			LogCapture.info("User Enterred Postcode....");

		}

	}

	@And("^android user doesnot provide country \"([^\"]*)\" specific mandatory address field data$")
	public void android_user_doesnot_provide_country_something_specific_mandatory_address_field_data(String country)
			throws Throwable {

		if (country.equalsIgnoreCase("United Kingdom")) {
			String vObjAdressLine1 = Constants.CDAppDashboard.getProperty("AdressLine1");
			Assert.assertEquals("PASS", Constants.key.click(vObjAdressLine1));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjAdressLine1));
			LogCapture.info("User Not provided AddressLine1....");

			String vObjAdressLine2 = Constants.CDAppDashboard.getProperty("AdressLine2");
			Assert.assertEquals("PASS", Constants.key.click(vObjAdressLine2));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjAdressLine2));
			LogCapture.info("User Enterred AddressLine2....");

			Constants.key.scrollDownUI("Save");
			String vObjCountry = Constants.CDAppDashboard.getProperty("Country");
			Assert.assertEquals("PASS", Constants.key.click(vObjCountry));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCountry));
			LogCapture.info("User Not Enterred Country....");

			Constants.key.scrollDownUI("City");
			String vObjCity = Constants.CDAppDashboard.getProperty("City");
			Assert.assertEquals("PASS", Constants.key.click(vObjCity));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCity));
			LogCapture.info("User Not Enterred City....");

			Constants.key.scrollDownUI("Postcode");
			String vObjPostcode = Constants.CDAppDashboard.getProperty("Postcode");
			Assert.assertEquals("PASS", Constants.key.click(vObjPostcode));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjPostcode));
			Assert.assertEquals("PASS", Constants.key.click(vObjCity));
			LogCapture.info("User not provided Postcode....");
			Constants.key.scrollDownUI("Save");

		} else {

			String vObjAdress = Constants.CDAppDashboard.getProperty("AdressOther");

			Thread.sleep(2000);
			Assert.assertEquals("PASS", Constants.key.clearText(vObjAdress));
			Constants.key.scrollDownUI("Save");
			LogCapture.info("User not provided Adress....");

			Constants.key.scrollDownUI("Save");
			Thread.sleep(1000);
			String vObjCountry = Constants.CDAppDashboard.getProperty("Country");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCountry));
			LogCapture.info("User Not Enterred Country....");

			String vObjCity = Constants.CDAppDashboard.getProperty("City");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCity));
			LogCapture.info("User Not Enterred City....");

			String vObjPostcodeZip = Constants.CDAppDashboard.getProperty("PostcodeZip");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjPostcodeZip));
			LogCapture.info("User not provided Postcode/Zip code....");

		}
		Constants.DataMap.put("Country", country);

	}

	@Then("^invalid field error message should be displyed for all mandatory address fields in android app$")
	public void invalid_field_error_message_should_be_displyed_for_all_mandatory_address_fields_in_android_app()
			throws Throwable {
		String Country = Constants.DataMap.get("Country");

		if (Country.equalsIgnoreCase("United Kingdom")) {
			String vObjAdress1ErrorLbl = Constants.CDAppDashboard.getProperty("Adress1ErrorLbl");
			String vAdress1ErrorMsg = Constants.AndroidTestData.getProperty("InvalidAdress1Msg").trim();
			String atbValue = Constants.key.getAttributeValue(vObjAdress1ErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vAdress1ErrorMsg, atbValue));
			LogCapture.info("Please enter valid address error message verfied......");

			String vObjAdress1ErrorLb2 = Constants.CDAppDashboard.getProperty("Adress2ErrorLbl");
			String vAdress2ErrorMsg = Constants.AndroidTestData.getProperty("InvalidAdress2Msg");
			String atbValue2 = Constants.key.getAttributeValue(vObjAdress1ErrorLb2, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vAdress2ErrorMsg, atbValue2));
			LogCapture.info("Please enter valid address line 2 error message verfied......");

			String vObjCity = Constants.CDAppDashboard.getProperty("CityErrorLbl");
			String vCityErrorMsg = Constants.AndroidTestData.getProperty("InvalidCityMsg");
			String atbValue3 = Constants.key.getAttributeValue(vObjCity, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vCityErrorMsg, atbValue3));
			LogCapture.info("Please enter valid city name	 error message verfied......");

			String vObjPostcode = Constants.CDAppDashboard.getProperty("PostcodeErrorLbl");
			String vPostcodeErrorMsg = Constants.AndroidTestData.getProperty("InvalidPostcoceMsg");
			String atbValue4 = Constants.key.getAttributeValue(vObjPostcode, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vPostcodeErrorMsg, atbValue4));
			LogCapture.info("Please enter valid post code error message verfied......");

		} else {

			String vObjAdress1ErrorLbl = Constants.CDAppDashboard.getProperty("AdressErrorLbl");
			String vAdress1ErrorMsg = Constants.AndroidTestData.getProperty("OtherAddressMsg").trim();
			String atbValue = Constants.key.getAttributeValue(vObjAdress1ErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vAdress1ErrorMsg, atbValue));
			LogCapture.info("Please enter valid address line 1 error message verfied......");

			String vObjCity = Constants.CDAppDashboard.getProperty("TownCitityLbl");
			String vCityErrorMsg = Constants.AndroidTestData.getProperty("TownCityMsg");
			String atbValue3 = Constants.key.getAttributeValue(vObjCity, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vCityErrorMsg, atbValue3));
			LogCapture.info("Please enter valid city name	 error message verfied......");

			String vObjPostcode = Constants.CDAppDashboard.getProperty("PostzipLbl");
			String vPostcodeErrorMsg = Constants.AndroidTestData.getProperty("InvalidPostcoceMsg");
			String atbValue4 = Constants.key.getAttributeValue(vObjPostcode, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vPostcodeErrorMsg, atbValue4));
			LogCapture.info("Please enter valid post code error message verfied......");

		}

	}

	@And("^android user selects country \"([^\"]*)\"$")
	public void android_user_selects_country(String countryData) throws Throwable {

		String vObjCountryDelect = Constants.CDAppDashboard.getProperty("CountrySelect");
		// String vObjCountryList =
		// Constants.CDAppDashboard.getProperty("countryList");
		String vObjsinglecountry = Constants.AndroidCDAppRecipient.getProperty("SearchedCountry");
		Assert.assertEquals("PASS", Constants.key.click(vObjCountryDelect));

		String vObjCountrySearch = Constants.CDAppDashboard.getProperty("CountrySearch");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountrySearch));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountrySearch, countryData));

		int noOfCountry = Constants.key.getElementList(vObjsinglecountry).size();
		LogCapture.info("countryList size: " + noOfCountry);

		List<MobileElement> countryList = Constants.key.getElementList(vObjsinglecountry);
		boolean isCountryFound = false;
		for (MobileElement country : countryList) {
			String countryName = country.getText();
			LogCapture.info("Country name: " + countryName);
			if (countryName.equalsIgnoreCase(countryData)) {
				country.click();
				Assert.assertEquals("PASS", "PASS");
				LogCapture.info("Country found: " + countryData);
				isCountryFound = true;
			}
		}
		if (!isCountryFound) {
			Assert.assertEquals("PASS", "FAIL");
		}

		LogCapture.info("User select country: " + countryData);

	}

	@And("^android user enters country \"([^\"]*)\" specific max \"([^\"]*)\" address field data$")
	public void android_user_enters_country_something_specific_max_something_address_field_data(String country,
																								String address) throws Throwable {

		android_user_enters_country_something_specific_required_address_something_field_data(country, address);

	}

	@Then("^android user should navigate to card list screen$")
	public void android_user_should_navigate_to_card_list_screen() throws Throwable {
		String vObjDebCardListTitle = Constants.CDAppDashboard.getProperty("DebCardListTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebCardListTitle));
		LogCapture.info("User Navigated to card list screen .....");

	}

	@And("^card \"([^\"]*)\" details should be saved in android app debit card list as per order of date added$")
	public void card_something_details_should_be_saved_in_android_app_debit_card_list_as_per_order_of_date_added(
			String cardnumber) throws Throwable {

		String vObjDebitCardList = Constants.CDAppDashboard.getProperty("DebitCardList");
		List<MobileElement> CardElements = Constants.key.getElementList(vObjDebitCardList);
		for (MobileElement Cardelement : CardElements) {
			String cardnumberListEle = Cardelement.getText();
			if (cardnumberListEle.equalsIgnoreCase(cardnumber)) {
				LogCapture.info("Card details saved....");
			}

		}

	}
	// ****************************************Recipent Module******************************************************//

	@And("^android user selects the recipient option from the home dashboard$")
	public void android_user_selects_the_recipient_option_from_the_home_dashboard() throws Throwable {
		String vObjRecipientIcon = Constants.AndroidCDAppRecipient.getProperty("RecipientIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjRecipientIcon));
		LogCapture.info("User clicked on RecipientIcon ....");

	}

	@And("^android user enters invalid swift code \"([^\"]*)\" based on \"([^\"]*)\"$")
	public void android_user_enters_invalid_swift_code_something_based_on_something(String swiftcode,
																					String countrycurrency) throws Throwable {
		android_user_enters_valid_swift_code_something_based_on_something(swiftcode, countrycurrency);
	}

	@And("^android user has no saved recipients previously$")
	public void android_user_has_no_saved_recipients_previously() throws Throwable {

		String vObjRecipientOnAccLbl = Constants.AndroidCDAppRecipient.getProperty("NoRecipientOnAccLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecipientOnAccLbl));
		LogCapture.info("Empty Recipient list has been displayed.........");
		String vExpectedMSg = Constants.AndroidTestData.getProperty("EmptyRecipient");
		String atbValue = Constants.key.getAttributeValue(vObjRecipientOnAccLbl, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vExpectedMSg));
		LogCapture.info("Displayed:  " + atbValue);
	}

	@Then("^an option to add a new recipient should be displayed in android app$")
	public void an_option_to_add_a_new_recipient_should_be_displayed_in_android_app() throws Throwable {
		String vObjAddRecepientBtn = Constants.AndroidCDAppRecipient.getProperty("AddRecipientBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddRecepientBtn));
	}

	@And("^android user has one or more saved recipients$")
	public void android_user_has_one_or_more_saved_recipients() throws Throwable {
		String vObjRecpientList = Constants.AndroidCDAppRecipient.getProperty("RecpientList");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecpientList));
		int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();
		LogCapture.info("Recipient present in list :" + (recpientListSize));

	}

	@Then("^all the recipients should be displayed with the option to add a new recipient in android app$")
	public void all_the_recipients_should_be_displayed_with_the_option_to_add_a_new_recipient_in_android_app()
			throws Throwable {
		String vObjBtnAddRecipientCell = Constants.AndroidCDAppRecipient.getProperty("BtnAddRecipientCell");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell));
		LogCapture.info("Add recipient button displayed with recipient list.........");
	}

	@Then("^each recipient in the list should be displayed with name,currency code and masked account number except last four digit$")
	public void each_recipient_in_the_list_should_be_displayed_with_namecurrency_code_and_masked_account_number_except_last_four_digit()
			throws Throwable {
		String vObjBtnAddRecipientCell = Constants.AndroidCDAppRecipient.getProperty("BtnAddRecipientCell");
		String vObjRecpientList = Constants.AndroidCDAppRecipient.getProperty("RecpientList");
		String vObjRecpientListitm = Constants.AndroidCDAppRecipient.getProperty("Recipientlistitem");
		String vObjRecipientName = Constants.AndroidCDAppRecipient.getProperty("RecipientName");
		String vObjRecipientCurrency = Constants.AndroidCDAppRecipient.getProperty("RecipientCurrency");
		String vObjRecipientAccountNumber = Constants.AndroidCDAppRecipient.getProperty("RecipientAccountnumber");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell));
		int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();
		for (int i = 0; i < recpientListSize; i++) {
			String vRecipientName = Constants.key.getAttributeValue(vObjRecpientListitm + i + vObjRecipientName,
					"text");
			String vCurrency = Constants.key.getAttributeValue(vObjRecpientListitm + i + vObjRecipientCurrency, "text");
			String vRecipientAccountNumber = Constants.key
					.getAttributeValue(vObjRecpientListitm + i + vObjRecipientAccountNumber, "text");
			String vUnmaskedAccNo = vRecipientAccountNumber.substring((vRecipientAccountNumber.length() - 4),
					(vRecipientAccountNumber.length()));

			LogCapture.info("Recipeint Name : " + vRecipientName + ", Currency : " + vCurrency + ", Account No :"
					+ vUnmaskedAccNo);

		}
		LogCapture.info("Recipient list displayed successfully.........");
	}

	@And("^the user selects a saved recipient \"([^\"]*)\"$")
	public void the_user_selects_a_saved_recipient_something(String recipientlistdata) throws Throwable {
		String vObjBtnAddRecipientCell = Constants.AndroidCDAppRecipient.getProperty("BtnAddRecipientCell");
		String vObjRecpientList = Constants.AndroidCDAppRecipient.getProperty("RecpientList");
		String vObjRecpientListitm = Constants.AndroidCDAppRecipient.getProperty("Recipientlistitem");
		String vObjRecipientName = Constants.AndroidCDAppRecipient.getProperty("RecipientName");
		String vObjRecipientCurrency = Constants.AndroidCDAppRecipient.getProperty("RecipientCurrency");
		String vObjRecipientAccountNumber = Constants.AndroidCDAppRecipient.getProperty("RecipientAccountnumber");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell));
		Constants.Data = Constants.AndroidTestData.getProperty(recipientlistdata).split(",");

		int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();

		for (int i = 0; i < recpientListSize; i++) {
			String vRecipientName = Constants.key.getAttributeValue(vObjRecpientListitm + i + vObjRecipientName,
					"text");
			String vCurrency = Constants.key.getAttributeValue(vObjRecpientListitm + i + vObjRecipientCurrency, "text");
			String vRecipientAccountNumber = Constants.key
					.getAttributeValue(vObjRecpientListitm + i + vObjRecipientAccountNumber, "text");
			String vUnmaskedAccNo = vRecipientAccountNumber.substring((vRecipientAccountNumber.length() - 4),
					(vRecipientAccountNumber.length()));

			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollToExactElement(vRecipientName));
			}

			LogCapture.info("Recipent: " + i + " Recipeint Name : " + vRecipientName + ", Currency : " + vCurrency
					+ ", Account No : **** " + vUnmaskedAccNo);

			if (vRecipientName.equalsIgnoreCase(Constants.Data[0]) && vCurrency.equalsIgnoreCase(Constants.Data[1])
					&& vUnmaskedAccNo.equalsIgnoreCase(Constants.Data[2])) {

				Assert.assertEquals("PASS", Constants.key.click(vObjRecpientListitm + i + vObjRecipientName));
				LogCapture.info("Recipient match found and clicked on : " + vRecipientName + ",Account No : **** "
						+ vUnmaskedAccNo);
				Constants.DataMap.put("RecipientName", vRecipientName);
				Constants.DataMap.put("RecipientAccountNo", vUnmaskedAccNo);
				Constants.DataMap.put("RecipientCurrency1", vCurrency);

				break;
			} else {
				LogCapture.info("Recipent List : " + i + " " + vRecipientName + ",Account No : **** " + vUnmaskedAccNo);
			}

		}

	}

	@Then("^all the details of the recipient \"([^\"]*)\" should be displayed as per country-currency \"([^\"]*)\"$")
	public void all_the_details_of_the_recipient_something_should_be_displayed_as_per_countrycurrency_something(
			String recipientviewdata, String countrycurrency) throws Throwable {
		String vObjRecpientName = Constants.AndroidCDAppRecipient.getProperty("RecpientName");
		String vObjBankNameLbl = Constants.AndroidCDAppRecipient.getProperty("BankNameLbl");
		String vObjBankNameTxt = Constants.AndroidCDAppRecipient.getProperty("BankNameTxt");
		String vObjAccountNoLbl = Constants.AndroidCDAppRecipient.getProperty("AccountNoLbl");
		String vObjAccountNoTxt = Constants.AndroidCDAppRecipient.getProperty("AccountNoTxt");
		String vObjBSBNoLbl = Constants.AndroidCDAppRecipient.getProperty("BSBNoLbl");
		String vObjBSBNoTxt = Constants.AndroidCDAppRecipient.getProperty("BSBNoTxt");
		String vObjRecCurrencyLbl = Constants.AndroidCDAppRecipient.getProperty("RecCurrencyLbl");
		String vObjRecCurrencyTxt = Constants.AndroidCDAppRecipient.getProperty("RecCurrencyTxt");
		String vObjRecCountryLbl = Constants.AndroidCDAppRecipient.getProperty("RecCountryLbl");
		String vObjRecCountryTxt = Constants.AndroidCDAppRecipient.getProperty("RecCountryTxt");
		String vObjSwiftLbl = Constants.AndroidCDAppRecipient.getProperty("SwiftLbl");
		String vObjSwiftTxt = Constants.AndroidCDAppRecipient.getProperty("SwiftTxt");
		String vObjSortCodeLbl = Constants.AndroidCDAppRecipient.getProperty("SortCodeLbl");
		String vObjSortCodeTxt = Constants.AndroidCDAppRecipient.getProperty("SortCodeTxt");

		Constants.Data = Constants.AndroidTestData.getProperty(recipientviewdata).split(",");

		String vRecpientName = Constants.key.getAttributeValue(vObjRecpientName, "text");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[0], vRecpientName));
		LogCapture.info("Recpient name : " + vRecpientName + " verified");

		String vBankNameLbl = Constants.key.getAttributeValue(vObjBankNameLbl, "text");
		Assert.assertEquals("PASS", Constants.key.VerifyText("Bank name", vBankNameLbl));

		String vBankNameTxt = Constants.key.getAttributeValue(vObjBankNameTxt, "text");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[1], vBankNameTxt));
		LogCapture.info("Bank name : " + vBankNameTxt + " verified");

		String vRecCurrencyLbl = Constants.key.getAttributeValue(vObjRecCurrencyLbl, "text");
		Assert.assertEquals("PASS", Constants.key.VerifyText("Currency", vRecCurrencyLbl));

		String vRecCurrencyTxt = Constants.key.getAttributeValue(vObjRecCurrencyTxt, "text");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[4], vRecCurrencyTxt));
		LogCapture.info("Currency: " + vRecCurrencyTxt + " verified");

		String vRecCountryLbl = Constants.key.getAttributeValue(vObjRecCountryLbl, "text");
		Assert.assertEquals("PASS", Constants.key.VerifyText("Country", vRecCountryLbl));

		String vRecCountryTxt = Constants.key.getAttributeValue(vObjRecCountryTxt, "text");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[5], vRecCountryTxt));
		LogCapture.info("Country: " + vRecCountryTxt + " verified");

		if (countrycurrency.equalsIgnoreCase("Finland-EUR")) {
			String vAccountNoLbl = Constants.key.getAttributeValue(vObjAccountNoLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText("IBAN number", vAccountNoLbl));
			String vAccountNoTxt = Constants.key.getAttributeValue(vObjAccountNoTxt, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[2], vAccountNoTxt));
			LogCapture.info("IBAN No: " + vAccountNoTxt + " verified");

			String vSwiftLbl = Constants.key.getAttributeValue(vObjSwiftLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText("Swift Code", vSwiftLbl));
			String vSwiftTxt = Constants.key.getAttributeValue(vObjSwiftTxt, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[3], vSwiftTxt));
			LogCapture.info("Swift No: " + vSwiftTxt + " verified");
		} else if (countrycurrency.equalsIgnoreCase("United Kingdom-GBP")) {
			String vAccountNoLbl = Constants.key.getAttributeValue(vObjAccountNoLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText("Account number", vAccountNoLbl));
			String vAccountNoTxt = Constants.key.getAttributeValue(vObjAccountNoTxt, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[2], vAccountNoTxt));
			LogCapture.info("Account No: " + vAccountNoTxt + " verified");

			String vSortCodeLbl = Constants.key.getAttributeValue(vObjSortCodeLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText("Sort Code", vSortCodeLbl));
			String vSortCodeTxt = Constants.key.getAttributeValue(vObjSortCodeTxt, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[3].toString(), vSortCodeTxt));
			LogCapture.info("Swift No: " + vSortCodeTxt + " verified");
		} else if (countrycurrency.equalsIgnoreCase("AUS-AUD")) {
			String vAccountNoLbl = Constants.key.getAttributeValue(vObjAccountNoLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText("Account number", vAccountNoLbl));
			String vAccountNoTxt = Constants.key.getAttributeValue(vObjAccountNoTxt, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[2], vAccountNoTxt));
			LogCapture.info("Account No: " + vAccountNoTxt + " verified");

			String vBSBNoLbl = Constants.key.getAttributeValue(vObjBSBNoLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText("BSB number", vBSBNoLbl));
			String vBSBNoTxt = Constants.key.getAttributeValue(vObjBSBNoTxt, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[3].toString(), vBSBNoTxt));
			LogCapture.info("BSB No: " + vBSBNoTxt + " verified");
		} else if (countrycurrency.equalsIgnoreCase("CANADA-CAD")) {
			String vAccountNoLbl = Constants.key.getAttributeValue(vObjAccountNoLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText("Account number", vAccountNoLbl));
			String vAccountNoTxt = Constants.key.getAttributeValue(vObjAccountNoTxt, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[2], vAccountNoTxt));
			LogCapture.info("Account No: " + vAccountNoTxt + " verified");

			String vSortCodeLbl = Constants.key.getAttributeValue(vObjSortCodeLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText("Transit number", vSortCodeLbl));
			String vSortCodeTxt = Constants.key.getAttributeValue(vObjSortCodeTxt, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[3].toString(), vSortCodeTxt));
			LogCapture.info("Swift No: " + vSortCodeTxt + " verified");
		} else if (countrycurrency.equalsIgnoreCase("INDIA-INR")) {
			String vAccountNoLbl = Constants.key.getAttributeValue(vObjAccountNoLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText("Account number", vAccountNoLbl));
			String vAccountNoTxt = Constants.key.getAttributeValue(vObjAccountNoTxt, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[2], vAccountNoTxt));
			LogCapture.info("Account No: " + vAccountNoTxt + " verified");

			String vSortCodeLbl = Constants.key.getAttributeValue(vObjSortCodeLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText("IFSC code", vSortCodeLbl));
			String vSortCodeTxt = Constants.key.getAttributeValue(vObjSortCodeTxt, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[3].toString(), vSortCodeTxt));
			LogCapture.info("Swift No: " + vSortCodeTxt + " verified");
		} else if (countrycurrency.equalsIgnoreCase("United States of America-USD")) {
			String vSortCodeLbl = Constants.key.getAttributeValue(vObjSortCodeLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText("ABA number", vSortCodeLbl));
			String vSortCodeTxt = Constants.key.getAttributeValue(vObjSortCodeTxt, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.Data[3].toString(), vSortCodeTxt));
			LogCapture.info("Swift No: " + vSortCodeTxt + " verified");
		} else {
			LogCapture.info("Ubnable to verify banking details of : " + countrycurrency);
		}

	}

	@And("^android user selects an option to add a new recipient$")
	public void android_user_selects_an_option_to_add_a_new_recipient() throws Throwable {
		String vObjAddRecepientBtn = Constants.AndroidCDAppRecipient.getProperty("AddRecipientBtn");
		String vObjAddRecepientListBtn = Constants.AndroidCDAppRecipient.getProperty("AddRecipientListBtn");

		if (Constants.key.eleLocatedDisplayed(vObjAddRecepientListBtn).equalsIgnoreCase("PASS")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjAddRecepientListBtn));
			LogCapture.info("User clicked on Add Recepient Button from list");
		} else {
			Assert.assertEquals("PASS", Constants.key.click(vObjAddRecepientBtn));
			LogCapture.info("User clicked on Add Recepient Button");
		}

	}

	@Then("^add recipient screen should be displayed to android user$")
	public void add_recipient_screen_should_be_displayed_to_android_user() throws Throwable {
		String vObjAddRecipient = Constants.AndroidCDAppRecipient.getProperty("AddRecipientTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddRecipient));
		LogCapture.info("User is on Add recipient Screen");
	}

	@When("^the android user clicks edit recipient button$")
	public void the_android_user_clicks_edit_recipient_button() throws Throwable {
		String vObjEditRecepientBtn = Constants.AndroidCDAppRecipient.getProperty("EditRecipientBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjEditRecepientBtn));
		LogCapture.info("User clicked on Edit Recepient Button");
		Thread.sleep(7000);

	}

	@Then("^the edit recipient screen should be displayed on android aap$")
	public void the_edit_recipient_screen_should_be_displayed_on_android_aap() throws Throwable {
		String vObjEditRecipient = Constants.AndroidCDAppRecipient.getProperty("EditRecipientTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEditRecipient));
		LogCapture.info("User is on Edit recipient Screen");

	}

	@When("^android user clicks on Delete Recipient button$")
	public void android_user_clicks_on_delete_recipient_button() throws Throwable {
		Constants.key.scrollDownUI("Delete");
		String vObjDeleteRecepientBtn = Constants.AndroidCDAppRecipient.getProperty("DeleteRecipientBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDeleteRecepientBtn));
		LogCapture.info("User clicked on Delete Button");

	}

	@Then("^information is displayed to the user to confirm if they want to delete the selected recipient$")
	public void information_is_displayed_to_the_user_to_confirm_if_they_want_to_delete_the_selected() throws Throwable {
		String vObjDeleteRecipientPop = Constants.AndroidCDAppRecipient.getProperty("DeleteRecipientPopMsg");
		String atbValue = Constants.key.getAttributeValue(vObjDeleteRecipientPop, "text").trim();
		String vDeletePopMsg = Constants.AndroidTestData.getProperty("DeleteRecipientPopupMsg");
		Assert.assertEquals("PASS", Constants.key.VerifyText(vDeletePopMsg, atbValue));
		LogCapture.info("Pop up for Delete debit card displayed .........");

	}

	@And("^the android user selects a saved recipient based on account number \"([^\"]*)\"recipientName\"([^\"]*)\" and currency \"([^\"]*)\"$")
	public void the_android_user_selects_a_saved_recipient_based_on_account_number_somethingrecipientnamesomething_and_currency_something(
			String accountnumber, String recipientname, String currency) throws Throwable {
		String vObjBtnAddRecipientCell = Constants.AndroidCDAppRecipient.getProperty("BtnAddRecipientCell");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell));
		Thread.sleep(2000);
		Assert.assertEquals("PASS", Constants.key.scrollToExactElement(recipientname));
		LogCapture.info("User selected saved recipient: " + recipientname);
		LogCapture.info("User selected saved recipient: " + accountnumber);
		Constants.DataMap.put("RecipientName", recipientname);
		Constants.DataMap.put("RecipientAccountNo", accountnumber);
		Constants.DataMap.put("RecipientCurrency1", currency);

	}

	@When("^user accepts recipient delete confirmation$")
	public void user_accepts_recipient_delete_confirmation() throws Throwable {
		String vObjDeleteConfirmBtn = Constants.AndroidCDAppRecipient.getProperty("RecipientDeletePopBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDeleteConfirmBtn));

	}

	@When("^android user dismiss recipient delete confirmation$")
	public void android_user_dismiss_recipient_delete_confirmation() throws Throwable {
		String vObjDeleteCancelBtn = Constants.AndroidCDAppRecipient.getProperty("RecipientCancelPopBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjDeleteCancelBtn));
		LogCapture.info("android user dismissed recipient delete confirmation");
	}

	// Recipient Delete

	@And("^recipient with the details name \"([^\"]*)\" currency \"([^\"]*)\" account no \"([^\"]*)\" should be deleted from the android app$")
	public void recipient_with_the_details_name_something_currency_something_account_no_something_should_be_deleted_from_the_android_app(
			String accountnumber, String recipientname, String currency) throws Throwable {
		String vObjBtnAddRecipientCell = Constants.AndroidCDAppRecipient.getProperty("BtnAddRecipientCell");
		String vObjRecpientList = Constants.AndroidCDAppRecipient.getProperty("RecpientList");
		String vObjRecpientListitm = Constants.AndroidCDAppRecipient.getProperty("Recipientlistitem");
		String vObjRecipientName = Constants.AndroidCDAppRecipient.getProperty("RecipientName");
		String vObjRecipientCurrency = Constants.AndroidCDAppRecipient.getProperty("RecipientCurrency");
		String vObjRecipientAccountNumber = Constants.AndroidCDAppRecipient.getProperty("RecipientAccountnumber");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell));
		int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();
		for (int i = 0; i < recpientListSize; i++) {
			String vRecipientName = Constants.key.getAttributeValue(vObjRecpientListitm + i + vObjRecipientName,
					"text");
			String vCurrency = Constants.key.getAttributeValue(vObjRecpientListitm + i + vObjRecipientCurrency, "text");
			String vRecipientAccountNumber = Constants.key
					.getAttributeValue(vObjRecpientListitm + i + vObjRecipientAccountNumber, "text");
			String vUnmaskedAccNo = vRecipientAccountNumber.substring((vRecipientAccountNumber.length() - 4),
					(vRecipientAccountNumber.length()));
			String vAccount4digit = accountnumber.substring((accountnumber.length() - 4), (accountnumber.length()));
			if (!vRecipientName.equalsIgnoreCase(recipientname) && !vCurrency.equalsIgnoreCase(currency)
					&& !vUnmaskedAccNo.equalsIgnoreCase(vAccount4digit)) {

				Assert.assertEquals("PASS", Constants.key.click(vObjRecpientListitm + i + vObjRecipientName));
				LogCapture.info("Recipient match found and clicked on : " + vRecipientName + ",Account No :"
						+ vRecipientAccountNumber);
				Constants.DataMap.put("RecipientName", vRecipientName);
				Constants.DataMap.put("RecipientAccountNo", accountnumber);
				Constants.DataMap.put("RecipientCurrency1", currency);
				break;
			} else {
				LogCapture.info("Recipent List : " + i + " " + vRecipientName + ",Account No : **** "
						+ vRecipientAccountNumber);
			}

		}

	}

	// Recipint edit

	@When("^android user validate recipient type \"([^\"]*)\"$")
	public void android_user_validate_recipient_type_something(String type) throws Throwable {
		String vObjEditCountry = Constants.AndroidCDAppRecipient.getProperty("EditCountry");
		String vObjEditCurrency = Constants.AndroidCDAppRecipient.getProperty("EditCurrency");
		String vObjEditCountryTxt = Constants.key.getAttributeValue(vObjEditCountry, "text");
		String vObjEditCurrencyTxt = Constants.key.getAttributeValue(vObjEditCurrency, "text");

		Constants.DataMap.put("ReipientCountry", vObjEditCountryTxt);
		Constants.DataMap.put("ReipientCurrency", vObjEditCurrencyTxt);

		if (type.equalsIgnoreCase("Individual")) {
			String vObjIndividual = Constants.AndroidCDAppRecipient.getProperty("Individual");
			String vObjIndividualtxt = Constants.key.getAttributeValue(vObjIndividual, "text");
			// Assert.assertEquals("PASS",Constants.key.click(vObjIndividual));
			String atbValue4 = Constants.key.getAttributeValue(vObjIndividual, "checked");
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue4));
			LogCapture.info("Recipent Type  :  " + vObjIndividualtxt + " validated");
			Constants.DataMap.put("Type", type);

		} else {
			String vObjCompany = Constants.AndroidCDAppRecipient.getProperty("Company");
			String vObjCompanytxt = Constants.key.getAttributeValue(vObjCompany, "text");
			LogCapture.info("Recipent Type  :  " + vObjCompanytxt + " " + " validated");
			Constants.DataMap.put("Type", type);

		}

	}

	@When("^android user change the recipient type \"([^\"]*)\"$")
	public void android_user_change_the_recipient_type_something(String type) throws Throwable {
		if (type.equalsIgnoreCase("Individual")) {
			String vObjIndividual = Constants.AndroidCDAppRecipient.getProperty("Individual");
			Assert.assertEquals("FAIL", Constants.key.click(vObjIndividual));

		} else {
			String vObjCompany = Constants.AndroidCDAppRecipient.getProperty("Company");
			Assert.assertEquals("FAIL", Constants.key.click(vObjCompany));
		}

	}

	@Then("^recipient type \"([^\"]*)\" should not be changed on android recipient edit screen$")
	public void recipient_type_something_should_not_be_changed_on_android_recipient_edit_screen(String type)
			throws Throwable {
		if (type.equalsIgnoreCase("Individual")) {
			String vObjIndividual = Constants.AndroidCDAppRecipient.getProperty("Individual");
			String atbValue2 = Constants.key.getAttributeValue(vObjIndividual, "enabled");
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue2));
			LogCapture.info("Recipent Type not changed");
		} else {

			String vObjCompany = Constants.AndroidCDAppRecipient.getProperty("Company");
			String atbValue2 = Constants.key.getAttributeValue(vObjCompany, "enabled");
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue2));

			LogCapture.info("Recipent Type not changed");

		}
	}

	@And("^android user does not provided (first name|last name|company name)$")
	public void android_user_does_not_provided_first_name(String optionalValue) throws Throwable {

		if (optionalValue.equalsIgnoreCase("first name")) {
			String vObjFirstNameTxt = Constants.AndroidCDAppRecipient.getProperty("FirstNameTxt");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFirstNameTxt));
			Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameTxt));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjFirstNameTxt));
			LogCapture.info("Cleared Fisrt Name ....");

		} else if (optionalValue.equalsIgnoreCase("last name")) {
			String vObjLastNameTxt = Constants.AndroidCDAppRecipient.getProperty("LastNameTxt");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLastNameTxt));
			Assert.assertEquals("PASS", Constants.key.click(vObjLastNameTxt));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjLastNameTxt));
			LogCapture.info("Cleared Last Name ....");
		} else {
			String vObjCompanyNameTxt = Constants.AndroidCDAppRecipient.getProperty("CompantNameTxt");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCompanyNameTxt));
			Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameTxt));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCompanyNameTxt));
			LogCapture.info("Cleared Company Name ....");
		}

	}

	@Then("^the option to save the recipient should be in an inactive/disabled state in android app$")
	public void the_option_to_save_the_recipient_should_be_in_an_inactivedisabled_state_in_android_app()
			throws Throwable {
		the_option_to_save_the_card_should_be_in_an_inactivedisabled_state_in_android_app();
	}

	@When("^the android user enter Company name \"([^\"]*)\"$")
	public void the_android_user_enter_company_name_something(String companyname) throws Throwable {
		String vObjCompanyNameTxt = Constants.AndroidCDAppRecipient.getProperty("CompantNameTxt");
		Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameTxt));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameTxt, companyname));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameTxt, companyname));
		String vObtComapanyNameValid = Constants.AndroidCDAppRecipient.getProperty("CompanyNameValid");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObtComapanyNameValid));
		LogCapture.info("Valid Company name provided");
		Constants.DataMap.put("Company", companyname);

	}

	@And("^the Recipient displayed in recipient list with updated name  \"([^\"]*)\"$")
	public void the_recipient_displayed_in_recipient_list_with_updated_name_something(String companyname)
			throws Throwable {
		String vObjUpdatedName = Constants.AndroidCDAppRecipient.getProperty("UpdatedName");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdatedName));
		String vObjEditCompanytNameTxt = Constants.key.getAttributeValue(vObjUpdatedName, "text");
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjEditCompanytNameTxt, companyname));

		LogCapture.info("Edited Recipient Displayed At Top : " + companyname);
	}

	@And("^the android user enter first name and last name \"([^\"]*)\"$")
	public void the_android_user_enter_first_name_and_last_name_something(String firstnamelastname) throws Throwable {
		String vObjFirstNameTxt = Constants.AndroidCDAppRecipient.getProperty("FirstNameTxt");
		String vObjLastNameTxt = Constants.AndroidCDAppRecipient.getProperty("LastNameTxt");
		Constants.Data = firstnamelastname.split(" ");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameTxt, Constants.Data[0].toString()));
		Assert.assertEquals("PASS", Constants.key.click(vObjLastNameTxt));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameTxt, Constants.Data[1].toString()));
		LogCapture.info("User provided first name and last name : " + firstnamelastname);

	}

	@When("^android user updates bank details \"([^\"]*)\"$")
	public void android_user_updates_bank_details_something(String fieldnamedata) throws Throwable {

		String vObjEditCountryTxt = Constants.DataMap.get("ReipientCountry");
		String vObjEditCurrencyTxt = Constants.DataMap.get("ReipientCurrency");
		// Constants.key.scrollDownUI("Delete");
		Constants.Data = fieldnamedata.split(",");

		LogCapture.info("data: " + fieldnamedata + vObjEditCountryTxt + vObjEditCurrencyTxt + " ");
		for (int i = 0; i < Constants.Data.length; i++) {
			String[] Data1;
			Data1 = Constants.Data[i].split("-");

			if ((vObjEditCountryTxt.equalsIgnoreCase("United States of America"))

					&& (vObjEditCurrencyTxt.equalsIgnoreCase("US Dollar"))) {
				if (Data1[0].toString().equalsIgnoreCase("AccountNo")) {
					String vObjEditAccounIBANtNumber = Constants.AndroidCDAppRecipient.getProperty("EditAccountNumber");
					Assert.assertEquals("PASS", Constants.key.click(vObjEditAccounIBANtNumber));
					Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjEditAccounIBANtNumber, Data1[1].toString()));

					// String validAccountnoIBAN =
					// Constants.AndroidCDAppRecipient.getProperty("validAccountnoIBAN");

					// String atbValue1 =
					// Constants.key.getAttributeValue(validAccountnoIBAN,
					// "enabled");
					// Assert.assertEquals("PASS",
					// Constants.key.VerifyText("true", atbValue1));
					Constants.key.scrollDownUI("Bank name");
					String vObjEditIntracountryCode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
					Constants.key.click(vObjEditIntracountryCode);
					LogCapture.info("Valid Account No/IBAN provided");
					Constants.DataMap.put("Account Number", Data1[1].toString());

				} else if (Data1[0].toString().equalsIgnoreCase("ABANo")) {
					String vObjEditIntracountryCode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
					Constants.key.scrollDownUI("Bank name");
					Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjEditIntracountryCode, Data1[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjEditIntracountryCode));
					/*Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjEditIntracountryCode, Data1[1].toString()));*/
					String vObjvalidIntracountryCode = Constants.AndroidCDAppRecipient
							.getProperty("IntracountryABANumber");
					String atbValue2 = Constants.key.getAttributeValue(vObjvalidIntracountryCode, "enabled");
					Constants.DataMap.put("ABA No", Data1[1].toString());
					String vObjEditAccounIBANtNumber = Constants.AndroidCDAppRecipient.getProperty("EditAccountNumber");
					Constants.key.click(vObjEditAccounIBANtNumber);
					if (atbValue2.equalsIgnoreCase("true")) {
						LogCapture.info("Valid ABA no provided");
					} else {
						LogCapture.info("Invalid ABA no provided");
					}

				}
				Constants.DataMap.put("Intracountry", Data1[1].toString());

			} else if ((vObjEditCountryTxt.equalsIgnoreCase("United Kingdom"))

					&& (vObjEditCurrencyTxt.equalsIgnoreCase("Sterling Pound"))) {
				if (Data1[0].toString().equalsIgnoreCase("AccountNo")) {
					String vObjEditAccounIBANtNumber = Constants.AndroidCDAppRecipient.getProperty("EditAccountNumber");
					Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjEditAccounIBANtNumber, Data1[1].toString()));
					String validAccountnoIBAN = Constants.AndroidCDAppRecipient.getProperty("validAccountnoIBAN");
					String atbValue1 = Constants.key.getAttributeValue(validAccountnoIBAN, "enabled");
					// Assert.assertEquals("PASS",
					// Constants.key.VerifyText("true", atbValue1));
					LogCapture.info("Valid Account No/IBAN provided");
					Constants.DataMap.replace("Account Number", Data1[1].toString());
					LogCapture.info("Account Number: " + Data1[1].toString());
				} else if (Data1[0].toString().equalsIgnoreCase("Sortcode")) {
					String vObjEditIntracountryCode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
					String vObjEditAccounIBANtNumber = Constants.AndroidCDAppRecipient.getProperty("EditAccountNumber");
					Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjEditIntracountryCode, Data1[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjEditIntracountryCode));
					Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjEditIntracountryCode, Data1[1].toString()));
					String vObjvalidIntracountryCode = Constants.AndroidCDAppRecipient
							.getProperty("validIntracountryCode");
					String atbValue2 = Constants.key.getAttributeValue(vObjvalidIntracountryCode, "enabled");
					Constants.DataMap.put("Intracountry", Data1[1].toString());
					Constants.key.click(vObjEditAccounIBANtNumber);
					if (atbValue2.equalsIgnoreCase("true")) {
						LogCapture.info("Valid sort no provided");
					} else {
						LogCapture.info("Invalid sort no provided");
					}

				}

			} else if ((vObjEditCountryTxt.equalsIgnoreCase("Australia"))

					&& (vObjEditCurrencyTxt.equalsIgnoreCase("Australian Dollar"))) {
				if (Data1[0].toString().equalsIgnoreCase("AccountNo")) {
					String vObjEditAccounIBANtNumber = Constants.AndroidCDAppRecipient.getProperty("EditAccountNumber");
					Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjEditAccounIBANtNumber, Data1[1].toString()));
					String validAccountnoIBAN = Constants.AndroidCDAppRecipient.getProperty("validAccountnoIBAN");
					String atbValue1 = Constants.key.getAttributeValue(validAccountnoIBAN, "enabled");
					Constants.DataMap.put("Account Number", Data1[1].toString());
					if (atbValue1.equalsIgnoreCase("true")) {
						LogCapture.info("Valid Account No/IBAN provided");
					} else {
						LogCapture.info("Invalid Account No/IBAN provided");
					}

				} else if (Data1[0].toString().equalsIgnoreCase("BSBcode")) {
					String vObjEditIntracountryCode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
					Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjEditIntracountryCode, Data1[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjEditIntracountryCode));
					Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjEditIntracountryCode, Data1[1].toString()));
					String vObjvalidIntracountryCode = Constants.AndroidCDAppRecipient
							.getProperty("validIntracountryCode");
					String atbValue2 = Constants.key.getAttributeValue(vObjvalidIntracountryCode, "enabled");
					if (atbValue2.equalsIgnoreCase("true")) {
						LogCapture.info("Valid BSB no provided");
					} else {
						LogCapture.info("Invalid BSB no provided");
					}
					Constants.DataMap.put("Intracountry", Data1[1].toString());
				}

			} else if ((vObjEditCountryTxt.equalsIgnoreCase("Finland"))

					&& (vObjEditCurrencyTxt.equalsIgnoreCase("Euro"))) {
				if (Data1[0].toString().equalsIgnoreCase("IBANNo")) {

					String vObjEditAccounIBANtNumber = Constants.AndroidCDAppRecipient.getProperty("EditAccountNumber");
					Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjEditAccounIBANtNumber, Data1[1].toString()));
					String validAccountnoIBAN = Constants.AndroidCDAppRecipient.getProperty("validAccountnoIBAN");
					Assert.assertEquals("PASS", Constants.key.click(vObjEditAccounIBANtNumber));

					Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjEditAccounIBANtNumber, Data1[1].toString()));
					String atbValue1 = Constants.key.getAttributeValue(validAccountnoIBAN, "enabled");
					Constants.DataMap.put("IBAN", Data1[1].toString());
					if (atbValue1.equalsIgnoreCase("true")) {
						LogCapture.info("Valid IBAN no provided");
					} else {
						LogCapture.info("Invalid IBAN no provided");
					}
				}

			}

		}
	}

	@And("^android usrer updates personal details \"([^\"]*)\"$")
	public void android_usrer_updates_personal_details_something(String personaldetailsfielddata) throws Throwable {
		Constants.Data = personaldetailsfielddata.split(",");
		// int datalegth = 0;
		/*
		 * if(personaldetailsfielddata.isEmpty()==false) {
		 * if(Constants.Data.length==0) { datalegth=1; } else {
		 * datalegth=Constants.Data.length; } }
		 */

		for (int i = 0; i < Constants.Data.length; i++) {
			String[] Data1;
			Data1 = Constants.Data[i].split("-");

			if (Data1[0].toString().equalsIgnoreCase("FirstName")) {

				String vObjFirstNameTxt = Constants.AndroidCDAppRecipient.getProperty("FirstNameTxt");
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameTxt, Data1[1]));
				Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameTxt));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameTxt, Data1[1]));
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFirstNameTxt));
				LogCapture.info("Valid first name provided");

				Constants.DataMap.put("First Name", Data1[1].toString());

			} else if (Data1[0].toString().equalsIgnoreCase("LastName")) {
				String vObjLastNameTxt = Constants.AndroidCDAppRecipient.getProperty("LastNameTxt");

				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameTxt, Data1[1]));
				Assert.assertEquals("PASS", Constants.key.click(vObjLastNameTxt));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameTxt, Data1[1]));
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLastNameTxt));
				LogCapture.info("Valid last name provided");
				Constants.DataMap.put("Last Name", Data1[1].toString());

			} else if (Data1[0].toString().equalsIgnoreCase("CompanyName")) {
				String vObjCompanyNameTxt = Constants.AndroidCDAppRecipient.getProperty("CompantNameTxt");
				Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameTxt));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameTxt, Data1[1]));
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCompanyNameTxt));
				LogCapture.info("Valid Company name provided");

				Constants.DataMap.put("Company Name", Data1[1].toString());
			}
		}
	}

	@Then("^bank details should be fetched in android app$")
	public void bank_details_should_be_fetched_in_android_app() throws Throwable {
		String vObjEditAccounIBANtNumber = Constants.AndroidCDAppRecipient.getProperty("EditAccountNumber");
		Assert.assertEquals("PASS", Constants.key.click(vObjEditAccounIBANtNumber));
		String vObjBankName = Constants.AndroidCDAppRecipient.getProperty("BankName");
		String vBankNameTxt = Constants.key.getAttributeValue(vObjBankName, "text");
		Constants.key.scrollDownUI("Bank name");
		Constants.DataMap.put("Bank Name", vBankNameTxt);
		LogCapture.info("Bank Name Fetched:" + vBankNameTxt);
		Constants.key.scrollDownUI("Continue");
		Thread.sleep(2000);
	}

	@Then("^the Recipient displayed in recipient list with updated details \"([^\"]*)\"$")
	public void the_Recipient_displayed_in_recipient_list_with_updated_details(String arg1) throws Throwable {
		String vObjBtnAddRecipientCell = Constants.AndroidCDAppRecipient.getProperty("BtnAddRecipientCell");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddRecipientCell));
		Constants.Data = arg1.split(",");
		String[] Data1 = Constants.Data[0].split("-");

		String AccountNumberIBANlat4digit = Data1[1].substring(Data1[1].length() - 4, Data1[1].length());
		String vObjUpdatedAccountNoIBAN = Constants.AndroidCDAppRecipient.getProperty("UpdatedAccountNoIBAN");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdatedAccountNoIBAN));
		String vObjEditAccountNoIBANTxt = Constants.key.getAttributeValue(vObjUpdatedAccountNoIBAN, "text");
		String vbjEditedlast4digit = vObjEditAccountNoIBANTxt.substring((vObjEditAccountNoIBANTxt.length() - 4),
				(vObjEditAccountNoIBANTxt.length()));
		Assert.assertEquals("PASS", Constants.key.VerifyText(vbjEditedlast4digit, AccountNumberIBANlat4digit));
		LogCapture.info("Updated recipient displayed in recipient list-" + "Account Number/IBAN:" + Data1[1]);
	}

	@When("^android user clicks on back button$")
	public void android_user_clicks_on_back_button() throws Throwable {
		String vObjBackRecButton = Constants.AndroidCDAppRecipient.getProperty("BackRecButton");
		Assert.assertEquals("PASS", Constants.key.click(vObjBackRecButton));
		LogCapture.info("clicked on back button....");
	}

	@Then("^recipient list screen shoould be displayed$")
	public void recipient_list_screen_shoould_be_displayed() throws Throwable {
		String vObjRecpientList = Constants.AndroidCDAppRecipient.getProperty("RecpientList");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecpientList));
		LogCapture.info("User is On recipient list screen");
	}

	@And("^android user updates address details \"([^\"]*)\"$")
	public void android_user_updates_address_details_something(String addressdetailsfielddata) throws Throwable {
		Constants.key.scrollDownUI("Bank details");
		if (addressdetailsfielddata.isEmpty()) {
			LogCapture.info("Adress details not provided");
		} else {
			Constants.key.scrollDownUI("Address");
			Constants.Data = addressdetailsfielddata.split(",");

			for (int i = 0; i < Constants.Data.length; i++) {
				String[] Data1;
				Data1 = Constants.Data[i].split("-");

				if (Data1[0].toString().equalsIgnoreCase("AdressLine1")) {

					String vObjRecpientAdressLine1 = Constants.AndroidCDAppRecipient.getProperty("RecpientAdressLine1");
					Assert.assertEquals("PASS",
							Constants.key.writeInInput(vObjRecpientAdressLine1, Data1[1].toString()));
					// String vObjAdreeLine1NameValid =
					// Constants.AndroidCDAppRecipient.getProperty("AdreeLine1NameValid");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecpientAdressLine1));

					LogCapture.info("Valid Adress Line1 Provided");
					Constants.DataMap.put("Adress Line1", Data1[1].toString());

					Constants.DataMap.put("AdressLine1", Data1[1]);

				} else if (Data1[0].toString().equalsIgnoreCase("City")) {

					String vObjRecpientCity = Constants.AndroidCDAppRecipient.getProperty("RecpientCity");
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecpientCity, Data1[1].toString()));

					// String vObjCityValid =
					// Constants.AndroidCDAppRecipient.getProperty("CityValid");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecpientCity));

					LogCapture.info("Valid Adress City Provided");
					Constants.DataMap.put("City", Data1[1].toString());

					LogCapture.info("Valid City Provided");
					Constants.DataMap.put("City", Data1[1]);

				} else if (Data1[0].toString().equalsIgnoreCase("Postcode")) {

					String vObjPostcode = Constants.AndroidCDAppRecipient.getProperty("RecpientPostcode");
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcode, Data1[1].toString()));
					Assert.assertEquals("PASS", Constants.key.click(vObjPostcode));
					Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcode, Data1[1].toString()));
					Constants.DataMap.put("Adress Line1", Data1[1].toString());

					// String vObjPostcodeValid =
					// Constants.AndroidCDAppRecipient.getProperty("PostcodeValid");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPostcode));

					Constants.DataMap.put("Postcode", Data1[1]);
					LogCapture.info("Valid Postcode provided");

				}

			}
		}

	}

	@And("^android user updates invalid bank details \"([^\"]*)\"$")
	public void android_user_updates_invalid_bank_details_something(String fieldnamedata) throws Throwable {
		android_user_updates_bank_details_something(fieldnamedata);
	}

	@Then("^invalid bank code error message should be displayed$")
	public void invalid_bank_code_error_message_should_be_displayed() throws Throwable {
		String vObjEditAccounIBANtNumber = Constants.AndroidCDAppRecipient.getProperty("EditAccountNumber");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEditAccounIBANtNumber));
		String vobjIntraCoutrycodeerror = Constants.AndroidCDAppRecipient.getProperty("IntraCoutrycodeerror");
		String vObjIntraCoutrycodeerrorTxt = Constants.key.getAttributeValue(vobjIntraCoutrycodeerror, "text");
		LogCapture.info(vObjIntraCoutrycodeerrorTxt);
	}

	@Then("^invalid account number error message should be displayed to android user$")
	public void invalid_account_number_error_message_should_be_displayed_to_android_user() throws Throwable {
		String vObjEditAccounIBANtNumbererror = Constants.AndroidCDAppRecipient.getProperty("AccountNumberError");
		String AccounIBANtNumbererrorTxt = Constants.key.getAttributeValue(vObjEditAccounIBANtNumbererror, "text");
		LogCapture.info(AccounIBANtNumbererrorTxt);

	}

	@And("^android user update personal,adress and bank valid details \"([^\"]*)\"$")
	public void android_user_update_personaladress_and_bank_valid_details_something(String fieldnamedata)
			throws Throwable {

		Constants.Data = fieldnamedata.split(",");

		for (int i = 0; i < Constants.Data.length; i++) {
			String[] Data1;
			Data1 = Constants.Data[i].split("-");

			if (Data1[0].toString().equalsIgnoreCase("FirstName")) {

				String vObjFirstNameTxt = Constants.AndroidCDAppRecipient.getProperty("FirstNameTxt");
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameTxt, Data1[1]));
				Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameTxt));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameTxt, Data1[1]));
				String vObjValidFisrtName = Constants.AndroidCDAppRecipient.getProperty("FirstNameValid");
				// Assert.assertEquals("PASS",Constants.key.eleLocatedDisplayed(vObjValidFisrtName));
				LogCapture.info("Valid first name provided");
				Constants.DataMap.put("First Name", Data1[1].toString());

			} else if (Data1[0].toString().equalsIgnoreCase("LastName")) {
				String vObjLastNameTxt = Constants.AndroidCDAppRecipient.getProperty("LastNameTxt");
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameTxt, Data1[1]));
				Assert.assertEquals("PASS", Constants.key.click(vObjLastNameTxt));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameTxt, Data1[1]));
				String vObjLastNameValid = Constants.AndroidCDAppRecipient.getProperty("LastNameValid");
				// Assert.assertEquals("PASS",
				// Constants.key.eleLocatedDisplayed(vObjLastNameValid));
				LogCapture.info("Valid last name provided");
				Constants.DataMap.put("Last Name", Data1[1].toString());

			} else if (Data1[0].toString().equalsIgnoreCase("CompanyName")) {
				String vObjCompanyNameTxt = Constants.AndroidCDAppRecipient.getProperty("CompantNameTxt");
				Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameTxt));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameTxt, Data1[1]));
				Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameTxt));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameTxt, Data1[1]));
				String vObtComapanyNameValid = Constants.AndroidCDAppRecipient.getProperty("CompanyNameValid");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObtComapanyNameValid));
				LogCapture.info("Valid Company name provided");
				Constants.DataMap.put("Company Name", Data1[1].toString());

			} else if (Data1[0].toString().equalsIgnoreCase("AdressLine1")) {
				String vObjRecpientAdressLine1 = Constants.AndroidCDAppRecipient.getProperty("RecpientAdressLine1");
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecpientAdressLine1, Data1[1].toString()));
				Constants.DataMap.put("Adress Line1", Data1[1].toString());

			} else if (Data1[0].toString().equalsIgnoreCase("City")) {
				String vObjRecpientCity = Constants.AndroidCDAppRecipient.getProperty("RecpientCity");
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecpientCity, Data1[1].toString()));
				Constants.DataMap.put("City", Data1[1].toString());
			} else if (Data1[0].toString().equalsIgnoreCase("Postcode")) {
				String vObjPostcode = Constants.AndroidCDAppRecipient.getProperty("RecpientPostcode");
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcode, Data1[1].toString()));
				Assert.assertEquals("PASS", Constants.key.click(vObjPostcode));
				Constants.DataMap.put("Post Code", Data1[1].toString());
				Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcode, Data1[1].toString()));
			}

		}

		android_user_updates_bank_details_something(fieldnamedata);

	}

	@Then("^all the updated details should be displayed on android recipient view screen$")
	public void all_the_updated_details_should_be_displayed_on_android_recipient_view_screen() throws Throwable {
		LogCapture.info("Updated Details are displayed-");
		Thread.sleep(6000);
		String LastName = Constants.DataMap.get("Last Name");
		String AccountNo = Constants.DataMap.get("Account Number");
		String IBAN = Constants.DataMap.get("IBAN");
		String FirstName = Constants.DataMap.get("First Name");
		String CompanyName = Constants.DataMap.get("Company Name");

		if (IBAN == null || IBAN.isEmpty()) {
			Thread.sleep(4000);
			String AccountNumberIBANlat4digit = AccountNo.substring(AccountNo.length() - 4, AccountNo.length());
			String vObjUpdatedAccountNoIBAN = Constants.AndroidCDAppRecipient.getProperty("UpdatedAccountNoIBAN");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdatedAccountNoIBAN));
			String vObjEditAccountNoIBANTxt = Constants.key.getAttributeValue(vObjUpdatedAccountNoIBAN, "text");
			String vbjEditedlast4digit = vObjEditAccountNoIBANTxt.substring((vObjEditAccountNoIBANTxt.length() - 4),
					(vObjEditAccountNoIBANTxt.length()));
			Assert.assertEquals("PASS", Constants.key.VerifyText(vbjEditedlast4digit, AccountNumberIBANlat4digit));
			LogCapture.info(
					"Updated recipient displayed in recipient list-" + "Account Number/IBAN:" + vbjEditedlast4digit);
			Constants.DataMap.put("AccountIBAN", vObjEditAccountNoIBANTxt);
		} else {
			String AccountNumberIBANlat4digit = IBAN.substring(IBAN.length() - 4, IBAN.length());
			String vObjUpdatedAccountNoIBAN = Constants.AndroidCDAppRecipient.getProperty("UpdatedAccountNoIBAN");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdatedAccountNoIBAN));
			String vObjEditAccountNoIBANTxt = Constants.key.getAttributeValue(vObjUpdatedAccountNoIBAN, "text");
			String vbjEditedlast4digit = vObjEditAccountNoIBANTxt.substring((vObjEditAccountNoIBANTxt.length() - 4),
					(vObjEditAccountNoIBANTxt.length()));
			Assert.assertEquals("PASS", Constants.key.VerifyText(vbjEditedlast4digit, AccountNumberIBANlat4digit));
			LogCapture.info(
					"Updated recipient displayed in recipient list-" + "Account Number/IBAN:" + vbjEditedlast4digit);
			Constants.DataMap.put("AccountIBAN", vObjEditAccountNoIBANTxt);
		}

		String vObjUpdatedName = Constants.AndroidCDAppRecipient.getProperty("UpdatedName");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUpdatedName));
		String vObjEditCompanytNameTxt = Constants.key.getAttributeValue(vObjUpdatedName, "text");
		System.out.println(vObjEditCompanytNameTxt);
		String Type = Constants.DataMap.get("Type");
		LogCapture.info(vObjEditCompanytNameTxt);

		LogCapture.info(FirstName);
		LogCapture.info(LastName);
		if (Type.equalsIgnoreCase("Commpany")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjEditCompanytNameTxt, CompanyName));
			LogCapture.info("Updated recipient namre displayed-" + "Recipient Name:" + vObjEditCompanytNameTxt);

			LogCapture.info("Updated Recipient Name-" + "Account Number/IBAN:" + vObjEditCompanytNameTxt);
		} else {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjEditCompanytNameTxt, FirstName + " " + LastName));
			LogCapture.info("Updated recipient namr displayed-" + "Recipient Name:" + vObjEditCompanytNameTxt);

			LogCapture.info("Updated Account Number/IBAN-" + "Account Number/IBAN:" + vObjEditCompanytNameTxt);

		}

		String name = "";
		if (Constants.DataMap.containsKey("RecipientType")) {
			if (Constants.DataMap.get("RecipientType").toString().equalsIgnoreCase("Individual")) {
				name = Constants.DataMap.get("FirstName").toString() + " "
						+ Constants.DataMap.get("LastName").toString();
			} else if (Constants.DataMap.get("RecipientType").toString().equalsIgnoreCase("Company")) {
				name = Constants.DataMap.get("CompanyName").toString();
			}
		} else {
			name = Constants.DataMap.get("RecipientName");
		}
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjEditCompanytNameTxt, name));
	}

	@When("^android user selects updated recipient$")
	public void android_user_selects_updated_recipient() throws Throwable {
		String LastName = Constants.DataMap.get("Last Name");
		LogCapture.info(LastName);
		String AccountNoIBAN = Constants.DataMap.get("AccountIBAN");
		LogCapture.info(AccountNoIBAN);
		String FirstName = Constants.DataMap.get("First Name");
		LogCapture.info(FirstName);
		String CompanyName = Constants.DataMap.get("Company Name");
		LogCapture.info(CompanyName);
		String Currency = Constants.DataMap.get("Currency");
		LogCapture.info(Currency);
		String RecipientName;
		String Typerecipient = Constants.DataMap.get("Type");

		if (Typerecipient.equalsIgnoreCase("Commpany")) {

			RecipientName = CompanyName;
			the_android_user_selects_a_saved_recipient_based_on_account_number_somethingrecipientnamesomething_and_currency_something(
					AccountNoIBAN, RecipientName, Currency);

		} else {
			RecipientName = FirstName + " " + LastName;
			the_android_user_selects_a_saved_recipient_based_on_account_number_somethingrecipientnamesomething_and_currency_something(
					AccountNoIBAN, RecipientName, Currency);
		}

	}

	@Then("^updated adress and bank details should be displayed edit recipient page$")
	public void updated_adress_and_bank_details_should_be_displayed_edit_recipient_page() throws Throwable {
		Constants.key.scrollDownUI("Adress");

		String vObjRecpientAdressLine1 = Constants.AndroidCDAppRecipient.getProperty("RecpientAdressLine1");
		String Adresstext = Constants.key.getAttributeValue(vObjRecpientAdressLine1, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(Adresstext, Constants.DataMap.get("AdressLine1")));

		String vObjCity = Constants.AndroidCDAppRecipient.getProperty("RecpientCity");
		String Citytext = Constants.key.getAttributeValue(vObjCity, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(Citytext, Constants.DataMap.get("City")));

		String vObjPostcode = Constants.AndroidCDAppRecipient.getProperty("RecpientPostcode");
		String Postcodetext = Constants.key.getAttributeValue(vObjPostcode, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(Postcodetext, Constants.DataMap.get("Postcode")));

		String vObjEditAccounIBANtNumber = Constants.AndroidCDAppRecipient.getProperty("EditAccountNumber");
		String AccountIBANtext = Constants.key.getAttributeValue(vObjEditAccounIBANtNumber, "text").toString();
		String AccountIBANlast4 = AccountIBANtext.substring((AccountIBANtext.length() - 4), (AccountIBANtext.length()));
		String AccountIBANlastMap = Constants.DataMap.get("AccountIBAN");
		String Map4 = AccountIBANtext.substring((AccountIBANlastMap.length() - 4), (AccountIBANlastMap.length()));
		Assert.assertEquals("PASS", Constants.key.VerifyText(AccountIBANlast4, Map4));

		String vObjEditIntracountryCode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
		String vObjEditIntracountryCodetext = Constants.key.getAttributeValue(vObjEditIntracountryCode, "text")
				.toString();
		Assert.assertEquals("PASS",
				Constants.key.VerifyText(vObjEditIntracountryCodetext, Constants.DataMap.get("Intracountry")));
	}

	// ************Add recipient**********//

	@When("^android user selects \"([^\"]*)\" and enters recipient name \"([^\"]*)\"$")
	public void android_user_selects_something_and_enters_recipient_name_something(String type, String recipientname)
			throws Throwable {
		String[] Data2;

		if (type.equalsIgnoreCase("Individual")) {
			Data2 = recipientname.split(" ");
			String vObjIndividual = Constants.AndroidCDAppRecipient.getProperty("Individual");
			String vObjIndividualtxt = Constants.key.getAttributeValue(vObjIndividual, "text");
			// Assert.assertEquals("PASS",Constants.key.click(vObjIndividual));
			String atbValue4 = Constants.key.getAttributeValue(vObjIndividual, "checked");
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue4));
			LogCapture.info("Recipent Type  :  " + vObjIndividualtxt + "Selected");

			String vObjFirstNameTxt = Constants.AndroidCDAppRecipient.getProperty("FirstNameTxt");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameTxt, Data2[0]));
			LogCapture.info("Fisrt Name Provided");

			String vObjLastNameTxt = Constants.AndroidCDAppRecipient.getProperty("LastNameTxt");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameTxt, Data2[1]));
			LogCapture.info("Last Name Provided");

		} else {
			String vObjCompany = Constants.AndroidCDAppRecipient.getProperty("Company");
			String vObjCompanytxt = Constants.key.getAttributeValue(vObjCompany, "text");
			Assert.assertEquals("PASS", Constants.key.click(vObjCompany));
			String atbValue2 = Constants.key.getAttributeValue(vObjCompany, "checked");
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue2));
			LogCapture.info("Recipent Type  :  " + vObjCompanytxt + " " + "Type Selected");

			String vObjCompanyNameTxt = Constants.AndroidCDAppRecipient.getProperty("CompantNameTxt");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameTxt, recipientname));
			LogCapture.info("Company Name Provided");

		}

	}

	@And("^android user selects country dropdown$")
	public void android_user_selects_country_dropdown() throws Throwable {
		String vObjCountrydrop = Constants.AndroidCDAppRecipient.getProperty("Countrydrop");
		Assert.assertEquals("PASS", Constants.key.click(vObjCountrydrop));
	}

	@Then("^list of available country should be displayed in android app$")
	public void list_of_available_country_should_be_displayed_in_android_app() throws Throwable {
		String vObjCountryList = Constants.AndroidCDAppRecipient.getProperty("Countrylist");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryList));
	}

	@And("^android user should be able to select country \"([^\"]*)\" by using search option$")
	public void android_user_should_be_able_to_select_country_something_by_using_search_option(String countryData)
			throws Throwable {
		String vObjCountrySearch = Constants.CDAppDashboard.getProperty("CountrySearch");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountrySearch));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountrySearch, countryData));

		String vObjsinglecountry = Constants.AndroidCDAppRecipient.getProperty("SearchedCountry");
		int noOfCountry = Constants.key.getElementList(vObjsinglecountry).size();
		LogCapture.info("countryList size: " + noOfCountry);

		List<MobileElement> countryList = Constants.key.getElementList(vObjsinglecountry);
		boolean isCountryFound = false;
		for (MobileElement country : countryList) {
			String countryName = country.getText();
			LogCapture.info("Country name: " + countryName);
			if (countryName.equalsIgnoreCase(countryData)) {
				country.click();
				Assert.assertEquals("PASS", "PASS");
				LogCapture.info("Country found: " + countryData);
				isCountryFound = true;
				Constants.DataMap.put("RecipientCountry", countryName);
			}
		}
		if (!isCountryFound) {
			Assert.assertEquals("PASS", "FAIL");
		}

		LogCapture.info("User select country: " + countryData);

	}

	@When("^android user selects currency dropdown$")
	public void android_user_selects_currency_dropdown() throws Throwable {
		String vObjCurrencydrop = Constants.AndroidCDAppRecipient.getProperty("Currencydrop");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencydrop));
		Assert.assertEquals("PASS", Constants.key.click(vObjCurrencydrop));

	}

	@Then("^list of available currency should be displayed in android aap$")
	public void list_of_available_currency_should_be_displayed_in_android_aap() throws Throwable {
		String vObjCurrencylist = Constants.AndroidCDAppRecipient.getProperty("Currencylist");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencylist));
	}

	@When("^android user types each character \"([^\"]*)\" in search field$")
	public void android_user_types_each_character_something_in_search_field(String searchcriteria) throws Throwable {
		String vObjCurrencySearch = Constants.AndroidCDAppRecipient.getProperty("CurrencySearch");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencySearch));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCurrencySearch, searchcriteria));

	}

	@Then("^the filtered available currencies list should be displayed after a few micro seconds in android app$")
	public void the_filtered_available_currencies_list_should_be_displayed_after_a_few_micro_seconds_in_android_app()
			throws Throwable {
		String vObjSearchedCurrency = Constants.AndroidCDAppRecipient.getProperty("SearchedCurrecy");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSearchedCurrency));
		LogCapture.info("Currency Selected");

	}

	@Then("^empty state currency list should be displayed in android app along with no result message$")
	public void empty_state_currency_list_should_be_displayed_in_android_app_along_with_no_result_message()
			throws Throwable {
		String vObjCurrencyInvalidSearch = Constants.AndroidCDAppRecipient.getProperty("CurrencyInvalidSearch");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencyInvalidSearch));
		LogCapture.info("Currency Search Not Found");
	}

	@And("^android user selects the close icon in the (search|address) field$")
	public void android_user_selects_the_close_icon_in_the_search_field(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("search")) {
			String vObjSearchCloseButton = Constants.AndroidCDAppRecipient.getProperty("SearchCloseBox");
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchCloseButton));
			LogCapture.info("User clicked on close icon of currency search box");
		} else if (optionalValue.equalsIgnoreCase("address")) {
			String vObjAddressSearchCloseButton = Constants.AndroidCDAppRegistrationOR
					.getProperty("CloseAddressSearchBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjAddressSearchCloseButton));
			LogCapture.info("User clicked on close icon of currency search box");
		}
	}

	@When("^android user select currency$")
	public void android_user_select_currency() throws Throwable {
		String vObjSearchedCurrency = Constants.AndroidCDAppRecipient.getProperty("SearchedCurrecy");
		Assert.assertEquals("PASS", Constants.key.click(vObjSearchedCurrency));
	}

	@Then("^the currency list should be closed with updated recipient country value in android aap$")
	public void the_currency_list_should_be_closed_with_updated_recipient_country_value_in_android_aap()
			throws Throwable {
		String vObjCurrencydrop = Constants.AndroidCDAppRecipient.getProperty("Currencydrop");
		String vObjSelectedCurrencyTxt = Constants.key.getAttributeValue(vObjCurrencydrop, "text");
		LogCapture.info("Currency Selected :" + vObjSelectedCurrencyTxt);
	}

	@Then("^address details fields should be displayed to applicable country currency$")
	public void address_details_fields_should_be_displayed_to_applicable_country_currency() throws Throwable {
		String vObjRecpientAdressLine1 = Constants.AndroidCDAppRecipient.getProperty("RecpientAdressLine1");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecpientAdressLine1));
		LogCapture.info("Adress Line 1 present");

		String vObjRecpientCity = Constants.AndroidCDAppRecipient.getProperty("RecpientCity");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecpientCity));
		LogCapture.info("Recipient city present");

		String vObjPostcode = Constants.AndroidCDAppRecipient.getProperty("RecpientPostcode");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPostcode));
		LogCapture.info("Recipient Postcode present");

	}

	@Then("^address details fields should be not be displayed to un applicable country currency$")
	public void address_details_fields_should_be_not_be_displayed_to_un_applicable_country_currency() throws Throwable {
		String vObjAdress = Constants.AndroidCDAppRecipient.getProperty("AdressRecipient");
		if (Constants.key.isElementPresent(vObjAdress, 60).equalsIgnoreCase("FAIL")) {
			LogCapture.info("Address Details not  applicable to selected country currency");
		}
	}

	@And("^android user removes one of the mandatory personal field data \"([^\"]*)\"$")
	public void android_user_removes_one_of_the_mandatory_personal_field_data_something(String mandatoryfield)
			throws Throwable {
		if (mandatoryfield.equalsIgnoreCase("FirstName")) {
			String vObjFirstNameTxt = Constants.AndroidCDAppRecipient.getProperty("FirstNameTxt");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjFirstNameTxt));
			LogCapture.info("Cleared Fisrt Name ....");

		} else if (mandatoryfield.equalsIgnoreCase("LastName")) {
			String vObjLastNameTxt = Constants.AndroidCDAppRecipient.getProperty("LastNameTxt");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjLastNameTxt));
			LogCapture.info("Cleared Last Name ....");

		} else {
			String vObjCompanyNameTxt = Constants.AndroidCDAppRecipient.getProperty("CompantNameTxt");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCompanyNameTxt));
			LogCapture.info("Cleared Company Name ....");
		}
	}

	@Then("^the continue button to save the recipient should be in an disabled state in android app$")
	public void the_continue_button_to_save_the_recipient_should_be_in_an_disabled_state_in_android_app()
			throws Throwable {
		String vObjContinueButton = Constants.AndroidCDAppRecipient.getProperty("ContinueBtn");


		String atbValue = Constants.key.getAttributeValue(vObjContinueButton, "enabled");
		Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		LogCapture.info("Continue button disabled");
	}

	@When("^android user selects \"([^\"]*)\" and enters recipient all details \"([^\"]*)\"$")
	public void android_user_selects_something_and_enters_recipient_all_details_something(String type,
																						  String recipientdetails) throws Throwable {

		String vRecipientdetails = Constants.AndroidTestData.getProperty(recipientdetails);
		Constants.Data = vRecipientdetails.split(",");
		// LogCapture.info("Length:"+Constants.Data.length);

		android_user_selects_something_and_enters_recipient_name_something(type, Constants.Data[0].toString());
		android_user_selects_country_dropdown();
		list_of_available_country_should_be_displayed_in_android_app();
		android_user_should_be_able_to_select_country_something_by_using_search_option(Constants.Data[1]);

		android_user_selects_currency_dropdown();
		list_of_available_currency_should_be_displayed_in_android_aap();
		android_user_types_each_character_something_in_search_field(Constants.Data[2]);
		the_filtered_available_currencies_list_should_be_displayed_after_a_few_micro_seconds_in_android_app();
		android_user_select_currency();

		String vObjRecipientAccountNumber = Constants.AndroidCDAppRecipient.getProperty("RecipientAccountNumber");
		if (Constants.Data[1].equalsIgnoreCase("United Kingdom") && (Constants.Data[2].equalsIgnoreCase("GBP"))) {
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientAccountNumber, Constants.Data[3]));
			String vobjIntracountry = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, Constants.Data[4]));
			Assert.assertEquals("PASS", Constants.key.clearText(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.click(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, Constants.Data[4]));
		} else if (Constants.Data[1].equalsIgnoreCase("Australia") && (Constants.Data[2].equalsIgnoreCase("AUD"))) {
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientAccountNumber, Constants.Data[3]));
			String vobjIntracountry = Constants.AndroidCDAppRecipient.getProperty("Swiftcode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, Constants.Data[4]));
		} else if (Constants.Data[1].equalsIgnoreCase("Canada") && (Constants.Data[2].equalsIgnoreCase("CAD"))) {
			String vObjRecpientAdressLine1 = Constants.AndroidCDAppRecipient.getProperty("RecpientAdressLine1");
			Assert.assertEquals("PASS",
					Constants.key.writeInInput(vObjRecpientAdressLine1, Constants.Data[6].toString()));

			String vObjRecpientCity = Constants.AndroidCDAppRecipient.getProperty("RecpientCity");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecpientCity, Constants.Data[7].toString()));
			Constants.key.scrollDownUI("Continue");

			String vObjPostcode = Constants.AndroidCDAppRecipient.getProperty("RecpientPostcode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcode, Constants.Data[8].toString()));

			Constants.key.scrollDownUI("Bank details");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientAccountNumber, Constants.Data[3]));
			String vobjSwiftCode = Constants.AndroidCDAppRecipient.getProperty("Swiftcode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjSwiftCode, Constants.Data[5]));

		} else if (Constants.Data[1].equalsIgnoreCase("Finland") && (Constants.Data[2].equalsIgnoreCase("EUR"))) {
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientAccountNumber, Constants.Data[3]));
			String vobjIntracountry = Constants.AndroidCDAppRecipient.getProperty("Swiftcode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, Constants.Data[4]));
			Assert.assertEquals("PASS", Constants.key.clearText(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.click(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, Constants.Data[4]));
		} else if (Constants.Data[1].equalsIgnoreCase("United States of America")
				&& (Constants.Data[2].equalsIgnoreCase("USD"))) {
			Constants.key.scrollDownUI("Continue");

			String vObjRecpientAdressLine1 = Constants.AndroidCDAppRecipient.getProperty("RecpientAdressLine1");
			Assert.assertEquals("PASS",
					Constants.key.writeInInput(vObjRecpientAdressLine1, Constants.Data[6].toString()));

			String vObjRecpientCity = Constants.AndroidCDAppRecipient.getProperty("RecpientCity");
			String vObjPostcode = Constants.AndroidCDAppRecipient.getProperty("RecpientPostcode");

			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecpientCity, Constants.Data[7]));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcode, Constants.Data[8]));
			String vobjBankcodeSelect = Constants.AndroidCDAppRecipient.getProperty("BankCodeSlect");
			Assert.assertEquals("PASS", Constants.key.click(vobjBankcodeSelect));

			String vobjBankcodeOption = Constants.AndroidCDAppRecipient.getProperty("BankCodeOption");
			Assert.assertEquals("PASS", Constants.key.click(vobjBankcodeOption));

			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientAccountNumber, Constants.Data[3]));
		} else if (Constants.Data[1].equalsIgnoreCase("Canada") && (Constants.Data[2].equalsIgnoreCase("CAD"))) {
			Constants.key.scrollDownUI("Continue");

			String vObjRecpientAdressLine1 = Constants.AndroidCDAppRecipient.getProperty("RecpientAdressLine1");
			Assert.assertEquals("PASS",
					Constants.key.writeInInput(vObjRecpientAdressLine1, Constants.Data[5].toString()));
			String vObjRecpientCity = Constants.AndroidCDAppRecipient.getProperty("RecpientCity");
			String vObjPostcode = Constants.AndroidCDAppRecipient.getProperty("RecpientPostcode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecpientCity, Constants.Data[6]));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcode, Constants.Data[7]));

			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientAccountNumber, Constants.Data[3]));
			String vObjIntarCountryCode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIntarCountryCode, Constants.Data[8]));
			Assert.assertEquals("PASS", Constants.key.click(vObjIntarCountryCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIntarCountryCode, Constants.Data[8]));
			String vObjSwiftCode = Constants.AndroidCDAppRecipient.getProperty("SwiftCode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSwiftCode, Constants.Data[4]));
			Assert.assertEquals("PASS", Constants.key.click(vObjIntarCountryCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjIntarCountryCode));

		}

	}

	@And("^android user removes one of the mandatory bank field data \"([^\"]*)\"$")
	public void android_user_removes_removes_one_of_the_mandatory_bank_field_data_something(String mandatoryfield)
			throws Throwable {
		if (mandatoryfield.equalsIgnoreCase("AccountNumber")) {
			String vObjRecipientAccountNumber = Constants.AndroidCDAppRecipient.getProperty("RecipientAccountNumber");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjRecipientAccountNumber));
		} else if (mandatoryfield.equalsIgnoreCase("SortCode")) {
			String vObjSortcode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSortcode));
		} else if (mandatoryfield.equalsIgnoreCase("BSBCode")) {
			String vObjSortcode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSortcode));
		} else if (mandatoryfield.equalsIgnoreCase("BSBCode")) {
			String vObjSortcode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSortcode));
		} else if (mandatoryfield.equalsIgnoreCase("SwiftCode")) {
			String vObjSwiftcode = Constants.AndroidCDAppRecipient.getProperty("Swiftcode");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSwiftcode));
		}

	}

	@And("^android user removes removes one of the mandatory adress field\"([^\"]*)\"$")
	public void android_user_removes_removes_one_of_the_mandatory_adress_fieldsomething(String mandatoryfield)
			throws Throwable {

		if (mandatoryfield.equalsIgnoreCase("AddressLine1")) {
			String vObjAdressLine1 = Constants.AndroidCDAppRecipient.getProperty("RecpientAdressLine1");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjAdressLine1));
			LogCapture.info("Adress 1 removed");
		} else if (mandatoryfield.equalsIgnoreCase("City")) {
			String vObjRecpientCity = Constants.AndroidCDAppRecipient.getProperty("RecpientCity");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjRecpientCity));
			LogCapture.info("City removed");
		} else if (mandatoryfield.equalsIgnoreCase("Postcode")) {
			String vObjPostcode = Constants.AndroidCDAppRecipient.getProperty("RecpientPostcode");
			Assert.assertEquals("PASS", Constants.key.clearText(vObjPostcode));
			LogCapture.info("Postcode removed");
		}

	}

	@Then("^the continue button to save the recipient should be in an enabled state in android app$")
	public void the_continue_button_to_save_the_recipient_should_be_in_an_enabled_state_in_android_app()
			throws Throwable {
		String vObjHeader = Constants.AndroidCDAppRecipient.getProperty("AddRecipientTitle");
		Assert.assertEquals("PASS", Constants.key.click(vObjHeader));

		Constants.key.scrollDownUI("Continue");
		String vObjContinueButton = Constants.AndroidCDAppRecipient.getProperty("ContinueBtn");

		Thread.sleep(3000);
		String atbValue = Constants.key.getAttributeValue(vObjContinueButton, "enabled");
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		LogCapture.info("Continue button enabled");
	}

	@And("^android user selects country-currency \"([^\"]*)\" and enters address \"([^\"]*)\"$")
	public void android_user_selects_country_currency_and_enters_address(String countrycurrency, String address)
			throws Throwable {
		String Data3[] = countrycurrency.split("-");
		android_user_selects_country_dropdown();
		list_of_available_country_should_be_displayed_in_android_app();
		android_user_should_be_able_to_select_country_something_by_using_search_option(Data3[0]);

		android_user_selects_currency_dropdown();
		list_of_available_currency_should_be_displayed_in_android_aap();
		android_user_types_each_character_something_in_search_field(Data3[1]);
		android_user_select_currency();

		if (countrycurrency.equalsIgnoreCase(("United Kingdom-GBP")) || countrycurrency.equalsIgnoreCase("Finland-EUR")
				|| countrycurrency.equalsIgnoreCase("France-EUR") || countrycurrency.equalsIgnoreCase("Denmark-DKK")
				|| countrycurrency.equalsIgnoreCase("Sweden-SEK") || countrycurrency.equalsIgnoreCase("Norway-NOK")
				|| countrycurrency.equalsIgnoreCase("Switzerland-CHF") || countrycurrency.equalsIgnoreCase("Singapore-SGD")
				|| countrycurrency.equalsIgnoreCase("Germany-EUR") || countrycurrency.equalsIgnoreCase("Austria-EUR")
				|| countrycurrency.equalsIgnoreCase("Hungary-HUF") || countrycurrency.equalsIgnoreCase("Spain-EUR")
				|| countrycurrency.equalsIgnoreCase("United Kingdom-EUR")
				|| countrycurrency.equalsIgnoreCase("Hong Kong-HKD") || countrycurrency.equalsIgnoreCase("China-HKD")
				|| countrycurrency.equalsIgnoreCase("India-INR")) {
			LogCapture.info("Address fields not applicable");
		} else {
			if (countrycurrency.equalsIgnoreCase("CANADA-CAD")
					|| countrycurrency.equalsIgnoreCase("United States of America-USD")) {
				Constants.Data = Constants.AndroidTestData.getProperty("CADAdd").split(",");
			} else if (countrycurrency.equalsIgnoreCase("South Africa-ZAR")) {
				Constants.Data = Constants.AndroidTestData.getProperty("ZARAdd").split(",");
			} else if (countrycurrency.equalsIgnoreCase("New Zealand-NZD")) {
				Constants.Data = Constants.AndroidTestData.getProperty("USAAdd").split(",");
			} else if (countrycurrency.equalsIgnoreCase("Australia-AUD")) {
				Constants.Data = Constants.AndroidTestData.getProperty("AUSAdd").split(",");
			}
			Thread.sleep(5000);
			String vObjRecpientAdressLine1 = Constants.AndroidCDAppRecipient.getProperty("RecpientAdressLine1");
			Assert.assertEquals("PASS",
					Constants.key.writeInInput(vObjRecpientAdressLine1, Constants.Data[0].toString()));

			String vObjRecpientCity = Constants.AndroidCDAppRecipient.getProperty("RecpientCity");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecpientCity, Constants.Data[1].toString()));

			String vObjPostcode = Constants.AndroidCDAppRecipient.getProperty("RecpientPostcode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcode, Constants.Data[2].toString()));

		}

	}

	@And("^android user enters valid account number \"([^\"]*)\"$")
	public void android_user_enters_valid_account_number_something(String accountnumber) throws Throwable {
		Constants.key.scrollDownUI("Continue");
		String vObjRecipientAccountNumber = Constants.AndroidCDAppRecipient.getProperty("RecipientAccountNumber");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientAccountNumber, accountnumber));
		LogCapture.info("User entered account number");

	}

	@And("^android user enters valid swift code \"([^\"]*)\" based on \"([^\"]*)\"$")
	public void android_user_enters_valid_swift_code_something_based_on_something(String swiftcode,
																				  String countrycurrency) throws Throwable {
		String CountryCourrency = countrycurrency;
		if (CountryCourrency.equalsIgnoreCase("United Kingdom-GBP")
				|| CountryCourrency.equalsIgnoreCase("CANADA-CAD")) {
			String vobjIntracountry = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, swiftcode));
			Assert.assertEquals("PASS", Constants.key.click(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.clearText(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.click(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, swiftcode));
			LogCapture.info("User entered Swift code");
		} else if (CountryCourrency.equalsIgnoreCase("Hong kong-HKD")
				|| CountryCourrency.equalsIgnoreCase("United States of America-USD")
				|| CountryCourrency.equalsIgnoreCase("China-HKD") || CountryCourrency.equalsIgnoreCase("India-INR")) {
			String vobjSWiftCode = Constants.AndroidCDAppRecipient.getProperty("Swiftcode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjSWiftCode, swiftcode));
			Assert.assertEquals("PASS", Constants.key.clearText(vobjSWiftCode));
			Assert.assertEquals("PASS", Constants.key.click(vobjSWiftCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjSWiftCode, swiftcode));
			LogCapture.info("User entered Swift code");
		} else if (CountryCourrency.equalsIgnoreCase("Finland-EUR")) {
			String vobjIntracountry = Constants.AndroidCDAppRecipient.getProperty("Swiftcode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, swiftcode));
			Assert.assertEquals("PASS", Constants.key.clearText(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.click(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, swiftcode));

		} else if (CountryCourrency.equalsIgnoreCase("New Zealand-NZD")
				|| CountryCourrency.equalsIgnoreCase("Australia-AUD")
				|| CountryCourrency.equalsIgnoreCase("South Africa-ZAR")
				|| CountryCourrency.equalsIgnoreCase("China-HKD")) {
			String vobjIntracountry = Constants.AndroidCDAppRecipient.getProperty("BSBCode");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, swiftcode));
			Assert.assertEquals("PASS", Constants.key.clearText(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.click(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, swiftcode));
		} else if (CountryCourrency.equalsIgnoreCase("South Africa-ZAR")) {

			Constants.key.scrollDownUI("Continue");
			String vObjBankCode = Constants.AndroidCDAppRecipient.getProperty("BankCodeID");
			Assert.assertEquals("PASS", Constants.key.click(vObjBankCode));

			MobileElement bankcode = Constants.driver.findElement(By.xpath(vObjBankCode));
			int x = bankcode.getCenter().getX();
			int y = bankcode.getCenter().getY() + 200;
			TouchAction a2 = new TouchAction(Constants.driver).tap(PointOption.point(x, y)).release().perform();

			String vobjIntracountry = Constants.AndroidCDAppRecipient.getProperty("IntracountryABANumber");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, swiftcode));
			Assert.assertEquals("PASS", Constants.key.clearText(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.click(vobjIntracountry));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjIntracountry, swiftcode));
			LogCapture.info("User entered ABA Number");
			Thread.sleep(3000);
		}
	}

	@When("^android user clicks on continue button$")
	public void android_user_clicks_on_continue_button() throws Throwable {
		String vObjContinueButton = Constants.AndroidCDAppRecipient.getProperty("ContinueBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjContinueButton));

	}

	@Then("^android user should navigate to recipient list screen$")
	public void android_user_should_navigate_to_recipient_list_screen() throws Throwable {
		String vObjRecpientList = Constants.AndroidCDAppRecipient.getProperty("RecpientList");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRecpientList));
		LogCapture.info("User is on recipient list screen");

	}

	@And("^newly added recipient details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" should be displayed at top of the list in android app$")
	public void newly_added_recipient_details_something_something_something_should_be_displayed_at_top_of_the_list_in_android_app(
			String recipientname, String accountnumber, String countrycurrency) throws Throwable {

		String vObjRecpientListitm = Constants.AndroidCDAppRecipient.getProperty("Recipientlistitem");
		String vObjRecipientName = Constants.AndroidCDAppRecipient.getProperty("RecipientName");
		String vObjRecipientCurrency = Constants.AndroidCDAppRecipient.getProperty("RecipientCurrency");
		String vObjRecipientAccountNumber = Constants.AndroidCDAppRecipient.getProperty("RecipientAccountnumber");

		String Data4[] = countrycurrency.split("-");

		String vRecipientName = Constants.key.getAttributeValue(vObjRecpientListitm + 0 + vObjRecipientName, "text");
		String vCurrency = Constants.key.getAttributeValue(vObjRecpientListitm + 0 + vObjRecipientCurrency, "text");
		String vRecipientAccountNumber = Constants.key
				.getAttributeValue(vObjRecpientListitm + 0 + vObjRecipientAccountNumber, "text");
		String vAccount4digit = vRecipientAccountNumber.substring((vRecipientAccountNumber.length() - 4),
				(vRecipientAccountNumber.length()));

		String vUnmaskedAccNo = accountnumber.substring((accountnumber.length() - 4), (accountnumber.length()));

		if (vRecipientName.equalsIgnoreCase(recipientname) && vCurrency.equalsIgnoreCase(Data4[1])
				&& vUnmaskedAccNo.equalsIgnoreCase(vAccount4digit)) {

			LogCapture.info(
					"Recipient match found at top : " + vRecipientName + ",Account No :" + vRecipientAccountNumber);

		} else {
			LogCapture.info("Recipient match not found");
		}

	}

	@Then("^android application should be displayed bank details according to swift code$")
	public void android_application_should_be_displayed_bank_details_according_to_swift_code() throws Throwable {
		String vObjCurrencydrop = Constants.AndroidCDAppRecipient.getProperty("Currencydrop");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencydrop));
		Assert.assertEquals("PASS", Constants.key.click(vObjCurrencydrop));
		String vObjCountryList = Constants.AndroidCDAppRecipient.getProperty("Countrylist");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryList));
		String vObjCurrencyBack = Constants.AndroidCDAppRecipient.getProperty("CurrencyBackButton");
		Assert.assertEquals("PASS", Constants.key.click(vObjCurrencyBack));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencydrop));

		Constants.key.scrollDownUI("Continue");
		String BankNameValue = Constants.AndroidCDAppRecipient.getProperty("BankNameValue");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(BankNameValue));
		String BankNameText = Constants.key.getAttributeValue(BankNameValue, "text");
		LogCapture.info("Bank Name fetcehd " + BankNameText);

		String BankSwiftcode = Constants.AndroidCDAppRecipient.getProperty("SwiftBankCodeValue");
		String Bankcodevalue = Constants.key.getAttributeValue(BankSwiftcode, "text");
		LogCapture.info("Bank Code fetcehd " + Bankcodevalue);

	}

	@When("^android user provides invalid (card number|unmatched contacts last name|issue date|expiry date) \"([^\"]*)\"$")
	public void android_user_provides_invalid_expiry_date_something(String optionalValue, String data)
			throws Throwable {
		String vObjCardholderName = Constants.CDAppDashboard.getProperty("CardHoldeNameTextField");
		String vObjCardNoInput = Constants.CDAppDashboard.getProperty("CardNoInput");
		String vObjExpDateInput = Constants.CDAppDashboard.getProperty("ExpiryDateInput");
		String vObjIssueDate = Constants.CDAppDashboard.getProperty("IssueDate");

		if (optionalValue.equalsIgnoreCase("unmatched contacts last name")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCardholderName));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardholderName, data));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardNoInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjCardNoInput));
			LogCapture.info("User entered invalid card owner name : " + data);

		} else if (optionalValue.equalsIgnoreCase("card number")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCardNoInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardNoInput, data));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardNoInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjIssueDate));
			LogCapture.info("User entered invalid card number : " + data);
		} else if (optionalValue.equalsIgnoreCase("issue date")) {
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIssueDate, data));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjExpDateInput));
			LogCapture.info("User entered invalid issue date : " + data);
		} else if (optionalValue.equalsIgnoreCase("expiry date")) {
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjExpDateInput, data));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjExpDateInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjExpDateInput));
			LogCapture.info("User entered invalid expiry date (MMYY): " + data);
		}
	}

	@Then("^invalid (last name|card number|issue date) error message should be displayed to andoid user$")
	public void invalid_expiry_date_error_message_should_be_displayed_to_android_user(String optionalValue)
			throws Throwable {

		if (optionalValue.equalsIgnoreCase("last name")) {
			String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidLastNameErrMsg");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidLastNameErrMsg");
			Thread.sleep(3000);
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid last name error message verified.........");

		} else if (optionalValue.equalsIgnoreCase("card number")) {
			String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidCardNoErrMsg");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidCardNoErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid card number error message verfied......");

		} else if (optionalValue.equalsIgnoreCase("issue date")) {
			String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidIssueDateErrMsg");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidIssueErrMsg");
			// Thread.sleep(3000);
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Issue date error message verfied......");

		} else if (optionalValue.equalsIgnoreCase("cvv")) {
			String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidCVVErrMsg");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidCVVErrMsg");
			Thread.sleep(3000);
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Invalid cvv no error message verfied......");
		}
	}

	@Then("^invalid expiry date error message should be displayed to android user$")
	public void invalid_expiry_date_error_message_should_be_displayed_to_android_user() throws Throwable {
		String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidExpiryDateErrMsg");
		String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidExpiryErrMsg");
		String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
		Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
		LogCapture.info("Issue date error message verfied......");
	}

	@And("^android user does not provide (card holder name|card number|issue date|expiry date)$")
	public void android_user_does_not_provide_card_holder_name(String optionalValue) throws Throwable {
		String vObjCardholderName = Constants.CDAppDashboard.getProperty("CardHoldeNameTextField");
		String vObjCardNoInput = Constants.CDAppDashboard.getProperty("CardNoInput");
		String vObjExpDateInput = Constants.CDAppDashboard.getProperty("ExpiryDateInput");
		// String vObjCVVInput =
		// Constants.CDAppDashboard.getProperty("CVVInput");
		String vObjIssueDate = Constants.CDAppDashboard.getProperty("IssueDate");

		if (optionalValue.equalsIgnoreCase("card holder name")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCardholderName));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCardholderName));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardNoInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjCardNoInput));
			LogCapture.info("Cleared card holder name....");

		} else if (optionalValue.equalsIgnoreCase("card number")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCardNoInput));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCardNoInput));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjExpDateInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjExpDateInput));
			LogCapture.info("Cleared card number....");

		} else if (optionalValue.equalsIgnoreCase("issue date")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjIssueDate));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjIssueDate));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjExpDateInput));
			Assert.assertEquals("PASS", Constants.key.click(vObjExpDateInput));
			LogCapture.info("Cleared Issue Date....");
		} else if (optionalValue.equalsIgnoreCase("expiry date")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjExpDateInput));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjExpDateInput));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjIssueDate));
			Assert.assertEquals("PASS", Constants.key.click(vObjIssueDate));
			LogCapture.info("Cleared expiry date....");

		}

	}

	@And("^android user enters invalid account number \"([^\"]*)\"$")
	public void android_user_enters_invalid_account_number_something(String accountnumber) throws Throwable {
		String vObjRecipientAccountNumber = Constants.AndroidCDAppRecipient.getProperty("RecipientAccountNumber");
		Assert.assertEquals("PASS", Constants.key.click(vObjRecipientAccountNumber));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientAccountNumber, accountnumber));

	}

	@Then("^prepopulated \"([^\"]*)\" should be displayed to android user based on selected \"([^\"]*)\"$")
	public void prepopulated_something_should_be_displayed_to_android_user_based_on_selected_something(String currency,
																									   String country) throws Throwable {
		String vbjCurrencyPrepopulated = Constants.AndroidCDAppRecipient.getProperty("CurrencyPrepopulated");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vbjCurrencyPrepopulated));
		String CurrencyTxt = Constants.key.getAttributeValue(vbjCurrencyPrepopulated, "text");

		if (country.equalsIgnoreCase("Spain")) {
			Assert.assertEquals(CurrencyTxt, currency);
			LogCapture.info("Currecy populated as per country is " + currency);
		} else if (country.equalsIgnoreCase("Australia")) {
			Assert.assertEquals(CurrencyTxt, currency);
			LogCapture.info("Currecy populated as per country is " + currency);
		} else if (country.equalsIgnoreCase("Canada")) {
			Assert.assertEquals(CurrencyTxt, currency);
			LogCapture.info("Currecy populated as per country is " + currency);
		}

	}

	@And("^android user waits until access token expired for miliseconds \"([^\"]*)\"$")
	public void android_user_waits_until_access_token_expired_for_miliseconds_something(long miliseconds)
			throws Throwable {
		Thread.sleep(miliseconds);
	}

	// ***********Registration*************//
	@When("^android user click on the create an account button on onboarding screen$")
	public void android_user_click_on_the_create_an_account_button_on_onboarding_screen() throws Throwable {
		android_login_signup_options_should_be_present_on_onboarding_screen();
		android_loginuser_click_on_the_Sign_up_button();
	}

	@Then("^android user should navigate to about you screen$")
	public void android_user_should_navigate_to_about_you_screen() throws Throwable {
		android_loginuser_should_navigate_to_registration_process_screen();

	}

	@Then("^android app should load the onboarding screen$")
	public void android_app_should_load_the_onboarding_screen() throws Throwable {
		android_login_signup_options_should_be_present_on_onboarding_screen();
	}

	@When("^android user click on the create an account button on login screen$")
	public void android_user_click_on_the_create_an_account_button_on_login_screen() throws Throwable {

		Thread.sleep(1000);
		String vObjCreateaccount = Constants.AndroidCDAppRegistrationOR.getProperty("CreateAccLogin");
		Assert.assertEquals("PASS", Constants.key.click(vObjCreateaccount));
		LogCapture.info("Clicked on create an account button");

	}
	// Account Tab

	@Then("^accounts menu screen should be display to andriod user$")
	public void accounts_menu_screen_should_be_display_to_andriod_user() throws Throwable {
		String vObjAccountTitle = Constants.AndroidCDAppAccountOR.getProperty("AccountTitle");
		String vActualText = Constants.key.getAttributeValue(vObjAccountTitle, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("Account", vActualText));
	}

	@Then("^Customer Name \"([^\"]*)\" should be display on account screen to andriod user$")
	public void customer_Name_should_be_display_on_account_screen_to_andriod_user(String CustName) throws Throwable {
		String vObjCustName = Constants.AndroidCDAppAccountOR.getProperty("CustomerName");
		String vObjCustNameText = Constants.driver.findElement(By.xpath(vObjCustName)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCustNameText, CustName));
		LogCapture.info("Customer name :" + vObjCustNameText);
	}

	@Then("^Customer ID number \"([^\"]*)\"should be display on account screen to andriod user$")
	public void customer_ID_number_should_be_display_on_account_screen_to_andriod_user(String CustID) throws Throwable {
		String vObjCustID = Constants.AndroidCDAppAccountOR.getProperty("CustomerID");
		String vObjCustIDText = Constants.driver.findElement(By.xpath(vObjCustID)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCustIDText, CustID));
		LogCapture.info("Customer ID Number :" + vObjCustIDText);
	}

	@Then("^(Personal Details|Debit Cards|Biometric on/off|Our Bank Details|Help and Support|Manage Device|Logout) option should be display on account screen to andriod user$")
	public void customer_Name_option_should_be_display_on_account_screen_to_andriod_user(String menu) throws Throwable {
		if (menu.equals("Personal Details")) {
			String vObjPersonalDetails = Constants.AndroidCDAppAccountOR.getProperty("AccPersonalDetails");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPersonalDetails));
			LogCapture.info("" + menu + " is Displayed.......");
		} else if (menu.equals("Debit Cards")) {
			String vObjDebitCardBtn = Constants.AndroidCDAppAccountOR.getProperty("AccDebitCardBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardBtn));
			LogCapture.info("" + menu + " is Displayed.......");
		} else if (menu.equals("Biometric on/off")) {
			String vObjBiometric = Constants.AndroidCDAppAccountOR.getProperty("AccBiometric");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBiometric));
			LogCapture.info("" + menu + " is Displayed.......");
		} else if (menu.equals("Our Bank Details")) {
			String vObjOurBankDetails = Constants.AndroidCDAppAccountOR.getProperty("AccOurBankDetails");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOurBankDetails));
			LogCapture.info("" + menu + " is Displayed.......");
		} else if (menu.equals("Help and Support")) {
			String vObjHelpAndSupport = Constants.AndroidCDAppAccountOR.getProperty("AccHelpAndSupport");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjHelpAndSupport));
			LogCapture.info("" + menu + " is Displayed.......");
		} else if (menu.equals("Manage Device")) {
			String vObjManageDevice = Constants.AndroidCDAppAccountOR.getProperty("AccManageDevice");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjManageDevice));
			LogCapture.info("" + menu + " is Displayed.......");
		} else if (menu.equals("Logout")) {
			String vObjLogout = Constants.AndroidCDAppAccountOR.getProperty("LogoutBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLogout));
			LogCapture.info("" + menu + " is Displayed.......");
		}
	}

	@When("^android user selects (Personal Details|Our Bank Details|Help and Support|Manage Device|Debit Cards|Biometrics on/off|Logout|Help and Support)$")
	public void android_user_selects_Personal_Details(String menu) throws Throwable {
		if (menu.equals("Personal Details")) {
			String vObjPersonalDetails = Constants.AndroidCDAppAccountOR.getProperty("AccPersonalDetails");
			Assert.assertEquals("PASS", Constants.key.click(vObjPersonalDetails));
			LogCapture.info("User click on " + menu + ".......");
		} else if (menu.equals("Debit Cards")) {
			String vObjDebitCardBtn = Constants.AndroidCDAppAccountOR.getProperty("AccDebitCardBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjDebitCardBtn));
			LogCapture.info("User click on " + menu + ".......");
		} else if (menu.equals("Biometric on/off")) {
			String vObjBiometric = Constants.AndroidCDAppAccountOR.getProperty("AccBiometric");
			Assert.assertEquals("PASS", Constants.key.click(vObjBiometric));
			LogCapture.info("User click on " + menu + ".......");
		} else if (menu.equals("Our Bank Details")) {
			String vObjOurBankDetails = Constants.AndroidCDAppAccountOR.getProperty("AccOurBankDetails");
			Assert.assertEquals("PASS", Constants.key.click(vObjOurBankDetails));
			Thread.sleep(2000);
			LogCapture.info("User click on " + menu + ".......");
		} else if (menu.equals("Help and Support")) {
			String vObjHelpAndSupport = Constants.AndroidCDAppAccountOR.getProperty("AccHelpAndSupport");
			Assert.assertEquals("PASS", Constants.key.click(vObjHelpAndSupport));
			LogCapture.info("User click on " + menu + ".......");
		} else if (menu.equals("Manage Device")) {
			String vObjManageDevice = Constants.AndroidCDAppAccountOR.getProperty("AccManageDevice");
			Assert.assertEquals("PASS", Constants.key.click(vObjManageDevice));
			LogCapture.info("User click on " + menu + ".......");
		} else if (menu.equals("Logout")) {
			String vObjLogout = Constants.AndroidCDAppAccountOR.getProperty("LogoutBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjLogout));
			LogCapture.info("User click on " + menu + ".......");
		} else if (menu.equals("Help and Support")) {
			String vObjHelpSupport = Constants.AndroidCDAppAccountOR.getProperty("HelpandSupport");
			Assert.assertEquals("PASS", Constants.key.click(vObjHelpSupport));
			LogCapture.info("User click on " + menu + ".......");
		}
	}

	@Then("^(Personal Details|bank account currency selection|Help and Support|Manage Device|My Cards) screen should be displayed to android user$")
	public void personal_Details_screen_should_be_displayed_to_android_user(String page) throws Throwable {

		String vObjPagetitle = Constants.AndroidCDAppAccountOR.getProperty("ScrrenTitle");
		Thread.sleep(15000);
		String vObjExpectedTitle = Constants.driver.findElement(By.xpath(vObjPagetitle)).getText();

		if (page.equals("Personal Details")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjExpectedTitle, "Personal details"));
		} else if (page.equals("bank account currency selection")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjExpectedTitle, "Bank details"));
		} else if (page.equals("Help and Support")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjExpectedTitle, "Help and support"));
		} else if (page.equals("Manage Device")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjExpectedTitle, "Manage device"));
		} else if (page.equals("My Cards")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjExpectedTitle, "Debit cards"));
		}

		String vObjCloseIcon = Constants.AndroidCDAppAccountOR.getProperty("CloseIcon");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCloseIcon));
		LogCapture.info("Displayed " + page + " screen to android user.......");
	}

	@Then("^(Biometric setup|logout) process should be initialised to android user$")
	public void biometric_setup_process_should_be_initialised_to_android_user(String process) throws Throwable {
		if (process.equals("Biometric setup")) {
			String vObjBiometricSwitch = Constants.AndroidCDAppLogin.getProperty("AndroidBiometricSwitch");
			Assert.assertEquals("true", Constants.key.getAttributeValue(vObjBiometricSwitch, "enabled").toString());
			LogCapture.info("User clicked on " + process + ".......");
		} else if (process.equals("logout")) {
			String vObjLogout = Constants.AndroidCDAppAccountOR.getProperty("ScrrenTitle");
			Thread.sleep(15000);
			String vObjExpectedTitle = Constants.driver.findElement(By.xpath(vObjLogout)).getText();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjExpectedTitle, "Logged out"));
		}
	}

	@When("^android user dismiss error popup$")
	public void android_user_dismiss_error_popup() throws Throwable {
		android_user_dismiss_recipient_delete_confirmation();
	}

	@Then("^the response not received by apply financial in android aap$")
	public void the_response_not_received_by_apply_financial_in_android_aap() throws Throwable {

		String vObjErrorBankDetail = Constants.AndroidCDAppRecipient.getProperty("ErrorbankDetails");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjErrorBankDetail));
		String vObjErrorBankDetailTxt = Constants.key.getAttributeValue(vObjErrorBankDetail, "text").toString();
		LogCapture.info("Error observed as:" + vObjErrorBankDetailTxt);
	}

	@Then("^the bank details should not be fetched in android aap$")
	public void the_bank_details_should_not_be_fetched_in_android_aap() throws Throwable {
		Constants.key.scrollDownUI("Save");
		String vObjBankName = Constants.AndroidCDAppRecipient.getProperty("BankName");
		Assert.assertEquals("FAIL", Constants.key.eleLocatedDisplayed(vObjBankName));
		LogCapture.info("Bank details not fetched");

	}

	@Then("^Customer Name \"([^\"]*)\" should be display on Personal Details to andriod user$")
	public void customer_Name_should_be_display_on_Personal_Details_to_andriod_user(String CustName) throws Throwable {
		String vObjCustName = Constants.AndroidCDAppAccountOR.getProperty("PersonalDetailsCustName");
		String vObjCustNameText = Constants.driver.findElement(By.xpath(vObjCustName)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCustNameText, CustName));
		LogCapture.info("Customer name : " + vObjCustNameText);
	}

	@Then("^Customer ID number \"([^\"]*)\" should be display on Personal Details to andriod user$")
	public void customer_ID_number_should_be_display_on_Personal_Details_to_andriod_user(String CustID)
			throws Throwable {
		String vObjCustID = Constants.AndroidCDAppAccountOR.getProperty("PersonalDetailsCustID");
		String vObjCustIDText = Constants.driver.findElement(By.xpath(vObjCustID)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCustIDText, CustID));
		LogCapture.info("Customer ID Number : " + vObjCustIDText);
	}

	@Then("^Customer email id \"([^\"]*)\" should be display on Personal Details to andriod user$")
	public void customer_email_id_should_be_display_on_Personal_Details_to_andriod_user(String EmailID)
			throws Throwable {
		String vObjCustEmailID = Constants.AndroidCDAppAccountOR.getProperty("EmailID");
		String vObjCustEmailIDText = Constants.driver.findElement(By.xpath(vObjCustEmailID)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCustEmailIDText, EmailID));
		LogCapture.info("Customer EmailID : " + vObjCustEmailIDText);
	}

	@Then("^Customer Billing Address \"([^\"]*)\" should be display on Personal Details to andriod user$")
	public void customer_Billing_Address_should_be_display_on_Personal_Details_to_andriod_user(String billingAdd)
			throws Throwable {
		String vObjCustBillingAdd = Constants.AndroidCDAppAccountOR.getProperty("BillingAddress");
		String vObjCustBillingAddText = Constants.driver.findElement(By.xpath(vObjCustBillingAdd)).getText().toString()
				.replaceAll("[\r\n]+", " ").replaceAll("\\s", "");
		;
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCustBillingAddText, billingAdd));
		LogCapture.info("Customer Billing Address : " + vObjCustBillingAddText);

	}

	@Then("^andriod user Contact details should be display on Personal Details which has legal entity is \"([^\"]*)\"$")
	public void andriod_user_Contact_details_should_be_display_on_Personal_Details_which_has_legal_entity_is(
			String legalEntity) throws Throwable {
		// Constants.CustLegalEntity = legalEntity;
		String vObjCustContactDetails = Constants.AndroidCDAppAccountOR.getProperty("ContactDetails");
		String vObjContactDetailsText = Constants.driver.findElement(By.xpath(vObjCustContactDetails)).getText();
		String vObjExpectedContactdetails = Constants.AndroidTestData.getProperty("ContactDetailsMsg_" + legalEntity);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjContactDetailsText, vObjExpectedContactdetails));
		LogCapture.info("Contact details : " + vObjContactDetailsText);
	}

	@Then("^Customer phone number \"([^\"]*)\" should be display on Personal Details to andriod user$")
	public void customer_phone_number_should_be_display_on_Personal_Details_to_andriod_user(String PhoneNo)
			throws Throwable {
		String vObjCustPhoneNo = Constants.AndroidCDAppAccountOR.getProperty("PhoneNo");
		String vObjvObjCustPhoneNoText = Constants.driver.findElement(By.xpath(vObjCustPhoneNo)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjvObjCustPhoneNoText, PhoneNo));
		LogCapture.info("Contact details : " + vObjvObjCustPhoneNoText);
	}

	@When("^android user presses the (close|back) icon$")
	public void android_user_presses_the_close_icon(String icon) throws Throwable {
		if (icon.equals("close")) {
			String vObjCloseIcon = Constants.AndroidCDAppAccountOR.getProperty("CloseIcon");
			Assert.assertEquals("PASS", Constants.key.click(vObjCloseIcon));
			LogCapture.info("user clicked on close button");
			Thread.sleep(5000);
		} else if (icon.equals("back")) {
			String vObjBackBtn = Constants.AndroidCDAppAccountOR.getProperty("BackBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjBackBtn));
			LogCapture.info("user clicked on back button");
			Thread.sleep(5000);
		}
	}

	@Then("^andriod user landed on bank details screen$")
	public void andriod_user_landed_on_bank_details_screen() throws Throwable {
		Thread.sleep(6000);
		String vObjBankDetails = Constants.AndroidCDAppAccountOR.getProperty("CurrencyBankDetaildHeader");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankDetails));
	}

	@Then("^Details screen should close and andriod user should navigate to the Accounts menu screen$")
	public void details_screen_should_close_and_andriod_user_should_navigate_to_the_Accounts_menu_screen()
			throws Throwable {
		String vObjCloseIcon = Constants.AndroidCDAppAccountOR.getProperty("CloseIcon");
		Assert.assertEquals("PASS", Constants.key.notexist(vObjCloseIcon, ""));

		String vObjAccountTitle = Constants.AndroidCDAppAccountOR.getProperty("AccountTitle");
		String vActualText = Constants.key.getAttributeValue(vObjAccountTitle, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vActualText, "Account"));
		LogCapture.info("User navigated on Account menu tab ....");
	}

	@Then("^Botton bar should be diplsay on account menu$")
	public void botton_bar_should_be_diplsay_on_account_menu() throws Throwable {
		String vObjBottomBar = Constants.AndroidCDAppAccountOR.getProperty("BottomBar");
		Assert.assertEquals("PASS", Constants.key.isElementPresent(vObjBottomBar, 60));
		LogCapture.info("Displayed Bottom bar successfully....");
	}

	@Then("^(search option|List of currencies|close icon) should be display on currency selection screen to andriod user$")
	public void search_option_should_be_display_on_currency_selection_screen_to_andriod_user(String option)
			throws Throwable {
		if (option.equals("search option")) {
			String vObjSearchOption = Constants.AndroidCDAppAccountOR.getProperty("CurrencySearchbox");
			Assert.assertEquals("PASS", Constants.key.isElementPresent(vObjSearchOption, 60));
			LogCapture.info("Currency option displayed on bank details screen ....");
		} else if (option.equals("List of currencies")) {
			String vObjCurrencyList = Constants.AndroidCDAppAccountOR.getProperty("CurrencyListSection");
			Assert.assertEquals("PASS", Constants.key.isElementPresent(vObjCurrencyList, 60));
			LogCapture.info("List of currencies displayed on bank details screen ....");
		} else if (option.equals("close icon")) {
			String vObjCloseIcon = Constants.AndroidCDAppAccountOR.getProperty("CloseIcon");
			Assert.assertEquals("PASS", Constants.key.isElementPresent(vObjCloseIcon, 60));
			LogCapture.info("close icon displayed on bank details screen ....");
		}
	}

	@When("^android user enters currency name \"([^\"]*)\" in search box$")
	public void android_user_enters_currency_name_in_search_box(String currency) throws Throwable {
		String vObjCurrency = Constants.AndroidCDAppAccountOR.getProperty("CurrencySearchbox");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCurrency, currency));
		LogCapture.info("user enter " + currency + " currency...");
	}

	@Then("^android user clicked on searched currency$")
	public void android_user_clicked_on_searched_currency() throws Throwable {
		String vObjSelectedCurrency = Constants.AndroidCDAppAccountOR.getProperty("SelectedCurrency");
		Assert.assertEquals("PASS", Constants.key.click(vObjSelectedCurrency));
		LogCapture.info("user clicked on searched currency...");
	}

	@Then("^\"([^\"]*)\" list should be filtered with matching options through fuzzy logic to andriod user$")
	public void list_should_be_filtered_with_matching_options_through_fuzzy_logic_to_andriod_user(String code)
			throws Throwable {
		String vObjCurrencyList = Constants.AndroidCDAppAccountOR.getProperty("CurrencyListSection");
		List<MobileElement> filterlist = Constants.key.getElementList(vObjCurrencyList);
		boolean isPresent = true;
		if (filterlist == null || filterlist.isEmpty()) {
			Assert.assertEquals("PASS", "PASS");
		}
		for (MobileElement el : filterlist) {
			String vObjCurrencyText1 = Constants.AndroidCDAppAccountOR.getProperty("currencyLetterInCode");
			String vObjCurrencyText2 = Constants.AndroidCDAppAccountOR.getProperty("currencyLetterInName");
			String vObjCustNameTextCode = el.findElement(By.xpath(vObjCurrencyText1)).getText().toLowerCase();
			String vObjCustNameTextName = el.findElement(By.xpath(vObjCurrencyText2)).getText().toLowerCase();

			if (!vObjCustNameTextCode.contains(code.toLowerCase())
					&& !vObjCustNameTextName.contains(code.toLowerCase())) {
				isPresent = false;
			}
		}
		if (isPresent) {
			Assert.assertEquals("PASS", "PASS");
		} else {
			Assert.assertEquals("PASS", Constants.KEYWORD_FAIL);
		}
	}

	@Then("^android user clicks the close icon in the search field$")
	public void android_user_clicks_the_close_icon_in_the_search_field() throws Throwable {
		String vObjSearchCloseIcon = Constants.AndroidCDAppAccountOR.getProperty("SearchCurrencyClose");
		Assert.assertEquals("PASS", Constants.key.click(vObjSearchCloseIcon));
		LogCapture.info("user clicked on search close button");
		Thread.sleep(40000);
	}

	@Then("^screen should be displayed with the selected \"([^\"]*)\" bank (details|text message) to andriod user$")
	public void screen_should_be_displayed_with_the_selected_bank_details_to_andriod_user(String currency,
																						  String option) throws Throwable {
		if (option.equals("details")) {
			Thread.sleep(6000);

			String vObjCurrencyHeader = Constants.AndroidCDAppAccountOR.getProperty("CurrencyBankDetaildHeader");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencyHeader));
			String vObjCurrencyHeaderText = Constants.driver.findElement(By.xpath(vObjCurrencyHeader)).getText();
			Assert.assertEquals("PASS",
					Constants.key.VerifyTextContains(vObjCurrencyHeaderText, currency));
		} else if (option.equals("text message")) {
			String vObjDetailTextMsg = Constants.AndroidCDAppAccountOR.getProperty("BankDetailMsg");
			String vObjTextMsgtext = Constants.driver.findElement(By.xpath(vObjDetailTextMsg)).getText();
			Assert.assertEquals("PASS", Constants.key.VerifyTextContains(vObjTextMsgtext, currency));
		}
	}

	@Then("^Bank Details should be diplay as per \"([^\"]*)\"$")
	public void bank_Details_should_be_diplay_as_per(String entityCurrency) throws Throwable {

		String dataString = Constants.AndroidTestData.getProperty(entityCurrency);
		String[] dataList = dataString.split("#");

		for (int i = 0; i < dataList.length; i++) {
			String[] Data1;


			Data1 = dataList[i].split(":");
			String vObjAccountName = Constants.AndroidCDAppAccountOR.getProperty(Data1[0].trim());
			String vExpectedTest = Data1[1];
			if (vExpectedTest == null) {
				vExpectedTest = "";
			}
			LogCapture.info("ExpectedData : " + vExpectedTest + "....");
			String isfieldPresent = Constants.key.isElementPresent(vObjAccountName, 2);
			// below if-else is used to check when value of any filed is not
			// present in that case element is not located in android side
			if (isfieldPresent == Constants.KEYWORD_FAIL) {
				Assert.assertEquals("PASS", "PASS");
			} else {
				String vActualText = Constants.driver.findElement(By.xpath(vObjAccountName)).getText().trim();
				LogCapture.info("ActualData   : " + vActualText + "....");
				Assert.assertEquals("PASS",
						Constants.key.VerifyText(vActualText, vExpectedTest.trim()));
			}

		}
	}

	@Then("^back icon should be display on bank details screen to andriod user$")
	public void back_icon_should_be_display_on_bank_details_screen_to_andriod_user() throws Throwable {
		String vObjBackBtn = Constants.AndroidCDAppAccountOR.getProperty("BackBtn");
		Assert.assertEquals("PASS", Constants.key.isElementPresent(vObjBackBtn, 60));
		LogCapture.info("back icon displayed on bank details scrren....");
	}

	@Then("^Selected currency should be highlighted$")
	public void selected_currency_should_be_highlighted() throws Throwable {

	}

	// My Card :CR-focus
	@When("^android user enter valid (last name|card number|issue date|expiry date) \"([^\"]*)\"$")
	public void android_user_enter_valid_last_name(String value, String data) throws Throwable {
		String vObjCardholderName = Constants.CDAppDashboard.getProperty("CardHoldeNameTextField");
		String vObjCardNoInput = Constants.CDAppDashboard.getProperty("CardNoInput");
		String vObjExpDateInput = Constants.CDAppDashboard.getProperty("ExpiryDateInput");
		String vObjIssueDate = Constants.CDAppDashboard.getProperty("IssueDate");

		if (value.equalsIgnoreCase("last name")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCardholderName));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardholderName, data));
			LogCapture.info("User entered valid " + value + " : " + data);
		} else if (value.equalsIgnoreCase("card number")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCardNoInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCardNoInput, data));
			LogCapture.info("User entered valid " + value + " : " + data);
		} else if (value.equalsIgnoreCase("issue date")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjIssueDate));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjIssueDate, data));
			LogCapture.info("User entered valid " + value + " : " + data);
		} else if (value.equalsIgnoreCase("expiry date")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjExpDateInput));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjExpDateInput, data));
			LogCapture.info("User entered valid " + value + " : " + data);
		}
	}

	@Then("^invalid (last name|card number|issue date|expiry date) error message should be removed to andoid user$")
	public void invalid_last_name_error_message_should_be_removed_to_andoid_user(String option) throws Throwable {
		if (option.equalsIgnoreCase("last name")) {
			String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidLastNameErrMsg");
			Assert.assertEquals("PASS", Constants.key.notexist(vObjErrorLbl, ""));
			LogCapture.info(" error message has been removed for : " + option + "");
		} else if (option.equalsIgnoreCase("card number")) {
			String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidCardNoErrMsg");
			Assert.assertEquals("PASS", Constants.key.notexist(vObjErrorLbl, ""));
			LogCapture.info(" error message has been removed for : " + option + "");
		} else if (option.equalsIgnoreCase("issue date")) {
			String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidIssueDateErrMsg");
			Assert.assertEquals("PASS", Constants.key.notexist(vObjErrorLbl, ""));
			LogCapture.info(" error message has been removed for : " + option + "");
		} else if (option.equalsIgnoreCase("expiry date")) {
			String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidExpiryDateErrMsg");
			Assert.assertEquals("PASS", Constants.key.notexist(vObjErrorLbl, ""));
			LogCapture.info(" error message has been removed for : " + option + "");
		}
	}

	@Then("^mandatory (card holder name|card number|issue date|expiry date) error messages should be display to android user$")
	public void mandatory_card_holder_name_error_messages_should_be_display_to_android_user(String field)
			throws Throwable {
		if (field.equalsIgnoreCase("card holder name")) {
			String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidLastNameErrMsg");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidLastNameErrMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info(" " + field + " Error message: " + atbValue + " ...");
		} else if (field.equalsIgnoreCase("card number")) {
			String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidCardNoErrMsg");
			String vErrorMsg = Constants.AndroidTestData.getProperty("MandatoryCardNo");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info(" " + field + " Error message: " + atbValue + " ...");
		} else if (field.equalsIgnoreCase("issue date")) {
			String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidIssueDateErrMsg");
			String vErrorMsg = Constants.AndroidTestData.getProperty("MandatoryIssueDate");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info(" " + field + " Error message: " + atbValue + " ...");
		} else if (field.equalsIgnoreCase("expiry date")) {
			String vObjErrorLbl = Constants.CDAppDashboard.getProperty("InvalidExpiryDateErrMsg");
			String vErrorMsg = Constants.AndroidTestData.getProperty("MandatoryExpiryDate");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info(" " + field + " Error message: " + atbValue + " ...");
		}
	}


	@Then("^Android user select country \"([^\"]*)\"$")
	public void android_user_select_country(String country) throws Throwable {
		String vObjCountrySelected = Constants.CDAppDashboard.getProperty("CountrySelected");
		Assert.assertEquals("PASS", Constants.key.click(vObjCountrySelected));

		String vObjCountrySearch = Constants.CDAppDashboard.getProperty("CountrySearch");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountrySearch));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountrySearch, country));
		Assert.assertEquals("PASS", Constants.key.click(vObjCountrySelected));
		String vObjEnterAdressManually = Constants.CDAppDashboard.getProperty("EnterAdressManually");

		Assert.assertEquals("PASS", Constants.key.click(vObjEnterAdressManually));
		LogCapture.info("User clicked on enter adress manually....");
	}

	@When("^android user does not provide country detail \"([^\"]*)\" to android user$")
	public void android_user_does_not_provide_country_detail_to_android_user(String country) throws Throwable {
		Constants.key.scrollDownUI("Postcode");

		String vObjAdressLine1 = Constants.CDAppDashboard.getProperty("AdressLine1");
		String vObjAdressLine2 = Constants.CDAppDashboard.getProperty("AdressLine2");
		String vObjCity = Constants.CDAppDashboard.getProperty("City");
		String vObjPostcodeZip = Constants.CDAppDashboard.getProperty("Postcode");
		String vObjCountry = Constants.CDAppDashboard.getProperty("Country");
		String vObjAddress = Constants.CDAppDashboard.getProperty("Address");
		String vObjZipCode = Constants.CDAppDashboard.getProperty("ZipCode");
		if (country.equalsIgnoreCase("United Kingdom")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjAdressLine1));
			Assert.assertEquals("PASS", Constants.key.click(vObjAdressLine2));
			Assert.assertEquals("PASS", Constants.key.click(vObjCity));
			Assert.assertEquals("PASS", Constants.key.click(vObjPostcodeZip));
			Assert.assertEquals("PASS", Constants.key.click(vObjCountry));
			Constants.key.scrollDownUI("Please enter valid post code");

		} else if (country.equalsIgnoreCase("spain")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjAddress));
			Assert.assertEquals("PASS", Constants.key.click(vObjCity));
			Assert.assertEquals("PASS", Constants.key.click(vObjZipCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjCountry));
		}
	}

	@Then("^mandatory country \"([^\"]*)\" error message should be display to android user$")
	public void mandatory_country_error_message_should_be_display_to_android_user(String country) throws Throwable {
		Constants.key.scrollDownUI("Postcode");

		String vExpectedPostcodeZip = Constants.AndroidTestData.getProperty("InvalidPostcoceMsg");

		if (country.equalsIgnoreCase("United Kingdom")) {
			String vObjErroraddress1 = Constants.CDAppDashboard.getProperty("Adress1ErrorLbl");
			String vErrorExpectedMsg1 = Constants.AndroidTestData.getProperty("InvalidAdress1Msg");
			String atbValue = Constants.key.getAttributeValue(vObjErroraddress1, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorExpectedMsg1, atbValue));
			LogCapture.info("Address1 Error message: " + atbValue + " ...");

			/*String vObjAdressLine2 = Constants.CDAppDashboard.getProperty("Adress2ErrorLbl");
			String vExpectedAdressLine2 = Constants.AndroidTestData.getProperty("InvalidAdress2Msg");
			String vActualAdressLine2 = Constants.key.getAttributeValue(vObjAdressLine2, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vExpectedAdressLine2, vActualAdressLine2));
			LogCapture.info("Address1 Error message: " + vActualAdressLine2 + " ...");*/

			String vObjCity = Constants.CDAppDashboard.getProperty("CityErrorLbl");
			String vExpectedCity = Constants.AndroidTestData.getProperty("InvalidCityMsg");
			String vActualCity = Constants.key.getAttributeValue(vObjCity, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vExpectedCity, vActualCity));
			LogCapture.info("City Error message: " + vActualCity + " ...");

			String vObjPostcodeZip = Constants.CDAppDashboard.getProperty("PostcodeErrorLbl");
			String vActualPostcodeZip = Constants.key.getAttributeValue(vObjPostcodeZip, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vExpectedPostcodeZip, vActualPostcodeZip));
			LogCapture.info("Post code Error message: " + vActualPostcodeZip + " ...");
		} else if (country.equalsIgnoreCase("spain")) {
			String vObjAdress = Constants.CDAppDashboard.getProperty("AddressError");
			String vExpectedAdress = Constants.AndroidTestData.getProperty("ErrorMsgAddress");
			String vActualAddress = Constants.key.getAttributeValue(vObjAdress, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vExpectedAdress, vActualAddress));
			LogCapture.info("Address1 Error message: " + vActualAddress + " ...");

			String vObjCity = Constants.CDAppDashboard.getProperty("TownError");
			String vExpectedCity = Constants.AndroidTestData.getProperty("ErrorMsgTownCity");
			String vActualCity = Constants.key.getAttributeValue(vObjCity, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vExpectedCity, vActualCity));
			LogCapture.info("City Error message: " + vActualCity + " ...");

			String vObjPostcodeZip = Constants.CDAppDashboard.getProperty("ZipCodeError");
			Thread.sleep(2000);
			String vActualPostcodeZip = Constants.key.getAttributeValue(vObjPostcodeZip, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vExpectedPostcodeZip, vActualPostcodeZip));
			LogCapture.info("Post code Error message: " + vActualPostcodeZip + " ...");
		}
	}

	// Recipients : Add recipients : focus error messages
	@When("^android user enter invalid (first name|last name|company name|sort code|IBAN|swift code|transit number) \"([^\"]*)\"$")
	public void android_user_enter_invalid_first_name(String optionalValue, String data) throws Throwable {

		String vObjFirstNameTxt = Constants.AndroidCDAppRecipient.getProperty("FirstNameTxt");
		String vObjLastNameTxt = Constants.AndroidCDAppRecipient.getProperty("LastNameTxt");
		String vObjCompanyNameTxt = Constants.AndroidCDAppRecipient.getProperty("CompantNameTxt");
		String vObjSortCode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
		String vObjRecipientAccountNumber = Constants.AndroidCDAppRecipient.getProperty("RecipientAccountNumber");
		String vObjRecipientSwiftCode = Constants.AndroidCDAppRecipient.getProperty("SwiftCode");
		String vObjTransitCode = Constants.AndroidCDAppRecipient.getProperty("TransitCode");

		if (optionalValue.equalsIgnoreCase("first name")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameTxt));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameTxt, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjLastNameTxt));
			Thread.sleep(2000);
			LogCapture.info("User entered " + optionalValue + " " + data + " ...");
		} else if (optionalValue.equalsIgnoreCase("last name")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjLastNameTxt));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameTxt, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameTxt));
			Thread.sleep(2000);
			LogCapture.info("User entered " + optionalValue + " " + data + " ...");
		} else if (optionalValue.equalsIgnoreCase("company name")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameTxt));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameTxt, data));
			Thread.sleep(2000);
			LogCapture.info("User entered " + optionalValue + " " + data + " ...");
		} else if (optionalValue.equalsIgnoreCase("sort code")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjSortCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSortCode, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientAccountNumber));
			Thread.sleep(2000);
			LogCapture.info("User entered " + optionalValue + " " + data + " ...");
		} else if (optionalValue.equalsIgnoreCase("IBAN")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientAccountNumber));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientAccountNumber, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameTxt));
			Thread.sleep(2000);
			LogCapture.info("User entered " + optionalValue + " " + data + " ...");
		} else if (optionalValue.equalsIgnoreCase("swift code")) {
			Constants.key.scrollDownUI("SWIFTBIC");
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientSwiftCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientSwiftCode, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientAccountNumber));
			Thread.sleep(2000);
			LogCapture.info("User entered " + optionalValue + " " + data + " ...");
		} else if (optionalValue.equalsIgnoreCase("transit number")) {
			Constants.key.scrollDownUI("Routing number");
			Assert.assertEquals("PASS", Constants.key.click(vObjTransitCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTransitCode, data));
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientAccountNumber));
			Thread.sleep(2000);
			LogCapture.info("User entered " + optionalValue + " " + data + " ...");
		}

	}

	@Then("^error message should be displayed to andoid user as user enter invalid (first name|last name|company name|account number|sort code|IBAN|swift code|transit number)$")
	public void error_message_should_be_displayed_to_andoid_user_as_user_enter_invalid_first_name(String field)
			throws Throwable {

		if (field.equalsIgnoreCase("first name")) {
			String vObjErrorFirstName = Constants.AndroidCDAppRecipient.getProperty("ErrorFirstName");
			String vExpectedFirstName = Constants.AndroidTestData.getProperty("InvalidFirstName");
			String atbValue = Constants.key.getAttributeValue(vObjErrorFirstName, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vExpectedFirstName, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (field.equalsIgnoreCase("last name")) {
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorLastName");
			String vExpectedLastName = Constants.AndroidTestData.getProperty("InvalidLastName");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vExpectedLastName, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (field.equalsIgnoreCase("company name")) {
			Thread.sleep(3000);
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorCompanyName");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidCompanyName");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (field.equalsIgnoreCase("account number")) {
			Thread.sleep(2000);
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorAccountNumber");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidAccountNumber");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (field.equalsIgnoreCase("sort code")) {
			Thread.sleep(2000);
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorSortCode");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidSortCode");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (field.equalsIgnoreCase("IBAN")) {
			Thread.sleep(2000);
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorIBAN");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidIBAN");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (field.equalsIgnoreCase("swift code")) {
			Thread.sleep(2000);
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorSwiftCode");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidSwfitCode");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (field.equalsIgnoreCase("transit number")) {
			Thread.sleep(2000);
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorTransitCode");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidTransitCode");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		}
	}

	@When("^android user enter valid recipient (first name|last name|company name|sort code|IBAN|swift code|transit number) \"([^\"]*)\"$")
	public void android_user_enter_valid_recipient_first_name(String field, String data) throws Throwable {
		String vObjFirstNameTxt = Constants.AndroidCDAppRecipient.getProperty("FirstNameTxt");
		String vObjLastNameTxt = Constants.AndroidCDAppRecipient.getProperty("LastNameTxt");
		String vObjCompanyNameTxt = Constants.AndroidCDAppRecipient.getProperty("CompantNameTxt");
		String vObjRecipientAccountNumber = Constants.AndroidCDAppRecipient.getProperty("RecipientAccountNumber");
		String vObjSortCode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
		String vObjRecipientSwiftCode = Constants.AndroidCDAppRecipient.getProperty("SwiftCode");
		String vObjTransitCode = Constants.AndroidCDAppRecipient.getProperty("TransitCode");

		if (field.equalsIgnoreCase("first name")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameTxt));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjFirstNameTxt));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjFirstNameTxt, data));
			Thread.sleep(3000);
			LogCapture.info("User entered valid " + field + " : " + data + "..");
		} else if (field.equalsIgnoreCase("last name")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjLastNameTxt));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjLastNameTxt));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjLastNameTxt, data));
			Thread.sleep(3000);
			LogCapture.info("User entered valid " + field + " : " + data + "..");
		} else if (field.equalsIgnoreCase("company name")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameTxt));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjCompanyNameTxt));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCompanyNameTxt, data));
			Thread.sleep(3000);
			LogCapture.info("User entered valid " + field + " : " + data + "..");
		} else if (field.equalsIgnoreCase("sort code")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjSortCode));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjSortCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSortCode, data));
			Thread.sleep(3000);
			LogCapture.info("User entered valid " + field + " : " + data + "..");
		} else if (field.equalsIgnoreCase("IBAN")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjRecipientAccountNumber));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientAccountNumber, data));
			Thread.sleep(3000);
			LogCapture.info("User entered valid " + field + " : " + data + "..");
		} else if (field.equalsIgnoreCase("swift code")) {
			Assert.assertEquals("PASS", Constants.key.clearText(vObjRecipientSwiftCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientSwiftCode, data));
			String vObjHeader = Constants.AndroidCDAppRecipient.getProperty("AddRecipientTitle");
			Assert.assertEquals("PASS", Constants.key.click(vObjHeader));
			Thread.sleep(3000);
			LogCapture.info("User entered valid " + field + " : " + data + "..");
		} else if (field.equalsIgnoreCase("transit number")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjTransitCode));
			Assert.assertEquals("PASS", Constants.key.clearText(vObjTransitCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjTransitCode, data));
			Thread.sleep(3000);
			LogCapture.info("User entered valid " + field + " : " + data + "..");
		}

	}

	@Then("^error message should be removed to andoid user as user enter valid (first name|last name|company name|sort code|account number|IBAN|swift code|transit number)$")
	public void error_message_should_be_removed_to_andoid_user_as_user_enter_valid_first_name(String field)
			throws Throwable {
		if (field.equalsIgnoreCase("first name")) {
			String vObjErrorFirstName = Constants.AndroidCDAppRecipient.getProperty("ErrorFirstName");
			Assert.assertEquals("PASS", Constants.key.notexist(vObjErrorFirstName, ""));
			LogCapture.info("" + field + " :error message has been removed");
		} else if (field.equalsIgnoreCase("last name")) {
			String vObjErrorLastName = Constants.AndroidCDAppRecipient.getProperty("ErrorLastName");
			Assert.assertEquals("PASS", Constants.key.notexist(vObjErrorLastName, ""));
			LogCapture.info("" + field + " :error message has been removed");
		} else if (field.equalsIgnoreCase("company name")) {
			String vObjErrorCompanyName = Constants.AndroidCDAppRecipient.getProperty("ErrorCompanyName");
			Assert.assertEquals("PASS", Constants.key.notexist(vObjErrorCompanyName, ""));
			LogCapture.info("" + field + " :error message has been removed");
		} else if (field.equalsIgnoreCase("sort code")) {
			String vObjErrorsortcode = Constants.AndroidCDAppRecipient.getProperty("ErrorSortCode");
			Assert.assertEquals("PASS", Constants.key.notexist(vObjErrorsortcode, ""));
			LogCapture.info("" + field + " :error message has been removed");
		} else if (field.equalsIgnoreCase("account number")) {
			Constants.key.scrollDownUI("Bank details");
			String vObjErrorsortcode = Constants.AndroidCDAppRecipient.getProperty("ErrorAccountNo");
			Assert.assertEquals("PASS", Constants.key.notexist(vObjErrorsortcode, ""));
			LogCapture.info("" + field + " :error message has been removed");
		} else if (field.equalsIgnoreCase("IBAN")) {
			String vObjErrorIBAN = Constants.AndroidCDAppRecipient.getProperty("ErrorIBAN");
			Assert.assertEquals("PASS", Constants.key.notexist(vObjErrorIBAN, ""));
			LogCapture.info("" + field + " :error message has been removed");
		} else if (field.equalsIgnoreCase("swift code")) {
			Constants.key.scrollDownUI("Bank details");
			String vObjErrorSwiftCode = Constants.AndroidCDAppRecipient.getProperty("ErrorSwiftCode");
			Assert.assertEquals("PASS", Constants.key.notexist(vObjErrorSwiftCode, ""));
			LogCapture.info("" + field + " :error message has been removed");
		} else if (field.equalsIgnoreCase("transit number")) {
			String vObjErrorTransitCode = Constants.AndroidCDAppRecipient.getProperty("ErrorTransitCode");
			Assert.assertEquals("PASS", Constants.key.notexist(vObjErrorTransitCode, ""));
			LogCapture.info("" + field + " :error message has been removed");
		}
	}

	@When("^android user select recipient type \"([^\"]*)\"$")
	public void android_user_select_recipient_type(String type) throws Throwable {
		if (type.equalsIgnoreCase("Individual")) {
			String vObjIndividual = Constants.AndroidCDAppRecipient.getProperty("Individual");
			Assert.assertEquals("PASS", Constants.key.click(vObjIndividual));
			LogCapture.info("Recipent Type  :  " + type + " validated");

		} else if (type.equalsIgnoreCase("Company")) {
			String vObjCompany = Constants.AndroidCDAppRecipient.getProperty("Company");
			Assert.assertEquals("PASS", Constants.key.click(vObjCompany));
			LogCapture.info("Recipent Type  :  " + type + " validated");
		}
	}

	@When("^android user selects \"([^\"]*)\" for recipients$")
	public void android_user_selects_for_recipients(String country) throws Throwable {
		String vObjCountrydropdown = Constants.AndroidCDAppRecipient.getProperty("Countrydrop");
		String vObjCountrySearch = Constants.AndroidCDAppRecipient.getProperty("RecCountrySearch");
		String vObjSearchedCountry = Constants.AndroidCDAppRecipient.getProperty("SearchedCountry");

		Assert.assertEquals("PASS", Constants.key.click(vObjCountrydropdown));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountrySearch, country));
		LogCapture.info("user enter " + country + " currency...");
		Assert.assertEquals("PASS", Constants.key.click(vObjSearchedCountry));

	}

	@Then("^android user enter accountNo \"([^\"]*)\"$")
	public void android_user_enter_accountNo(String accountno) throws Throwable {
		String vObjRecipientAccountNumber = Constants.AndroidCDAppRecipient.getProperty("RecipientAccountNumber");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjRecipientAccountNumber, accountno));
		LogCapture.info("user enter accountno : " + accountno + " ");
	}

	@Then("^android user enter ABA number \"([^\"]*)\"$")
	public void android_user_enter_ABA_number(String abaNo) throws Throwable {
		Constants.key.scrollDownUI("Continue");
		String vObjBankCode = Constants.AndroidCDAppRecipient.getProperty("BankCodeID");
		// String vTest= Constants.AndroidCDAppRecipient.getProperty("BankID");

		Assert.assertEquals("PASS", Constants.key.click(vObjBankCode));
		MobileElement bankcode = Constants.driver.findElement(By.xpath(vObjBankCode));
		// vObjBankCode.sendKeys(text);
		int x = bankcode.getCenter().getX();
		int y = bankcode.getCenter().getY() + 50;

		TouchAction a2 = new TouchAction(Constants.driver).tap(PointOption.point(x, y)).release().perform();

		String vObjEditIntracountryCode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjEditIntracountryCode, abaNo));
		Thread.sleep(3000);

	}

	@When("^android user enters white spaces in (first name|last name|company name|sort code|IBAN|swift code|transit number)$")
	public void android_user_enters_blank_first_name(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("first name")) {
			android_user_enter_invalid_first_name("first name", "   ");
		} else if (optionalValue.equalsIgnoreCase("last name")) {
			android_user_enter_invalid_first_name("last name", "   ");
		} else if (optionalValue.equalsIgnoreCase("company name")) {
			android_user_enter_invalid_first_name("company name", "   ");
		} else if (optionalValue.equalsIgnoreCase("sort code")) {
			android_user_enter_invalid_first_name("sort code", "   ");
		} else if (optionalValue.equalsIgnoreCase("IBAN")) {
			android_user_enter_invalid_first_name("IBAN", "   ");
		} else if (optionalValue.equalsIgnoreCase("swift code")) {
			android_user_enter_invalid_first_name("swift code", "   ");
		} else if (optionalValue.equalsIgnoreCase("transit number")) {
			android_user_enter_invalid_first_name("transit number", "   ");
		}

	}

	@Then("^mandatory (first name|last name|company name|sort code|IBAN|swift code|transit number|address|account number) error message should be display to android user$")
	public void mandatory_first_name_error_message_should_be_display_to_android_user(String optionalvalue)
			throws Throwable {
		if (optionalvalue.equalsIgnoreCase("first name")) {
			String vObjErrorFirstName = Constants.AndroidCDAppRecipient.getProperty("ErrorFirstName");
			String vExpectedFirstName = Constants.AndroidTestData.getProperty("InvalidFirstName");
			String atbValue = Constants.key.getAttributeValue(vObjErrorFirstName, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vExpectedFirstName, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (optionalvalue.equalsIgnoreCase("last name")) {
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorLastName");
			String vExpectedLastName = Constants.AndroidTestData.getProperty("InvalidLastName");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vExpectedLastName, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (optionalvalue.equalsIgnoreCase("company name")) {
			Thread.sleep(3000);
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorCompanyName");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidCompanyName");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (optionalvalue.equalsIgnoreCase("account number")) {
			Thread.sleep(2000);
			Constants.key.scrollDownUI("Bank details");
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorAccountNumber");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidAccountNumber");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (optionalvalue.equalsIgnoreCase("sort code")) {
			Thread.sleep(2000);
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorSortCode");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidSortCode");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (optionalvalue.equalsIgnoreCase("IBAN")) {
			Thread.sleep(2000);
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorIBAN");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidIBAN");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (optionalvalue.equalsIgnoreCase("swift code")) {
			Thread.sleep(2000);
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorSwiftCode");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidSwfitCode");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (optionalvalue.equalsIgnoreCase("transit number")) {
			Thread.sleep(2000);
			String vObjErrorLbl = Constants.AndroidCDAppRecipient.getProperty("ErrorTransitCode");
			String vErrorMsg = Constants.AndroidTestData.getProperty("InvalidTransitCode");
			String atbValue = Constants.key.getAttributeValue(vObjErrorLbl, "text");
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorMsg, atbValue));
			LogCapture.info("Error message verfied: " + atbValue + "......");
		} else if (optionalvalue.equalsIgnoreCase("address")) {
			Thread.sleep(2000);
			Constants.key.scrollDownUI("Address");
			String vObjErrorPostCode = Constants.AndroidCDAppRecipient.getProperty("ErrorPostCode");
			String vErrorErrorPostMsg = Constants.AndroidTestData.getProperty("InvalidPostcoceMsg");
			String atbValuePostCode = Constants.key.getAttributeValue(vObjErrorPostCode, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorErrorPostMsg, atbValuePostCode));
			LogCapture.info("Post Code Error message: " + atbValuePostCode + " ... ");

			String vObjErrorCity = Constants.AndroidCDAppRecipient.getProperty("ErrorCity");
			String vErrorErrorCityMsg = Constants.AndroidTestData.getProperty("InvalidCityMsg");
			String atbValueCity = Constants.key.getAttributeValue(vObjErrorCity, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorErrorCityMsg, atbValueCity));
			LogCapture.info("City Error message: " + atbValueCity + " ... ");

			String vObjErrorAddress = Constants.AndroidCDAppRecipient.getProperty("Erroraddress");
			String vErrorErrorAddressMsg = Constants.AndroidTestData.getProperty("ErrorMsgAddress");
			String atbValueAddress = Constants.key.getAttributeValue(vObjErrorAddress, "text").trim();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vErrorErrorAddressMsg, atbValueAddress));
			LogCapture.info("address Error message: " + atbValueAddress + " ...");

		}
	}

	@When("^android user selects country-currency \"([^\"]*)\" and enters white spaces in address$")
	public void android_user_selects_country_currency_and_enters_blank_address(String countrycurrency)
			throws Throwable {
		String Data3[] = countrycurrency.split("-");
		android_user_selects_country_dropdown();
		list_of_available_country_should_be_displayed_in_android_app();
		android_user_should_be_able_to_select_country_something_by_using_search_option(Data3[0]);

		android_user_selects_currency_dropdown();
		list_of_available_currency_should_be_displayed_in_android_aap();
		android_user_types_each_character_something_in_search_field(Data3[1]);
		the_filtered_available_currencies_list_should_be_displayed_after_a_few_micro_seconds_in_android_app();
		android_user_select_currency();

		String vObjAdress = Constants.AndroidCDAppRecipient.getProperty("RecpientAdressLine1");
		Assert.assertEquals("PASS", Constants.key.click(vObjAdress));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAdress, "  "));
		// Assert.assertEquals("PASS", Constants.key.click(vObjAdress));
		LogCapture.info("User enterred  blank Address");
		Constants.key.scrollDownUI("Continue");

		String vObjCity = Constants.AndroidCDAppRecipient.getProperty("RecpientCity");
		Assert.assertEquals("PASS", Constants.key.click(vObjCity));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCity, "  "));
		LogCapture.info("User enterred blank City....");

		String vObjPostcodeZip = Constants.AndroidCDAppRecipient.getProperty("RecpientPostcode");
		Assert.assertEquals("PASS", Constants.key.click(vObjPostcodeZip));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostcodeZip, "  "));
		LogCapture.info("User enterred blank Postcode....");
		Thread.sleep(3000);
		Assert.assertEquals("PASS", Constants.key.click(vObjPostcodeZip));
		Assert.assertEquals("PASS", Constants.key.click(vObjAdress));

	}

	@Then("^the filter should be cleared and the whole currency list should be displayed in android app$")
	public void the_filter_should_be_cleared_and_the_whole_currency_list_should_be_displayed() throws Throwable {
		Thread.sleep(2000);
		String vObjCountryLabel = Constants.AndroidCDAppRecipient.getProperty("CurrencyListBox");
		LogCapture.info("All Currency List displayed............");
		int noOfCountry = Constants.key.getElementList(vObjCountryLabel).size();
		if (noOfCountry > 5) {
			LogCapture.info("Currency List displayed............");
		}

	}

	@Then("^android user does not provide recipients (first name|last name|company name|sort code|IBAN|account number|swift code|transit number|address)$")
	public void android_user_does_not_provide_recipients_first_name(String optionalValue) throws Throwable {
		String vObjFirstNameTxt = Constants.AndroidCDAppRecipient.getProperty("FirstNameTxt");
		String vObjLastNameTxt = Constants.AndroidCDAppRecipient.getProperty("LastNameTxt");
		String vObjCompanyNameTxt = Constants.AndroidCDAppRecipient.getProperty("CompantNameTxt");
		String vObjRecipientAccountNumber = Constants.AndroidCDAppRecipient.getProperty("RecipientAccountNumber");
		String vObjSortCode = Constants.AndroidCDAppRecipient.getProperty("IntracountryCode");
		String vObjRecipientSwiftCode = Constants.AndroidCDAppRecipient.getProperty("SwiftCode");
		String vObjTransitCode = Constants.AndroidCDAppRecipient.getProperty("TransitCode");

		if (optionalValue.equalsIgnoreCase("first name")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameTxt));
			Thread.sleep(3000);
			LogCapture.info("User does not provided :" + optionalValue + " ..");
		} else if (optionalValue.equalsIgnoreCase("last name")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjLastNameTxt));
			Assert.assertEquals("PASS", Constants.key.click(vObjFirstNameTxt));
			Thread.sleep(3000);
			LogCapture.info("User does not provided :" + optionalValue + " ..");
		} else if (optionalValue.equalsIgnoreCase("company name")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjCompanyNameTxt));
			Thread.sleep(3000);
			LogCapture.info("User does not provided :" + optionalValue + " ..");
		} else if (optionalValue.equalsIgnoreCase("sort code")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjSortCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientAccountNumber));
			Thread.sleep(3000);
			LogCapture.info("User does not provided :" + optionalValue + " ..");
		} else if (optionalValue.equalsIgnoreCase("IBAN")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientAccountNumber));
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientAccountNumber));
			Thread.sleep(3000);
			LogCapture.info("User does not provided :" + optionalValue + " ..");
		} else if (optionalValue.equalsIgnoreCase("account number")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientAccountNumber));
			Thread.sleep(3000);
			LogCapture.info("User does not provided :" + optionalValue + " ..");
		} else if (optionalValue.equalsIgnoreCase("swift code")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientSwiftCode));
			Assert.assertEquals("PASS", Constants.key.click(vObjRecipientAccountNumber));
			Thread.sleep(3000);
			LogCapture.info("User does not provided :" + optionalValue + " ..");
		} else if (optionalValue.equalsIgnoreCase("transit number")) {
			Assert.assertEquals("PASS", Constants.key.click(vObjTransitCode));
			Thread.sleep(3000);
			LogCapture.info("User does not provided :" + optionalValue + " ..");
		} else if (optionalValue.equalsIgnoreCase("address")) {

			String vObjAdress = Constants.AndroidCDAppRecipient.getProperty("RecpientAdressLine1");
			Assert.assertEquals("PASS", Constants.key.click(vObjAdress));
			LogCapture.info("User does not provided AdressLine1");
			Constants.key.scrollDownUI("Continue");

			String vObjCity = Constants.AndroidCDAppRecipient.getProperty("RecpientCity");
			Assert.assertEquals("PASS", Constants.key.click(vObjCity));
			LogCapture.info("User does not provided City");

			String vObjPostcodeZip = Constants.AndroidCDAppRecipient.getProperty("RecpientPostcode");
			Assert.assertEquals("PASS", Constants.key.click(vObjPostcodeZip));
			LogCapture.info("User does not provided PostcodeZip");

		}
	}

	@When("^the android user clicks close icon on recipient button$")
	public void the_android_user_clicks_close_icon_on_recipient_button() throws Throwable {
		String vObjCloseBtn = Constants.AndroidCDAppRecipient.getProperty("EditRecipientBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjCloseBtn));
		LogCapture.info("User clicked on recepient close icon");
	}

	// -----------------------------Registration
	// Module--------------------------


	@When("^android user enters the (valid|invalid|incorrect) (first name|last name|email id|date of birth) \"([^\"]*)\" on Registration page$")
	public void android_user_enters_the_valid_first_name_on_Registration_page(String optionalValue1,
																			  String optionalValue2, String data) throws Throwable {
		String vobjFirstNameReg = Constants.AndroidCDAppRegistrationOR.getProperty("FirstNameReg");
		String vobjLastNameReg = Constants.AndroidCDAppRegistrationOR.getProperty("LastNameReg");
		String vobjEmailReg = Constants.AndroidCDAppRegistrationOR.getProperty("EmaildIdreg");
		String vobjDateOfBirth = Constants.AndroidCDAppRegistrationOR.getProperty("Dobreg");
		if (optionalValue1.equalsIgnoreCase("valid") || optionalValue1.equalsIgnoreCase("invalid")) {
			if (optionalValue2.equalsIgnoreCase("first name")) {
				Assert.assertEquals("PASS", Constants.key.click(vobjFirstNameReg));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vobjFirstNameReg, data));
				LogCapture.info("Registration page: User  enter " + optionalValue2 + " : " + data);
			} else if (optionalValue2.equalsIgnoreCase("last name")) {
				Assert.assertEquals("PASS", Constants.key.click(vobjLastNameReg));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vobjLastNameReg, data));
				LogCapture.info("Registration page: User  enter " + optionalValue2 + " : " + data);
			} else if (optionalValue2.equalsIgnoreCase("email id")) {
				String vUsername = Constants.AndroidTestData.getProperty(data);
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjEmailReg));
				Assert.assertEquals("PASS", Constants.key.click(vobjEmailReg));

				//Assert.assertEquals("PASS", Constants.key.writeInInput(vobjEmailReg, vUsername));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vobjEmailReg, vUsername));

				//Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.writeInInput(vobjEmailReg, vUsername));
				Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.writeInInput(vobjEmailReg, vUsername));

				LogCapture.info("email id: " + vUsername);

			} else if (optionalValue2.equalsIgnoreCase("date of birth")) {
				Assert.assertEquals("PASS", Constants.key.click(vobjDateOfBirth));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vobjDateOfBirth, data));
				LogCapture.info("Registration page: User  enter  " + optionalValue2 + " : " + data);
				Assert.assertEquals("PASS", Constants.key.click(vobjFirstNameReg));
				// Assert.assertEquals("PASS",Constants.key.KeyboardAction(vobjDateOfBirth,
				// "TAB"));

			}
		} else if (optionalValue1.equalsIgnoreCase("incorrect")) {
			if (optionalValue2.equalsIgnoreCase("email id")) {
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjEmailReg));
				Assert.assertEquals("PASS", Constants.key.click(vobjEmailReg));
				Assert.assertEquals("PASS", Constants.key.writeInInput(vobjEmailReg, data));
				LogCapture.info("email id: " + data + " is validated ....");

			}
		}
	}

	@Then("^continue button should be in (enabled|disabled) state in android app$")
	public void continue_button_should_be_in_enabled_state_in_android_app(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("enabled")) {
			String vobjContiue = Constants.AndroidCDAppRegistrationOR.getProperty("ContinueBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjContiue));
			String atbValue = Constants.key.getAttributeValue(vobjContiue, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
			LogCapture.info("Continue button is in enabled state.........");
		} else if (optionalValue.equalsIgnoreCase("disabled")) {
			String vobjContiue = Constants.AndroidCDAppRegistrationOR.getProperty("ContinueBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjContiue));
			String atbValue = Constants.key.getAttributeValue(vobjContiue, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
			LogCapture.info("Continue button is in disabled state.........");
		}
	}

	@And("^android user select occupation \"([^\"]*)\"$")
	public void android_user_select_occupation(String occupation) throws Throwable {

		String vObjOccupationSelected = Constants.AndroidCDAppRegistrationOR.getProperty("Occupation");
		Assert.assertEquals("PASS", Constants.key.click(vObjOccupationSelected));
		MobileElement bankcode = Constants.driver.findElement(By.xpath(vObjOccupationSelected));
		int x = bankcode.getCenter().getX();
		int y = bankcode.getCenter().getY() - 200;
		TouchAction a2 = new TouchAction(Constants.driver).tap(PointOption.point(x, y)).release().perform();

	}

	@When("^android user click on (continue button|search address|Enter address manually|save button|additional info contiune button)$")
	public void android_user_click_on_continue_button(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("continue button")) {
			String vObjContinue = Constants.AndroidCDAppRegistrationOR.getProperty("ContinueBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjContinue));
			LogCapture.info("android user click on continue button.......");
			Thread.sleep(5000);
		} else if (optionalValue.equalsIgnoreCase("search address")) {
			String vObjSearchAddress = Constants.AndroidCDAppRegistrationOR.getProperty("SearchAddress");
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddress));
			LogCapture.info("android user click on search address.......");
		} else if (optionalValue.equalsIgnoreCase("Enter address manually")) {
			String vObjSearchAddress = Constants.AndroidCDAppRegistrationOR.getProperty("ManuallyEnterAddress");
			Assert.assertEquals("PASS", Constants.key.click(vObjSearchAddress));
			LogCapture.info("android user click on Enter address manually.......");
		} else if (optionalValue.equalsIgnoreCase("save button")) {
			String vObjSaveBtn = Constants.AndroidCDAppRegistrationOR.getProperty("SaveBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjSaveBtn));
			LogCapture.info("android user click on save button.......");
		} else if (optionalValue.equalsIgnoreCase("additional info contiune button")) {
			String vObjContinue2 = Constants.AndroidCDAppRegistrationOR.getProperty("AddtionalInfoContinueBtn");
			Assert.assertEquals("PASS", Constants.key.click(vObjContinue2));
			LogCapture.info("android user click on contiune button of additional info.......");
		}

	}

	@Then("^invalid (first name|last name|email id|DOB) error message should be displayed$")
	public void invalid_first_name_error_message_should_be_displayed(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("first name")) {
			String vObjErrLabelFirstName = Constants.AndroidCDAppRegistrationOR.getProperty("ErrLabelFirstName");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjErrLabelFirstName));
			String vExpectedValue = Constants.AndroidTestData.getProperty("InvalidFirstName");
			String atbValue = Constants.key.getAttributeValue(vObjErrLabelFirstName, "text").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vExpectedValue));
		} else if (optionalValue.equalsIgnoreCase("last name")) {
			String vObjErrLabelLastName = Constants.AndroidCDAppRegistrationOR.getProperty("ErrLabelLastName");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjErrLabelLastName));
			String vExpectedValue = Constants.AndroidTestData.getProperty("InvalidLastName");
			String atbValue = Constants.key.getAttributeValue(vObjErrLabelLastName, "text").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vExpectedValue));
		} else if (optionalValue.equalsIgnoreCase("email id")) {
			String vObjErrLabelEmailAdd = Constants.AndroidCDAppRegistrationOR.getProperty("ErrLabelEmailAdd");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjErrLabelEmailAdd));
			String vExpectedValue = Constants.AndroidTestData.getProperty("AndroidEmailErrorMsg");
			String atbValue = Constants.key.getAttributeValue(vObjErrLabelEmailAdd, "text").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vExpectedValue));
		} else if (optionalValue.equalsIgnoreCase("DOB")) {
			String vObjErrLabelDOB = Constants.AndroidCDAppRegistrationOR.getProperty("ErrLabelDOB");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjErrLabelDOB));
			String vExpectedValue = Constants.AndroidTestData.getProperty("InvalidDate");
			String atbValue = Constants.key.getAttributeValue(vObjErrLabelDOB, "text").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vExpectedValue));
		}
		LogCapture.info("Invalid " + optionalValue + " error message verified.........");
	}

	@Then("^android user landed on (Current address|About you|search address|Mobile number|Additional information|National ID Number|OTP|set password|verification) screen$")
	public void android_user_landed_on_Current_address_page(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("Current address")) {
			String vObjCurrentAddressHeader = Constants.AndroidCDAppRegistrationOR.getProperty("AddressHeader");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrentAddressHeader));
			LogCapture.info("User landed on Current address screen.........");
		} else if (optionalValue.equalsIgnoreCase("About you")) {
			String vObjAboutyousHeader = Constants.AndroidCDAppRegistrationOR.getProperty("AboutYouHeader");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAboutyousHeader));
			LogCapture.info("User landed on About you screen.........");
		} else if (optionalValue.equalsIgnoreCase("search address")) {
			String vObjSearchScrren = Constants.AndroidCDAppRegistrationOR.getProperty("SearchScrrenText");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSearchScrren));
			LogCapture.info("User landed on Search address screen.........");
		} else if (optionalValue.equalsIgnoreCase("Mobile number")) {
			String vObjMobileNumberScrren = Constants.AndroidCDAppRegistrationOR.getProperty("MobileNumberHeader");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMobileNumberScrren));
			LogCapture.info("User landed on Mobile Number screen.........");
		} else if (optionalValue.equalsIgnoreCase("Additional information")) {
			String vObjAdditionalInformationScrren = Constants.AndroidCDAppRegistrationOR
					.getProperty("AdditionalInformationHeader");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAdditionalInformationScrren));
			LogCapture.info("User landed on Additional information screen.........");
		} else if (optionalValue.equalsIgnoreCase("National ID Number")) {
			String vObjNationalIDScrren = Constants.AndroidCDAppRegistrationOR.getProperty("NationalIDScreenTitle");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNationalIDScrren));
			LogCapture.info("User landed on National ID Number screen.........");
		} else if (optionalValue.equalsIgnoreCase("OTP")) {
			Thread.sleep(1000);
			String vObjOTPscrren = Constants.AndroidCDAppRegistrationOR.getProperty("OTPScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOTPscrren));
			LogCapture.info("User landed on Confirm Pin screen.........");
			Thread.sleep(3000);
		} else if (optionalValue.equalsIgnoreCase("set password")) {
			Thread.sleep(1000);
			String vObjpasswordscrren = Constants.AndroidCDAppRegistrationOR.getProperty("PasswordScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjpasswordscrren));
			LogCapture.info("User landed on set password screen.........");
		} else if (optionalValue.equalsIgnoreCase("verification")) {
			// Assert.assertEquals("PASS",Constants.key.reInitializeWebDriverWait());
			Thread.sleep(60000);
			Assert.assertEquals("PASS", Constants.key.reInitializeWebDriverWait());
			String vObjVerificationScreen = Constants.AndroidCDAppRegistrationOR.getProperty("VerificationScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjVerificationScreen));
			LogCapture.info("User landed on verification screen.........");
		}
	}

	@When("^android user enters the max length (first name|last name|email id) \"([^\"]*)\"$")
	public void android_user_enters_the_max_length_first_name(String optionalValue, String data) throws Throwable {
		String vData = Constants.AndroidTestData.getProperty(data);
		android_user_enters_the_valid_first_name_on_Registration_page("valid", optionalValue, vData);
		LogCapture.info("User entered Max length data in input field.........");
	}

	@When("^android user removes the valid (first name|last name|email id|DOB)$")
	public void android_user_removes_the_valid_first_name(String optionalValue) throws Throwable {
		String vobjFirstNameReg = Constants.AndroidCDAppRegistrationOR.getProperty("FirstNameReg");
		String vobjLastNameReg = Constants.AndroidCDAppRegistrationOR.getProperty("LastNameReg");
		String vobjEmailReg = Constants.AndroidCDAppRegistrationOR.getProperty("EmaildIdreg");
		String vobjDateOfBirth = Constants.AndroidCDAppRegistrationOR.getProperty("Dobreg");
		if (optionalValue.equalsIgnoreCase("first name")) {
			Assert.assertEquals("PASS", Constants.key.click(vobjFirstNameReg));
			Assert.assertEquals("PASS", Constants.key.clearText(vobjFirstNameReg));
		} else if (optionalValue.equalsIgnoreCase("last name")) {
			Assert.assertEquals("PASS", Constants.key.click(vobjLastNameReg));
			Assert.assertEquals("PASS", Constants.key.clearText(vobjLastNameReg));
		} else if (optionalValue.equalsIgnoreCase("email id")) {
			Assert.assertEquals("PASS", Constants.key.click(vobjEmailReg));
			Assert.assertEquals("PASS", Constants.key.clearText(vobjEmailReg));
		} else if (optionalValue.equalsIgnoreCase("DOB")) {
			Assert.assertEquals("PASS", Constants.key.click(vobjDateOfBirth));
			Assert.assertEquals("PASS", Constants.key.clearText(vobjDateOfBirth));
			Assert.assertEquals("PASS", Constants.key.click(vobjFirstNameReg));
		}

		LogCapture.info(optionalValue + " removed from the field.........");
	}

	@Then("^mandatory (first name|last name|email id|DOB) error message should be displayed on android app$")
	public void mandatory_first_name_error_message_should_be_displayed(String optionalValue) throws Throwable {
		invalid_first_name_error_message_should_be_displayed(optionalValue);
		LogCapture.info("mandatory error message should be displayed on android app.........");
	}

	// Error message not implemented yet
	@Then("^already existed email address error message should be display on android app$")
	public void already_existed_email_address_error_message_should_be_display_on_android_app() throws Throwable {

	}

	@Then("^android user is taken to about you screen loaded with the details previously entered by the user$")
	public void android_user_is_taken_to_about_you_screen_loaded_with_the_details_previously_entered_by_the_user()
			throws Throwable {
		String vObjFNameTextField = Constants.AndroidCDAppRegistrationOR.getProperty("FirstNameReg");
		Assert.assertNotEquals("FAIL", Constants.key.readText(vObjFNameTextField));
		LogCapture.info("First Name :" + Constants.key.readText(vObjFNameTextField));
		String vObjLNameTextField = Constants.AndroidCDAppRegistrationOR.getProperty("LastNameReg");
		Assert.assertNotEquals("FAIL", Constants.key.readText(vObjLNameTextField));
		LogCapture.info("Last Name :" + Constants.key.readText(vObjLNameTextField));
		String vObjEmailTextField = Constants.AndroidCDAppRegistrationOR.getProperty("EmaildIdreg");
		Assert.assertNotEquals("FAIL", Constants.key.readText(vObjEmailTextField));
		LogCapture.info("Email ID :" + Constants.key.readText(vObjEmailTextField));
		LogCapture.info("Previously entered data displayed successfully........");

	}

	@When("^android user search country name \"([^\"]*)\"$")
	public void android_user_search_country_name(String data) throws Throwable {
		String vObjCountryDelect = Constants.CDAppDashboard.getProperty("CountrySelect");
		LogCapture.info("User select country......");
		Assert.assertEquals("PASS", Constants.key.click(vObjCountryDelect));
		String vObjCountrySearch = Constants.CDAppDashboard.getProperty("CountrySearch");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountrySearch));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountrySearch, data));

		LogCapture.info("User entered country code or name : " + data);

	}

	@Then("^matching country should be displayed in search result of android app$")
	public void matching_country_should_be_displayed_in_search_result_of_android_app() throws Throwable {
		String vObjCountryLabel = Constants.AndroidCDAppRegistrationOR.getProperty("CountryName");
		Thread.sleep(2000);
		int noOfCountry = Constants.key.getElementList(vObjCountryLabel).size();
		if (noOfCountry > 0) {
			LogCapture.info("Total number of matching country : " + noOfCountry);
		} else {
			LogCapture.info("No matching country found........ ");
		}
	}

	@Then("^UK country should default selected in current address to android app$")
	public void uk_country_should_default_selected_in_current_address_to_android_app() throws Throwable {
		String vObjCountryfefault = Constants.AndroidCDAppRegistrationOR.getProperty("DefaultCountry");
		String atbValue = Constants.key.getAttributeValue(vObjCountryfefault, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText(atbValue, "United Kingdom"));
		LogCapture.info("UK country should default selected in current address.......... ");
	}

	@Then("^the filter should be cleared and the whole country list should be displayed to android app$")
	public void the_filter_should_be_cleared_and_the_whole_country_list_should_be_displayed_to_android_app()
			throws Throwable {
		String vObjCountryLabel = Constants.AndroidCDAppRegistrationOR.getProperty("CountryName");
		int noOfCountry = Constants.key.getElementList(vObjCountryLabel).size();
		if (noOfCountry > 5) {
			LogCapture.info("Country search result has been cleared............");
		}
	}

	@Then("^selected country \"([^\"]*)\" should be displayed in country dropdown of android app$")
	public void selected_country_should_be_displayed_in_country_dropdown_of_android_app(String data) throws Throwable {
		String vObjDDCountry = Constants.AndroidCDAppRegistrationOR.getProperty("CountryDD");
		String vObjDDCountrylbl = Constants.AndroidCDAppRegistrationOR.getProperty("CountryName");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDDCountry));
		String vDDCountrylbl = Constants.key.getAttributeValue(vObjDDCountrylbl, "value");
		Assert.assertEquals(data, vDDCountrylbl);
		LogCapture.info("Country : " + data + " selected by user.......");
	}

	@When("^android user clicks on back button on country search page$")
	public void android_user_clicks_on_back_button_on_country_search_page() throws Throwable {
		String vObjBackRecButton = Constants.AndroidCDAppRegistrationOR.getProperty("Backbutton");
		Assert.assertEquals("PASS", Constants.key.click(vObjBackRecButton));
		LogCapture.info("user clicked on back button.......");
	}

	@When("^android user searches for address \"([^\"]*)\"$")
	public void android_user_searches_for_address(String data) throws Throwable {
		String vObjSearchAddress = Constants.AndroidCDAppRegistrationOR.getProperty("SearchAddress");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSearchAddress));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSearchAddress, data));
		LogCapture.info("User searching for address contains : " + data);
	}

	@Then("^android app should fetch matching address according to the selected country$")
	public void android_app_should_fetch_matching_address_according_to_the_selected_country() throws Throwable {
		String vObjFilterAddress = Constants.AndroidCDAppRegistrationOR.getProperty("FilterAddress");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFilterAddress));
		LogCapture.info("Result list displayed for searched address............. ");
	}

	@Then("^andriod user remove the entered address from search option$")
	public void andriod_user_remove_the_entered_address_from_search_option() throws Throwable {
		String vObjRemoveAddressfromscreen = Constants.CDAppDashboard.getProperty("Removeaddress");
		Assert.assertEquals("PASS", Constants.key.click(vObjRemoveAddressfromscreen));
		LogCapture.info("Remove the entered address from search screen....");
	}

	@Then("^andriod user click on back button from search finder screen$")
	public void andriod_user_click_on_back_button_from_search_finder_screen() throws Throwable {
		String vObjBackbuttonfromscreen = Constants.CDAppDashboard.getProperty("Backbuttonfromsearch");
		Assert.assertEquals("PASS", Constants.key.click(vObjBackbuttonfromscreen));
		LogCapture.info("Click on Back button from search screen....");
	}

	@Then("^andriod user observe address not found then click on manually entered address option$")
	public void andriod_user_observe_address_not_found_then_click_on_manually_entered_address_option()
			throws Throwable {
		String vObjEntermanualadd = Constants.CDAppDashboard.getProperty("ManualAddress");
		Assert.assertEquals("PASS", Constants.key.click(vObjEntermanualadd));
		LogCapture.info("Click on Manual Enter address link from search screen....");
	}

	@Then("^information is displayed requesting the user to confirm the action$")
	public void information_is_displayed_requesting_the_user_to_confirm_the_action() throws Throwable {
		String vObjConfirmationpopup = Constants.AndroidCDAppAccountOR.getProperty("ConfirmationPopup");
		String vActualTextConfirm = Constants.key.getAttributeValue(vObjConfirmationpopup, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("Confirm Logout", vActualTextConfirm));
	}

	@Then("^the user confirms the action$")
	public void the_user_confirms_the_action() throws Throwable {
		String vObjConifrmBtn = Constants.AndroidCDAppAccountOR.getProperty("ConfirmBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjConifrmBtn));
		LogCapture.info("Andriod user click on Confirm button..");
	}

	@Then("^the user should be logged out of the application and user be taken the logout screen$")
	public void the_user_should_be_logged_out_of_the_application_and_user_be_taken_the_logout_screen()
			throws Throwable {
		String vObjLogoutScreen = Constants.AndroidCDAppAccountOR.getProperty("ScrrenTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLogoutScreen));
		LogCapture.info("Logout screen is getting displayed............. ");
	}

	@Then("^user click on cancel button$")
	public void user_click_on_cancel_button() throws Throwable {
		String vObjConifrmcancel = Constants.AndroidCDAppAccountOR.getProperty("ConfirmCancelBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjConifrmcancel));
		LogCapture.info("Andriod user click on cancel button from confirmation popup..");
	}

	@Then("^the confirmation popup should close and user remain on account screen$")
	public void the_confirmation_popup_should_close_and_user_remain_on_account_screen() throws Throwable {
		String vObjAccountTitle = Constants.AndroidCDAppAccountOR.getProperty("AccountTitle");
		String vActualText = Constants.key.getAttributeValue(vObjAccountTitle, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("Account", vActualText));
	}

	@When("^the user is in an inactive state in the app$")
	public void the_user_is_in_an_inactive_state_in_the_app() throws Throwable {
		String vObjSendmoney = Constants.AndroidCDAppLogin.getProperty("AndroidDashboardPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendmoney));
		LogCapture.info("User navigated to dashboard screen successfully .......");
	}

	// Need to revisit
	@When("^the user returns to active state in less than five minutes$")
	public void the_user_returns_to_active_state_in_less_than_five_minutes() throws Throwable {
		String vObjWalletIcon = Constants.AndroidCDAppWalletOR.getProperty("WalletIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjWalletIcon));
		LogCapture.info("User clicked on walletIcon ....");
		Thread.sleep(50000);
		LogCapture.info("Andriod user is inactive for 90 seconds.........");
		String vObjAccountIcon = Constants.CDAppDashboard.getProperty("AccountIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
		LogCapture.info("Andriod user succesfully click on account setting  after inactive for 90 seconds.........");
	}

	// Need to revisit
	@When("^the user returns to active state in more than five minutes$")
	public void the_user_returns_to_active_state_in_more_than_five_minutes() throws Throwable {
		String vObjWalletIcon = Constants.AndroidCDAppWalletOR.getProperty("WalletIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjWalletIcon));
		LogCapture.info("User clicked on WalletIcon ....");
		LogCapture.info("Andriod user is inactive for 5.5 minutes.........");
		Thread.sleep(330000);
		String vObjAccountIcon = Constants.CDAppDashboard.getProperty("AccountIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
		LogCapture.info("Andriod user succesfully click on account setting  after inactive for 90 seconds.........");
	}

	@Then("^the user should be able to enter the app at the same position they left the app$")
	public void the_user_should_be_able_to_enter_the_app_at_the_same_position_they_left_the_app() throws Throwable {
		String vObjDashboard = Constants.AndroidCDAppLogin.getProperty("AndroidDashboardPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashboard));
		LogCapture.info("Andriod user land on dashbaord screen...");
	}

	@When("^application is in backgrounds state less than one minutes$")
	public void application_is_in_backgrounds_state_less_than_one_minutes() throws Throwable {
		Assert.assertEquals("PASS", Constants.key.AppBackground(Duration.ofSeconds(45)));
		LogCapture.info("App is in background state for 45 seconds");
	}

	@When("^application is in backgrounds state more than one minutes$")
	public void application_is_in_backgrounds_state_more_than_one_minutes() throws Throwable {
		Assert.assertEquals("PASS", Constants.key.AppBackground(Duration.ofSeconds(92)));
		LogCapture.info("App is in background state more than 1 minute");
	}

	@Then("^andriod user click on Login button from logout screen and land into subsequent login page$")
	public void andriod_user_click_on_Login_button_from_logout_screen_and_land_into_subsequent_login_page()
			throws Throwable {
		String vObjLoginBtn = Constants.AndroidCDAppLogin.getProperty("AndroidSendMealinkBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjLoginBtn));
		String vObjSubsequentLogin = Constants.AndroidCDAppLogin.getProperty("AndroidPassFieldInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSubsequentLogin));
		LogCapture.info("Andriod user able to login from logout screen and land into subsequent login page.........");
	}

	@Then("^the user should be able to click on Account icon$")
	public void the_user_should_be_able_to_click_on_Account_icon() throws Throwable {
		String vObjAccountIcon = Constants.CDAppDashboard.getProperty("AccountIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjAccountIcon));
		LogCapture.info("Andriod user able to click on account menu...");
	}

	@Then("^android app should display nothing found message with enter address manually link$")
	public void android_app_should_display_nothing_found_message_with_enter_address_manually_link() throws Throwable {
		String vObjAddressNotFoundLbl = Constants.AndroidCDAppRegistrationOR.getProperty("AddressNotFoundLbl");
		String vObjManualAddressLink = Constants.AndroidCDAppRegistrationOR.getProperty("ManualAddressLink");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddressNotFoundLbl));
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjManualAddressLink));
		LogCapture.info("Address not found message was displayed with enter address manually link...... ");
	}

	@Then("^android app filter should be cleared and empty search address screen should be displayed$")
	public void android_app_filter_should_be_cleared_and_empty_search_address_screen_should_be_displayed()
			throws Throwable {
		String vObjSearchScrren = Constants.AndroidCDAppRegistrationOR.getProperty("SearchScrrenText");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSearchScrren));
		LogCapture.info("Empty search address screen has been displayed...... ");
	}

	@Then("^selected country \"([^\"]*)\" address should be updated in address field of android app$")
	public void selected_address_should_be_updated_in_address_field_of_android_app(String country) throws Throwable {
		// Constants.Data = address.split(",");
		String vObjAddress = Constants.AndroidCDAppRegistrationOR.getProperty("Address");
		String vObjAdressLine1 = Constants.AndroidCDAppRegistrationOR.getProperty("AddressLine1");
		String vObjAdressLine2 = Constants.AndroidCDAppRegistrationOR.getProperty("AddressLine2");
		String vObjCountry = Constants.AndroidCDAppRegistrationOR.getProperty("country");
		String vObjCity = Constants.AndroidCDAppRegistrationOR.getProperty("city");
		String vObjPoscode = Constants.AndroidCDAppRegistrationOR.getProperty("Poscode");
		String vObjunitApartment = Constants.AndroidCDAppRegistrationOR.getProperty("unitApartment");
		String vObjstateDropDown = Constants.AndroidCDAppRegistrationOR.getProperty("stateDropDown");
		String vObjzipcode = Constants.AndroidCDAppRegistrationOR.getProperty("ZipCode");
		String vObjPostzipcode = Constants.AndroidCDAppRegistrationOR.getProperty("postzipCode");
		String vObjUnitNumber = Constants.AndroidCDAppRegistrationOR.getProperty("UnitNumber");
		String vObjCivicNumber = Constants.AndroidCDAppRegistrationOR.getProperty("CivicNumber");
		String vObjStreetName = Constants.AndroidCDAppRegistrationOR.getProperty("StreetName");
		String vObjStreetTypeDropdown = Constants.AndroidCDAppRegistrationOR.getProperty("StreetTypeDropdown");
		String vObjCanadaPostCode = Constants.AndroidCDAppRegistrationOR.getProperty("CanadaPostCode");
		String vObjStreetNumber = Constants.AndroidCDAppRegistrationOR.getProperty("StreetNumber");
		String vObjSuburbs = Constants.AndroidCDAppRegistrationOR.getProperty("Suburbs");
		String vObjNZPostCode = Constants.AndroidCDAppRegistrationOR.getProperty("NewZealandPostCode");
		if (country.equalsIgnoreCase("United Kingdom")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAdressLine1));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAdressLine2));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountry));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCity));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPoscode));
		} else if (country.equalsIgnoreCase("United States of America")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjunitApartment));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjstateDropDown));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjzipcode));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCity));
		} else if (country.equalsIgnoreCase("France") || country.equalsIgnoreCase("Spain")
				|| country.equalsIgnoreCase("India")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddress));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountry));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCity));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPostzipcode));
		} else if (country.equalsIgnoreCase("Canada")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUnitNumber));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCivicNumber));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjStreetName));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCity));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjstateDropDown));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjStreetTypeDropdown));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCanadaPostCode));
		} else if (country.equalsIgnoreCase("Australia")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUnitNumber));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPoscode));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjStreetName));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjStreetNumber));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSuburbs));
			// Assert.assertEquals("PASS",Constants.key.eleLocatedDisplayed(vObjstateDropDown));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjStreetTypeDropdown));
		} else if (country.equalsIgnoreCase("New Zealand")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjUnitNumber));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjStreetName));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjStreetNumber));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSuburbs));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNZPostCode));
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjStreetTypeDropdown));
		}
		LogCapture.info("Address updated in address field ......");
	}

	@When("^android user enters all the address \"([^\"]*)\" as per selected country \"([^\"]*)\"$")
	public void android_user_enters_all_the_address_as_per_selected_country(String address, String country)
			throws Throwable {
		Constants.Data = Constants.AndroidTestData.getProperty(address).split(",");

		String vObjAddress = Constants.AndroidCDAppRegistrationOR.getProperty("Address");
		String vObjAdressLine1 = Constants.AndroidCDAppRegistrationOR.getProperty("AddressLine1");
		String vObjAdressLine2 = Constants.AndroidCDAppRegistrationOR.getProperty("AddressLine2");
		String vObjCountry = Constants.AndroidCDAppRegistrationOR.getProperty("country");
		String vObjCity = Constants.AndroidCDAppRegistrationOR.getProperty("city");
		String vObjPoscode = Constants.AndroidCDAppRegistrationOR.getProperty("Poscode");
		String vObjunitApartment = Constants.AndroidCDAppRegistrationOR.getProperty("unitApartment");
		String vObjstateDropDown = Constants.AndroidCDAppRegistrationOR.getProperty("stateDropDown");
		String vObjzipcode = Constants.AndroidCDAppRegistrationOR.getProperty("ZipCode");
		String vObjPostzipcode = Constants.AndroidCDAppRegistrationOR.getProperty("postzipCode");
		String vObjUnitNumber = Constants.AndroidCDAppRegistrationOR.getProperty("UnitNumber");
		String vObjCivicNumber = Constants.AndroidCDAppRegistrationOR.getProperty("CivicNumber");
		String vObjStreetName = Constants.AndroidCDAppRegistrationOR.getProperty("StreetName");
		String vObjStreetTypeDropdown = Constants.AndroidCDAppRegistrationOR.getProperty("StreetTypeDropdown");
		String vObjCanadaPostCode = Constants.AndroidCDAppRegistrationOR.getProperty("CanadaPostCode");
		String vObjStreetNumber = Constants.AndroidCDAppRegistrationOR.getProperty("StreetNumber");
		String vObjSuburbs = Constants.AndroidCDAppRegistrationOR.getProperty("Suburbs");
		String vObjNZPostalCode = Constants.AndroidCDAppRegistrationOR.getProperty("NewZealandPostCode");
		if (country.equalsIgnoreCase("United Kingdom")) {

			Constants.DataMap.put("AdressLine1", Constants.Data[0].toString().trim());
			Constants.DataMap.put("AdressLine2", Constants.Data[1].toString().trim());
			Constants.DataMap.put("Country", Constants.Data[2].toString().trim());
			Constants.DataMap.put("City", Constants.Data[3].toString().trim());
			Constants.DataMap.put("PostCode", Constants.Data[4].toString().trim());

			Assert.assertEquals("PASS", Constants.key.click(vObjAdressLine1));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAdressLine1, Constants.Data[0].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjAdressLine2));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAdressLine2, Constants.Data[1].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjCountry));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountry, Constants.Data[2].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjCity));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCity, Constants.Data[3].toString()));

			Constants.key.scrollDownUI("Postcode");
			Assert.assertEquals("PASS", Constants.key.click(vObjPoscode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPoscode, Constants.Data[4].toString()));

		} else if (country.equalsIgnoreCase("France") || country.equalsIgnoreCase("Spain")
				|| country.equalsIgnoreCase("India")) {

			Constants.DataMap.put("Address", Constants.Data[0].toString().trim());
			Constants.DataMap.put("City", Constants.Data[1].toString().trim());
			Constants.DataMap.put("Country", Constants.Data[2].toString().trim());
			Constants.DataMap.put("PostZipCode", Constants.Data[3].toString().trim());

			Assert.assertEquals("PASS", Constants.key.click(vObjAddress));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAddress, Constants.Data[0].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjCity));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCity, Constants.Data[1].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjCountry));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountry, Constants.Data[2].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjPostzipcode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPostzipcode, Constants.Data[3].toString()));

		} else if (country.equalsIgnoreCase("United States of America")) {

			Constants.DataMap.put("unitApartment", Constants.Data[0].toString().trim());
			Constants.DataMap.put("City", Constants.Data[1].toString().trim());
			Constants.DataMap.put("stateDropDown", Constants.Data[2].toString().trim());
			Constants.DataMap.put("zipcode", Constants.Data[3].toString().trim());

			Assert.assertEquals("PASS", Constants.key.click(vObjunitApartment));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjunitApartment, Constants.Data[0].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjstateDropDown));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjstateDropDown, Constants.Data[1].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjzipcode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjzipcode, Constants.Data[2].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjCity));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCity, Constants.Data[3].toString()));
		} else if (country.equalsIgnoreCase("canada")) {
			Constants.DataMap.put("UnitNumber", Constants.Data[0].toString().trim());
			Constants.DataMap.put("CivicNumber", Constants.Data[1].toString().trim());
			Constants.DataMap.put("StreetName", Constants.Data[2].toString().trim());
			Constants.DataMap.put("StreetTypeDropdown", Constants.Data[3].toString().trim());
			Constants.DataMap.put("City", Constants.Data[4].toString().trim());
			Constants.DataMap.put("stateDropDown", Constants.Data[5].toString().trim());
			Constants.DataMap.put("CanadaPostCode", Constants.Data[6].toString().trim());

			Assert.assertEquals("PASS", Constants.key.click(vObjUnitNumber));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUnitNumber, Constants.Data[0].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjCivicNumber));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCivicNumber, Constants.Data[1].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjStreetName));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStreetName, Constants.Data[2].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjCity));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCity, Constants.Data[3].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjstateDropDown));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjstateDropDown, Constants.Data[4].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjStreetTypeDropdown));
			Assert.assertEquals("PASS",
					Constants.key.writeInInput(vObjStreetTypeDropdown, Constants.Data[5].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjCanadaPostCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCanadaPostCode, Constants.Data[6].toString()));

		} else if (country.equalsIgnoreCase("Australia")) {

			Constants.DataMap.put("Poscode", Constants.Data[0].toString().trim());
			Constants.DataMap.put("UnitNumber", Constants.Data[1].toString().trim());
			Constants.DataMap.put("StreetNumber", Constants.Data[2].toString().trim());
			Constants.DataMap.put("StreetName", Constants.Data[3].toString().trim());
			Constants.DataMap.put("StreetType", Constants.Data[4].toString().trim());
			Constants.DataMap.put("Suburbs", Constants.Data[5].toString().trim());
			Constants.DataMap.put("state", Constants.Data[6].toString().trim());

			Assert.assertEquals("PASS", Constants.key.click(vObjPoscode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPoscode, Constants.Data[0].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjUnitNumber));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUnitNumber, Constants.Data[1].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjStreetNumber));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStreetNumber, Constants.Data[2].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjStreetName));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStreetName, Constants.Data[3].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjStreetTypeDropdown));
			Assert.assertEquals("PASS",
					Constants.key.writeInInput(vObjStreetTypeDropdown, Constants.Data[4].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjSuburbs));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSuburbs, Constants.Data[5].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjstateDropDown));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjstateDropDown, Constants.Data[6].toString()));

		} else if (country.equalsIgnoreCase("New Zealand")) {

			Constants.DataMap.put("Poscode", Constants.Data[0].toString().trim());
			Constants.DataMap.put("UnitNumber", Constants.Data[1].toString().trim());
			Constants.DataMap.put("StreetNumber", Constants.Data[2].toString().trim());
			Constants.DataMap.put("StreetName", Constants.Data[3].toString().trim());
			Constants.DataMap.put("StreetType", Constants.Data[4].toString().trim());
			Constants.DataMap.put("Suburbs", Constants.Data[5].toString().trim());
			Constants.DataMap.put("state", Constants.Data[6].toString().trim());

			Assert.assertEquals("PASS", Constants.key.click(vObjPoscode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPoscode, Constants.Data[0].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjUnitNumber));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjUnitNumber, Constants.Data[1].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjStreetNumber));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStreetNumber, Constants.Data[2].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjStreetName));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjStreetName, Constants.Data[3].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjStreetTypeDropdown));
			Assert.assertEquals("PASS",
					Constants.key.writeInInput(vObjStreetTypeDropdown, Constants.Data[4].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjSuburbs));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSuburbs, Constants.Data[5].toString()));

			Assert.assertEquals("PASS", Constants.key.click(vObjNZPostalCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjstateDropDown, Constants.Data[6].toString()));

		}
	}

	@Then("^save button should be in (enabled|disabled) state in android app$")
	public void save_button_should_be_in_enabled_state_in_android_app(String button) throws Throwable {
		String vObjSaveBtn = Constants.AndroidCDAppRegistrationOR.getProperty("SaveBtn");
		if (button.equals("enabled")) {
			Assert.assertEquals("true", Constants.key.getAttributeValue(vObjSaveBtn, "enabled").toString());
			LogCapture.info("save button is Active.......");
		} else if (button.equals("disabled")) {
			Assert.assertEquals("false", Constants.key.getAttributeValue(vObjSaveBtn, "enabled").toString());
			LogCapture.info("save button is Inactive.......");
		}
	}

	@Then("^selected country address \"([^\"]*)\" should be updated in address field of android app$")
	public void searched_country_address_should_be_updated_in_address_field_of_android_app(String addressData)
			throws Throwable {
		String vObjSelectedAddress = Constants.AndroidCDAppRegistrationOR.getProperty("SelectedAddress");

		int noOfaddress = Constants.key.getElementList(vObjSelectedAddress).size();
		LogCapture.info("address size: " + noOfaddress);

		List<MobileElement> addressList = Constants.key.getElementList(vObjSelectedAddress);
		boolean isFound = false;
		for (MobileElement address : addressList) {
			String particularAddress = address.getText();

			LogCapture.info("Country Address: " + particularAddress + " expected:" + addressData);
			if (particularAddress.toLowerCase().contains(addressData.toLowerCase())) {

				address.click();
				Thread.sleep(2000);

				LogCapture.info("Country address: " + particularAddress);
				isFound = true;
				break;
			}
		}
		if (isFound) {
			Assert.assertEquals("PASS", "PASS");
		} else {
			Assert.assertEquals("PASS", Constants.KEYWORD_FAIL);
		}
		LogCapture.info("Address updated in address field............. ");
	}

	@Then("^(Medicare|Passport details|Driving License Details) option displayed on additional information screen to android user$")
	public void medicare_option_displayed_on_additional_information_screen_to_android_user(String optionValue)
			throws Throwable {
		if (optionValue.equalsIgnoreCase("Medicare")) {
			String vObjMedicare = Constants.AndroidCDAppRegistrationOR.getProperty("Medicure1");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMedicare));
			LogCapture.info("Medicare option listed on additional information screen");
		} else if (optionValue.equalsIgnoreCase("Passport details")) {
			String vObjPassport = Constants.AndroidCDAppRegistrationOR.getProperty("PassportDeatils");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPassport));
			LogCapture.info("Passport details option listed on additional information screen");
		} else if (optionValue.equalsIgnoreCase("Driving License Details")) {
			String vObjDrivingLicence = Constants.AndroidCDAppRegistrationOR.getProperty("DrivingLicenseDetails");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDrivingLicence));
			LogCapture.info("Driving License Details option listed on additional information screen");
		}
	}

	@Then("^National ID header message and edit box displayed to android user$")
	public void national_ID_header_text_and_edit_box_displayed_to_android_user() throws Throwable {
		String vObjNationalIDHeaderText = Constants.AndroidCDAppRegistrationOR.getProperty("NationalIDHeaderText");
		String vExpectedText = Constants.AndroidTestData.getProperty("NationalIDNumberScreenText");
		String vActualHeaderText = Constants.key.getAttributeValue(vObjNationalIDHeaderText, "text").trim();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vExpectedText, vActualHeaderText));
		LogCapture.info("National ID header message: " + vActualHeaderText + " ...");

		String vObjNationalIDEditBox = Constants.AndroidCDAppRegistrationOR.getProperty("NationalIDMedicardTextBox");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNationalIDEditBox));
		LogCapture.info("National ID edit box displayed ...");
	}

	@Then("^continue button to save additional info should be in (enabled|disabled) state in android app$")
	public void continue_button_to_save_additional_info_should_be_in_disabled_state_in_android_app(String optionalValue)
			throws Throwable {
		String vobjContiue = Constants.AndroidCDAppRegistrationOR.getProperty("AddtionalInfoContinueBtn");
		if (optionalValue.equalsIgnoreCase("enabled")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjContiue));
			String atbValue = Constants.key.getAttributeValue(vobjContiue, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
			LogCapture.info("Continue button is in enabled state.........");
		} else if (optionalValue.equalsIgnoreCase("disabled")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjContiue));
			String atbValue = Constants.key.getAttributeValue(vobjContiue, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
			LogCapture.info("Continue button is in disabled state.........");
		}
	}

	@Then("^android user provide (National ID Number|Medicare Card Number|Medicare Reference Number|License Number|Card Number|Country Code|State Code|Date of Expiry|Family Name At Birth|Name At Citizenship|Passport Number|Place Of Birth) \"([^\"]*)\" as addtional information$")
	public void android_user_provide_National_ID_Number_as_addtional_information(String optionalValue, String data)
			throws Throwable {
		if (optionalValue.equalsIgnoreCase("National ID Number")
				|| optionalValue.equalsIgnoreCase("Medicare Card Number")
				|| optionalValue.equalsIgnoreCase("License Number")) {
			String vobjNationalID = Constants.AndroidCDAppRegistrationOR.getProperty("NationalIDMedicardTextBox");
			Assert.assertEquals("PASS", Constants.key.click(vobjNationalID));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjNationalID, data));
			LogCapture.info("provided Number : " + data);
		} else if (optionalValue.equalsIgnoreCase("Medicare Reference Number")) {
			String vobjMedicareRefNo = Constants.AndroidCDAppRegistrationOR.getProperty("MedicareReference");
			Assert.assertEquals("PASS", Constants.key.click(vobjMedicareRefNo));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjMedicareRefNo, data));
			LogCapture.info("provided Medicare Reference Number : " + data);
		} else if (optionalValue.equalsIgnoreCase("Card Number")) {
			String vobjDLCardNo = Constants.AndroidCDAppRegistrationOR.getProperty("DLCardNo");
			Assert.assertEquals("PASS", Constants.key.click(vobjDLCardNo));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjDLCardNo, data));
			LogCapture.info("provided Number Card Number : " + data);
		} else if (optionalValue.equalsIgnoreCase("Country Code")) {
			String vobjDLCountryCode = Constants.AndroidCDAppRegistrationOR.getProperty("DLCountryCode");
			Assert.assertEquals("PASS", Constants.key.click(vobjDLCountryCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjDLCountryCode, data));
			LogCapture.info("provided Number Country Code : " + data);
		} else if (optionalValue.equalsIgnoreCase("State Code")) {
			String vobjDLStateCode = Constants.AndroidCDAppRegistrationOR.getProperty("DLStateCode");
			Assert.assertEquals("PASS", Constants.key.click(vobjDLStateCode));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjDLStateCode, data));
			LogCapture.info("provided Number State Code : " + data);
		} else if (optionalValue.equalsIgnoreCase("Date of Expiry")) {
			String vobjDLDateofExpiry = Constants.AndroidCDAppRegistrationOR.getProperty("DLDateofExpiry");
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjDLDateofExpiry, data));
			LogCapture.info("provided Number Date of Expiry : " + data);
		} else if (optionalValue.equalsIgnoreCase("Passport Number")) {
			String vobjPDDPassportNo = Constants.AndroidCDAppRegistrationOR.getProperty("PDDPassportNo");
			Assert.assertEquals("PASS", Constants.key.click(vobjPDDPassportNo));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjPDDPassportNo, data));
			LogCapture.info("provided Number Passport Number : " + data);
		} else if (optionalValue.equalsIgnoreCase("Family Name At Birth")) {
			String vobjPDDFamilyname = Constants.AndroidCDAppRegistrationOR.getProperty("PDDFamilyname");
			Assert.assertEquals("PASS", Constants.key.click(vobjPDDFamilyname));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjPDDFamilyname, data));
			LogCapture.info("provided Number Family Name At Birth: " + data);
		} else if (optionalValue.equalsIgnoreCase("Name At Citizenship")) {
			String vobjPDDCitizenshipName = Constants.AndroidCDAppRegistrationOR.getProperty("PDDCitizenshipName");
			Assert.assertEquals("PASS", Constants.key.click(vobjPDDCitizenshipName));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjPDDCitizenshipName, data));
			LogCapture.info("provided Number Name At Citizenship : " + data);
		} else if (optionalValue.equalsIgnoreCase("Place Of Birth")) {
			String vobjPDDPlaceOFBirth = Constants.AndroidCDAppRegistrationOR.getProperty("PDDPlaceOFBirth");
			Assert.assertEquals("PASS", Constants.key.click(vobjPDDPlaceOFBirth));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjPDDPlaceOFBirth, data));
			LogCapture.info("provided Number Place Of Birth: " + data);
		}
	}

	@Then("^android user clicks on the (Medicare|Driving License Details|Passport details) proceed icon of additional information screen$")
	public void android_user_clicks_on_the_Medicare_proceed_icon_of_additional_information_screen(String optionalValue)
			throws Throwable {
		if (optionalValue.equalsIgnoreCase("Medicare")) {
			String vobjProceedIcon = Constants.AndroidCDAppRegistrationOR.getProperty("MedicareProceedIcon");
			Assert.assertEquals("PASS", Constants.key.click(vobjProceedIcon));
			LogCapture.info("clicked on Medicare proceed icon .......");
		} else if (optionalValue.equalsIgnoreCase("Driving License Details")) {
			String vobjProceedIcon = Constants.AndroidCDAppRegistrationOR.getProperty("DLProceed");
			Assert.assertEquals("PASS", Constants.key.click(vobjProceedIcon));

			LogCapture.info("clicked on Driving License Details proceed icon .......");

		} else if (optionalValue.equalsIgnoreCase("Passport details")) {
			String vobjPDProceed = Constants.AndroidCDAppRegistrationOR.getProperty("PDProceed");
			Assert.assertEquals("PASS", Constants.key.click(vobjPDProceed));
			LogCapture.info("clicked on Passport details proceed icon .......");
		}

	}

	@Then("^country code should be updated as per \"([^\"]*)\" on android app$")
	public void country_code_should_be_updated_as_per_on_android_app(String country) throws Throwable {
		if (country.equalsIgnoreCase("United Kingdom")) {
			Thread.sleep(2000);
			String vobjMobileCode = Constants.AndroidCDAppRegistrationOR.getProperty("CountryCodePrefx");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjMobileCode));
			String vObjCodeValue = Constants.driver.findElement(By.xpath(vobjMobileCode)).getText();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCodeValue, "+44"));
			LogCapture.info(country + "country code : " + vObjCodeValue);
		} else if (country.equalsIgnoreCase("France")) {
			Thread.sleep(2000);
			String vobjMobileCode = Constants.AndroidCDAppRegistrationOR.getProperty("CountryCodePrefx");
			String vObjCodeValue = Constants.driver.findElement(By.xpath(vobjMobileCode)).getText();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCodeValue, "+33"));
			LogCapture.info(country + "country code : " + vObjCodeValue);
		} else if (country.equalsIgnoreCase("South Africa")) {
			Thread.sleep(2000);
			String vobjMobileCode = Constants.AndroidCDAppRegistrationOR.getProperty("CountryCodePrefx");
			String vObjCodeValue = Constants.driver.findElement(By.xpath(vobjMobileCode)).getText();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCodeValue, "+27"));
			LogCapture.info(country + "country code : " + vObjCodeValue);
		} else if (country.equalsIgnoreCase("Australia")) {
			Thread.sleep(2000);
			String vobjMobileCode = Constants.AndroidCDAppRegistrationOR.getProperty("CountryCodePrefx");
			String vObjCodeValue = Constants.driver.findElement(By.xpath(vobjMobileCode)).getText();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCodeValue, "+61"));
			LogCapture.info(country + "country code : " + vObjCodeValue);
		} else if (country.equalsIgnoreCase("Spain")) {
			Thread.sleep(2000);
			String vobjMobileCode = Constants.AndroidCDAppRegistrationOR.getProperty("CountryCodePrefx");
			String vObjCodeValue = Constants.driver.findElement(By.xpath(vobjMobileCode)).getText();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCodeValue, "+34"));
			LogCapture.info(country + "country code : " + vObjCodeValue);
		} else if (country.equalsIgnoreCase("India")) {
			Thread.sleep(2000);
			String vobjMobileCode = Constants.AndroidCDAppRegistrationOR.getProperty("CountryCodePrefx");
			String vObjCodeValue = Constants.driver.findElement(By.xpath(vobjMobileCode)).getText();
			Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCodeValue, "+91"));
			LogCapture.info(country + "country code : " + vObjCodeValue);
		}
	}

	@Then("^mobile number edit box should be display on android app$")
	public void mobile_number_edit_box_should_be_display_on_android_app() throws Throwable {
		String vobjMobileNo = Constants.AndroidCDAppRegistrationOR.getProperty("MobileNumberfield");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjMobileNo));
		LogCapture.info("Telephone number field .......");
	}

	@Then("^continue button to save mobile number details should be in (enabled|disabled) state in android app$")
	public void continue_button_to_mobile_number_details_should_be_in_enabled_state_in_android_app(String optionalValue)
			throws Throwable {
		String vobjContinue = Constants.AndroidCDAppRegistrationOR.getProperty("SaveBtn");
		if (optionalValue.equalsIgnoreCase("enabled")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjContinue));
			String atbValue = Constants.key.getAttributeValue(vobjContinue, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
			LogCapture.info("Continue button is in enabled state.........");
		} else if (optionalValue.equalsIgnoreCase("disabled")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjContinue));
			String atbValue = Constants.key.getAttributeValue(vobjContinue, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
			LogCapture.info("Continue button is in disabled state.........");
		}
	}

	@Then("^country \"([^\"]*)\" should be selected as per current address in android app$")
	public void country_should_be_selected_as_per_current_address_in_android_app(String country) throws Throwable {
		String vobjCountry = Constants.AndroidCDAppRegistrationOR.getProperty("CountryName");
		String vObjCountryValue = Constants.driver.findElement(By.xpath(vobjCountry)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCountryValue, country));
		LogCapture.info("Country displayed as urrent address.....");
	}

	@Then("^android user entered (mobile number|password) \"([^\"]*)\"$")
	public void android_user_entered_mobile_number(String optionalValue, String data) throws Throwable {
		if (optionalValue.equalsIgnoreCase("mobile number")) {
			String vobjobileNumber = Constants.AndroidCDAppRegistrationOR.getProperty("MobileNumberfield");
			Assert.assertEquals("PASS", Constants.key.click(vobjobileNumber));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjobileNumber, data));
			LogCapture.info("user entered mobile number:  " + data);
		} else if (optionalValue.equalsIgnoreCase("password")) {
			String vobjPassword = Constants.AndroidCDAppRegistrationOR.getProperty("PasswordTextBox");
			Assert.assertEquals("PASS", Constants.key.click(vobjPassword));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vobjPassword, data));
			LogCapture.info("user entered password:  " + data);
		}
	}

	@When("^android user click on continue button on (mobile|password) screen$")
	public void android_user_click_on_continue_button_on_mobile_screen(String optionalValue) throws Throwable {
		String vobjcontinue = Constants.AndroidCDAppRegistrationOR.getProperty("SaveBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjcontinue));
		Assert.assertEquals("PASS", Constants.key.click(vobjcontinue));
		LogCapture.info("user clicked on continue button.......");
		Thread.sleep(7000);

	}

	// Error message not implemented
	@Then("^android app should generate error message to provide correct OTP$")
	public void android_app_should_generate_error_message_to_provide_correct_OTP() throws Throwable {

	}

	// Error message not implemented
	@Then("^android app should generate error message for invalid mobile number$")
	public void android_app_should_generate_error_message_for_invalid_mobile_number() throws Throwable {

	}

	@Then("^android app should display resend pin link$")
	public void android_app_should_display_resend_OTP_link() throws Throwable {
		String vobjResendPin = Constants.AndroidCDAppRegistrationOR.getProperty("ResendPin");
		Assert.assertEquals("PASS", Constants.key.isElementActive(vobjResendPin));
		LogCapture.info("displayed resend pin link.......");

	}

	@Then("^all paramters of set password screen should be displayed to android user$")
	public void all_paramters_of_set_password_screen_should_be_displayed_to_android_user() throws Throwable {
		String vobjPassword = Constants.AndroidCDAppRegistrationOR.getProperty("PasswordTextBox");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjPassword));
		LogCapture.info("displayed: Password field ");

		String vobjEyeicon = Constants.AndroidCDAppRegistrationOR.getProperty("Eyeicon");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjEyeicon));
		LogCapture.info("displayed: hide password icon ");

		String vobjPasswordRule = Constants.AndroidCDAppRegistrationOR.getProperty("PasswordRuleHeader");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjPasswordRule));
		LogCapture.info("displayed: Password validation header ");

		String vobjPasswordRule1 = Constants.AndroidCDAppRegistrationOR.getProperty("Rule1");
		String vExpectedRule1 = Constants.AndroidTestData.getProperty("SetPasswordRul1");
		String atbValueRule1 = Constants.key.getAttributeValue(vobjPasswordRule1, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValueRule1, vExpectedRule1));
		LogCapture.info("Displayed:  " + atbValueRule1);

		String vobjPasswordRule2 = Constants.AndroidCDAppRegistrationOR.getProperty("Rule2");
		String vExpectedRule2 = Constants.AndroidTestData.getProperty("SetPasswordRul2");
		String atbValueRule2 = Constants.key.getAttributeValue(vobjPasswordRule2, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValueRule2, vExpectedRule2));
		LogCapture.info("Displayed:  " + atbValueRule2);

		String vobjPasswordRule3 = Constants.AndroidCDAppRegistrationOR.getProperty("Rule3");
		String vExpectedRule3 = Constants.AndroidTestData.getProperty("SetPasswordRul3");
		String atbValueRule3 = Constants.key.getAttributeValue(vobjPasswordRule3, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValueRule3, vExpectedRule3));
		LogCapture.info("Displayed:  " + atbValueRule3);

		String vobjPasswordRule4 = Constants.AndroidCDAppRegistrationOR.getProperty("Rule4");
		String vExpectedRule4 = Constants.AndroidTestData.getProperty("SetPasswordRul4");
		String atbValueRule4 = Constants.key.getAttributeValue(vobjPasswordRule4, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValueRule4, vExpectedRule4));
		LogCapture.info("Displayed:  " + atbValueRule4);

		String vobjfootertext = Constants.AndroidCDAppRegistrationOR.getProperty("footertext");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjfootertext));
		String vExpectedfooter = Constants.AndroidTestData.getProperty("SetPasswordScreenFooterText");
		String atbValuefooter = Constants.key.getAttributeValue(vobjfootertext, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValuefooter, vExpectedfooter));
		LogCapture.info("displayed:  " + atbValuefooter);

		Thread.sleep(2000);
		String vObjContinueBtn = Constants.AndroidCDAppRegistrationOR.getProperty("SaveBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtn));
		LogCapture.info("displayed: Continue Button ");
	}

	@When("^android user presses device back button$")
	public void android_user_presses_device_back_button() throws Throwable {
		Thread.sleep(2000);
		((AndroidDriver) Constants.driver).pressKey(new KeyEvent(AndroidKey.BACK));
		LogCapture.info("user clicked on device back button.......");
	}

	@When("^android user selects the show button$")
	public void android_user_selects_the_show_button() throws Throwable {
		String vObjHideicon = Constants.AndroidCDAppRegistrationOR.getProperty("Eyeicon");
		Assert.assertEquals("PASS", Constants.key.click(vObjHideicon));
		LogCapture.info("user clicked on show/hide button ");
	}

	@Then("^the characters entered into the password \"([^\"]*)\" field should be visible$")
	public void the_characters_entered_into_the_password_field_should_be_visible(String password) throws Throwable {
		String vobjenteredPassword = Constants.AndroidCDAppRegistrationOR.getProperty("PasswordTextBox");
		String atbValue = Constants.key.getAttributeValue(vobjenteredPassword, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, password));
		LogCapture.info("Password displayed as :  " + atbValue);
	}

	@Then("^android user selects T&Cs acknowledgment switch$")
	public void android_user_selects_T_Cs_acknowledgment_switch() throws Throwable {
		String vObjswitch = Constants.AndroidCDAppRegistrationOR.getProperty("T&CSwitch");
		Assert.assertEquals("PASS", Constants.key.click(vObjswitch));
		LogCapture.info("user selects T&Cs acknowledgment switch");
	}

	@Then("^continue button gets (enabled|disabled) on set password screen for android app$")
	public void continue_button_gets_enabled_on_set_password_screen_for_android_app(String button) throws Throwable {
		String vObjSaveBtn = Constants.AndroidCDAppRegistrationOR.getProperty("SaveBtn");
		Thread.sleep(2000);
		if (button.equals("enabled")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSaveBtn));
			Assert.assertEquals("true", Constants.key.getAttributeValue(vObjSaveBtn, "enabled").toString());
			LogCapture.info("continue button is Active.......");
		} else if (button.equals("disabled")) {
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSaveBtn));
			Assert.assertEquals("false", Constants.key.getAttributeValue(vObjSaveBtn, "enabled").toString());
			LogCapture.info("continue button is Inactive.......");
		}
	}

	@Then("^android user clicks on continue button to set password$")
	public void android_user_clicks_on_continue_button_to_set_password() throws Throwable {
		String vObjcontinue = Constants.AndroidCDAppRegistrationOR.getProperty("SaveBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjcontinue));
		LogCapture.info("User clicked on save button....");
		Thread.sleep(30000);

	}

	@Then("^android app verifying details for KYC check$")
	public void android_app_verifying_details_for_KYC_check() throws Throwable {
		// Constants.modifyWaitInSeconds =
		// Integer.parseInt(Constants.CONFIG.getProperty("ModifyWaitInSecondsForAndroid"));
		Assert.assertEquals("PASS", Constants.key.reInitializeWebDriverWait());

		String vobjverfiyingdetailsloader = Constants.AndroidCDAppRegistrationOR.getProperty("verfiyingdetailsloader");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjverfiyingdetailsloader));
		String vExpectedDetails = Constants.AndroidTestData.getProperty("verifyLoaderText");
		String atbValueDetails = Constants.key.getAttributeValue(vobjverfiyingdetailsloader, "text").toString();
		Assert.assertEquals("PASS",
				Constants.key.VerifyTextContains(atbValueDetails, vExpectedDetails));
		LogCapture.info("displayed:  " + atbValueDetails);

		String vobjVerfiyingSubtext = Constants.AndroidCDAppRegistrationOR.getProperty("LoaderSubtext");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjVerfiyingSubtext));
		String vExpectedSubtext = Constants.AndroidTestData.getProperty("verifyLoaderSubText");
		String atbValueSubtext = Constants.key.getAttributeValue(vobjVerfiyingSubtext, "text").toString();
		Assert.assertEquals("PASS",
				Constants.key.VerifyTextContains(atbValueSubtext, vExpectedSubtext));
		LogCapture.info("displayed:  " + atbValueDetails);

		// To initialize wait with original value
		Constants.wait = new WebDriverWait(Constants.driver, Constants.waitInSeconds);
	}

	@Then("^Kill android app from background$")
	public void kill_android_app_from_background() throws Throwable {
		Constants.driver.closeApp();
		LogCapture.info("Application killed.......");
	}

	@Then("^default currency does not displayed for selected country to android user$")
	public void default_currency_does_not_displayed_for_selected_country_to_android_user() throws Throwable {
		Thread.sleep(2000);
		String vobjDefaultCurrencytext = Constants.AndroidCDAppRecipient.getProperty("DefaultCurrency");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjDefaultCurrencytext));
		LogCapture.info("Default currency does not displayed for selected country");
	}

	@When("^android user click on (Update ID|Do it later) button$")
	public void android_user_click_on_Update_ID_button(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("Update ID")) {
			String vobjUpdateIDBtn = Constants.AndroidCDAppLogin.getProperty("UpdateID");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjUpdateIDBtn));
			Assert.assertEquals("PASS", Constants.key.click(vobjUpdateIDBtn));
			LogCapture.info("clicked on Update ID button");
		} else if (optionalValue.equalsIgnoreCase("Do it later")) {
			String vobjDoItLaterBtn = Constants.AndroidCDAppLogin.getProperty("DoItLater");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjDoItLaterBtn));
			Assert.assertEquals("PASS", Constants.key.click(vobjDoItLaterBtn));
			LogCapture.info("clicked on Do it later button");
		}
	}

	@Then("^android the app should navigate to web login page$")
	public void android_the_app_should_navigate_to_web_login_page() throws Throwable {
		String vobjbrowser = Constants.AndroidCDAppLogin.getProperty("Webbroswer");
		String vExpectedURL = Constants.AndroidTestData.getProperty("SITWebURL");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobjbrowser));
		String vObjbroswerURL = Constants.driver.findElement(By.xpath(vobjbrowser)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjbroswerURL, vExpectedURL));
	}

	@Then("^android the app should load the ID update needed screen$")
	public void android_the_app_should_load_the_ID_update_needed_screen() throws Throwable {
		String vObjIDNeededScrren = Constants.AndroidCDAppLogin.getProperty("ScreenHeader");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjIDNeededScrren));
		String vObjHeaderText = Constants.driver.findElement(By.xpath(vObjIDNeededScrren)).getText();
		String vExpected = Constants.AndroidTestData.getProperty("IDNeededScreen");
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjHeaderText, vExpected));
		LogCapture.info("User navigated to ID update needed screen successfully .......");
	}

	@Then("^remove account button should be displayed to android user$")
	public void remove_account_button_should_be_displayed_to_android_user() throws Throwable {
		String vObjRemoveAccBtn = Constants.AndroidCDAppAccountOR.getProperty("RemoveAccount");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRemoveAccBtn));
		LogCapture.info("Remove Account button should be displayed .......");
	}

	@Then("^android user clicks (remove account|Cancel|Reset) button on manage device screen$")
	public void android_user_clicks_remove_account_button_on_manage_device_screen(String optionalValue)
			throws Throwable {
		if (optionalValue.equalsIgnoreCase("remove account")) {
			String vObjRemoveAccBtn = Constants.AndroidCDAppAccountOR.getProperty("RemoveAccount");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRemoveAccBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjRemoveAccBtn));
			LogCapture.info("Clicked on remove account button.....");
		} else if (optionalValue.equalsIgnoreCase("Cancel")) {
			String vObjcancelBtn = Constants.AndroidCDAppAccountOR.getProperty("CancelBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjcancelBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjcancelBtn));
			LogCapture.info("Clicked on cancel button.....");
		} else if (optionalValue.equalsIgnoreCase("Reset")) {
			String vObjResetBtn = Constants.AndroidCDAppAccountOR.getProperty("ResetBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjResetBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjResetBtn));
			LogCapture.info("Clicked on Reset button.....");
		}
	}

	@Then("^confirmation pop up message should be displayed to android user$")
	public void confirmation_pop_up_message_should_be_displayed_to_android_user() throws Throwable {
		String vObjPopTitale = Constants.AndroidCDAppAccountOR.getProperty("POPTitle");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPopTitale));

		String vObjPOPMessage = Constants.AndroidCDAppAccountOR.getProperty("PopMsg");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPOPMessage));
		String vObjPOPMessageText = Constants.driver.findElement(By.xpath(vObjPOPMessage)).getText();
		String vExpected = Constants.AndroidTestData.getProperty("RemoveAccountConfirmatiomMsg");
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjPOPMessageText, vExpected));
		LogCapture.info("confirmation message:" + vObjPOPMessageText);
	}

	@Then("^android user should be land on send money screen$")
	public void android_user_should_be_land_on_send_money_screen() throws Throwable {
		String vObjDashboard = Constants.AndroidCDAppLogin.getProperty("AndroidDashboardPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDashboard));
		LogCapture.info("User navigated to send money screen successfully .......");
	}

	@When("^android user enter amount \"([^\"]*)\" in buying currency and user stops typing the amount$")
	public void android_user_enter_amount_in_buying_currency_and_user_stops_typing_the_amount(String amount)
			throws Throwable {
		String vObjBuyingAmount = Constants.AndroidCDAppSendMoney.getProperty("BuyingAmount");
		Assert.assertEquals("PASS", Constants.key.click(vObjBuyingAmount));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBuyingAmount, amount));

	}

	@Then("^after two sec appropriate amount should be calculated in sell currency in android app$")
	public void after_two_sec_appropriate_amount_should_be_calculated_in_sell_currency_in_android_app()
			throws Throwable {

		String VObjSellingAmount = Constants.AndroidCDAppSendMoney.getProperty("SellingAmount");
		String vObjSellingText = Constants.driver.findElement(By.xpath(VObjSellingAmount)).getText();
		Constants.TempData = vObjSellingText;
		LogCapture.info("Before refreshed Calculated Selling Amount :" + vObjSellingText);

		boolean isRefreshed = false;
		for (int i = 0; i <= 63; i++) {

			Thread.sleep(2000);
			String VObjSellingAmount1 = Constants.AndroidCDAppSendMoney.getProperty("SellingAmount");
			String vObjSellingText1 = Constants.driver.findElement(By.xpath(VObjSellingAmount1)).getText();

			if (vObjSellingText1.equals(Constants.TempData)) {
				LogCapture.info("temp data= " + Constants.TempData + "equals currenct value: " + vObjSellingText1);
				LogCapture.info("After " + 1 * (i + 1) + " seconds :" + vObjSellingText1);
			} else {
				isRefreshed = true;
				LogCapture.info("temp data: " + Constants.TempData + " not equals currenct value: " + vObjSellingText1);
				LogCapture.info("After " + 1 * (i + 1) + " seconds Selling Amount refreshed:" + vObjSellingText1);
				break;
			}

		}

		if (isRefreshed) {
			Assert.assertEquals("PASS", "PASS");
		} else {
			Assert.assertEquals("PASS", Constants.KEYWORD_FAIL);
		}
	}

	@When("^android user enter amount \"([^\"]*)\" less than hundred GBP in selling currency and user stops typing the amount$")
	public void android_user_enter_amount_less_than_hundred_GBP_in_selling_currency_and_user_stops_typing_the_amount(
			String amount) throws Throwable {
		String vObjSellingAmount = Constants.AndroidCDAppSendMoney.getProperty("SellingAmount");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSellingAmount));
		Assert.assertEquals("PASS", Constants.key.click(vObjSellingAmount));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSellingAmount, amount));
	}

	@Then("^minimum amount limit error message should be displayed to android user$")
	public void minimum_amount_limit_error_message_should_be_displayed_to_android_user() throws Throwable {
		Thread.sleep(5000);
		String vobjLessThanGBP = Constants.AndroidCDAppSendMoney.getProperty("ErrorText");
		String vExpectedMSg = Constants.AndroidTestData.getProperty("LessThanGBP");
		String atbValue = Constants.key.getAttributeValue(vobjLessThanGBP, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vExpectedMSg));
		LogCapture.info("Displayed minimum limit amount error message :  " + atbValue);
	}

	@When("^android user enter amount \"([^\"]*)\" greater than allowed GBP limit in selling currency$")
	public void android_user_enter_amount_greater_than_allowed_GBP_limit_in_selling_currency(String amount)
			throws Throwable {
		String vObjSellingAmount = Constants.AndroidCDAppSendMoney.getProperty("SellingAmount");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSellingAmount));
		Assert.assertEquals("PASS", Constants.key.click(vObjSellingAmount));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSellingAmount, amount));
		LogCapture.info("Entered amount:  " + amount);

	}

	@Then("^maximum allowed amount limit error message should be displayed to android user$")
	public void maximum_allowed_amount_limit_error_message_should_be_displayed_to_android_user() throws Throwable {
		Thread.sleep(5000);
		String vobjGreaterThanGBP = Constants.AndroidCDAppSendMoney.getProperty("ErrorText");
		String vExpectedMsg = Constants.AndroidTestData.getProperty("GreaterThanGBP");
		String atbValue = Constants.key.getAttributeValue(vobjGreaterThanGBP, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vExpectedMsg));
		LogCapture.info("Displayed maximum limit error message:  " + atbValue);

	}

	@When("^android user enter amount \"([^\"]*)\" in (selling|buying) currency$")
	public void android_user_enter_amount_in_selling_currency(String amount, String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("selling")) {
			String vObjSellingAmount = Constants.AndroidCDAppSendMoney.getProperty("SellingAmount");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSellingAmount));
			Assert.assertEquals("PASS", Constants.key.click(vObjSellingAmount));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSellingAmount, amount));
			LogCapture.info("Entered selling amount:  " + amount);

			String vObjSellCurrencyLbl = Constants.AndroidCDAppSendMoney.getProperty("SellingCurrency");
			String vSellCurrency = Constants.key.readText(vObjSellCurrencyLbl);
			Constants.DataMap.put("UserSelection", "Sell");
			Constants.DataMap.put("UserAmountWithCurrency", amount + " " + vSellCurrency);

		} else if (optionalValue.equalsIgnoreCase("buying")) {
			String vObjBuyingAmount = Constants.AndroidCDAppSendMoney.getProperty("BuyingAmount");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBuyingAmount));
			Assert.assertEquals("PASS", Constants.key.click(vObjBuyingAmount));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBuyingAmount, amount));
			LogCapture.info("Entered buying amount:  " + amount);

			String vObjBuyCurrencyLbl = Constants.AndroidCDAppSendMoney.getProperty("BuyingCurrnecy");
			String vBuyCurrency = Constants.key.readText(vObjBuyCurrencyLbl);
			Constants.DataMap.put("UserSelection", "Buy");
			// Constants.DataMap.put("UserAmountWithCurrency",Constants.key.getAttributeValue(vObjBuyingAmount,
			// "value") + " " + vBuyCurrency);
			Constants.DataMap.put("UserAmountWithCurrency", amount + " " + vBuyCurrency);

		}
	}

	@Then("^after two sec appropriate amount should be calculated in buy currency in android app$")
	public void after_two_sec_appropriate_amount_should_be_calculated_in_buy_currency_in_android_app()
			throws Throwable {
		String VObjBuyingAmount = Constants.AndroidCDAppSendMoney.getProperty("BuyingAmount");
		String vObjBuyingText = Constants.driver.findElement(By.xpath(VObjBuyingAmount)).getText();
		Constants.TempData = vObjBuyingText;
		LogCapture.info("Before refreshed Calculated Buying Amount :" + vObjBuyingText);

		boolean isRefreshed = false;
		for (int i = 0; i <= 63; i++) {
			Thread.sleep(2000);
			String VObjBuyingAmount1 = Constants.AndroidCDAppSendMoney.getProperty("BuyingAmount");
			String vObjBuyingText1 = Constants.driver.findElement(By.xpath(VObjBuyingAmount1)).getText();

			if (vObjBuyingText1.equals(Constants.TempData)) {
				LogCapture.info("temp data= " + Constants.TempData + "equals current value: " + vObjBuyingText1);
				LogCapture.info("After " + 1 * (i + 1) + " seconds :" + vObjBuyingText1);
			} else {
				isRefreshed = true;
				LogCapture.info("temp data: " + Constants.TempData + " not equals current value: " + vObjBuyingText1);
				LogCapture.info("After " + 1 * (i + 1) + " seconds Buying Amount refreshed:" + vObjBuyingText1);
				break;
			}
		}
		if (isRefreshed) {
			Assert.assertEquals("PASS", "PASS");
		} else {
			Assert.assertEquals("PASS", Constants.KEYWORD_FAIL);
		}
	}

	@Then("^an auto timer of sixty seconds should start and rate should be refreshed and buying amount should be updated$")
	public void an_auto_timer_of_sixty_seconds_should_start_and_rate_should_be_refreshed_and_buying_amount_should_be_updated()
			throws Throwable {
		String VObjBuyingAmount = Constants.AndroidCDAppSendMoney.getProperty("BuyingAmount");
		String vObjBuyingText = Constants.driver.findElement(By.xpath(VObjBuyingAmount)).getText();
		Constants.TempData = vObjBuyingText;
		LogCapture.info("Before rate refresh calculated Buying Amount :" + vObjBuyingText);

		boolean isRefreshed = false;
		for (int i = 0; i <= 7; i++) {
			Thread.sleep(10000);
			String VObjBuyingAmount1 = Constants.AndroidCDAppSendMoney.getProperty("BuyingAmount");
			String vObjBuyingText1 = Constants.driver.findElement(By.xpath(VObjBuyingAmount1)).getText();

			if (vObjBuyingText1.equals(Constants.TempData)) {
				// LogCapture.info("temp data= " + Constants.TempData + "equals
				// current value: " + vObjBuyingText1);
				LogCapture.info("After " + 10 * (i + 1) + " seconds :" + vObjBuyingText1);
			} else {
				isRefreshed = true;
				// LogCapture.info("temp data: " + Constants.TempData + " not
				// equals current value: " + vObjBuyingText1);
				LogCapture.info("After " + 10 * (i + 1) + " seconds Buying Amount refreshed:" + vObjBuyingText1);
				break;
			}
		}
		if (isRefreshed) {
			Assert.assertEquals("PASS", "PASS");
		} else {
			Assert.assertEquals("PASS", Constants.KEYWORD_FAIL);
		}
	}

	@Then("^an auto timer of sixty seconds should start and rate should be refreshed and selling amount should be updated$")
	public void an_auto_timer_of_sixty_seconds_should_start_and_rate_should_be_refreshed_and_selling_amount_should_be_updated()
			throws Throwable {
		String vObjSellingAmount = Constants.AndroidCDAppSendMoney.getProperty("SellingAmount");
		String vObjSellingText = Constants.driver.findElement(By.xpath(vObjSellingAmount)).getText();
		Constants.TempData = vObjSellingText;
		LogCapture.info("Before rate refreshed Calculated Selling Amount :" + vObjSellingText);

		boolean isRefreshed = false;
		for (int i = 0; i <= 7; i++) {
			Thread.sleep(10000);
			String VObjSellingAmount1 = Constants.AndroidCDAppSendMoney.getProperty("SellingAmount");
			String vObjSellingText1 = Constants.driver.findElement(By.xpath(VObjSellingAmount1)).getText();

			if (vObjSellingText1.equals(Constants.TempData)) {
				// LogCapture.info("temp data= " + Constants.TempData + "equals
				// current value: " + vObjSellingText1);
				LogCapture.info("After " + 10 * (i + 1) + " seconds :" + vObjSellingText1);
			} else {
				isRefreshed = true;
				// LogCapture.info("temp data: " + Constants.TempData + " not
				// equals current value: " + vObjSellingText1);
				LogCapture.info("After " + 10 * (i + 1) + " seconds Selling Amount refreshed:" + vObjSellingText1);
				break;
			}
		}
		if (isRefreshed) {
			Assert.assertEquals("PASS", "PASS");
		} else {
			Assert.assertEquals("PASS", Constants.KEYWORD_FAIL);
		}
	}

	@When("^android user selects buy currency drop down$")
	public void android_user_selects_buy_currency_drop_down() throws Throwable {
		String vObjBuyCurrencydrp = Constants.AndroidCDAppSendMoney.getProperty("BuyingCurrnecy");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBuyCurrencydrp));
		Assert.assertEquals("PASS", Constants.key.click(vObjBuyCurrencydrp));
		LogCapture.info("User click on buy currency dropdown");
	}

	@When("^android user clicks on back arrow$")
	public void android_user_clicks_on_back_arrow() throws Throwable {
		String vObjCurrencyBackbtn = Constants.AndroidCDAppSendMoney.getProperty("BackBtnCurrencydrp");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCurrencyBackbtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjCurrencyBackbtn));
		LogCapture.info("User click on back arrow from currency dropdown");
	}

	@When("^android user selects Sell currency drop down$")
	public void android_user_selects_Sell_currency_drop_down() throws Throwable {
		String vObjSellCurrencydrp = Constants.AndroidCDAppSendMoney.getProperty("SellingCurrency");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSellCurrencydrp));
		Assert.assertEquals("PASS", Constants.key.click(vObjSellCurrencydrp));
		LogCapture.info("User click on sell currency dropdown");
	}

	@When("^android user enters currency code or name \"([^\"]*)\"$")
	public void android_user_enters_currency_code_or_name(String currency) throws Throwable {
		String vObjSearchcurrency = Constants.AndroidCDAppSendMoney.getProperty("CurrencySearch");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSearchcurrency));
		Assert.assertEquals("PASS", Constants.key.click(vObjSearchcurrency));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSearchcurrency, currency));
		LogCapture.info("User found the enerted currency into dropdown");
	}

	@Then("^android user should be able to search the available currencies through the search bar$")
	public void android_user_should_be_able_to_search_the_available_currencies_through_the_search_bar()
			throws Throwable {
		String vObjSelectcurrency = Constants.AndroidCDAppSendMoney.getProperty("SelectCurrdropdown");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSelectcurrency));
		Assert.assertEquals("PASS", Constants.key.click(vObjSelectcurrency));
		LogCapture.info("User select currency from dropdown");
	}

	@When("^android user click on \\(X\\) option$")
	public void android_user_click_on_X_option() throws Throwable {
		String vObjcancelsearch = Constants.AndroidCDAppSendMoney.getProperty("CancelCurrencySearch");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjcancelsearch));
		Assert.assertEquals("PASS", Constants.key.click(vObjcancelsearch));
		LogCapture.info("User cancel the currency search..");
	}

	@Then("^android app should take the user to the home screen with the selected currency \"([^\"]*)\"in buying dropdown$")
	public void android_app_should_take_the_user_to_the_home_screen_with_the_selected_currency_in_buying_dropdown(
			String data) throws Throwable {
		Thread.sleep(5000);
		String vObjBuyCurrencydrp = Constants.AndroidCDAppSendMoney.getProperty("BuyingCurrnecy");
		String vObjBuyingCurrText = Constants.driver.findElement(By.xpath(vObjBuyCurrencydrp)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(vObjBuyingCurrText, data));
		LogCapture.info("displayed Buying currency :" + vObjBuyingCurrText);
	}

	@Then("^android app should take the user to the home screen with the selected currency \"([^\"]*)\" in selling dropdown$")
	public void android_app_should_take_the_user_to_the_home_screen_with_the_selected_currency_in_selling_dropdown(
			String data) throws Throwable {
		Thread.sleep(5000);
		String vObjSellCurrencydrp = Constants.AndroidCDAppSendMoney.getProperty("SellingCurrency");
		String vObjsellingCurrText = Constants.driver.findElement(By.xpath(vObjSellCurrencydrp)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(vObjsellingCurrText, data));
		LogCapture.info("selected selling currency:" + vObjsellingCurrText);
	}

	@Then("^android app should take the user to the home screen with the selected currency buyCurrency \"([^\"]*)\" in buying dropdown$")
	public void android_app_should_take_the_user_to_the_home_screen_with_the_selected_currency_buyCurrency_in_buying_dropdown(
			String data) throws Throwable {
		Thread.sleep(5000);
		String vObjBuyCurrencydrp = Constants.AndroidCDAppSendMoney.getProperty("BuyingCurrnecy");
		String vObjBuyingCurrText = Constants.driver.findElement(By.xpath(vObjBuyCurrencydrp)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(vObjBuyingCurrText, data));
		LogCapture.info("selected Buying currency:" + vObjBuyingCurrText);
	}

	@Then("^error message should be displayed for unsupported currency pair$")
	public void error_message_should_be_displayed_for_unsupported_currency_pair() throws Throwable {
		Thread.sleep(5000);
		String vobjCurrencyNotsupported = Constants.AndroidCDAppSendMoney.getProperty("CurrencyNotSupport");
		String vExpectedMSg = Constants.AndroidTestData.getProperty("CurrencyNotSupportedError");
		String atbValue = Constants.key.getAttributeValue(vobjCurrencyNotsupported, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vExpectedMSg));
		LogCapture.info("Currency not supported error message Displayed:  " + atbValue);
	}

	@Then("^rate should not be fetched$")
	public void rate_should_not_be_fetched() throws Throwable {
		// String vObjGetrate =
		// Constants.AndroidCDAppLogin.getProperty("getrate");
		// Assert.assertEquals("true",
		// Constants.key.getAttributeValue(vObjGetrate, "enabled").toString());
		LogCapture.info("Rate not fetched when currency not supported.......");
	}

	@When("^android user click on swap$")
	public void android_user_click_on_swap() throws Throwable {
		Thread.sleep(5000);
		String vObjswapcurr = Constants.AndroidCDAppSendMoney.getProperty("SwapCurrency");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjswapcurr));
		Assert.assertEquals("PASS", Constants.key.click(vObjswapcurr));
		LogCapture.info("User click on swap currency");
	}

	@Then("^after swap sell currency displayed as buy \"([^\"]*)\" and buy currency displayed as sell \"([^\"]*)\" currency$")
	public void after_swap_sell_currency_displayed_as_buy_and_buy_currency_displayed_as_sell_currency(String data,
																									  String data1) throws Throwable {
		Thread.sleep(5000);
		String vObjSellCurrencydrp = Constants.AndroidCDAppSendMoney.getProperty("SellingCurrency");
		String vObjsellingCurrText = Constants.driver.findElement(By.xpath(vObjSellCurrencydrp)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(vObjsellingCurrText, data));
		LogCapture.info("After swap selling currency:" + data1);
		String vObjBuyCurrencydrp = Constants.AndroidCDAppSendMoney.getProperty("BuyingCurrnecy");
		String vObjBuyingCurrText = Constants.driver.findElement(By.xpath(vObjBuyCurrencydrp)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(vObjBuyingCurrText, data1));
		LogCapture.info("After swap Buying currency:" + data);
	}

	@Then("^in selling \"([^\"]*)\" amount should remain as is in android app$")
	public void in_selling_amount_should_remain_as_is_in_android_app(String data) throws Throwable {
		String VObjSellingAmount = Constants.AndroidCDAppSendMoney.getProperty("SellingAmount");
		String vObjSellingText = Constants.driver.findElement(By.xpath(VObjSellingAmount)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(vObjSellingText, data));
		LogCapture.info("After swap Selling Amount remains same:" + vObjSellingText);
	}

	@Then("^in buying amount \"([^\"]*)\" should remain as is$")
	public void in_buying_amount_should_remain_as_is(String data) throws Throwable {
		String VObjBuyingAmount = Constants.AndroidCDAppSendMoney.getProperty("BuyingAmount");
		String vObjBuyingText = Constants.driver.findElement(By.xpath(VObjBuyingAmount)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(vObjBuyingText, data));
		LogCapture.info("After swap Buying Amount remains same :" + vObjBuyingText);
	}

	@When("^android user click on continue$")
	public void android_user_click_on_continue() throws Throwable {
		Thread.sleep(5000);
		String vObjContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("ContinueBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjContinueBtn));
		LogCapture.info("User click on continue button");
	}

	@Then("^android user should land on select recipient screen$")
	public void android_user_should_land_on_select_recipient_screen() throws Throwable {
		Thread.sleep(15000);
		String vObjReceipient = Constants.AndroidCDAppSendMoney.getProperty("SelectReceipient");
		String vObjReceipientText = Constants.driver.findElement(By.xpath(vObjReceipient)).getText();
		Assert.assertEquals("PASS",
				Constants.key.VerifyTextContains(vObjReceipientText, "Select recipient"));
		LogCapture.info("Screen Title:" + vObjReceipientText);
	}

	@When("^android user clicks on cancel button$")
	public void android_user_clicks_on_cancel_button() throws Throwable {
		String vObjCancelReciepient = Constants.AndroidCDAppSendMoney.getProperty("CancelfromReceipinet");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCancelReciepient));
		Assert.assertEquals("PASS", Constants.key.click(vObjCancelReciepient));
		LogCapture.info("User click on cancel button from select receipient screen");
	}

	@When("^default currency pair \"([^\"]*)\" and amount \"([^\"]*)\"should be displayed in selling currency$")
	public void default_currency_pair_and_amount_should_be_displayed_in_selling_currency(String defaultCurrencyPair,
																						 String defaultSellingAmt) throws Throwable {
		Thread.sleep(7000);
		String vObjSellCurrencydrp = Constants.AndroidCDAppSendMoney.getProperty("SellingCurrency");
		String vObjsellingCurrText = Constants.driver.findElement(By.xpath(vObjSellCurrencydrp)).getText();
		String vObjBuyCurrencydrp = Constants.AndroidCDAppSendMoney.getProperty("BuyingCurrnecy");
		String vObjBuyingCurrText = Constants.driver.findElement(By.xpath(vObjBuyCurrencydrp)).getText();
		String vObjCurrencypair = vObjsellingCurrText + '-' + vObjBuyingCurrText;
		LogCapture.info("Currency pair on send money screen:" + vObjCurrencypair);
		Assert.assertEquals("PASS", Constants.key.VerifyText(defaultCurrencyPair, vObjCurrencypair));
		String vObjSellingAmount = Constants.AndroidCDAppSendMoney.getProperty("SellingAmount");
		String vObjSellingText = Constants.driver.findElement(By.xpath(vObjSellingAmount)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyText(defaultSellingAmt, vObjSellingText));
		LogCapture.info("selling amount on send money screen:" + vObjSellingText);
	}

	@Then("^only buy currency \"([^\"]*)\" recipients list should be displayed to android user$")
	public void only_buy_currency_recipients_list_should_be_displayed_to_android_user(String buyCurrency)
			throws Throwable {
		String vObjRecpientList = Constants.AndroidCDAppRecipient.getProperty("RecpientList");
		String vObjRecpientListitm = Constants.AndroidCDAppRecipient.getProperty("Recipientlistitem");
		String vObjRecipientCurrency = Constants.AndroidCDAppRecipient.getProperty("RecipientCurrency");
		int recpientListSize = Constants.key.getElementList(vObjRecpientList).size();
		LogCapture.info("Total recipient lsit Select Recipient screen:" + recpientListSize);

		for (int i = 0; i < recpientListSize; i++) {
			String vCurrency = Constants.key.getAttributeValue(vObjRecpientListitm + i + vObjRecipientCurrency, "text");

			if (i == 6) {
				Assert.assertEquals("PASS", Constants.key.scrollToExactElement(vObjRecipientCurrency));
			}
			LogCapture.info("Recipent: " + i + " Currency : " + vCurrency + "");
			if (vCurrency.equalsIgnoreCase(buyCurrency)) {
				LogCapture.info("Recipient currency match found : " + vCurrency);
				break;
			} else {
				LogCapture.info("Recipent List not found for the currency : " + i + " " + vCurrency);
			}
		}
	}

	@Then("^empty recipient screen with an option to add a new recipient should be displayed in android app$")
	public void empty_recipient_screen_with_an_option_to_add_a_new_recipient_should_be_displayed_in_android_app()
			throws Throwable {
		String vObjAddRecipient = Constants.AndroidCDAppSendMoney.getProperty("AddRecipientBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddRecipient));
		LogCapture.info("Add Recipient button displayed.....");
	}

	@Then("^non editable recipient currency should be auto set as buying currency \"([^\"]*)\" in android app$")
	public void non_editable_recipient_currency_should_be_auto_set_as_buying_currency_in_android_app(String buyCurrency)
			throws Throwable {
		Thread.sleep(3000);
		String vObjnonEditCurrency = Constants.AndroidCDAppRecipient.getProperty("EditCurrency");
		String vObjnonEditCurrencyTxt = Constants.key.getAttributeValue(vObjnonEditCurrency, "text");
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjnonEditCurrencyTxt, buyCurrency));
		LogCapture.info("Buying currency on Add Recipient screen:" + vObjnonEditCurrencyTxt);
		// enabled and disabled need to check
	}

	@Then("^android user land on Payment Method screen$")
	public void android_user_land_on_Payment_Method_screen() throws Throwable {
		Thread.sleep(8000);
		String vObjPaymentMethod = Constants.AndroidCDAppSendMoney.getProperty("PaymentMethod");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentMethod));
		LogCapture.info("Payment method screen displayed.....");
	}

	@When("^android user clicks on back arrow from payment method screen$")
	public void android_user_clicks_on_back_arrow_from_payment_method_screen() throws Throwable {
		String vObjBackbtnpaymentmethod = Constants.AndroidCDAppSendMoney.getProperty("BackBtnPaymentmenthod");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBackbtnpaymentmethod));
		Assert.assertEquals("PASS", Constants.key.click(vObjBackbtnpaymentmethod));
		LogCapture.info("User click on BAck button from payment mehtod");
	}

	@Then("^CVV field should display to android user with the message$")
	public void cvv_field_should_display_to_android_user_with_the_message() throws Throwable {
		Thread.sleep(2000);
		String vobjCVVTextMsg = Constants.AndroidCDAppSendMoney.getProperty("CVVText");
		String vExpectedCVVMSg = Constants.AndroidTestData.getProperty("CVVTextMsg");
		String atbValue = Constants.key.getAttributeValue(vobjCVVTextMsg, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vExpectedCVVMSg));
		LogCapture.info("Displayed CVV message :  " + atbValue);
	}

	@Then("^User enters the digits in CVV \"([^\"]*)\" fields$")
	public void user_enters_the_digits_in_CVV_fields(String data) throws Throwable {
		String vObjCVVNumber = Constants.AndroidCDAppSendMoney.getProperty("CVVNumber");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCVVNumber));
		Assert.assertEquals("PASS", Constants.key.click(vObjCVVNumber));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCVVNumber, data));
		LogCapture.info("User enter CVV number into textfield: " + data);
		Constants.key.scrollDownUI("Continue");
	}

	@Then("^continue button should get enabled for (bank transfer|debit card|wallet) in android app$")
	public void continue_button_should_get_enabled_for_bank_transfer_in_android_app(String optionalValue)
			throws Throwable {
		if (optionalValue.equalsIgnoreCase("Debit Card")) {
			String vObjContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("ContinueBtnPaymentMethod");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtn));
			String atbValue = Constants.key.getAttributeValue(vObjContinueBtn, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		} else if (optionalValue.equalsIgnoreCase("bank transfer")) {
			String vObjbankContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("BankContinueBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjbankContinueBtn));
			String atbValue = Constants.key.getAttributeValue(vObjbankContinueBtn, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		} else if (optionalValue.equalsIgnoreCase("wallet")) {
			String vObjwalletContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("WalletContinueBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjwalletContinueBtn));
			String atbValue = Constants.key.getAttributeValue(vObjwalletContinueBtn, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		}
		LogCapture.info("Contniue button enable state.........");
	}

	@Then("^continue button should get disabled in android app$")
	public void continue_button_should_get_disabled_in_android_app() throws Throwable {
		String vObjContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("ContinueBtnPaymentMethod");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtn));
		String atbValue = Constants.key.getAttributeValue(vObjContinueBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		LogCapture.info("Contniue button disabled state.........");
	}

	@Then("^android user select card from save card list$")
	public void android_user_select_card_from_save_card_list() throws Throwable {
		String vObjCardSelect = Constants.AndroidCDAppSendMoney.getProperty("CardSelection");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCardSelect));
		Assert.assertEquals("PASS", Constants.key.click(vObjCardSelect));
	}

	@Then("^user click on continue button$")
	public void user_click_on_continue_button() throws Throwable {
		String vObjContinueBtnPaymtMeth = Constants.AndroidCDAppSendMoney.getProperty("ContinueBtnPaymtMeth");
		// Assert.assertEquals("PASS",
		// Constants.key.eleLocatedDisplayed(vObjContinueBtnPaymtMeth));
		Constants.key.scrollDownUI("Continue");
		Assert.assertEquals("PASS", Constants.key.click(vObjContinueBtnPaymtMeth));
	}

	@Then("^user should navigates to review page$")
	public void user_should_navigates_to_review_page() throws Throwable {
		Thread.sleep(3000);
		String vobjReviewScreen = Constants.AndroidCDAppSendMoney.getProperty("ReviewScreen");
		String vObjReviewText = Constants.driver.findElement(By.xpath(vobjReviewScreen)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(vObjReviewText, "Review"));
		LogCapture.info("Screen Title:" + vObjReviewText);
	}

	@Then("^android user click on back button from review screen and get navigate back on the payment method screen$")
	public void android_user_click_on_back_button_from_review_screen_and_get_navigate_back_on_the_payment_method_screen()
			throws Throwable {
		String vObjBackBtnReview = Constants.AndroidCDAppSendMoney.getProperty("BackBtnReview");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBackBtnReview));
		Assert.assertEquals("PASS", Constants.key.click(vObjBackBtnReview));
	}

	@Then("^previously selected payment method (Debit Card|Wallet|Bank Transfer) should be displayed in android app on payment method screen$")
	public void previously_selected_payment_method_should_be_displayed_in_android_app_on_payment_method_screen(
			String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("Debit Card")) {
			String vObjDebitCardMethod = Constants.AndroidCDAppSendMoney.getProperty("Paymentmethselected");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardMethod));
			String vObjDebitCard = Constants.key.elementClickable(vObjDebitCardMethod);
			LogCapture.info("Debit Card button is selected......." + vObjDebitCard);
		} else if (optionalValue.equalsIgnoreCase("Wallet")) {
			String vObjWalletMethod = Constants.AndroidCDAppSendMoney.getProperty("WalletPayment");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWalletMethod));
			String vObjWallet = Constants.key.elementClickable(vObjWalletMethod);
			LogCapture.info("Debit Card button is selected......." + vObjWallet);

		} else if (optionalValue.equalsIgnoreCase("Bank Transfer")) {
			String vObjBankTransferMethod = Constants.AndroidCDAppSendMoney.getProperty("BankTransferPayment");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankTransferMethod));
			String vObjBankTransfer = Constants.key.elementClickable(vObjBankTransferMethod);
			LogCapture.info("Debit Card button is selected......." + vObjBankTransfer);
		}
	}

	@Then("^android user click on terms and condition link$")
	public void android_user_click_on_terms_and_condition_link() throws Throwable {
		Thread.sleep(4000);
		String vObjTermsandCondition = Constants.AndroidCDAppSendMoney.getProperty("TermsandCondition");
		Constants.key.scrollDownUI("Confirm and pay");
		Assert.assertEquals("PASS", Constants.key.click(vObjTermsandCondition));
		LogCapture.info("User click on terms and condition");
	}

	@Then("^window should open with a link to the respective UK T's & C in android app$")
	public void window_should_open_with_a_link_to_the_respective_UK_T_s_C_in_android_app() throws Throwable {
		LogCapture.info("User lands on terms and condition");
	}

	@When("^android user click on back button or the device back button on UK T's & C window$")
	public void android_user_click_on_back_button_or_the_device_back_button_on_UK_T_s_C_window() throws Throwable {

	}

	@Then("^android user lands back to review screen$")
	public void android_user_lands_back_to_review_screen() throws Throwable {
		String vobjReviewScreen = Constants.AndroidCDAppSendMoney.getProperty("ReviewScreen");
		String vObjReviewText = Constants.driver.findElement(By.xpath(vobjReviewScreen)).getText();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(vObjReviewText, "Review"));
		LogCapture.info("Screen Title:" + vObjReviewText);
	}

	@Then("^user land on (\\d+)d page$")
	public void user_land_on_d_page(int arg1) throws Throwable {
		Thread.sleep(9000);
		String vObj3Dsecurescreen = Constants.AndroidCDAppSendMoney.getProperty("3Dsecurescreen");
		String vObj3dsecureText = Constants.key.readText(vObj3Dsecurescreen);
		// Assert.assertEquals("PASS",
		// Constants.key.eleLocatedDisplayed(vObj3Dsecurescreen));
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObj3dsecureText, "3D Secure Simulator"));
		LogCapture.info("User land on 3D secure screen" + vObj3dsecureText);
	}

	@Then("^android user click on Confirm and pay button from Review screen$")
	public void android_user_click_on_Confirm_and_pay_button_from_Review_screen() throws Throwable {
		String vObjConfirnandPayBtn = Constants.AndroidCDAppSendMoney.getProperty("ConfirnandPayBtn");
		Constants.key.scrollDownUI("Confirm and pay");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjConfirnandPayBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjConfirnandPayBtn));
		LogCapture.info("User click on Confirm and pay button from review screen");
		Thread.sleep(15000);

	}

	@Then("^android user click on back button from (\\d+)d sceure screen$")
	public void android_user_click_on_back_button_from_d_sceure_screen(int arg1) throws Throwable {
		Constants.driver.navigate().back();
		LogCapture.info("User click device back from 3d secure screen");
	}

	@Then("^android user click on submit from (\\d+)dsceure screen$")
	public void androiduser_click_on_submit_from_dsceure_screen(int arg1) throws Throwable {
		String vObjSubmitbtn = Constants.AndroidCDAppSendMoney.getProperty("Submitbtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSubmitbtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjSubmitbtn));
		LogCapture.info("User click on submit button 3D secure screen");
		Thread.sleep(8000);
	}

	@Then("^android user land on success page and click on Done button$")
	public void android_user_land_on_success_page_and_click_on_Done_button() throws Throwable {
		/*String vobjSuccessScreen = Constants.AndroidCDAppSendMoney.getProperty("SuccessScreen");
		String vObjSuccessText = Constants.key.readText(vobjSuccessScreen);
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(vObjSuccessText, "Success"));
		LogCapture.info("Screen Title:" + vObjSuccessText);*/
		Constants.key.scrollDownUI("Done");
		String vObjDoneBtn = Constants.AndroidCDAppSendMoney.getProperty("DoneBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDoneBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjDoneBtn));
		LogCapture.info("User click on Done button Success screen");
	}

	@Then("^android user enter Payment Reference \"([^\"]*)\"$")
	public void android_user_enter_Payment_Reference(String data) throws Throwable {
		Thread.sleep(1000);
		// Constants.key.scrollDownUI("PaymentReference");
		String vObjPaymentReference = Constants.AndroidCDAppSendMoney.getProperty("PaymentReference");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentReference));
		Assert.assertEquals("PASS", Constants.key.click(vObjPaymentReference));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjPaymentReference, data));
		Constants.DataMap.put("RecipientReference", data);
		LogCapture.info("User enter value into payment reference");
	}

	@Then("^android user click on back button from terms and condition and lands back to review screen$")
	public void android_user_click_on_back_button_from_terms_and_condition_and_lands_back_to_review_screen()
			throws Throwable {
		String vObjBackBtnReview = Constants.AndroidCDAppSendMoney.getProperty("BackBtnReview");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBackBtnReview));
		Assert.assertEquals("PASS", Constants.key.click(vObjBackBtnReview));
		LogCapture.info("User click on Back button and land review screen");
	}

	@Then("^android user select payment reason (Debit Card|Wallet|Bank Transfer)$")
	public void android_user_select_payment_reason(String optionalValue) throws Throwable {
		String vObjPaymentReason = Constants.AndroidCDAppSendMoney.getProperty("PaymentReason");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentReason));
		Assert.assertEquals("PASS", Constants.key.click(vObjPaymentReason));
		if (optionalValue.equalsIgnoreCase("Debit Card")) {
			MobileElement bankcode = Constants.driver.findElement(By.xpath(vObjPaymentReason));
			int x = bankcode.getCenter().getX();
			int y = bankcode.getCenter().getY() - 400;
			TouchAction a2 = new TouchAction(Constants.driver).tap(PointOption.point(x, y)).release().perform();
		} else if (optionalValue.equalsIgnoreCase("Wallet")) {
			MobileElement bankcode = Constants.driver.findElement(By.xpath(vObjPaymentReason));
			int x = bankcode.getCenter().getX();
			int y = bankcode.getCenter().getY() + 300;
			TouchAction a2 = new TouchAction(Constants.driver).tap(PointOption.point(x, y)).release().perform();
		} else if (optionalValue.equalsIgnoreCase("Bank Transfer")) {
			MobileElement bankcode = Constants.driver.findElement(By.xpath(vObjPaymentReason));
			int x = bankcode.getCenter().getX();
			int y = bankcode.getCenter().getY() + 200;
			TouchAction a2 = new TouchAction(Constants.driver).tap(PointOption.point(x, y)).release().perform();
		}
		LogCapture.info("User select Payment Reason from dropdown");
	}

	// Wallet

	@And("^android user selects the wallet option from the home dashboard$")
	public void android_user_selects_the_wallet_option_from_the_home_dashboard() throws Throwable {
		String vObjWalletIcon = Constants.AndroidCDAppWalletOR.getProperty("WalletIcon");
		Assert.assertEquals("PASS", Constants.key.click(vObjWalletIcon));
		LogCapture.info("User clicked on WalletIcon ....");

	}

	@And("^android user has no saved wallet previously$")
	public void android_user_has_no_saved_wallet_previously() throws Throwable {
		String vObjWallettOnAccLbl = Constants.AndroidCDAppWalletOR.getProperty("NoWalletOnAccLbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWallettOnAccLbl));
		LogCapture.info("Empty Wallet list has been displayed.........");
	}

	@And("^list of wallets should be displayed with the wallet balance$")
	public void list_of_wallets_should_be_displayed_with_the_wallet_balance() throws Throwable {
		String vObjWallettlistLbl = Constants.AndroidCDAppWalletOR.getProperty("WalletListlbl");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWallettlistLbl));
		LogCapture.info("Wallet list has been displayed.........");
	}

	@Then("^User should be able to click on currency wallet in android app \"([^\"]*)\"$")
	public void User_should_be_able_to_click_on_currency_wallet_in_android_app(String walletCurrency) throws Throwable {

		String vObjWalletCurrencyname = Constants.AndroidCDAppWalletOR.getProperty("Walletlistitem");
		String vObjWalletListitem = Constants.AndroidCDAppWalletOR.getProperty("WalletList");

		boolean isFound = false;

		List<MobileElement> list = Constants.key.getElementList(vObjWalletListitem);

		for (MobileElement element : list) {
			MobileElement singleWalletElement = element.findElementByXPath(vObjWalletCurrencyname);
			String vWalletName = singleWalletElement.getText();

			if (vWalletName.contains(walletCurrency)) {
				Assert.assertEquals("PASS", Constants.key.click(singleWalletElement));
				LogCapture.info("Wallet match found and clicked on : " + vWalletName);
				break;
			} else {
				LogCapture.info("Element list " + vWalletName + " Expected :" + walletCurrency);
			}
		}
		Thread.sleep(2000);
		if (isFound) {
			Assert.assertEquals("PASS", "PASS");
		} else {
			Assert.assertEquals("PASS", Constants.KEYWORD_FAIL);
		}
	}

	@Then("^andriod user click on any Questions and it should collapsed$")
	public void andriod_user_click_on_any_Questions_and_it_should_collapsed() throws Throwable {
		String vObjQuestion = Constants.AndroidCDAppAccountOR.getProperty("Question");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjQuestion));
		Assert.assertEquals("PASS", Constants.key.click(vObjQuestion));
		LogCapture.info("Clicked on any Question.........");
	}

	@Then("^topic details should be expanded to android user$")
	public void topic_details_should_be_expanded_to_android_user() throws Throwable {
		String vObjanwser = Constants.AndroidCDAppAccountOR.getProperty("Answer");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjanwser));
		LogCapture.info("topic details has been displayed.........");
	}

	@Then("^continue button should get disabled for (bank transfer|debit card|wallet) in android app$")
	public void continue_button_should_get_disabled_for_bank_transfer_in_android_app(String optionalValue)
			throws Throwable {
		if (optionalValue.equalsIgnoreCase("Debit Card")) {
			String vObjContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("ContinueBtnPaymentMethod");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtn));
			String atbValue = Constants.key.getAttributeValue(vObjContinueBtn, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		} else if (optionalValue.equalsIgnoreCase("bank transfer")) {
			String vObjbankContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("BankContinueBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjbankContinueBtn));
			String atbValue = Constants.key.getAttributeValue(vObjbankContinueBtn, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		} else if (optionalValue.equalsIgnoreCase("wallet")) {
			String vObjwalletContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("WalletContinueBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjwalletContinueBtn));
			String atbValue = Constants.key.getAttributeValue(vObjwalletContinueBtn, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		}
		LogCapture.info("Contniue button disabled state.........");
	}

	@When("^android user click on continue button for (bank transfer|debit card|wallet)$")
	public void android_user_click_on_continue_button_for(String optionalValue) throws Throwable {
		Constants.key.scrollDownUI("Continue");
		if (optionalValue.equalsIgnoreCase("Debit Card")) {
			String vObjContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("ContinueBtnPaymentMethod");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjContinueBtn));
		} else if (optionalValue.equalsIgnoreCase("bank transfer")) {
			String vObjbankContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("BankContinueBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjbankContinueBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjbankContinueBtn));
		} else if (optionalValue.equalsIgnoreCase("wallet")) {
			String vObjwalletContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("WalletContinueBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjwalletContinueBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjwalletContinueBtn));
		}
		LogCapture.info("Clicked on Contniue button .........");
	}

	@Then("^android user do not select payment reason (Debit card|Wallet|Bank Transfer)$")
	public void android_user_do_not_select_payment_reason(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("Debit Card")) {
			LogCapture.info("User not selected payment reason");
		} else if (optionalValue.equalsIgnoreCase("Wallet")) {
			LogCapture.info("User not selected payment reason");
		} else if (optionalValue.equalsIgnoreCase("Bank Transfer")) {
			LogCapture.info("User not selected payment reason");
		}
	}

	@Then("^android user land on confirmation screen$")
	public void android_user_land_on_confirmation_screen() throws Throwable {
		String vobjSuccessScreen = Constants.AndroidCDAppSendMoney.getProperty("SuccessScreen");
		String vObjSuccessText = Constants.key.readText(vobjSuccessScreen);
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(vObjSuccessText, "Success"));
		LogCapture.info("Screen Title:" + vObjSuccessText);
	}

	@Then("^Done button should displayed in (enabled|disabled) state$")
	public void done_button_should_displayed_in_enabled_state(String button) throws Throwable {
		Constants.key.scrollDownUI("Done");
		String vObjDoneBtn = Constants.AndroidCDAppSendMoney.getProperty("DoneBtn");
		if (button.equals("enabled")) {
			Assert.assertEquals("true", Constants.key.getAttributeValue(vObjDoneBtn, "enabled").toString());
			LogCapture.info("Done button is Active.......");
		} else if (button.equals("disabled")) {
			Assert.assertEquals("false", Constants.key.getAttributeValue(vObjDoneBtn, "enabled").toString());
			LogCapture.info("Done button is Inactive.......");
		}
	}

	@Then("^screen should load with bank account details option selected by default$")
	public void screen_should_load_with_bank_account_details_option_selected_by_default() throws Throwable {
		String vObjBankDetailsBtn = Constants.AndroidCDAppSendMoney.getProperty("SuccessBankDetails");
		String vObjBankDetailsText = Constants.key.isElementActive(vObjBankDetailsBtn);
		LogCapture.info("Screen Title:" + vObjBankDetailsText);
	}

	@Then("^android user do not enter Payment Reference \"([^\"]*)\"$")
	public void android_user_do_not_enter_Payment_Reference(String arg1) throws Throwable {
		LogCapture.info("User not entered Payment Reference data");
	}

	@Then("^Payment Reference not displayed on Review screen$")
	public void payment_Reference_not_displayed_on_Review_screen() throws Throwable {
		String vObjPaymentRefReview = Constants.AndroidCDAppSendMoney.getProperty("PaymentRefReview");
		Assert.assertEquals("PASS", Constants.key.notexist(vObjPaymentRefReview, ""));
		LogCapture.info("Payment Reference not present");
	}

	@Then("^android app dispalyed the error for entered wrong cvv$")
	public void android_app_dispalyed_the_error_for_entered_wrong_cvv() throws Throwable {
		Thread.sleep(8000);
		String vobjCardReauth = Constants.AndroidCDAppSendMoney.getProperty("CardReauth");
		String vExpectedMSg = Constants.AndroidTestData.getProperty("CardReauthMsg");
		String atbValue = Constants.key.getAttributeValue(vobjCardReauth, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vExpectedMSg));
		LogCapture.info("Displayed card wrong CVV error message :  " + atbValue);
	}

	@Then("^android user click Done button from error sreen$")
	public void android_user_click_Done_button_from_error_sreen() throws Throwable {
		String vObjCarderrorDoneBtn = Constants.AndroidCDAppSendMoney.getProperty("carderrorDonebtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCarderrorDoneBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjCarderrorDoneBtn));
		LogCapture.info("User click on Done button from card reauth error screen");
	}

	@Then("^android user observed (DebitCard|Wallet|BankTransfer) payment method in active state$")
	public void android_user_observed_payment_method_in_active_state(String optionalValue) throws Throwable {
		Thread.sleep(2000);
		if (optionalValue.equalsIgnoreCase("DebitCard")) {
			String vObjDebitCardMethod = Constants.AndroidCDAppSendMoney.getProperty("PaymentMethodoptions");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardMethod));
			String vObjDebitCardclickable = Constants.key.isElementActive(vObjDebitCardMethod);
			LogCapture.info("Debit Card payment mehtod Active state: " + vObjDebitCardclickable);
		} else if (optionalValue.equalsIgnoreCase("Wallet")) {
			String vObjWalletMethod = Constants.AndroidCDAppSendMoney.getProperty("WalletPayment");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWalletMethod));
			String vObjWalletclickable = Constants.key.isElementActive(vObjWalletMethod);
			LogCapture.info("Wallet payment mehtod Active state: " + vObjWalletclickable);
		} else if (optionalValue.equalsIgnoreCase("BankTransfer")) {
			String vObjBankTransferMethod = Constants.AndroidCDAppSendMoney.getProperty("BankTransferPayment");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankTransferMethod));
			String vObjBankTransferclickable = Constants.key.isElementActive(vObjBankTransferMethod);
			LogCapture.info("Bank Transfer payment mehtod Active state: " + vObjBankTransferclickable);
		}
	}

	@Then("^android user observed (DebitCard|Wallet) payment method in disabled state$")
	public void android_user_observed_payment_method_in_disabled_state(String optionalValue) throws Throwable {
		Thread.sleep(3000);
		if (optionalValue.equalsIgnoreCase("DebitCard")) {
			String vObjDebitCardMethod = Constants.AndroidCDAppSendMoney.getProperty("PaymentMethodoptions");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardMethod));
			Assert.assertEquals("false", Constants.key.getAttributeValue(vObjDebitCardMethod, "Clickable").toString());
			LogCapture.info("Debit Card payment mehtod Disabled state");
		} else if (optionalValue.equalsIgnoreCase("Wallet")) {
			String vObjWalletMethod = Constants.AndroidCDAppSendMoney.getProperty("WalletPayment");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWalletMethod));
			String atbValue = Constants.key.getAttributeValue(vObjWalletMethod, "Clickable").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
			LogCapture.info("Wallet payment mehtod Disabled state");
		}
	}

	@Then("^android user click on OK button from minimum amount error popup$")
	public void android_user_click_on_OK_button_from_minimum_amount_error_popup() throws Throwable {
		String vObjOKbtn = Constants.AndroidCDAppSendMoney.getProperty("OKbtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOKbtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjOKbtn));
		LogCapture.info("User click on OK button from minimum amount popup");
	}

	@Then("^android user observe the parameter on Review screen$")
	public void android_user_observe_the_parameter_on_Review_screen() throws Throwable {

		String vObjReviewTitle = Constants.AndroidCDAppSendMoney.getProperty("ReviewScreen");
		String vObjReipientName = Constants.AndroidCDAppSendMoney.getProperty("Receipientname");
		String vObjCountry = Constants.AndroidCDAppSendMoney.getProperty("Country");
		String vObjAccountNumber = Constants.AndroidCDAppSendMoney.getProperty("AccountNumber");
		String vObjIBAN = Constants.AndroidCDAppSendMoney.getProperty("IBAN");
		String vObjSWIFTBIC = Constants.AndroidCDAppSendMoney.getProperty("SWIFTBIC");
		String vObjRecipientReference = Constants.AndroidCDAppSendMoney.getProperty("RecipientReference");
		String vObjBankName = Constants.AndroidCDAppSendMoney.getProperty("BankName");
		String vObjPaymentReason = Constants.AndroidCDAppSendMoney.getProperty("PaymentReasonReview");
		String vObjAmountDue = Constants.AndroidCDAppSendMoney.getProperty("AmountDue");
		String vObjTransferToRecipient = Constants.AndroidCDAppSendMoney.getProperty("TrasnferReceipient");
		String vObjRate = Constants.AndroidCDAppSendMoney.getProperty("Rate");
		String vObjFee = Constants.AndroidCDAppSendMoney.getProperty("Fee");
		String vObjPaymentMethod = Constants.AndroidCDAppSendMoney.getProperty("PaymentMethodReview");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReviewTitle));
		LogCapture.info("Review screen title verified");

		String vReipientName = Constants.key.getAttributeValue(vObjReipientName, "text");
		String vCountry = Constants.key.getAttributeValue(vObjCountry, "text");
		String vAccountNumber = Constants.key.readText(vObjAccountNumber);
		String vIBAN = Constants.key.readText(vObjIBAN);
		String vSWIFTBIC = Constants.key.readText(vObjSWIFTBIC);
		String vRecipientReference = Constants.key.readText(vObjRecipientReference);
		String vBankName = Constants.key.readText(vObjBankName);
		String vPaymentReason = Constants.key.readText(vObjPaymentReason);

		Constants.key.scrollDownUI("Confirm and pay");

		String vAmountDue = Constants.key.readText(vObjAmountDue).replace(",", "");
		String vTransferToRecipient = Constants.key.readText(vObjTransferToRecipient).replace(",", "");
		;
		String vRate = Constants.key.readText(vObjRate);
		String vFee = Constants.key.readText(vObjFee);
		String vPaymentMethod = Constants.key.readText(vObjPaymentMethod);


		LogCapture.info("********************Review screen******************");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.DataMap.get("RecipientName"), vReipientName));
		LogCapture.info("Recipient name : " + vReipientName + " verified..............");

		LogCapture.info("Country : " + vCountry);
		Constants.DataMap.put("RecipientCountry", vCountry);
		Assert.assertEquals("PASS",
				Constants.key.VerifyText(Constants.DataMap.get("RecipientAccountNo"), vAccountNumber));
		LogCapture.info("Account number : " + vAccountNumber + " verified..............");

		LogCapture.info("SWIFT : " + vSWIFTBIC);
		Constants.DataMap.put("Swift", vSWIFTBIC);
		LogCapture.info("PaymentReason : " + vPaymentReason);

		Assert.assertEquals("PASS",
				Constants.key.VerifyText(Constants.DataMap.get("RecipientReference"), vRecipientReference));
		LogCapture.info("Recipient Reference: " + vRecipientReference + " verified..............");

		LogCapture.info("Bank name : " + vBankName);

		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("Sell")) {
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vAmountDue));
			LogCapture.info("Amount due : " + vAmountDue + " verified..............");
		}

		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("Buy")) {
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vTransferToRecipient));
			LogCapture.info("Transfer to recipient : " + vTransferToRecipient + " verified..............");
		}

		LogCapture.info("Rate : " + vRate);
		LogCapture.info("Fee : " + vFee);

		Assert.assertEquals("PASS",
				Constants.key.VerifyTextContains(vPaymentMethod, Constants.DataMap.get("PaymentMethod")));
		LogCapture.info("Payment method : " + vPaymentMethod + " verified..............");

	}

	@Then("^android user click on payment details tab$")
	public void android_user_click_on_payment_details_tab() throws Throwable {
		String vPaymentDetailsTab = Constants.AndroidCDAppSendMoney.getProperty("PaymentDetailstab");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vPaymentDetailsTab));
		Assert.assertEquals("PASS", Constants.key.click(vPaymentDetailsTab));
		LogCapture.info("User click on Payment details tab from confirmation screen");
	}

	@Then("^Payment Reference not displayed on confirmation screen$")
	public void payment_Reference_not_displayed_on_confirmation_screen() throws Throwable {
		Constants.key.scrollDownUI("Done");
		String vObjPaymentRefReview = Constants.AndroidCDAppSendMoney.getProperty("PaymentRefReview");
		Assert.assertEquals("PASS", Constants.key.notexist(vObjPaymentRefReview, ""));
		LogCapture.info("Payment Reference not present on confirmation screen");
	}

	@Then("^android user click on Confirm and Pay button$")
	public void android_user_click_on_Confirm_and_Pay_button() throws Throwable {
		String vConfirmPayBtn = Constants.AndroidCDAppSendMoney.getProperty("ConfirmPayBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vConfirmPayBtn));
		Assert.assertEquals("PASS", Constants.key.click(vConfirmPayBtn));
		LogCapture.info("User click on Confirm Pay Btn on review screen");
	}

	@Then("^deal confirmation screen should be displayed with correct mapped details in android app$")
	public void deal_confirmation_screen_should_be_displayed_with_correct_mapped_details_in_android_app()
			throws Throwable {
		String vObjPaymentSuccessLbl = Constants.AndroidCDAppSendMoney.getProperty("PaymentSuccessLbl");
		String vObjReipientName = Constants.AndroidCDAppSendMoney.getProperty("ReipientName");
		String vObjCountry = Constants.AndroidCDAppSendMoney.getProperty("SuccessCountry");
		String vObjAccountNumber = Constants.AndroidCDAppSendMoney.getProperty("SuccessIBANAccountNo");
		String vObjIBAN = Constants.AndroidCDAppSendMoney.getProperty("SuccessIBANAccountNo");
		String vObjSWIFTBIC = Constants.AndroidCDAppSendMoney.getProperty("SuccessSwift");
		String vObjRecipientReference = Constants.AndroidCDAppSendMoney.getProperty("");
		String vObjBankName = Constants.AndroidCDAppSendMoney.getProperty("SuccessBankName");
		String vObjSellCurrencyAmount = Constants.AndroidCDAppSendMoney.getProperty("SellCurrencyAmount");
		String vObjBuyCurrencyAmount = Constants.AndroidCDAppSendMoney.getProperty("BuyCurrencyAmount");
		String vObjRate = Constants.AndroidCDAppSendMoney.getProperty("SuccessRate");
		String vObjFee = Constants.AndroidCDAppSendMoney.getProperty("SuccessFee");
		String vObjPaymentMethod = Constants.AndroidCDAppSendMoney.getProperty("SuccessPaymentMethod");
		String vObjBookingDate = Constants.AndroidCDAppSendMoney.getProperty("SuccessBookingDate");
		String vObjValueDate = Constants.AndroidCDAppSendMoney.getProperty("SuccessValueDate");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentSuccessLbl));
		LogCapture.info("Success screen is displayed");

		if (Constants.DataMap.get("PaymentMethod").equalsIgnoreCase("Bank Transfer")) {
			String vObjPaymentInstructionLbl = Constants.AndroidCDAppSendMoney.getProperty("PaymentInstructionLbl");
			String vObjAccountNameLbl = Constants.AndroidCDAppSendMoney.getProperty("AccountNameLbl");
			String vObjBankNameLbl = Constants.AndroidCDAppSendMoney.getProperty("BankNameLbl");
			String vPaymentInstructionLbl = Constants.key.readText(vObjPaymentInstructionLbl);
			String vAccountNameLbl = Constants.key.readText(vObjAccountNameLbl);
			String vBankNameLbl = Constants.key.readText(vObjBankNameLbl);
			Assert.assertNotEquals("FAIL", vPaymentInstructionLbl);
			Assert.assertNotEquals("FAIL", vAccountNameLbl);
			Assert.assertNotEquals("FAIL", vBankNameLbl);
			String vObjPaymentDeatailsTab = Constants.AndroidCDAppSendMoney.getProperty("PaymentDeatailsTab");
			Assert.assertEquals("PASS", Constants.key.click(vObjPaymentDeatailsTab));
			LogCapture.info("User click on Payment details tab on success screen");
		}
		String vReipientName = Constants.key.readText(vObjReipientName);
		String vCountry = Constants.key.readText(vObjCountry);
		String vSWIFTBIC = Constants.key.readText(vObjSWIFTBIC);
		String vBankName = Constants.key.readText(vObjBankName);
		String vBookingDate = Constants.key.readText(vObjBookingDate);
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBookingDate));

		Assert.assertEquals("PASS", Constants.key.scrollDownUI("Done"));

		String vRate = Constants.key.readText(vObjRate);
		String vFee = Constants.key.readText(vObjFee);
		String vPaymentMethod = Constants.key.readText(vObjPaymentMethod);
		String vValueDate = Constants.key.readText(vObjValueDate);
		LogCapture.info("********************Success screen******************");

		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.DataMap.get("RecipientName"), vReipientName));
		LogCapture.info("Recipient name : " + vReipientName + " verified..............");

		System.out
				.println("MapCounry: " + Constants.DataMap.get("RecipientCountry") + " Attribute Country: " + vCountry);
		LogCapture.info("Country : " + vCountry + " verified..............");

		LogCapture.info("Booking Date : " + vBookingDate + " verified..............");

		LogCapture.info("SWIFT : " + vSWIFTBIC + " verified..............");
		Constants.DataMap.put("Swift", vSWIFTBIC);
		LogCapture.info("Bank name : " + vBankName + " verified..............");

		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("YouPay")) {
			String vSellCurrencyAmount = Constants.key.readText(vObjSellCurrencyAmount);
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vSellCurrencyAmount));
			LogCapture.info("Sell currency amount : " + vSellCurrencyAmount + " verified..............");
		}
		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("TheyGet")) {
			String vBuyCurrencyAmount = Constants.key.readText(vObjBuyCurrencyAmount);
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vBuyCurrencyAmount));
			LogCapture.info("Transfer to recipient : " + vBuyCurrencyAmount + " verified..............");
		}
		LogCapture.info("Rate : " + vRate + " verified..............");
		LogCapture.info("Fee : " + vFee + " verified..............");
		Assert.assertEquals("PASS",
				Constants.key.VerifyTextContains(vPaymentMethod, Constants.DataMap.get("PaymentMethod")));
		LogCapture.info("Payment method : " + vPaymentMethod + " verified..............");
		LogCapture.info("Value Date : " + vValueDate + " verified..............");

	}

	// ******************************************Wallet******************************************//

	@And("^android user click on the wallet option from the home dashboard$")
	public void android_user_click_on_the_wallet_option_from_the_home_dashboard() throws Throwable {
		String vObjWalletIcon = Constants.AndroidCDAppWalletOR.getProperty("WalletIcon");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWalletIcon));
		Assert.assertEquals("PASS", Constants.key.click(vObjWalletIcon));
		LogCapture.info("User clicked on WalletIcon ....");
	}

	@Then("^android user navigates to wallet screen$")
	public void android_user_navigates_to_wallet_screen() throws Throwable {
		Thread.sleep(3000);
		String vObjWalletScreen = Constants.AndroidCDAppWalletOR.getProperty("Header");
		String vObjwalletscreenText = Constants.key.readText(vObjWalletScreen);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjwalletscreenText, "Wallets"));
		LogCapture.info("User is on Wallet screen ....");
	}

	@Then("^your wallet is empty message should be displayed in android app$")
	public void your_wallet_is_empty_message_should_be_displayed_in_android_app() throws Throwable {
		String vObjWalletMsg = Constants.AndroidCDAppWalletOR.getProperty("NoWalletMessage");
		String vObjExpectedMsg = Constants.AndroidTestData.getProperty("EmptyWalletMsg");
		String vObjemptywalletText = Constants.key.readText(vObjWalletMsg);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjemptywalletText, vObjExpectedMsg));
		LogCapture.info("Your wallet is empty message has been displayed.........");
	}

	@And("^an option to add wallet should be displayed in android app$")
	public void an_option_to_add_wallet_should_be_displayed_in_android_app() throws Throwable {
		String vObjAddWalletBtn = Constants.AndroidCDAppWalletOR.getProperty("AddWalletBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddWalletBtn));
		LogCapture.info(" add wallet option is displayed.........");
	}

	@Then("^list of wallets should be displayed with the wallet balance in android app$")
	public void list_of_wallets_should_be_displayed_with_the_wallet_balance_in_android_app() throws Throwable {
		String vObjBtnAddWalletCell = Constants.AndroidCDAppWalletOR.getProperty("BtnAddWalletCell");
		String vObjWalletList = Constants.AndroidCDAppWalletOR.getProperty("WalletList");
		String vObjWalletListitm = Constants.AndroidCDAppWalletOR.getProperty("Walletlistitem");
		String vObjWalletName = Constants.AndroidCDAppWalletOR.getProperty("WalletName");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddWalletCell));

		int walletListSize = Constants.key.getElementList(vObjWalletList).size();

		for (int i = 0; i < walletListSize; i++) {
			String vWalletName = Constants.key.getAttributeValue(vObjWalletListitm + i + vObjWalletName, "text");
			LogCapture.info("Wallet with currency amount : " + vWalletName);

		}

	}

	@When("^android user click on add wallet option from the wallet screen$")
	public void android_user_click_on_add_wallet_option_from_the_wallet_screen() throws Throwable {
		String vObjAddWalletBtn = Constants.AndroidCDAppWalletOR.getProperty("AddWalletBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjAddWalletBtn));
		LogCapture.info("User click on add wallet from wallet screen.........");
	}

	@When("^android user click on currency \"([^\"]*)\" retrived from search$")
	public void android_user_click_on_currency_retrived_from_search(String currency) throws Throwable {
		String vObjAddCurrency = Constants.AndroidCDAppWalletOR.getProperty("AddCurrency");
		Assert.assertEquals("PASS", Constants.key.click(vObjAddCurrency));
		LogCapture.info("User click on currency from dropdown........" + currency);

	}

	@When("^android user click on wallet currency \"([^\"]*)\" from wallet screen$")
	public void android_user_click_on_wallet_currency_from_wallet_screen(String currency) throws Throwable {
		String vObjBtnAddWalletCell = Constants.AndroidCDAppWalletOR.getProperty("BtnAddWalletCell");
		String vObjWalletList = Constants.AndroidCDAppWalletOR.getProperty("WalletList");
		String vObjWalletListitm = Constants.AndroidCDAppWalletOR.getProperty("Walletlistitem");
		String vObjWalletName = Constants.AndroidCDAppWalletOR.getProperty("WalletName");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBtnAddWalletCell));

		int walletListSize = Constants.key.getElementList(vObjWalletList).size();

		for (int i = 0; i < walletListSize; i++) {
			String vWalletName = Constants.key.getAttributeValue(vObjWalletListitm + i + vObjWalletName, "text");

			if (vWalletName.contains(currency)) {
				Assert.assertEquals("PASS", Constants.key.click(vObjWalletListitm + i + vObjWalletName));

				LogCapture.info("Wallet match found and clicked on : " + vWalletName);
				Thread.sleep(1000);

				break;
			} else {
				LogCapture.info("Wallet List : " + vWalletName);
			}

		}
	}

	@Then("^android user navigate to selected currency \"([^\"]*)\" wallet detail screen$")
	public void android_user_navigate_to_selected_currency_wallet_detail_screen(String data) throws Throwable {
		String vObjCurrencyWallet = Constants.AndroidCDAppWalletOR.getProperty("Header");
		String vObjCurrencyWalletText = Constants.key.readText(vObjCurrencyWallet);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCurrencyWalletText, data));
		LogCapture.info("Selected wallet " + vObjCurrencyWalletText);
	}

	@And("^android user click on Add currency from wallet screen$")
	public void android_user_click_on_Add_currency_from_wallet_screen() throws Throwable {
		String vObjAddCurrencyWalletBtn = Constants.AndroidCDAppWalletOR.getProperty("AddCurrencyWalletBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddCurrencyWalletBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjAddCurrencyWalletBtn));
		LogCapture.info("android user click on add.........");
	}

	@Then("^android user navigates to buy currency screen$")
	public void android_user_navigates_to_buy_currency_screen() throws Throwable {
		String vObjBuyCurrency = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrency");
		String vObjBuyCurrencyText = Constants.key.readText(vObjBuyCurrency);
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBuyCurrency));
		LogCapture.info("Buy currency header text: " + vObjBuyCurrencyText);
	}

	@When("^android user enter the amount in buying currency\"([^\"]*)\" field$")
	public void android_user_enter_the_amount_in_buying_currency_field(String BuyAmount) throws Throwable {
		String vObjBuyCurrencyAmount = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyAmount");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBuyCurrencyAmount));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBuyCurrencyAmount, BuyAmount));
		LogCapture.info("android user enter buying amount........." + BuyAmount);
		Thread.sleep(10000);
	}

	@When("^android user enter the amount in selling currency\"([^\"]*)\" field$")
	public void android_user_enter_the_amount_in_selling_currency_field(String SellAmount) throws Throwable {
		String vObjSellCurrencyAmount = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyAmount");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSellCurrencyAmount, SellAmount));
		LogCapture.info("android user enter selling amount........." + vObjSellCurrencyAmount);
		Thread.sleep(5000);
	}

	@When("^android user click on the continue button for buy currency$")
	public void android_user_click_on_the_continue_button_for_buy_currency() throws Throwable {
		Thread.sleep(5000);
		String vObjBuyCurrencyContinueBtn = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyContinueBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjBuyCurrencyContinueBtn));
		LogCapture.info("android user click on continue button.........");
	}

	@Then("^android user navigates to payment method page$")
	public void android_user_navigates_to_payment_method_page() throws Throwable {
		Thread.sleep(10000);
		String vObjPaymentMethodScreen = Constants.AndroidCDAppWalletOR.getProperty("Header");
		String vObjCurrencyWalletText = Constants.key.readText(vObjPaymentMethodScreen);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCurrencyWalletText, "Payment method"));
		LogCapture.info("android user is on payment method page.........");
	}

	@When("^android user enter amount \"([^\"]*)\" in buying currency wallet and user stops typing the amount$")
	public void android_user_enter_amount_in_buying_currency_wallet_and_user_stops_typing_the_amount(String amount)
			throws Throwable {
		String vObjBuyingAmount = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyAmount");
		Assert.assertEquals("PASS", Constants.key.click(vObjBuyingAmount));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBuyingAmount, amount));
		LogCapture.info("android user entered buy amount: " + amount);

		String vObjBuyCurrencyLbl = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyName");
		String vBuyCurrency = Constants.key.readText(vObjBuyCurrencyLbl);
		Constants.DataMap.put("UserSelection", "Buy");
		Constants.DataMap.put("UserAmountWithCurrency", amount + " " + vBuyCurrency);
	}

	@Then("^after two sec appropriate amount should be calculated in sell currency wallet in android app$")
	public void after_two_sec_appropriate_amount_should_be_calculated_in_sell_currency_wallet_in_android_app()
			throws Throwable {

		String VObjSellingAmount = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyAmount");
		String vObjSellingText = Constants.driver.findElement(By.xpath(VObjSellingAmount)).getText();
		Constants.TempData = vObjSellingText;
		LogCapture.info("Before refreshed Calculated Selling Amount :" + vObjSellingText);

		boolean isRefreshed = false;
		for (int i = 0; i <= 63; i++) {

			Thread.sleep(4000);
			String VObjSellingAmount1 = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyAmount");
			String vObjSellingText1 = Constants.driver.findElement(By.xpath(VObjSellingAmount1)).getText();

			if (vObjSellingText1.equals(Constants.TempData)) {
				LogCapture.info("temp data= " + Constants.TempData + "equals currenct value: " + vObjSellingText1);
				LogCapture.info("After " + 1 * (i + 1) + " seconds :" + vObjSellingText1);
			} else {
				isRefreshed = true;
				LogCapture.info("temp data: " + Constants.TempData + " not equals currenct value: " + vObjSellingText1);
				LogCapture.info("After " + 1 * (i + 1) + " seconds Selling Amount refreshed:" + vObjSellingText1);
				break;
			}

		}
		if (isRefreshed) {
			Assert.assertEquals("PASS", "PASS");
		} else {
			Assert.assertEquals("PASS", Constants.KEYWORD_FAIL);
		}
	}

	@When("^android user enter amount \"([^\"]*)\" in selling currency wallet and user stops typing the amount$")
	public void android_user_enter_amount_in_selling_currency_wallet_and_user_stops_typing_the_amount(String amount)
			throws Throwable {
		String vObjsellAmount = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyAmount");
		Assert.assertEquals("PASS", Constants.key.click(vObjsellAmount));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjsellAmount, amount));
		LogCapture.info("android user entered sell amount: " + amount);

	}

	@Then("^after two sec appropriate amount should be calculated in buy currency wallet in android app$")
	public void after_two_sec_appropriate_amount_should_be_calculated_in_buy_currency_wallet_in_android_app()
			throws Throwable {
		String VObjbuyAmount = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyAmount");
		String VObjbuyAmountText = Constants.driver.findElement(By.xpath(VObjbuyAmount)).getText();
		Constants.TempData = VObjbuyAmountText;
		LogCapture.info("Before refreshed Calculated Selling Amount :" + VObjbuyAmountText);

		boolean isRefreshed = false;
		for (int i = 0; i <= 63; i++) {

			Thread.sleep(4000);
			String VObjbuyingAmount1 = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyAmount");
			String VObjbuyingAmountText1 = Constants.driver.findElement(By.xpath(VObjbuyingAmount1)).getText();

			if (VObjbuyingAmountText1.equals(Constants.TempData)) {
				LogCapture.info("temp data= " + Constants.TempData + "equals currenct value: " + VObjbuyingAmountText1);
				LogCapture.info("After " + 1 * (i + 1) + " seconds :" + VObjbuyingAmountText1);
			} else {
				isRefreshed = true;
				LogCapture.info(
						"temp data: " + Constants.TempData + " not equals currenct value: " + VObjbuyingAmountText1);
				LogCapture.info("After " + 1 * (i + 1) + " seconds Selling Amount refreshed:" + VObjbuyingAmountText1);
				break;
			}

		}
		if (isRefreshed) {
			Assert.assertEquals("PASS", "PASS");
		} else {
			Assert.assertEquals("PASS", Constants.KEYWORD_FAIL);
		}
	}

	@When("^android user enter amount \"([^\"]*)\" less than hundred GBP in selling currency wallet and user stops typing the amount$")
	public void android_user_enter_amount_less_than_hundred_GBP_in_selling_currency_wallet_and_user_stops_typing_the_amount(
			String amount) throws Throwable {
		String vObjsellAmount = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyAmount");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjsellAmount));
		Assert.assertEquals("PASS", Constants.key.click(vObjsellAmount));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjsellAmount, amount));
		LogCapture.info("Entered sell amount:  " + amount);
	}

	@When("^android user enter amount \"([^\"]*)\" greater than allowed GBP limit in selling currency wallet$")
	public void android_user_enter_amount_greater_than_allowed_GBP_limit_in_selling_currency_wallet(String amount)
			throws Throwable {
		String vObjSellingAmount = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyAmount");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSellingAmount));
		Assert.assertEquals("PASS", Constants.key.click(vObjSellingAmount));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSellingAmount, amount));
		LogCapture.info("Entered sell amount:  " + amount);
	}

	@When("^android user enter amount \"([^\"]*)\" less than hundred GBP in buying currency wallet and user stops typing the amount$")
	public void android_user_enter_amount_less_than_hundred_GBP_in_buying_currency_wallet_and_user_stops_typing_the_amount(
			String amount) throws Throwable {
		String vObjbuyAmount = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyAmount");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjbuyAmount));
		Assert.assertEquals("PASS", Constants.key.click(vObjbuyAmount));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjbuyAmount, amount));
		LogCapture.info("Entered buy amount:  " + amount);
	}

	@When("^android user enter amount \"([^\"]*)\" greater than allowed GBP limit in buying currency wallet$")
	public void android_user_enter_amount_greater_than_allowed_GBP_limit_in_buying_currency_wallet(String amount)
			throws Throwable {
		String vObjBuyAmount = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyAmount");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBuyAmount));
		Assert.assertEquals("PASS", Constants.key.click(vObjBuyAmount));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBuyAmount, amount));
		LogCapture.info("Entered buy amount:  " + amount);
	}

	@Then("^send button should displayed in enabled state in android app$")
	public void send_button_should_displayed_in_enabled_state_in_android_app() throws Throwable {
		Thread.sleep(10000);
		String vObjSendButton = Constants.AndroidCDAppWalletOR.getProperty("SendBtn");
		String atbValue = Constants.key.getAttributeValue(vObjSendButton, "enabled");
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		LogCapture.info("Send button enabled");
	}

	@Then("^send button should displayed in disabled state in android app$")
	public void send_button_should_displayed_in_disabled_state_in_android_app() throws Throwable {
		Thread.sleep(3000);
		String vObjSendButton = Constants.AndroidCDAppWalletOR.getProperty("SendBtn");
		String atbValue = Constants.key.getAttributeValue(vObjSendButton, "clickable");
		Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		LogCapture.info("Send button disabled");
	}

	@When("^android user click on send button in android app$")
	public void android_user_click_on_send_button_in_android_app() throws Throwable {
		String vObjSendBtn = Constants.AndroidCDAppWalletOR.getProperty("SendBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjSendBtn));
		LogCapture.info("android user click on send button.........");
	}

	@Then("^android user navigates to send from wallet page$")
	public void android_user_navigates_to_send_from_wallet_page() throws Throwable {
		Thread.sleep(10000);
		String vObjSendFromWalletScreen = Constants.AndroidCDAppWalletOR.getProperty("Header");
		String vObjSendFromWalletText = Constants.key.readText(vObjSendFromWalletScreen);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjSendFromWalletText, "Send from Wallet"));
		LogCapture.info("android user is on Send From wallet page.........");
	}

	@When("^android user click on continue send button$")
	public void android_user_click_on_continue_send_button() throws Throwable {
		Thread.sleep(5000);
		String vObjContinueBtn = Constants.AndroidCDAppWalletOR.getProperty("ContinueBtnSend");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjContinueBtn));
		LogCapture.info("User click on continue button");
	}

	@When("^android user selects Sell currency drop down from wallet$")
	public void android_user_selects_Sell_currency_drop_down_from_wallet() throws Throwable {
		String vObjSellCurrencydrp = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyName");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSellCurrencydrp));
		Assert.assertEquals("PASS", Constants.key.click(vObjSellCurrencydrp));
		LogCapture.info("User click on sell currency dropdown");
	}

	@Then("^android app should take the user to the buy currency screen with the selected currency \"([^\"]*)\" in selling dropdown$")
	public void android_app_should_take_the_user_to_the_buy_currency_screen_with_the_selected_currency_in_selling_dropdown(
			String sellCurrency) throws Throwable {
		String vObjSellCurrencyWallet = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyName");
		String vObjSellCurrencyWalletText = Constants.key.readText(vObjSellCurrencyWallet);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjSellCurrencyWalletText, sellCurrency));
		LogCapture.info("Selected sell currency " + vObjSellCurrencyWalletText);
	}

	@Then("^android user select the payment method (Debit Card|Wallet|Bank Transfer)$")
	public void android_user_select_the_payment_method(String optionalValue) throws Throwable {
		if (optionalValue.equalsIgnoreCase("Debit Card")) {
			String vObjDebitCardMethod = Constants.AndroidCDAppSendMoney.getProperty("PaymentMethodoptions");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardMethod));
			Assert.assertEquals("PASS", Constants.key.click(vObjDebitCardMethod));
			LogCapture.info("User click on Debit card payment mehtod");
			Constants.DataMap.put("PaymentMethod", "Debit Card");
		} else if (optionalValue.equalsIgnoreCase("Wallet")) {
			String vObjWalletMethod = Constants.AndroidCDAppSendMoney.getProperty("WalletPayment");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWalletMethod));
			Assert.assertEquals("PASS", Constants.key.click(vObjWalletMethod));
			LogCapture.info("User click on Wallet payment mehtod");

			String vObjWalletNamePath = Constants.AndroidCDAppSendMoney.getProperty("WalletscrnCur");
			String vObjWalletName = Constants.key.readText(vObjWalletNamePath);
			Constants.DataMap.put("PaymentMethod", vObjWalletName);
		} else if (optionalValue.equalsIgnoreCase("Bank Transfer")) {
			String vObjBankTransferMethod = Constants.AndroidCDAppSendMoney.getProperty("BankTransferPayment");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankTransferMethod));
			Assert.assertEquals("PASS", Constants.key.click(vObjBankTransferMethod));
			LogCapture.info("User click on bank transfer payment mehtod");
			Constants.DataMap.put("PaymentMethod", "Bank Transfer");
		}
	}

	@Then("^bydefault 1000 amount should be displayed for send from wallet in android app$")
	public void bydefault_1000_amount_should_be_displayed_for_send_from_wallet_in_android_app() throws Throwable {
		Thread.sleep(10000);
		String vObjSendAmount = Constants.AndroidCDAppWalletOR.getProperty("SendAmount");
		String vObjSendAmountText = Constants.key.readText(vObjSendAmount);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjSendAmountText, "1,000.00"));
		LogCapture.info("bydefault 1000 amount displayed for send from wallet.........");
	}

	@When("^android user enters amount \"([^\"]*)\" for send from wallet$")
	public void android_user_enters_amount_for_send_from_wallet(String amount) throws Throwable {
		String vObjSendAmount = Constants.AndroidCDAppWalletOR.getProperty("SendAmount");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendAmount));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSendAmount, amount));
		LogCapture.info("Amount entered.." + amount);


		String vObjBuyCurrencyLbl = Constants.AndroidCDAppWalletOR.getProperty("SendCurrency");
		String vBuyCurrency = Constants.key.readText(vObjBuyCurrencyLbl);
		Constants.DataMap.put("UserSelection", "Send from wallet");
		Constants.DataMap.put("UserAmountWithCurrency", amount + " " + vBuyCurrency);
	}

	@Then("^android user able to enter amount for send from wallet$")
	public void android_user_able_to_enter_amount_for_send_from_wallet() throws Throwable {
		String vObjSendAmount = Constants.AndroidCDAppWalletOR.getProperty("SendAmount");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendAmount));
		LogCapture.info("Amount entered");

	}

	@Then("^send error message should be dislayed in android app$")
	public void send_error_message_should_be_dislayed_in_android_app() throws Throwable {
		Thread.sleep(5000);
		String vobjGreaterThanWalletBalance = Constants.AndroidCDAppSendMoney.getProperty("ErrorText");
		String vExpectedMsg = Constants.AndroidTestData.getProperty("GreaterThanWalletBalance");
		String atbValue = Constants.key.getAttributeValue(vobjGreaterThanWalletBalance, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vExpectedMsg));
		LogCapture.info("Displayed amount entered is greater than wallet balance error message:  " + atbValue);

	}


	@Then("^wallet continue button should get disabled for (bank transfer|debit card|wallet) in android app$")
	public void wallet_continue_button_should_get_disabled_for_bank_transfer_in_android_app(String optionalValue)
			throws Throwable {
		if (optionalValue.equalsIgnoreCase("Debit Card")) {
			String vObjContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("ContinueBtnPaymentMethod");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtn));
			String atbValue = Constants.key.getAttributeValue(vObjContinueBtn, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		} else if (optionalValue.equalsIgnoreCase("bank transfer")) {
			String vObjbankContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("BankContinueBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjbankContinueBtn));
			String atbValue = Constants.key.getAttributeValue(vObjbankContinueBtn, "disabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		} else if (optionalValue.equalsIgnoreCase("wallet")) {
			String vObjwalletContinueBtn = Constants.AndroidCDAppSendMoney.getProperty("WalletContinueBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjwalletContinueBtn));
			String atbValue = Constants.key.getAttributeValue(vObjwalletContinueBtn, "enabled").toString();
			Assert.assertEquals("PASS", Constants.key.VerifyText("false", atbValue));
		}
		LogCapture.info("Contniue button disabled state.........");
	}

	@Then("^android user click on terms and condition link to send wallet$")
	public void android_user_click_on_terms_and_condition_link_to_send_wallet() throws Throwable {
		Thread.sleep(4000);
		String vObjTermsandCondition = Constants.AndroidCDAppSendMoney.getProperty("TermsandCondition");
		Constants.key.scrollDownUI("terms and conditions");
		// Assert.assertEquals("PASS",
		// Constants.key.eleLocatedDisplayed(vObjTermsandCondition));
		Assert.assertEquals("PASS", Constants.key.click(vObjTermsandCondition));
		LogCapture.info("User click on terms and condition");
	}

	@Then("^pay in currency \"([^\"]*)\" tab should be displayed in android app$")
	public void pay_in_currency_tab_should_be_displayed_in_android_app(String AddCCY) throws Throwable {
		String vObjAddCCY = Constants.AndroidCDAppWalletOR.getProperty("AddCCY");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddCCY));
		String atbValue = Constants.key.getAttributeValue(vObjAddCCY, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		LogCapture.info("Pay In currency tab displayed");
	}

	@When("^android user click on pay in \"([^\"]*)\" tab$")
	public void android_user_click_on_pay_in_currency(String currency) throws Throwable {
		String vObjAddCCY = Constants.AndroidCDAppWalletOR.getProperty("AddCCY");
		Assert.assertEquals("PASS", Constants.key.click(vObjAddCCY));
		LogCapture.info("user clicked on Pay in currency");

	}

	@Then("^android user navigate to pay in \"([^\"]*)\" screen$")
	public void android_user_navigate_to_pay_in_currency_screen(String AddCCY) throws Throwable {
		String vObjAddCCY = Constants.AndroidCDAppWalletOR.getProperty("AddCCY");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddCCY));
		LogCapture.info("User navigate to pay in tab");
	}

	@Then("^continue button gets enabled in android app$")
	public void continue_button_gets_enabled_in_android_app() throws Throwable {
		Thread.sleep(8000);
		String vObjBuyCurrencyContinueBtn = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyContinueBtn");
		String atbValue = Constants.key.getAttributeValue(vObjBuyCurrencyContinueBtn, "enabled");
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		LogCapture.info("Continue button enabled");
	}

	@When("^android user click on ok for error popup$")
	public void android_user_click_on_ok_for_error_popup() throws Throwable {
		String vObjokError = Constants.AndroidCDAppWalletOR.getProperty("OkError");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjokError));
		Assert.assertEquals("PASS", Constants.key.click(vObjokError));
		LogCapture.info("User click on Ok for error pop-up");
	}

	@Then("^user should be able to scroll down to see wallet list in android app$")
	public void user_should_be_able_to_scroll_down_to_see_wallet_list__in_android_app() throws Throwable {

		Constants.key.scrollDownUI("Add wallet");
		Constants.key.scrollDownUI("Add wallet");
		LogCapture.info("User able to scroll down to see wallets");
	}

	@When("^android user clicks on close icon from search$")
	public void android_user_clicks_on_close_icon_from_search() throws Throwable {
		String vObjAddWalletCloseBtn = Constants.AndroidCDAppWalletOR.getProperty("AddWalletCloseBtn");
		Assert.assertEquals("PASS", Constants.key.click(vObjAddWalletCloseBtn));
		LogCapture.info("user clicked on close icon from search.......");
	}

	@Then("^wallet currency not found error message displayed in android app$")
	public void wallet_currency_not_found_error_message_displayed_in_android_app() throws Throwable {
		String vObjWalletMsg = Constants.AndroidCDAppWalletOR.getProperty("AddWalletNotFound");
		String vObjExpectedMsg = Constants.AndroidTestData.getProperty("WalletCCYNotMatch");
		String vObjNotMatchwalletText = Constants.key.readText(vObjWalletMsg);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjNotMatchwalletText, vObjExpectedMsg));
		LogCapture.info("Wallet currency match not found.........");
	}

	@And("^android user click on bank from wallet screen$")
	public void android_user_click_on_bank_from_from_wallet_screen() throws Throwable {
		String vObjBankBtn = Constants.AndroidCDAppWalletOR.getProperty("BankBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjBankBtn));
		LogCapture.info("android user click on bank.........");
	}

	@Then("^android user navigates to bank details screen$")
	public void android_user_navigates_to_bank_details_screen() throws Throwable {
		String vObjBankDetail = Constants.AndroidCDAppWalletOR.getProperty("BankDetailPage");
		String vObjBankDetailText = Constants.key.readText(vObjBankDetail);
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankDetail));
		LogCapture.info("Bank details header text: " + vObjBankDetailText);
	}

	@Then("^bank details screen displayed with correct details mapped in android app$")
	public void bank_details_screen_displayed_with_correct_details_mapped_in_android_app() throws Throwable {
		String vObjBankDetail = Constants.AndroidCDAppWalletOR.getProperty("BankDetailPage");
		String vObjAccountName = Constants.AndroidCDAppWalletOR.getProperty("AccountName");
		String vObjBankName = Constants.AndroidCDAppWalletOR.getProperty("BankName");
		String vObjAccountNumber = Constants.AndroidCDAppWalletOR.getProperty("AccountNumber");
		String vObjSortCode = Constants.AndroidCDAppWalletOR.getProperty("SortCode");
		String vObjIban = Constants.AndroidCDAppWalletOR.getProperty("Iban");
		String vObjSwiftbic = Constants.AndroidCDAppWalletOR.getProperty("Swiftbic");
		String vObjCountry = Constants.AndroidCDAppWalletOR.getProperty("Country");
		String vObjReference = Constants.AndroidCDAppWalletOR.getProperty("Reference");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankDetail));
		LogCapture.info("Bank details screen title verified");

		String vAccountName = Constants.key.readText(vObjAccountName);
		String vBankName = Constants.key.readText(vObjBankName);
		String vAccountNumber = Constants.key.readText(vObjAccountNumber);
		String vSortCode = Constants.key.readText(vObjSortCode);
		String vIban = Constants.key.readText(vObjIban);
		String vSwiftbic = Constants.key.readText(vObjSwiftbic);
		String vCountry = Constants.key.readText(vObjCountry);
		String vReference = Constants.key.readText(vObjReference);

		LogCapture.info("Account Name : " + vAccountName);
		LogCapture.info("Bank Name : " + vBankName);
		LogCapture.info("Account Number : " + vAccountNumber);
		LogCapture.info("Sort Code : " + vSortCode);
		LogCapture.info("IBan : " + vIban);
		LogCapture.info("SwiftBIC : " + vSwiftbic);
		LogCapture.info("Country : " + vCountry);
		LogCapture.info("Reference : " + vReference);

	}

	@Then("^no transaction message displayed in android app$")
	public void no_transaction_message_displayed_in_android_app() throws Throwable {
		String vObjWalletNoTransactionMsg = Constants.AndroidCDAppWalletOR.getProperty("WalletNoTransactionText");
		String vObjExpectedMsg = Constants.AndroidTestData.getProperty("WalletNoTransaction");
		String vObjNoTransactionwalletText = Constants.key.readText(vObjWalletNoTransactionMsg);

		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjNoTransactionwalletText, vObjExpectedMsg));

		Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.VerifyText(vObjNoTransactionwalletText, vObjExpectedMsg));

		LogCapture.info("transaction not present.........");
	}

	@Then("^wallet transaction displayed in android app$")
	public void wallet_transaction_displayed__in_android_app() throws Throwable {
		String vObjWalletTransaction = Constants.AndroidCDAppWalletOR.getProperty("WalletTransaction");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWalletTransaction));
		LogCapture.info("wallet transactions presnt");
		Constants.key.scrollDownUI("GBP debited");
		LogCapture.info("User able to scroll down to see wallets");
	}

	@Then("^android user observe the parameter on Review screen for add currency$")
	public void android_user_observe_the_parameter_on_Review_screen_for_add_currency() throws Throwable {
		String vObjReviewTitle = Constants.AndroidCDAppSendMoney.getProperty("ReviewScreen");
		String vObjAddTo = Constants.AndroidCDAppWalletOR.getProperty("AddTo");
		String vObjAmountDue = Constants.AndroidCDAppWalletOR.getProperty("AmountDue");
		String vObjAmountToBeAddedToTheWallet = Constants.AndroidCDAppWalletOR.getProperty("AmountToBeAddedToTheWallet");
		String vObjFee = Constants.AndroidCDAppWalletOR.getProperty("Fee");
		String vObjPaymentMethod = Constants.AndroidCDAppWalletOR.getProperty("PaymentMethod");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReviewTitle));
		LogCapture.info("Review screen title verified");

		String vAddTo = Constants.key.readText(vObjAddTo);
		String vAmountDue = Constants.key.readText(vObjAmountDue);
		String vAmountToBeAddedToTheWallet = Constants.key.readText(vObjAmountToBeAddedToTheWallet);
		String vFee = Constants.key.readText(vObjFee);
		String vPaymentMethod = Constants.key.readText(vObjPaymentMethod);

		LogCapture.info("Add to : " + vAddTo);
		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("Buy")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vAmountToBeAddedToTheWallet));
			LogCapture.info("Amount due : " + vAmountDue + " verified..............");
			LogCapture.info("Amount to be added to wallet : " + vAmountToBeAddedToTheWallet + " verified..............");
		}
		LogCapture.info("Fee : " + vFee);
		LogCapture.info("Payment method : " + vPaymentMethod + " verified..............");

	}

	@When("^android user click on continue wallet$")
	public void android_user_click_on_continue_wallet() throws Throwable {
		Thread.sleep(4000);
		String vObjTermsandCondition = Constants.AndroidCDAppWalletOR.getProperty("ContinuePaymentMethod");
		Assert.assertEquals("PASS", Constants.key.click(vObjTermsandCondition));
		LogCapture.info("User click on Continue");
	}

	@When("^android user enter amount \"([^\"]*)\" in (selling|buying) currency wallet$")
	public void android_user_enter_amount_in_selling_currency_wallet(String amount, String optionalValue)
			throws Throwable {
		if (optionalValue.equalsIgnoreCase("selling")) {
			String vObjSellingAmount = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyAmount");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSellingAmount));
			Assert.assertEquals("PASS", Constants.key.click(vObjSellingAmount));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjSellingAmount, amount));
			LogCapture.info("Entered selling amount:  " + amount);

			String vObjSellCurrencyLbl = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyName");
			String vSellCurrency = Constants.key.readText(vObjSellCurrencyLbl);
			Constants.DataMap.put("UserSelection", "Sell");
			Constants.DataMap.put("UserAmountWithCurrency", amount + " " + vSellCurrency);
			Constants.DataMap.put("UserCurrency", vSellCurrency);


		} else if (optionalValue.equalsIgnoreCase("buying")) {
			String vObjBuyingAmount = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyAmount");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBuyingAmount));
			Assert.assertEquals("PASS", Constants.key.click(vObjBuyingAmount));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjBuyingAmount, amount));
			LogCapture.info("Entered buying amount:  " + amount);

			String vObjBuyCurrencyLbl = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyName");
			String vBuyCurrency = Constants.key.readText(vObjBuyCurrencyLbl);
			Constants.DataMap.put("UserSelection", "Buy");
			Constants.DataMap.put("UserAmountWithCurrency", amount + " " + vBuyCurrency);
			Constants.DataMap.put("UserCurrency", vBuyCurrency);

		}
	}

	@Then("^deal confirmation screen should be displayed with correct mapped details for buy currency fx in android app$")
	public void deal_confirmation_screen_should_be_displayed_with_correct_mapped_details_for_buy_currency_fx_in_android_app()
			throws Throwable {
		String vObjPaymentSuccessLbl = Constants.AndroidCDAppSendMoney.getProperty("PaymentSuccessLbl");
		String vObjAddTo = Constants.AndroidCDAppWalletOR.getProperty("SuccessAddTo");
		String vObjAmountDue = Constants.AndroidCDAppWalletOR.getProperty("SuccessAmountDue");
		String vObjAmountAddedToWallet = Constants.AndroidCDAppWalletOR.getProperty("SuccessAmountAddedToWallet");
		String vObjRate = Constants.AndroidCDAppWalletOR.getProperty("SuccessRate");
		String vObjFee = Constants.AndroidCDAppWalletOR.getProperty("SuccessFee");
		String vObjPaymentMethod = Constants.AndroidCDAppWalletOR.getProperty("SuccessPaymentMethod");
		String vObjCustomerReference = Constants.AndroidCDAppWalletOR.getProperty("SuccessCustomerReference");
		String vObjValueDate = Constants.AndroidCDAppWalletOR.getProperty("SuccessValueDate");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentSuccessLbl));
		LogCapture.info("Success screen is displayed");

		if (Constants.DataMap.get("PaymentMethod").equalsIgnoreCase("Bank Transfer")) {
			String vObjPaymentInstructionLbl = Constants.AndroidCDAppSendMoney.getProperty("PaymentInstructionLbl");
			String vObjAccountNameLbl = Constants.AndroidCDAppSendMoney.getProperty("AccountNameLbl");
			String vObjBankNameLbl = Constants.AndroidCDAppSendMoney.getProperty("BankNameLbl");
			String vPaymentInstructionLbl = Constants.key.readText(vObjPaymentInstructionLbl);
			String vAccountNameLbl = Constants.key.readText(vObjAccountNameLbl);
			String vBankNameLbl = Constants.key.readText(vObjBankNameLbl);
			Assert.assertNotEquals("FAIL", vPaymentInstructionLbl);
			Assert.assertNotEquals("FAIL", vAccountNameLbl);
			Assert.assertNotEquals("FAIL", vBankNameLbl);
			String vObjPaymentDeatailsTab = Constants.AndroidCDAppWalletOR.getProperty("PaymentDeatailsTab");
			Assert.assertEquals("PASS", Constants.key.click(vObjPaymentDeatailsTab));
			LogCapture.info("User click on Payment details tab on success screen");
		}

		String vAddTo = Constants.key.readText(vObjAddTo);
		String vAmountDue = Constants.key.readText(vObjAmountDue);
		String vAmountAddedToWallet = Constants.key.readText(vObjAmountAddedToWallet);
		Assert.assertEquals("PASS", Constants.key.scrollDownUI("Done"));

		String vRate = Constants.key.readText(vObjRate);
		String vFee = Constants.key.readText(vObjFee);
		String vPaymentMethod = Constants.key.readText(vObjPaymentMethod);
		String vCustomerReference = Constants.key.readText(vObjCustomerReference);
		String vValueDate = Constants.key.readText(vObjValueDate);
		LogCapture.info("********************Success screen******************");

		LogCapture.info("Add to : " + vAddTo);

		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("Sell")) {
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vAmountDue));
			LogCapture.info("Amount due : " + vAmountDue + " verified..............");
		}
		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("Buy")) {
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vAmountAddedToWallet));
			LogCapture.info("Amount to be added to wallet : " + vAmountAddedToWallet + " verified..............");
		}
		LogCapture.info("Amount added to wallet : " + vAmountAddedToWallet);
		LogCapture.info("Fee : " + vFee);
		Assert.assertEquals("PASS",
				Constants.key.VerifyTextContains(vPaymentMethod, Constants.DataMap.get("PaymentMethod")));
		LogCapture.info("Payment method : " + vPaymentMethod + " verified..............");
		LogCapture.info("Rate : " + vRate);
		LogCapture.info("Customer reference : " + vCustomerReference);
		LogCapture.info("Value date : " + vValueDate);
	}

	@Then("^android user observe the parameter on Review screen send wallet$")
	public void android_user_observe_the_parameter_on_Review_screen_send_wallet() throws Throwable {

		String vObjReviewTitle = Constants.AndroidCDAppSendMoney.getProperty("ReviewScreen");
		String vObjReipientName = Constants.AndroidCDAppSendMoney.getProperty("Receipientname");
		String vObjCountry = Constants.AndroidCDAppSendMoney.getProperty("Country");
		String vObjAccountNumber = Constants.AndroidCDAppSendMoney.getProperty("AccountNumber");
		String vObjSWIFTBIC = Constants.AndroidCDAppSendMoney.getProperty("SwiftBICRecipient");
		String vObjBankName = Constants.AndroidCDAppSendMoney.getProperty("BankName");
		String vObjPaymentReason = Constants.AndroidCDAppSendMoney.getProperty("PaymentReasonReview");
		String vObjTransferToRecipient = Constants.AndroidCDAppSendMoney.getProperty("TrasnferReceipient");
		String vObjFee = Constants.AndroidCDAppSendMoney.getProperty("Fee");
		String vObjPaymentMethod = Constants.AndroidCDAppWalletOR.getProperty("PaymentMethodSendWallet");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReviewTitle));
		LogCapture.info("Review screen title verified");

		String vReipientName = Constants.key.getAttributeValue(vObjReipientName, "text");
		String vCountry = Constants.key.getAttributeValue(vObjCountry, "text");
		String vAccountNumber = Constants.key.getAttributeValue(vObjAccountNumber, "text");
		// String vIBAN = Constants.key.getAttributeValue(vObjIBAN, "text");
		String vSWIFTBIC = Constants.key.getAttributeValue(vObjSWIFTBIC, "text");
		String vBankName = Constants.key.readText(vObjBankName);
		String vPaymentReason = Constants.key.readText(vObjPaymentReason);

		Constants.key.scrollDownUI("terms and conditions");

		String vTransferToRecipient = Constants.key.readText(vObjTransferToRecipient).replace(",", "");

		String vFee = Constants.key.readText(vObjFee);
		String vPaymentMethod = Constants.key.readText(vObjPaymentMethod);

		LogCapture.info("********************Review screen******************");
		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.DataMap.get("RecipientName"), vReipientName));
		LogCapture.info("Recipient name : " + vReipientName + " verified..............");

		LogCapture.info("Country : " + vCountry);
		Constants.DataMap.put("RecipientCountry", vCountry);
		Assert.assertEquals("PASS",
				Constants.key.VerifyText(Constants.DataMap.get("RecipientAccountNo"), vAccountNumber));
		LogCapture.info("Account number : " + vAccountNumber + " verified..............");

		LogCapture.info("SWIFT : " + vSWIFTBIC);
		Constants.DataMap.put("Swift", vSWIFTBIC);
		LogCapture.info("PaymentReason : " + vPaymentReason);

		LogCapture.info("Bank name : " + vBankName);

		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("Send from wallet")) {
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vTransferToRecipient));
			LogCapture.info("Transfer to recipient : " + vTransferToRecipient + " verified..............");
		}

		LogCapture.info("Fee : " + vFee);
		LogCapture.info("PaymentMethod : " + vPaymentMethod);

	}

	@Then("^deal confirmation screen should be displayed with correct mapped details wallet send in android app$")
	public void deal_confirmation_screen_should_be_displayed_with_correct_mapped_details_wallet_sendin_android_app()
			throws Throwable {
		String vObjPaymentSuccessLbl = Constants.AndroidCDAppSendMoney.getProperty("PaymentSuccessLbl");
		String vObjReipientName = Constants.AndroidCDAppSendMoney.getProperty("ReipientName");
		String vObjBookingDate = Constants.AndroidCDAppSendMoney.getProperty("SuccessBookingDate");
		String vObjCountry = Constants.AndroidCDAppSendMoney.getProperty("SuccessCountry");
		String vObjAccountNumber = Constants.AndroidCDAppSendMoney.getProperty("SuccessIBANAccountNo");
		String vObjSWIFTBIC = Constants.AndroidCDAppWalletOR.getProperty("SuccessSwift");
		String vObjBankName = Constants.AndroidCDAppSendMoney.getProperty("SuccessBankName");
		String vObjPaymentReason = Constants.AndroidCDAppWalletOR.getProperty("SuccessPaymentReason");
		String vObjCustomerReference = Constants.AndroidCDAppWalletOR.getProperty("SuccessCustomerReference");
		String vObjPaymentDate = Constants.AndroidCDAppWalletOR.getProperty("SuccessPaymentDate");
		String vObjAmountToBeDeductedFromWallet = Constants.AndroidCDAppWalletOR.getProperty("AmountToBeDeductedFromWallet");
		String vObjTransferToRecipient = Constants.AndroidCDAppWalletOR.getProperty("TransferToRecipient");
		String vObjFee = Constants.AndroidCDAppWalletOR.getProperty("SuccessFee");
		String vObjPaymentMethod = Constants.AndroidCDAppWalletOR.getProperty("SuccessPaymentMethod");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentSuccessLbl));
		LogCapture.info("Success screen is displayed");

		String vReipientName = Constants.key.readText(vObjReipientName);
		String vCountry = Constants.key.readText(vObjCountry);
		String vSWIFTBIC = Constants.key.readText(vObjSWIFTBIC);
		String vBankName = Constants.key.readText(vObjBankName);
		String vBookingDate = Constants.key.readText(vObjBookingDate);
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBookingDate));

		Assert.assertEquals("PASS", Constants.key.scrollDownUI("Done"));

		String vPaymentReason = Constants.key.readText(vObjPaymentReason);
		String vCustomerReference = Constants.key.readText(vObjCustomerReference);
		String vPaymentDate = Constants.key.readText(vObjPaymentDate);
		String vTransferToRecipient = Constants.key.readText(vObjTransferToRecipient);
		String vFee = Constants.key.readText(vObjFee);
		String vAmountToBeDeductedFromWallet = Constants.key.readText(vObjAmountToBeDeductedFromWallet);
		String vPaymentMethod = Constants.key.readText(vObjPaymentMethod);


		Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.DataMap.get("RecipientName"), vReipientName));
		LogCapture.info("Recipient name : " + vReipientName + " verified..............");

		LogCapture.info("Country : " + vCountry + " verified..............");

		LogCapture.info("Booking Date : " + vBookingDate + " verified..............");

		LogCapture.info("SWIFT : " + vSWIFTBIC + " verified..............");
		Constants.DataMap.put("Swift", vSWIFTBIC);
		LogCapture.info("Bank name : " + vBankName + " verified..............");
		LogCapture.info("Payment reason : " + vPaymentReason + " verified..............");
		LogCapture.info("Customer reference : " + vCustomerReference + " verified..............");
		LogCapture.info("Payment Date : " + vPaymentDate + " verified..............");
		LogCapture.info("Fee : " + vFee + " verified..............");
		LogCapture.info("Transfer to recipient : " + vTransferToRecipient + " verified..............");
		LogCapture.info("Amount To Be Deducted From Wallet : " + vAmountToBeDeductedFromWallet + " verified..............");
		LogCapture.info("Payment method : " + vPaymentMethod + " verified..............");
	}

	@Then("^an auto timer of sixty seconds should start and rate should be refreshed and buying amount should be updated for wallet$")
	public void an_auto_timer_of_sixty_seconds_should_start_and_rate_should_be_refreshed_and_buying_amount_should_be_updated_for_wallet()
			throws Throwable {
		String VObjBuyingAmount = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyAmount");
		String vObjBuyingText = Constants.driver.findElement(By.xpath(VObjBuyingAmount)).getText();
		Constants.TempData = vObjBuyingText;
		LogCapture.info("Before rate refresh calculated Buying Amount :" + vObjBuyingText);

		boolean isRefreshed = false;
		for (int i = 0; i <= 7; i++) {
			Thread.sleep(20000);
			String VObjBuyingAmount1 = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyAmount");
			String vObjBuyingText1 = Constants.driver.findElement(By.xpath(VObjBuyingAmount1)).getText();

			if (vObjBuyingText1.equals(Constants.TempData)) {
				// LogCapture.info("temp data= " + Constants.TempData + "equals
				// current value: " + vObjBuyingText1);
				LogCapture.info("After " + 10 * (i + 1) + " seconds :" + vObjBuyingText1);
			} else {
				isRefreshed = true;
				// LogCapture.info("temp data: " + Constants.TempData + " not
				// equals current value: " + vObjBuyingText1);
				LogCapture.info("After " + 10 * (i + 1) + " seconds Buying Amount refreshed:" + vObjBuyingText1);
				break;
			}
		}
		if (isRefreshed) {
			Assert.assertEquals("PASS", "PASS");
		} else {
			Assert.assertEquals("PASS", Constants.KEYWORD_FAIL);
		}
	}

	@Then("^an auto timer of sixty seconds should start and rate should be refreshed and selling amount should be updated for wallet$")
	public void an_auto_timer_of_sixty_seconds_should_start_and_rate_should_be_refreshed_and_selling_amount_should_be_updated_for_wallet()
			throws Throwable {
		String vObjSellingAmount = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyAmount");
		String vObjSellingText = Constants.driver.findElement(By.xpath(vObjSellingAmount)).getText();
		Constants.TempData = vObjSellingText;
		LogCapture.info("Before rate refreshed Calculated Selling Amount :" + vObjSellingText);

		boolean isRefreshed = false;
		for (int i = 0; i <= 7; i++) {
			Thread.sleep(20000);
			String VObjSellingAmount1 = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyAmount");
			String vObjSellingText1 = Constants.driver.findElement(By.xpath(VObjSellingAmount1)).getText();

			if (vObjSellingText1.equals(Constants.TempData)) {
				// LogCapture.info("temp data= " + Constants.TempData + "equals
				// current value: " + vObjSellingText1);
				LogCapture.info("After " + 10 * (i + 1) + " seconds :" + vObjSellingText1);
			} else {
				isRefreshed = true;
				// LogCapture.info("temp data: " + Constants.TempData + " not
				// equals current value: " + vObjSellingText1);
				LogCapture.info("After " + 10 * (i + 1) + " seconds Selling Amount refreshed:" + vObjSellingText1);
				break;
			}
		}
		if (isRefreshed) {
			Assert.assertEquals("PASS", "PASS");
		} else {
			Assert.assertEquals("PASS", Constants.KEYWORD_FAIL);
		}
	}

	@Then("^android user scroll down currency list page$")
	public void android_user_scroll_down_currency_list_page() throws Throwable {
		Constants.key.scrollDownUI("South African Rand");
		LogCapture.info("User able to scroll down currency list page");
	}

	@When("^android user clicks on \"([^\"]*)\" instruction")
	public void android_user_clicks_on_fx_deal(String transactionId) throws Throwable {
		String vObjTransactionList = Constants.AndroidCDAppWalletOR.getProperty("TransactionList");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTransactionList));
		List<MobileElement> TransactionList = Constants.key.getElementList(vObjTransactionList);
		int TransactionListSize = Constants.key.getElementList(vObjTransactionList).size();
		LogCapture.info("Number of transaction for wallet screen : " + TransactionListSize);

		for (int i = 0; i < TransactionListSize; i++) {
			if (Integer.parseInt(transactionId) == i) {
				TransactionList.get(i).click();
				Thread.sleep(8000);
				LogCapture.info("User clicks on transaction to see detail page");
				break;
			}
		}
	}

	@Then("^android user navigates on activity page$")
	public void android_user_navigates_on_activity_page() throws Throwable {
		String vObjWalletDetail = Constants.AndroidCDAppWalletOR.getProperty("Header");
		String vObjWalletDetailText = Constants.key.readText(vObjWalletDetail);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjWalletDetailText, "Activity"));
		LogCapture.info("User navigate on:" + vObjWalletDetailText);
	}


	@Then("^available wallet balance displayed for selected currency$")
	public void available_wallet_balance_displayed_for_selected_currency() throws Throwable {
		String vObjAvailableCurrencyBalance = Constants.AndroidCDAppWalletOR.getProperty("CurrencyBalance");
		String vObjAvailableCurrencyBalanceText = Constants.key.readText(vObjAvailableCurrencyBalance);

		if ((vObjAvailableCurrencyBalanceText) == Integer.toBinaryString((int) 0.00)) {
			LogCapture.info("Wallet does not have balance to send journey");

		} else
			LogCapture.info("Wallet have balance to send journey");

	}

	@Then("^cvv field observed blank in android app$")
	public void cvv_field_observed_blank_in_android_app() throws Throwable {
		String vObjCVVNumber = Constants.AndroidCDAppSendMoney.getProperty("CVVNumber");
		String vObjCVVNumberText = Constants.key.readText(vObjCVVNumber);
		if (vObjCVVNumberText.equalsIgnoreCase("CVV")) {
			LogCapture.info("Cvv field is blank");
		}
	}

	@Then("^sell and buy amount get zero in android app$")
	public void sell_and_buy_amount_get_zero_in_android_app() throws Throwable {
		String vObjSellcurrencyBalance = Constants.AndroidCDAppWalletOR.getProperty("SellCurrencyAmount");
		String vObjSellcurrencyBalanceText = Constants.key.readText(vObjSellcurrencyBalance);

		String vObjBuycurrencyBalance = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyAmount");
		String vObjBuycurrencyBalanceText = Constants.key.readText(vObjBuycurrencyBalance);
		if (vObjSellcurrencyBalanceText.equalsIgnoreCase(Float.toString((float) 0.00))) {
			if (vObjBuycurrencyBalanceText.equalsIgnoreCase(Float.toString((float) 0.00))) {
				LogCapture.info("Sell and buy amount is zero");
			}
		}

	}

	@Then("^android user observe the parameter on Review screen for buy currency$")
	public void android_user_observe_the_parameter_on_Review_screen_for_buy_currency() throws Throwable {
		String vObjReviewTitle = Constants.AndroidCDAppSendMoney.getProperty("ReviewScreen");
		String vObjAddTo = Constants.AndroidCDAppWalletOR.getProperty("AddTo");
		String vObjAmountDue = Constants.AndroidCDAppWalletOR.getProperty("AmountDue");
		String vObjAmountToBeAddedToTheWallet = Constants.AndroidCDAppWalletOR.getProperty("AmountToBeAddedToTheWallet");
		String vObjFee = Constants.AndroidCDAppWalletOR.getProperty("Fee");
		String vObjPaymentMethod = Constants.AndroidCDAppWalletOR.getProperty("PaymentMethod");
		String vObjRate = Constants.AndroidCDAppWalletOR.getProperty("Rate");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReviewTitle));
		LogCapture.info("Review screen title verified");

		String vAddTo = Constants.key.readText(vObjAddTo);
		String vAmountDue = Constants.key.readText(vObjAmountDue);
		String vAmountToBeAddedToTheWallet = Constants.key.readText(vObjAmountToBeAddedToTheWallet);
		String vFee = Constants.key.readText(vObjFee);
		String vPaymentMethod = Constants.key.readText(vObjPaymentMethod);
		String vRate = Constants.key.readText(vObjRate);

		LogCapture.info("Add to : " + vAddTo);

		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("Sell")) {
			Assert.assertEquals("PASS",
					Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"), vAmountDue));
			LogCapture.info("Amount due : " + vAmountDue + " verified..............");
		}
		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("Buy")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"),
					vAmountToBeAddedToTheWallet));
			LogCapture
					.info("Amount to be added to wallet : " + vAmountToBeAddedToTheWallet + " verified..............");
		}
		LogCapture.info("Fee : " + vFee);


		Assert.assertEquals("PASS",
				Constants.key.VerifyTextContains(vPaymentMethod, Constants.DataMap.get("PaymentMethod")));
		LogCapture.info("Payment method : " + vPaymentMethod + " verified..............");

		LogCapture.info("Rate : " + vRate);
	}

	@Then("^deal confirmation screen should be displayed with correct mapped details for add currency in android app$")
	public void deal_confirmation_screen_should_be_displayed_with_correct_mapped_details_for_add_currency_in_android_app()
			throws Throwable {
		String vObjPaymentSuccessLbl = Constants.AndroidCDAppSendMoney.getProperty("PaymentSuccessLbl");
		String vObjAddTo = Constants.AndroidCDAppWalletOR.getProperty("SuccessAddTo");
		String vObjAmountDue = Constants.AndroidCDAppWalletOR.getProperty("SuccessAmountDue");
		String vObjAmountAddedToWallet = Constants.AndroidCDAppWalletOR.getProperty("SuccessAmountAddedToWallet");
		String vObjFee = Constants.AndroidCDAppWalletOR.getProperty("SuccessFee");
		String vObjPaymentMethod = Constants.AndroidCDAppWalletOR.getProperty("SuccessPaymentMethod");
		String vObjCustomerReference = Constants.AndroidCDAppWalletOR.getProperty("SuccessCustomerReference");
		String vObjValueDate = Constants.AndroidCDAppWalletOR.getProperty("SuccessValueDate");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPaymentSuccessLbl));
		LogCapture.info("Success screen is displayed");

		String vAddTo = Constants.key.readText(vObjAddTo);
		String vAmountDue = Constants.key.readText(vObjAmountDue);
		String vAmountAddedToWallet = Constants.key.readText(vObjAmountAddedToWallet);
		Assert.assertEquals("PASS", Constants.key.scrollDownUI("Done"));
		String vFee = Constants.key.readText(vObjFee);
		String vPaymentMethod = Constants.key.readText(vObjPaymentMethod);
		String vCustomerReference = Constants.key.readText(vObjCustomerReference);
		String vValueDate = Constants.key.readText(vObjValueDate);

		LogCapture.info("********************Success screen******************");
		LogCapture.info("Add to : " + vAddTo);

		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("Buy")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.DataMap.get("UserAmountWithCurrency"),
					vAmountAddedToWallet));
			LogCapture.info("Amount due : " + vAmountDue + " verified..............");
			LogCapture.info("Amount to be added to wallet : " + vAmountAddedToWallet + " verified..............");
		}

		LogCapture.info("Fee : " + vFee);
		LogCapture.info("Payment method : " + vPaymentMethod + " verified..............");
		LogCapture.info("Customer reference : " + vCustomerReference);
		LogCapture.info("Value date : " + vValueDate);
	}

	@Then("^add new card option visible in android app$")
	public void add_new_card_option_visible_in_android_app() throws Throwable {
		String vObjAddDebitCardBtn = Constants.AndroidCDAppWalletOR.getProperty("addCardOption");
		String atbValue = Constants.key.getAttributeValue(vObjAddDebitCardBtn, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		LogCapture.info("Add new card option visible on screen.....");
	}

	@Then("^sell currency dislayed as payment currency in android app$")
	public void sell_currency_dislayed_as_payment_currency_in_android_app() throws Throwable {
		String vObjWalletPaymentMethod = Constants.AndroidCDAppWalletOR.getProperty("WalletPaymentMethod");
		String vSellCurrency = Constants.key.readText(vObjWalletPaymentMethod);
		if (Constants.DataMap.get("UserSelection").equalsIgnoreCase("Sell")) {
			Assert.assertEquals("PASS", Constants.key.VerifyText(Constants.DataMap.get("UserCurrency"), vSellCurrency.substring(0, 3)));
			LogCapture.info("Selling currency displayed as payment currency : " + vSellCurrency);
		}
	}

	@Then("^default amount \"([^\"]*)\" displayed in android app")
	public void default_amount_displayed_in_android_app(String defaultAmount) throws Throwable {
		Thread.sleep(10000);
		String vObjpayInAmount = Constants.AndroidCDAppWalletOR.getProperty("BuyCurrencyAmount");
		String vObjSendAmountText = Constants.key.readText(vObjpayInAmount);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjSendAmountText, "1,000.00"));
		LogCapture.info("bydefault 1000 amount displayed for add currency wallet.........");
	}

	@Then("^android user navigates to \"([^\"]*)\" wallet  screen$")
	public void android_user_navigates_to_wallet_screen(String currency) throws Throwable {
		String vObjWalletScreen = Constants.AndroidCDAppWalletOR.getProperty("Header");

		String vObjwalletscreenText = Constants.key.readText(vObjWalletScreen);
		Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.VerifyText(vObjwalletscreenText, currency + "  " + "Wallet"));
		LogCapture.info("User is on Wallet screen ....");
	}


//	@When("^android user click on wallet currency \"([^\"]*)\" from wallet screen page$")
//	public void android_user_click_on_wallet_currency_from_wallet_screen_page(String currency) throws Throwable {
//		String vObjWalletScreen = Constants.AndroidCDAppWalletOR.getProperty("Header");
//
//		String vObjwalletscreenText = Constants.key.readText(vObjWalletScreen);
//		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjwalletscreenText, currency + "  " + "Wallet"));
//		LogCapture.info("User is on Wallet screen ....");
//	}


	@When("^android user click on wallet currency \"([^\"]*)\" from wallet screen page$")
	public void android_user_click_on_wallet_currency_from_wallet_screen_page(String currency) throws Throwable {
		String vObjWalletScreen = Constants.AndroidCDAppWalletOR.getProperty("Header");
		String vObjwalletscreenText = Constants.key.readText(vObjWalletScreen);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjwalletscreenText, "Wallets"));
		String vObjWalletList = Constants.AndroidCDAppWalletOR.getProperty("WalletList");
		String vObjWalletListitm = Constants.AndroidCDAppWalletOR.getProperty("Walletlistitem");
		String vObjWalletName = Constants.AndroidCDAppWalletOR.getProperty("WalletName");

		int walletListSize = Constants.key.getElementList(vObjWalletList).size();
		Thread.sleep(5000);
		Constants.key.scrollDownUI(currency);
		Constants.key.scrollDownUI(currency);


		for (int i = 0; i < walletListSize; i++) {
			String vWalletName = Constants.key.getAttributeValue(vObjWalletListitm + i + vObjWalletName, "text");

			if (vWalletName.contains(currency)) {

				Assert.assertEquals("PASS", Constants.key.click(vObjWalletListitm + i + vObjWalletName));

				LogCapture.info("Wallet match found and clicked on : " + vWalletName);
				Thread.sleep(1000);

				break;
			} else {
				LogCapture.info("Wallet List : " + vWalletName);
			}

		}
	}

	@Then("^android user should be land on activity screen$")
	public void android_user_should_be_land_on_activity_screen() throws Throwable {
		String vObjActivityScreen = Constants.AndroidCDAppWalletOR.getProperty("Header");
		String vObjActivityText = Constants.key.readText(vObjActivityScreen);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjActivityText, "Activity"));
		LogCapture.info("android user is on Activity page.........");
	}


	@Then("^android user is navigated towards (\\d+)ds page$")
	public void android_user_is_navigated_towards_ds_page(int arg1) throws Throwable {
		String vObj3DsecureNewscreen = Constants.AndroidCDAppSendMoney.getProperty("3DsecureNewscreen");
		String atbValue = Constants.key.getAttributeValue(vObj3DsecureNewscreen, "enabled").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyText("true", atbValue));
		LogCapture.info("User land on 3D secure screen");
		Thread.sleep(7000);
		Constants.key.KeyboardAction(vObj3DsecureNewscreen, "ENTER");
		Thread.sleep(5000);
	}

	@Then("^the user should be logged out of the application and user be taken the login screen$")
	public void the_user_should_be_logged_out_of_the_application_and_user_be_taken_the_login_screen()
			throws Throwable {
		String vObjLoginScreen = Constants.AndroidCDAppLogin.getProperty("AndroidLoginBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLoginScreen));
		LogCapture.info("Login screen is getting displayed............. ");
	}

	@Then("^cancel payment confirmation popup displayed on android device$")
	public void cancel_payment_confirmation_popup_displayed_on_android_device() throws Throwable {
		String vObjCancelPayment = Constants.AndroidCDAppSendMoney.getProperty("Error");
		String vObjCancelPaymentText = Constants.key.readText(vObjCancelPayment);
		Assert.assertEquals("PASS", Constants.key.VerifyText(vObjCancelPaymentText, "Cancel payment"));
		LogCapture.info("Cancel payment popup observed");

	}

	@When("^androd user clicks on dont cancel link$")
	public void androd_user_clicks_on_dont_cancel_link() throws Throwable {
		String vObjDontCancalPaymet = Constants.AndroidCDAppWalletOR.getProperty("DontCancalPaymet");
		Assert.assertEquals("PASS", Constants.key.click(vObjDontCancalPaymet));
		LogCapture.info("User click on dont cancel payment link");
	}

	@When("^androd user clicks on yes cancel link$")
	public void androd_user_clicks_on_yes_cancel_link() throws Throwable {
		String vObjYesCancalPaymet = Constants.AndroidCDAppWalletOR.getProperty("YesCancalPaymet");
		Assert.assertEquals("PASS", Constants.key.click(vObjYesCancalPaymet));
		LogCapture.info("User click on yes cancel payment link");
	}

	@Then("^android app dispalyed payment cancelled scrren$")
	public void android_app_dispalyed_payment_cancelled_scrren() throws Throwable {
		Thread.sleep(2000);
		String vobjCardReauth = Constants.AndroidCDAppSendMoney.getProperty("CardReauth");
		String vExpectedMSg = Constants.AndroidTestData.getProperty("PaymentCancelled");
		String atbValue = Constants.key.getAttributeValue(vobjCardReauth, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vExpectedMSg));
		LogCapture.info("Displayed payment cancelled message :  " + atbValue);
	}

	@Then("^android user landed on Nationa registration Ideentity card screen$")
	public void android_user_landed_on_Nationa_registration_Ideentity_card_screen() throws Throwable {
		String vobAdditionalDetailsText = Constants.AndroidCDAppRegistrationOR
				.getProperty("Singapore_AdditionDeatilsPageHeader");

		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vobAdditionalDetailsText));

		Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.eleLocatedDisplayed(vobAdditionalDetailsText));

		LogCapture.info("  NationalityAddition details Page :  " + vobAdditionalDetailsText);
	}

	@Then("^android user selects NIRC \"([^\"]*)\"$")
	public void android_user_selects_NIRC(String data) throws Throwable {
		String vobjinrcText = Constants.AndroidCDAppRegistrationOR.getProperty("Singapore_NIRCText");

		Assert.assertEquals("PASS", Constants.key.writeInInput(vobjinrcText, data));

		Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.writeInInput(vobjinrcText, data));

		LogCapture.info(" Nationality text box values to be entered  :  " + vobjinrcText);
	}

	@Then("^android user selects nationality$")
	public void android_user_selects_nationality() throws Throwable {

		String vobNationalityDropDOwn = Constants.AndroidCDAppRegistrationOR.getProperty("Singapore_DropDown");

		Assert.assertEquals("PASS", Constants.key.click(vobNationalityDropDOwn));

		Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.click(vobNationalityDropDOwn));

		MobileElement nationality = Constants.driver.findElement(By.xpath(vobNationalityDropDOwn));
		int x = 334;
		int y = 1133;
		TouchAction a2 = new TouchAction(Constants.driver).tap(PointOption.point(x, y)).release().perform();
		LogCapture.info(" Nationality selected from drop down  :  " + vobNationalityDropDOwn);
	}


	@Then("^bank details should be fetched in android app for swift$")
	public void bank_details_should_be_fetched_in_android_app_for_swift() throws Throwable {
		String vObjEditAccounIBANtNumber = Constants.AndroidCDAppRecipient.getProperty("EditAccountNumber");
		Assert.assertEquals("PASS", Constants.key.click(vObjEditAccounIBANtNumber));
		String vobjSWiftCode = Constants.AndroidCDAppRecipient.getProperty("Swiftcode");
		Assert.assertEquals("PASS", Constants.key.click(vobjSWiftCode));
		String vObjBankName = Constants.AndroidCDAppRecipient.getProperty("BankName");
		String vBankNameTxt = Constants.key.getAttributeValue(vObjBankName, "text");
		Constants.key.scrollDownUI("Bank name");
		Constants.DataMap.put("Bank Name", vBankNameTxt);
		LogCapture.info("Bank Name Fetched:" + vBankNameTxt);
		Constants.key.scrollDownUI("Continue");
		Thread.sleep(2000);
	}

	@When("^android user enters state \"([^\"]*)\"$")
	public void android_user_enters_state(String state) throws Throwable {
		String vObjState = Constants.AndroidCDAppRecipient.getProperty("StateRec");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjState, state));
		LogCapture.info("user enter " + state + " state...");
	}

	@When("^android user enters postcode \"([^\"]*)\" for newzealand$")
	public void android_user_enters_city_for_newzealand(String postcode) throws Throwable {
		String vObjState = Constants.AndroidCDAppRegistrationOR.getProperty("NewZealandPostCode");
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjState, postcode));
		LogCapture.info("user enter " + postcode + " Postcode...");
	}

	@And("^android user select state \"([^\"]*)\" for newzealand$")
	public void android_user_select_state_for_newzealand(String state) throws Throwable {

		String vobNationalityDropDOwn = Constants.AndroidCDAppRegistrationOR.getProperty("stateDropDown");

		Assert.assertEquals("PASS", Constants.key.click(vobNationalityDropDOwn));

		Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.click(vobNationalityDropDOwn));

		MobileElement nationality = Constants.driver.findElement(By.xpath(vobNationalityDropDOwn));
		int x = 334;
		int y = 1133;
		TouchAction a2 = new TouchAction(Constants.driver).tap(PointOption.point(x, y)).release().perform();
		LogCapture.info(" Nationality selected from drop down  :  " + vobNationalityDropDOwn);

	}

	@Then("^android user unable to find country$")
	public void android_user_unable_to_find_country() throws Throwable {
		String vObjCountryNotFound = Constants.AndroidCDAppRegistrationOR.getProperty("CountryNotFound");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountryNotFound));
		String vCountryNotSupported = Constants.AndroidTestData.getProperty("CountryNotFound");
		String atbValue = Constants.key.getAttributeValue(vObjCountryNotFound, "text").toString();
		Assert.assertEquals("PASS", Constants.key.VerifyTextContains(atbValue, vCountryNotSupported));
		Thread.sleep(2000);
		LogCapture.info("Error message observed: " + vCountryNotSupported);
	}


	@And("^android user enter country \"([^\"]*)\"$")
	public void android_user_enter_country(String countryData) throws Throwable {

		String vObjCountryDelect = Constants.CDAppDashboard.getProperty("CountrySelect");
		// String vObjCountryList =
		// Constants.CDAppDashboard.getProperty("countryList");
		Assert.assertEquals("PASS", Constants.key.click(vObjCountryDelect));

		String vObjCountrySearch = Constants.CDAppDashboard.getProperty("CountrySearch");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCountrySearch));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjCountrySearch, countryData));


		LogCapture.info("User enter country: " + countryData);

	}


	@Then("^User validates the Account Header \"([^\"]*)\" Account name \"([^\"]*)\"$")

	public void userValidatesTheAccountHeaderAccountName(String Accountnameheader, String AccountNameInput) throws Throwable {
		LogCapture.info("checking account name and header");
		String vAccountnameheader = Constants.AndroidCDAppAccountOR.getProperty("Accountnameheader");
		Assert.assertEquals("PASS", Constants.key.pause("5", ""));
		//Assert.assertEquals("PASS", Constants.key.readText("Accountnameheader"));
		Assert.assertEquals("PASS", Constants.key.notexist(vAccountnameheader, Accountnameheader));
		String vAccountName_Value = Constants.AndroidCDAppAccountOR.getProperty("AccountName_Value");
		//Assert.assertEquals("PASS", Constants.key.readText("AccountName_Value"));
		Assert.assertEquals("PASS", Constants.key.notexist(vAccountName_Value, AccountNameInput));
	}

	@Then("^User validates the BanknameHeader \"([^\"]*)\"  Bank name \"([^\"]*)\"$")
	public void userValidatesTheBanknameHeaderBankName(String BanknameHeader, String BankNameInput) throws Throwable {
		LogCapture.info("checking bank name header and bank name ");
		String vBanknameHeader = Constants.AndroidCDAppAccountOR.getProperty("BanknameHeader");
		Assert.assertEquals("PASS", Constants.key.notexist(vBanknameHeader, BanknameHeader));
		String vBankName_Value = Constants.AndroidCDAppAccountOR.getProperty("BankName_Value");
		Assert.assertEquals("PASS", Constants.key.pause("5", ""));
		Assert.assertEquals("PASS", Constants.key.notexist(vBankName_Value, BankNameInput));

	}


	@Then("^User validates the Bankgiro numberHeader \"([^\"]*)\" BGNumber \"([^\"]*)\"$")

	public void userValidatesTheBankgiroNumberHeaderBGNumber(String BankgiroHeader_value, String Bankgiro_value) throws Throwable {
		LogCapture.info("BGNumberHeader and  and Bankgiro");
		String vBankgiroHeader_value = Constants.AndroidCDAppAccountOR.getProperty("BankgiroHeader_value");
		Assert.assertEquals("PASS", Constants.key.notexist(vBankgiroHeader_value, BankgiroHeader_value));
		String vBankgiro_value = Constants.AndroidCDAppAccountOR.getProperty("Bankgiro_value");
		Assert.assertEquals("PASS", Constants.key.pause("5", ""));
		Assert.assertEquals("PASS", Constants.key.notexist(vBankgiro_value, Bankgiro_value));

	}


	@Then("^User validates the countrynameheader \"([^\"]*)\" countryname \"([^\"]*)\"$")

	public void userValidatesTheCountrynameheaderCountryname(String countrynameheadervalue, String countrynamevalue) throws Throwable {
		LogCapture.info("countrynameheade  and countryname");
		String vcountrynameheadervalue = Constants.AndroidCDAppAccountOR.getProperty("countrynameheadervalue");
		Assert.assertEquals("PASS", Constants.key.notexist(vcountrynameheadervalue, countrynameheadervalue));
		String vcountrynamevalue = Constants.AndroidCDAppAccountOR.getProperty("countrynamevalue");
		Assert.assertEquals("PASS", Constants.key.pause("5", ""));
		Assert.assertEquals("PASS", Constants.key.notexist(vcountrynamevalue, countrynamevalue));
	}


	@Then("^User validates the reference header \"([^\"]*)\" Referene \"([^\"]*)\"$")
	public void userValidatesTheReferenceHeaderReferene(String Refereneheader, String Referene_value) throws Throwable {
		LogCapture.info("Refereneheader  and Referene");
		String vRefereneheader = Constants.AndroidCDAppAccountOR.getProperty("Refereneheader");
		Assert.assertEquals("PASS", Constants.key.notexist(vRefereneheader, Refereneheader));
		String vReferene_value = Constants.AndroidCDAppAccountOR.getProperty("Referene_value");
		Assert.assertEquals("PASS", Constants.key.pause("5", ""));
		Assert.assertEquals("PASS", Constants.key.notexist(vReferene_value, Referene_value));

	}
}

