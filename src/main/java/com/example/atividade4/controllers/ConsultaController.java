package com.example.atividade4.controllers;

import com.example.atividade4.dtos.ConsultaDTO;
import com.example.atividade4.services.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<?> agendar(@RequestBody ConsultaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.agendar(dto));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(consultaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(consultaService.buscarPorId(id));
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<?> listarPorAnimal(@PathVariable Integer animalId) {
        return ResponseEntity.ok(consultaService.listarPorAnimal(animalId));
    }

    @GetMapping("/veterinario/{veterinarioId}")
    public ResponseEntity<?> listarPorVeterinario(@PathVariable Integer veterinarioId) {
        return ResponseEntity.ok(consultaService.listarPorVeterinario(veterinarioId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        consultaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}