
package jogador;

public abstract class Jogador {
    protected String cor;
    protected int moedas;
    protected int posicao;
    protected int jogadas;
    private boolean preso; // Indica se o jogador está preso
    private int rodadasPreso; // Contador de rodadas que o jogador está preso

    public Jogador(String cor) {
        this.cor = cor;
        this.moedas = 0;
        this.posicao = 0;
        this.jogadas = 0;
        this.preso = false; // Inicialmente, o jogador não está preso
        this.rodadasPreso = 0; // Inicialmente, o jogador não tem rodadas de prisão
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

    public boolean isPreso() {
        return preso;
    }

    public void prender() {
        this.preso = true;
        this.rodadasPreso = 0; // Reseta o contador de rodadas
    }

    public void liberar() {
        this.preso = false;
        this.rodadasPreso = 0; // Reseta o contador de rodadas
    }

    public void incrementarRodadasPreso() {
        this.rodadasPreso++;
    }

    public int getRodadasPreso() {
        return rodadasPreso;
    }

    public abstract int rolarDados();
}