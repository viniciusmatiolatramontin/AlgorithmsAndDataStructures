import busca.ClasseDeBusca;

public class Main {
	public static void main(String[] args) {
		Integer[] arr = new Integer[20];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		
		System.out.println(ClasseDeBusca.buscaBinaria(arr, 10));
	}
}
