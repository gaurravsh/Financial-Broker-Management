package com.fbm.finbrokermgmt.constants;

public enum BrokerEnum {
	brokerName("brokerName"),
	brokerId("brokerId");
	
	private String field;
	
	BrokerEnum(String field) {
		this.field=field;
	}
	
	public String value() {
		return field;
	}
}
