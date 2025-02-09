package casa;

import jogador.Jogador;
import jogador.JogadorAzarado;

public class CasaSorte extends Casa {
    public CasaSorte(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        if (!(jogador instanceof JogadorAzarado)) {
            jogador.avancar(3);
            jogador.adicionarMoedas(3);
        }
    }
}
