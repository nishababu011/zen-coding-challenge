package com.zendesk.config;

import java.util.HashMap;
import java.util.Map;

import com.zendesk.search.organization.OrganizationMatcher;
import com.zendesk.search.ticket.TicketMatcher;
import com.zendesk.search.users.UserMatcher;


/**
 * 
 * @author joel
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
