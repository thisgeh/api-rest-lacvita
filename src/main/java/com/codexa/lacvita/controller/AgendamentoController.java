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

import com.codexa.lacvita.dto.agendamento.AgendamentoCreateRequest;
import com.codexa.lacvita.dto.agendamento.AgendamentoMapper;
import com.codexa.lacvita.dto.agendamento.AgendamentoResponse;
import com.codexa.lacvita.dto.agendamento.AgendamentoUpdateRequest;
import com.codexa.lacvita.model.Agendamento;
import com.codexa.lacvita.service.AgendamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;
    private final AgendamentoMapper mapper;

    public AgendamentoController(AgendamentoService service, AgendamentoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponse> create(@Valid @RequestBody AgendamentoCreateRequest dto) {
        Agendamento agendamento = mapper.toEntity(dto);
        Agendamento criado = service.create(agendamento, dto.getNutrizeId(), dto.getEnderecoId(),
                dto.getPontoColetaId());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(criado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.findByIdOrThrow(id)));
    }

    @GetMapping("/nutriz/{nutrizeId}")
    public ResponseEntity<List<AgendamentoResponse>> findByNutrizeId(@PathVariable Long nutrizeId) {
        return ResponseEntity.ok(
                service.findByNutrizeId(nutrizeId).stream()
                        .map(mapper::toDto)
                        .toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> update(@PathVariable Long id,
            @Valid @RequestBody AgendamentoUpdateRequest dto) {
        Agendamento existente = service.findByIdOrThrow(id);
        mapper.updateEntityFromDto(dto, existente);
        return ResponseEntity.ok(mapper.toDto(service.update(existente)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}