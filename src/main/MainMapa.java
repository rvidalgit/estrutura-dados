package main;

import mapas.Mapa;
import model.Pessoa;

import java.util.ArrayList;

public class MainMapa {

    public static void main(String[] args) {
        fazerMapa();
    }

    private static void fazerMapa() {
        Mapa<String, Pessoa> mapa = new Mapa<String, Pessoa>();
        mapa.adicionar("pai", new Pessoa(1, "Rodrigo"));
        mapa.adicionar("mae", new Pessoa(2, "Ananda"));
        System.out.println(mapa);
        mapa.adicionar("crianca", new Pessoa(3, "Joaquim"));
        System.out.println(mapa);
        mapa.adicionar("crianca", new Pessoa(3, "Joana"));
        System.out.println(mapa);
        System.out.println(mapa.recuperar("pai"));
        mapa.remover("pai");
        System.out.println(mapa);

        System.out.println("#### Outro mapa");

        Mapa<String, ArrayList<Pessoa>> mapa2 = new Mapa<String, ArrayList<Pessoa>>();
        ArrayList<Pessoa> lista = new ArrayList<>();
        lista.add(new Pessoa(1, "Rodrigo"));
        lista.add(new Pessoa(2, "Ananda"));
        mapa2.adicionar("adulto", lista);
        mapa2.adicionar("adulto", lista);
        System.out.println(mapa2);
        mapa2.remover("chave");
    }

}
