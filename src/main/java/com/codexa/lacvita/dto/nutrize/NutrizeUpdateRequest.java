package com.codexa.lacvita.dto.nutrize;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class NutrizeUpdateRequest {

    @NotBlank
    @Size(min = 3, max = 150, message = "Nome deve ter entre 3 e 150 caracteres")
    private String nome;

    @NotBlank
    @Email
    private String email;

    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter 10 ou 11 dígitos")
    private String telefone;

    //Triagem
    private Boolean mae;
    private Boolean amamentando;
    private Boolean saudavel;
    private Boolean usaMedicamento;
    private Boolean teveDoencaRecente;

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
}