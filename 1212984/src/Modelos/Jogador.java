package Modelos;

import java.util.ArrayList;

public class Jogador {
	private String nome;
	private String cor;
	private String obj;
	private ArrayList< Carta > cartas = new ArrayList< Carta >();
	private ArrayList< Territorio > territoriosPossuidos = new ArrayList< Territorio >();
	private ArrayList<Continente> continentesPossuidos = new ArrayList<Continente>();
	
	
	
	
	public Jogador(String nome, String cor, String obj, ArrayList<Carta> cartas, ArrayList<Territorio> territoriosPossuidos, ArrayList<Continente> continentesPossuidos) {
		super();
		this.nome = nome;
		this.cor = cor;
		this.obj = obj;
		this.cartas = new ArrayList< Carta >();
		this.territoriosPossuidos = new ArrayList< Territorio >();
		this.continentesPossuidos = new ArrayList<Continente>();
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
	public String getObj() {
		return obj;
	}
	public void setObj(String obj) {
		this.obj = obj;
	}
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	public ArrayList<Territorio> getTerritoriosPossuidos() {
		return territoriosPossuidos;
	}
	public void setTerritoriosPossuidos(ArrayList<Territorio> territoriosPossuidos) {
		this.territoriosPossuidos = territoriosPossuidos;
	}
	public ArrayList<Continente> getContinentesPossuidos() {
		return continentesPossuidos;
	}
	public void setContinentesPossuidos(ArrayList<Continente> continentesPossuidos) {
		this.continentesPossuidos = continentesPossuidos;
	}


	
	
}
