package com.sparc.service;

import java.util.List;

import com.sparc.entity.Specialization;
import com.sparc.request.SpecRequest;

public interface ISpecService {

	String saveSpec(Specialization spec);

	String saveSpec(SpecRequest request);

	String saveAllSpecData(List<Specialization> specList);

	List<Specialization> getAllSpecData();

	Specialization getSpecDataById(Long id);

	Specialization getSpecDataByIdUsingRP(Long id);

	String updateSpecDataBySpecId(Specialization spec);

	String deleteSpecDataById(Long id);

}
