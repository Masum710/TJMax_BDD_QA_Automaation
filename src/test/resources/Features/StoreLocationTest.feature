Feature: TJMaxx Store Locator

  Scenario: User searches for a TJMaxx store location
    Given User is on the TJMaxx home page for store location
    When User clicks on the store locator
    And User enters the zip code
    And User enters the city
    And User selects the state
    And User clicks on the find store button
    Then User should see the store locations

  Scenario: User searches for a TJMaxx store with invalid state and city
    Given User is on the TJMaxx home page for store location
    When User clicks on the stores link
    And User enters the city again
    And User selects the state again
    And User clicks on the find a store button
    Then User should see an error message or no store found
    