package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>
{
	

}
