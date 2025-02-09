package jogador;

import util.Dado;

public class JogadorNormal extends Jogador {
    public JogadorNormal(String cor) {
        super(cor);
    }

    @Override
    public int rolarDados() {
        return Dado.rolar() + Dado.rolar();
    }
}
