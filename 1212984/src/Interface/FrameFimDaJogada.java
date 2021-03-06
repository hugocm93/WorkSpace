package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Controladores.ControladorPainelOpcoes;
import java.awt.Container;
import java.awt.FlowLayout;

public class FrameFimDaJogada extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton ok;
	private JButton cancelar;

	public FrameFimDaJogada(){
		super("Fim da Jogada");

		ControladorPainelOpcoes.proximo();
		JLabel frase = new JLabel("Passar Jogada para " + ControladorPainelOpcoes.jogadorAtual("nome")) ;
		ok = new JButton("OK");
		cancelar = new JButton("Cancelar");

		ok.setSize(50,30);
		cancelar.setSize(50,30);

		Container cont  = getContentPane();
		cont.setLayout(new FlowLayout());
		cont.add(frase);
		cont.add(ok);
		cont.add(cancelar);

		ok.addActionListener(this);  
		cancelar.addActionListener(this);

		frase.setVisible(true);

		ok.setVisible(true);
		cancelar.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok){
			ControladorPainelOpcoes.isfimRodada();
			setVisible(false);  
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dispose(); 
		}
		if(e.getSource() == cancelar){
			setVisible(false);  
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dispose(); 
			ControladorPainelOpcoes.anterior();
		}
	}
}
