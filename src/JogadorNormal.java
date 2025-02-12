public class JogadorNormal implements TipoJogador {
    @Override
    public int rolarDados() {
        return Dado.rolar() + Dado.rolar();
    }
}