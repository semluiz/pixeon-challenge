package com.pixeon.restapi.controller;


import com.pixeon.restapi.model.Patient;
import com.pixeon.restapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/patient-api")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/patient")
    public ResponseEntity<?> save(@RequestBody Patient patient) {
        try {
            return new ResponseEntity<>(patientRepository.save(patient), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patients")
    public ResponseEntity<?> findAll() {
        try {
            List<Patient> patients = patientRepository.findAll();
            return new ResponseEntity<>(patients, HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/patient/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        try {
            return new ResponseEntity<>(patientRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/patient")
    public ResponseEntity<?> update(@RequestBody Patient patient) {
        try {
            return new ResponseEntity<>(patientRepository.save(patient), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping("patient/{id}")
    public ResponseEntity<?> deleteById(@PathVariable (value = "id") Integer id){
        try{
            patientRepository.deleteById(id);
            String message = "Patient Deleted Successfully";
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
