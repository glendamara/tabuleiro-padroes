import java.util.Random;

public abstract class Jogador {
    protected String cor;
    protected int moedas;
    protected int posicao;
    protected int jogadas;
    private boolean preso;
    private int rodadasPreso;

    // 🔹 Atributo do comportamento do jogador
    private TipoJogador tipoJogador;

    public Jogador(String cor, TipoJogador tipoInicial) {
        this.cor = cor;
        this.moedas = 0;
        this.posicao = 0;
        this.jogadas = 0;
        this.preso = false;
        this.rodadasPreso = 0;

        // 🔹 Se o tipo for null, escolhe um aleatoriamente
        this.tipoJogador = (tipoInicial != null) ? tipoInicial : escolherTipoAleatorio();
    }

    // ✅ Método que escolhe aleatoriamente um tipo de jogador
    private TipoJogador escolherTipoAleatorio() {
        Random random = new Random();
        int escolha = random.nextInt(3); // Gera 0, 1 ou 2

        switch (escolha) {
            case 0:
                return new JogadorNormal();
            case 1:
                return new JogadorSortudo();
            default:
                return new JogadorAzarado();
        }
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
        this.rodadasPreso = 0;
    }

    public void liberar() {
        this.preso = false;
        this.rodadasPreso = 0;
    }

    public void incrementarRodadasPreso() {
        this.rodadasPreso++;
    }

    public int getRodadasPreso() {
        return rodadasPreso;
    }

    // 🔄 Método para alterar o comportamento do jogador dinamicamente
    public void setTipo(TipoJogador novoTipo) {
        if (novoTipo != null) {
            this.tipoJogador = novoTipo;
            System.out.println(cor + " agora é " + novoTipo.getClass().getSimpleName());
        }
    }

    // 🔄 Agora delegamos a rolagem de dados ao tipo ativo do jogador
    public int rolarDados() {
        return this.tipoJogador.rolarDados();
    }
    public TipoJogador getTipoJogador() {
    return this.tipoJogador;
}


private int bonusMovimento = 0; // Inicialmente, sem bônus

public void setBonusMovimento(int bonus) {
    this.bonusMovimento = bonus;
}

public int getBonusMovimento() {
    return bonusMovimento;
}


}
