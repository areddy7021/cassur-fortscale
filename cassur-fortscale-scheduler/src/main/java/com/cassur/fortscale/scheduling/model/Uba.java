package com.cassur.fortscale.scheduling.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An entity User composed by three fields (id, email, name). The Entity
 * annotation indicates that this class is a JPA entity. The Table annotation
 * specifies the name for the table in the db.
 *
 * @author netgloo
 */
@Entity
@Table(name = "uba")
public class Uba implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "UBA_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int ubaId;
	
	@Column(name = "User_Id")
	private int userId;
	
	@Column(name = "User_Risk_Score")
	private int userRiskScore;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="uba")
	public CassurUser cassurUser;

	public int getUserRiskScore() {
		return userRiskScore;
	}

	public void setUserRiskScore(int userRiskScore) {
		this.userRiskScore = userRiskScore;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date_Time")
	private java.util.Date dateTime;

	public int getUbaId() {
		return ubaId;
	}

	public void setUbaId(int ubaId) {
		this.ubaId = ubaId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public java.util.Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(java.util.Date dateTime) {
		this.dateTime = dateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CassurUser getCassurUser() {
		return cassurUser;
	}

	public void setCassurUser(CassurUser cassurUser) {
		this.cassurUser = cassurUser;
	}

	
	
} 
