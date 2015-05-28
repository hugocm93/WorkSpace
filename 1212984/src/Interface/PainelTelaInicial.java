package Interface;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controladores.Controlador;

import org.imgscalr.Scalr;

public class PainelTelaInicial extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/zImagens/Background/";
	private String path3 = "/src/zImagens/Pinos/";
	private BufferedImage imgMapa;
	private BufferedImage imgTitulo;
	private BufferedImage imgPlay;
	private BufferedImage[] pinos = new BufferedImage[6];;
	private JButton botaoPlay = new JButton();
	
	public PainelTelaInicial(){
		
		try {
			File imgMapaFile = new File(path1 + path2 + "war_tabuleiro_fundo.png");
			imgMapa = ImageIO.read(imgMapaFile);
			
			File imgTituloFile = new File(path1 + path2 + "war_titulo.png");
			imgTitulo = ImageIO.read(imgTituloFile);
			
			File imgPlayFile = new File(path1 + path2 + "war_play.png");
			imgPlay = ImageIO.read(imgPlayFile);
			
			File[] imgPinoFile = new File[]{new File(path1 + path3 + "vermelho.png"),new File(path1 + path3 + "verde.png"),new File(path1 + path3 + "amarelo.png"),new File(path1 + path3 + "azul.png"),new File(path1 + path3 + "branco.png"),new File(path1 + path3 + "preto.png")};
			
			for(int i=0;i<6;i++){
				pinos[i] = ImageIO.read(imgPinoFile[i]);
			}
		}
		
		catch (IOException e) {
			System.out.println("Imagem não encontrada.");
		}
		
		botaoPlay.setIcon(new ImageIcon(Scalr.resize(imgPlay, 100)));
		botaoPlay.addActionListener(this);
		botaoPlay.setBounds( 200, 200  ,50 ,50 );
		this.add(botaoPlay);
		botaoPlay.setVisible(true);
		botaoPlay.setOpaque(false);
		botaoPlay.setContentAreaFilled(false);
		botaoPlay.setBorderPainted(false);

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
			}
		}
		g.finalize();
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoPlay){
			Controlador.criaPainelMapa();
			Controlador.irPainelMapa();
		}
	}
}
