package com.codexa.lacvita.dto.qualidade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class QualidadeLeiteCreateRequest {

    @NotNull
    private Long coletaId;

    @NotBlank
    private String aparencia;

    private Double temperaturaColetaC;
    private String observacoes;

    public Long getColetaId() {
        return coletaId;
    }

    public void setColetaId(Long coletaId) {
        this.coletaId = coletaId;
    }

    public String getAparencia() {
        return aparencia;
    }

    public void setAparencia(String aparencia) {
        this.aparencia = aparencia;
    }

    public Double getTemperaturaColetaC() {
        return temperaturaColetaC;
    }

    public void setTemperaturaColetaC(Double temperaturaColetaC) {
        this.temperaturaColetaC = temperaturaColetaC;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}