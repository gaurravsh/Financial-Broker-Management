package com.fbm.finbrokermgmt.dao;

import org.springframework.data.repository.CrudRepository;

import com.fbm.finbrokermgmt.entity.UserDetails;

public interface UserRepository extends CrudRepository<UserDetails, Long> {
	
}
