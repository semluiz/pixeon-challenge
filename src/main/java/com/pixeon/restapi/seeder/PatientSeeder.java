package com.pixeon.restapi.seeder;


import com.pixeon.restapi.enums.Sexo;
import com.pixeon.restapi.model.Patient;
import com.pixeon.restapi.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PatientSeeder {

    @Autowired
    PatientRepository repository;

    @EventListener
    public void seedPatient(ContextRefreshedEvent event){
        try {
            log.info("Creating Patiens.......");
            creatingClients();
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }


    private void creatingClients(){
        Patient patient1 = new Patient();

        patient1.setAge(20);
        patient1.setName("Lucas");
        patient1.setSexo(Sexo.M);
        repository.save(patient1);

        Patient patient2 = new Patient();

        patient2.setAge(23);
        patient2.setName("Luiz");
        patient2.setSexo(Sexo.M);

        repository.save(patient2);

        Patient patient3 = new Patient();
        patient3.setName("Ana");
        patient3.setAge(29);
        patient3.setSexo(Sexo.F);


        repository.save(patient3);

    }
}
