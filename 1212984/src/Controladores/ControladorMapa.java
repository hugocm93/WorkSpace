package Controladores;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import Interface.Constantes;
import Modelos.Cor;
import Modelos.Mundo;
import Modelos.Territorio;

public class ControladorMapa {

	private static Mundo mundo = Mundo.getInstance();
	private static Territorio clicado ;

	public static String detectaTerritorio(MouseEvent e, BufferedImage imgMapa){
		int packedInt = imgMapa.getRGB(Math.round(e.getX()*Constantes.getConstConversao2()), Math.round((e.getY() + Constantes.getDeslocamento())*Constantes.getConstConversao() - Constantes.getDeslocamento()/2));
		Color color = new Color(packedInt, true);

		//      System.out.printf("(%d,%d,%d)\n", color.getRed(),color.getGreen(),color.getBlue());
		//		System.out.printf("new Point(%d,%d),", Math.round(e.getX()*constConversaoX), Math.round(e.getY()*constConversaoY));

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

}