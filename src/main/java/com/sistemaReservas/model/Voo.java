package com.sistemaReservas.model;

import com.sistemaReservas.enums.EStatusVoo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Voo {
    private String numeroVoo;
    private String origem;
    private String destino;
    private LocalDateTime dataHoraPartida;
    private int capacidadePassageiros;
    private List<Integer> assentosDisponiveis;
    private EStatusVoo status;

    public Voo(
            String numeroVoo,
            String origem,
            String destino,
            LocalDateTime dataHoraPartida,
            int capacidadePassageiros) {
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.dataHoraPartida = dataHoraPartida;
        this.capacidadePassageiros = capacidadePassageiros;
        this.status = EStatusVoo.PROGRAMADO;
        inicializarAssentos();
    }

    private void inicializarAssentos() {
        assentosDisponiveis = new ArrayList<>();
        for (int i = 1; i <= capacidadePassageiros; i++) {
            assentosDisponiveis.add(i);
        }
    }

    public boolean reservarAssento(int numeroAssento) {
        if (assentosDisponiveis.contains(numeroAssento)) {
            assentosDisponiveis.remove(Integer.valueOf(numeroAssento));
            return true;
        }
        return false;
    }

    public int getQuantidadeAssentosDisponiveis() {
        return assentosDisponiveis.size();
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDateTime getDataHoraPartida() {
        return dataHoraPartida;
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public EStatusVoo getStatus() {
        return status;
    }

    public void setStatus(EStatusVoo status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "numeroVoo='" + numeroVoo + '\'' +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", dataHoraPartida=" + dataHoraPartida +
                ", capacidadePassageiros=" + capacidadePassageiros +
                ", assentosDisponiveis=" + getQuantidadeAssentosDisponiveis() +
                ", status=" + status +
                '}';
    }
}