package com.example.funcionarioaula3.controller.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioRequest {
    @NotNull
    @NotBlank
    private String nomeFuncionario;

    @NotNull
    private Double salario;

    @NotNull
    private Long tempoEmpresa;
}
