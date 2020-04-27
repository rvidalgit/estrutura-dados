package main;

import conjuntos.Conjunto;
import model.Pessoa;

public class MainConjunto {

    public static void main(String[] args) {
        fazerConjunto();
    }

    private static void fazerConjunto() {
        Conjunto<Pessoa> conjunto = new Conjunto<>();
        conjunto.inseir(new Pessoa(1, "Rodrigo"));
        conjunto.inseir(new Pessoa(2, "Ananda"));
        System.out.println(conjunto);
        conjunto.inseir(new Pessoa(3, "Joana"));
        System.out.println(conjunto.inseir(new Pessoa(3, "Joana")));
        System.out.println(conjunto);
        conjunto.remover(0);
        System.out.println(conjunto);
    }
}
