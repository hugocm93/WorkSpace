package Interface;

public abstract class Constantes {

	private static int largura = 1024;
	private static int altura = 768;
	private static int constMagica = 0;

	//	public static int largura = 800;
	//	public static int altura = 600;
	//	public static int constMagica = 10;


	private static int largImg = 2133;
	private static int altImg = 1600;

	private static float constConversao = (float)altImg/altura;
	private static float constConversao2 = (float)largImg/largura;
	private static float constConversaoX = (float)largura/1067;
	private static float constConversaoY = (float)altura/800;

	private static int deslocamento = Math.round(80*constConversaoY);
	private static int deslocamento2 = 80;
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
