package Interface;

import java.awt.HeadlessException;
import javax.swing.*;
import Estruturas.Constantes;

public class Tabuleiro extends JFrame{
	
	static final long serialVersionUID = 1L;
	
	private PainelMapa painelMapa = new PainelMapa();
	//private PainelTelaInicial painelTelaInicial = new PainelTelaInicial();
	
	public Tabuleiro(String title) throws HeadlessException {
		super(title);
		
		this.add(painelMapa);
		this.addMouseListener(painelMapa);
		painelMapa.setVisible(true);
		
//		this.add(painelTelaInicial);
//		this.addMouseListener(painelTelaInicial);
//		painelTelaInicial.setVisible(true);
		
		this.setSize(Constantes.getLargura(), Constantes.getAltura());
		
	
	}
	
}
