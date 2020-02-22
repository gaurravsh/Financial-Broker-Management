package com.fbm.finbrokermgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fbm.finbrokermgmt.entity.BrokerDetails;

@Repository
public interface BrokerRepository extends JpaRepository<BrokerDetails, Long> {

}
