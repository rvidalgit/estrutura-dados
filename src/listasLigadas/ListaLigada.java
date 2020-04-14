package listasLigadas;

public class ListaLigada<T> {

    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public ListaLigada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }

    public void inserir(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (isEmpty()) {
            this.primeiroNo = novoNo;
        } else {
            this.ultimoNo.setProximo(novoNo);
        }
        this.ultimoNo = novoNo;
        this.tamanho++;
    }

    public void inserirEm(T elemento, int posicao) throws IllegalArgumentException {
        if (posicao == 0) {
            No<T> novoNo = new No<>(elemento);
            novoNo.setProximo(this.primeiroNo);
            this.primeiroNo = novoNo;
        } else if (posicao == tamanho() - 1) {
            No<T> novoNo = new No<>(elemento);
            ultimoNo.setProximo(novoNo);
            this.ultimoNo = novoNo;
        } else {
            No<T> noAnterior = recuperarNo(posicao - 1);
            No<T> noAtual = recuperarNo(posicao);
            No<T> novoNo = new No<>(elemento);
            noAnterior.setProximo(novoNo);
            novoNo.setProximo(noAtual);
        }
        this.tamanho++;
    }

    public T recuperar(int posicao) {
        No<T> resultado = recuperarNo(posicao);
        return resultado.getElemento();
    }

    private No<T> recuperarNo(int posicao) throws IllegalArgumentException {
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("Posição inválida %d", posicao));
        }

        No<T> resultado = null;
        for (int i = 0; i <= posicao; i++) {
            if (i == 0) {
                resultado = this.primeiroNo;
            } else {
                resultado = resultado.getProximo();
            }
        }
        return resultado;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "ListaLigada{}";
        } else {
            No<T> noAtual = this.primeiroNo;
            StringBuilder sb = new StringBuilder();
            sb.append("Lista [");
            sb.append(noAtual.getElemento() != null ? noAtual.getElemento().toString() : "<NULL>");
            while (noAtual.getProximo() != null) {
                sb.append(", ");
                sb.append(noAtual.getProximo().getElemento() != null ? noAtual.getProximo().getElemento().toString() : "<NULL>");
                noAtual = noAtual.getProximo();
            }
            sb.append("]");
            return sb.toString();
        }
    }

}
