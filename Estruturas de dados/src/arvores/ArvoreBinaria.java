package arvores;

public class ArvoreBinaria<T> {
	
	private NoArvoreBinaria<T> raiz;
	
	public ArvoreBinaria() {
		
	}
	
	public void setRaiz(NoArvoreBinaria<T> no) {
		this.raiz = no;
	}
	
	public boolean vazia() {
		if(raiz == null) {
			return true;
		}
		
		return false;
	}
	
	public NoArvoreBinaria<T> pertence(T info) {
		if(this.vazia()) {
			return null;
		}
		return raiz.pertence(info);
	}
	
	@Override
	public String toString() {
		return raiz.imprimePre();
	}
}
