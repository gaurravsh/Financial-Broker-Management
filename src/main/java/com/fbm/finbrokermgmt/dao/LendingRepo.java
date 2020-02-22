package com.fbm.finbrokermgmt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fbm.finbrokermgmt.entity.LendingDetails;

@Repository
public interface LendingRepo extends CrudRepository<LendingDetails, Long> {
	
}
