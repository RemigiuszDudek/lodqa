Scenario: When looking for particular subject only appropriate set of posts appears
Given I am on the main blog page
When I look for a keyword BDD
Then following posts appear: Behaviour Driven Development