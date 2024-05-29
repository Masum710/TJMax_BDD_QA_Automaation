Feature: Continue Shopping

  Scenario: Add multiple items to the shopping bag and continue shopping
    Given user is on TJ Max homepage for continue shopping
    When user selects the "Luggage" category
    And user clicks on "Carry-On Luggage"
    And user selects the first carry-on luggage item
    And user adds the item to the order for continue shopping
    And user selects another carry-on luggage item
    And user adds the second item to the order
    Then both items should be added to the shopping bag
