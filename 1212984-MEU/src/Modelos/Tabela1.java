package Modelos;

public class Tabela1 {

	private final int[] troca = {4,6,8,10,12,15,20,25,35,45};
	private int ultimaTroca=0;
	private int i = 0;

	public int proximoValor(){

		if(ultimaTroca < 9){
			return troca[ultimaTroca++];
		}
		else{
			return troca[ultimaTroca] + 10*i++;
		}

	}


}
