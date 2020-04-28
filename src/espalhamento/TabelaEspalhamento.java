package espalhamento;

import listasLigadas.ListaLigada;

public class TabelaEspalhamento<T> {

    private ListaLigada<ListaLigada<T>> elementos;
    private int numeroDeCategorias = 16;
    private int tamanho;

    public TabelaEspalhamento() {
        this.elementos = new ListaLigada<ListaLigada<T>>();
        for (int i = 0; i < numeroDeCategorias; i++) {
            elementos.inserir(new ListaLigada<T>());
        }
        this.tamanho = 0;
    }

    public boolean inserir(T elemento) {

        if (elemento == null || this.contem(elemento)) {
            return false;
        }

        int categoria = gerarNumEspalhamento(elemento);
        //this.elementos.recuperar(categoria).inserir(elemento);
        ListaLigada<T> listaCategoria = this.elementos.recuperar(categoria);

        listaCategoria.inserir(elemento);
        this.tamanho++;
        return true;
    }

    public void remover(T elemento) {
        int numEspalhamento = gerarNumEspalhamento(elemento);
        ListaLigada<T> listaCategoria = this.elementos.recuperar(numEspalhamento);
        listaCategoria.remover(elemento);
        this.tamanho--;
    }

    public boolean contem(T elemento) {
        int numEspalhamento = gerarNumEspalhamento(elemento);
        ListaLigada<T> listaCategoria = this.elementos.recuperar(numEspalhamento);
        return listaCategoria.contem(elemento);
    }

    public int tamanho() {
        /* For dentro de for é terrivel, pois tem uma complexidade quadrática (i^x).
        Então, vamos adicionar uma variável tamanho.
        int sum = 0;
        for(i){
            for(x){

            }
        }*/
        return tamanho;
    }

    private int gerarNumEspalhamento(T elemento) {
        int hash = elemento.hashCode();
        return hash % numeroDeCategorias; //retorna um inteiro entre 0 e numeroDeCategorias
    }

    @Override
    public String toString() {
        return "TabelaEspalhamento{" + elementos.toString() + '}';
    }
}
