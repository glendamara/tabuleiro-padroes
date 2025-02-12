

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogo jogo = new Jogo();

        System.out.print("Digite o número de casas: ");
        int numCasas = scanner.nextInt();

        System.out.print("Digite o número de jogadores: ");
        int numJogadores = scanner.nextInt();

        jogo.configTabuleiro(numCasas);
        jogo.config(numJogadores);

        System.out.print("Deseja jogar no modo Debug? (s/n): ");
        char modoDebug = scanner.next().charAt(0); // Corrigido para usar next() e pegar o primeiro caractere

        if (modoDebug == 's' || modoDebug == 'S') {
            jogo.startDebug(); // Inicia o jogo no modo Debug
        } else {
            jogo.start(); // Inicia o jogo normalmente
        }

        scanner.close(); // Fechar o scanner
    }
}