package Controladores;

import Modelos.Jogador;
import Modelos.Mundo;

public class ControladorInicial {
	
	private static Mundo mundo = Mundo.getInstance();
	
	public static void criaNovoJogador(String nome, String cor){
		mundo.insereNovoJogador(new Jogador(nome, cor, null, null, null, null));
	}

	public static void sortSequencia() {
		mundo.desordena();
		
	}
	
	public static void imprime(){
		mundo.listaJogadores();
	}

	public static void criaTurnos() {
		mundo.criaTurnos();
		
	}
	
	public static void sortearTerritorios(){
		mundo.distribuirTerritorios();

	}

}
