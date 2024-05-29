Feature: TJMaxx Search By Category

  Scenario: User searches and adds a beauty item to the cart
    Given User is on the TJMaxx home page for categorysearch
    When User navigates to the women's category
    And User navigates to the women's perfume section
    And User selects the perfume item
    And User adds the item to the cart for categorysearch
    Then item should be in the cart