@New3dImplemantionMAT
Feature: To test new 3d functionality for make a transfer

    @PAD-5320_3ds2_MAT_TC_01
    Scenario Outline: To check MAT 3ds2 scenario for testcase one and three.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
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
    When android user selects a saved card "<cardLast4Digit>"
    Then android user select card from save card list
    Then CVV field should display to android user with the message
    And User enters the digits in CVV "<CVV>" fields
    And android user select payment reason Debit Card
    When android user click on continue button for debit card
    And android user click on Confirm and pay button from Review screen
    Then android user land on success page and click on Done button

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit  | CVV | paymentreason | 
      | 3dsuserID7   | CDRegEmailPass | GBP      | EUR         | 200.00 | Jack Smith | EUR   |  FR1420041010050500013M02606   |  1000 | 555 | Emigration    | 
      | 3dsuserID7   | CDRegEmailPass | GBP      | EUR         | 200.00 | Jack Smith | EUR   |  FR1420041010050500013M02606   |  1005 | 555 | Emigration    | 
      | 3dsuserID7   | CDRegEmailPass | GBP      | EUR         | 200.00 | Jack Smith | EUR   |  FR1420041010050500013M02606   |  1026 | 555 | Emigration    | 
      | 3dsuserID7   | CDRegEmailPass | GBP      | EUR         | 200.00 | Jack Smith | EUR   |  FR1420041010050500013M02606   |  1021 | 555 | Emigration    |
      
    @PAD-5320_3ds2_MAT_TC_02
    Scenario Outline: To check MAT 3ds2 scenario for testcase two
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
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
    Then android app dispalyed the error for entered wrong cvv
      Examples: 
       | emailAddress| password       | sellCurrency | buyCurrency | amount | recipientName| currency | accountNumber  | cardHolderName | cardNumber   | expiryDate(MMYY) | issuedate | cardLast4Digit | CVV |PaymentReference| 
       | 3dsuserID6  | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606  | AUTHORISED | 4000000000001042 | 12/29  | 09/20     |    1042 | 555 | abv            |
       | 3dsuserID6  | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606  | AUTHORISED | 5200000000001047 | 12/29  | 09/20     |    1047 | 555 | abv            |  
      
    @PAD-5320_3ds1_MAT_TC_03
    Scenario Outline: To check MAT 3ds1 scenario for testcase six and twelve.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
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
    Examples: 
       | emailAddress| password       | sellCurrency | buyCurrency | amount | recipientName| currency | accountNumber  | cardHolderName | cardNumber   | expiryDate(MMYY) | issuedate | cardLast4Digit | CVV |PaymentReference| 
       | 3dsuserID9  | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606  | AUTHORISED | 4000000000000051 | 12/29  | 09/20     |    0051 | 555 | abv              |
       | 3dsuserID9  | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606  | AUTHORISED | 5200000000000056 | 12/29  | 09/20     |    0056 | 555 | abv            |  
       | 3dsuserID9  | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606  | AUTHORISED | 5200990000000009 | 12/29  | 09/20     |    0009 | 555 | abv            |  
     
    @PAD-5320_3ds2_MAT_TC_04
    Scenario Outline: To check MAT 3ds1 scenario for Refused cards
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
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
    Then android app dispalyed the error for entered wrong cvv
      Examples: 
       | emailAddress| password       | sellCurrency | buyCurrency | amount | recipientName| currency | accountNumber  | cardHolderName | cardNumber   | expiryDate(MMYY) | issuedate | cardLast4Digit | CVV |PaymentReference| 
       | 3dsuserID25 | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606  | REFUSED | 4000000000000101 | 12/29  | 09/20     |    0101 | 555 | abv            |
       | 3dsuserID25 | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606  | REFUSED | 5200000000000908 | 12/29  | 09/20     |    0908 | 555 | abv            |
       | 3dsuserID25 | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606  | REFUSED | 4000000000000085 | 12/29  | 09/20     |    0085 | 555 | abv            |
       | 3dsuserID25 | CDRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606  | REFUSED | 5200000000000080 | 12/29  | 09/20     |    0080 | 555 | abv            |
           
