package com.codexa.lacvita.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexa.lacvita.dto.lembrete.LembreteCreateRequest;
import com.codexa.lacvita.dto.lembrete.LembreteMapper;
import com.codexa.lacvita.dto.lembrete.LembreteResponse;
import com.codexa.lacvita.model.Lembrete;
import com.codexa.lacvita.service.LembreteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/lembretes")
public class LembreteController {

    private final LembreteService service;
    private final LembreteMapper mapper;

    public LembreteController(LembreteService service, LembreteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<LembreteResponse> create(@Valid @RequestBody LembreteCreateRequest dto) {
        Lembrete criado = service.criar(dto.getNutrizeId(), dto.getTipo(), dto.getTitulo(), dto.getMensagem());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(criado));
    }

    @GetMapping("/nutriz/{nutrizeId}")
    public ResponseEntity<List<LembreteResponse>> findByNutrizeId(@PathVariable Long nutrizeId) {
        return ResponseEntity.ok(
                service.findByNutrizeId(nutrizeId).stream()
                        .map(mapper::toDto)
                        .toList());
    }

    @PatchMapping("/{id}/lido")
    public ResponseEntity<LembreteResponse> marcarComoLido(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.marcarComoLido(id)));
    }
}