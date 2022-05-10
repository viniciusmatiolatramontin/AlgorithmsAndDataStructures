package arvores;

public class TesteArvore {

	public static void main(String[] args) {
		NoArvoreBinariaBST<Integer> no5 = new NoArvoreBinariaBST<>(7);
		NoArvoreBinariaBST<Integer> no4 = new NoArvoreBinariaBST<>(6);
		
		NoArvoreBinariaBST<Integer> no3 = new NoArvoreBinariaBST<>(3);
	
		NoArvoreBinariaBST<Integer> no2 = new NoArvoreBinariaBST<>(4);
		NoArvoreBinariaBST<Integer> no1 = new NoArvoreBinariaBST<>(5);
		
		no1.setEsq(no2);
		no1.setDir(no4);
		no4.setDir(no5);
		no2.setEsq(no3);
		
		ArvoreBinariaBST<Integer> arvore = new ArvoreBinariaBST<>();
		arvore.setRaiz(no1);
		
		System.out.println(arvore.toString());
		arvore.retirar(5);
		System.out.println(arvore.toString());
	}

}
