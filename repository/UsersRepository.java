package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.exapmle.demo.entity.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer>
{
	

}
