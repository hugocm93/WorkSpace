package Controladores;

import Interface.Fase;
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
		Jogador[] jogadores = mundo.getJogadores();
		int aux = mundo.getR().getIndexTurno();
		int aux2 = mundo.getR().getIndexRodada();
		int u;
		for(u=0; u<6 && jogadores[u]!=null ;u++);

		//System.out.println("aux2: " + aux2);
		System.out.println(mundo.getR().getTurnos().get(aux).getIndexJogador() + "-" + u);

		if(mundo.getR().getTurnos().get(aux).getIndexJogador() == 0){
			ControladorInicial.criaTurnos();
			mundo.getR().setIndexRodada(++aux2);
		}
	}

	public static boolean permitidoPassar(String name) {
		if(mundo.getR().getAtual().getJogador().getNome().equals(name)){
			if(mundo.getR().getAtual().getnExercitosDaVez() == 0){
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
		// TODO Auto-generated method stub

		for(Territorio t : mundo.getR().getAtual().getJogador().getTerritoriosPossuidos()){
			if(t.getNome().equals(name)){
				mundo.getR().getAtual().setAtacante(t);

			}
		}

	}

	public static void setarDefensor(String name) {
		// TODO Auto-generated method stub
		for(Territorio t : mundo.getR().getAtual().getJogador().getTerritoriosPossuidos()){
			if(t.getNome().equals(name)){

			}
		}
		for(Continente c : mundo.getContinentes()){
			for(Territorio s : c.getTerritorios()){
				if(s.getNome().equals(name)){
					mundo.getR().getAtual().setDefensor(s);
					System.out.println(s.getBase());
				}
			}
		}

	}

	public static void fimAtaque() {
		// TODO Auto-generated method stub

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
		if(mundo.getR().getAtual().getnExercitosDaVez() > 0){
			mundo.getR().getAtual().setF(Fase.RECEBENDO);
		}
		if(mundo.getR().getAtual().getnExercitosDaVez() == 0 && !ControladorPainelOpcoes.isNotPrimeiraRodada()){
			mundo.getR().getAtual().setF(Fase.FIM);
		}
		if(mundo.getR().getAtual().getnExercitosDaVez() == 0 && ControladorPainelOpcoes.isNotPrimeiraRodada()){
			mundo.getR().getAtual().setF(Fase.ATAQUE);
		}
		if(mundo.getR().getAtual().isFimFaseAtaque()){
			mundo.getR().getAtual().setF(Fase.DESLOCAMENTO);
		}



		return mundo.getR().getAtual().getF();
	}

	public static boolean podeAtacar() {
		if(mundo.getR().getAtual().getAtacante() != null && mundo.getR().getAtual().getDefensor() != null){
			return true;
		}
		return false;
	}
}
