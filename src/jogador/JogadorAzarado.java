package jogador;

import java.util.Random;

public class JogadorAzarado extends Jogador {
    private Random random = new Random();

    public JogadorAzarado(String nome, String cor) {
        super(nome, cor);
    }

    @Override
    public int rolarDados() {
        int soma;
        do {
            soma = dado1.rolar() + dado2.rolar();
        } while (soma > 6);
        return soma;
    }
}
