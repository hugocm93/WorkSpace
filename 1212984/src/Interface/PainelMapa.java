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
	
	private int largura = 1024;
	private int altura = 768;
	
	
	private int largImg = 2133;
	private int altImg = 1600;
	
	private float constConversao = (float)altImg/altura;
	private float constConversaoX = (float)largura/1067;
	private float constConversaoY = (float)altura/800;
	
	private int deslocamento = Math.round(80*constConversaoY);
	private int deslocamento2 = 80;
	

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.drawImage(img, 0, - deslocamento, largura,altura , null);
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
		// TODO Auto-generated method stub
		
		int packedInt = img.getRGB(Math.round(e.getX()*constConversao), Math.round((e.getY() + deslocamento)*constConversao - deslocamento/2));
		
		Color color = new Color(packedInt, true);
//        System.out.printf("(%d,%d,%d)\n", color.getRed(),color.getGreen(),color.getBlue());
		
		
//		System.out.printf("new Point(%d,%d),", Math.round(e.getX()*constConversaoX), Math.round(e.getY()*constConversaoY));
		
		
		int flag = 0;
		
		for(int j=0 ; j<mundo.getContinentes().length ;j++){
			if(mundo.getContinentes()[j].getCor().equals(new Cor(color.getRed(),color.getGreen(),color.getBlue())) == false){
				//System.out.printf("%d %d %d - %d %d %d\n", mundo.getContinentes()[j].getCor().getR(),mundo.getContinentes()[j].getCor().getG(),mundo.getContinentes()[j].getCor().getB(),color.getRed(),color.getGreen(),color.getBlue());
				continue;
			}
			for(int i=0 ; i<mundo.getContinentes()[j].getTerritorios().length ; i++){
				if(mundo.getContinentes()[j].getTerritorios()[i].getPoligono().dentroPolig(new Point( Math.round(e.getX()/constConversaoX),Math.round(e.getY()/constConversaoY+deslocamento2))) == true){
					System.out.println(mundo.getContinentes()[j].getTerritorios()[i].getNome());
					flag = 1;
				}
			}
		}
		
		if(flag == 0){
			for(int j=0 ; j<mundo.getContinentes().length ;j++){
				for(int i=0 ; i<mundo.getContinentes()[j].getTerritorios().length ; i++){
					if(mundo.getContinentes()[j].getTerritorios()[i].getPoligono().dentroPolig(new Point(Math.round(e.getX()/constConversaoX),Math.round(e.getY()/constConversaoY+deslocamento2))) == true){
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
