public class ListaEncadeada<T> implements Lista<T> {

	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdElementos;
	
	
	@Override
	public void inserir(T valor) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(valor);
		
		if(this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		
		ultimo = novo;
		qtdElementos++;
	}

	@Override
	public int buscar(T valor) {
		NoLista<T> p = primeiro;
		
		for(int i = 0; i < qtdElementos; i++) {
			if(p != null) {
				if(p.getInfo().equals(valor)) {
					return i;
				}
			
				p = p.getProximo();
			}
		}
		
		return -1;
	}

	@Override
	public void retirar(T valor) {
		NoLista<T> no = primeiro;
		NoLista<T> noAnterior = null;
			
		while(no != null && !no.getInfo().equals(valor)) {
			noAnterior = no;
			no = no.getProximo();
		}
		
		if(no != null) {
			if(noAnterior == null) {
				primeiro = no.getProximo();
			} else {
				noAnterior.setProximo(no.getProximo());
			}
			
			if(ultimo == no) {
				ultimo = noAnterior;
			}
	
			qtdElementos--;
		}
	}

	@Override
	public String exibir() {
		String resultado = "Lista: [";
		NoLista<T> no = primeiro;
		
		while(no != null) {
			resultado += no.getInfo() + ", ";
			no = no.getProximo();
		}
		
		return resultado + "]";
	}

	@Override
	public boolean estaVazia() {
		if(primeiro == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Lista<T> dividir() {
		NoLista<T> no = primeiro;
		ListaEncadeada<T> listaNova = new ListaEncadeada<>();
		int metade = this.getTamanho() / 2;
		int contador = 1;
		
		while(no != null) {
			if(contador > metade) {
				listaNova.inserir(no.getInfo());
			} else {
				
			}
			contador++;
			no = no.getProximo();
		}
		
		return listaNova;
	}

	@Override
	public Lista<T> copiar() {
		NoLista<T> no = primeiro;
		ListaEncadeada<T> listaNova = new ListaEncadeada<>();
		while(no != null) {
			listaNova.inserir(no.getInfo());
			no = no.getProximo();
		}
		
		return listaNova;
	}

	@Override
	public void concatenar(Lista<T> outra) {
		for(int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return this.qtdElementos;
	}

	@Override
	public T pegar(int pos) {
		if(pos < 0 || pos >= this.qtdElementos) {
			throw new IndexOutOfBoundsException("Posi�ao="+pos+"; Tamanho="+this.qtdElementos);
		}
		
		NoLista<T> no = primeiro;
		
		for(int i = 0; i < pos; i++) {
			no = no.getProximo();
		}
		
		return no.getInfo();
	}

}
