package Controladores;

import java.util.ArrayList;
import Modelos.Carta;
import Modelos.Continente;
import Modelos.Jogador;
import Modelos.Mundo;
import Modelos.Rodada;
import Modelos.Territorio;
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
		int i = mundo.getNJogadores();
		Jogador[] jogadores2 = new Jogador[]{null,null,null,null,null,null}; 

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
		int u = mundo.getNJogadores();
		boolean flag = true;

		while(cont<=51){
			if(cont==51){
				break;
			}
			for(i=0;i<u;i++){
				if(cont<51){
					flag=true;
				}
				else{
					flag=false;
				}
				while(flag){
					if(cont==51){
						break;
					}

					int aux1 = (int)(Math.random() * 6);
					int aux2 = (int)(Math.random() * continentes[aux1].getTerritorios().length);
					if(continentes[aux1].getTerritorios()[aux2].getDono() == null){
						continentes[aux1].getTerritorios()[aux2].setDono(jogadores[i]);
						jogadores[i].getTerritoriosPossuidos().add(continentes[aux1].getTerritorios()[aux2]);
						cont++;
						flag=false;
						break;
					}

				}
			}
		}
		return;
	}

	public static void calculaJogadores() {
		mundo.calculaNumeroJogadores();

	}

	public static void distribuiObjetivos() {
		Jogador[] jogadores = mundo.getJogadores();
		int u;
		int index = 0;
		String aux = "";
		for(u=0; u<6 && jogadores[u]!=null ;u++){

			index = (int)(Math.random() * mundo.getObjDisponiveis().size());

			try{
				aux = mundo.getObjDisponiveis().get(index);

			}
			catch(Exception e){
				System.out.println("Erro!!!");
			}
			jogadores[u].setObj(aux);
			mundo.getObjDisponiveis().remove(index);
			System.out.println(aux);
		}


	}

	public static void verificaContinentes()  {
		Jogador[] jogadores = mundo.getJogadores();
		Continente[] conts = mundo.getContinentes();

		int u;
		for(u=0; u<6 && jogadores[u]!=null ;u++){
			int[] AA = {0,0,0,0,0,0};
			ArrayList<Territorio> aux = jogadores[u].getTerritoriosPossuidos();
			java.util.ListIterator<Territorio> novaLi = aux.listIterator();
			
			jogadores[u].setContinentesPossuidos(new ArrayList<Continente>());
			
			while(novaLi.hasNext()){

				String aux1 = "";
				aux1 = novaLi.next().getCont().getNome();

				if(aux1.equals("America do Norte")){
					AA[0]++;
				}
				if(aux1.equals("America do Sul")){
					AA[1]++;
				}
				if(aux1.equals("Africa")){
					AA[2]++;
				}
				if(aux1.equals("Europa")){
					AA[3]++;
				}
				if(aux1.equals("Asia")){
					AA[4]++;
				}
				if(aux1.equals("Oceania")){
					AA[5]++;
				}
			}

			for(int j=0;j<6;j++){
				boolean flag = false;
				if(conts[j].getTerritorios().length == AA[j]){

					if(flag==false){
						jogadores[u].getContinentesPossuidos().add(conts[j]);
						System.out.println(conts[j].getNome() + " foi dominado.");
						mundo.getR().getAtual().getnExercitosDaVezContinente().put(conts[j].getNome(),conts[j].getExercitosTabela());
				
					}
				} 
			}
		}


	}

	public static void daCarta() {


		if(!mundo.getR().getAtual().isJaRecebeuCarta() && mundo.getR().getAtual().isPodeReceberCarta()){
			int index = (int)(Math.random() * mundo.getCartasDisponiveis().size());
			Carta aux = mundo.getCartasDisponiveis().get(index);

			mundo.getR().getAtual().getJogador().getCartas().add(aux);
			aux.setDono(mundo.getR().getAtual().getJogador());

			mundo.getCartasDisponiveis().remove(aux);

			System.out.println("Carta" + aux.getImgNome());
			mundo.getR().getAtual().setJaRecebeuCarta(true);
		}

	}

}


