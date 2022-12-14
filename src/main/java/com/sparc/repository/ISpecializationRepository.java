package com.sparc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparc.entity.Specialization;

public interface ISpecializationRepository extends JpaRepository<Specialization, Long> {
}
