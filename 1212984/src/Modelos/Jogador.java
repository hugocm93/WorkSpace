package Modelos;

public class Jogador {
	private String nome;
	private String cor;
	private Objetivo obj;
	private Carta[] cartas;
	private Territorio[] territoriosPossuidos;
	private Continente[] continentesPossuidos;


	public Jogador(String nome, String cor, Objetivo obj, Carta[] cartas, Territorio[] territoriosPossuidos, Continente[] continentesPossuidos) {

		this.nome = nome;
		this.cor = cor;
		this.obj = obj;
		this.cartas = cartas;
		this.territoriosPossuidos = territoriosPossuidos;
		this.continentesPossuidos = continentesPossuidos;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Objetivo getObj() {
		return obj;
	}
	public void setObj(Objetivo obj) {
		this.obj = obj;
	}
	public Carta[] getCartas() {
		return cartas;
	}
	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}
	public Territorio[] getTerritoriosPossuidos() {
		return territoriosPossuidos;
	}
	public void setTerritoriosPossuidos(Territorio[] territoriosPossuidos) {
		this.territoriosPossuidos = territoriosPossuidos;
	}
	public Continente[] getContinentesPossuidos() {
		return continentesPossuidos;
	}
	public void setContinentesPossuidos(Continente[] continentesPossuidos) {
		this.continentesPossuidos = continentesPossuidos;
	}
	
}
