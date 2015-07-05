package Controladores;

import javax.swing.ImageIcon;
import java.util.*;
import Interface.Observable;
import Interface.Observer;
import Modelos.Dado;
import Modelos.Mundo;
import Modelos.Territorio;
import Modelos.TipoDado;

public class ControladorFrameDados implements Observable {

	private List<Observer> observers = new ArrayList();
	private static Mundo mundo = Mundo.getInstance();

	public static  void jogarDadosAtaque(int nExercitosAtaque){

		for(int i=0;i<3;i++){
			mundo.getDadosAtaque()[i].reseta();
		}

		if(nExercitosAtaque<=3){
			for(int i=0;i<nExercitosAtaque-1;i++){
				mundo.getDadosAtaque()[i].rolar_dado();
			}
		}
		else{
			for(int i=0;i<3;i++){
				mundo.getDadosAtaque()[i].rolar_dado();
			}
		}

	}

	public static void jogarDadosDefesa(int nExercitosDefesa){

		for(int i=0;i<3;i++){
			mundo.getDadosDefesa()[i].reseta();
		}

		if(nExercitosDefesa<=3){
			for(int i=0;i<nExercitosDefesa;i++){
				mundo.getDadosDefesa()[i].rolar_dado();
			}
		}
		else{
			for(int i=0;i<3;i++){
				mundo.getDadosDefesa()[i].rolar_dado();
			}
		}

	}

	public static ImageIcon[] getNomesDasImagensDosDadosDeAtaque(){
		ImageIcon[] ret = new ImageIcon[3];

		for(int i=0;i<3;i++){
			ret[i] = mundo.getDadosAtaque()[i].getIcon();
		}

		return ret;
	}

	public static ImageIcon[] getNomesDasImagensDosDadosDeDefesa(){
		ImageIcon[] ret = new ImageIcon[3];

		for(int i=0;i<3;i++){
			ret[i] = mundo.getDadosDefesa()[i].getIcon();
		}

		return ret;
	}

	public static void ordenarDadosDeAtaque() {

		ControladorFrameDados.ordenarDados(TipoDado.ATAQUE);

	}

	public static void ordenarDadosDeDefesa() {

		ControladorFrameDados.ordenarDados(TipoDado.DEFESA);

	}

	static void ordenarDados(TipoDado t){
		if(t == TipoDado.ATAQUE){

			Dado[] dadosAtaque = mundo.getDadosAtaque();

			int fim=3;

			for(;fim>0;fim--){
				for(int j=0;j<fim-1;j++){
					if(dadosAtaque[j].getValor() < dadosAtaque[j+1].getValor()){
						Dado aux = dadosAtaque[j];
						dadosAtaque[j] = dadosAtaque[j+1];
						dadosAtaque[j+1] = aux;
					}
				}
			}
		}
		else{
			int fim=3;

			Dado[] dadosDefesa = mundo.getDadosDefesa();

			for(;fim>0;fim--){
				for(int j=0;j<fim-1;j++){
					if(dadosDefesa[j].getValor() < dadosDefesa[j+1].getValor()){
						Dado aux = dadosDefesa[j];
						dadosDefesa[j] = dadosDefesa[j+1];
						dadosDefesa[j+1] = aux;
					}
				}
			}
		}
	}


	public static boolean compararDados(){

		Dado[] dadosDefesa = mundo.getDadosDefesa();
		Dado[] dadosAtaque = mundo.getDadosAtaque();

		for(int i=0; i<3 &&  dadosDefesa[i].getValor()!=0 && dadosAtaque[i].getValor()!=0 ; i++){
			if(dadosDefesa[i].getValor() >= dadosAtaque[i].getValor()){
				ControladorMapa.retiraExer(mundo.getR().getAtual().getAtacante().getNome());

			}
			else{
				ControladorMapa.retiraExer(mundo.getR().getAtual().getDefensor().getNome());
				if(mundo.getR().getAtual().getDefensor().getExercitos() == 0){
					ControladorFrameDados.colocaTerritorioNoAtacante(mundo.getR().getAtual().getDefensor().getNome());
					return true; 
				}	
			}
		}
		return false;
	}
	
	public static void colocaTerritorioNoAtacante(String aux) {
		Territorio t = mundo.getTerritorios().get(aux);
		if(t==null){
			return ;
		}

		if(t.getDono().getNome().equals(mundo.getR().getAtual().getDefensor().getDono().getNome())){

			mundo.getR().getAtual().getDefensor().getDono().getTerritoriosPossuidos().remove(t);
			mundo.getR().getAtual().getAtacante().getDono().getTerritoriosPossuidos().add(t);
			t.setDono(mundo.getR().getAtual().getAtacante().getDono());
			mundo.getR().getAtual().getAtacante().exerMenos();
			t.exerMais();

			return ;

		}
	}
	
	public static String getNomeDefensor(){
		return mundo.getR().getAtual().getDefensor().getDono().getNome();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer ob : observers) {
            System.out.println("Notificando observers!");
              ob.update(getNomeDefensor());
            }
	}


}
