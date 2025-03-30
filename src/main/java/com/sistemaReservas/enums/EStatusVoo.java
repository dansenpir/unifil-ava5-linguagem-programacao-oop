package com.sistemaReservas.enums;

public enum EStatusVoo {
    PROGRAMADO("Voo programado e dentro do horário"),
    ATRASADO("Voo atrasado, aguardando nova previsão"),
    EM_ANDAMENTO("Voo em andamento, decolagem efetuada"),
    CONCLUIDO("Voo concluído, pouso realizado"),
    CANCELADO("Voo cancelado por motivos operacionais");

    private final String descricao;

    EStatusVoo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}