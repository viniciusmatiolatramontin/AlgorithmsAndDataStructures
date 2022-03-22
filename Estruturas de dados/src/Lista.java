
public interface Lista {

	void inserir(int valor);

	int buscar(int valor);

	void retirar(int valor);

	String exibir();

	boolean estaVazia();

	void concatenar(Lista outra);

	Lista dividir();

	Lista copiar();

	int getTamanho();

	int pegar(int pos);

}