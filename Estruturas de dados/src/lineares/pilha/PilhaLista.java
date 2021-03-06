package lineares.pilha;
import lineares.lista.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista = new ListaEncadeada<T>();

    @Override
    public void empilhar(T valor) {
        this.lista.inserir(valor);
    }

    @Override
    public T desempilhar() {
        T elemento = null;
        if (!this.lista.estaVazia()) {
            elemento = this.lista.pegar(this.lista.getTamanho() - 1);
            this.lista.retirar(elemento);
        }
        return elemento;
    }

    @Override
    public T pegar() {
        if (this.lista.estaVazia()) {
            return null;
        }
        return this.lista.pegar(this.lista.getTamanho() - 1);
    }

    @Override
    public boolean estaVazia() {
        return this.lista.estaVazia();
    }

    @Override
    public void liberar() {
        while (!this.lista.estaVazia()) {
            desempilhar();
        }
    }

    @Override
    public String toString() {
        String elementos = "";

        for (int i = this.lista.getTamanho() - 1; i >= 0; i--) {
            elementos += this.lista.pegar(i) + ", ";
        }
        elementos = elementos.substring(0, Math.max(0, elementos.length() - 2));
        return "[" + elementos + "]";
    }
}
