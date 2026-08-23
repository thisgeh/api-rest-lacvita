package com.codexa.lacvita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codexa.lacvita.exception.BusinessException;
import com.codexa.lacvita.exception.ResourceNotFoundException;
import com.codexa.lacvita.model.Nutrize;
import com.codexa.lacvita.repository.NutrizeRepository;

@Service
public class NutrizeService {

    private final NutrizeRepository repository;

    public NutrizeService(NutrizeRepository repository) {
        this.repository = repository;
    }

    public Nutrize create(Nutrize nutrize) {
        if (repository.findByEmail(nutrize.getEmail()).isPresent()) {
            throw new BusinessException("Já existe uma nutriz cadastrada com este email");
        }
        if (repository.findByCpf(nutrize.getCpf()).isPresent()) {
            throw new BusinessException("Já existe uma nutriz cadastrada com este CPF");
        }
        return repository.save(nutrize);
    }

    public Nutrize update(Nutrize nutrize) {
        return repository.save(nutrize);
    }

    public Nutrize findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nutriz não encontrada com id: " + id));
    }

    public List<Nutrize> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        findByIdOrThrow(id);
        repository.deleteById(id);
    }

    public Optional<Nutrize> autenticar(String emailOuCpf, String senha) {
        Optional<Nutrize> porEmail = repository.findByEmail(emailOuCpf);
        Optional<Nutrize> nutrize = porEmail.isPresent() ? porEmail : repository.findByCpf(emailOuCpf);
        return nutrize.filter(n -> n.getSenha().equals(senha));
    }
}