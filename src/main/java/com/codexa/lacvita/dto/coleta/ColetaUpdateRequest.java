package com.codexa.lacvita.dto.coleta;

import java.time.LocalDateTime;

import com.codexa.lacvita.model.enums.StatusColeta;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ColetaUpdateRequest {

    @NotNull
    private StatusColeta status;

    @Positive
    private Integer volumeColetadoMl;

    private LocalDateTime dataRealizacao;

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