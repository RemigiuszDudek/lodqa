Narrative: Basic scenario showing how to use webdriver with JBehave

Scenario: By default all subjects should be present on the page
Given I am on the main blog page
Then following posts appear:
    Behaviour Driven Development,
    Money and self organized teams,
    Statement coverage .vs. Branch coverage .vs. Path coverage,
    Agile vs Scrum,
    Agile vs Waterfall