package main;

import filas.Fila;
import model.Pessoa;

public class MainFila {

    public static void main(String[] args) {
        fazerFila();
    }

    private static void fazerFila() {

        Fila<Pessoa> fila = new Fila<>();
        fila.enfileirar(new Pessoa(1, "Rodrigo"));
        fila.enfileirar(new Pessoa(2, "Ananda"));
        System.out.println(fila);
        fila.enfileirar(new Pessoa(3, "Joana"));
        System.out.println(fila);
        fila.desenfileirar();
        System.out.println(fila);
    }
}
