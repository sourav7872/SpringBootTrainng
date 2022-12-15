package com.sparc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparc.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor,Long> {
	List<Doctor>findByspecialization_id(Long specId);

}
