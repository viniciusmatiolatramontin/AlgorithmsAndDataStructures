package arvores;

public class Arvore<T extends Comparable<T>> {
	
	private NoArvore<T> raiz;
	
	public void setRaiz(NoArvore<T> raiz) {
		this.raiz = raiz;
	}
	
	public NoArvore<T> pertence(T info) {
		return raiz.pertence(info);
	}
	
	public boolean vazia() {
		if(this.raiz == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return raiz.imprimePre();
	}
	
	public int getAltura() {
		if(this.vazia()) {
			return -1;
		}
		
		return this.raiz.contaAltura() - 1;
	}
}
