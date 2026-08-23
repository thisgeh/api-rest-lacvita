package com.codexa.lacvita.model;

import java.time.LocalDateTime;

import com.codexa.lacvita.model.enums.TipoLembrete;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "lembretes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nutrize_id", nullable = false)
    private Nutrize nutrize;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoLembrete tipo; 

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 255)
    private String mensagem;

    @Column(nullable = false)
    @Builder.Default
    private Boolean lido = false;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime dataEnvio = LocalDateTime.now();
}