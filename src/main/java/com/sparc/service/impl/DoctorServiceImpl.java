package com.sparc.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparc.entity.Doctor;
import com.sparc.entity.Specialization;
import com.sparc.repository.IDoctorRepo;
import com.sparc.repository.ISpecializationRepository;
import com.sparc.request.DoctorRequest;
import com.sparc.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo doctorRepo;

	@Autowired
	private ISpecializationRepository specRepo;

	@Override
	public String saveDoctor(DoctorRequest request) {
		try {
			Doctor addData = new Doctor();
			addData.setAddress(request.getAddress());
			addData.setEmail(request.getEmail());
			addData.setFirstName(request.getFirstName());
			addData.setGender(request.getGender());
			addData.setLastName(request.getLastName());
			addData.setMobile(request.getMobile());
			addData.setNote(request.getNote());
			addData.setPhotoLoc(request.getPhotoLoc());
			// addData.setSpecialization(request.getSpecId());
			Optional<Specialization> opt = specRepo.findById(request.getSpecId());
			if (opt.isPresent()) {
				Specialization spe = opt.get();
				addData.setSpecialization(spe);
			} else
				return "SpecIdNotPresent";

			// addData.setSpecialization(specRepo.findById(request.getSpecId()).get());
			// addData.setSpecialization(specRepo.findById(request.getSpecId()).orElse(null));

			Long id = doctorRepo.save(addData).getId();
			return id != null ? "success" : "problem";

		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}

}
