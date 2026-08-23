package com.codexa.lacvita.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexa.lacvita.dto.feedback.FeedbackDoadoraCreateRequest;
import com.codexa.lacvita.dto.feedback.FeedbackDoadoraMapper;
import com.codexa.lacvita.dto.feedback.FeedbackDoadoraResponse;
import com.codexa.lacvita.model.FeedbackDoadora;
import com.codexa.lacvita.service.FeedbackDoadoraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/feedbacks")
public class FeedbackDoadoraController {

    private final FeedbackDoadoraService service;
    private final FeedbackDoadoraMapper mapper;

    public FeedbackDoadoraController(FeedbackDoadoraService service, FeedbackDoadoraMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<FeedbackDoadoraResponse> create(@Valid @RequestBody FeedbackDoadoraCreateRequest dto) {
        FeedbackDoadora criado = service.create(mapper.toEntity(dto), dto.getNutrizeId(), dto.getColetaId());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(criado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDoadoraResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.findByIdOrThrow(id)));
    }

    @GetMapping("/nutriz/{nutrizeId}")
    public ResponseEntity<List<FeedbackDoadoraResponse>> findByNutrizeId(@PathVariable Long nutrizeId) {
        return ResponseEntity.ok(
                service.findByNutrizeId(nutrizeId).stream()
                        .map(mapper::toDto)
                        .toList());
    }
}