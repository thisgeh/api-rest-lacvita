package com.codexa.lacvita.model;

import java.util.ArrayList;
import java.util.List;

import com.codexa.lacvita.model.enums.TipoPontoColeta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pontos_coleta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PontoColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoPontoColeta tipo;

    @Column(nullable = false)
    @Builder.Default
    private Boolean parceiroOficial = false;

    @Column(length = 9)
    private String cep;

    @Column(nullable = false, length = 150)
    private String logradouro;

    @Column(length = 10)
    private String numero;

    @Column(nullable = false, length = 80)
    private String bairro;

    @Column(nullable = false, length = 80)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String estado;

    private Double latitude;
    private Double longitude;

    @Column(length = 20)
    private String telefone;

    @Column(length = 100)
    private String horarioFuncionamento;

    @Column(nullable = false)
    @Builder.Default
    private Boolean aceitaColetaEmCasa = true;

    @Column(nullable = false)
    @Builder.Default
    private Boolean aceitaEntregaPresencial = true;

    @OneToMany(mappedBy = "pontoColeta")
    @Builder.Default
    private List<Agendamento> agendamentos = new ArrayList<>();
}