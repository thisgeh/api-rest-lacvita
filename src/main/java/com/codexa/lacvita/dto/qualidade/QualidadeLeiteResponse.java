package com.codexa.lacvita.dto.qualidade;

import java.time.LocalDateTime;

import com.codexa.lacvita.model.enums.ResultadoAnalise;

public class QualidadeLeiteResponse {

    private Long id;
    private Long coletaId;
    private String aparencia;
    private Double temperaturaColetaC;
    private ResultadoAnalise resultado;
    private String observacoes;
    private LocalDateTime dataAnalise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(LocalDateTime dataAnalise) {
        this.dataAnalise = dataAnalise;
    }
}