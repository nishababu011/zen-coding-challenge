package com.zendesk.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Organization
 */
public class Organization {

	 private Long _id;
	 
	 private String url;
	 
	 private String external_id;
	 
	 private String name;
	 
	 private List<String> domain_names;
	 
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone="GMT")
	 private Date created_at;
	 
	 private String details;
	 
	 private Boolean shared_tickets;
	 
	 private List<String> tags;
	 
	 

	@Override
	public String toString() {
		return "_id" +"\t"+"\t"+"\t"+ _id + "\n"
				+ "url" +"\t"+"\t"+"\t"+ url + "\n"
				+ "external_id" +"\t"+"\t"+ external_id + "\n"
				+ "name" +"\t"+"\t"+"\t"+ name + "\n"
				+ "domain_names" +"\t"+"\t"+ domain_names + "\n"
				+ "created_at" +"\t"+"\t"+ created_at + "\n"
				+ "details" +"\t"+"\t"+"\t"+ details + "\n"
				+ "shared_tickets" +"\t"+"\t"+ shared_tickets + "\n"
				+ "tags" +"\t"+"\t"+"\t"+ tags + "\n"+ "\n";
	}
	
	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getExternal_id() {
		return external_id;
	}

	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDomain_names() {
		return domain_names;
	}

	public void setDomain_names(List<String> domain_names) {
		this.domain_names = domain_names;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Boolean isShared_tickets() {
		return shared_tickets;
	}

	public void setShared_tickets(Boolean shared_tickets) {
		this.shared_tickets = shared_tickets;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	 
	 
}
