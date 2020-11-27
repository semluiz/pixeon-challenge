package com.pixeon.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "healthcare_institution")
public class HealthCareInstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private String cnpj;

    @Column(name = "pixeon_coins")
    private Double pixeonBudget;

    private Integer requests;



}
