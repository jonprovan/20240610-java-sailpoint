package com.skillstorm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Detail;

@Repository
public interface DetailRepository extends CrudRepository<Detail, Integer> {

}
