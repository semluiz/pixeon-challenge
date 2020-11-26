package com.pixeon.restapi.controller;

import com.pixeon.restapi.model.Patient;
import com.pixeon.restapi.model.Physician;
import com.pixeon.restapi.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/physician-api")
public class PhysicianController {

    @Autowired
    private PhysicianRepository physicianRepository;

    @PostMapping("/physician")
    public ResponseEntity<?> save(@RequestBody Physician physician) {
        try {
            return new ResponseEntity<>(physicianRepository.save(physician), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/physicians")
    public ResponseEntity<?> findAll() {
        try {
            List<Physician> physicians = physicianRepository.findAll();
            return new ResponseEntity<>(physicians, HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/physician/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        try {
            return new ResponseEntity<>(physicianRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/physician")
    public ResponseEntity<?> update(@RequestBody Physician physician) {
        try {
            return new ResponseEntity<>(physicianRepository.save(physician), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping("/physician/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Integer id){
        try{
            physicianRepository.deleteById(id);
            String message = "Physician Deleted sucessfully";
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
