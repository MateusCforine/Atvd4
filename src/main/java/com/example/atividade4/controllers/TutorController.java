package com.example.atividade4.controllers;

import com.example.atividade4.dtos.TutorDTO;
import com.example.atividade4.services.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tutores")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody TutorDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tutorService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(tutorService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(tutorService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        tutorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}