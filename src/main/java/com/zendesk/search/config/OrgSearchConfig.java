package com.zendesk.search.config;

import java.util.Map;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.model.Organization;
import com.zendesk.search.organization.OrganizationMatcher;
import com.zendesk.util.IOUtil;
import com.zendesk.util.OrganizationSearchConstants;
import com.zendesk.util.SearchConstants;


/**
 * This config stores the map of each fields of Organization 
 * and its corresponding Matcher class implementation.
 * This map is loaded statically on start of the application
 *
 */
public class OrgSearchConfig {
	
	/**
	 * This config store a map of search field and the respective implementation
	 * of the OrganizationMatcher interface
	 * @param orgMatcherMap
	 */
	public static void populateOrganizationMatcherConfig(Map<String, OrganizationMatcher> orgMatcherMap) {
		orgMatcherMap.put(OrganizationSearchConstants.SEARCH_FIELD_ORG_ID, (SearchCriteria searchCriteria,
				Organization org) -> org.get_id() == IOUtil.parseLong(searchCriteria.getFieldValue()));
		orgMatcherMap.put(OrganizationSearchConstants.SEARCH_FIELD_ORG_CREATED_AT, (SearchCriteria searchCriteria,
				Organization org) -> org.getCreated_at() != null && org.getCreated_at().equals(IOUtil.parseDate(searchCriteria.getFieldValue(), SearchConstants.SEARCH_DATE_FORMAT)));
		orgMatcherMap.put(OrganizationSearchConstants.SEARCH_FIELD_ORG_EXTERNAL_ID,
				(SearchCriteria searchCriteria, Organization org) -> org.getExternal_id() != null
						&& org.getExternal_id().equals(searchCriteria.getFieldValue()));
		orgMatcherMap.put(OrganizationSearchConstants.SEARCH_FIELD_ORG_TAGS,
				(SearchCriteria searchCriteria, Organization org) -> org.getTags() != null
						&& org.getTags().contains(searchCriteria.getFieldValue()));
		orgMatcherMap.put(OrganizationSearchConstants.SEARCH_FIELD_ORG_URL,
				(SearchCriteria searchCriteria, Organization org) -> org.getUrl() != null
						&& org.getUrl().equals(searchCriteria.getFieldValue()));
		orgMatcherMap.put(OrganizationSearchConstants.SEARCH_FIELD_ORG_DETAILS,
				(SearchCriteria searchCriteria, Organization org) -> org.getDetails() != null
						&& org.getDetails().equals(searchCriteria.getFieldValue()));
		orgMatcherMap.put(OrganizationSearchConstants.SEARCH_FIELD_ORG_DOMAIN_NAMES,
				(SearchCriteria searchCriteria, Organization org) -> org.getDomain_names() != null
						&& org.getDomain_names().contains(searchCriteria.getFieldValue()));
		orgMatcherMap.put(OrganizationSearchConstants.SEARCH_FIELD_ORG_NAME,
				(SearchCriteria searchCriteria, Organization org) -> org.getName() != null
						&& org.getName().equals((String) searchCriteria.getFieldValue()));
		orgMatcherMap.put(OrganizationSearchConstants.SEARCH_FIELD_ORG_SHARED_TICKETS, (SearchCriteria searchCriteria,
				Organization org) -> org.isShared_tickets() != null && org.isShared_tickets().equals(IOUtil.parseBoolean(searchCriteria.getFieldValue())));
	}
	
}
