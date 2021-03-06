package Modelos;

import java.util.ArrayList;

public class Rodada {
	
	ArrayList<Turno> turnos;
	int indexTurno;
	Turno atual;
	public static int indexRodada;
	
	

	public Rodada(ArrayList<Turno> turnos, Turno atual) {
		super();
		this.turnos = turnos;
		this.atual = atual;
	}

	public ArrayList<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(ArrayList<Turno> turnos) {
		this.turnos = turnos;
	}

	public Turno getAtual() {
		return atual;
	}

	public void setAtual(Turno atual) {
		this.atual = atual;
	}
	
	public void proxTurno(){
		indexTurno++;
		atual = this.get();
		
	}
	
    public void turnoAnt(){
    	indexTurno--;
    	atual = this.get();
		
	} 
    
    
    public int getIndexRodada() {
		return Rodada.indexRodada;
	}

	public void setIndexRodada(int indexRodada) {
		Rodada.indexRodada = indexRodada;
	}
	
	public int getIndexTurno() {
		return indexTurno;
	}

	public void setIndexTurno(int indexTurno) {
		this.indexTurno = indexTurno;
	}

	public Turno get(){
        if (this.indexTurno == -1)
        {
            this.indexTurno = turnos.size()-1;
        }

        else if (this.indexTurno >= turnos.size())
        {
            this.indexTurno = 0;
        }

        return turnos.get(this.indexTurno);
    }
	
	

}


