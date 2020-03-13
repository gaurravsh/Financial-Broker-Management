package com.fbm.finbrokermgmt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="brokerdetails")
public class BrokerDetails implements Serializable{

	private static final long serialVersionUID = 5128156072309668461L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name="brokerId",unique = true,nullable=false)
	private String brokerId;
	
	@Column(name="brokerName",nullable=false)
	private String brokerName;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "broker")
	private List<UserDetails> users;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "broker")
	private List<LendingDetails> dealsCracked;
	
	public BrokerDetails(String brokerId,String brokerName) {
		this.brokerId=brokerId;
		this.brokerName=brokerName;
	}
	
	public BrokerDetails() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrokerId() {
		return brokerId.toLowerCase();
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId.toLowerCase();
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}
}
