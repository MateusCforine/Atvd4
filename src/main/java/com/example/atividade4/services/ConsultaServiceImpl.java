package com.example.atividade4.services;

import com.example.atividade4.dtos.ConsultaDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Animal;
import com.example.atividade4.models.Consulta;
import com.example.atividade4.models.Veterinario;
import com.example.atividade4.repositories.AnimalRepository;
import com.example.atividade4.repositories.ConsultaRepository;
import com.example.atividade4.repositories.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final AnimalRepository animalRepository;
    private final VeterinarioRepository veterinarioRepository;

    @Override
    public ConsultaDTO agendar(ConsultaDTO dto) {

        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new RegraNegocioException("Animal não encontrado"));

        Veterinario veterinario = veterinarioRepository.findById(dto.getVeterinarioId())
                .orElseThrow(() -> new RegraNegocioException("Veterinário não encontrado"));

        boolean veterinarioOcupado = consultaRepository
                .existsByVeterinarioIdAndDataHora(dto.getVeterinarioId(), dto.getDataHora());

        if (veterinarioOcupado) {
            throw new RegraNegocioException("Veterinário já possui consulta nesse horário");
        }

        if (!veterinario.getEspecializacao().equalsIgnoreCase(animal.getEspecie())) {
            throw new RegraNegocioException("Veterinário não possui especialização para atender essa espécie");
        }

        Consulta consulta = Consulta.builder()
                .id(dto.getId())
                .dataHora(dto.getDataHora())
                .local(dto.getLocal())
                .status("Agendada")
                .animal(animal)
                .veterinario(veterinario)
                .build();

        consulta = consultaRepository.save(consulta);

        return converterParaDTO(consulta);
    }

    @Override
    public ConsultaDTO buscarPorId(Integer id) {

        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Consulta não encontrada"));

        return converterParaDTO(consulta);
    }

    @Override
    public List<ConsultaDTO> listar() {

        return consultaRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    @Override
    public List<ConsultaDTO> listarPorAnimal(Integer animalId) {

        return consultaRepository.findByAnimalId(animalId)
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    @Override
    public List<ConsultaDTO> listarPorVeterinario(Integer veterinarioId) {

        return consultaRepository.findByVeterinarioId(veterinarioId)
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    @Override
    public void deletar(Integer id) {

        consultaRepository.deleteById(id);
    }

    private ConsultaDTO converterParaDTO(Consulta consulta) {

        return ConsultaDTO.builder()
                .id(consulta.getId())
                .dataHora(consulta.getDataHora())
                .local(consulta.getLocal())
                .status(consulta.getStatus())
                .animalId(consulta.getAnimal().getId())
                .veterinarioId(consulta.getVeterinario().getId())
                .build();
    }
}