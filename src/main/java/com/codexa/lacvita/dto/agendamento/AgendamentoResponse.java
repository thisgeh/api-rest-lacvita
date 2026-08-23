package com.codexa.lacvita.dto.agendamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.codexa.lacvita.model.enums.StatusAgendamento;
import com.codexa.lacvita.model.enums.TipoColeta;

public class AgendamentoResponse {

    private Long id;
    private Long nutrizeId;
    private TipoColeta tipoColeta;
    private Long enderecoId;
    private Long pontoColetaId;
    private LocalDate dataAgendada;
    private LocalTime horaAgendada;
    private StatusAgendamento status;
    private String observacoes;
    private LocalDateTime dataCriacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}