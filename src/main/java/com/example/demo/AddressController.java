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

import com.example.demo.entities.Address;
import com.example.demo.service.AddressService;
import com.example.demo.service.LoggService;

@RestController
@RequestMapping("/addressN")
public class AddressController 
{
	
	@Autowired
	private AddressService addressService;
	@Autowired
	private LoggService loggService;
	
	@GetMapping(value = "/all")
	public List<Address> getAllAddresss(HttpServletRequest req) 
	{

		String url=req.getRequestURL().toString();
		LocalDateTime startTime=LocalDateTime.now();

		
		List <Address> address = addressService.getAllAddress();
		 
		 
		LocalDateTime endTime=LocalDateTime.now();
		
		loggService.addLogs(url, startTime, endTime);
		 
		
		
		return (List<Address>) addressService.getAllAddress();

	}
	
	
	@GetMapping(value = "/getOne/{id}")
	public Address getaddressById(HttpServletRequest req,@PathVariable Integer id) 
	{

		String url=req.getRequestURL().toString();
		LocalDateTime startTime=LocalDateTime.now();

		addressService.getOne(id);
		 
		LocalDateTime endTime=LocalDateTime.now();
		
		loggService.addLogs(url, startTime, endTime);
		 
		
		
		return addressService.getOne(id);


	}
	
	
	@PostMapping(value = "/add")
	public List<Address> addAddress(@Valid @RequestBody Address address,HttpServletRequest req)
	{
		String url=req.getRequestURL().toString();
		LocalDateTime startTime=LocalDateTime.now();

		addressService.addAddress(address);
		
		LocalDateTime endTime=LocalDateTime.now();
		
		loggService.addLogs(url, startTime, endTime);
		
		return (List<Address>) addressService.getAllAddress();

	}

	
	@PutMapping(value = "/update/{id}")
	public List<Address> updateDetails(@RequestBody Address address,@PathVariable int id,HttpServletRequest req)
	{
		String url=req.getRequestURL().toString();
		LocalDateTime startTime=LocalDateTime.now();
		
		addressService.updateAddressDetails(address,id);
		
		LocalDateTime endTime=LocalDateTime.now();
		loggService.addLogs(url, startTime, endTime); 
		
		return (List<Address>) addressService.getAllAddress();

	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public List<Address> addAddress(@PathVariable int id,HttpServletRequest req)
	{
		String url=req.getRequestURL().toString();
		LocalDateTime startTime=LocalDateTime.now();
		
		addressService.deleteAddress(id);
		
		LocalDateTime endTime=LocalDateTime.now();
		loggService.addLogs(url, startTime, endTime); 
		return (List<Address>) addressService.getAllAddress();

	}

	

}
