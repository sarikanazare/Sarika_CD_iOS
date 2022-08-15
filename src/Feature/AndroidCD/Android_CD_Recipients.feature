@Recipient
Feature: Recipient :

  @PAD-2922_TC118 @NoRecipient
  Scenario Outline: 2.1 To verify add recipient button on empty recipient list screen.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has no saved recipients previously
    Then an option to add a new recipient should be displayed in android app

    Examples:
      | emailAddress | password       |
      | CDNoWallet   | CDRegEmailPass |

  @PAD-2922_TC119
  Scenario Outline: 2.1 To verify add recipient list along with the option to add a new recipient.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    Then all the recipients should be displayed with the option to add a new recipient in android app

    Examples:
      | emailAddress | password       |
      | CDRegEmailId | CDRegEmailPass |

  @PAD-2922_TC120
  Scenario Outline: 2.1 To verify individual and company type recipients in the list screen has been displayed with name,currency code and masked account number except last four digits.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    Then each recipient in the list should be displayed with name,currency code and masked account number except last four digit

    Examples:
      | emailAddress | password       |
      | CDRegEmailId | CDRegEmailPass |

  @PAD-2922_TC121
  Scenario Outline: 2.2 To verify details of selected individual and company recipient in the view recipients screen.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the user selects a saved recipient "<recipientListData>"
    Then all the details of the recipient "<recipientViewData>" should be displayed as per country-currency "<country-currency>"

    Examples:
      | emailAddress | password       | recipientListData  | recipientViewData  | country-currency   |
      | CDRegEmailId | CDRegEmailPass | recipientListData3 | recipientViewData3 | United Kingdom-GBP |

  @PAD-2922_TC122
  Scenario Outline: 2.5 To check that when user clicks on the add new recipient button then user navigates to add a new recipient screen.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user

    Examples:
      | emailAddress | password       |
      | CDRegEmailId | CDRegEmailPass |

  @PAD-2928_TC_123 @EditRecipient
  Scenario Outline: 7.1, 7.5  To verify that user lands on edit recipient screen when user clicks on edit icon from the view recipient screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    And the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    Then the option to save the recipient should be in an inactive/disabled state in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber               |
      | CDRegEmailId | CDRegEmailPass | Individual | Seina Brown   | AUD      | FR1420041010050500013M02606 |

  @PAD-2928_TC124 @EditRecipient @CDregression
  Scenario Outline: 7.1, 7.5   To verify user land on View recipient on click on back option on Edit recipient
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    And the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user clicks on back button
    Then all the details of the recipient "<recipientViewData>" should be displayed as per country-currency "<country-currency>"

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | recipientViewData  | country-currency |
      | CDRegEmailId | CDRegEmailPass | Individual | Seina Brown   | AUD      | 56986         | recipientViewData4 | India-AUD        |

  @PAD-2927_TC125 @EditRecipient
  Scenario Outline: 7.1, 7.5 To verify save button disbaled when first name not provided
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    And the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user does not provided first name
    Then the option to save the recipient should be in an inactive/disabled state in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber |
      | CDRegEmailId | CDRegEmailPass | Individual | Seina Brown   | AUD      | 56986         |

  @PAD-2927_TC126 @EditRecipient
  Scenario Outline: 7.1, 7.5  To verify save button disbaled when last name not provided
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    And the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user does not provided last name
    Then the option to save the recipient should be in an inactive/disabled state in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber |
      | CDRegEmailId | CDRegEmailPass | Individual | Seina Brown   | AUD      | 56986         |

  @PAD-2927_TC127 @EditRecipient
  Scenario Outline: 7.1, 7.5 Save button disbaled when company name not provided
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user does not provided company name
    Then the option to save the recipient should be in an inactive/disabled state in android app

    Examples:
      | emailAddress | password       | Type    | recipientName | currency | accountNumber |
      | CDRegEmailId | CDRegEmailPass | Company | Gbp Recipient | GBP      | 12345678      |

  @PAD-2927_TC128 @EditRecipient @doneChnages
  Scenario Outline: 7.1, 7.5 To verify the edit recipient save button should be disabled by default when landed on edit recipient Screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    Then the option to save the recipient should be in an inactive/disabled state in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber |
      | CDRegEmailId | CDRegEmailPass | Individual | Seina Brown   | AUD      | 56986         |

  @PAD-2927_TC129 @doneChnages
  Scenario Outline: 7.1, 7.5 To verify that user is able to edit recipient sucessfully when  bank and pernal details updated
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user update personal,adress and bank valid details "<fieldname-data>"
    And android user clicks on save button
    Then Otp page should be displayed to android user
    When android user should enters valid otp "<otp>"
    Then recipient list screen shoould be displayed
     Examples: 
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | fieldname-data                                                 |otp|
      | CDRegEmailId | CDRegEmailPass | Individual | Seina Brown   | AUD      |         56986 | FirstName-Seina,LastName-Brown,AccountNo-56986,Sortcode-111111 |AndroidvalidOTP|

  @hashmaptest
  Scenario Outline: 7.1, 7.5 To verify that user is able to edit recipient sucessfully when bank and pernal details updated
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user update personal,adress and bank valid details "<fieldname-data>"
    And android user clicks on save button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<otp>"
    Then recipient list screen shoould be displayed
    Then all the updated details should be displayed on android recipient view screen

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber    | fieldname-data                                                                | otp             |
      | CDRegEmailId | CDRegEmailPass | Individual | Usd Recipient | USD      | 1235588888877777 | FirstName-Usd,LastName-Recipient,AccountNo-1235588888877777,BSBcode-121100782 | AndroidValidOTP |

  @PAD-2927_TC130 @EditRecipient @doneChnages
  Scenario Outline: 7.6  To verify that application doesnot allow user to change recipient type on edit recipient screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    Then recipient type "<type>" should not be changed on android recipient edit screen

    Examples:
      | emailAddress | password       | type     | recipientName | currency | accountNumber |
      | CDRegEmailId | CDRegEmailPass | Commpany | Gbp Recipient | GBP      | 12345678      |

  @PAD-2927_TC131
  Scenario Outline: 7.6 To verify recipient type should be editabled and user is able to save the recipient when Type changed Company to Individual
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And the android user enter first name and last name "<firstnamelastname>"
    And android user clicks on save button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<otp>"
    Then recipient list screen shoould be displayed

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | firstnamelastname | otp             |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam Walness   | USD      | 22345678      | Sam Walness       | AndroidValidOTP |

  @PAD-2927_TC132 @validotp
  Scenario Outline: 7.13 7.14,7.15  To verify when all data,bank details are changed with valid data and recipient should be saved successfully and user lands on recipient  list page  with updated list
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user updates bank details "<fieldname-data>"
    And android user clicks on save button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<otp>"

    Examples:
      | emailAddress | password       | Type    | recipientName | currency | accountNumber | fieldname-data                     | otp             |
      | CDRegEmailId | CDRegEmailPass | Company | Gbp Recipient | GBP      | 12345678      | AccountNo-12345678,Sortcode-111111 | AndroidValidOTP |

  @PAD-2925_TC166 @CDregression @CDsanity
  Scenario Outline: 3.17,3.18 To verify recipient should be add successfully though swift code and newly added recipient should be mapped correctly on recipient view screen.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters valid account number "<accountNumber>"
    And android user enters valid swift code "<swiftCode>" based on "<country-currency>"
    Then bank details should be fetched in android app
    Then the continue button to save the recipient should be in an enabled state in android app
    When android user clicks on continue button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<otp>"
    Then android user should navigate to recipient list screen
    And newly added recipient details "<recipientName>" "<accountNumber>" "<country-currency>" should be displayed at top of the list in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency             | accountNumber | swiftCode | otp             |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam Walness   | United States of America-USD | 22345678      | 122235821 | AndroidValidOTP |

  @PAD-2927_133 @EditRecipientSuccess @validotp @smokeTest
  Scenario Outline: 7.16 To verify the recipient is edited successfully when it is used in trade
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android usrer updates personal details "<personalDetailsField-Data>"
    And android user updates bank details "<fieldname-data>"
    Then bank details should be fetched in android app
    And android user clicks on save button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<otp>"
    Then all the updated details should be displayed on android recipient view screen

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | fieldname-data                     | otp             | personalDetailsField-Data      | addressDetailsField-Data                            |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam Walness   | USD      | 22345678      | AccountNo-22345678,ABANo-122235821 | AndroidValidOTP | FirstName-Sam,LastName-Walness | AdressLine1-1992 Cork St,City-Guelph,Postcode-14025 |

  @PAD-2928_TC149 @CDregression @CDsanity
  Scenario Outline: 8.2 To verify Individual recipient get deleted when user selects delete button on confirmation page.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user clicks on Delete Recipient button
    Then information is displayed to the user to confirm if they want to delete the selected recipient
    When user accepts recipient delete confirmation
    Then add recipient screen should be displayed to android user
    And recipient with the details name "<recipientName>" currency "<currency>" account no "<accountNo>" should be deleted from the android app

    Examples:
      | emailAddress | password       | recipientName | currency | accountNumber |
      | CDRegEmailId | CDRegEmailPass | Sam Walness   | USD      | 22345678      |

  @PAD-2927_1341 @EditRecipient @validotp
  Scenario Outline: 7.16 To verify that user is able to update valid personal,address and bank details successfully and updated recipient get displayed at top of the recipient list using valid OTP.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android usrer updates personal details "<personalDetailsField-Data>"
    And android user updates address details "<addressDetailsField-Data>"
    And android user updates bank details "<fieldname-data>"
    Then bank details should be fetched in android app
    And android user clicks on save button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<otp>"
    Then all the updated details should be displayed on android recipient view screen
    When android user selects updated recipient
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | fieldname-data                     | otp             | personalDetailsField-Data      | addressDetailsField-Data                            |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam Walness   | USD      | 22345678      | AccountNo-22345678,ABANo-122235821 | AndroidValidOTP | FirstName-Sam,LastName-Walness | AdressLine1-1992 Cork St,City-Guelph,Postcode-14025 |

  @PAD-2927_135 @EditRecipient
  Scenario Outline: 7.16 verify application fetch the bank details for valid bank SORT,BSB,TranUAT Number,ABA or IFSC code on edit recipient screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user updates bank details "<fieldname-data>"
    Then bank details should be fetched in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | fieldname-data                  |
      | CDRegEmailId | CDRegEmailPass | Individual | Seina Brown   | AUD      | 56986         | AccountNo-56986,SortCode-111111 |

  @PAD-2927_136 @EditRecipient
  Scenario Outline: 7.16 verify application fetch the bank details for valid bank SORT,BSB,TranUAT Number,ABA or IFSC code on edit recipient screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user updates bank details "<fieldname-data>"
    Then bank details should be fetched in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | fieldname-data                     |
      | CDRegEmailId | CDRegEmailPass | Individual | Adam Martin   | USD      | 44556671      | AccountNo-44556671,ABANo-122101706 |

  @PAD-2927_137 @EditRecipient
  Scenario Outline: 7.16  To verify that to save the recipient details button is in disabled state and
  error message gets displayed when user do not provides or removes one of the mandatory address details field

    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user removes removes one of the mandatory adress field"<mandatoryField>"
    Then the option to save the recipient should be in an inactive/disabled state in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | mandatoryField |
      | CDRegEmailId | CDRegEmailPass | Individual | Adam Martin   | USD      | 44556671      | Postcode       |

  @PAD-2927_138 @EditRecipient @validotp
  Scenario Outline: 7.16   To verify that user is able to update recipient data with regex provided in the Global NFR document into text field and shows success icon.
  error message gets displayed when user do not provides or removes one of the mandatory address details field

    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android usrer updates personal details "<personalDetailsField-Data>"
    And android user updates address details "<addressDetailsField-Data>"
    And android user updates bank details "<fieldname-data>"
    Then bank details should be fetched in android app
    And android user clicks on save button

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | fieldname-data                     | personalDetailsField-Data     | addressDetailsField-Data                                                | environment |
      | CDRegEmailId | CDRegEmailPass | Individual | Ana Martin    | USD      | 44556671      | AccountNo-44556671,ABANo-122101706 | FirstName-Ana,LastName-Martin | AdressLine1-Estreet!@$%^&*()_+?><:./,City-California!@,Postcode-0000002 | UAT         |

  @PAD-2927_139
  Scenario Outline: 7.10 7.14 4 To verify error message for invalid bank SORT,BSB,TranUAT Number,ABA or IFSC code on edit recipient screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user updates invalid bank details "<fieldname-data>"
    Then invalid bank code error message should be displayed

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | fieldname-data                |
      | CDRegEmailId | CDRegEmailPass | Individual | Adam Martin   | USD      | 44556671      | AccountNo-44556671,ABANo-1221 |

  @PAD-2927_140
  Scenario Outline: 7.10 7.14 4  To verify error message for invalid account number on edit recipient screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user updates invalid bank details "<fieldname-data>"
    Then invalid account number error message should be displayed to android user

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | fieldname-data |
      | CDRegEmailId | CDRegEmailPass | Individual | Adam Martin   | USD      | 44556671      | AccountNo-44   |

  @PAD-2927_142
  Scenario Outline: 7.6 To verify the error message to be displayed on wrong OTP attempts while editing recipint.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    And the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user updates bank details "<fieldname-data>"
    And android user clicks on save button
    Then OTP page should be displayed to android user
    When android user enters invalid otp "<otp>"
    Then android invalid otp error message should be displayed

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | otp               | fieldname-data                  |
      | CDRegEmailId | CDRegEmailPass | Individual | Seina Brown   | AUD      | 56111986      | AndroidInvalidOTP | AccountNo-56986,Sortcode-111111 |

  @PAD-2927_143 @validotp
  Scenario Outline: 7.6  To verify reset OTP flow user shoudld be able to edit the recipient
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    When android user updates bank details "<fieldname-data>"
    And android user clicks on save button
    Then OTP page should be displayed to android user
    When android user do not enters otp in sixty seconds
    Then resend pin link gets displayed on android app pin screen
    When android user click on resend pin
    Then request a new pin timer should be start for sixty seconds
    When android user enters valid otp "<otp>"
    Then the Recipient displayed in recipient list with updated details "<fieldname-data>"

    Examples:
      | emailAddress | password       | Type     | recipientName | currency | accountNumber | otp             | fieldname-data                     |
      | CDRegEmailId | CDRegEmailPass | Commpany | Gbp Recipient | AUD      | 12345678      | AndroidValidOTP | AccountNo-12345678,Sortcode-111111 |

  @PAD-2927_144
  Scenario Outline: 7.6  To verify that application do not get crash and user lands on invalid OTP screen when user switches between two application
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user update personal,adress and bank valid details "<fieldname-data>"
    And android user clicks on save button
    Then OTP page should be displayed to android user
    When android user enters invalid otp "<otp>"
    Then android invalid otp error message should be displayed
    When android user switch to other application "<appPackage>"
    And android reswitch to cdapp
    Then android invalid otp error message should be displayed

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | otp               | fieldname-data                                                 | appPackage                   |
      | CDRegEmailId | CDRegEmailPass | Individual | Seina Brown   | AUD      | 56986         | AndroidInvalidOTP | FirstName-Seina,LastName-Brown,AccountNo-56986,Sortcode-111111 | com.google.android.apps.maps |

  @PAD-2927_145 @validotp
  Scenario Outline: 7.16 To verify the recipient adress should get edited and thoses are edited
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    And the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    When android user updates address details "<fieldname-data>"
    And android user clicks on save button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<otp>"

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | fieldname-data                                | otp             |
      | CDRegEmailId | CDRegEmailPass | Individual | Seina Brown   | AUD      | 56986         | AdressLine1-abcd xyz,City-pune,Postcode-12345 | AndroidValidOTP |

  @PAD-2927_146
  Scenario Outline: 7.13 7.14,7.15 To check recipient gets edited successfully with max data
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And the android user enter first name and last name "<firstnamelastname>"
    And android user updates address details "<fieldname-data>"
    And android user clicks on save button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<otp>"

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | firstnamelastname | fieldname-data                                                   | otp             |
      | CDRegEmailId | CDRegEmailPass | Individual | John Morgan   | CAD      | 2233556677    | john morgan       | AdressLine1-11111111111111,City-11111111111,Postcode-22222222222 | AndroidValidOTP |

  @PAD-2927_147
  Scenario Outline: 8.1 To verify confirmation message to be displayed when user select delete recipient option.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user clicks on Delete Recipient button
    Then information is displayed to the user to confirm if they want to delete the selected recipient

    Examples:
      | emailAddress | password       | recipientName | currency | accountNumber |
      | CDRegEmailId | CDRegEmailPass | Sam Walness   | USD      | 22345678      |

  @PAD-2927_148
  Scenario Outline: 8.1 To verify â€œCompanyâ€ recipient get deleted when user selects â€˜Deleteâ€™ button on confirmation page.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user clicks on Delete Recipient button
    Then information is displayed to the user to confirm if they want to delete the selected recipient
    When user accepts recipient delete confirmation
    Then add recipient screen should be displayed to android user
    And recipient with the details name "<name>" currency "<currency>" account no "<accountNo>" should be deleted from the android app

    Examples:
      | emailAddress | password       | recipientName | currency | accountNumber |
      | CDRegEmailId | CDRegEmailPass | Sam Walness   | USD      | 22345678      |

  @PAD-2928_TC150 @CDregression
  Scenario Outline: 8.2 To verify recipient delete confirmation pop up closes when user select â€˜Cancelâ€™ on confirmation pop up
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user clicks on Delete Recipient button
    Then information is displayed to the user to confirm if they want to delete the selected recipient
    When android user dismiss recipient delete confirmation
    Then the edit recipient screen should be displayed on android aap

    Examples:
      | emailAddress | password       | recipientName | currency | accountNumber |
      | CDRegEmailId | CDRegEmailPass | John Morgan   | CAD      | 2233556677    |

  @PAD-2928_TC151
  Scenario Outline: 8.2 To delete the recipient when recipient is used in Trade.
    Given android user installed the new CD app and launched successfully Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user clicks on Delete Recipient button
    Then information is displayed to the user to confirm if they want to delete the selected recipient

    Examples:
      | emailAddress | password       | recipientName | currency | accountNumber |
      | CDRegEmailId | CDRegEmailPass | Seina1 Brown  | HKD      | 56986         |

  @PAD-2928_TC152
  Scenario Outline: 8.2 To verify that application do not get crash and user lands on last delete confirmation screen when user switches between two application
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user clicks on Delete Recipient button
    Then information is displayed to the user to confirm if they want to delete the selected recipient
    When android user switch to other application "<appPackage>"
    And android reswitch to cdapp
    Then information is displayed to the user to confirm if they want to delete the selected recipient

    Examples:
      | emailAddress | password       | recipientName | currency | accountNumber | appPackage                   |
      | CDRegEmailId | CDRegEmailPass | Seina1 Brown  | HKD      | 56981126      | com.google.android.apps.maps |

  @PAD-2925_TC153
  Scenario Outline: 5.2 4.3 To verify that application search the available countries list in micro second by using search option
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country dropdown
    Then list of available country should be displayed in android app
    And android user should be able to select country "<country>" by using search option
    When android user selects currency dropdown
    Then list of available currency should be displayed in android aap
    When android user types each character "<searchCriteria>" in search field
    Then the filtered available currencies list should be displayed after a few micro seconds in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | country | searchCriteria |
      | CDRegEmailId | CDRegEmailPass | Individual | Adam Watson   | Spain   | EUR            |

  @PAD-2925_TC154
  Scenario Outline: 5.2 4.3To verify that empty state list should be displayed along with a message indicating no results have been returned
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country dropdown
    Then list of available country should be displayed in android app
    And android user should be able to select country "<country>" by using search option
    When android user selects currency dropdown
    Then list of available currency should be displayed in android aap
    When android user types each character "<searchCriteria>" in search field
    Then empty state currency list should be displayed in android app along with no result message

    Examples:
      | emailAddress | password       | Type       | recipientName | country | searchCriteria |
      | CDRegEmailId | CDRegEmailPass | Individual | Adam Watson   | Spain   | SSS            |

  @PAD-2925_TC155
  Scenario Outline: 5.2 4.3 To verify that when user selects the close icon in the search field then the country filter should be cleared
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country dropdown
    Then list of available country should be displayed in android app
    And android user should be able to select country "<country>" by using search option
    When android user selects currency dropdown
    Then list of available currency should be displayed in android aap
    When android user types each character "<searchCriteria>" in search field
    And android user selects the close icon in the search field
    Then the filter should be cleared and the whole currency list should be displayed

    Examples:
      | emailAddress | password       | Type       | recipientName | country | searchCriteria |
      | CDRegEmailId | CDRegEmailPass | Individual | Adam Watson   | Spain   | SSS            |

  @PAD-2925_TC156
  Scenario Outline: 4.5 4.6 4.7 To verify that currency list screen gets closed when user selects the currency from the list
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country dropdown
    Then list of available country should be displayed in android app
    And android user should be able to select country "<country>" by using search option
    When android user selects currency dropdown
    Then list of available currency should be displayed in android aap
    When android user types each character "<searchCriteria>" in search field
    When android user select currency
    Then the currency list should be closed with updated recipient country value in android aap

    Examples:
      | emailAddress | password       | recipientName  | Type       | recipientName | country | searchCriteria |
      | CDRegEmailId | CDRegEmailPass | Usher Johnsons | Individual | Adam Watson   | Spain   | EUR            |

  @PAD-2925_TC157
  Scenario Outline: 4.9 To verify that address fields gets displayed for applicable country currency
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country dropdown
    Then list of available country should be displayed in android app
    And android user should be able to select country "<country>" by using search option
    When android user selects currency dropdown
    Then list of available currency should be displayed in android aap
    When android user types each character "<searchCriteria>" in search field
    When android user select currency
    Then address details fields should be displayed to applicable country currency

    Examples:
      | emailAddress | password       | Type       | recipientName | country                  | searchCriteria |
      | CDRegEmailId | CDRegEmailPass | Individual | Donald Watson | United States of America | USD            |

  @PAD-2925_TC158
  Scenario Outline: 4.10  To verify that address fields should not be displayed to if user selects other than specific currency.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country dropdown
    Then list of available country should be displayed in android app
    And android user should be able to select country "<country>" by using search option
    When android user selects currency dropdown
    Then list of available currency should be displayed in android aap
    When android user types each character "<searchCriteria>" in search field
    When android user select currency
    Then address details fields should be not be displayed to un applicable country currency

    Examples:
      | emailAddress | password       | Type       | recipientName | country        | searchCriteria |
      | CDRegEmailId | CDRegEmailPass | Individual | Thomas Watson | United Kingdom | GBP            |

  @PAD-2925_TC159
  Scenario Outline: 4.10To verify that continue button is in disabled state when user do not provides or removes one of the mandatory personal details field data.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user removes one of the mandatory personal field data "<mandatoryField>"
    Then the continue button to save the recipient should be in an disabled state in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | mandatoryField |
      | CDRegEmailId | CDRegEmailPass | Individual | Thomas Watson | FirstName      |

  @PAD-2925_TC160
  Scenario Outline: 4.10To verify that continue button is in disabled state when user do not provides or removes one of the mandatory bank details field data.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user removes one of the mandatory personal field data "<mandatoryField>"
    Then the continue button to save the recipient should be in an disabled state in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency   | mandatoryField |
      | CDRegEmailId | CDRegEmailPass | Individual | Thomas Watson | United Kingdom-GBP | LastName       |

  @PAD-2925_TC161
  Scenario Outline: 4.10 To verify that continue button is in disabled state when user do not provides or removes one of the mandatory address details field data.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters valid account number "<accountNumber>"
    And android user enters valid swift code "<swiftcode>" based on "<country-currency>"
    And android user removes removes one of the mandatory adress field"<mandatoryField>"
    Then the continue button to save the recipient should be in an disabled state in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency | accountNumber | swiftcode | mandatoryField | Address                                       |
      | CDRegEmailId | CDRegEmailPass | Individual | shorn Walness | CANADA-CAD       | 55443344      | 026011242 | RecpientCity   | AdressLine1-abcd xyz,City-pune,Postcode-12345 |

  @PAD-2925_TC163
  Scenario Outline: 3.16 To check that when user enters all the mandatory recipients fields data and click on continue then OTP process should be triggered
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters valid account number "<accountNumber>"
    And android user enters valid swift code "<swiftCode>" based on "<country-currency>"
    Then the continue button to save the recipient should be in an enabled state in android app
    When android user clicks on continue button
    Then OTP page should be displayed to android user

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency   | accountNumber | swiftCode |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam William   | United Kingdom-GBP | 12345678      | 111111    |

  @PAD-2925_TC164
  Scenario Outline: 3.16  To verify resend pin link functionality on add recipient screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters valid account number "<accountNumber>"
    And android user enters valid swift code "<swiftCode>" based on "<country-currency>"
    Then the continue button to save the recipient should be in an enabled state in android app
    When android user clicks on continue button
    Then OTP page should be displayed to android user
    When android user do not enters otp in sixty seconds
    Then resend pin link gets displayed on android app pin screen
    When android user click on resend pin
    Then request a new pin timer should be start for sixty seconds

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency   | accountNumber | swiftCode |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam William   | United Kingdom-GBP | 12345678      | 111111    |

  @PAD-2925_TC165
  Scenario Outline: 3.16 To verify invalid OTP error message on add recipient otp screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters valid account number "<accountNumber>"
    And android user enters valid swift code "<swiftCode>" based on "<country-currency>"
    Then the continue button to save the recipient should be in an enabled state in android app
    When android user clicks on continue button
    Then OTP page should be displayed to android user
    When android user enters invalid otp "<otp>"
    Then android invalid otp error message should be displayed

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency   | accountNumber | swiftCode | OTP               |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam William   | United Kingdom-GBP | 12345678      | 111111    | AndroidInvalidOTP |

  @PAD-2925_TC166_A @addRecipent
  Scenario Outline: 3.17,3.18 To verify recipient should be add successfully and newly added recipient should be mapped correctly on recipient view screen.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters valid account number "<accountNumber>"
    Then bank details should be fetched in android app
    Then the continue button to save the recipient should be in an enabled state in android app
    When android user clicks on continue button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<otp>"
    Then android user should navigate to recipient list screen
    And newly added recipient details "<recipientName>" "<accountNumber>" "<country-currency>" should be displayed at top of the list in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency   | accountNumber          | otp             |
      | CDRegEmailId | CDRegEmailPass | Individual | shorn Walness | United Kingdom-EUR | GB29NWBK60161331926819 | AndroidValidOTP |

  @PAD-2925_TC167
  Scenario Outline: 3.7,3.8,3.9 verify that when user enters valid account number,swift code and user moves focus from respective field then application fetch the bank details
  by validating the the entered bank data

    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters valid account number "<accountNumber>"
    And android user enters valid swift code "<swiftCode>" based on "<country-currency>"
    Then android application should be displayed bank details according to swift code

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency | accountNumber | swiftCode |
      | CDRegEmailId | CDRegEmailPass | Individual | Camela A      | CANADA-CAD       | 55443344      | 026011242 |

  @PAD-2925_TC168
  Scenario Outline: 3.7,3.8,3.9 verify that when user enters valid account number,swift code and user moves focus from respective field then application fetch the bank details by validating the
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters valid account number "<accountNumber>"
    And android user enters valid swift code "<swiftCode>" based on "<country-currency>"
    Then android application should be displayed bank details according to swift code

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency | accountNumber | swiftCode |
      | CDRegEmailId | CDRegEmailPass | Individual | Camela A      | CANADA-CAD       | 55443344      | 026011242 |

  # Not yet implemented : last step
  @PAD-2925_TC169
  Scenario Outline: 3.7,3.8,3.9 To verify error message while adding duplicate payee
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters valid account number "<accountNumber>"
    Then bank details should be fetched in android app
    When android user clicks on continue button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<otp>"

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency | accountNumber      | otp             |
      | CDRegEmailId | CDRegEmailPass | Individual | Adam Kelvin   | Finland-EUR      | FI2112345600000785 | AndroidValidOTP |

  @PAD-2925_TC170
  Scenario Outline: 3.10 To verify error message for invalid account number
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters invalid account number "<accountNumber>"
    And android user enters valid swift code "<swiftCode>" based on "<country-currency>"
    Then invalid account number error message should be displayed to android user

    Examples:
      | emailAddress | password       | Type       | recipientName   | country-currency   | accountNumber | swiftCode |
      | CDRegEmailId | CDRegEmailPass | Individual | William Walness | United Kingdom-GBP | 2234          | 111111    |

  @PAD-2925_TC180
  Scenario Outline: 4.5 4.6 4.7o verify default currency populated for selected country
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country dropdown
    Then list of available country should be displayed in android app
    When android user should be able to select country "<country>" by using search option
    Then prepopulated "<currency>" should be displayed to android user based on selected "<country>"

    Examples:
      | emailAddress | password       | recipientNOnboardingimg ame | Type     | country | currency |
      | CDRegEmailId | CDRegEmailPass | Usher Johnsons              | Commpany | Spain   | Euro     |

  @PAD-3501_146
  Scenario Outline: 7.10 7.14 4 To verify error message when bank details not fetched when details edited
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user has one or more saved recipients
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user updates invalid bank details "<infieldname-data>"
    Then the response not received by apply financial in android aap
    When android user dismiss error popup
    When android user updates bank details "<fieldname-data>"
    Then bank details should be fetched in android app
    Then the bank details should not be fetched in android aap

    Examples:
      | emailAddress | password       | Type       | recipientName | currency | accountNumber | infieldname-data                   | fieldname-data                     |
      | CDRegEmailId | CDRegEmailPass | Individual | Joe Walness   | GBP      | 22345678      | AccountNo-44556671,Sortcode-123456 | AccountNo-44556671,Sortcode-111111 |

  @PAD-3277_181
  Scenario Outline: 7.10 7.14 4 : To verify error message when bank details not fetched when details invalid details provided
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters valid account number "<accountNumber>"
    And android user enters valid swift code "<swiftCode>" based on "<country-currency>"
    And android user enters invalid swift code "<swiftCode>" based on "<country-currency>"
    And android user enters valid swift code "<swiftCode>" based on "<country-currency>"
    Then the response not received by apply financial in android aap
    When android user dismiss error popup
    Then the bank details should not be fetched in android aap

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency   | accountNumber | swiftCode | Address |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam William   | United Kingdom-GBP | 12345678      | 123456    | sdddd   |

  @PAD-2925_TC180
  Scenario Outline: 4.5 4.6 4.7 To verify default currency populated for selected country
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country dropdown
    Then list of available country should be displayed in android app
    When android user should be able to select country "<country>" by using search option
    Then prepopulated "<currency>" should be displayed to android user based on selected "<country>"

    Examples:
      | emailAddress   | password       | recipientName | Type    | country        | currency       |
      | CDRegEmailId19 | CDRegEmailPass | Usher K       | Company | United Kingdom | Sterling Pound |

  @PAD-3563_TC214 @PAD-3563
  Scenario Outline: 2.2.1, 2.4.1 To verify error message gets displayed when user enters invalid data in first name field and when users reviUAT the same field again and corrects the data error message gets removed
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user enter invalid first name "<invalidFirstName>"
    Then error message should be displayed to andoid user as user enter invalid first name
    When android user enter valid recipient first name "<validFirstName>"
    Then error message should be removed to andoid user as user enter valid first name

    Examples:
      | emailAddress | password       | Type       | invalidFirstName | validFirstName |
      | CDRegEmailId | CDRegEmailPass | Individual | A$%^&            | Peter          |

  @PAD-3563_TC215 @PAD-3563
  Scenario Outline: 2.2.2,2.4.2  To verify error message gets displayed when user enters invalid data in last name field and when users reviUAT the same field again and corrects the data error message gets removed
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user enter invalid last name "<invalidLastName>"
    Then error message should be displayed to andoid user as user enter invalid last name
    When android user enter valid recipient last name "<validLastName>"
    Then error message should be removed to andoid user as user enter valid last name

    Examples:
      | emailAddress | password       | invalidLastName | validLastName |
      | CDRegEmailId | CDRegEmailPass | A$#$%%^&        | Murphy        |

  @PAD-3563_TC216 @PAD-3563
  Scenario Outline: 2.2.3,2.4.3 To verify error message gets displayed when user enters invalid data in Company name field and when users reviUAT the same field again and corrects the data error message gets removed
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user select recipient type "<Type>"
    When android user enter invalid company name "<invalidCompanyName>"
    And android user selects "<country>" for recipients
    Then error message should be displayed to andoid user as user enter invalid company name
    When android user enter valid recipient company name "<validCompanyName>"
    Then error message should be removed to andoid user as user enter valid company name

    Examples:
      | emailAddress | password       | Type    | country        | invalidCompanyName | validCompanyName |
      | CDRegEmailId | CDRegEmailPass | Company | United Kingdom | B#N#T$OF%^T&       | BNT-SOFT         |

  @PAD-3563_TC217 @PAD-3563
  Scenario Outline: 2.2.4,2.4.4 To verify error message gets displayed when user enters invalid data in Account number and sort code field and when users reviUAT the same field again and corrects the data error message gets removed
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters invalid account number "<invalidAccountNumber>"
    And android user enter invalid sort code "<invalidSortcode>"
    Then error message should be displayed to andoid user as user enter invalid account number
    And android user enters valid account number "<validAccountNumber>"
    Then error message should be removed to andoid user as user enter valid account number
    And android user enter valid recipient sort code "<validSortcode>"
    Then error message should be removed to andoid user as user enter valid sort code

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency   | invalidAccountNumber | validAccountNumber | invalidSortcode | validSortcode |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam William   | United Kingdom-GBP | 5678                 | 32165498           | 08754           | 401517        |

  @PAD-3563_TC218 @PAD-3563
  Scenario Outline: 2.2.5,2.4.5 To verify error message gets displayed when user enters invalid data in IBAN field and when users reviUAT the same field again and corrects the data error message gets removed
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enter invalid IBAN "<invalidIBAN>"
    Then error message should be displayed to andoid user as user enter invalid IBAN
    And android user enter valid recipient IBAN "<validIBAN>"
    Then error message should be removed to andoid user as user enter valid IBAN

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency | invalidIBAN | validIBAN       |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam William   | Norway-NOK       | FRE         | NO9386011117947 |

  @PAD-3563_TC223 @PAD-3563
  Scenario Outline: 2.3.4 To verify error message gets displayed when user enters only spaces in sort code field and when users reviUAT the same field again and corrects the data error message gets removed
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    When android user enters white spaces in sort code
    Then mandatory sort code error message should be display to android user
    When android user enter valid recipient sort code "<validsortcode>"
    Then error message should be removed to andoid user as user enter valid sort code

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency   | validsortcode |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam William   | United Kingdom-GBP | 401527        |

  @PAD-3563_TC224 @PAD-3563
  Scenario Outline: 2.3.4 To verify error message gets displayed when user enters only spaces in IBAN field and when users reviUAT the same field again and corrects the data error message gets removed
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    When android user enters white spaces in IBAN
    Then mandatory IBAN error message should be display to android user
    When android user enter valid recipient IBAN "<validIBAN>"
    Then error message should be removed to andoid user as user enter valid IBAN

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency | validIBAN                   |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam William   | France-EUR       | FR1420041010050500013M02606 |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam William   | Norway-NOK       | NO9386011117947             |

  @PAD-3563_TC226 @PAD-3563
  Scenario Outline: 2.3.6 To verify error message gets displayed when user enters only spaces in address,city,sountry field and when users reviUAT the same field again and corrects the data error message gets removed
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters white spaces in address
    Then mandatory address error message should be display to android user

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency |
      | CDRegEmailId | CDRegEmailPass | Individual | Sam William   | Australia-AUD    |

  @PAD-3563_TC228 @PAD-3563
  Scenario Outline: 2.3.2 To verify mandatory error message gets displayed when user do not enter any data in account number and sort code
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    Then android user select recipient type "<Type>"
    When android user selects "<country>" for recipients
    And android user does not provide recipients account number
    And android user does not provide recipients sort code
    Then mandatory sort code error message should be display to android user
    Then mandatory account number error message should be display to android user

    Examples:
      | emailAddress | password       | Type       | country        |
      | CDRegEmailId | CDRegEmailPass | Individual | United Kingdom |

  @PAD-3563_TC229 @PAD-3563
  Scenario Outline: 2.3.3 To verify mandatory error message gets displayed when user do not enter any data in  IBAN field
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    Then android user select recipient type "<Type>"
    When android user selects "<country>" for recipients
    And android user does not provide recipients IBAN
    Then mandatory IBAN error message should be display to android user

    Examples:
      | emailAddress | password       | Type       | country |
      | CDRegEmailId | CDRegEmailPass | Individual | France  |

  @PAD-2923_TC230
  Scenario Outline: To verify user should navigate to recipient list screen when the android user clicks close icon on recipient button
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When the android user clicks close icon on recipient button
    Then android user should navigate to recipient list screen

    Examples:
      | emailAddress | password       |
      | CDRegEmailId | CDRegEmailPass |

  @PAD-2927_TC231
  Scenario Outline: To verify application fetches bank details for valid SWIFT code on edit recipient screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters valid account number "<accountNumber>"
    And android user enters valid swift code "<swiftCode>" based on "<country-currency>"
    Then bank details should be fetched in android app
    Then the continue button to save the recipient should be in an enabled state in android app
    When android user clicks on continue button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<emailAddress>"
    Then android user should navigate to recipient list screen
    And newly added recipient details "<recipientName>" "<accountNumber>" "<country-currency>" should be displayed at top of the list in android app
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    When the android user clicks edit recipient button
    Then the edit recipient screen should be displayed on android aap
    When android user validate recipient type "<Type>"
    And android user updates bank details "<fieldname-data>"
    Then bank details should be fetched in android app

    Examples:
      | emailAddress | password       | Type       | recipientName | country-currency             | accountNumber | swiftCode   | environment | currency | fieldname-data                     | personalDetailsField-Data      | addressDetailsField-Data                         |
      | CDRegEmailId | CDRegEmailPass | Individual | sam Walness   | United States of America-USD | 22345678      | USBKUS44LAX | UAT         | USD      | AccountNo-44556671,ABANo-122101706 | FirstName-Ana,LastName-Johnson | AdressLine1-E steet,City-Helsinki,Postcode-00002 |

  @PAD-3971_TC1233
  Scenario Outline: 1.2.2 To verify when user selects the country for which default currency is (not available online) then select currency gets displayed where user can selects the currency manually.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country dropdown
    Then list of available country should be displayed in android app
    And android user should be able to select country "<country>" by using search option
    Then default currency does not displayed for selected country to android user
    When android user selects currency dropdown
    Then list of available currency should be displayed in android aap
    When android user types each character "<searchCriteria>" in search field
    When android user select currency
    Then the currency list should be closed with updated recipient country value in android aap

    Examples:
      | emailAddress | password       | Type       | recipientName  | country | searchCriteria |
      | CDRegEmailId | CDRegEmailPass | Individual | giiter krishvi | Kuwait  | HKD            |

  @PAD-2925_TC0065
  Scenario Outline: 3.17,3.18 To verify recipient should be add successfully and newly added recipient should be mapped correctly on recipient view screen.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user selects the recipient option from the home dashboard
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country-currency "<country-currency>" and enters address "<Address>"
    And android user enters valid account number "<accountNumber>"
    Then bank details should be fetched in android app
    Then the continue button to save the recipient should be in an enabled state in android app
    When android user clicks on continue button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<otp>"
    Then android user should navigate to recipient list screen
    And newly added recipient details "<recipientName>" "<accountNumber>" "<country-currency>" should be displayed at top of the list in android app


    Examples: 
      | emailAddress | password       | Type       | recipientName | country-currency   | accountNumber          |  
      | 3dsuserID2   | CDRegEmailPass | Individual | shorn Walness | United Kingdom-EUR | GB29NWBK60161331926819 |

  

