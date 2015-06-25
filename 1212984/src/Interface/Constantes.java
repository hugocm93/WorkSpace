package Interface;

public abstract class Constantes {

	//public static int largura = 1067;
	//public static int altura = 800;
	//public static int constMagica = 0;
	public static int largura = 1024;
	public static int altura = 768;
	public static int constMagica = 10;
	public static int largImg = 2133;
	public static int altImg = 1600;
	public static float constConversao = (float)altImg/altura;
	public static float constConversao2 = (float)largImg/largura;
	public static float constConversaoX = (float)largura/1067;
	public static float constConversaoY = (float)altura/800;
	public static int deslocamento2 = 80;
	public static int deslocamento = Math.round(deslocamento2*constConversaoY);


	public static int getLargura() {
		return largura;
	}
	public static int getAltura() {
		return altura;
	}
	public static int getConstMagica() {
		return constMagica;
	}
	public static int getLargImg() {
		return largImg;
	}
	public static int getAltImg() {
		return altImg;
	}
	public static float getConstConversao() {
		return constConversao;
	}
	public static float getConstConversao2() {
		return constConversao2;
	}
	public static float getConstConversaoX() {
		return constConversaoX;
	}
	public static float getConstConversaoY() {
		return constConversaoY;
	}
	public static int getDeslocamento() {
		return deslocamento;
	}
	public static int getDeslocamento2() {
		return deslocamento2;
	}

}
