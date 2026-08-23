package com.codexa.lacvita.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codexa.lacvita.exception.ResourceNotFoundException;
import com.codexa.lacvita.model.PontoColeta;
import com.codexa.lacvita.repository.PontoColetaRepository;

@Service
public class PontoColetaService {

    private final PontoColetaRepository repository;

    public PontoColetaService(PontoColetaRepository repository) {
        this.repository = repository;
    }

    public PontoColeta createOrUpdate(PontoColeta pontoColeta) {
        return repository.save(pontoColeta);
    }

    public PontoColeta findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ponto de coleta não encontrado com id: " + id));
    }

    public List<PontoColeta> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        findByIdOrThrow(id);
        repository.deleteById(id);
    }
}