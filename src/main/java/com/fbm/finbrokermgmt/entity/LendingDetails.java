package com.fbm.finbrokermgmt.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="lendingdetails")
public class LendingDetails {
	@Id
	@SequenceGenerator(initialValue = 1,name = "deal_id_generator")
	private long recordId;
	
	
	@ManyToOne
	@JoinColumn(name = "lender_id", foreignKey = @ForeignKey(name="lender_fkey"))
	private UserDetails lender;
	
	@ManyToOne
	@JoinColumn(name = "borrower_id", foreignKey = @ForeignKey(name="borrower_fkey"))
	private UserDetails borrower;
	
	
	
	/*
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "lenderId", foreignKey = @ForeignKey(name="lender_fkey")),
		@JoinColumn(name = "borrowerId", foreignKey = @ForeignKey(name="borrower_fkey"))
	})
	private UserDetails user;
	*/
	@ManyToOne
	@JoinColumn(name = "broker_id", foreignKey = @ForeignKey(name="broker_fkey"))
	private BrokerDetails broker;
	
	private double rate;
	
	private long amount;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date bookingDate;
	
	@Formula(value =  "TimeUnit.DAYS.convert(endDate.getTime()-startDate.getTime(), TimeUnit.MILLISECONDS)")
	private long durationInDays;
	
	@Formula(value = "amount*rate/100 * (durationInDays/365.0)")
	private double totalAmount;

	public long getRecordId() {
		return recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}

	public BrokerDetails getBroker() {
		return broker;
	}

	public void setBroker(BrokerDetails broker) {
		this.broker = broker;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getDurationInDays() {
		return durationInDays;
	}

	public void setDurationInDays(long durationInDays) {
		this.durationInDays = durationInDays;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
