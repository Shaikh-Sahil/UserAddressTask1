package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LogEntity;

import com.example.demo.service.LoggService;

@RestController
@RequestMapping("/getLogs")
public class LogController
{
	@Autowired
	private LoggService loggService;
	
	@GetMapping(value = "/all")
	public List<LogEntity> getAllLogDetails(@RequestParam(name = "start",required = false, defaultValue = "0" ) int start,
			@RequestParam (name = "size",required = false, defaultValue = "0" ) int size,
			HttpServletRequest req)
	{
		String url=req.getRequestURL().toString();
		LocalDateTime startTime=LocalDateTime.now();

		
		@SuppressWarnings("unused")
		List<LogEntity> user = loggService.getAllLogs();
		 
		 
		LocalDateTime endTime=LocalDateTime.now();
		
		loggService.addLogs(url, startTime, endTime);
		 
		
		if(start>0 && size>=0)
			return loggService.getPaginatedLogs(start-1,size);
			
		return (List<LogEntity>) loggService.getAllLogs();
	
	}
}
