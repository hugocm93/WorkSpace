package Controladores;

import Modelos.Mundo;

public class ControladorPainelOpcoes {
	
	private static Mundo mundo = Mundo.getInstance();
	private static String[] rets;
	
	public static String jogadorAtual(String param){
		if(param.equals("nome")){
			return mundo.getJogadores()[mundo.getJogadorDaVez()].getNome();
		}
		if(param.equals("cor")){
			return mundo.getJogadores()[mundo.getJogadorDaVez()].getCor();
		}
		if(param.equals("exer")){
			return String.format("%d",mundo.getR().getAtual().getnExercitosDaVez());
			
		}
		return null;
	}
	
	public static void proximo(){
		mundo.proximoJogador();
	}
	
	public static void anterior(){
		mundo.jogadorAnt();
	}

	public static String[] getNomesDasImagensDosJogadores(){
		rets = new String[6];

		for(int i=0; i<6 && mundo.coresDosJogadores()[i]!=null ;i++){
			rets[i] = mundo.coresDosJogadores()[i];
		}

		return rets;
	}

	public static void isfimRodada() {
		mundo.isFimRodada();
		
	}

	public static boolean permitidoPassar(String name) {
		return mundo.permitidoPassar(name);
	}
	
}
