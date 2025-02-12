public class CasaSorte extends Casa {
    public CasaSorte(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        // 🔹 Verifica corretamente se o jogador está com comportamento de Azarado
        if (!(jogador.getTipoJogador() instanceof JogadorAzarado)) {
            jogador.adicionarMoedas(3);
            System.out.println(jogador.getCor() + " ganhou 3 moedas!");
        } else {
            System.out.println(jogador.getCor() + " é azarado e não recebeu moedas!");
        }
    }
}
