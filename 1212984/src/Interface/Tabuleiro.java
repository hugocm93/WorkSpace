package Interface;

import java.awt.HeadlessException;

import javax.swing.*;

import Estruturas.Constantes;
import Mapa.Mundo;

public class Tabuleiro extends JFrame{
	
	static final long serialVersionUID = 1L;
	private PainelTelaInicial painelTelaInicial = new PainelTelaInicial();
	
	private static Tabuleiro instance;
	
	
	public static Tabuleiro getInstance() {
	      if (instance == null)
	         instance = new Tabuleiro("War");
	      return instance;
	   }
	
	private Tabuleiro(String title) throws HeadlessException {
		super(title);
				
		this.add(painelTelaInicial);
		this.addMouseListener(painelTelaInicial);
		painelTelaInicial.setVisible(true);
		
		this.setSize(Constantes.getLargura(), Constantes.getAltura());
		
	
	}
	
}
