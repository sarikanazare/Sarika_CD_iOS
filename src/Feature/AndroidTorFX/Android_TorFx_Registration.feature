@Registration_AndroidTorFx
Feature: To test registration functionality:  

  # USA and canada country is not applicable for Registration flow
  @PAD-3147_TC01_AndroidTorFx
  Scenario: 1.1 To verify that when user click on create your account button on onboarding screen one then user navigates to about you screen and on click of back option 
  user should navigate back to onboarding screen one
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user clicks on back button
    Then android app should load the onboarding screen

  @PAD-3147_TC02_AndroidTorFx
  Scenario: 1.2 2.1 To verify that when user click on create your account button onboarding screen then user navigates to about you screen and on click of back option 
  user navigate back to onboarding screen
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on I already have an account? link
    Then android user should navigate to login screen
    When android user click on the create an account button on login screen
    Then android user should navigate to about you screen
    When android user clicks on back button
    Then android user should navigate to login screen

  @PAD-3148_TC03_AndroidTorFx
  Scenario Outline: 2.2 To verify that  user presses back button or device back button then the user is taken to the onboarding screens
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    When android user clicks on back button
    Then android app should load the onboarding screen

    Examples: 
      | FirstName | LastName | EmailID                | DateOfBirth | Occupation  |
      | John      | Sweven   | TorFxRegisterationUser |    01121993 | Artist      |

  #Bug raised ID: @PAD-4007
  @PAD-3148_TC04_AndroidTorFx
  Scenario Outline: 2.3 To verify that application allow user to enter supported regex in about you input data fields.
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstNameWithRegEx>" on Registration page
    And android user enters the valid last name "<LastNameWithRegEx>" on Registration page
    And android user enters the valid email id "<EmailIDWithRegEx>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app

    Examples: 
      | FirstNameWithRegEx    | LastNameWithRegEx     | EmailIDWithRegEx | DateOfBirth | Occupation |
      | ^(?=.*[a-zA-Z0-9]).+$ | ^(?=.*[a-zA-Z0-9]).+$  |RegExMail         |    01121993 | Artist     |

  @PAD-3148_TC05_AndroidTorFx  
  Scenario Outline: 2.4 To verify that application display error message when user enters the invalid data with unsupported regex in about you input data fields.
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the invalid first name "<inValidFirstName>" on Registration page
    When android user enters the invalid last name "<invalidLastName>" on Registration page
    When android user enters the incorrect email id "<inValidEmailID>" on Registration page
    And android user enters the invalid date of birth "<invalidDateOfBirth>" on Registration page
    Then invalid first name error message should be displayed
    Then invalid last name error message should be displayed
    Then invalid email id error message should be displayed
    And android user select occupation "<Occupation>"
    Then invalid DOB error message should be displayed
    Then continue button should be in disabled state in android app

    Examples: 
      | inValidFirstName | invalidLastName | inValidEmailID   | invalidDateOfBirth | Occupation |
      | *@#$             | *!!%            | *!!%@.!*$        |           01132101 | Artist     |

  #PAD-3937 :Bug is already raised
  @PAD-3148_TC06_AndroidTorFx
  Scenario Outline: 2.5,2.6 To verify that when user enters valid data in about you fields then the 'Continue' button should become enabled and user click on Continue button
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen

    Examples: 
      | FirstName | LastName  | EmailID           | DateOfBirth | Occupation |
      | John      | Sweven    | TorFxRegisterationUser |    01121993 | Artist     |

  @PAD-3148_TC07_AndroidTorFx
  Scenario Outline: To verify that application allow user to enter max data in about you input data fields.
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the max length first name "<FirstName>"
    And android user enters the max length last name "<LastName>"
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app

    Examples: 
     | FirstName              | LastName              | EmailID              | DateOfBirth | Occupation |
     | FirstNameWithMaxlength | LastNameWithMaxlength | EmailIDWithMaxLength |    01011956 | Artist     |

  @PAD-3148_TC08_AndroidTorFx
  Scenario Outline: To verify that when user enters valid data in about you fields and when focus get changes to other field then green tick should display to fields
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | Occupation |
     | John      | Sweven   | TorFxRegisterationUser |    01121993 | Artist     |

  @PAD-3148_TC09_AndroidTorFx @TorFxregression
  Scenario Outline: To verify that application display mandatory field error message when user doesnot enters or removes data from the about you input data fields.
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user removes the valid first name
    And android user removes the valid last name
    And android user removes the valid email id
    And android user removes the valid DOB
    Then mandatory first name error message should be displayed on android app
    Then mandatory last name error message should be displayed on android app
    Then mandatory email id error message should be displayed on android app
    Then mandatory DOB error message should be displayed on android app

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth |
    | John      | Sweven   | TorFxRegisterationUser |    01121990 |

  @PAD-3148_TC10_AndroidTorFx
  Scenario Outline: To verify that application displays error message to date of birth when age is less than OR equal to 18
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    When android user enters the valid last name "<LastName>" on Registration page
    When android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the invalid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in disabled state in android app

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | Occupation |
     | John      | Sweven   | TorFxRegisterationUser |    01012015 | Artist     |

  @PAD-3148_TC11_AndroidTorFx
  Scenario Outline: 2.6 User should land on address page when user click on Continue button on About you page
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | Occupation |
     | John      | Sweven   | TorFxRegisterationUser |    01121993 | Artist     |

  @PAD-3148_TC12_AndroidTorFx
  Scenario Outline: To verify that application allow user update about you screen details when user comes back to about you screen from the current address screen
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    When android user clicks on back button
    Then android user landed on About you screen
    When android user enters the valid first name "<UpdateFirstName>" on Registration page
    And android user enters the valid last name "<UpdateLastName>" on Registration page

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | Occupation | UpdateFirstName | UpdateLastName |
     | John      | Sweven   | TorFxRegisterationUser |    01121993 | Artist     | Peter           | lily           |

  #Error message not implemented yet :last step
  @PAD-3148_TC13_AndroidTorFx @TorFxregression
  Scenario Outline: To verify the error message when user enters already existed email address in registration
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<ExistingEmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then already existed email address error message should be display on android app

    Examples: 
    | FirstName | LastName | ExistingEmailID  | DateOfBirth | Occupation |
    | John      | Sweven   | TorFxRegEmailId  |    01121993 | Artist     |

  @PAD-3430_TC14_AndroidTorFx @TorFxregression
  Scenario Outline: 3.2,3.3 To verify that when user presses back button then the user is taken to about you screen loaded with the details previously entered by the user
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    When android user clicks on back button
    Then android user landed on About you screen
    Then android user is taken to about you screen loaded with the details previously entered by the user

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | Occupation |
     | John      | Sweven   | TorFxRegisterationUser |    01121993 | Artist     |

  @PAD-3430_TC16_AndroidTorFx
  Scenario Outline: To verify that UK country should by default selected when user viUAT the current address screen
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    Then UK country should default selected in current address to android app

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 |

  @PAD-3430_TC15_AndroidTorFx
  Scenario Outline: 3.5,3.6 To verify that when the user enters a country name then the country list should be filtered with matching options
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    When android user search country name "<country>"
    Then matching country should be displayed in search result of android app

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom      |

  @PAD-3430_TC17_AndroidTorFx
  Scenario Outline: 3.7 To verify enter search data gets cleared when user selects (x) option and the whole country list should be displayed
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    When android user search country name "<country>"
    Then matching country should be displayed in search result of android app
    And android user selects the close icon in the search field
    Then the filter should be cleared and the whole country list should be displayed to android app

    Examples: 
     | FirstName | LastName | EmailID                 | DateOfBirth | country |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | USA     |

  @PAD-3430_TC18_AndroidTorFx
  Scenario Outline: 3.8 To verify that when user selects a country then the app should take the user back to current address screen with the selected country
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    Then the filter should be cleared and the whole country list should be displayed to android app

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country        |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom |

  @PAD-3430_TC19_AndroidTorFx
  Scenario Outline: 3.10 To verify that when user is search for a country and user presses back button without selecting country then the user is taken to the Current Address screen
    Given android user installed the new TorFx app and launched successfully   
   
    
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    When android user search country name "<country>"
    Then matching country should be displayed in search result of android app
    When android user clicks on back button on country search page
    Then android user landed on Current address screen

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country         |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom  |

  @PAD-3430_TC20_AndroidTorFx
  Scenario Outline: 3.11 To verify that when user clicks on search address field then address search screen should be displayed
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country        |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom |

  @PAD-3430_TC21_AndroidTorFx
  Scenario Outline: 3.12, 3.13 To verify that when use enters some text in address search bar then app should fetch matching address options and filter the list according to the selected country
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country             | address |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom      | abc     |

  @PAD-3430_TC22_AndroidTorFx
  Scenario Outline: 3.14 To verify that when searched address not available then application displays Nothing found message with enter address manually link
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should display nothing found message with enter address manually link

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | country         | address |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom  | @#%%    |

  @PAD-3430_TC23_AndroidTorFx
  Scenario Outline: 3.9,3.15 To verify that when user clicks the close icon in the search address field then address filter should be cleared
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    And android user selects the close icon in the address field
    Then android app filter should be cleared and empty search address screen should be displayed

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | country          | address |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom   | XYZ     |

  @PAD-3430_TC24_AndroidTorFx
  Scenario Outline: 3.16 To verify that when user selects an address from the list,then the app should take the user back to Current address screen with selected address populated in those updated address form fields
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then selected country "<country>" address should be updated in address field of android app

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country | address |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | France  |     129 |

    @PAD-3430_TC25_AndroidTorFx
  Scenario Outline: 3.17 To verify that when user presses back button without selecting address on address search screen then user should taken to Current Address screen
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    And android user clicks on back button on country search page
    Then android user landed on Current address screen

    Examples: 
    | FirstName | LastName | EmailID                 | DateOfBirth | country   | address                                  |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | France    | Aast 64460 - 2657 Addresses              |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | Spain     | Calle Huerta las Pilas A 11204 Algeciras |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | Australia | PO Box A Pohnpei FM 96941                |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | India     | PO Box A Pohnpei FM 96941                |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom        | PO Box A Pohnpei FM 96941    |           

  @PAD-3430_TC26_AndroidTorFx 
  Scenario Outline: 3.18, 3.19 To verify that after entering the address details manually ,fields should be validated as per Regex validation rules and address should be updated in address field
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on Enter address manually
    Then selected country "<country>" address should be updated in address field of android app
    And android user enters all the address "<address>" as per selected country "<country>"

    Examples: 
    | FirstName | LastName | EmailID           | DateOfBirth | country        | address       |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | India          | IndiaAddRegX  |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | France         | FranceAddRegX |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom | UKAddRegX     |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | Spain          | SpainAddRegX  |
  
  @PAD-3430_TC27_AndroidTorFx
  Scenario Outline: 3.20 To verify that when user is on current address screen and all the mandatory address fields value enter by the 
  user then save button should be enabled
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on Enter address manually
    Then selected country "<country>" address should be updated in address field of android app
    And android user enters all the address "<address>" as per selected country "<country>"
    Then save button should be in enabled state in android app
    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country        | address   |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom | UKAddress |

  @PAD-3430_TC28_AndroidTorFx
  Scenario Outline: 3.21 To verify that when user is on current address screen and any of the mandatory fields kept empty then the save button should be disabled
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on Enter address manually
    Then selected country "<country>" address should be updated in address field of android app
    And android user enters all the address "<oneFieldEmpty_Address>" as per selected country "<country>"
    Then save button should be in disabled state in android app

    Examples: 
     |FirstName  | LastName | EmailID                | DateOfBirth | country         | oneFieldEmpty_Address       |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom  | UKAddressWithout_UnitStreet |

 
  @PAD-3430_TC29_AndroidTorFx
  Scenario Outline: 3.22 To verify that when user is on current address screen and all the mandatory address fields value enter by the user then click on save button
    Given android user installed the new TorFx app and launched successfully   
   Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on Enter address manually
    Then selected country "<country>" address should be updated in address field of android app
    And android user enters all the address "<address>" as per selected country "<country>"
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | country         | address       |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom  | UKAddress     |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | France          | FranceAddress |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | India           | IndiaAdd      |

  #Bug raised under PAD-3150 :ID's PAD-4071,PAD-4072,PAD-4073
  @PAD-3150_TC30_AndroidTorFx
  Scenario Outline: 4.2 To verify that all the mandatory address value selected and click on save button then user lands on mobile number screen
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen

    Examples: 
    | FirstName | LastName | EmailID                 | DateOfBirth | country        | address |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom |     123 |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | France         |     150 |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | Denmark        | Den     |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | South Africa   | south   |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | Austria        |     148 |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | China          | ab      |

  @PAD-3150_TC31_AndroidTorFx 
  Scenario Outline: 4.3 To verify Additional information screen with the 'Medicare,Passport,Drivers Licence' when user click on save button
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on Additional information screen
    And Medicare option displayed on additional information screen to android user
    And Passport details option displayed on additional information screen to android user
    And Driving License Details option displayed on additional information screen to android user

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | country   | address |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | Australia |     148 |
      

  @PAD-3150_TC32_AndroidTorFx 
  Scenario Outline: 4.4,4.6,4.7 To verify Additional information screen with the 'National ID Number' edit box and
    continue button in disabled state when user dones not provided mandatory data

    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on National ID Number screen
    And National ID header message and edit box displayed to android user
    Then continue button to save additional info should be in disabled state in android app
    And android user provide National ID Number "<nationalIdNumber>" as addtional information
    Then continue button to save additional info should be in enabled state in android app
    Then android user click on additional info contiune button
    Then android user landed on Mobile number screen

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country | address | nationalIdNumber |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | Spain   |      22 |         12345678 |

  @PAD-3150_TC33_AndroidTorFx 
  Scenario Outline: 4.5,4.6,4.12 To verify that when user select the additional information as 'Medicare' and enters required field data then continue buttongets enabled and after submition of
    details user redirects to mobile number screen

    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on Additional information screen
    And Medicare option displayed on additional information screen to android user
    Then android user clicks on the Medicare proceed icon of additional information screen
    Then continue button to save additional info should be in disabled state in android app
    And android user provide Medicare Card Number "<medicareCardNumber>" as addtional information
    And android user provide Medicare Reference Number "<medicareReferenceNumber>" as addtional information
    Then continue button to save additional info should be in enabled state in android app
    Then android user click on additional info contiune button
    Then android user landed on Mobile number screen

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country   | address | medicareCardNumber | medicareReferenceNumber |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | Australia |     148 |          789456485 |                       1 |

  @PAD-3150_TC35_AndroidTorFx 
  Scenario Outline: 4.6  4.12 To verify that when user select the additional information as Driver's licence and 
  enters required field data then continue button gets enabled
  after submition of  details user redirects to mobile number screen

    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on Additional information screen
    And Driving License Details option displayed on additional information screen to android user
    Then android user clicks on the Driving License Details proceed icon of additional information screen
    Then continue button to save additional info should be in disabled state in android app
    And android user provide License Number "<licenseNumber>" as addtional information
    And android user provide Card Number "<cardNumber>" as addtional information
    And android user provide Country Code "<countryCode>" as addtional information
    And android user provide State Code "<stateCode>" as addtional information
    And android user provide Date of Expiry "<expiryDate>" as addtional information
    Then continue button to save additional info should be in enabled state in android app
    Then android user click on additional info contiune button
    Then android user landed on Mobile number screen

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country   | address | licenseNumber | cardNumber | countryCode | stateCode | expiryDate |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | Australia |     148 |     789456485 |       1245 | GBR         |       123 | 21-02-2030 |

  @PAD-3150_TC36_AndroidTorFx 
  Scenario Outline: 4.7 To verify that when user select the additional information as Driver's licence  and does not provide expiry date
    then continue button should be in disabled state

    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on Additional information screen
    And Driving License Details option displayed on additional information screen to android user
    Then android user clicks on the Driving License Details proceed icon of additional information screen
    Then continue button to save additional info should be in disabled state in android app
    And android user provide License Number "<licenseNumber>" as addtional information
    And android user provide Card Number "<cardNumber>" as addtional information
    And android user provide Country Code "<countryCode>" as addtional information
    And android user provide State Code "<stateCode>" as addtional information
    Then continue button to save additional info should be in disabled state in android app

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country   | address | licenseNumber | cardNumber | countryCode | stateCode |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | Australia |     148 |     789456485 |       1245 | GBR         |       123 |

  @PAD-3150_TC37_AndroidTorFx 
  Scenario Outline: 4.6  4.12  To verify that when user select  the additional information as Passport 
  and enters required field data then continue button gets enabled after submition of details user redirects to mobile number screen
    
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on Additional information screen
    And Passport details option displayed on additional information screen to android user
    Then android user clicks on the Passport details proceed icon of additional information screen
    Then continue button to save additional info should be in disabled state in android app
    And android user provide Passport Number "<passportNo>" as addtional information
    And android user provide Country Code "<countryCode>" as addtional information
    And android user provide Family Name At Birth "<familyNAme>" as addtional information
    And android user provide Name At Citizenship "<nameCitizenship>" as addtional information
    And android user provide Place Of Birth "<birthPlace>" as addtional information
    Then continue button to save additional info should be in enabled state in android app
    Then android user click on additional info contiune button
    Then android user landed on Mobile number screen

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country   | address | passportNo | countryCode | familyNAme | nameCitizenship | birthPlace |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | Australia |     148 |  789456485 | GBR         | Parker     | Peter Parker    | Austrlia   |

  @PAD-3150_TC38_AndroidTorFx 
  Scenario Outline: 4.7 To verify that when user select the additional information as Passport and does not provide 'name of citizenship'
    then continue button should be in disabled state
    
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on Additional information screen
    And Passport details option displayed on additional information screen to android user
    Then android user clicks on the Passport details proceed icon of additional information screen
    Then continue button to save additional info should be in disabled state in android app
    And android user provide Passport Number "<passportNo>" as addtional information
    And android user provide Country Code "<countryCode>" as addtional information
    And android user provide Family Name At Birth "<familyNAme>" as addtional information
    And android user provide Place Of Birth "<birthPlace>" as addtional information
    Then continue button to save additional info should be in disabled state in android app

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country   | address | passportNo | countryCode | familyNAme | nameCitizenship | birthPlace |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | Australia |     148 |  789456485 | GBR         | Parker     | Peter Parker    | Austrlia   |

  @PAD-3150_TC40_AndroidTorFx  
  Scenario Outline: 4.8 To verify that when user presses back button from the additional information screen then the user should navigate to the Step 2 - Current Address screen
    with the details previously stored by the application

    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on Additional information screen
    And android user click on back button
    Then android user landed on Current address screen

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | country   | address |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | Australia |     148 |

  @PAD-3150_TC41_AndroidTorFx   
  Scenario Outline: 4.9  To verify that when user press back button from the Medicare Passport Drivers licence screen then
    user should be navigate to additional information screen

    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on Additional information screen
    And Passport details option displayed on additional information screen to android user
    Then android user clicks on the Passport details proceed icon of additional information screen
    And android user click on back button
    And android user landed on Additional information screen
    And android user click on back button
    Then android user landed on Current address screen

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country   | address |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | Australia |     148 |

  @PAD-3151_TC42_AndroidTorFx  
  Scenario Outline: 5.2 To verify that when user is on Your mobile number and user has previously provided Additional information and presses back button
    then additional information screen should be displayed with stored information
 
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on Additional information screen
    And Passport details option displayed on additional information screen to android user
    Then android user clicks on the Passport details proceed icon of additional information screen
    Then continue button to save additional info should be in disabled state in android app
    And android user provide Passport Number "<passportNo>" as addtional information
    And android user provide Country Code "<countryCode>" as addtional information
    And android user provide Family Name At Birth "<familyNAme>" as addtional information
    And android user provide Name At Citizenship "<nameCitizenship>" as addtional information
    And android user provide Place Of Birth "<birthPlace>" as addtional information
    Then continue button to save additional info should be in enabled state in android app
    Then android user click on additional info contiune button
    Then android user landed on Mobile number screen
    And android user click on back button

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country   | address | passportNo | countryCode | familyNAme | nameCitizenship | birthPlace |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | Australia |     148 |  789456485 | GBR         | Parker     | Peter Parker    | Austrlia   |

  @PAD-3151_TC43_AndroidTorFx
  Scenario Outline: 5.3 To verify that when user is on Your mobile number and user was NOT previously asked to provide additional information and presses back button
    then current address screen should be displayed with stored information
 
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user click on back button
    Then android user landed on Current address screen

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | country        | address |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom |     123 |

  @PAD-3151_TC44_AndroidTorFx
  Scenario Outline: 5.1 To verify that when user lands to Your mobile number screen then Country Code selector field should be set by default with country of residence provided on current address and
    Country code prefix value,Telephone number field (edit Box) and 'Continue' button should be present in mobile number screen.

    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And country "<country>" should be selected as per current address in android app
    And country code should be updated as per "<country>" on android app
    And mobile number edit box should be display on android app
    Then continue button to save mobile number details should be in disabled state in android app

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | country          | address |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom   |     123 |

  @PAD-3151_TC45_AndroidTorFx
  Scenario Outline: 5.4 To verify that when user is on Your mobile number and user wants to change the Country Code from the dropdown then the country code selection list is displayed in alphabetic order with the country code
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user selects country "<countryCode>"

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country        | address | countryCode |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom |     123 | France      |

  @PAD-3151_TC46_AndroidTorFx  
  Scenario Outline: 5.5,5.6 To verify that when user is on Your mobile number and user wants to change the Country Code from the dropdown then t country code list should be filtered with matching options through fuzzy logic
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user search country name "<countryCode>"
    Then matching country should be displayed in search result of android app

    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | country        | address | countryCode |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom |     123 | +54         |

  @PAD-3151_TC47_AndroidTorFx
  Scenario Outline: 5.7 To verify that when user is on Your mobile number and filter should be cleared and the whole list should be displayed When the user clicks the close icon in the search field
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user search country name "<countryCode>"
    And android user selects the close icon in the search field
    Then the filter should be cleared and the whole country list should be displayed to android app

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country             | address | countryCode |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom      |     123 | +54         |

  @PAD-3151_TC48_AndroidTorFx
  Scenario Outline: 5.8  To verify that when user selects country then country code gets updated in field value
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user selects country "<countrySelected>"
    Then country code should be updated as per "<countrySelected>" on android app

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country        | address | countryCode | countrySelected |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom |     123 | +33         | France          |

  @PAD-3151_TC49_AndroidTorFx
  Scenario Outline: 5.9 To verify that when user is searching for a country code and user presses back icon then the user is taken to Your mobile number screen
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user search country name "<countryCode>"
    Then android user clicks on back button on country search page
    Then android user landed on Mobile number screen

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country        | address | countryCode |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom |     123 | +33         |

  @PAD-3151_TC50_AndroidTorFx
  Scenario Outline: 5.12,5.13 To verify that when user entered telephone number then continue button gets enabled and click on continue button the user lands on OTP screen
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user selects country "<countrySelected>"
    Then country code should be updated as per "<countrySelected>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country        | address | countryCode | countrySelected | mobileNumber |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom |     123 | +91         | India           |   9103214578 |

  @PAD-3152_TC51_AndroidTorFx
  Scenario Outline: 6.1 To verify when user presses back button on 'Enter OTP' page then the user is taken to Your Mobile Number screen with the previously supplied details remaining on the form
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user selects country "<countrySelected>"
    Then country code should be updated as per "<countrySelected>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user clicks on back button
    Then android user landed on Mobile number screen

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country       | address | countryCode | countrySelected | mobileNumber |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom|     123 | +91         | India           |   9156379129 |

  @PAD-3152_TC52_AndroidTorFx 
  Scenario Outline: 6.2 To verify when user submits the correct OTP then user navigates to the create Password screen
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user selects country "<countrySelected>"
    Then country code should be updated as per "<countrySelected>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>"
    Then android user landed on set password screen

    Examples: 
     | FirstName | LastName | EmailID                 | DateOfBirth | country        | address | countryCode | countrySelected | mobileNumber | otp             |
     | John      | Sweven   | TorFxRegisterationUserA |    01012000 | United Kingdom |     123 | +91         | India           |   9000000001 | AndroidValidOTP |

  # Error message : Not defined
  @PAD-3152_TC53_AndroidTorFx @TorFxregression
  Scenario Outline: To verify when user submits the wrong OTP then system should generate error message to provide correct OTP
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user selects country "<countrySelected>"
    Then country code should be updated as per "<countrySelected>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters invalid otp "<otp>"
    Then android app should generate error message to provide correct OTP

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country        | address | countryCode | countrySelected | mobileNumber | otp               |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom |     123 | +91         | India           | 9000000001   | AndroidInvalidOTP |

  @PAD-3152_TC54_AndroidTorFx @TorFxregression
  Scenario Outline: To verify that Resend OTP link get displayed when timer counter gets terminate
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user selects country "<countrySelected>"
    Then country code should be updated as per "<countrySelected>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When application is in backgrounds state more than one minutes
    Then android app should display resend pin link

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country        | address | countryCode | countrySelected | mobileNumber | environment |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | United Kingdom |     123 | +91         | India           |   9156379129 | UAT         |

  # Error message : Not defined ;last step
  @PAD-3152_TC55_AndroidTorFx 
  Scenario Outline: To verify when user has enetred the mobile on which PIN can not be send in that system should display user proper error message.
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    #Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    Then country code should be updated as per "<country>" on android app
    And android user entered mobile number "<invalidmobileNumber>"
    When android user click on continue button on mobile screen
    Then android app should generate error message for invalid mobile number

    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country | address | invalidmobileNumber |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | India   | abcd    |           915637917 |

    @PAD-3153_TC56_AndroidTorFx 
    Scenario Outline: 7.1 To verify that when user is on set Password screen and presses device back button then the user should remain on create Password screen
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    Then country code should be updated as per "<country>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>"
    Then android user landed on set password screen
    When android user presses device back button
    Then android user landed on set password screen

    Examples: 
    | FirstName | LastName | EmailID                 | DateOfBirth | country | address | mobileNumber  |otp             |
    | John      | Sweven   | TorFxRegisterationUserB |    01012000 | India   |     129 |   8668272780  |AndroidValidOTP |

  #Bug Raised : PAD-4083
  @PAD-3153_TC57_AndroidTorFx 
  Scenario Outline: 7.2 To verify the all parameter's of set Password screen when user landed on set password screen
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    Then country code should be updated as per "<country>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>"
    Then android user landed on set password screen
    Then all paramters of set password screen should be displayed to android user

    Examples:
      | FirstName | LastName | EmailID                 | DateOfBirth | country | address | mobileNumber | otp             |
      | John      | Sweven   | TorFxRegisterationUserC | 01012000    | India   | 129     |  8668272780  | AndroidValidOTP |

  @PAD-3153_TC58_AndroidTorFx 
  Scenario Outline: 7.5 To verify that user selects the hide/show button then the characters entered into the password field should be masked/visible respectively
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    Then country code should be updated as per "<country>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>"
    Then android user landed on set password screen
    And android user entered password "<password>"
    When android user selects the show button
    Then the characters entered into the password "<password>" field should be visible

    Examples: 
    | FirstName | LastName | EmailID                | EmailID           | DateOfBirth | country | address | mobileNumber | otp            | password    |
    | John      | Sweven   | TorFxRegisterationUserD| TorFxRegisterationUser |    01012000 | India |  129 |   8668272780 | AndroidValidOTP| Password@12 |

  @PAD-3153_TC59_AndroidTorFx 
   
   Scenario Outline: 7.6,7.7 To verify that user selects the T&Cs acknowledgment switch then T&C's should be marked as 'acknowledged' by the user respectively
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    Then country code should be updated as per "<country>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>" 
    Then android user landed on set password screen
    And android user entered password "<password>"
    Then android user selects T&Cs acknowledgment switch

    Examples: 
    | FirstName | LastName | EmailID                | EmailID           | DateOfBirth | country | address | mobileNumber | otp             | password    |
    | John      | Sweven   | TorFxRegisterationUserE| TorFxRegisterationUser | 01012000 | India |     129 |   900000000  | AndroidValidOTP | Password@12 |

  @PAD-3153_TC60_AndroidTorFx 
  Scenario Outline: 7.11,7.12 To verify that continue button when user selects the T&Cs acknowledgment switch
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    Then country code should be updated as per "<country>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>" 
    Then android user landed on set password screen
    And android user entered password "<password>"
    Then android user selects T&Cs acknowledgment switch
    Then continue button gets enabled on set password screen for android app
    Then android user clicks on continue button to set password

    Examples: 
    | FirstName | LastName | EmailID                 | DateOfBirth | country | address | mobileNumber | otp             | password    |
    | John      | Sweven   | TorFxRegisterationUserF |    01012000 | India   |     129 |   8668272780 | AndroidValidOTP | Password@12 |

  @PAD-3153_TC61_AndroidTorFx 
  Scenario Outline: To verify that continue button remains disabled when user do not enters Password or T&Cs
    Given android user installed the new TorFx app and launched successfully   
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<emailAddress>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    Then country code should be updated as per "<country>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>"
    Then android user landed on set password screen
    Then android user selects T&Cs acknowledgment switch
    Then continue button gets disabled on set password screen for android app

    Examples: 
    | FirstName  | LastName  | emailAddress            | DateOfBirth | country | address | mobileNumber | otp |
    | John1      | Sweven1   | TorFxRegisterationUserG |    01012000 | India   |     129 |   8668272780 | AndroidValidOTP |

    
    @PAD-3150_TC133_AndroidTorFx_singa
    Scenario Outline: 4.5,4.6,4.12 To verify that end to end registration for Singapore .
    Given android user installed the new TorFx app and launched successfully  
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on Nationa registration Ideentity card screen
    And android user selects NIRC "<NIRC>"
    And android user selects nationality  
    Then android user click on additional info contiune button
    Then android user landed on Mobile number screen
    And android user selects country "<countrySelected>"
     Then country code should be updated as per "<countrySelected>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>"
    Then android user landed on set password screen
    And android user entered password "<password>"
    Then android user selects T&Cs acknowledgment switch
    Then continue button gets enabled on set password screen for android app
    Then android user clicks on continue button to set password
   
   
    Examples:
    | FirstName | LastName | EmailID             | DateOfBirth | country   | address | NIRC      | countryCode| countrySelected | mobileNumber   |password   |otp         |
    | John      | Sweven   | RegisterationUser02 |    01012000 | Singapore |     148 | 789456485 |  +91       | India           |   8668272780   |Password@12|AndroidValidOTP|
    
    @PAD-3153_TC134_AndroidTorFx 
    Scenario Outline: 4.5,4.6,4.12 To verify that end to end registration for different countries.
    Given android user installed the new TorFx app and launched successfully  
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user selects country "<countrySelected>"
     Then country code should be updated as per "<countrySelected>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>"
    Then android user landed on set password screen
    And android user entered password "<password>"
    Then android user selects T&Cs acknowledgment switch
    Then continue button gets enabled on set password screen for android app
    Then android user clicks on continue button to set password
   
   
    Examples:
    | FirstName | LastName | EmailID             | DateOfBirth | country   | address | countryCode| countrySelected | mobileNumber   |password   |otp             |
    | John      | Rick     | RegisterationUser03 |    01012000 | South Africa|  345  |  +91       | India           |   8668272780   |Password@12|AndroidValidOTP |    
    | John      | Rick     | RegisterationUser04 |    01012000 | China     |    ab   |  +91       | India           |   8668272780   |Password@12|AndroidValidOTP |
    | John      | Rick     | RegisterationUser05 |    01012000 | United Kingdom|22   |  +91       | India           |   8668272780   |Password@12|AndroidValidOTP |
    | John      | Sweven   | RegisterationUser06 |    01012000 | France    |   148   |  +91       | India           |   8668272780   |Password@12|AndroidValidOTP | 
  
    @PAD-3150_TC135_AndroidTorFx
    Scenario Outline: 4.5,4.6,4.12 To verify that end to end registration for Spain.
    Given android user installed the new TorFx app and launched successfully  
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<Emai++lID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on Nationa registration Ideentity card screen
    And android user selects NIRC "<NIRC>"
    Then android user click on additional info contiune button
    Then android user landed on Mobile number screen
    And android user selects country "<countrySelected>"
     Then country code should be updated as per "<countrySelected>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>"
    Then android user landed on set password screen
    And android user entered password "<password>"
    Then android user selects T&Cs acknowledgment switch
    Then continue button gets enabled on set password screen for android app
    Then android user clicks on continue button to set password
   
   
    Examples:
    | FirstName | LastName | EmailID             | DateOfBirth | country   | address | NIRC      | countryCode| countrySelected | mobileNumber |password   |   otp      |
    | Kelvin01  | Jackson  | RegisterationUser08 |    01012000 | Spain     |     148 | 789456485 |  +91       | India           |   8668272780 |Password@12|AndroidValidOTP |

      @PAD-3430_TC271_AndroidTorFx
  Scenario Outline: 3.20 To verify registration for New Zealand
    Given android user installed the new TorFx app and launched successfully  
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    When android user enters postcode "<postcode>" for newzealand
    When android user select state "<state>" for newzealand
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user selects country "<countrySelected>"
     Then country code should be updated as per "<countrySelected>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>"
    Then android user landed on set password screen
    And android user entered password "<password>"
    Then android user selects T&Cs acknowledgment switch
    Then continue button gets enabled on set password screen for android app
    Then android user clicks on continue button to set password
    Examples: 
    | FirstName | LastName | EmailID                | DateOfBirth | country        | address   |postcode  |state |countrySelected | mobileNumber |password   |otp             |
    | John      | Sweven   | TorFxRegisterationUser |    01012000 | New Zealand    | 129       |123       |abc   |India           |   8668272780 |Password@12|AndroidValidOTP |
    
    #new tcs for both USA and Canada Country not not in registration count
    @PAD-3150_TC272_AndroidTorFx
    Scenario Outline: To verify both USA and canada not to have in country list of registration
    Given android user installed the new TorFx app and launched successfully  
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user enter country "<country>"
    Then android user unable to find country
   
    Examples:
    | FirstName | LastName | EmailID                    | DateOfBirth |country                  |
    | John      | Sweven   | InvalidCountryRegistration |    01012000 |Canada                   |
    | John      | Sweven   | InvalidCountryRegistration |    01012000 |United States of America |
    
    
    @PAD-3150_TC301_AndroidTorFx @TorFxregression @TorFxSanity
    Scenario Outline: 3.20.1 To verify registration for Australia
    Given android user installed the new TorFx app and launched successfully  
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    And android user landed on Additional information screen
    And Medicare option displayed on additional information screen to android user
    And Passport details option displayed on additional information screen to android user
    And Driving License Details option displayed on additional information screen to android user
    Then android user clicks on the Medicare proceed icon of additional information screen
    Then continue button to save additional info should be in disabled state in android app
    And android user provide Medicare Card Number "<medicareCardNumber>" as addtional information
    And android user provide Medicare Reference Number "<medicareReferenceNumber>" as addtional information
    Then continue button to save additional info should be in enabled state in android app
    Then android user click on additional info contiune button
    Then android user landed on Mobile number screen
    And android user selects country "<countrySelected>"
    Then country code should be updated as per "<countrySelected>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>"
    Then android user landed on set password screen
    And android user entered password "<password>"
    Then android user selects T&Cs acknowledgment switch
    Then continue button gets enabled on set password screen for android app
    Then android user clicks on continue button to set password
    Examples: 
     | FirstName | LastName | EmailID                | DateOfBirth | country   | address |medicareCardNumber | medicareReferenceNumber |countrySelected | mobileNumber |password   |   otp      |
     | John      | Sweven   | TorFxRegisterationUser |    01012000 | Australia |     148 |         789456485 |                       1 |India           |   8668272780 |Password@12|AndroidValidOTP |
  
  
  @PAD-3153_TC134_AndroidTorFx  @TorFxSanity @TorFxregression
    Scenario Outline: 4.5,4.6,4.12 To verify that end to end registration for different countries.
    Given android user installed the new TorFx app and launched successfully  
    Then android the app should load the onboarding screen
    When android user click on the create an account button on onboarding screen
    Then android user should navigate to about you screen
    When android user enters the valid first name "<FirstName>" on Registration page
    And android user enters the valid last name "<LastName>" on Registration page
    And android user enters the valid email id "<EmailID>" on Registration page
    And android user enters the valid date of birth "<DateOfBirth>" on Registration page
    And android user select occupation "<Occupation>"
    Then continue button should be in enabled state in android app
    When android user click on continue button
    Then android user landed on Current address screen
    And android user selects country "<country>"
    Then android user landed on Current address screen
    When android user click on search address
    Then android user landed on search address screen
    When android user searches for address "<address>"
    Then android app should fetch matching address according to the selected country
    Then selected country address "<address>" should be updated in address field of android app
    Then android user landed on Current address screen
    Then save button should be in enabled state in android app
    Then android user click on save button
    Then android user landed on Mobile number screen
    And android user selects country "<countrySelected>"
     Then country code should be updated as per "<countrySelected>" on android app
    And android user entered mobile number "<mobileNumber>"
    When android user click on continue button on mobile screen
    Then android user landed on OTP screen
    When android user enters valid otp "<otp>"
    Then android user landed on set password screen
    And android user entered password "<password>"
    Then android user selects T&Cs acknowledgment switch
    Then continue button gets enabled on set password screen for android app
    Then android user clicks on continue button to set password
   
   
    Examples:
    | FirstName | LastName | EmailID             | DateOfBirth | country   | address | countryCode| countrySelected | mobileNumber |password   |   otp          |
    | John      | Rick     | RegisterationUser05 |    01012000 | United Kingdom|22   |  +91       | India           |   8668272780 |Password@12|AndroidValidOTP |
  