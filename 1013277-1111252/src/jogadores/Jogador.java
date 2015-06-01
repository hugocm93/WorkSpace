package jogadores;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import territorios.Territorio;

public class Jogador{

	int dinheiro;
	int cor;
	int casa;
	int preso = 0;
	public int x = 0, y = 0;
	Boolean passeprisao = false;
	public LinkedList<Territorio> tComprados = new LinkedList<Territorio>();
	public LinkedList<Territorio> tHipotecados = new LinkedList<Territorio>();
	public Image imagem;
	
	public Jogador ()
	{
	}
	
	public Jogador (int i)
	{
		casa = 0;
		cor = i;
		dinheiro = 2458;
	}
	
	public void setCoord (int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setPreso (int i)
	{
		preso = i;
	}
	
	public int getPreso ()
	{
		return preso;
	}
	
	public void setCor (int c)
	{
		cor = c;
	}
	
	public int getCor()
	{
		return cor;
	}
	
	public int getCasa ()
	{
		return casa;
	}
	
	public void setCasa(int i)
	{
		casa = i;
	}
	
	public int getDinheiro ()
	{
		return dinheiro;
	}
	
	public void setDinheiro (int din)
	{
		dinheiro += din;
	}
	
	public Boolean getPassePrisao()
	{
		return passeprisao;
	}
	
	public void setPassePrisao(Boolean b)
	{
		passeprisao = b;
	}
	
	public void setTerritorioComprado (Territorio t)
	{
		this.tComprados.add(t);
	}
	
	public void retiraTerritorioComprado (Territorio t)
	{
		for (int i =0; i<tComprados.size(); i++)
		{
			if (tComprados.get(i) == t)
			{
				tComprados.remove(i);
			}
		}
	}
	
	public void setImagem (String path)
	{
		imagem = new ImageIcon(path).getImage();
	}
	
	public Boolean checaCompraSede (Territorio t)
	{
		int tam = tComprados.size();
		int numCor = 0;
		int sedesOk = 0;
		
		for (int i=0; i<tam; i++)
		{
			if (tComprados.get(i).cor == t.cor)
				numCor++;
		}
		if (numCor == 3)
		{
			for (int i=0; i<tam; i++)
			{
				if (tComprados.get(i).cor == t.cor)
				{
					if (tComprados.get(i).sede <= t.sede+1)
					{
						sedesOk++;
					}
				}
			}
		}
		
		if (sedesOk == 3)
			return true;
		
		return false;
	}
	
	public Boolean checaCompraCPolitico(Territorio t)
	{
		if (t.sede == 3)
			return true;
		
		return false;
	}
	
	public void venderSedes (Territorio t, int numSedes)
	{
		this.dinheiro += (numSedes * t.precoSede)/2;
		t.sede -= numSedes;
		t.setTaxaAtual(0);
	}
	
	public void venderCPolitico (Territorio t)
	{
		this.dinheiro += (t.precoSede)/2;
		t.cPolitico = 0;
		t.setTaxaAtual(0);
	}
}
