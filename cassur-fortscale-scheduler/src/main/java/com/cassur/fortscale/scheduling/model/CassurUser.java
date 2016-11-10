package com.cassur.fortscale.scheduling.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * An entity User composed by three fields (id, email, name). The Entity
 * annotation indicates that this class is a JPA entity. The Table annotation
 * specifies the name for the table in the db.
 *
 * @author netgloo
 */
@Entity
@Table(name = "users")
public class CassurUser implements Serializable {

	@Id 
	@Column(name = "User_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int userId;
	
	
	@Column(name = "Client_ID")
	private int clientId;
	
	@Column(name = "Username")
	private String userName;
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date_Time")
	private java.util.Date dateTime;
	
	private Uba uba;
	
    @OneToOne
	@PrimaryKeyJoinColumn
	private Client client;

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public java.util.Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(java.util.Date dateTime) {
		this.dateTime = dateTime;
	}

	public Uba getUba() {
		return uba;
	}

	public void setUba(Uba uba) {
		this.uba = uba;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
} 
