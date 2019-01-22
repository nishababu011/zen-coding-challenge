package com.zendesk.util;

/**
 * 
 * @author
 *
 */
public class SearchConstants {

	public static final String SEARCH_FIELD_USERS = "Users";

	public static final String SEARCH_FIELD_TICKETS = "Tickets";

	public static final String SEARCH_FIELD_ORGANIZATIONS = "Organizations";
	
	public static final String SEARCH_FIELD_USERS_FILE_PATH = ".\\resources\\data\\users.json";
	
	public static final String SEARCH_FIELD_TICKETS_FILE_PATH = ".\\resources\\data\\tickets.json";
	
	public static final String SEARCH_FIELD_ORGANIZATIONS_FILE_PATH = ".\\resources\\data\\organizations.json";
	
	public static final String SEARCH_WELCOME = "Welcome to Zendesk Search";
	
	public static final String SEARCH_WELCOME_OPTIONS_STR = "Type 'quit' to exit at any time, Please 'Enter' to continue" 
													+"\n"+"\n"
													+"Select search options:"+"\n"
													+"* Press 1 to search Zendesk" + "\n"
													+"* Press 2 to view a list of searchable fields" + "\n"
													+"* Type 'quit' to exit" + "\n";
	public static final String SEARCH_TYPES_STR = "Select 1) Users or 2) Tickets or 3) Organizations";
	
	public static final String SEARCH_FIELDS_STR = UserSearchConstants.SEARCH_FIELDS_LIST
			+ TicketSearchConstants.SEARCH_FIELDS_LIST + OrganizationSearchConstants.SEARCH_FIELDS_LIST;
	
	public static final String SEARCH_ENTER_FIELD_NAME = "Enter search field name";
	
	public static final String SEARCH_ENTER_FIELD_VALUE = "Enter search field value";
	
	public static final String SEARCH_ENTER_INVALID_USER_ENTRY = "Invalid entry.Please try again.\\n";
	
	public static final String SEARCH_ENTER_INVALID_FIELD_NAME = "Invalid field name.\n";
	
	public static final String SEARCH_NO_RESULTS_FOUND = "No results found.\n";
	
	public static final String SEARCH_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
	
	public static final String SEARCH_QUIT = "quit";
}
