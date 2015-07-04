package Modelos;

public class Continente {
	
	String nome;
	Territorio[] territorios;
	Cor cor;
	Jogador dono;
	int exercitosTabela;
	
	public Continente(String nome, Territorio[] territorios, Cor cor, Jogador dono, int exercitosTabela) {
		
		this.nome = nome;
		this.territorios = territorios;
		this.cor = cor;
		this.dono = dono;
		this.exercitosTabela = exercitosTabela;
		
		this.preencher();
	}

	public Jogador getDono() {
		return dono;
	}

	public void setDono(Jogador dono) {
		this.dono = dono;
	}

	public Territorio[] getTerritorios() {
		return territorios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public int getExercitosTabela() {
		return exercitosTabela;
	}

	public void setExercitosTabela(int exercitosTabela) {
		this.exercitosTabela = exercitosTabela;
	}

	public void setTerritorios(Territorio[] territorios) {
		this.territorios = territorios;
	}
	
	private void preencher(){
		for(int i = 0; i<territorios.length ;i++){
			territorios[i].setCont(this);
		}
	}
	

}
