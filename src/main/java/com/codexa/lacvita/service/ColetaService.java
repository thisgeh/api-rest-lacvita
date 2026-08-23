package com.codexa.lacvita.service;

import org.springframework.stereotype.Service;

import com.codexa.lacvita.exception.BusinessException;
import com.codexa.lacvita.exception.ResourceNotFoundException;
import com.codexa.lacvita.model.Agendamento;
import com.codexa.lacvita.model.Coleta;
import com.codexa.lacvita.model.enums.StatusColeta;
import com.codexa.lacvita.repository.ColetaRepository;

@Service
public class ColetaService {

    private final ColetaRepository repository;

    public ColetaService(ColetaRepository repository) {
        this.repository = repository;
    }

    public Coleta criarAPartirDeAgendamento(Agendamento agendamento) {
        if (repository.findByAgendamentoId(agendamento.getId()).isPresent()) {
            throw new BusinessException("Já existe uma coleta registrada para este agendamento");
        }
        Coleta coleta = Coleta.builder()
                .agendamento(agendamento)
                .status(StatusColeta.PENDENTE)
                .build();
        return repository.save(coleta);
    }

    public Coleta update(Coleta coleta) {
        return repository.save(coleta);
    }

    public Coleta findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coleta não encontrada com id: " + id));
    }

    public Coleta findByAgendamentoIdOrThrow(Long agendamentoId) {
        return repository.findByAgendamentoId(agendamentoId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Coleta não encontrada para o agendamento id: " + agendamentoId));
    }
}