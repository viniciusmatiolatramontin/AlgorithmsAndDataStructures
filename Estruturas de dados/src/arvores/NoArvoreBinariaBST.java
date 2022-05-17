package arvores;

public class NoArvoreBinariaBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

	public NoArvoreBinariaBST(T info) {
		super(info);
	}

	public void inserir(T valor) {
		if (valor.compareTo(this.getInfo()) < 0) {
			if (this.getEsq() == null) {
				this.setEsq(new NoArvoreBinariaBST<T>(valor));
			} else {
				((NoArvoreBinariaBST<T>) this.getEsq()).inserir(valor);
			}
		} else {
			if (this.getDir() == null) {
				this.setDir(new NoArvoreBinariaBST<T>(valor));
			} else {
				((NoArvoreBinariaBST<T>) this.getDir()).inserir(valor);
			}
		}
	}

	public NoArvoreBinariaBST<T> buscar(T valor) {
		if (valor.compareTo(this.getInfo()) == 0) {
			return this;
		} else {
			if (valor.compareTo(this.getInfo()) < 0) {
				if (this.getEsq() == null) {
					return null;
				} else {
					return ((NoArvoreBinariaBST<T>) this.getEsq()).buscar(valor);
				}
			} else {
				if (this.getDir() == null) {
					return null;
				} else {
					return ((NoArvoreBinariaBST<T>) this.getDir()).buscar(valor);
				}
			}
		}
	}

	public boolean ehFolha() {
		return (this.getEsq() == null && this.getDir() == null);
	}

	public boolean temApenasUmFilho() {
		return (this.getEsq() == null ^ this.getDir() == null); // ou exclusivo
	}

	public NoArvoreBinariaBST<T> getNoSucessor() {
		NoArvoreBinariaBST<T> sucessor = (NoArvoreBinariaBST<T>) this.getDir();
		while(sucessor.getEsq() != null) {
			sucessor = (NoArvoreBinariaBST<T>)sucessor.getEsq();
		}
		return sucessor;
	}
	
	public NoArvoreBinariaBST<T> getNoAntecessor() {
		NoArvoreBinariaBST<T> sucessor = (NoArvoreBinariaBST<T>) this.getEsq();
		while(sucessor.getDir() != null) {
			sucessor = (NoArvoreBinariaBST<T>)sucessor.getDir();
		}
		return sucessor;
	}
	
	public T menorElemento() {
		if(this.getEsq() != null) {
			return ((NoArvoreBinariaBST<T>) this.getEsq()).menorElemento();
		} else {
			return this.getInfo();
		}
	}
	
	public T maiorElemento() {
		if(this.getEsq() != null) {
			return ((NoArvoreBinariaBST<T>) this.getDir()).menorElemento();
		} else {
			return this.getInfo();
		}
	}
}