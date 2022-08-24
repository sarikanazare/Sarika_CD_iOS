@TorFX_Recipient
Feature: Recipient Functionality :

  @TorFX_PID-3604_TC118 @TorRecipientlot1
  Scenario Outline: 2.1 To verify add recipient button on empty recipient list screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has no saved recipients previously
    Then an option to add a new recipient should be displayed in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId09 | CDRegEmailPass1 |

  @TorFX_PID-3604_TC119 @TorRecipientlot1
  Scenario Outline: 2.2 To verify add recipient list along with the option to add a new recipient.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    Then all the recipients should be displayed with the option to add a new recipient in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId08 | CDRegEmailPass1 |

  @TorFX_PID-3604_TC120 @TorRecipientlot1
  Scenario Outline: 2.3 2.4 To verify individual and company type recipients in the list screen has been displayed with name,currency code and masked account number except last four digits.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    Then each recipient in the list should be displayed with name,currency code and masked account number except last four digit in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId08 | CDRegEmailPass1 |

  #Will cover in view recipent
  @TorFX_PID-3604_TC121 @TorRecipientlot1
  Scenario Outline: 2.5 To verify selected individual or company type recipient details gets displayed on recipient view screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient "<recipientListData>"
    Then all the details of the recipient "<recipientViewData>" should be displayed as per country-currency "<country-currency>" in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | country-currency | recipientListData  | recipientViewData  |
      | TorRegEmailId08 | CDRegEmailPass1 | France-EUR       | RecipientListData1 | RecipientViewData1 |

  #| CDRegEmailID35 | CDRegEmailPass1 | AUS-AUD          | RecipientListData2 | RecipientViewData2 |
  #| CDRegEmailId3 | CDRegEmailPass | UK-GBP       		| RecipientListData3 | RecipientViewData3 |
  #| CDRegEmailId3 | CDRegEmailPass | USA-USD       	| RecipientListData4 | RecipientViewData4 |
  #| CDRegEmailId3 | CDRegEmailPass | CANADA-CAD      | RecipientListData5 | RecipientViewData5 |
  #| CDRegEmailId3 | CDRegEmailPass | INDIA-INR       | RecipientListData6 | RecipientViewData6 |
  @TorFX_PID-3604_TC122 @TorRecipientlot1
  Scenario Outline: 2.6 To check that when user clicks on the add new recipient button then user navigates to add a new recipient screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId08 | CDRegEmailPass1 |

  #Will cover in view recipent with @TorFX_PID-3604 @TorFX_PID-3604_TC121
  @TorFX_PID-3604_TC123 @TorRecipientlot1
  Scenario Outline: To check that when user close the recipient detail view then user navigates recipient list screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    # And ios user selects a saved recipient "<recipientListData>"
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    When ios user close the recipient view window
    Then all the recipients should be displayed with the option to add a new recipient in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientName   | currency | accountNo |
      #  | CDRegEmailId28 | CDRegEmailPass1 | USA-USD          | RecipientListData4 |
      | TorRegEmailId08 | CDRegEmailPass1 | Andrew Peterson | USD      |  12345675 |

  @TorFX_PID-3610_TC142 @TorRecipientlot1
  Scenario Outline: 8.1 To verify confirmation message to be displayed when user select delete recipient option.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user clicks on delete recipient button
    Then delete confirmation message window should be displayed in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientName   | currency | accountNo |
      | TorRegEmailId08 | CDRegEmailPass1 | Andrew Peterson | USD      |  12345675 |

  @TorFX_PID-3610_TC143 @TorRecipientlot1
  Scenario Outline: To verify that user lands on delete confirmation screen and delete functionality work as it when user visit application and come back
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user clicks on delete recipient button
    Then delete confirmation message window should be displayed in ios app
    When ios user switch to other application "<iphoneMessageBundleId>"
    And reswitch to cd ios app "<IOSbundleId>" after seconds <miliSeconds>
    Then delete confirmation message window should be displayed in ios app
    When ios user accepts recipient delete confirmation
    Then ios user should be navigated to recipient list screen
    And recipient with the details name "<recipientName>" currency "<currency>" account no "<accountNo>" should be deleted from the ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientName   | currency | accountNo | iphoneMessageBundleId | IOSbundleId | miliSeconds |
      | TorRegEmailId08 | CDRegEmailPass1 | Andrew Peterson | USD      |  12345675 | iphoneMessageBundleId | IOSbundleId |        5000 |

  @TorFX_CD_PID-3605_TC170 @Torfx_iOS_sanity @TorRecipientlot1 @TorFX_iOS_2FA
  Scenario Outline: 3.17 3.18 To verify when user enters all mandatory recipient data and completes OTP process then user should navigate to updated recipient list screen with newly added recipient at the top of list.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    # And ios address details fields should be displayed to applicable country currency
    # When ios user enters country specific required address "<address>" field data to add recipient
    # And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen

    #When ios user removes account by using manage device option from recipients screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName    | country | currency | address  | accountNumber | bankCodeType | bankCode                      | environment |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Frances Shuffler | Spain   | USD      | SpainAdd |      12457823 | IBAN         | ES91 2100 0418 4502 0005 1332 | UAT         |

  @TorFX_PID-3605_TC1712 @TorFX_iOS_2FA
  Scenario Outline: 3.17 3.18 To verify when user enters all mandatory recipient data and completes OTP process then user should navigate to updated recipient list screen with newly added recipient at the top of list.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen

    #When ios user removes account by using manage device option from recipients screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName    | country                  | currency | address   | accountNumber               | bankCodeType   | bankCode    | environment |
      | TorRegEmailId08 | CDRegEmailPass1 | Company       | Frances Shuffler | United States Of America | USD      | USAAdd    |                    12457823 | ABA            |   083900363 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Company       | Barclays Inc     | France                   | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN           | NA          | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Frances Shuffler | Canada                   | CAD      | CanadaAdd |                    12345678 | Routing number |   017700000 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Company       | Tata Services    | India                    | INR      | IndiaAdd  |                    12345678 | IFSC           | SBIN0000575 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Company       | ICICI Bank       | Australia                | AUD      | AUSAdd    |                    12345678 | BSB            |      012002 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Company       | TCS  Ltd         | South Africa             | ZAR      | UKAdd     |                    12345678 | Branch code    |      200309 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson  | New Zealand              | NZD      | USAAdd    |                    12345678 | BSB            |      060188 | UAT         |

  @TorFX_PID-3605_TC172 @TorFX_iOS_2FA
  Scenario Outline: 3.17 3.18 To verify when user enters all mandatory recipient data and completes OTP process then user should navigate to updated recipient list screen with newly added recipient at the top of list.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    #And ios address details fields should be displayed to applicable country currency
    #When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    # When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen

    #When ios user removes account by using manage device option from recipients screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country        | currency | address | accountNumber          | bankCodeType | bankCode | environment |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | Singapore      | SGD      | USAAdd  |               12345678 | SWIFT        | AMCLNZ21 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Parle Inc       | United Kingdom | EUR      | UKAdd   | GB29NWBK60161331926819 | IBAN         | NA       | UAT         |

  @TorFX_PID-3605_TC173 @TorFX_iOS_2FA
  Scenario Outline: 3.17 3.18 To verify when user enters all mandatory recipient data and completes OTP process then user should navigate to updated recipient list screen with newly added recipient at the top of list.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    #And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen

    #When ios user removes account by using manage device option from recipients screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country | currency | address | accountNumber | bankCodeType | bankCode     | environment |
      | TorRegEmailId08 | CDRegEmailPass1 | Company       | TCS  Ltd      | China   | GBP      | UKaAdd  |      12345678 | CNAPS Code   | 501100000011 | UAT         |

  @TorFX_PID-3610_TC144 @Torfx_iOS_regression @TorRecipientlot1
  Scenario Outline: 8.4 To verify that user should be land on selected edit recipient screen when user cancels the recipient delete confirmation.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user clicks on delete recipient button
    Then delete confirmation message window should be displayed in ios app
    When ios user dismiss recipient delete confirmation
    Then ios user should be land on selected recipent edit screen

    #When ios user removes account by using manage device option from payment method screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientName   | currency | accountNo |
      # | CDRegEmailID35 | CDRegEmailPass1 | David Morris  | USD      | 874565122 |
      | TorRegEmailId08 | CDRegEmailPass1 | Andrew Peterson | USD      |  12345675 |

  # | CDRegEmailID35 | CDRegEmailPass1 | galler stone  | EUR      | FR1420041010050500013M02606 |
  @TorFX_PID-3610_TC145 @Torfx_iOS_sanity @TorRecipientlot1
  Scenario Outline: 8.2 8.3 To verify that individual and company recipient get deleted from the recipients list when user accepts the recipient delete confirmation.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user clicks on delete recipient button
    Then delete confirmation message window should be displayed in ios app
    When ios user accepts recipient delete confirmation
    Then ios user should be navigated to recipient list screen
    And recipient with the details name "<name>" currency "<currency>" account no "<accountNo>" should be deleted from the ios app

    #When ios user removes account by using manage device option from recipients screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientName    | currency | accountNo |
      | TorRegEmailId08 | CDRegEmailPass1 | Frances Shuffler | USD      |  12457823 |

  #| ProductionUAT | CDRegEmailPass |John Peter  | USD      |                   12457823 |
  #| CDRegEmailId | CDRegEmailPass | David Peterson | USD      |                  8745145110 |
  #| CDRegEmailId | CDRegEmailPass | Michael Hussy  | AUD      |                   874564545 |
  #| CDRegEmailId | CDRegEmailPass | John Mike      | GBP      |                    45121245 |
  #| CDRegEmailId | CDRegEmailPass | Steve Smith    | NZD      |                   458712454 |
  #| CDRegEmailId | CDRegEmailPass | Steve Smith    | EUR      | FR1420041010050500013M02606 |
  ##############################Add Recipient###############################
  @TorFX_PID-3607_TC146 @TorRecipientlot2
  Scenario Outline: 5.2 4.3 To verify that application search the available countries list in micro second by using search option
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    Then matching country should be displayed in search result of ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | Spain   |

  #| CDRegEmailId28 | CDRegEmailPass1 | Company       | Andrew Peterson | UK      |
  @TorFX_PID-3607_TC147 @TorRecipientlot2
  Scenario Outline: 4.3 To verify that empty state of country list should be displayed along with a message indicating no results have been returned
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    Then empty state country list should be displayed in ios app along with no result message

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country   |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | Spaindfds |

  @TorFX_PID-3607_TC148 @TorRecipientlot2
  Scenario Outline: 5.4 To verify that when user selects the close icon in the country search field then the country filter should be cleared
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    Then matching country should be displayed in search result of ios app
    When ios user click on search currency (X) option
    Then the filter should be cleared and the whole country list should be displayed on ios screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | Spain   |

  @TorFX_PID-3607_TC149 @TorRecipientlot2
  Scenario Outline: To verify user land on add recipient screen on click on back option option on country selection
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    Then matching country should be displayed in search result of ios app
    When ios user clicks on the back button
    Then add recipient screen should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | Spain   |

  @TorFX_PID-3607_TC0149 @TorRecipientlot2
  Scenario Outline: 5.5 5.6 5.7 To verify that when user selects a country then the app should take the user back to add recipient screen with the selected country
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    Then matching country should be displayed in search result of ios app
    When ios user selects the country from searched result list "<country>"
    Then add recipient screen should be displayed to ios user
    And selected country "<country>" should be displayed in country dropdown to add recipient

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | India   |

  @TorFX_PID-3606_TC150 @TorRecipientlot2
  Scenario Outline: 4.2 4.3 To verify that application search the available currency list in micro second by using search option
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    Then matching country should be displayed in search result of ios app
    When ios user selects the country from searched result list "<country>"
    Then add recipient screen should be displayed to ios user
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    Then matching currency should be displayed in search result of ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      |

  @TorFX_PID-3607_TC0150 @Torfx_iOS_regression @TorRecipientlot2
  Scenario Outline: To verify user land on add recipient screen on click on back option option on currency selection screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    Then matching country should be displayed in search result of ios app
    When ios user selects the country from searched result list "<country>"
    Then add recipient screen should be displayed to ios user
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    Then matching currency should be displayed in search result of ios app
    When ios user clicks on the back button
    Then add recipient screen should be displayed to ios user

    #When ios user removes account by using manage device option from add recipient screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      |

  @TorFX_PID-3606_TC151 @TorRecipientlot2
  Scenario Outline: 4.3 To verify that empty state of currency list should be displayed along with a message indicating no results have been returned
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    Then matching country should be displayed in search result of ios app
    When ios user selects the country from searched result list "<country>"
    Then add recipient screen should be displayed to ios user
    And selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    Then empty state currency list should be displayed in ios app along with no result message on add recipient window

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | aafhjk   |

  @TorFX_PID-3606_TC152 @TorRecipientlot2
  Scenario Outline: 4.4 To verify that when user selects the close icon in the currency search field then the currency filter should be cleared
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    Then matching country should be displayed in search result of ios app
    When ios user selects the country from searched result list "<country>"
    Then add recipient screen should be displayed to ios user
    And selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    Then matching currency should be displayed in search result of ios app
    When ios user click on search currency (X) option
    Then the filter should be cleared and the whole currency list should be displayed on ios screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      |

  @TorFX_PID-3606_TC153 @TorRecipientlot2
  Scenario Outline: 4.5 4.6 4.7 To verify that when user selects a currency then the app should take the user back to add recipient screen with the selected currency
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    Then matching country should be displayed in search result of ios app
    When ios user selects the country from searched result list "<country>"
    Then add recipient screen should be displayed to ios user
    And selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<currency>"
    Then add recipient screen should be displayed to ios user
    And selected country "<country>" should be displayed in country dropdown to add recipient

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      |

  @TorFX_PID-3606_TC154 @TorRecipientlot2
  Scenario Outline: 4.9 5.9 To verify that address fields gets displayed for applicable country currency
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    Then matching country should be displayed in search result of ios app
    When ios user selects the country from searched result list "<country>"
    Then add recipient screen should be displayed to ios user
    And selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<currency>"
    Then add recipient screen should be displayed to ios user
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      |

  # | CDRegEmailId28 | CDRegEmailPass1 | Individual    | Andrew Peterson    | CANADA    | USD      |
  #| CDRegEmailId28 | CDRegEmailPass1 | Individual    | Andrew Peterson    | Australia | USD      |
  #Applicable address country : BHD/CAD/USD/AUD/NZD/ZAR/RUB
  @TorFX_PID-3606_TC155 @TorRecipientlot2
  Scenario Outline: 4.10 5.9  To verify that address fields should not be displayed to if user selects other than specific currency.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    Then matching country should be displayed in search result of ios app
    When ios user selects the country from searched result list "<country>"
    Then add recipient screen should be displayed to ios user
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And address details fields should not be displayed to applicable country currency

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country        | currency |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United Kingdom | GBP      |

  #| CDRegEmailId1 | CDRegEmailPass | Individual    | Adam Watson   | France  | EUR      |
  @TorFX_PID-3605_TC0156 @TorRecipientlot2
  Scenario Outline: To verify user land on recopient list screen on click on “X” close option on ‘Add recipient’ screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user close the add recipient window
    Then all the recipients should be displayed with the option to add a new recipient in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 026009593 | UAT         |

  @TorFX_PID-3605_TC156 @TorRecipientlot2
  Scenario Outline: 3.2 3.3 To verify that continue button is in disabled state when user do not provides or removes one of the mandatory personal details field data(First or Last or Company name).
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user removes one of the mandatory personal field data base on recipient type "<recipientType>"
    Then continue button should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment |
      | TorRegEmailId08 | CDRegEmailPass1 | Company       | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 026009593 | UAT         |

  # | CDRegEmailId3 | CDRegEmailPass | Individual    | Johnny Watson | USA     | USD      | USAAdd  |      12345675 | SWIFT        | USBKUS44 | SIT         |
  @TorFX_PID-3605_TC157 @TorRecipientlot2
  Scenario Outline: 3.2 3.3 To verify that continue button is in disabled state when user do not provides or removes one of the mandatory bank details field data
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user removes one of the mandatory bank field data "<mandatoryField>"
    Then continue button should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment | mandatoryField |
      | TorRegEmailId08 | CDRegEmailPass1 | Company       | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 026009593 | UAT         | ABA            |

  # | CDRegEmailId3 | CDRegEmailPass | Individual    | Johnny Watson    | USA     | USD      | USAAdd    |                    12345675 | ABA          |   083900363 | SIT         | ABA            |
  #| CDRegEmailId3 | CDRegEmailPass | Individual    | Adam Watson      | UK      | GBP      | UKAdd     |                    12345678 | SORT         |      111213 | SIT         | SORT           |
  #| CDRegEmailId3 | CDRegEmailPass | Individual    | Frances Shuffler | Canada  | CAD      | CanadaAdd |                    12345678 | Transit      |   000305054 | SIT         | Transit        |
  # | CDRegEmailId3 | CDRegEmailPass | Company       | Barclays inc     | France  | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN         | NA          | SIT         | IBAN           |
  #| CDRegEmailId3 | CDRegEmailPass | Company       | Tata Services    | India   | INR      | IndiaAdd  |                    12345678 | IFSC         | SBIN0000575 | SIT         | IFSC           |
  #  | CDRegEmailId3 | CDRegEmailPass | Individual    | Gloria Walters   | Australia | AUD      | AUSAdd    |                    12345678 | BSB          |      032929 | SIT         | BSB            |
  @TorFX_PID-3605_TC158 @TorRecipientlot3
  Scenario Outline: 3.2 3.3 To verify that continue button is in disabled state when user do not provides or removes one of the mandatory address details field data(AddressLine1,City,PostCode).
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user removes one of the mandatory address field data
    Then continue button should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment |
      | TorRegEmailId09 | CDRegEmailPass1 | Company       | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 026009593 | UAT         |

  #| CDRegEmailId3 | CDRegEmailPass | Individual    | Johnny Watson | USA     | USD      | USAAdd  |      12345675 | ABA          | 083900363 | SIT         |
  @TorFX_PID-3605_TC159 @TorRecipientlot3
  Scenario Outline: 3.4  To verify that continue button is in enabled state when user enters all the required recipient data .
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment | mandatoryField |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         | ABA            |

  # | CDRegEmailId3 | CDRegEmailPass | Individual    | Adam Watson      | UK        | GBP      | UKAdd     |                    12345678 | SORT         |      111213 | SIT         | SORT           |
  #| CDRegEmailId3 | CDRegEmailPass | Individual    | Frances Shuffler | Canada    | CAD      | CanadaAdd |                    12345678 | Transit      |   000305054 | SIT         | Transit        |
  #| CDRegEmailId3 | CDRegEmailPass | Company       | Barclays inc     | France    | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN         | NA          | SIT         | IBAN           |
  #| CDRegEmailId3 | CDRegEmailPass | Company       | Tata Services    | India     | INR      | IndiaAdd  |                    12345678 | IFSC         | SBIN0000575 | SIT         | IFSC           |
  #| CDRegEmailId3 | CDRegEmailPass | Individual    | Gloria Walters   | Australia | AUD      | AUSAdd    |                    12345678 | BSB          |      032929 | SIT         | BSB            |
  @TorFX_PID-3605_TC160 @TorRecipientlot3
  Scenario Outline: 3.7 3.8 3.9 5.8 5.9 To verify that when user enters valid account number,swift code and user moves focus from respective field then application fetch the bank details by validating the entered bank data
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName     | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment |
      | TorRegEmailId09 | CDRegEmailPass1 | Company       | Currencies Direct | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 026009593 | UAT         |

  # | CDRegEmailId3 | CDRegEmailPass | Individual    | Pedro Thompson    | British Virgin Islands | GBP      | UKAdd   |      12345678 | SWIFT        | FCIBVGVGXXX | SIT         |
  #| CDRegEmailId3 | CDRegEmailPass | Company       | ICICI Bank        | Australia              | AUD      | AUSAdd  |      12345678 | SWIFT        | CPANAU21    | SIT         |
  #| CDRegEmailId28 | CDRegEmailPass1 | Individual    | Andrew Peterson   | New Zealand            | NZD      | USAAdd  |      12345678 | SWIFT        | AMCLNZ21    | UAT         |
  @TorFX_PID-3605_TC161 @TorRecipientlot3
  Scenario Outline: 3.7 3.8 3.9 To verify that when user enters valid account number and bank SORT,BSB,Transit ,ABA or IFSC code and user moves focus from respective field then application fetch the bank details by validating the entered bank data
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName  | country   | currency | address | accountNumber | bankCodeType | bankCode | environment |
      #| CDRegEmailId3 | CDRegEmailPass | Individual    | Johnny Watson    | USA       | USD      | USAAdd    |               12345675 | ABA          |   083900363 | SIT         |
      #| CDRegEmailId28 | CDRegEmailPass1 | Individual    | Adam Watson      | UK        | GBP      | UKAdd     |               12345678 | SORT         |      111213 | UAT         |
      # | CDRegEmailId28 | CDRegEmailPass1 | Company       | Parle Inc        | UK        | EUR      | UKAdd     | GB29NWBK60161331926819 | IBAN         | NA          | UAT         |
      #| CDRegEmailId28 | CDRegEmailPass1 | Company       | Tata Services    | India     | INR      | IndiaAdd  |               12345678 | IFSC         | SBIN0000575 | UAT         |
      # | CDRegEmailId3 | CDRegEmailPass | Individual    | Frances Shuffler | Canada    | CAD      | CanadaAdd |               12345678 | Transit      |   000305054 | SIT         |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Gloria Walters | Australia | AUD      | AUSAdd  |      12345678 | BSB          |   032929 | UAT         |

  #Note : The address line should be uncommented if the user belongs to CDINC legal entity ,for CDLGB user it should be commented
  @TorFX_PID-3605_TC162 @TorRecipientlot3
  Scenario Outline: 3.10 To verify error message for invalid account number for UK-GBP country currency when users revisits the same field again and corrects the data then error message gets removed.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    # And ios address details fields should be displayed to applicable country currency
    # When ios user enters country specific required address "<address>" field data to add recipient
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    When ios user enters account number "<inValidAccountNumber>" base on country"<country>"currency"<currency>"
    Then invalid account number error message should be displayed to ios user
    And continue button should be in disabled state in ios app
    When ios user enters valid account number "<accountNumber>" base on country"<country>"currency"<currency>"
    Then invalid account number error message should be removed from the ios app add recipient screen
    And continue button should be in enabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | accountNumber | bankCodeType | bankCode | environment | inValidAccountNumber |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Adam Watson   | United Kingdom | GBP      |      12345678 | SORT         |   111213 | UAT         |               123456 |

  #Need to revisit code once developed ,error message displayed
  @TorFX_PID-3605_TC163 @TorRecipientlot3
  Scenario Outline: 3.10 To verify error message for invalid bank SORT,BSB,Transit,ABA or IFSC code
    when users revisits the same field again and corrects the data then error message should be removed.

    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<inValidBankCode>"base on country"<country>"currency"<currency>"
    Then invalid bank code "<bankCodeType>" error message should be displayed to ios user
    And continue button should be in disabled state in ios app
    When ios user enters valid bank code "<validBankCode>" base on bank code type"<bankCodeType>"
    #Then invalid bank code "<bankCodeType>" error message should be removed from ios app add recipient screen
    And continue button should be in enabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country                  | currency | address | accountNumber | validBankCode | bankCodeType | inValidBankCode | environment |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Johnny Watson | United States Of America | USD      | USAAdd  |      12345675 |     083900363 | ABA          |      0845654545 | UAT         |

  # | CDRegEmailId3 | CDRegEmailPass | Individual    | Adam Watson      | UK      | GBP      | UKAdd     |      12345678 | SORT         |        111213 |        11110201 | SIT         |
  #| CDRegEmailId3 | CDRegEmailPass | Company       | Tata Services    | India   | INR      | IndiaAdd  |      12345678 | IFSC         | SBIN0000575   | SBA65414231     | SIT         |
  #| CDRegEmailId3 | CDRegEmailPass | Individual    | Frances Shuffler | Canada  | CAD      | CanadaAdd |      12345678 | Transit      |     000305054 |       454212154 | SIT         |
  @TorFX_PID-3605_TC164 @TorRecipientlot3
  Scenario Outline: 3.10 To verify error message for invalid IBAN and when users revisits the same field
    again and corrects the data then error message should be removed.

    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    #And ios address details fields should be displayed to applicable country currency
    #When ios user enters country specific required address "<address>" field data to add recipient
    #And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    #And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    And ios user enters invalid IBAN "<inValidIBAN>"
    Then invalid bank code "<bankCodeType>" error message should be displayed to ios user
    And continue button should be in disabled state in ios app
    And ios user enters valid IBAN "<validIBAN>"
    Then invalid bank code "<bankCodeType>" error message should be removed from ios app add recipient screen
    And continue button should be in enabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country | currency | inValidIBAN      | bankCodeType | validIBAN                         | environment |
      | TorRegEmailId09 | CDRegEmailPass1 | Company       | Parle Inc     | France  | EUR      | GANESH5465454546 | IBAN         | FR14 2004 1010 0505 0001 3M02 606 | UAT         |

  @TorFX_PID-3605_TC165 @TorRecipientlot3
  Scenario Outline: 3.10 To verify error message for invalid SWIFT code and when users revisits the same field
    again and corrects the data then error message should be removed.

    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    #And ios address details fields should be displayed to applicable country currency
    #When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters invalid IBAN "<inValidIBAN>"
    Then invalid bank code "<bankCodeType>" error message should be displayed to ios user
    And continue button should be in disabled state in ios app
    And ios user enters valid IBAN "<validIBAN>"
    Then invalid bank code "<bankCodeType>" error message should be removed from ios app add recipient screen
    And continue button should be in enabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName     | country | currency | address | accountNumber | bankCodeType | bankCode | environment | inValidIBAN | validIBAN                         |
      | TorRegEmailId09 | CDRegEmailPass1 | Company       | Currencies Direct | France  | EUR      | USAAdd  |      12345675 | IBAN         | NA       | UAT         | dsj568g55   | FR14 2004 1010 0505 0001 3M02 606 |

  #  | CDRegEmailId3 | CDRegEmailPass | Individual    | Pedro Thompson    | British Virgin Islands | GBP      | UKAdd   |      12345678 | SWIFT        | FCIBVGVGXXX | SIT         |
  #  | CDRegEmailId3 | CDRegEmailPass | Company       | ICICI Bank        | Australia              | AUD      | AUSAdd  |      12345678 | SWIFT        | CPANAU21    | SIT         |
  #  | CDRegEmailId3 | CDRegEmailPass | Individual    | Barbara Mayberry  | New Zealand            | NZD      | USAAdd  |      12345678 | SWIFT        | AMCLNZ21    | SIT         |
  #Need to provide data with regex
  @TorFX_PID-3605_TC1651 @TorRecipientlot3 @TorFX_iOS_2FA
  Scenario Outline: 3.11 To check that application allow user to add recipient by enter recipient details using regex provided in the Global NFR document
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    #And ios address details fields should be displayed to applicable country currency
    #When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | address | accountNumber | bankCodeType | bankCode | environment |
      # | CDAddPayee   | CDRegEmailPass1 | Company       | Tata^\\-_&?'':(),+{}0-9/]+$ | UK      | GBP      | UKAdd   |      12345678 | SORT         |   111213 | UAT         |
      #| CDAddPayee   | CDRegEmailPass1 | Company       | bnt-soft | UK      | GBP      | UKAdd   |      12345678 | SORT         |   111213 | UAT         |
      | TorRegEmailId09 | CDRegEmailPass1 | Company       | AISSM         | United Kingdom | GBP      | UKAdd   |      12345678 | SORT         |   111213 | UAT         |

  # | CDRegEmailId3 | CDRegEmailPass | Individual    | JÒñhnny^\\-_&?'':(),+{}0-9/]+$ WatsÒñ^\\-_&?'':(),+{}0-9/]+$ | USA     | USD      | USARegxAdd |      12345675 | ABA          | 083900363 | SIT         |
  #Need to provide data with unsupported regex once NFR is finalised
  @TorFX_PID-3605_TC166 @TorRecipientlot3
  Scenario Outline: 3.12 To check that application does not allow user to enter unsupported special character except regex provided in the Global NFR document into text field and shows error icon.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    Then invalid personal field error message should be displayed
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    Then invalid address field error message should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName    | country | currency | address          | accountNumber | bankCodeType  | bankCode           | environment |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | ₹Pedro ₹Thompson | Canada  | CAD      | CanadaAddInvalid |      12345678 | Transit,SWIFT | 000305054,CPANAU21 | UAT         |

  # | CDRegEmailId3 | CDRegEmailPass | Company       | ₹Parle Inc       | UK                     | EUR      | UKAdd   | GB29NWBK60161331926819 | IBAN         | NA          | SIT         |
  @TorFX_PID-3605_TC167 @TorRecipientlot3
  Scenario Outline: 3.16 To check that when user enters all the mandatory recipients fields data and click on continue then OTP process should be triggered
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    #And ios address details fields should be displayed to applicable country currency
    #When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country | currency | address   | accountNumber               | bankCodeType | bankCode | environment |
      | TorRegEmailId09 | CDRegEmailPass1 | Company       | Barclays inc  | France  | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN         | NA       | UAT         |

  @TorFX_PID-3605_TC168 @TorRecipientlot3
  Scenario Outline: 3.16 To verify resend pin link functionality on add recipient screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    When ios user do not enters otp in sixty seconds
    Then resend pin link gets displayed on ios app pin screen
    When ios user click on resend pin
    Then request a new pin timer should be start for sixty seconds in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country | currency | address   | accountNumber               | bankCodeType | bankCode | environment |
      | TorRegEmailId09 | CDRegEmailPass1 | Company       | Barclays inc  | France  | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN         | NA       | UAT         |

  @TorFX_PID-3605_TC169 @TorRecipientlot3
  Scenario Outline: 3.19 To verify invalid OTP error message on add recipient otp screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    When ios user enters invalid otp "<otp>"
    Then invalid otp error message should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country | currency | address   | accountNumber               | bankCodeType | bankCode | environment |
      | TorRegEmailId09 | CDRegEmailPass1 | Company       | Barclays inc  | France  | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN         | NA       | UAT         |

  #ISSUE:NZD-SWIFT,CAD-Transit,Swift
  #Will develop code while view recipient screen
  #Unable to add Canada-CAD Australia-AUD, NZD-SWIFT Recipient issue raised need to revisit once resolved for CAD-Transit
  #ISSUE:NZD-SWIFT,CAD-Transit,Swift
  @TorFX_PID-4314_TC172 @TorRecipientlot3
  Scenario Outline: To verify default currency gets auto selected when user selects the country
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    And default currency should be displayed as per country "<country>" selected by ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName    | country     | currency | address | accountNumber | bankCodeType | bankCode | environment |
      # | CDRegEmailId3 | CDRegEmailPass | Individual    | Johnny Watson    | USA                    | USD      | USAAdd  |      12345675 | ABA          |   083900363 | SIT         |
      # | CDRegEmailId3 | CDRegEmailPass | Individual    | Pedro Thompson   | British Virgin Islands | GBP      | UKAdd   |      12345678 | SWIFT        | FCIBVGVGXXX | SIT         |
      # | CDRegEmailId3 | CDRegEmailPass | Company       | ICICI Bank       | Australia              | AUD      | AUSAdd  |      12345678 | SWIFT        | CPANAU21    | SIT         |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Barbara Mayberry | New Zealand | NZD      | USAAdd  |      12345678 | SWIFT        | AMCLNZ21 | UAT         |

  #Need to revisit once bug fixed PID-4508
  @TorFX_PID-3605_TC1732 @TorRecipientlot3 @TorFX_iOS_2FA
  Scenario Outline: To verify error message while adding duplicate payee
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    #And ios address details fields should be displayed to applicable country currency
    #When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then newly added recipient details should be displayed on recipient view screen to ios user
    When ios user close the recipient view window
    When ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    #And ios address details fields should be displayed to applicable country currency
    #When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then error message should be displayed as recipent already exist

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | address | accountNumber | bankCodeType | bankCode | environment |
      | TorRegEmailId09 | CDRegEmailPass1 | Company       | bnt-soft      | United Kingdom | GBP      | USAAdd  |      12345678 | SORT         |   111213 | UAT         |

  #Need to revisit once bank code error message finalised and implemenation done by dev team
  @TorFX_PID-3605_TC174 @TorRecipientlot4
  Scenario Outline: 3.10.1 To verify when server can not fetch the bank details system displays error message and previously displayed Bank name field for valid bank code should not be displayed
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user enters invalid bank code "<invalidBankCode>"
    Then invalid bank code "<bankCodeType>" error message should be displayed to ios user
    And previous bank details should be clear in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country                  | currency | address | accountNumber | bankCodeType | bankCode  | invalidBankCode |
      | TorRegEmailId10 | CDRegEmailPass1 | Individual    | Johnny Watson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | GANESH          |

  ############################EditRecipient#####################################
  @TorFX_PID-3609_TC175 @TorRecipientlot4
  Scenario Outline: 7.1 7.5 To verify that user lands on edit recipient screen when user clicks on the edit recipient icon present on the view recipient screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         |

  #| CDRegEmailId3 | CDRegEmailPass | Individual    | John Peter    | USA         | USD      | USAAdd    |                    12345675 | ABA          | 083900363 | SIT         |
  @TorFX_PID-3609_TC176 @TorRecipientlot4
  Scenario Outline: To verify that user lands on the view recipient screen when user clicks on the back button available on edit recipient screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user clicks on the back button present on edit recipient screen
    Then view recipient screen should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment |
      #| TorRegEmailId05 | CDRegEmailPass1 | Company       | Eclairs Inc   | USA     | USD      | USAAdd  |      12457823 | ABA          | 083900363 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         |

  #| CDRegEmailId3 | CDRegEmailPass | Individual    | John Peter    | USA         | USD      | USAAdd    |                    12345675 | ABA          | 083900363 | SIT         |
  #Only Error message validation is pending once developed by dev we will update the code
  @TorFX_PID-3609_TC177 @TorRecipientlot4
  Scenario Outline: 7.4 To verify that save recipient details button is in disabled state when user do not provides First name or Last name for individual recipient type.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user removes first name
    Then first name required error message should be displayed in ios app
    And the option to save the recipient details should be in disabled state in ios app
    When ios user removes last name
    Then last name required error message should be displayed in ios app
    And the option to save the recipient details should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment |
      #| TorRegEmailId05 | CDRegEmailPass1 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         |

  #| CDRegEmailId3 | CDRegEmailPass | Individual    | John Peter    | USA         | USD      | USAAdd    |                    12345675 | ABA          | 083900363 | SIT         |
  #Only Error message validation is pending once developed by dev we will update the code
  @TorFX_PID-3609_TC178 @TorRecipientlot4
  Scenario Outline: 7.4 To verify that save recipient details button is in disabled state when user do not provides company name.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user removes company name
    #Then last name required field error message should be displayed in ios app
    And the option to save the recipient details should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment |
      #| TorRegEmailId05 | CDRegEmailPass1 | Company       | Eclairs Inc   | USA     | USD      | USAAdd  |      12457823 | ABA          | 083900363 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Company       | Andrew Peterson | United States Of America | GBP      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         |

  #| CDRegEmailId3 | CDRegEmailPass | Individual    | John Peter    | USA         | USD      | USAAdd    |                    12345675 | ABA          | 083900363 | SIT         |
  #Only Error message validation is pending once developed by dev we will update the code
  @TorFX_PID-3609_TC179 @TorRecipientlot4
  Scenario Outline: 7.4 To verify that save recipient details button is in disabled state and application displays respective field error message when user does not provides the mandatory address field data (Address line1,City,Post code) .
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user removes address line
    Then address line required error message should be displayed in ios app
    And the option to save the recipient details should be in disabled state in ios app
    When ios user removes city
    Then city required error message should be displayed in ios app
    And the option to save the recipient details should be in disabled state in ios app
    When ios user removes post code
    Then post code required error message should be displayed in ios app
    And the option to save the recipient details should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment |
      #| TorRegEmailId05 | CDRegEmailPass1 | Company       | Eclairs Inc   | USA     | USD      | USAAdd  |      12457823 | ABA          | 083900363 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         |

  #| CDRegEmailId3 | CDRegEmailPass | Individual    | John Peter    | USA         | USD      | USAAdd    |                    12345675 | ABA          | 083900363 | SIT         |
  @TorFX_PID-3609_TC180 @TorRecipientlot4
  Scenario Outline: 7.4 To verify that to save button is in disabled state and previous bank details has been removed when user removes the mandatory bank code field data (SWIFT,SORT,IFSC).
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user removes one of the mandatory bank field data "<bankCodeType>" from the edit recipient screen
    # Then previous bank details should be clear in ios app
    And the option to save the recipient details should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment |
      #| TorRegEmailId05 | CDRegEmailPass1 | Company       | Eclairs Inc   | USA     | USD      | USAAdd  |      12457823 | ABA          | 083900363 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         |

  #| CDRegEmailId3 | CDRegEmailPass | Individual    | John Peter    | USA     | USD      | USAAdd  |      12345675 | ABA          | 083900363 | SIT         |
  # | CDRegEmailId3 | CDRegEmailPass | Company       | Barclays Inc  | France      | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN         | NA         | SIT         |
  # | CDRegEmailId3 | CDRegEmailPass | Individual    | Adam Watson   | UK          | GBP      | UKAdd     |                    12345678 | SORT         |     111213 | SIT         |
  # | CDRegEmailId3 | CDRegEmailPass | Company       | ICICI Bank    | Australia   | AUD      | AUSAdd    |                    12345678 | SWIFT        | CPANAU21   | SIT         |
  # | CDRegEmailId3 | CDRegEmailPass | Company       | Samsung Ele.  | New Zealand | NZD      | USAAdd    |                    12345678 | BSB          |     010001 | SIT         |
  # | CDRegEmailId3 | CDRegEmailPass | Company       | Tata Services | India       | INR      | IndiaAdd  |                    12345678 | IFSC         | SBIN000057 | SIT         |
  @TorFX_PID-3609_TC181 @TorRecipientlot4
  Scenario Outline: 7.4 To verify that to save button is in disabled state when user do not provides or removes account number field data.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user removes account number from the edit recipient screen
    And the option to save the recipient details should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment |
      #| TorRegEmailId05 | CDRegEmailPass1 | Company       | Eclairs Inc   | USA     | USD      | USAAdd  |      12457823 | ABA          | 083900363 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         |

  # | CDRegEmailId3 | CDRegEmailPass | Individual    | John Peter    | USA     | USD      | USAAdd  |      12345675 | ABA          | 083900363 | SIT         |
  @TorFX_PID-4023 @TorFX_PID-3609_TC182 @TorRecipientlot4
  Scenario Outline: 7.4 To verify that application doesnot allow user to change recipient type on edit recipient screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user change the recipient type "<recipientType>"
    Then current recipient type "<recipientType>" should not be changed in ios recipient edit screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment |
      #| TorRegEmailId05 | CDRegEmailPass1 | Company       | Eclairs Inc   | USA     | USD      | USAAdd  |      12457823 | ABA          | 083900363 | UAT         |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         |

  # | CDRegEmailId3 | CDRegEmailPass | Individual    | John Peter    | USA     | USD      | USAAdd  |      12345675 | ABA          | 083900363 | SIT         |
  @TorFX_PID-3609_TC183 @TorRecipientlot4
  Scenario Outline: 7.11 7.13 To verify application fetch the bank details for valid bank SORT,BSB,Transit Number,ABA or IFSC code on edit recipient screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    And ios user updates bank field details "<bankField-Details>"
    Then bank details should be fetched in ios app
    And the option to save the recipient details should be in enabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment | personalField-Details            | bankField-Details                        |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-45216387,SWIFT-PUPPALTRXXX |

  #| CDRegEmailId28 | CDRegEmailPass1 | Company       | Barclays Inc  | France  | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN         | NA       | UAT         | CompanyName-Quick Heal Services | IBAN-FR7630006000011234567890189 | Addressline1-Street ABC,City-New York,PostCode-41103256 |
  #| CDRegEmailId28 | CDRegEmailPass1 | Company       | Barclays Inc  | France  | EUR      | FranceAdd | FR7630006000011234567890189 | IBAN         | NA       | UAT         | CompanyName-Quick Heal Services | IBAN-FR1420041010050500013M02606 | Addressline1-Street ABC,City-New York,PostCode-41103256 |
  #| CDRegEmailId3 | CDRegEmailPass | Individual    | Adam Watson   | UK          | GBP      | UKAdd     |                    12345678 | SORT         |      111213 | SIT         | FirstName-Martin,LastName-King     | SORT-111212,Account Number-4521542154       | City-New York,PostCode-41103256                         |
  #| CDRegEmailId3 | CDRegEmailPass | Company       | Samsung Ele.  | New Zealand | NZD      | USAAdd    |                    12345678 | BSB          |      010001 | SIT         | CompanyName-Transtech Projects Ltd | BSB-389000                                  | Addressline1-Street ABC,PostCode-PST55JH                |
  #| CDRegEmailId3 | CDRegEmailPass | Company       | Tata Services | India       | INR      | IndiaAdd  |                    12345678 | IFSC         | SBIN0000575 | SIT         | CompanyName-BNT Soft Pvt Ltd.      | Account Number-87454213121,IFSC-HDFC0009116 | Addressline1-Nigdi Bhosari Road,PostCode-411044         |
  #personalField:FirstName,LastName,CompanyName
  #addressField :Addressline1,City,PostCode
  #bankField:AccountNumber,ABA,IBAN,SWIFT,SORT,IFSC,BSB,Transit
  @TorFX_PID-3609_TC184 @TorRecipientlot4
  Scenario Outline: 7.13 To verify application fetches bank details for valid SWIFT code on edit recipient screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    And ios user updates bank field details "<bankField-Details>"
    Then bank details should be fetched in ios app
    And the option to save the recipient details should be in enabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment | personalField-Details            | bankField-Details                    | addressField-Details                                  |
      #| CDRegEmailId3 | CDRegEmailPass | Company       | ICICI Bank    | Australia | AUD      | AUSAdd  |      12345678 | SWIFT        | CPANAU21 | SIT         | CompanyName-Master Card Inc | SWIFT-CTBAAU2S                             | Addressline1- MG Road,PostCode-PST55JH |
      #| CDRegEmailId28 | CDRegEmailPass1 | Company       | Eclairs Inc   | USA     | USD      | USAAdd  |      12457823 | ABA          | 083900363 | UAT         | CompanyName-Tata Visteon | AccountNumber-4521542154,SWIFT-NFBKUS33XXX | City-New York,PostCode-PST5545 |
      | TorRegEmailId08 | CDRegEmailPass1 | Company       | Andrew Peterson | United States Of America | GBP      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-45216387,ABA-125000105 | Addressline1-Street ABC,City-New York,PostCode-US3256 |

  @TorFX_PID-3609_TC185 @TorRecipientlot4
  Scenario Outline: 7.13 To verify application displays invalid account number error message for UK-GBP
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    And ios user updates bank field details "<bankField-Details>"
    Then invalid account number error message should be displayed to ios user
    And the option to save the recipient details should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | address | accountNumber | bankCodeType | bankCode | environment | personalField-Details            | bankField-Details    | addressField-Details                                  |
      #| TorRegEmailId05 | CDRegEmailPass1 | Company       | Henry Ford    | UK      | GBP      | UKAdd   |      34567891 | SORT         |   200000 | UAT         | CompanyName-Master Card Inc | AccountNumber-123456 | Addressline1- MG Road,PostCode-PST55JH |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Henry Ford    | United Kingdom | GBP      | UKAdd   |      12345675 | SORT         |   200000 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-125135 | Addressline1-Street ABC,City-New York,PostCode-US3256 |

  #Invalid bank code error message was not implemented need to revisit once it developed
  @TorFX_PID-3609_TC186
  Scenario Outline: 7.13 To verify application displays invalid bank code error message when user enters invalid bank code and when user re-enters the bank code then bank details should be fetched.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    And ios user updates bank field details "<InvalidbankField-Details>"
    # Then invalid bank code "<bankCodeType>" error message should be displayed to ios user
    Then invalid account number error message should be displayed to ios user
    #And previous bank details should be clear in ios app
    And the option to save the recipient details should be in disabled state in ios app
    When ios user updates bank field details "<bankField-Details>"
    Then bank details should be fetched in ios app
    And the option to save the recipient details should be in enabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | address | accountNumber | bankCodeType | bankCode  | environment | personalField-Details            | bankField-Details                  | InvalidbankField-Details | addressField-Details                                    |
      #| CDRegEmailId3 | CDRegEmailPass | Individual    | John Peter    | USA         | USD      | USAAdd    |                    12345675 | ABA          |     083900363 | SIT         | FirstName-Daniel,LastName-Watson   | ABA-083900363                    | ABA-125000105MMM         | Addressline1-Street ABC,City-New York,PostCode-US3256   |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Daniel Watson | United Kingdom | GBP      | UKAdd   |      12346387 | SORT         | 125000105 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-12346888,SORT-111213 | AccountNumber-564259     | Addressline1-Street ABC,City-New York,PostCode-41103256 |

  #| TorRegEmailId09 | CDRegEmailPass1 | Individual    | Daniel Watson | United Kingdom | GBP      | UKAdd   |      12346387 | SORT         | 125000105 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-12346888,SORT-111213 | Addressline1- ABC Road,City-New York,PostCode-US3256 |                      |
  #| CDRegEmailId3 | CDRegEmailPass | Individual    | Adam Watson   | UK          | GBP      | UKAdd     |                    12345678 | SORT         |        111213 | SIT         | FirstName-Martin,LastName-King     | SORT-111213                      | SORT-1112GA              | City-New York,PostCode-41103256                         |
  #| CDRegEmailId3 | CDRegEmailPass | Company       | Samsung Ele.  | New Zealand | NZD      | USAAdd    |                    12345678 | BSB          |        010001 | SIT         | CompanyName-Transtech Projects Ltd | BSB-010001                       | BSB-G389000              | Addressline1-Street ABC,PostCode-PST55JH                |
  #| CDRegEmailId3 | CDRegEmailPass | Company       | Tata Services | India       | INR      | IndiaAdd  |                    12345678 | IFSC         | SBINGB0000575 | SIT         | CompanyName-BNT Soft Pvt Ltd.      | IFSC-SBIN0000575                 | IFSC-HGAN09116           | Addressline1-Nigdi Bhosari Road,PostCode-411044         |
  #Invalid swift code error message was not implemented need to revisit once it developed
  @TorFX_PID-3609_TC187 @TorRecipientlot5
  Scenario Outline: 7.13 To verify application displays invalid swift code error message when user enters invalid swift code
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    And ios user updates bank field details "<bankField-Details>"
    Then invalid swift code error message should be displayed
    #And previous bank details should be clear in ios app
    And the option to save the recipient details should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment | personalField-Details            | bankField-Details                      | addressField-Details                                  |
      # | CDRegEmailId3 | CDRegEmailPass | Company       | ICICI Bank    | Australia | AUD      | AUSAdd  |      12345678 | SWIFT        | CPANAU21 | SIT         | CompanyName-Master Card Inc | SWIFT-GANESH      | Addressline1- MG Road,PostCode-PST55JH |
      #| CDRegEmailId28 | CDRegEmailPass1 | Company       | Eclairs Inc   | USA     | USD      | USAAdd  |      12457823 | ABA          | 083900363 | UAT         | CompanyName-Tata Visteon | SWIFT-GANESHXXX   | City-New York,PostCode-PST5545 |
      #| CDRegEmailId28 | CDRegEmailPass1 | Company       | Eclairs Inc   | USA     | USD      | USAAdd  |      12457823 | ABA          | 083900363 | UAT         | CompanyName-Tata Visteon | SWIFT-GANESHXXX   | City-New York,PostCode-PST5545 |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | SWIFT        | 083900363 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-45216387,SWIFT-125000105 | Addressline1-Street ABC,City-New York,PostCode-US3256 |

  @TorFX_PID-3605_TC171 @TorRecipientlot5 @TorFX_iOS_2FA
  Scenario Outline: To verify that when user enters all required recipient data and completes OTP process then user should navigate to updated
    recipient list screen and newly added recipient details should be mapped correctly on recipient view screen.

    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    #And ios address details fields should be displayed to applicable country currency
    #When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then newly added recipient details should be displayed on recipient view screen to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | address | accountNumber | bankCodeType | bankCode | environment |
      #  | CDRegEmailId3 | CDRegEmailPass | Individual    | John Peter    | USA     | USD      | USAAdd  |      12345675 | ABA          | 083900363 | SIT         |
      #  | CDRegEmailId3 | CDRegEmailPass | Company       | Eclairs Inc      | USA                    | USD      | USAAdd    |                     12457823 | SWIFT         | USBKUS44           | SIT         |
      #| CDRegEmailId28 | CDRegEmailPass1 | Company       | Barclays Inc  | France  | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN         | NA       | UAT         |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Eclairs Inc   | United Kingdom | GBP      | UKAdd   |      12345678 | SORT         |   111213 | UAT         |

  #| CDRegEmailIdRecipient   | CDRegEmailPass1 | Company       | ICICI Bank    | Australia | AUD      | AUSAdd  |      12345678 | BSB          |   032929 | UAT         |
  #  | CDRegEmailId3 | CDRegEmailPass | Company       | Samsung Ele.     | New Zealand            | NZD      | USAAdd    |                     12345678 | BSB           |             010001 | SIT         |
  #  | CDRegEmailId3 | CDRegEmailPass | Company       | Tata Services    | India                  | INR      | IndiaAdd  |                     12345678 | IFSC          | SBIN0000575        | SIT         |
  #  | CDRegEmailId3 | CDRegEmailPass | Individual    | Barbara Mayberry | New Zealand            | NZD      | USAAdd    |                     12345678 | SWIFT         | AMCLNZ21           | SIT         |
  #  | CDRegEmailId3 | CDRegEmailPass | Individual    | Gloria Walters   | Australia              | AUD      | AUSAdd    |                     12345678 | BSB           |             032929 | SIT         |
  #  | CDRegEmailId3 | CDRegEmailPass | Company       | Parle Inc        | UK                     | EUR      | UKAdd     | GB29NWBK60161331926819       | IBAN          | NA                 | SIT         |
  #  | CDRegEmailId3 | CDRegEmailPass | Individual    | Pedro Thompson   | British Virgin Islands | GBP      | UKAdd     |                     12345678 | SWIFT         | FCIBVGVGXXX        | SIT         |
  #  | CDRegEmailId3 | CDRegEmailPass | Individual    | Frances Shuffler | Canada                 | CAD      | CanadaAdd |                     12345678 | Transit,SWIFT | 000305054,CPANAU21 | SIT         |
  #  | CDRegEmailId3 | CDRegEmailPass | Company       | LG Services      | Hong Kong              | USD      | USAAdd    |                     12345678 | SWIFT         | HSBCHKHHHKH        | SIT         |
  #  | CDRegEmailId3 | CDRegEmailPass | Individual    | Glenn Newsome    | Hong Kong              | HKD      | CanadaAdd |                     12345678 | SWIFT         | SINOHKHH           | SIT         |
  #  | CDRegEmailId3 | CDRegEmailPass | Company       | Oxymist Ltd      | Hungary                | HUF      | CanadaAdd | HU42117730161111101800000000 | IBAN          | NA                 | SIT         |
  # | CDRegEmailId3 | CDRegEmailPass | Company       | TCS  Ltd      | South Africa | ZAR      | UKAdd   |      12345678 | Branch Code  |       200309 | SIT         |
  # | CDRegEmailId3 | CDRegEmailPass | Company       | TCS  Ltd      | China        | GBP      | UKaAdd  |      12345678 | CNAPS Code   | 501100000011 | SIT         |
  @TorFX_PID-3609_TC188 @TorRecipientlot5 @TorFX_iOS_2FA
  Scenario Outline: 7.6 7.15,7.16,7.17,7.19 To verify that user is able to update valid personal,address and bank details successfully
    and updated recipient details mapped correctly on recipient view screen.

    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user updates personal field details "<personalField-Details>" base on recipient type "<recipientType>"
    And ios user updates address field details "<addressField-Details>"
    And ios user updates bank field details "<bankField-Details>"
    Then bank details should be fetched in ios app
    #And the option to save the recipient details should be in enabled state in ios app
    When ios user click on save button
    Then otp page should be displayed to ios user
    # When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen
    When ios user selects updated recipient
    Then updated details should be displayed on view recipient screen to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | address | accountNumber | bankCodeType | bankCode | environment | personalField-Details            | bankField-Details                    | addressField-Details                                 |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | matinn gills  | United Kingdom | GBP      | UKAdd   |      12345678 | SORT         |   111213 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-45216387,ABA-125000105 | Addressline1- ABC Road,City-New York,PostCode-US3256 |

  # | CDRegEmailId28 | CDRegEmailPass1 | Company       |Barclays Inc | France  | EUR      | FranceAdd | IBAN-FR1420041010050500013M02606 | IBAN    | NA       | UAT         | CompanyName-Quick Heal Services | IBAN-FR9230003000505649133625B29 | Addressline1-Street ABC,City-New York,PostCode-41103256 |
  #| CDRegEmailId28 | CDRegEmailPass1 | Individual    | Martin Kba    | UK      | GBP      | UKAdd   |      87546869 | SORT         |   111213 | UAT         | FirstName-johns,LastName-bca | SORT-111212,AccountNumber-87546645 | City-New York,PostCode-41103256 |
  #  | CDRegEmailId3 | CDRegEmailPass | Company       | Samsung Ele.  | New Zealand | NZD      | USAAdd    |                    12345678 | BSB          |      010001 | SIT         | CompanyName-Transtech Projects Ltd | BSB-389000                                 | Addressline1-Street ABC,PostCode-PST55JH                |
  #  | CDRegEmailId3 | CDRegEmailPass | Company       | Tata Services | India       | INR      | IndiaAdd  |                    12345678 | IFSC         | SBIN0000575 | SIT         | CompanyName-BNT Soft Pvt Ltd.      | AccountNumber-87454213121,IFSC-HDFC0009116 | Addressline1-Nigdi Bhosari Road,PostCode-411044         |
  #  | CDRegEmailId3 | CDRegEmailPass | Company       | ICICI Bank    | Australia   | AUD      | AUSAdd    |                    12345678 | SWIFT        | CPANAU21    | SIT         | CompanyName-Master Card Inc        | SWIFT-CTBAAU2S                             | Addressline1- MG Road,PostCode-PST55JH                  |
  #  | CDRegEmailId3 | CDRegEmailPass | Company       | Eclairs Inc   | USA         | USD      | USAAdd    |                    12457823 | SWIFT        | USBKUS44    | SIT         | CompanyName-Tata Visteon           | AccountNumber-4521542154,SWIFT-HEMSUS3M    | City-New York,PostCode-PST5545                          |
  #personalField:FirstName,LastName,CompanyName
  #addressField :Addressline1,City,PostCode
  #bankField:AccountNumber,ABA,IBAN,SWIFT,SORT,IFSC,BSB,Transit
  @TorFX_PID-3609_TC189 @TorRecipientlot5 @TorFX_iOS_2FA
  Scenario Outline: To verify that user is able to update used in trade recipient personal,address and bank details successfully.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user updates personal field details "<personalField-Details>" base on recipient type "<recipientType>"
    #And ios user updates address field details "<addressField-Details>"
    And ios user updates bank field details "<bankField-Details>"
    Then bank details should be fetched in ios app
    And the option to save the recipient details should be in enabled state in ios app
    When ios user click on save button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen
    When ios user selects updated recipient
    Then updated details should be displayed on view recipient screen to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | address | accountNumber | bankCodeType | bankCode  | environment | personalField-Details            | bankField-Details                  | addressField-Details                                 |
      #| CDRegEmailId3 | CDRegEmailPass | Individual    | John Peter    | USA     | USD      | USAAdd    |                    12345675 | ABA          | 083900363 | SIT         | FirstName-Daniel,LastName-Watson | AccountNumber-45216387,ABA-125000105 | Addressline1-Street ABC,City-New York,PostCode-US3256   |
      # | CDRegEmailId28 | CDRegEmailPass1 | Company       | Barclays Inc | France  | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN         | NA       | UAT         | CompanyName-Quick Heal Services | IBAN-FR9230003000505649133625B29 | Addressline1-Street ABC,City-New York,PostCode-41103256 |
      #| TorRegEmailId05 | CDRegEmailPass1 | Company       | metros glis   | USA     | USD      | USAAdd  |      87547823 | ABA          | 083900363 | UAT         | CompanyName-johns     | ABA-125000105,AccountNumber-87546645 | Addressline1-Street ABC,City-New York,PostCode-US3256 |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Daniel Watson | United Kingdom | GBP      | UKAdd   |      12346387 | SORT         | 125000105 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-45216387,SORT-111213 | Addressline1- ABC Road,City-New York,PostCode-US3256 |

  @TorFX_PID-3609_TC190 @TorRecipientlot5 @TorFX_iOS_2FA
  Scenario Outline: 7.15 To verify resend pin link functionality on edit recipient screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user updates personal field details "<personalField-Details>" base on recipient type "<recipientType>"
    #And ios user updates address field details "<addressField-Details>"
    And ios user updates bank field details "<bankField-Details>"
    Then bank details should be fetched in ios app
    And the option to save the recipient details should be in enabled state in ios app
    When ios user click on save button
    Then otp page should be displayed to ios user
    When ios user do not enters otp in sixty seconds
    Then resend pin link gets displayed on ios app pin screen
    When ios user click on resend pin
    Then request a new pin timer should be start for sixty seconds in ios app in ios app
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen
    #Then the updated recipient should be displayed top of the recipient list in ios app
    When ios user selects updated recipient
    #Then all the updated details should be displayed on ios recipient view screen
    Then updated details should be displayed on view recipient screen to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | address | accountNumber | bankCodeType | bankCode  | environment | personalField-Details            | bankField-Details                  | addressField-Details                                 |
      # | CDRegEmailId28 | CDRegEmailPass1 | Company       | Barclays Inc  | France  | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN         | NA       | UAT         | CompanyName-Quick Heal Services | IBAN-FR9230003000505649133625B29 | Addressline1-Street ABC,City-New York,PostCode-41103256 |
      #| TorRegEmailId05 | CDRegEmailPass1 | Company       | bajaj         | UK      | GBP      | UKAdd   |      45166645 | SORT         |   111213 | UAT         | CompanyName-Tata      | SORT-111212,AccountNumber-45164952 | City-New York,PostCode-41103256 |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Matinn Gills  | United Kingdom | GBP      | UKAdd   |      45216387 | SORT         | 125000105 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-12346387,SORT-111213 | Addressline1- ABC Road,City-New York,PostCode-US3256 |

  @TorFX_PID-3609_TC191 @TorRecipientlot5
  Scenario Outline: 7.18 To verify that application displays invalid otp error message and recipient details do not get updates when user enters invalid OTP.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user updates personal field details "<personalField-Details>" base on recipient type "<recipientType>"
    # And ios user updates address field details "<addressField-Details>"
    And ios user updates bank field details "<bankField-Details>"
    Then bank details should be fetched in ios app
    And the option to save the recipient details should be in enabled state in ios app
    When ios user click on save button
    Then otp page should be displayed to ios user
    When ios user enters invalid otp "<otp>"
    Then invalid otp error message should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | address | accountNumber | bankCodeType | bankCode  | environment | personalField-Details            | bankField-Details                  | addressField-Details                                 |
      #| TorRegEmailId05 | CDRegEmailPass1 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |      12345675 | ABA          | 026009593 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-45216387,ABA-125000105 | Addressline1-Street ABC,City-New York,PostCode-US3256 |
      #| TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-45216387,ABA-125000105 | Addressline1-Street ABC,City-New York,PostCode-US3256 |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Matinn Gills  | United Kingdom | GBP      | UKAdd   |      12346387 | SORT         | 125000105 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-45216387,SORT-111213 | Addressline1- ABC Road,City-New York,PostCode-US3256 |

  @TorFX_PID-3609_TC192 @TorFX_iOS_2FA
  Scenario Outline: To verify that user is able to compelte update recipient journey successfuly when user switches to message application and again come back to otp screen to enter otp.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    #When android user select type "<type>"
    #And ios user updates bank details "<bankDetailsField-Data>"
    And ios user updates bank field details "<bankField-Details>"
    Then bank details should be fetched in ios app
    Then the option to save the recipient details should be in enabled state in ios app
    #When ios user clicks on save button
    When ios user click on save button
    Then otp page should be displayed to ios user
    When ios user switch to other application "<iphoneMessageBundleId>"
    And reswitch to cd ios app "<IOSbundleId>" after seconds <miliSeconds>
    # When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    #Then the updated recipient should be displayed top of the recipient list in ios app
    Then ios user should be navigated to recipient list screen
    When ios user selects updated recipient
    #Then all the updated details should be displayed on ios recipient view screen
    Then updated details should be displayed on view recipient screen to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | address | accountNo | bankCodeType | bankCode  | environment | personalField-Details            | bankField-Details                  | addressField-Details                                  | iphoneMessageBundleId | IOSbundleId | miliSeconds |
      #| CDRegEmailId28 | CDRegEmailPass1 | Company       | Barclays Inc  | France  | EUR      | USAAdd  | FR1420041010050500013M02606 | IBAN         | NA       | UAT         | CompanyName-Hawkins | IBAN-FR9230003000505649133625B29 | Addressline1-Street ABC,City-New York,PostCode-US3256 | iphoneMessageBundleId | IOSbundleId |        5000 |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Daniel Watson | United Kingdom | GBP      | UKAdd   |  12346387 | SORT         | 125000105 | UAT         | FirstName-Barclays ,LastName-Inc | AccountNumber-12346888,SORT-111213 | Addressline1-Street ABC,City-New York,PostCode-US3256 | iphoneMessageBundleId | IOSbundleId |        5000 |

  #| TorRegEmailId09 | CDRegEmailPass1 | Individual       | Daniel Watson | United Kingdom  | GBP      | UKAdd | 12346387 | SORT         | 125000105       | UAT         | FirstName-Daniel,LastName-Watson |  AccountNumber-12346888,SORT-111213 | AccountNumber-564259         | Addressline1-Street ABC,City-New York,PostCode-41103256 |
  @TorFX_PID-3609_TC193 @TorFX_iOS_2FA
  Scenario Outline: To verify that user is able to update recipient data with max length .
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user updates personal field details "<personalField-Details>" base on recipient type "<recipientType>"
    #And ios user updates address field details "<addressField-Details>"
    And ios user updates bank field details "<bankField-Details>"
    Then bank details should be fetched in ios app
    And the option to save the recipient details should be in enabled state in ios app
    When ios user click on save button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen
    When ios user selects updated recipient
    Then updated details should be displayed on view recipient screen to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | address | accountNumber | bankCodeType | bankCode  | environment | personalField-Details            | bankField-Details                  | addressField-Details                                  |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Usher Johnson | United Kingdom | GBP      | UKAdd   |      45216387 | SORT         | 125000105 | UAT         | FirstName-Barclays ,LastName-Inc | AccountNumber-85648965,SORT-111213 | Addressline1-Street ABC,City-New York,PostCode-US3256 |

  #| TorRegEmailId09 | CDRegEmailPass1 | Individual    | Barclays Inc |  United Kingdom      | GBP      | UKAdd  |      85648965 | ABA          | 083900363 | UAT         | FirstName-Usher,LastName-Johnson | AccountNumber-45216387,SORT-111213| Addressline1-Estreet,City-California,PostCode-US3256 |
  @TorFX_PID-3609_TC194 @TorFX_iOS_2FA
  Scenario Outline: To verify that user is able to update recipient data with regex provided in the Global NFR document into text field and shows success icon.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user updates personal field details "<personalField-Details>" base on recipient type "<recipientType>"
    #And ios user updates address field details "<addressField-Details>"
    And ios user updates bank field details "<bankField-Details>"
    Then bank details should be fetched in ios app
    And the option to save the recipient details should be in enabled state in ios app
    When ios user click on save button
    Then otp page should be displayed to ios user
    # When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen
    When ios user selects updated recipient
    Then updated details should be displayed on view recipient screen to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country        | currency | address | accountNumber | bankCodeType | bankCode  | environment | personalField-Details            | bankField-Details                  | addressField-Details                                 |
      #| CDRegEmailId3 | CDRegEmailPass | Individual    | John Peter    | USA     | USD      | USAAdd    |                    12345675 | ABA          | 083900363 | SIT         | FirstName-Usher,LastName-Johnson| AccountNumber-45216387,ABA-125000105 | Addressline1-Estreet,City-California,PostCode-US3256   |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Barclays Inc  | United Kingdom | GBP      | UKAdd   |      85648965 | ABA          | 083900363 | UAT         | FirstName-Usher,LastName-Johnson | AccountNumber-45216387,SORT-111213 | Addressline1-Estreet,City-California,PostCode-US3256 |

  #supported regx :!@TorFX_$%^&*()_+?><:"-./
  #Need to revisit once error code finalised and developed
  @TorFX_PID-3609_TC195 @TorRecipientlot5
  Scenario Outline: 7.4  7.10 To check that application does not allow user to enter unsupported special character except regex provided in the Global NFR document into text field and shows line error message .
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user updates personal field details "<personalField-Details>" base on recipient type "<recipientType>"
    Then invalid personal field error message should be displayed
    When ios user updates address field details "<addressField-Details>"
    Then invalid address field error message should be displayed
    And the option to save the recipient details should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment | personalField-Details           | bankField-Details                    | addressField-Details                                          |
      #| TorRegEmailId05 | CDRegEmailPass1 | Individual    | John₹ Peter₹  | USA     | USD      | USAAdd  |      12345675 | ABA          | 083900363 | SIT         | FirstName-mony₹,LastName-johns₹ | AccountNumber-45216387,ABA-125000105 | Addressline1-Estreet₹ ,City-California₹ ,PostCode-US3256 |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         | FirstName-mony₹,LastName-johns₹ | AccountNumber-45216387,ABA-125000105 | Addressline1-Estreet₹  ABC₹,City-California₹ ,PostCode-US3256 |

  #| CDRegEmailId28 | CDRegEmailPass1 | Company       | Barclays Inc₹ | France  | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN         | NA       | UAT         | CompanyName-Infosys Inc₹ | IBAN-FR9230003000505649133625B29 | Addressline1-Estreet₹ ,City-California₹ ,PostCode-41103256 |
  #Need to revisit once error message finalised and developed by dev team #Need to revisit once bug fixed PID-4508
  @TorFX_PID-3609_TC195 @TorRecipientlot5 @TorFX_iOS_2FA
  Scenario Outline: To verify system displays proper error message for duplication recipient.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user has one or more saved recipients
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user updates personal field details "<personalField-Details>" base on recipient type "<recipientType>"
    And ios user updates address field details "<addressField-Details>"
    And ios user updates bank field details "<bankField-Details>"
    Then bank details should be fetched in ios app
    And the option to save the recipient details should be in enabled state in ios app
    When ios user click on save button
    Then otp page should be displayed to ios user
    # When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then error message should be displayed as recipent already exist

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName   | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment | personalField-Details            | bankField-Details                    | addressField-Details                                  |
      #| TorRegEmailId05 | CDRegEmailPass1 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |      12345675 | ABA          | 026009593 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-45216387,ABA-125000105 | Addressline1-Street ABC,City-New York,PostCode-US3256 |
      | TorRegEmailId08 | CDRegEmailPass1 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |      12345675 | ABA          | 083900363 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-45216387,ABA-125000105 | Addressline1-Street ABC,City-New York,PostCode-US3256 |

  @TorFX_PID-4225_TC196 @TorRecipientlot5
  Scenario Outline: 2.2.1 To verify error message gets displayed when user enters invalid data in first name field and when users revisit the same field again and corrects the data error message gets removed
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user enters invalid recipients first name "<invalidFirstName>" on add recipient screen
    Then invalid first name error message should be displayed to ios user on add recipient screen
    When ios user enters valid recipients first name "<validFirstName>" on add recipient screen
    Then invalid first name error message should be removed from the ios app add recipient screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | validFirstName | invalidFirstName |
      | TorRegEmailId05 | CDRegEmailPass1 | Individual    | John           | A$%^&            |

  @TorFX_PID-4225_TC197 @TorRecipientlot5
  Scenario Outline: 2.2.2 2.4.2 To verify error message gets displayed when user enters invalid data in last name field and when users revisit the same field again and corrects the data error message gets removed
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user enters invalid recipients last name "<invalidLastName>" on add recipient screen
    Then invalid last name error message should be displayed to ios user on add recipient screen
    When ios user enters valid recipients last name "<validLastName>" on add recipient screen
    Then invalid last name error message should be removed from the ios app add recipient screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | validLastName | invalidLastName |
      | TorRegEmailId05 | CDRegEmailPass1 | Smith         | A$%^&           |

  @TorFX_PID-4225_TC198 @TorRecipientlot5
  Scenario Outline: 2.2.3,2.4.3 To verify error message gets displayed when user enters invalid data in company name field and when users revisit the same field again and corrects the data error message gets removed
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user enters invalid recipients company name "<invalidRecipientName>" on add recipient screen
    Then invalid company name error message should be displayed to ios user on add recipient screen
    When ios user enters valid recipients company name "<recipientName>" on add recipient screen
    Then invalid company name error message should be removed from the ios app add recipient screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientName | invalidRecipientName |
      | TorRegEmailId05 | CDRegEmailPass1 | Eclairs Inc   | A$%^&                |

  @TorFX_PID-4225_TC199 @TorRecipientlot5
  Scenario Outline: 2.4.7 To verify error message gets displayed when user enters only spaces in first name field and when users revisit the same field again and corrects the data then error message gets removed
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user enters white spaces in recipients first name field on add recipient screen
    Then invalid first name error message should be displayed to ios user on add recipient screen
    When ios user enters valid recipients first name "<FirstName>" on add recipient screen
    Then invalid first name error message should be removed from the ios app add recipient screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | FirstName |
      | TorRegEmailId05 | CDRegEmailPass1 | Individual    | John      |

  @TorFX_PID-4225_TC200 @TorRecipientlot5
  Scenario Outline: 2.3.2,2.4.8 To error message gets displayed when user enters only spaces in last name field and when users revisit the same field again and corrects the data error message gets removed
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user enters white spaces in recipients last name field on add recipient screen
    Then invalid last name error message should be displayed to ios user on add recipient screen
    When ios user enters valid recipients last name "<LastName>" on add recipient screen
    Then invalid last name error message should be removed from the ios app add recipient screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | LastName |
      | TorRegEmailId05 | CDRegEmailPass1 | Smith    |

  @TorFX_PID-4225_TC201 @TorRecipientlot5
  Scenario Outline: 2.3.3,2.4.9 To verify error message gets displayed when user enters only spaces in company name field and when users revisit the same field again and corrects the data error message gets removed
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user enters white spaces in recipients company name field on add recipient screen
    Then invalid company name error message should be displayed to ios user on add recipient screen
    When ios user enters valid recipients company name "<recipientName>" on add recipient screen
    Then invalid company name error message should be removed from the ios app add recipient screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientName |
      | TorRegEmailId05 | CDRegEmailPass1 | Eclairs Inc   |

  @TorFX_PID-4225_TC202 @TorRecipientlot5
  Scenario Outline: 2.3.1 To verify mandatory error message gets displayed when user do not enter any data
    in personal fields (firstname,lastname,company name) address fields (address,city,post code ) ,
    bank fields (account number,swift code,transit number,IBAN).

    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and leaves the recipient name field in focus
    Then recipient name required error message should be displayed for recipient type "<recipientType>"
    When ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    When ios user leaves the address city and postcode field in focus of country "<country>"
    Then address city and postcode required field error message should be displayed in ios for country "<country>"
    When ios user leaves the bank code "<bankCodeType>" field in focus base on country "<country>" currency "<currency>"
    Then bank code "<bankCodeType>" required field error message should be displayed in ios app
    When ios user leaves the account number field in focus
    Then account number required field error message should be displayed in ios app
    When ios user close the add recipient window

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country | currency | address | accountNumber | bankCodeType | bankCode | environment |
      | TorRegEmailId05 | CDRegEmailPass1 | Individual    | Johnny Watson | USA     | USD      | USAAdd  |      12345675 | ABA          | USBKUS44 | UAT         |

  #| CDRegEmailId3 | CDRegEmailPass | Individual    | Adam Watson   | UK      | GBP      | UKAdd   |      12345678 | SORT         |   111213 | SIT         |
  #    | CDRegEmailId3 | CDRegEmailPass | Company       | Samsung Ele.   | New Zealand | NZD      | USAAdd    |                    12345678 | BSB          |      010001 | SIT         |
  #    | CDRegEmailId3 | CDRegEmailPass | Company       | Tata Services  | India       | INR      | IndiaAdd  |                    12345678 | IFSC         | SBIN0000575 | SIT         |
  #    | CDRegEmailId3 | CDRegEmailPass | Individual    | Gloria Walters | Australia   | AUD      | AUSAdd    |                    12345678 | BSB          |      032929 | SIT         |
  @TorFX_PID-4225_TC203 @TorRecipientlot5
  Scenario Outline: 2.3.1 To verify mandatory error message gets displayed when user do not enter any data
    in personal fields (firstname,lastname,company name) address fields (address,city,post code ) ,
    and bank field as IBAN .

    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and leaves the recipient name field in focus
    Then recipient name required error message should be displayed for recipient type "<recipientType>"
    When ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    When ios user leaves the address city and postcode field in focus of country "<country>"
    Then address city and postcode required field error message should be displayed in ios for country "<country>"
    When ios user leaves the bank code "<bankCodeType>" field in focus base on country "<country>" currency "<currency>"
    Then bank code "<bankCodeType>" required field error message should be displayed in ios app
    When ios user close the add recipient window

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | recipientType | recipientName | country | currency | address   | accountNumber               | bankCodeType | bankCode | environment |
      | TorRegEmailId05 | CDRegEmailPass1 | Company       | Barclays Inc  | France  | EUR      | FranceAdd | FR1420041010050500013M02606 | IBAN         | NA       | UAT         |

  @TorRecipientlot6 @TorFX_iOS_2FA
  Scenario Outline: To verify that user able to add new recipient,Edit the recipient and delete recipient
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects the recipient option from the home dashboard
    And ios user selects an option to add a new recipient
    Then add recipient screen should be displayed to ios user
    When ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    When ios user selects currency drop down and enters currency code or name "<currency>" to add recipient
    And ios user selects the currency from searched result list "<currency>"
    Then selected currency "<currency>" should be displayed in currency dropdown to add recipient
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNumber>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    # When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen
    #When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    #Then newly added recipient details should be displayed on recipient view screen to ios user
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNumber>"
    Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user updates personal field details "<personalField-Details>" base on recipient type "<recipientType>"
    And ios user updates address field details "<addressField-Details>"
    And ios user updates bank field details "<bankField-Details>"
    Then bank details should be fetched in ios app
    And the option to save the recipient details should be in enabled state in ios app
    When ios user click on save button
    Then otp page should be displayed to ios user
    # When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should be navigated to recipient list screen
    When ios user selects updated recipient
    Then updated details should be displayed on view recipient screen to ios user
    #And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<bankField-Details>"
    #Then view recipient screen should be displyed with edit button in ios app
    When ios user click on edit icon
    Then edit recipient screen should be displayed to ios user
    When ios user clicks on delete recipient button
    Then delete confirmation message window should be displayed in ios app
    When ios user accepts recipient delete confirmation
    Then ios user should be navigated to recipient list screen
    And recipient with the details name "<recipientName>" currency "<currency>" account no "<accountNumber>" should be deleted from the ios app

    Examples: 
      | emailAddress    | password        | recipientType | recipientName    | country                  | currency | address | accountNumber | bankCodeType | bankCode  | environment | personalField-Details            | bankField-Details                    | addressField-Details                                  |
      # | TorRegEmailId09 | CDRegEmailPass1 | Individual    | John Peter   | United Kingdom | GBP      | UKAdd   |      12345678 | SORT         |   111213 | UAT         |FirstName-Daniel,LastName-Watson | AccountNumber-45216387,SORT-111213 | Addressline1- ABC Road,City-New York,PostCode-US3256 |
      | TorRegEmailId09 | CDRegEmailPass1 | Individual    | Frances Shuffler | United States Of America | USD      | USAAdd  |      12457823 | ABA          | 083900363 | UAT         | FirstName-Daniel,LastName-Watson | AccountNumber-23456985,ABA-125000105 | Addressline1-Street ABC,City-New York,PostCode-US3256 |
