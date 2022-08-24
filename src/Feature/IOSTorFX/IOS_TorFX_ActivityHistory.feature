@TorFX_ActivityHistory
Feature: To test activity history

  @TorFX_PID-4462 @TorFX_PID-4462_TC01
  Scenario Outline: 1. To verify that user navigate to emapty state activity screen when user accesses the Activity section from the tab bar menu.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user accesses the activity section from the tab bar menu
    And ios user has no recent transaction history
    Then empty state activity screen should be displayed to ios user

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId01 | CDRegEmailPass1 |

  @TorFX_PID-4463 @TorFX_PID-4463_TC02
  Scenario Outline: To verify that application displays user transaction history on activity screen when user accesses the Activity section from the tab bar menu.
    Given ios user installed the new TorFX app and launched successfully
    Then ios app should load the onboarding screen
    When ios user click on I already have an account? link
    Then ios user should navigate to login screen
    When ios user is logged into the app with Username "<emailAddress>" and Password "<password>"
    And ios user accesses the activity section from the tab bar menu
    And ios user has recent transaction history
    Then activity screen should be displayed with recent transaction history in ios app

    #When ios user removes account by using manage device option
    #Then previous ios user credentials should be removed and onboarding screen should be displayed
    Examples: 
      | emailAddress    | password        |
      | TorRegEmailId01 | CDRegEmailPass1 |
