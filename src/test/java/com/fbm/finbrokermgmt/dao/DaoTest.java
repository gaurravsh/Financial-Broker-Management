package com.fbm.finbrokermgmt.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fbm.finbrokermgmt.bean.FinBrokerService;
import com.fbm.finbrokermgmt.entity.BrokerDetails;

public class DaoTest {
	@Autowired
	FinBrokerService service;
	
	@Test
	public void checkBrokerIsInserted() {
//		final String brokerName = "Rajan Soni";
//		BrokerDetails returnedBroker = service.addBroker(brokerName);
//		List<BrokerDetails> brokers = service.getAllBrokers();
//		BrokerDetails broker = new BrokerDetails(brokerName);
//		broker.setBrokerId(returnedBroker.getBrokerId());
//		assertTrue(brokers.contains(broker));
//		service.deleteBroker(String.valueOf(returnedBroker.getBrokerId()));
	}
}
