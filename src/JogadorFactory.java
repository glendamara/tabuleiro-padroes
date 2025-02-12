public class JogadorFactory {
    public static Jogador criarJogador(String tipo, String cor) {
        TipoJogador tipoJogador;

        switch (tipo.toLowerCase()) {
            case "normal":
                tipoJogador = new JogadorNormal();
                break;
            case "sortudo":
                tipoJogador = new JogadorSortudo();
                break;
            case "azarado":
                tipoJogador = new JogadorAzarado();
                break;
            default:
                throw new IllegalArgumentException("Tipo de jogador inválido.");
        }

        // Criar um jogador com o tipo correto
        return new Jogador(cor, tipoJogador) {};
    }
}
