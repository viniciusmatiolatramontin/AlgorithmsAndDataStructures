package lineares.fila;

public class FilaVetor<T> implements Fila<T> {

    private int limite;
    private int tamanhoAtual = 0;
    private T[] info;
    private int inicio = 0;
    
    public FilaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
    }
	
	@Override
	public void inserir(T valor) {
		info[(tamanhoAtual + inicio)%limite] = valor;
		tamanhoAtual++;
	}

	@Override
	public T retirar() {
		T retorno = info[inicio];
		info[inicio] = null;
		this.inicio = (inicio+1)%limite;
		tamanhoAtual = tamanhoAtual-1;
		return retorno;
	}

	@Override
	public T peek() {
		if(estaVazia()) {
			throw new RuntimeException("A fila est? vazia");
		}
		return info[inicio];
	}

	@Override
	public boolean estaVazia() {
		if (tamanhoAtual == 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public void liberar() {
		for(int i = 0; i < info.length; i++) {
			this.retirar();
		}
	}

	@Override
	public String toString() {
		String resultado = "FilaVetor [";
		
		for(int i = 0; i < tamanhoAtual; i++) {
			if(i == tamanhoAtual-1) {
				resultado += this.pegar(i).toString() + "]";
			} else {
				resultado += this.pegar(i).toString() + ", ";
			}
		}
		
		return resultado;
	}
	
	public FilaVetor<T> concatenar(FilaVetor<T> v2) {
		FilaVetor<T> fila = new FilaVetor<>(this.getLimite()+v2.getLimite());
		
		for(int i = 0; i < this.getTamanhoAtual(); i++) {
			fila.inserir(pegar(i));
		}
		
		for(int i = 0; i < v2.getTamanhoAtual(); i++) {
			fila.inserir(v2.pegar(i));
		}
		
		return fila;
	}

	private T pegar(int i) {
		return info[(i + inicio)%limite];
	}
	
	private int getLimite() {
		return limite;
	}

	private int getTamanhoAtual() {
		return tamanhoAtual;
	}
	
}
