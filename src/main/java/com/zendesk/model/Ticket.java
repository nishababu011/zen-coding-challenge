package com.zendesk.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Ticket
 */
public class Ticket {
	
	  private String _id;
	  
	  private String url;
	  
	  private String external_id;
	  
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone="GMT")
	  private Date created_at;
	  
	  private String type;
	  
	  private String subject;
	  
	  private String description;
	  
	  private String priority;
	  
	  private String status;
	  
	  private Long submitter_id;
	  
	  private Long assignee_id;
	  
	  private Long organization_id;
	  
	  private List<String> tags;
	   
	  private Boolean has_incidents;
	  
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone="GMT")
	  private Date due_at;
	  
	  private String via;
	  
	  

	@Override
	public String toString() {
		return "_id" +"\t"+"\t"+"\t"+ _id + "\n"
				+ "url" +"\t"+"\t"+"\t"+ url + "\n"
				+ "external_id" +"\t"+"\t"+ external_id + "\n"
				+ "created_at" +"\t"+"\t"+ created_at + "\n" 
				+ "type" +"\t"+"\t"+"\t"+ type + "\n"
				+ "subject" +"\t"+"\t"+"\t" + subject + "\n"
				+ "description" +"\t"+"\t"+ description + "\n"
				+ "priority" +"\t"+"\t"+ priority + "\n"
				+ "status" +"\t"+"\t"+"\t"+ status + "\n"
				+ "submitter_id" +"\t"+"\t"+ submitter_id + "\n"
				+ "assignee_id" +"\t"+"\t"+ assignee_id + "\n"
				+ "organization_id" +"\t"+"\t"+ organization_id + "\n"
				+ "tags" +"\t"+"\t"+"\t"+ tags + "\n"
				+ "has_incidents" +"\t"+"\t"+ has_incidents + "\n"
				+ "due_at" +"\t"+"\t"+"\t"+ due_at + "\n"
				+ "via" +"\t"+"\t"+"\t"+ via + "\n"+ "\n";
	}
	

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSubmitter_id() {
		return submitter_id;
	}

	public void setSubmitter_id(Long submitter_id) {
		this.submitter_id = submitter_id;
	}

	public Long getAssignee_id() {
		return assignee_id;
	}

	public void setAssignee_id(Long assignee_id) {
		this.assignee_id = assignee_id;
	}

	public Long getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(Long organization_id) {
		this.organization_id = organization_id;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Boolean isHas_incidents() {
		return has_incidents;
	}

	public void setHas_incidents(Boolean has_incidents) {
		this.has_incidents = has_incidents;
	}

	public Date getDue_at() {
		return due_at;
	}

	public void setDue_at(Date due_at) {
		this.due_at = due_at;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	  
}
