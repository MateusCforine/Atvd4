package com.example.atividade4.services;

import com.example.atividade4.dtos.TutorDTO;

import java.util.List;

public interface TutorService {

    TutorDTO salvar(TutorDTO dto);

    TutorDTO buscarPorId(Integer id);

    List<TutorDTO> listar();

    void deletar(Integer id);
}