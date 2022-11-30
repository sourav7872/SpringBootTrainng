package com.sparc.service;

import com.sparc.entity.Specialization;
import com.sparc.request.SpecRequest;

public interface ISpecService {

	String saveSpec(Specialization spec);

	String saveSpec(SpecRequest request);

}
