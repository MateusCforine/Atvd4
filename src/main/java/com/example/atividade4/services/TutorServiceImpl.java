package com.example.atividade4.services;

import com.example.atividade4.dtos.TutorDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Tutor;
import com.example.atividade4.repositories.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;

    @Override
    public TutorDTO salvar(TutorDTO dto) {

        Tutor tutor = Tutor.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .telefone(dto.getTelefone())
                .endereco(dto.getEndereco())
                .build();

        tutor = tutorRepository.save(tutor);

        return converterParaDTO(tutor);
    }

    @Override
    public TutorDTO buscarPorId(Integer id) {

        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Tutor não encontrado"));

        return converterParaDTO(tutor);
    }

    @Override
    public List<TutorDTO> listar() {

        return tutorRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    @Override
    public void deletar(Integer id) {

        tutorRepository.deleteById(id);
    }

    private TutorDTO converterParaDTO(Tutor tutor) {

        return TutorDTO.builder()
                .id(tutor.getId())
                .nome(tutor.getNome())
                .cpf(tutor.getCpf())
                .telefone(tutor.getTelefone())
                .endereco(tutor.getEndereco())
                .build();
    }
}