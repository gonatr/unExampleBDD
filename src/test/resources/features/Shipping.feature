@Reg
Feature: Test the Shipping Functionality in App

  @TS012 @Positive
  Scenario: Admin warehouse verify the order from drivers a
    Given Admin warehouse click product shipping, select driver
    Then Admin warehouse get the results order from drivers a

  @TS013 @Positive
  Scenario: Admin warehouse verify the product order from drivers b
    Given Admin warehouse click product shipping, select driver
    Then Admin warehouse get the results order from drivers b

  @TS014 @Positive
  Scenario: Admin warehouse verify order more two product from drivers c
    Given Admin warehouse click product shipping, select driver
    Then Admin warehouse get the results order from drivers c