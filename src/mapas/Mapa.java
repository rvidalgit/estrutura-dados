package mapas;

import listasLigadas.ListaLigada;

public class Mapa<K, V> {

    private ListaLigada<ListaLigada<Associacao<K, V>>> elementos;
    private int quantidadeCategorias = 16;

    public Mapa() {
        this.elementos = new ListaLigada<ListaLigada<Associacao<K, V>>>();
        for (int i = 0; i < this.quantidadeCategorias; i++) {
            this.elementos.inserir(new ListaLigada<Associacao<K, V>>());
        }
    }

    public boolean contemChave(K chave) {
        int numEspalhamento = this.gerarNumeroEspalhamento(chave);
        ListaLigada<Associacao<K, V>> categoria = this.elementos.recuperar(numEspalhamento);
        for (int i = 0; i < categoria.tamanho(); i++) {
            Associacao<K, V> associacao = categoria.recuperar(i);
            if (associacao.getChave().equals(chave)) {
                return true;
            }
        }
        return false;
    }

    public void remover(K chave) {
        int numeroEspalhamento = gerarNumeroEspalhamento(chave);
        ListaLigada<Associacao<K, V>> categoria = this.elementos.recuperar(numeroEspalhamento);
        for (int i = 0; i < categoria.tamanho(); i++) {
            Associacao<K, V> associacao = categoria.recuperar(i);
            if (associacao.getChave().equals(chave)) {
                categoria.remover(i);
                return;
            }
        }
        throw new IllegalArgumentException("Chave não encontrada");
    }

    public void adicionar(K chave, V valor) {
        if (contemChave(chave)) {
            remover(chave);
        }

        int numEspalhamento = gerarNumeroEspalhamento(chave);
        ListaLigada<Associacao<K, V>> categoria = this.elementos.recuperar(numEspalhamento);
        categoria.inserir(new Associacao<>(chave, valor));
    }

    public V recuperar(K chave) {
        int numEspalhamento = gerarNumeroEspalhamento(chave);
        ListaLigada<Associacao<K, V>> categoria = this.elementos.recuperar(numEspalhamento);

        for (int i = 0; i < categoria.tamanho(); i++) {
            Associacao<K, V> associacao = categoria.recuperar(i);
            if (associacao.getChave().equals(chave)) {
                return associacao.getValor();
            }
        }
        throw new IllegalArgumentException("Chave não existe");
    }

    private int gerarNumeroEspalhamento(K chave) {
        return Math.abs(chave.hashCode() % quantidadeCategorias);
    }

    @Override
    public String toString() {
        return "Mapa{" +
                "elementos=" + elementos +
                '}';
    }
}
