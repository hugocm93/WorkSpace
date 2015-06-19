package Controladores;

import javax.swing.ImageIcon;

import Modelos.Dado;
import Modelos.Mundo;
import Modelos.TipoDado;

public class ControladorFrameDados {

	private static Mundo mundo = Mundo.getInstance();

	public static  void jogarDadosAtaque(int nExercitosAtaque){

		for(int i=0;i<3;i++){
			mundo.getDadosAtaque()[i].reseta();
		}

		if(nExercitosAtaque<=3){
			for(int i=0;i<nExercitosAtaque-1;i++){
				mundo.getDadosAtaque()[i].rolar_dado();
			}
		}
		else{
			for(int i=0;i<3;i++){
				mundo.getDadosAtaque()[i].rolar_dado();
			}
		}

	}

	public static void jogarDadosDefesa(int nExercitosDefesa){

		for(int i=0;i<3;i++){
			mundo.getDadosDefesa()[i].reseta();
		}

		if(nExercitosDefesa<=3){
			for(int i=0;i<nExercitosDefesa;i++){
				mundo.getDadosDefesa()[i].rolar_dado();
			}
		}
		else{
			for(int i=0;i<3;i++){
				mundo.getDadosDefesa()[i].rolar_dado();
			}
		}

	}

	public static ImageIcon[] getNomesDasImagensDosDadosDeAtaque(){
		ImageIcon[] ret = new ImageIcon[3];

		for(int i=0;i<3;i++){
			ret[i] = mundo.getDadosAtaque()[i].getIcon();
		}

		return ret;
	}

	public static ImageIcon[] getNomesDasImagensDosDadosDeDefesa(){
		ImageIcon[] ret = new ImageIcon[3];

		for(int i=0;i<3;i++){
			ret[i] = mundo.getDadosDefesa()[i].getIcon();
		}

		return ret;
	}

	public static void ordenarDadosDeAtaque() {

		ControladorFrameDados.ordenarDados(TipoDado.ATAQUE);

	}

	public static void ordenarDadosDeDefesa() {

		ControladorFrameDados.ordenarDados(TipoDado.DEFESA);

	}
	
	static void ordenarDados(TipoDado t){
		if(t == TipoDado.ATAQUE){
			
			Dado[] dadosAtaque = mundo.getDadosAtaque();

			int fim=3;

			for(;fim>0;fim--){
				for(int j=0;j<fim-1;j++){
					if(dadosAtaque[j].getValor() < dadosAtaque[j+1].getValor()){
						Dado aux = dadosAtaque[j];
						dadosAtaque[j] = dadosAtaque[j+1];
						dadosAtaque[j+1] = aux;
					}
				}
			}
		}
		else{
			int fim=3;
			
			Dado[] dadosDefesa = mundo.getDadosDefesa();

			for(;fim>0;fim--){
				for(int j=0;j<fim-1;j++){
					if(dadosDefesa[j].getValor() < dadosDefesa[j+1].getValor()){
						Dado aux = dadosDefesa[j];
						dadosDefesa[j] = dadosDefesa[j+1];
						dadosDefesa[j+1] = aux;
					}
				}
			}
		}
	}
	
	
	static boolean compararDados(){
		//TODO compara dado a dado - os dados são vetores ()
		// TODO mundo.getDadosAtaque()
		//TODO mundo.getDadosDefesa()
		
		//TODO retirar exercitos do territorio correspondente
		//TODO retirar territorio da lista do jogador defensor e coloca-lo na lista de exercitos do jogador atacante com um exercito
		//TODO entrar no territorio e trocar o dono dele
		
		//TODO se retornar true eh porque conquistou
		
		return false;
	}


}
