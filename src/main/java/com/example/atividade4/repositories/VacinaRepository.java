package com.example.atividade4.repositories;

import com.example.atividade4.models.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacinaRepository extends JpaRepository<Vacina, Integer> {

    List<Vacina> findByAnimalId(Integer animalId);
}