package Interface;


import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Mapa.Mundo;

public class PainelTelaInicial extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	private Mundo mundo = Mundo.getInstance();
	
	private int largura = 1024;
	private int altura = 768;
	private int constMagica = 0;
	
//	private int largura = 800;
//	private int altura = 600;
//	private int constMagica = 10;
	
	
	private int largImg = 2133;
	private int altImg = 1600;
	
	private float constConversao = (float)altImg/altura;
	private float constConversao2 = (float)largImg/largura;
	private float constConversaoX = (float)largura/1067;
	private float constConversaoY = (float)altura/800;
	
	private int deslocamento = Math.round(80*constConversaoY);
	private int deslocamento2 = 80;
	
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/Imagens/Mapas/";
	private String path3 = "/src/Imagens/Background/";
	private BufferedImage imgMapa;
	private BufferedImage imgTitulo;

	
	
	public PainelTelaInicial(){
		
		
		try {
			
			File imgMapaFile = new File(path1 + path3 + "war_tabuleiro_fundo.png");
			imgMapa = ImageIO.read(imgMapaFile);
			
			File imgTituloFile = new File(path1 + path3 + "war_titulo.png");
			imgTitulo = ImageIO.read(imgTituloFile);
			
		}
		
		catch (IOException e) {
			
			System.out.println("Imagem não encontrada.");
			
		}
		
		this.repaint();

		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.drawImage(imgMapa, 0, - deslocamento, largura,altura , null);
		g.drawImage(imgTitulo, 0, -5, largura + 5,Math.round(imgTitulo.getHeight()/constConversao) , null);
		
		g.finalize();
    }

	
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public void mouseClicked(MouseEvent e) {
		
		
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}


}