package com.example.atividade4.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeVacina;
    private LocalDate dataAplicacao;
    private LocalDate proximaDose;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
}