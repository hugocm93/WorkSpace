package Mapa;

import Estruturas.*;
import Geometria.*;
import java.awt.*;

public class Mundo {
	
		Continente[] continentes;
		Tabela1 tabTroca;
		Jogador[] jogadores;
		Dado[] dadosAtaque;
		Dado[] dadosDefesa;
		
		public Mundo(){
			
			tabTroca = new Tabela1();
			continentes = new Continente[6]; 
			
			String nome;
			Territorio[] territorios;
			Cor cor;
			int exercitosTabela;
			String nomeT;
			Poligono poligono;
			Simbolo simb;
			String[] territoriosFronteira;
			
			
			///////
			
			nome = "América do Norte";
			cor = new Cor(238,64,54);
			exercitosTabela = 5;
			territorios = new Territorio[9];
						
				nomeT = "Alasca";
					poligono = new Poligono(new Point[]{new Point(90,149),new Point(140,150),new Point(117,194),new Point(63,195)});
					simb = Simbolo.TRIANGULO;
					territoriosFronteira = new String[]{new String("Sibéria"),new String("Calgary"),new String("Vancouver")};
				territorios[0] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);
				
				nomeT = "Calgary";
					poligono = new Poligono(new Point[]{new Point(140,151),new Point(155,151),new Point(159,156),new Point(218,155),new Point(223,164),new Point(241,164),new Point(253,143),new Point(284,143),new Point(295,164),new Point(271,166),new Point(257,191),new Point(241,191),new Point(234,205),new Point(153,206),new Point(133,168)});
					simb = Simbolo.CIRCULO;
					territoriosFronteira = new String[]{new String("Alasca"),new String("Vancouver"),new String("Québec")};
				territorios[1] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);
				
				nomeT = "Groelândia";
					poligono = new Poligono(new Point[]{new Point(298,119),new Point(387,120),new Point(397,131),new Point(388,146),new Point(382,146),new Point(366,174),new Point(350,176),new Point(343,166),new Point(295,164),new Point(284,143)});
					simb = Simbolo.CIRCULO;
					territoriosFronteira = new String[]{new String("Reino Unido"),new String("Calgary"),new String("Québec")};
				territorios[2] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);
				
				nomeT = "Vancouver";
					poligono = new Poligono(new Point[]{new Point(133,167),new Point(153,206),new Point(233,206),new Point(241,221),new Point(225,249),new Point(113,250),new Point(108,242),new Point(126,212),new Point(118,195)});
					simb = Simbolo.TRIANGULO;
					territoriosFronteira = new String[]{new String("Alasca"),new String("Calgary'"),new String("Québec"),new String("Texas"),new String("Califórnia")};
				territorios[3] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);
				
				nomeT = "Québec";
					poligono = new Poligono(new Point[]{new Point(242,219),new Point(273,219),new Point(284,200),new Point(294,199),new Point(302,188),new Point(333,187),new Point(335,190),new Point(355,190),new Point(359,200),new Point(352,212),new Point(347,206),new Point(338,221),new Point(345,234),new Point(339,245),new Point(326,246),new Point(329,237),new Point(318,237),new Point(309,250),new Point(224,249)});
					simb = Simbolo.CIRCULO;
					territoriosFronteira = new String[]{new String("Groelândia"),new String("Vancouver"),new String("Texas"),new String("Nova York")};
				territorios[4] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);
			
				nomeT = "Califórnia";
					poligono = new Poligono(new Point[]{new Point(113,251),new Point(185,250),new Point(132,344),new Point(94,343),new Point(82,323),new Point(94,301),new Point(87,289)});
					simb = Simbolo.QUADRADO;
					territoriosFronteira = new String[]{new String("Vancouver"),new String("Texas"),new String("México")};
				territorios[5] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);
		
				nomeT = "Texas";
					poligono = new Poligono(new Point[]{new Point(186,251),new Point(257,250),new Point(243,279),new Point(211,280),new Point(153,378),new Point(132,344)});
					simb = Simbolo.TRIANGULO;
					territoriosFronteira = new String[]{new String("Vancouver"),new String("Québec"),new String("Nova York"),new String("México"),new String("Califórnia")};
				territorios[6] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);
	
				nomeT = "Nova York";
					poligono = new Poligono(new Point[]{new Point(256,251),new Point(309,252),new Point(304,262),new Point(291,263),new Point(273,296),new Point(255,296),new Point(248,312),new Point(242,312),new Point(225,340),new Point(216,340),new Point(210,353),new Point(221,373),new Point(215,383),new Point(191,343),new Point(174,343),new Point(211,279),new Point(242,278)});
					simb = Simbolo.QUADRADO;
					territoriosFronteira = new String[]{new String("Texas"),new String("Québec")};
				territorios[7] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

				nomeT = "México";
					poligono = new Poligono(new Point[]{new Point(96,344),new Point(132,345),new Point(159,391),new Point(170,390),new Point(172,384),new Point(178,396),new Point(173,404),new Point(197,443),new Point(188,460),new Point(181,445),new Point(170,445),new Point(152,413),new Point(143,413),new Point(111,360),new Point(108,365),new Point(116,381),new Point(108,394),new Point(88,358)});
					simb = Simbolo.QUADRADO;
					territoriosFronteira = new String[]{new String("Califórnia"), new String("Texas"),new String("Venezuela")};
				territorios[8] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);
						
			continentes[0] = new Continente(nome, territorios, cor, null, exercitosTabela);
			
			////////
			
			////////
			
			nome = "América do Sul";
			cor = new Cor(0,104,56);
			exercitosTabela = 2;
			territorios = new Territorio[4];
			
				nomeT = "Argentina";
					poligono = new Poligono(new Point[]{new Point(286,548),new Point(348,547),new Point(316,603),new Point(325,617),new Point(294,672),new Point(309,698),new Point(291,699),new Point(245,617)});
					simb = Simbolo.QUADRADO;
					territoriosFronteira = new String[]{new String("Brasil"), new String("Peru")};
				territorios[0] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);
				
				nomeT = "Venezuela";
					poligono = new Poligono(new Point[]{new Point(203,437),new Point(266,435),new Point(205,538),new Point(198,523),new Point(184,523),new Point(169,496)});
					simb = Simbolo.TRIANGULO;
					territoriosFronteira = new String[]{new String("México"),new String("Brasil"),new String("Peru")};
				territorios[1] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

			
				nomeT = "Brasil";
					poligono = new Poligono(new Point[]{new Point(265,436),new Point(272,445),new Point(298,445),new Point(306,461),new Point(320,461),new Point(330,484),new Point(350,484),new Point(359,500),new Point(340,531),new Point(348,547),new Point(287,546),new Point(245,474)});
					simb = Simbolo.CIRCULO;
					territoriosFronteira = new String[]{new String("Venezuela"),new String("Peru"),new String("Argentina"), new String("Nigéria")};
				territorios[2] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		
				nomeT = "Peru";
					poligono = new Poligono(new Point[]{new Point(245,475),new Point(286,546),new Point(251,608),new Point(238,589),new Point(242,582),new Point(225,550),new Point(212,550),new Point(207,540)});
					simb = Simbolo.TRIANGULO;
					territoriosFronteira = new String[]{new String("Venezuela"),new String("Brasil"),new String("Argentina")};
				territorios[3] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

			continentes[1] = new Continente(nome, territorios, cor, null, exercitosTabela);
			
			////////
//			
//			nome = "África";
//			cor = new Cor(101,45,144);
//			exercitosTabela = 3;
//			//territorios = ;
//			//continentes[0] = new Continente(nome, territorios, cor, null, exercitosTabela);
//			
//			nome = "Europa";
//			cor = new Cor(43,56,143);
//			exercitosTabela = 5;
//			//territorios = ;
//			//continentes[0] = new Continente(nome, territorios, cor, null, exercitosTabela);
//			
//			nome = "Ásia";
//			cor = new Cor(246,146,30);
//			exercitosTabela = 7;
//			//territorios = ;
//			//continentes[0] = new Continente(nome, territorios, cor, null, exercitosTabela);
//			
//			nome = "Oceania";
//			cor = new Cor(38,169,224);
//			exercitosTabela = 2;
//			//territorios = ;
//			//continentes[0] = new Continente(nome, territorios, cor, null, exercitosTabela);
			
			
			
			
		}
		

		public Continente[] getContinentes() {
			return continentes;
		}
		
}
