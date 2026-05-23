package com.example.atividade4.services;

import com.example.atividade4.dtos.ProntuarioDTO;
import com.example.atividade4.dtos.VacinaDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Animal;
import com.example.atividade4.models.Prontuario;
import com.example.atividade4.models.Vacina;
import com.example.atividade4.models.Veterinario;
import com.example.atividade4.repositories.AnimalRepository;
import com.example.atividade4.repositories.ProntuarioRepository;
import com.example.atividade4.repositories.VacinaRepository;
import com.example.atividade4.repositories.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProntuarioServiceImpl implements ProntuarioService {

    private final ProntuarioRepository prontuarioRepository;
    private final VacinaRepository vacinaRepository;
    private final AnimalRepository animalRepository;
    private final VeterinarioRepository veterinarioRepository;

    @Override
    public ProntuarioDTO registrarAtendimento(ProntuarioDTO dto) {

        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new RegraNegocioException("Animal não encontrado"));

        Veterinario veterinario = veterinarioRepository.findById(dto.getVeterinarioId())
                .orElseThrow(() -> new RegraNegocioException("Veterinário não encontrado"));

        Prontuario prontuario = Prontuario.builder()
                .id(dto.getId())
                .dataAtendimento(dto.getDataAtendimento())
                .observacoes(dto.getObservacoes())
                .animal(animal)
                .veterinario(veterinario)
                .build();

        prontuario = prontuarioRepository.save(prontuario);

        return converterProntuarioParaDTO(prontuario);
    }

    @Override
    public VacinaDTO registrarVacina(VacinaDTO dto) {

        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new RegraNegocioException("Animal não encontrado"));

        Vacina vacina = Vacina.builder()
                .id(dto.getId())
                .nomeVacina(dto.getNomeVacina())
                .dataAplicacao(dto.getDataAplicacao())
                .proximaDose(dto.getProximaDose())
                .animal(animal)
                .build();

        vacina = vacinaRepository.save(vacina);

        return converterVacinaParaDTO(vacina);
    }

    @Override
    public List<ProntuarioDTO> listarProntuarioPorAnimal(Integer animalId) {

        return prontuarioRepository.findByAnimalId(animalId)
                .stream()
                .map(this::converterProntuarioParaDTO)
                .toList();
    }

    @Override
    public List<VacinaDTO> listarVacinasPorAnimal(Integer animalId) {

        return vacinaRepository.findByAnimalId(animalId)
                .stream()
                .map(this::converterVacinaParaDTO)
                .toList();
    }

    private ProntuarioDTO converterProntuarioParaDTO(Prontuario prontuario) {

        return ProntuarioDTO.builder()
                .id(prontuario.getId())
                .dataAtendimento(prontuario.getDataAtendimento())
                .observacoes(prontuario.getObservacoes())
                .animalId(prontuario.getAnimal().getId())
                .veterinarioId(prontuario.getVeterinario().getId())
                .build();
    }

    private VacinaDTO converterVacinaParaDTO(Vacina vacina) {

        return VacinaDTO.builder()
                .id(vacina.getId())
                .nomeVacina(vacina.getNomeVacina())
                .dataAplicacao(vacina.getDataAplicacao())
                .proximaDose(vacina.getProximaDose())
                .animalId(vacina.getAnimal().getId())
                .build();
    }
}