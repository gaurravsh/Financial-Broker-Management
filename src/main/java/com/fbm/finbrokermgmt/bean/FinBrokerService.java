package com.fbm.finbrokermgmt.bean;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbm.finbrokermgmt.dao.BrokerRepository;
import com.fbm.finbrokermgmt.dao.LendingRepo;
import com.fbm.finbrokermgmt.dao.UserRepository;
import com.fbm.finbrokermgmt.entity.BrokerDetails;

@Service
public class FinBrokerService {
	@Autowired
	BrokerRepository brokerRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	LendingRepo lendingRepo;
	
	
	/**Broker Table Related Functions. */
	public BrokerDetails addBroker(String brokerName) {
		return brokerRepo.save(new BrokerDetails(brokerName));
	}
	
	public List<BrokerDetails> getAllBrokers() {
		return brokerRepo.findAll();
	}
	
	public void deleteBroker(String brokerId) {
		brokerRepo.delete(Long.parseLong(brokerId));
	}
	
	
	/**User Table Related Functions. */
	public void addUser(Map<String, String[]> userMap) {
		
	}

	
	/**Lending Table Related Functions. */
	public void addDeal(Map<String, String[]> dealMap) {
		
	}

	

}
