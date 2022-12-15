package com.sparc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
			spec.setActiveStatus(true);
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
			addData.setActiveStatus(true);
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
				addData.setActiveStatus(true);
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
		List<Specialization> findAll = specRepo.findAll().stream().filter(y -> y.getActiveStatus() ==true)
				.collect(Collectors.toList());
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

	@Override
	public Specialization getSpecDataByIdUsingRP(Long id) {
		try {
			Optional<Specialization> opt = specRepo.findById(id);
			if (opt.isPresent())
				return opt.get();
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public String updateSpecDataBySpecId(Specialization spec) {
		try {
			Optional<Specialization> opt = specRepo.findById(spec.getId());
			if (opt.isPresent()) {
				Specialization specData = opt.get();
				if (spec.getSpecCode() != null)
					specData.setSpecCode(spec.getSpecCode());
				if (spec.getSpecName() != null)
					specData.setSpecName(spec.getSpecName());
				if (spec.getSpecNote() != null)
					specData.setSpecNote(spec.getSpecNote());
				Specialization save = specRepo.save(specData);
				if (save != null)
					return "success";
				else
					return "error";
			} else
				return "invalidId";
		} catch (Exception e) {
			e.printStackTrace();
			return "InternalServerError";
		}
	}

	@Override
	public String deleteSpecDataById(Long id) {
		Optional<Specialization> findById = specRepo.findById(id);
		if (findById.isPresent()) {
			Specialization specialization = findById.get();
			//specRepo.delete(specialization);
			specialization.setActiveStatus(false);
			Specialization save = specRepo.save(specialization);
			if (save != null)
				return "success";
			else
				return "error";
		} else
			return "invalidId";
	}
	
	@Override
	public List<Specialization> getAllSpecBySpecCode(String specCode) {
		try {
			//List<Specialization> list = specRepo.findAllSpecBySpecCode(specCode);
			//List<Specialization> list = specRepo.findAllSpecBySpecCodeJpa(specCode);
			List<Specialization> list = specRepo.findBySpecCode(specCode);
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
