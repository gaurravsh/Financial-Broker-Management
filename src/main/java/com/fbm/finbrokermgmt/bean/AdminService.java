package com.fbm.finbrokermgmt.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fbm.finbrokermgmt.dao.BrokerRepo;
import com.fbm.finbrokermgmt.entity.BrokerDetails;
import com.fbm.finbrokermgmt.exception.FinBrokerException;

@Service
public class AdminService {
	@Autowired
	BrokerRepo brokerRepo;
	
	/** Broker Table Related Functions. Owned by Admin.*/
	
	
	public BrokerDetails addBroker(String brokerId, String brokerName) throws FinBrokerException {
		try {
			return brokerRepo.save(new BrokerDetails(brokerId, brokerName));
		} catch (DataIntegrityViolationException e) {
			throw new FinBrokerException("BrokerId '" + brokerId + "' already exists.");
		}
	}

	public List<BrokerDetails> getAllBrokers() {
		return brokerRepo.findAll();
	}

	@Transactional
	public void deleteBroker(String brokerId) {
		brokerRepo.deleteByBrokerId(brokerId);
	}
}
