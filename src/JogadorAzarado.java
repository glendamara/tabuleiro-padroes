public class JogadorAzarado implements TipoJogador {
    @Override
    public int rolarDados() {
        int soma;
        do {
            soma = Dado.rolar() + Dado.rolar();
        } while (soma > 6);
        return soma;
    }
}
