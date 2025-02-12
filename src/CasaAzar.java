public class CasaAzar extends Casa {
    public CasaAzar(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        // 🔹 Verifica corretamente se o jogador tem um TipoJogador do tipo Sortudo
        if (!(jogador.getTipoJogador() instanceof JogadorSortudo)) {
            jogador.adicionarMoedas(-3);
            System.out.println(jogador.getCor() + " perdeu 3 moedas!");
        } else {
            System.out.println(jogador.getCor() + " é sortudo e não perdeu moedas!");
        }
    }
}
