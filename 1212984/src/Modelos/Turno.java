package Modelos;

public class Turno {
	
	Jogador jogador;
	int indexJogador;
	int nExercitosDaVez;
	
	Jogador atacante;
	Jogador defensor;
	
	public Turno(Jogador jogador, int nExercitosDaVez,int index) {
		super();
		this.jogador = jogador;
		this.nExercitosDaVez = nExercitosDaVez;
		this.indexJogador = index;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public int getnExercitosDaVez() {
		return nExercitosDaVez;
	}

	public void setnExercitosDaVez(int nExercitosDaVez) {
		this.nExercitosDaVez = nExercitosDaVez;
	}

	public int getIndexJogador() {
		return indexJogador;
	}

	public void setIndexJogador(int indexJogador) {
		this.indexJogador = indexJogador;
	}

	public Jogador getAtacante() {
		return atacante;
	}

	public void setAtacante(Jogador atacante) {
		this.atacante = atacante;
	}

	public Jogador getDefensor() {
		return defensor;
	}

	public void setDefensor(Jogador defensor) {
		this.defensor = defensor;
	}
	
	
	
	
	
}
