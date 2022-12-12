package com.sparc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparc.request.DoctorRequest;
import com.sparc.service.IDoctorService;

@RestController
@RequestMapping("/api/doc")
public class DoctorController {
	
	@Autowired
	private IDoctorService docService;
	
	@PostMapping("/saveDoc")
	public String saveDoctor(@RequestBody DoctorRequest request) {		
	String msg=	docService.saveDoctor(request);
	return msg;
		
	}

}