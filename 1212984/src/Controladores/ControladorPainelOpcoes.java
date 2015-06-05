package Controladores;

import Modelos.Mundo;

public class ControladorPainelOpcoes {
	
	private static Mundo mundo = Mundo.getInstance();
	
	public static String jogadorAtual(String param){
		if(param.equals("nome")){
			return mundo.getJogadores()[mundo.getJogadorDaVez()].getNome();
		}
		if(param.equals("cor")){
			return mundo.getJogadores()[mundo.getJogadorDaVez()].getCor();
		}
		return null;
	}
	
	public static void proximo(){
		mundo.proximoJogador();
	}
	
	public static void anterior(){
		mundo.jogadorAnt();
	}

}
