package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repository.UsersRepository;



@Service
public class UsersService 
{
	@Autowired(required=true)
	private UsersRepository usersRepository;
	

	
	public List<Users> getAllUsers()
	{
		return (List<Users>) usersRepository.findAll();
	}
	
	//********************************************************//
	
	public List<Users> addUsers(Users users)
	{		
		usersRepository.save(users);
		return (List<Users>) usersRepository.findAll();
	}
	
	//********************************************************//

	
	public List<Users> deleteUsers(int id)
	{
		usersRepository.deleteById(id);		
		return (List<Users>) usersRepository.findAll();
	}
	
	//********************************************************//

	
	public List<Users> updateUsersDetails(Users users, int id)
	{
		Users dbObj =  usersRepository.findById(id).get();
		System.out.println("Printing oBject from db");
		System.out.println(dbObj.toString());
		
		if(dbObj!=null)
		{
				
				dbObj.setName(users.getName());
				dbObj.setEmail(users.getEmail());
				dbObj.setAddress(users.getAddress());
				
				System.out.println(dbObj.toString());
		}
			usersRepository.save(dbObj);		
		return (List<Users>) usersRepository.findAll();
	}
	
	//********************************************************//

	
	

	public Users getOne(Integer id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(id).get();
	}
	

}
