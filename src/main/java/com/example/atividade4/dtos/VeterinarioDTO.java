package com.example.atividade4.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarioDTO {

    private Integer id;
    private String nome;
    private String crmv;
    private String telefone;
    private String especializacao;
}