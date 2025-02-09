package jogador;
import util.*;

public class JogadorAzarado extends Jogador {
    public JogadorAzarado(String cor) {
        super(cor);
    }

    @Override
    public int rolarDados() {
        int soma;
        do {
            soma = Dado.rolar() + Dado.rolar();
        } while (soma > 6);
        return soma;
    }
}