Feature: Log into Application

Scenario: Positive test validation login

Given Chrome browser is initialized
And Nvigate to "http://qaclickacademy.com" site
And Click on Login link in home page to land on Secure signin page
When User enters <username> and <password> and logs in
Then Verify the user is successfully logged in

Examples:
|username			|password		|
|test99@gmail.com	|123456			|
|test123@gmail.com	|123321			|