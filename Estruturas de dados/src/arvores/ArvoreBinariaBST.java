package arvores;

public class ArvoreBinariaBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

	public void inserir(T valor) {
		if (this.vazia()) {
			this.setRaiz(new NoArvoreBinariaBST<>(valor));
		} else {
			((NoArvoreBinariaBST<T>) this.getRaiz()).inserir(valor);
		}
	}

	public NoArvoreBinariaBST<T> buscar(T valor) {
		if (this.vazia()) {
			return null;
		} else {
			return ((NoArvoreBinariaBST<T>) this.getRaiz()).buscar(valor);
		}
	}

	public void retirar(T valor) {
		NoArvoreBinariaBST<T> noARetirar = this.buscar(valor);
		if (noARetirar != null) {
			this.retirar(noARetirar);
		}
	}
		
	private void retirar(NoArvoreBinariaBST<T> noARetirar) {
		NoArvoreBinariaBST<T> noPai = this.buscarPai(noARetirar);

		if (noARetirar.ehFolha()) { // caso 1
			if (noARetirar == this.getRaiz()) { // para saber se é a raiz
				this.setRaiz(null);
			} else {
				if (noPai.getEsq() == noARetirar) {
					noPai.setEsq(null);
				} else {
					noPai.setDir(null);
				}
			}
		} else {
			if (noARetirar.temApenasUmFilho()) { // caso 2
				NoArvoreBinaria<T> filho = (noARetirar.getEsq() == null
											?noARetirar.getDir()
											:noARetirar.getEsq());
				if (noARetirar == this.getRaiz()) {
					this.setRaiz(filho);
				} else {
					if (noPai.getEsq() == noARetirar) {
						noPai.setEsq(filho);
					} else {
						noPai.setDir(filho);
					}
				}
			} else { // caso 3
				NoArvoreBinariaBST<T> noSucessor = noARetirar.getNoSucessor();
				T info = noSucessor.getInfo();
				this.retirar(noSucessor);
				noARetirar.setInfo(info);
			}
		}

	}

	private NoArvoreBinariaBST<T> buscarPai(NoArvoreBinariaBST<T> noARetirar) {
		if (this.getRaiz() == noARetirar) {
			return null;
		}
		NoArvoreBinaria<T> pai = this.getRaiz();
		while (pai.getEsq() != noARetirar && pai.getDir() != noARetirar) {
			if (noARetirar.getInfo().compareTo(pai.getInfo()) < 0) {
				pai = pai.getEsq();
			} else {
				pai = pai.getDir();
			}
		}
		return (NoArvoreBinariaBST<T>) pai;
	}
	
	public T menorElemento() {
		return ((NoArvoreBinariaBST<T>) this.getRaiz()).menorElemento();
	}
	
	public T maiorElemento() {
		return ((NoArvoreBinariaBST<T>) this.getRaiz()).maiorElemento();
	}
	
	public T getNoAntecessor(T info) {
		NoArvoreBinariaBST<T> no = this.buscar(info);
		NoArvoreBinariaBST<T> pai = no;
		if(no != null && no.getEsq() != null) {
			return no.getNoAntecessor().getInfo();
		} else if(no != null && this.menorElemento().compareTo(info) != 0) {
			while(pai.getInfo().compareTo(info) >= 0) {
				pai = this.buscarPai(pai);
			}
			return pai.getInfo();
		} else {
			return null;
		}
	}
	
	public T getNoSucessor(T info) {
		NoArvoreBinariaBST<T> no = this.buscar(info);
		NoArvoreBinariaBST<T> pai = no;
		if(no != null && no.getDir() != null) {
			return no.getNoSucessor().getInfo();
		} else if(no != null && this.maiorElemento().compareTo(info) != 0) {
			while(pai.getInfo().compareTo(info) <= 0) {
				pai = this.buscarPai(pai);
			}
			return pai.getInfo();
		} else {
			return null;
		}
	}
	
	public String toSringOrdered() {
		return this.getRaiz().imprimeOrdenado();
	}
}