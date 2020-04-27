package conjuntos;

import listasLigadas.ListaLigada;

public class Conjunto<T> {

    private ListaLigada<T> elementos;

    public Conjunto() {
        elementos = new ListaLigada<>();
    }

    public boolean inseir(T elemento) {
        //if (elemento != null && !contem(elemento)) {
        if (elemento != null && !contemOtimizado(elemento)) {
            this.elementos.inserir(elemento);
            return true;
        }
        return false;
    }

    public boolean inserirEm(int posicao, T elemento) {
        //if (elemento != null && !contem(elemento)) {
        if (elemento != null && !contemOtimizado(elemento)) {
            this.elementos.inserirEm(elemento, posicao);
            return true;
        }
        return false;

    }

    public T recuperar(int posicao) {
        return this.elementos.recuperar(posicao);
    }

    public boolean isEmpty() {
        return this.elementos.isEmpty();
    }

    public int tamanho() {
        return this.elementos.tamanho();
    }

    public boolean contem(T elemento) {
        return this.elementos.contem(elemento);
    }

    public int indice(T elemento) {
        return this.elementos.indice(elemento);
    }

    public void remover(T elemento) {
        this.elementos.remover(elemento);
    }

    public void remover(int posicao) {
        this.elementos.remover(posicao);
    }

    @Override
    public String toString() {
        return "Conjunto{" + elementos + '}';
    }

    private boolean contemOtimizado(T elemento) {
        for (int i = 0; this.elementos.tamanho() > i; i++) {
            T result = this.elementos.recuperar(i);
            if (result.hashCode() == elemento.hashCode()) {
                return true;
            }
        }
        return false;
    }

}
