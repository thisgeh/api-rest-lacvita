package com.codexa.lacvita.dto.ponto;

import com.codexa.lacvita.model.enums.TipoPontoColeta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PontoColetaCreateRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Tipo é obrigatório")
    private TipoPontoColeta tipo;

    private Boolean parceiroOficial;

    @Pattern(regexp = "\\d{5}-?\\d{3}", message = "CEP inválido")
    private String cep;

    @NotBlank
    private String logradouro;

    private String numero;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    @Size(min = 2, max = 2, message = "Estado deve ser a sigla com 2 letras")
    private String estado;

    private Double latitude;
    private Double longitude;
    private String telefone;
    private String horarioFuncionamento;
    private Boolean aceitaColetaEmCasa;
    private Boolean aceitaEntregaPresencial;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPontoColeta getTipo() {
        return tipo;
    }

    public void setTipo(TipoPontoColeta tipo) {
        this.tipo = tipo;
    }

    public Boolean getParceiroOficial() {
        return parceiroOficial;
    }

    public void setParceiroOficial(Boolean parceiroOficial) {
        this.parceiroOficial = parceiroOficial;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public Boolean getAceitaColetaEmCasa() {
        return aceitaColetaEmCasa;
    }

    public void setAceitaColetaEmCasa(Boolean aceitaColetaEmCasa) {
        this.aceitaColetaEmCasa = aceitaColetaEmCasa;
    }

    public Boolean getAceitaEntregaPresencial() {
        return aceitaEntregaPresencial;
    }

    public void setAceitaEntregaPresencial(Boolean aceitaEntregaPresencial) {
        this.aceitaEntregaPresencial = aceitaEntregaPresencial;
    }
}