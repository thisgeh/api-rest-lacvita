package com.codexa.lacvita.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexa.lacvita.dto.ponto.PontoColetaCreateRequest;
import com.codexa.lacvita.dto.ponto.PontoColetaMapper;
import com.codexa.lacvita.dto.ponto.PontoColetaResponse;
import com.codexa.lacvita.dto.ponto.PontoColetaUpdateRequest;
import com.codexa.lacvita.model.PontoColeta;
import com.codexa.lacvita.service.PontoColetaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/pontos-coleta")
public class PontoColetaController {

    private final PontoColetaService service;
    private final PontoColetaMapper mapper;

    public PontoColetaController(PontoColetaService service, PontoColetaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<PontoColetaResponse> create(@Valid @RequestBody PontoColetaCreateRequest dto) {
        PontoColeta criado = service.createOrUpdate(mapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(criado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoColetaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.findByIdOrThrow(id)));
    }

    @GetMapping
    public ResponseEntity<List<PontoColetaResponse>> findAll() {
        return ResponseEntity.ok(
                service.findAll().stream()
                        .map(mapper::toDto)
                        .toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PontoColetaResponse> update(@PathVariable Long id,
            @Valid @RequestBody PontoColetaUpdateRequest dto) {
        PontoColeta existente = service.findByIdOrThrow(id);
        mapper.updateEntityFromDto(dto, existente);
        return ResponseEntity.ok(mapper.toDto(service.createOrUpdate(existente)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}