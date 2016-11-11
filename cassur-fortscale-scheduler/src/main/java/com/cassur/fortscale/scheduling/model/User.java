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
@Table(name = "users_fortscale")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
    
	@Column(columnDefinition="JSON")
	@JsonProperty("data")
	private String data;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private java.util.Date createdAt;
	
	

	@PrePersist
	protected void onCreate() {
	    createdAt = new Timestamp((new Date()).getTime());
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public java.util.Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(java.util.Date createdAt) {
		this.createdAt = createdAt;
	}

} 
