package Controladores;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import Interface.*;
import Modelos.*;

public abstract class Controlador {

	private static JFrame janela;
	private static PainelTelaInicial painelTelaInicial;
	private static PainelMapa painelMapa;
	private static Mundo mundo;

	public static void criaMundo(){
		mundo = new Mundo();
	}
	
	public static void criaJanela(){

		janela = new JFrame("War");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		janela.setVisible(true);
		
		Controlador.criaPainelTelaInicial();
		Controlador.irPainelTelaInicial();
	}

	public static void criaPainelMapa(){
		painelMapa = new PainelMapa();

	}
	
	public static void irPainelMapa(){
		janela.add(painelMapa);
		janela.addMouseListener(painelMapa);
		painelMapa.setVisible(true);

		if(painelTelaInicial!=null)
			painelTelaInicial.setVisible(false);
	}

	public static void criaPainelTelaInicial(){
		painelTelaInicial = new PainelTelaInicial();

	}
	
	public static void irPainelTelaInicial(){
		janela.add(painelTelaInicial);
		painelTelaInicial.setVisible(true);

		janela.setSize(Constantes.getLargura(), Constantes.getAltura());
	}
	
	public static void detectaTerritorio(MouseEvent e, BufferedImage imgMapa){
		int packedInt = imgMapa.getRGB(Math.round(e.getX()*Constantes.getConstConversao2()), Math.round((e.getY() + Constantes.getDeslocamento())*Constantes.getConstConversao() - Constantes.getDeslocamento()/2));
		Color color = new Color(packedInt, true);
		
//      System.out.printf("(%d,%d,%d)\n", color.getRed(),color.getGreen(),color.getBlue());
//		System.out.printf("new Point(%d,%d),", Math.round(e.getX()*constConversaoX), Math.round(e.getY()*constConversaoY));
		
		int j;
		for(j=0 ; j<6 && mundo.getContinentes()[j].getCor().equals(new Cor(color.getRed(),color.getGreen(),color.getBlue())) == false;j++){
//			System.out.printf("%d %d %d - %d %d %d\n", mundo.getContinentes()[j].getCor().getR(),mundo.getContinentes()[j].getCor().getG(),mundo.getContinentes()[j].getCor().getB(),color.getRed(),color.getGreen(),color.getBlue());
		}
		
		if(j<6 && mundo.getContinentes()[j].getCor().equals(new Cor(color.getRed(),color.getGreen(),color.getBlue())) == true){
			Controlador.percorre(e, j);
		}
		
		else{
			for(int k=0 ; j<mundo.getContinentes().length ;k++)
				Controlador.percorre(e, k);
		}
	}
	
	private static boolean percorre(MouseEvent e, int j){
		for(int i=0 ; i<mundo.getContinentes()[j].getTerritorios().length ; i++){
			if(mundo.getContinentes()[j].getTerritorios()[i].getPoligono().dentroPolig(new Point( Math.round(e.getX()/Constantes.getConstConversaoX()),Math.round((e.getY())/Constantes.getConstConversaoY())+ Constantes.getDeslocamento2()-Constantes.getConstMagica())) == true){
				System.out.println(mundo.getContinentes()[j].getTerritorios()[i].getNome());
				return true;
			}
		}
		return false;
	}



}
