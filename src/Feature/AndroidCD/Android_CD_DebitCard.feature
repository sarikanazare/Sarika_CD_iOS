@DebitCard
Feature: Debit Card :

  @PAD-2811 @PAD-2803_TC89
  Scenario Outline: 2.5 To check that user navigates to main account screen when user closes the debit card screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    When android user selects the close button
    Then android user should return to the account screen
    Examples: 
      | emailAddress | password       |
      | CDRegEmailId | CDRegEmailPass |

  @PAD-2803 @PAD-2803_TC90
  Scenario Outline: 2.1 To verify empty debit cards screen with add debit card option.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user has not saved any cards previously
    Then an empty state screen should be displayed to android user with an option to add a new card

    Examples: 
      | emailAddress| password       |
      | CDNoWallet  | CDRegEmailPass |

    @PAD-2811 @PAD-2803 @PAD-2803_TC91
     Scenario Outline: 2.2 To verify all the saved cards list is in the order of date added with option to add a new card
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    When android user has one or more saved cards
    Then all saved cards list should be displayed in order of date added with option add a new card to android user

    Examples: 
      | emailAddress | password       |
      | CDRegEmailId | CDRegEmailPass |

  @PAD-2811 @PAD-2803_TC92
  Scenario Outline: 2.3 To verify list of saved cards number is masked except last four digits in accordance with PCI-DSS requirements
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    When android user has one or more saved cards
    Then saved cards number should be masked except last four digits in android app accordance with PCI-DSS requirements

    Examples: 
      | emailAddress | password       |
      | CDRegEmailId | CDRegEmailPass |

  @PAD-2811 @PAD-2803_TC93 
  Scenario Outline: 2.4 To verify all the details of a selected card has been displayed in a new screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    When android user selects a saved card "<cardLast4Digit>"
    Then all the details of the card "<debitCardData>" should be displayed in a new screen to android user

    Examples: 
      | emailAddress | password       | cardLast4Digit | debitCardData                                                                                       |
      | CDRegEmailId | CDRegEmailPass |           8453 | Name-saira Peter,Card no-**** **** **** 8453,Expiry date-12/30,IssueDate-09/20,Adress-2HeatherlandsAscotBerkshireSL50AN |

  @PAD-2811 @PAD-2803_TC94
  Scenario Outline: 2.5 To check that user navigates to main account screen when user closes the debit card screen
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    When android user selects the close button
    Then android user should return to the account screen

    Examples: 
      | emailAddress | password       |
      | CDRegEmailId | CDRegEmailPass |

  @PAD-2803_TC95
  Scenario Outline: 4.1 To verify pre populated card holder name and billing address is as per logged in user and card details are blank on add card screen.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    Then card details should be blank to android user
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user

    Examples: 
      | emailAddress  | password       | nameBillingAddress                     | 
      | CDRegEmailId | CDRegEmailPass  | saira Peter,2HeatherlandsSL50ANAscotUK |

  @PAD-2803_TC96  @CDregression @CDsanity
  Scenario Outline: 4.2 To verify application allow user to add debit card with the last name which matches with available contacts last name of the account
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    Then card details should be blank to android user
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    And android user clicks on save button

    Examples: 
      | emailAddress | password       | nameBillingAddress                    | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate |
      | CDRegEmailId | CDRegEmailPass |saira Peter,2HeatherlandsSL50ANAscotUK |saira Peter     | 6759649826438453 | 12/30            | 09/20     |

#Bug Raised for this:PAD-4241
  @PAD-2803_TC99
  Scenario Outline: 4.6 To verify save card button is disabled and last name invalid error message when user removes the pre populated cardholder name.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    Then card details should be blank to android user
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    And android user does not provide card holder name
    Then the option to save the card should be in an inactive/disabled state in android app

    Examples: 
      | emailAddress  | password       | nameBillingAddress                        | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate |
      | CDRegEmailId  | CDRegEmailPass | saira Peter,2HeatherlandsSL50ANAscotUK| saira Peter | 6759649826438453 | 12/30          | 09/20     |

  @PAD-2803_TC100
  Scenario Outline: 4.7 To verify save card button is disabled and card number invalid error message when user removes cardnumber.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    Then card details should be blank to android user
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    And android user does not provide card number
    Then the option to save the card should be in an inactive/disabled state in android app

    Examples: 
      | emailAddress  | password       | nameBillingAddress                              | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate |
      | CDRegEmailId  | CDRegEmailPass | saira Peter,2HeatherlandsSL50ANAscotUK | saira Peter    | 6759649826438453 | 12/30  | 09/20     |

  @PAD-2805_TC101
  Scenario Outline: 4.9 To verify save card button is enabled when user provides the all valid card details
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    Then card details should be blank to android user
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    Then the option to save the card should be in active/enabled state in android app

    Examples: 
      | emailAddress  | password       | nameBillingAddress                        | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate |
      | CDRegEmailId  | CDRegEmailPass | saira Peter,2HeatherlandsSL50ANAscotUK | saira Peter  | 6759649826438453 | 12/30            | 09/20     |

  @PAD-2805_TC102 @addcard @smokeTest
  Scenario Outline: 4.9 To verify save withought entering adress details
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    Then card details should be blank to android user
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    And android user clicks on save button
    Then android user should navigate to card list screen
    And card "<cardNumber>" details should be saved in android app debit card list as per order of date added

    Examples: 
      | emailAddress  | password      | nameBillingAddress        | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate |
      | CDRegEmailId | CDRegEmailPass | saira Peter,2HeatherlandsSL50ANAscotUK | saira Peter   | 6759649826438453 | 12/30   | 09/20  |

  @PAD-2803_TC103
  Scenario Outline: 4.11  To verify invalid expiry date error message
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    Then card details should be blank to android user
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides invalid expiry date "<pastExpiryDate(MMYY)>"
    Then invalid expiry date error message should be displayed to android user

    Examples: 
      | emailAddress  | password       | nameBillingAddress    | pastExpiryDate(MMYY) |
      | CDRegEmailId | CDRegEmailPass | saira Peter,2HeatherlandsSL50ANAscotUK | 01/20|

  
 
  @PAD-2803_TC107
  Scenario Outline: 3.7 To verify all the details of a selected card has been displayed with an option to delete the card
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    When android user selects a saved card "<cardLast4Digit>"
    Then all the details of the card "<debitCardData>" should be displayed in a new screen to android user
    And an option to delete the card should be available to android user

    Examples: 
      | emailAddress | password       | cardLast4Digit | debitCardData                                                                                        |
      | CDRegEmailId | CDRegEmailPass |           8453 | Name-saira Peter,Card no-**** **** **** 8453,Expiry date-12/30,IssueDate-09/20,Adress-2HeatherlandsAscotBerkshireSL50AN |

  @PAD-2803_TC108
  Scenario Outline: 3.7 To verify all the details of a selected card has been displayed with an option to delete the card
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    When android user selects a saved card "<cardLast4Digit>"
    Then all the details of the card "<debitCardData>" should be displayed in a new screen to android user
    And an option to delete the card should be available to android user
    When android user clicks on delete
    Then an alert view should be displayed to confirm the delete card action in android app

    Examples: 
      | emailAddress | password       | cardLast4Digit | debitCardData                                                                                        |
      | CDRegEmailId | CDRegEmailPass |           8453 | Name-saira Peter,Card no-**** **** **** 8453,Expiry date-12/30,IssueDate-09/20,Adress-2HeatherlandsAscotBerkshireSL50AN |

  @PAD-2803_TC109
  Scenario Outline: 3.7  To verify that user stays on selected card view screen when user dismiss the delete card confirmation alert.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    When android user selects a saved card "<cardLast4Digit>"
    Then all the details of the card "<debitCardData>" should be displayed in a new screen to android user
    And an option to delete the card should be available to android user
    When android user clicks on delete
    Then an alert view should be displayed to confirm the delete card action in android app
    When android user cancels the action
    Then android user should be on same selected card view screen

    Examples: 
      | emailAddress | password       | cardLast4Digit | debitCardData                                                                                        |
      | CDRegEmailId | CDRegEmailPass |           8453 | Name-saira Peter,Card no-**** **** **** 8453,Expiry date-12/30,IssueDate-09/20,Adress-2HeatherlandsAscotBerkshireSL50AN |

  @PAD-2803_TC110 @deleteCard  
  Scenario Outline: 3.7 To verify all the details of a selected card has been displayed with an option to delete the card
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    When android user selects a saved card "<cardLast4Digit>"
    Then all the details of the card "<debitCardData>" should be displayed in a new screen to android user
    And an option to delete the card should be available to android user
    When android user clicks on delete
    Then an alert view should be displayed to confirm the delete card action in android app
    When android user confirms the action
    Then android user should navigate to card list screen

    Examples:
      | emailAddress | password       | cardLast4Digit | debitCardData                                                                                        |
      | CDRegEmailId | CDRegEmailPass |           8453 | Name-saira Peter,Card no-**** **** **** 8453,Expiry date-12/30,IssueDate-09/20,Adress-2HeatherlandsAscotBerkshireSL50AN |

@PAD2920_TC111 @PAD-3581 @PAD-3670
  Scenario Outline: 3.7 To verify add debit card functionality with manual address entry when user uses pre populated country value and rest of the address by using search option.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    And android user clicks on edit address
    Then billing address fields should be populated with option search address in android app
    When android user searches for address "<address>" and select auto searched address
    Then android user selects adress from searched
    And android user clicks on save button
    Then android user should navigate to card list screen
    And card "<cardNumber>" details should be saved in android app debit card list as per order of date added

    Examples: 
      | emailAddress | password | address | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate |
      | CDRegEmailId | CDRegEmailPass | Cab Building, Campus East Welwyn Garden City, AL8 6LY | saira Peter | 6759649826438453 | 12/30 | 09/20 |


  @PAD2920_TC112 @PAD-3581 @EditCard
  Scenario Outline: 3.7 To verify add debit card functionality with manual address entry when user uses pre populated country and rest of the address enters by manually.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    And android user clicks on edit address
    Then billing address fields should be populated with option search address in android app
    When user clicks on enter address manually
    And android user enters country "<country>" specific required address "<Address>" field data
    And android user clicks on save button
    Then android user should navigate to card list screen
    And card "<cardNumber>" details should be saved in android app debit card list as per order of date added

    Examples: 
      | emailAddress | password       | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate | Address                                  | country          |
      | CDRegEmailId | CDRegEmailPass | saira Peter    | 6759649826438453 | 12/30            |    09/20  | Flat 2,Wickliffe Court,UK,London,9999999 | United Kingdom   |


  @PAD2920_TC113 @PAD-3581
  Scenario Outline: 3.7 To verify add debit card functionality with manual address entry when user enters country and address details manually.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    And android user clicks on edit address
    Then billing address fields should be populated with option search address in android app
    And android user selects country "<country>"
    When user clicks on enter address manually
    And android user enters country "<country>" specific required address "<Address>" field data
    And android user clicks on save button
    Then android user should navigate to card list screen
    And card "<cardNumber>" details should be saved in android app debit card list as per order of date added

    Examples: 
      | emailAddress | password       | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate | Address                           | country   |
      | CDRegEmailId | CDRegEmailPass | saira Peter    | 6759649826438453 | 12/30            | 09/20     | Calle B,Cabaleiros,Tordoia,999999 | Argentina |

  @PAD2920_TC114 @PAD-3581
  Scenario Outline: 3.7  To verify add debit card functionality with manual address when user enters country and rest of the address details by using search option.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    And android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    And android user clicks on edit address
    Then billing address fields should be populated with option search address in android app
    And android user selects country "<country>"
    When android user searches for address "<address>" and select auto searched address
    Then android user selects adress from searched

    Examples: 
     | emailAddress | password       | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate | address                                | country |
		 | CDRegEmailId | CDRegEmailPass | saira Peter    | 6759649826438453 | 12/30            | 09/20     | Calle B Curtis (Santaia), 15379 Curtis | Spain   |

  
  @PAD2920_TC116
  Scenario Outline: 3.7 To verify user able to add debit card with manual address entry when user provides max length data in address field value.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    And android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    And android user clicks on edit address
    Then billing address fields should be populated with option search address in android app
    When user clicks on enter address manually
    And android user selects country "<country>"
    When user clicks on enter address manually
    And android user enters country "<country>" specific max "<Address>" address field data
    And android user clicks on save button
    Then android user should navigate to card list screen
    And card "<cardNumber>" details should be saved in android app debit card list as per order of date added

    Examples: 
      | emailAddress  | password      | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate | country | Address                                                                                                                                                                                                                                                                                                                                           |
      | CDRegEmailId | CDRegEmailPass | saira Peter    | 6759649826438453 |      12/30       |   09/20  |   United Kingdom | 111111111111111111111111111111313133141414414144141515151554&2418292926261926252927252826225272525226252625266666666666666666666\u20766619191918181818282828282828181818182727272727277272727212,111111111111111111111111111111313133141414414144141515151554_&111111111222221172762717777711111122818171515155151515155151929202&2418292926261926252927252826225272525226252625266666666666666666666\u20766619191918181818282828282828181818182727272727277272727212,UKKkkkkkkkkkkkkkkkk,Landooooooooooooooooooooooooooooooooooon,111111111144444 |
  
  @PAD2920_TC117
  Scenario Outline: 3.7 To verify save button should be disabled when user click on edit address
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    And android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    And android user clicks on edit address
    Then the option to save the card should be in an inactive/disabled state in android app

    Examples: 
      | emailAddress  | password       | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate |
      | CDRegEmailId | CDRegEmailPass  | saira Peter    | 6759649826438453 | 12/30            | 09/20     |
    
      
  
  @PAD-3561_TC205 @PAD-3561
  Scenario Outline: 2.2, 2.3.1 To verify error message for invalid last name should be removed without changing focus
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    Then card details should be blank to android user
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides invalid unmatched contacts last name "<unmatchedLastName>"
    Then invalid last name error message should be displayed to andoid user
    When android user enter valid last name "<matchedLastName>"
    Then invalid last name error message should be removed to andoid user

    Examples: 
      | emailAddress | password       | nameBillingAddress       | unmatchedLastName | matchedLastName |
      | CDRegEmailId | CDRegEmailPass | saira Peter,2HeatherlandsSL50ANAscotUK | Tom k             | saira Peter    |


  @PAD-3561_TC206 @PAD-3561
  Scenario Outline: 2.2, 2.3.2 To verify error message gets displayed when user enters invalid data in Card number field and when users revisit the same field again and corrects the data error message gets removed
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    Then card details should be blank to android user
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides invalid card number "<invalidCardNumber>"
    Then invalid card number error message should be displayed to andoid user
    When android user enter valid card number "<ValidCardNumber>"
    Then invalid card number error message should be removed to andoid user

    Examples: 
      | emailAddress  | password       | nameBillingAddress                     | invalidCardNumber | ValidCardNumber  |
      | CDRegEmailId  | CDRegEmailPass | saira Peter,2HeatherlandsSL50ANAscotUK |   123456987012345 | 6759649826438453 |


  @PAD-2803_TC207 @PAD-3561
  Scenario Outline: 2.2, 2.3.3  To verify error message for invalid issue date should be removed without changing focus
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    Then card details should be blank to android user
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides invalid issue date "<issueDate(MMDD)>"
    Then invalid issue date error message should be displayed to andoid user
    When android user enter valid issue date "<ValidIssueDate>"
    Then invalid issue date error message should be removed to andoid user

    Examples: 
      | emailAddress  | password       | nameBillingAddress                     | issueDate(MMDD) | ValidIssueDate |
      | CDRegEmailId  | CDRegEmailPass | saira Peter,2HeatherlandsSL50ANAscotUK | 12/30           | 02/21          |

  @PAD-3561_TC208 @PAD-3561
  Scenario Outline: 2.2, 2.3.4  To verify error message for invalid expiry date should be removed without changing focus
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    Then card details should be blank to android user
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides invalid expiry date "<pastExpiryDate(MMYY)>"
    Then invalid expiry date error message should be displayed to android user
    When android user enter valid expiry date "<ValidExpiryDate>"
    Then invalid expiry date error message should be removed to andoid user

    Examples: 
      | emailAddress  | password       | nameBillingAddress                              | pastExpiryDate(MMYY) | ValidExpiryDate |
      | CDRegEmailId  | CDRegEmailPass | saira Peter,2HeatherlandsSL50ANAscotUK | 01/20                | 05/30           |

  @PAD-3561_TC209 @PAD-3561
  Scenario Outline: 2.4.1 To verify mandatory fields error message should be removed after entering card holder name
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    When android user does not provide card holder name
    Then mandatory card holder name error messages should be display to android user
    When android user enter valid last name "<matchedLastName>"
    Then invalid last name error message should be removed to andoid user

    Examples: 
      | emailAddress  | password       | matchedLastName |
      | CDRegEmailId  | CDRegEmailPass | saira Peter     |

  @PAD-3561_TC210 @PAD-3561
  Scenario Outline: 2.4.2 To verify mandatory fields error message should be removed after entering card number
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    When android user does not provide card number
    Then mandatory card number error messages should be display to android user
    When android user enter valid card number "<ValidCardNumber>"
    Then invalid card number error messages should be removed to andoid user

    Examples: 
      | emailAddress  | password       | ValidCardNumber  |
      | CDRegEmailId  | CDRegEmailPass | 6759649826438453 |

 
  @PAD-3561_TC212 @PAD-3561
  Scenario Outline: 2.4.4 To verify mandatory fields error message should be removed after entering expiry date
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    When android user does not provide expiry date
    Then mandatory expiry date error messages should be display to android user
    When android user enter valid expiry date "<ValidExpiryDate>"
    Then invalid expiry date error message should be removed to andoid user

    Examples: 
      | emailAddress  | password       | ValidExpiryDate |
      | CDRegEmailId  | CDRegEmailPass | 02/30           |

  @PAD-3561_TC213 @PAD-3561 
  Scenario Outline: 2.4.5o verify add debit card functionality with manual address entry when user enters country and address details manually.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    Then android user clicks on edit address
    Then android user selects country "<country>"
    When user clicks on enter address manually
    And android user enters all the address "<address>" as per selected country "<country>"
	  And android user clicks on save button
    Then android user should navigate to card list screen
    And card "<cardNumber>" details should be saved in android app debit card list as per order of date added
   
    Examples: 
       | emailAddress | password       |cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate | country | address |
       | CDRegEmailId | CDRegEmailPass | saira Peter   | 6759649826438453 | 12/23            | 11/20     | Spain    |canadaAddress    |          
 
  @PAD-3561_TC214 @PAD-3561
  Scenario Outline: 2.4.6 To verify mandatory fields error message should be removed after entering country
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    Then android user clicks on edit address
	  Then android user selects country "<country>"
	  When user clicks on enter address manually	
	  Then android user does not provide country detail "<country>" to android user
    Then mandatory country "<country>" error message should be display to android user

    Examples: 
      | emailAddress  | password       | country         |
      | CDRegEmailId  | CDRegEmailPass | United Kingdom  |

      
  @PAD-3670_TC215 @PAD-3670
  Scenario Outline:2.1,2.2 To verify andriod user lands on add debit card screen when click on button from search address screen
  Given android user installed the new CD app and launched successfully
  Then android the app should load the onboarding screen
  When android user click on I already have an account? link
  Then android user should navigate to login screen
  When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
  And android user opens up their account settings
  And debit cards is selected by android user
  And android user selects to add a new card
  When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
  And android user clicks on edit address 
  Then billing address fields should be populated with option search address in android app
  When android user searches for address "<address>" and select auto searched address 
  Then andriod user remove the entered address from search option 
  Then andriod user click on back button from search finder screen
  Then android user should be on same selected card view screen
  
  Examples: 
      | emailAddress | password       | address | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate |
      | CDRegEmailId | CDRegEmailPass | Cab Building, Campus East Welwyn Garden City, AL8 6LY | saira Peter | 6759649826438453 | 12/21 | 11/20 |
      | CDRegEmailId | CDRegEmailPass | ^&**% | saira Peter | 6759649826438453 | 12/21 | 11/20 |
   
  @PAD-3670_TC216 @PAD-3670
  Scenario Outline:2.3To verify user andriod user land on Add Debit card screen When addres not found message user click on Enter address manually
  Given android user installed the new CD app and launched successfully
  Then android the app should load the onboarding screen
  When android user click on I already have an account? link
  Then android user should navigate to login screen
  When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
  And android user opens up their account settings
  And debit cards is selected by android user
  And android user selects to add a new card
  When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
  And android user clicks on edit address 
  Then billing address fields should be populated with option search address in android app
  When android user searches for address "<address>" and select auto searched address 
  Then andriod user remove the entered address from search option 
  Then andriod user observe address not found then click on manually entered address option
  Then android user should be on same selected card view screen
   Examples: 
      | emailAddress | password       | address | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate |
      | CDRegEmailId | CDRegEmailPass | (((())))| John Morgan | 6759649826438453 | 12/21 | 11/20 |
      
  @PAD-3670_TC217 @PAD-3670
  Scenario Outline:2.4To verify user andriod user land on Add Debit card screen When addres not found message user click on Enter address manually
  Given android user installed the new CD app and launched successfully
  Then android the app should load the onboarding screen
  When android user click on I already have an account? link
  Then android user should navigate to login screen
  When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
  And android user opens up their account settings
  And debit cards is selected by android user
  And android user selects to add a new card
  When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
  And android user clicks on edit address 
  Then billing address fields should be populated with option search address in android app
  When android user searches for address "<address>" and select auto searched address 
  Then andriod user observe address not found then click on manually entered address option
  Then android user should be on same selected card view screen
   Examples: 
      | emailAddress | password       | address | cardHolderName | cardNumber       | expiryDate(MMYY) | issuedate |
      | CDRegEmailId | CDRegEmailPass | (((())))| saira Peter | 6759649826438453 | 12/21 | 11/20 |
      
    @PAD-3652_TC218
    Scenario Outline: To check that user is able to save card details without entering issue date as it is optional field.
    Given android user installed the new CD app and launched successfully
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And android user opens up their account settings
    And debit cards is selected by android user
    And android user selects to add a new card
    And pre populated contact name and billing address "<nameBillingAddress>" should be displayed to android user
    When android user provides card holder name "<cardHolderName>" card number "<cardNumber>" expiry date "<expiryDate(MMYY)>" issue date "<issuedate>"
    Then the option to save the card should be in active/enabled state in android app
    And android user clicks on save button
    Then android user should navigate to card list screen
    And card "<cardNumber>" details should be saved in android app debit card list as per order of date added

     Examples: 
      | emailAddress  | password      | nameBillingAddress | cardHolderName    | cardNumber     | expiryDate(MMYY) | issuedate     |
      | CDRegEmailId | CDRegEmailPass | saira Peter,2HeatherlandsSL50ANAscotUK | saira Peter    | 6759649826438453 | 12/30 | 09/20 |
 
