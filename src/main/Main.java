package main;
import jogo.Jogo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogo jogo = new Jogo();
        jogo.iniciar();

        System.out.print("Digite o número de casas: ");
        int numCasas = scanner.nextInt();

        System.out.print("Digite o número de jogadores: ");
        int numJogadores = scanner.nextInt();

        jogo.configTabuleiro(numCasas);
        jogo.config(numJogadores);
        jogo.printTabuleiro();
        jogo.start();
    }
}