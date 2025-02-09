package jogador;

public class JogadorFactory {
    public static Jogador criarJogador(String tipo, String cor) {
        switch (tipo.toLowerCase()) {
            case "normal":
                return new JogadorNormal(cor);
            case "sortudo":
                return new JogadorSortudo(cor);
            case "azarado":
                return new JogadorAzarado(cor);
            default:
                throw new IllegalArgumentException("Tipo de jogador inválido.");
        }
    }
}
