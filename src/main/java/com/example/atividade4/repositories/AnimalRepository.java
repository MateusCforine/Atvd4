package com.example.atividade4.repositories;

import com.example.atividade4.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findByTutorId(Integer tutorId);

    List<Animal> findByEspecie(String especie);
}