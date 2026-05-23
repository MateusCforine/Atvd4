package com.example.atividade4.services;

import com.example.atividade4.dtos.VeterinarioDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Veterinario;
import com.example.atividade4.repositories.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    @Override
    public VeterinarioDTO salvar(VeterinarioDTO dto) {

        Veterinario veterinario = Veterinario.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .crmv(dto.getCrmv())
                .telefone(dto.getTelefone())
                .especializacao(dto.getEspecializacao())
                .build();

        veterinario = veterinarioRepository.save(veterinario);

        return converterParaDTO(veterinario);
    }

    @Override
    public VeterinarioDTO buscarPorId(Integer id) {

        Veterinario veterinario = veterinarioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Veterinário não encontrado"));

        return converterParaDTO(veterinario);
    }

    @Override
    public List<VeterinarioDTO> listar() {

        return veterinarioRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    @Override
    public List<VeterinarioDTO> listarPorEspecializacao(String especializacao) {

        return veterinarioRepository.findByEspecializacao(especializacao)
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    @Override
    public void deletar(Integer id) {

        veterinarioRepository.deleteById(id);
    }

    private VeterinarioDTO converterParaDTO(Veterinario veterinario) {

        return VeterinarioDTO.builder()
                .id(veterinario.getId())
                .nome(veterinario.getNome())
                .crmv(veterinario.getCrmv())
                .telefone(veterinario.getTelefone())
                .especializacao(veterinario.getEspecializacao())
                .build();
    }
}