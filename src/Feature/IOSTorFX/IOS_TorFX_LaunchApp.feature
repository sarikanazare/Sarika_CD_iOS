@TorFX_LaunchApp
Feature: Launch Appllication

  @TorFX_PID-3261_TC01 @launch1
  Scenario: 1.1 To check that application is installed on device and splash screen is displayed
    Given ios user installed the new TorFX app and launched successfully
    When ios app version is supported by the server
    And ios app scheduled maintenance has been checked
    Then ios app should load the onboarding screen
    Then ios app splash screen should be displayed

  @TorFX_PID-3261_TC02 @launch1
  Scenario: 1.4 To check that after loading the application onboarding screen is displayed
    Given ios user installed the new TorFX app and launched successfully
    When ios app version is supported by the server
    And ios app scheduled maintenance has been checked
    Then ios app should load the onboarding screen

  @TorFX_PID-3261_TC03 @launch1
  Scenario: 1.5 To verify that user navigate to onboarding screen when user is not pinned to the app
    Given ios user installed the new TorFX app and launched successfully
    When ios app version is supported by the server
    And ios app scheduled maintenance has been checked
    Then ios app should load the onboarding screen

  @TorFX_PID-3261_TC04 @launch1
  Scenario Outline: To verify that application do not get the crash when user relaunch application multiple times
    Given ios user installed the new TorFX app and launched successfully
    #Given ios app has been launched with attepmt <attempt>
    Given ios TorFX app has been launched with attepmt <attempt>
    When ios app version is supported by the server
    And ios app scheduled maintenance has been checked
    Then ios app should load the onboarding screen

    Examples: 
      | attempt |
      |       1 |

  #Need to check how to find bundleid form BS
  @TorFX_PID-3261_TC05 @launch1
  Scenario Outline: To Verify application works properly when user switches between the two applications.
    Given ios user installed the new TorFX app and launched successfully
    When ios app version is supported by the server
    And ios app scheduled maintenance has been checked
    Then ios app should load the onboarding screen
    When ios user switch to other application "<SettingAppbundleId>"
    And reswitch to TorFX ios app "<IOSbundleId>"
    Then ios app should load the last activity screen

    Examples: 
      | SettingAppbundleId    | IOSbundleId |
      | iphoneSettingBundleId | IOSbundleId |

  @TorFX_PID-3247_TC06 @launch1
  Scenario Outline: 1.6 To verify pinned user login screen
    Given ios user installed the new TorFX app and launched successfully
    When internet connection is available on ios device
    And ios app version is supported by the server
    And ios app scheduled maintenance has been checked
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId01 | CDRegEmailPass1 |

  @TorFX_PID-3247_TC07 @launch1
  Scenario: 1.7 To check that when there is no internet connection then application lands on onboarding screen
    Given ios user installed the new TorFX app and launched successfully
    When internet connection is not available on ios device
    Then ios app should load the onboarding screen

  @TorFX_PID-3247_TC08 @launch1
  Scenario: 1.8 To check that when there is an internet connection then application lands on onboarding screen
    Given ios user installed the new TorFX app and launched successfully
    When internet connection is available on ios device
    Then ios app should load the onboarding screen

  @TorFX_PID-3247_TC09 @launch1
  Scenario Outline: 1.6 To verify pinned user login screen
    Given ios user installed the new TorFX app and launched successfully
    When internet connection is available on ios device
    And ios app version is supported by the server
    And ios app scheduled maintenance has been checked
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    When internet connection is not available on ios device
    #And ios pinned user relaunches the application "<appVersion>"
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username

    #And ios user should able to turn on wifi connection
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId01 | CDRegEmailPass1 |

  @TorFX_PID-3339_TC10 @launch1
  Scenario: Verify when user performs swipe action on onboarding page then respective screen image gets displayed
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user swap the page from right to left respective pages should display
    And ios user swap the page from left to right respective pages should display

  @TorFX_PID-3258_TC11 @launch1
  Scenario: 4.1 To verify that when application version is supported and server is not under maintenace then system loads the onboarding screen
    Given ios user installed the new TorFX app and launched successfully
    When ios app version is supported by the server
    And ios app scheduled maintenance has been checked
    Then ios app should load the onboarding screen

  @TorFX_PID-3258_TC12 @launch1
  Scenario: 4.2 To verify that login and signup  links are present on onboarding screen.
    Given ios user installed the new TorFX app and launched successfully
    When ios app version is supported by the server
    And ios app scheduled maintenance has been checked
    Then ios app should load the onboarding screen
    And login signup options should be present on ios app onboarding screen

  @TorFX_PID-3258 @TorFX_PID-3343_3257_3258_TC13 @launch1
  Scenario: 4.3_5.1 Verify that when user click on I already have an account link then user redirects to login process screen
    Given ios user installed the new TorFX app and launched successfully
    When ios app version is supported by the server
    And ios app scheduled maintenance has been checked
    Then ios app should load the onboarding screen
    And login signup options should be present on ios app onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen

  @TorFX_PID-3258_TC14 @launch1
  Scenario: 4.4 Verify that when user click on  then user redirects to registration process screen.
    Given ios user installed the new TorFX app and launched successfully
    When ios app version is supported by the server
    And ios app scheduled maintenance has been checked
    Then ios app should load the onboarding screen
    And login signup options should be present on ios app onboarding screen
    When ios user click on the Sign up button
    Then ios user should navigate to registration process screen

  #NA
  @TorFX_PID-3371_TC15 @launch1
  Scenario: 2.10 To verify that user redirects to app store when user request for update app
    Given ios user installed the new TorFX app and launched successfully
    When the version of ios app is not supported by the server
    And ios user click on the update now button
    Then ios app should navigate to requested app store url

  #NA
  @TorFX_PID-3371_TC16 @launch1
  Scenario: 2.11 To verify no internet connection error message when user request for update app
    Given ios user installed the new TorFX app and launched successfully
    When the version of ios app is not supported by the server
    And internet connection is not available on ios device
    And ios user click on the update now button
    Then no internet connection error message should be displayed to ios user

  #NA
  @TorFX_PID-3371_TC17
  Scenario: 2.18 To check that when user doesnot select update option then the previous version of the app remains installed on the device
    Given ios user installed the new TorFX app and launched successfully
    When internet connection is available on ios device
    When the version of ios app is not supported by the server
    And ios user click on the update now button
    Then ios app should navigate to requested app store url
    When ios user does not select the update option
    Then previous version of the cd ios app should remain installed on the device

  #NA
  @TorFX_PID-3371_TC18
  Scenario: To check that when user cancel the update process then the previous version of the app remains installed on the device
    Given ios user installed the new TorFX app and launched successfully
    When internet connection is available on ios device
    When the version of ios app is not supported by the server
    And ios user click on the update now button
    Then ios app should navigate to requested app store url
    When ios user select the update option
    And ios user cancel the update process
    Then previous version of the cd ios app should remain installed on the device

  #The set testcase will be testcase during the fource upgrade
  @TorFX_PID-3371_TC19
  Scenario: 2.17 To check that user is able to update latest version of app
    # Given ios app is installed on the device and launched successfully
    Given ios older version app "<appVersion>" is installed on the device "<deviceId>" and launched successfully
    When internet connection is available on ios device
    When the version of ios app is not supported by the server
    And ios user click on the update now button
    Then ios app should navigate to requested app store url
    When ios user select the update option
    Then ios app should be updated on the device "<deviceId>" to the latest available version "<appVersion>"
