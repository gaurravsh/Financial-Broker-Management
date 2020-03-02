package com.fbm.finbrokermgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="brokerdetails")
public class BrokerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id;

	@NaturalId
	@Column(name="brokerId",unique = true,nullable=false)
	private String brokerId;
	
	@Column(name="brokerName",nullable=false)
	private String brokerName;
	
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
		return brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}
}
