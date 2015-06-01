package territorios;
import javax.swing.ImageIcon;

import jogadores.Jogador;
import sistema.Option;

public class Territorio {
	public boolean irprisao, terreno, empresa, partida, sortereves, imposto, prisao, plivre, lucros;
	public int preco = 0;
	public int hipoteca = 0;
	public Jogador dono = null;
	public int cor = 0;
	public int sede = 0;
	public int cPolitico = 0;
	public int precoSede = 0;
	public int taxaAtual = 0;
	public int [] taxas = new int[] {0,0,0,0,0,0};
	public String nome;
	public ImageIcon imagem;
	Option warning = new Option();
	
	public Territorio (int i)
	{
		switch (i){
		case 1:
			this.terreno = true;
			break;
		case 2:
			this.empresa = true;
			break;
		case 3:
			this.sortereves = true;
			break;
		case 4:
			this.lucros = true;
			break;
		case 5:
			this.irprisao = true;
			break;
		case 6:
			this.prisao = true;
			break;
		case 7:
			this.plivre = true;
			break;
		case 8:
			this.partida = true;
			break;
		case 9:
			this.imposto = true;
			break;
		}
	}
	
	public int getPreco ()
	{
		return this.preco;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public Jogador getDono()
	{
		return dono;
	}
	
	public void setTaxaAtual(int i)
	{
		taxaAtual = taxas[i];
	}
	
	public void setTaxaUnica (int i)
	{
		taxaAtual = i;
	}
	
	public void setPreco (int i)
	{
		this.preco = i;
	}
	
	public void setHipoteca (int i)
	{
		this.hipoteca = i;
	}
	
	public void setTaxas (int t1,int t2,int t3,int t4,int t5,int t6)
	{
		taxas[0] = t1;
		taxas[1] = t2;
		taxas[2] = t3;
		taxas[3] = t4;
		taxas[4] = t5;
		taxas[5] = t6;
	}
	
	public void setNome (String nome)
	{
		this.nome = nome;
	}
	
	public void setdono (Jogador player)
	{
		this.dono = player;
	}
	
	public void setImagem (String path)
	{
		imagem = new ImageIcon(path);
	}
	
	public void setPrecoSede (int i)
	{
		this.precoSede = i;
	}
	
	public void setCor (int i)
	{
		cor = i;
	}
	
	public void setSede (int i)
	{
		this.sede = i;
	}
	
	public void setCPolitco (int i)
	{
		this.cPolitico = i;
	}
	
	public void setTerrenoSemDono()
	{
		if( this.empresa || this.terreno)
		{
			this.dono = null;
			if (this.terreno)
			{
				this.taxaAtual = taxas[0];
				this.sede = 0;
				this.cPolitico = 0;
			}
		}
	}
	
	public Boolean compraOk ()
	{
		if (this.terreno == true || this.empresa == true)
		{
			if (this.dono != null)
			{
				System.out.println ("Esse terreno já possui dono.\n");
				warning.aviso("Este terreno já possui dono!");
				return false;
			}
			return true;
		}		
		warning.aviso("Não é possível comprar este terreno!");
		return false;
	}
	
}
