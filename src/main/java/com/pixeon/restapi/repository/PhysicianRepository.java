package com.pixeon.restapi.repository;

import com.pixeon.restapi.model.Physician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicianRepository extends JpaRepository<Physician, Integer> {
}
