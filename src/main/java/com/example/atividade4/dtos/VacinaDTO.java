package com.example.atividade4.dtos;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacinaDTO {

    private Integer id;
    private String nomeVacina;
    private LocalDate dataAplicacao;
    private LocalDate proximaDose;
    private Integer animalId;
}