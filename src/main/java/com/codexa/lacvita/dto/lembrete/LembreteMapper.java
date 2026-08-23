package com.codexa.lacvita.dto.lembrete;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.codexa.lacvita.model.Lembrete;

@Component
public class LembreteMapper {

    private final ModelMapper modelMapper;

    public LembreteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public LembreteResponse toDto(Lembrete entity) {
        LembreteResponse response = modelMapper.map(entity, LembreteResponse.class);
        response.setNutrizeId(entity.getNutrize() != null ? entity.getNutrize().getId() : null);
        return response;
    }
}