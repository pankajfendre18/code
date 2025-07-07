package com.example.cab_book_driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.cab_book_driver.service.constant.AppConstant;

@Service
public class CabLocationService {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public boolean updateLocation(String location) {
		kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
		return true;
	}

}
