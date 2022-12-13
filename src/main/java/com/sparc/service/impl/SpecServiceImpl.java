package com.sparc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public String saveSpec(SpecRequest request) {
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

	@Override
	public String saveAllSpecData(List<Specialization> specList) {
		List<Specialization> addDataToList = new ArrayList<Specialization>();
		try {
			specList.forEach(x -> {
				Specialization addData = new Specialization();
				addData.setSpecCode(x.getSpecCode());
				addData.setSpecName(x.getSpecName());
				addData.setSpecNote(x.getSpecNote());
				addDataToList.add(addData);
			});
			List<Specialization> saveAll = specRepo.saveAll(addDataToList);
			if (saveAll.size() != 0)
				return "success";
			else
				return "error";
		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
			return "InternalServerError";
		}
	}

	@Override
	public List<Specialization> getAllSpecData() {
		List<Specialization> findAll = specRepo.findAll();
		return findAll;
	}

	@Override
	public Specialization getSpecDataById(Long id) {
		Optional<Specialization> opt = specRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		else
			return null;
	}

}
