package com.fbm.finbrokermgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fbm.finbrokermgmt.entity.BrokerDetails;

@Repository
public interface BrokerRepo extends JpaRepository<BrokerDetails, Long>{
	public BrokerDetails findByBrokerId(String brokerId);
}
