package com.fbm.finbrokermgmt.repo;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.fbm.finbrokermgmt.dao.BrokerRepo;
import com.fbm.finbrokermgmt.entity.BrokerDetails;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BrokerRepoTest {
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	private BrokerRepo repo;
	
	private static final String brokerName="Rajan Soni";
	
	@Test
	public void checkIfBrokerIsInserted() {
		BrokerDetails brokerEntity = new BrokerDetails(brokerName);
		BrokerDetails returnedBroker = repo.save(brokerEntity);
		List<BrokerDetails> brokers = repo.findAll();
		assertTrue(brokers.contains(returnedBroker));
	}
}
