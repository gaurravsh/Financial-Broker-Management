package com.fbm.finbrokermgmt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fbm.finbrokermgmt.entity.UserDetails;

@Repository
public interface UserRepository extends CrudRepository<UserDetails, Long> {
	
}
