package lineares.pilha;
@SuppressWarnings("unchecked")
public class PilhaVetor<T> implements Pilha<T> {

    private int limite;
    private int tamanho = 0;
    private T[] info;

    public PilhaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
    }

    @Override
    public void empilhar(T valor) {
        if (this.tamanho == this.limite) {
            throw new RuntimeException("A lista está cheia!");
        }
        this.info[tamanho] = valor;
        this.tamanho += 1;
    }

    @Override
    public T desempilhar() {
        if (!estaVazia()) {
            T elemento = pegar();
            this.info[tamanho - 1] = null;
            this.tamanho -= 1;
            return elemento;
        }
        throw new RuntimeException("A lista está vazia!");
    }

    @Override
    public T pegar() {
        if (estaVazia()) {
            throw new RuntimeException("A lista está vazia!");
        }
        return this.info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            desempilhar();
        }
    }

    @Override
    public String toString() {
        String elementos = "";

        for (int i = this.tamanho - 1; i >= 0; i--) {
            elementos += this.info[i] + ", ";
        }
        elementos = elementos.substring(0, Math.max(0, elementos.length() - 2));
        return "[" + elementos + "]";
    }
}
