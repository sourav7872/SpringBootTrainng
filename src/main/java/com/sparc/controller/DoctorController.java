package com.sparc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparc.entity.Doctor;
import com.sparc.request.DoctorRequest;
import com.sparc.response.ApiMessageResponse;
import com.sparc.service.IDoctorService;

@RestController
@RequestMapping("/api/doc")
public class DoctorController {

	@Autowired
	private IDoctorService docService;

	@PostMapping("/saveDoc")
	public String saveDoctor(@RequestBody DoctorRequest request) {
		String msg = docService.saveDoctor(request);
		return msg;
	}

	@PostMapping(value = "/saveAllDoc",consumes = "text/html")
	public ResponseEntity<?> saveAllDoc(@RequestBody List<DoctorRequest> request) {
		String msg = docService.saveAllDoc(request);
		return ResponseEntity.ok(new ApiMessageResponse(msg));
	}

	@GetMapping("/getAllDocBySpecid/{id}")
	public ResponseEntity<?> getAllDocBySpecid(@PathVariable Long id) {
		List<Doctor> list = docService.getAllDocBySpecid(id);
		if (list.size() != 0)
			return ResponseEntity.ok(list);
		else
			return new ResponseEntity<>(new ApiMessageResponse("notFOund"), HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getAllDoc")
	public ResponseEntity<?> getAllDoc() {
		List<Doctor> list = docService.getAllDoc();
		return ResponseEntity.ok(list);
	}

}
