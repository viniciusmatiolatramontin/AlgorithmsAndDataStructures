package arvores;

public class NoArvoreBinariaBST<T extends Comparable<T>> extends NoArvoreBinaria<T>{

	public NoArvoreBinariaBST(T info) {
		super(info);
	}

	public void inserir(T info) {
		if(info.compareTo(this.getInfo()) < 0) {
			if(this.getEsq() == null) {
				this.setEsq(new NoArvoreBinaria<T>(info));;
			} else {
				((NoArvoreBinariaBST<T>)this.getEsq()).inserir(info);
			}
		} else {
			if(this.getDir() == null) {
				this.setDir(new NoArvoreBinaria<T>(info));;
			} else {
				((NoArvoreBinariaBST<T>)this.getDir()).inserir(info);
			}
		}
	}
	
	
	public NoArvoreBinariaBST<T> buscar(T info) {
		if(info.equals(this.getInfo())) {
			return this;
		} else {
			if(info.compareTo(this.getInfo()) < 0) {
				return ((NoArvoreBinariaBST<T>)this.getEsq()).buscar(info);
			} else {
				return ((NoArvoreBinariaBST<T>)this.getDir()).buscar(info);
			}
		}
	}
	
	
}
