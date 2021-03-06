package lineares.fila;

import lineares.lista.ListaEncadeada;

public class FilaLista<T> implements Fila<T> {

	private ListaEncadeada<T> lista = new ListaEncadeada<>();
	
	@Override
	public void inserir(T valor) {
		lista.inserir(valor);	
	}

	@Override
	public T retirar() {
		T valor = lista.pegar(0);
		lista.retirar(lista.pegar(0));
		return valor;
	}

	@Override
	public T peek() {
		return lista.pegar(0);
	}

	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	@Override
	public void liberar() {
		lista = new ListaEncadeada<>();
	}

	@Override
	public String toString() {
		return lista.exibir();	
	}

	
}
