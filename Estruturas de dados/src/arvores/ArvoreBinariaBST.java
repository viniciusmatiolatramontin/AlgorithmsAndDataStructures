package arvores;

public class ArvoreBinariaBST<T extends Comparable<T>> extends ArvoreBinaria<T>{
	
	public void inserir(T info) {
		if(this.vazia()) {
			this.setRaiz(new NoArvoreBinariaBST<T>(info));
		} else {
			((NoArvoreBinariaBST<T>)this.getRaiz()).inserir(info);
		}
	}
	
	public NoArvoreBinariaBST<T> buscar(T info) {
		return ((NoArvoreBinariaBST<T>)this.getRaiz()).buscar(info);
	}
	
	public NoArvoreBinariaBST<T> buscarPai(NoArvoreBinariaBST<T> no) {
		if(this.getRaiz() == no) {
			return null;
		}
		
		return ((NoArvoreBinariaBST<T>)this.getRaiz()).buscarPai(no);
	}
	
	public void retirar(T info) {
		NoArvoreBinariaBST<T> no = this.buscar(info);
		NoArvoreBinariaBST<T> noSucessor = (NoArvoreBinariaBST<T>) this.buscar(info).getDir();
		NoArvoreBinariaBST<T> noPai = this.buscarPai(no);
		if(no.eFolha()) {
			if(no == this.getRaiz()) {
				this.setRaiz(no);
			} else {
				if(noPai.getEsq() == no) {
					noPai.setEsq(null);
				} else {
					noPai.setDir(null);
				}
			}
		} else if(no.temUmFilho()) {
			if(no == this.getRaiz()) {
				if(no.getEsq() != null) {
					this.setRaiz(no.getEsq());
				} else {
					this.setRaiz(no.getDir());
				}
			} else {
				if(noPai.getEsq() == no) {
					if(no.getEsq() != null) {
						noPai.setEsq(no.getEsq());
					} else {
						noPai.setEsq(no.getDir());
					}
				} else {
					if(no.getEsq() != null) {
						noPai.setDir(no.getEsq());
					} else {
						noPai.setDir(no.getDir());
					}
				}
			}
		} else {	
			while(noSucessor.getEsq() != null) {
				noSucessor = (NoArvoreBinariaBST<T>) noSucessor.getEsq();
			}
			
			this.retirar(noSucessor.getInfo());
			noSucessor.setDir(no.getDir());
			noSucessor.setEsq(no.getEsq());
			
			if(no == this.getRaiz()) {
				this.setRaiz(noSucessor);
			} else {
				if(noPai.getEsq() == no) {
					noPai.setEsq(noSucessor);
				} else {
					noPai.setDir(no);
				}
			}
		}
	}
}
