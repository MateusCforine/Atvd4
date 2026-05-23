package com.example.atividade4.repositories;

import com.example.atividade4.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Integer> {

    Tutor findByCpf(String cpf);
}