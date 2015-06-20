package Modelos;

public class Turno {
	
	Jogador jogador;
	int indexJogador;
	int nExercitosDaVez;
	
	Territorio atacante;
	Territorio defensor;
	
	boolean fimFaseAtaque = false;
	
	
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

	public Territorio getAtacante() {
		return atacante;
	}

	public void setAtacante(Territorio atacante) {
		this.atacante = atacante;
	}

	public Territorio getDefensor() {
		return defensor;
	}

	public void setDefensor(Territorio defensor) {
		this.defensor = defensor;
	}

	public boolean isFimFaseAtaque() {
		return fimFaseAtaque;
	}

	public void setFimFaseAtaque(boolean fimFaseAtaque) {
		this.fimFaseAtaque = fimFaseAtaque;
	}
	
	
	
	
	
}
