@checkout
@dtd
Feature: Display the Availability Status of Products (Relative Inventory)

  Background:
    Given I go to the homepage

  @smoketest
  @checkoutPaypalViaMyVehiclesSmoke
  @8654
  Scenario Outline: Checkout with Paypal using Vehicle Search via My Vehicles
    When I open the fitment popup
    And I do a "my vehicles" vehicle search with details "<Year>" "<Make>" "<Model>" "<Trim>" "<Assembly>"
    Then I should see the fitment panel page with vehicle "<Year> <Make>"
    When I select a fitment option "<FitmentOption>"
    And I add item "<ItemCode>" of type "none" to my cart and "View shopping cart"
    Then I see "<ItemCode>" on the cart page
    When I select the checkout option "<Checkout>"
    And I log into paypal as "<Customer>"
    And I select a paypal address for "<Customer>"
    And I place the order
    Then I am brought to the order confirmation page
    And I confirm that taxes are listed on the "order" page
    And I confirm that fees are listed on the "order" page

    Examples:
      |Year |Make  |Model |Trim     |Assembly |FitmentOption |ItemCode |Checkout |Customer          |
      |2012 |Honda |Civic |Coupe DX |none     |All Wheels    |23500    |paypal   |paypal_customer_az|


  @smoketest
  @checkoutDefaultViaHomepageKeywordSearchSmoke
  @8653
  Scenario Outline: Checkout with Credit card using Homepage Keyword Search
    When I do a free text search for "<SearchTerm>"
    Then I should see product list page with "<ProductName>"
    When I select a product "<ProductName>" from the autocomplete dropdown of the search box
    Then I should see product detail page with "<ProductName>"
    When I add item to my cart and "View shopping cart"
    Then I should see product "<ProductName>" on the cart page
    When I select the checkout option "<Checkout>"
    And I enter shipping and payment info as "<Customer>"
    Then I confirm that taxes are listed on the "checkout" page
    And I confirm that fees are listed on the "checkout" page
    When I place the order
    Then I am brought to the order confirmation page
    And I confirm that taxes are listed on the "order" page
    And I confirm that fees are listed on the "order" page

    Examples:
      |SearchTerm |ProductName      |Checkout |Customer            |
      |34302      |PBX A/T HARDCORE |default  |default_customer_az |

  @bba
  @checkoutDefaultViaHomepageKeywordSearch
  @8629
  @8640
  @8643
  Scenario Outline: Checkout with Credit card using Homepage Keyword Search
    When I do a free text search for "<SearchTerm>"
    Then I should see product list page with "<ProductName>"
    When I select a product "<ProductName>" from the autocomplete dropdown of the search box
    Then I should see product detail page with "<ProductName>"
    When I add item to my cart and "View shopping cart"
    Then I should see product "<ProductName>" on the cart page
    When I select the checkout option "<Checkout>"
    And I enter shipping and payment info as "<Customer>"
    Then I confirm that taxes are listed on the "checkout" page
    And I confirm that fees are listed on the "checkout" page
    When I place the order
    Then I am brought to the order confirmation page
    And I confirm that taxes are listed on the "order" page
    And I confirm that fees are listed on the "order" page

    Examples:
      |SearchTerm |ProductName      |Checkout |Customer            |
      |34302      |PBX A/T HARDCORE |default  |default_customer_oh |
      |34302      |PBX A/T HARDCORE |default  |default_customer_la |
      |34302      |PBX A/T HARDCORE |default  |default_customer_tx |

  @bba
  @checkoutPaypalViaHomepageKeywordSearch
  @8627
  Scenario Outline: Checkout with Paypal using Homepage Keyword Search
    When I do a free text search for "<SearchTerm>"
    Then I should see product list page with "<ProductName>"
    When I select a product "<ProductName>" from the autocomplete dropdown of the search box
    Then I should see product detail page with "<ProductName>"
    When I add item to my cart and "View shopping cart"
    Then I should see product "<ProductName>" on the cart page
    When I select the checkout option "<Checkout>"
    And I log into paypal as "<Customer>"
    And I select a paypal address for "<Customer>"
    And I place the order
    Then I am brought to the order confirmation page
    And I confirm that taxes are listed on the "order" page
    And I confirm that fees are listed on the "order" page

    Examples:
      |SearchTerm |ProductName      |Checkout |Customer           |
      |34302      |PBX A/T HARDCORE |paypal   |paypal_customer_az |
