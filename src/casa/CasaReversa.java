package casa;

import jogador.Jogador;
import tabuleiro.Tabuleiro;

public class CasaReversa extends Casa {
    public CasaReversa(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        Jogador ultimo = Tabuleiro.getInstance().getJogadorMaisAtrasado();
        if (!jogador.equals(ultimo)) {
            int tempPosicao = jogador.getPosicao();
            jogador.setPosicao(ultimo.getPosicao());
            ultimo.setPosicao(tempPosicao);
        }
    }
}
