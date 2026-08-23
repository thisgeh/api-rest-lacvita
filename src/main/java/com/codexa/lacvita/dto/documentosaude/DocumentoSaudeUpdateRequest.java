package com.codexa.lacvita.dto.documentosaude;

import com.codexa.lacvita.model.enums.StatusDocumento;

import jakarta.validation.constraints.NotNull;

public class DocumentoSaudeUpdateRequest {

    @NotNull(message = "Status é obrigatório")
    private StatusDocumento status;

    public StatusDocumento getStatus() {
        return status;
    }

    public void setStatus(StatusDocumento status) {
        this.status = status;
    }
}