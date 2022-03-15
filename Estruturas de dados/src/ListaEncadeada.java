
public class ListaEncadeada implements Lista {

	private NoLista primeiro;
	private NoLista ultimo;
	private int qtdElementos;
	
	
	@Override
	public void inserir(int valor) {
		NoLista novo = new NoLista();
		novo.setInfo(valor);
		novo.setProximo(null);
		if(this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(primeiro);
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
		
		if(noAnterior == null) {
			primeiro = no.getProximo();
		}
		
		noAnterior.setProximo(no.getProximo());
		qtdElementos--;
		
		if(ultimo == no) {
			ultimo = noAnterior;
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
		
		while(no != null && contador < this.getTamanho()) {
			if(contador > metade) {
				
			}
		}
	}

	@Override
	public Lista copiar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void concatenar(Lista outra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTamanho() {
		return this.qtdElementos;
	}

	@Override
	public void inserir(int valor, int pos) {
		NoLista no = primeiro;
		NoLista noAnterior = null;
		NoLista noNovo = new NoLista();
		int contador = 0;		
		
		while(no != null && no.getInfo() != valor) {
			no = no.getProximo();
			noAnterior = noAnterior.getProximo();
		}
		
		
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
