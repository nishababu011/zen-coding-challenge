package com.zendesk.dto;

/**
 * This object is used across to pass the search criteria 
 * through out the application
 */
public class SearchCriteria {
	
	private String searchType;
	
	private String fieldName;
	
	private String fieldValue;
	
	private boolean resultsFound;
	
	private boolean isSearch;
	
	private boolean searchSelected;
	
	private boolean listSelected;
	
	private boolean subMenuActive;
	
	public void reset() {
		this.searchType  = null;
		this.fieldName = null;
		this.fieldValue = null;
		this.resultsFound = false;
		this.isSearch = false;
		this.searchSelected = false;
		this.listSelected = false;
		this.subMenuActive = false;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public boolean isResultsFound() {
		return resultsFound;
	}

	public void setResultsFound(boolean resultsFound) {
		this.resultsFound = resultsFound;
	}

	public boolean isSearch() {
		return isSearch;
	}

	public void setSearch(boolean isSearch) {
		this.isSearch = isSearch;
	}

	public boolean isSearchSelected() {
		return searchSelected;
	}

	public void setSearchSelected(boolean searchSelected) {
		this.searchSelected = searchSelected;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public boolean isListSelected() {
		return listSelected;
	}

	public void setListSelected(boolean listSelected) {
		this.listSelected = listSelected;
	}

	public boolean isSubMenuActive() {
		return subMenuActive;
	}

	public void setSubMenuActive(boolean subMenuActive) {
		this.subMenuActive = subMenuActive;
	}
	
	
	

}
