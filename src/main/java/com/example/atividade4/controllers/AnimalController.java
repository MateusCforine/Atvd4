package com.example.atividade4.controllers;

import com.example.atividade4.dtos.AnimalDTO;
import com.example.atividade4.services.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animais")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody AnimalDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(animalService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(animalService.buscarPorId(id));
    }

    @GetMapping("/tutor/{tutorId}")
    public ResponseEntity<?> listarPorTutor(@PathVariable Integer tutorId) {
        return ResponseEntity.ok(animalService.listarPorTutor(tutorId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        animalService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}