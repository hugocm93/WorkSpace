package Interface;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controladores.ControladorInicial;
import Controladores.ControladorFluxo;

import org.imgscalr.Scalr;

public class PainelTelaInicial extends JPanel implements ActionListener, FocusListener, Observer{

	private static final long serialVersionUID = 1L;
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/zImagens/Background/";
	private String path3 = "/src/zImagens/Pinos/";
	private BufferedImage imgMapa;
	private BufferedImage imgTitulo;
	private BufferedImage imgPlay;
	private BufferedImage[] pinos = new BufferedImage[6];;
	private JButton botaoPlay = new JButton();
	private JTextField[] jogadoresTexto  = new JTextField[]{new JTextField(20),new JTextField(20),new JTextField(20),new JTextField(20),new JTextField(20),new JTextField(20)};
	private String[] cores;
	private int nJogadores=0;

	public PainelTelaInicial(){


		try {
			File imgMapaFile = new File(path1 + path2 + "war_tabuleiro_fundo.png");
			imgMapa = ImageIO.read(imgMapaFile);

			File imgTituloFile = new File(path1 + path2 + "war_titulo.png");
			imgTitulo = ImageIO.read(imgTituloFile);

			File imgPlayFile = new File(path1 + path2 + "war_play.png");
			imgPlay = ImageIO.read(imgPlayFile);

			cores = new String[]{"vermelho.png","verde.png","amarelo.png","azul.png","branco.png","preto.png"};
			File[] imgPinoFile = new File[]{new File(path1 + path3 + cores[0]),new File(path1 + path3 + cores[1]),new File(path1 + path3 + cores[2]),new File(path1 + path3 + cores[3]),new File(path1 + path3 + cores[4]),new File(path1 + path3 + cores[5])};

			for(int i=0;i<6;i++){
				pinos[i] = ImageIO.read(imgPinoFile[i]);
			}
		}

		catch (IOException e) {
			System.out.println("Imagem não encontrada.");
		}

		botaoPlay.setIcon(new ImageIcon(Scalr.resize(imgPlay, 100)));
		botaoPlay.addActionListener(this);
		this.add(botaoPlay);
		botaoPlay.setVisible(true);
		botaoPlay.setOpaque(false);
		botaoPlay.setContentAreaFilled(false);
		botaoPlay.setBorderPainted(false);

		for(int i=0;i<2;i++){
			for(int j=0;j<3;j++){
				this.add(jogadoresTexto[j+i*3]);
				jogadoresTexto[j+i*3].setVisible(true);
				jogadoresTexto[j+i*3].addFocusListener(this);

			}
		}

		this.repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);

		g.drawImage(imgMapa, 0, - Constantes.getDeslocamento(), Constantes.getLargura(), Constantes.getAltura() , null);
		g.drawImage(imgTitulo, 0, -5, Constantes.getLargura() + 5,Math.round(imgTitulo.getHeight()/Constantes.getConstConversao()) , null);
		botaoPlay.setBounds(Constantes.getLargura() - imgPlay.getWidth()/3 ,  Constantes.getAltura() - imgPlay.getHeight()/2, imgPlay.getWidth()/4, imgPlay.getHeight()/4);

		for(int i=0;i<2;i++){
			for(int j=0;j<3;j++){

				g.drawImage(pinos[j+i*3], i*400+70, j*170+150, 65, 65 , null);
				jogadoresTexto[j+i*3].setBounds(i*400+150,j*170+170,170,30);

				if(jogadoresTexto[j+i*3].getText().equals(String.format("Nome do jogador %d", j+i*3+1))==true || jogadoresTexto[j+i*3].getText().equals(String.format(""))==true){
					jogadoresTexto[j+i*3].setText(String.format("Nome do jogador %d", j+i*3+1));
				}
			}
		}
		g.finalize();
	}

	public void actionPerformed(ActionEvent e) {
		nJogadores = 0;
		if(e.getSource() == botaoPlay){

			for(int i=0;i<2;i++){
				for(int j=0;j<3;j++){					
					if(jogadoresTexto[j+i*3].getText().equals(String.format("Nome do jogador %d", j+i*3+1))==false && jogadoresTexto[j+i*3].getText().equals(String.format(""))==false){
						nJogadores++;
					}
				}
			}

			if(nJogadores>=3){
				for(int i=0 ; i<6;i++){
					if(jogadoresTexto[i].getText().equals(String.format("Nome do jogador %d", i+1))==false && (jogadoresTexto[i].getText().equals(String.format(""))==false)){
						ControladorInicial.criaNovoJogador(jogadoresTexto[i].getText(), cores[i]);
					}	
				}
				ControladorInicial.calculaJogadores();
				ControladorFluxo.testarObserver();
				ControladorInicial.sortSequencia();	//sorteando a sequencia
				ControladorInicial.distribuiObjetivos();
				ControladorInicial.sortearTerritorios();
				ControladorInicial.criaTurnos();
				ControladorFluxo.criaPainelMapa();
				ControladorInicial.verificaContinentes();
				ControladorFluxo.irPainelMapa();

			}
			else{
				JOptionPane.showMessageDialog(this, "O numero minimo de jogadores eh 3.");
				
			}
		}
	}

	public void focusGained(FocusEvent e) {

		if(e.getSource() == jogadoresTexto[0]){
			jogadoresTexto[0].setText(" ");
		}
		if(e.getSource() == jogadoresTexto[1]){
			jogadoresTexto[1].setText(" ");
		}
		if(e.getSource() == jogadoresTexto[2]){
			jogadoresTexto[2].setText(" ");
		}
		if(e.getSource() == jogadoresTexto[3]){
			jogadoresTexto[3].setText(" ");
		}
		if(e.getSource() == jogadoresTexto[4]){
			jogadoresTexto[4].setText(" ");
		}
		if(e.getSource() == jogadoresTexto[5]){
			jogadoresTexto[5].setText(" ");
		}
	}

	public void focusLost(FocusEvent e) {

	}

	@Override
	public void update(Object obj) {
		
		if(nJogadores == 3){
			System.out.println("Temos 3 jogadores!");
		}
		if(nJogadores == 4){
			System.out.println("Temos 4 jogadores!");
		}
		if(nJogadores == 5){
			System.out.println("Temos 5 jogadores!");
		}
		if(nJogadores ==6){
			System.out.println("Temos 6 jogadores!");
		}
		
	}

}
