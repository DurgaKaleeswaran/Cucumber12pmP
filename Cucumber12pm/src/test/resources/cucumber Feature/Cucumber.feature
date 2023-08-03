Feature: Open the Nile Airlines 
Scenario Outline: To check the ticket booking in one way 
    Given User on nile airline home page 
    When To check the flight tickets booking
    And To check the select a region from and to
    And To check a travel date
    And To check the adult child and click search
    And To Check Covid Alert box and accept
    Then Open flex pricer availability 
		
		Examples:
		|Dates|
		|2023-08-12|		