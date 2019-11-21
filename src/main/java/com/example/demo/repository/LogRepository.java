package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.LogEntity;

@Repository
public interface LogRepository extends CrudRepository<LogEntity, Integer>
{
	

}
