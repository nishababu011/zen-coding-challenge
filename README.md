# Zendesk Search
System and Software requirements to run the application.
1. Install Java version "1.8.0_201" or higher.
2. Maven version : apache-maven-3.6.0

# Instructions to run the application.
1. Download the folder ZendeskSearchApp to any location in your local system.
2. Open cmd and cd to <path>/ZendeskSearchApp
3. Run command :  java -jar ZendeskSearchApp.jar
 
# Alternatively  
1. clone zen-coding-challenge project
2. run mvn clean install from the root folder.
3. Run the command:  java -jar ZendeskSearchApp.jar from the target\ZendeskSearchApp location.
 
  
Application works in an interactive way with the user inputs and displays the main menu as below:

 Welcome to Zendesk Search
 Type 'quit' to exit at any time, Please 'Enter' to continue

 Select search options:
 * Press 1 to search Zendesk
 * Press 2 to view a list of searchable fields
 * Type 'quit' to exit

-> User can select any options to proceed.

-> After each operation the application displays the main menu with all options to continue.

-> Typing 'quit' will close the application.

# Technical Notes:

-> Date search fields has to be in the format yyyy-MM-dd'T'HH:mm:ss (as appearing in the json files)
-> The data is read from JSON files using the Jackson Api. To make it simple it is loaded statically at the start of the application.
-> Decorator pattern is used to perform the comparison between fields and using Matcher interface implementation Which is configured in    Maps.
-> The code is written such that each entity can be extended to add new fields.
-> It is also extendable such that new entity can be added without changing existing logic.
-> Test case covers search of all the fields that can be searched through the application.

