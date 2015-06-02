package Modelos;

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
		jogadores = new Jogador[6]; 

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

		////////

		nome = "África";
		cor = new Cor(101,45,144);
		exercitosTabela = 3;
		territorios = new Territorio[6];

		nomeT = "Argélia";
		poligono = new Poligono(new Point[]{new Point(455,372),new Point(494,373),new Point(501,386),new Point(513,386),new Point(520,399),new Point(563,399),new Point(536,447),new Point(444,448),new Point(426,422)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Espanha"),new String("Itália"),new String("Egito"),new String("Nigéria")};
		territorios[0] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Egito";
		poligono = new Poligono(new Point[]{new Point(566,397),new Point(615,395),new Point(624,414),new Point(620,423),new Point(650,475),new Point(587,477),new Point(572,449),new Point(536,447)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Argélia"),new String("Romênia"),new String("Jordânia"),new String("Somália"),new String("Nigéria")};
		territorios[1] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);


		nomeT = "Nigéria";
		poligono = new Poligono(new Point[]{new Point(445,448),new Point(572,447),new Point(614,524),new Point(542,524),new Point(525,493),new Point(468,492)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Brasil"), new String("Argélia"), new String("Egito"), new String("Somália"), new String("Angola")};
		territorios[2] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);


		nomeT = "Somália";
		poligono = new Poligono(new Point[]{new Point(587,475),new Point(651,476),new Point(668,505),new Point(702,504),new Point(682,544),new Point(671,544),new Point(644,589),new Point(599,588),new Point(626,544)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Arábia Saudita"), new String("Egito"), new String("Nigéria"), new String("Angola"), new String("África do Sul")};
		territorios[3] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);


		nomeT = "Angola";
		poligono = new Poligono(new Point[]{new Point(543,524),new Point(614,524),new Point(625,544),new Point(598,588),new Point(552,588),new Point(560,574),new Point(537,534)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Nigéria"),new String("Somália"),new String("África do Sul")};
		territorios[4] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);


		nomeT = "África do Sul";
		poligono = new Poligono(new Point[]{new Point(551,589),new Point(644,589),new Point(653,604),new Point(641,630),new Point(633,629),new Point(623,646),new Point(582,645)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Angola"),new String("Somália")};
		territorios[5] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

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
		territoriosFronteira = new String[]{new String("Groelândia"), new String("França")};
		territorios[0] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Suécia";
		poligono = new Poligono(new Point[]{new Point(575,121),new Point(610,121),new Point(636,171),new Point(627,184),new Point(596,185),new Point(603,173),new Point(594,172),new Point(605,153),new Point(588,154),new Point(576,173),new Point(583,183),new Point(577,195),new Point(580,200),new Point(573,212),new Point(559,212),new Point(554,199),new Point(545,199),new Point(537,212),new Point(522,211),new Point(512,194),new Point(528,167),new Point(545,167),new Point(560,136),new Point(567,137)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("França"),new String("Itália"), new String("Letônia"), new String("Estônia")};
		territorios[1] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);


		nomeT = "França";
		poligono = new Poligono(new Point[]{new Point(521,246),new Point(537,248),new Point(545,236),new Point(541,229),new Point(551,215),new Point(563,240),new Point(532,293),new Point(525,294),new Point(517,310),new Point(505,312),new Point(497,324),new Point(480,298),new Point(487,287),new Point(480,277),new Point(472,276),new Point(467,266),new Point(509,267)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Reino Unido"), new String("Suécia"), new String("Itália"), new String("Espanha")};
		territorios[2] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);


		nomeT = "Itália";
		poligono = new Poligono(new Point[]{new Point(562,239),new Point(577,238),new Point(592,269),new Point(581,291),new Point(575,309),new Point(589,331),new Point(583,333),new Point(580,330),new Point(573,342),new Point(561,340),new Point(567,333),new Point(558,316),new Point(550,315),new Point(541,295),new Point(532,294)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("França"), new String("Suécia"), new String("Polônia"), new String("Romênia"), new String("Argélia")};
		territorios[3] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);


		nomeT = "Polônia";
		poligono = new Poligono(new Point[]{new Point(588,218),new Point(594,218),new Point(600,204),new Point(610,204),new Point(628,234),new Point(608,268),new Point(592,269),new Point(576,237)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Itália"), new String("Letônia"), new String("Ucrânia"), new String("Romênia")};
		territorios[4] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);


		nomeT = "Romênia";
		poligono = new Poligono(new Point[]{new Point(592,269),new Point(607,268),new Point(634,312),new Point(621,322),new Point(627,328),new Point(618,341),new Point(607,341),new Point(600,330),new Point(604,321),new Point(586,319),new Point(584,308),new Point(598,308),new Point(591,297),new Point(583,295),new Point(581,291)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Itália"), new String("Polônia"), new String("Ucrânia"), new String("Egito")};
		territorios[5] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);


		nomeT = "Ucrânia";
		poligono = new Poligono(new Point[]{new Point(607,269),new Point(627,234),new Point(647,269),new Point(640,283),new Point(682,283),new Point(687,293),new Point(646,296),new Point(637,308),new Point(632,308)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Polônia"), new String("Romênia"), new String("Letônia"), new String("Turquia")};
		territorios[6] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);


		nomeT = "Espanha";
		poligono = new Poligono(new Point[]{new Point(433,341),new Point(441,327),new Point(427,326),new Point(426,316),new Point(450,315),new Point(462,297),new Point(481,297),new Point(498,324),new Point(495,329),new Point(502,330),new Point(491,345),new Point(471,347),new Point(476,338),new Point(462,337),new Point(459,342)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("França"), new String("Argélia")};
		territorios[7] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		continentes[3] = new Continente(nome, territorios, cor, null, exercitosTabela);

		////////

		////////

		nome = "Ásia";
		cor = new Cor(246,146,30);
		exercitosTabela = 7;
		territorios = new Territorio[20];

		nomeT = "Estônia";
		poligono = new Poligono(new Point[]{new Point(608,121),new Point(631,121),new Point(633,126),new Point(661,126),new Point(671,148),new Point(659,148),new Point(656,141),new Point(641,142),new Point(656,171),new Point(679,169),new Point(688,150),new Point(767,149),new Point(738,199),new Point(654,200)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Suécia"), new String("Letônia"), new String("Rússia")};
		territorios[0] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Rússia";
		poligono = new Poligono(new Point[]{new Point(758,163),new Point(775,163),new Point(779,156),new Point(775,155),new Point(775,149),new Point(907,151),new Point(861,230),new Point(770,230),new Point(756,202),new Point(737,200)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Estônia"), new String("Letônia"), new String("Cazaquistão"), new String("Sibéria")};
		territorios[1] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Sibéria";
		poligono = new Poligono(new Point[]{new Point(913,143),new Point(978,143),new Point(993,169),new Point(981,170),new Point(988,183),new Point(981,190),new Point(998,220),new Point(990,232),new Point(978,211),new Point(969,210),new Point(955,187),new Point(946,203),new Point(922,204),new Point(915,216),new Point(925,229),new Point(861,230)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Rússia"), new String("Cazaquistão"), new String("Alasca")};
		territorios[2] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Letônia";
		poligono = new Poligono(new Point[]{new Point(637,172),new Point(654,200),new Point(756,200),new Point(770,230),new Point(757,254),new Point(638,253),new Point(610,205),new Point(617,203)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Polônia"), new String("Ucrânia"), new String("Suécia"), new String("Estônia"), new String("Turquia"), new String("Cazaquistão"), new String("Rússia")};
		territorios[3] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Cazaquistão";
		poligono = new Poligono(new Point[]{new Point(770,231),new Point(946,232),new Point(960,251),new Point(945,278),new Point(817,276),new Point(805,253),new Point(755,253)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Sibéria"), new String("Rússia"), new String("Letônia"), new String("Turquia"), new String("China"), new String("Mongólia"), new String("Japão")};
		territorios[4] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Turquia";
		poligono = new Poligono(new Point[]{new Point(639,254),new Point(805,254),new Point(818,276),new Point(797,311),new Point(714,311),new Point(721,300),new Point(708,278),new Point(698,278),new Point(694,271),new Point(680,271),new Point(674,281),new Point(667,269),new Point(648,269)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Ucrânia"), new String("Letônia"), new String("Cazaquistão"), new String("China"), new String("Paquistão"), new String("Síria")};
		territorios[5] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Mongólia";
		poligono = new Poligono(new Point[]{new Point(840,278),new Point(945,278),new Point(948,285),new Point(940,295),new Point(955,320),new Point(944,332),new Point(934,310),new Point(857,309)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Cazaquistão"), new String("China"), new String("Japão")};
		territorios[6] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "China";
		poligono = new Poligono(new Point[]{new Point(818,276),new Point(840,278),new Point(858,310),new Point(912,309),new Point(925,333),new Point(875,335),new Point(848,385),new Point(819,385),new Point(787,329)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Mongólia"), new String("Coréia do Norte"), new String("Coréia do Sul"), new String("Cazaquistão"), new String("Índia"), new String("Paquistão"),new String("Turquia")};
		territorios[7] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Síria";
		poligono = new Poligono(new Point[]{new Point(657,308),new Point(674,307),new Point(675,303),new Point(688,304),new Point(694,311),new Point(748,311),new Point(740,330),new Point(747,344),new Point(666,343),new Point(664,338),new Point(657,338),new Point(647,322)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Turquia"), new String("Paquistão"), new String("Irã"), new String("Iraque"), new String("Jordânia")};
		territorios[8] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Paquistão";
		poligono = new Poligono(new Point[]{new Point(749,311),new Point(796,310),new Point(788,329),new Point(819,384),new Point(797,424),new Point(773,424),new Point(782,404),new Point(739,328)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Síria"), new String("Turquia"), new String("China"), new String("Irã"),new String("Índia")};
		territorios[9] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Irã";
		poligono = new Poligono(new Point[]{new Point(731,344),new Point(746,342),new Point(784,405),new Point(773,424),new Point(765,411),new Point(747,411),new Point(721,363)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Paquistão"), new String("Síria"), new String("Iraque")};
		territorios[10] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Jordânia";
		poligono = new Poligono(new Point[]{new Point(676,344),new Point(700,344),new Point(654,423),new Point(649,413),new Point(640,413),new Point(628,390),new Point(606,386),new Point(607,376),new Point(643,372),new Point(662,372)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Egito"), new String("Arábia Saudita"), new String("Iraque"), new String("Síria")};
		territorios[11] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Iraque";
		poligono = new Poligono(new Point[]{new Point(700,344),new Point(732,344),new Point(721,362),new Point(732,386),new Point(724,398),new Point(736,423),new Point(709,423),new Point(682,378)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Arábia Saudita"), new String("Jordânia"), new String("Síria"), new String("Irã")};
		territorios[12] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Arábia Saudita";
		poligono = new Poligono(new Point[]{new Point(683,379),new Point(709,423),new Point(747,425),new Point(757,440),new Point(728,489),new Point(677,488),new Point(666,473),new Point(675,460),new Point(656,425)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Somália"), new String("Jordânia"), new String("Iraque")};
		territorios[13] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Índia";
		poligono = new Poligono(new Point[]{new Point(820,386),new Point(884,386),new Point(843,458),new Point(846,466),new Point(833,489),new Point(798,423)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Indonésia"), new String("Paquistão"), new String("China"), new String("Coréia do Sul"), new String("Bangladesh")};
		territorios[14] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Coréia do Norte";
		poligono = new Poligono(new Point[]{new Point(875,336),new Point(926,334),new Point(932,346),new Point(949,348),new Point(954,356),new Point(861,358)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Japão"), new String("China"), new String("Coréia do Sul")};
		territorios[15] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Coréia do Sul";
		poligono = new Poligono(new Point[]{new Point(861,359),new Point(954,361),new Point(961,371),new Point(954,385),new Point(846,384)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Coréia do Norte"), new String("China"), new String("Índia"), new String("Bangladesh"), new String("Tailândia")};
		territorios[16] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Japão";
		poligono = new Poligono(new Point[]{new Point(977,253),new Point(997,284),new Point(994,288),new Point(1008,309),new Point(996,324),new Point(988,325),new Point(980,340),new Point(962,340),new Point(969,326),new Point(967,318),new Point(973,311),new Point(979,311),new Point(984,302),new Point(967,268)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Cazaquistão"), new String("Mongólia"), new String("Coréia do Norte")};
		territorios[17] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Bangladesh";
		poligono = new Poligono(new Point[]{new Point(883,385),new Point(921,384),new Point(896,433),new Point(917,471),new Point(910,484),new Point(918,495),new Point(907,509),new Point(892,481),new Point(896,471),new Point(886,448),new Point(878,448),new Point(864,419)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Índia"), new String("Coréia do Sul"), new String("Tailândia"), new String("Indonésia")};
		territorios[18] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Tailândia";
		poligono = new Poligono(new Point[]{new Point(922,385),new Point(955,387),new Point(966,406),new Point(958,424),new Point(950,424),new Point(947,432),new Point(934,432),new Point(932,427),new Point(925,435),new Point(940,458),new Point(936,463),new Point(940,471),new Point(934,484),new Point(926,484),new Point(895,432)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Coréia do Sul"), new String("Bangladesh")};
		territorios[19] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		continentes[4] = new Continente(nome, territorios, cor, null, exercitosTabela);

		////////

		////////

		nome = "Oceania";
		cor = new Cor(38,169,224);
		exercitosTabela = 2;
		territorios = new Territorio[4];

		nomeT = "Indonésia";
		poligono = new Poligono(new Point[]{new Point(876,521),new Point(887,521),new Point(898,541),new Point(919,541),new Point(926,526),new Point(941,528),new Point(946,540),new Point(966,540),new Point(975,559),new Point(984,560),new Point(994,577),new Point(969,579),new Point(960,565),new Point(947,564),new Point(944,570),new Point(928,572),new Point(921,558),new Point(885,558),new Point(871,531)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Índia"), new String("Bangladesh"), new String("Austrália"), new String("Nova Zelândia")};
		territorios[0] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Perth";
		poligono = new Poligono(new Point[]{new Point(875,578),new Point(892,579),new Point(900,586),new Point(892,595),new Point(898,606),new Point(853,689),new Point(822,689),new Point(814,704),new Point(799,703),new Point(790,687),new Point(796,676),new Point(805,676),new Point(817,654),new Point(809,642),new Point(815,630),new Point(824,628),new Point(833,610),new Point(858,609)});
		simb = Simbolo.CIRCULO;
		territoriosFronteira = new String[]{new String("Austrália")};
		territorios[1] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Austrália";
		poligono = new Poligono(new Point[]{new Point(913,583),new Point(925,583),new Point(960,644),new Point(950,658),new Point(957,670),new Point(941,696),new Point(928,698),new Point(917,720),new Point(883,722),new Point(874,704),new Point(859,704),new Point(853,690)});
		simb = Simbolo.TRIANGULO;
		territoriosFronteira = new String[]{new String("Indonésia"), new String("Nova Zelândia")};
		territorios[2] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		nomeT = "Nova Zelândia";
		poligono = new Poligono(new Point[]{new Point(969,651),new Point(976,651),new Point(990,679),new Point(976,710),new Point(960,729),new Point(938,731),new Point(957,695),new Point(963,695),new Point(973,678),new Point(967,667),new Point(974,659)});
		simb = Simbolo.QUADRADO;
		territoriosFronteira = new String[]{new String("Austrália"), new String("Indonésia")};
		territorios[3] = new Territorio(nomeT, poligono, 0, null, simb, territoriosFronteira);

		continentes[5] = new Continente(nome, territorios, cor, null, exercitosTabela);

		////////

	}

	public Continente[] getContinentes() {
		return continentes;
	}
	
	public void insereNovoJogador(Jogador jogador){
		int i;
		for(i=0; jogadores[i]!=null;i++);
		jogadores[i]=jogador;
		System.out.println(jogadores[i].getNome()+"->"+jogadores[i].getCor());
	}
	
	
}