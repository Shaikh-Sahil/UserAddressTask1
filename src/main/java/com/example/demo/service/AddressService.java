package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Address;

import com.example.demo.repository.AddressRepository;

@Service
public class AddressService
{

	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> getAllAddress()
	{
		return (List<Address>) addressRepository.findAll();
	}
	
	public List<Address> addAddress(Address address)
	{
		addressRepository.save(address);
		return (List<Address>) addressRepository.findAll();
	}
	
	public List<Address> deleteAddress(int id)
	{
		addressRepository.deleteById(id);		
		return (List<Address>) addressRepository.findAll();
	}
	
	public List<Address> updateAddressDetails(Address address,int id)
	{
		
		Address dbObj =  addressRepository.findById(id).get();
		System.out.println("Printing oBject from db");
		System.out.println(dbObj.toString());
		
		if(dbObj!=null)
		{
				
				dbObj.setCity(address.getCity());
				
				
				System.out.println(dbObj.toString());
		}
			addressRepository.save(dbObj);
			
		return (List<Address>) addressRepository.findAll();
		
	}

	public  Address getOne(Integer id)
	{
		
		return addressRepository.findById(id).get();
	}

}
