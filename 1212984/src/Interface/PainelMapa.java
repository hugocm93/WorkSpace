package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import Mapa.*;
import Estruturas.Cor;

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
		
		g.drawImage(img, 0, -80, 1067,800 , null);
		g.finalize();
    }


	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int packedInt = img.getRGB(e.getX()*2 - 1, e.getY()*2 + 80);
		
		Color color = new Color(packedInt, true);
//        System.out.printf("(%d,%d,%d)\n", color.getRed(),color.getGreen(),color.getBlue());
		
		
//		System.out.printf("new Point(%d,%d),", e.getX(), e.getY());
		
		int flag = 0;
		
		for(int j=0 ; j<mundo.getContinentes().length ;j++){
			if(mundo.getContinentes()[j].getCor().equals(new Cor(color.getRed(),color.getGreen(),color.getBlue())) == false){
				//System.out.printf("%d %d %d - %d %d %d\n", mundo.getContinentes()[j].getCor().getR(),mundo.getContinentes()[j].getCor().getG(),mundo.getContinentes()[j].getCor().getB(),color.getRed(),color.getGreen(),color.getBlue());
				continue;
			}
			for(int i=0 ; i<mundo.getContinentes()[j].getTerritorios().length ; i++){
				if(mundo.getContinentes()[j].getTerritorios()[i].getPoligono().dentroPolig(new Point(e.getX(),e.getY()+80)) == true){
					System.out.println(mundo.getContinentes()[j].getTerritorios()[i].getNome());
					flag = 1;
				}
			}
		}
		
		if(flag == 0){
			for(int j=0 ; j<mundo.getContinentes().length ;j++){
				
				for(int i=0 ; i<mundo.getContinentes()[j].getTerritorios().length ; i++){
					if(mundo.getContinentes()[j].getTerritorios()[i].getPoligono().dentroPolig(new Point(e.getX(),e.getY()+80)) == true){
						System.out.println(mundo.getContinentes()[j].getTerritorios()[i].getNome());
					}
				}
			}
		}
		
      
		
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

}
