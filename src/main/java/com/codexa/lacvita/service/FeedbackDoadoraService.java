package com.codexa.lacvita.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codexa.lacvita.exception.ResourceNotFoundException;
import com.codexa.lacvita.model.Coleta;
import com.codexa.lacvita.model.FeedbackDoadora;
import com.codexa.lacvita.model.Nutrize;
import com.codexa.lacvita.repository.FeedbackDoadoraRepository;

@Service
public class FeedbackDoadoraService {

    private final FeedbackDoadoraRepository repository;
    private final NutrizeService nutrizeService;
    private final ColetaService coletaService;

    public FeedbackDoadoraService(FeedbackDoadoraRepository repository, NutrizeService nutrizeService,
            ColetaService coletaService) {
        this.repository = repository;
        this.nutrizeService = nutrizeService;
        this.coletaService = coletaService;
    }

    public FeedbackDoadora create(FeedbackDoadora feedback, Long nutrizeId, Long coletaId) {
        Nutrize nutrize = nutrizeService.findByIdOrThrow(nutrizeId);
        feedback.setNutrize(nutrize);

        if (coletaId != null) {
            Coleta coleta = coletaService.findByIdOrThrow(coletaId);
            feedback.setColeta(coleta);
        }

        return repository.save(feedback);
    }

    public FeedbackDoadora findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback não encontrado com id: " + id));
    }

    public List<FeedbackDoadora> findByNutrizeId(Long nutrizeId) {
        return repository.findByNutrizeId(nutrizeId);
    }
}