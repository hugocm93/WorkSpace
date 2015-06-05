package Controladores;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Interface.Constantes;
import Interface.FrameDados;
import Interface.FrameFimDaJogada;
import Interface.PainelMapa;
import Interface.PainelOpcoes;
import Interface.PainelTelaInicial;

public class ControladorFluxo {
	
	private static JFrame janela;
	private static FrameDados frameDados;
	private static FrameFimDaJogada frameFimDaJogada;
	private static PainelTelaInicial painelTelaInicial;
	private static PainelMapa painelMapa;
	private static PainelOpcoes painelOpcoes;
	
	public static void criaJanela(){

		janela = new JFrame("War");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		janela.setVisible(true);
		janela.setResizable(false);


		//Controlador.criaPainelTelaInicial();
		//Controlador.irPainelTelaInicial();
		ControladorFluxo.criaPainelMapa();
		ControladorFluxo.irPainelMapa();

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


}
