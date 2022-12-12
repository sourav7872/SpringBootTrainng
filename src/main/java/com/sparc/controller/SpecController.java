package com.sparc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sparc.entity.Specialization;
import com.sparc.request.SpecRequest;
import com.sparc.service.ISpecService;

@RestController
@RequestMapping("/api/spec")
public class SpecController {
	
	@Autowired
	private ISpecService specService;
	
	//@PostMapping("/save")
	@PostMapping(value = {"/save","/saveSpec"})
	//@RequestMapping(method = RequestMethod.POST,value ={"/save","/saveSpec"})
	public String saveSpec(@RequestBody Specialization spec) {
		String msg=specService.saveSpec(spec);
		return msg;
	}
	
	/*
	 * @PostMapping("/saveSpec")
	 * 
	 * public String saveSpec(@RequestBody SpecRequest request) { String
	 * msg=specService.saveSpec(request); return msg; }
	 */

}
