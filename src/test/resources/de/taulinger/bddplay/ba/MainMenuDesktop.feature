Feature: Request SpaceIQ demo from desktop browsers

  Scenario: Negative test for a request demo step on Firefox
    Given I open SpaceIq home page with 'Firefox' for 'desktop' usage
    When I click button "Request a demo"
    Then I fill demo form partially
    When I submit a form
    Then I verify an error appears "Please complete all required fields."

  Scenario: Negative test for a request demo step on Chrome
    Given I open SpaceIq home page with 'Chromium' for 'desktop' usage
    When I click button "Request a demo"
    Then I fill demo form partially
    When I submit a form
    Then I verify an error appears "Please complete all required fields."

  Scenario: Negative test for a request demo step on Safari
    Given I open SpaceIq home page with 'Webkit' for 'desktop' usage
    When I click button "Request a demo"
    Then I fill demo form partially
    When I submit a form
    Then I verify an error appears "Please complete all required fields."