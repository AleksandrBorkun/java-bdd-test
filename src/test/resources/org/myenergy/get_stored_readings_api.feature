Feature: Get Stored Readings Api
  API should return all stored reading for specified smart meter

  Scenario: Get Readings For Not Existing Smart Meter
    Given smart meter id is "smart-meter-10"
    When get smart meter readings "smart-meter-10"
    Then check status code 404

  Scenario: Get Stored Reading Is Returning 2 readings for Dave
    Given company employee name "Anders"
    When get smart meter readings "smart-meter-3"
    Then check status code 200
    And smart meter readings length is 1