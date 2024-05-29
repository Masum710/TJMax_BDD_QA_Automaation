Feature: Add Gift Card
  
  Scenario: Add a gift card with valid details
    Given User is on the TJMaxx home page for gift card purchase
    When User selects E-Gift Cards
    Then User navigate to the TJ Maxx Cashstar website
    When User wait for the recipient name input field to be visible
    And User enter name in the recipient name field
    And User enter name in the sender name field
    And User click on the next button
    And User click on giftcard submit button
    And User wait for the amount selection to be visible
    And User select the first available amount
    And User click on the next button
    And User wait for the message input field to be visible
    And User enter message in the message field
    And User click on the next button
    And User wait for the recipient email input field to be visible
    And User enter email in the recipient email field
    And User confirm the recipient email by entering again
    And User click on the next button
    And User click on the confirmation button to complete the process
    Then User should be able to see giftcard in the cart