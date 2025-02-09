package casa;

import jogador.Jogador;
import jogador.JogadorNormal;
import jogador.JogadorSortudo;
import jogador.JogadorAzarado;

import java.util.Random;

public class CasaSurpresa extends Casa {
    private static final Random random = new Random();

    public CasaSurpresa(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        int sorteio = random.nextInt(3); // 0, 1 ou 2

        switch (sorteio) {
            case 0:
                jogador.setTipo(new JogadorNormal(jogador.getCor()));
                System.out.println(jogador.getCor() + " agora é um Jogador Normal!");
                break;
            case 1:
                jogador.setTipo(new JogadorSortudo(jogador.getCor()));
                System.out.println(jogador.getCor() + " agora é um Jogador Sortudo!");
                break;
            case 2:
                jogador.setTipo(new JogadorAzarado(jogador.getCor()));
                System.out.println(jogador.getCor() + " agora é um Jogador Azarado!");
                break;
        }
    }
}
