 @SendMoney_AndroidTorFx
Feature: Send Money :

  
  @PAD-3040_TC01_AndroidTorFx
  Scenario Outline: 1.1 To check that user land on send money screen after login sucessfully
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then android user should be land on send money screen

    Examples: 
      | emailAddress       | password          | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | 

  @PAD-3041_TC02_AndroidTorFx 
  Scenario Outline: 2.1 2.2 selling currency  To verify that amount get calculated in sell currency when user entered amount in Buy currency
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user enter amount "<amount>" in buying currency and user stops typing the amount
    Then after two sec appropriate amount should be calculated in sell currency in android app

    Examples: 
      | emailAddress       | password          | amount   | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | 2,000.00 | 

  @PAD-3041_TC03_AndroidTorFx @TorFxregression
  Scenario Outline: 2.3 Selling currency  To verify that when amount entered in selling currency is less than allowed limit (100 GBP) error message to be displayed
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user enter amount "<amount>" less than hundred GBP in selling currency and user stops typing the amount
    Then minimum amount limit error message should be displayed to android user

    Examples: 
      | emailAddress       | password          | amount | 
      | TorFxSendMoneyUser | TorFxRegEmailPass |  99.99 | 

   @PAD-3041_TC04_AndroidTorFx 
  Scenario Outline: 2.4 Selling currency  To verify that when amount entered in selling currency is greater than allowed GBP limit (25000 GBP) error message to be displayed
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user enter amount "<amount>" greater than allowed GBP limit in selling currency
    Then maximum allowed amount limit error message should be displayed to android user

    Examples: 
      | emailAddress       | password          | amount    | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | 25,001.00 | 

  @PAD-3041_TC05_AndroidTorFx
  Scenario Outline: 2.1 2.2 2.6 2.5 2.9 buying currency  To verify that amount get calculated in buying currency when user entered amount in selling currency
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user enter amount "<amount>" in selling currency
    Then after two sec appropriate amount should be calculated in buy currency in android app

    Examples: 
      | emailAddress       | password          | amount   | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | 1,500.00 | 

  @PAD-3041_TC06_AndroidTorFx
  Scenario Outline: 2.7 Buying currency  To verify that when amount entered in buying currency such that calculated amount in selling currency is less than 100 GBP error message to be displayed
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user enter amount "<amount>" in buying currency
    Then minimum amount limit error message should be displayed to android user

    Examples: 
      | emailAddress       | password          | amount | 
      | TorFxSendMoneyUser | TorFxRegEmailPass |  99.00 | 

  @PAD-3041_TC07_AndroidTorFx @TorFxregression
  Scenario Outline: 2.8 To verify that when amount entered in buying currency such that calculated amount in selling currency is greater than allowed GBP (25000 GBP) error message to be displayed
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user enter amount "<amount>" in buying currency
    Then maximum allowed amount limit error message should be displayed to android user

    Examples: 
      | emailAddress       | password          | amount    | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | 50,000.00 | 

   @PAD-3041_TC08_AndroidTorFx @TorFxregression
  Scenario Outline: 2.11 2.13  To Verify after 60 sec rate gets refreshed and buying amount gets updated as amount is entered in selling currency.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user selects buy currency drop down
    And android user enters currency code or name "<currency>"
    Then android user should be able to search the available currencies through the search bar
    And android user enter amount "<amount>" in selling currency
    Then after two sec appropriate amount should be calculated in buy currency in android app
    And an auto timer of sixty seconds should start and rate should be refreshed and buying amount should be updated

    Examples: 
      | emailAddress       | password          | amount   | currency | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | 10001.00 | INR      | 

  @PAD-3041_TC09_AndroidTorFx 
  Scenario Outline: 2.11 2.14 To Verify after 60 sec rate gets refreshed and selling amount gets updated as amount is entered in buying currency
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user selects Sell currency drop down
    And android user enters currency code or name "<currency>"
    Then android user should be able to search the available currencies through the search bar
    And android user enter amount "<amount>" in buying currency and user stops typing the amount
    Then after two sec appropriate amount should be calculated in sell currency in android app
    And an auto timer of sixty seconds should start and rate should be refreshed and selling amount should be updated

    Examples: 
      | emailAddress       | password          | amount   | currency | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | 10001.00 | USD      | 

   @PAD-3041_TC10_AndroidTorFx
  Scenario Outline: 2.12 To verify Fx deal rates are fetched again and the timer gets resets after every 60 second when user enters amount in selling currency
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user enter amount "<amount>" in selling currency
    Then after two sec appropriate amount should be calculated in buy currency in android app
    And an auto timer of sixty seconds should start and rate should be refreshed and buying amount should be updated
    And an auto timer of sixty seconds should start and rate should be refreshed and buying amount should be updated

    Examples: 
      | emailAddress       | password          | amount  | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | 1000.01 | 

  @PAD-3041_TC11_AndroidTorFx
  Scenario Outline: 2.12 To verify Fx deal rates are fetched again and the timer gets resets after every 60 second when user enters amount in buying currency
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user enter amount "<amount>" in buying currency and user stops typing the amount
    Then after two sec appropriate amount should be calculated in sell currency in android app
    And an auto timer of sixty seconds should start and rate should be refreshed and selling amount should be updated
    And an auto timer of sixty seconds should start and rate should be refreshed and selling amount should be updated

    Examples: 
      | emailAddress       | password          | amount    | 
      | TorFxSendMoneyUser | TorFxRegEmailPass |  10001.00 | 

  @PAD-3042_TC12_AndroidTorFx
  Scenario Outline: Buy currency drop down To verify on click of back arrow on drop down page user should be lands on send money page.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user selects buy currency drop down
    And android user clicks on back arrow
    Then android user should be land on send money screen

    Examples: 
      | emailAddress       | password          | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | 

  @PAD-3042_TC13_AndroidTorFx
  Scenario Outline: Sell currency drop down To verify on click of back arrow on drop down page user should be lands on send money page.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user selects Sell currency drop down
    And android user clicks on back arrow
    Then android user should be land on send money screen

    Examples: 
      | emailAddress       | password          | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | 

  @PAD-3042_TC14_AndroidTorFx  @TorFxregression
  Scenario Outline: 3.2 3.3 sell currency drop down  To verify the that user should be able to search currency.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user selects Sell currency drop down
    And android user enters currency code or name "<currency>"
    Then android user should be able to search the available currencies through the search bar

    Examples: 
      | emailAddress       | password          | currency       | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP            | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | CAD            | 

   @PAD-3042_TC15_AndroidTorFx
  Scenario Outline: 3.2 3.3 buy currency drop down  To verify the that user should be able to search currency.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user selects buy currency drop down
    And android user enters currency code or name "<currency>"
    Then android user should be able to search the available currencies through the search bar

    Examples: 
      | emailAddress       | password          | currency          | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | AUD               | 

  @PAD-3042_TC16_AndroidTorFx
  Scenario Outline: 3.2 3.3 sell currency drop down  To verify enter search data gets cleared when user selects (x) option
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user selects Sell currency drop down
    And android user enters currency code or name "<currency>"
    When android user click on (X) option
    Then the filter should be cleared and the whole currency list should be displayed in android app

    Examples: 
      | emailAddress       | password          | currency       | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP            | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | Sterling Pound | 

  @PAD-3042_TC17_AndroidTorFx
  Scenario Outline: 3.2 3.3 sell currency drop down  To verify enter search data gets cleared when user selects (x) option
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user selects buy currency drop down
    And android user enters currency code or name "<currency>"
    When android user click on (X) option
    Then the filter should be cleared and the whole currency list should be displayed

    Examples: 
      | emailAddress       | password          | currency       | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP            | 

   @PAD-3042_TC18_AndroidTorFx
   Scenario Outline: 3.5 Sell currency drop down To verify that after selecting currency, app should take the user to the home screen with the selected currency in buying/selling currency.
   Given android user installed the new TorFx app and launched successfully
   Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user selects Sell currency drop down
    And android user enters currency code or name "<currency>"
    Then android user should be able to search the available currencies through the search bar
    Then android app should take the user to the home screen with the selected currency "<currency>" in selling dropdown

    Examples: 
      | emailAddress       | password          | currency       | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP            | 

  @PAD-3042_TC19_AndroidTorFx
  Scenario Outline: 3.5 Buy currency drop down To verify that after selecting currency, app should take the user to the home screen with the selected currency in buying/selling currency.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user selects buy currency drop down
    And android user enters currency code or name "<currency>"
    Then android user should be able to search the available currencies through the search bar
    Then android app should take the user to the home screen with the selected currency "<currency>"in buying dropdown

    Examples: 
      | emailAddress       | password          | currency       | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP            | 

  @PAD-3042_TC20_AndroidTorFx  @TorFxregression
  Scenario Outline: 3.8 To verify when user selects invalid currency pair then rate should not be fetch and error message to be displayed
    Given android user installed the new TorFx app and launched successfully
   Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user should be land on send money screen
    And android user selects buy currency drop down
    And android user enters currency code or name "<buyCurrency>"
    Then android user should be able to search the available currencies through the search bar
    Then android app should take the user to the home screen with the selected currency buyCurrency "<buyCurrency>" in buying dropdown
    And android user selects Sell currency drop down
    And android user enters currency code or name "<sellCurrency>"
    Then android user should be able to search the available currencies through the search bar 
    Then error message should be displayed for unsupported currency pair
    And rate should not be fetched

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency     | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | AED          | CAD             | 

  @PAD-3043_TC21_AndroidTorFx @TorFxregression
  Scenario Outline: 4.1 4.2 To verify when user selects swap option only currency should get swap and default selling amount should remain as is.
   Given android user installed the new TorFx app and launched successfully
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
    And android user click on swap
    Then after swap sell currency displayed as buy "<buyCurrency>" and buy currency displayed as sell "<sellCurrency>" currency
    And in selling "<amount>" amount should remain as is in android app

    Examples: 
      | emailAddress       | password          | buyCurrency | sellCurrency | amount   | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | AUD         | USD          | 1,000.00 | 

  @PAD-3043_TC22_AndroidTorFx
  Scenario Outline: 4.1 4.2 To verify when user selects swap option only currency should get swap and entered buying amount should remain as is
    Given android user installed the new TorFx app and launched successfully
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
    And android user click on swap
    Then after swap sell currency displayed as buy "<buyCurrency>" and buy currency displayed as sell "<sellCurrency>" currency
    And in buying amount "<amount>" should remain as is

    Examples: 
      | emailAddress       | password          | buyCurrency | amount   | sellCurrency | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | CAD         | 1,500.00 | AUD          | 

   @PAD-3043_TC23_AndroidTorFx
  Scenario Outline: 4.1 4.2 To verify when user selects swap option only currency should get swap and entered buying amount should remain as is
   Given android user installed the new TorFx app and launched successfully
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
    And android user enter amount "<amount>" in selling currency
    And android user click on swap
    Then after swap sell currency displayed as buy "<buyCurrency>" and buy currency displayed as sell "<sellCurrency>" currency
    And in selling "<amount>" amount should remain as is in android app

    Examples: 
      | emailAddress       | password          | buyCurrency | amount  | sellCurrency | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | CAD         | 1,500.00| AUD          | 

    @PAD-3045_TC24_AndroidTorFx
  Scenario Outline: 6.2 To verify that user lands on select recipient screen when user clicks on the continue button available on send money screen
    Given android user installed the new TorFx app and launched successfully
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

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency | amount  | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | EUR          | AUD         | 2000.00 | 

  @PAD-3045_TC25_AndroidTorFx
  Scenario Outline: 6.2 6.3 To verify on click of cancel button on select recipient page user should be lands on send money page and default currency pair and amount should be displayed in selling currency
   Given android user installed the new TorFx app and launched successfully
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
    When android user click on continue
    Then android user should land on select recipient screen
    When android user clicks on cancel button
    And android user should be land on send money screen
    And default currency pair "<defaultCurrencyPair>" and amount "<defaultSellingAmt>"should be displayed in selling currency

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency | defaultCurrencyPair | defaultSellingAmt | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | EUR          | AUD         | EUR-AUD             |          1,000.00 | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | GBP-EUR             |          1,000.00 | 

    @PAD-3045_TC27_AndroidTorFx
  Scenario Outline: 6.4 To check that only those recipients are shown in the list, who can receive the buying currency, as selected by the user in the send money screen step1.
    Given android user installed the new TorFx app and launched successfully
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
    And only buy currency "<buyCurrency>" recipients list should be displayed to android user

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency | amount   | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | EUR          | USD         | 2,000.00 | 

     @PAD-3045_TC28_AndroidTorFx @TorFxregression
  Scenario Outline: 6.4 To verify that empty recipients screen gets displayed when selected buy currency recipient are not present in recipient list.
   Given android user installed the new TorFx app and launched successfully
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
    When android user has no saved recipients previously
    Then empty recipient screen with an option to add a new recipient should be displayed in android app

    Examples: 
      | emailAddress | password          | sellCurrency | buyCurrency      | amount   | 
      | CDNoWallet   | TorFxRegEmailPass | GBP          | Romanian New Lei | 2,000.00 | 

   @PAD-3045_TC29_AndroidTorFx   
  Scenario Outline: 6.5 6.6 To verify that application allow user to initiate add recipient process during send money journey currency field should be set to the Buy Currency of the Send Money and it should not be editable.
   Given android user installed the new TorFx app and launched successfully
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
    And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country dropdown
    Then list of available country should be displayed in android app
    And android user should be able to select country "<country>" by using search option
    And non editable recipient currency should be auto set as buying currency "<buyCurrency>" in android app

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency | amount   | country | Type       | recipientName | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | EUR          | DKK         | 2,000.00 | Denmark | Individual | Adam Watson   | 

   @PAD-3045_TC30_AndroidTorFx @TorFxregression 
  Scenario Outline: 6.7 7.1 To verify that user lands on payment method page once user completes the add recipient process during the send money journey and selects newly added recipien
    Given android user installed the new TorFx app and launched successfully
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
    #And android user select the payment method
    Then android user select the payment method Debit Card
    And android user selects to add a new card
    Then pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | nameBillingAddress         | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 | Richard Smith,SKNDA1DartfordUK | 

   @PAD-3045_TC31_AndroidTorFx  
  Scenario Outline: 6.8 To verify that user lands on payment method page once user selects the recipient from the available recipient list during the send money journey
    Given android user installed the new TorFx app and launched successfully
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
    And only buy currency "<buyCurrency>" recipients list should be displayed to android user
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606  | 

   @PAD-3047_TC32_AndroidTorFx  
  Scenario Outline: 7.2 7.3 To verify that when user selects back button on the payment method page then user should
    land on recipient list screen with selected recipient state and only those recipients should be displayed
    who can receive the buying currency as selected by the user in the send money screen step1.

    Given android user installed the new TorFx app and launched successfully
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
    And only buy currency "<buyCurrency>" recipients list should be displayed to android user
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen
    When android user clicks on back arrow from payment method screen
    Then android user should land on select recipient screen
    And only buy currency "<buyCurrency>" recipients list should be displayed to android user

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606  | 

     @PAD-3047_TC33_AndroidTorFx 
     Scenario Outline: 7.8 To verify that user navigates to add card page when user clicks on add card option from the empty card payment method screen.
    Given android user installed the new TorFx app and launched successfully
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
    #And android user select the payment method
    Then android user select the payment method Debit Card
    And android user selects to add a new card
    Then pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | nameBillingAddress         | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606 | Richard Smith,SKNDA1DartfordUK | 

    @PAD-3047_TC34_AndroidTorFx  
  Scenario Outline: 7.9 To verify list of saved cards number is masked except last four digits in accordance with PCI-DSS requirements
    Given android user installed the new TorFx app and launched successfully
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
    And android user has one or more saved cards
    Then saved cards number should be masked except last four digits in android app accordance with PCI-DSS requirements

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo                     | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606  | 

   @PAD-3047_TC35_AndroidTorFx 
  Scenario Outline: 7.11 To verify that user can add new card successfully and user should land card list page where recently added card displayed
    Given android user installed the new TorFx app and launched successfully
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
    Then the option to save the card should be in active/enabled state in android app
    And android user clicks on save button
    Then android user should navigate to card list screen
    And card "<cardNumber>" details should be saved in android app debit card list as per order of date added

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 | Richard Smith  | 6759649826438453 | 12/29            | 09/20     | 

  @PAD-3047_TC36_AndroidTorFx @TorFxregression  
  Scenario Outline: To verify that in send money flow while adding new card when last name does not match with the account holders last name the system should give proper error message
   Given android user installed the new TorFx app and launched successfully
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
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides invalid unmatched contacts last name "<unmatchedLastName>"
    Then invalid last name error message should be displayed to andoid user

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | nameBillingAddress        | unmatchedLastName | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606 | Richard Smith,SKNDA1DartfordUK | Tom k          | 

  @PAD-3047_TC37_AndroidTorFx  
  Scenario Outline: To verify that in send money flow while adding new card when expiry date is less than current date than system should give proper error message
    Given android user installed the new TorFx app and launched successfully
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
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides invalid expiry date "<pastExpiryDate(MMYY)>"
    Then invalid expiry date error message should be displayed to android user

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | nameBillingAddress        | pastExpiryDate(MMYY) | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606 | Richard Smith,SKNDA1DartfordUK | 01/20             | 
 
   @PAD-3047_TC38_AndroidTorFx  
  Scenario Outline: 7.13 To verify that when user selects any card from available list then CVV field gets displayed to user with the message
    Given android user installed the new TorFx app and launched successfully
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

    Examples: 
      | emailAddress   | password       | sellCurrency | buyCurrency | amount  | recipientName| currency | accountNo                   |cardLast4Digit | 
      | TorFxSendMoneyUser3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith   | EUR      |FR1420041010050500013M02606  | 8453 | 

   @PAD-3047_TC39_AndroidTorFx @TorFxregression  
  Scenario Outline: 7.13 To verify that when user selects any card from available list then enter 2digit CVV field then continue button gets disabled
    Given android user installed the new TorFx app and launched successfully
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
    Then continue button should get disabled in android app

    Examples: 
      | emailAddress   | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit| CVV | paymentreason | 
      | TorFxSendMoneyUser3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 |           8453 |  55 | Emigration    | 

    @PAD-3047_TC40_AndroidTorFx  
    Scenario Outline: 7.13 To verify that when user selects any card from available list then enter correct  CVV field then continue button gets enabled
    Given android user installed the new TorFx app and launched successfully
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
    Then continue button should get enabled for debit card in android app

    Examples: 
      | emailAddress   | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit | CVV | paymentreason | 
      | TorFxSendMoneyUser3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606   |           8453 | 555 | Emigration    | 

   @PAD-3047_TC41_AndroidTorFx @TorFxregression  
   Scenario Outline: 7.15 To verify continue button gets disabled when user enter cvv and do not provide payment reason
    Given android user installed the new TorFx app and launched successfully
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
    And android user do not select payment reason Debit card
    Then continue button should get disabled for debit card in android app

    Examples: 
      | emailAddress   | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo| cardLast4Digit | CVV | 
      | TorFxSendMoneyUser3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 |    8453 | 555 | 
      
  @PAD-3047_TC42_AndroidTorFx  
  Scenario Outline: 7.16 7.17 To verify that user lands on review page when user selects the valid CVV and data get mapped correctly
    Given android user installed the new TorFx app and launched successfully
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
    Then continue button should get enabled for debit card in android app
    When android user click on continue button for debit card
    Then user should navigates to review page

    Examples: 
      | emailAddress   | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit | CVV | paymentreason | 
      | TorFxSendMoneyUser3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 |           8453  | 555 | Emigration    | 

  @PAD-3047_TC43_AndroidTorFx   
  Scenario Outline: 2.11 To verify that clicking on back button of review screen user get navigate back on the payment method screen WITH PREVIOUS PAYMENT METHOD SELECTED
   Given android user installed the new TorFx app and launched successfully
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
    Then user should navigates to review page
    Then android user click on back button from review screen and get navigate back on the payment method screen
    And previously selected payment method Debit Card should be displayed in android app on payment method screen

    Examples: 
      | emailAddress   | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit | CVV | paymentreason | 
      | TorFxSendMoneyUser3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 |           8453  | 555 | Emigration    | 

   @PAD-3047_TC44_AndroidTorFx  
  Scenario Outline: 8.6.1 To verify when CDLGB user selects the T's & C's link,window should open with a link to the respective UK T's & C'
    Given android user installed the new TorFx app and launched successfully
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
    Then user should navigates to review page
    Then android user click on terms and condition link
    Then window should open with a link to the respective UK T's & C in android app

    Examples: 
      | emailAddress   | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit | CVV | paymentreason | 
      | TorFxSendMoneyUser3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606  |           8453 | 555 | Emigration    | 

    @PAD-3047_TC45_AndroidTorFx   
    Scenario Outline: 8.6.3 To verify that user lands on review page on click of back button or the device back button on UK T's & C window
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter Payment Reference "<PaymentReference>"
    Then continue button should get enabled for debit card in android app
    When android user click on continue button for debit card
    Then user should navigates to review page
    Then android user click on terms and condition link
    Then window should open with a link to the respective UK T's & C in android app
    When android user click on back button or the device back button on UK T's & C window
    Then android user click on back button from terms and condition and lands back to review screen

    Examples: 
      | emailAddress   | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit | CVV | paymentreason | PaymentReference | 
      | TorFxSendMoneyUser3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606  |           8453 | 555 | Emigration    | Testing on SIT   | 

   @PAD-3047_TC46_AndroidTorFx   
   Scenario Outline: 8.10 To verify that existing 3d card user land on 3d page post submitting the review page
   Given android user installed the new TorFx app and launched successfully
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
    Then user land on 3d page

    Examples: 
      | emailAddress      | password          | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit | CVV | paymentreason | 
      | TorFxWalletList3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606  |           8453 | 555 | Emigration    | 

   @PAD-3047_TC47_AndroidTorFx   
   Scenario Outline: 8.11 To verify that when user click on back option from 3d page then user should land on review page
   Given android user installed the new TorFx app and launched successfully
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
    Then user land on 3d page
    Then android user click on back button from 3d sceure screen
    Then user should navigates to review page

    Examples: 
      | emailAddress   | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit | CVV | paymentreason | 
      | TorFxWalletList3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606   |           8453 | 555 | Emigration    | 

   @PAD-3047_TC48_AndroidTorFx   
  Scenario Outline: 9.1 9.3 9.4 To verify that on click of done button on success page user should land on â€˜Homeâ€™ (Send Money) screen
   Given android user installed the new TorFx app and launched successfully
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
    Then user land on 3d page
    Then android user click on submit from 3dsceure screen
    Then android user land on success page and click on Done button
    And android user should be land on activity screen

    Examples: 
      | emailAddress   | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit | CVV | paymentreason | PaymentReference | 
      | TorFxWalletList3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 |  Jack Smith   | EUR      |  FR1420041010050500013M02606  |         8453   | 555 | Emigration    | Testing on SIT   | 

  @PAD-3049_TC49_AndroidTorFx    
  Scenario Outline: 8.1 To verify that when user selects a payment reason then only continue button should get enabled and clicking on it user should get navigate to Review screen
    Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Bank Transfer
    And android user select payment reason Bank Transfer
    Then continue button should get enabled for bank transfer in android app
    When android user click on continue button for bank transfer
    Then user should navigates to review page

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | paymentreason | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606  | Emigration    | 

  @PAD-3049_TC50_AndroidTorFx    
  Scenario Outline: 7.21 Bank Transfer- To verify that when payment reason is not selected then continue button should be disabled
   Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Bank Transfer
    And android user do not select payment reason Bank Transfer
    Then continue button should get disabled for bank transfer in android app

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith   | EUR       |  FR1420041010050500013M02606 | 

  @PAD-3049_TC51_AndroidTorFx @TorFxregression  
  Scenario Outline: Bank Transfer To verify that clicking on back button of review screen user get navigate back on the payment method screen WITH PREVIOUS PAYMENT METHOD SELECTED
    Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Bank Transfer
    And android user select payment reason Bank Transfer
    Then continue button should get enabled for bank transfer in android app
    When android user click on continue button for bank transfer
    Then user should navigates to review page
    Then android user click on back button from review screen and get navigate back on the payment method screen
    And previously selected payment method Bank Transfer should be displayed in android app on payment method screen

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | paymentreason | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606   | Emigration    | 

  @PAD-3049_TC52_AndroidTorFx  
  Scenario Outline: Bank Transfer To verify Bank journey get successfully done when user click on back and forth page
    Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Bank Transfer
    And android user select payment reason Bank Transfer
    When android user click on continue button for bank transfer
    Then user should navigates to review page
    Then android user click on back button from review screen and get navigate back on the payment method screen
    When android user click on continue button for bank transfer
    And android user click on Confirm and pay button from Review screen
    Then android user land on success page and click on Done button
    And android user should be land on activity screen
    

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 | 

  @PAD-3048_TC53_AndroidTorFx  
  Scenario Outline: Wallet  7.20 To verify that when user selects a payment reason then only continue button should get enabled and clicking on it user should get
   Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Wallet
    And android user select payment reason Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then user should navigates to review page

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 |  

  @PAD-3048_TC54_AndroidTorFx   
  Scenario Outline: 7.21 Wallet To verify that when payment reason is not selected then continue button should be disabled
   Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Wallet
    And android user do not select payment reason Wallet
    Then continue button should get disabled for wallet in android app

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606  |  

 

  @PAD-3048_TC55_AndroidTorFx    
  Scenario Outline: 8.1 To verify that when user enters valid data on wallet payment method screen and click on continue button then user lands on review screen
    Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Wallet
    And android user select payment reason Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then user should navigates to review page

    Examples: 
      | emailAddress       | password          | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 | 

  @PAD-3249_TC56_AndroidTorFx @TorFxSanity @TorFxregression  
  Scenario Outline: 8.7 To verify that NEW 3d card user land on success page post submitting valid data in all field
    Given android user installed the new TorFx app and launched successfully
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
    Then user land on 3d page
    Then android user click on submit from 3dsceure screen
    Then android user land on success page and click on Done button
    And android user should be land on activity screen

    Examples: 
   | emailAddress      | password         | sellCurrency | buyCurrency | amount | recipientName | currency | accountNo  | cardHolderName | cardNumber   | expiryDate(MMYY) | issuedate | cardLast4Digit | CVV |PaymentReference| 
   | TorFxWalletList3d | TorFxRegEmailPass| GBP          | EUR         | 200.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606  | 3d | 6759649826438453 | 12/29  | 09/20     |           8453 | 555 | abv            | 
       
  @PAD-3048_TC57_AndroidTorFx  
  Scenario Outline: 8.1 To verify that when user enters valid data on wallet payment method screen and click on continue button then user lands on review screen
   Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Wallet
    And android user select payment reason Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then user should navigates to review page
    Then android user click on back button from review screen and get navigate back on the payment method screen
    And previously selected payment method Wallet should be displayed in android app on payment method screen

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo                    | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 | 

  @PAD-3048_TC58_AndroidTorFx  
  Scenario Outline: To verify wallet journey get successfully done when user click on back and forth page.
   Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Wallet
    And android user select payment reason Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then user should navigates to review page
    And android user click on Confirm and pay button from Review screen
    Then android user land on success page and click on Done button
    And android user should be land on activity screen

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo                    | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR          | 250.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 |  

  @PAD-3048_TC59_AndroidTorFx    
  Scenario Outline: 8.9  To verify that when the payment is successfully processed then the processing screen should close AND the user navigated to Confirmation screen
    Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Wallet
    And android user select payment reason Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then user should navigates to review page
    And android user click on Confirm and pay button from Review screen
    Then android user land on confirmation screen

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo                    |  
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 250.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 | 

  @PAD-3048_TC60_AndroidTorFx   
  Scenario Outline: 9.3 To verify that when Confirmation screen loads then â€˜Doneâ€™ button should be displayed in active/enabled state
    Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Wallet
    And android user select payment reason Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then user should navigates to review page
    And android user click on Confirm and pay button from Review screen
    Then android user land on confirmation screen
    Then Done button should displayed in enabled state

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo                    | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 | 

  @PAD-3193_TC61_AndroidTorFx   
  Scenario Outline: 9.3 To verify that when Confirmation screen loads then â€˜Doneâ€™ button should be displayed in active/enabled state
    Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Bank Transfer
    And android user select payment reason Bank Transfer
    When android user click on continue button for bank transfer
    Then user should navigates to review page
    Then android user click on back button from review screen and get navigate back on the payment method screen
    When android user click on continue button for bank transfer
    And android user click on Confirm and pay button from Review screen
    Then android user land on confirmation screen
    Then Done button should displayed in enabled state

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo                    | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 250.00         | Jack Smith    | EUR      |  FR1420041010050500013M02606 | 

  @PAD-3193_TC62_AndroidTorFx   
  Scenario Outline: 9.2 To verify that when Confirmation screen loads then user should also have an option to see the bank account details to fund the transaction and should be selected as default
    Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Bank Transfer
    And android user select payment reason Bank Transfer
    When android user click on continue button for bank transfer
    Then user should navigates to review page
    Then android user click on back button from review screen and get navigate back on the payment method screen
    When android user click on continue button for bank transfer
    And android user click on Confirm and pay button from Review screen
    Then android user land on confirmation screen
    Then screen should load with bank account details option selected by default

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo                    | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 300.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 | 

  @PAD-3049_TC63_AndroidTorFx  
  Scenario Outline: 9.2 To verify that when Confirmation screen loads then user should also have an option to see the bank account details to fund the transaction and should be selected as default
    Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Bank Transfer
    And android user select payment reason Bank Transfer
    When android user click on continue button for bank transfer
    Then user should navigates to review page
    Then android user click on back button from review screen and get navigate back on the payment method screen
    When android user click on continue button for bank transfer
    And android user click on Confirm and pay button from Review screen
    Then android user land on confirmation screen
    Then screen should load with bank account details option selected by default

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo                    | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 | 

  @PAD-3124_TC64_AndroidTorFx  
  Scenario Outline: 8.1 To verify that when user selects a payment reason then only continue button should get enabled and clicking on it user should get navigate to Review screen
    Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Bank Transfer
    And android user select payment reason Bank Transfer
    And android user do not enter Payment Reference "<PaymentReference>"
    Then continue button should get enabled for bank transfer in android app
    When android user click on continue button for bank transfer
    Then user should navigates to review page
    Then Payment Reference not displayed on Review screen

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo                    |  
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 250.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 |  

  @PAD-3249_TC65_AndroidTorFx  
  Scenario Outline: To verify android app displayed the error message when wrong CVV number entered for new card
    Given android user installed the new TorFx app and launched successfully
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
    Then card details should be blank to android user
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
      | emailAddress | password          | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo      | cardHolderName  | cardNumber       | expiryDate(MMYY) | issuedate | cardLast4Digit | CVV |PaymentReference| 
      | CVVFailedUser| TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 |REFUSED43 | 6759649826438453 | 12/29            | 09/20     |           8453 | 633 | abcd           | 

  @PAD-3249_TC66_AndroidTorFx   
  Scenario Outline: To verify android app displayed the error message when wrong CVV number entered for existing non 3d card
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter Payment Reference "<PaymentReference>"
    When android user click on continue button for debit card
    And android user click on Confirm and pay button from Review screen
    Then android app dispalyed the error for entered wrong cvv

    Examples: 
       | emailAddress  | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit | CVV | PaymentReference  | 
       | CVVFailedUser | TorFxRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606|           8453 | 633 | Testing wrong CVV | 
 
  @PAD-3249_TC67_AndroidTorFx  
  Scenario Outline: To verify android app displayed the error message when wrong CVV number entered for new Non 3d card
    Given android user installed the new TorFx app and launched successfully
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
    Then card details should be blank to android user
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
      | emailAddress  | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo                  | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate | cardLast4Digit | CVV | PaymentReference  | 
      | CVVFailedUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      | FR1420041010050500013M02606|  REFUSED43 | 6759649826438453 | 12/29            | 09/20     |           8453 | 633 | Testing wrong CVV | 

  @PAD-3046_TC69_AndroidTorFx   
  Scenario Outline: CDLGB To verify when sell currency is GBP/EUR and sell amount less than or equal to available balance then in payment method
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter amount "<amount>" in selling currency
    Then after two sec appropriate amount should be calculated in buy currency in android app
    When android user click on continue
    Then android user should land on select recipient screen
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen
    Then android user observed DebitCard payment method in active state
    Then android user observed BankTransfer payment method in active state
    Then android user observed Wallet payment method in active state

    Examples: 
      | emailAddress    | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo                    | 
      | TorFxSendMoneyUser    | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 | 

  @PAD-3046_TC70_AndroidTorFx   
  Scenario Outline: CDLGB To verify when sell currency is GBP/EUR and sell amount is greater than available balance then wallet payment method present Inactive state
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter amount "<amount>" in buying currency
    Then after two sec appropriate amount should be calculated in sell currency in android app
    When android user click on continue
    Then android user should land on select recipient screen
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen
    Then android user observed DebitCard payment method in active state
    Then android user observed BankTransfer payment method in active state
    Then android user observed Wallet payment method in disabled state

    Examples: 
      | emailAddress  | password       | sellCurrency | buyCurrency | amount   | recipientName | currency | accountNumber                | 
      | TorFxSendMoneyUser  | TorFxRegEmailPass | GBP          | EUR         | 22000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 | 

  @PAD-3046_TC71_AndroidTorFx  
  Scenario Outline: CDLGB To verify when sell currency is other than GBP/EUR and sell amount less than or equal to available balance then Debitcard payment method disabled
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter amount "<amount>" in selling currency
    Then after two sec appropriate amount should be calculated in buy currency in android app
    When android user click on continue
    Then android user should land on select recipient screen
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen
    Then android user observed DebitCard payment method in disabled state
    Then android user observed BankTransfer payment method in active state
    Then android user observed Wallet payment method in active state

    Examples: 
      | emailAddress    | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNumber                | 
      | TorFxSendMoneyUser    | TorFxRegEmailPass | USD          | EUR         | 1386.30 |  Jack Smith   | EUR      |  FR1420041010050500013M02606 | 

  @PAD-3046_TC72_AndroidTorFx 
  Scenario Outline: CDLGB To verify when sell currency is other than GBP/EUR and sell amount greater than or equal to available balance then Debitcard and wallet payment method disabled
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter amount "<amount>" in selling currency
    Then after two sec appropriate amount should be calculated in buy currency in android app
    When android user click on continue
    Then android user should land on select recipient screen
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen
    Then android user observed DebitCard payment method in disabled state
    Then android user observed BankTransfer payment method in active state
    Then android user observed Wallet payment method in disabled state

    Examples: 
      | emailAddress    | password       | sellCurrency | buyCurrency | amount   | recipientName | currency | accountNumber                | 
      | TorFxSendMoneyUser    | TorFxRegEmailPass | CAD          | EUR         | 5000.00  | Jack Smith    | EUR      |  FR1420041010050500013M02606 | 

  #PAD-4407   :bug raised
  @PAD-3920_TC73_AndroidTorFx  
  Scenario Outline: 2.1 Review DebitCard To verify all data mapped on review screen
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter amount "<amount>" in buying currency
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
    And android user enter Payment Reference "<PaymentReference>"
    When android user click on continue button for debit card
    Then user should navigates to review page
    Then android user observe the parameter on Review screen

    Examples: 
      | emailAddress       | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNumber                | cardLast4Digit | CVV | paymentreason |PaymentReference| 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606 |           4444 | 555 | Emigration    |ReferenceTest   | 

  @PAD-3920_TC74_AndroidTorFx  
  Scenario Outline: 8.1 Review Bank Transfer To verify that when user selects a payment reason then only continue button should get enabled and clicking on it user should get navigate to Review screen
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter amount "<amount>" in buying currency
    Then after two sec appropriate amount should be calculated in sell currency in android app
    When android user click on continue
    Then android user should land on select recipient screen
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen
    Then android user select the payment method Bank Transfer
    And android user select payment reason Bank Transfer
    And android user enter Payment Reference "<PaymentReference>"
    Then continue button should get enabled for bank transfer in android app
    When android user click on continue button for bank transfer
    Then android user observe the parameter on Review screen

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNumber                    | paymentreason | PaymentReference | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |      FR1420041010050500013M02606 | Emigration    | Test             | 

  @PAD-3920_TC75_AndroidTorFx  
  Scenario Outline: 8.2 Review Wallet To verify that when user selects a payment reason then only continue button should get enabled and clicking on it user should get navigate to Review screen
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter amount "<amount>" in buying currency
    Then after two sec appropriate amount should be calculated in sell currency in android app
    When android user click on continue
    Then android user should land on select recipient screen
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen
    Then android user select the payment method Wallet
    And android user select payment reason Wallet
    And android user enter Payment Reference "<PaymentReference>"
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then android user observe the parameter on Review screen

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount | recipientName | currency | accountNumber               | paymentreason | PaymentReference | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith    | EUR      | FR1420041010050500013M02606 | Emigration    | Test             | 

  @PAD-3920_TC76_AndroidTorFx @TorFxregression   
  Scenario Outline: 8.2.2 Review Bank Transfer To verify that payment reference if not selected it should not be displayed on review and confirmation/success page.
    Given android user installed the new TorFx app and launched successfully
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
    Then android user select the payment method Bank Transfer
    And android user select payment reason Bank Transfer
    And android user do not enter Payment Reference "<PaymentReference>"
    Then continue button should get enabled for bank transfer in android app
    When android user click on continue button for bank transfer
    Then user should navigates to review page
    Then Payment Reference not displayed on Review screen
    And android user click on Confirm and pay button from Review screen
    Then android user land on confirmation screen
    Then android user click on payment details tab
    Then Payment Reference not displayed on confirmation screen

    Examples: 
      | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName| currency | accountNo                    | paymentreason | 
      | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 250.00 | Jack Smith   | USD      |  FR1420041010050500013M02606 | Emigration    | 

  @PAD-3920_TC77_AndroidTorFx @TorFxSanity @TorFxregression  
  Scenario Outline: 8.10 Confirmation screen Bank Transfer To verify that when the user is on Confirmation screen then the payment execution date, payee and payment details
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter amount "<amount>" in buying currency
    Then after two sec appropriate amount should be calculated in sell currency in android app
    When android user click on continue
    Then android user should land on select recipient screen
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen
    Then android user select the payment method Bank Transfer
    And android user select payment reason Bank Transfer
    And android user enter Payment Reference "<PaymentReference>"
    Then continue button should get enabled for bank transfer in android app
    When android user click on continue button for bank transfer
    Then android user observe the parameter on Review screen
    Then android user click on Confirm and Pay button
    Then deal confirmation screen should be displayed with correct mapped details in android app

    Examples: 
      | emailAddress      | password          | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNumber               | paymentreason | PaymentReference | 
      | TorFxWalletList3d | TorFxRegEmailPass | USD          | EUR         | 900.00 | Jack Smith    | EUR      | FR1420041010050500013M02606 | Emigration    | Test             | 

  @PAD-3920_TC78_AndroidTorFx @TorFxSanity   @TorFxregression  
  Scenario Outline: 8.11 Success screen Wallet To verify that on Confirmation screen,payment booking, value date, payee and payment details
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter amount "<amount>" in buying currency
    Then after two sec appropriate amount should be calculated in sell currency in android app
    When android user click on continue
    Then android user should land on select recipient screen
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen
    Then android user select the payment method Wallet
    And android user select payment reason Wallet
    And android user enter Payment Reference "<PaymentReference>"
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then android user observe the parameter on Review screen
    Then android user click on Confirm and Pay button
    Then android user land on success page and click on Done button

    Examples: 
      | emailAddress      | password         | sellCurrency | buyCurrency | amount  | recipientName| currency | accountNumber               | paymentreason | PaymentReference | 
      |TorFxSendMoneyUser | TorFxRegEmailPass| GBP          | EUR         | 200.00  | Jack Smith   | EUR      | FR1420041010050500013M02606 | Emigration    | Test             | 

  @PAD-3920_TC79_AndroidTorFx @smokeTest @FraudSight  
  Scenario Outline: 8.11 Success Card To verify that on Confirmation screen,payment booking, value date, payee and payment details
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter amount "<amount>" in buying currency
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
    And android user enter Payment Reference "<PaymentReference>"
    When android user click on continue button for debit card
    And android user click on Confirm and pay button from Review screen
    Then android user land on success page and click on Done button

    Examples: 
        | emailAddress | password       | sellCurrency | buyCurrency | amount  | recipientName| currency | accountNumber | cardLast4Digit | CVV | paymentreason |PaymentReference| 
        | TorFxSendMoneyUser | TorFxRegEmailPass | GBP          | EUR         | 200.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606|           8453 | 555 | Emigration    |ReferenceTest| 
   
    @PAD-3047_TC80_AndroidTorFx  
     Scenario Outline: 8.11 To verify that when user click on back option from 3d page then payment cancel? pop up observed
    Given android user installed the new TorFx app and launched successfully
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
    Then user land on 3d page
    When android user presses device back button
    Then cancel payment confirmation popup displayed on android device  

    Examples: 
      | emailAddress      | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit | CVV | paymentreason | 
      | TorFxWalletList3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606   |           8453 | 555 | Emigration    | 
   
    @PAD-3047_TC81_AndroidTorFx  
    Scenario Outline: To verify that when user click on dont cancel option from 3d page then user remain on 3d page
    Given android user installed the new TorFx app and launched successfully
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
    Then user land on 3d page
    When android user presses device back button
    Then cancel payment confirmation popup displayed on android device 
    When androd user clicks on dont cancel link
    Then user land on 3d page

    Examples: 
      | emailAddress      | password       | sellCurrency | buyCurrency | amount  | recipientName | currency | accountNo | cardLast4Digit | CVV | paymentreason | 
      | TorFxWalletList3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith   | EUR      |  FR1420041010050500013M02606   |           8453 | 555 | Emigration    | 
   
    @PAD-3047_TC88_AndroidTorFx   
    Scenario Outline: To verify that when user click on yes cancel from 3d page then payment should be cancelled 
   Given android user installed the new TorFx app and launched successfully
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
    Then user land on 3d page
    When android user presses device back button
    Then cancel payment confirmation popup displayed on android device 
    When androd user clicks on yes cancel link
    Then android app dispalyed payment cancelled scrren

    Examples: 
      | TorFxWalletList3d | TorFxRegEmailPass | GBP          | EUR         | 2000.00 | Jack Smith    | EUR      |  FR1420041010050500013M02606   |           8453 | 555 | Emigration    | 
   