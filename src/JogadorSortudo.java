public class JogadorSortudo implements TipoJogador {
    @Override
    public int rolarDados() {
        int soma;
        do {
            soma = Dado.rolar() + Dado.rolar();
        } while (soma < 7);
        return soma;
    }
}