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

import com.codexa.lacvita.dto.endereco.EnderecoCreateRequest;
import com.codexa.lacvita.dto.endereco.EnderecoMapper;
import com.codexa.lacvita.dto.endereco.EnderecoResponse;
import com.codexa.lacvita.dto.endereco.EnderecoUpdateRequest;
import com.codexa.lacvita.model.Endereco;
import com.codexa.lacvita.service.EnderecoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/enderecos")
public class EnderecoController {

    private final EnderecoService service;
    private final EnderecoMapper mapper;

    public EnderecoController(EnderecoService service, EnderecoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<EnderecoResponse> create(@Valid @RequestBody EnderecoCreateRequest dto) {
        Endereco criado = service.create(mapper.toEntity(dto), dto.getNutrizeId());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(criado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.findByIdOrThrow(id)));
    }

    @GetMapping("/nutriz/{nutrizeId}")
    public ResponseEntity<List<EnderecoResponse>> findByNutrizeId(@PathVariable Long nutrizeId) {
        return ResponseEntity.ok(
                service.findByNutrizeId(nutrizeId).stream()
                        .map(mapper::toDto)
                        .toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponse> update(@PathVariable Long id,
            @Valid @RequestBody EnderecoUpdateRequest dto) {
        Endereco existente = service.findByIdOrThrow(id);
        mapper.updateEntityFromDto(dto, existente);
        return ResponseEntity.ok(mapper.toDto(service.update(existente)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}