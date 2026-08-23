package com.codexa.lacvita.dto.ponto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.codexa.lacvita.model.PontoColeta;

@Component
public class PontoColetaMapper {

    private final ModelMapper modelMapper;

    public PontoColetaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PontoColeta toEntity(PontoColetaCreateRequest dto) {
        return modelMapper.map(dto, PontoColeta.class);
    }

    public void updateEntityFromDto(PontoColetaUpdateRequest dto, PontoColeta entity) {
        modelMapper.map(dto, entity);
    }

    public PontoColetaResponse toDto(PontoColeta entity) {
        return modelMapper.map(entity, PontoColetaResponse.class);
    }
}