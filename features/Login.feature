#Each feature file contains one feature
# Feature files use Gherkin language - business language
Feature: Test the login functionality on sdet university

#A feature may have different specific scenariosxw
#scenario's use given-When-Then structure
Scenario: the user should be able to login with correct username and correct password
Given user is on the login page
When user enters correct username and correct password
Then user gets logged in

Scenario Outline: the user should be able to login
Given user is on the login page
When user enters email <username>
And user enters password <password>
Then user gets logged in

Examples:
| username | password |
| tim@testemail.com | trpass |
| ep@testemail.com | ep1password |
| sw@testemail.com | sw2password |
| ml@testemail.com | ml3password |
| jv@testemail.com | jv4password |