
import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private boolean jogoAtivo;
    private Scanner scanner;

    public Jogo() {
        this.tabuleiro = Tabuleiro.getInstancia();
        this.jogoAtivo = true;
        this.scanner = new Scanner(System.in);
    }

public void configTabuleiro(int numCasas) {
    for (int i = 0; i < numCasas; i++) {
        System.out.println("Escolha o tipo da casa " + i + ":");
        System.out.println("1 - Simples");
        System.out.println("2 - Surpresa");
        System.out.println("3 - Prisão");
        System.out.println("4 - Sorte");
        System.out.println("5 - Azar");
        System.out.println("6 - Reversa");
        System.out.println("7 - Joga de Novo");
        System.out.println("8 - Troca");

        int escolha = scanner.nextInt();
        String tipo;

        switch (escolha) {
            case 1:
                tipo = "simples";
                break;
            case 2:
                tipo = "surpresa";
                break;
            case 3:
                tipo = "prisao";
                break;
            case 4:
                tipo = "sorte";
                break;
            case 5:
                tipo = "azar";
                break;
            case 6:
                tipo = "reversa";
                break;
            case 7:
                tipo = "joga_de_novo";
                break;
            case 8:
                tipo = "troca";
                break;
            default:
                System.out.println("Opção inválida! Criando casa Simples por padrão.");
                tipo = "simples";
        }

        tabuleiro.adicionarCasa(CasaFactory.criarCasa(tipo, i));
    }
}

    public void config(int numJogadores) {
        for (int i = 0; i < numJogadores; i++) {
            System.out.println("Digite a cor do jogador " + (i + 1) + ":");
            String cor = scanner.next();
            System.out.println("Digite o tipo (normal, sortudo, azarado):");
            String tipo = scanner.next();
            tabuleiro.adicionarJogador(JogadorFactory.criarJogador(tipo, cor));
        }
    }

public void start() {
    System.out.println("Jogo iniciado!");
    
    while (jogoAtivo) { 
        for (Jogador jogador : tabuleiro.getJogadores()) {
            if (!jogoAtivo) break;

            // Verifica se o jogador está preso
            if (jogador.isPreso()) {
                System.out.println(jogador.getCor() + " está preso e não pode jogar nesta rodada.");
                jogador.incrementarRodadasPreso();
                if (jogador.getRodadasPreso() >= 2) {
                    jogador.liberar();
                    System.out.println(jogador.getCor() + " foi liberado da prisão!");
                }
                continue;
            }

            System.out.println("\nVez do jogador: " + jogador.getCor());
            int dado = jogador.rolarDados();
            System.out.println("Jogador " + jogador.getCor() + " tirou " + dado);
            
            // 🔹 Calculando nova posição corretamente
            int novaPosicao = jogador.getPosicao() + dado;

            // 🔹 Verificando se a posição ultrapassa os limites do tabuleiro
            if (novaPosicao >= tabuleiro.getCasas().size()) {
                System.out.println(jogador.getCor() + " venceu o jogo!");
                jogoAtivo = false;
                break;
            }

            jogador.setPosicao(novaPosicao);
            System.out.println(jogador.getCor() + " está na casa " + novaPosicao);

            Casa casaAtual = tabuleiro.getCasas().get(novaPosicao);
            casaAtual.aplicarRegra(jogador);
        }
    }
    
    System.out.println("Jogo encerrado.");
}



    public void startDebug() {
        System.out.println("Modo Debug iniciado!");
        while (jogoAtivo) {
            for (Jogador jogador : tabuleiro.getJogadores()) {
                if (!jogoAtivo) break;

                // Verifica se o jogador está preso
                if (jogador.isPreso()) {
                    System.out.println(jogador.getCor() + " está preso e não pode jogar nesta rodada.");
                    jogador.incrementarRodadasPreso(); // Incrementa o contador de rodadas
                    if (jogador.getRodadasPreso() >= 2) {
                        jogador.liberar(); // Libera o jogador após 2 rodadas
                        System.out.println(jogador.getCor() + " foi liberado da prisão!");
                    }
                    continue; // Pula para o próximo jogador
                }

                System.out.println("\nVez do jogador: " + jogador.getCor());
                System.out.println("Digite o número da casa para onde deseja ir:");
                int casaEscolhida = scanner.nextInt();
                jogador.setPosicao(casaEscolhida);
                System.out.println(jogador.getCor() + " está na casa " + jogador.getPosicao());

                // Aplicar regra da casa
                Casa casaAtual = tabuleiro.getCasas().get(jogador.getPosicao());
                casaAtual.aplicarRegra(jogador);

                // Verificar se o jogador venceu
                if (jogador.getPosicao() >= tabuleiro.getCasas().size() - 1) {
                    System.out.println(jogador.getCor() + " venceu o jogo!");
                    jogoAtivo = false;
                    break;
                }
            }
        }
        System.out.println("Jogo encerrado.");
    }
}