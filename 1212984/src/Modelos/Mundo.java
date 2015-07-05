package Modelos;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Interface.Observable;
import Interface.Observer;

public class Mundo implements Observable{

	private List<Observer> observers = new ArrayList<Observer>();
	Continente[] continentes;
	Tabela1 tabTroca;
	Jogador[] jogadores;
	int nJogadores;
	Dado[] dadosAtaque;
	Dado[] dadosDefesa;
	Rodada r;
	HashMap<String, Territorio> territorios;
	String[] cartasObjetivo;
	Baralho cartasTroca;
	ArrayList<String> objDisponiveis = new ArrayList<String>();
	ArrayList<Carta> cartasDisponiveis = new ArrayList<Carta>();
	static String[] rets;

	private static Mundo instance;

	public static Mundo getInstance() {
		if (instance == null)
			instance = new Mundo();
		return instance;
	}

	private Mundo(){

		tabTroca = new Tabela1();
		continentes = new Continente[6]; 
		jogadores = new Jogador[6]; 
		dadosAtaque = new Dado[3];
		dadosDefesa = new Dado[3];
		territorios = new HashMap<String, Territorio>();


		for(int i=0;i<3;i++){
			dadosAtaque[i] = new Dado();
			dadosAtaque[i].setTipo(TipoDado.ATAQUE);
		}

		for(int i=0;i<3;i++){
			dadosDefesa[i] = new Dado();
			dadosDefesa[i].setTipo(TipoDado.DEFESA);
		}

		String nome;
		Territorio[] territorios;
		Cor cor;
		int exercitosTabela;
		String nomeT;
		Poligono poligono;
		Simbolo simb;
		Point base=null;
		String[] territoriosFronteira;
		Carta[] cartas = new Carta[53];


		///////

		nome = "America do Norte";
		cor = new Cor(238,64,54);
		exercitosTabela = 5;
		territorios = new Territorio[9];

		nomeT = "Alasca";
		poligono = new Poligono(new Point[]{new Point(90,149),new Point(140,150),new Point(117,194),new Point(63,195)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Siberia"),new String("Calgary"),new String("Vancouver")};
		base = new Point(107,169); 
		territorios[0] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[6] = new Carta(null, "war_carta_an_alasca.png", territorios[0]);
		
		nomeT = "Calgary";
		poligono = new Poligono(new Point[]{new Point(140,151),new Point(155,151),new Point(159,156),new Point(218,155),new Point(223,164),new Point(241,164),new Point(253,143),new Point(284,143),new Point(295,164),new Point(271,166),new Point(257,191),new Point(241,191),new Point(234,205),new Point(153,206),new Point(133,168)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Alasca"),new String("Vancouver"),new String("Quebec")};
		base = new Point(195,173);
		territorios[1] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[7] = new Carta(null, "war_carta_an_calgary.png", territorios[1]);
		
		nomeT = "Groelandia";
		poligono = new Poligono(new Point[]{new Point(298,119),new Point(387,120),new Point(397,131),new Point(388,146),new Point(382,146),new Point(366,174),new Point(350,176),new Point(343,166),new Point(295,164),new Point(284,143)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Reino Unido"),new String("Calgary"),new String("Quebec")};
		base = new Point(349,174);
		territorios[2] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[9] = new Carta(null, "war_carta_an_groelandia.png", territorios[2]);
		
		nomeT = "Vancouver";
		poligono = new Poligono(new Point[]{new Point(133,167),new Point(153,206),new Point(233,206),new Point(241,221),new Point(225,249),new Point(113,250),new Point(108,242),new Point(126,212),new Point(118,195)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Alasca"),new String("Calgary"),new String("Quebec"),new String("Texas"),new String("California")};
		base = new Point(131,220);
		territorios[3] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[14] = new Carta(null, "war_carta_an_vancouver.png", territorios[3]);
		
		nomeT = "Quebec";
		poligono = new Poligono(new Point[]{new Point(242,219),new Point(273,219),new Point(284,200),new Point(294,199),new Point(302,188),new Point(333,187),new Point(335,190),new Point(355,190),new Point(359,200),new Point(352,212),new Point(347,206),new Point(338,221),new Point(345,234),new Point(339,245),new Point(326,246),new Point(329,237),new Point(318,237),new Point(309,250),new Point(224,249)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Groelandia"),new String("Vancouver"),new String("Texas"),new String("Nova York")};
		base = new Point(309,220);
		territorios[4] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[12] = new Carta(null, "war_carta_an_quebec.png", territorios[4]);
		
		nomeT = "California";
		poligono = new Poligono(new Point[]{new Point(113,251),new Point(185,250),new Point(132,344),new Point(94,343),new Point(82,323),new Point(94,301),new Point(87,289)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Vancouver"),new String("Texas"),new String("Mexico")};
		base = new Point(105,332);
		territorios[5] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[8] = new Carta(null, "war_carta_an_california.png", territorios[5]);
		
		nomeT = "Texas";
		poligono = new Poligono(new Point[]{new Point(186,251),new Point(257,250),new Point(243,279),new Point(211,280),new Point(153,378),new Point(132,344)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Vancouver"),new String("Quebec"),new String("Nova York"),new String("Mexico"),new String("California")};
		base = new Point(158,340);
		territorios[6] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[13] = new Carta(null, "war_carta_an_texas.png", territorios[6]);
		
		nomeT = "Nova York";
		poligono = new Poligono(new Point[]{new Point(256,251),new Point(309,252),new Point(304,262),new Point(291,263),new Point(273,296),new Point(255,296),new Point(248,312),new Point(242,312),new Point(225,340),new Point(216,340),new Point(210,353),new Point(221,373),new Point(215,383),new Point(191,343),new Point(174,343),new Point(211,279),new Point(242,278)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Texas"),new String("Quebec")};
		base = new Point(210,338);
		territorios[7] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[11] = new Carta(null, "war_carta_an_novayork.png", territorios[7]);
		
		nomeT = "Mexico";
		poligono = new Poligono(new Point[]{new Point(96,344),new Point(132,345),new Point(159,391),new Point(170,390),new Point(172,384),new Point(178,396),new Point(173,404),new Point(197,443),new Point(188,460),new Point(181,445),new Point(170,445),new Point(152,413),new Point(143,413),new Point(111,360),new Point(108,365),new Point(116,381),new Point(108,394),new Point(88,358)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("California"), new String("Texas"),new String("Venezuela")};
		base = new Point(133,392);
		territorios[8] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[10] = new Carta(null, "war_carta_an_mexico .png", territorios[8]);
		
		continentes[0] = new Continente(nome, territorios, cor, null, exercitosTabela);

		////////

		////////

		nome = "America do Sul";
		cor = new Cor(0,104,56);
		exercitosTabela = 2;
		territorios = new Territorio[4];

		nomeT = "Argentina";
		poligono = new Poligono(new Point[]{new Point(286,548),new Point(348,547),new Point(316,603),new Point(325,617),new Point(294,672),new Point(309,698),new Point(291,699),new Point(245,617)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Brasil"), new String("Peru")};
		base = new Point(296,595);
		territorios[0] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[33] = new Carta(null, "war_carta_asl_argentina.png", territorios[0]);
		
		nomeT = "Venezuela";
		poligono = new Poligono(new Point[]{new Point(203,437),new Point(266,435),new Point(205,538),new Point(198,523),new Point(184,523),new Point(169,496)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Mexico"),new String("Brasil"),new String("Peru")};
		base = new Point(216,470);
		territorios[1] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[38] = new Carta(null, "war_carta_asl_venezuela.png", territorios[1]);
		

		nomeT = "Brasil";
		poligono = new Poligono(new Point[]{new Point(265,436),new Point(272,445),new Point(298,445),new Point(306,461),new Point(320,461),new Point(330,484),new Point(350,484),new Point(359,500),new Point(340,531),new Point(348,547),new Point(287,546),new Point(245,474)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Venezuela"),new String("Peru"),new String("Argentina"), new String("Nigeria")};
		base = new Point(311,530);
		territorios[2] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[36] = new Carta(null, "war_carta_asl_brasil.png", territorios[2]);
		

		nomeT = "Peru";
		poligono = new Poligono(new Point[]{new Point(245,475),new Point(286,546),new Point(251,608),new Point(238,589),new Point(242,582),new Point(225,550),new Point(212,550),new Point(207,540)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Venezuela"),new String("Brasil"),new String("Argentina")};
		base = new Point(247,568);
		territorios[3] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[37] = new Carta(null, "war_carta_asl_peru.png", territorios[3]);
		
		continentes[1] = new Continente(nome, territorios, cor, null, exercitosTabela);

		////////

		////////

		nome = "Africa";
		cor = new Cor(101,45,144);
		exercitosTabela = 3;
		territorios = new Territorio[6];

		nomeT = "Argelia";
		poligono = new Poligono(new Point[]{new Point(455,372),new Point(494,373),new Point(501,386),new Point(513,386),new Point(520,399),new Point(563,399),new Point(536,447),new Point(444,448),new Point(426,422)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Espanha"),new String("Italia"),new String("Egito"),new String("Nigeria")};
		base = new Point(459,404);
		territorios[0] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[2] = new Carta(null, "war_carta_af_argelia.png" , territorios[0]);
		
		nomeT = "Egito";
		poligono = new Poligono(new Point[]{new Point(566,397),new Point(615,395),new Point(624,414),new Point(620,423),new Point(650,475),new Point(587,477),new Point(572,449),new Point(536,447)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Argelia"),new String("Romenia"),new String("Jordania"),new String("Somalia"),new String("Nigeria")};
		base = new Point(601,471);
		territorios[1] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[3] = new Carta(null, "war_carta_af_egito.png", territorios[1 ]);

		nomeT = "Nigeria";
		poligono = new Poligono(new Point[]{new Point(445,448),new Point(572,447),new Point(614,524),new Point(542,524),new Point(525,493),new Point(468,492)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Brasil"), new String("Argelia"), new String("Egito"), new String("Somalia"), new String("Angola")};
		base = new Point(554,509);
		territorios[2] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[4] = new Carta(null, "war_carta_af_nigeria.png", territorios[2 ]);

		nomeT = "Somalia";
		poligono = new Poligono(new Point[]{new Point(587,475),new Point(651,476),new Point(668,505),new Point(702,504),new Point(682,544),new Point(671,544),new Point(644,589),new Point(599,588),new Point(626,544)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Arabia Saudita"), new String("Egito"), new String("Nigeria"), new String("Angola"), new String("Africa do Sul")};
		base = new Point(630,513);
		territorios[3] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[5] = new Carta(null, "war_carta_af_somalia.png" , territorios[ 3]);

		nomeT = "Angola";
		poligono = new Poligono(new Point[]{new Point(543,524),new Point(614,524),new Point(625,544),new Point(598,588),new Point(552,588),new Point(560,574),new Point(537,534)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Nigeria"),new String("Somalia"),new String("Africa do Sul")};
		base = new Point(570,586);
		territorios[4] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[1] = new Carta(null, "war_carta_af_angola.png" , territorios[4 ]);

		nomeT = "Africa do Sul";
		poligono = new Poligono(new Point[]{new Point(551,589),new Point(644,589),new Point(653,604),new Point(641,630),new Point(633,629),new Point(623,646),new Point(582,645)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Angola"),new String("Somalia")};
		base = new Point(622,636);
		territorios[5] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[0] = new Carta(null, "war_carta_af_africadosul   .png", territorios[5]);
		
		continentes[2] = new Continente(nome, territorios, cor, null, exercitosTabela);

		////////

		////////

		nome = "Europa";
		cor = new Cor(43,56,143);
		exercitosTabela = 5;
		territorios = new Territorio[8];

		nomeT = "Reino Unido";
		poligono = new Poligono(new Point[]{new Point(482,173),new Point(503,173),new Point(495,183),new Point(501,183),new Point(501,219),new Point(504,226),new Point(512,227),new Point(506,240),new Point(464,239),new Point(470,225),new Point(443,226),new Point(447,211),new Point(458,210),new Point(458,190),new Point(471,189)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Groelandia"), new String("Franca")};
		base = new Point(479,234);
		territorios[0] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[45] = new Carta(null, "war_carta_eu_reinounido.png", territorios[0]);
		
		nomeT = "Suecia";
		poligono = new Poligono(new Point[]{new Point(575,121),new Point(610,121),new Point(636,171),new Point(627,184),new Point(596,185),new Point(603,173),new Point(594,172),new Point(605,153),new Point(588,154),new Point(576,173),new Point(583,183),new Point(577,195),new Point(580,200),new Point(573,212),new Point(559,212),new Point(554,199),new Point(545,199),new Point(537,212),new Point(522,211),new Point(512,194),new Point(528,167),new Point(545,167),new Point(560,136),new Point(567,137)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Franca"),new String("Italia"), new String("Letonia"), new String("Estonia")};
		base = new Point(558,169);
		territorios[1] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[47] = new Carta(null, "war_carta_eu_suecia.png", territorios[1]);

		nomeT = "Franca";
		poligono = new Poligono(new Point[]{new Point(521,246),new Point(537,248),new Point(545,236),new Point(541,229),new Point(551,215),new Point(563,240),new Point(532,293),new Point(525,294),new Point(517,310),new Point(505,312),new Point(497,324),new Point(480,298),new Point(487,287),new Point(480,277),new Point(472,276),new Point(467,266),new Point(509,267)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Reino Unido"), new String("Suecia"), new String("Italia"), new String("Espanha")};
		base = new Point(496,305);
		territorios[2] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[42] = new Carta(null, "war_carta_eu_franca.png", territorios[2]);
		

		nomeT = "Italia";
		poligono = new Poligono(new Point[]{new Point(562,239),new Point(577,238),new Point(592,269),new Point(581,291),new Point(575,309),new Point(589,331),new Point(583,333),new Point(580,330),new Point(573,342),new Point(561,340),new Point(567,333),new Point(558,316),new Point(550,315),new Point(541,295),new Point(532,294)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Franca"), new String("Suecia"), new String("Polonia"), new String("Romenia"), new String("Argelia")};
		base = new Point(558,279);
		territorios[3] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[43] = new Carta(null, "war_carta_eu_italia.png", territorios[3]);
		

		nomeT = "Polonia";
		poligono = new Poligono(new Point[]{new Point(588,218),new Point(594,218),new Point(600,204),new Point(610,204),new Point(628,234),new Point(608,268),new Point(592,269),new Point(576,237)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Italia"), new String("Letonia"), new String("Ucrania"), new String("Romenia")};
		base = new Point(592,261);
		territorios[4] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[44] = new Carta(null, "war_carta_eu_polonia.png", territorios[4]);
		

		nomeT = "Romenia";
		poligono = new Poligono(new Point[]{new Point(592,269),new Point(607,268),new Point(634,312),new Point(621,322),new Point(627,328),new Point(618,341),new Point(607,341),new Point(600,330),new Point(604,321),new Point(586,319),new Point(584,308),new Point(598,308),new Point(591,297),new Point(583,295),new Point(581,291)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Italia"), new String("Polonia"), new String("Ucrania"), new String("Egito")};
		base = new Point(598,304);
		territorios[5] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[46] = new Carta(null, "war_carta_eu_romenia.png", territorios[5]);

		nomeT = "Ucrania";
		poligono = new Poligono(new Point[]{new Point(607,269),new Point(627,234),new Point(647,269),new Point(640,283),new Point(682,283),new Point(687,293),new Point(646,296),new Point(637,308),new Point(632,308)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Polonia"), new String("Romenia"), new String("Letonia"), new String("Turquia")};
		base = new Point(624,278);
		territorios[6] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[48] = new Carta(null, "war_carta_eu_ucrania.png", territorios[6]);
		

		nomeT = "Espanha";
		poligono = new Poligono(new Point[]{new Point(433,341),new Point(441,327),new Point(427,326),new Point(426,316),new Point(450,315),new Point(462,297),new Point(481,297),new Point(498,324),new Point(495,329),new Point(502,330),new Point(491,345),new Point(471,347),new Point(476,338),new Point(462,337),new Point(459,342)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Franca"), new String("Argelia")};
		base = new Point(444,340);
		territorios[7] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[41] = new Carta(null, "war_carta_eu_espanha.png", territorios[7]);
		
		continentes[3] = new Continente(nome, territorios, cor, null, exercitosTabela);

		////////

		////////

		nome = "Asia";
		cor = new Cor(246,146,30);
		exercitosTabela = 7;
		territorios = new Territorio[20];

		nomeT = "Estonia";
		poligono = new Poligono(new Point[]{new Point(608,121),new Point(631,121),new Point(633,126),new Point(661,126),new Point(671,148),new Point(659,148),new Point(656,141),new Point(641,142),new Point(656,171),new Point(679,169),new Point(688,150),new Point(767,149),new Point(738,199),new Point(654,200)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Suecia"), new String("Letonia"), new String("Russia")};
		base = new Point(706,173);
		territorios[0] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[21] = new Carta(null, "war_carta_as_estonia.png", territorios[0]);
		
		nomeT = "Russia";
		poligono = new Poligono(new Point[]{new Point(758,163),new Point(775,163),new Point(779,156),new Point(775,155),new Point(775,149),new Point(907,151),new Point(861,230),new Point(770,230),new Point(756,202),new Point(737,200)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Estonia"), new String("Letonia"), new String("Cazaquistao"), new String("Siberia")};
		base = new Point(820,176);
		territorios[1] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[30] = new Carta(null, "war_carta_as_russia.png", territorios[1]);
		
		nomeT = "Siberia";
		poligono = new Poligono(new Point[]{new Point(913,143),new Point(978,143),new Point(993,169),new Point(981,170),new Point(988,183),new Point(981,190),new Point(998,220),new Point(990,232),new Point(978,211),new Point(969,210),new Point(955,187),new Point(946,203),new Point(922,204),new Point(915,216),new Point(925,229),new Point(861,230)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Russia"), new String("Cazaquistao"), new String("Alasca")};
		base = new Point(899,206);
		territorios[2] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[31] = new Carta(null, "war_carta_as_siberia.png", territorios[2]);
		
		nomeT = "Letonia";
		poligono = new Poligono(new Point[]{new Point(637,172),new Point(654,200),new Point(756,200),new Point(770,230),new Point(757,254),new Point(638,253),new Point(610,205),new Point(617,203)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Polonia"), new String("Ucrania"), new String("Suecia"), new String("Estonia"), new String("Turquia"), new String("Cazaquistao"), new String("Russia")};
		base = new Point(738,245);
		territorios[3] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[27] = new Carta(null, "war_carta_as_letonia.png", territorios[3]);
		
		nomeT = "Cazaquistao";
		poligono = new Poligono(new Point[]{new Point(770,231),new Point(946,232),new Point(960,251),new Point(945,278),new Point(817,276),new Point(805,253),new Point(755,253)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Siberia"), new String("Russia"), new String("Letonia"), new String("Turquia"), new String("China"), new String("Mongolia"), new String("Japao")};
		base = new Point(824,251);
		territorios[4] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[17] = new Carta(null, "war_carta_as_cazaquistao.png", territorios[4]);
		
		nomeT = "Turquia";
		poligono = new Poligono(new Point[]{new Point(639,254),new Point(805,254),new Point(818,276),new Point(797,311),new Point(714,311),new Point(721,300),new Point(708,278),new Point(698,278),new Point(694,271),new Point(680,271),new Point(674,281),new Point(667,269),new Point(648,269)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Ucrania"), new String("Letonia"), new String("Cazaquistao"), new String("China"), new String("Paquistao"), new String("Siria")};
		base = new Point(726,279);
		territorios[5] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[35] = new Carta(null, "war_carta_as_turquia.png", territorios[5]);
		
		nomeT = "Mongolia";
		poligono = new Poligono(new Point[]{new Point(840,278),new Point(945,278),new Point(948,285),new Point(940,295),new Point(955,320),new Point(944,332),new Point(934,310),new Point(857,309)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Cazaquistao"), new String("China"), new String("Japao")};
		base = new Point(863,298);
		territorios[6] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[28] = new Carta(null, "war_carta_as_mongolia.png", territorios[6]);
		
		nomeT = "China";
		poligono = new Poligono(new Point[]{new Point(818,276),new Point(840,278),new Point(858,310),new Point(912,309),new Point(925,333),new Point(875,335),new Point(848,385),new Point(819,385),new Point(787,329)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Mongolia"), new String("Coreia do Norte"), new String("Coreia do Sul"), new String("Cazaquistao"), new String("India"), new String("Paquistao"),new String("Turquia")};
		base = new Point(827,315);
		territorios[7] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[18] = new Carta(null, "war_carta_as_china.png", territorios[7]);
		
		nomeT = "Siria";
		poligono = new Poligono(new Point[]{new Point(657,308),new Point(674,307),new Point(675,303),new Point(688,304),new Point(694,311),new Point(748,311),new Point(740,330),new Point(747,344),new Point(666,343),new Point(664,338),new Point(657,338),new Point(647,322)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Turquia"), new String("Paquistao"), new String("Ira"), new String("Iraque"), new String("Jordania")};
		base = new Point(686,329);
		territorios[8] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[32] = new Carta(null, "war_carta_as_siria.png", territorios[8]);
		
		nomeT = "Paquistao";
		poligono = new Poligono(new Point[]{new Point(749,311),new Point(796,310),new Point(788,329),new Point(819,384),new Point(797,424),new Point(773,424),new Point(782,404),new Point(739,328)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Siria"), new String("Turquia"), new String("China"), new String("Ira"),new String("India")};
		base = new Point(790,388);
		territorios[9] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[29] = new Carta(null, "war_carta_as_paquistao.png", territorios[9]);
		
		nomeT = "Ira";
		poligono = new Poligono(new Point[]{new Point(731,344),new Point(746,342),new Point(784,405),new Point(773,424),new Point(765,411),new Point(747,411),new Point(721,363)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Paquistao"), new String("Siria"), new String("Iraque")};
		base = new Point(757,410);
		territorios[10] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[23] = new Carta(null, "war_carta_as_ira.png", territorios[10]);
		
		nomeT = "Jordania";
		poligono = new Poligono(new Point[]{new Point(676,344),new Point(700,344),new Point(654,423),new Point(649,413),new Point(640,413),new Point(628,390),new Point(606,386),new Point(607,376),new Point(643,372),new Point(662,372)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Egito"), new String("Arabia Saudita"), new String("Iraque"), new String("Siria")};
		base = new Point(654,404);
		territorios[11] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[26] = new Carta(null, "war_carta_as_jordania.png", territorios[11]);
		
		nomeT = "Iraque";
		poligono = new Poligono(new Point[]{new Point(700,344),new Point(732,344),new Point(721,362),new Point(732,386),new Point(724,398),new Point(736,423),new Point(709,423),new Point(682,378)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Arabia Saudita"), new String("Jordania"), new String("Siria"), new String("Ira")};
		base = new Point(711,377);
		territorios[12] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[24] = new Carta(null, "war_carta_as_iraque.png", territorios[12]);
		
		nomeT = "Arabia Saudita";
		poligono = new Poligono(new Point[]{new Point(683,379),new Point(709,423),new Point(747,425),new Point(757,440),new Point(728,489),new Point(677,488),new Point(666,473),new Point(675,460),new Point(656,425)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Somalia"), new String("Jordania"), new String("Iraque")};
		base = new Point(674,437);
		territorios[13] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[15] = new Carta(null, "war_carta_as_arabiasaudita.png", territorios[13]);
		
		nomeT = "India";
		poligono = new Poligono(new Point[]{new Point(820,386),new Point(884,386),new Point(843,458),new Point(846,466),new Point(833,489),new Point(798,423)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Indonesia"), new String("Paquistao"), new String("China"), new String("Coreia do Sul"), new String("Bangladesh")};
		base = new Point(839,418);
		territorios[14] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[22] = new Carta(null, "war_carta_as_india.png", territorios[14]);
		
		nomeT = "Coreia do Norte";
		poligono = new Poligono(new Point[]{new Point(875,336),new Point(926,334),new Point(932,346),new Point(949,348),new Point(954,356),new Point(861,358)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Japao"), new String("China"), new String("Coreia do Sul")};
		base = new Point(885,351);
		territorios[15] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[19] = new Carta(null, "war_carta_as_coreiadonorte.png", territorios[15]);
		
		nomeT = "Coreia do Sul";
		poligono = new Poligono(new Point[]{new Point(861,359),new Point(954,361),new Point(961,371),new Point(954,385),new Point(846,384)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Coreia do Norte"), new String("China"), new String("India"), new String("Bangladesh"), new String("Tailandia")};
		base = new Point(940,382);
		territorios[16] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[20] = new Carta(null, "war_carta_as_coreiadosul .png", territorios[16]);
		
		nomeT = "Japao";
		poligono = new Poligono(new Point[]{new Point(977,253),new Point(997,284),new Point(994,288),new Point(1008,309),new Point(996,324),new Point(988,325),new Point(980,340),new Point(962,340),new Point(969,326),new Point(967,318),new Point(973,311),new Point(979,311),new Point(984,302),new Point(967,268)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Cazaquistao"), new String("Mongolia"), new String("Coreia do Norte")};
		base = new Point(983,288);
		territorios[17] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[25] = new Carta(null, "war_carta_as_japao.png", territorios[17]);
		
		nomeT = "Bangladesh";
		poligono = new Poligono(new Point[]{new Point(883,385),new Point(921,384),new Point(896,433),new Point(917,471),new Point(910,484),new Point(918,495),new Point(907,509),new Point(892,481),new Point(896,471),new Point(886,448),new Point(878,448),new Point(864,419)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("India"), new String("Coreia do Sul"), new String("Tailandia"), new String("Indonesia")};
		base = new Point(885,444);
		territorios[18] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[16] = new Carta(null, "war_carta_as_bangladesh.png", territorios[18]);
		
		nomeT = "Tailandia";
		poligono = new Poligono(new Point[]{new Point(922,385),new Point(955,387),new Point(966,406),new Point(958,424),new Point(950,424),new Point(947,432),new Point(934,432),new Point(932,427),new Point(925,435),new Point(940,458),new Point(936,463),new Point(940,471),new Point(934,484),new Point(926,484),new Point(895,432)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Coreia do Sul"), new String("Bangladesh")};
		base = new Point(917,444);
		territorios[19] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[34] = new Carta(null, "war_carta_as_tailandia.png", territorios[19]);
		
		continentes[4] = new Continente(nome, territorios, cor, null, exercitosTabela);

		////////

		////////

		nome = "Oceania";
		cor = new Cor(38,169,224);
		exercitosTabela = 2;
		territorios = new Territorio[4];

		nomeT = "Indonesia";
		poligono = new Poligono(new Point[]{new Point(876,521),new Point(887,521),new Point(898,541),new Point(919,541),new Point(926,526),new Point(941,528),new Point(946,540),new Point(966,540),new Point(975,559),new Point(984,560),new Point(994,577),new Point(969,579),new Point(960,565),new Point(947,564),new Point(944,570),new Point(928,572),new Point(921,558),new Point(885,558),new Point(871,531)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("India"), new String("Bangladesh"), new String("Australia"), new String("Nova Zelandia")};
		base = new Point(972,569);
		territorios[0] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[50] = new Carta(null, "war_carta_oc_indonesia.png", territorios[0]);
		
		nomeT = "Perth";
		poligono = new Poligono(new Point[]{new Point(875,578),new Point(892,579),new Point(900,586),new Point(892,595),new Point(898,606),new Point(853,689),new Point(822,689),new Point(814,704),new Point(799,703),new Point(790,687),new Point(796,676),new Point(805,676),new Point(817,654),new Point(809,642),new Point(815,630),new Point(824,628),new Point(833,610),new Point(858,609)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Australia")};
		base = new Point(857,627);
		territorios[1] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[52] = new Carta(null, "war_carta_oc_perth.png", territorios[1]);
		
		nomeT = "Australia";
		poligono = new Poligono(new Point[]{new Point(913,583),new Point(925,583),new Point(960,644),new Point(950,658),new Point(957,670),new Point(941,696),new Point(928,698),new Point(917,720),new Point(883,722),new Point(874,704),new Point(859,704),new Point(853,690)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Indonesia"), new String("Nova Zelandia"), new String("Perth")};
		base = new Point(914,648);
		territorios[2] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[49] = new Carta(null, "war_carta_oc_australia.png", territorios[2]);
		
		nomeT = "Nova Zelandia";
		poligono = new Poligono(new Point[]{new Point(969,651),new Point(976,651),new Point(990,679),new Point(976,710),new Point(960,729),new Point(938,731),new Point(957,695),new Point(963,695),new Point(973,678),new Point(967,667),new Point(974,659)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Australia"), new String("Indonesia")};
		base = new Point(981,668);
		territorios[3] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira, base);
		cartas[51] = new Carta(null, "war_carta_oc_novazelandia.png", territorios[3]);
		
		continentes[5] = new Continente(nome, territorios, cor, null, exercitosTabela);
		

		
		cartas[39] = new Carta(null, "war_carta_coringa.png", null);
		cartas[40] = new Carta(null, "war_carta_coringa.png", null);
		
		cartasTroca = new Baralho(cartas, "Troca", 53);
		
		cartasObjetivo = new String[14];
		cartasObjetivo[0] = "Destruir totalmente os exercitos azuis.\n Se voce é quem possui os exercitos azuis,\n ou se o jogador que os possuir for eliminado\n por outro jogador\n, o seu objetivo passa a ser\n conquistar 24 territorios";
		cartasObjetivo[1] = "Destruir totalmente os exercitos verdes.\n Se voce é quem possui os exercitos verdes,\n ou se o jogador que os possuir for eliminado\n por outro jogador\n, o seu objetivo passa a ser\n conquistar 24 territorios";
		cartasObjetivo[2] = "Destruir totalmente os exercitos amarelos.\n Se voce é quem possui os exercitos amarelos,\n ou se o jogador que os possuir for eliminado\n por outro jogador\n, o seu objetivo passa a ser\n conquistar 24 territorios";
		cartasObjetivo[3] = "Destruir totalmente os exercitos vermelhos.\n Se voce é quem possui os exercitos vermelhos,\n ou se o jogador que os possuir for eliminado\n por outro jogador\n, o seu objetivo passa a ser\n conquistar 24 territorios";
		cartasObjetivo[4] = "Destruir totalmente os exercitos brancos.\n Se voce é quem possui os exercitos brancos,\n ou se o jogador que os possuir for eliminado\n por outro jogador\n, o seu objetivo passa a ser\n conquistar 24 territorios";
		cartasObjetivo[5] = "Destruir totalmente os exercitos pretos.\n Se voce é quem possui os exercitos pretos,\n ou se o jogador que os possuir for eliminado\n por outro jogador\n, o seu objetivo passa a ser\n conquistar 24 territorios";
		cartasObjetivo[6] = "Conquistar na totalidade a Europa, Oceania\n e mais um continente à sua escolha";
		cartasObjetivo[7] = "Conquistar na totalidade\n a Ásia e a África";
		cartasObjetivo[8] = "Conquistar na totalidade\n a América do Norte e a Oceania";
		cartasObjetivo[9] = "Conquistar na totalidade a Europa,\n a América do Sul e mais um\n continete à sua escolha";
		cartasObjetivo[10] = "Conquistar na totalidade a Ásia\n e a América do Sul";
		cartasObjetivo[11] = "Conquistar 24 territórios\n à sua escolha";
		cartasObjetivo[12] = "Conquistar na totalidade a\n América do Norte e a África";
		cartasObjetivo[13] = "Conquistar 18 territórios e ocupar\n cada um deles com pelo menos 2 exércitos";
		
		for(int i = 0; i<14 ; i++){
			objDisponiveis.add(cartasObjetivo[i]);
		}
		
		for(int i = 0; i<53 ; i++){
			cartasDisponiveis.add(cartas[i]);
		}
	
		

		////////
		
		for(int j=0;j<6;j++){
			for(int i=0 ; i<this.getContinentes()[j].getTerritorios().length ; i++){
				this.territorios.put(this.getContinentes()[j].getTerritorios()[i].getNome(), this.getContinentes()[j].getTerritorios()[i]);
			}
		}

	}
	
	

	public int getnJogadores() {
		return nJogadores;
	}

	public void setnJogadores(int nJogadores) {
		this.nJogadores = nJogadores;
	}

	public HashMap<String, Territorio> getTerritorios() {
		return territorios;
	}

	public void setTerritorios(HashMap<String, Territorio> territorios) {
		this.territorios = territorios;
	}

	public Continente[] getContinentes() {
		return continentes;
	}

	public Tabela1 getTabTroca() {
		return tabTroca;
	}

	public void setTabTroca(Tabela1 tabTroca) {
		this.tabTroca = tabTroca;
	}

	public Jogador[] getJogadores() {
		return jogadores;
	}

	public void setJogadores(Jogador[] jogadores) {
		this.jogadores = jogadores;
	}

	public Dado[] getDadosAtaque() {
		return dadosAtaque;
	}

	public void setDadosAtaque(Dado[] dadosAtaque) {
		this.dadosAtaque = dadosAtaque;
	}

	public Dado[] getDadosDefesa() {
		return dadosDefesa;
	}

	public void setDadosDefesa(Dado[] dadosDefesa) {
		this.dadosDefesa = dadosDefesa;
	}

	public void setContinentes(Continente[] continentes) {
		this.continentes = continentes;
	}

	public Rodada getR() {
		return r;
	}

	public void setR(Rodada r) {
		this.r = r;
	}
	
	public void calculaNumeroJogadores(){
		int u;
		for(u=0; u<6 && this.getJogadores()[u]!=null ;u++);
		
		nJogadores = u;
		notifyObservers();
	}
	
	public int getNJogadores(){
		return nJogadores;
	}

	public String[] getCartasObjetivo() {
		return cartasObjetivo;
	}

	public void setCartasObjetivo(String[] cartasObjetivo) {
		this.cartasObjetivo = cartasObjetivo;
	}

	public ArrayList<String> getObjDisponiveis() {
		return objDisponiveis;
	}

	public void setObjDisponiveis(ArrayList<String> objDisponiveis) {
		this.objDisponiveis = objDisponiveis;
	}

	public Baralho getCartasTroca() {
		return cartasTroca;
	}

	public void setCartasTroca(Baralho cartasTroca) {
		this.cartasTroca = cartasTroca;
	}

	public ArrayList<Carta> getCartasDisponiveis() {
		return cartasDisponiveis;
	}

	public void setCartasDisponiveis(ArrayList<Carta> cartasDisponiveis) {
		this.cartasDisponiveis = cartasDisponiveis;
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
              ob.update(this.nJogadores);
            }
		
	}
	
	

	
	

}
