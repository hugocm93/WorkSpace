package Controladores;

import java.util.HashMap;
import java.util.ListIterator;
import Interface.Fase;
import Modelos.Carta;
import Modelos.Continente;
import Modelos.Jogador;
import Modelos.Mundo;
import Modelos.Territorio;

public class ControladorPainelOpcoes {

	private static Mundo mundo = Mundo.getInstance();
	private static String[] rets;

	public static String jogadorAtual(String param){
		if(param.equals("nome")){
			return mundo.getJogadores()[mundo.getR().getAtual().getIndexJogador()].getNome();
		}
		if(param.equals("cor")){
			return mundo.getJogadores()[mundo.getR().getAtual().getIndexJogador()].getCor();
		}
		if(param.equals("exer")){
			return String.format("%d",mundo.getR().getAtual().getnExercitosDaVez());

		}
		if(param.equals("Objetivo")){
			return String.format("<html>"+mundo.getJogadores()[mundo.getR().getAtual().getIndexJogador()].getObj()+"</html>");

		}

		if(param.equals("America do Norte")){
			return String.format("%d",mundo.getR().getAtual().getnExercitosDaVezContinente().get(param).intValue());

		}
		if(param.equals("America do Sul")){
			return String.format("%d",mundo.getR().getAtual().getnExercitosDaVezContinente().get(param).intValue());

		}
		if(param.equals("Africa")){
			return String.format("%d",mundo.getR().getAtual().getnExercitosDaVezContinente().get(param).intValue());

		}
		if(param.equals("Europa")){
			return String.format("%d",mundo.getR().getAtual().getnExercitosDaVezContinente().get(param).intValue());

		}
		if(param.equals("Asia")){
			return String.format("%d",mundo.getR().getAtual().getnExercitosDaVezContinente().get(param).intValue());

		}
		if(param.equals("Oceania")){
			return String.format("%d",mundo.getR().getAtual().getnExercitosDaVezContinente().get(param).intValue());

		}
		return null;
	}

	public static void proximo(){
		mundo.getR().proxTurno();
	}

	public static void anterior(){
		mundo.getR().turnoAnt();
	}

	public static String[] getNomesDasImagensDosJogadores(){
		rets = new String[6];

		for(int i=0; i<6 && ControladorPainelOpcoes.coresDosJogadores()[i]!=null ;i++){
			rets[i] = ControladorPainelOpcoes.coresDosJogadores()[i];
		}

		return rets;
	}

	public static void isfimRodada() {


		int aux = mundo.getR().getIndexTurno();
		int aux2 = mundo.getR().getIndexRodada();
		int u = mundo.getNJogadores();
		System.out.println(mundo.getR().getTurnos().get(aux).getIndexJogador() + "-" + u);

		if(mundo.getR().getTurnos().get(aux).getIndexJogador() == 0){
			ControladorInicial.criaTurnos();
			mundo.getR().setIndexRodada(++aux2);
		}

		ControladorInicial.verificaContinentes();

	}

	public static boolean permitidoPassar(String name) {
		if(mundo.getR().getAtual().getJogador().getNome().equals(name)){
			if(mundo.getR().getAtual().getnExercitosDaVez() == 0){
				ListIterator<Continente> li = mundo.getR().getAtual().getJogador().getContinentesPossuidos().listIterator();
				
				while(li.hasNext()){
					if(mundo.getR().getAtual().getnExercitosDaVezContinente().get(li.next().getNome()) != 0){
						return false;
					}
				}
				
				return true;
			}
		}

		return false;
	}


	public static String[] coresDosJogadores(){
		Jogador[] jogadores = mundo.getJogadores();

		for(int i=0; i<6 && jogadores[i]!=null ;i++){
			rets[i] = jogadores[i].getCor();
		}
		return rets;
	}

	public static void setarAtacante(String name) {
		Territorio t = mundo.getTerritorios().get(name);
		if(t==null){
			return ;
		}

		if(t.getDono().getNome().equals(mundo.getR().getAtual().getJogador().getNome())){

			mundo.getR().getAtual().setAtacante(t);

		}
	}

	public static void setarDefensor(String name) {
		Territorio t = mundo.getTerritorios().get(name);
		if(t==null){
			return ;
		}
		mundo.getR().getAtual().setDefensor(t);
		System.out.println("Base do defensor" + t.getBase());


	}

	public static void fimAtaque() {
		mundo.getR().getAtual().setFimFaseAtaque(true);

	}

	public static boolean isNotPrimeiraRodada() {

		//		if(mundo.getR().getIndexRodada()>=1){
		//			return true;
		//		}
		//		return false;
		return true;
	}

	public static Fase getFase() {

		if(mundo.getR().getAtual().getnExercitosDaVez() == 0 && !ControladorPainelOpcoes.isNotPrimeiraRodada()){
			mundo.getR().getAtual().setF(Fase.FIM);
		}
		if(mundo.getR().getAtual().getnExercitosDaVez() == 0 && ControladorPainelOpcoes.isNotPrimeiraRodada()){
			mundo.getR().getAtual().setF(Fase.ATAQUE);
		}
		if(mundo.getR().getAtual().isFimFaseAtaque()){
			mundo.getR().getAtual().setF(Fase.DESLOCAMENTO);
		}
		if(mundo.getR().getAtual().getnExercitosDaVez() > 0){
			mundo.getR().getAtual().setF(Fase.RECEBENDO);
		}
		if(mundo.getR().getAtual().getnExercitosDaVez() == 0){
			//ControladorInicial.verificaContinentes();
			try{
				if(ControladorPainelOpcoes.pertenceAoAtual("America do Norte")){
					if(mundo.getR().getAtual().getnExercitosDaVezContinente().get("America do Norte").intValue() > 0){

						mundo.getR().getAtual().setF(Fase.RECEBENDOAM);
					}
				}
			}
			catch(Exception e){

			}
			try{
				if(ControladorPainelOpcoes.pertenceAoAtual("America do Sul")){
					if(mundo.getR().getAtual().getnExercitosDaVezContinente().get("America do Sul").intValue() > 0){
						mundo.getR().getAtual().setF(Fase.RECEBENDOAS);
					}
				}
			}
			catch(Exception e){

			}
			try{
				if(ControladorPainelOpcoes.pertenceAoAtual("Africa")){

					if(mundo.getR().getAtual().getnExercitosDaVezContinente().get("Africa").intValue() > 0){
						mundo.getR().getAtual().setF(Fase.RECEBENDOA);
					}
				}
			}
			catch(Exception e){

			}
			try{
				if(ControladorPainelOpcoes.pertenceAoAtual("Europa")){
					if(mundo.getR().getAtual().getnExercitosDaVezContinente().get("Europa").intValue() > 0){
						mundo.getR().getAtual().setF(Fase.RECEBENDOEU);
					}
				}
			}
			catch(Exception e){

			}
			try{
				if(ControladorPainelOpcoes.pertenceAoAtual("Asia")){

					if(mundo.getR().getAtual().getnExercitosDaVezContinente().get("Asia").intValue() > 0){
						mundo.getR().getAtual().setF(Fase.RECEBENDOASI);
					}
				}
			}
			catch(Exception e){

			}
			try{
				if(ControladorPainelOpcoes.pertenceAoAtual("Oceania")){

					if(mundo.getR().getAtual().getnExercitosDaVezContinente().get("Oceania").intValue() > 0){
						mundo.getR().getAtual().setF(Fase.RECEBENDOOC);
					}
				}
			}
			catch(Exception e){

			}
		}


		return mundo.getR().getAtual().getF();
	}

	private static boolean pertenceAoAtual(String name) {
		ListIterator<Continente> li  = mundo.getR().getAtual().getJogador().getContinentesPossuidos().listIterator();

		while(li.hasNext()){
			if(li.next().getNome().equals(name)){
				return true;
			}
		}

		return false;
	}

	public static boolean podeAtacar() {
		if(mundo.getR().getAtual().getAtacante() != null && mundo.getR().getAtual().getDefensor() != null){
			return true;
		}
		return false;
	}

	public static void snapShot() {
		HashMap <String, Integer> snap = new HashMap<String, Integer>();

		for(int j=0;j<6;j++){
			for(int i=0 ; i<mundo.getContinentes()[j].getTerritorios().length ; i++){
				snap.put(mundo.getContinentes()[j].getTerritorios()[i].getNome(), mundo.getContinentes()[j].getTerritorios()[i].getExercitos());
			}
		}

		mundo.getR().getAtual().setSnap(snap);

	}

	public static void troca() {
		int aux = mundo.getR().getAtual().getnExercitosDaVez();

		if(aux != 0 && !mundo.getR().getAtual().isJaTrocou()){
			if(mundo.getR().getAtual().getJogador().getCartas().size() >= 3){
				int quad = 0;
				int tria = 0;
				int circ = 0;

				ListIterator<Carta> li = mundo.getR().getAtual().getJogador().getCartas().listIterator();

				Carta[] q = new Carta[3];
				Carta[] t = new Carta[3];
				Carta[] c = new Carta[3];

				while(li.hasNext()){
					Carta aux1 = li.next();

					System.out.println(aux1);
					System.out.println(aux1.getTerritorio() );
					System.out.println(aux1.getTerritorio().getSimb());

					switch(aux1.getTerritorio().getSimb()){
					case QUADRADO:
						q[quad] = aux1;
						quad++;
						break;
					case TRIANGULO:
						t[tria] = aux1;
						tria++;
						break;
					case CIRCULO:
						c[circ] = aux1;
						circ++;
						break;
					}
				}


				if(quad!=0 && tria!=0 && circ!=0){
					mundo.getR().getAtual().getJogador().getCartas().remove(q[0]);
					mundo.getR().getAtual().getJogador().getCartas().remove(t[0]);
					mundo.getR().getAtual().getJogador().getCartas().remove(c[0]);
				}
				else if(quad==3){
					mundo.getR().getAtual().getJogador().getCartas().remove(q[0]);
					mundo.getR().getAtual().getJogador().getCartas().remove(q[1]);
					mundo.getR().getAtual().getJogador().getCartas().remove(q[2]);

				}
				else if(tria==3){
					mundo.getR().getAtual().getJogador().getCartas().remove(t[0]);
					mundo.getR().getAtual().getJogador().getCartas().remove(t[1]);
					mundo.getR().getAtual().getJogador().getCartas().remove(t[2]);

				}
				else if(circ==3){
					mundo.getR().getAtual().getJogador().getCartas().remove(c[0]);
					mundo.getR().getAtual().getJogador().getCartas().remove(c[1]);
					mundo.getR().getAtual().getJogador().getCartas().remove(c[2]);

				}

				else{
					return;
				}

			}
			else{
				return;
			}

			mundo.getR().getAtual().setnExercitosDaVez(aux + mundo.getTabTroca().proximoValor());
			mundo.getR().getAtual().setJaTrocou(true);
		}


	}

	public static void conquistou() {
		mundo.getR().getAtual().setPodeReceberCarta(true);

	}

	public static void verificaGanhador() {
		final String[] cartasObjetivo = new String[14];
		cartasObjetivo[0] = "Destruir totalmente os exercitos azuis.\n Se voce � quem possui os exercitos azuis,\n ou se o jogador que os possuir for eliminado\n por outro jogador\n, o seu objetivo passa a ser\n conquistar 24 territorios";
		cartasObjetivo[1] = "Destruir totalmente os exercitos verdes.\n Se voce � quem possui os exercitos verdes,\n ou se o jogador que os possuir for eliminado\n por outro jogador\n, o seu objetivo passa a ser\n conquistar 24 territorios";
		cartasObjetivo[2] = "Destruir totalmente os exercitos amarelos.\n Se voce � quem possui os exercitos amarelos,\n ou se o jogador que os possuir for eliminado\n por outro jogador\n, o seu objetivo passa a ser\n conquistar 24 territorios";
		cartasObjetivo[3] = "Destruir totalmente os exercitos vermelhos.\n Se voce � quem possui os exercitos vermelhos,\n ou se o jogador que os possuir for eliminado\n por outro jogador\n, o seu objetivo passa a ser\n conquistar 24 territorios";
		cartasObjetivo[4] = "Destruir totalmente os exercitos brancos.\n Se voce � quem possui os exercitos brancos,\n ou se o jogador que os possuir for eliminado\n por outro jogador\n, o seu objetivo passa a ser\n conquistar 24 territorios";
		cartasObjetivo[5] = "Destruir totalmente os exercitos pretos.\n Se voce � quem possui os exercitos pretos,\n ou se o jogador que os possuir for eliminado\n por outro jogador\n, o seu objetivo passa a ser\n conquistar 24 territorios";
		cartasObjetivo[6] = "Conquistar na totalidade a Europa, Oceania\n e mais um continente a sua escolha";
		cartasObjetivo[7] = "Conquistar na totalidade\n a �sia e a �frica";
		cartasObjetivo[8] = "Conquistar na totalidade\n a Am�rica do Norte e a Oceania";
		cartasObjetivo[9] = "Conquistar na totalidade a Europa,\n a �frica do Sul e mais um\n continete a sua escolha";
		cartasObjetivo[10] = "Conquistar na totalidade a �sia\n e a Am�rica do Sul";
		cartasObjetivo[11] = "Conquistar 24 territ�rios\n a sua escolha";
		cartasObjetivo[12] = "Conquistar na totalidade a\n Am�rica do Norte e a �frica";
		cartasObjetivo[13] = "Conquistar 18 territ�rios e ocupar\n cada um deles com pelo menos 2 ex�rcitos";

		String aux = mundo.getR().getAtual().getJogador().getObj();
		System.out.println(aux);
		ControladorInicial.verificaContinentes();

		if(aux.equals(cartasObjetivo[0])){
			if(mundo.getR().getAtual().getJogador().getCor().equals("azul.png")){
				if(mundo.getR().getAtual().getJogador().getTerritoriosPossuidos().size() > 23){
					System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
					ControladorFluxo.novoFrameGanhouOJogo();
				}
				
			}
			boolean flag = false;
			for(int i=0 ; i<6 && mundo.getJogadores()[i] != null ;i++){
				if(mundo.getJogadores()[i].getCor().equals("azul.png")){
					flag = true; 
				}
			}
			if(flag == false){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}
		}
		else if(aux.equals(cartasObjetivo[1])){
			if(mundo.getR().getAtual().getJogador().getCor().equals("verde.png")){
				if(mundo.getR().getAtual().getJogador().getTerritoriosPossuidos().size() > 23){
					System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
					ControladorFluxo.novoFrameGanhouOJogo();
				}
				
			}
			boolean flag = false;
			for(int i=0 ; i<6 && mundo.getJogadores()[i] != null ;i++){
				if(mundo.getJogadores()[i].getCor().equals("verde.png")){
					flag = true; 
				}
			}
			if(flag == false){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}

		}
		else if(aux.equals(cartasObjetivo[2])){
			if(mundo.getR().getAtual().getJogador().getCor().equals("amarelo.png")){
				if(mundo.getR().getAtual().getJogador().getTerritoriosPossuidos().size() > 23){
					System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
					ControladorFluxo.novoFrameGanhouOJogo();
				}
				
			}
			boolean flag = false;
			for(int i=0 ; i<6 && mundo.getJogadores()[i] != null ;i++){
				if(mundo.getJogadores()[i].getCor().equals("verde.png")){
					flag = true; 
				}
			}
			if(flag == false){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}

		}
		else if(aux.equals(cartasObjetivo[3])){
			if(mundo.getR().getAtual().getJogador().getCor().equals("vermelho.png")){
				if(mundo.getR().getAtual().getJogador().getTerritoriosPossuidos().size() > 23){
					System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
					ControladorFluxo.novoFrameGanhouOJogo();
				}
				
			}
			boolean flag = false;
			for(int i=0 ; i<6 && mundo.getJogadores()[i] != null ;i++){
				if(mundo.getJogadores()[i].getCor().equals("vermelho.png")){
					flag = true; 
				}
			}
			if(flag == false){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}

		}
		else if(aux.equals(cartasObjetivo[4])){
			if(mundo.getR().getAtual().getJogador().getCor().equals("branco.png")){
				if(mundo.getR().getAtual().getJogador().getTerritoriosPossuidos().size() > 23){
					System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
					ControladorFluxo.novoFrameGanhouOJogo();
				}
				
			}
			boolean flag = false;
			for(int i=0 ; i<6 && mundo.getJogadores()[i] != null ;i++){
				if(mundo.getJogadores()[i].getCor().equals("branco.png")){
					flag = true; 
				}
			}
			if(flag == false){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}

		}
		else if(aux.equals(cartasObjetivo[5])){
			if(mundo.getR().getAtual().getJogador().getCor().equals("preto.png")){
				if(mundo.getR().getAtual().getJogador().getTerritoriosPossuidos().size() > 23){
					System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
					ControladorFluxo.novoFrameGanhouOJogo();
				}
				
			}
			boolean flag = false;
			for(int i=0 ; i<6 && mundo.getJogadores()[i] != null ;i++){
				if(mundo.getJogadores()[i].getCor().equals("preto.png")){
					flag = true; 
				}
			}
			if(flag == false){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}

		}
		else if(aux.equals(cartasObjetivo[6])){

			if(ControladorPainelOpcoes.pertenceAoAtual("Europa") && ControladorPainelOpcoes.pertenceAoAtual("Oceania") && mundo.getR().getAtual().getJogador().getContinentesPossuidos().size() >= 3){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}

		}
		else if(aux.equals(cartasObjetivo[7])){
			if(ControladorPainelOpcoes.pertenceAoAtual("Asia") && ControladorPainelOpcoes.pertenceAoAtual("Africa")){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}

		}
		else if(aux.equals(cartasObjetivo[8])){
			if(ControladorPainelOpcoes.pertenceAoAtual("America do Norte") && ControladorPainelOpcoes.pertenceAoAtual("Oceania")){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}

		}
		else if(aux.equals(cartasObjetivo[9])){
			if(ControladorPainelOpcoes.pertenceAoAtual("Europa") && ControladorPainelOpcoes.pertenceAoAtual("America do Sul") && mundo.getR().getAtual().getJogador().getContinentesPossuidos().size() >= 3){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}


		}
		else if(aux.equals(cartasObjetivo[10])){
			if(ControladorPainelOpcoes.pertenceAoAtual("Asia") && ControladorPainelOpcoes.pertenceAoAtual("America do Sul")){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}

		}
		else if(aux.equals(cartasObjetivo[11])){
			if(mundo.getR().getAtual().getJogador().getTerritoriosPossuidos().size() > 23){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}

		}
		else if(aux.equals(cartasObjetivo[12])){
			if(ControladorPainelOpcoes.pertenceAoAtual("Africa") && ControladorPainelOpcoes.pertenceAoAtual("America do Norte")){
				System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
				ControladorFluxo.novoFrameGanhouOJogo();
			}

		}
		else if(aux.equals(cartasObjetivo[13])){
			if(mundo.getR().getAtual().getJogador().getTerritoriosPossuidos().size() > 17){
				ListIterator<Territorio> li = mundo.getR().getAtual().getJogador().getTerritoriosPossuidos().listIterator();
				boolean flag = false;
				while(li.hasNext()){
					if(!(li.next().getExercitos() > 1)){
						flag=true;
						break;
					}
				}
				if(flag==false){
					System.out.println(mundo.getR().getAtual().getJogador().getNome() + "ganhou");
					ControladorFluxo.novoFrameGanhouOJogo();
				}
			}
		}

	}
}
