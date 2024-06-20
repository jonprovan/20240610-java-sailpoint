package com.skillstorm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Certification;

@Repository
public interface CertificationRepository extends CrudRepository<Certification, Integer> {

}
