package com.example.atividade4.controllers;

import com.example.atividade4.dtos.VeterinarioDTO;
import com.example.atividade4.services.VeterinarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/veterinarios")
@RequiredArgsConstructor
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody VeterinarioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veterinarioService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(veterinarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(veterinarioService.buscarPorId(id));
    }

    @GetMapping("/especializacao/{especializacao}")
    public ResponseEntity<?> listarPorEspecializacao(@PathVariable String especializacao) {
        return ResponseEntity.ok(veterinarioService.listarPorEspecializacao(especializacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        veterinarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}