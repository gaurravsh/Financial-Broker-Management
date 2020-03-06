package com.fbm.finbrokermgmt.bean;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import com.fbm.finbrokermgmt.dao.BrokerRepo;
import com.fbm.finbrokermgmt.dao.LendingRepo;
import com.fbm.finbrokermgmt.dao.UserRepo;
import com.fbm.finbrokermgmt.entity.BrokerDetails;
import com.fbm.finbrokermgmt.entity.LendingDetails;
import com.fbm.finbrokermgmt.entity.UserDetails;
import com.fbm.finbrokermgmt.entity.UserIdAndName;
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
		PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken("sampat", "",
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
		System.out.println("brokerid : " + brokerId);
		if (broker == null)
			throw new FinBrokerException("The broker " + brokerId + " is not found.");

		UserDetails user = new UserDetails();
		user.setBroker(broker);
		user.setUserName(userName);
		user.setUserId(userId);
		return userRepo.save(user);

	}

	public List<UserIdAndName> showUsers() throws FinBrokerException {
		preAuthenticate();
		String brokerId = SecurityContextHolder.getContext().getAuthentication().getName();
		if (brokerId == null) {
			throw new FinBrokerException("Broker Id not found. Bad SecurityContext.");
		}
		return userRepo.findByBrokerId(brokerId);
	}

	/**
	 * Lending Table Related Functions.
	 * 
	 * @throws FinBrokerException
	 */
	public LendingDetails addDeal(String borrowerId, String lenderId, double rate, long amount, Date startDate,
			Date endDate) throws FinBrokerException {
		preAuthenticate();
		String brokerId = SecurityContextHolder.getContext().getAuthentication().getName();
		BrokerDetails broker = brokerRepo.findByBrokerId(brokerId);
		System.out.println("broker = "+brokerId);
		System.out.println("broker object : "+broker.toString());
		LendingDetails deal = new LendingDetails();
		if (lenderId.equals(borrowerId))
			throw new FinBrokerException("Both lender and borrower are set as " + lenderId);
		UserDetails lender = userRepo.findByUserId(lenderId).get(0);
		UserDetails borrower = userRepo.findByUserId(borrowerId).get(0);
		deal.setAmount(amount);
		deal.setBookingDate(new Date());
		deal.setBorrower(borrower);
		deal.setBroker(broker);
		deal.setLender(lender);
		deal.setRate(rate);
		deal.setStartDate(startDate);
		deal.setEndDate(endDate);
		long durationInDays = TimeUnit.DAYS.convert(endDate.getTime()-startDate.getTime(), TimeUnit.MILLISECONDS);
		deal.setDurationInDays(durationInDays);
		deal.setFinalAmount(amount*rate/100 * (durationInDays/365.0));
		return lendingRepo.save(deal);
	}

}
