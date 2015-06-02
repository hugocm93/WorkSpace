package Controladores;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

import Interface.*;
import Modelos.*;

public abstract class Controlador {

	private static JFrame janela;
	private static FrameDados frameDados;
	private static FrameFimDaJogada frameFimDaJogada;
	private static PainelTelaInicial painelTelaInicial;
	private static PainelMapa painelMapa;
	private static PainelOpcoes painelOpcoes;
	private static Mundo mundo;
	private static Territorio clicado ;
	private static Dado ataqueOuDefesa ;
	public static void criaMundo(){
		mundo = new Mundo();
		ataqueOuDefesa = new Dado();
	}





	//////Inicio dos metodos relacionados com o fluxo de execucao******************************
	public static void criaJanela(){

		janela = new JFrame("War");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		janela.setVisible(true);


		//Controlador.criaPainelTelaInicial();
		//Controlador.irPainelTelaInicial();
		Controlador.criaPainelMapa();
		Controlador.irPainelMapa();

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

		janela.setSize(Constantes.getLargura(), Constantes.getAltura());
	}

	public static void criaPainelTelaInicial(){
		painelTelaInicial = new PainelTelaInicial();

	}

	public static void irPainelTelaInicial(){
		janela.add(painelTelaInicial);
		painelTelaInicial.setVisible(true);

		janela.setSize(Constantes.getLargura(), Constantes.getAltura());
	}

	public static void criaPainelOpcoes(){
		painelOpcoes = new PainelOpcoes();

	}

	public static void irPainelOpcoes(){

		janela.add(painelOpcoes, BorderLayout.SOUTH );
		painelOpcoes.setVisible(true);

	}

	public static void novoFrameDados(){

		if(frameDados==null){
			frameDados = new FrameDados();
		}

		frameDados.setBounds((int)janela.getLocation().getX()+janela.getWidth()/2-100,(int)janela.getLocation().getY()+janela.getHeight()/2-110,200,220);
		frameDados.setVisible(true);
	}

	public static void novoFrameFimDaJogada(){
		if(frameFimDaJogada==null){
			frameFimDaJogada = new FrameFimDaJogada();
		}

		frameFimDaJogada.setBounds((int)janela.getLocation().getX()+janela.getWidth()/2-110,(int)janela.getLocation().getY()+janela.getHeight()/2-50,220,100);
		frameFimDaJogada.setVisible(true);
	}

	//////Fim dos metodos relacionados com o fluxo de execucao******************************






	//////Inicio dos metodos relacionados com o painelMapa************************************************
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
				clicado = mundo.getContinentes()[j].getTerritorios()[i];
				return true;
			}
		}
		clicado = null;
		return false;
	}

	public static Territorio getTerritorioClicado (){
		return clicado;
	}
	//////Fim dos metodos relacionados com o painelMapa*************************************************





	//////Inicio dos metodos relacionados com o painelTelaInicial************************************************
	public static void criaNovoJogador(String nome, String cor){
		mundo.insereNovoJogador(new Jogador(nome, cor, null, null, null, null));
	}
	//////Inicio dos metodos relacionados com o painelTelaInicial************************************************






	//////Inicio dos metodos relacionados com o frameDados************************************************
	public static Boolean getAtaqueOuDefesa (){
		return ataqueOuDefesa.getAtaqueOuDefesa();
	}

	public static ArrayList<Dado> jogarDadosAtaque(){

		ArrayList <Dado> ret = new ArrayList <Dado>();
		Dado dado1 = new Dado(); Dado dado2 = new Dado(); Dado dado3 = new Dado();
		Dado dado4 = new Dado(); Dado dado5 = new Dado(); Dado dado6 = new Dado();
		Boolean ataqueOuDefesa = Controlador.getAtaqueOuDefesa();
		int valorDado1, valorDado2, valorDado3, valorDado4, valorDado5, valorDado6;
		//int exercitos = Controlador.getTerritorioClicado().getExercitos();
		int exercitos = 4;
		if (ataqueOuDefesa == true){
			if(exercitos > 3){
				valorDado1 = dado1.rolar_dado();
				dado1.imgDado();
				valorDado2 = dado2.rolar_dado();
				dado2.imgDado();
				valorDado3 = dado3.rolar_dado();
				dado3.imgDado();

				ret.add(dado1);	ret.add(dado2); ret.add(dado3);
			}
			else if(exercitos == 3){
				valorDado1 = dado1.rolar_dado();
				dado1.imgDado();
				valorDado2 = dado2.rolar_dado();
				dado2.imgDado();

				ret.add(dado1);	ret.add(dado2);
			}
			else if(exercitos == 2){
				valorDado1 = dado1.rolar_dado();
				dado1.imgDado();

				ret.add(dado1);
			}
			ataqueOuDefesa = false;
		}

		if (ataqueOuDefesa == false){
			if(exercitos >= 3){
				valorDado4 = dado4.rolar_dado();
				dado4.imgDado();
				valorDado5 = dado5.rolar_dado();
				dado5.imgDado();
				valorDado6 = dado6.rolar_dado();
				dado6.imgDado();

				ret.add(dado4);	ret.add(dado5); ret.add(dado6);
			}
			else if(exercitos == 2){
				valorDado4 = dado4.rolar_dado();
				dado4.imgDado();
				valorDado5 = dado5.rolar_dado();
				dado5.imgDado();

				ret.add(dado4);	ret.add(dado5);
			}
			else if(exercitos == 1){
				valorDado4 = dado4.rolar_dado();
				dado4.imgDado();

				ret.add(dado4);	
			}
			ataqueOuDefesa = true;
		}

		return ret;
	}
	//////Fim dos metodos relacionados com o frameDados************************************************

}
