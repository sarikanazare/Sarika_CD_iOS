@CD_Account
Feature: To test account functionality

  @CD_Account_TC_01 @Acc_lot1
  Scenario Outline: To verify that when user click on account button then user should be land on account screen
    #Given ios user launched already installed CD app successfully
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress     | password        |
      | CDAuthorisedSIT3 | CDRegEmailPass1 |

  @CD_Account_TC_02 @Acc_lot1
  Scenario Outline: To verify that personal details screen should be displayed when user click on personal details button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on personal details button
    Then personal details screen should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_03 @Acc_lot1
  Scenario Outline: To verify that bank details screen should be displayed when user click on our bank details button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on our bank details button
    Then bank details currency selection screen should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_04 @Acc_lot1
  Scenario Outline: To verify that help and support screen should be displayed when user click on help and support button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on help and support button
    Then help and support screen should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_05 @Acc_lot1
  Scenario Outline: To verify that manage device screen should be displayed when user click on manage device button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on manage device button
    Then manage device screen should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_06 @Acc_lot1
  Scenario Outline: To verify that my cards screen should be displayed when user click on debit cards button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on debit cards button
    Then debit cards screen should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_07 @Acc_lot1
  Scenario Outline: To verify that biometric setup process should be enabled when user click on touch id ON/OFF
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on touch id ON/OFF button
    Then biometric setup process should be enabled

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_08 @Acc_lot1
  Scenario Outline: To verify that user able to logout the app when user click on logout then user should be land on confirm logout screen
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on logout button
    Then confirm logout screen should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_09 @Acc_lot1
  Scenario Outline: To verify customer name should be displayed when user click on personal details button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on personal details button
    Then personal details screen should be displayed
    And customer name should be displayed on personal details screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_10 @Acc_lot1
  Scenario Outline: To verify customer id should be displayed when user click on personal details button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on personal details button
    Then personal details screen should be displayed
    And customer id should be displayed on personal details screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_11
  Scenario Outline: To verify customer email address should be displayed when user click on personal details button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on personal details button
    Then personal details screen should be displayed
    And customer email address should be displayed on personal details screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_12
  Scenario Outline: To verify customer phone number should be displayed when user click on personal details button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on personal details button
    Then personal details screen should be displayed
    And customer phone number should be displayed on personal details screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_13
  Scenario Outline: To verify customer address should be displayed when user click on personal details button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on personal details button
    Then personal details screen should be displayed
    And customer address should be displayed on personal details screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_14
  Scenario Outline: To verify our bank details screen options when user click on our bank details button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on our bank details button
    Then search option should be displayed on our bank details screen
    And list of currencies should be displayed on our bank details screen
    And close icon should be displayed on our bank details screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_15
  Scenario Outline: To verify that when user click on close button on our bank details screen then user should be land on account screen
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on our bank details button
    Then bank details currency selection screen should be displayed
    When ios user click on close button
    Then account screen should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_16
  Scenario Outline: To verify currency list should be filtered with no matching options along with no result message should be displayed on bank details screen
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on our bank details button
    Then bank details currency selection screen should be displayed
    When ios user enters currency name "<currencyName>" in search option
    Then empty state currency list should be displayed in ios app along with no result message on bank details window

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | currencyName |
      | CDRegEmailId28 | CDRegEmailPass1 | KKK          |

  @CD_Account_TC_17
  Scenario Outline: To verify if user tap on   icon on search tab, the filter value get clear and whole list should be display
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on our bank details button
    Then bank details currency selection screen should be displayed
    When ios user enters currency name "<currencyName>" in search option
    Then ios app user clears the text entered in search bar by clicking the close button

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | currencyName |
      | CDRegEmailId28 | CDRegEmailPass1 | gif          |

  @CD_Account_TC_18
  Scenario Outline: To verify that user should able to search the currency name
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on our bank details button
    Then bank details currency selection screen should be displayed
    When ios user enters currency name "<currencyName>" in search option
    Then matching currency should be displayed in search result of ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | currencyName |
      | CDRegEmailId28 | CDRegEmailPass1 | GBP          |

  @CD_Account_TC_19
  Scenario Outline: To verify searched currency should be selected and landed on currency bank details screen
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on our bank details button
    Then bank details currency selection screen should be displayed
    When ios user enters currency name "<currencyName>" in search option
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list
    Then ios user should be land on currency bank details screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | currencyName |
      | CDRegEmailId28 | CDRegEmailPass1 | USD          |

  @CD_Account_TC_20
  Scenario Outline: To verify bank details should be displayed when user land on currency bank details screen
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on our bank details button
    Then bank details currency selection screen should be displayed
    When ios user enters currency name "<currencyName>" in search option
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list
    Then ios user should be land on currency bank details screen
    And bank details should be displayed on bank details screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | currencyName |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR          |

  @CD_Account_TC_21 @CD_iOS_sanity
  Scenario Outline: To verify bank details screen should be displayed when ios user click back button on currency bank details screen
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on our bank details button
    Then bank details currency selection screen should be displayed
    When ios user enters currency name "<currencyName>" in search option
    Then matching currency should be displayed in search result of ios app
    When ios user selects the currency from searched result list
    Then ios user should be land on currency bank details screen
    When ios user clicks on back button
    Then bank details currency selection screen should be displayed

    #When ios user removes account by using manage device option from account screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | currencyName |
      | CDRegEmailId28 | CDRegEmailPass1 | EUR          |

  @CD_Account_TC_22
  Scenario Outline: To verify user should be land on account screen when user click close button on help and support button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on help and support button
    Then help and support screen should be displayed
    When ios user click on close button
    Then account screen should be displayed in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_23
  Scenario Outline: To verify header and close icon should be displayed when user click on help and support button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on help and support button
    Then help and support screen should be displayed
    And header and close icon should be displayed on help and support screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_24
  Scenario Outline: To verify that remove account button should be displayed when user click on manage device button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on manage device button
    Then manage device screen should be displayed
    And remove account button should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_25
  Scenario Outline: To verify that confirmation pop up message should be displayed when user click on remove account button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on manage device button
    Then manage device screen should be displayed
    And remove account button should be displayed
    When ios user click on remove account button
    Then confirmation pop up message should be displayed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_26
  Scenario Outline: To verify user should be land on login screen when user click on reset button on confirmation screen
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on manage device button
    Then manage device screen should be displayed
    And remove account button should be displayed
    When ios user click on remove account button
    Then confirmation pop up message should be displayed
    When ios user click on reset button
    Then ios user should be land on login screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_27
  Scenario Outline: To verify that confirmation pop up message should be closed when user click on cancle button
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on manage device button
    Then manage device screen should be displayed
    And remove account button should be displayed
    When ios user click on remove account button
    Then confirmation pop up message should be displayed
    When ios user click on cancle button
    Then remove account button should be displayed on manage device screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        |
      | CDRegEmailId28 | CDRegEmailPass1 |

  @CD_Account_TC_28
  Scenario Outline: To verify when user click on specified question it should be expand and collapsed
    Given ios user installed the new CD app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user provides Username "<emailAddress>" and Password "<password>"
    Then ios app login button should be enabled to submit the credentials
    When ios user click on the login button
    And ios user skip the biometric credentials for the app
    And ios user click on account button
    Then account screen should be displayed
    When ios user click on help and support button
    Then help and support screen should be displayed
    When ios user click on specified question "<question>" for expansion
    Then specified question should expanded
    When ios user again click on specified question "<question>" for collapse
    Then specfied question should collapsed

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress   | password        | question                  |
      | CDRegEmailId28 | CDRegEmailPass1 | How do I make a transfer? |
