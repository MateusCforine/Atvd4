package com.example.atividade4.dtos;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalDTO {

    private Integer id;
    private String nome;
    private String especie;
    private String raca;
    private LocalDate dataNascimento;
    private Integer tutorId;
}