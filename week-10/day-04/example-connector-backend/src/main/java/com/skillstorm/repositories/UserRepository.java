package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.User;
import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query
	public User findByUsername(String username);

}