package com.codexa.lacvita.dto.documentosaude;

import com.codexa.lacvita.model.enums.TipoExame;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DocumentoSaudeCreateRequest {

    @NotNull
    private Long nutrizeId;

    @NotNull
    private TipoExame tipo;

    @NotBlank
    private String arquivoUrl;

    public Long getNutrizeId() {
        return nutrizeId;
    }

    public void setNutrizeId(Long nutrizeId) {
        this.nutrizeId = nutrizeId;
    }

    public TipoExame getTipo() {
        return tipo;
    }

    public void setTipo(TipoExame tipo) {
        this.tipo = tipo;
    }

    public String getArquivoUrl() {
        return arquivoUrl;
    }

    public void setArquivoUrl(String arquivoUrl) {
        this.arquivoUrl = arquivoUrl;
    }
}