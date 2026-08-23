package com.codexa.lacvita.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "feedbacks_doadora")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackDoadora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nutrize_id", nullable = false)
    private Nutrize nutrize;

    @ManyToOne
    @JoinColumn(name = "coleta_id")
    private Coleta coleta; 

    @Column(nullable = false)
    private Integer nota; 

    @Column(length = 500)
    private String comentario;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime dataFeedback = LocalDateTime.now();
}