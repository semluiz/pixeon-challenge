package com.pixeon.restapi.repository;

import com.pixeon.restapi.model.HealthCareInstitution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthCareInstitutionRepository extends JpaRepository<HealthCareInstitution, Integer> {
}
