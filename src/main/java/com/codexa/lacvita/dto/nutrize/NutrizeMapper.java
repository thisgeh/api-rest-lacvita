package com.codexa.lacvita.dto.nutrize;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.codexa.lacvita.model.Nutrize;

@Component
public class NutrizeMapper {

    private final ModelMapper modelMapper;

    public NutrizeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Nutrize toEntity(NutrizeCreateRequest dto) {
        return modelMapper.map(dto, Nutrize.class);
    }

    public void updateEntityFromDto(NutrizeUpdateRequest dto, Nutrize entity) {
        modelMapper.map(dto, entity);
    }

    public NutrizeResponse toDto(Nutrize entity) {
        return modelMapper.map(entity, NutrizeResponse.class);
        // "senha" da entidade não existe no NutrizeResponse, então o ModelMapper
        // simplesmente ignora esse campo — não precisa de configuração extra.
    }
}