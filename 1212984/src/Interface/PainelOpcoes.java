package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.imgscalr.Scalr;

import Controladores.ControladorFluxo;
import Controladores.ControladorPainelOpcoes;

public class PainelOpcoes extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton botaoDado = new JButton();
	private JButton botaoFimDaJogada = new JButton();
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/zImagens/Background/";
	private String path3 = "/src/zImagens/Dados/";
	private String path4 = "/src/zImagens/Botoes/";
	private String path5 = "/src/zImagens/Pinos/";
	private BufferedImage imgFimDaJogada;
	private BufferedImage imgFundo;
	private BufferedImage imgDados;
	private BufferedImage imgJogador;
	private JLabel nomeJogador;

	public PainelOpcoes(){

		try {
			File imgMapaFile = new File(path1 + path2 + "war_tabuleiro_fundo.png");
			imgFundo = ImageIO.read(imgMapaFile);

			File imgPlayFile = new File(path1 + path3 + "botaoDados.png");
			imgDados = ImageIO.read(imgPlayFile);

			File imgPlayFile1 = new File(path1 + path4 + "botaoFimDaJogada.png");
			imgFimDaJogada = ImageIO.read(imgPlayFile1);
			
			File imgJogadorFile = new File(path1 + path5 + ControladorPainelOpcoes.jogadorAtual("cor"));
			imgJogador = ImageIO.read(imgJogadorFile);
			
		}
		catch (IOException e) {
			System.out.println("Imagem não encontrada.");
		}

		this.setPreferredSize(new Dimension(1024,125));
		this.setLayout(new FlowLayout());

		botaoFimDaJogada.setIcon(new ImageIcon(imgFimDaJogada));
		botaoFimDaJogada.setOpaque(false);
		botaoFimDaJogada.setContentAreaFilled(false);
		botaoFimDaJogada.setBorderPainted(false);
		botaoFimDaJogada.addActionListener(this);
		this.add(botaoFimDaJogada);
		botaoFimDaJogada.setVisible(true);

		botaoDado.setIcon(new ImageIcon(Scalr.resize(imgDados, 50)));
		botaoDado.setSize(50, 50);
		botaoDado.setVisible(true);
		botaoDado.setOpaque(false);
		botaoDado.setContentAreaFilled(false);
		botaoDado.setBorderPainted(false);
		botaoDado.addActionListener(this);
		this.add(botaoDado);
		botaoDado.setVisible(true);
		
		nomeJogador = new JLabel();
		nomeJogador.setForeground(Color.white);
		nomeJogador.setText(ControladorPainelOpcoes.jogadorAtual("nome"));
        nomeJogador.setVisible(true);
        this.add(nomeJogador);
        
		this.setVisible(true);
		this.repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);

		g.drawImage(imgFundo, 0, 0, Constantes.getLargura(), 200 , null);
		botaoFimDaJogada.setBounds(Constantes.getLargura() -160,30 ,130, 50);
		g.drawImage(imgJogador, 20, 20, 65, 65 , null);
		nomeJogador.setBounds(20, 88, 150, 20);
		
		File imgJogadorFile = new File(path1 + path5 + ControladorPainelOpcoes.jogadorAtual("cor"));
		try {
			imgJogador = ImageIO.read(imgJogadorFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		nomeJogador.setText(ControladorPainelOpcoes.jogadorAtual("nome"));
		
		g.finalize();
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoDado){
			ControladorFluxo.novoFrameDados();
		}
		if(e.getSource() == botaoFimDaJogada){
			ControladorFluxo.novoFrameFimDaJogada();
		}

	}

}
