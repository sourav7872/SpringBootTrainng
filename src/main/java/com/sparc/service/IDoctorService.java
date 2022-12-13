package com.sparc.service;

import java.util.List;

import com.sparc.request.DoctorRequest;

public interface IDoctorService {
	
	String saveDoctor(DoctorRequest request);

	String saveAllDoc(List<DoctorRequest> request);

}
