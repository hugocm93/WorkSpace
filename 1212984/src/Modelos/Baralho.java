package Modelos;

public class Baralho {
	
	Carta[] cartas;
	String tipo;
	int qtd;
	
	public Baralho(Carta[] cartas, String tipo, int qtd) {
		super();
		this.cartas = cartas;
		this.tipo = tipo;
		this.qtd = qtd;
	}

	public Carta[] getCartas() {
		return cartas;
	}

	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	

}
