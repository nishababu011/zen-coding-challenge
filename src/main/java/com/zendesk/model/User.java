package com.zendesk.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * User data.
 */
public class User {
	
	private Long _id;
	
	private String url;
	
	private String external_id;
	
	private String name;
	
	private String alias;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone="GMT")
	private Date created_at;
	
	private Boolean active;
	
	private Boolean verified;
	
	private Boolean shared;
	
	private String locale;
	
	private String timezone;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone="GMT")
	private Date last_login_at;
	
	private String email;
	
	private String phone;
	
	private String signature;
	
	private Long organization_id;
	
	private List<String> tags;
	
	private Boolean suspended;
	
	private String role;
	
	@Override
	public String toString() {
		return "_id" +"\t"+"\t"+"\t"+ _id + "\n" 
				+ "url"+"\t" +"\t"+"\t"+ url + "\n" 
				+ "external_id"+"\t"+"\t" + external_id + "\n"
				+ "name" +"\t" +"\t"+"\t"+ name + "\n"
				+ "alias" +"\t" +"\t"+"\t"+ alias + "\n"
				+ "created_at" +"\t"+"\t" + created_at + "\n" 
				+ "active" +"\t" +"\t"+"\t"+ active + "\n"
				+ "verified" +"\t" +"\t"+ verified + "\n"
				+ "shared" +"\t"+"\t"+"\t" + shared + "\n"
				+ "locale" +"\t"+"\t"+"\t" + locale + "\n"
				+ "timezone" +"\t" +"\t"+ timezone + "\n"
				+ "last_login_at" +"\t" +"\t"+ last_login_at + "\n"
				+ "email" +"\t" +"\t"+"\t"+ email + "\n"
				+ "phone" +"\t" +"\t"+"\t"+ phone + "\n"
				+ "signature" +"\t" +"\t"+ signature + "\n" 
				+ "organization_id" +"\t" +"\t"+ organization_id + "\n" 
				+ "tags" +"\t" +"\t"+"\t"+ tags + "\n"
				+ "suspended" +"\t" +"\t"+ suspended + "\n" 
				+ "role" +"\t"+"\t"+"\t" + role+ "\n"+ "\n";
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean isVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public Boolean isShared() {
		return shared;
	}

	public void setShared(Boolean shared) {
		this.shared = shared;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Date getLast_login_at() {
		return last_login_at;
	}

	public void setLast_login_at(Date last_login_at) {
		this.last_login_at = last_login_at;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
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

	public Boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(Boolean suspended) {
		this.suspended = suspended;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
