@New3dImplemantion
Feature: To test new 3d functionality:


  @PAD-3646_TC93
  Scenario Outline: (Standalone PaymentIn) 8.11 To verify that when user click on yes cancel from 3d page then payment should be cancelled
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    When android user click on pay in "<currency>" tab
    And android user enter amount "<amount>" in buying currency wallet and user stops typing the amount
    Then continue button gets enabled in android app
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    When android user selects a saved card "<cardLast4Digit>"
    Then android user select card from save card list
    Then CVV field should display to android user with the message
    And User enters the digits in CVV "<CVV>" fields
    When android user click on continue wallet
    And android user click on Confirm and pay button from Review screen
    Then android user is navigated towards 3ds page

    Examples:
      | emailAddress | password       | currency | amount | cardLast4Digit | CVV |
      | CDSITUser1   | CDRegEmailPass | EUR      | 150.00 | 1091           | 555 |


  @PAD-4851_3ds2_006
  Scenario Outline: 8.7 To verify that NEW 3d card user land on success page post submitting valid data in all field
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user selects buy currency drop down
    And android user enters currency code or name "<buyCurrency>"
    Then android user should be able to search the available currencies through the search bar
    And android user selects Sell currency drop down
    And android user enters currency code or name "<sellCurrency>"
    Then android user should be able to search the available currencies through the search bar
    And android user enter amount "<amount>" in buying currency and user stops typing the amount
    Then after two sec appropriate amount should be calculated in sell currency in android app
    When android user click on continue
    Then android user should land on select recipient screen
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen
    Then android user select the payment method Debit Card
    And android user selects to add a new card
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    And android user clicks on save button
    When android user selects a saved card "<cardLast4Digit>"
    Then android user select card from save card list
    Then CVV field should display to android user with the message
    And User enters the digits in CVV "<CVV>" fields
    And android user select payment reason Debit Card
    And android user enter Payment Reference "<PaymentReference>"
    When android user click on continue button for debit card
    And android user click on Confirm and pay button from Review screen
    Then android user land on success page and click on Done button
    And android user should be land on activity screen

    Examples:
      | Testcase | emailAddress | password       | sellCurrency | buyCurrency | amount | recipientName | currency | accountNo                   | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate | cardLast4Digit | CVV | PaymentReference |
      | TC_4     | CDSITUser2   | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith    | EUR      | FR1420041010050500013M02606 | AUTHORISED     | 4000000000001034 | 12/29            | 09/20     | 1034           | 555 | abv              |
      | TC_4     | CDSITUser2   | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith    | EUR      | FR1420041010050500013M02606 | AUTHORISED     | 5200000000001039 | 12/29            | 09/20     | 1039           | 555 | abv              |
      | TC_6     | CDSITUser2   | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith    | EUR      | FR1420041010050500013M02606 | AUTHORISED     | 4000000000001059 | 12/29            | 09/20     | 1059           | 555 | abv              |
      | TC_6     | CDSITUser2   | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith    | EUR      | FR1420041010050500013M02606 | AUTHORISED     | 5200000000001054 | 12/29            | 09/20     | 1054           | 555 | abv              |


  @PAD-4851_3ds2_001
  Scenario Outline: (Standalone PaymentIn) 13.5 To verify User allowed to performed PayIn same currency journey successfully using add new card flow
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    When android user click on pay in "<currency>" tab
    And android user enter amount "<amount>" in buying currency wallet and user stops typing the amount
    Then continue button gets enabled in android app
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    And android user selects to add a new card
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    Then the option to save the card should be in active/enabled state in android app
    And android user clicks on save button
    Then android user should navigate to card list screen
    When android user selects a saved card "<cardLast4Digit>"
    Then android user select card from save card list
    Then CVV field should display to android user with the message
    And User enters the digits in CVV "<CVV>" fields
    When user click on continue button
    Then android user observe the parameter on Review screen for add currency
    When android user click on Confirm and pay button from Review screen
    Then deal confirmation screen should be displayed with correct mapped details for add currency in android app
    Examples:
      | Testcase | emailAddress | password       | currency | amount | cardLast4Digit | CVV | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate |
      | TC_1     | CDSITUser1   | CDRegEmailPass | GBP      | 150.00 | 0002           | 555 | AUTHORISED     | 4000000000001000 | 12/29            | 09/20     |
      | TC_1     | CDSITUser1   | CDRegEmailPass | GBP      | 150.00 | 1005           | 555 | AUTHORISED     | 5200000000001005 | 12/29            | 09/20     |
      | TC_3     | CDSITUser1   | CDRegEmailPass | GBP      | 150.00 | 1026           | 555 | AUTHORISED     | 4000000000001026 | 12/29            | 09/20     |
      | TC_3     | CDSITUser1   | CDRegEmailPass | GBP      | 150.00 | 1021           | 555 | AUTHORISED     | 5200000000001021 | 12/29            | 09/20     |
      | TC_8     | CDSITUser1   | CDRegEmailPass | GBP      | 150.00 | 1075           | 555 | AUTHORISED     | 4000000000001075 | 12/29            | 09/20     |
      | TC_8     | CDSITUser1   | CDRegEmailPass | GBP      | 150.00 | 1070           | 555 | AUTHORISED     | 5200000000001070 | 12/29            | 09/20     |

  @PAD-4851_3ds2_002
  Scenario Outline: Buy currency-Fx To verify payment journey flow for add new card Non-3d Card with wrong cvv.
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    And android user selects Sell currency drop down from wallet
    And android user enters currency code or name "<sellCurrency>"
    When android user click on currency "<sellCurrency>" retrived from search
    And android user enter amount "<amount>" in buying currency wallet and user stops typing the amount
    Then after two sec appropriate amount should be calculated in sell currency wallet in android app
    Then continue button gets enabled in android app
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    And android user selects to add a new card
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    Then the option to save the card should be in active/enabled state in android app
    And android user clicks on save button
    Then android user should navigate to card list screen
    When android user selects a saved card "<cardLast4Digit>"
    Then android user select card from save card list
    Then CVV field should display to android user with the message
    And User enters the digits in CVV "<CVV>" fields
    When android user click on continue button for debit card
    When android user click on Confirm and pay button from Review screen
    Then android app dispalyed the error for entered wrong cvv
    Examples:
      | Testcase | emailAddress | password       | currency | amount | cardLast4Digit | CVV | sellCurrency | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate |
      | TC_2     | CDSITUser2   | CDRegEmailPass | GBP      | 150.00 | 1018           | 555 | EUR          | AUTHORISED     | 4000000000001018 | 12/29            | 09/20     |
      | TC_2     | CDSITUser2   | CDRegEmailPass | GBP      | 150.00 | 1013           | 555 | EUR          | AUTHORISED     | 5200000000001013 | 12/29            | 09/20     |
      | TC_5     | CDSITUser2   | CDRegEmailPass | GBP      | 150.00 | 1042           | 555 | EUR          | AUTHORISED     | 4000000000001042 | 12/29            | 09/20     |
      | TC_5     | CDSITUser2   | CDRegEmailPass | GBP      | 150.00 | 1047           | 555 | EUR          | AUTHORISED     | 5200000000001047 | 12/29            | 09/20     |
      | TC_7     | CDSITUser2   | CDRegEmailPass | GBP      | 150.00 | 1067           | 555 | EUR          | AUTHORISED     | 4000000000001067 | 12/29            | 09/20     |
      | TC_7     | CDSITUser2   | CDRegEmailPass | GBP      | 150.00 | 1062           | 555 | EUR          | AUTHORISED     | 5200000000001062 | 12/29            | 09/20     |
    