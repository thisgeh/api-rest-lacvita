package com.codexa.lacvita.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                // STRICT evita que campos como "nutrizeId" sejam mapeados
                // ambiguamente tanto para o relacionamento (nutrize.id)
                // quanto para o id da própria entidade de destino (Endereco.id,
                // DocumentoSaude.id, etc). Com STANDARD (default), o ModelMapper
                // mapeia para os dois ao mesmo tempo, fazendo o Spring Data JPA
                // achar que a entidade já existe e tentar um UPDATE em vez de
                // um INSERT no save() -> "Row was already updated or deleted...".
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true);

        return modelMapper;
    }
}