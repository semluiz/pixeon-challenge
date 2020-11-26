package com.pixeon.restapi.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Sexo {

    M("Masculino"), F("Feminino"), O("Outros");
    private String sexo;

}
