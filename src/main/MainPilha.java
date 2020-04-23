package main;

import model.Pessoa;
import pilhas.Pilha;

public class MainPilha {

    public static void main(String[] args) {
        fazerPilha();
    }

    private static void fazerPilha() {
        Pilha<Pessoa> pilha = new Pilha<>();
        pilha.empilhar(new Pessoa(1, "Rodrigo"));
        pilha.empilhar(new Pessoa(2, "Ananda"));
        System.out.println(pilha.toString());
        pilha.empilhar(new Pessoa(3, "Joana"));
        System.out.println(pilha.toString());
        System.out.println(pilha.retirar());
        System.out.println(pilha.toString());
    }
}
