@Account_AndroidTorFxMob
Feature: Account Tab

@PAD-3416_TC181_AndroidTorFxMob
 Scenario Outline: 1.1 To check that user navigates to Accounts Menu screen when user click on account setting
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    Then Botton bar should be diplsay on account menu

    Examples: 
      | emailAddress          | password       |   
      | TorFxWalletListUser   | TorFxRegEmailPass |   

      
  @PAD-3417_TC182_AndroidTorFxMob @TorFxSanity@TorFxregression
  Scenario Outline: 2.1 To verify parameters of account detail page and when user press close button on personal detail then user navigate on account detail page.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    And Customer Name "<CustName>" should be display on account screen to andriod user
    And Customer ID number "<CustIDNumber>"should be display on account screen to andriod user
    And Personal Details option should be display on account screen to andriod user
    And Debit Cards option should be display on account screen to andriod user
    And Biometric on/off option should be display on account screen to andriod user
    And Our Bank Details option should be display on account screen to andriod user
    And Help and Support option should be display on account screen to andriod user
    And Manage Device option should be display on account screen to andriod user
    Then Logout option should be display on account screen to andriod user
    Then Botton bar should be diplsay on account menu
    When android user selects Personal Details
    Then Personal Details screen should be displayed to android user
    Then android user presses the close icon

    Examples: 
      | emailAddress    | password          |CustName    | CustIDNumber |
      | TorFxRegEmailId | TorFxRegEmailPass |saira Peter |   1006779650 |

  @PAD-3417_TC183_AndroidTorFxMob
  Scenario Outline: 2.2 To verify Personal Details screen should be display when user click on 'Personal Details'
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Personal Details
    Then Personal Details screen should be displayed to android user

    Examples: 
      | emailAddress    | password          |
      | TorFxRegEmailId | TorFxRegEmailPass |

  @PAD-3417_TC184_AndroidTorFxMob
  Scenario Outline: 2.3 To verify bank account currency selection screen should be display when user click on 'Our Bank Details'
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Our Bank Details
    Then bank account currency selection screen should be displayed to android user

    Examples: 
      | emailAddress    | password       |
      | TorFxRegEmailId | TorFxRegEmailPass |

  @PAD-3417_TC185_AndroidTorFxMob
  Scenario Outline: 2.4 To verify Help and Support screen should be display when user click on 'Help and Support'
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Help and Support
    Then Help and Support screen should be displayed to android user

    Examples: 
      | emailAddress | password       |
      | TorFxRegEmailId | TorFxRegEmailPass |

   @PAD-3417_TC186_AndroidTorFxMob
  Scenario Outline: 2.5 To verify Manage Device screen should be display when user click on 'Manage Device'
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Manage Device
    Then Manage Device screen should be displayed to android user

    Examples: 
      | emailAddress | password       |
      | TorFxRegEmailId | TorFxRegEmailPass |

  @PAD-3417_TC187_AndroidTorFxMob
  Scenario Outline: 2.6 To verify My Cards screen should be display when user click on 'Debit Cards'
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Debit Cards
    Then My Cards screen should be displayed to android user

    Examples: 
      | emailAddress | password       |
      | TorFxRegEmailId | TorFxRegEmailPass |

  @PAD-3417_TC188_AndroidTorFxMob
  Scenario Outline: 2.7 To verify Biometric setup process should be display when user switch 'Biometrics ON/OFF'
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Biometrics on/off
    Then Biometric setup process should be initialised to android user

    Examples: 
      | emailAddress | password       |
      | TorFxRegEmailId | TorFxRegEmailPass |

  @PAD-3417_TC189_AndroidTorFxMob
  Scenario Outline: 2.8 To verify user able to logout the app when user click on 'Logout'
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Logout
    Then information is displayed requesting the user to confirm the action
    Then the user confirms the action
    Then the user should be logged out of the application and user be taken the logout screen

    Examples: 
      | emailAddress | password       |
      | TorFxRegEmailId | TorFxRegEmailPass |

 @PAD-3418_TC190_AndroidTorFxMob
  Scenario Outline: 3.1.1 To verify customer name should be display when user click on 'Personal Details'
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Personal Details
    And Personal Details screen should be displayed to android user
    Then Customer Name "<CustName>" should be display on Personal Details to andriod user

    Examples: 
      | emailAddress  | password      | CustName    |
      | TorFxRegEmailId | TorFxRegEmailPass | saira Peter |

  @PAD-3418_TC191_AndroidTorFxMob
  Scenario Outline: 3.1.2 To verify customer ID should be display when user click on 'Personal Details'
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Personal Details
    And Personal Details screen should be displayed to android user
    Then Customer ID number "<CustIDNumber>" should be display on Personal Details to andriod user

    Examples: 
      | emailAddress  | password      |CustIDNumber |
      | TorFxRegEmailId | TorFxRegEmailPass |  1006686187 |

   @PAD-3418_TC192_AndroidTorFxMob
    Scenario Outline: 3.1.3 To verify customer Email Address should be display when user click on Personal Details
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Personal Details
    And Personal Details screen should be displayed to android user
    Then Customer email id "<CustEmailID>" should be display on Personal Details to andriod user

    Examples: 
      | emailAddress  | password       | CustEmailID                     |
      | TorFxRegEmailId  | TorFxRegEmailPass | testinguser033@dispostable.com  |

  @PAD-3418_TC193_AndroidTorFxMob
  Scenario Outline: 3.1.4 To verify customer Phone Number should be display when user click on Personal Details
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Personal Details
    And Personal Details screen should be displayed to android user
    Then Customer phone number "<CustPhoneNo>" should be display on Personal Details to andriod user

    Examples: 
      | emailAddress  | password         |CustPhoneNo     |
      | TorFxRegEmailId  | TorFxRegEmailPass   |+91 8668272780  |

  @PAD-3418_TC194_AndroidTorFxMob
  Scenario Outline: 3.1.5 To verify 'customer Billing Address' should be display when user click on Personal Details
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Personal Details
    And Personal Details screen should be displayed to android user
    Then Customer Billing Address "<CustBillingAddress>" should be display on Personal Details to andriod user

    Examples: 
      | emailAddress  | password       | CustBillingAddress                 |
      | TorFxRegEmailId  | TorFxRegEmailPass |2HeatherlandsAscotBerkshireSL50ANUK |

  #contact details removed as per PAD-4167 story
   @PAD-3418_TC195_AndroidTorFxMob
  Scenario Outline: 3.1.6 To verify 'Contact details' should be display when user click on Personal Details
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Personal Details
    And Personal Details screen should be displayed to android user

    Examples: 
      | emailAddress | password       |LegalEntity |
      | TorFxRegEmailId | TorFxRegEmailPass | TorFxLGB      |

   @PAD-3418_TC196_AndroidTorFxMob
  Scenario Outline: 3.2 To check user should be lands on account page when user click on close option on personal detail page
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Personal Details
    And Personal Details screen should be displayed to android user
    When android user presses the close icon
    Then Details screen should close and andriod user should navigate to the Accounts menu screen

    Examples: 
      | emailAddress  | password       |
      | TorFxRegEmailId  | TorFxRegEmailPass | 

   @PAD-3419_TC197_AndroidTorFxMob
  Scenario Outline: 4.1 To verify bank details screen options when user click on 'Our Bank Details'
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Our Bank Details
    Then search option should be display on currency selection screen to andriod user
    And List of currencies should be display on currency selection screen to andriod user
    Then close icon should be display on currency selection screen to andriod user

    Examples: 
      | emailAddress  | password       |
      | TorFxRegEmailId  | TorFxRegEmailPass |

   @PAD-3419_TC198_AndroidTorFxMob
  Scenario Outline: 4.2 4.3 To check currency list should be filtered with matching options through fuzzy logic
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    Then android user selects Our Bank Details
    When android user enters currency name "<currency>" in search box
    Then "<currency>" list should be filtered with matching options through fuzzy logic to andriod user
    Then android user presses the close icon

    Examples: 
      | emailAddress  | password       | currency |
      | TorFxRegEmailId  | TorFxRegEmailPass | g        |

   @PAD-3419_TC199_AndroidTorFxMob
  Scenario Outline: 4.4 To check currency list should be filtered with no matching options through fuzzy logic
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    Then android user selects Our Bank Details
    When android user enters currency name "<currency>" in search box
    Then "<currency>" list should be filtered with matching options through fuzzy logic to andriod user

    Examples: 
      | emailAddress  | password       | currency |
      | TorFxRegEmailId  | TorFxRegEmailPass | Dsff     |

  @PAD-3419_TC200_AndroidTorFxMob
  Scenario Outline: 4.5 To check currency should not be display when user press close button on search box and display default list of currencies
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    And android user selects Our Bank Details
    And android user enters currency name "<currency>" in search box
    And android user clicks the close icon in the search field
    Then list of available currency should be displayed in android aap
    

    Examples: 
      | emailAddress  | password        |currency |
      | TorFxRegEmailId  | TorFxRegEmailPass  |GBP      |

   @PAD-3419_TC202_AndroidTorFxMob
  Scenario Outline: 4.9 To verify bank details screen should be close options when user click on close icon
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Our Bank Details
    Then android user presses the close icon

    Examples: 
      | emailAddress  | password       |
      | TorFxRegEmailId  | TorFxRegEmailPass |

    @PAD-3419_TC201_AndroidTorFxMob
  Scenario Outline: 4.6  4.7 To check searched currency should be selected and landed on currency bank details page where all currency details get displayed
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    And android user selects Our Bank Details
    And android user enters currency name "<currency>" in search box
    And android user clicked on searched currency
    Then screen should be displayed with the selected "<currency>" bank details to andriod user
    And screen should be displayed with the selected "<currency>" bank text message to andriod user
    Then Bank Details should be diplay as per "<legalentity-currency>"
    Then screen should be displayed with the selected "<currency>" bank details to andriod user

    Examples: 
       | emailAddress | password       | currency | legalentity-currency |
       | TorFxRegEmailId | TorFxRegEmailPass | GBP      | TorFxLGB-GBP            |
       | TorFxRegEmailId | TorFxRegEmailPass | SEK      | TorFxLGB-SEK            |
       | TorFxRegEmailId | TorFxRegEmailPass | NOK      | TorFxLGB-NOK            |
       | TorFxRegEmailId | TorFxRegEmailPass | DKK      | TorFxLGB-DKK            |
       | TorFxRegEmailId | TorFxRegEmailPass | CZK      | TorFxLGB-CZK            |
       | TorFxRegEmailId | TorFxRegEmailPass | EUR      | TorFxLGB-EUR            |

  @PAD-3420_TC203_AndroidTorFxMob
  Scenario Outline: 4.1 To check searched curreny should be selected and displayed bank details
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    And android user selects Our Bank Details
    And android user enters currency name "<currency>" in search box
    And android user clicked on searched currency
    Then screen should be displayed with the selected "<currency>" bank details to andriod user
    And screen should be displayed with the selected "<currency>" bank text message to andriod user
    Then back icon should be display on bank details screen to andriod user

    Examples: 
      | emailAddress  | password       | currency | legalentity-currency |
      | TorFxRegEmailId  | TorFxRegEmailPass | GBP      | TorFxLGB-GBP            |

  @PAD-3420_TC204_AndroidTorFxMob
  Scenario Outline: 4.2 To check user landed on currency selection screen when user press back icon
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    And android user selects Our Bank Details
    And android user enters currency name "<currency>" in search box
    And android user clicked on searched currency
    And screen should be displayed with the selected "<currency>" bank details to andriod user
    When android user presses the back icon
    Then andriod user landed on bank details screen

    Examples: 
      | emailAddress  | password       | currency | legalentity-currency |
      | TorFxRegEmailId  | TorFxRegEmailPass | GBP      | TorFxLGB-GBP            |

  @PAD-3420_TC205_AndroidTorFxMob
  Scenario Outline: 4.1 To check searched curreny should be selected and highlighted
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    And android user selects Our Bank Details
    And android user enters currency name "<currency>" in search box
    And android user clicked on searched currency
    Then Selected currency should be highlighted

    Examples: 
      | emailAddress  | password      | currency | legalentity-currency |
      | TorFxRegEmailId | TorFxRegEmailPass | GBP      | TorFxLGB-GBP            |

  @PAD-3339_TC207_AndroidTorFxMob
  Scenario Outline: 5.3  To verify that user is on account tab and click on logout button then user click cancel button
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Logout
    Then information is displayed requesting the user to confirm the action
    Then user click on cancel button
    Then the confirmation popup should close and user remain on account screen

    Examples: 
      | emailAddress | password       |
      | TorFxRegEmailId | TorFxRegEmailPass |

  @PAD-3336_TC208_AndroidTorFxMob
  Scenario Outline: 1.1  (Without phone lock functionality ) To verify after revisisting the app within 5 min, user should be on the same screen where he left the app
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And the user is in an inactive state in the app
    When the user returns to active state in less than five minutes
    Then the user should be able to click on Account icon

    Examples: 
      | emailAddress | password       |
      | TorFxRegEmailId | TorFxRegEmailPass | 

   @PAD-3337_TC210_AndroidTorFxMob
  Scenario Outline: 1.2 1.3  To verify after revisist the app which is in background within 1 min, user should be on the same screen where he left the app
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And the user is in an inactive state in the app
    And application is in backgrounds state less than one minutes
    Then the user should be able to enter the app at the same position they left the app

    Examples: 
      | emailAddress | password       |
      | TorFxRegEmailId | TorFxRegEmailPass | 

  @PAD-3339_TC206_AndroidTorFxMob
  Scenario Outline: 3.1 4.1 5.1 5.2 To verify that user is on account tab and click on logout button
    then user click confirm button
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    When android user selects Logout
    Then information is displayed requesting the user to confirm the action
    Then the user confirms the action
    Then the user should be logged out of the application and user be taken the logout screen

    Examples: 
      | emailAddress | password       |
      | TorFxRegEmailId | TorFxRegEmailPass |

  @PAD-3337_TC211_AndroidTorFxMob
  Scenario Outline: 1.2 1.3 To verify that user logged in into the app and keep the app in
    backround for 1 minutes or more than 1 minutes then the application should take the user on logout screen
   Given android user installed the new TorFx app and launched successfully
   Then android the app should load the onboarding screen
   When android user click on I already have an account? link
   Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And the user is in an inactive state in the app
    And application is in backgrounds state more than one minutes
    Then the user should be logged out of the application and user be taken the logout screen
    Then andriod user click on Login button from logout screen and land into subsequent login page

    Examples: 
      | emailAddress | password       |
      | TorFxRegEmailId | TorFxRegEmailPass | 

  @PAD-3422_212_AndroidTorFxMob
  Scenario Outline: 6.1  To verify that remove account button should be displayed when user selects Manage Device option from account menu
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    Then Manage Device option should be display on account screen to andriod user
    Then android user selects Manage Device
    Then remove account button should be displayed to android user

    Examples: 
      | emailAddress  | password       |
      | TorFxRegEmailId  | TorFxRegEmailPass | 

  @PAD-3422_213_AndroidTorFxMob
  Scenario Outline: 6.2  To verify that confirmation pop up message should be displayed when user clicks on remove account button
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    Then Manage Device option should be display on account screen to andriod user
    Then android user selects Manage Device
    Then remove account button should be displayed to android user
    Then android user clicks remove account button on manage device screen
    Then confirmation pop up message should be displayed to android user

    Examples: 
      | emailAddress  | password       |
      | TorFxRegEmailId  | TorFxRegEmailPass | 

  @PAD-3422_214_AndroidTorFxMob
  Scenario Outline: 6.3 To verify that user should be logged out of the application and taken to the Onboarding screen, user clicks on RESET button
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    Then Manage Device option should be display on account screen to andriod user
    Then android user selects Manage Device
    Then remove account button should be displayed to android user
    Then android user clicks remove account button on manage device screen
    Then confirmation pop up message should be displayed to android user
    And android user clicks Reset button on manage device screen
    Then the user should be logged out of the application and user be taken the login screen

    Examples: 
      | emailAddress     | password       |
      | TorFxRegEmailId     | TorFxRegEmailPass |

  @PAD-3422_215_AndroidTorFxMob
  Scenario Outline: 6.5  To verify that confirmation pop up message should be closed when user clicks on cancel button
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    Then Manage Device option should be display on account screen to andriod user
    Then android user selects Manage Device
    Then remove account button should be displayed to android user
    Then android user clicks remove account button on manage device screen
    Then confirmation pop up message should be displayed to android user
    And android user clicks Cancel button on manage device screen
    Then remove account button should be displayed to android user

    Examples: 
      | emailAddress  | password       |
      | TorFxRegEmailId  | TorFxRegEmailPass | 

  @PAD-3421_216_AndroidTorFxMob
  Scenario Outline: 5.1,5.2  To verify header and close icon getting displayed when user click on Help and support and user navigtaed to account menu screen again
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    Then android user selects Help and Support
    Then Help and Support screen should be displayed to android user
    Then android user presses the close icon
    Then accounts menu screen should be display to andriod user
    Examples: 
      | emailAddress  | password      |
      | TorFxRegEmailId | TorFxRegEmailPass | 

      
   @PAD-3421_217_AndroidTorFxMob
  Scenario Outline: 5.4,5.5 To verify questions in list collapsed and again turn into expanded state.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    Then android user selects Help and Support
    Then Help and Support screen should be displayed to android user
    Then andriod user click on any Questions and it should collapsed
    Then topic details should be expanded to android user
    Examples: 
      | emailAddress  | password      |
      | TorFxRegEmailId | TorFxRegEmailPass |
  @PAD-3421_218_AndroidTorFxMob
  Scenario Outline: 5.4,5.5 To verify questions in list collapsed and again turn into expanded state.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    Then accounts menu screen should be display to andriod user
    Then accounts menu screen should be display to andriod user
    And android user selects Our Bank Details
    And android user enters currency name "<currency>" in search box
    And android user clicked on searched currency
    #And User clicks on currency dropdown and selects required "<Currency>" currency
    Then User validates the Account Header "<AccountHader>" Account name "<AccountName>"
    Then User validates the BanknameHeader "<BanknameHeader>"  Bank name "<BankName>"
    Then User validates the Bankgiro numberHeader "<BGNumberHeader>" BGNumber "<Bankgiro>"
    Then User validates the countrynameheader "<countrynameheader>" countryname "<country>"
    Then User validates the reference header "<referenceheader>" Referene "<Referene>"

    Examples:
      | emailAddress | password       | currency | AccountHader | AccountName                      | BanknameHeader | BankName                                                          | BGNumberHeader | Bankgiro  | referenceheader | Referene   | countrynameheader | country |  |
      | CDRegEmailId | CDRegEmailPass | SEK      | Account name | Currencies Direct Ltd Client Acc | Bank name      | Citibank Europe Plc Birger Jarlsgatan 6, 114 34 Stockholm, Sweden | Bankgiro       | 5628-1579 | Referene        | 1006846138 | country           | Sweden  |  |
