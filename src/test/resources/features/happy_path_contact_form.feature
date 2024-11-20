@Max
Feature: Contact Us Form - Happy Path



  Scenario: Happy path - Submitting a valid contact form
    Given User is on the "Contact Us" page
    When User press on Contact Sales arrow
    When User fills out the form with valid details
    And User submits the form
    Then User should see a success message
