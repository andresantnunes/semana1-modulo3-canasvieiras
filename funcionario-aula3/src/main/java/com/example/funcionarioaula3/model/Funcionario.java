package com.example.funcionarioaula3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_funcionario")
    private String nomeFuncionario;
    @Column(name = "salario")
    private Double salario;
    @Column(name = "tempo_empresa")
    private Long tempoEmpresa;
}
