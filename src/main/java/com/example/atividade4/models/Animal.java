package com.example.atividade4.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String especie;
    private String raca;
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @OneToMany(mappedBy = "animal")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "animal")
    private List<Prontuario> prontuarios;

    @OneToMany(mappedBy = "animal")
    private List<Vacina> vacinas;
}