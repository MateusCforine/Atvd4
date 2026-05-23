package com.example.atividade4.repositories;

import com.example.atividade4.models.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {

    List<Veterinario> findByEspecializacao(String especializacao);
}