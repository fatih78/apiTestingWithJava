@karate
Feature: Testing DELETE of the CREATED Drinks

  Background:
    * url baseUrl
    * def fourth = 4


  @DeleteNewDrink
  Scenario: deleting extra set of data
    Given path 'drinks/' + 2
    When method delete
#    Then status 204

