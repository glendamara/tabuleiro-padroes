package jogador;

public abstract class Jogador {
    protected String cor;
    protected int moedas;
    protected int posicao;
    protected int jogadas;

    public Jogador(String cor) {
        this.cor = cor;
        this.moedas = 0;
        this.posicao = 0;
        this.jogadas = 0;
    }

    public String getCor() {
        return cor;
    }

    public int getMoedas() {
        return moedas;
    }

    public int getPosicao() {
        return posicao;
    }

    public void adicionarMoedas(int qtd) {
        this.moedas += qtd;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public void incrementarJogadas() {
        this.jogadas++;
    }

    public abstract int rolarDados();
}