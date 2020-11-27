package com.pixeon.restapi.controller;


import com.pixeon.restapi.model.HealthCareInstitution;
import com.pixeon.restapi.model.Patient;
import com.pixeon.restapi.repository.HealthCareInstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "healthCare-api")
public class HealthCareInstitutionController {

    @Autowired
    private HealthCareInstitutionRepository healthCareInstitutionRepository;

    @PostMapping("/healthcare")
    public ResponseEntity<?> save(@RequestBody HealthCareInstitution healthCareInstitution, @RequestParam("pixelCoins")BigDecimal pixelCoins) {
        try {
            return new ResponseEntity<>(healthCareInstitutionRepository.save(healthCareInstitution), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/healthcares")
    public ResponseEntity<?> findAll() {
        try {
            List<HealthCareInstitution> healthCareInstitutions = healthCareInstitutionRepository.findAll();
            return new ResponseEntity<>(healthCareInstitutions, HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/healthcare/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        try {
            return new ResponseEntity<>(healthCareInstitutionRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/healthcare")
    public ResponseEntity<?> update(@RequestBody HealthCareInstitution healthCareInstitution) {
        try {
            return new ResponseEntity<>(healthCareInstitutionRepository.save(healthCareInstitution), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping("healthcare/{id}")
    public ResponseEntity<?> deleteById(@PathVariable (value = "id") Integer id){
        try{
            healthCareInstitutionRepository.deleteById(id);
            String message = "healthcaree excluted successfully";
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
