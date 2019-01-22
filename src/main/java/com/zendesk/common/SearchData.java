package com.zendesk.common;

import com.zendesk.model.Organization;
import com.zendesk.model.Ticket;
import com.zendesk.model.User;

/**
 * This stores all the search data that are read from the JSON
 * @author
 *
 */
public class SearchData {
	
	private  User[] users;;
	
	private Ticket[] tickets;
	
	private Organization[] organizations;

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public Ticket[] getTickets() {
		return tickets;
	}

	public void setTickets(Ticket[] tickets) {
		this.tickets = tickets;
	}

	public Organization[] getOrganizations() {
		return organizations;
	}

	public void setOrganizations(Organization[] organizations) {
		this.organizations = organizations;
	}	
	
	
	

}
