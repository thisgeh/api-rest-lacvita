package com.codexa.lacvita.dto.endereco;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.codexa.lacvita.model.Endereco;

import jakarta.annotation.PostConstruct;

@Component
public class EnderecoMapper {

    private final ModelMapper modelMapper;

    public EnderecoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    void configureMappings() {
        // Defesa extra: o id da entidade NUNCA deve vir do DTO de criação.
        // Quem gera o id é o banco (GenerationType.AUTO).
        modelMapper.typeMap(EnderecoCreateRequest.class, Endereco.class)
                .addMappings(m -> m.skip(Endereco::setId));
    }

    public Endereco toEntity(EnderecoCreateRequest dto) {
        return modelMapper.map(dto, Endereco.class);
    }

    public void updateEntityFromDto(EnderecoUpdateRequest dto, Endereco entity) {
        modelMapper.map(dto, entity);
    }

    public EnderecoResponse toDto(Endereco entity) {
        EnderecoResponse response = modelMapper.map(entity, EnderecoResponse.class);
        response.setNutrizeId(entity.getNutrize() != null ? entity.getNutrize().getId() : null);
        return response;
    }
}