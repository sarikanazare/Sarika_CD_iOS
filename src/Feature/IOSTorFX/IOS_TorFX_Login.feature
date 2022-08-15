@Login
Feature: Login Functionality :

  @TorFX__PID-3257_3343_TC20 @TorFXLoginlot1
  Scenario Outline: 5.2_5.4 To verify that login button should be enabled when user enters the valid email id and password.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3257_3343_TC21 @TorFXLoginlot1
  Scenario: 5.3 To verify that login buttion is disabled when user doesnot provide the username and Password
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user doest not provides Username and Password
    Then ios app login button should be disabled to submit the credentials

  @TorFX__PID-3257_3343_TC22 @TorFXLoginlot1
  Scenario Outline: To verify that when user provides only username then login button should be disabled.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user  provide only Username "<emailAddress>"
    Then ios app login button should be disabled to submit the credentials

    Examples: 
      | emailAddress    |
      | TorRegEmailId11 |

  @TorFX__PID-3257_3343_TC23 @TorFXLoginlot1
  Scenario Outline: To verify that when user provide only password then login button should remain inactive
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provide only Password "<password>"
    Then ios app login button should be disabled to submit the credentials

    Examples: 
      | password        |
      | CDRegEmailPass2 |

  @TorFX__PID-3257_TC24 @TorFXLoginlot1
  Scenario Outline: 5.5 To verify that when user performs login with valid user credentials then system stores the data for future subsequent logins.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #And ios user required data should be saved in secure device "<deviceId>" storage for future subsequent logins
    And ios user required data should be saved in secure device storage for future subsequent logins in ios application

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3257_3343_TC25 @TorFXLoginlot1
  Scenario Outline: 5.6 To Verify that if user exits the Login process and relaunch the app then it redirects to onboarding page.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user exits the login process
    #And ios user relaunches the app
    When ios pinned user relaunches the TorFX application
    Then ios app should load the onboarding screen

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3257_TC26 @TorFXLoginlot1
  Scenario Outline: 5.7 To verify that when user performs login with valid credential then user navigates to home dashboard screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3257_3343_TC27 @TorFXLoginlot1
  Scenario Outline: 5.8 To verify validation error message for invalid email id format.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provide Username "<emailAddress>" in invalid format
    Then a validation failure message should be displayed for the username to ios user

    Examples: 
      | emailAddress   |
      | InvalidEmailId |

  @TorFX__PID-3257_TC28 @TorFXLoginlot1
  Scenario: 5.9 Verify that when user clicks on the Forgot Password link then user redirects to forgot password process screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    Then forgot password? link should be present on ios app login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen

  @TorFX__PID-3257_TC29 @TorFXLoginlot1
  Scenario Outline: To verify that when user enters the invalid Username and Password then system displays invalid credentials error message.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    Then authentication unsuccessful error message should be displayed on login screen for ios user

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3255_3433_TC30 @TorFXLoginlot1
  Scenario Outline: 7.1_7.2 To verify that forgot password button should be in active state when user enters valid registered user email id.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When ios user provide valid registered Username "<emailAddress>"
    Then ios app forgot password button should be active

    Examples: 
      | emailAddress    |
      | TorRegEmailId11 |

  @TorFX__PID-3433 @PID-3255_TC31 @TorFXLoginlot1
  Scenario Outline: 7.3 To verify that forgot password button remains disabled and email validation error message gets populated, when user provides email id in invalidformat.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When ios user provide Username "<emailAddress>" in invalid format
    Then a validation failure message should be displayed for the username to ios user
    And ios app forgot password button should be inactive

    Examples: 
      | emailAddress   |
      | InvalidEmailId |

  @TorFX__PID-3255_3433_TC32 @TorFXLoginlot1
  Scenario: 7.4 To verify that forgot password button remains inactive when user doesnot provide the username .
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When ios user doesnot provide Username
    Then ios app forgot password button should be inactive

  @TorFX__PID-3255_TC33 @TorFXLoginlot1
  Scenario: To check that when user closes the forgot password window then user lands on the login page.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When ios user close the forgot password window
    Then ios user should navigate to login screen

  @TorFX__PID-3255_TC34 @TorFXLoginlot1
  Scenario: To check the label description on the forgot password screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    And forgot password description label should be present on the forgot password screen of ios app

  @TorFX__PID-3255_3433_TC35 @TorFXLoginlot1
  Scenario Outline: 7.5 To verify reset password link has been sent success journey from the main login screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When ios user provide valid registered Username "<emailAddress>"
    And ios user click on send me a link
    Then reset password link has been sent success message should be displayed on ios app
    When ios user closes the reset password link success window
    Then ios user should navigate to login screen

    Examples: 
      | emailAddress    |
      | TorRegEmailId11 |

  @TorFX__PID-3433 @PID-3255_TC36 @TorFXLoginlot1
  Scenario Outline: To verify reset password link has been sent success journey from the pinned user login screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When ios user provide valid registered Username "<emailAddress>"
    And ios user click on send me a link
    Then reset password link has been sent success message should be displayed on ios app
    When ios user closes the reset password link success window
    Then ios app should load the pinned user login screen with prefilled username

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3703_TC37 @TorFXLoginlot1
  Scenario Outline: To verify success message gets displayed on forgot password screen when user submit active user email id.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When ios user provide valid registered Username "<emailAddress>"
    And ios user click on send me a link
    Then password reset link sent success message should be displayed to ios user

    Examples: 
      | emailAddress    |
      | TorRegEmailId11 |

  @TorFX__PID-3703_TC38 @TorFXLoginlot1
  Scenario Outline: To verify success message gets displayed on forgot password screen when user submit the non registered user email id.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When ios user provide valid non registered Username "<emailAddress>"
    And ios user click on send me a link
    Then password reset link sent success message should be displayed to ios user

    Examples: 
      | emailAddress    |
      | TorRegEmailId11 |

  @TorFX__PID-3703_TC39 @TorFXLoginlot1
  Scenario Outline: To verify success message gets displayed on forgot password screen when user submit the atlas inactive user email id.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When ios user provide atlas inactive Username "<emailAddress>"
    And ios user click on send me a link
    Then password reset link sent success message should be displayed to ios user

    Examples: 
      | emailAddress    |
      | TorRegEmailId11 |

  @TorFX__PID-3703_TC40 @TorFXLoginlot2
  Scenario Outline: To verify success message gets displayed on forgot password screen when user submit the locked due to inavlid attempt	user email id.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When ios user provide locked due to inavlid attempt Username "<emailAddress>"
    And ios user click on send me a link
    Then password reset link sent success message should be displayed to ios user

    Examples: 
      | emailAddress    |
      | TorRegEmailId11 |

  @TorFX__PID-3703_TC41 @TorFXLoginlot2
  Scenario Outline: To verify success message gets displayed on forgot password screen when user submit the admin locked user email id.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When ios user provide admin locked Username "<emailAddress>"
    And ios user click on send me a link
    Then password reset link sent success message should be displayed to ios user

    Examples: 
      | emailAddress    |
      | TorRegEmailId11 |

  @TorFX__PID-3703_TC42 @TorFXLoginlot2
  Scenario Outline: To check generic message to be displayed on forgot password screen when server connection is down and user submit the email id.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When ios user provide valid registered Username "<emailAddress>"
    And ios user click on send me a link
    Then a generic message should be displayed on the screen to ios user

    Examples: 
      | emailAddress    |
      | TorRegEmailId11 |

  @TorFX__PID-3703_TC43 @TorFXLoginlot2
  Scenario Outline: To verify internet connection not available message on forgot password screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen
    When internet connection is not available on ios device
    Then ios user should navigate to forgot password process screen
    When ios user provide valid registered Username "<emailAddress>"
    And ios user click on send me a link
    Then no internet connection error message should be displayed to ios user

    Examples: 
      | emailAddress    |
      | TorRegEmailId11 |

  #as current implementation does not have the option to login with another account on pinned user screen hence this testcase is NA
  @TorFX__PID-3254_TC44 @lot3
  Scenario Outline: 8.1 To verify login with another is account link available
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    #Then ios app should load the pinned user login screen
    Then ios app should load the pinned user login screen with prefilled username

    #And an option to login with another account should be available on ios app
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId32 | CDRegEmailPass4 |

  #as current implementation does not have the option to login with another account on pinned user screen hence this testcase is NA
  @TorFX__PID-3254_TC45
  Scenario Outline: 8.2 To verify warning message on the login with another account link
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    #Then ios app should load the pinned user login screen
    Then ios app should load the pinned user login screen with prefilled username
    When ios user select login with another account
    Then warning message this action will clear any user saved information popup should be displayed on ios app

    Examples: 
      | emailAddress      | password        |
      | CDRegEmailIdUKAdd | CDRegEmailPass2 |

  #as current implementation does not have the option to login with another account on pinned user screen hence this testcase is NA
  @TorFX__PID-3254_TC46
  Scenario Outline: 8.3 To verify cancel button functionality of login with another account link
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen
    When ios user select login with another account
    Then warning message this action will clear any user saved information popup should be displayed on ios app
    When ios user cancel to login with another account
    Then ios app warning message popup should be closed
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen

    Examples: 
      | emailAddress      | password        |
      | CDRegEmailIdUKAdd | CDRegEmailPass2 |

  #as current implementation does not have the option to login with another account on pinned user screen hence this testcase is NA
  @TorFX__PID-3254_TC47
  Scenario Outline: 8.4 To verify that reset option removes the previously stored username from secure device storage
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen
    When ios user select login with another account
    And ios user accepts to login as a different user
    Then the previously stored username on the ios app should be removed from secure device storage

    Examples: 
      | emailAddress      | password        |
      | CDRegEmailIdUKAdd | CDRegEmailPass2 |

  #as current implementation does not have the option to login with another account on pinned user screen hence this testcase is NA
  @TorFX__PID-3254_TC48
  Scenario Outline: 8.5 Verify that reset option removes the previous stored user data and trigger the first time login process.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen
    When ios user select login with another account
    And ios user accepts to login as a different user
    Then the previously stored username on the ios app should be removed from secure device storage
    And ios user should trigger the first time login process

    Examples: 
      | emailAddress      | password        |
      | CDRegEmailIdUKAdd | CDRegEmailPass2 |

  #NA
  @TorFX__PID-3441_3256_TC49 @TorFXLoginlot2
  Scenario Outline: 6.1_6.2 To verify biometric request popup to biometric enabled app user
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user enables the biometric credentials for the app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should request the users biometric credentials to login
    When ios user cancel the biometric option
    Then ios app should load the pinned user login screen with prefilled username

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3441_3256_TC50 @TorFXLoginlot2
  Scenario Outline: 6.3 To verify that biometric request popup do not get display on pinned user login screen when biometric option have not been enabled by user
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    And ios app should not request for the biometric credentials to login
    And system should allow ios user to enter Password "<password>" in password field

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3441_3256_TC51 @TorFXLoginlot2
  Scenario Outline: 6.4 To verify that an eye icon to show hide the password value gets available when user begins to type in the password field
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    And ios app should not request for the biometric credentials to login
    When ios user provides valid Password "<password>"
    Then an eye icon to show hide the password value should be available for ios app

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3441_3256_TC52 @TorFXLoginlot2
  Scenario Outline: 6.5 To verify that show hide icon is available when password field is blank.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user enables the biometric credentials for the app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should request the users biometric credentials to login
    When ios user cancel the biometric option
    And ios user did not provide the passsword
    Then an eye icon to show hide the password value should be available for ios app

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3441_3256_TC53 @TorFXLoginlot2
  Scenario Outline: 6.6 To verify that password value is masked by default when user type in the password field.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    And ios app should not request for the biometric credentials to login
    When ios user provides valid Password "<password>"
    Then an eye icon to show hide the password value should be available for ios app
    And password value should be masked by default for ios app

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3256 @PID-3441_TC541 @TorFXLoginlot2
  Scenario Outline: To verify show hide password functionality on pinned user login screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    And ios app should not request for the biometric credentials to login
    When ios user provides valid Password "<password>"
    Then an eye icon to show hide the password value should be available for ios app
    When ios user click on eye icon to unmask the password value
    Then password value should be unmasked for ios user
    When ios user click on eye icon to mask the password value
    Then password value should be masked for ios user
    #When ios user click on the login button
    And ios user click on the login button on pinned user
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  #6.7 and 6.8 out of .scope
  @TorFX__PID-3441_3256_TC55 @TorFXLoginlot2
  Scenario Outline: 6.9_6.13._6.15 To verify that system allow user perform login journey when user cancel the biometric authentication popup
    Given ios user installed the new TorFX app and launched successfully
    #Given ios user installed the new app "<appVersion>" on the device "<deviceId>" and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user enables the biometric credentials for the app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should request the users biometric credentials to login
    When ios user cancel the biometric option
    And ios user provides valid Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  #This testcases is need to discuss with bhakti whether it present or not
  @TorFX__PID-3441_3256_TC56 @lot4
  Scenario Outline: 6.10 To verify option to trigger a request for biometric credentials is available after user cancel the biometric popup
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user enables the biometric credentials for the app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should request the users biometric credentials to login
    When ios user cancel the biometric option
    Then an option to trigger a request for biometric credentials should be available on ios login screen

    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId32 | CDRegEmailPass4 |

  @TorFX__PID-3441_3256_TC57 @TorFXLoginlot2
  Scenario Outline: 6.11 To verify that app replace the an option of biometric credentials with an option to show/hide the password value
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user enables the biometric credentials for the app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should request the users biometric credentials to login
    When ios user cancel the biometric option
    Then an option to trigger a request for biometric credentials should be available on ios login screen
    When ios user provides valid Password "<password>"
    Then ios app should replace the biometric credentials option with eye icon to mask unmask password

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  #NA
  @TorFX__PID-3441_3256_TC58 @TorFXLoginlot2
  Scenario Outline: 6.12 To verify that app replace an option to show/hide the password value with option of biometric credentials after clear the text
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user enables the biometric credentials for the app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should request the users biometric credentials to login
    When ios user cancel the biometric option
    When ios user provides valid Password "<password>"
    Then ios app should replace the biometric credentials option with eye icon to mask unmask password
    When ios user clear the password field value
    Then ios app replace an option eye icon with option biometric credentials to trigger a biometric request

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3441_3256_TC59 @TorFXLoginlot2
  Scenario Outline: 6.14 To verify that when user does not provide password then login button should remain disabled.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    And ios user doesnot provide password
    Then ios app login button should be disabled to submit the credentials

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3256 @TorFX__PID-3441_TC60 @TorFXLoginlot2
  Scenario Outline: 6.16 To verify that when pinned user reinstall the application then user lands on dashboard screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user reinstall and launch the CD app in ios app
    When ios pinned user reinstall and launch the TorFX app in ios app
    Then ios app should load the onboarding screen

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3441 @TorFX__PID-3441_TC61 @TorFXLoginlot2
  Scenario Outline: 6.17 To verify forgot password process screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    When ios user click on forgot password? link
    Then ios user should navigate to forgot password process screen

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3248_TC62 @TorFXLoginlot2
  Scenario Outline: 14.1_14.2_14.3 To verify pre-scheduled maintenance notification check on login for new and pinned user
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    And ios app scheduled maintenance has been checked
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    And ios app scheduled maintenance has been checked
    Then ios app should load the pinned user login screen with prefilled username
    And ios app should not request for the biometric credentials to login
    When ios user provides valid Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId11 | CDRegEmailPass1 |

  @TorFX__PID-3253_TC63 @TorFXLoginlot2 @Attempt
  Scenario Outline: 9.1 To verify successful login from the main login screen where first three attempts was failed due to invalid password.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides valid Username "<emailAddress>" and invalid Password "<invalidPassword>"
    And ios user click on the login button on pinned user
    Then ios app should display error message on main login screen according to failed attempt <attempt> and user legal entity "<custLegalEntity>"
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    # When ios user provides valid Password "<password>"
    And ios user click on the login button
    #And ios user click on the login button on pinned user
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | invalidPassword | password        | attempt | custLegalEntity  |
      | TorRegEmailId13 | InvalidPass     | CDRegEmailPass1 |       3 | CustLegalEntity1 |

  #9.3_9.4_9.5_9.6_9.7
  @TorFX__PID-3253_TC64 @TorFXLoginlot2 @Attempt
  Scenario Outline: To verify successful login from the subsequent login screen where first some attempts was failed due to invalid password.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    And ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    #When ios user provides invalid Password "<invalidPassword>"
    Then ios app should display error message on subsequent login screen according to failed attempt <attempt> and user legal entity "<custLegalEntity>"
    When ios user provides valid Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | password        | invalidPassword | attempt | custLegalEntity  |
      | TorRegEmailId13 | CDRegEmailPass1 | InvalidPass     |       2 | CustLegalEntity1 |

  #9.8_9.9_9.10_9.11_9.12_9.13_9.14
  @TorFX__PID-3253_TC65 @TorFXLoginlot2 @Attempt
  Scenario Outline: To verify failed login attempt messages on main login screen with diffrent legal entity users.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides valid Username "<emailAddress>" and invalid Password "<invalidPassword>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then ios app should display error message on main login screen according to failed attempt <attempt> and user legal entity "<custLegalEntity>"

    Examples: 
      | emailAddress    | invalidPassword | attempt | custLegalEntity  |
      | TorRegEmailId13 | InvalidPass     |       2 | CustLegalEntity1 |

  @TorFX__PID-3253_TC66 @lot5 @Attempt
  Scenario Outline: To verify login failed attempt messages on subsequent login screen with diffrent legal entity users.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    And ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    When ios user provides invalid Password "<invalidPassword>"
    Then ios app should display error message on subsequent login screen according to failed attempt <attempt> and user legal entity "<custLegalEntity>"

    Examples: 
      | emailAddress    | password        | invalidPassword | attempt | custLegalEntity  |
      | TorRegEmailId14 | CDRegEmailPass1 | InvalidPass     |       2 | CustLegalEntity1 |

  @TorFX__PID-3253_TC67 @lot5 @Attempt
  Scenario Outline: To verify that system locks the user credentials by considering subsequent login failed attempt on main login screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    And ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    # When ios user provides invalid Password "<invalidPassword>"
    #And ios user click on the login button
    Then ios app should display error message on subsequent login screen according to failed attempt <attempt> and user legal entity "<custLegalEntity>"

    #When ios pinned user relaunches the application
    #When ios user click on login with another account and enters Username "<emailAddress>" and invalid Password "<invalidPassword>"
    # When ios pinned user reinstall and launch the CD app in ios app
    # Then ios app should load the onboarding screen
    #When ios user click on I already have an account? link
    #When ios user provides valid Username "<emailAddress>" and invalid Password "<invalidPassword>"
    #And ios user click on the login button
    #Then ios app should display error message on main login screen according to failed attempt <attempt2> and user legal entity "<custLegalEntity>"
    Examples: 
      | emailAddress    | password        | invalidPassword | attempt | custLegalEntity  |
      | TorRegEmailId14 | CDRegEmailPass1 | InvalidPass     |       3 | CustLegalEntity1 |

  @TorFX__PID-3253_TC68 @lot5 @Attempt
  Scenario Outline: To verify that system redirect the user from subsequent login screen to main login screen when user gets locked on fifth attempt.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    And ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    When ios user provides invalid Password "<invalidPassword>"
    Then ios app should display error message on subsequent login screen according to failed attempt <attempt> and user legal entity "<custLegalEntity>"

    #Then ios user should be taken to the login screen requesting full user credentials
    Examples: 
      | emailAddress    | password        | invalidPassword | attempt | custLegalEntity  |
      | TorRegEmailId15 | CDRegEmailPass1 | InvalidPass     |       3 | CustLegalEntity1 |

  @TorFX__PID-3253_TC69 @lot5 @Attempt
  Scenario Outline: 9.2 To verify failed login attempt reset counter on main login screen with diffrent legal entity users.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides valid Username "<emailAddress>" and invalid Password "<invalidPassword>"
    And ios user click on the login button on pinned user
    Then ios app should display error message on main login screen according to failed attempt <attempt> and user legal entity "<custLegalEntity>"
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    # When ios user provides valid Password "<password>"
    And ios user click on the login button
    And ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    And failed log in attempts has been set to zero
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    # When ios user provides invalid Password "<invalidPassword>"
    # And ios user click on the login button
    #When ios user click on login with another account and enters Username "<emailAddress>" and invalid Password "<invalidPassword>"
    Then ios app should display error message on subsequent login screen according to failed attempt <attempt2> and user legal entity "<custLegalEntity>"

    Examples: 
      | emailAddress    | password        | invalidPassword | attempt | attempt2 | custLegalEntity  |
      | TorRegEmailId15 | CDRegEmailPass1 | InvalidPass     |       2 |        3 | CustLegalEntity1 |

  @TorFX__PID-3253_TC70 @lot6 @Attempt
  Scenario Outline: To verify failed login attempt reset counter on subsequent login screen with diffrent legal entity users.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    And ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    When ios user provides invalid Password "<invalidPassword>"
    Then ios app should display error message on subsequent login screen according to failed attempt <attempt> and user legal entity "<custLegalEntity>"
    When ios user provides valid Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    When ios user provides invalid Password "<invalidPassword>"
    Then ios app should display error message on subsequent login screen according to failed attempt <attempt2> and user legal entity "<custLegalEntity>"

    Examples: 
      | emailAddress    | password        | invalidPassword | attempt | attempt2 | custLegalEntity  |
      | TorRegEmailId15 | CDRegEmailPass1 | InvalidPass     |       3 |        2 | CustLegalEntity1 |

  #NA
  @TorFX__PID-3250_TC71 @lot6 @TorFXLoginlot3
  Scenario Outline: 12.1 To verify biometric request popup to a user who has set their security QAs
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then biometric enable popup should be displayed for ios app
    When ios user enables the biometric credentials for the app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should request the users biometric credentials to login
    When ios user cancel the biometric option
    Then ios app should load the pinned user login screen with prefilled username

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId12 | CDRegEmailPass1 |

  #Required new user
  @TorFX__PID-3250_TC72 @lot6 @QA
  Scenario Outline: 12.2_12.3 To verify submit button is enabled when user provides security question and answer in valid format
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    And ios user has not set their Security QA
    Then ios app should display an option to set their Security QA
    When ios user provides their Security QAs in a valid format
    Then the option to submit their details should be enabled for ios app

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId15 | CDRegEmailPass1 |

  #Required new user
  @TorFX__PID-3250_TC73 @lot6 @QA
  Scenario Outline: To verify security question and answer setup request screen gets display to pinned user when it is not set first time login
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    #And existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    And ios user has not set their Security QA
    #And ios user relaunches the app
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    When ios user provides valid Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then ios app should display an option to set their Security QA

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId15 | CDRegEmailPass1 |

  #Required new user
  @TorFX__PID-3250_TC74 @lot6 @QA
  Scenario Outline: 12.4 To verify submit button is disabled when user provides security question and answer in invalid format
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    And ios user has not set their Security QA
    Then ios app should display an option to set their Security QA
    When ios user provides their Security QAs in  invalid format
    Then the option to submit their details should be disabled for ios app

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId15 | CDRegEmailPass1 |

  #Required new user
  @TorFX__PID-3250_TC75 @lot6 @QA
  Scenario Outline: 12.5 To verify user lands on dashboard afetr valid security question and answer setup.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    And ios user has not set their Security QA
    Then ios app should display an option to set their Security QA
    When ios user provides their Security QAs in a valid format
    Then the option to submit their details should be enabled for ios app
    When ios user submits their details
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId15 | CDRegEmailPass1 |

  #Required new user
  @TorFX__PID-3250_TC76 @lot6 @QA
  Scenario Outline: 12.6 To verify system doesnot show security QAs screen when user has set security question and answer previously
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    #And existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    #And ios user click on the login button on pinned user
    And ios user has not set their Security QA
    Then ios app should display an option to set their Security QA
    When ios user provides their Security QAs in a valid format
    Then the option to submit their details should be enabled for ios app
    When ios user submits their details
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    # When ios pinned user relaunches the application
    #Then ios app should load the onboarding screen
    When ios pinned user reinstall and launch the CD app in ios app
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    #And existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button on pinned user
    Then ios app should not be displayed an option to set their Security QA

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId16 | CDRegEmailPass1 |

  #NA
  @TorFX__PID-3245_TC77 @lot6 @TorFXLoginlot3
  Scenario Outline: 15.1_15.2_15.7 To verify the setup biometric functionality switch status is on in account setting.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    Then biometric enable popup should be displayed for ios app
    When ios user enables the biometric credentials for the app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios user opens up their account settings
    And ios user click on account button
    Then account screen should be displayed
    Then the setup biometric switch status should be on

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId12 | CDRegEmailPass1 |

  #NA
  @TorFX__PID-3245_TC78 @lot6 @TorFXLoginlot3
  Scenario Outline: 15.8 To verify the setup biometric functionality switch status is off in account setting.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios user opens up their account settings
    And ios user click on account button
    Then account screen should be displayed
    Then the setup biometric switch status should be off

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId12 | CDRegEmailPass1 |

  @TorFX__PID-3245_TC79 @lot6 @TorFXLoginlot3
  Scenario Outline: To verify that when user clicks on the back button then user navigates to full login screen from the pin page.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then otp page should be displayed to ios user
    When ios user click on back button
    #Then ios user should navigate to login screen
    Then ios app should load the pinned user login screen with prefilled username

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId01 | CDRegEmailPass1 |

  @TorFX__PID-3251_TC80 @lot7 @TorFXLoginlot3
  Scenario Outline: 11.1 To verify invalid otp for existing user on full login screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then otp page should be displayed to ios user
    When ios user enters invalid otp "<otp>"
    Then invalid otp error message should be displayed

    Examples: 
      | emailAddress    | password        | otp        |
      | TorRegEmailId08 | CDRegEmailPass1 | InvalidOTP |

  @TorFX__PID-3251_TC81 @lot7 @TorFXLoginlot3
  Scenario Outline: To verify resend pin link gets displayed after sixty seconds of interval and gets disappeared when user click on resend pin link.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When new registered user provides Username "<emailAddress>" and Password "<password>" first time in ios app
    When ios user provides Username "<emailAddress>" and Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then otp page should be displayed to ios user
    When ios user do not enters otp in sixty seconds
    Then resend pin link gets displayed on ios app pin screen
    When ios user click on resend pin
    Then request a new pin timer should be start for sixty seconds in ios app

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId01 | CDRegEmailPass1 |

  @TorFX__PID-3251_TC82 @lot7 @TorFXLoginlot3 @TorFX_iOS_2FA
  Scenario Outline: 11.1 To verify 2FA with valid otp for existing user on full login screen when Last log in is before 90 days
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    #When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    #And ios user click on the login button
    When ios user provides Username "<emailAddress>" and Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>"
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on login screen
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | password        | otp |
      | TorRegEmailId10 | CDRegEmailPass1 | OTP |

  #NA
  @TorFX__PID-3251_TC83 @lot7 @TorFXLoginlot3
  Scenario Outline: To verify 2FA with valid otp for existing user by switching between two application
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    #Then otp page should be displayed to ios user
    When ios user switch to other application "<iphoneMessageBundleId>"
    And reswitch to cd ios app "<IOSbundleId>" after seconds <miliSeconds>
    #And ios user enters valid otp "<emailAddress>"
    #When ios user enters valid otp "<emailAddress>" "<environment>" to add recipient
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | password        | iphoneMessageBundleId | IOSbundleId | miliSeconds | otp |
      | TorRegEmailId12 | CDRegEmailPass1 | iphoneMessageBundleId | IOSbundleId |       10000 | OTP |

  #Required new user
  @TorFX__PID-3251_TC84 @QA @TorFX_iOS_2FA
  Scenario Outline: 11.2_11.3 To verify QAs setup with valid otp for new user on full login screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When new registered user provides Username "<emailAddress>" and Password "<password>" first time in ios app
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    #And ios user click on the login button on pinned user
    #Then otp page should be displayed to ios user
    # When ios user enters valid otp "<emailAddress>"
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on login screen
    Then ios app should display an option to set their Security QA
    When ios user provides their Security QAs in a valid format
    Then the option to submit their details should be enabled for ios app
    When ios user submits their details
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId13 | CDRegEmailPass1 |

  #Required new user
  @TorFX__PID-3251_TC85 @QA @TorFX_iOS_2FA
  Scenario Outline: To verify QAs setup with valid otp for new user on subsequent login screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    #Then otp page should be displayed to ios user
    #And ios user relaunches the app
    When ios pinned user relaunches the TorFX application
    Then ios app should load the pinned user login screen with prefilled username
    When ios user provides valid Password "<password>"
    #And ios user click on the login button
    And ios user click on the login button on pinned user
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>"
    # When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on login screen
    Then ios app should display an option to set their Security QA
    When ios user provides their Security QAs in a valid format
    Then the option to submit their details should be enabled for ios app
    When ios user submits their details
    Then biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId14 | CDRegEmailPass1 |

  @TorFX__PID-3531_TC86 @lot7 @TorFXLoginlot3
  Scenario Outline: To verify user is able to process any journey without any disturbance  after access token time period expired  (currently its 10 min)
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    When ios user skip the biometric credentials for the app
    # And ios user click on the login button on pinned user
    And ios user selects the recipient option from the home dashboard
    And ios user waits until access token expired for miliseconds <miliSeconds>
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user

    Examples: 
      | emailAddress    | password        | miliSeconds |
      | TorRegEmailId12 | CDRegEmailPass1 |       60000 |

  #Not implemented yet
  @TorFX__PID-4291_TC87
  Scenario Outline: 1,2 To verify that system ask user Uplod document page from main login if POI flag is true
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    And ios user skip the biometric credentials for the app
    Then ID update needed screen should be displayed to ios user
    When ios user click on do it later button
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress  | password        |
      | CDRegEmailId8 | CDRegEmailPass1 |

  #Not implemented yet
  @TorFX__PID-4291_TC88
  Scenario Outline: 1,2 To verify that system ask user Uplod document page from susequent login login if POI flag is true
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    And ios user skip the biometric credentials for the app
    Then ID update needed screen should be displayed to ios user
    When ios user relaunches the app
    Then ios app should load the pinned user login screen with prefilled username
    When ios user provides valid Password "<password>"
    And ios user click on the login button
    Then ID update needed screen should be displayed to ios user
    When ios user click on do it later button
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress | email                     | password        |
      | CDLEUPOIUser | kattyjane@dispostable.com | CDRegEmailPass1 |

  #Not implemented yet
  @TorFX__PID-4291_TC89 @TorFX_iOS_2FA
  Scenario Outline: To verify that poi page should ask the user even if user get login after 90 days
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<email>"
    When ios user enters default otp on login screen
    And ios user skip the biometric credentials for the app
    Then ID update needed screen should be displayed to ios user
    When ios user relaunches the app
    Then ios app should load the pinned user login screen with prefilled username
    When ios user provides valid Password "<password>"
    And ios user click on the login button
    Then ID update needed screen should be displayed to ios user
    When ios user click on do it later button
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress | email                     | password        |
      | CDLEUPOIUser | kattyjane@dispostable.com | CDRegEmailPass1 |

  @TorFX__PID-4291_TC90 @lot7 @TorFXLoginlot3
  Scenario Outline: 3. To verify that System should not ask for poi document upload for the user if POI flag is off
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    #And biometric enable popup should be displayed for ios app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId12 | CDRegEmailPass1 |

  #Not implemented yet
  @TorFX__PID-4291_TC91
  Scenario Outline: 6:To verify when user click on ‘Update ID’ button then users should trigger for POI upload process and user should land on web login page in mobile brower
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    And ios user skip the biometric credentials for the app
    Then ID update needed screen should be displayed to ios user
    When ios user click on update id button
    Then ios app should navigate to web login page "<url>"

    Examples: 
      | emailAddress    | password        | url     |
      | TorRegEmailId12 | CDRegEmailPass1 | NGOPUAT |

  #Not implemented yet
  @TorFX__PID-4291_TC92
  Scenario Outline: 9. To verify that user is on upload poi screen and clicking on ‘Do it later’ button user should navigate to the Dashboard
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When existing user provides Username "<emailAddress>" and Password "<password>"
    When existing user provides Username "<emailAddress>" and Password "<password>" first time for ios app
    And ios user click on the login button
    And ios user skip the biometric credentials for the app
    Then ID update needed screen should be displayed to ios user
    When ios user click on do it later button
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId12 | CDRegEmailPass1 |

  #NA
  @TorFX__PID-3979_TC93 @lot7 @TorFXLoginlot3
  Scenario Outline: 1.  (Without phone lock functionality ) To verify after revisisting the app within 5 min, user should be on the same screen where he left the app
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    #And ios user click on the login button on pinned user
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    When ios user keeps app ideal state for time <seconds>
    #And ios user opens up their account settings
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    Then ios user should navigate to debit card screen

    Examples: 
      | emailAddress    | password        | seconds |
      | TorRegEmailId12 | CDRegEmailPass1 |     200 |

  #| CDRegEmailId28 | CDRegEmailPass1 |     100 |
  @TorFX__PID-3979_TC94 @lot7 @TorFXLoginlot3
  Scenario Outline: (Without phone lock ) 1.2, 1.3 : To verify when user keeps app ideally and revisist the app after 5 min user should land on Logout page and click on "Login" then user should be land on "Subsequent" login page
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    #And ios user click on the login button on pinned user
    When ios user keeps app ideal state for time <seconds>
    Then ios user should navigate to logout screen
    When ios user click on login
    Then ios app should load the pinned user login screen with prefilled username

    Examples: 
      | emailAddress    | password        | seconds |
      | TorRegEmailId12 | CDRegEmailPass1 |     320 |

  @TorFX__PID-3979_TC95 @lot7 @TorFXLoginlot3
  Scenario Outline: 1.2 1.3  To verify after revisist the app which is in background within 1 min, user should be on the same screen where he left the app
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    When ios user keeps the appp in background for time <seconds>
    And ios user return to active state in app
    Then ios app should load the dashboard screen

    Examples: 
      | emailAddress    | password        | iphoneMessageBundleId | IOSbundleId | seconds |
      | TorRegEmailId12 | CDRegEmailPass1 | iphoneMessageBundleId | IOSbundleId |      50 |

  @TorFX__PID-3979_TC96 @lot7 @TorFXLoginlot3
  Scenario Outline: 1.2 1.3   To verify that user logged in into the app and keep the app in backround for 1 minutes or more than 1 minutes then the application should take the user on logout screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    When ios user keeps the appp in background for time <seconds>
    And ios user return to active state in app
    Then ios user should navigate to logout screen

    Examples: 
      | emailAddress    | password        | iphoneMessageBundleId | IOSbundleId | seconds |
      | TorRegEmailId12 | CDRegEmailPass1 | iphoneMessageBundleId | IOSbundleId |     120 |

  @TorFX__PID-3979_TC97 @lot7 @TorFXLoginlot3
  Scenario Outline: 4.1, 5.1, 5.2 To verify that user is on account tab and click on logout button then information should be displayed asking the user to confirm the action and when user confirms the action user should taken the logout screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    When ios user skip the biometric credentials for the app
    #And ios user opens up their account settings
    And ios user click on account button
    Then account screen should be displayed
    And ios user click on the logout button
    #Then logout confirmation screen should be displayed in ios app
    Then confirm logout screen should be displayed
    When ios user confirms the logout action
    Then ios user should be logged out from the application
    And ios user should navigate to logout screen

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId12 | CDRegEmailPass1 |

  @TorFX__PID-3979_TC98 @lot7 @TorFXLoginlot3
  Scenario Outline: 5.3  To verify that user is on account tab and click on logout button then information should
    be displayed asking the user to confirm the action and when user cancels the action then the information should
    close and user should stay on account tab

    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    #When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    When ios user provides Username "<emailAddress>" and Password "<password>"
    And ios user click on the login button
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #And ios user opens up their account settings
    And ios user click on account button
    Then account screen should be displayed
    And ios user click on the logout button
    Then logout confirmation screen should be displayed in ios app
    When ios user cancels the logout action
    Then the confirmation popup should close and user remain on account screen for ios app

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId12 | CDRegEmailPass1 |

  @TorFX__PID-4311_TC99 @lot7 @TorFXLoginlot3
  Scenario Outline: To verify the 'Login with Biometric' link functionality on subsequent login screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user enables the biometric credentials for the app
    When ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    #When ios pinned user relaunches the application
    When ios pinned user relaunches the TorFX application
    Then ios app should request the users biometric credentials to login
    When ios user cancel the biometric option
    Then login with biometric link text should be displayed on subsequent login screen of ios app
    When ios user clicks on the login with biometric link
    Then ios app should request the users biometric credentials to login
    When ios user cancel the biometric option
    Then login with biometric link text should be displayed on subsequent login screen of ios app
    When ios user clicks on the login with biometric link
    Then ios app should request the users biometric credentials to login
    When ios user cancel the biometric option
    And ios user provides valid Password "<password>"
    When ios user click on the login button
    Then ios app should load the dashboard screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId12 | CDRegEmailPass1 |

  @TorFX__PID-4311_TC100 @lot7 @TorFXLoginlot3
  Scenario Outline: To verify the 'Login with Biometric' link functionality on subsequent login screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    When ios user removes account by using manage device option

    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId12 | CDRegEmailPass1 |

  @TorFX__Login1 @lot7 @TorFXLoginlot3
  Scenario Outline: To verify that user should land on account screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    Then ios app should load the dashboard screen
    # When ios user click on an account
    #When ios user opens up their account settings
    And ios user click on account button
    Then account screen should be displayed

    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId12 | CDRegEmailPass1 |
