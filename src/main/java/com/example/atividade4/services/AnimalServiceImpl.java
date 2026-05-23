package com.example.atividade4.services;

import com.example.atividade4.dtos.AnimalDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Animal;
import com.example.atividade4.models.Tutor;
import com.example.atividade4.repositories.AnimalRepository;
import com.example.atividade4.repositories.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final TutorRepository tutorRepository;

    @Override
    public AnimalDTO salvar(AnimalDTO dto) {

        Tutor tutor = tutorRepository.findById(dto.getTutorId())
                .orElseThrow(() -> new RegraNegocioException("Tutor não encontrado"));

        Animal animal = Animal.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .especie(dto.getEspecie())
                .raca(dto.getRaca())
                .dataNascimento(dto.getDataNascimento())
                .tutor(tutor)
                .build();

        animal = animalRepository.save(animal);

        return converterParaDTO(animal);
    }

    @Override
    public AnimalDTO buscarPorId(Integer id) {

        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Animal não encontrado"));

        return converterParaDTO(animal);
    }

    @Override
    public List<AnimalDTO> listar() {

        return animalRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    @Override
    public List<AnimalDTO> listarPorTutor(Integer tutorId) {

        return animalRepository.findByTutorId(tutorId)
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    @Override
    public void deletar(Integer id) {

        animalRepository.deleteById(id);
    }

    private AnimalDTO converterParaDTO(Animal animal) {

        return AnimalDTO.builder()
                .id(animal.getId())
                .nome(animal.getNome())
                .especie(animal.getEspecie())
                .raca(animal.getRaca())
                .dataNascimento(animal.getDataNascimento())
                .tutorId(animal.getTutor().getId())
                .build();
    }
}