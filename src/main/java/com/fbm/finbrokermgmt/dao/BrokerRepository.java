package com.fbm.finbrokermgmt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fbm.finbrokermgmt.entity.BrokerDetails;

@Repository
public interface BrokerRepository extends CrudRepository<BrokerDetails, Long> {

}
