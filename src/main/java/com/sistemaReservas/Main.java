package com.sistemaReservas;

import com.sistemaReservas.model.SistemaReservas;
import com.sistemaReservas.model.Voo;
import com.sistemaReservas.model.Reserva;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final SistemaReservas sistema = new SistemaReservas();
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarVoo();
                    break;
                case 2:
                    cadastrarPassageiro();
                    break;
                case 3:
                    fazerReserva();
                    break;
                case 4:
                    listarVoos();
                    break;
                case 5:
                    listarReservas();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Reservas de Passagens Aéreas ===");
        System.out.println("1. Cadastrar Voo");
        System.out.println("2. Cadastrar Passageiro");
        System.out.println("3. Fazer Reserva");
        System.out.println("4. Listar Voos");
        System.out.println("5. Listar Reservas de um Voo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.nextLine();
            return -1;
        }
    }

    private static void cadastrarVoo() {
        try {
            System.out.print("Número do voo: ");
            String numeroVoo = scanner.nextLine();
            System.out.print("Origem: ");
            String origem = scanner.nextLine();
            System.out.print("Destino: ");
            String destino = scanner.nextLine();
            System.out.print("Data e hora de partida (dd/MM/yyyy HH:mm): ");
            String        dataHoraStr     = scanner.nextLine();
            LocalDateTime dataHoraPartida = LocalDateTime.parse(dataHoraStr, formatter);
            System.out.print("Capacidade de passageiros: ");
            int capacidade = scanner.nextInt();
            scanner.nextLine();

            sistema.cadastrarVoo(numeroVoo, origem, destino, dataHoraPartida, capacidade);
            System.out.println("Voo cadastrado com sucesso!");
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data/hora inválido. Use o formato dd/MM/yyyy HH:mm.");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida para capacidade. Digite um número inteiro.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void cadastrarPassageiro() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Número do documento: ");
        String numeroDocumento = scanner.nextLine();
        System.out.print("Número de telefone: ");
        String numeroTelefone = scanner.nextLine();

        try {
            sistema.cadastrarPassageiro(nome, sobrenome, numeroDocumento, numeroTelefone);
            System.out.println("Passageiro cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void fazerReserva() {
        System.out.print("Número do voo: ");
        String numeroVoo = scanner.nextLine();
        System.out.print("Número do documento do passageiro: ");
        String numeroDocumento = scanner.nextLine();
        System.out.print("Número do assento: ");
        int numeroAssento = scanner.nextInt();
        scanner.nextLine();

        try {
            boolean reservaFeita = sistema.reservarAssento(numeroVoo, numeroDocumento, numeroAssento);
            if (reservaFeita) {
                System.out.println("Reserva realizada com sucesso!");
            } else {
                System.out.println("Não foi possível realizar a reserva. Verifique os dados e tente novamente.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida para o número do assento. Digite um número inteiro.");
            scanner.nextLine();
        }
    }

    private static void listarVoos() {
        List<Voo> voos = sistema.listarVoos();
        if (voos.isEmpty()) {
            System.out.println("Não há voos cadastrados.");
        } else {
            System.out.println("Voos disponíveis:");
            for (Voo voo : voos) {
                System.out.println(voo);
            }
        }
    }

    private static void listarReservas() {
        System.out.print("Número do voo: ");
        String        numeroVoo = scanner.nextLine();
        List<Reserva> reservas  = sistema.listarReservasPorVoo(numeroVoo);
        if (reservas.isEmpty()) {
            System.out.println("Não há reservas para este voo.");
        } else {
            System.out.println("Reservas do voo " + numeroVoo + ":");
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }
}