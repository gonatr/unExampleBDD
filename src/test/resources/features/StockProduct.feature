@Reg
Feature: Test the Stock product Functionality in App

  @TS010 @Positive
  Scenario: Admin sales see product to warehouse
    Given Admin sales click stock product true
    Then Admin sales get the stock product from warehouse and document tracking true

  @TS011 @Negative
  Scenario: Admin sales see product to warehouse but no orders
    Given Admin sales click stock product false
    Then Admin sales get the stock product from warehouse and document tracking false