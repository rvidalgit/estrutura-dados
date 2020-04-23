package listasLigadas;

public class ListaDuplamenteLigada<T> {

    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public ListaDuplamenteLigada() {
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
            novoNo.setAnterior(this.ultimoNo);
        }
        this.ultimoNo = novoNo;
        this.tamanho++;
    }

    public void inserirEm(T elemento, int posicao) throws IllegalArgumentException {
        if (posicao == 0) {
            No<T> novoNo = new No<>(elemento);
            novoNo.setProximo(this.primeiroNo);
            this.primeiroNo.setAnterior(novoNo);
            this.primeiroNo = novoNo;
        } else if (posicao == tamanho() - 1) {
            No<T> novoNo = new No<>(elemento);
            ultimoNo.setProximo(novoNo);
            novoNo.setAnterior(ultimoNo);
            this.ultimoNo = novoNo;
        } else {
            No<T> noAnterior = recuperarNo(posicao - 1);
            No<T> noAtual = recuperarNo(posicao);
            No<T> novoNo = new No<>(elemento);
            noAnterior.setProximo(novoNo);
            novoNo.setProximo(noAtual);
            noAtual.setAnterior(novoNo);
            novoNo.setAnterior(noAnterior);
        }
        this.tamanho++;
    }

    public void inserirPrimeiro(T elemento) {
        inserirEm(elemento, 0);
    }

    public void inserirUltimo(T elemento) {
        inserirEm(elemento, tamanho() - 1);
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

    public boolean contem(T elemento) {
        for (int i = 0; i < tamanho; i++) {
            No<T> noAtual = recuperarNo(i);
            if (noAtual.getElemento() != null && noAtual.getElemento().equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public int indice(T elemento) {
        for (int i = 0; i < tamanho; i++) {
            No<T> noAtual = recuperarNo(i);
            if (noAtual.getElemento() != null && noAtual.getElemento().equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public void remover(int posicao) {
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (posicao == 0) {
            No<T> proximoNo = this.primeiroNo.getProximo();
            this.primeiroNo.setProximo(null);
            proximoNo.setAnterior(null);
            this.primeiroNo = proximoNo;
        } else if (posicao == tamanho() - 1) {
            No<T> penultimoNo = this.ultimoNo.getAnterior();
            penultimoNo.setProximo(null);
            this.ultimoNo.setAnterior(null);
            this.ultimoNo = penultimoNo;
        } else {
            No<T> noAtual = recuperarNo(posicao);
            No<T> noAnterior = noAtual.getAnterior();
            No<T> noProximo = noAtual.getProximo();
            noAnterior.setProximo(noProximo);
            noProximo.setAnterior(noAnterior);
            noAtual.setProximo(null);
            noAnterior.setAnterior(null);
        }
        this.tamanho--;
    }

    public void remover(T elemento) {
        int posicao = indice(elemento);
        if (posicao == -1) {
            throw new IllegalArgumentException("Elemento inválido");
        }
        remover(posicao);
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
