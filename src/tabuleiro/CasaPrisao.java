package casa;

import jogador.Jogador;

public class CasaPrisao extends Casa {
    public CasaPrisao(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        jogador.prender();
    }
}
