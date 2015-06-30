package Modelos;

public class Carta {
	
	Jogador dono;
	String imgNome;
	Territorio territorio;
	
	public Carta(Jogador dono, String imgNome, Territorio territorio) {
		super();
		this.dono = dono;
		this.imgNome = imgNome;
		this.territorio = territorio;
	}

	public Jogador getDono() {
		return dono;
	}

	public void setDono(Jogador dono) {
		this.dono = dono;
	}

	public String getImgNome() {
		return imgNome;
	}

	public void setImgNome(String imgNome) {
		this.imgNome = imgNome;
	}

	public Territorio getTerritorio() {
		return territorio;
	}

	public void setTerritorio(Territorio territorio) {
		this.territorio = territorio;
	}

	
}
