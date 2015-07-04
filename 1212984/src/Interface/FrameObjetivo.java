package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import Controladores.ControladorPainelOpcoes;

public class FrameObjetivo extends JFrame{

	private static final long serialVersionUID = 1L;

	public FrameObjetivo(){
		super("Objetivo");

		PainelObj novo = new PainelObj();
		this.setBounds(0, 0, 440, 725);
		novo.setVisible(true);
		this.add(novo);
		
	}
	
	public void fechar(){
		setVisible(false);  
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dispose();
	}

}

class PainelObj extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private String path1 = System.getProperty("user.dir");
	private String path3 = "/src/zImagens/Cartas/";
	private BufferedImage imgFundo;
	private JButton ok;
	private JLabel text = new JLabel();

	public PainelObj(){

		ok = new JButton("OK");

		try {
			File imgFundoF = new File(path1 + path3 + "war_carta_objetivo.png");
			imgFundo = ImageIO.read(imgFundoF);
			System.out.println(path1 + path3 + "war_carta_objetivo.png");
		}

		catch (IOException e) {
			System.out.println("Imagem n�o encontrada.");
		}


		ok.setSize(45,20);
		this.add(ok);
		ok.addActionListener(this);  
		ok.setVisible(true);
		ok.setEnabled(true);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("PaintObj");
		g.drawImage(imgFundo, 0, 0, 440, 725 , null);

		ok.setBounds(ok.getBounds().x, 440, ok.getBounds().width, ok.getBounds().height);

		text.setForeground(Color.black);
		text.setText(ControladorPainelOpcoes.jogadorAtual("Objetivo"));
		text.setVisible(true);
		text.setBounds(40, 50, 380, 400);
		this.add(text);
		g.finalize();
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok){
			FrameObjetivo topFrame = (FrameObjetivo) SwingUtilities.getWindowAncestor(this);
			topFrame.fechar();
		}
	}
}
