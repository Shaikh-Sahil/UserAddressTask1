package com.example.demo;


import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.*;
import com.example.demo.service.LoggService;
import com.example.demo.service.UsersService;


@RestController
@RequestMapping("/UsersN")
public class UsersController
{
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private LoggService loggService;

	
	
	
	@GetMapping(value = "/all")
	public List<Users> getAllUserss(HttpServletRequest req) 
	{

		String url=req.getRequestURL().toString();
		LocalDateTime startTime=LocalDateTime.now();

		
		List <Users> user = usersService.getAllUsers();
		 
		 
		LocalDateTime endTime=LocalDateTime.now();
		
		loggService.addLogs(url, startTime, endTime);
		 
		
		
		return (List<Users>) usersService.getAllUsers();

	}
	
	
	@GetMapping(value = "/getOne/{id}")
	public Users getUserById(HttpServletRequest req,@PathVariable Integer id) 
	{

		String url=req.getRequestURL().toString();
		LocalDateTime startTime=LocalDateTime.now();

		usersService.getOne(id);
		 
		LocalDateTime endTime=LocalDateTime.now();
		
		loggService.addLogs(url, startTime, endTime);
		 
		
		
		return usersService.getOne(id);


	}
	
	
	@PostMapping(value = "/add")
	public List<Users> addUsers(@Valid @RequestBody Users Users,HttpServletRequest req)
	{
		String url=req.getRequestURL().toString();
		LocalDateTime startTime=LocalDateTime.now();

		usersService.addUsers(Users);
		
		LocalDateTime endTime=LocalDateTime.now();
		
		loggService.addLogs(url, startTime, endTime);
		
		return (List<Users>) usersService.getAllUsers();

	}

	
	@PutMapping(value = "/update/{id}")
	public List<Users> updateDetails(@RequestBody Users users,@PathVariable int id,HttpServletRequest req)
	{
		String url=req.getRequestURL().toString();
		LocalDateTime startTime=LocalDateTime.now();
		
		usersService.updateUsersDetails(users,id);
		
		LocalDateTime endTime=LocalDateTime.now();
		loggService.addLogs(url, startTime, endTime); 
		
		return (List<Users>) usersService.getAllUsers();

	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public List<Users> addUsers(@PathVariable int id,HttpServletRequest req)
	{
		String url=req.getRequestURL().toString();
		LocalDateTime startTime=LocalDateTime.now();
		
		usersService.deleteUsers(id);
		
		LocalDateTime endTime=LocalDateTime.now();
		loggService.addLogs(url, startTime, endTime); 
		return (List<Users>) usersService.getAllUsers();

	}

}
