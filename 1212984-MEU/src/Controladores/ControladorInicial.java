package Controladores;

import java.util.ArrayList;

import Modelos.Continente;
import Modelos.Jogador;
import Modelos.Mundo;
import Modelos.Rodada;
import Modelos.Turno;

public class ControladorInicial {
	
	private static Mundo mundo = Mundo.getInstance();
	
	public static void criaNovoJogador(String nome, String cor){
		
		Jogador jogador = new Jogador(nome, cor, null, null, null, null);
		Jogador[] jogadores = mundo.getJogadores();
		int i;
		for(i=0; jogadores[i]!=null;i++);
		jogadores[i]=jogador;
	}

	public static void sortSequencia() {
		Jogador[] jogadores = mundo.getJogadores();
		int i;
		Jogador[] jogadores2 = new Jogador[]{null,null,null,null,null,null}; 
		for(i=0; i<6 && jogadores[i]!=null;i++);

		for(int j=0; j<i;){
			int aux = (int)(Math.random() * 6);
			if(jogadores[aux]!=null){
				jogadores2[j] = jogadores[aux];
				jogadores[aux] = null;
				j++;
			}
		}
		mundo.setJogadores(jogadores2);
		
	}
	
	public static void imprime(){
		Jogador[] jogadores = mundo.getJogadores();
		
		for(int i=0; i<6 && jogadores[i]!=null ;i++){
			System.out.println(jogadores[i].getNome());
		}

	}

	public static void criaTurnos() {
		Jogador[] jogadores = mundo.getJogadores();
		ArrayList<Turno> t = new ArrayList<Turno>();
		int u;
		for(u=0; u<6 && jogadores[u]!=null ;u++){
			System.out.println(jogadores[u].getTerritoriosPossuidos().size());
			Turno novo = new Turno(jogadores[u],jogadores[u].getTerritoriosPossuidos().size()/2, u);
			t.add(novo);
		}
		Turno atual = t.get(0);
		mundo.setR(new Rodada(t,atual));
		
	}
	
	public static void sortearTerritorios(){
		Jogador[] jogadores = mundo.getJogadores();
		Continente[] continentes = mundo.getContinentes();
		int i=0;
		int cont=0;
		int u;
		for(u=0; u<6 && jogadores[u]!=null ;u++);
		boolean flag = true;

		while(cont<=51){
			//System.out.printf("while1%d\n", cont);
			if(cont==51){
				break;
			}
			for(i=0;i<u;i++){
				//System.out.printf("while2%d\n", cont);
				if(cont<51){
					flag=true;
				}
				else{
					flag=false;
				}
				while(flag){
					//System.out.printf("while3%d\n", cont);
					if(cont==51){
						break;
					}

					int aux1 = (int)(Math.random() * 6);
					int aux2 = (int)(Math.random() * continentes[aux1].getTerritorios().length);
					if(continentes[aux1].getTerritorios()[aux2].getDono() == null){
						continentes[aux1].getTerritorios()[aux2].setDono(jogadores[i]);
						jogadores[i].getTerritoriosPossuidos().add(continentes[aux1].getTerritorios()[aux2]);
						//System.out.println(continentes[aux1].getTerritorios()[aux2].getNome() + "->"+ jogadores[i].getNome());
						cont++;
						flag=false;
						break;
					}

				}
			}


		}
		return;

	}

}
