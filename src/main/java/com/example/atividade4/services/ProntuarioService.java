package com.example.atividade4.services;

import com.example.atividade4.dtos.ProntuarioDTO;
import com.example.atividade4.dtos.VacinaDTO;

import java.util.List;

public interface ProntuarioService {

    ProntuarioDTO registrarAtendimento(ProntuarioDTO dto);

    VacinaDTO registrarVacina(VacinaDTO dto);

    List<ProntuarioDTO> listarProntuarioPorAnimal(Integer animalId);

    List<VacinaDTO> listarVacinasPorAnimal(Integer animalId);
}