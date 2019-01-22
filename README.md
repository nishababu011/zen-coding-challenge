# zen-coding-challenge
System and Software requirements to run the application.
1. Install Java version "1.8.0_201" or higher.
2. Add/Append the Java home path to the PATH system variable in the enviornment properties.(Eg: C:\Program Files\Java\jdk1.8.0_201\bin)
 
Application is built using Maven. 
1. Maven version : apache-maven-3.6.0
2. Add the Maven installation path (C:\apache-maven-3.6.0-bin\apache-maven-3.6.0\bin) to the PATH system variable and add a JAVA_HOME pointing to JDK installation (Eg: C:\Program Files\Java\jdk1.8.0_201)

Instructions to run the application.
1. Download the folder #zen-coding-challenge/target/ZendeskSearchApp/ to any location in your local system.
2. Open cmd and cd to <path>/ZendeskSearchApp
3. Run command :  java -jar ZendeskSearchApp.jar
  
Application displays the main menu as below:
Welcome to Zendesk Search
Type 'quit' to exit at any time, Please 'Enter' to continue

Select search options:
* Press 1 to search Zendesk
* Press 2 to view a list of searchable fields
* Type 'quit' to exit

-> User can select any options to proceed.
-> After each operation the application displays the main menu with all options to continue.
-> Typing 'quit' will close the application.

