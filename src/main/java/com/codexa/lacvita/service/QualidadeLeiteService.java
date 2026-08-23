package com.codexa.lacvita.service;

import org.springframework.stereotype.Service;

import com.codexa.lacvita.exception.BusinessException;
import com.codexa.lacvita.exception.ResourceNotFoundException;
import com.codexa.lacvita.model.Coleta;
import com.codexa.lacvita.model.QualidadeLeite;
import com.codexa.lacvita.repository.QualidadeLeiteRepository;

@Service
public class QualidadeLeiteService {

    private final QualidadeLeiteRepository repository;
    private final ColetaService coletaService;

    public QualidadeLeiteService(QualidadeLeiteRepository repository, ColetaService coletaService) {
        this.repository = repository;
        this.coletaService = coletaService;
    }

    public QualidadeLeite create(QualidadeLeite qualidadeLeite, Long coletaId) {
        Coleta coleta = coletaService.findByIdOrThrow(coletaId);

        if (repository.findByColetaId(coletaId).isPresent()) {
            throw new BusinessException("Já existe uma análise de qualidade registrada para esta coleta");
        }

        qualidadeLeite.setColeta(coleta);
        return repository.save(qualidadeLeite);
    }

    public QualidadeLeite findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Análise de qualidade não encontrada com id: " + id));
    }

    public QualidadeLeite findByColetaIdOrThrow(Long coletaId) {
        return repository.findByColetaId(coletaId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Análise de qualidade não encontrada para a coleta id: " + coletaId));
    }
}