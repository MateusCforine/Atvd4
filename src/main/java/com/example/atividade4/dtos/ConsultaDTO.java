package com.example.atividade4.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaDTO {

    private Integer id;
    private LocalDateTime dataHora;
    private String local;
    private String status;
    private Integer animalId;
    private Integer veterinarioId;
}