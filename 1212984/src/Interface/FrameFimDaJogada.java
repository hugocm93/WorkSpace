package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.FlowLayout;

public class FrameFimDaJogada extends JFrame{

	private static final long serialVersionUID = 1L;

	public FrameFimDaJogada(){
		super("Fim da Jogada");

		String nomeJogador = "fulano";
		JLabel frase = new JLabel("Passar Jogada para " + nomeJogador) ;
		JButton ok = new JButton("OK");
		JButton cancelar = new JButton("Cancelar");

		ok.setSize(50,30);
		cancelar.setSize(50,30);

		Container cont  = getContentPane();
		cont.setLayout(new FlowLayout());
		cont.add(frase);
		cont.add(ok);
		cont.add(cancelar);

		ok.addActionListener(new fechar());  
		cancelar.addActionListener(new fechar());

		frase.setVisible(true);

		ok.setVisible(true);
		cancelar.setVisible(true);
	}

	private class fechar implements ActionListener{
		public void actionPerformed(ActionEvent e) {  
			setVisible(false);  
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dispose(); 
		} 
	}


}
