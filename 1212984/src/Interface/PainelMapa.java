package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
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
	private String ultTerritorio;


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

		for(int i = 0;i<6;i++){
			ArrayList<Integer> nExerc = new ArrayList<Integer>();
			ArrayList<Point> pontos = ControladorMapa.colocarBase(cores[i],nExerc);

			if(pontos==null){
				break;
			}
			Integer[] intt = nExerc.toArray(new Integer[nExerc.size()]);
			Point[] pointt = pontos.toArray(new Point[pontos.size()]);

			for(int y=0 ;y<pontos.size();y++){
				ShadowLabel pins = new ShadowLabel(String.format("%d",intt[y]), JLabel.CENTER);
				pins.setForeground(Color.white);
				pins.setBounds(pointt[y].x+8, pointt[y].y, 30, 30);	
				pins.setVisible(true);
				this.add(pins);
				pins = new ShadowLabel();
				pins.setIcon(new ImageIcon(Scalr.resize(imgPinos[i], 20)));
				pins.setBounds(pointt[y].x, pointt[y].y, 30, 30);	
				pins.setVisible(true);
				this.add(pins); 
			}
		}
		this.repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		System.out.println("Paint");
		
		g.drawImage(imgMapa, 0, - Constantes.getDeslocamento(), Constantes.getLargura(), Constantes.getAltura() , null);
		this.drawline();
		g.finalize();
	}

	public void mouseClicked(MouseEvent e) {
		Fase f = ControladorPainelOpcoes.getFase();

		if(f == Fase.DESLOCAMENTO){
			return;
		}
		if (e.isPopupTrigger() == false){
			String aux = ControladorMapa.detectaTerritorio(e, imgMapa);
			if(aux!=null){
				doPop(e,aux);
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		Fase f = ControladorPainelOpcoes.getFase();

		if(f != Fase.DESLOCAMENTO){
			return;
		}
		String aux = ControladorMapa.detectaTerritorio(e, imgMapa);
		ultTerritorio = aux;
		if(ControladorMapa.permitidoMover(aux) && ControladorMapa.isFimAtaque() && ControladorMapa.permitidoMover2(aux)){
			int i=0;
			for(;i<6;i++){
				if(cores[i].equals(ControladorPainelOpcoes.jogadorAtual("cor"))){
					break;
				}
			}
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image image = new ImageIcon(Scalr.resize(imgPinos[i], 20)).getImage();
			Cursor c = toolkit.createCustomCursor(image , new Point(this.getX(),this.getY()), "img");
			this.setCursor (c);
		}
		this.repaint();
	}

	public void mouseReleased(MouseEvent e) {
		Fase f = ControladorPainelOpcoes.getFase();

		if(f != Fase.DESLOCAMENTO){
			return;
		}
		String aux = ControladorMapa.detectaTerritorio(e, imgMapa);
		if(ControladorMapa.permitidoDeixar(aux) && ControladorMapa.permitidoMover(ultTerritorio)  && ControladorMapa.fazFronteira(aux, ultTerritorio) && ControladorMapa.isFimAtaque() && ControladorMapa.permitidoMover2(ultTerritorio)){
			ControladorMapa.retiraExer(ultTerritorio);
			ControladorMapa.colocaExer(aux);
			ControladorMapa.moveu(ultTerritorio);
			this.nExer();

		}
		else{

			ultTerritorio = null;
		}

		Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		setCursor(cursor);

		 this.repaint();
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	private void doPop(MouseEvent e, String s){
		PopUp menu = new PopUp(s);
		menu.setPainel(this);
		menu.show(e.getComponent(), e.getX(), e.getY());
	}

	private void drawArrowLine(Graphics g, double e, double f, double i, double j, int d, int h){
		double dx = i - e, dy = j - f;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - d, xn = xm, ym = h, yn = -h, x;
		double sin = dy/D, cos = dx/D;

		x = xm*cos - ym*sin + e;
		ym = xm*sin + ym*cos + f;
		xm = x;

		x = xn*cos - yn*sin + e;
		yn = xn*sin + yn*cos + f;
		xn = x;

		int[] xpoints = {(int)i , (int) xm, (int) xn};
		int[] ypoints = {(int) j, (int) ym, (int) yn};

		g.drawLine((int)e, (int)f, (int)i, (int)j);
		g.fillPolygon(xpoints, ypoints, 3);
	}

	public void drawline() {
		System.out.println("Drawline");
		if(!ControladorMapa.getBaseD().equals(new Point(0,0))){
			this.drawArrowLine(this.getGraphics(), ControladorMapa.getBaseAT().getX(),ControladorMapa.getBaseAT().getY() , ControladorMapa.getBaseD().getX(),ControladorMapa.getBaseD().getY() , 8, 8);
		}
	}
}
