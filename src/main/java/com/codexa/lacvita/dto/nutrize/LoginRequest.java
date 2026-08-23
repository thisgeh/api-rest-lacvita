package com.codexa.lacvita.dto.nutrize;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Email ou CPF é obrigatório")
    private String emailOuCpf;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;

    public String getEmailOuCpf() {
        return emailOuCpf;
    }

    public void setEmailOuCpf(String emailOuCpf) {
        this.emailOuCpf = emailOuCpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}