package com.pixeon.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.pixeon.restapi.model.Patient;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @JoinColumn(name = "healthcareIntitution_id")
    @OneToOne(cascade = CascadeType.ALL)
    private HealthCareInstitution healthCareInstitution;

    @JoinColumn(name = "patient_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Patient patient;

    @JoinColumn(name = "physician_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Physician physician;

    @Column(name = "procedure_name")
    private String procedureName;
}
