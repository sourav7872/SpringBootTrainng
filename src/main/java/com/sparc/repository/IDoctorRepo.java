package com.sparc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparc.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor,Long> {

}
