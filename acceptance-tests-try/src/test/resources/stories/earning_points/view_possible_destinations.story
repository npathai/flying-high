Meta:
@Versions Release 1, Iteration 1.0
@tag layer:web

Narrative:
In order to plan my holidays
As a traveller
I want to see where I can fly with Flying High Airlines
					 
Scenario: View possible desitnations
Given Sarah is a Frequent Flyer member
When she views her account details
Then she should see a home city of Sydney
And the following destination airports:
| airport 		|
| Melbourne 	|
| Brisbane  	|
| Los Angeles 	|
| Auckland		|
| Perth			|
