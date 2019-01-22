package com.zendesk.search.organization;

import com.zendesk.dto.SearchCriteria;
import com.zendesk.model.Organization;

/**
 * Match Interface for Organization
 * @author 
 *
 */
public interface OrganizationMatcher {
	public  boolean searchByFieldName(SearchCriteria searchCriteria,Organization organization);
}
