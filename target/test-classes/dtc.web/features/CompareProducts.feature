@compareProducts
@dt
Feature: Compare multiple products

  Background:

    Given I change to the default store

  #TC 1 - Compare Products page displays w/ expected categories
  @bba
  @8348
  @compareProductsWithReview
  Scenario Outline: Compare Tire products with product reviews
    When I do a "homepage" vehicle search with details "<Year>" "<Make>" "<Model>" "<Trim>" "<Assembly>"
    And  I select a fitment option "<FitmentOption>"
    And  I select the first "<Quantity>" results to compare
    And  I click the compare products Compare button
    Then I verify all categories are present for the "<Quantity>" products

    Examples:
      | Year | Make  | Model | Trim     | Assembly | FitmentOption | Quantity |
      | 2012 | Honda | Civic | Coupe DX | none     | All Tires     | 3        |


  #TC 2 - Remove and re-add product from compare page
  @bba
  @8348
  @compareProductsRemoveFromCart
  Scenario Outline: Add and remove tires from shopping cart
    When I do a "homepage" vehicle search with details "<Year>" "<Make>" "<Model>" "<Trim>" "<Assembly>"
    When I select a fitment option "<FitmentOption>"
    And  I select the first "<Quantity>" results to compare
    And  I click the compare products Compare button
    Then I verify all categories are present for the "<Quantity>" products
    When  I add item "<ItemCode>" to my cart and click "Close" on the Compare Products page
    And  I click the X next to the first product on the compare product page
    And  I click the undo remove product button
    Then I verify all categories are present for the "<Quantity>" products

    Examples:
      |Year |Make  |Model |Trim     |Assembly |FitmentOption |Quantity|ItemCode |
      |2012 |Honda |Civic |Coupe DX |none     |All Tires     |3       |29935    |


  #TC 3 - Modify selection updated on Compare Products page (click x on item, click Add an Item button)
  @8348
  @compareProductsModifyComparison
  Scenario: Modify products to be compared
    When I open the "TIRES" navigation link
    And I click the "Michelin Tires" menu option
    And I select "Shop for Passenger Tires" from the Product Brands page
    And I select the first "2" results to compare
    And I click the compare products Compare button
    Then I verify all categories are present for the "2" products
    When I remove the first item on the compare product page
    And I select the first "3" results to compare
    And I click the compare products Compare button
    Then I verify all categories are present for the "3" products


  #TC 4
  @bba
  @8348
  @compareProductsRemoveAll
  Scenario: Compare Products and remove all
    When I open the "TIRES" navigation link
    And I click the "All-Season Tires" menu option
    And I select "GOODYEAR" from the Product Brands page
    And I note the current product list results url
    And I select the first "3" results to compare
    And  I click the compare products Compare button
    Then I verify all categories are present for the "3" products
    When I click Remove All
    Then I am taken back to the previous product list results url

  #TC 5
  @bba
  @8348
  @compareProductsFromDifferentResultPages
  Scenario: Compare Products from different result pages
    When I open the "TIRES" navigation link
    And I click the "Michelin Tires" menu option
    And I select "Shop for All-Season Tires" from the Product Brands page
    And I select a single product to compare
    And I go to the "next" page of product list results
    And I select a single product to compare
    And I click the compare products Compare button
    Then I verify all categories are present for the "2" products