package Controladores;

import javax.swing.ImageIcon;

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
		// TODO Auto-generated method stub

		mundo.ordenarDados(TipoDado.ATAQUE);

	}

	public static void ordenarDadosDeDefesa() {
		// TODO Auto-generated method stub

		mundo.ordenarDados(TipoDado.DEFESA);

	}

}
