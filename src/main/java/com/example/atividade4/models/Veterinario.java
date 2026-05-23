package com.example.atividade4.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String crmv;
    private String telefone;
    private String especializacao;

    @OneToMany(mappedBy = "veterinario")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "veterinario")
    private List<Prontuario> prontuarios;
}