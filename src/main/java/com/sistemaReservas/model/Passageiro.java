package com.sistemaReservas.model;

public class Passageiro {
    private String nome;
    private String sobrenome;
    private String numeroDocumento;
    private String numeroTelefone;

    public Passageiro(String nome, String sobrenome, String numeroDocumento, String numeroTelefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroDocumento = numeroDocumento;
        this.numeroTelefone = numeroTelefone;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", numeroTelefone='" + numeroTelefone + '\'' +
                '}';
    }
}