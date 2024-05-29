Feature: TJMaxx Search Item

  Scenario: User searches and adds an item to the cart
    Given User is on the TJMaxx home page for searchitem
    When User searches for an item
    And User clicks on the search button
    And User selects the item from the search results
    And User adds the item to the cart
    Then item should be added to the cart successfully
