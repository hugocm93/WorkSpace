package Controladores;

import java.util.HashMap;

import Interface.Fase;
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
		try{
			if(mundo.getR().getAtual().getnExercitosDaVezContinente().get("America do Norte").intValue() > 0){
				mundo.getR().getAtual().setF(Fase.RECEBENDOAM);
			}
		}
		catch(Exception e){

		}
		try{
			if(mundo.getR().getAtual().getnExercitosDaVezContinente().get("America do Sul").intValue() > 0){
				mundo.getR().getAtual().setF(Fase.RECEBENDOAS);
			}
		}
		catch(Exception e){

		}
		try{
			if(mundo.getR().getAtual().getnExercitosDaVezContinente().get("Africa").intValue() > 0){
				mundo.getR().getAtual().setF(Fase.RECEBENDOA);
			}
		}
		catch(Exception e){

		}
		try{
			if(mundo.getR().getAtual().getnExercitosDaVezContinente().get("Europa").intValue() > 0){
				mundo.getR().getAtual().setF(Fase.RECEBENDOEU);
			}
		}
		catch(Exception e){

		}
		try{
			if(mundo.getR().getAtual().getnExercitosDaVezContinente().get("Asia").intValue() > 0){
				mundo.getR().getAtual().setF(Fase.RECEBENDOASI);
			}
		}
		catch(Exception e){

		}
		try{
			if(mundo.getR().getAtual().getnExercitosDaVezContinente().get("Oceania").intValue() > 0){
				mundo.getR().getAtual().setF(Fase.RECEBENDOOC);
			}
		}
		catch(Exception e){

		}
		if(mundo.getR().getAtual().getnExercitosDaVez() > 0){
			mundo.getR().getAtual().setF(Fase.RECEBENDO);
		}

		return mundo.getR().getAtual().getF();
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
}
