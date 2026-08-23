package com.codexa.lacvita.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexa.lacvita.dto.documentosaude.DocumentoSaudeCreateRequest;
import com.codexa.lacvita.dto.documentosaude.DocumentoSaudeMapper;
import com.codexa.lacvita.dto.documentosaude.DocumentoSaudeResponse;
import com.codexa.lacvita.dto.documentosaude.DocumentoSaudeUpdateRequest;
import com.codexa.lacvita.model.DocumentoSaude;
import com.codexa.lacvita.service.DocumentoSaudeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/documentos-saude")
public class DocumentoSaudeController {

    private final DocumentoSaudeService service;
    private final DocumentoSaudeMapper mapper;

    public DocumentoSaudeController(DocumentoSaudeService service, DocumentoSaudeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<DocumentoSaudeResponse> create(@Valid @RequestBody DocumentoSaudeCreateRequest dto) {
        DocumentoSaude criado = service.create(mapper.toEntity(dto), dto.getNutrizeId());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(criado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoSaudeResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.findByIdOrThrow(id)));
    }

    @GetMapping("/nutriz/{nutrizeId}")
    public ResponseEntity<List<DocumentoSaudeResponse>> findByNutrizeId(@PathVariable Long nutrizeId) {
        return ResponseEntity.ok(
                service.findByNutrizeId(nutrizeId).stream()
                        .map(mapper::toDto)
                        .toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoSaudeResponse> update(@PathVariable Long id,
            @Valid @RequestBody DocumentoSaudeUpdateRequest dto) {
        DocumentoSaude existente = service.findByIdOrThrow(id);
        mapper.updateEntityFromDto(dto, existente);
        return ResponseEntity.ok(mapper.toDto(service.update(existente)));
    }
}