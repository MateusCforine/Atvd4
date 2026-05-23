package com.example.atividade4.repositories;

import com.example.atividade4.models.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Integer> {

    List<Prontuario> findByAnimalId(Integer animalId);

    List<Prontuario> findByVeterinarioId(Integer veterinarioId);
}