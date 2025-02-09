package casa;

import jogador.Jogador;

public class CasaJogaDeNovo extends Casa {
    public CasaJogaDeNovo(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        int novaJogada = jogador.rolarDados();
        jogador.adicionarMoedas(novaJogada);
        System.out.println(jogador.getCor() + " jogou novamente e ganhou " + novaJogada + " moedas!");
    }
}
