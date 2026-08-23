package com.codexa.lacvita.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codexa.lacvita.exception.ResourceNotFoundException;
import com.codexa.lacvita.model.Endereco;
import com.codexa.lacvita.model.Nutrize;
import com.codexa.lacvita.repository.EnderecoRepository;

@Service
public class EnderecoService {

    private final EnderecoRepository repository;
    private final NutrizeService nutrizeService;

    public EnderecoService(EnderecoRepository repository, NutrizeService nutrizeService) {
        this.repository = repository;
        this.nutrizeService = nutrizeService;
    }

    public Endereco create(Endereco endereco, Long nutrizeId) {
        Nutrize nutrize = nutrizeService.findByIdOrThrow(nutrizeId);
        endereco.setNutrize(nutrize);
        return repository.save(endereco);
    }

    public Endereco update(Endereco endereco) {
        return repository.save(endereco);
    }

    public Endereco findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado com id: " + id));
    }

    public List<Endereco> findByNutrizeId(Long nutrizeId) {
        return repository.findByNutrizeId(nutrizeId);
    }

    public void deleteById(Long id) {
        findByIdOrThrow(id);
        repository.deleteById(id);
    }
}