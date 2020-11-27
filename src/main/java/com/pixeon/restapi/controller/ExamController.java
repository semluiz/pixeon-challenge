package com.pixeon.restapi.controller;

import com.pixeon.restapi.model.Exam;
import com.pixeon.restapi.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "exam-webservice")
public class ExamController {
    @Autowired
    private ExamRepository examRepository;

    @PostMapping("/exam")
    public ResponseEntity<?> save(@RequestBody Exam exam) {
        try {
            Double budget = exam.getHealthCareInstitution().getPixeonBudget();
            String message = "You´re out of budget, the institution need at least 20 pixeon coins";
            if (budget >= 20.00) {
                exam.getHealthCareInstitution().setPixeonBudget(exam.getHealthCareInstitution().getPixeonBudget() - 1);
                return new ResponseEntity<>(examRepository.save(exam), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
            }
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
            Integer quantidadeRequests = 1;
            Optional<Exam> exam = examRepository.findById(id);

            Exam exam1 = exam.get();

            exam1.getHealthCareInstitution().setRequests(exam1.getHealthCareInstitution().getRequests() + 1);

            Integer requests = exam1.getHealthCareInstitution().getRequests();

            if(requests > quantidadeRequests){
                exam1.getHealthCareInstitution().setPixeonBudget(exam1.getHealthCareInstitution().getPixeonBudget() - 1);

                examRepository.save(exam1);

                return new ResponseEntity<>(examRepository.findById(id), HttpStatus.OK);
            }

            else {
                return new ResponseEntity<>(examRepository.findById(id), HttpStatus.OK);
            }


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
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Integer id) {
        try {
            examRepository.deleteById(id);
            String message = "Item excluido com sucesso";
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
