import javax.swing.JFrame;
import Interface.*;

public class Jogo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tabuleiro janela = Tabuleiro.getInstance();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		janela.setVisible(true);
		
		
	}

}
