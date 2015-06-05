package Interface;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.imgscalr.Scalr;
import Controladores.ControladorFrameDados;

public class FrameDados extends JFrame{

	private static final long serialVersionUID = 1L;
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/zImagens/Dados/";
	private BufferedImage imgAtaque;
	private BufferedImage imgDefesa;

	private JButton botaoLancarDadosAtaque;
	private JButton botaoLancarDadosDefesa;
	private JButton ok;

	public FrameDados(){
		super("Lancar Dados");

		botaoLancarDadosAtaque = new JButton();
		botaoLancarDadosDefesa = new JButton();
		ok = new JButton("OK");

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

		botaoLancarDadosAtaque.addActionListener( new lancarDadosAtaque());
		botaoLancarDadosDefesa.addActionListener(new lancarDadosDefesa());

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
	}

	private class lancarDadosAtaque implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ControladorFrameDados.jogarDadosAtaque(4);
			ControladorFrameDados.ordenarDadosDeAtaque();
			ImageIcon[] imagensDados = ControladorFrameDados.getNomesDasImagensDosDadosDeAtaque();

			for(int i=0;i<3;i++){
				System.out.println(imagensDados[i]);
			}

			botaoLancarDadosAtaque.setVisible(false);

			JLabel dado;
			Container cont  = getContentPane();
			cont.setLayout(null);
			for(int i=0;i<3;i++){
				dado = new JLabel();
				cont.add(dado);
				BufferedImage aux = null;
				try {
					aux = ImageIO.read(new File(imagensDados[i].toString()));
				}
				catch (IOException e1) {

					e1.printStackTrace();
				}
				dado.setIcon(new ImageIcon(Scalr.resize(aux, 55)));
				dado.setBounds(i*55+10*i + 5,20, 55, 55);
				dado.setVisible(true);
				dado.setOpaque(false);
			}
		}
	}

	private class lancarDadosDefesa implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ControladorFrameDados.jogarDadosDefesa(4);
			ControladorFrameDados.ordenarDadosDeDefesa();
			ImageIcon[] imagensDados = ControladorFrameDados.getNomesDasImagensDosDadosDeDefesa();

			for(int i=0;i<3;i++){
				System.out.println(imagensDados[i]);
			}

			botaoLancarDadosDefesa.setVisible(false);

			JLabel dado;
			Container cont  = getContentPane();
			cont.setLayout(null);
			for(int i=0;i<3;i++){
				dado = new JLabel();
				cont.add(dado);
				BufferedImage aux = null;
				try {
					aux = ImageIO.read(new File(imagensDados[i].toString()));
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				dado.setIcon(new ImageIcon(Scalr.resize(aux, 55)));
				dado.setBounds(i*55+10*i + 5,85, 55, 55);
				dado.setVisible(true);
				dado.setOpaque(false);
			}

		}
	}

	private class fechar implements ActionListener{

		public void actionPerformed(ActionEvent e) {  
			setVisible(false);  
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dispose();

		} 
	}

}
