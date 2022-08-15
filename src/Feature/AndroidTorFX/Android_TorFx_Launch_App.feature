@AppLaunch_TorFxAndroidMob

Feature: To test TorFx  app functionality 

    @PAD-2483_TC01_TorFxAndroidMob
    Scenario: 1.1To check that application is installed on device and splash screen is displayed
    Given android user installed the new TorFx app and launched successfully
    When android the version is supported by the server
    And android scheduled maintenance has been checked
    Then android a splash screen should be displayed

    @PAD-2483_TC02_TorFxAndroidMob
    Scenario: 1.4 To check that after loading the application onboarding screen is displayed
    Given android user installed the new TorFx app and launched successfully
    When android the version is supported by the server
    And android scheduled maintenance has been checked
    Then android the app should load the onboarding screen
 
    @PAD-2483_TC03_TorFxAndroidMob
    Scenario: 1.5 To verify that user navigate to onboarding screen when user is not pinned to the app
    Given android user installed the new TorFx app and launched successfully
    When android the version is supported by the server
    And android scheduled maintenance has been checked
    Then android the app should load the onboarding screen
   
    @PAD-2483_TC04_TorFxAndroidMob
    Scenario Outline: 5.6 To Verify that if user exits the Login process and relaunch the app then it redirects to onboarding page.
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android the user provides Username "<emailAddress>" and Password "<password>"
    When android pinned user relaunches the application
    Then android the app should load the onboarding screen
   #Then android user is taken to the login screen with user name pre-filled
   
    Examples: 
      | emailAddress    | password          |
      | TorFxRegEmailId | TorFxRegEmailPass |
       
    @PAD-2483_TC05_TorFxAndroidMob
    Scenario Outline: Verify application should work properly while user switch between the two applications
    Given android user installed the new TorFx app and launched successfully
    When android the version is supported by the server
    And android scheduled maintenance has been checked
    Then android the app should load the onboarding screen
    When android user switch to other application "<appPackage>"
    And android reswitch to TorFxapp
    Then android the app should load the last activity screen
    Examples:
      | appPackage                            |
      | com.google.android.apps.messaging     |


    @PAD-2483_TC06_TorFxAndroidMob
    Scenario Outline: 1.6 Verify that login screen is displayed for pinned useRr
    Given android user installed the new TorFx app and launched successfully
    When android the version is supported by the server
    And android scheduled maintenance has been checked
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android the user provides Username "<emailAddress>" and Password "<password>"
    And android user click on the login button and credentials authentication is successful
    Then android the app should load the dashboard screen
    When android pinned user relaunches the application
    Then android the app should load the pinned user login screen
    Examples:
      | emailAddress | password       |
      | TorFxRegEmailId | TorFxRegEmailPass |

    @PAD-2507_TC07_TorFxAndroidMob
    Scenario: 1.7 To check that when there is no internet connection then application lands on onboarding screen
    Given android user installed the new TorFx app and launched successfully
    When android there is no internet connection
    Then android the app should load the onboarding screen
      
    @PAD-2507_TC08_TorFxAndroidMob
    Scenario: To check that when there is an internet connection then application lands on onboarding screen
    Given android user installed the new TorFx app and launched successfully
    When android there is an internet connection
    Then android the app should load the onboarding screen
   
    @PAD-2604_TC09_TorFxAndroidMob
    Scenario: Verify when user performs swipe action on onboarding page then respective screen image gets displayed
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android the user swap the page from right to left respective pages should display
    When android the user swap the page from left to right respective pages should display
    
    @PAD-2486_TC10_TorFxAndroidMob
    Scenario: 4.1 To verify that when application version is supported and server is not under maintenace then system loads the onboarding screen
    Given android user installed the new TorFx app and launched successfully
    When android the version is supported by the server
    And android scheduled maintenance has been checked
    Then android the app should load the onboarding screen

    @PAD-2486_TC11_TorFxAndroidMob
    Scenario: 4.2 To verify that login and signup  links are present on onboarding screen.
    Given android user installed the new TorFx app and launched successfully
    When android the version is supported by the server
    And android scheduled maintenance has been checked
    Then android the app should load the onboarding screen
    And android login signup options should be present on onboarding screen
  
    @PAD-2486_TC12_TorFxAndroidMob
    Scenario: 4.3_5.1 Verify that when user click on I already have an account link then user redirects to login process screen
    Given android user installed the new TorFx app and launched successfully
    When android the version is supported by the server
    And android scheduled maintenance has been checked
    Then android the app should load the onboarding screen
    And android login signup options should be present on onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
  
    @PAD-2486_TC13_TorFxAndroidMob
    Scenario: 4.4 Verify that when user click on  then user redirects to registration process screen.
    Given android user installed the new TorFx app and launched successfully
    When android the version is supported by the server
    And android scheduled maintenance has been checked
    Then android the app should load the onboarding screen
    And android login signup options should be present on onboarding screen
    When android user click on the Sign up button
    Then android user should navigate to registration process screen
    
    @PAD-2487_TC14_TorFxAndroidMob
    Scenario Outline: 5.2 5.4 To verify that login button should be enabled when user enters the valid email id and password
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then android user should be land on send money screen
    
    Examples: 
      | emailAddress       | password       |
      | TorFxRegEmailId    | TorFxRegEmailPass |
       

     @PAD-2487_TC15_TorFxAndroidMob
    Scenario Outline: 6.4 Verify when register user logged into the app previously then after relaunching the app it should display option to show/hide the password
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android existing user provides  Username "<emailAddress>" and Password "<password>"
    And android user click on the login button and credentials authentication is successful
    When android user skip the biometric credentials for the app
    Then android the app should load the dashboard page
    When android pinned user relaunches the application
    Then android user is taken to the login screen with user name pre-filled
    And android app should not request for the biometric credentials to login
    When android user begins to type in the password "<password>" field
    Then android an eye icon to show/hide the password value should be available

    Examples: 
      | emailAddress     | password       |
      | TorFxRegEmailId  | TorFxRegEmailPass |
      
    #@PAD-2677 @PAD-2677_TC16 @Regression
    #Scenario Outline: 2.10 To verify that user redirects to app store when user request for update app
    #Given android user installed the new TorFx app and launched successfully   
    #When android the version is not supported by the server
    #And android user click on the update now button
    #Then android the app should navigate to requested play store url

  #@PAD-2677 @PAD-2677_TC_17 @Regression
  #Scenario Outline: 2.11 To verify no internet connection error message when user request for update app
    #Given android user installed the new TorFx app and launched successfully   
    #When android the version is not supported by the server
    #And android there is no internet connection
    #And android user click on the update now button
    #Then android no internet connection error message should be displayed

  #@PAD-2677 @PAD-2677_TC_18 @Regression
  #Scenario Outline: 2.17 To check that user is able to update latest version of app
    #Given android user installed the new TorFx app and launched successfully   
    #When android there is an internet connection
    #And android the version is not supported by the server
    #And android user click on the update now button
    #Then android the app should navigate to requested play store url
    #When android the user select the update option
    #Then android the app should be updated to the latest available version
 
  #@PAD-2677 @PAD-2677_TC_19 @Regression
  #Scenario Outline: 2.17 To check that when user doesnot select update option then the previous version of the app remains installed on the device
    #Given android user installed the new TorFx app and launched successfully   
    #When android there is an internet connection
    #And android the version is not supported by the server
    #And android user click on the update now button
    #Then android the app should navigate to requested play store url
    #When android the user does not select the update option
    #Then android the previous version of the app remains installed on the device


 #@PAD-2677 @PAD-2677_TC_20 @Regression
  #Scenario Outline: 2.17.1 To check that when user cancel the update process then the previous version of the app remains installed on the device
    #Given android user installed the new TorFx app and launched successfully   
    #When android there is an internet connection
    #And android the version is not supported by the server
    #And android user click on the update now button
    #Then android the app should navigate to requested play store url
    #When android the user select the update option
    #And android user cancel the update process
    #Then android the previous version of the app remains installed on the device
    #And android forced upgrade screen should be displayed
    #Examples:
      #| deviceName    |
      #| Galaxy Note 8 |
   