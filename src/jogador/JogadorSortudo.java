package jogador;

import java.util.Random;

public class JogadorSortudo extends Jogador {
    private Random random = new Random();

    public JogadorSortudo(String nome, String cor) {
        super(nome, cor);
    }

    @Override
    public int rolarDados() {
        int soma;
        do {
            soma = dado1.rolar() + dado2.rolar();
        } while (soma < 7);
        return soma;
    }
}
