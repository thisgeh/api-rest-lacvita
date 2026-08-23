// AgendamentoService.java
package com.codexa.lacvita.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codexa.lacvita.exception.BusinessException;
import com.codexa.lacvita.exception.ResourceNotFoundException;
import com.codexa.lacvita.model.Agendamento;
import com.codexa.lacvita.model.Endereco;
import com.codexa.lacvita.model.Nutrize;
import com.codexa.lacvita.model.PontoColeta;
import com.codexa.lacvita.model.enums.StatusAgendamento;
import com.codexa.lacvita.model.enums.TipoColeta;
import com.codexa.lacvita.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final NutrizeService nutrizeService;
    private final EnderecoService enderecoService;
    private final PontoColetaService pontoColetaService;
    private final ColetaService coletaService;

    public AgendamentoService(AgendamentoRepository repository, NutrizeService nutrizeService,
            EnderecoService enderecoService, PontoColetaService pontoColetaService,
            ColetaService coletaService) {
        this.repository = repository;
        this.nutrizeService = nutrizeService;
        this.enderecoService = enderecoService;
        this.pontoColetaService = pontoColetaService;
        this.coletaService = coletaService;
    }

    public Agendamento create(Agendamento agendamento, Long nutrizeId, Long enderecoId, Long pontoColetaId) {
        Nutrize nutrize = nutrizeService.findByIdOrThrow(nutrizeId);
        agendamento.setNutrize(nutrize);

        if (agendamento.getTipoColeta() == TipoColeta.EM_CASA) {
            if (enderecoId == null) {
                throw new BusinessException("Endereço é obrigatório para coleta em casa");
            }
            Endereco endereco = enderecoService.findByIdOrThrow(enderecoId);
            agendamento.setEnderecoColeta(endereco);
        } else if (agendamento.getTipoColeta() == TipoColeta.PONTO_COLETA) {
            if (pontoColetaId == null) {
                throw new BusinessException("Ponto de coleta é obrigatório para entrega presencial");
            }
            PontoColeta pontoColeta = pontoColetaService.findByIdOrThrow(pontoColetaId);
            agendamento.setPontoColeta(pontoColeta);
        }

        return repository.save(agendamento);
    }

    public Agendamento update(Agendamento agendamento) {
        Agendamento salvo = repository.save(agendamento);

        if (salvo.getStatus() == StatusAgendamento.REALIZADO) {
            coletaService.criarAPartirDeAgendamento(salvo);
        }

        return salvo;
    }

    public Agendamento findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado com id: " + id));
    }

    public List<Agendamento> findByNutrizeId(Long nutrizeId) {
        return repository.findByNutrizeId(nutrizeId);
    }

    public void deleteById(Long id) {
        findByIdOrThrow(id);
        repository.deleteById(id);
    }
}