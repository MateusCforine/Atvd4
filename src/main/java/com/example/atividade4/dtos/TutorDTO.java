package com.example.atividade4.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TutorDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
}