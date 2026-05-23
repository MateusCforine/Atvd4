package com.example.atividade4.controllers;

import com.example.atividade4.dtos.ProntuarioDTO;
import com.example.atividade4.dtos.VacinaDTO;
import com.example.atividade4.services.ProntuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prontuarios")
@RequiredArgsConstructor
public class ProntuarioController {

    private final ProntuarioService prontuarioService;

    @PostMapping
    public ResponseEntity<?> registrarAtendimento(@RequestBody ProntuarioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(prontuarioService.registrarAtendimento(dto));
    }

    @PostMapping("/vacinas")
    public ResponseEntity<?> registrarVacina(@RequestBody VacinaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(prontuarioService.registrarVacina(dto));
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<?> listarProntuarioPorAnimal(@PathVariable Integer animalId) {
        return ResponseEntity.ok(prontuarioService.listarProntuarioPorAnimal(animalId));
    }

    @GetMapping("/vacinas/animal/{animalId}")
    public ResponseEntity<?> listarVacinasPorAnimal(@PathVariable Integer animalId) {
        return ResponseEntity.ok(prontuarioService.listarVacinasPorAnimal(animalId));
    }
}