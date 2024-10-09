package com.mingo.dao.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mingo.entity.AuthDetail;

public interface AuthenticationRepository extends CrudRepository<AuthDetail, String> {
	Optional<AuthDetail> findByEmail(String email);
}
