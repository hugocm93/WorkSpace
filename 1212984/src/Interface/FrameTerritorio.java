package Interface;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.imgscalr.Scalr;

import Controladores.ControladorMapa;

public class FrameTerritorio extends JFrame implements Observable{

	private static final long serialVersionUID = 1L;
	private List<Observer> observers = new ArrayList();
	private PainelCartas painelCartas = new PainelCartas();



	public FrameTerritorio(){
		super("Cartas");
		this.setBounds(0, 0, 440, 725);
		
		painelCartas.setVisible(true);
		this.add(painelCartas);
	}



	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}


	@Override
	public void removeObserver(Observer observer) {
	observers.remove(observer);
	}


	@Override
	public void notifyObservers() {		
		for (Observer ob : observers) {
			System.out.println("Notificando observers!");
	        ob.update(this.add(painelCartas));
	    }
	}
}

class PainelCartas extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/zImagens/Botoes/";
	private String path3 = "/src/zImagens/Cartas/";
	private JButton botaoSetaDireita = new JButton();
	private JButton botaoSetaEsquerda= new JButton();
	private BufferedImage imgSetaDireita;
	private BufferedImage imgSetaEsquerda;
	private BufferedImage[] imgFundo = new BufferedImage[5];
	int i=0, max=0;

	public PainelCartas(){


		try{
			File imgSetaDireitaFile = new File(path1 + path2 + "setaDireita.png");
			imgSetaDireita = ImageIO.read(imgSetaDireitaFile);

			File imgSetaEsquerdaFile = new File(path1 + path2 + "setaEsquerda.png"); 
			imgSetaEsquerda = ImageIO.read(imgSetaEsquerdaFile);

			String[] s = ControladorMapa.getImagensAtuais();
			max = s.length;

			for(int u=0;u<max;u++){
				File imgFundoF1 = new File(path1 + path3 + s[u]);
				imgFundo[u] = ImageIO.read(imgFundoF1);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		botaoSetaEsquerda.setIcon(new ImageIcon(Scalr.resize(imgSetaEsquerda, 50,50)));
		botaoSetaEsquerda.setOpaque(false);
		botaoSetaEsquerda.setContentAreaFilled(false);
		botaoSetaEsquerda.setBorderPainted(false);
		botaoSetaEsquerda.addActionListener(this);
		botaoSetaEsquerda.setVisible(true);
		this.add(botaoSetaEsquerda);
		

		botaoSetaDireita.setIcon(new ImageIcon(Scalr.resize(imgSetaDireita, 50,50)));
		botaoSetaDireita.setOpaque(false);
		botaoSetaDireita.setContentAreaFilled(false);
		botaoSetaDireita.setBorderPainted(false);
		botaoSetaDireita.addActionListener(this);
		botaoSetaDireita.setVisible(true);
		this.add(botaoSetaDireita);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(imgFundo[i], 0, 0, 440, 725 , null);
		botaoSetaEsquerda.setBounds(0,600,50, 50);
		botaoSetaDireita.setBounds(390,600,50, 50);

		g.finalize();
	}

	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == botaoSetaDireita){
			System.out.println("direita");
			if(max!=0){
				
				i++;
				i = i%max;
			}
		}

		if(e.getSource() == botaoSetaEsquerda){
			System.out.println("Esquerda");
			if(max!=0){
				
				if(i!=0){
					i--;
					i = i%max;
				}
				else{
					i=max-1;
				}
			}
		}
		this.repaint();

	}


}
