
public class Main {

	public static void main(String[] args) {
		ListaEstatica lista = new ListaEstatica();
		ListaEstatica lista2 = new ListaEstatica();
		
		for(int i = 1; i <= 20; i++) {
			lista.inserir(i);
		}
		
		for(int i = 21; i <= 30; i++) {
			lista2.inserir(i);
		}
		
		lista.concatenar(lista2);
		
		System.out.println(lista.exibir());
	}

}
