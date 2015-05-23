package Interface;

import java.awt.HeadlessException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.*;


public class Tabuleiro extends JFrame{
	
	private BufferedImage img;
	
	public Tabuleiro(String title) throws HeadlessException {
		super(title);
		
		try {
			File obj1 = new File("war_tabuleiro_com_nomes.png");
			System.out.println(obj1.getAbsolutePath() + "--->" +obj1.getCanonicalPath());
			
		    img = ImageIO.read(obj1);
		    
		} 
		catch (IOException e) {
			System.out.println("Imagem não encontrada.");
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.drawImage(img, 0, 0, this);
    }
	
	
}
