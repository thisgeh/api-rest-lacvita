package com.codexa.lacvita.model;

import java.time.LocalDateTime;

import com.codexa.lacvita.model.enums.ResultadoAnalise;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "qualidade_leite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QualidadeLeite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "coleta_id", nullable = false, unique = true)
    private Coleta coleta;

    @Column(length = 60)
    private String aparencia; // ex.: "Normal", "Alterada"

    private Double temperaturaColetaC;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private ResultadoAnalise resultado = ResultadoAnalise.EM_ANALISE;

    @Column(length = 255)
    private String observacoes;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime dataAnalise = LocalDateTime.now();
}