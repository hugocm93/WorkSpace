package sistema;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import jogadores.Jogador;
import territorios.Territorio;


public class Negocio {

	Jogador enviaN;
	Jogador recebeN;
	int valor = 0;
	String tipo = ""; // Compra de terreno, compra de passe, troca de terrenos.
	Territorio tDesejado = new Territorio(0);
	Territorio tOferecido = new Territorio(0);
	
	Option warning = new Option();
	
	public Boolean avisoNegociar()
	{
		Object[] options = {"Sim",
        "N�o"}; 
		JFrame frame = new JFrame();
			if (tipo == "compraTerreno")
			{
				int n = JOptionPane.showOptionDialog(
						frame,
						"O jogador "+Integer.toString(enviaN.getCor())+ " deseja comprar seu terreno "+
						tDesejado.nome+" por $"+Integer.toString(valor)+"."+"\n"+"Voc� aceita?"+"\n"+
								"Se voc� aceitar todas as casas ou comit� pol�tico que est�o nesse terreno ser�o vendidos",
						"Aviso para o Jogador "+Integer.toString(recebeN.getCor()),
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						tDesejado.imagem,
						options,
						options[0]);
				if (n == 0)
				{
					recebeN.venderSedes(tDesejado, tDesejado.sede);
					recebeN.retiraTerritorioComprado(tDesejado);
					enviaN.setTerritorioComprado(tDesejado);
					enviaN.setDinheiro(-valor);
					recebeN.setDinheiro (+valor);
					return true;
				}
				return false;
			}
			if (tipo == "compraPasse")
			{
				int n = JOptionPane.showOptionDialog(
						frame,
						"O jogador "+Integer.toString(enviaN.getCor())+ 
						"deseja comprar seu passe da pris�o por $"+Integer.toString(valor)+"."+"\n"+"Voc� aceita?",
						"Aviso para o Jogador "+Integer.toString(recebeN.getCor()),
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[0]);
				if (n == 0)
				{
					enviaN.setPassePrisao(true);
					enviaN.setDinheiro(-valor);
					recebeN.setPassePrisao (false);
					recebeN.setDinheiro (+valor);
					return true;
				}
				return false;
			}
			return null;
	}
	
	public void setEnviaN (Jogador j)
	{
		enviaN = j;
	}
	
	public void setRecebeN (Jogador j)
	{
		recebeN = j;
	}
	public void setValor (int n)
	{
		valor = n;
	}
	public void setTerrenoDesejado (Territorio t)
	{
		this.tDesejado = t;
	}
	public void setTerrenoOferecido (Territorio t)
	{
		this.tOferecido = t;
	}
	
}
