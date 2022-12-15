package com.sparc.service.impl;

import java.util.ArrayList;
import java.util.List;
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

	@Override
	public String saveAllDoc(List<DoctorRequest> request) {
		List<Doctor> addDataToDoc = new ArrayList<Doctor>();
		try {
			request.forEach(x -> {
				Doctor addData = new Doctor();
				addData.setAddress(x.getAddress());
				addData.setEmail(x.getEmail());
				addData.setFirstName(x.getFirstName());
				addData.setGender(x.getGender());
				addData.setLastName(x.getLastName());
				addData.setMobile(x.getMobile());
				addData.setNote(x.getNote());
				addData.setPhotoLoc(x.getPhotoLoc());
				// addData.setSpecialization(request.getSpecId());
				/*
				 * Optional<Specialization> opt = specRepo.findById(x.getSpecId()); if
				 * (opt.isPresent()) { Specialization spe = opt.get();
				 * addData.setSpecialization(spe); }
				 */
				addData.setSpecialization(specRepo.findById(x.getSpecId()).get());
				addDataToDoc.add(addData);
			});
			List<Doctor> saveAll = doctorRepo.saveAll(addDataToDoc);
			if (saveAll.size() != 0)
				return "succes";
			else
				return "error";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Doctor> getAllDocBySpecid(Long id) {
		try {
			List<Doctor> list = doctorRepo.findByspecialization_id(id);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
