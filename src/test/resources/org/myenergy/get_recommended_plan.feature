Feature: Get Recommended Plan Api
  View Recommended Price Plans for Usage

    Scenario: Get recommended plan for existing user
        Given all users in place
        When check recommended plan "smart-meter-2"
        Then 3 recommended plans shown
        And check status code 200

    Scenario: Get recommended plan For Not Existing User
        Given smart meter id is "none"
        When check recommended plan "none"
        Then check status code 404
