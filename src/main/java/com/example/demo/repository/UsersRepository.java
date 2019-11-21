package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Users;



@Repository
public interface UsersRepository extends CrudRepository<Users, Integer>
{
	

}
