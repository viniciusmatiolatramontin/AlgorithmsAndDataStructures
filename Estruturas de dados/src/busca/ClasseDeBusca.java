package busca;

public class ClasseDeBusca<T> {
	public static <T extends Comparable<T>> int buscaBinaria(T[] vetor, T valorBuscar) {
		int n = vetor.length;
		int inicio = 0;
		int fim = n-1;
		while(inicio <= fim) {
			int meio = (fim+inicio)/2;
			if(valorBuscar.compareTo(vetor[meio]) < 0) {
				fim = meio-1;
			} else {
				if(valorBuscar.compareTo(vetor[meio]) > 0) {
					inicio = meio+1;
				} else {
					return meio;
				}
			}
		}
		
		return -1;
	}
}
