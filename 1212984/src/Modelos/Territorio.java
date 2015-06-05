package Modelos;

public class Territorio {

	String nome;
	Poligono poligono;
	int exercitos;
	Jogador dono;
	Simbolo simb;
	String[] TerritoriosFronteira;


	public Territorio(String nome, Poligono poligono, int exercitos, Jogador dono, Simbolo simb, String[] territoriosFronteira) {

		this.nome = nome;
		this.poligono = poligono;
		this.exercitos = exercitos;
		this.dono = dono;
		this.simb = simb;
		TerritoriosFronteira = territoriosFronteira;
	}


	public int getExercitos() {
		return exercitos;
	}


	public void setExercitos(int exercitos) {
		this.exercitos = exercitos;
	}


	public Jogador getDono() {
		return dono;
	}


	public void setDono(Jogador dono) {
		this.dono = dono;
	}


	public Poligono getPoligono() {
		return poligono;
	}


	public String getNome() {
		return nome;
	}


	public Simbolo getSimb() {
		return simb;
	}


	public void setSimb(Simbolo simb) {
		this.simb = simb;
	}


	public String[] getTerritoriosFronteira() {
		return TerritoriosFronteira;
	}


	public void setTerritoriosFronteira(String[] territoriosFronteira) {
		TerritoriosFronteira = territoriosFronteira;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setPoligono(Poligono poligono) {
		this.poligono = poligono;
	}



}
