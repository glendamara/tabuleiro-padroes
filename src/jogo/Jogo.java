package jogo;

import tabuleiro.Tabuleiro;
import jogador.Jogador;
import casa.Casa;
import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private boolean jogoAtivo;
    private Scanner scanner;

    public Jogo() {
        this.tabuleiro = Tabuleiro.getInstancia();
        this.jogoAtivo = true;
        this.scanner = new Scanner(System.in);
    }

    public void configTabuleiro(int numCasas) {
        for (int i = 0; i < numCasas; i++) {
            tabuleiro.adicionarCasa(CasaFactory.criarCasa("simples", i));
        }
    }

    public void config(int numJogadores) {
        for (int i = 0; i < numJogadores; i++) {
            System.out.println("Digite a cor do jogador " + (i + 1) + ":");
            String cor = scanner.next();
            System.out.println("Digite o tipo (normal, sortudo, azarado):");
            String tipo = scanner.next();
            tabuleiro.adicionarJogador(JogadorFactory.criarJogador(tipo, cor));
        }
    }

    public void start() {
        System.out.println("Jogo iniciado!");
        while (jogoAtivo) {
            for (Jogador jogador : tabuleiro.getJogadores()) {
                if (!jogoAtivo) break;

                System.out.println("\nVez do jogador: " + jogador.getCor());
                int dado = jogador.rolarDados();
                System.out.println("Jogador " + jogador.getCor() + " tirou " + dado);

                // Lógica de movimento e aplicação de regras
                // Exibir estado do tabuleiro
            }
        }
        System.out.println("Jogo encerrado.");
    }
}