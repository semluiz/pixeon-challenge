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

@Component
@Slf4j
public class ExamSeeder {
    @Autowired
    ExamRepository repository;

    @Autowired
    HealthCareInstitutionRepository healthCareInstitutionRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PhysicianRepository physicianRepository;

    @EventListener
    private void seedExam(ContextRefreshedEvent event) {
        try {
            log.info("creating Exams....");
            creatingExams();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void creatingExams() {
        HealthCareInstitution healthCareInstitution1 = new HealthCareInstitution();
        healthCareInstitution1.setName("Clinica Especializada Embu");
        healthCareInstitution1.setCnpj("22.222.222/2222-22");
        healthCareInstitutionRepository.save(healthCareInstitution1);

        Patient patient1 = new Patient();

        patient1.setAge(20);
        patient1.setName("Lucas Luiz");
        patient1.setSexo(Sexo.M);
        patientRepository.save(patient1);

        Physician physician1 = new Physician();
        physician1.setName("Doutor Philip");
        physician1.setCrm("165798/US");
        physicianRepository.save(physician1);


        Exam exam = new Exam();
        exam.setPatient(patient1);
        exam.setPhysician(physician1);
        exam.setProcedureName("Consulta Oftalmo");

        repository.save(exam);
    }

}
