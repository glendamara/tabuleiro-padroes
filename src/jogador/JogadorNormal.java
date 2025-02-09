package jogador;

public class JogadorNormal extends Jogador {
    public JogadorNormal(String nome, String cor) {
        super(nome, cor);
    }

    @Override
    public int rolarDados() {
        return dado1.rolar() + dado2.rolar();
    }
}
