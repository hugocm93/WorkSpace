package Interface;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Controladores.Controlador;

public class PainelMapa extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/zImagens/Mapas/";
	private BufferedImage imgMapa;
	
	public PainelMapa(){
		try {
			File imgMapaFile = new File(path1 + path2 + "war_tabuleiro_com_nomes.png");
			imgMapa = ImageIO.read(imgMapaFile);
		}
		catch (IOException e) {
			System.out.println("Imagem não encontrada.");
		}
		
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.drawImage(imgMapa, 0, - Constantes.getDeslocamento(), Constantes.getLargura(), Constantes.getAltura() , null);
		g.finalize();
	}

	public void mouseClicked(MouseEvent e) {
		Controlador.detectaTerritorio(e, imgMapa);
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	

}
