package tabuleiro;

public class CasaFactory {
    public static Casa criarCasa(String tipo, int numero) {
        switch (tipo.toLowerCase()) {
            case "simples":
                return new CasaSimples(numero);
            case "sorte":
                return new CasaSorte(numero);
            case "prisao":
                return new CasaPrisao(numero);
            default:
                throw new IllegalArgumentException("Tipo de casa inválido.");
        }
    }
}
