package com.sistemaReservas.model;

public class Reserva {
    private Voo voo;
    private Passageiro passageiro;
    private int numeroAssento;

    public Reserva(
            Voo voo,
            Passageiro passageiro,
            int numeroAssento) {
        this.voo = voo;
        this.passageiro = passageiro;
        this.numeroAssento = numeroAssento;
    }

    public Voo getVoo() {
        return voo;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public int getNumeroAssento() {
        return numeroAssento;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "voo=" + voo.getNumeroVoo() +
                ", passageiro=" + passageiro.getNomeCompleto() +
                ", numeroAssento=" + numeroAssento +
                '}';
    }
}