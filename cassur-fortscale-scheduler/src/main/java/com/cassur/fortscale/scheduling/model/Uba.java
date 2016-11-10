package com.cassur.fortscale.scheduling.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name = "uba_id")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int ubaId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_risk_score")
	private int userRiskScore;
    
	public int getUserRiskScore() {
		return userRiskScore;
	}

	public void setUserRiskScore(int userRiskScore) {
		this.userRiskScore = userRiskScore;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time")
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

	
	
} 
