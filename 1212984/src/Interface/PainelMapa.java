package Interface;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import Mapa.*;

import javax.swing.*;

public class PainelMapa extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	private BufferedImage img;
	private Mundo mundo = new Mundo();
	
	
	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.drawImage(img, 0, 0, 1067,800 , null);
		g.finalize();
    }


	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

}
