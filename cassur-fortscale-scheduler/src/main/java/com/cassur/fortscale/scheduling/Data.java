package com.cassur.fortscale.scheduling;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

	private String id;

	private String administratorAccount;

	private String executiveAccount;

	private String userServiceAccount;

	private String displayName;

	private String username;

	private String noDomainUsername;

	private String followed;

	private String searchField;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdministratorAccount() {
		return administratorAccount;
	}

	public void setAdministratorAccount(String administratorAccount) {
		this.administratorAccount = administratorAccount;
	}

	public String getExecutiveAccount() {
		return executiveAccount;
	}

	public void setExecutiveAccount(String executiveAccount) {
		this.executiveAccount = executiveAccount;
	}

	public String getUserServiceAccount() {
		return userServiceAccount;
	}

	public void setUserServiceAccount(String userServiceAccount) {
		this.userServiceAccount = userServiceAccount;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNoDomainUsername() {
		return noDomainUsername;
	}

	public void setNoDomainUsername(String noDomainUsername) {
		this.noDomainUsername = noDomainUsername;
	}

	public String getFollowed() {
		return followed;
	}

	public void setFollowed(String followed) {
		this.followed = followed;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	//

}