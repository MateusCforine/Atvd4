package com.example.atividade4.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProntuarioDTO {

    private Integer id;
    private LocalDateTime dataAtendimento;
    private String observacoes;
    private Integer animalId;
    private Integer veterinarioId;
}