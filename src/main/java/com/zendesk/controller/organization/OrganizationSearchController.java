package com.zendesk.controller.organization;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.zendesk.config.SearchConfig;
import com.zendesk.controller.SearchController;
import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;
import com.zendesk.initialiser.SearchDataInitialiser;
import com.zendesk.model.Organization;
import com.zendesk.search.organization.OrganizationMatcher;
import com.zendesk.util.LogUtil;
import com.zendesk.util.SearchConstants;

/**
 * Controller class for Organization
 * @author 
 *
 */
public class OrganizationSearchController extends SearchController {

	/**
	 * 
	 */
	public void performSearch(SearchCriteria searchCriteria) throws InvalidUserInputException{
		checkIfDataLoaded();
		Stream<Organization> str = Arrays.stream(SearchDataInitialiser.SEARCH_DATA.getOrganizations());
		OrganizationMatcher orgMatcher = SearchConfig.organizationMatcherMap.get(searchCriteria.getFieldName());
		if(orgMatcher == null) {
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
		}
				Predicate<Organization> orgFilter = (Organization u) -> SearchConfig.organizationMatcherMap
				.get(searchCriteria.getFieldName()).searchByFieldName(searchCriteria, u);
		Stream<Organization> results = str.filter(orgFilter);
		if (results != null) {
			results.forEach(u -> {
				LogUtil.logToConsole(u.toString());
				searchCriteria.setResultsFound(true);
			});
		}

		if (!searchCriteria.isResultsFound()) {
			LogUtil.logToConsole(SearchConstants.SEARCH_NO_RESULTS_FOUND);
			searchCriteria.reset();
		}
	}/**
	 * 
	 */
	private void checkIfDataLoaded() throws InvalidUserInputException{
		if(SearchDataInitialiser.SEARCH_DATA == null || SearchDataInitialiser.SEARCH_DATA.getOrganizations() == null) {
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
		}
		
	}
	
	

}
