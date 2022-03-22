
public class ListaEstatica implements Lista {
	private int[] info;
	private int tamanho;
	
	public ListaEstatica() {
		this.info = new int[10];
		this.tamanho = 0;
	}
	
	private void redimensionar() {
		int[] novo;
		int novoTamanho = info.length + 10;
		novo = new int[novoTamanho];
		
		for(int i = 0; i < info.length; i++) {
			novo[i] = info[i];
		}
		
		info = novo;
	}
	
	@Override
	public void inserir(int valor) {
		if(tamanho == info.length) {
			redimensionar();
		}
		
		info[tamanho] = valor;
		tamanho++;
	}
	
	@Override
	public int buscar(int valor) {
		for(int i = 0; i < tamanho; i++) {
			if(info[i] == valor) {
				return i;
			}
		}
		
		return -1;
	}
	
	@Override
	public void retirar(int valor) {
		int local = buscar(valor);
		info[local] = 0;
		
		for(int i = local; i < tamanho - 1; i++) {
			info[i] = info[i+1];
		}
		
		tamanho--;
	}
	
	@Override
	public String exibir() {
		String vetor = "Vetor:";
		
		for(int i = 0; i < tamanho; i++) {
			vetor += " " + info[i];
		}
		
		return vetor;
	}
	
	@Override
	public boolean estaVazia() {
		if(tamanho == 0) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public void concatenar(Lista outra) {
		for(int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}
	
	@Override
	public Lista dividir() {
		Lista novaLista = new ListaEstatica();
		
		int tamanhoEstatico = tamanho/2;
		
		for(int i = 0; i < tamanhoEstatico; i++) {
			novaLista.inserir(info[0]);
			this.retirar(info[0]);
		}
		
		return novaLista;
	}
	
	@Override
	public Lista copiar() {
		Lista novaLista = new ListaEstatica();
		
		for(int i = 0; i < tamanho; i++) {
			novaLista.inserir(info[i]);
		}
		
		return novaLista;
	}

	@Override
	public int getTamanho() {
		return this.tamanho;
	}

	@Override
	public int pegar(int pos) {
		return info[pos];
	}
}
