package com.codexa.lacvita.dto.qualidade;

import com.codexa.lacvita.model.enums.ResultadoAnalise;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class QualidadeLeiteUpdateRequest {

    @NotNull
    private ResultadoAnalise resultado;

    @Size(max = 255)
    private String observacoes;

    public ResultadoAnalise getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoAnalise resultado) {
        this.resultado = resultado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}