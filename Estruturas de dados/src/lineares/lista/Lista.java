package lineares.lista;

public interface Lista<T> {

	void inserir(T valor);

	int buscar(T valor);

	void retirar(T valor);

	String exibir();

	boolean estaVazia();

	void concatenar(Lista<T> outra);

	Lista<T> dividir();

	Lista<T> copiar();

	int getTamanho();

	T pegar(int pos);

}