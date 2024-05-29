Feature: TJMaxx Delete Item from Cart

  Scenario: Add and remove an item from the shopping bag
    Given user is on the TJ Maxx homepage for delete item
    When  user searches for lamp
    And  user clicks on the search button
    And user scrolls down by pixels
    And user selects the table lamp
    And user adds the item to the order
    Then user should see the ViewBag link
    When user clicks on the ViewBag link
    When user clicks on the link to remove item
    Then item should be removed from the shopping bag
