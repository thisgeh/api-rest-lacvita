package com.codexa.lacvita.dto.lembrete;

import com.codexa.lacvita.model.enums.TipoLembrete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LembreteCreateRequest {

    @NotNull
    private Long nutrizeId;

    @NotNull
    private TipoLembrete tipo;

    @NotBlank
    @Size(max = 100)
    private String titulo;

    @NotBlank
    @Size(max = 255)
    private String mensagem;

    public Long getNutrizeId() {
        return nutrizeId;
    }

    public void setNutrizeId(Long nutrizeId) {
        this.nutrizeId = nutrizeId;
    }

    public TipoLembrete getTipo() {
        return tipo;
    }

    public void setTipo(TipoLembrete tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}