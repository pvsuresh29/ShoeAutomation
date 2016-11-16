@dt
@at
@cartPage

Feature: Display the Availability Status of Products (Relative Inventory)

  Background:
    Given I change to the default store

  @bba
  @tpmsCartValidation
  @8665
  Scenario Outline: Verify the TPMS line item appears in the shopping cart
    When I do a "homepage" vehicle search with details "<Year>" "<Make>" "<Model>" "<Trim>" "<Assembly>"
    Then I should see the fitment panel page with vehicle "<Year> <Make>"
    When I select a fitment option "<FitmentOption>"
    And I add item "<ItemCode>" of type "none" to my cart and "View shopping cart"
    Then I see "<ItemCode>" on the cart page
    And I verify the "<Tip Container>" line item is present on the shopping cart page

    Examples:
    |Year |Make  |Model|Trim |Assembly |FitmentOption |ItemCode |Tip Container     |
    |2015 |Acura |ILX  |2.0L |none     |All Tires     |43563    |TPMS Rebuild Kits |
    #TODO: This data is only available on staging!!