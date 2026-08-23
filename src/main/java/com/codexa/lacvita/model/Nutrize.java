package com.codexa.lacvita.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nutrizes")
@Getter
@Setter
@NoArgsConstructor
public class Nutrize {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(nullable = false)
    private String senha;

    @Column(length = 20)
    private String telefone;

    //Triagem inicial 
    @Column(name = "eh_mae")
    private Boolean mae;

    private Boolean amamentando;
    private Boolean saudavel;

    @Column(name = "usa_medicamento")
    private Boolean usaMedicamento;

    @Column(name = "teve_doenca_recente")
    private Boolean teveDoencaRecente;

    @Column(nullable = false)
    private Boolean ativo = true;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    // --- Relacionamentos ---
    @OneToMany(mappedBy = "nutrize", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "nutrize", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocumentoSaude> documentosSaude = new ArrayList<>();

    @OneToMany(mappedBy = "nutrize")
    private List<Agendamento> agendamentos = new ArrayList<>();
}