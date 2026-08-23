package com.codexa.lacvita.dto.feedback;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.codexa.lacvita.model.FeedbackDoadora;

import jakarta.annotation.PostConstruct;

@Component
public class FeedbackDoadoraMapper {

    private final ModelMapper modelMapper;

    public FeedbackDoadoraMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    void configureMappings() {
        modelMapper.typeMap(FeedbackDoadoraCreateRequest.class, FeedbackDoadora.class)
                .addMappings(m -> m.skip(FeedbackDoadora::setId));
    }

    public FeedbackDoadora toEntity(FeedbackDoadoraCreateRequest dto) {
        return modelMapper.map(dto, FeedbackDoadora.class);
    }

    public FeedbackDoadoraResponse toDto(FeedbackDoadora entity) {
        FeedbackDoadoraResponse response = modelMapper.map(entity, FeedbackDoadoraResponse.class);
        response.setNutrizeId(entity.getNutrize() != null ? entity.getNutrize().getId() : null);
        response.setColetaId(entity.getColeta() != null ? entity.getColeta().getId() : null);
        return response;
    }
}