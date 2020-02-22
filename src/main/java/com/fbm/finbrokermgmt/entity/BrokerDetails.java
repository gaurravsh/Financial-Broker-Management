package com.fbm.finbrokermgmt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BrokerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long brokerId;
	
	private String brokerName;
	
	public BrokerDetails(String brokerName) {
		this.brokerName=brokerName;
	}
	
	public BrokerDetails() {}

	public long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(long brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}
}
