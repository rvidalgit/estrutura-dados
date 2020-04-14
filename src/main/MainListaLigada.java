package main;

import listasLigadas.ListaLigada;
import model.Pessoa;

public class MainListaLigada {

    public static void main(String[] args) {
        fazerListaLigada();
    }

    public static void fazerListaLigada() {
        ListaLigada<Pessoa> listaLigada = new ListaLigada<>();
        listaLigada.inserir(new Pessoa(1, "Rodrigo"));
        listaLigada.inserir(new Pessoa(2, "Ananda"));
        System.out.println(listaLigada.toString());
    }
}
