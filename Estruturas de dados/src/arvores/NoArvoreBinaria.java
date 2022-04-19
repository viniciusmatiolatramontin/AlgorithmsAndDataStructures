package arvores;

public class NoArvoreBinaria<T> {
	private T info;
	private NoArvoreBinaria<T> dir;
	private NoArvoreBinaria<T> esq;
	
	public NoArvoreBinaria(T info) {
		this.info = info;
	}
	
	public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
		this.info = info;
		this.dir = dir;
		this.esq = esq;
	}
	
	public NoArvoreBinaria<T> pertence(T info) {
		NoArvoreBinaria<T> result = null;
		
		if(this.getInfo().equals(info)) {
			return this;
		} else {
			if(esq != null) {
				result = esq.pertence(info);
			}
			
			if(result == null && dir != null) {
				result = dir.pertence(info);
			}
			
			return result;
		}
	}
	
	public T getInfo() {
		return this.info;
	}
	
	public String imprimePre() {
		String result = "(" + this.getInfo().toString();
		
		if(esq != null) {
			result += esq.imprimePre();
		}
		
		if(dir != null) {
			result += dir.imprimePre();
		}
		
		return result + ")";
	}
}