Feature: Post Readings Api
  API should store readings for provided smart meter

  Scenario: Add new readings to smart meter
      Given smart meter id is "smart-meter-5"
      When add 2.5 power reading
      Then check smart meter 2.5
      And check status code 200

  Scenario: Add readings to smart meter with space id (Negative)
      Given smart meter id is " "
      When add 2.5 power reading
      Then check status code 400

  Scenario: Add multiple readings to smart meter
      Given company employee name "John"
      When get smart meter readings "smart-meter-0"
      Then smart meter readings length is 10
      And check status code 200

  Scenario: Add new readings with empty time (Negative)
      Given smart meter id is "smart-meter-1"
      When add 2.5 power reading ""
      Then check status code 400

  Scenario: Add new readings to store with empty reading (Negative)
      Given smart meter id is "smart-meter-1"
      When add power reading
      Then check status code 400
