package com.air.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.air.service.IdGeneratorService;

@RestController
@RequestMapping("/api/generate-id")
public class IdGeneratorController {

	@Autowired
	IdGeneratorService idService;
	
	@GetMapping
	public String getGeneratedId() {
		return idService.generateId();
	}
}
