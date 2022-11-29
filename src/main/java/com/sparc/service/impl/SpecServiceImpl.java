package com.sparc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparc.repository.ISpecializationRepository;
import com.sparc.service.ISpecService;

@Service
public class SpecServiceImpl implements ISpecService {
	
	@Autowired
	private ISpecializationRepository specRepo;

}
