package com.fbm.finbrokermgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fbm.finbrokermgmt.entity.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {
	
}
