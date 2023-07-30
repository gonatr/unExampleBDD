@Reg
Feature: Test the Order Functionality in App

  @TS01 @Positive
  Scenario: User select a store name from list
    Given User on page app Store
    When User clicks store, see select store name from list
    Then User will see get selected store code from list true

  @TS02 @Positive
  Scenario: User select a product name from list
    Given User on page app Store
    When User clicks store, see select product name from list
    Then User will see get selected product code from list true

  @TS03 @Positive
  Scenario: User select a quantity from list
    Given User on page app Store
    When User clicks store, see select quantity from list true
    Then User will see get selected quantity true

  @TS04 @Positive
  Scenario: User add notes to product order
    Given User on page app Store
    When User adds notes to product order
    Then User will get notes

  @TS05 @Negative
  Scenario: User not select a store name from list
    Given User on page app Store
    When User clicks store, not select store name from list
    Then User will not get selected store code from list false

  @TS06 @Negative
  Scenario: User does not select a product from the list
    Given User on page app Store
    When User clicks store, not select product name from list
    Then User will not get selected product code from list false

  @TS07 @Negative
  Scenario: User not input quantity from the list product
    Given User on page app Store
    When User clicks store, not select quantity from list false
    Then User will not get selected quantity false