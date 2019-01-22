package com.zendesk.controller.user;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.zendesk.config.SearchConfig;
import com.zendesk.controller.SearchController;
import com.zendesk.dto.SearchCriteria;
import com.zendesk.exception.InvalidUserInputException;
import com.zendesk.initialiser.SearchDataInitialiser;
import com.zendesk.model.User;
import com.zendesk.search.users.UserMatcher;
import com.zendesk.util.LogUtil;
import com.zendesk.util.SearchConstants;


/**
 * Controller class for User
 * @author 
 *
 */
public class UserSearchController extends SearchController {

	/**
	 * 
	 */
	public void performSearch(SearchCriteria searchCriteria) throws  InvalidUserInputException{
		checkIfDataLoaded();
		Stream<User> str = Arrays.stream(SearchDataInitialiser.SEARCH_DATA.getUsers());
		UserMatcher userMatcher = SearchConfig.userMatcherMap.get(searchCriteria.getFieldName());
		if(userMatcher == null) {
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
		}
		Predicate<User> userFilter = (User u) -> userMatcher.searchByFieldName(searchCriteria, u);
		Stream<User> results = str.filter(userFilter);
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
	}
	
	/**
	 * 
	 */
	private void checkIfDataLoaded() throws InvalidUserInputException{
		if(SearchDataInitialiser.SEARCH_DATA == null || SearchDataInitialiser.SEARCH_DATA.getUsers() == null) {
			throw new InvalidUserInputException(SearchConstants.SEARCH_ENTER_INVALID_FIELD_NAME);
		}
		
	}

}
