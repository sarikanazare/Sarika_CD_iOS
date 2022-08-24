Feature: To check 3dS1 and 3dS2 card functionality :

  @CD_3dS2_Authorised
  Scenario Outline: To verify that new 3d card user land on “3dS2page” post submitting the review page
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
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
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    #And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    #Then ios user should land on threedStwo page
    Then threedStwo page should not be dislayed to ios user
    #When ios user submits threedStwo card otp "<otp>"response
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    Examples: 
      | emailAddress      | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment | otp  |
      #| CDAuthorisedSIT4 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  | 12345675  | ABA          | 083900363 | AUTHORISED     | 4000000000001000 | 1120            | 1125             | 555 | Bill payments | Test-Reference | SIT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000001005 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001091 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000001096 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |

  @CD_3dS1_Authorised
  Scenario Outline: To verify that new 3d card user land on “3dS1page” post submitting the review page
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
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
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    #When ios user selects a saved card "<cardNumber>"
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then ios user should land on threedSone page
    When ios user submits threedSone card otp "<otp>"response
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    Examples: 
      | emailAddress      | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment | otp  |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000098 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |

  # | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000002 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         | 1234 |
  # | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000007 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
  # | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000093 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
  # | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000098 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
  @CD_3dS1_Authorised_CVV
  Scenario Outline: To verify that new 3d card functionality by entering valid cvv and user land on “3dS1page” post submitting the review page
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
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
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    #When ios user selects a saved card "<cardNumber>"
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then ios user should land on threedSone page
    When ios user submits threedSone card otp "<otp>"response
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    Examples: 
      | emailAddress      | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment | otp  |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000002 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000007 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000002 |            1120 |             1125 | 222 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000007 |            1120 |             1125 | 222 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000002 |            1120 |             1125 | 333 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000007 |            1120 |             1125 | 333 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000002 |            1120 |             1125 | 444 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000007 |            1120 |             1125 | 444 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000002 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000007 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000093 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000098 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000093 |            1120 |             1125 | 222 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000098 |            1120 |             1125 | 222 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000093 |            1120 |             1125 | 333 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000098 |            1120 |             1125 | 333 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000093 |            1120 |             1125 | 444 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000098 |            1120 |             1125 | 444 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000093 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000000098 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         | 1234 |

  @CD_3dS2_Authorised_CVV
  Scenario Outline: To verify that new 3d card functionality by entering valid cvv and user land on “3dS2page” post submitting the review page
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
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
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    #And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    #Then ios user should land on threedStwo page
    Then threedStwo page should not be dislayed to ios user
    #When ios user submits threedStwo card otp "<otp>"response
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    Examples: 
      | emailAddress      | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment | otp  |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001000 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000001005 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001000 |            1120 |             1125 | 222 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000001005 |            1120 |             1125 | 222 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001000 |            1120 |             1125 | 333 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000001005 |            1120 |             1125 | 333 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001000 |            1120 |             1125 | 444 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000001005 |            1120 |             1125 | 444 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001000 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000001005 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001091 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000001096 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001091 |            1120 |             1125 | 222 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000001096 |            1120 |             1125 | 222 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001091 |            1120 |             1125 | 333 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000001096 |            1120 |             1125 | 333 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001091 |            1120 |             1125 | 444 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000001096 |            1120 |             1125 | 444 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000001091 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         | 1234 |
      | CDUATRegEmailId20 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 5200000000001096 |            1120 |             1125 | 555 | Bill payments | Test-Reference | UAT         | 1234 |

  @CD_3dS1_Authorised_AddressPostCode
  Scenario Outline: To verify that new 3d card functionality by address post code and user land on “3dS1page” post submitting the review page
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
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
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    #When ios user selects a saved card "<cardNumber>"
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then ios user should land on threedSone page
    When ios user submits threedSone card otp "<otp>"response
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    Examples: 
      | emailAddress      | password        | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName   | country | currency | address | accountNo | bankCodeType | bankCode  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference      | environment | otp  |
      | CDUATRegEmailId21 | CDRegEmailPass1 | EUR            | GBP             | 200.00 | Individual    | Andrew Peterson | Albania | GBP      | USAAdd  |  12345675 | ABA          | 083900363 | AUTHORISED     | 4000000000000002 |            1120 |             1125 | 111 | Bill payments | Test-Reference | UAT         | 1234 |

  @CD_3dS2_Authorised_AddressPostCode
  Scenario Outline: To verify that new 3d card functionality by address post code and user land on “3dS1page” post submitting the review page
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
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
    And card "<cardNumber>" details should be saved in ios app debit card payment method list
    When ios user selects saved card "<cardNumber>" to make a transfer
    #When ios user selects a saved card "<cardNumber>"
    And ios user enters cvv "<cvv>"
    And ios user selects payement reason "<paymentReason>"
    And ios user enters payment reference "<reference>"
    And ios user click on continue button
    Then ios user should navigate to review screen
    And all the deal details should be displayed on ios deal review screen
    When ios user submits the review page details
    Then ios user should land on threedSone page
    When ios user submits threedSone card otp "<otp>"response
    Then deal confirmation screen should be displayed with correct mapped details in ios app

    Examples: 
      | emailAddress | password | youPayCurrency | theyGetCurrency | amount | recipientType | recipientName | country | currency | address | accountNo | bankCodeType | bankCode | cardHolderName | cardNumber | issueDate(MMYY) | expiryDate(MMYY) | cvv | paymentReason | reference | environment | otp |
