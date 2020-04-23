package main;

import listasLigadas.ListaDuplamenteLigada;
import model.Pessoa;

public class MainListaDuplamenteLigada {

    public static void main(String[] args) {
        fazerListaDL();
    }

    private static void fazerListaDL() {
        ListaDuplamenteLigada<Pessoa> listaLigada = new ListaDuplamenteLigada<>();
        listaLigada.inserir(new Pessoa(1, "Rodrigo"));
        listaLigada.inserir(new Pessoa(2, "Ananda"));
        listaLigada.inserir(new Pessoa(3, "Joana"));
        System.out.println(listaLigada.toString());
        listaLigada.inserirEm(new Pessoa(4, "Miá"), 1);
        listaLigada.inserirPrimeiro(new Pessoa(5, "David"));
        listaLigada.inserirUltimo(new Pessoa(6, "Karol"));
        System.out.println(listaLigada.toString());
        listaLigada.remover(0);
        System.out.println(listaLigada.toString());
    }
}
