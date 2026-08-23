package com.codexa.lacvita.dto.lembrete;

import java.time.LocalDateTime;

import com.codexa.lacvita.model.enums.TipoLembrete;

public class LembreteResponse {

    private Long id;
    private Long nutrizeId;
    private TipoLembrete tipo;
    private String titulo;
    private String mensagem;
    private Boolean lido;
    private LocalDateTime dataEnvio;

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

    public Boolean getLido() {
        return lido;
    }

    public void setLido(Boolean lido) {
        this.lido = lido;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}