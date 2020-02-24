package com.fbm.finbrokermgmt.bean;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbm.finbrokermgmt.dao.BrokerRepository;
import com.fbm.finbrokermgmt.dao.LendingRepo;
import com.fbm.finbrokermgmt.dao.UserRepository;
import com.fbm.finbrokermgmt.entity.BrokerDetails;
import com.fbm.finbrokermgmt.entity.UserDetails;
import com.fbm.finbrokermgmt.security.IAuthenticationFacade;

@Service
public class FinBrokerService {
	@Autowired
	BrokerRepository brokerRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	LendingRepo lendingRepo;
	
	@Autowired
    private IAuthenticationFacade authenticationFacade;
	
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
	public UserDetails addUser(String userName) {
		String brokerId = ((Principal)authenticationFacade.getAuthentication().getPrincipal()).getName();
		BrokerDetails broker = brokerRepo.findOne(Long.parseLong(brokerId));
		UserDetails user = new UserDetails();
		user.setBroker(broker);
		user.setUserName(userName);
		return userRepo.save(user);
	}

	
	/**Lending Table Related Functions. */
	public void addDeal(Map<String, String[]> dealMap) {
		
	}

	

}
