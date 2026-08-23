package com.codexa.lacvita.dto.feedback;

import java.time.LocalDateTime;

public class FeedbackDoadoraResponse {

    private Long id;
    private Long nutrizeId;
    private Long coletaId;
    private Integer nota;
    private String comentario;
    private LocalDateTime dataFeedback;

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

    public Long getColetaId() {
        return coletaId;
    }

    public void setColetaId(Long coletaId) {
        this.coletaId = coletaId;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getDataFeedback() {
        return dataFeedback;
    }

    public void setDataFeedback(LocalDateTime dataFeedback) {
        this.dataFeedback = dataFeedback;
    }
}