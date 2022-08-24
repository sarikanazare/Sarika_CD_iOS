@Wallet_AndroidMobTorFx
Feature: Wallet 
  
 
    @PAD-3387_TC1_AndroidMobTorFx
    Scenario Outline: 1.1 To verify post login when user click on “wallet” bottom bar user should land on wallet page, Wallet screen displayed with list of wallet balance
    Given android user installed the new TorFx app and launched successfully    
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    Then android user navigates to wallet screen
    Then list of wallets should be displayed with the wallet balance in android app
        Examples: 
        | emailAddress         | password          | 
        | TorFxWalletListUser  | TorFxRegEmailPass |
       
    @PAD-3388_TC2_AndroidMobTorFx
    Scenario Outline: 2.2To verify page get scroll properly when user has many wallet available
    Given android user installed the new TorFx app and launched successfully    
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    Then user should be able to scroll down to see wallet list in android app
        Examples: 
        | emailAddress     | password       | 
        | TorFxWalletBigList  | TorFxRegEmailPass | 
       
     @PAD-3388_TC3_AndroidMobTorFx
     Scenario Outline: 2.3 To verify when user don't have any wallet then app should display no wallet present screen
     Given android user installed the new TorFx app and launched successfully    
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen  
     When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
     And android user click on the wallet option from the home dashboard
     Then your wallet is empty message should be displayed in android app
     Then an option to add wallet should be displayed in android app
         Examples: 
         | emailAddress     | password          | 
         | TorFxNoWallet    | TorFxRegEmailPass | 
     
     @PAD-3390_TC4_AndroidMobTorFx
     Scenario Outline: 4.2 To verify on “Add wallet” page after tap on close icon or device back button, user redirects to the Wallet page.
     Given android user installed the new TorFx app and launched successfully    
     Then android the app should load the onboarding screen
     When android user click on I already have an account? link
     Then android user should navigate to login screen
     When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
     And android user click on the wallet option from the home dashboard
     When android user click on add wallet option from the wallet screen
     When android user selects the close button
     Then android user navigates to wallet screen
         Examples: 
         | emailAddress         | password          | 
         | TorFxWalletListUser  | TorFxRegEmailPass | 
     
           
     @PAD-3390_TC5_AndroidMobTorFx
     Scenario Outline: 4.4 To verify user able to scroll, filter the currency using search bar and select currency from dropdown 
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
     When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
     And android user click on the wallet option from the home dashboard
     When android user click on add wallet option from the wallet screen
     Then list of available currency should be displayed in android aap
     When android user types each character "<Typecurrency>" in search field
     Then user should be able to scroll down to see wallet list in android app
     When android user click on currency "<currency>" retrived from search
     Then android user navigates to wallet screen     
         Examples: 
         | emailAddress         | password          | currency |Typecurrency| 
         | TorFxWalletListUser  | TorFxRegEmailPass | EUR      |E           | 
      
     @PAD-3390_TC6_AndroidMobTorFx
     Scenario Outline: 4.7 To verify that if as per Search criteria no result found then system should display proper error message screen, 
     closing error popup user navigates on currency list screen
    Given android user installed the new TorFx app and launched successfully    
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
     When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
     And android user click on the wallet option from the home dashboard
     When android user click on add wallet option from the wallet screen
     Then list of available currency should be displayed in android aap
     When android user types each character "<currency>" in search field
     Then wallet currency not found error message displayed in android app
     When android user clicks on close icon from search
     Then list of available currency should be displayed in android aap
         Examples: 
         | emailAddress         | password          | currency |
         | TorFxWalletListUser  | TorFxRegEmailPass | EARTT    |
       
    @PAD-3388_TC7_AndroidMobTorFx
    Scenario Outline:  2.5 To verify after clicking any wallet user should land on “Currency wallet” screen.
    Given android user installed the new TorFx app and launched successfully    
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    When android user click on wallet currency "<currency>" from wallet screen
   # When android user click on wallet currency "<currency>" from wallet screen page
    Then android user navigate to selected currency "<currencyWallet>" wallet detail screen 
  
        Examples: 
        | emailAddress           | password          | currency | currencyWallet | 
        | TorFxWalletListUser    | TorFxRegEmailPass | USD      | USD  Wallet    |  
      
    @PAD-3545_TC8_AndroidMobTorFx
    Scenario Outline:   3.1 (Without transaction) To verify the parameter of “Currency wallet” screen when transaction are not present
    Given android user installed the new TorFx app and launched successfully    
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    When android user click on wallet currency "<currency>" from wallet screen
    Then android user navigate to selected currency "<currencyWallet>" wallet detail screen 
    Then no transaction message displayed in android app
        Examples: 
        | emailAddress         | password          | currency | currencyWallet | 
        | TorFxWalletListUser  | TorFxRegEmailPass | CAD      | CAD  Wallet    |  
       
    @PAD-3672_TC9_AndroidMobTorFx
    Scenario Outline: 6.1 To verify when user is on “Currency Wallet” page and when the wallet amount is below the minimum threshold 
    to make a transfer or available balance is zero then “send”option should be disable  
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen 
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then available wallet balance displayed for selected currency
    Then send button should displayed in disabled state in android app
        Examples:
        | emailAddress         | password          | currency  | 
        | TorFxWalletListUser  | TorFxRegEmailPass | CAD       | 
     
    @PAD-3389_TC10_AndroidMobTorFx
    Scenario Outline:   3.1.1 (With transaction) To verify page get scroll properly when user has many wallet transaction.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    When android user click on wallet currency "<currency>" from wallet screen
    Then android user navigate to selected currency "<currencyWallet>" wallet detail screen 
    Then wallet transaction displayed in android app
        Examples: 
        | emailAddress         | password          | currency | currencyWallet | 
        | TorFxWalletListUser  | TorFxRegEmailPass | EUR      | EUR  Wallet    |  
         
    @PAD-3545_TC11_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 3.2.1 To verify the user redirects to the “Currency wallet” screen after tap on back (arrow) button or device back on “Top up Wallet” screen.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    When android user click on back button
    Then android user navigate to selected currency "<currencyWallet>" wallet detail screen 
    And android user click on Add currency from wallet screen  
    Then android user navigates to buy currency screen
    When android user presses device back button
    Then android user navigate to selected currency "<currencyWallet>" wallet detail screen 
        Examples: 
        | emailAddress         | password          | currency | currencyWallet | 
        | TorFxWalletListUser  | TorFxRegEmailPass | EUR      | EUR  Wallet    |   
  
    @PAD-3392_TC12_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut) 3.3 To verify the user redirects to the “Currency wallet” screen after tap on back (arrow) button or device back on “Send from Wallet” screen.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user click on back button
    Then android user navigate to selected currency "<currencyWallet>" wallet detail screen 
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user presses device back button
    Then android user navigate to selected currency "<currencyWallet>" wallet detail screen 
        Examples:
        | emailAddress         | password          | currency  | currencyWallet | 
        | TorFxWalletListUser  | TorFxRegEmailPass | AUD       | AUD  Wallet    |  
        
    @PAD-3351_TC13_AndroidMobTorFx
    Scenario Outline: 3.4,5.1 To verify the parameter of “Bank Details” screen.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on bank from wallet screen
    Then android user navigates to bank details screen
    Then bank details screen displayed with correct details mapped in android app 
        Examples: 
        | emailAddress         | password          | currency |
        | TorFxWalletListUser  | TorFxRegEmailPass | USD      |
      
    @PAD-3391_TC14_AndroidMobTorFx
    Scenario Outline: 5.2 To verify the user redirects to the “Currency wallet” screen after tap on back (arrow) button or device back on “Bank Details” screen.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on bank from wallet screen
    Then android user navigates to bank details screen
    Then bank details screen displayed with correct details mapped in android app 
    When android user click on back button
    Then android user navigate to selected currency "<currencyWallet>" wallet detail screen 
    And android user click on bank from wallet screen
    Then android user navigates to bank details screen
    Then bank details screen displayed with correct details mapped in android app 
    When android user presses device back button
    Then android user navigate to selected currency "<currencyWallet>" wallet detail screen 
        Examples: 
        | emailAddress         | password          | currency |currencyWallet | 
        | TorFxWalletListUser  | TorFxRegEmailPass | EUR      |EUR  Wallet    |  
         
    @PAD-3351_TC15_AndroidMobTorFx
    Scenario Outline: (Wallet transaction) To verify when user tap on Add fund-FX transaction user should land on FX detail page
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    When android user click on wallet currency "<currency>" from wallet screen
    Then android user navigate to selected currency "<currencyWallet>" wallet detail screen 
    Then wallet transaction displayed in android app
    When android user clicks on "<transactionId>" instruction 
    Then android user navigates on activity page
        Examples: 
        | emailAddress         | password          | currency | currencyWallet |transactionId | 
        | TorFxWalletListUser  | TorFxRegEmailPass | EUR      | EUR  Wallet    |  4           | 
      
    @PAD-3393_TC16_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn) 8.1 To verify on “Add Currency” screen, app should fetch all the 
    available/supported wallet top up methods for the selected wallet currency (Buying Currency)
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    Then pay in currency "<PayInCCY>" tab should be displayed in android app
        Examples: 
        | emailAddress         | password          | currency |  PayInCCY      | 
        | TorFxWalletListUser  | TorFxRegEmailPass | EUR      |  Pay in EUR    | 
       
     @PAD-3390_TC17_AndroidMobTorFx
     Scenario Outline: 9.2 To verify the user presses device back button on “Currency Wallet” screen, user lands on Wallet screen.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
     When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
     And android user click on the wallet option from the home dashboard
     And android user click on wallet currency "<currency>" from wallet screen
     When android user presses device back button
     Then android user navigates to wallet screen
         Examples: 
         | emailAddress         | password          | currency | 
         | TorFxWalletListUser  | TorFxRegEmailPass | GBP      | 
       
    @PAD-3395_TC18_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)9.4 selling currency - To verify that amount get calculated in sell currency when user entered amount in Buy currency
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    And android user enter amount "<amount>" in buying currency wallet and user stops typing the amount
    Then after two sec appropriate amount should be calculated in sell currency wallet in android app
        Examples: 
        | emailAddress        | password           | currency  | amount    | 
        | TorFxWalletListUser | TorFxRegEmailPass  | GBP       |  2,000.00 | 
      
    @PAD-3395_TC19_AndroidMobTorFx @TorFxSanity @TorFxregression 
    Scenario Outline: (Buy currency-Fx)9.5 To verify when the user is entering amount less than min limit in 'Selling Currency’ (Paying with) amount field, after 2 sec a relevant error message should be display.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    And android user enter amount "<amount>" less than hundred GBP in selling currency wallet and user stops typing the amount
    Then minimum amount limit error message should be displayed to android user
        Examples: 
        | emailAddress        | password           | currency | amount | 
        | TorFxWalletListUser | TorFxRegEmailPass  | GBP      | 99.99  | 
      
    @PAD-3395_20_AndroidMobTorFx @TorFxSanity @TorFxregression
    Scenario Outline: (Buy currency-Fx)9.6 To verify when the user is entering amount greater than max limit in 
    'Selling Currency’ (Paying with) amount field, after 2 sec a relevant error message should be display.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen 
    And android user enter amount "<amount>" greater than allowed GBP limit in selling currency wallet
    Then maximum allowed amount limit error message should be displayed to android user
        Examples: 
        | emailAddress        | password           | currency | amount      | 
        | TorFxWalletListUser | TorFxRegEmailPass  | GBP      | 225,001.00  | 
      
    @PAD-3395_TC21_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 9.7 buying currency - To verify that amount get calculated in buy currency when user entered amount in sell currency   
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen 
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    And android user enter amount "<amount>" in selling currency wallet and user stops typing the amount
    Then after two sec appropriate amount should be calculated in buy currency wallet in android app
        Examples: 
        | emailAddress        | password           | currency  | amount    | 
        | TorFxWalletListUser | TorFxRegEmailPass  | GBP       |  3,000.00 | 
      
    @PAD-3395_TC22_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 9.8 To verify when the user is entering amount less than min limit in Buying Currency’ (Add to wallet) amount field, 
    after 2 sec a relevant error message should be display.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    And android user enter amount "<amount>" less than hundred GBP in buying currency wallet and user stops typing the amount
    Then minimum amount limit error message should be displayed to android user
        Examples: 
        | emailAddress        | password           | currency  | amount   | 
        | TorFxWalletListUser | TorFxRegEmailPass  | GBP       |  95.00   | 
      
    @PAD-3395_TC23_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 9.9 To verify when the user is entering amount greater than max limit in Buying Currency’ (Add to wallet) amount field, 
    after 2 sec a relevant error message should be display.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    And android user enter amount "<amount>" greater than allowed GBP limit in buying currency wallet
    Then maximum allowed amount limit error message should be displayed to android user
        Examples: 
       | emailAddress        | password           | currency  | amount   | 
       | TorFxWalletListUser | TorFxRegEmailPass  | GBP       | 55595.00 | 
      
    @PAD-3395_TC24_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 9.10 To verify when the user has entered the 'Selling Currency’ (Paying with) amount then buying amount with FX deal rate populated. 
    Changes amount again when the user stops typing the amount then after 2 seconds, the app should attempt to fetch the latest Fx deal rates.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    And android user enter amount "<amount>" in selling currency wallet and user stops typing the amount
    Then after two sec appropriate amount should be calculated in buy currency wallet in android app
    And android user enter amount "<Updateamount>" in selling currency wallet and user stops typing the amount
    Then after two sec appropriate amount should be calculated in buy currency wallet in android app
        Examples: 
        | emailAddress        | password           | currency  | amount    |Updateamount | 
        | TorFxWalletListUser | TorFxRegEmailPass  | GBP       |  3,000.00 | 5,000.31    | 
      
    @PAD-3395_TC25_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)9.11 To verify when the user has entered the 'Buying Currency’ (Add to wallet) amount then selling amount with FX deal rate populated. 
    Changes amount again when the user stops typing the amount then after 2 seconds, the app should attempt to fetch the latest Fx deal rates.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    And android user enter amount "<amount>" in buying currency wallet and user stops typing the amount
    Then after two sec appropriate amount should be calculated in sell currency wallet in android app
    And android user enter amount "<Updateamount>" in buying currency wallet and user stops typing the amount
    Then after two sec appropriate amount should be calculated in sell currency wallet in android app
        Examples: 
        | emailAddress        | password           | currency  | amount    |Updateamount | 
        | TorFxWalletListUser | TorFxRegEmailPass  | GBP       |  3,000.00 | 5,000.31    | 
      
      @PAD-3395_TC26_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)9.13 To verify when user entered the amount in selling currency field and rate observed for that pair, 
    when the timer ends(60 sec), then the Fx deal rates should fetched again and the timer resets/restarts
    Given android user installed the new TorFx app and launched successfully
   Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    And android user selects Sell currency drop down from wallet
    And android user enters currency code or name "<sellCurrency>"
    When android user click on currency "<sellCurrency>" retrived from search
    And android user enter amount "<amount>" in selling currency wallet and user stops typing the amount
    Then after two sec appropriate amount should be calculated in buy currency wallet in android app
    And an auto timer of sixty seconds should start and rate should be refreshed and buying amount should be updated for wallet
        Examples: 
        | emailAddress        | password           | currency  | amount     |sellCurrency| 
        | TorFxWalletListUser | TorFxRegEmailPass  | USD       |  35,000.00 | DKK        | 
    
    @PAD-3395_TC27_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)9.14 To verify when user entered the amount in buying currency field and rate observed for that pair, 
    when the timer ends(60 sec), then the Fx deal rates should fetched again and the timer resets/restarts 
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    And android user selects Sell currency drop down from wallet
    And android user enters currency code or name "<sellCurrency>"
    When android user click on currency "<sellCurrency>" retrived from search
    And android user enter amount "<amount>" in buying currency wallet and user stops typing the amount
    Then after two sec appropriate amount should be calculated in sell currency wallet in android app
    And an auto timer of sixty seconds should start and rate should be refreshed and selling amount should be updated for wallet
        Examples: 
        | emailAddress        | password           | currency  | amount    |sellCurrency | 
        | TorFxWalletListUser | TorFxRegEmailPass  | USD       |  3,000.00 |DKK          | 
        
    @PAD-3395_TC28_AndroidMobTorFx
    Scenario Outline: 9.17.1 To verify on currency selection list user should be scroll the screen, and select currency from dropdown
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    When android user selects Sell currency drop down from wallet
    Then list of available currency should be displayed in android aap
    Then android user scroll down currency list page
    And android user enters currency code or name "<sellCurrency>"
    When android user click on currency "<sellCurrency>" retrived from search
    Then android app should take the user to the buy currency screen with the selected currency "<sellCurrency>" in selling dropdown
        Examples: 
        | emailAddress         | password          | currency  | sellCurrency |  
        | TorFxWalletListUser  | TorFxRegEmailPass | GBP       |  USD         | 
         
    @PAD-3395_TC29_AndroidMobTorFx
    Scenario Outline:9.20 To verify when user tap on close icon on search field, the entered search value should get clear and 
    whole currency selection list should be display.
    Given android user installed the new TorFx app and launched successfully
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
    When android user click on (X) option
    Then the filter should be cleared and the whole currency list should be displayed
    When android user clicks on back arrow
    Then android user navigates to buy currency screen
        Examples: 
        | emailAddress        | password          | currency  | sellCurrency   | 
        | TorFxWalletListUser | TorFxRegEmailPass | GBP       |  USD           | 
           
    @PAD-3395_TC30_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 9.22 To verify if the user selects the currency from currency list, that is not supported for fx/online trade then fx deal rate should not display.
    Given android user installed the new TorFx app and launched successfully
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
    Then error message should be displayed for unsupported currency pair
    When android user click on ok for error popup
    Then android user navigates to buy currency screen
        Examples: 
        | emailAddress        | password          | currency  | sellCurrency   | 
        | TorFxWalletListUser | TorFxRegEmailPass | EUR       |  CZK           |  
        
     
    @PAD-3396_TC31_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn) 10.2 To verify on “Add Currency” screen when user tap on Back arrow button button or device back,user lands on ”Currency Wallet” screen.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    When android user click on pay in "<currency>" tab
    When android user click on back button
    Then android user navigate to selected currency "<currencyWallet>" wallet detail screen 
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    When android user click on pay in "<currency>" tab
    When android user presses device back button
    Then android user navigate to selected currency "<currencyWallet>" wallet detail screen 
        Examples: 
        | emailAddress        | password          | currency  |currencyWallet  | 
        | TorFxWalletListUser | TorFxRegEmailPass | EUR       |  EUR  Wallet   | 
        
    @PAD-3396_TC32_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn)10.3 To verify on “Add Currency” screen, able to update the amount for the same.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    When android user click on pay in "<currency>" tab
    Then default amount "<defaultAmount>" displayed in android app
    Then continue button gets enabled in android app
    And android user enter amount "<amount>" in buying currency wallet and user stops typing the amount
    Then continue button gets enabled in android app
        Examples: 
        | emailAddress  | password       | currency |  amount      |defaultAmount | 
        | TorFxWalletListUser  | TorFxRegEmailPass | EUR      |   150.00     |1000          | 
      
    @PAD-3396_TC33_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn)10.4 To verify on “Add Currency” screen when user enters amount below threshold or above threshold, a proper error message should be display on the app.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    When android user click on pay in "<currency>" tab
    And android user enter amount "<MinAmount>" in buying currency wallet and user stops typing the amount
    Then continue button gets enabled in android app
    When android user click on the continue button for buy currency
    Then minimum amount limit error message should be displayed to android user
    When android user click on ok for error popup
    And android user enter amount "<MaxAmount>" in buying currency wallet and user stops typing the amount
    When android user click on the continue button for buy currency
    Then maximum allowed amount limit error message should be displayed to android user   
    When android user click on ok for error popup
    Then android user navigates to buy currency screen    
    Examples: 
       | emailAddress         | password          | currency | MinAmount   |MaxAmount | 
       | TorFxWalletListUser  | TorFxRegEmailPass | EUR      |   00.10     |36000.10  | 
          
       @PAD-3396_TC34_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn) 12.1 To verify when user is on payment method page and press device back then user should navigate towards buy currency page
    Given android user installed the new TorFx app and launched successfully
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
    When android user presses device back button
    Then android user navigates to buy currency screen
     Examples: 
       | emailAddress         | password          | currency |  amount   | 
       | TorFxWalletListUser  | TorFxRegEmailPass | EUR      |   150.00  |   
       
    @PAD-3396_TC35_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn) 12.2 To verify when user is on payment method page and presses back button then user should navigate towards buy currency page
    Given android user installed the new TorFx app and launched successfully
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
    When android user click on back button
    Then android user navigates to buy currency screen
     Examples: 
       | emailAddress         | password       | currency |  amount   | 
       | TorFxWalletListUser  | TorFxRegEmailPass | EUR      |   150.00  |  
       
    @PAD-3396_TC36_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn)12.6, 12.8 To verify when user lands on Payment method page, list of all saved Debit Cards is displayed 
    list of all saved cards should be display and Debit Card number should appear masked
    Given android user installed the new TorFx app and launched successfully
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
    And android user has one or more saved cards
    Then saved cards number should be masked except last four digits in android app accordance with PCI-DSS requirements
     Examples: 
       | emailAddress         | password          | currency |  amount   |  
       | TorFxWalletListUser  | TorFxRegEmailPass | EUR      |   150.00  |  
   
  
    @PAD-3646_TC37_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn)12.12 To verify when user enters less than 3 digit CVV number COntinue button  should remains disabled
    Given android user installed the new TorFx app and launched successfully
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
    Then continue button should get disabled in android app
        Examples: 
        | emailAddress        | password          | currency |  amount   |  cardLast4Digit|CVV  |
        | TorFxWalletListUser | TorFxRegEmailPass | EUR      |   150.00  |  8453          | 05  |
        
    @PAD-3396_TC38_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn)12.6 To verify that in wallet flow while adding new card when 
    user enter invalid last name, card number, issue date, expiry date the system should give proper error message
    Given android user installed the new TorFx app and launched successfully
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
    Then pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides invalid unmatched contacts last name "<unmatchedLastName>"
    Then invalid last name error message should be displayed to andoid user
    When android user provides invalid expiry date "<pastExpiryDate(MMYY)>"
    Then invalid expiry date error message should be displayed to android user
     When android user provides invalid card number "<cardNumber>"
    Then invalid card number error message should be displayed to andoid user
    When android user provides invalid issue date "<issuedate>"
    Then invalid issue date error message should be displayed to andoid user
         Examples: 
         | emailAddress        | password          | currency |  amount   |  nameBillingAddress               | unmatchedLastName |pastExpiryDate(MMYY)|cardNumber       |issuedate  |
         | TorFxWalletListUser | TorFxRegEmailPass | EUR      |   150.00  | Richard Smith,SKNDA1DartfordUK    | Tom K             | 01/20              |58544442222222   | 12/23     |
              
    @PAD-3396_TC39_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn)13.1 To verify that clicking on back button of review screen user get navigate back on the payment method screen WITH PREVIOUS PAYMENT METHOD SELECTED i.e. Debit card with cvv field clear
    Given android user installed the new TorFx app and launched successfully
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
    When user click on continue button
    Then user should navigates to review page  
    When android user click on back button
    Then android user navigates to payment method page
    Then cvv field observed blank in android app
    Examples: 
       | emailAddress        | password          | currency |  amount   |  cardLast4Digit|CVV   | 
       | TorFxWalletListUser | TorFxRegEmailPass | EUR      |   150.00  |  8453          | 555  | 
           
    @PAD-3396_TC40_AndroidMobTorFx 
    Scenario Outline: (Standalone PaymentIn) 13.5 To verify User allowed to performed PayIn same currency journey successfully using add new card flow
    Given android user installed the new TorFx app and launched successfully
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
    Then android user observe the parameter on Review screen for add currency 
    When android user click on Confirm and pay button from Review screen
    Then deal confirmation screen should be displayed with correct mapped details for add currency in android app
     Examples: 
     | Legal Entity | emailAddress        | password          | currency |  amount   |  cardLast4Digit|CVV   |cardHolderName |cardNumber        | expiryDate(MMYY) | issuedate | 
     |  TORGB       |  TorFxWalletListUser| TorFxRegEmailPass | GBP      |   150.00  |  8453          | 555  | Richard Smith |6759649826438453  | 12/29            | 09/20     | 
             
    @PAD-3396_TC41_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn) 13.6 To verify when user lands on “Confirmation” screen then, On clicking Done button user navigate towards buy currency screen. 
    Given android user installed the new TorFx app and launched successfully
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
        | emailAddress        | password          | currency |  amount   |  cardLast4Digit|CVV   | 
        | TorFxWalletListUser | TorFxRegEmailPass | EUR      |   150.00  |  8453          | 555  | 
      
       
    @PAD-3396_TC42_AndroidMobTorFx
    Scenario Outline: (Standalone paymentIn) To verify payment journey flow for add new card Non-3d Card with wrong cvv.
    Given android user installed the new TorFx app and launched successfully
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
    Then android app dispalyed the error for entered wrong cvv  
         Examples: 
          | emailAddress   | password          | currency |  amount   |  cardLast4Digit|CVV   |cardHolderName     |cardNumber        | expiryDate(MMYY) | issuedate | 
          | CVVFailedUser  | TorFxRegEmailPass | GBP      |   150.00  |  8453          | 125  |Jack0990 Martin788 |6759649826438453  | 12/29            | 09/20      |  
   
     @PAD-3648_TC44_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn) 14.1 To verify that user is able to perform journey by using add new
    3d card user land and on success page and data get mapped.
    Given android user installed the new TorFx app and launched successfully
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
    Then user land on 3d page
    Then android user click on submit from 3dsceure screen
   # Then android user land on confirmation screen
   # Then deal confirmation screen should be displayed with correct mapped details for add currency in android app 
      Examples: 
           | emailAddress      | password          | currency |  amount   |  cardLast4Digit|CVV   |cardHolderName|cardNumber      | expiryDate(MMYY)|issuedate| 
           | TorFxWalletList3d | TorFxRegEmailPass | EUR      |   150.00  |  8453          | 555  |  3d          |6759649826438453|11/26            |12/20    | 
       
    @PAD-3648_TC45_AndroidMobTorFx 
    Scenario Outline: (Standalone PaymentIn) 14.2 To verify that user is able to perform journey by using existing 3d card user land and on success page and data get mapped. 
    Done button is enabled and clickable
    Given android user installed the new TorFx app and launched successfully
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
    When user click on continue button
    Then android user observe the parameter on Review screen for add currency 
    When android user click on Confirm and pay button from Review screen
    Then user land on 3d page
    Then android user click on submit from 3dsceure screen
    #Then deal confirmation screen should be displayed with correct mapped details for add currency in android app 
    #Then Done button should displayed in enabled state
        Examples: 
            | emailAddress      | password          | currency |  amount   |  cardLast4Digit|CVV   | 
            | TorFxWalletList3d | TorFxRegEmailPass | EUR      |   150.00  |  8453          | 555  | 
        
       
    @PAD-3396_TC46_AndroidMobTorFx
    Scenario Outline: (Standalone paymentIn)To verify payment journey flow for existing 3d Card with wrong cvv.
    Given android user installed the new TorFx app and launched successfully
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
    When user click on continue button
    Then user should navigates to review page 
    When android user click on Confirm and pay button from Review screen
   # Then user land on 3d page
   # Then android user click on submit from 3dsceure screen
    Then android app dispalyed the error for entered wrong cvv  
        Examples: 
       | emailAddress   | password          | currency |  amount   |  cardLast4Digit|CVV   | 
       | CVVFailedUser  | TorFxRegEmailPass | GBP      |   150.00  |  8453          | 125  | 
       
    @PAD-3396_TC47_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn) 18.14 To verify 3d card journey get successfully done when user click on back and forth page.
    Given android user installed the new TorFx app and launched successfully
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
    When user click on continue button
    Then user should navigates to review page 
    Then android user click on back button from review screen and get navigate back on the payment method screen  
    When android user selects a saved card "<cardLast4Digit>"
    Then android user select card from save card list
    Then CVV field should display to android user with the message
    And User enters the digits in CVV "<CVV>" fields
    When user click on continue button
    Then user should navigates to review page 
    When android user click on Confirm and pay button from Review screen
    Then user land on 3d page
    Then android user click on submit from 3dsceure screen
    Then deal confirmation screen should be displayed with correct mapped details for add currency in android app 
        Examples: 
        | emailAddress      | password          | currency |  amount   |  cardLast4Digit|CVV   | 
        | TorFxWalletList3d | TorFxRegEmailPass | GBP      |   150.00  |  8453          | 555  | 
  
    @PAD-4164_TC48_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) To verify amount in sell and buy currency get zero when user acknowledges the error message  for lower and higher amount
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    And android user enter amount "<minamount>" less than hundred GBP in selling currency wallet and user stops typing the amount
    Then minimum amount limit error message should be displayed to android user
    When android user click on ok for error popup
    Then sell and buy amount get zero in android app
    And android user enter amount "<maxamount>" greater than allowed GBP limit in buying currency wallet
    Then maximum allowed amount limit error message should be displayed to android user
    When android user click on ok for error popup
    Then sell and buy amount get zero in android app
        Examples: 
        | emailAddress        | password           | currency | minamount |maxamount | 
        | TorFxWalletListUser | TorFxRegEmailPass  | GBP      | 99.99     | 55000.00 | 
      
         
    @PAD-3398_TC49_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 12.2 To verify while user performing top-up journey when user tap on app back button on “Payment method” screen then 
    user should redirect to previous page with the previously selected top up method in selected state
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    When android user clicks on back arrow from payment method screen
    Then android user navigates to buy currency screen
        Examples: 
        | emailAddress         | password          | currency  |  
        | TorFxWalletListUser  | TorFxRegEmailPass | GBP       |    
     
    @PAD-3398_TC50_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)12.2.1 To verify while user performing top-up journey when user tap on device back button on “Payment method” screen then user should redirect 
    to previous page with the previously selected top up method in selected state
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    When android user presses device back button
    Then android user navigates to buy currency screen
        Examples: 
        | emailAddress         | password          | currency  |  
        | TorFxWalletListUser  | TorFxRegEmailPass | GBP       | 
      
    @PAD-5588_TC51_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)TorFxLGB To verify when sell currency is GBP/EUR and sell amount less than or equal to available balance (non zero balance) then all payment methods is in active state
    Given android user installed the new TorFx app and launched successfully
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
    When android user enter amount "<amount>" in selling currency wallet
    Then after two sec appropriate amount should be calculated in buy currency wallet in android app
    When android user click on the continue button for buy currency
    Then android user land on Payment Method screen
    Then android user observed DebitCard payment method in active state
    Then android user observed BankTransfer payment method in active state
    Then android user observed Wallet payment method in active state
    Examples:
        | emailAddress        | password          | amount |sellCurrency | currency  | 
        | TorFxWalletListUser | TorFxRegEmailPass | 250.00 |GBP          |    USD    | 
    
      
    @PAD-5588_TC52_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) TorFxLGB To verify when sell currency is other than GBP/EUR and sell amount less than or equal to available balance then wallet and Debit card payment method disabled
    Given android user installed the new TorFx app and launched successfully
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
    When android user enter amount "<amount>" in selling currency wallet
    Then after two sec appropriate amount should be calculated in buy currency wallet in android app
    When android user click on the continue button for buy currency
    Then android user land on Payment Method screen
    Then android user observed DebitCard payment method in disabled state
    Then android user observed BankTransfer payment method in active state
    Then android user observed Wallet payment method in active state
      Examples:
          | emailAddress        | password          | amount   |sellCurrency | currency  |  
          | TorFxWalletListUser | TorFxRegEmailPass | 22650.00 |USD          |    EUR    | 
    
    @PAD-5588_TC53_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) TorFxLGB To verify when sell currency is GBP/EUR and sell amount greater than available balance (non zero balance) then all payment methods is in active state
    Given android user installed the new TorFx app and launched successfully
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
    When android user enter amount "<amount>" in selling currency wallet
    Then after two sec appropriate amount should be calculated in buy currency wallet in android app
    When android user click on the continue button for buy currency
    Then android user land on Payment Method screen
    Then android user observed DebitCard payment method in active state
    Then android user observed BankTransfer payment method in active state
    Then android user observed Wallet payment method in disabled state
    Examples:
          | emailAddress        | password          | amount   |sellCurrency | currency  | 
          |TorFxWalletListUser  | TorFxRegEmailPass | 22550.00 |CAD          |    GBP    | 
  
     
    @PAD-5588_TC54_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) TorFxLGB To verify when sell currency is other than GBP/EUR and sell amount greater than available balance then wallet and card payment methods is in disable state
    Given android user installed the new TorFx app and launched successfully
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
    When android user enter amount "<amount>" in selling currency wallet
    Then after two sec appropriate amount should be calculated in buy currency wallet in android app
    When android user click on the continue button for buy currency
    Then android user land on Payment Method screen
    Then android user observed DebitCard payment method in disabled state
    Then android user observed BankTransfer payment method in active state
    Then android user observed Wallet payment method in disabled state
    Examples:
        | emailAddress         | password          | amount    |sellCurrency | currency  | 
        | TorFxWalletListUser  | TorFxRegEmailPass | 2190.00   |CAD          |    EUR    | 
    
    @PAD-3398_TC55_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 12.8 To verify when user lands on  debit card Payment method then list of all saved cards should be display with Option to ‘Add new card’ and Continue button should be in disabled state
    list of all saved cards should be display and Debit Card number should appear masked
    Given android user installed the new TorFx app and launched successfully
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
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    And android user has one or more saved cards
    Then saved cards number should be masked except last four digits in android app accordance with PCI-DSS requirements
    Then add new card option visible in android app
    Then wallet continue button should get disabled for debit card in android app
    Examples: 
      | emailAddress         | password       | currency  | sellCurrency | 
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR       | GBP          | 
    
    @PAD-3398_TC56_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 12.9 To verify when user lands on Payment method page and user selects the payment method as debit card then 
    list of all saved cards should be display and Debit Card number should appear masked
    Given android user installed the new TorFx app and launched successfully
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
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    Then android user select the payment method Debit Card
    And android user has one or more saved cards
    Then saved cards number should be masked except last four digits in android app accordance with PCI-DSS requirements
    Examples: 
      | emailAddress         | password          | currency  | sellCurrency | 
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR       | GBP          |  

    @PAD-3398_TC57_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)12.9.3 12.11 To verify when user completes the Add card journey, then it should redirects to the “Payment method” screen, 
    with cards list where recently added should be on the top
    current date than system should give proper error message
    account holders last name the system should give proper error message
    Given android user installed the new TorFx app and launched successfully
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
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    Then android user select the payment method Debit Card
    And android user selects to add a new card
    Then pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    Then the option to save the card should be in active/enabled state in android app
    And android user clicks on save button
    Then android user should navigate to card list screen
    And card "<cardNumber>" details should be saved in android app debit card list as per order of date added
    Examples: 
      | emailAddress        | password          | currency   | sellCurrency |nameBillingAddress             |cardHolderName  |cardNumber        | expiryDate(MMYY) | issuedate | 
      | TorFxWalletListUser | TorFxRegEmailPass | CAD        |   EUR        | Richard Smith,SKNDA1DartfordUK| Richard Smith   |6759649826438453  | 12/29           | 09/20     |  

    @PAD-3398_TC58_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 12.13 To verify on “Payment method” screen, when the user selects an already saved card from the list,
    user is asked to enter the correct CVV number.
    Given android user installed the new TorFx app and launched successfully
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
    When android user click on the continue button for buy currency
    Then android user navigates to payment method page
    Then android user select the payment method Debit Card
    When android user selects a saved card "<cardLast4Digit>"
    Then android user select card from save card list
    Then CVV field should display to android user with the message
    Examples: 
      | emailAddress   | password          | currency   | sellCurrency |cardLast4Digit | 
      | CVVFailedUser  | TorFxRegEmailPass | CAD        |   EUR        |8453           |    
       
    @PAD-3398_TC59_AndroidMobTorFx 
    Scenario Outline: (Buy currency-Fx)12.19 To verify the user selects the debit card as payment method on Review and confirmation screen correct payment details obsrved.   
    Given android user installed the new TorFx app and launched successfully
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
         | emailAddress        | password          | currency   | sellCurrency |amount | cardLast4Digit |CVV | 
         | TorFxWalletListUser | TorFxRegEmailPass | USD        |   GBP        |280.00 | 8453           | 555| 
   
    @PAD-3398_TC60_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)13.6 To verify that clicking on back button of review screen user get navigate back on the payment method screen WITH PREVIOUS PAYMENT METHOD SELECTED  
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen 
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    When android user click on the continue button for buy currency
    Then android user land on Payment Method screen
    Then android user select the payment method Bank Transfer
    Then continue button should get enabled for bank transfer in android app
    When android user click on continue button for bank transfer
    Then user should navigates to review page  
    Then android user click on back button from review screen and get navigate back on the payment method screen  
   Examples:
      | emailAddress         | password          | currency  |  
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR       | 
      
    @PAD-3398_TC61_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 12.19 To verify the user selects the wallet as payment method on On payment method page sell currency is payment currency.
    Given android user installed the new TorFx app and launched successfully
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
    When android user enter amount "<amount>" in selling currency wallet
    Then after two sec appropriate amount should be calculated in buy currency wallet in android app
    When android user click on the continue button for buy currency
    Then android user land on Payment Method screen
    Then android user select the payment method Wallet
    Then sell currency dislayed as payment currency in android app
     Examples:
      | emailAddress         | password          | sellCurrency | currency  | amount   | 
      | TorFxWalletListUser  | TorFxRegEmailPass | GBP          |    USD    |100.00    |  
      
    @PAD-3399_TC62_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)13.4 13.3 To verify when user tap on the T's & C's link, a webview window should open with a link to the respective T's & C's specific to the user.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    And android user click on Add currency from wallet screen
    Then android user navigates to buy currency screen
    When android user click on the continue button for buy currency
    Then android user land on Payment Method screen
    Then android user select the payment method Bank Transfer
    Then continue button should get enabled for bank transfer in android app
    When android user click on continue button for bank transfer
    Then user should navigates to review page 
    Then android user click on terms and condition link
    Then window should open with a link to the respective UK T's & C in android app 
   Examples:
      | emailAddress         | password          | currency  |  
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR       | 
      
       @PAD-3399_TC63_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)13.4 To verify when user tap on Back button then T's & C's page get close and user lands on the Review screen.
    Given android user installed the new TorFx app and launched successfully
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
    When android user click on the continue button for buy currency
    Then android user land on Payment Method screen
    Then android user select the payment method Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then user should navigates to review page
    Then android user click on terms and condition link
    Then window should open with a link to the respective UK T's & C in android app 
    When android user click on back button or the device back button on UK T's & C window
    Then android user click on back button from terms and condition and lands back to review screen
    Examples:
      | emailAddress         | password          | sellCurrency | currency  |  
      | TorFxWalletListUser  | TorFxRegEmailPass | GBP          |    EUR    | 
      
    @PAD-3399_TC64_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)13.5,13.7 To verify when deal completed successfully then the “Confirmation” screen should be display. 
    Given android user installed the new TorFx app and launched successfully
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
    When android user enter amount "<amount>" in selling currency wallet
    Then after two sec appropriate amount should be calculated in buy currency wallet in android app
    When android user click on the continue button for buy currency
    Then android user land on Payment Method screen
    Then android user select the payment method Bank Transfer
    Then continue button should get enabled for bank transfer in android app
    When android user click on continue button for bank transfer
    Then android user observe the parameter on Review screen for buy currency 
    When android user click on Confirm and pay button from Review screen
    Then deal confirmation screen should be displayed with correct mapped details for buy currency fx in android app  
    Examples:
      | emailAddress         | password          | amount |sellCurrency | currency  | 
      | TorFxWalletListUser  | TorFxRegEmailPass | 250.00 |USD          |    GBP    | 
      
    @PAD-3398_TC65_AndroidMobTorFx @TorFxSanity @TorFxregression
    Scenario Outline: (Buy currency-Fx) 12.19 To verify the user selects the wallet as payment method on Review and confirmation screen correct payment details obsrved.  
    Given android user installed the new TorFx app and launched successfully
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
    When android user enter amount "<amount>" in selling currency wallet
    Then after two sec appropriate amount should be calculated in buy currency wallet in android app
    When android user click on the continue button for buy currency
    Then android user land on Payment Method screen
    Then android user select the payment method Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then android user observe the parameter on Review screen for buy currency 
    When android user click on Confirm and pay button from Review screen
    Then deal confirmation screen should be displayed with correct mapped details for buy currency fx in android app  
    
    Examples:
      | emailAddress         | password           |sellCurrency | currency  | amount | 
      | TorFxWalletListUser  | TorFxRegEmailPass  |EUR          |    USD    |130.00  | 
    
     @PAD-3399_TC66_AndroidMobTorFx @TorFxSanity @TorFxregression
    Scenario Outline: (Buy currency-Fx) 14.4 To verify on the 'Confirmation' screen, When the 'Done' button is selected,
     the user should navigate to the “Wallets” screen.
    Given android user installed the new TorFx app and launched successfully
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
    Then android user land on Payment Method screen
    Then android user select the payment method Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then android user observe the parameter on Review screen for buy currency 
    When android user click on Confirm and pay button from Review screen
    Then android user land on success page and click on Done button
    Then android user navigates to buy currency screen      
    Examples:
      | emailAddress         | password          | sellCurrency | currency  | amount   | 
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR          |    GBP    |180.00    | 
 
    @PAD-3398_TC67_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)12.21 To verify that clicking on back button of review screen user get navigate back on the payment method screen WITH PREVIOUS PAYMENT METHOD SELECTED i.e. Debit card with cvv field clear
    Given android user installed the new TorFx app and launched successfully
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
    Then android user click on back button from review screen and get navigate back on the payment method screen
    And previously selected payment method Debit Card should be displayed in android app on payment method screen
    Then cvv field observed blank in android app
     Examples: 
       | emailAddress        | password          | currency   | sellCurrency |amount | cardLast4Digit |CVV | 
       | TorFxWalletListUser | TorFxRegEmailPass | USD        |   GBP        |180.00 | 8453           | 555| 
    
    @PAD-3396_TC68_AndroidMobTorFx @TorFxSanity @TorFxregression
    Scenario Outline: Buy currency-Fx To verify payment journey flow for add new card, user land and on success page data get mapped
    Given android user installed the new TorFx app and launched successfully
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
    And android user enter amount "<amount>" in buying currency wallet and user stops typing the amount
    Then after two sec appropriate amount should be calculated in sell currency wallet in android app
    Then continue button gets enabled in android app
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
    Then user should navigates to review page 
    Then android user observe the parameter on Review screen for buy currency 
    When android user click on Confirm and pay button from Review screen
    Then deal confirmation screen should be displayed with correct mapped details for buy currency fx in android app
     Examples: 
        | emailAddress         | password          | currency |  amount   |  cardLast4Digit|CVV   |sellCurrency | cardHolderName  |cardNumber        | expiryDate(MMYY) | issuedate | 
        | TorFxWalletListUser  | TorFxRegEmailPass | EUR      |   250.00  |  8453          | 555  | GBP         |Richard Smith    |6759649826438453  | 12/29            | 09/20     |    
     
    @PAD-4164_TC69_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)12.19.1  To verify Non-3d Card journey get successfully done when user click on back and forth page.
    User select card and goes further and then again comes back and then again select card and process the journey completely.
    Given android user installed the new TorFx app and launched successfully
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
    Then user should navigates to review page  
    When android user click on back button
    Then android user navigates to payment method page
    When android user selects a saved card "<cardLast4Digit>"
    Then android user select card from save card list
    Then CVV field should display to android user with the message
    And User enters the digits in CVV "<CVV>" fields
    When android user click on continue button for debit card
    Then android user observe the parameter on Review screen for buy currency 
    When android user click on Confirm and pay button from Review screen
    Then deal confirmation screen should be displayed with correct mapped details for buy currency fx in android app
      Examples: 
      | emailAddress        | password          | currency   | sellCurrency |amount | cardLast4Digit |CVV | 
      | TorFxWalletListUser | TorFxRegEmailPass | USD        |   GBP        |180.00 | 8453           | 555| 
      
      @PAD-3396_TC70_AndroidMobTorFx 
    Scenario Outline: Buy currency-Fx To verify payment journey flow for add new card Non-3d Card with wrong cvv.
    Given android user installed the new TorFx app and launched successfully
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
    #Then android app dispalyed the error for entered wrong cvv  
     Examples: 
        | emailAddress       | password          | currency |  amount   |  cardLast4Digit|CVV   |sellCurrency | cardHolderName      |cardNumber        | expiryDate(MMYY) | issuedate | 
        | CVVFailedUser      | TorFxRegEmailPass | EUR      |   150.00  |  8453          | 125  | GBP         |Jack0990 Martin788   |6759649826438453  | 12/29            | 09/20     |   
     
      @PAD-3398_TC71_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx)12.22 To verify that clicking on back button of review screen user get navigate back on the payment method screen WITH PREVIOUS PAYMENT METHOD SELECTED i.e. Wallet
    Given android user installed the new TorFx app and launched successfully
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
    Then android user land on Payment Method screen
    Then android user select the payment method Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then android user observe the parameter on Review screen for buy currency 
    Then android user click on back button from review screen and get navigate back on the payment method screen
    And previously selected payment method Wallet should be displayed in android app on payment method screen
    Examples:
      | emailAddress         | password          | sellCurrency | currency  | amount   | 
      | TorFxWalletListUser  | TorFxRegEmailPass | GBP          |    USD    |250.00    |  
      
      @PAD-3398_TC72_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 12.23 To verify that clicking on back button of review screen user get navigate back on the payment method screen i.r. bank transfer
    WITH PREVIOUS PAYMENT METHOD SELECTED i.e. Bank transfer
    Given android user installed the new TorFx app and launched successfully
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
    When android user enter amount "<amount>" in selling currency wallet
    Then after two sec appropriate amount should be calculated in buy currency wallet in android app
    When android user click on the continue button for buy currency
    Then android user land on Payment Method screen
    Then android user select the payment method Bank Transfer
    Then continue button should get enabled for bank transfer in android app
    When android user click on continue button for bank transfer
    Then android user observe the parameter on Review screen for buy currency 
    Then android user click on back button from review screen and get navigate back on the payment method screen
    And previously selected payment method Bank Transfer should be displayed in android app on payment method screen
   Examples:
      | emailAddress         | password       | amount   | currency  | sellCurrency | 
      | TorFxWalletListUser  | TorFxRegEmailPass | 1,200.00 | USD       | GBP          | 
      
      @PAD-3398_TC73_AndroidMobTorFx 
    Scenario Outline: (Buy currency-Fx) 14.2 To verify that user is able to perform journey by using existing 3d card user land and on success page and data get mapped.
    Given android user installed the new TorFx app and launched successfully
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
    Then user should navigates to review page  
    Then android user observe the parameter on Review screen for buy currency 
    When android user click on Confirm and pay button from Review screen
    Then user land on 3d page
    Then android user click on submit from 3dsceure screen
    Then android user land on confirmation screen
    Then deal confirmation screen should be displayed with correct mapped details for buy currency fx in android app
      Examples: 
         | emailAddress      | password          | currency   | sellCurrency |amount | cardLast4Digit |CVV |cardLast4DigitUpdated | 
         | TorFxWalletList3d | TorFxRegEmailPass | EUR        |   GBP        |180.00 | 8453           | 555|      1111            | 
      
      @PAD-3398_TC74_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 14.2 To verify that user is able to perform journey by using add new 3d card user land and on success page and data get mapped. Done button is enabled and clickable
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
    And User enters the digits in CVV "<CVV>" fields
    When android user click on continue button for debit card
    Then android user observe the parameter on Review screen for buy currency 
    When android user click on Confirm and pay button from Review screen
    Then user land on 3d page
    Then android user click on submit from 3dsceure screen
    Then android user land on confirmation screen
    Then deal confirmation screen should be displayed with correct mapped details for buy currency fx in android app
    Then android user land on success page and click on Done button
    Then android user navigates to buy currency screen  
      Examples: 
         | emailAddress      | password          | currency   | sellCurrency |amount | cardLast4Digit |CVV |cardHolderName |cardNumber        | expiryDate(MMYY) | issuedate | 
         | TorFxWalletList3d | TorFxRegEmailPass | EUR        |   GBP        |180.00 | 8453           | 555| 3d            |6759649826438453  | 12/29            | 09/20     |   
        
    @PAD-3392_TC75_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut)6.2.1 6.2.3 To verify when user navigates to the send from wallet page, 
    1000  amount should be display by default When available wallet balance is > 1000, user able to select the amount field and enter the amount.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    Then bydefault 1000 amount should be displayed for send from wallet in android app
    When android user enters amount "<amount>" for send from wallet
    Then android user able to enter amount for send from wallet
    Examples:
      | emailAddress         | password       | currency  | amount    |  
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR       |250.00     |  
          
    @PAD-3392_TC76_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut)6.3 To verify error observed, when user enters more than available balance in selected wallet on “Send from wallet” screen.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user enters amount "<amount>" for send from wallet
    When android user click on continue send button
    Then send error message should be dislayed in android app
    Examples:
      | emailAddress         | password       | currency  | amount       |  
      | TorFxWalletListUser  | TorFxRegEmailPass | AUD       |90000.00      |   
       
      @PAD-3392_TC77_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut)6.6 To verify on “Select Recipient” page, user tap on Device back button then it redirect user back to “Send from wallet” screen.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user enters amount "<amount>" for send from wallet
    When android user click on continue send button
    Then android user should land on select recipient screen
    When android user presses device back button
    Then android user navigates to send from wallet page   
      Examples:
        | emailAddress         | password          | currency  | amount    | 
        | TorFxWalletListUser  | TorFxRegEmailPass | EUR       |120.00     | 
        
      @PAD-3392_TC78_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut) 6.6 To verify on “Select Recipient” page, user tap on back arrow button on app, then it redirect user back to “Send from wallet” screen.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user enters amount "<amount>" for send from wallet
    When android user click on continue send button
    Then android user should land on select recipient screen
    When android user click on back button
    Then android user navigates to send from wallet page   
     Examples:
      | emailAddress         | password          | currency  | amount    |  
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR       |120        | 
      
    @PAD-3392_TC79_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut)6.9, 6.11, 6.15 To verify when the user tap on “Add new recipient” button on “Select Recipient” page, then 
    user should land on “Add recipient” page to perform the add recipient journey.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user click on continue send button
    Then android user should land on select recipient screen
	  And android user selects an option to add a new recipient
    Then add recipient screen should be displayed to android user
    When android user selects "<Type>" and enters recipient name "<recipientName>"
    And android user selects country dropdown
    Then list of available country should be displayed in android app
    And android user should be able to select country "<country>" by using search option
    When android user enters valid account number "<accountNumber>"
    Then bank details should be fetched in android app
    Then the continue button to save the recipient should be in an enabled state in android app
    When android user clicks on continue button
    Then OTP page should be displayed to android user
    When android user enters valid otp "<emailAddress>"
    Then android user land on Payment Method screen    
    Examples:
      | emailAddress         | password          | currency |Type      | recipientName | country  |  accountNumber                |  
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR      |Individual| Samie Will    | France   | FR1420041010050500013M02606   | 
      
    @PAD-3392_TC80_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut) 6.7,6.8  To verify on Recipient page buy currency recipient list displayed. User is alllowed to select recipient from recipient list and proceed to next (payment method) page
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user click on continue send button
    Then android user should land on select recipient screen
	  And only buy currency "<buyCurrency>" recipients list should be displayed to android user
	  And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
	  Then android user land on Payment Method screen
    Examples:
      | emailAddress         | password          | currency  |recipientName | accountNumber                 | 
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR       |Jack Smith    | FR1420041010050500013M02606   | 
      
    @PAD-3392_TC81_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut)6.13 To verify after tap on back(arrow) button or device back button on “Payment method” page, user should be navigate back to the “Select Recipient” page successfully.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user click on continue send button
    Then android user should land on select recipient screen
	  And only buy currency "<buyCurrency>" recipients list should be displayed to android user
	  And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
	  Then android user land on Payment Method screen
	  When android user presses device back button
	  Then android user should land on select recipient screen
	   Examples:
      | emailAddress         | password          | currency  |recipientName | accountNumber                 | 
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR       |Jack Smith    | FR1420041010050500013M02606   | 
      
    @PAD-3392_TC82_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut)6.14 To verify after tap on back button from “Payment method” page, user should be navigate back to the “Select Recipient” page.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen 
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user click on continue send button
    Then android user should land on select recipient screen
	  And only buy currency "<buyCurrency>" recipients list should be displayed to android user
	  And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
	  Then android user land on Payment Method screen
	  When android user clicks on back arrow from payment method screen
	  Then android user should land on select recipient screen
    Examples:
      | emailAddress         | password          | currency  |recipientName | accountNumber               |  
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR       |Jack Smith    | FR1420041010050500013M02606 | 
      
      @PAD-3392_TC83_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut)6.17,7.3 To verify on “Payment method” page “Continue” button disable when user not select the Payment reason.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user enters amount "<amount>" for send from wallet
    When android user click on continue send button
    Then android user should land on select recipient screen
	  And only buy currency "<buyCurrency>" recipients list should be displayed to android user
	  And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
	  Then android user land on Payment Method screen
	  And android user do not select payment reason Wallet
	   Then wallet continue button should get disabled for wallet in android app
    Examples:
      | emailAddress       | password          | currency  |amount |buyCurrency| recipientName | accountNumber               |  
      | TorFxWalletListUser| TorFxRegEmailPass | EUR       |450    |EUR        | Jack Smith    | FR1420041010050500013M02606 | 
      
    @PAD-3392_TC84_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut)6.18,7.4 To verify on “Payment method” page user select the payment reason and tap on “Continue” button, 
    user navigates to the “Review” page successfully
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user click on continue send button
    Then android user should land on select recipient screen
	  And only buy currency "<buyCurrency>" recipients list should be displayed to android user
	  And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
	  Then android user land on Payment Method screen
	  And android user select payment reason Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then user should navigates to review page
      Examples:
        | emailAddress        | password          | currency  |buyCurrency| recipientName | accountNumber                 | 
        | TorFxWalletListUser | TorFxRegEmailPass | EUR       |EUR        |  Jack Smith   | FR1420041010050500013M02606   | 
      
    @PAD-3399_TC85_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut)6.19, 6.20 To verify on “Review” page payment details should be display details that selected in previous steps.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user enters amount "<amount>" for send from wallet
    When android user click on continue send button
    Then android user should land on select recipient screen
    And only buy currency "<buyCurrency>" recipients list should be displayed to android user
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen
    And android user select payment reason Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then android user observe the parameter on Review screen send wallet 
     Examples:
      | emailAddress         | password          | currency  |  amount  | buyCurrency| recipientName | accountNumber              |  
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR       |  5.00    |      EUR   | Jack Smith    | FR1420041010050500013M02606| 
      
    @PAD-3392_TC86_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut)6.22 To verify “T&C” page gets close after tap on back (arrow) button or device back button.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user click on continue send button
    Then android user should land on select recipient screen
	  And only buy currency "<buyCurrency>" recipients list should be displayed to android user
	  And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
	  Then android user land on Payment Method screen
	  And android user select payment reason Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then user should navigates to review page
    Then android user click on terms and condition link to send wallet
    Then window should open with a link to the respective UK T's & C in android app
    When android user click on back button or the device back button on UK T's & C window
    Then android user click on back button from terms and condition and lands back to review screen
     Examples:
      | emailAddress         | password          | currency  |buyCurrency| recipientName | accountNumber                 | 
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR       |EUR        |  Jack Smith   | FR1420041010050500013M02606   | 
      
      @PAD-3399_TC87_AndroidMobTorFx
    Scenario Outline: (Standalone paymentOut)16.23, 6.24, 6.25 Wallet Send-To verify that when the user is on Confirmation screen 
    the payment execution date, recipient details and payment details
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    Then android user navigates to send from wallet page
    When android user enters amount "<amount>" for send from wallet
    When android user click on continue send button
    Then android user should land on select recipient screen
    And only buy currency "<buyCurrency>" recipients list should be displayed to android user
    And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
    Then android user land on Payment Method screen
    And android user select payment reason Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then android user observe the parameter on Review screen send wallet 
    And android user click on Confirm and pay button from Review screen
    Then deal confirmation screen should be displayed with correct mapped details wallet send in android app 
     Examples:
      | emailAddress         | password          | currency  |  amount  | buyCurrency| recipientName |  accountNumber              |  
      | TorFxWalletListUser  | TorFxRegEmailPass | EUR       |  5.00    |    EUR     | Jack Smith    | FR1420041010050500013M02606 | 
      
    @PAD-3392_TC88_AndroidMobTorFx @TorFxSanity @TorFxregression
    Scenario Outline: (Standalone paymentOut) 6.30 To verify user navigate to the wallet screen after tap on “Done” button.
    Given android user installed the new TorFx app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user click on the wallet option from the home dashboard
    And android user click on wallet currency "<currency>" from wallet screen
    Then send button should displayed in enabled state in android app
    When android user click on send button in android app
    When android user enters amount "<amount>" for send from wallet
    Then android user navigates to send from wallet page
    When android user click on continue send button
    Then android user should land on select recipient screen
	  And only buy currency "<buyCurrency>" recipients list should be displayed to android user
	  And the android user selects a saved recipient based on account number "<accountNumber>"recipientName"<recipientName>" and currency "<currency>"
	  Then android user land on Payment Method screen
	  And android user select payment reason Wallet
    Then continue button should get enabled for wallet in android app
    When android user click on continue button for wallet
    Then user should navigates to review page
    And android user click on Confirm and pay button from Review screen
    Then android user land on confirmation screen
    Then android user land on success page and click on Done button
    Then android user navigates to "<currency>" wallet  screen
     Examples:
      | emailAddress        | password          | currency  |amount |buyCurrency| recipientName | accountNumber                | 
      | TorFxWalletListUser | TorFxRegEmailPass | EUR       |02.00  |EUR        | Jack Smith    | FR1420041010050500013M02606  | 
      
         @PAD-3646_TC89_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn) 8.11 To verify that when user click on back option from 3d page then payment cancellation poup up  observed 
    Given android user installed the new TorFx app and launched successfully
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
    Then user land on 3d page
    When android user presses device back button
    Then cancel payment confirmation popup displayed on android device  
     Examples: 
       | emailAddress        | password          | currency |  amount   |  cardLast4Digit|CVV   | 
       | TorFxWalletList3d   | TorFxRegEmailPass | EUR      |   150.00  |  8453          | 555  |    
    
    @PAD-3646_TC90_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn) 8.11 To verify that when user click on dont cancel option from 3d page then user remain on 3d page
    Given android user installed the new TorFx app and launched successfully
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
    Then user land on 3d page
    When android user presses device back button
    Then cancel payment confirmation popup displayed on android device 
    When androd user clicks on dont cancel link
     Then user land on 3d page
     Examples: 
       | emailAddress           | password          | currency |  amount   |  cardLast4Digit| CVV  | 
       | TorFxWalletList3d      | TorFxRegEmailPass | EUR      |  150.00   |  8453          | 555  |    
     
     @PAD-3646_TC91_AndroidMobTorFx
    Scenario Outline: (Standalone PaymentIn) 8.11 To verify that when user click on yes cancel from 3d page then payment should be cancelled 
    Given android user installed the new TorFx app and launched successfully
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
    Then user land on 3d page
    When android user presses device back button
    Then cancel payment confirmation popup displayed on android device 
    When androd user clicks on yes cancel link
    Then android app dispalyed payment cancelled scrren
     Examples: 
       | emailAddress      | password          | currency |  amount   |  cardLast4Digit| CVV   | 
       | TorFxWalletList3d | TorFxRegEmailPass | EUR      |   150.00  |  8453          | 555   | 
       
       @PAD-3398_TC92_AndroidMobTorFx
    Scenario Outline: (Buy currency-Fx) 14.2 To verify that user is able to perform journey by using add new 3d card user land and on success page and data get mapped. Done button is enabled and clickable
    Given android user installed the new TorFx app and launched successfully
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
    And User enters the digits in CVV "<CVV>" fields
    When android user click on continue button for debit card
    Then android user observe the parameter on Review screen for buy currency 
    When android user click on Confirm and pay button from Review screen
    Then user land on 3d page
    When android user presses device back button
    Then cancel payment confirmation popup displayed on android device 
    When androd user clicks on dont cancel link
    Then user land on 3d page
    Then android user click on submit from 3dsceure screen
    Then android user land on confirmation screen
    Then deal confirmation screen should be displayed with correct mapped details for buy currency fx in android app
     Examples: 
        | emailAddress      | password          | currency   | sellCurrency |amount | cardLast4Digit |CVV |cardHolderName |cardNumber        | expiryDate(MMYY) | issuedate | 
        | TorFxWalletList3d | TorFxRegEmailPass | EUR        |   GBP        |180.00 | 8453           | 555| 3d            |6759649826438453  | 12/29            | 09/20     |   
   

         
 