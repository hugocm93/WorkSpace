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
import Estruturas.Constantes;

public class PainelTelaInicial extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	private Mundo mundo = Mundo.getInstance();
		
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/Imagens/Mapas/";
	private String path3 = "/src/Imagens/Background/";
	private BufferedImage imgMapa;
	private BufferedImage imgTitulo;
	private BufferedImage imgPlay;

	public PainelTelaInicial(){
		
		try {
			
			File imgMapaFile = new File(path1 + path3 + "war_tabuleiro_fundo.png");
			imgMapa = ImageIO.read(imgMapaFile);
			
			File imgTituloFile = new File(path1 + path3 + "war_titulo.png");
			imgTitulo = ImageIO.read(imgTituloFile);
			
			File imgPlayFile = new File(path1 + path3 + "war_play.png");
			imgPlay = ImageIO.read(imgPlayFile);
			
		}
		
		catch (IOException e) {
			
			System.out.println("Imagem não encontrada.");
			
		}
		
		this.repaint();

	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.drawImage(imgMapa, 0, - Constantes.getDeslocamento(), Constantes.getLargura(), Constantes.getAltura() , null);
		g.drawImage(imgTitulo, 0, -5, Constantes.getLargura() + 5,Math.round(imgTitulo.getHeight()/Constantes.getConstConversao()) , null);
		g.drawImage(imgPlay, Constantes.getLargura() - imgPlay.getWidth()/3 ,  Constantes.getAltura() - imgPlay.getHeight()/2, imgPlay.getWidth()/4, imgPlay.getHeight()/4 , null);
		
		g.finalize();
    }


	public void mouseClicked(MouseEvent e) {
		
		
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}


}
