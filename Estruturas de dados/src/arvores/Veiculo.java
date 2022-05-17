package arvores;

public class Veiculo implements Comparable<Veiculo>{

	private String placa;
	private String modelo;
	private int ano;
	private String proprietario;
	
	public Veiculo(String placa, String modelo, int ano, String proprietario) {
		this.setPlaca(placa);
		this.setModelo(modelo);
		this.setAno(ano);
		this.setProprietario(proprietario);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public int compareTo(Veiculo o) {
		if(this.getPlaca().compareTo(o.getPlaca()) > 0) {
			return 1;
		} else if(this.getPlaca().compareTo(o.getPlaca()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", modelo=" + modelo + ", ano=" + ano + ", proprietario=" + proprietario
				+ "]";
	}
	
	
	
}
