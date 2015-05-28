package Modelos;

public class Cor {
	int r,g,b;

	public Cor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public boolean equals(Object obj){
		Cor aux = (Cor)obj;
		if(aux.getR() == this.getR() && aux.getG() == this.getG() && aux.getB() == this.getB()){
			return true;
		}
		else if((aux.getR()*2 - this.getR() < 40) && (aux.getG()*2 - this.getG() < 40) && (aux.getB()*2 - this.getB() < 40)){
			return true;
		}
		else if((aux.getR()*3 - this.getR() < 40) && (aux.getG()*3 - this.getG() < 40) && (aux.getB()*3 - this.getB() < 40)){
			return true;
		}
		else if((aux.getR()*4 - this.getR() < 40) && (aux.getG()*4 - this.getG() < 40) && (aux.getB()*4 - this.getB() < 40)){
			return true;
		}
		else if((aux.getR()*5 - this.getR() < 40) && (aux.getG()*5 - this.getG() < 40) && (aux.getB()*5 - this.getB() < 40)){
			return true;
		}
		else{
			return false;
			
		}
	}

}
