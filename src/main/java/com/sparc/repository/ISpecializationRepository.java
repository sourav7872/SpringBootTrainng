package com.sparc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sparc.entity.Specialization;

public interface ISpecializationRepository extends JpaRepository<Specialization, Long> {
	
	//native Query
	@Query(value = "select * from healthcare.spec_tab where spec_code_col=:specCode",nativeQuery = true )
	List<Specialization>findAllSpecBySpecCode(String specCode);
	//jpa query	
	@Query(value = "select s from Specialization s  where s.specCode=:specCode")
	List<Specialization>findAllSpecBySpecCodeJpa(String specCode);
	//finder method	
	List<Specialization>findBySpecCode(String specCode);
	
}
