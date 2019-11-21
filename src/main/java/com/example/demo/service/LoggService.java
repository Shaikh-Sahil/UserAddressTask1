package com.example.demo.service;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.LogEntity;

import com.example.demo.repository.LogRepository;


@Service
public class LoggService 
{
	@Autowired(required=true)
	private LogRepository logRespository;
	
	public void addLogs(String url, LocalDateTime start, LocalDateTime end)
	{		
		System.out.println("into Logs add");
		LogEntity logEntity = new LogEntity();
		
		logEntity.setLogId(null);
		logEntity.setUrl(url);
		logEntity.setStartTime(start);
		logEntity.setEndTime(end);

		logRespository.save(logEntity);
	
	}



	public List<LogEntity> getAllLogs() 
	{
		System.out.println("In finding all logs");
		return  (List<LogEntity>) logRespository.findAll();
	}



	public List<LogEntity> getPaginatedLogs(int s, int size)
	{
		List<LogEntity> listLog = new ArrayList<>();
		logRespository.findAll().forEach(listLog::add);
		
		if(s>listLog.size() || size==0)
			return null;
		else if(s+size>listLog.size())
			return listLog.subList(s, listLog.size());
		else
			return listLog.subList(s, s+size);

	
	}
	
	

}
