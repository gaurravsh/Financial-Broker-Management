package com.fbm.finbrokermgmt.bean;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbm.finbrokermgmt.dao.BrokerRepository;
import com.fbm.finbrokermgmt.dao.UserRepository;

@Service
public class FinBrokerService {
	@Autowired
	BrokerRepository brokerRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	public void addUser(Map<String, String[]> userMap) {
		
	}

	public void addDeal(Map<String, String[]> dealMap) {
		
	}

}
