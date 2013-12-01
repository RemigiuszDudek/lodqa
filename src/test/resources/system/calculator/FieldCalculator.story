Scenario: Should calculate field of a circle
Given a circle with radius 1
When asked to compute field
Then should return PI


Scenario: Border cases for circle's field
Meta:
Given a circle with radius [radius]
When asked to compute field
Then should return [result]

Examples:
|radius|result|
|     0|     0|
|    -1|    -1|
|   -10|    -1|

Scenario: Should calculate field of a rectangle
Given rectangle with sides
|a|b|
|2|3|
When asked to compute field for a rectangle
Then should return 6

