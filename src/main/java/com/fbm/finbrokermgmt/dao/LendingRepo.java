package com.fbm.finbrokermgmt.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fbm.finbrokermgmt.entity.LendingDetails;
import com.fbm.finbrokermgmt.entity.DealSummary;

@Repository
public interface LendingRepo extends CrudRepository<LendingDetails, Long> {
	List<DealSummary> findByBrokerId(String brokerId);
}
