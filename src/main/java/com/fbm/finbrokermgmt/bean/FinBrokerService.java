package com.fbm.finbrokermgmt.bean;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import com.fbm.finbrokermgmt.dao.BrokerRepo;
import com.fbm.finbrokermgmt.dao.LendingRepo;
import com.fbm.finbrokermgmt.dao.UserRepo;
import com.fbm.finbrokermgmt.entity.BrokerDetails;
import com.fbm.finbrokermgmt.entity.UserDetails;
import com.fbm.finbrokermgmt.exception.FinBrokerException;

@Service
public class FinBrokerService {
	@Autowired
	BrokerRepo brokerRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	LendingRepo lendingRepo;

	public void preAuthenticate() {
		PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken("sampat2", "",
				null);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	/** Broker Table Related Functions. */
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

	public void deleteBroker(String brokerId) {
		brokerRepo.delete(Long.parseLong(brokerId));
	}

	/**
	 * User Table Related Functions.
	 * 
	 * @throws FinBrokerException
	 */
	public UserDetails addUser(String userId, String userName) throws FinBrokerException {
		preAuthenticate();
		String brokerId = SecurityContextHolder.getContext().getAuthentication().getName();
		BrokerDetails broker = brokerRepo.findByBrokerId(brokerId);
		if(broker==null)
			throw new FinBrokerException("The broker "+brokerId+" is not found.");
		try {
			UserDetails user = new UserDetails();
			user.setBroker(broker);
			user.setUserName(userName);
			user.setUserId(userId);
			return userRepo.save(user);
		} catch (Exception e) {
			throw new FinBrokerException(e.toString());
		}
	}

	public List<UserDetails> showUsers() throws FinBrokerException {
		preAuthenticate();
		String brokerId = SecurityContextHolder.getContext().getAuthentication().getName();
		if (brokerId == null) {
			throw new FinBrokerException("Broker Id not found. Bad SecurityContext.");
		}
		
		
		return userRepo.findByBrokerId(brokerId);
	}

	public List<UserDetails> getUser(String id) {
		return userRepo.findAll(Collections.singleton(Long.parseLong(id)));

	}

	/** Lending Table Related Functions. */
	public void addDeal(Map<String, String[]> dealMap) {

	}

}
