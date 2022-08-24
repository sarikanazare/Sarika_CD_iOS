@TorFX_DebitCard
Feature: My Card

  @TorFX_PID-3519_TC99 @Mycard1
  Scenario Outline: 2.1 To verify empty debit cards screen with add debit card option.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    Then ios user should navigate to debit card screen
    When ios user has not saved any cards previously
    Then an empty state screen should be displayed to ios user with an option to add a new card

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId07 | CDRegEmailPass1 |

  @TorFX_PID-3519_TC100 @Mycard1
  Scenario Outline: 2.5 To check that user navigates to main account screen when user closes the debit card screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    When ios user selects the close button
    Then ios user should return to the account screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId03 | CDRegEmailPass1 |

  @TorFX_PID-3521_TC101 @Mycard1
  Scenario Outline: 4.1 3.3 To verify pre populated card holder name and billing address is as per logged in user and card details are blank on add card screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    And card details should be blank to ios user
    And pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress                        |
      | TorRegEmailId07 | CDRegEmailPass1 | Torfxuser uatios   | 279 H Hays Rd,Karabeal,Australia,3294 |

  # | CDRegEmailId2 | CDRegEmailPass  | Jerin Quad         | 27 N Main St Ste 1,Florida,USA,10921-1355 |
  #  | CDAddPayee    | CDRegEmailPass1 | Lincoln Cgomes     | Ben Lomond Rd,Ben Lomond,Australia,2365   |
  #Billing Address : Street,City,Country,Post code
  @TorFX_PID-3521_TC102 @Torfx_iOS_sanity
  Scenario Outline: To verify application allow user to add debit card with the last name which matches with available contacts last name of the account
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    And pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to debit card screen
    And card "<cardNumber>" details should be saved in ios app debit card list as per order of date added

    #When ios user removes account by using manage device option from debit cards screen
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 6759649826438453 |            1120 |             1125 |

  #  | IOSDeviceUdId | IosAppVersion| CDRegEmailId4 | CDRegEmailPass | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | Wilson  Thompson | 5454545454545454 |            1120 |             1125 |
  # VISA Master Maestro 3D need to add
  @TorFX_PID-3519_TC103 @Mycard1
  Scenario Outline: 2.2 To verify all the saved cards list is displayed in the order of date added with option to add a new card
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    Then ios user should navigate to debit card screen
    When ios user has one or more saved cards
    Then all saved cards list should be displayed in order of date added with option add a new card to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId03 | CDRegEmailPass1 |

  @TorFX_PID-3519_TC104 @Mycard1
  Scenario Outline: 2.3 To verify list of saved cards number is masked except last four digits in accordance with PCI-DSS requirements
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    Then ios user should navigate to debit card screen
    When ios user has one or more saved cards
    Then saved cards number should be masked except last four digits in ios app accordance with PCI-DSS requirements

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId03 | CDRegEmailPass1 |

  @TorFX_PID-3614_TC105 @Mycard1
  Scenario Outline: To verify save button is disabled when user clicks on edit address link.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then the option to save the card should be in an inactive/disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | cardHolderName | cardNumber       | issueDate(MMYY) | expDate(MMYY) | country | Address |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro   | 6759649826438453 |            1120 |          1125 | USA     | USAAdd  |

  @TorFX_PID-3519_3612_TC106 @Mycard1
  Scenario Outline: 2.4 3.1 3.3 To verify all the details of a selected card has been displayed in a new screen
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    And pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to debit card screen
    When ios user has one or more saved cards
    Then selected saved card details name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>" should be displayed in ios app card view screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 6759649826438453 |            1120 |             1125 |

  #  | CDRegEmailID34 | CDRegEmailPass1 | Lincoln Cgomes     | Ben Lomond Rd,Ben Lomond,Australia,2365 | Smith          | 6759649826438453 |            1120 |             1125 |
  # | CDRegEmailID33 | CDRegEmailPass  | Lincoln Cgomes     | Ben Lomond Rd,Ben Lomond,Australia,2365 | Lincoln        | 5454545454545454 |            1120 |             1125 |
  # Not Yet Developed, once functionality developed  we will check feasibility
  @TorFX_PID-3521_TC107
  Scenario Outline: 4.2 To check option to scan the card details
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then option to scan the card details should be available to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId03 | CDRegEmailPass1 |

  # Not Yet Developed, once functionality developed  we will check feasibility
  @TorFX_PID-3521_TC108
  Scenario Outline: 4.3 To check that scan card process gets triggered when user selects scan card option
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then option to scan the card details should be available to ios user
    When ios user selects to scan the card details
    Then the scan card process should be triggered in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId03 | CDRegEmailPass1 |

  # Not Yet Developed, once functionality developed  we will check feasibility
  @TorFX_PID-3521_TC109
  Scenario Outline: 4.4 To verify scanned card details should be displayed in the relevant fields
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then option to scan the card details should be available to ios user
    When ios user selects to scan the card details
    Then the scan card process should be triggered in ios app
    When card has been scanned in ios app
    Then scanned card details should be displayed in the relevant fields to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId03 | CDRegEmailPass1 |

  @TorFX_PID-3521_TC110 @Mycard1
  Scenario Outline: 4.5 To verify save card button is disabled and card holder name required error message gets displayed when user removes the pre populated cardholder name.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user removes provided card holder name
    Then card holder name required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 6759649826438453 |            1120 |             1125 |

  @TorFX_PID-3521_TC111 @Mycard1
  Scenario Outline: 4.5 To verify save card button is in disabled state and card number required error message displayed when user removes the card number.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user removes provided card number
    Then card number required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 6759649826438453 |            1120 |             1125 |

  @TorFX_PID-3521_TC112 @Mycard1
  Scenario Outline: 4.5 To verify save card button is enabled state when user removes the entered issue date
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user removes provided issue date
    Then the option to save the card should be in active/enabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       |                | Samsss Petro   | 6759649826438453 |            1120 |             1125 |

  #Expirey date required error message not implemented
  @TorFX_PID-3521_TC113
  Scenario Outline: 4.5 To verify save card button is disabled expiry date required erroer message displayed when user removes the entered expiry date
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user removes provided expiry date
    Then expiry date required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 6759649826438453 |            1120 |                  |

  @TorFX_PID-3521_TC114 @Mycard2
  Scenario Outline: 4.6 To verify save card button is enabled when user provides the all valid card details
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    Then the option to save the card should be in active/enabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 6759649826438453 |            1120 |             1125 |

  @TorFX_PID-3521_TC115 @Mycard2
  Scenario Outline: 4.7 4.8 4.9 4.10 To check that user is able to save card details with valid data and saved card displays in top of the card list
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to debit card screen
    And card "<cardNumber>" details should be saved in ios app debit card list as per order of date added

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 6759649826438453 |            1120 |             1125 |

  #| CDAddPayee    | CDRegEmailPass1 | Lincoln Cgomes     | Ben Lomond Rd,Ben Lomond,Australia,2365 | Andrew Cgomes    |    6759649826438453 |            1120 |             1125 |
  #| CDRegEmailId4 | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116            | Peter Thompson   |    5555555555554444 |            0420 |             0128 |
  #| CDRegEmailId4 | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116            | William Thompson | 4917610000000000003 |            1020 |              925 |
  #PID-4613 Jira raised pending from development side for issue date
  @TorFX_PID-3521_TC116 @Mycard2
  Scenario Outline: To check that user is able to save card details without entering issue date as it is optional field.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user removes provided issue date
    Then the option to save the card should be in active/enabled state in ios app
    When ios user clicks on save
    Then ios user should navigate to debit card screen
    #And card "<cardNumber>" details should be saved in ios app debit card list as per order of date added
    #commenting above line as it verifying card details
    Then ios user should navigate to debit card screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 6759649826438453 |            1120 |             1125 |

  #| CDAddPayee     | CDRegEmailPass1 | Lincoln Cgomes     | Ben Lomond Rd,Ben Lomond,Australia,2365 | Andrew Cgomes  | 6759649826438453 |            1120 |             1125 |
  @TorFX_PID-3521_TC117 @Mycard2
  Scenario Outline: 4.11 To verify invalid expiry date error message when user enters past date as expiry date
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides invalid expiry date "<pastExpiryDate(MMYY)>"
    Then invalid expiry date error message should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | pastExpiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b |                 1104 |

  #| CDRegEmailId4 | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116            |                 1120 |
  #| CDAddPayee    | CDRegEmailPass1 | Lincoln Cgomes     | Ben Lomond Rd,Ben Lomond,Australia,2365 |                 1120 |
  #Improper error message observed "Card number should be 12-19 digits long"
  @TorFX_PID-3521_TC118 @Mycard2
  Scenario Outline: 4.11 To verify invalid card number error validation message
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides invalid card number "<invalidCardNumber>"
    Then invalid card number error message should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | invalidCardNumber |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b |  1256464899651246 |

  @TorFX_PID-3521_TC119 @Mycard2
  Scenario Outline: 4.11 To verify that application displays error message when last name does not match with the account contacts last name
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides invalid unmatched contacts last name "<unmatchedLastName>"
    Then invalid last name error message should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | unmatchedLastName |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Ganesh Vitkar     |

  #| CDAddPayee     | CDRegEmailPass1 | Lincoln Cgomes     | Ben Lomond Rd,Ben Lomond,Australia,2365 | Thompson Pedro    |
  @TorFX_PID-3521_TC120 @Mycard2
  Scenario Outline: 4.11 To verify invalid issue date validation error message
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides invalid issue date "<issueDate(MMDD)>"
    Then invalid issue date error message should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | issueDate(MMDD) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b |            0225 |

  @TorFX_PID-3612_TC121 @Mycard2
  Scenario Outline: 3.7 To verify all the details of a selected card has been displayed with an option to delete the card
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    And pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to debit card screen
    When ios user has one or more saved cards
    Then selected saved card details name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>" should be displayed in ios app card view screen
    And an option to delete the card should be available to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 5454545454545454 |            1120 |             1125 |

  #| CDAddPayee    | CDRegEmailPass1 | Lincoln Cgomes     | Ben Lomond Rd,Ben Lomond,Australia,2365 | Andrew Cgomes  | 6759649826438453 |            1120 |             1125 |
  @TorFX_PID-3612_TC122 @Mycard2
  Scenario Outline: 3.8 To verify delete card confirmation alert view and message
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    And pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to debit card screen
    And selected saved card details name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>" should be displayed in ios app card view screen
    And an option to delete the card should be available to ios user
    When ios user clicks on delete
    Then an alert view should be displayed to confirm the delete card action in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 5454545454545454 |            1120 |             1125 |

  #| CDAddPayee    | CDRegEmailPass1 | Lincoln Cgomes     | Ben Lomond Rd,Ben Lomond,Australia,2365 | Andrew Cgomes   | 6759649826438453 |            1120 |             1125 |
  @TorFX_PID-3612_TC123 @Mycard2
  Scenario Outline: 3.11 To verify that user stays on selected card view screen when user dismiss the delete card confirmation alert.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    And pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to debit card screen
    And selected saved card details name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>" should be displayed in ios app card view screen
    And an option to delete the card should be available to ios user
    When ios user clicks on delete
    Then an alert view should be displayed to confirm the delete card action in ios app
    When ios user cancels the action
    Then ios user should be on same selected card view screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 5454545454545454 |            1120 |             1125 |

  #| CDAddPayee    | CDRegEmailPass1 | Lincoln Cgomes     | Ben Lomond Rd,Ben Lomond,Australia,2365 | Andrew Cgomes    | 6759649826438453 |            1120 |             1125 |
  @TorFX_PID-3612_TC124 @Mycard2
  Scenario Outline: 3.9 3.10 To verify that system allow user to save and delete the card from the saved card list.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    And pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on save
    Then ios user should navigate to debit card screen
    #And card "<cardNumber>" details should be saved in ios app debit card list as per order of date added
    And selected saved card details name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>" should be displayed in ios app card view screen
    And an option to delete the card should be available to ios user
    When ios user clicks on delete
    When ios user confirms the action
    Then ios user should navigate to debit card screen
    And the selected card "<cardNumber>" should be deleted from the list of saved cards for ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 5454545454545454 |            1120 |             1125 |

  #| CDAddPayee     | CDRegEmailPass1 | Lincoln Cgomes     | Ben Lomond Rd,Ben Lomond,Australia,2365 | Andrew Cgomes  | 6759649826438453 |            1120 |             1125 |
  @TorFX_Sanit_0050 @Mycard2
  Scenario Outline: To verify user able to delete the card by selecting existing card
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    Then ios user should navigate to debit card screen
    When ios user has one or more saved cards
    And ios user selects existing card number "<cardNumber>"
    And an option to delete the card should be available to ios user
    When ios user clicks on delete
    When ios user confirms the action
    Then ios user should navigate to debit card screen
    And the selected card "<cardNumber>" should be deleted from the list of saved cards for ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Samsss Petro   | 5454545454545454 |            1120 |             1125 |

  @TorFX_PID-3614_TC125 @Mycard3
  Scenario Outline: To verify add debit card functionality with manual address entry when user uses pre populated country value and rest of the address by using search option.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    When ios user searches for address "<searchAddress>" and select auto searched address
    #When ios user searches for address "<searchAddress>"
    #When ios user select searched address
    And ios user clicks on save

    #Then ios user should navigate to debit card screen
    #And card "<cardNumber>" details should be saved in ios app debit card list as per order of date added
    #commenting above line as it verifying card details
    #Then ios user should navigate to debit card screen
    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country                  | address |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b |         78728 | Samsss Petro   | 6759649826438453 |            1120 |             1125 | United States Of America | USAAdd  |

  @TorFX_PID-3614_TC126 @Mycard3
  Scenario Outline: To verify add debit card functionality with manual address entry when user uses prepopulated country and rest of the address enters by manually.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    When ios user selects country "<country>"
    When ios user clicks on enter address manually
    And ios user enters country specific required address "<address>" field data
    And ios user clicks on save
    Then ios user should navigate to debit card screen
    And card "<cardNumber>" details should be saved in ios app debit card list as per order of date added

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country                  | address |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b |         78728 | Samsss Petro   | 6759649826438453 |            1120 |             1125 | United States Of America | USAAdd  |

  #Note:Storing search address for country USA_UK_Spain_France_India only for other country use manual address
  #Reason: Auto search address not giving full mandatory address field values
  @TorFX_PID-3614_TC127 @Mycard3
  Scenario Outline: To verify add debit card functionality with manual address entry when user enters country and address details manually.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    When ios user selects country "<country>"
    And ios user clicks on enter address manually
    And ios user enters country specific required address "<address>" field data
    And ios user clicks on save
    Then ios user should navigate to debit card screen
    And card "<cardNumber>" details should be saved in ios app debit card list as per order of date added

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country                  | address |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b |         78728 | Samsss Petro   | 6759649826438453 |            1120 |             1125 | United States Of America | USAAdd  |

  # | CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | John1 Thompson    | 4444333322221111 |            1120 |             1125 | Spain     | SpainAdd  |
  # | CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Carol Thompson    | 5163613613613613 |            1120 |             1125 | Australia | AUSAdd    |
  # | CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Johnson Thompson  | 4462030000000000 |            1120 |             1125 | UK        | UKAdd     |
  #| CDRegEmailId28    | CDRegEmailPass1 | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | jee               | 5555555555554444 |            1120 |             1125 | Canada    | CanadaAdd |
  #| CDRegEmailIdUKAdd | CDRegEmailPass2 | Jennifer Crosnst   | 43 Grand'Rue,Ry,France,76116 | LE 128JP      | Jennifer Crosnst  | 4462030000000000 |            1120 |             1125 | Canada    | CanadaAdd |
  #| CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Nancy Thompson    | 5454545454545454 |            1120 |             1125 | France    | FranceAdd |
  #| CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Brinegar Thompson | 2221000000000009 |            1120 |             1125 | India     | IndiaAdd  |
  @TorFX_PID-3614_TC128 @Mycard3
  Scenario Outline: To verify add debit card functionality with manual address when user enters country and rest of the address details by using search option.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    When ios user selects country "<country>"
    And ios user searches for address "<searchAddress>" and select auto searched address
    And ios user clicks on save
    Then ios user should navigate to debit card screen
    And card "<cardNumber>" details should be saved in ios app debit card list as per order of date added

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country                  | address |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b |         78728 | Samsss Petro   | 6759649826438453 |            1120 |             1125 | United States Of America | USAAdd  |

  #| CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Evan Thompson     | 5454545454545454 |            1120 |             1125 | Spain                    | SpainAdd |
  #| CDRegEmailIdUKAdd | CDRegEmailPass2 | Jennifer Crosnst   | 43 Grand'Rue,Ry,France,76116 |         78728 | Jennifer Crosnst  | 6759649826438453 |            1120 |             1125 | United States Of America | USAAdd   |
  #Note:Storing search address for country USA_UK_Spain_France_India only for other country use manual address
  #Reason: Auto search address not giving all mandatory address field values
  @TorFX_PID-3614_TC129 @Mycard3
  Scenario Outline: To verify add debit card functionality with mandatory address field error messages for UK,France,Spain,India country.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    When ios user selects country "<country>"
    And ios user clicks on enter address manually
    And ios user enters country specific required address "<address>" field data
    And ios user removes mandatory address field address line
    Then street line field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app
    When ios user removes mandatory address field town city
    Then town city field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app
    When ios user removes mandatory address field post code
    Then post code field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country | address  | mandatoryAddField |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | XYz           | Samsss Petro   | 5454545454545454 |            1120 |             1125 | Spain   | SpainAdd | City              |

  #Note - Mandatory field
  #Group1 : UK-France-Spain-India: AddressLine1,City,PostCode #Group2: USA : StreetLine1,City,State,ZipCode
  #Group3: Canada: StreetName,StreetType,City,State,PostCode #Group4: Australia: StreetNumber,StreetName,StreetType,Suburb,State,PostCode
  @TorFX_PID-3614_TC130 @Mycard3
  Scenario Outline: To verify add debit card functionality with mandatory address field error messages for USA country.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    When ios user selects country "<country>"
    And ios user clicks on enter address manually
    And ios user enters country specific required address "<address>" field data
    And ios user removes mandatory address field unit street apartment
    Then unit street apartment field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app
    When ios user removes mandatory address field city
    Then city field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app
    When ios user removes mandatory address field zip code
    Then zip code field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country                  | address |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b |         78728 | Samsss Petro   | 6759649826438453 |            1120 |             1125 | United States Of America | USAAdd  |

  #Note - Mandatory field
  #Group1 : UK-France-Spain-India: AddressLine1,City,PostCode #Group2: USA : StreetLine1,City,State,ZipCode
  #Group3: Canada: StreetName,StreetType,City,State,PostCode #Group4: Australia: StreetNumber,StreetName,StreetType,Suburb,State,PostCode
  @TorFX_PID-3614_TC131 @Mycard3
  Scenario Outline: To verify add debit card functionality with mandatory address field error messages for canada country.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    When ios user selects country "<country>"
    And ios user clicks on enter address manually
    And ios user enters country specific required address "<address>" field data
    And ios user removes mandatory address field street name
    Then street name field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app
    When ios user removes mandatory address field city of canada country
    Then city field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app
    When ios user removes mandatory address field post code of canada country
    Then post code field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country | address   |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | LE 128JP      | Samsss Petro   | 4462030000000000 |            1120 |             1125 | Canada  | CanadaAdd |

  @TorFX_PID-3614_TC132 @Mycard3
  Scenario Outline: To verify add debit card functionality with mandatory address field error messages for australia country.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    When ios user selects country "<country>"
    And ios user clicks on enter address manually
    And ios user enters country specific required address "<address>" field data
    And ios user removes mandatory address field street name
    Then street name field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app
    When ios user removes mandatory address field street number
    Then street number field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app
    When ios user removes mandatory address field suburb
    Then suburb field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app
    When ios user removes mandatory address field post code of australia country
    Then post code field required error message should be displayed in ios app
    And the option to save the card should be in an inactive/disabled state in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country   | address |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | XYz           | Samsss Petro   | 6759649826438453 |            1120 |             1125 | Australia | AUSAdd  |

  @TorFX_PID-3614_TC133 @Mycard4
  Scenario Outline: To verify user able to add debit card with manual address entry when user provides max length data in address field value.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    When ios user clicks on enter address manually
    And ios user selects country "<country>"
    And ios user clicks on enter address manually
    And ios user enters country specific required address "<maxAddress>" field data
    And ios user clicks on save
    Then ios user should navigate to debit card screen
    And card "<cardNumber>" details should be saved in ios app debit card list as per order of date added

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country        | maxAddress | mandatoryAddField |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | XYz           | Samsss Petro   | 6759649826438453 |            1120 |             1125 | United Kingdom | UKMaxAdd   | Postcode          |

  # | CDRegEmailIdUKAdd | CDRegEmailPass2 | Jennifer Crosnst   | 43 Grand'Rue,Ry,France,76116 | LE 128JP      | Jennifer Crosnst   | 4462030000000000 |            1120 |             1125 | United Kingdom | UKMaxAdd     | Postcode          |
  # | CDRegEmailId4     | CDRegEmailPass1 | Jimmy Sen          | 43 Grand'Rue,Ry,France,76116 | XYz           | Jimmy Sen          | 5454545454545454 |            1120 |             1125 | Spain          | SpainMaxAdd  |                   |
  # | CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Jean Thompson      | 4462030000000000 |            1120 |             1125 | UK             | UKMaxAdd     | PostCode          |
  # | CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Orval Thompson     | 5454545454545454 |            1120 |             1125 | Australia      | AUSMaxAdd    | StreetLine1       |
  # | CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Rodriguez Thompson | 2221000000000009 |            1120 |             1125 | Canada         | CanadaMaxAdd | PostCode          |
  # | CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Bruce Thompson     | 2221000000000009 |            1120 |             1125 | France         | FranceMaxADD | Suburb            |
  @TorFX_PID-3614_TC134 @Mycard4
  Scenario Outline: 3.7To verify user able to add debit card with regex provided in the Global NFR document into text field
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    When ios user selects country "<country>"
    And ios user clicks on enter address manually
    And ios user enters country specific required address "<address>" field data
    And ios user clicks on save
    Then ios user should navigate to debit card screen
    And card "<cardNumber>" details should be saved in ios app debit card list as per order of date added

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country                  | address    |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | XYz           | Samsss Petro   | 6759649826438453 |            1120 |             1125 | United States Of America | USAAddRegX |

  #| CDRegEmailIdUKAdd | CDRegEmailPass2 | Jennifer Crosnst   | 43 Grand'Rue,Ry,France,76116 | LE 128JP      | Jennifer Crosnst   | 4462030000000000 |            1120 |             1125 | United Kingdom | UKAdd         |
  #| CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Brackett Thompson  | 5454545454545454 |            1120 |             1125 | Australia      | AUSAddRegX    |
  #| CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Patricia Thompson  | 4462030000000000 |            1120 |             1125 | UK             | UKAddRegX     |
  #| CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Purvis Thompson    | 2221000000000009 |            1120 |             1125 | Canada         | CanadaAddRegX |
  #| CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Alexander Thompson | 2221000000000009 |            1120 |             1125 | France         | FranceAddRegX |
  #| CDRegEmailId4     | CDRegEmailPass  | Pedro Thompson     | 43 Grand'Rue,Ry,France,76116 | XYz           | Reece Thompson     | 2221000000000009 |            1120 |             1125 | India          | IndiaAddRegX  |
  @TorFX_PID-4224_TC135 @Mycard4
  Scenario Outline: 2.1, 2.2, 2.3 To verify mandatory fields error message should be removed after entering valid card holder name
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios app should load the dashboard screen
    #When ios user opens up their account settings
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides invalid unmatched contacts last name "<unmatchedLastName>"
    Then invalid last name error message should be displayed to ios user
    When ios user provides valid matched contacts last name "<matchedLastName>"
    Then invalid last name error message should be removed from ios add card screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | unmatchedLastName | matchedLastName |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Ganesh Vitkar     | Samsss Petro    |

  @TorFX_PID-4224_TC136 @Mycard4
  Scenario Outline: 2.1 2.2 2.3 To verify error message gets displayed when user enters invalid card number in field
    and when users revisit the same field again and corrects the data then error message gets removed.

    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides invalid card number "<invalidCardNo>"
    Then invalid card number error message should be displayed to ios user
    When ios user provides valid card number "<validCardNo>"
    Then invalid card number error message should be removed from ios add card screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | unmatchedLastName | matchedLastName | invalidCardNo | validCardNo      |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Ganesh Vitkar     | Samsss Petro    |  412563987544 | 6759649826438453 |

  @TorFX_PID-4224_TC137 @Mycard4
  Scenario Outline: 2.1, 2.2, 2.3 To verify error message gets displayed when user enters invalid data in issue date  field and when users revisit the same field again and corrects the data error message gets removed
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios app should load the dashboard screen
    #When ios user opens up their account settings
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides invalid issue date "<inValidIssueDate>"
    Then invalid issue date error message should be displayed to ios user
    When ios user provides valid issue date "<validIssueDate>"
    Then invalid issue date error message should be removed from ios add card screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | unmatchedLastName | matchedLastName | inValidIssueDate | validIssueDate |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | Ganesh Vitkar     | Samsss Petro    |             0126 |           0120 |

  #expiry date error message not implemented yet
  @TorFX_PID-4224_TC138
  Scenario Outline: 2.1, 2.2, 2.3  To verify error message gets displayed when user enters invalid data in expiry date field and when users revisit the same field again and corrects the data then error message gets removed
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios app should load the dashboard screen
    When ios user opens up their account settings
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides invalid expiry date "<inValidExpiryDate>"
    Then invalid expiry date error message should be displayed to ios user
    When ios user provides valid expiry date "<validExpiryDate>"
    Then invalid expiry date error message should be removed from ios add card screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress               | unmatchedLastName | matchedLastName | inValidExpiryDate | validExpiryDate |  |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | 43 Grand'Rue,Ry,France,76116 | Ganesh Vitkar     | Samsss Petro    |              0120 |            0126 |  |

  @TorFX_PID-3521_TC13 @Mycard4
  Scenario Outline: 1.4 To verify error message getting appreaed when card number not in between 12 & 19 digit length and not match with card scheme Regex rule.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user provides invalid card number "<invalidCardNumber>"
    Then invalid card number digit length error message should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | invalidCardNumber |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b |        0123456789 |

  @TorFX_PID-4316_TC140 @Mycard4
  Scenario Outline: 2.1 To verify andriod user lands on add debit card screen when click on back button from Address finder screen.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    #When ios user searches for the address "<address>"
    And ios user searches for address "<searchAddress>" and select auto searched address
    And ios user clicks on back button available on search address screen
    Then ios user should navigate to debit card screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country | address |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | XYzzz         | Samsss Petro   | 6759649826438453 |            1120 |             1125 | France  | abc     |

  @TorFX_PID-4316_TC141 @Mycard4
  Scenario Outline: 2.2To verify when address finder not shows any address after enetering search criteria like #,$,&,( ,)
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    When ios user searches for the address "<address>"
    #And ios user searches for address "<searchAddress>" and select auto searched address
    Then address not found screen should be displayed on ios app search address screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country | address  |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | %({{{}}*      | Samsss Petro   | 6759649826438453 |            1120 |             1125 | France  | %({{{}}* |

  @TorFX_PID-4316_TC142 @Mycard4
  Scenario Outline: 2.3To verify user andriod user land on Add Debit card screen when user clicks on enter address manually link
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then ios user should navigate to add card screen
    When ios user provides card holder name "<cardHolderName>" card number "<cardNumber>" issue date "<issueDate(MMYY)>" expiry date "<expiryDate(MMYY)>"
    And ios user clicks on edit address
    Then billing address fields should be populated with option search address in ios app
    When ios user searches for the address "<address>"
    #And ios user searches for address "<searchAddress>" and select auto searched address
    Then address not found screen should be displayed in ios app search address screen
    And ios user clicks on back button available on search address screen
    When ios user clicks on enter address manually
    Then ios user should navigate to add card screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | searchAddress | cardHolderName | cardNumber       | issueDate(MMYY) | expiryDate(MMYY) | country | address  |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | %({{{}}*      | Samsss Petro   | 6759649826438453 |            1120 |             1125 | France  | %({{{}}* |

  @TorFX_PID-4224_TC143 @Mycard4
  Scenario Outline: 2.1, 2.2, 2.3 To verify mandatory fields error message should be removed after entering valid card holder name
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios app should load the dashboard screen
    #When ios user opens up their account settings
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user clicks on card holder name field and lefts the focus
    Then card holder name required field error message should be displayed to ios user
    When ios user provides valid matched contacts last name "<prePopulatedCHName>"
    Then card holder name required field error message should be removed from ios add card screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b |

  @TorFX_PID-4224_TC144 @Mycard4
  Scenario Outline: 2.1, 2.2, 2.3To verify mandatory fields error message should be removed after entering card number
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios app should load the dashboard screen
    # When ios user opens up their account settings
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user clicks on card number field and lefts the focus
    Then card number required field error message should be displayed to ios user
    When ios user provides valid card number "<cardNumber>"
    #Then card number required field error message should be removed from ios add card screen
    Then invalid card number error message should be removed from ios add card screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | cardNumber       |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b | 6759649826438453 |

  @TorFX_PID-4224_TC145 @Mycard4
  Scenario Outline: 2.1, 2.2, 2.3 To verify mandatory fields error message should be removed after valid entering issue date
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios app should load the dashboard screen
    #When ios user opens up their account settings
    And ios user click on account button
    Then account screen should be displayed
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user clicks on issue date field and lefts the focus
    Then issue date required field error message should be displayed to ios user
    When ios user provides valid issue date "<issueDate>"
    Then issue date required field error message should be removed from ios add card screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress  | issueDate |
      | TorRegEmailId03 | CDRegEmailPass1 | Samsss Petro       | gj,gj,Germany,b |      0120 |

  #Expiry date error message not implemented yet
  @TorFX_PID-4224_TC146
  Scenario Outline: 2.1, 2.2, 2.3  to verify mandatory fields error message should be removed after entering valid expiry date
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    Then ios app should load the dashboard screen
    When ios user opens up their account settings
    And debit cards is selected by ios user
    And ios user selects to add a new card
    Then pre populated card holder name "<prePopulatedCHName>" and billing address "<billingAddress>" should be displayed to ios user
    When ios user clicks on expiry date field and lefts the focus
    Then expiry date required field error message should be displayed to ios user
    When ios user provides valid expiry date "<expiryDate>"
    Then expiry date required field error message should be removed from ios add card screen

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        | prePopulatedCHName | billingAddress               | expiryDate |
      | TorRegEmailId03 | CDRegEmailPass1 | Jimmy Sen          | 43 Grand'Rue,Ry,France,76116 |       0128 |
