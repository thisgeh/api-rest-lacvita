package com.codexa.lacvita.dto.qualidade;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.codexa.lacvita.model.QualidadeLeite;

import jakarta.annotation.PostConstruct;

@Component
public class QualidadeLeiteMapper {

    private final ModelMapper modelMapper;

    public QualidadeLeiteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    void configureMappings() {
        modelMapper.typeMap(QualidadeLeiteCreateRequest.class, QualidadeLeite.class)
                .addMappings(m -> m.skip(QualidadeLeite::setId));
    }

    public QualidadeLeite toEntity(QualidadeLeiteCreateRequest dto) {
        return modelMapper.map(dto, QualidadeLeite.class);
    }

    public void updateEntityFromDto(QualidadeLeiteUpdateRequest dto, QualidadeLeite entity) {
        modelMapper.map(dto, entity);
    }

    public QualidadeLeiteResponse toDto(QualidadeLeite entity) {
        QualidadeLeiteResponse response = modelMapper.map(entity, QualidadeLeiteResponse.class);
        response.setColetaId(entity.getColeta() != null ? entity.getColeta().getId() : null);
        return response;
    }
}