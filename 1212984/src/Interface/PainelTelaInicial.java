package Interface;



import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Mapa.Mundo;
import Estruturas.Constantes;

import org.imgscalr.Scalr;

public class PainelTelaInicial extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private Mundo mundo = Mundo.getInstance();
		
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/Imagens/Mapas/";
	private String path3 = "/src/Imagens/Background/";
	private BufferedImage imgMapa;
	private BufferedImage imgTitulo;
	private BufferedImage imgPlay;
	
	JButton botaoPlay = new JButton();
	

	public PainelTelaInicial(){
		
		try {
			
			File imgMapaFile = new File(path1 + path3 + "war_tabuleiro_fundo.png");
			imgMapa = ImageIO.read(imgMapaFile);
			
			File imgTituloFile = new File(path1 + path3 + "war_titulo.png");
			imgTitulo = ImageIO.read(imgTituloFile);
			
			File imgPlayFile = new File(path1 + path3 + "war_play.png");
			imgPlay = ImageIO.read(imgPlayFile);
			
		}
		
		catch (IOException e) {
			
			System.out.println("Imagem não encontrada.");
			
		}
		
		
		
		
		BufferedImage thumbnail = Scalr.resize(imgPlay, 100);
		
	
		botaoPlay.setIcon(new ImageIcon(thumbnail));
		botaoPlay.addActionListener(this);
		botaoPlay.setBounds( 200, 200  ,50 ,50 );
		
		this.add(botaoPlay);
		botaoPlay.setVisible(true);
		
		botaoPlay.setOpaque(false);
		botaoPlay.setContentAreaFilled(false);
		botaoPlay.setBorderPainted(false);
		
		this.repaint();
		
		
		
		

	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.drawImage(imgMapa, 0, - Constantes.getDeslocamento(), Constantes.getLargura(), Constantes.getAltura() , null);
		g.drawImage(imgTitulo, 0, -5, Constantes.getLargura() + 5,Math.round(imgTitulo.getHeight()/Constantes.getConstConversao()) , null);
		g.finalize();
    }



	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoPlay){
			System.out.println("Action");
			
			PainelMapa painelMapa = new PainelMapa();

			Tabuleiro.getInstance().add(painelMapa);
			Tabuleiro.getInstance().addMouseListener(painelMapa);
			painelMapa.setVisible(true);

			this.setVisible(false);
		}
		
	}


}
