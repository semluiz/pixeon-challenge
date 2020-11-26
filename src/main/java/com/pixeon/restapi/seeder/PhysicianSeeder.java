package com.pixeon.restapi.seeder;


import com.pixeon.restapi.model.Physician;
import com.pixeon.restapi.repository.PhysicianRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PhysicianSeeder {
    @Autowired
    PhysicianRepository repository;

    @EventListener
    private void seedPhysian(ContextRefreshedEvent event){
        try{
            log.info("creating physicians......");
            creatingPhysicians();
        }catch (Exception e){
            e.getMessage();
        }
    }

    private void creatingPhysicians() {
        Physician physician1 = new Physician();
        physician1.setName("Doutor Carlos");
        physician1.setCrm("042391/BR");

        repository.save(physician1);

        Physician physician2 = new Physician();
        physician2.setName("Doutora Vivian");
        physician2.setCrm("891355/ARG");

        repository.save(physician2);
    }

}
