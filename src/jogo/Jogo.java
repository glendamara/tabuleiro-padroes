package jogo;

import java.util.List;
import java.util.Scanner;
import tabuleiro.*;
import jogador.*;
import casa.Casa;
import casa.CasaFactory;

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
        List<Jogador> jogadores = tabuleiro.getJogadores();
        
        while (jogoAtivo) {
            for (Jogador jogador : jogadores) {
                if (!jogoAtivo) break;
                
                System.out.println("\nVez do jogador: " + jogador.getCor());
                System.out.println("Pressione ENTER para rolar o dado...");
                scanner.nextLine();
                
                int dado = jogador.rolarDado();
                System.out.println("Jogador " + jogador.getCor() + " tirou " + dado);
                
                tabuleiro.moverJogador(jogador, dado);
                
                Casa casaAtual = tabuleiro.getCasa(jogador.getPosicao());
                casaAtual.acao(jogador);
                
                if (jogador.getPosicao() >= tabuleiro.getNumeroCasas() - 1) {
                    System.out.println("\nParabéns! O jogador " + jogador.getCor() + " venceu!");
                    jogoAtivo = false;
                    break;
                }
            }
        }
        System.out.println("Jogo encerrado.");
    }

    public void printTabuleiro() {
        System.out.println("\nEstado atual do tabuleiro:");
        for (Jogador jogador : tabuleiro.getJogadores()) {
            System.out.println("Jogador " + jogador.getCor() + " está na posição " + jogador.getPosicao());
        }
    }
}
