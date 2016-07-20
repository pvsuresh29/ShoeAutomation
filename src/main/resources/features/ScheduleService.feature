@smoketest
Feature: Schedule the service
    

Background: 
    Given I open DThomepage



Scenario Outline: Schedule the service
Then I click on Store Locator
And I enter "<ZipCode>"
And I click on Search Button
And I click a store and click on Send to Phone
And I enter a valid "<PhoneNumber>"
And I click on send Button
And I close the popup
And I click on My Store Header
And I click on Schedule Appointment on the menu
And I click on a Service and click Next Steps Store and Time
And I select a Date and Time and Click on Customer Information
And I enter "<FirstName>" "<LastName>" "<Email>" "<PhoneNumber>"
And I click on Schedule Appointment




Examples:
    |ZipCode|PhoneNumber|FirstName|LastName|Email|
    |32003|1234567890|Sam|Jackson|test@test.com|