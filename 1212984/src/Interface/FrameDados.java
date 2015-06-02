package Interface;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import Controladores.Controlador;
import Modelos.Dado;

public class FrameDados extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/zImagens/Dados/";
	private BufferedImage imgAtaque;
	private BufferedImage imgDefesa;
	private BufferedImage imgDado1, imgDado2, imgDado3, imgDado4, imgDado5, imgDado6;
	
	public FrameDados(){
		super("Lancar Dados");
		
		JButton botaoLancarDadosAtaque = new JButton();
		JButton botaoLancarDadosDefesa = new JButton();
		JButton ok = new JButton("OK");
		
		try {
			File imgPlayFile = new File(path1 + path2 + "botaoLancarDadosAtaque.png");
			imgAtaque = ImageIO.read(imgPlayFile);

			File imgPlayFile1 = new File(path1 + path2 + "botaoLancarDadosDefesa.png");
			imgDefesa = ImageIO.read(imgPlayFile1);
		}
		
		catch (IOException e) {
			System.out.println("Imagem n�o encontrada.");
		}
		
		botaoLancarDadosAtaque.setIcon(new ImageIcon(imgAtaque));
		botaoLancarDadosDefesa.setIcon(new ImageIcon(imgDefesa));
		
		botaoLancarDadosAtaque.setSize(90, 40);
		botaoLancarDadosDefesa.setSize(90, 40);
		ok.setSize(45,20);
		
		Container cont  = getContentPane();
		cont.setLayout(new FlowLayout());
		cont.add(botaoLancarDadosAtaque);
		cont.add(botaoLancarDadosDefesa);
		cont.add(ok);
		
		botaoLancarDadosAtaque.addActionListener( new lancarDados());
		botaoLancarDadosDefesa.addActionListener(new lancarDados());
		ok.addActionListener(new fechar());  
		
		botaoLancarDadosAtaque.setVisible(true);
		botaoLancarDadosAtaque.setOpaque(false);
		botaoLancarDadosAtaque.setContentAreaFilled(false);
		botaoLancarDadosAtaque.setBorderPainted(false);
		
		botaoLancarDadosDefesa.setVisible(true);
		botaoLancarDadosDefesa.setOpaque(false);
		botaoLancarDadosDefesa.setContentAreaFilled(false);
		botaoLancarDadosDefesa.setBorderPainted(false);
		
		ok.setVisible(true);
		ok.setOpaque(false);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		
		
	}
		
	private class lancarDados implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Nathalia");
			List<Dado> resultados = Controlador.jogarDadosAtaque();
			
			for(Dado dado : resultados) {  
				System.out.println(dado.rolar_dado());  
			}
		}
	}

	private class fechar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {  
		    setVisible(false);  
		} 
	}
}
