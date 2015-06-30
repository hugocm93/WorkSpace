import Controladores.ControladorFluxo;
import Interface.Constantes;

public class Jogo {

	public static void main(String[] args) {
		String aux = OSValidator.detectOS();
		
		switch(aux){
		case "Windows":
			Constantes.setConstMagica(0);
			Constantes.setAlturaPainel(125);
			break;
			
		case "Mac":
			Constantes.setConstMagica(0);
			Constantes.setAlturaPainel(125);
			break;
			
		case "Linux":
			break;
			
		}
		ControladorFluxo.criaJanela();
	}

}
