package com.codexa.lacvita.dto.nutrize;

import java.time.LocalDateTime;

public class NutrizeResponse {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private Boolean mae;
    private Boolean amamentando;
    private Boolean saudavel;
    private Boolean usaMedicamento;
    private Boolean teveDoencaRecente;
    private Boolean ativo;
    private LocalDateTime dataCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getMae() {
        return mae;
    }

    public void setMae(Boolean mae) {
        this.mae = mae;
    }

    public Boolean getAmamentando() {
        return amamentando;
    }

    public void setAmamentando(Boolean amamentando) {
        this.amamentando = amamentando;
    }

    public Boolean getSaudavel() {
        return saudavel;
    }

    public void setSaudavel(Boolean saudavel) {
        this.saudavel = saudavel;
    }

    public Boolean getUsaMedicamento() {
        return usaMedicamento;
    }

    public void setUsaMedicamento(Boolean usaMedicamento) {
        this.usaMedicamento = usaMedicamento;
    }

    public Boolean getTeveDoencaRecente() {
        return teveDoencaRecente;
    }

    public void setTeveDoencaRecente(Boolean teveDoencaRecente) {
        this.teveDoencaRecente = teveDoencaRecente;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}