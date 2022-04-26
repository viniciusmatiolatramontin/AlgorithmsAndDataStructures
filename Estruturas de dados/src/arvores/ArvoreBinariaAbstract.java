package arvores;

public abstract class ArvoreBinariaAbstract<T> {
	
	private NoArvoreBinaria<T> raiz;
	
	public ArvoreBinariaAbstract() {
		
	}
	
	protected void setRaiz(NoArvoreBinaria<T> no) {
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
	
	protected NoArvoreBinaria<T> getRaiz(){
		return this.raiz;
	}
}
