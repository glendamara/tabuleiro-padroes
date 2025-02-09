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
            jogador.adicionarMoedas(3);
            System.out.println(jogador.getCor() + " ganhou 3 moedas!");
        }
    }
}
