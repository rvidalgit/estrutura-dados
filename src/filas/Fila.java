package filas;

import listasLigadas.ListaLigada;

public class Fila<T> {

    private ListaLigada<T> elementos;

    public Fila() {
        this.elementos = new ListaLigada<>();
    }

    public void enfileirar(T elemento) {
        this.elementos.inserir(elemento);
    }

    public T desenfileirar() {
        if (isEmpty()) {
            return null;
        }

        T resultado = this.elementos.recuperar(0);
        this.elementos.remover(0);
        return resultado;
    }

    public boolean isEmpty() {
        return this.elementos.isEmpty();
    }

    @Override
    public String toString() {
        return "Fila{" + elementos.toString() + '}';
    }
}
