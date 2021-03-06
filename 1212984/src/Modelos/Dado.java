package Modelos;

import javax.swing.ImageIcon;

public class Dado {

	int valor;
	ImageIcon icon;
	TipoDado tipo;

	public Dado() {
		valor = 0;
		icon = null;
		tipo = TipoDado.INDEF;
	}

	public int rolar_dado() {
		valor = 1 + (int)(Math.random() * 6);

		if(tipo == TipoDado.ATAQUE){
			icon = new ImageIcon("src/zImagens/Dados/dado_ataque_" + valor + ".png");
		}
		else if(tipo == TipoDado.DEFESA){
			icon = new ImageIcon("src/zImagens/Dados/dado_defesa_" + valor + ".png");
		}
		else{
			icon = null;
		}

		return valor;
	}

	public TipoDado getTipo() {
		return tipo;
	}

	public void setTipo(TipoDado tipo) {
		this.tipo = tipo;
	}

	public void reseta(){
		valor = 0;
		icon = null;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}



}
