package sistema;

public class Dado {
	
	int valor;
	int dado1 = 0;
	int dado2 = 0;
	int somaDados = 0;
	
	public Dado()
	{
		valor = 0;
	}
	
	public int rolar_dado()
	{
		valor = 1 + (int)(Math.random() * 6);
		return valor;
	}
	
	public int getSomaDados()
	{
		return somaDados;
	}
	
	public boolean dadosIguais()
	{
		if (dado1 == dado2)
			return true;
		
		return false;
	}
}
