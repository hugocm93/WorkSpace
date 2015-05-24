package Interface;

import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.*;

public class Tabuleiro extends JFrame{
	
	static final long serialVersionUID = 1L;
	private BufferedImage imgMapa;
	private PainelMapa painelMapa = new PainelMapa();
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/Imagens/Mapas/";
	
	public Tabuleiro(String title) throws HeadlessException {
		super(title);
		
		this.add(painelMapa);
		this.addMouseListener(painelMapa);
		painelMapa.setVisible(true);
		
		try {
			
			File imgMapaFile = new File(path1 + path2 + "war_tabuleiro_com_nomes.png");
			imgMapa = ImageIO.read(imgMapaFile);
			
		}
		
		catch (IOException e) {
			
			System.out.println("Imagem não encontrada.");
			
		}
		
		painelMapa.setImg(imgMapa);
		painelMapa.repaint();
		
	}
	
}