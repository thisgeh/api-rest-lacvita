package com.codexa.lacvita.dto.documentosaude;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.codexa.lacvita.model.DocumentoSaude;

import jakarta.annotation.PostConstruct;

@Component
public class DocumentoSaudeMapper {

    private final ModelMapper modelMapper;

    public DocumentoSaudeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    void configureMappings() {
        modelMapper.typeMap(DocumentoSaudeCreateRequest.class, DocumentoSaude.class)
                .addMappings(m -> m.skip(DocumentoSaude::setId));
    }

    public DocumentoSaude toEntity(DocumentoSaudeCreateRequest dto) {
        return modelMapper.map(dto, DocumentoSaude.class);
    }

    public void updateEntityFromDto(DocumentoSaudeUpdateRequest dto, DocumentoSaude entity) {
        modelMapper.map(dto, entity);
    }

    public DocumentoSaudeResponse toDto(DocumentoSaude entity) {
        DocumentoSaudeResponse response = modelMapper.map(entity, DocumentoSaudeResponse.class);
        response.setNutrizeId(entity.getNutrize() != null ? entity.getNutrize().getId() : null);
        return response;
    }
}