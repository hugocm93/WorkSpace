package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import org.imgscalr.Scalr;
import Controladores.ControladorFluxo;
import Controladores.ControladorMapa;
import Controladores.ControladorPainelOpcoes;

public class PainelMapa extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;

	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/zImagens/Mapas/";
	private String path5 = "/src/zImagens/Pinos/";
	private BufferedImage[] imgPinos = new BufferedImage[6];
	private String[] cores = ControladorPainelOpcoes.getNomesDasImagensDosJogadores();
	private BufferedImage imgMapa;
	



	public PainelMapa(){
		try {
			File imgMapaFile = new File(path1 + path2 + "war_tabuleiro_com_nomes.png");
			imgMapa = ImageIO.read(imgMapaFile);

			for(int i=0; i<6 && cores[i]!=null ; i++){
				File imgPinosJogadorFiles = new File(path1 + path5 + cores[i]);
				imgPinos[i] = ImageIO.read(imgPinosJogadorFiles);
			}
		}
		catch (IOException e) {
			System.out.println("Imagem n�o encontrada.");
		}


		this.setLayout(new BorderLayout());
		ControladorFluxo.criaPainelOpcoes();
		ControladorFluxo.irPainelOpcoes();
		
		this.nExer();
		
		this.repaint();


	}
	
	public void nExer(){
		this.removeAll();
//		int j=0;
		for(int i = 0;i<6;i++){
			ArrayList<Integer> nExerc = new ArrayList<Integer>();
			ArrayList<Point> pontos = ControladorMapa.colocarBase(cores[i],nExerc);
			
			 if(pontos==null){
	            	break;
	            }
		
			Integer[] intt = nExerc.toArray(new Integer[nExerc.size()]);
			Point[] pointt = pontos.toArray(new Point[pontos.size()]);

           
			//for(Point p : pontos){
			for(int y=0 ;y<pontos.size();y++){
				
//			    JLabel b = (JLabel)this.getComponentAt(pointt[y].x+12, pointt[y].y+4);
//			    if(b!=null){
//			    	this.remove(b);
//			         b.setEnabled(false);
//			    }
				
				ShadowLabel pins = new ShadowLabel(String.format("%d",intt[y]), JLabel.CENTER);
				pins.setForeground(Color.white);
				
				pins.setBounds(pointt[y].x+8, pointt[y].y, 30, 30);	
				//System.out.println(p.x + " " + p.y + "->" + j++);
				pins.setVisible(true);
				
				this.add(pins);
				
				pins = new ShadowLabel();
				
                pins.setIcon(new ImageIcon(Scalr.resize(imgPinos[i], 20)));
				
				pins.setBounds(pointt[y].x, pointt[y].y, 30, 30);	
				//System.out.println(p.x + " " + p.y + "->" + j++);
				pins.setVisible(true);
				
				this.add(pins); 
				
				
			}
			
		}
		this.repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);

		g.drawImage(imgMapa, 0, - Constantes.getDeslocamento(), Constantes.getLargura(), Constantes.getAltura() , null);

		
		
		g.finalize();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.isPopupTrigger() == false){
			String aux = ControladorMapa.detectaTerritorio(e, imgMapa);
			if(aux!=null){
				doPop(e,aux);
			}
		}
	}

	public void mousePressed(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}


	private void doPop(MouseEvent e, String s){
		PopUp menu = new PopUp(s);
		menu.setPainel(this);
		menu.show(e.getComponent(), e.getX(), e.getY());
	}
}
