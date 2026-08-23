package com.codexa.lacvita.dto.agendamento;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.codexa.lacvita.model.Agendamento;

import jakarta.annotation.PostConstruct;

@Component
public class AgendamentoMapper {

    private final ModelMapper modelMapper;

    public AgendamentoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    void configureMappings() {
        modelMapper.typeMap(AgendamentoCreateRequest.class, Agendamento.class)
                .addMappings(m -> m.skip(Agendamento::setId));
    }

    public Agendamento toEntity(AgendamentoCreateRequest dto) {
        return modelMapper.map(dto, Agendamento.class);
    }

    public void updateEntityFromDto(AgendamentoUpdateRequest dto, Agendamento entity) {
        modelMapper.map(dto, entity);
    }

    public AgendamentoResponse toDto(Agendamento entity) {
        AgendamentoResponse response = modelMapper.map(entity, AgendamentoResponse.class);
        response.setNutrizeId(entity.getNutrize() != null ? entity.getNutrize().getId() : null);
        response.setEnderecoId(entity.getEnderecoColeta() != null ? entity.getEnderecoColeta().getId() : null);
        response.setPontoColetaId(entity.getPontoColeta() != null ? entity.getPontoColeta().getId() : null);
        return response;
    }
}