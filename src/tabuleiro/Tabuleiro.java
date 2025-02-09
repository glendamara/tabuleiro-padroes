// /tabuleiro/Tabuleiro.java
package tabuleiro;

import java.util.ArrayList;
import jogador.Jogador;
import casa.Casa;

public class Tabuleiro {
    private static Tabuleiro instancia;
    private ArrayList<Casa> casas;
    private ArrayList<Jogador> jogadores;

    private Tabuleiro() {
        casas = new ArrayList<>();
        jogadores = new ArrayList<>();
    }

    public static Tabuleiro getInstancia() {
        if (instancia == null) {
            instancia = new Tabuleiro();
        }
        return instancia;
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void adicionarCasa(Casa casa) {
        casas.add(casa);
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public Jogador getJogadorMaisAtrasado() {
        Jogador jogadorMaisAtrasado = jogadores.get(0); // Começa assumindo que o primeiro jogador é o mais atrasado

        for (Jogador jogador : jogadores) {
            if (jogador.getPosicao() < jogadorMaisAtrasado.getPosicao()) {
                jogadorMaisAtrasado = jogador; // Atualiza se encontrar um jogador mais atrasado
            }
        }

        return jogadorMaisAtrasado; // Retorna o jogador mais atrasado
    }
}