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

public class FrameDados extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/zImagens/Dados/";
	private BufferedImage imgAtaque;
	private BufferedImage imgDefesa;
	private JButton botaoLancarDadosAtaque;
	private JButton botaoLancarDadosDefesa;
	private JButton ok;
	private boolean defesaPodeJogar = false;

	public FrameDados(){
		super("Lancar Dados");

		botaoLancarDadosAtaque = new JButton();
		botaoLancarDadosDefesa = new JButton();
		ok = new JButton("OK");

		try {
			File imgPlayFile = new File(path1 + path2 + "botaoLancarDadosAtaque2.png");
			imgAtaque = ImageIO.read(imgPlayFile);

			File imgPlayFile1 = new File(path1 + path2 + "botaoLancarDadosDefesa2.png");
			imgDefesa = ImageIO.read(imgPlayFile1);
			
		}

		catch (IOException e) {
			System.out.println("Imagem n�o encontrada.");
		}

		botaoLancarDadosAtaque.setIcon(new ImageIcon(imgAtaque));
		botaoLancarDadosDefesa.setIcon(new ImageIcon(imgDefesa));

		//botaoLancarDadosAtaque.setSize(90, 35);
		//botaoLancarDadosDefesa.setSize(90, 35);
		ok.setSize(45,20);

		Container cont  = getContentPane();
		cont.setLayout(new FlowLayout());
		cont.add(botaoLancarDadosAtaque);
		cont.add(botaoLancarDadosDefesa);
		cont.add(ok);

		botaoLancarDadosAtaque.addActionListener(this);
		botaoLancarDadosDefesa.addActionListener(this);

		ok.addActionListener(this);  

		botaoLancarDadosAtaque.setVisible(true);
		botaoLancarDadosAtaque.setOpaque(false);
		botaoLancarDadosAtaque.setContentAreaFilled(false);
		botaoLancarDadosAtaque.setBorderPainted(false);

		botaoLancarDadosDefesa.setVisible(true);
		botaoLancarDadosDefesa.setOpaque(false);
		botaoLancarDadosDefesa.setContentAreaFilled(false);
		botaoLancarDadosDefesa.setBorderPainted(false);
		botaoLancarDadosDefesa.setEnabled(false);

		ok.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok){
			setVisible(false);  
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dispose();
		}
		if(e.getSource() == botaoLancarDadosAtaque){
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

				defesaPodeJogar = true;
				botaoLancarDadosDefesa.setEnabled(true);
			}
		}
		if(e.getSource() == botaoLancarDadosDefesa){
			if(defesaPodeJogar == false){
				return;
			}
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

}
