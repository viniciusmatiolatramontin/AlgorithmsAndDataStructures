
public class Main {

	public static void main(String[] args) {
		Lista lista = new ListaEstatica();
		
		for(int i = 1; i <= 20; i++) {
			lista.inserir(i);
		}
		
		System.out.println(lista.dividir().exibir() + " // " + lista.exibir() + " // " + lista.copiar().exibir());
	}

}
