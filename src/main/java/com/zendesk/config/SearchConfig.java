package com.zendesk.config;

import java.util.HashMap;
import java.util.Map;

import com.zendesk.search.config.OrgSearchConfig;
import com.zendesk.search.config.TicketSearchConfig;
import com.zendesk.search.config.UserSearchConfig;
import com.zendesk.search.organization.OrganizationMatcher;
import com.zendesk.search.ticket.TicketMatcher;
import com.zendesk.search.users.UserMatcher;


/**
 * This config stores the map of all the entities.
 * A single point to get the configurations. 
 * and its corresponding Matcher class implementation.
 * This map is loaded statically on start of the application
 *
 */
public class SearchConfig {
	
	public static  Map<String, UserMatcher> userMatcherMap = new HashMap<String, UserMatcher>();
	public static  Map<String, TicketMatcher> ticketMatcherMap = new HashMap<String, TicketMatcher>();
	public static  Map<String, OrganizationMatcher> organizationMatcherMap = new HashMap<String, OrganizationMatcher>();

	/**
	 * 
	 */
	public static void loadConfig() {
		UserSearchConfig.populateUserMatcherConfig(userMatcherMap);
		TicketSearchConfig.populateTicketMatcherConfig(ticketMatcherMap);
		OrgSearchConfig.populateOrganizationMatcherConfig(organizationMatcherMap);
	}
}
