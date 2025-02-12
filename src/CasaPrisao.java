
public class CasaPrisao extends Casa {
    public CasaPrisao(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        // Verifica se o jogador já está preso
        if (jogador.isPreso()) {
            System.out.println(jogador.getCor() + " está preso e não pode jogar nesta rodada.");
            jogador.incrementarRodadasPreso(); // Incrementa o contador de rodadas
            if (jogador.getRodadasPreso() >= 2) {
                jogador.liberar(); // Libera o jogador após 2 rodadas
                System.out.println(jogador.getCor() + " foi liberado da prisão!");
            }
        } else {
            // O jogador cai na casa e é preso
            System.out.println(jogador.getCor() + " caiu na Casa de Prisão e foi preso!");
            jogador.prender(); // Marca o jogador como preso
        }
    }
}