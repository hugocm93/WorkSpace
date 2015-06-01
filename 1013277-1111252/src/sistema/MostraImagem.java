package sistema;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MostraImagem extends JFrame{
	
	Tabuleiro tab = Tabuleiro.getTabuleiro();
	
	public MostraImagem()
	{
		inicializa();
	}
	
	private void inicializa(){
		
		JButton botaoDado = new JButton();
		JButton botaoCompra = new JButton("Comprar terreno");
		JButton botaoTurno = new JButton("Passar o turno");
		JButton botaoNegocia = new JButton("Negociar");
		JButton botaoGerencia = new JButton("Gerenciar terrenos");
		JPanel panel = new JPanel();
		
		setTitle("Banco Imobiliario");
		
		add(botaoDado);
		botaoDado.setIcon(new ImageIcon("src/dados.jpg"));
    	botaoDado.setBounds(650, 650, 100, 100);
		botaoDado.addActionListener(tab);
		botaoDado.setActionCommand(tab.botaoDado);
		
		add(panel);
		panel.setBounds(250, 650, 200, 150);
		panel.setBorder(new LineBorder(Color.BLACK));
		
		panel.add(botaoCompra);
		botaoCompra.addActionListener(tab);
		botaoCompra.setActionCommand(tab.botaoCompra);
		
		panel.add(botaoGerencia);
		botaoGerencia.addActionListener(tab);
		botaoGerencia.setActionCommand(tab.botaoGerencia);
		
		panel.add(botaoNegocia);
		botaoNegocia.addActionListener(tab);
		botaoNegocia.setActionCommand(tab.botaoNegocia);
		
		panel.add(botaoTurno);
		botaoTurno.addActionListener(tab);
		botaoTurno.setActionCommand(tab.botaoTurno);
		
		botaoDado.setVisible(true);
		botaoCompra.setVisible(true);
		botaoTurno.setVisible(true);
		add(tab);
		
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
