package com.example.atividade4.services;

import com.example.atividade4.dtos.VeterinarioDTO;

import java.util.List;

public interface VeterinarioService {

    VeterinarioDTO salvar(VeterinarioDTO dto);

    VeterinarioDTO buscarPorId(Integer id);

    List<VeterinarioDTO> listar();

    List<VeterinarioDTO> listarPorEspecializacao(String especializacao);

    void deletar(Integer id);
}