package com.sparc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sparc.entity.Specialization;
import com.sparc.repository.ISpecializationRepository;
import com.sparc.request.SpecRequest;
import com.sparc.service.ISpecService;

@Service
public class SpecServiceImpl implements ISpecService {

	@Autowired
	private ISpecializationRepository specRepo;

	@Override
	public String saveSpec(Specialization spec) {
		try {

			Long id = specRepo.save(spec).getId();
			// return id != null ? "success" : "error";
			if (id != null)
				return "success";
			else
				return "error";
		} catch (Exception e) {
			e.printStackTrace();
			return "Internal Problem";
		}

	}

	@Override
	public String saveSpec(SpecRequest  request) {
		try {
			Specialization addData = new Specialization();
			addData.setSpecCode(request.getSpecCode());
			addData.setSpecName(request.getSpecName());
			addData.setSpecNote(request.getSpecNote());
			Specialization save = specRepo.save(addData);
			return save != null ? "success" : "error";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
