package Modelos;
import java.awt.*;

public class Poligono {
	Point[] vertices;
	
	public Poligono(Point[] vertices) {

		this.vertices = vertices;
		
	}

	public boolean dentroPolig(Point p){
		
		int i, j;
		
		boolean c = false;
		
		  for (i = 0, j = vertices.length-1; i < vertices.length; j = i++) {
		    if ( ((vertices[i].getY() > p.getY()) != (vertices[j].getY() > p.getY() )) &&
			 (p.getX() < (vertices[j].getX() - vertices[i].getX()) * (p.getY() -vertices[i].getY()) / (vertices[j].getY()-vertices[i].getY()) + vertices[i].getX()) )
		       c = !c;
		  }
		  
		  return c;
	}

}
