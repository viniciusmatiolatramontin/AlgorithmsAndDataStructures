package lineares.pilha;
public interface Pilha<T> {
    void empilhar(T valor);

    T desempilhar();

    T pegar();

    boolean estaVazia();

    void liberar();
}
