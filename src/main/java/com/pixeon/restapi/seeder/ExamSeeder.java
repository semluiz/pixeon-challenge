package com.pixeon.restapi.seeder;

import com.pixeon.restapi.enums.Sexo;
import com.pixeon.restapi.model.Exam;
import com.pixeon.restapi.model.HealthCareInstitution;
import com.pixeon.restapi.model.Patient;
import com.pixeon.restapi.model.Physician;
import com.pixeon.restapi.repository.ExamRepository;
import com.pixeon.restapi.repository.HealthCareInstitutionRepository;
import com.pixeon.restapi.repository.PatientRepository;
import com.pixeon.restapi.repository.PhysicianRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@Slf4j
@Transactional
public class ExamSeeder {
    @Autowired
    ExamRepository examRepository;

    @Autowired
    HealthCareInstitutionRepository healthCareInstitutionRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PhysicianRepository physicianRepository;



    @EventListener
    public void seedExam(ContextRefreshedEvent event) {
        try {
            log.info("creating exams............");
            creatingExams();
        } catch (Exception e) {
            e.getMessage();
        }
    }


    public void creatingExams() {

        try {


            Patient patient1 = new Patient();

            patient1.setAge(20);
            patient1.setName("Lucas Luiz");
            patient1.setSexo(Sexo.M);
            patientRepository.save(patient1);

            HealthCareInstitution healthCareInstitution1 = new HealthCareInstitution();
            healthCareInstitution1.setName("Clinica Especializada Embu");
            healthCareInstitution1.setCnpj("22.222.222/2222-22");
            healthCareInstitution1.setPixeonBudget(37.00);
            healthCareInstitution1.setRequests(0);
            healthCareInstitutionRepository.save(healthCareInstitution1);


            Physician physician1 = new Physician();
            physician1.setName("Doutor Philip");
            physician1.setCrm("165798/US");
            physicianRepository.save(physician1);


            Exam exam1 = new Exam();
            exam1.setHealthCareInstitution(healthCareInstitution1);
            exam1.setPatient(patient1);
            exam1.setPhysician(physician1);
            exam1.setProcedureName("Consulta Oftalmo");

            examRepository.save(exam1);

        } catch (Exception e) {
            e.getMessage();
        }

    }

}
