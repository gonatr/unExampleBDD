@Reg
Feature: Test the Admin sales Functionality in App

  @TS08 @Positive
  Scenario: Admin sales can see list orders input from salesman
    Given Admin sales click store, click list order true
    Then Admin sales can see list orders input from salesman true

  @TS09 @Negative
  Scenario: Admin sales see list orders not input from salesman
    Given Admin sales click store, click list order false
    Then Admin sales can not list orders input from salesman false