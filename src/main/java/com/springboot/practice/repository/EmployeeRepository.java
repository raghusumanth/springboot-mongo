package com.springboot.practice.repository;

import com.springboot.practice.entity.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity,Long> {

    @Query("{id:'?0'}")
    EmployeeEntity findEmployeeById(Long id);

    public long count();

    @Query("{name:'?0'}")
    List<EmployeeEntity> findAll(String name);
}
