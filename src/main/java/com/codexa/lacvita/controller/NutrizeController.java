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

import com.codexa.lacvita.dto.nutrize.NutrizeCreateRequest;
import com.codexa.lacvita.dto.nutrize.NutrizeMapper;
import com.codexa.lacvita.dto.nutrize.NutrizeResponse;
import com.codexa.lacvita.dto.nutrize.NutrizeUpdateRequest;
import com.codexa.lacvita.exception.BusinessException;
import com.codexa.lacvita.model.Nutrize;
import com.codexa.lacvita.service.NutrizeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/nutrizes")
public class NutrizeController {

    private final NutrizeService service;
    private final NutrizeMapper mapper;

    public NutrizeController(NutrizeService service, NutrizeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<NutrizeResponse> create(@Valid @RequestBody NutrizeCreateRequest dto) {
        Nutrize criada = service.create(mapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(criada));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutrizeResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.findByIdOrThrow(id)));
    }

    @GetMapping
    public ResponseEntity<List<NutrizeResponse>> findAll() {
        return ResponseEntity.ok(
                service.findAll().stream()
                        .map(mapper::toDto)
                        .toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NutrizeResponse> update(@PathVariable Long id, @Valid @RequestBody NutrizeUpdateRequest dto) {
        Nutrize existente = service.findByIdOrThrow(id);
        mapper.updateEntityFromDto(dto, existente);
        return ResponseEntity.ok(mapper.toDto(service.update(existente)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/login")
    public ResponseEntity<NutrizeResponse> login(@Valid @RequestBody com.codexa.lacvita.dto.nutrize.LoginRequest dto) {
        return service.autenticar(dto.getEmailOuCpf(), dto.getSenha())
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BusinessException("Email/CPF ou senha inválidos"));
    }
}