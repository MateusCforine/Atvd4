package com.example.atividade4.repositories;

import com.example.atividade4.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    boolean existsByVeterinarioIdAndDataHora(Integer veterinarioId, LocalDateTime dataHora);

    List<Consulta> findByAnimalId(Integer animalId);

    List<Consulta> findByVeterinarioId(Integer veterinarioId);
}