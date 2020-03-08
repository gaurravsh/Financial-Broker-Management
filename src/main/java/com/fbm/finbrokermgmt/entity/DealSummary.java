package com.fbm.finbrokermgmt.entity;

public interface DealSummary {
	String getLenderId();
	String getBorrowerId();
	String getRate();
	String getAmount();
	String getStartDate();
	String getEndDate();
	String getBookingDate();
	String getDurationInDays();
	String getFinalAmount();
}
