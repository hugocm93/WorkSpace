package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Mapa.*;
import Estruturas.Cor;
import Estruturas.Constantes;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PainelMapa extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	private Mundo mundo = Mundo.getInstance();
		
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/Imagens/Mapas/";
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
		
		int packedInt = imgMapa.getRGB(Math.round(e.getX()*Constantes.getConstConversao2()), Math.round((e.getY() + Constantes.getDeslocamento())*Constantes.getConstConversao() - Constantes.getDeslocamento()/2));
		Color color = new Color(packedInt, true);
		
//      System.out.printf("(%d,%d,%d)\n", color.getRed(),color.getGreen(),color.getBlue());
//		System.out.printf("new Point(%d,%d),", Math.round(e.getX()*constConversaoX), Math.round(e.getY()*constConversaoY));
		
		int j;
		for(j=0 ; mundo.getContinentes()[j].getCor().equals(new Cor(color.getRed(),color.getGreen(),color.getBlue())) == false ;j++){
//			System.out.printf("%d %d %d - %d %d %d\n", mundo.getContinentes()[j].getCor().getR(),mundo.getContinentes()[j].getCor().getG(),mundo.getContinentes()[j].getCor().getB(),color.getRed(),color.getGreen(),color.getBlue());
		}
		
		if(mundo.getContinentes()[j].getCor().equals(new Cor(color.getRed(),color.getGreen(),color.getBlue())) == true){
			this.percorre(e, j);
		}
		
		else{
			for(int k=0 ; j<mundo.getContinentes().length ;k++)
				this.percorre(e, k);
		}
				
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	private boolean percorre(MouseEvent e, int j){
		for(int i=0 ; i<mundo.getContinentes()[j].getTerritorios().length ; i++){
			if(mundo.getContinentes()[j].getTerritorios()[i].getPoligono().dentroPolig(new Point( Math.round(e.getX()/Constantes.getConstConversaoX()),Math.round((e.getY())/Constantes.getConstConversaoY())+ Constantes.getDeslocamento2()-Constantes.getConstMagica())) == true){
				System.out.println(mundo.getContinentes()[j].getTerritorios()[i].getNome());
				return true;
			}
		}
		return false;
	}

}
