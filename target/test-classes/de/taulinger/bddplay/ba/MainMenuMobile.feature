Feature: Request SpaceIQ demo from mobile browsers

  Scenario: Negative mobile test for a request demo step
    Given I open SpaceIq home page with 'Firefox' for 'mobile' usage
    And I accept cookies
    When I click button "Request a demo"
    Then I fill demo form partially
    When I submit a form
    Then I verify an error appears "Please complete all required fields."

  Scenario: Negative mobile test for a request demo step
    Given I open SpaceIq home page with 'Chromium' for 'mobile' usage
    And I accept cookies
    When I click button "Request a demo"
    Then I fill demo form partially
    When I submit a form
    Then I verify an error appears "Please complete all required fields."

  Scenario: Negative mobile test for a request demo step
    Given I open SpaceIq home page with 'Webkit' for 'mobile' usage
    And I accept cookies
    When I click button "Request a demo"
    Then I fill demo form partially
    When I submit a form
    Then I verify an error appears "Please complete all required fields."