package jogador;
import util.Dado;

public class JogadorSortudo extends Jogador {
    public JogadorSortudo(String cor) {
        super(cor);
    }

    @Override
    public int rolarDados() {
        int soma;
        do {
            soma = Dado.rolar() + Dado.rolar();
        } while (soma < 7);
        return soma;
    }
}