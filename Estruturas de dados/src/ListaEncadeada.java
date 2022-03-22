
public class ListaEncadeada implements Lista {

	private NoLista primeiro;
	private NoLista ultimo;
	private int qtdElementos;
	
	
	@Override
	public void inserir(int valor) {
		NoLista novo = new NoLista();
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
	public int buscar(int valor) {
		NoLista p = primeiro;
		
		for(int i = 0; i < qtdElementos; i++) {
			if(p != null) {
				if(p.getInfo() == valor) {
					return i;
				}
			
				p = p.getProximo();
			}
		}
		
		return -1;
	}

	@Override
	public void retirar(int valor) {
		NoLista no = primeiro;
		NoLista noAnterior = null;
			
		while(no != null && no.getInfo() != valor) {
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
		NoLista no = primeiro;
		
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
	public Lista dividir() {
		NoLista no = primeiro;
		ListaEncadeada listaNova = new ListaEncadeada();
		int metade = this.getTamanho() / 2;
		int contador = 1;
		
		while(no != null) {
			if(contador > metade) {
				listaNova.inserir(no.getInfo());
				this.retirar(no.getInfo());
			}
			contador++;
			no = no.getProximo();
		}
		
		return listaNova;
	}

	@Override
	public Lista copiar() {
		NoLista no = primeiro;
		ListaEncadeada listaNova = new ListaEncadeada();
		while(no != null) {
			listaNova.inserir(no.getInfo());
			no = no.getProximo();
		}
		
		return listaNova;
	}

	@Override
	public void concatenar(Lista outra) {
		for(int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return this.qtdElementos;
	}

	@Override
	public int pegar(int pos) {
		NoLista no = primeiro;
		
		for(int i = 1; i <= pos; i++) {
			no = no.getProximo();
		}
		
		return no.getInfo();
	}

}
