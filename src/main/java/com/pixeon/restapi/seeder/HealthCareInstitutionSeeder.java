package com.pixeon.restapi.seeder;

import com.pixeon.restapi.model.HealthCareInstitution;
import com.pixeon.restapi.repository.HealthCareInstitutionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HealthCareInstitutionSeeder {
    @Autowired
    HealthCareInstitutionRepository repository;

    @EventListener
    private void seedHealthCareInstitution(ContextRefreshedEvent event){
        try{
            log.info("creating healthcare institutions......");
            creatingHealthCareInstitutions();
        }catch (Exception e){
            e.getMessage();
        }
    }

    private void creatingHealthCareInstitutions() {
        HealthCareInstitution healthCareInstitution1 = new HealthCareInstitution();
        healthCareInstitution1.setName("Clinica Especializada Cotia");
        healthCareInstitution1.setCnpj("99.999.999/9999-99");
        healthCareInstitution1.setPixeonBudget(21.00);
        healthCareInstitution1.setRequests(0);

        repository.save(healthCareInstitution1);


        HealthCareInstitution healthCareInstitution2 = new HealthCareInstitution();
        healthCareInstitution2.setName("Clinica Especializada São Paulo");
        healthCareInstitution2.setCnpj("88.888.888/8888-88");
        healthCareInstitution2.setPixeonBudget(82.00);
        healthCareInstitution2.setRequests(0);


        repository.save(healthCareInstitution2);

    }


}
