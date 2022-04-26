package arvores;

public class ArvoreBinariaBST<T extends Comparable<T>> extends ArvoreBinaria<T>{
	
	public void inserir(T info) {
		if(this.vazia()) {
			this.setRaiz(new NoArvoreBinariaBST<T>(info));
		} else {
			((NoArvoreBinariaBST<T>)this.getRaiz()).inserir(info);
		}
	}
	
	public void buscar(T info) {
		((NoArvoreBinariaBST<T>)this.getRaiz()).buscar(info);
	}
}
