@smokeTest

Feature: DT-149: Display the Availability Status of Products (Relative Inventory)
    

Background: 
    Given I open DThomepage



Scenario Outline: Checkout with Credit card    
    Then I select "<Year>" from "<YearDropDown>" which is dropdown "<num1>"
    And  I select "<Make>" from "<MakeDropdown>" which is dropdown "<num2>"
    And  I select "<Model>" from "<ModelDropdow>" which is dropdown "<num3>"
    And  I select "<Trim>" from "<TrimDropdown>" which is dropdown "<num4>"
    And  I select "<Assembly>" from "<AssemblyDropdown>" which is dropdown "<num5>"
    And  I click the Shop for my vehicle Button
   

Examples:
     |Year|Make  |Model|Trim      |Assembly			 |YearDropDown|MakeDropdown|ModelDropdow|TrimDropdown|AssemblyDropdown|num1|num2|num3|num4|num5|
     |2016|Alpine|A110 |ESV Sport |255 /50 R18 XL|Year        |Make        |Model       |Trim        |Assembly        |1   |2   |3   |4   |5   |