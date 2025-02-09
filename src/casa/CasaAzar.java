package casa;

import jogador.Jogador;
import jogador.JogadorSortudo;

public class CasaAzar extends Casa {
    public CasaAzar(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        if (!(jogador instanceof JogadorSortudo)) {
            jogador.removerMoedas(3);
        }
    }
}
