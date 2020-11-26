package com.pixeon.restapi.controller;

import com.pixeon.restapi.model.Exam;
import com.pixeon.restapi.model.Patient;
import com.pixeon.restapi.repository.ExamRepository;
import com.pixeon.restapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "exam-api")
public class ExamController {
    @Autowired
    private ExamRepository examRepository;

    @PostMapping("/exam")
    public ResponseEntity<?> save(@RequestBody Exam exam) {
        try {
            return new ResponseEntity<>(examRepository.save(exam), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/exams")
    public ResponseEntity<?> listAll() {
        try {
            List<Exam> exams = examRepository.findAll();
            return new ResponseEntity<>(exams, HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/exam/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Integer id) {
        try {
            return new ResponseEntity<>(examRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/exam")
    public ResponseEntity<?> update(@RequestBody Exam exam) {
        try {
            return new ResponseEntity<>(examRepository.save(exam), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping("exam/{id}")
    public ResponseEntity<?> deleteById(@PathVariable (value = "id") Integer id){
        try{
            examRepository.deleteById(id);
            String message = "Item excluido com sucesso";
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
