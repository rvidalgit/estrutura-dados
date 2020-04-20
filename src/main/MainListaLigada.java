package main;

import listasLigadas.ListaLigada;
import model.Pessoa;

import java.util.LinkedList;

public class MainListaLigada {

    public static void main(String[] args) {
        fazerListaLigada();
    }

    public static void fazerListaLigada() {
        ListaLigada<Pessoa> listaLigada = new ListaLigada<>();
        listaLigada.inserir(new Pessoa(1, "Rodrigo"));
        listaLigada.inserir(new Pessoa(2, "Ananda"));
        listaLigada.inserir(new Pessoa(3, "Joana"));
        listaLigada.inserirEm(new Pessoa(4, "Miá"), 1);
        listaLigada.inserirPrimeiro(new Pessoa(5, "David"));
        listaLigada.inserirUltimo(new Pessoa(6, "Karol"));
        System.out.println(listaLigada.toString());

        LinkedList<Pessoa> pessoas = new LinkedList<>();
    }
}
