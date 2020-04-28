package conjuntos;

import espalhamento.TabelaEspalhamento;

//utilizando o conjunto com a tabela de empalhamento
public class ConjuntoMelhorado<T> {

    private TabelaEspalhamento<T> elementos;

    public ConjuntoMelhorado() {
        elementos = new TabelaEspalhamento<>();
    }

    public boolean inseir(T elemento) {
        return this.elementos.inserir(elemento);
    }

    public boolean isEmpty() {
        return this.elementos.tamanho() == 0;
    }

    public int tamanho() {
        return this.elementos.tamanho();
    }

    public boolean contem(T elemento) {
        return this.elementos.contem(elemento);
    }

    public void remover(T elemento) {
        this.elementos.remover(elemento);
    }

    @Override
    public String toString() {
        return "Conjunto{" + elementos + '}';
    }

}
