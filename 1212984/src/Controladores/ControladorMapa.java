package Controladores;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Interface.Constantes;
import Modelos.Cor;
import Modelos.Mundo;
import Modelos.Rodada;
import Modelos.Territorio;

public class ControladorMapa {

	private static Mundo mundo = Mundo.getInstance();
	private static Territorio clicado ;

	public static String detectaTerritorio(MouseEvent e, BufferedImage imgMapa){
		int packedInt = imgMapa.getRGB(Math.round(e.getX()*Constantes.getConstConversao2()), Math.round((e.getY() + Constantes.getDeslocamento())*Constantes.getConstConversao() - Constantes.getDeslocamento()/2));
		Color color = new Color(packedInt, true);

		//      System.out.printf("(%d,%d,%d)\n", color.getRed(),color.getGreen(),color.getBlue());
		//System.out.printf("new Point(%d,%d),", Math.round(e.getX()*Constantes.constConversaoX), Math.round(e.getY()*Constantes.constConversaoY));

		int j;
		for(j=0 ; j<6 && mundo.getContinentes()[j].getCor().equals(new Cor(color.getRed(),color.getGreen(),color.getBlue())) == false;j++){
			//			System.out.printf("%d %d %d - %d %d %d\n", mundo.getContinentes()[j].getCor().getR(),mundo.getContinentes()[j].getCor().getG(),mundo.getContinentes()[j].getCor().getB(),color.getRed(),color.getGreen(),color.getBlue());
		}

		if(j<6 && mundo.getContinentes()[j].getCor().equals(new Cor(color.getRed(),color.getGreen(),color.getBlue())) == true){
			return ControladorMapa.percorre(e, j);
		}

		else{
			for(int k=0 ; k<mundo.getContinentes().length ; k++){
				String aux = ControladorMapa.percorre(e, k);
				if(aux != null){
					return aux;
				}
			}
		}

		return null;
	}

	private static String percorre(MouseEvent e, int j){

		for(int i=0 ; i<mundo.getContinentes()[j].getTerritorios().length ; i++){
			if(mundo.getContinentes()[j].getTerritorios()[i].getPoligono().dentroPolig(new Point( Math.round(e.getX()/Constantes.getConstConversaoX()),Math.round((e.getY())/Constantes.getConstConversaoY())+ Constantes.getDeslocamento2()-Constantes.getConstMagica())) == true){
				System.out.println(mundo.getContinentes()[j].getTerritorios()[i].getNome());
				clicado = mundo.getContinentes()[j].getTerritorios()[i];
				return mundo.getContinentes()[j].getTerritorios()[i].getNome();
			}
		}
		clicado = null;
		return null;
	}

	public static Territorio getTerritorioClicado (){
		return clicado;
	}

	public static ArrayList<Point> colocarBase(String cor, ArrayList<Integer> nExer){
		int index;

		int u;
		for(u=0; u<6 && mundo.getJogadores()[u]!=null ;u++);

		for(index=0;index<u;index++){
			if(mundo.getJogadores()[index]!=null && mundo.getJogadores()[index].getCor().equals(cor)){
				// System.out.println(mundo.getJogadores()[index].getCor() + cor);
				break;
			}
		}
		if(index>=u){
			return null;
		}
		ArrayList<Point> pontos = new ArrayList<Point>();
		
		for( Territorio ter :mundo.getJogadores()[index].getTerritoriosPossuidos() )  {  
			
			Point p = new Point(Math.round(ter.getBase().x*Constantes.constConversaoX-5), Math.round(ter.getBase().y*Constantes.constConversaoY)-Constantes.deslocamento2 - 40);
			pontos.add(p);
			
			nExer.add(ter.getExercitos());
			
		}
		pontos.add(new Point(-50,-50));
		nExer.add(-2);
		
		return pontos;

	}

	public static int nExer(Point p){

		for(int j=0;j<6;j++){
			for(int i=0 ; i<mundo.getContinentes()[j].getTerritorios().length ; i++){
				//System.out.println(mundo.getContinentes()[j].getTerritorios()[i].getBase() + " " +p);
				Point aux = new Point(Math.round(mundo.getContinentes()[j].getTerritorios()[i].getBase().x*Constantes.constConversaoX-5), Math.round(mundo.getContinentes()[j].getTerritorios()[i].getBase().y*Constantes.constConversaoY)-Constantes.deslocamento2 - 40);
				
				if(aux.equals(p)){
					
					return mundo.getContinentes()[j].getTerritorios()[i].getExercitos();
				}
			}
		}
		
		return -1;

	}
	
	public static void addExer(String nome){
		for(int j=0;j<6;j++){
			for(int i=0 ; i<mundo.getContinentes()[j].getTerritorios().length ; i++){
				if(mundo.getContinentes()[j].getTerritorios()[i].getNome().equals(nome)){
					mundo.getContinentes()[j].getTerritorios()[i].exerMais();
					int nExercitosDaVez = mundo.getR().getAtual().getnExercitosDaVez()-1;
					mundo.getR().getAtual().setnExercitosDaVez(nExercitosDaVez);
					System.out.println(mundo.getR().getAtual().getnExercitosDaVez());
					return;
				}
				
			}
		}
	}

	public static boolean permitido(String name) {
		for(Territorio t : mundo.getR().getAtual().getJogador().getTerritoriosPossuidos()){
			if(t.getNome().equals(name)){
				if(mundo.getR().getAtual().getnExercitosDaVez() > 0){
					return true;
				}
			}
		}

		return false;
	
	}

	public static boolean permitidoAtacar(String name) {
		if(ControladorMapa.permitido(name)==true){
			return false;
		}

		for(Territorio t : mundo.getR().getAtual().getJogador().getTerritoriosPossuidos()){
			if(t.getNome().equals(name)){
				if(Rodada.indexRodada > 0){
					return true;
				}
			}
		}


		return false;
	}

	public static boolean permitidoDefender(String name) {
		if(ControladorMapa.permitido(name)==true){
			return false;
		}
		for(Territorio t : mundo.getR().getAtual().getJogador().getTerritoriosPossuidos()){
			if(t.getNome().equals(name)){
				return false;

			}
			//			for(int j=0;j<t.getTerritoriosFronteira().length;j++){
			//				if(!t.getTerritoriosFronteira()[j].equals(name)){
			//					return false;
			//				}
			//			}
			
			//TODO verificar se o territorio faz fronteira com o territorio do jogador defensor
		}

		if(Rodada.indexRodada > 0){
			return true;
		}
		else{
			return false;
		}
	}

	


}
