package Modelos;

import java.util.HashMap;

import Controladores.ControladorInicial;
import Interface.Fase;

public class Turno {
	
	Jogador jogador;
	int indexJogador;
	int nExercitosDaVez;
	boolean jaTrocou;
	boolean jaRecebeuCarta;
	boolean podeReceberCarta;
	
	HashMap<String, Integer> nExercitosDaVezContinente;
	
	HashMap<String, Integer> snap;
	
	
	
	int nExercitosDaVezCartas;
	
	Territorio atacante;
	Territorio defensor;
	
	Fase f;
	
	boolean fimFaseAtaque = false;
	
	
	public Turno(Jogador jogador, int nExercitosDaVez,int index) {
		super();
		this.jogador = jogador;
		this.nExercitosDaVez = nExercitosDaVez;
		this.indexJogador = index;
		
		nExercitosDaVezContinente = new HashMap<String, Integer>();
		
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

	public Fase getF() {
		return f;
	}

	public void setF(Fase f) {
		this.f = f;
	}
	
	
	public HashMap<String, Integer> getnExercitosDaVezContinente() {
		return nExercitosDaVezContinente;
	}

	public void setnExercitosDaVezContinente(
			HashMap<String, Integer> nExercitosDaVezContinente) {
		this.nExercitosDaVezContinente = nExercitosDaVezContinente;
	}

	public int getnExercitosDaVezCartas() {
		return nExercitosDaVezCartas;
	}

	public void setnExercitosDaVezCartas(int nExercitosDaVezCartas) {
		this.nExercitosDaVezCartas = nExercitosDaVezCartas;
	}

	public HashMap<String, Integer> getSnap() {
		return snap;
	}

	public void setSnap(HashMap<String, Integer> snap) {
		this.snap = snap;
	}

	public boolean isJaTrocou() {
		return jaTrocou;
	}

	public void setJaTrocou(boolean jaTrocou) {
		this.jaTrocou = jaTrocou;
	}

	public boolean isJaRecebeuCarta() {
		return jaRecebeuCarta;
	}

	public void setJaRecebeuCarta(boolean jaRecebeuCarta) {
		this.jaRecebeuCarta = jaRecebeuCarta;
	}

	public boolean isPodeReceberCarta() {
		return podeReceberCarta;
	}

	public void setPodeReceberCarta(boolean podeReceberCarta) {
		this.podeReceberCarta = podeReceberCarta;
	}

	
	
	
}
