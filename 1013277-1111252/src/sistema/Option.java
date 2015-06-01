package sistema;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import jogadores.Jogador;
import sorteReves.SorteOuReves;
import territorios.Territorio;

public class Option {

	JFrame frame = new JFrame();
	
	public Option ()
	{
		
	}
	
	public int inicio()
	{
		Object[] options = {"2 Jogadores",
                "3 Jogadores",
                "4 Jogadores", "5 Jogadores", "6 Jogadores"};
		String s = (String) JOptionPane.showInputDialog(frame,
				"Selecione quantos jogadores ir�o jogar",
						"Inicio",
						JOptionPane.PLAIN_MESSAGE,
						null,
						options,
						"");
		if (s == options[0])
			return 2;
		if (s == options[1])
			return 3;
		if (s == options[2])
			return 4;
		if (s == options[3])
			return 5;
		if (s == options[4])
			return 6;
		else
			System.exit(0);
		return 0;
	}
	
	public void aviso (String s)
	{	
		JOptionPane.showMessageDialog(frame,
		    s,
		    "Aviso",
		    JOptionPane.WARNING_MESSAGE);
	}
	
	public void info (String s)
	{
		JOptionPane.showMessageDialog(frame,
			   s);
	}
	
	public Boolean compraTerreno(Territorio t)
	{			
		Object[] options = {"Sim",
        "N�o"}; 
		int n = JOptionPane.showOptionDialog(
		    frame,
		    "Voc� deseja comprar este terreno?"+"\n"+"Pre�o: $" + Integer.toString(t.preco),
		    "Compra de terreno",
		    JOptionPane.YES_NO_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    t.imagem,
		    options,
		    options[0]);
			
		if (n == 0)
			return true;
		else
			return false;
	}
	
	public void pagaTaxas (Territorio t, int v)
	{
		JOptionPane.showMessageDialog(frame,
				  "Pague para o Jogador "+
				Integer.toString(t.dono.getCor())+ "\n"+
				    		"Taxas: $"+ Integer.toString(v),
				    "Taxa",
				    JOptionPane.INFORMATION_MESSAGE,
				    t.imagem);
	}
	
	public void sorteReves(SorteOuReves s)
	{
		if (s.recebeOutros)
		{
			JOptionPane.showMessageDialog(frame,
				    "Receba $50 de cada jogador."+"\n"+
			"Lucro: $"+ Integer.toString(s.efeito),
				    "Sorte",
				    JOptionPane.INFORMATION_MESSAGE,
				    s.imagem);
		}
		if (s.passeprisao)
		{
			JOptionPane.showMessageDialog(frame,
				    "O passe livre da pris�o fica guardado com o jogador at� que seja necess�rio us�-lo",
				    "Sorte",
				    JOptionPane.INFORMATION_MESSAGE,
				    s.imagem);
		}
		if (s.irprisao)
		{
			JOptionPane.showMessageDialog(frame,
				    "V� para pris�o",
				    "Reves",
				    JOptionPane.INFORMATION_MESSAGE,
				    s.imagem);
		}
		if (s.efeito < 0)
		{
			JOptionPane.showMessageDialog(frame,
			    "Pague $" + Integer.toString(s.efeito)+",00",
			    "Rev�s",
			    JOptionPane.INFORMATION_MESSAGE,
			    s.imagem);
		}
		if (s.efeito > 0 && !s.recebeOutros)
		{
			JOptionPane.showMessageDialog(frame,
				    "Receba $" + Integer.toString(s.efeito)+",00",
				    "Sorte",
				    JOptionPane.INFORMATION_MESSAGE,
				    s.imagem);
		}
	}
	
	public void escolheTerritorio (Jogador j)
	{		
		int tam = j.tComprados.size();
		String[] possibilities = new String[tam];
		
		for (int i=0; i<tam; i++)
		{
			possibilities[i] = j.tComprados.get(i).nome;
		}
		String s = (String)JOptionPane.showInputDialog(
		                    frame,
		                    "Escolha o terreno que quer gerenciar:",
		                    "Escolher terreno",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibilities,
		                    "");
		
		for (int i=0; i<tam; i++)
		{
			if (s == j.tComprados.get(i).nome)
			{
				for (int u=0; u<j.tHipotecados.size(); u++)
				{
				if (s == j.tHipotecados.get(i).nome)
					recompra(j.tHipotecados.get(i), j);
				}
				gerenciarTerreno (j.tComprados.get(i), j);
			}
		}
	}
	
	public void gerenciarTerreno (Territorio t, Jogador j)
	{
		Object[] options = {"Adicionar sede",
                "Adicionar comit� pol�tico",
                "Vender sede", "Vender comit� pol�tico", "Hipotecar terreno", "Escolher outro terreno"};
		String s = (String) JOptionPane.showInputDialog(frame,
				"O que gostaria de fazer?"+"\n"+
		"Sedes: "+Integer.toString(t.sede)+"\n"
		+"Comit� Polit�co: "+Integer.toString(t.cPolitico),
						"Gerenciar",
						JOptionPane.PLAIN_MESSAGE,
						t.imagem,
						options,
						"");
		if (s == options[0])
		{
			if (j.getDinheiro() <= t.precoSede)
			{
				aviso("Dinheiro insuficiente.");
			}
			else
			{
				if (j.checaCompraSede(t))
				{
					t.setSede(t.sede+1);
					t.setTaxaAtual(t.sede-1);
					info("Sede adicionada ao terreno "+t.nome+".");
				}
				else
					aviso("Para adicionar uma sede a um terreno voc� precisa ter todos os terrenos da mesma cor."+"\n"
							+"E cada terreno da mesma cor deve possuir apenas uma sede de diferen�a.");
			}
		}
		if (s == options[1])
		{
			if (j.getDinheiro() <= t.precoSede)
			{
				aviso("Dinheiro insuficiente.");
			}
			else
			{
				if (j.checaCompraCPolitico(t))
				{
					t.setCPolitco(1);
					t.setTaxaAtual(5);
					j.venderSedes(t, 4);
					info("Suas casas foram vendidas e o comit� pol�tico foi adicionado ao terreno"+t.nome+".");
				}
				else
					aviso("Para adicionar um comit� pol�tico � necess�rio o terreno possua 4 sedes."+"\n"
							+"E apenas um comit� pol�tico pode ser adicionado por terreno.");
			}
		}
		if (s == options[2])
		{
			if (t.sede != 0)
			{
				venderSedes(t, j);
			}
			else
				aviso ("Este terreno n�o possui sedes.");
		}
		if (s == options[3])
		{
			if (t.cPolitico != 0)
			{
				info ("Comit� pol�tico do terreno "+t.nome+" foi vendido."+"\n"+ "Lucro: $"+Integer.toString(t.precoSede/2)+",00");
				j.venderCPolitico(t);
			}
			else
				aviso ("Este terreno n�o possui comit�s pol�ticos.");
		}
		if (s == options[4])
		{
			if (t.sede != 0)
			{
				aviso ("Para hipotecar um terreno voc� deve vender todas as sedes ou o comit� pol�tico dele.");
			}
			else
			{
				info ("O terreno "+t.nome+" foi hipotecado. Voc� pode compr�-lo de volta pelo valor da sua hipoteca + 20% de juros."+
			"\n"+"Outros jogadores ainda podem mandar ofertas para terrenos hipotecados, se ofertarem, cabe ao comprador pagar os 20%.");
				j.setDinheiro(+t.hipoteca);
				j.tHipotecados.add(t);
			}
		}
		if (s == options[5])
		{
			escolheTerritorio(j);
		}
	}
	
	public void venderSedes (Territorio t, Jogador j)
	{
		String[] options = new String[t.sede];
		for (int i=0; i<t.sede; i++)
		{
			options[i] = Integer.toString(i+1);
		}
		String s = (String) JOptionPane.showInputDialog(frame,
				"Quantas sedes gostaria de vender?"+"\n"+"Pre�o por sede: $"+Integer.toString(t.precoSede/2)+",00",
						"Vender sedes",
						JOptionPane.PLAIN_MESSAGE,
						t.imagem,
						options,
						"");
		if (s == options[0])
		{	
			j.venderSedes(t, 1);
			info ("Uma sede do terreno "+t.nome+" foi vendida."+"\n"+ "Lucro: $"+Integer.toString(t.precoSede/2)+",00");
		}
		else if (s == options[1])
		{
			j.venderSedes(t, 2);
			info ("Duas sedes do terreno "+t.nome+" foram vendidas."+"\n"+ "Lucro: $"+Integer.toString((t.precoSede*2)/2)+",00");
		}
		else if (s == options[2])
		{
			j.venderSedes(t, 3);
			info ("Tr�s sedes do terreno "+t.nome+" foram vendidas."+"\n"+ "Lucro: $"+Integer.toString((t.precoSede*3)/2)+",00");
		}
		else if (s == options[3])
		{
			j.venderSedes(t, 4);
			info ("Todas as sedes do terreno "+t.nome+" foram vendidas."+"\n"+ "Lucro: $"+Integer.toString((t.precoSede*4)/2)+",00");
		}
	}
	
	public void recompra (Territorio t, Jogador j)
	{
		Object[] options = {"Sim",
        "N�o"}; 
		int n = JOptionPane.showOptionDialog(
		    frame,
		    "Este terreno encontra-se hipotecado." +"\n"
		    + "Voc� deseja compr�-lo de volta?"+"\n"+"Pre�o: $" + Integer.toString(t.hipoteca)+"\n"+
		    		"Juros: $"+ Double.toString(t.hipoteca*0.2)+"\n"+
		    		"Pre�o total: $"+ Double.toString(t.hipoteca+t.hipoteca*0.2),
		    "Compra de terreno hipotecado",
		    JOptionPane.YES_NO_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    t.imagem,
		    options,
		    options[0]);
		
		if (n == 0)
		{
			if (j.getDinheiro() <= t.hipoteca + t.hipoteca*0.2)
			{
				aviso("Dinheiro insuficiente!");
			}
			else
			{
				for (int i=0; i<j.tHipotecados.size();i++)
				{
				if (t == j.tHipotecados.get(i))
					j.tHipotecados.remove(i);
				}
				int valor;
				valor = (int) (t.preco+t.preco*0.2);
				j.setDinheiro(-valor);
			}
		}
		else if (n == 1)
		{
			escolheTerritorio(j);
		}
	}

	public void negociar (Tabuleiro t, Jogador j)
	{
		Negocio n = null;
		Object[] options = {"Negociar terrenos",
                "Negociar passe livre da pris�o"};
		String s = (String) JOptionPane.showInputDialog(frame,
				"O que gostaria de fazer?",
						"Negociar",
						JOptionPane.PLAIN_MESSAGE,
						null,
						options,
						"");
		if (s == options[0])
		{
			n = compraTerreno(t, j);
			if (n == null)
				return;
		}
		if (s == options[1])
		{
			n = compraPasse(t.jogadores, j);
			if (n == null)
				return;
		}
		if (n == null)
			return;
		
		if (n.avisoNegociar())
			info("Negocia��o feita com sucesso.");
	}
	
	public Negocio compraPasse (LinkedList<Jogador> jog, Jogador j)
	{
		int valor=0,k=0, tam = jog.size();
		String possibilities[] = new String[tam];
		Negocio n = new Negocio();
		
		for (int i=0; i<tam; i++)
		{
			if (jog.get(i).getPassePrisao())
			{
			k++;
			}
		}
		
		if (j.getPassePrisao())
		{
			aviso("Voc� j� possui um passe da pris�o.");
			return null;
		}
		if (k == 0)
		{
			aviso("Nenhum jogador possui passe da pris�o.");
			return null;
		}
		
		n.tipo = "compraPasse";
		n.setEnviaN(j);
		for (int i=0; i<tam; i++)
		{
			if (jog.get(i).getPassePrisao())
			{
			possibilities[i] = Integer.toString(jog.get(i).getCor());
			}
		}
			String s = (String) JOptionPane.showInputDialog(frame,
				"Com qual jogador quer negociar?",
						"Compra de passe",
						JOptionPane.PLAIN_MESSAGE,
						null,
						possibilities,
						"");
		for (int i=0; i<jog.size(); i++)
		{
			if (jog.get(i).getCor() == Integer.parseInt(s))
				n.setRecebeN(jog.get(i));
		}

		String v = (String) JOptionPane.showInputDialog(
		                    frame,
		                    "Digite o valor que deseja oferecer:",
		                    "Compra de passe",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    null,
		                    "");
		if (v == null)
		{
			aviso("Voce deve digitar algo.");
			return null;
		}
		valor = Integer.parseInt(v);
		n.valor = valor;
		
		return n;
	}
	
	public Negocio compraTerreno (Tabuleiro t, Jogador j)
	{
		Negocio n = new Negocio();
		int valor = 0;
		Boolean hipo = false;
		n.enviaN = j;
		n.tipo = "compraTerreno";
		LinkedList<Territorio> tComDono = new LinkedList<Territorio>();
		
		for (int i=0; i<t.jogadores.size(); i++)
		{
			for (int k=0; k<t.jogadores.get(i).tComprados.size(); k++)
			{
				if (t.jogadores.get(i)!= j)
					tComDono.add(t.jogadores.get(i).tComprados.get(k));
			}
		}
		
		if (tComDono.size() == 0)
		{
			aviso("Nenhum jogador possui terreno.");
			return null;
		}
		
		String possibilities[] = new String[tComDono.size()];	
		
		for (int i=0; i<tComDono.size(); i++)
		{
			possibilities[i] =  tComDono.get(i).nome;
		}
		
		String s = (String) JOptionPane.showInputDialog(frame,
				"Qual terreno voc� quer comprar?",
						"Compra de terreno",
						JOptionPane.PLAIN_MESSAGE,
						null,
						possibilities,
						"");
		for (int i=0;i<tComDono.size();i++)
		{
			if (tComDono.get(i).nome == s)
			{
				n.tDesejado = tComDono.get(i);
				n.recebeN = tComDono.get(i).dono;
			}
		}
		
		String v = (String) JOptionPane.showInputDialog(
                frame,
                "Digite o valor que deseja oferecer:",
                "Compra de passe",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "");
		if (n.recebeN.tHipotecados.size() != 0)
		{
			for (int i=0; i< n.recebeN.tHipotecados.size(); i++)
			{
				if (n.tDesejado == n.recebeN.tHipotecados.get(i))
				{
					aviso ("Este terreno encontra-se hipotecado." +"\n"+
				"voc� ainda pode compr�-lo, mas ter� que pagar 20% do valor de sua hipoteca al�m do valor oeferecido.");
					hipo = true;
					break;
				}
			}
		}
		
		if (v == null)
		{
			aviso("Voce deve digitar algo.");
			return null;
		}
		valor = Integer.parseInt(v);
		if (hipo)
		{
			valor += n.tDesejado.hipoteca*0.2;
		}
		n.valor = valor;
		return n;
	}

	public void usarPasse (Jogador j, ImageIcon img)
	{
		Object[] options = {"Sim",
        "N�o"}; 
		int n = JOptionPane.showOptionDialog(
		    frame,
		    "Voc� est� preso mas possui o passe livre da pris�o. Gostaria de us�-lo?",
		    "Passe livre",
		    JOptionPane.YES_NO_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    img,
		    options,
		    options[0]);
		
		if (n == 0)
		{
			j.setPassePrisao(false);
			j.setPreso ( 0);
		}
	}
	
	public Boolean avisaFalencia (Jogador j)
	{
		if (j.tComprados.size() == 0)
		{
			aviso ("Voc� est� devendo ao banco e n�o possui nenhuma propriedade para hipotecar."+"\n"+
		"Seguiu o conselho do seu advogado e fugiu do pa�s. Est� fora do jogo.");
			return true;
		}
		
		Object[] options = {"Sim",
        "N�o"}; 
		int n = JOptionPane.showOptionDialog(
		    frame,
		    "Voc� est� devendo dinheiro ao banco, se passar o seu turno ir� a fal�ncia e ser� retirado do jogo."+"\n"+
		    "Tente hipotecar os seus terrenos para acabar com sua d�vida."+"\n"+
		    "Deseja passar o turno mesmo assim?",
		    "Aviso fal�ncia",
		    JOptionPane.YES_NO_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    options,
		    null);
		if (n == 0)
			return true;
		return false;
	}
}

