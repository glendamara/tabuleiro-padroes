import java.util.Random;

public class CasaSurpresa extends Casa {
    private static final Random random = new Random();

    public CasaSurpresa(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        int sorteio = random.nextInt(3); // 0, 1 ou 2

        switch (sorteio) {
            case 0:
                jogador.setTipo(new JogadorNormal());
                System.out.println(jogador.getCor() + " agora é um Jogador Normal!");
                break;
            case 1:
                jogador.setTipo(new JogadorSortudo());
                System.out.println(jogador.getCor() + " agora é um Jogador Sortudo!");
                break;
            case 2:
                jogador.setTipo(new JogadorAzarado());
                System.out.println(jogador.getCor() + " agora é um Jogador Azarado!");
                break;
        }
    }
}
