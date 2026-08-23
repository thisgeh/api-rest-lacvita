package com.codexa.lacvita.dto.coleta;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.codexa.lacvita.model.Coleta;

@Component
public class ColetaMapper {

    private final ModelMapper modelMapper;

    public ColetaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public void updateEntityFromDto(ColetaUpdateRequest dto, Coleta entity) {
        modelMapper.map(dto, entity);
    }

    public ColetaResponse toDto(Coleta entity) {
        ColetaResponse response = modelMapper.map(entity, ColetaResponse.class);
        response.setAgendamentoId(entity.getAgendamento() != null ? entity.getAgendamento().getId() : null);
        return response;
    }
}