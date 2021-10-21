package com.raden.diet_gram.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.raden.diet_gram.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	
	List<User> findAll();
	Optional<User> findByEmail(String email);

 }
