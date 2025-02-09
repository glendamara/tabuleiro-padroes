
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

                // Verifica se o jogador está preso
                if (jogador.isPreso()) {
                    System.out.println(jogador.getCor() + " está preso e não pode jogar nesta rodada.");
                    jogador.incrementarRodadasPreso(); // Incrementa o contador de rodadas
                    if (jogador.getRodadasPreso() >= 2) {
                        jogador.liberar(); // Libera o jogador após 2 rodadas
                        System.out.println(jogador.getCor() + " foi liberado da prisão!");
                    }
                    continue; // Pula para o próximo jogador
                }

                System.out.println("\nVez do jogador: " + jogador.getCor());
                int dado = jogador.rolarDados();
                System.out.println("Jogador " + jogador.getCor() + " tirou " + dado);

                // Lógica de movimento
                jogador.setPosicao(jogador.getPosicao() + dado);
                System.out.println(jogador.getCor() + " está na casa " + jogador.getPosicao());

                // Aplicar regra da casa
                Casa casaAtual = tabuleiro.getCasas().get(jogador.getPosicao());
                casaAtual.aplicarRegra(jogador);

                // Verificar se o jogador venceu
                if (jogador.getPosicao() >= tabuleiro.getCasas().size() - 1) {
                    System.out.println(jogador.getCor() + " venceu o jogo!");
                    jogoAtivo = false;
                    break;
                }
            }
        }
        System.out.println("Jogo encerrado.");
    }

    public void startDebug() {
        System.out.println("Modo Debug iniciado!");
        while (jogoAtivo) {
            for (Jogador jogador : tabuleiro.getJogadores()) {
                if (!jogoAtivo) break;

                // Verifica se o jogador está preso
                if (jogador.isPreso()) {
                    System.out.println(jogador.getCor() + " está preso e não pode jogar nesta rodada.");
                    jogador.incrementarRodadasPreso(); // Incrementa o contador de rodadas
                    if (jogador.getRodadasPreso() >= 2) {
                        jogador.liberar(); // Libera o jogador após 2 rodadas
                        System.out.println(jogador.getCor() + " foi liberado da prisão!");
                    }
                    continue; // Pula para o próximo jogador
                }

                System.out.println("\nVez do jogador: " + jogador.getCor());
                System.out.println("Digite o número da casa para onde deseja ir:");
                int casaEscolhida = scanner.nextInt();
                jogador.setPosicao(casaEscolhida);
                System.out.println(jogador.getCor() + " está na casa " + jogador.getPosicao());

                // Aplicar regra da casa
                Casa casaAtual = tabuleiro.getCasas().get(jogador.getPosicao());
                casaAtual.aplicarRegra(jogador);

                // Verificar se o jogador venceu
                if (jogador.getPosicao() >= tabuleiro.getCasas().size() - 1) {
                    System.out.println(jogador.getCor() + " venceu o jogo!");
                    jogoAtivo = false;
                    break;
                }
            }
        }
        System.out.println("Jogo encerrado.");
    }
}