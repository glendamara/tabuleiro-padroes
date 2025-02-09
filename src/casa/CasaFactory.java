package factory;

import casa.Casa;
import casa.CasaSimples;
import casa.CasaSurpresa;
import casa.CasaPrisao;
import casa.CasaSorte;
import casa.CasaAzar;
import casa.CasaReversa;
import casa.CasaJogaDeNovo;
import casa.CasaTroca;

public class CasaFactory {
    public static Casa criarCasa(String tipo, int numero) {
        switch (tipo.toLowerCase()) {
            case "simples":
                return new CasaSimples(numero);
            case "surpresa":
                return new CasaSurpresa(numero);
            case "prisao":
                return new CasaPrisao(numero);
            case "sorte":
                return new CasaSorte(numero);
            case "azar":
                return new CasaAzar(numero);
            case "reversa":
                return new CasaReversa(numero);
            case "joga_de_novo":
                return new CasaJogaDeNovo(numero);
            case "troca":
                return new CasaTroca(numero);
            default:
                throw new IllegalArgumentException("Tipo de casa inválido.");
        }
    }
}