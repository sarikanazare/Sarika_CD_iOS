Feature: To test wallet functionality

  @TorFX_PID-4038_TC1 @TorFX_PID-4039_TC1 @TorAddwalletLot1
  Scenario Outline: 2.1,2.2,2.3,2.4 To verify that logged in user should land on wallet screen post clicking on Wallet option present on bottom bar.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId02 | CDRegEmailPass1 |

  @TorFX_PID-4041_TC1_AddWallet @TorAddwalletLot1
  Scenario Outline: 4.1 To verify that user should able to click on Add Wallet.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    When ios user click on the Add Wallet button
    Then ios app user land on Add Wallet screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId02 | CDRegEmailPass1 |

  @TorFX_PID-4041_TC2_AddWallet @TorAddwalletLot1
  Scenario Outline: 4.1,4.5,4.7.1,4.7.2,4.7.3,4.9 To verify that user should able to Add a new wallet.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    When ios user click on the Add Wallet button
    Then ios app user land on Add Wallet screen
    When ios app user select the "<currency>" to add the wallet
    And ios app user add the wallet for selected "<currency>"
    Then ios app user land on wallet screen and Added wallet of selected "<currency>" should be displayed.

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency |
      | TorRegEmailId02 | CDRegEmailPass1 | MXN      |

  @TorFX_PID-4041_TC3_AddWallet @TorAddwalletLot1
  Scenario Outline: 4.6 To verify if user tap on close icon on search tab, the filter value get clear and whole list should be display.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    When ios user click on the Add Wallet button
    Then ios app user land on Add Wallet screen
    When ios app user select the "<currency>" to add the wallet
    Then ios app user clears the text entered in search bar by clicking the close button

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency |
      | TorRegEmailId02 | CDRegEmailPass1 | U        |

  @TorFX_PID-4041_TC4_AddWallet @TorAddwalletLot1
  Scenario Outline: 4.3 To verify user land on wallet screen on click on “X” close option on ‘Add Wallet’ screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    When ios user click on the Add Wallet button
    Then ios app user land on Add Wallet screen
    When ios user close the add wallet window
    Then ios app user land on wallet screen and Add Wallet button should be displayed.

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId02 | CDRegEmailPass1 |

  @TorFX_PID-4041_TC5_AddWallet @TorAddwalletLot1
  Scenario Outline: To verify that empty state of currency list should be displayed along with a message indicating no results have been returned
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    When ios user click on the Add Wallet button
    Then ios app user land on Add Wallet screen
    When ios app user select the "<currency>" to add the wallet
    Then empty state currency list should be displayed in ios app along with no result message on add wallet window

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency |
      | TorRegEmailId02 | CDRegEmailPass1 | AAA      |

  @TorFX_PID-4040_TC6_AddWallet @TorAddwalletLot1
  Scenario Outline: To verify that user should able to select the wallet
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      |

  @TorFX_PID-4040_TC_7_AddWallet_AddButton @TorAddwalletLot1
  Scenario Outline: To verify user on “Currency wallet” screen, after tap on “add” button user redirects to the “Top up Wallet” screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      |

  @TorFX_PID-4043_TC_3_SendWallet @TorFX_PID-4046_ADD_CURRENCY_TC_02 @TorAddwalletLot1
  Scenario Outline: 9.5 To verify that error message should be displayed when user entered the amount in selling currency is less than allowed limit (100 GBP)
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user enters you pay amount "<amount>"
    Then minimum allowed amount limit error message should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      |   0.01 |

  @TorFX_PID-4043_TC_4_SendWallet @TorAddwalletLot1
  Scenario Outline: 3.4 To verify on “Currency wallet” screen after tap on “Bank” button user redirects to the “Bank Details” screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Bank button
    Then ios app user land on Bank details screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      |

  @TorFX_PID-4043_TC_5_SendWallet @TorFX_PID-4046_ADD_CURRENCY_TC_03 @TorAddwalletLot1
  Scenario Outline: 9.6 To verify that error message should be displayed when user entered the amount in selling currency is more than allowed limit (25000 GBP)
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user enters you pay amount "<amount>"
    Then maximum allowed amount limit error message should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount    |
      | TorRegEmailId01 | CDRegEmailPass1 | GBP      | 45,000.01 |

  @TorFX_PID-4043_TC_6_SendWallet @Torfx_iOS_sanity @TorAddwalletLot1
  Scenario Outline: 14.1,14.2,14.3,14.4 To verify the deal to be processed successfully when user initiates the Add currency transaction with bank transfer payment method
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    When ios user select bank transfer as payment method
    #When ios user click on continue button
    When ios user click on continue button on bank transfer
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details
    Then by default bank account details section should be displayed on buy currency confirmation screen
    When ios user click on Top-up details
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    #When ios user click on the done button
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option from wallet screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount |
      | TorRegEmailId01 | CDRegEmailPass1 | GBP      | USD            | 150,20 |

  @TorFX_PID-4042 @TorAddwalletLot1
  Scenario Outline: 5.2 To verify the user redirects to the “Currency wallet” screen after tap on back (arrow) button on “Bank Details” screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Bank button
    Then ios app user land on Bank details screen
    When ios user click on Back button
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      |

  @TorFX_PID-4046_TC_01 @TorAddwalletLot1
  Scenario Outline: 9.2 To verify the user redirects to the “Currency wallet” screen after tap on back (arrow) button on “Send from Wallet” screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user selects the send option from the wallet transaction screen
    When ios user click on Back button
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency |
      | TorRegEmailId02 | CDRegEmailPass1 | EUR      |

  @TorFX_PID-4049_ADD_CURRENCY_TC_05 @TorAddwalletLot2
  Scenario Outline: 8.1,8.2,8.3,12.5 To verify on “Add Currency” screen, all top-up method
        should display when more than one supported wallet top up methods are fetched from the server. the app should display all the top up methods for selection in an enabled state

    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    #And bank transfer payment method should be in active state on buy currency screen
    And bank transfer payment method should be in active state
    #And debit card payment method should be in active state on buy currency screen
    #And wallet payment method should be in active state on buy currency screen
    And wallet payment method should be in inactive state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | CAD      | USD            | 200.00 |

  @TorFX_PID-4045_TC_02 @TorFX_PID-4272_TC_02 @TorAddwalletLot2
  Scenario Outline: 11.1,9.15,9.18,9.19,12.7 To verify the Payment method to be in Inactive state if its not supported.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    And bank transfer payment method should be in active state
    And debit card payment method should be in inactive state
    And wallet payment method should be in inactive state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | CAD      | USD            | 200.00 |

  @TorFX_PID-4041_TC6_AddWallet @TorFX_PID-4047_ADD_CURRENCY_TC_01 @TorAddwalletLot2
  Scenario Outline: 9.2,10.2 To verify the user presses back button on “Currency Wallet” screen, user lands on Wallet screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on Back button
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      |

  @TorFX_PID-4272_TC_02 @TorFX_PID-4046_ADD_CURRENCY_TC_07 @TorAddwalletLot2
  Scenario Outline: 11.2,9.16,10.2 To verify on “Add Currency” page, user able enter the amount in buying currency
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user enters they get amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    And an auto timer of sixty seconds should start and rate should be refreshed and you pay amount should be updated in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount    | seconds |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | 10,001.00 |      60 |

  @TorFX_PID-4046_ADD_CURRENCY_TC_04 @TorFX_PID-4047_ADD_CURRENCY_TC_03 @Torfx_iOS_sanity @TorAddwalletLot2
  Scenario Outline: Scenario: 9.8,10.4 To verify when the user is entering amount less than min limit in Buying Currency’ (Add to wallet) amount field, after 2 sec a relevant error message should be display.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user enters they get amount "<amount>" for limit error
    Then minimum allowed amount limit error message should be displayed to ios user

    #When ios user removes account by using manage device option from buy currency screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount |
      | TorRegEmailId01 | CDRegEmailPass1 | GBP      |  01.00 |

  @TorFX_PID-4046_ADD_CURRENCY_TC_05 @TorFX_PID-4047_ADD_CURRENCY_TC_04 @Torfx_iOS_sanity @TorAddwalletLot2
  Scenario Outline: Scenario: 9.9,10.5 To verify when the user is entering amount greater than max limit in Buying Currency’ (Add to wallet) amount field, after 2 sec a relevant error message should be display.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user enters they get amount "<amount>" for limit error
    Then maximum allowed amount limit error message should be displayed to ios user

    #When ios user removes account by using manage device option from buy currency screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount    |
      | TorRegEmailId01 | CDRegEmailPass1 | GBP      | 45,000.01 |

  @TorFX_PID-4045_TC_50 @TorAddwalletLot2
  Scenario Outline: To verify that user can add new card successfully
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | EUR            | 200.00 | Kemmy Watasons | 6759649826438453 |            1120 |             1125 |

  #| CDRegEmailID34 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | Smith          | 8453  | 555 | Sending to Family | Test-Reference | SIT         |
  @TorFX_PID-4046_ADD_CURRENCY_TC11 @TorAddwalletLot2
  Scenario Outline: 9.20 To verify if user tap on close icon on search tab, the filter value get clear and whole list should be display.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then ios app user clears the text entered in search bar by clicking the close button on buy currency

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | U              |

  @TorFX_PID-4045_TC_53 @TorAddwalletLot2
  Scenario Outline: Scenario: 9.22 To verify if the user selects the currency from currency list, that is not supported for fx/online trade then fx deal rate should not display.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then empty state currency list should be displayed in ios app along with no result message on buy currency window

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | AAAaa          |

  @TorFX_PID-4046_ADD_CURRENCY_TC_09 @TorAddwalletLot2
  Scenario Outline: To verify if user tap on back icon on currency selection list screen then user should land on “Add Currency” screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then ios user click back button on buy currency
    Then ios app user land on Add money screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | r              |

  @TorFX_PID-4047_ADD_CURRENCY_TC_05 @TorAddwalletLot2
  Scenario Outline: 10.1 To verify the parameter of “Add Currency” page, when user selects currency as a top up method and for Add GBP is a supported top up method> GBP as a top up method
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      |

  @TorFX_PID-4046_ADD_CURRENCY_TC_10 @TorAddwalletLot2
  Scenario Outline: 9.22 To verify if the user selects the currency from currency list, that is not supported for fx/online trade then fx deal rate should not display.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    Then error message observed on buy currency screen
    And ios app user click on ok button

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | ZAR            |

  @TorFX_PID-4268_ADD_CURRENCY_TC_01 @TorAddwalletLot2
  Scenario Outline: 12.4 To verify on “Add Currency” screen, only debit card payment method displayed
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should navigate to payment method screen
    And debit card payment method should be displayed on buy currency screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | 300.00 |

  @TorFX_PID-4268_ADD_CURRENCY_TC_02 @TorAddwalletLot2
  Scenario Outline: 12.1,12.2,12.3 To verify when user is on payment method page and press back then user should navigate towards buy currency page
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should navigate to payment method screen
    And debit card payment method should be displayed on buy currency screen
    When ios user click on Back button
    Then ios user land on send money screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | 300.00 |

  @TorFX_PID-4268_ADD_CURRENCY_TC_05 @TorAddwalletLot3
  Scenario Outline: 12.10,12.11 To verify that user can add new card successfully on buy currency
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | 200.00 | Kemmy Watasons | 5555555555554444 |            1120 |             1125 |

  @TorFX_PID-4268_ADD_CURRENCY_TC_07 @TorFX_PID-5128_ADD_CURRENCY_TC_01 @TorAddwalletLot3
  Scenario Outline: 12.16,12.17,12.13,13.1,13.2,13.5 To verify that user perform Pay in journey using normal card.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should navigate to payment method screen
    # And card "<cardNumber>" details should be saved in ios app debit card payment method list
    #When ios user selects saved card "<cardNumber>" to make a transfer
    When ios user selects a saved card "<cardNumberlast4digit>" to buy a currency
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | cardNumberlast4digit | cvv |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | 200.00 |                 4444 | 555 |

  @TorFX_PID-4047_ADD_CURRENCY_TC_10 @TorFX_PID-4269_ADD_CURRENCY_TC_04 @Torfx_iOS_sanity @TorAddwalletLot3
  Scenario Outline: 14.1,14.2,14.3,14.4 To verify that user perform Pay in journey using 3d card.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should navigate to payment method screen
    When ios user selects a saved card "<cardNumberlast4digit>" to buy a currency
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    Then ios user should land on threed card page
    When ios user submits threed card response
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option from wallet screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | cardNumberlast4digit | cvv |
      | TorRegEmailId05 | CDRegEmailPass1 | GBP      | 200.00 |                 4444 | 555 |

  @TorFX_PID-4268_ADD_CURRENCY_TC_06 @TorFX_PID-4049_ADD_CURRENCY_TC_03 @TorAddwalletLot3
  Scenario Outline: 12.12 To verify that continue button should be disabled when no card is present.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should navigate to payment method screen
    Then continue button should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | 200.00 |

  @TorFX_PID-4268_ADD_CURRENCY_TC_03 @TorAddwalletLot3
  Scenario Outline: To verify that in pay in flow while adding new card when last name does not match with the account holders last name the system should give proper error message
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    When ios user selects to add a new card to make a transfer
    And ios user provides invalid unmatched contacts last name "<cardHolderName>"
    Then invalid last name error message should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | cardHolderName |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | 200.00 | sss petro      |

  @TorFX_PID-4268_ADD_CURRENCY_TC_08 @TorAddwalletLot3
  Scenario Outline: To verify that in send money flow while adding new card when expiry date is less than current date than system should give proper error message
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    When ios user selects to add a new card to make a transfer
    And ios user provides invalid unmatched contacts last name "<cardHolderName>"
    When ios user provides invalid expiry date "<expiryDate(MMYY)>"
    Then invalid expiry date error message should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId02 | CDRegEmailPass1 | GBP      | 200.00 | Kemmy Watasons | 6759649826438453 |            1120 |             1120 |

  @TorFX_PID-3939_ADD_CURRENCY_TC_02 @TorAddwalletLot3
  Scenario Outline: To verify payment journey flow for existing 3d card with wrong selection of 3d simulator page
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should navigate to payment method screen
    When ios user selects a saved card "<cardNumberlast4digit>" to buy a currency
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    Then ios user should land on threed card page
    When ios user submits threed card response with other reason
    Then ios user should navigate to review screen on buy currency

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | cardNumberlast4digit | cvv |
      | TorRegEmailId05 | CDRegEmailPass1 | GBP      | 200.00 |                 8453 | 555 |

  @TorFX_PID-4269_ADD_CURRENCY_TC_02 @TorAddwalletLot3
  Scenario Outline: 13.4 To verify that user perform Pay in journey using 3d card.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should navigate to payment method screen
    When ios user selects a saved card "<cardNumberlast4digit>" to buy a currency
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user click on Back button
    Then ios user should navigate to payment method screen
    When ios user selects a saved card "<cardNumberlast4digit>" to buy a currency
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    Then ios user should land on threed card page
    When ios user submits threed card response
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | cardNumberlast4digit | cvv |
      | TorRegEmailId05 | CDRegEmailPass1 | GBP      | 200.00 |                 8453 | 555 |

  @TorFX_PID-4269_ADD_CURRENCY_TC_03 @TorAddwalletLot3
  Scenario Outline: 13.1,13.2,13.5,12.16,12.17 To verify that user can add new 3d card successfully on buy currency
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    Then ios user should land on threed card page
    When ios user submits threed card response
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv |
      | TorRegEmailId05 | CDRegEmailPass1 | GBP      | 200.00 | 3d             | 6759649826438453 |            1120 |             1125 | 555 |

  @TorFX_PID-3939_ADD_CURRENCY_TC_01 @TorFX_PID-4049_ADD_CURRENCY_TC_02 @TorAddwalletLot3
  Scenario Outline: 8.13,12.8-12.17,12.13,12.14,12.16,12.17 To verify that user is performed the buy currency journey using new 3d card
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    Then ios user should land on threed card page
    When ios user submits threed card response
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv |
      #| CDRegEmailId30 | CDRegEmailPass1 | EUR      | GBP            | 400.00 | 3d             | 4462030000000000 |            1120 |             1125 | 555 |
      | TorRegEmailId05 | CDRegEmailPass1 | GBP      | EUR            | 200.00 | 3d             | 4462030000000000 |            1120 |             1125 | 555 |

  @TorFX_PID-3797_ADD_CURRENCY_TC_01 @TorAddwalletLot3
  Scenario Outline: 12.6 To verify that when user selects any card from available list then enter 2digit CVV field then continue button gets disabled
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    #And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects a saved card "<cardNumberlast4digit>" to buy a currency
    # When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    Then continue button should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount | cardNumberlast4digit | cvv |
      | TorRegEmailId02 | CDRegEmailPass1 | CAD      | EUR            | 200.00 |                 4444 |  12 |

  @TorFX_PID-3939_ADD_CURRENCY_TC_03 @TorAddwalletLot3
  Scenario Outline: 11.1 To verify 3d card journey get successfully done when user click on back and forth page on review screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should navigate to payment method screen
    When ios user selects a saved card "<cardNumberlast4digit>" to buy a currency
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user click on Back button
    Then ios user should navigate to payment method screen
    When ios user selects a saved card "<cardNumberlast4digit>" to buy a currency
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    Then ios user should land on threed card page
    When ios user submits threed card response
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | cardNumberlast4digit | cvv |
      | TorRegEmailId05 | CDRegEmailPass1 | GBP      | 200.00 |                 4444 | 555 |

  @TorFX_PID-4049_ADD_CURRENCY_WALLET_PYT_TC_08 @Torfx_iOS_sanity @TorAddwalletLot3
  Scenario Outline: 12.18,12.19,12.20,12.21,12,22 To verify the deal to be processed successfully when user initiates the Add currency transaction with wallet payment method
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    When ios user select wallet as payment method
    Then you pay currency "<youPayCurrency>" wallet should be displayed with balance in ios app
    When ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details
    # Then by default bank account details section should be displayed on buy currency confirmation screen
    # When ios user click on Top-up details
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option from wallet screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount |
      | TorRegEmailId01 | CDRegEmailPass1 | EUR      | GBP            | 200.00 |

  @TorFX_PID-4049_ADD_CURRENCY_WALLET_PYT_TC_09 @TorAddwalletLot3
  Scenario Outline: To verify the Payment method to be in Inactive state if its not supported.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    And bank transfer payment method should be in active state
    And wallet payment method should be in inactive state
    And debit card payment method should be in inactive state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | CAD      | USD            | 200.00 |

  @TorFX_PID-4045_TC_1113 @TorAddwalletLot3
  Scenario Outline: To verify the Payment method to be in Inactive state if its not supported.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    #And debit card payment method should be in active state
    And wallet payment method should be in inactive state
    And bank transfer payment method should be in inactive state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | EUR      | USD            | 200.00 |

  @TorFX_PID-4049_ADD_CURRENCY_TC_10 @TorAddwalletLot4
  Scenario Outline: To verify when sell currency is USD and sell amount less than or equal to available balance then in payment method :
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    #And bank transfer payment method should be in active state on buy currency screen
    And bank transfer payment method should be in active state
    #And debit card payment method should be in active state on buy currency screen
    And wallet payment method should be in inactive state

    #And wallet payment method should be in inactive state on buy currency screen
    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | EUR      | USD            | 300.00 |

  @TorFX_PID-4049_ADD_CURRENCY_TC_11 @TorAddwalletLot4
  Scenario Outline: To verify when sell currency is USD and sell amount less than or equal to available balance then in payment method
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    #And wallet payment method should be in active state on buy currency screen
    And wallet payment method should be in inactive state
    #And bank transfer payment method should be in active state on buy currency screen
    And bank transfer payment method should be in active state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | CAD      | USD            | 300.00 |

  @TorFX_PID-4049_ADD_CURRENCY_TC_12 @TorAddwalletLot4
  Scenario Outline: To verify when sell currency is other than USD and sell amount less than or equal to available balance then in payment method
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    #And wallet payment method should be in active state on buy currency screen
    And wallet payment method should be in inactive state
    #And bank transfer payment method should be in active state on buy currency screen
    And bank transfer payment method should be in active state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | CAD      | USD            | 300.00 |

  @TorFX_PID-4049_ADD_CURRENCY_TC_13
  Scenario Outline: 12.18,12.19,12.20,12.21,12,22 To verify the deal to be processed successfully when user initiates the Add currency transaction with wallet payment method
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    When ios user select bank transfer as payment method
    When ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user click on terms and condition link
    Then terms and condition page should be displayed to ios user
    When ios user clicks on back button
    Then ios user should navigate to review screen
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details
    Then by default bank account details section should be displayed on buy currency confirmation screen
    When ios user click on Top-up details
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    And ios user click done button on top up details screen
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | EUR      | GBP            | 300.00 |

  @TorFX_PID-4049_ADD_CURRENCY_TC_14
  Scenario Outline: 12.18,12.19,12.20,12.21,12,22 To verify the deal to be processed successfully when user initiates the Add currency transaction with wallet payment method
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    When ios user select bank transfer as payment method
    When ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user click on terms and condition link
    Then terms and condition page should be displayed to ios user
    When ios user clicks on back button
    Then ios user should navigate to review screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount |
      | TorRegEmailId02 | CDRegEmailPass1 | EUR      | GBP            | 300.00 |

  @TorFX_PID-4043_TC_8_SendWallet @TorAddwalletLot4
  Scenario Outline: To verify by default available wallet amount should be displayed on send from wallet screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user selects the send option from the wallet transaction screen
    Then default available wallet amount "<amount>" should be displayed on send from wallet screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount   |
      | TorRegEmailId02 | CDRegEmailPass1 | EUR      | 1,000.00 |

  @TorFX_PID-4043_TC_9_SendWallet @TorAddwalletLot4
  Scenario Outline: To verify send from wallet screen should be displayed when user click on back arrow button on select recipient screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user selects the send option from the wallet transaction screen
    #Then available wallet balance should be displayed on send from wallet screen
    And ios user click on continue button
    Then ios user should land on select recipient screen
    When ios user click on back button
    Then ios user should land on send from wallet screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency |
      | TorRegEmailId02 | CDRegEmailPass1 | EUR      |

  @TorFX_PID-4043_TC_10_SendWallet @TorAddwalletLot4
  Scenario Outline: To verify user should be land on select recipient screen when user click back button on payment method screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user selects the send option from the wallet transaction screen
    And ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then ios user should navigate to payment method screen
    When ios user click on back button
    Then ios user should land on select recipient screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | recipientName | accountNumber |
      | TorRegEmailId02 | CDRegEmailPass1 | EUR      | 700.00 | T T           |      33665544 |

  @TorFX_PID-4043_TC_11_SendWallet @TorAddwalletLot4
  Scenario Outline: To verify that continue button should be disabled when user land on payment method screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user selects the send option from the wallet transaction screen
    And ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then ios user should navigate to payment method screen
    Then continue button should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | recipientName | accountNumber |
      | TorRegEmailId02 | CDRegEmailPass1 | EUR      | 700.00 | T T           |      33665544 |

  @TorFX_ADD_WALLET5
  Scenario Outline: To verify user should be land on terms and condition screen when user click terms and condition link on review screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user selects the send option from the wallet transaction screen
    And ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then ios user should navigate to payment method screen
    And ios user selects payement reason "<paymentReason>" in standalone journey
    Then continue button should be in enabled state in ios app
    When ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user click on terms and condition link
    Then terms and condition page should be displayed to ios user
    When ios user clicks on back button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | recipientName | currency | accountNumber | paymentReason     |
      | TorRegEmailId02 | CDRegEmailPass1 | EUR      | 700.00 | T T           | GBP      |      33665544 | Sending to Family |

  @TorFX_PID-4043_TC_7_SendWallet @Torfx_iOS_sanity @TorAddwalletLot4 @TorFX_iOS_2FA
  Scenario Outline: To verify send wallet journey to be sucessful when user add the new recipent and process the journey
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user selects the send option from the wallet transaction screen
    And ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should land on select recipient screen
    When ios user selects an option to add a new recipient during send money journey
    And ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    And non editable recipient currency should be auto set as they get currency "<currency>" in ios app
    And ios user enters account number "<accountNo>" base on country"<country>"currency"<currency>"
    And ios user enters swift code "<swiftCode>"
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should navigate to payment method screen
    And ios user selects payement reason "<paymentReason>" in standalone journey
    Then continue button should be in enabled state in ios app
    When ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then deal confirmation screen should be displayed with correct mapped details in ios app
    When ios user click on the done button

    #When ios user removes account by using manage device option from wallet screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | amount | recipientType | recipientName   | country | currency | accountNo | swiftCode | environment | paymentReason     |
      | TorRegEmailId01 | CDRegEmailPass1 | GBP      | 300.00 | Individual    | Andrew Peterson | Albania | GBP      |  12345675 | PUPPALTR  | UAT         | Sending to Family |

  @TorFX_PID-328 @TorAddwalletLot4
  Scenario Outline: To verify 3d card journey by selecting pay in method
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user click on Back button
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    Then ios user should land on threed card page
    When ios user submits threed card response
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv |
      | TorRegEmailId05 | CDRegEmailPass1 | GBP      | EUR            | 300.00 | 3d             | 6759649826438453 |            1120 |             1125 | 555 |

  @Torfx_iOS_sanity @PID-060 @TorAddwalletLot4
  Scenario Outline: To verify that user is performed the buy currency journey using new non 3d card
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option from wallet screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country                  | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason     | reference      | environment |
      | TorRegEmailId01 | CDRegEmailPass1 | GBP            | USD             | 300.00 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |  12345675 | ABA          | 083900363 | Peter          | 6759649826438453 |            1120 |             1125 | 555 | Sending to Family | Test-Reference | SIT         |

  @TorFX_FraudSight_Scenario @TorAddwalletLot4
  Scenario Outline: 13.6,13.7,13.8 To verify that dealer initiate instruction using existing 3d card.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    #And card "<cardNumber>" details should be saved in ios app debit card payment method list
    #When ios user selects saved card "<cardNumber>" to make a transfer
    When ios user selects a saved card "<cardNumberlast4digit>" to buy a currency
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    Then ios user should land on threed card page
    When ios user submits threed card response
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount | cardHolderName | cardNumberlast4digit | issueDate(MMYY) | expiryDate(MMYY) | cvv |
      #| CDRegEmailId30 | CDRegEmailPass1 | EUR      | GBP            | 130,20 | 3d             |                 5454 |            1120 |             1125 | 555 |
      | TorRegEmailId05 | CDRegEmailPass1 | GBP      | EUR            | 300.00 | 3d             |                 8453 |            1120 |             1125 | 555 |

  @TorFX_FraudSight_Scenario_01 @TorAddwalletLot4
  Scenario Outline: To verify that dealer initiate instruction using existing non 3d invalid cvv card.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country                  | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason     | reference      | environment |
      #| CDRegEmailID33 | CDRegEmailPass  | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | Lincoln        | 5454545454545454 |            1120 |             1125 | 555 | Sending to Family | Test-Reference | SIT         |
      #| TorRegEmailId05 | CDRegEmailPass1 | EUR            | USD             | 300.00 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |  12345675 | ABA          | 083900363 | Smith          | 6759649826438453 |            1120 |             1125 | 555 | Sending to Family | Test-Reference | SIT         |
      | TorRegEmailId01 | CDRegEmailPass1 | GBP            | USD             | 300.00 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |  12345675 | ABA          | 083900363 | Peter          | 6759649826438453 |            1120 |             1125 | 555 | Sending to Family | Test-Reference | SIT         |

  @TorFX_FraudSight_Scenario_02 @TorAddwalletLot4
  Scenario Outline: To verify that dealer initiate instruction using existing 3d invalid cvv card.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    Then ios user should land on threed card page
    When ios user submits threed card response
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv |
      | TorRegEmailId05 | CDRegEmailPass1 | EUR      | GBP            | 300.00 | 3d             | 6759649826438453 |            1120 |             1125 | 266 |

  #| CDRegEmailId32 | CDRegEmailPass4 | EUR      | GBP            | 230,20 | 3d             | 6759649826438453 |            1120 |             1125 | 351 |
  @TorFX_PID-315 @TorAddwalletLot4
  Scenario Outline: To verify 3d card journey get successfully done when user click on back and forth screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    When ios user select bank transfer as payment method
    When ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user click on Back button
    Then ios user should navigate to payment method screen
    When ios user select debit card as payment method
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    Then ios user should land on threed card page
    When ios user submits threed card response
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv |
      | TorRegEmailId05 | CDRegEmailPass1 | EUR      | GBP            | 300.00 | 3d             | 6759649826438453 |            1120 |             1125 | 555 |

  @TorFX_PID-308 @TorAddwalletLot4
  Scenario Outline: To verify when user is on payment method page and press back then user should navigate towards buy currency page
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    When ios user click on Back button
    Then ios user land on send money screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv |
      | TorRegEmailId02 | CDRegEmailPass1 | EUR      | GBP            | 300.00 | Kemmy Watasons | 6759649826438453 |            1120 |             1125 | 555 |

  @TorFX_PID-3939_ADD_CURRENCY_TC_04 @TorAddwalletLot4
  Scenario Outline: To verify 3d card journey get successfully done when switches the apps to any external apps and come back and complete the flow
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user switch to other application "<SettingAppbundleId>"
    And reswitch to TorFX ios app "<IOSbundleId>"
    # Then ios app should load the last activity screen
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    Then ios user should land on threed card page
    When ios user submits threed card response
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | SettingAppbundleId    | IOSbundleId |
      | TorRegEmailId05 | CDRegEmailPass1 | EUR      | GBP            | 300.00 | 3d             | 6759649826438453 |            1120 |             1125 | 555 | iphoneSettingBundleId | IOSbundleId |

  @TorFX_PID-3939_ADD_CURRENCY_TC_05 @TorAddwalletLot4
  Scenario Outline: To verify 3d card journey get successfully done when switches the apps to any external apps and come back and complete the flow
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user click on payin button
    Then ios user land on send money screen
    When ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    When ios user switch to other application "<SettingAppbundleId>"
    And reswitch to TorFX ios app "<IOSbundleId>"
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    Then ios user should land on threed card page
    When ios user submits threed card response
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | currency | youPayCurrency | amount | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | SettingAppbundleId    | IOSbundleId |
      #| CDRegEmailId30 | CDRegEmailPass1 | GBP      | GBP            | 2130,20 | 3d             | 5454545454545454 |            1120 |             1125 | 555 | iphoneSettingBundleId | IOSbundleId |
      | TorRegEmailId05 | CDRegEmailPass1 | GBP      | GBP            | 300.00 | 3d             | 6759649826438453 |            1120 |             1125 | 555 | iphoneSettingBundleId | IOSbundleId |

  @TorFX_PID-4045_TC_51 @TorFX_PID-4269_ADD_CURRENCY_TC_01 @TorAddwalletLot2
  Scenario Outline: 13.6,13.7,13.8 To verify that dealer initiate instruction using existing non 3d card.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user click on Add button
    Then ios app user land on Add money screen
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should navigate to payment method screen
    #And card "<cardNumber>" details should be saved in ios app debit card payment method list
    # When ios user selects saved card "<cardNumber>" to make a transfer
    When ios user selects a saved card "<cardNumberlast4digit>" to buy a currency
    And ios user enters cvv "<cvv>"
    And ios user click on continue button
    Then ios user should navigate to review screen on buy currency
    When ios user submits the review page details on buy currency
    And deal confirmation buy currency screen should be displayed with correct mapped details in ios app
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country                  | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumberlast4digit | cvv | paymentReason     | reference      | environment |
      | TorRegEmailId01 | CDRegEmailPass1 | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |  12345675 | ABA          | 083900363 | Peter          |                 8453 | 555 | Sending to Family | Test-Reference | SIT         |

  @TorFX_PID-4043_TC_1_SendWallet @TorFX_PID-4317_TC_2_SendWallet_Button_Enable @TorAddwalletLot1
  Scenario Outline: 3.2 To verify the Send wallet journey to be processed successfully when user has available wallet balance.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user selects the wallet option from the home dashboard
    Then ios app user land on wallet screen and Add Wallet button should be displayed.
    And ios user selects a saved  "<currency>" wallet
    Then all the details of the wallet should be displayed as per "<currency>"
    When ios user selects the send option from the wallet transaction screen
    #Then default available wallet amount "<amount>" should be displayed on send from wallet screen
    And ios user enters transfer amount "<amount>"
    And ios user click on continue button
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then ios user should navigate to payment method screen
    And ios user selects payement reason "<paymentReason>" in standalone journey
    Then continue button should be in enabled state in ios app
    When ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then deal confirmation screen should be displayed with correct mapped details in ios app
    #When ios user click on the done button
    When ios user click on the done button on buy currency
    Then all the details of the wallet should be displayed as per "<currency>"

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | amount | recipientType | recipientName    | country                  | currency | accountNumber               | bankCodeType | bankCode | paymentReason | reference      |
      # | TorRegEmailId01 | CDRegEmailPass1 | 100.00 | Individual    | Andrew Peterson | United Kingdom | USD      |      12345675 | ABA          | 083900363 | Sending to Family | Test-Reference |
      | TorRegEmailId01 | CDRegEmailPass1 | 100.00 | Individual    | Frances Shuffler | Spain                    | EUR      |                    12457823 | SORT         |   200000 | Bill payments | Test-Reference |
      | TorRegEmailId01 | CDRegEmailPass1 | 100.00 | Company       | Frances Shuffler | United States Of America | USD      |                    12457823 | SORT         |   200000 | Bill payments | Test-Reference |
      | TorRegEmailId01 | CDRegEmailPass1 | 100.00 | Company       | Barclays Inc     | France                   | EUR      | FR1420041010050500013M02606 | SORT         |   200000 | Bill payments | Test-Reference |
      | TorRegEmailId01 | CDRegEmailPass1 | 100.00 | Individual    | Frances Shuffler | Canada                   | CAD      |                    12345678 | SORT         |   200000 | Bill payments | Test-Reference |
      | TorRegEmailId01 | CDRegEmailPass1 | 100.00 | Company       | Tata Services    | India                    | INR      |                    12345678 | SORT         |   200000 | Bill payments | Test-Reference |
      | TorRegEmailId01 | CDRegEmailPass1 | 100.00 | Company       | ICICI Bank       | Australia                | AUD      |                    12345678 | SORT         |   200000 | Bill payments | Test-Reference |
      | TorRegEmailId01 | CDRegEmailPass1 | 100.00 | Company       | TCS  Ltd         | South Africa             | ZAR      |                    12345678 | SORT         |   200000 | Bill payments | Test-Reference |
      | TorRegEmailId01 | CDRegEmailPass1 | 100.00 | Individual    | Andrew Peterson  | New Zealand              | NZD      |                    12345678 | SORT         |   200000 | Bill payments | Test-Reference |
      | TorRegEmailId01 | CDRegEmailPass1 | 100.00 | Individual    | Andrew Peterson  | Singapore                | SGD      |                    12345678 | SORT         |   200000 | Bill payments | Test-Reference |
      | TorRegEmailId01 | CDRegEmailPass1 | 100.00 | Individual    | Parle Inc        | United Kingdom           | EUR      | GB29NWBK60161331926819      | SORT         |   200000 | Bill payments | Test-Reference |
      | TorRegEmailId01 | CDRegEmailPass1 | 100.00 | Individual    | Parle Inc        | China                    | GBP      |                    12345678 | SORT         |   200000 | Bill payments | Test-Reference |
