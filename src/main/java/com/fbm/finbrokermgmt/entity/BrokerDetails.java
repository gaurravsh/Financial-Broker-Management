package com.fbm.finbrokermgmt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="brokerdetails")
public class BrokerDetails implements Serializable{

	private static final long serialVersionUID = 5128156072309668461L;

	@Id
	@SequenceGenerator(initialValue = 1,name = "broker_id_seq")
	@Column(name = "id")
	private long id;

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
