package com.example.cab_book_driver.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cab_book_driver.service.CabLocationService;

@RestController
@RequestMapping("/location")
public class CabLocationController {

	@Autowired
	private CabLocationService cabLocationService;

	@PutMapping
	public ResponseEntity<Map<String, String>> updateLocation() {

		int range = 100;
		while (range > 0) {
			cabLocationService.updateLocation(Math.random() + " , " + Math.random());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			range--;

		}

		return new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);
	}
}
