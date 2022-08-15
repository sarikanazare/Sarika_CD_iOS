@CD_SendMoney
Feature: Dashboard send money functionality :

  @CD_PID-3790_TC01 @CD_SendMoneyLot1
  Scenario Outline: 1.1 To verify the Send functionality from the tab bar menu
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should be land on Money Transfer feature screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_PID-3791_TC02 @CD_SendMoneyLot1
  Scenario Outline: 2.1 2.2 Selling currency : To verify that amount get calculated in sell currency when user entered amount in they get field
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user enters they get amount "<amount>"
    Then after two sec appropriate amount should be calculated in you pay ios app field

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | amount |
      | CDRegEmailId28 | CDRegEmailPass1 | 200.00 |

  @CD_PID-3791_TC03 @CD_iOS_regression @CD_SendMoneyLot1
  Scenario Outline: 2.3 Selling currency : To verify that when amount entered in selling currency is less than allowed limit (100 GBP) error message to be displayed
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user enters you pay amount "<amount>" for limit error
    Then minimum allowed amount limit error message should be displayed to ios user

    #When ios user removes account by using manage device option from send money screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | amount |
      | CDRegEmailId28 | CDRegEmailPass1 |  24.00 |

  #| CDRegEmailId | CDRegEmailPass |   1.00 |
  @CD_PID-3791_TC04 @CD_iOS_regression @CD_SendMoneyLot1
  Scenario Outline: 2.4 Selling currency :  To verify that when amount entered in selling currency is greater than allowed GBP limit (25000 GBP)  error message to be displayed :
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user enters you pay amount "<amount>" for limit error
    Then maximum allowed amount limit error message should be displayed to ios user

    #When ios user removes account by using manage device option from send money screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | amount    |
      | CDRegEmailId28 | CDRegEmailPass1 | 26,000.01 |

  @CD_PID-3791_TC05 @CD_SendMoneyLot1
  Scenario Outline: 2.1 2.2 2.6 2.5 2.9 buying currency : To verify that amount get calculated in buying currency when user entered amount in you pay field
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | amount |
      | CDRegEmailId28 | CDRegEmailPass1 | 200.00 |

  @CD_PID-3791_TC06 @CD_SendMoneyLot1
  Scenario Outline: 2.7 Buying currency : To verify that when amount entered in buying currency such that calculated amount in selling currency is less than 100 GBP error message to be displayed :
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user enters they get amount "<amount>"
    Then minimum allowed amount limit error message should be displayed to ios user
    #When ios user click on the ok button
    Then you pay and they get amount should be set to zero

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | amount |
      | CDRegEmailId28 | CDRegEmailPass1 |  99.00 |

  @CD_PID-3791_TC07 @CD_SendMoneyLot1
  Scenario Outline: 2.8 Buying currency : To verify that when amount entered in buying currency such that calculated amount in selling currency is greater than allowed GBP (25000 GBP) error message to be displayed :
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user enters they get amount "<amount>"
    Then maximum allowed amount limit error message should be displayed to ios user
    #When ios user click on the ok button
    Then you pay and they get amount should be set to zero

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | amount |
      | CDRegEmailId28 | CDRegEmailPass1 | 30,000 |

  @CD_PID-3791_TC08 @CD_SendMoneyLot1
  Scenario Outline: 2.11 2.13 : To Verify after 60 sec rate gets refreshed and they get amount gets updated as amount is entered in selling currency.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    And an auto timer of sixty seconds should start and rate should be refreshed and they get amount should be updated in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | amount |
      | CDRegEmailId28 | CDRegEmailPass1 | 200.00 |

  @CD_PID-3791_TC09 @CD_SendMoneyLot1
  Scenario Outline: 2.11 2.14 To Verify after 60 sec rate gets refreshed  and you pay amount gets updated as amount is entered in buying currency.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user enters they get amount "<amount>"
    Then after two sec appropriate amount should be calculated in you pay ios app field

    #And an auto timer of sixty seconds should start and rate should be refreshed and you pay amount should be updated in ios app
    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | amount | seconds |
      | CDRegEmailId28 | CDRegEmailPass1 | 200.00 |      60 |

  @CD_PID-3791_TC10 @CD_iOS_regression @CD_SendMoneyLot1
  Scenario Outline: 2.12 To verify Fx deal rates are fetched again and the timer gets resets after every 60 second when user enters amount in you pay field
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    And an auto timer of sixty seconds should start and rate should be refreshed and they get amount should be updated in ios app
    And an auto timer of sixty seconds should start and rate should be refreshed and they get amount should be updated in ios app

    #When ios user removes account by using manage device option from send money screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | amount |
      | CDRegEmailId28 | CDRegEmailPass1 | 200.00 |

  @CD_PID-3791_TC11 @CD_iOS_regression @CD_SendMoneyLot1
  Scenario Outline: 2.12 To verify Fx deal rates are fetched again and the timer gets resets after every 60 second when user enters amount in they get
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user enters they get amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    And an auto timer of sixty seconds should start and rate should be refreshed and you pay amount should be updated in ios app

    #And an auto timer of sixty seconds should start and rate should be refreshed and you pay amount should be updated in ios app
    #When ios user removes account by using manage device option from send money screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | amount |
      | CDRegEmailId28 | CDRegEmailPass1 | 200.00 |

  @CD_PID-3792_TC12 @CD_SendMoneyLot1
  Scenario Outline: They get currency drop down: To verify on click of back arrow on drop down page user should be lands on send money page.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user clicks on back arrow
    Then ios user should land on send money dashboard page

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | theyGetCurrency |
      | CDRegEmailId28 | CDRegEmailPass1 | CAD             |

  @CD_PID-3792_TC13 @CD_SendMoneyLot1
  Scenario Outline: You pay currency drop down: To verify on click of back arrow on drop down page user should be lands on send money page.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user clicks on back arrow
    Then ios user should land on send money dashboard page

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency |
      | CDRegEmailId28 | CDRegEmailPass1 | AUD            |

  @CD_PID-3792_TC14 @CD_iOS_regression @CD_SendMoneyLot1
  Scenario Outline: 3.2, 3.3 You pay drop down : To verify the that user should be able to search currency.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then matching currency should be displayed in search result of ios app

    #When ios user removes account by using manage device option from send money screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            |

  @CD_PID-3792_TC15 @CD_SendMoneyLot1
  Scenario Outline: 3.2, 3.3 They get drop down : To verify the that user should be able to search currency.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    Then matching currency should be displayed in search result of ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | theyGetCurrency |
      | CDRegEmailId28 | CDRegEmailPass1 | USD             |

  #| CDRegEmailId | CDRegEmailPass | US Dollar       |
  @CD_PID-3792_TC16 @CD_SendMoneyLot2
  Scenario Outline: 3.2, 3.3 You pay currency drop down : To verify enter serach data gets cleared when user selects (x) option
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    When ios user click on (X) option
    Then the filter should be cleared and the whole currency list should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             |

  @CD_PID-3792_TC17 @CD_SendMoneyLot2
  Scenario Outline: 3.2, 3.3 They get currency drop down : To verify enter serach data gets cleared when user selects (x) option
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user click on (X) option
    Then the filter should be cleared and the whole currency list should be displayed on ios screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | ZAR             |

  @CD_PID-3792_TC18 @CD_SendMoneyLot2
  Scenario Outline: 3.5  You pay currency drop down: To verify that after selecting currency, app should take the
              user to the home screen with the selected currency in selling currency.

    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<youPayCurrency>"
    Then selected currency "<youPayCurrency>" should be displayed in you pay currency dropdown

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             |

  @CD_PID-3792_TC19 @CD_SendMoneyLot2
  Scenario Outline: 3.5  They get currency drop down: To verify that after selecting currency, app should take the user to the home screen with the selected currency in buying currency.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<theyGetCurrency>"
    Then selected currency "<theyGetCurrency>" should be displayed in they get currency dropdown

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             |

  @CD_PID-3792_TC20 @CD_iOS_regression @CD_SendMoneyLot2
  Scenario Outline: 3.8  To verify when user selects invalid currency pair then rate should not be fetch and error message to be displayed
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<youPayCurrency>"
    Then selected currency "<youPayCurrency>" should be displayed in you pay currency dropdown
    When ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<theyGetCurrency>"
    Then error message should be displayed for unsupported currency pair in ios app

    #When ios user removes account by using manage device option from send money screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency |
      | CDRegEmailId28 | CDRegEmailPass1 | DKK            | CZK             |

  @CD_PID-3793_TC21 @CD_iOS_regression @CD_SendMoneyLot2
  Scenario Outline: 4.1 4.2 To verify when user selects swap option only currency should get swap and default selling amount should remain as is.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<theyGetCurrency>"
    When ios user click on swap
    Then you pay and they get currency "<youPayCurrency>" "<theyGetCurrency>" should be swap in ios app
    And you pay amount "<amount>" should remain as is in ios app

    #When ios user removes account by using manage device option from send money screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount   |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | EUR             | 1,000.00 |

  @CD_PID-3793_TC22 @CD_SendMoneyLot2
  Scenario Outline: 4.1 4.2 To verify when user selects  swap option only currency should get swap and default you pay amount should remain as is.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on swap
    Then you pay and they get currency "<youPayCurrency>" "<theyGetCurrency>" should be swap in ios app
    And you pay amount "<amount>" should remain as is in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | EUR             | 400.00 |

  @CD_PID-3793_TC23 @CD_SendMoneyLot2
  Scenario Outline: 4.1, 4.2  To verify when user selects swap option only currency should get swap and entered buying amount should remain as is.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters they get amount "<amount>"
    Then after two sec appropriate amount should be calculated in you pay ios app field
    When ios user click on swap
    Then you pay and they get currency "<youPayCurrency>" "<theyGetCurrency>" should be swap in ios app
    And they get amount "<amount>" should remain as is in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | EUR             | 200.00 |

  @CD_PID-3795_TC24 @CD_SendMoneyLot2
  Scenario Outline: 6.2 To verify that user lands on select recipient screen when user clicks on the continue button available on send money screen
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user close the select recipient screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | EUR             | 200.00 |

  @CD_PID-3795_TC25 @CD_SendMoneyLot2
  Scenario Outline: 6.2 6.3 To verify on click of back arrow on select recipient page user should be lands on send money page and default currency pair and amount should be displayed in selling currency
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user close the select recipient screen
    Then ios user should land on send money dashboard page
    And default currency pair "<defaultCurrencyPair>" and amount "<defaultYouPayAmt>"should be displayed in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount   | defaultCurrencyPair | defaultYouPayAmt |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 1,000.00 | GBP-USD             |         1,000.00 |

  @CD_PID-3795_TC26 @CD_SendMoneyLot2
  Scenario Outline: 6.4 To check that only those recipients are shown in the list, who can receive the buying currency, as selected by the user in the send money screen step1.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    And only you pay currency "<theyGetCurrency>" recipients list should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount  |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | GBP             | 2000.00 |

  @CD_PID-3795_TC27 @CD_iOS_regression @CD_SendMoneyLot2
  Scenario Outline: 6.4 To verify that empty recipients screen gets displayed when selected buy currency recipient are not present in recipient list.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    And empty recipient screen with an option to add a new recipient should be displayed in ios app

    #When ios user removes account by using manage device option from recipients screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount  |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | ZAR             | 2000.00 |

  @CD_PID-3793_TC28 @CD_SendMoneyLot2
  Scenario Outline: 6.5 6.6 To verify that application allow user to initiate add recipient process during send money journey currency field should be set to the Buy Currency of the Send Money and it should not be editable.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<youPayCurrency>"
    When ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    And ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects an option to add a new recipient during send money journey
    Then add recipient screen should be displayed to ios user
    When ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    Then non editable recipient currency should be auto set as they get currency "<theyGetCurrency>" in ios app

    # When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount  | country |
      | CDRegEmailID35 | CDRegEmailPass1 | GBP            | EUR             | 2000.00 | France  |

  #| CDRegEmailId | CDRegEmailPass | GBP            | USD             |  236.22 | USA     |
  # | CDRegEmailId | CDRegEmailPass | EUR            | GBP             |  399.98 | UK      |
  #| CDRegEmailId | CDRegEmailPass | GBP            | CAD             |  455.59 | CANADA  |
  #| CDRegEmailId | CDRegEmailPass | GBP            | NZD             |  455.59 | UK      |
  #| CDRegEmailId | CDRegEmailPass | GBP            | AUD             |  455.59 | UK      |
  #| CDRegEmailId | CDRegEmailPass | EUR            | HKD             |  455.59 | UK      |
  # | CDRegEmailID35 | CDRegEmailPass1 | GBP            | ZAR             |  455.59 | UK      |
  @CD_PID-3793_TC29 @CD_iOS_regression @CD_SendMoneyLot2 @CD_iOS_2FA
  Scenario Outline: 6.7 7.1 To verify that user lands on payment method page once user completes the add recipient process during the send money journey
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    And ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects an option to add a new recipient during send money journey
    And ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    And non editable recipient currency should be auto set as they get currency "<theyGetCurrency>" in ios app
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNo>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should navigate to payment method screen

    #When ios user removes account by using manage device option from payment method screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName        | country                  | currency | address | accountNo | bankCodeType | bankCode  |
      | CDRegEmailID35 | CDRegEmailPass1 | GBP            | USD             | 200.00 | Individual    | harsheyss7 peteross5 | United States Of America | USD      | USAAdd  |  12345675 | ABA          | 083900363 |

  @CD_PID-3793_TC30 @CD_SendMoneyLot2
  Scenario Outline: 6.8 To verify that user lands on payment method page once user selects the recipient from the available recipient list during the send money journey
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 |

  @CD_PID-3796_TC31 @CD_SendMoneyLot3
  Scenario Outline: 7.2 7.3  To verify that when user selects back button on the payment method page then user should land
    on recipient list screen with selected recipient state and only those recipients should be displayed,
    who can receive the buying currency, as selected by the user in the send money screen step1.

    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user clicks on back button
    Then ios user should land on select recipient screen
    And only you pay currency "<theyGetCurrency>" recipients list should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 |

  @CD_PID-3796_TC32 @CD_SendMoneyLot3
  Scenario Outline: 7.8 To verify that user navigates to add card page when user clicks on add card option from the empty
    card payment method screen.

    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    #When ios user select debit card as payment method
    And ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 |

  @CD_PID-3797_TC33 @CD_SendMoneyLot3
  Scenario Outline: 7.9  To verify list of saved cards number is masked except last four digits in accordance with PCI-DSS requirements
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    #Then ios user should navigate to payment method screen
    When ios user select debit card as payment method
    When ios user has one or more saved cards on payment method screen
    Then saved cards number in the list should be masked except last four digits in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 |

  @CD_PID-3797_TC34 @CD_SendMoneyLot3
  Scenario Outline: 7.11 To verify that user can add new card successfully and user should land card list page where recently added card displayed during send money journey.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
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
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 |

  @CD_PID-3797_TC35 @CD_iOS_regression @CD_SendMoneyLot3
  Scenario Outline: To verify that in send money flow while adding new card when last name does not match with the account holders last name the system should give proper error message
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides invalid unmatched contacts last name "<cardHolderName>"
    Then invalid last name error message should be displayed to ios user

    #When ios user removes account by using manage device option from add debit card screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName  | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | Andrew Peterson | 6759649826438453 |            1120 |             1125 |

  @CD_PID-3797_TC36 @CD_SendMoneyLot3
  Scenario Outline: To verify that in send money flow while adding new card when expiry date is less than current date than system should give proper error message
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides invalid expiry date "<expiryDate(MMYY)>"
    Then invalid expiry date error message should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName  | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | Andrew Peterson | 6759649826438453 |            1120 |             1120 |

  @CD_PID-3797_TC37 @CD_SendMoneyLot3
  Scenario Outline: To verify that in send money flow while adding new card when issue date is greater than current date then system should give proper error message
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides invalid issue date "<issueDate(MMYY)>"
    Then invalid issue date error message should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName  | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | Andrew Peterson | 6759649826438453 |            1125 |             1120 |

  @CD_PID-3797_TC38 @CD_SendMoneyLot3
  Scenario Outline: To verify that when user selects any card from available list then CVV field gets displayed to user with the message
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    #And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    Then cvv input field should be displayed with message in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 |

  @CD_PID-3797_TC39 @CD_iOS_regression @CD_SendMoneyLot3
  Scenario Outline: 7.13 To verify that when user selects any card from available list then enter 2digit CVV field then continue button gets disabled
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    Then continue button should be in disabled state in ios app

    #When ios user removes account by using manage device option from payment method screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 |  12 |

  @CD_PID-3797_TC40 @CD_SendMoneyLot3
  Scenario Outline: 7.13 To verify that when user selects any card from available list then enter correct  CVV field then continue button gets enabled
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    Then cvv input field should be displayed with message in ios app
    When ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    Then continue button should be in enabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference |

  @CD_PID-3797_TC41 @CD_iOS_regression @CD_SendMoneyLot3
  Scenario Outline: 7.15 To verify continue button gets disabled when user enter cvv and do not provide payment reason
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user enters payment reference "<reference>"
    Then continue button should be in disabled state in ios app

    #When ios user removes account by using manage device option from payment method screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference |

  @CD_PID-3797_TC42 @CD_SendMoneyLot3
  Scenario Outline: 7.16, 7.17 To verify that user lands on review page when user enters the valid CVV and clicks on confirm and pay
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference |

  @CD_PID-3939_TC43 @CD_SendMoneyLot3
  Scenario Outline: 2.11 To verify that clicking on back button of review screen user get navigate back on the payment method screen with previous payment method selected
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    When ios user clicks on back button
    Then ios user should navigate to payment method screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference |

  @CD_PID-3939_TC44 @CD_SendMoneyLot3
  Scenario Outline: 8.2,8.2.1 To verify proper data get mapped on review page for payee , payment details and payment reason, payment reference
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference |

  @CD_PID-3939_TC45 @CD_iOS_regression @CD_SendMoneyLot3
  Scenario Outline: To verify that 'Payment reference' if not selected it should not be displayed on review and confirmation success page.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen

    #When ios user removes account by using manage device option from add debit card screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 5555555555554444 |            1120 |             1125 | 555 | Bill payments | Test-Reference |

  #| CDRegEmailId25 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 5555555555554444 |            1120 |             1125 | 555 | Bill payments | Test-Reference |
  @CD_PID-3939_TC46 @CD_SendMoneyLot4
  Scenario Outline: 8.6.1 To verify when CDLGB user selects the T's & C's link,window should open with a link to the respective UK T's & C'
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user click on terms and condition link
    Then terms and condition page should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | samy jee       | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | SIT         |

  @CD_PID-3939_TC47
  Scenario Outline: 8.6.3 To verify that user lands on review page on click of back button or the device back button on UK T's & C window
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user click on terms and condition link
    Then terms and condition page should be displayed to ios user
    When ios user clicks on back button
    Then ios user should navigate to review screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress  | password       | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName  | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId3 | CDRegEmailPass | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | George Browning | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | SIT         |

  @CD_PID-3797_TC48 @CD_SendMoneyLot4
  Scenario Outline: 8.7 To verify that in send money flow user is able to perform journey by using Non-3d NEW card user land and on success page with all mapped data.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    #When ios user select debit card as payment method
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  #| CDRegEmailID34 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | Smith          | 5454545454545454 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
  @CD_PID-3939_TC49
  Scenario Outline: To verify android app displayed the error message when wrong CVV number entered for existing non 3d card
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    Then please enter valid cvv error message should be displayed in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 5454545454545454 |            1120 |             1125 |  55 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3939_TC50
  Scenario Outline: To verify android app displayed the error message when wrong CVV number entered for new Non 3d card
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then wrong cvv entered error message should be displayed in ios app
    When ios user click on the ok button
    Then ios user should land on send money dashboard page

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 5454545454545454 |            1120 |             1125 | 999 | Bill payments | Test-Reference | SIT         |

  @CD_PID-3939_TC51 @CD_FraudSight_SendMoney_Cycle3 @CD_SendMoneyLot4
  Scenario Outline: 8.10 To verify that new 3d card user land on “3d page” post submitting the review page
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    #Then ios user should land on 3d page
    #When ios user submits the valid reason "<3dPageReason>" from the dropdown
    Then ios user should land on threed card page
    When ios user submits threed card response
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |  |
      | CDRegEmailId30 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |  |

  #| CDMagicSIT   | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001091 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         | 1234 |
  #| CDRegEmailId32 | CDRegEmailPass4  | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
  @CD_PID-3939_TC521 @CD_iOS_sanity @CD_SendMoneyLot4
  Scenario Outline: 8.13 To verify that in send money flow user is able to perform journey by using existing 3d card user land and on success page and data get mapped.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    # And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then ios user should land on threed card page
    When ios user submits threed card response
    Then deal confirmation screen should be displayed with correct mapped details in ios app
    When ios user click on the done button
    Then activity screen should be displayed with recent transaction history in ios app

    #When ios user removes account by using manage device option from activity screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      #| CDRegEmailId30 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Adams Watsons | Albania | GBP      | USAAdd  |  12345678 | ABA          | 083900363 | 3d             | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      #| CDRegEmailId32 | CDRegEmailPass4  | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      | CDRegEmailId25 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 5555555555554444 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3939_TC53 @CD_SendMoneyLot4
  Scenario Outline: To verify 3d card journey get successfully done when user click on back and forth page on 3d page.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then ios user should land on threed card page
    When ios user clicks on back button
    Then ios user should navigate to review screen
    When ios user submits the review page details
    Then ios user should land on threed card page
    When ios user submits threed card response
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    #Examples:
    # | emailAddress     | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
    #| CDRegEmailId30 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | SIT         |
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId30 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  #| CDRegEmailId32 | CDRegEmailPass4 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
  @CD_PID-3939_TC54
  Scenario Outline: To verify payment journey flow for New 3d card with wrong cvv.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then ios user should land on threed card page
    Then ios user should land on threed card page
    When ios user submits threed card response
    Then wrong cvv error message should be displayed in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId30 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 4462030000000000 |            1120 |             1125 | 444 | Bill payments | Test-Reference | SIT         |

  @CD_PID-3939_TC55 @CD_SendMoneyLot4
  Scenario Outline: 9.1,9.3,9.4 To verify that on click of done button on success page user should land on ‘Home’ (Send Money) screen
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then ios user should land on threed card page
    Then ios user should land on threed card page
    When ios user submits threed card response
    #Then wrong cvv error message should be displayed in ios app
    When ios user click on the done button
    #Then ios user should land on send money dashboard page
    #as per new implementation it should be redirect on activity screen
    Then activity screen should be displayed with recent transaction history in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password       | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId25 | CDRegEmailPass | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 5555555555554444 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  #| CDRegEmailId30 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
  @CD_PID-3939_TC5200 @CD_SendMoneyLot4
  Scenario Outline: 8.7 To verify that in send money flow user is able to perform journey by using 3d NEW card user land and on success page data get mapped.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects to add a new card to make a transfer
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to payment method screen
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then ios user should land on threed card page
    When ios user submits threed card response
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      # | 3dCDRegEmailID19 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | SIT         |
      | CDRegEmailId30 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3798_TC01 @CD_SendMoneyLot4
  Scenario Outline: 8.1 To verify that when user selects a payment reason then continue button should get enabled and clicking on it user should get navigate to review screen
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user select bank transfer as payment method
    And ios user selects payement reason "<paymentReason>"
    Then continue button should be in enabled state in ios app
    When ios user click on continue button
    Then ios user should navigate to review screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3798_TC02 @CD_SendMoneyLot4
  Scenario Outline: 7.21 Bank Transfer- To verify that when payment reason is not selected then continue button should be disabled
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user select bank transfer as payment method
    And ios user enters payment reference "<reference>"
    Then continue button should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3798_TC03 @CD_SendMoneyLot4
  Scenario Outline: Bank Transfer- To verify that clicking on back button of review screen user get navigate back on the payment method screen WITH PREVIOUS PAYMENT METHOD SELECTED
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user select bank transfer as payment method
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    When ios user clicks on back button
    Then ios user should navigate to payment method screen
    And previously selected payment method should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3798_TC04 @CD_iOS_sanity @CD_SendMoneyLot5
  Scenario Outline: Bank Transfer-To verify Bank journey get successfully done when user click on back and forth page
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user select bank transfer as payment method
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    #Then continue button should be in enabled state in ios app
    #When ios user click on continue button
    When ios user click on continue button on bank transfer
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user clicks on back button
    And previously selected payment method should be displayed to ios user
    When ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then deal confirmation screen should be displayed with correct mapped details in ios app
    When ios user click on the done button
    #Then ios user should land on send money dashboard page
    #as per new implementation it should be redirect on activity screen
    Then activity screen should be displayed with recent transaction history in ios app

    #When ios user removes account by using manage device option from activity screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  #| CDRegEmailId25 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 5555555555554444 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
  @CD_PID-3798_TC05 @CD_SendMoneyLot5
  Scenario Outline: 8.2.2 Bank Transfer-To verify that payment reference if not selected it should not be displayed on review and confirmation or success page.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user select bank transfer as payment method
    And ios user selects payement reason "<paymentReason>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then deal confirmation screen should be displayed with correct mapped details in ios app
    When ios user click on the done button
    #Then ios user should land on send money dashboard page
    Then activity screen should be displayed with recent transaction history in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3798_TC06
  Scenario Outline: 8.6.1 To verify when CDLGB user selects the T's & C's link,window should open with a link to the respective UK T's & C'
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user select bank transfer as payment method
    And ios user selects payement reason "<paymentReason>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user click on terms and condition link
    Then terms and condition page should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3798_TC07
  Scenario Outline: 8.6.3 To verify that user lands on review page on click of back button or the device back button on UK Ts & C window
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user select bank transfer as payment method
    And ios user selects payement reason "<paymentReason>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user click on terms and condition link
    Then terms and condition page should be displayed to ios user
    When ios user clicks on back button
    Then ios user should navigate to review screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress  | password       | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName  | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId3 | CDRegEmailPass | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | George Browning | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | SIT         |

  @CD_PID-3941_TC08 @CD_SendMoneyLot5
  Scenario Outline: 9.2 To verify that when Confirmation screen loads then user should also have an option to see the bank account details to fund the transaction and should be selected as default
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user select bank transfer as payment method
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    Then continue button should be in enabled state in ios app
    When ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then by default bank account details section should be displayed on confirmation screen
    And deal confirmation screen should be displayed with correct mapped details in ios app
    When ios user click on the done button

    #Then activity screen should be displayed with recent transaction history in ios app
    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3942_TC01 @CD_SendMoneyLot5 @CD_iOS_2FA
  Scenario Outline: 9.1 ,8.10 To verify that data get mapped properly on confirmation page for wallet payment method.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects an option to add a new recipient during send money journey
    And ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    And non editable recipient currency should be auto set as they get currency "<theyGetCurrency>" in ios app
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNo>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should navigate to payment method screen
    When ios user select wallet as payment method
    Then you pay currency "<youPayCurrency>" wallet should be displayed with balance in ios app
    When ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    #And ios user click on the continue button available on wallet method screen
    When ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then deal confirmation screen should be displayed with correct mapped details in ios app
    When ios user click on the done button
    Then activity screen should be displayed with recent transaction history in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName  | country                  | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName  | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      #| CDRegEmailID35 | CDRegEmailPass1 | EUR            | USD             | 150.00 | Individual    | carry Peterson | United States Of America | USD      | USAAdd  |  12345675 | ABA          | 083900363 | George Browning | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 150.00 | Individual    | carry Peterson | United States Of America | USD      | USAAdd  |  12345675 | ABA          | 083900363 | George Browning | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3942_TC02 @CD_SendMoneyLot5 @CD_iOS_2FA
  Scenario Outline: To verify that when user makes the first payment he should only get the payment method ‘Bank Transfer  and other payment method should be disabled
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects an option to add a new recipient during send money journey
    And ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    And non editable recipient currency should be auto set as they get currency "<theyGetCurrency>" in ios app
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNo>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should navigate to payment method screen
    When ios user select wallet as payment method
    Then ios user should navigate to payment method screen
    And bank transfer payment method should be in active state
    And debit card payment method should be in inactive state
    And wallet payment method should be in inactive state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName  | country                  | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName  | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailID35 | CDRegEmailPass1 | EUR            | USD             | 150.00 | Individual    | denny Peterson | United States Of America | USD      | USAAdd  |  12345675 | ABA          | 083900363 | George Browning | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3942_TC03 @CD_SendMoneyLot5
  Scenario Outline: To verify that when user makes the first payment he should get the all the payment method
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    And debit card payment method should be in active state
    And wallet payment method should be in active state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3942_TC04 @CD_SendMoneyLot5 @CD_iOS_2FA
  Scenario Outline: 8.1 To verify that when user enters valid data on wallet payment method screen and click on continue button then user lands on review screen
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects an option to add a new recipient during send money journey
    And ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    And non editable recipient currency should be auto set as they get currency "<theyGetCurrency>" in ios app
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNo>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should navigate to payment method screen
    When ios user select wallet as payment method
    Then you pay currency "<youPayCurrency>" wallet should be displayed with balance in ios app
    When ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    #And ios user click on the continue button available on wallet method screen
    When ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName  | country                  | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName  | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 150.00 | Individual    | zenny Peterson | United States Of America | USD      | USAAdd  |  12345675 | ABA          | 083900363 | George Browning | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3942_TC05 @CD_SendMoneyLot5
  Scenario Outline: To verify that clicking on back button of review screen user get navigate back on the payment method screen with previous payment method selected
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    #Then ios user should land on select recipient screen
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user select wallet as payment method
    Then you pay currency "<youPayCurrency>" wallet should be displayed with balance in ios app
    When ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    #And ios user click on the continue button available on wallet method screen
    When ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user clicks on back button
    Then ios user should navigate to payment method screen
    And previously selected payment method should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country                  | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3942_TC06 @CD_iOS_sanity @CD_SendMoneyLot5
  Scenario Outline: To verify wallet journey get successfully done when user click on back and forth page.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user select wallet as payment method
    Then you pay currency "<youPayCurrency>" wallet should be displayed with balance in ios app
    When ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    When ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user clicks on back button
    Then ios user should navigate to payment method screen
    And previously selected payment method should be displayed to ios user
    When ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then deal confirmation screen should be displayed with correct mapped details in ios app
    When ios user click on the done button
    #Then ios user should land on send money dashboard page
    Then activity screen should be displayed with recent transaction history in ios app

    #When ios user removes account by using manage device option from activity screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  #| CDRegEmailId25 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 5555555555554444 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
  @CD_PID-3942_TC07 @CD_SendMoneyLot5 @CD_iOS_2FA
  Scenario Outline: CDLGB: To verify when sell currency is other than GBP or EUR and sell amount is greater than  available balance then only Bank Transfer payment method should be enabled
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects an option to add a new recipient during send money journey
    And ios user selects recipient type "<recipientType>" and enters recipient name "<recipientName>"
    And ios user selects country drop down and enters country code or name "<country>" to add recipient
    And ios user selects the country from searched result list "<country>"
    Then selected country "<country>" should be displayed in country dropdown to add recipient
    And non editable recipient currency should be auto set as they get currency "<theyGetCurrency>" in ios app
    And ios address details fields should be displayed to applicable country currency
    When ios user enters country specific required address "<address>" field data to add recipient
    And ios user enters account number "<accountNo>" base on country"<country>"currency"<currency>"
    And ios user selects bank code type"<bankCodeType>"and enters bank code"<bankCode>"base on country"<country>"currency"<currency>"
    Then bank details should be fetched in ios app
    And continue button should be in enabled state in ios app
    When ios user click on continue button
    Then otp page should be displayed to ios user
    #When ios user enters valid otp "<emailAddress>" to add recipient
    When ios user enters default otp on add recipient screen
    Then ios user should navigate to payment method screen
    And bank transfer payment method should be in active state
    And debit card payment method should be in inactive state
    And wallet payment method should be in inactive state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount   | recipientType | recipientName   | country                  | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | AUD            | USD             | 12000.00 | Individual    | Andrew Peterson | United States Of America | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3942_TC08 @CD_SendMoneyLot5
  Scenario Outline: To verify when sell currency is GBP or EUR and sell amount is greater than  available balance then Debit card payment method should be enabled and Wallet should be in disabled state.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    And debit card payment method should be in active state
    And bank transfer payment method should be in active state
    And wallet payment method should be in inactive state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount   | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 12000.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3942_TC09 @CD_SendMoneyLot5
  Scenario Outline: CDLGB To verify when sell currency is other than GBP or EUR and sell amount less than or equal to available balance then Bank Transfer, Wallet should be in enabled state and Debitcard payment method in disabled state
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    And wallet payment method should be in active state
    And bank transfer payment method should be in active state
    And debit card payment method should be in inactive state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount  | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 2000.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3942_TC10 @CD_SendMoneyLot5
  Scenario Outline: To verify when sell currency is other than GBP or EUR and sell amount greater than or equal to available balance then bank transfer payment method should be enabled and debitcard
    							 wallet payment method should be in disabled state.

    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    And bank transfer payment method should be in active state
    And wallet payment method should be in inactive state
    And debit card payment method should be in inactive state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount  | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 8000.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3942_TC11 @CD_SendMoneyLot5
  Scenario Outline: CDLGB To verify when sell currency is GBP or EUR and sell amount is less than or equal to available balance then Bank transfer,Debit Card and Wallet payment method should be in enabled state.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    And wallet payment method should be in active state
    And bank transfer payment method should be in active state
    And debit card payment method should be in active state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3942_TC12 @CD_SendMoneyLot5
  Scenario Outline: CDLGB To verify when sell currency is GBP or EUR and sell amount greater than available balance then Bank Transfer ,Debit Card should be eneabled state
    and Wallet payment method should be in disabled state

    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    And bank transfer payment method should be in active state
    And debit card payment method should be in active state
    And wallet payment method should be in inactive state

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount   | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 20000.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3942_TC13 @CD_SendMoneyLot5
  Scenario Outline: 7.21 To verify that when payment reason is not selected then continue button should be in disabled state.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    And ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user select wallet as payment method
    Then you pay currency "<youPayCurrency>" wallet should be displayed with balance in ios app
    When ios user enters payment reference "<reference>"
    Then continue button should be in disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 6759649826438453 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_PID-3939_TC52 @CD_FraudSight_SendMoney_Cycle1 @CD_SendMoneyLot5
  Scenario Outline: 8.13 To verify that in send money flow user is able to perform journey by using existing non 3d card user land and on success page and data get mapped.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      # | CDRegEmailID33 | CDRegEmailPass  | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 5454545454545454 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      #| CDRegEmailID34 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | Smith          | 5454545454545454 |            1120 |             1125 | 555 | Bill payments | Test-Reference | SIT         |
      #| CDRegEmailId3 | CDRegEmailPass | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | George Browning | 5555555555554444 |            1120 |             1125 | 555 | Bill payments | Test-Reference | SIT         |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 5555555555554444 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  @CD_FraudSight_Scenario_05 @CD_SendMoneyLot5
  Scenario Outline: 8.13 To verify that in send money flow user is able to perform journey by using existing non 3d invalid cvv card user land and on success page and data get mapped.
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      #| CDRegEmailID33 | CDRegEmailPass | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 5454545454545454 |            1120 |             1125 | 254 | Bill payments | Test-Reference | UAT         |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | jee            | 5555555555554444 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  #| CDRegEmailID34 | CDRegEmailPass1 | EUR            | USD             | 200.00 | Individual    | Andrew Peterson | USA     | USD      | USAAdd  |  12345675 | ABA          | 083900363 | Smith          | 5454545454545454 |            1120 |             1125 | 354 | Bill payments | Test-Reference | UAT         |
  @CD_FraudSight_Scenario_06 @CD_SendMoneyLot5
  Scenario Outline: 8.13 To verify that in send money flow user is able to perform journey by
           using existing 3d invalid cvv card user land and on success page and data get mapped.

    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then ios user should land on threed card page
    When ios user submits threed card response
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDRegEmailId30 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |

  # | CDRegEmailId32 | CDRegEmailPass4 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | 3d             | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
  @CD_MakeATransfer
  Scenario Outline: 8.13 To verify that in send money flow user is able to perform journey by
           using existing card user land and on success page and data get mapped.

    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios user should land on send money dashboard page
    When ios user selects you pay currency drop down and enters currency code or name "<youPayCurrency>"
    And ios user selects the currency from searched result list "<youPayCurrency>"
    And ios user selects they get currency drop down and enters currency code or name "<theyGetCurrency>"
    And ios user selects the currency from searched result list "<theyGetCurrency>"
    And ios user enters you pay amount "<amount>"
    Then after two sec appropriate amount should be calculated in they get ios app field
    When ios user click on continue
    Then ios user should land on select recipient screen
    When ios user selects a saved recipient base on name "<recipientName>" currency "<currency>" and account no "<accountNo>"
    Then ios user should navigate to payment method screen
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then deal confirmation screen should be displayed with correct mapped details in ios app
    When ios user click on the done button
    Then activity screen should be displayed with recent transaction history in ios app

    Examples: 
      | emailAddress | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName    | country        | currency | address | accountNo                   | bankCodeType | bankCode                      | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment |
      | CDAddPayee   | CDRegEmailPass1 | GBP            | EUR             | 200.00 | Individual    | Frances Shuffler | Spain          | EUR      | USAAdd  |                    12451332 | IBAN         | ES91 2100 0418 4502 0005 1332 | Cgomes         | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      # | CDAddPayee   | CDRegEmailPass1 | GBP            | USD             | 200.00 | Company       | Frances Shuffler | United States Of America | USD      | USAAdd  |                    12457823 | ABA          |                     083900363 | Cgomes         | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      | CDAddPayee   | CDRegEmailPass1 | GBP            | EUR             | 200.00 | Company       | Barclays Inc     | France         | EUR      | USAAdd  | FR1420041010050500013M02606 | ABA          |                     083900363 | Cgomes         | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      | CDAddPayee   | CDRegEmailPass1 | GBP            | CAD             | 200.00 | Individual    | Frances Shuffler | Canada         | CAD      | USAAdd  |                    12345678 | ABA          |                     083900363 | Cgomes         | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      | CDAddPayee   | CDRegEmailPass1 | GBP            | INR             | 200.00 | Company       | Tata Services    | India          | INR      | USAAdd  |                    12345678 | ABA          |                     083900363 | Cgomes         | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      | CDAddPayee   | CDRegEmailPass1 | GBP            | AUD             | 200.00 | Company       | ICICI Bank       | Australia      | AUD      | USAAdd  |                    12345678 | ABA          |                     083900363 | Cgomes         | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      | CDAddPayee   | CDRegEmailPass1 | GBP            | ZAR             | 200.00 | Company       | TCS  Ltd         | South Africa   | ZAR      | USAAdd  |                    12345678 | ABA          |                     083900363 | Cgomes         | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      | CDAddPayee   | CDRegEmailPass1 | GBP            | NZD             | 200.00 | Individual    | Andrew Peterson  | New Zealand    | NZD      | USAAdd  |                    12345678 | ABA          |                     083900363 | Cgomes         | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      | CDAddPayee   | CDRegEmailPass1 | GBP            | SGD             | 200.00 | Individual    | Andrew Peterson  | Singapore      | SGD      | USAAdd  |                    12345678 | ABA          |                     083900363 | Cgomes         | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      | CDAddPayee   | CDRegEmailPass1 | GBP            | EUR             | 200.00 | Individual    | Parle Inc        | United Kingdom | EUR      | USAAdd  | GB29NWBK60161331926819      | ABA          |                     083900363 | Cgomes         | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
      | CDAddPayee   | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Parle Inc        | China          | GBP      | USAAdd  |                    12345678 | ABA          |                     083900363 | Cgomes         | 4462030000000000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         |
