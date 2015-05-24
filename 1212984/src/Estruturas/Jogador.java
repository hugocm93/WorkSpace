package Estruturas;

import Mapa.*;

public class Jogador {

		Cor cor;
		Objetivo obj;
		Carta[] cartas;
		Territorio[] territoriosPossuidos;
		Continente[] continentesPossuidos;
		
		public int nExercitosPossuidos(){
			
			return 0;
		}

		public Cor getCor() {
			return cor;
		}

		public void setCor(Cor cor) {
			this.cor = cor;
		}

		public Objetivo getObj() {
			return obj;
		}

		public void setObj(Objetivo obj) {
			this.obj = obj;
		}

		public Carta[] getCartas() {
			return cartas;
		}

		public void setCartas(Carta[] cartas) {
			this.cartas = cartas;
		}

		public Territorio[] getTerritoriosPossuidos() {
			return territoriosPossuidos;
		}

		public void setTerritoriosPossuidos(Territorio[] territoriosPossuidos) {
			this.territoriosPossuidos = territoriosPossuidos;
		}

		public Continente[] getContinentesPossuidos() {
			return continentesPossuidos;
		}

		public void setContinentesPossuidos(Continente[] continentesPossuidos) {
			this.continentesPossuidos = continentesPossuidos;
		}
		
		
}
