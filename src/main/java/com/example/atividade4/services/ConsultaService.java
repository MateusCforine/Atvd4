package com.example.atividade4.services;

import com.example.atividade4.dtos.ConsultaDTO;

import java.util.List;

public interface ConsultaService {

    ConsultaDTO agendar(ConsultaDTO dto);

    ConsultaDTO buscarPorId(Integer id);

    List<ConsultaDTO> listar();

    List<ConsultaDTO> listarPorAnimal(Integer animalId);

    List<ConsultaDTO> listarPorVeterinario(Integer veterinarioId);

    void deletar(Integer id);
}