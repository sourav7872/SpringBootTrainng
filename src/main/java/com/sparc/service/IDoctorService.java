package com.sparc.service;

import java.util.List;

import com.sparc.entity.Doctor;
import com.sparc.request.DoctorRequest;

public interface IDoctorService {
	
	String saveDoctor(DoctorRequest request);

	String saveAllDoc(List<DoctorRequest> request);

	List<Doctor> getAllDocBySpecid(Long id);

	List<Doctor> getAllDoc();

}
