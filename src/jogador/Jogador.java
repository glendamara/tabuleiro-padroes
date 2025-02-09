package jogador;

public abstract class Jogador {
    protected String cor;
    protected int moedas;

    public Jogador(String cor) {
        this.cor = cor;
        this.moedas = 0;
    }

    public abstract void avancar(int casas);
    public void adicionarMoedas(int qtd) {
        this.moedas += qtd;
    }
}
