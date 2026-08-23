package com.codexa.lacvita.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codexa.lacvita.exception.ResourceNotFoundException;
import com.codexa.lacvita.model.DocumentoSaude;
import com.codexa.lacvita.model.Nutrize;
import com.codexa.lacvita.repository.DocumentoSaudeRepository;

@Service
public class DocumentoSaudeService {

    private final DocumentoSaudeRepository repository;
    private final NutrizeService nutrizeService;

    public DocumentoSaudeService(DocumentoSaudeRepository repository, NutrizeService nutrizeService) {
        this.repository = repository;
        this.nutrizeService = nutrizeService;
    }

    public DocumentoSaude create(DocumentoSaude documento, Long nutrizeId) {
        Nutrize nutrize = nutrizeService.findByIdOrThrow(nutrizeId);
        documento.setNutrize(nutrize);
        return repository.save(documento);
    }

    public DocumentoSaude update(DocumentoSaude documento) {
        documento.setDataAnalise(LocalDateTime.now());
        return repository.save(documento);
    }

    public DocumentoSaude findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documento de saúde não encontrado com id: " + id));
    }

    public List<DocumentoSaude> findByNutrizeId(Long nutrizeId) {
        return repository.findByNutrizeId(nutrizeId);
    }
}