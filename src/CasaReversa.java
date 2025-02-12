

public class CasaReversa extends Casa {
    public CasaReversa(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        Jogador ultimo = Tabuleiro.getInstancia().getJogadorMaisAtrasado();
        if (!jogador.equals(ultimo)) {
            int tempPosicao = jogador.getPosicao();
            jogador.setPosicao(ultimo.getPosicao());
            ultimo.setPosicao(tempPosicao);
            System.out.println(jogador.getCor() + " trocou de lugar com " + ultimo.getCor());
        }
    }
}