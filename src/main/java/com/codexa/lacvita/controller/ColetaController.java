package com.codexa.lacvita.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexa.lacvita.dto.coleta.ColetaMapper;
import com.codexa.lacvita.dto.coleta.ColetaResponse;
import com.codexa.lacvita.dto.coleta.ColetaUpdateRequest;
import com.codexa.lacvita.model.Coleta;
import com.codexa.lacvita.service.ColetaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/coletas")
public class ColetaController {

    private final ColetaService service;
    private final ColetaMapper mapper;

    public ColetaController(ColetaService service, ColetaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColetaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.findByIdOrThrow(id)));
    }

    @GetMapping("/agendamento/{agendamentoId}")
    public ResponseEntity<ColetaResponse> findByAgendamentoId(@PathVariable Long agendamentoId) {
        return ResponseEntity.ok(mapper.toDto(service.findByAgendamentoIdOrThrow(agendamentoId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColetaResponse> update(@PathVariable Long id, @Valid @RequestBody ColetaUpdateRequest dto) {
        Coleta existente = service.findByIdOrThrow(id);
        mapper.updateEntityFromDto(dto, existente);
        return ResponseEntity.ok(mapper.toDto(service.update(existente)));
    }
}