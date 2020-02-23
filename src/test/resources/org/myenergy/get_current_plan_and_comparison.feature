Feature: Get Current Price Plan Api
  View Current Price Plan and Compare Usage Cost Against all Price Plans

    Scenario: Check Current Plan For Existing User
        Given all users in place
        When get current plan "smart-meter-2"
        Then check that price plan "price-plan-0"
        And check available plans 3
        And check status code 200

    Scenario: Check Current Plan For Not Existing User
        Given smart meter id is "none"
        When get current plan "none"
        Then check status code 404
