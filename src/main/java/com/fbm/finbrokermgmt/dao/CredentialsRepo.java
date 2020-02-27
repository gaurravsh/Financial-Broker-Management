package com.fbm.finbrokermgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fbm.finbrokermgmt.entity.CredentialsDetails;

@Repository
public interface CredentialsRepo extends JpaRepository<CredentialsDetails, Long> {

}
