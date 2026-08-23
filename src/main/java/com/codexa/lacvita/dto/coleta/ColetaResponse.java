package com.codexa.lacvita.dto.coleta;

import java.time.LocalDateTime;

import com.codexa.lacvita.model.enums.StatusColeta;

public class ColetaResponse {

    private Long id;
    private Long agendamentoId;
    private StatusColeta status;
    private Integer volumeColetadoMl;
    private LocalDateTime dataRealizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgendamentoId() {
        return agendamentoId;
    }

    public void setAgendamentoId(Long agendamentoId) {
        this.agendamentoId = agendamentoId;
    }

    public StatusColeta getStatus() {
        return status;
    }

    public void setStatus(StatusColeta status) {
        this.status = status;
    }

    public Integer getVolumeColetadoMl() {
        return volumeColetadoMl;
    }

    public void setVolumeColetadoMl(Integer volumeColetadoMl) {
        this.volumeColetadoMl = volumeColetadoMl;
    }

    public LocalDateTime getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDateTime dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
}