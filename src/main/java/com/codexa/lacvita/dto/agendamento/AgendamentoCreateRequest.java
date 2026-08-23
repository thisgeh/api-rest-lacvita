package com.codexa.lacvita.dto.agendamento;

import java.time.LocalDate;
import java.time.LocalTime;

import com.codexa.lacvita.model.enums.TipoColeta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public class AgendamentoCreateRequest {

    @NotNull
    private Long nutrizeId;

    @NotNull
    private TipoColeta tipoColeta;

    private Long enderecoId;

    private Long pontoColetaId;

    @NotNull
    @Future
    private LocalDate dataAgendada;

    @NotNull
    private LocalTime horaAgendada;

    private String observacoes;

    public Long getNutrizeId() {
        return nutrizeId;
    }

    public void setNutrizeId(Long nutrizeId) {
        this.nutrizeId = nutrizeId;
    }

    public TipoColeta getTipoColeta() {
        return tipoColeta;
    }

    public void setTipoColeta(TipoColeta tipoColeta) {
        this.tipoColeta = tipoColeta;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Long getPontoColetaId() {
        return pontoColetaId;
    }

    public void setPontoColetaId(Long pontoColetaId) {
        this.pontoColetaId = pontoColetaId;
    }

    public LocalDate getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(LocalDate dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public LocalTime getHoraAgendada() {
        return horaAgendada;
    }

    public void setHoraAgendada(LocalTime horaAgendada) {
        this.horaAgendada = horaAgendada;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}