package com.codexa.lacvita.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codexa.lacvita.exception.ResourceNotFoundException;
import com.codexa.lacvita.model.Lembrete;
import com.codexa.lacvita.model.Nutrize;
import com.codexa.lacvita.model.enums.TipoLembrete;
import com.codexa.lacvita.repository.LembreteRepository;

@Service
public class LembreteService {

    private final LembreteRepository repository;

    public LembreteService(LembreteRepository repository) {
        this.repository = repository;
    }

    public Lembrete criar(Nutrize nutrize, TipoLembrete tipo, String titulo, String mensagem) {
        Lembrete lembrete = Lembrete.builder()
                .nutrize(nutrize)
                .tipo(tipo)
                .titulo(titulo)
                .mensagem(mensagem)
                .build();
        return repository.save(lembrete);
    }

    public Lembrete marcarComoLido(Long id) {
        Lembrete lembrete = findByIdOrThrow(id);
        lembrete.setLido(true);
        return repository.save(lembrete);
    }

    public Lembrete findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lembrete não encontrado com id: " + id));
    }

    public List<Lembrete> findByNutrizeId(Long nutrizeId) {
        return repository.findByNutrizeId(nutrizeId);
    }
}