import java.util.Scanner;

public class CasaTroca extends Casa {
    private static final Scanner scanner = new Scanner(System.in);

    public CasaTroca(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        System.out.println(jogador.getCor() + " caiu na Casa de Troca! Escolha um item para equipar:");
        System.out.println("1 - Boné (+3 moedas, +1 casa por rodada)");
        System.out.println("2 - Moletom (+4 moedas, +2 casas por rodada)");
        System.out.println("3 - Óculos Escuro (+5 moedas, +3 casas por rodada)");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                jogador.adicionarMoedas(3);
                jogador.setBonusMovimento(1);
                System.out.println(jogador.getCor() + " equipou um Boné!");
                break;
            case 2:
                jogador.adicionarMoedas(4);
                jogador.setBonusMovimento(2);
                System.out.println(jogador.getCor() + " equipou um Moletom!");
                break;
            case 3:
                jogador.adicionarMoedas(5);
                jogador.setBonusMovimento(3);
                System.out.println(jogador.getCor() + " equipou um Óculos Escuro!");
                break;
            default:
                System.out.println("Opção inválida! Nenhum item foi equipado.");
        }

        System.out.println(jogador.getCor() + " agora tem " + jogador.getMoedas() + " moedas e um bônus de +" +
                jogador.getBonusMovimento() + " casas por rodada.");
    }
}
