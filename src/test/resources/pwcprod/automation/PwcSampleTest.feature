Feature: Basic Functionality of Pwc Digital Pulse website
  As a customer,
  I am able to verify information and perform a search

  @web @chrome @pwc
  Scenario: Nevigate carousel
    Given a web browser is on the PWC Digital Pulse page 
    Then carousel will load 3 featured articles 
    When I click the next button on the carousel 
    Then carousel will load 3 featured articles 
    When I click the Previous button on the carousel 
    Then carousel will load 3 featured articles 

  @web @chrome @pwc
  Scenario: Navigate to contact us section and verify details
    Given a web browser is on the PWC Digital Pulse page
    When I click on nav bar 
    And I select "Contact us" from nav bar menu
    Then I am taken to the Contact Us page 
    And all contacts details are displayed

  @web @chrome @pwc
  Scenario Outline: Simple search with PWC Digital Pulse Website
    Given a web browser is on the PWC Digital Pulse page
    When I click on top icon to perform a search
    And the search phrase "<searchTerm>" is entered
    Then results for "<searchTerm>" are shown
    And "<searchTerm>" is displayed in the first "<nbOfResultsToSearch>" results

  Examples:
    |searchTerm               | nbOfResultsToSearch |
    |Single page applications | 1                   |

    

