package com.codexa.lacvita.dto.agendamento;

import java.time.LocalDate;
import java.time.LocalTime;

import com.codexa.lacvita.model.enums.StatusAgendamento;

import jakarta.validation.constraints.NotNull;

public class AgendamentoUpdateRequest {

    private LocalDate dataAgendada;
    private LocalTime horaAgendada;

    @NotNull
    private StatusAgendamento status;

    private String observacoes;

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
}