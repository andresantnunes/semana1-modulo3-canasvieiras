package com.example.exemploaula.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "produto")
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double valor;

    public Produto(String nome, Double valor) {
        this.nome=nome;
        this.valor = valor;
    }

    public Produto() {

    }
}
