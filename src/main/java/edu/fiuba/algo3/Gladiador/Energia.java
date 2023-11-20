package edu.fiuba.algo3.Gladiador;

public class Energia {
    private int valor;

    public Energia(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void aumentarEnergia(Energia energia){
        valor += energia.getValor();
    }

    public void disminuirEnergia(Energia energia){
        valor -= energia.getValor();
    }
}
