@New3dImplemantionWallet
Feature: To test new 3d functionality for wallet

    @PAD-5320_3ds2_Wallet_TC_01 
    Scenario Outline: (Standalone PaymentIn) To check Wallet 3ds2 scenario for testcase six.
    3d card user land and on success page and data get mapped.
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
    Then user should navigates to review page 
    When android user click on Confirm and pay button from Review screen
    Then android user land on confirmation screen
    Then deal confirmation screen should be displayed with correct mapped details for add currency in android app 
  Examples:
    | emailAddress| password       | currency |  amount   |  cardLast4Digit|CVV   |cardHolderName|cardNumber      | expiryDate(MMYY)|issuedate| 
    |  3dsuserID2 | CDRegEmailPass | EUR      |   150.00  |  1059          | 555  | AUTHORISED   |4000000000001059|11/26            |12/20    | 
    |  3dsuserID2 | CDRegEmailPass | EUR      |   150.00  |  1054          | 555  | AUTHORISED   |5200000000001054|11/26            |12/20    | 
       
    @PAD-5320_3ds2_Wallet_TC_02 
    Scenario Outline: (Standalone PaymentIn) To check Wallet 3ds2 scenario for testcase four and seven.
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
    When android user enter amount "<amount>" in buying currency wallet and user stops typing the amount
    Then continue button gets enabled in android app
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    When android user selects a saved card "<cardLast4Digit>"
    Then android user select card from save card list
    Then CVV field should display to android user with the message
    And User enters the digits in CVV "<CVV>" fields
    When user click on continue button
    Then android user observe the parameter on Review screen for add currency 
    When android user click on Confirm and pay button from Review screen
    Then deal confirmation screen should be displayed with correct mapped details for add currency in android app
    Then android user land on success page and click on Done button
    Then android user navigates to buy currency screen      
     Examples: 
     | emailAddress  | password       | currency |  amount   |  cardLast4Digit|CVV   | 
     | 3dsuserID5    | CDRegEmailPass | EUR      |   150.00  |  1034          | 555  | 
     | 3dsuserID5    | CDRegEmailPass | EUR      |   150.00  |  1039          | 555  | 
     | 3dsuserID5    | CDRegEmailPass | EUR      |   150.00  |  1067          | 555  | 
     | 3dsuserID5    | CDRegEmailPass | EUR      |   150.00  |  1062          | 555  | 
     
    @PAD-5320_3ds2_Wallet_TC_03 
    Scenario Outline: (Buy currency-Fx) To check Wallet 3ds2 scenario for testcase eight and nine.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    And android user selects Sell currency drop down from wallet
    And android user enters currency code or name "<sellCurrency>"
    When android user click on currency "<sellCurrency>" retrived from search
    When android user enter amount "<amount>" in buying currency wallet
    Then after two sec appropriate amount should be calculated in sell currency wallet in android app
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    Then android user select the payment method Debit Card
    When android user selects a saved card "<cardLast4Digit>"
    Then android user select card from save card list
    Then CVV field should display to android user with the message
    And User enters the digits in CVV "<CVV>" fields
    When android user click on continue button for debit card
    Then android user observe the parameter on Review screen for buy currency 
    When android user click on Confirm and pay button from Review screen
    Then deal confirmation screen should be displayed with correct mapped details for buy currency fx in android app
      Examples: 
        | emailAddress  | password       | currency   | sellCurrency |amount | cardLast4Digit |CVV | 
        | 3dsuserID20   | CDRegEmailPass | EUR        |   GBP        |280.00 | 1075           | 555| 
        | 3dsuserID20   | CDRegEmailPass | GBP        |   EUR        |280.00 | 1070           | 555| 
        | 3dsuserID20   | CDRegEmailPass | GBP        |   EUR        |280.00 | 1083           | 555|
        | 3dsuserID20   | CDRegEmailPass | GBP        |   EUR        |280.00 | 1088           | 555|
        
    @PAD-5320_3ds2_Wallet_TC_04
    Scenario Outline: (Buy currency-Fx) To check Wallet 3ds2 scenario for testcase five.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    And android user selects Sell currency drop down from wallet
    And android user enters currency code or name "<sellCurrency>"
    When android user click on currency "<sellCurrency>" retrived from search
    When android user enter amount "<amount>" in buying currency wallet
    Then after two sec appropriate amount should be calculated in sell currency wallet in android app
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    Then android user select the payment method Debit Card
    When android user selects a saved card "<cardLast4Digit>"
    Then android user select card from save card list
    Then CVV field should display to android user with the message
    And User enters the digits in CVV "<CVV>" fields
    When android user click on continue button for debit card
    Then android user observe the parameter on Review screen for buy currency 
    When android user click on Confirm and pay button from Review screen
    Then android app dispalyed the error for entered wrong cvv
      Examples: 
        | emailAddress | password       | currency   | sellCurrency |amount | cardLast4Digit |CVV | 
        | 3dsuserID6   | CDRegEmailPass | EUR        |   GBP        |280.00 | 1042           | 555| 
        | 3dsuserID6   | CDRegEmailPass | GBP        |   EUR        |280.00 | 1047           | 555| 
       
    @PAD-5320_3ds1_Wallet_TC_05 
    Scenario Outline: (Standalone PaymentIn) To check Wallet 3ds1 scenario for testcase four and five.
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
    When android user enter amount "<amount>" in buying currency wallet and user stops typing the amount
    Then continue button gets enabled in android app
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    When android user selects a saved card "<cardLast4Digit>"
    Then android user select card from save card list
    Then CVV field should display to android user with the message
    And User enters the digits in CVV "<CVV>" fields
    When user click on continue button
    Then android user observe the parameter on Review screen for add currency 
    When android user click on Confirm and pay button from Review screen
    Then deal confirmation screen should be displayed with correct mapped details for add currency in android app
    Then android user land on success page and click on Done button
    Then android user navigates to buy currency screen      
     Examples: 
     | emailAddress  | password       | currency |  amount   |  cardLast4Digit|CVV   | 
     | 3dsuserID8    | CDRegEmailPass | EUR      |   150.00  |  0101          | 555  | 
     | 3dsuserID8    | CDRegEmailPass | EUR      |   150.00  |  4767          | 555  | 
     | 3dsuserID8    | CDRegEmailPass | EUR      |   150.00  |  0044          | 555  | 
     | 3dsuserID8    | CDRegEmailPass | EUR      |   150.00  |  0049          | 555  | 
     
     @PAD-5320_3ds1_Wallet_TC_06
    Scenario Outline: (Buy currency-Fx) To check Wallet 3ds1 scenario for testcase seven and eight.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    And android user selects Sell currency drop down from wallet
    And android user enters currency code or name "<sellCurrency>"
    When android user click on currency "<sellCurrency>" retrived from search
    When android user enter amount "<amount>" in buying currency wallet
    Then after two sec appropriate amount should be calculated in sell currency wallet in android app
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    Then android user select the payment method Debit Card
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
    Then android user observe the parameter on Review screen for buy currency 
    When android user click on Confirm and pay button from Review screen
    Then android user land on success page and click on Done button
      Examples: 
        | emailAddress | password       | currency   | sellCurrency |amount  | cardLast4Digit|CVV   |cardHolderName|cardNumber      | expiryDate(MMYY)|issuedate|
        | 3dsuserID12  | CDRegEmailPass | EUR        |   GBP        |150.00  |  0069          | 555  | AUTHORISED   |4000000000000069|11/26           |12/20    |
        | 3dsuserID12  | CDRegEmailPass | EUR        |   GBP        |150.00  |  0064          | 555  | AUTHORISED   |5200000000000064|11/26           |12/20    | 
        | 3dsuserID12  | CDRegEmailPass | EUR        |   GBP        |150.00  |  0077          | 555  | AUTHORISED   |4000000000000077|11/26           |12/20    | 
        | 3dsuserID12  | CDRegEmailPass | EUR        |   GBP        |150.00  |  0072          | 555  | AUTHORISED   |5200000000000072|11/26           |12/20    | 
        | 3dsuserID12  | CDRegEmailPass | EUR        |   GBP        |150.00  |  0085          | 555  | AUTHORISED   |4000000000000085|11/26           |12/20    | 
        | 3dsuserID12  | CDRegEmailPass | EUR        |   GBP        |150.00  |  0080          | 555  | AUTHORISED   |5200000000000080|11/26           |12/20    |
        
    @PAD-5320_3ds2_Wallet_TC_07
    Scenario Outline: (Standalone PaymentIn) To check Wallet 3ds2 scenario for refused cards
    3d card user land and on success page and data get mapped.
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
    Then user should navigates to review page 
    When android user click on Confirm and pay button from Review screen
    Then android user land on confirmation screen
    Then deal confirmation screen should be displayed with correct mapped details for add currency in android app 
  Examples:
    | emailAddress | password       | currency |  amount   |  cardLast4Digit|CVV   |cardHolderName|cardNumber      | expiryDate(MMYY)|issuedate| 
    |  3dsuserID26 | CDRegEmailPass | EUR      |   150.00  |  1067          | 555  | AUTHORISED   |4000000000001067|11/26            |12/20    | 
    |  3dsuserID26 | CDRegEmailPass | EUR      |   150.00  |  1062          | 555  | AUTHORISED   |5200000000001062|11/26            |12/20    | 
    |  3dsuserID26 | CDRegEmailPass | EUR      |   150.00  |  1083          | 555  | AUTHORISED   |4000000000001083|11/26            |12/20    | 
    |  3dsuserID26 | CDRegEmailPass | EUR      |   150.00  |  1088          | 555  | AUTHORISED   |5200000000001088|11/26            |12/20    | 