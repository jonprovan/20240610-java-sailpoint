package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Permission;


@Repository
public interface PermissionRepository extends CrudRepository<Permission, Integer> {
	
	@Query
	public Permission findByName(String name);

}
