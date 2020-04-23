package pilhas;

import listasLigadas.ListaDuplamenteLigada;

public class Pilha<T> {

    ListaDuplamenteLigada<T> elementos;

    public Pilha() {
        this.elementos = new ListaDuplamenteLigada<>();
    }

    public boolean isEmpty() {
        return this.elementos.isEmpty();
    }

    public void empilhar(T elemento) {
        this.elementos.inserir(elemento);
    }

    public T retirar() {
        if (isEmpty()) {
            return null;
        }

        T resultado = this.elementos.recuperar(this.elementos.tamanho() - 1);
        this.elementos.remover(this.elementos.tamanho() - 1);
        return resultado;
    }

    @Override
    public String toString() {
        return "Pilha{" + elementos + '}';
    }
}
