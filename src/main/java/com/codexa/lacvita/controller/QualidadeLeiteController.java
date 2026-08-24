package com.codexa.lacvita.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexa.lacvita.dto.qualidade.QualidadeLeiteCreateRequest;
import com.codexa.lacvita.dto.qualidade.QualidadeLeiteMapper;
import com.codexa.lacvita.dto.qualidade.QualidadeLeiteResponse;
import com.codexa.lacvita.dto.qualidade.QualidadeLeiteUpdateRequest;
import com.codexa.lacvita.model.QualidadeLeite;
import com.codexa.lacvita.service.QualidadeLeiteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/qualidade-leite")
public class QualidadeLeiteController {

    private final QualidadeLeiteService service;
    private final QualidadeLeiteMapper mapper;

    public QualidadeLeiteController(QualidadeLeiteService service, QualidadeLeiteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<QualidadeLeiteResponse> create(@Valid @RequestBody QualidadeLeiteCreateRequest dto) {
        QualidadeLeite criada = service.create(mapper.toEntity(dto), dto.getColetaId());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(criada));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QualidadeLeiteResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.findByIdOrThrow(id)));
    }

    @GetMapping("/coleta/{coletaId}")
    public ResponseEntity<QualidadeLeiteResponse> findByColetaId(@PathVariable Long coletaId) {
        return ResponseEntity.ok(mapper.toDto(service.findByColetaIdOrThrow(coletaId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QualidadeLeiteResponse> update(@PathVariable Long id,
            @Valid @RequestBody QualidadeLeiteUpdateRequest dto) {
        QualidadeLeite existente = service.findByIdOrThrow(id);
        mapper.updateEntityFromDto(dto, existente);
        return ResponseEntity.ok(mapper.toDto(service.update(existente)));
    }
}