package Controladores;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Interface.Constantes;
import Interface.FrameConquistouTerritorio;
import Interface.FrameDados;
import Interface.FrameFimDaJogada;
import Interface.FrameFimDoJogo;
import Interface.FrameObjetivo;
import Interface.PainelMapa;
import Interface.PainelOpcoes;
import Interface.PainelTelaInicial;
import Interface.FrameTerritorio;

public class ControladorFluxo {

	public static  JFrame janela;
	private static FrameDados frameDados;
	private static FrameFimDaJogada frameFimDaJogada;
	private static FrameFimDoJogo frameFimDoJogo;
	private static FrameObjetivo frameObjetivo;
	private static FrameConquistouTerritorio frameConquistouTerritorio;
	private static PainelTelaInicial painelTelaInicial;
	public static  PainelMapa painelMapa;
	private static PainelOpcoes painelOpcoes;
	private static FrameTerritorio frameTerritorio;
	
	public static void criaJanela(){

		janela = new JFrame("War");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		janela.setVisible(true);
		janela.setResizable(false);

		ControladorFluxo.criaPainelTelaInicial();
		ControladorFluxo.irPainelTelaInicial();
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

		janela.setSize(Constantes.getLargura(), Constantes.getAltura()-15);
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
		else if(frameDados.isVisible() == false){
			frameDados = new FrameDados();
		}

		frameDados.setBounds((int)janela.getLocation().getX()+janela.getWidth()/2-100,(int)janela.getLocation().getY()+janela.getHeight()/2-110,200,220);
		frameDados.setVisible(true);
		frameDados.setResizable(false);
	}

	public static void novoFrameFimDaJogada(){
		if(frameFimDaJogada==null){
			frameFimDaJogada = new FrameFimDaJogada();
		}
		else if(frameFimDaJogada.isVisible() == false){
			frameFimDaJogada = new FrameFimDaJogada();
		}

		frameFimDaJogada.setBounds((int)janela.getLocation().getX()+janela.getWidth()/2-110,(int)janela.getLocation().getY()+janela.getHeight()/2-50,220,100);
		frameFimDaJogada.setVisible(true);
		frameFimDaJogada.setResizable(false);
	}

	public static void novoFrameConquistouTerritorio(){

		if(frameConquistouTerritorio==null){
			frameConquistouTerritorio = new FrameConquistouTerritorio();
		}
		else if(frameConquistouTerritorio.isVisible() == false){
			frameConquistouTerritorio = new FrameConquistouTerritorio();
		}

		frameConquistouTerritorio.setBounds((int)janela.getLocation().getX()+janela.getWidth()/2-100,(int)janela.getLocation().getY()+janela.getHeight()/2-110,500,100);
		frameConquistouTerritorio.setVisible(true);
		frameConquistouTerritorio.setResizable(false);
	}

	public static void novoFrameGanhouOJogo(){
		frameFimDoJogo = new FrameFimDoJogo();

		frameFimDoJogo.setBounds((int)janela.getLocation().getX()+janela.getWidth()/2-100,(int)janela.getLocation().getY()+janela.getHeight()/2-110,500,100);
		frameFimDoJogo.setVisible(true);
		frameFimDoJogo.setResizable(false);
		janela.setEnabled(false);
		frameFimDaJogada.setVisible(false);
	}

	public static void novoFrameObjetivo(){
		frameObjetivo = new FrameObjetivo();
		frameObjetivo.setBounds(0, 0, 440, 725);
		frameObjetivo.setVisible(true);
		frameObjetivo.setResizable(false);
	}
	
	public static void novoFrameTerritorio(){

		if(frameTerritorio==null){
			frameTerritorio = new FrameTerritorio();
		}
		else if(frameTerritorio.isVisible() == false){
			frameTerritorio = new FrameTerritorio();
		}

		frameTerritorio.setBounds(0,0,440,725);
		frameTerritorio.setVisible(true);
		frameTerritorio.setResizable(false);
	}
}
