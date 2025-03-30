package com.sistemaReservas.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaReservas {
    private List<Voo> voos;
    private List<Passageiro> passageiros;
    private Map<String, List<Reserva>> reservasPorVoo;

    public SistemaReservas() {
        this.voos = new ArrayList<>();
        this.passageiros = new ArrayList<>();
        this.reservasPorVoo = new HashMap<>();
    }

    public void cadastrarVoo(
            String numeroVoo,
            String origem,
            String destino,
            LocalDateTime dataHoraPartida,
            int capacidadePassageiros) {
        Voo novoVoo = new Voo(numeroVoo, origem, destino, dataHoraPartida, capacidadePassageiros);
        voos.add(novoVoo);
        reservasPorVoo.put(numeroVoo, new ArrayList<>());
    }

    public void cadastrarPassageiro(
            String nome,
            String sobrenome,
            String numeroDocumento,
            String numeroTelefone) {
        Passageiro novoPassageiro = new Passageiro(nome, sobrenome, numeroDocumento, numeroTelefone);
        passageiros.add(novoPassageiro);
    }

    public boolean reservarAssento(
            String numeroVoo,
            String numeroDocumentoPassageiro,
            int numeroAssento) {
        Voo        voo        = buscarVoo(numeroVoo);
        Passageiro passageiro = buscarPassageiro(numeroDocumentoPassageiro);

        if (voo != null && passageiro != null && voo.reservarAssento(numeroAssento)) {
            Reserva novaReserva = new Reserva(voo, passageiro, numeroAssento);
            reservasPorVoo.get(numeroVoo).add(novaReserva);
            return true;
        }
        return false;
    }

    public Voo buscarVoo(String numeroVoo) {
        for (Voo voo : voos) {
            if (voo.getNumeroVoo().equals(numeroVoo)) {
                return voo;
            }
        }
        return null;
    }

    public Passageiro buscarPassageiro(String numeroDocumento) {
        for (Passageiro passageiro : passageiros) {
            if (passageiro.getNumeroDocumento().equals(numeroDocumento)) {
                return passageiro;
            }
        }
        return null;
    }

    public List<Voo> listarVoos() {
        return new ArrayList<>(voos);
    }

    public List<Reserva> listarReservasPorVoo(String numeroVoo) {
        return reservasPorVoo.getOrDefault(numeroVoo, new ArrayList<>());
    }
}