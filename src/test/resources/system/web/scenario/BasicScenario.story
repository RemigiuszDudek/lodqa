Narrative: Basic scenario showing how to use webdriver with JBehave

Scenario: By default all subjects should be present on the page
Given I am on the main blog page
Then all posts should be present on the page

Scenario: When looking for particular subject only appropriate set of posts appears
Given I am on the main blog page
When I look for a keyword BDD
Then following posts appear: Behaviour Driven Development