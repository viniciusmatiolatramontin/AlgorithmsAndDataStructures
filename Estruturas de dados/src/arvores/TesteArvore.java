package arvores;

public class TesteArvore {

	public static void main(String[] args) {
		NoArvore<Integer> n1 = new NoArvore<>(1);
		NoArvore<Integer> n2 = new NoArvore<>(2);
		NoArvore<Integer> n3 = new NoArvore<>(3);
		NoArvore<Integer> n4 = new NoArvore<>(4);
		NoArvore<Integer> n5 = new NoArvore<>(5);
		NoArvore<Integer> n6 = new NoArvore<>(6);
		NoArvore<Integer> n7 = new NoArvore<>(7);
		NoArvore<Integer> n8 = new NoArvore<>(8);
		NoArvore<Integer> n9 = new NoArvore<>(9);
		NoArvore<Integer> n10 = new NoArvore<>(10);
		n9.inserirFilho(n10);
		n7.inserirFilho(n9);
		n7.inserirFilho(n8);
		n3.inserirFilho(n4);
		n2.inserirFilho(n3);
		n2.inserirFilho(n5);
		n1.inserirFilho(n2);
		n1.inserirFilho(n6);
		n1.inserirFilho(n7);
		Arvore<Integer> a = new Arvore<>();
		a.setRaiz(n1);	
		
		System.out.println(a.toString());
		System.out.println(a.pertence(3));
		System.out.println(a.getAltura());
	}

}
