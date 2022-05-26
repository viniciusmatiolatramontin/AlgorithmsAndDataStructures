package arvores;

public class NoArvore<T extends Comparable<T>> {
	private T info;
	private NoArvore<T> filho;
	private NoArvore<T> irmao;
	
	public NoArvore(T info) {
		this.info = info;
	}
	
	public String imprimePre() {
		String result = "<" + this.info.toString();
		
		if(this.getFilho() != null) {
			result += filho.imprimePre();
		}
		
		result += ">";
		
		if(this.getIrmao() != null) {
			result += irmao.imprimePre();
		}
		
		return result;
	}
	
	public void inserirFilho(NoArvore<T> filho) {
		filho.setIrmao(this.getFilho());
		this.filho = filho;
	}
	

	public NoArvore<T> pertence(T info) {
		if (this.info.equals(info)) {
			return this;
		} else {
			NoArvore<T> no = null;
			if (this.getFilho() != null) {
				no = this.getFilho().pertence(info);
			}
			if (no == null && this.getIrmao() != null) {
				no = this.getIrmao().pertence(info);
			}
			return no;
		}
	}

	public NoArvore<T> getFilho() {
		return filho;
	}

	public NoArvore<T> getIrmao() {
		return irmao;
	}

	private void setIrmao(NoArvore<T> irmao) {
		this.irmao = irmao;
	}
	
	public T getInfo() {
		return info;
	}
	
	public int contaAltura() {	
		int altura = 1;
		
		if(this.getFilho() != null) {
			altura += this.getFilho().contaAltura();
		}
		
		if(this.getIrmao() != null && this.getIrmao().contaAltura() > altura) {
			altura = this.getIrmao().contaAltura();
		}
		
		return altura;
	}
	
	public int contaNivel(T info) {	
		int nivel = 1;
		
		if(this.getInfo().equals(info)) {
			return 0;
		}
		
		if(this.getFilho() != null) {
			nivel += this.getFilho().contaNivel(info);
		}
		
		if(this.getIrmao() != null && this.getIrmao().pertence(info) != null) {
			nivel = this.getIrmao().contaNivel(info);
		}
		
		return nivel;
	}
}
