package com.pixeon.restapi.model;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HealthCareInstitution getHealthCareInstitution() {
        return healthCareInstitution;
    }

    public void setHealthCareInstitution(HealthCareInstitution healthCareInstitution) {
        this.healthCareInstitution = healthCareInstitution;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }
}
