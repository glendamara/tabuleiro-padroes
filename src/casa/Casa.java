package casa;

import jogador.Jogador;

public abstract class Casa {
    protected int numero;

    public Casa(int numero) {
        this.numero = numero;
    }

    public abstract void aplicarRegra(Jogador jogador);
}