package com.example.atividade4.services;

import com.example.atividade4.dtos.AnimalDTO;

import java.util.List;

public interface AnimalService {

    AnimalDTO salvar(AnimalDTO dto);

    AnimalDTO buscarPorId(Integer id);

    List<AnimalDTO> listar();

    List<AnimalDTO> listarPorTutor(Integer tutorId);

    void deletar(Integer id);
}