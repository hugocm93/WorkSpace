package sistema;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import jogadores.Jogador;
import sorteReves.SorteOuReves;
import territorios.Territorio;

public class Tabuleiro extends JPanel implements ActionListener {

	private Image imagem_tabuleiro;
	
	int numJogadores = 0;
	int numJogador = 0;
	int turnoIguais = 0;
	
	String botaoDado = "dado", botaoCompra = "compra", botaoTurno = "turno", botaoNegocia = "negociar", botaoGerencia = "gerenciar";
	Option warning = new Option();
	Boolean turno = true;
	
	Dado dado = new Dado();
	
	int x[] = new int[]{25, 50, 75, 25, 50, 75};
	int y[] = new int[]{885, 885, 885, 925, 925, 925};
	int preso = 0;
	
	public LinkedList<Jogador> jogadores = new LinkedList<Jogador>();
	public LinkedList<Negocio> negociacoes = new LinkedList<Negocio>();
	Jogador jogadorAtual = null;
	
	private static Tabuleiro tab = null;
	
	Territorio casas[] = this.vetorTerritorio();
	SorteOuReves sortereves[] = this.vetorSorteReves();
	{
		//adicionaObserver(this);
	}
	
	private Tabuleiro(){
		numJogadores = warning.inicio();
		carrega_imagemTab();
		define_tamanho();
		inicializaJogadores(numJogadores);
	}
	
	public static Tabuleiro getTabuleiro()
	{
		if (tab == null)
			tab = new Tabuleiro();
		return tab;
	}
	
	public void inicializaJogadores (int numJogadores)
	{
		for (int i = 0; i<numJogadores; i++)
		{
			jogadores.add (new Jogador(i+1));
			jogadores.get(i).setImagem("src/jogadores/pin"+i+".png");
			jogadores.get(i).setCoord(x[i], y[i]);
		}
		jogadorAtual = jogadores.getFirst();
	}

	private void carrega_imagemTab()
	{
		imagem_tabuleiro = new ImageIcon("src/tabuleiroRJ.jpg").getImage();
	}
	
	private void define_tamanho(){
		
		Dimension d = new Dimension();
		d.width = imagem_tabuleiro.getWidth(null);
		d.height = imagem_tabuleiro.getHeight(null);
		setPreferredSize(d);
	}
	
	private void desenha(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(imagem_tabuleiro, 1, 1, null);
		for (int i=0; i<numJogadores; i++)
		{
			g2d.drawImage(jogadores.get(i).imagem, jogadores.get(i).x, jogadores.get(i).y, null);
		}
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Turno do jogador "+Integer.toString(jogadorAtual.getCor()), 200, 200);
		g.drawString("Dinheiro: $"+Integer.toString(jogadorAtual.getDinheiro())+",00", 200, 220);
		//g.drawString("Dado 1: "+Integer.toString(dado.dado1),650,770);
		//g.drawString("Dado 2: "+Integer.toString(dado.dado2),650,790);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){

		if (e.getActionCommand() == "dado" && turno == true)
		{
			dado.dado1 = dado.rolar_dado();
			dado.dado2 = dado.rolar_dado();
		
			dado.somaDados = dado.dado1 + dado.dado2;

			System.out.printf("Dado 1: %d\nDado 2: %d\nSoma dos dados: %d\n", dado.dado1, dado.dado2, dado.somaDados);
			jogada(numJogador);
			
			if (jogadorAtual.getPreso() != 0)
			{
					if (!dado.dadosIguais())
					{
						if (jogadorAtual.getPreso() == 1)
						{
							jogadorAtual.setDinheiro (-50);
							warning.info("Você passou 3 turnos na prisão, pagou $50 para o guarda e ele fingiu que estava dormindo."+
							"\n"+"No próximo turno estará livre.");
						}
						else
						{
						warning.info("Você está preso e precisa tirar dados iguais ou esperar mais "+Integer.toString(jogadorAtual.getPreso())+
						" turnos para sair");
						}
						preso = jogadorAtual.getPreso();
						preso--;
						jogadorAtual.setPreso(preso);
					}
					else
					{
						warning.info("Você tirou dados iguais e está livre da prisão.");
						jogadorAtual.setPreso (0);
					}
					
			}
			if (casas[jogadorAtual.getCasa()].empresa == true || casas[jogadorAtual.getCasa()].terreno)
			{
				if (casas[jogadorAtual.getCasa()].dono != null && casas[jogadorAtual.getCasa()].dono != jogadorAtual)
				{
					int taxa = 0;
					if (casas[jogadorAtual.getCasa()].empresa == true)
					{
						taxa = casas[jogadorAtual.getCasa()].taxaAtual * dado.somaDados;
					}
					else
						taxa = casas[jogadorAtual.getCasa()].taxaAtual;
					warning.pagaTaxas(casas[jogadorAtual.getCasa()], taxa);
					jogadorAtual.setDinheiro(-taxa);
					for (int i=0; i<jogadores.size();i++)
					{
						casas[jogadorAtual.getCasa()].dono.setDinheiro(+taxa);
					}
				}
			}
			if (casas[jogadorAtual.getCasa()].lucros)
			{
				warning.info("Receba $200 das propinas e extorsões.");
				jogadorAtual.setDinheiro(+200);
			}
			if (casas[jogadorAtual.getCasa()].imposto)
			{
				warning.info("Pague $200 pelos custos de campanha.");
				jogadorAtual.setDinheiro(-200);
			}
			if (casas[jogadorAtual.getCasa()].sortereves == true)
			{
				int i = 1 + (int)(Math.random() * 30);

				if (sortereves[i-1].irprisao)
				{
					mandaPrisao(jogadorAtual);
					turno = false;
				}
				else if (sortereves[i-1].irpartida)
				{
					mandaInicio(jogadorAtual);
				}
				else if (sortereves[i-1].passeprisao)
				{
					jogadorAtual.setPassePrisao(true);
				}
				else if (sortereves[i-1].recebeOutros)
				{
					int taxa = 0;
					for (int j=0;j<jogadores.size();j++)
					{
						if (jogadores.get(j) != jogadorAtual)
						{
							jogadores.get(j).setDinheiro (-50);
							taxa += 50;
						}
					}
					sortereves[i-1].setEfeito(taxa);
				}
				
				warning.sorteReves(sortereves[i-1]);
				jogadorAtual.setDinheiro (sortereves[i-1].efeito);
				
			}
			if (dado.dadosIguais() && turno == true)
			{
				turnoIguais++;
				turno = true;
				if (turnoIguais == 3)
				{
					warning.aviso("Você tirou 3 vezes dados iguais, os outros jogadores estão desconfiando de você."+"\n"+
				"Vá para a prisão.");
					mandaPrisao (jogadorAtual);
					turnoIguais = 0;
					turno = false;
				}
				else
					warning.info("Dados Iguais! Jogue novamente");
			}
			else
			{
				turnoIguais = 0;
				turno = false;
			}
			repaint();
		}
		else if (e.getActionCommand() == "dado" && turno == false)
		{
			warning.aviso ("Dado já foi jogado!");
		}
		
		else if (e.getActionCommand() == "turno")
		{
		if (jogadorAtual.getDinheiro() <= 0)
		{
			if (warning.avisaFalencia (jogadorAtual))
			{
				falencia(jogadorAtual);
				numJogador--;
				if (jogadores.size() == 1)
				{
					warning.info("Parabéns Jogador "+Integer.toString(jogadores.getFirst().getCor())+"!"+
				"\n"+ "Você é o vencedor!");
				}
			}
			else
			{
				return;
			}
		}
			
		numJogador++;
		if (numJogador >= jogadores.size())
		{
			numJogador = 0;
		}
		jogadorAtual = jogadores.get(numJogador);
		turno = true;
		System.out.printf ("Turno do jogador %d\n", jogadorAtual.getCor());
		
		if (jogadorAtual.getPreso() != 0 && jogadorAtual.getPassePrisao())
		{
			warning.usarPasse(jogadorAtual, sortereves[2].imagem);
		}
		
		}
		
		else if (e.getActionCommand() == "compra")
		{
			if (casas[jogadorAtual.getCasa()].compraOk() )
			{
				if (casas[jogadorAtual.getCasa()].preco > jogadorAtual.getDinheiro())
				{
					System.out.println ("Dinheiro insuficiente.");
					warning.aviso("Dinheiro insuficiente!");
					return;
				}
				else
				{
					if(warning.compraTerreno(casas[jogadorAtual.getCasa()]))
					{
						int compra = 0;	
						casas[jogadorAtual.getCasa()].setdono(jogadorAtual);
						compra =- casas[jogadorAtual.getCasa()].preco;
						jogadorAtual.setDinheiro(compra);
						jogadorAtual.setTerritorioComprado(casas[jogadorAtual.getCasa()]);
						warning.info("Terreno comprado!");	
					}
				}				
			}
		}
		else if (e.getActionCommand() == "gerenciar")
		{
			warning.escolheTerritorio(jogadorAtual);
		}
		else if (e.getActionCommand() == "negociar")
		{
			warning.negociar(this, jogadorAtual);
		}
		repaint();
	}
	
	public void falencia (Jogador j)
	{
		for (int i=0; i<j.tHipotecados.size(); i++)
		{
			j.tHipotecados.remove(i);
		}
		for (int i=0; i<j.tComprados.size(); i++)
		{
			j.tComprados.get(i).setTerrenoSemDono();
			j.tComprados.remove(i);
		}
		warning.info("O Jogador "+j.getCor()+" saiu do jogo.");
		jogadores.removeFirstOccurrence(j);
		numJogadores--;
	}
	
	public void mandaPrisao (Jogador j)
	{
		switch (j.getCor()){
		case 1:
			j.setCoord(25, 21);
			break;
		case 2:
			j.setCoord(50, 21);
			break;
		case 3:
			j.setCoord(75, 21);
			break;
		case 4:
			j.setCoord(25, 71);
			break;
		case 5:
			j.setCoord(50, 71);
			break;
		case 6:
			j.setCoord(75, 71);
			break;
		}
		j.setPreso (3);
		j.setCasa (9);
	}
	
	public void mandaInicio (Jogador j)
	{
		switch (j.getCor()){
		case 1:
			j.setCoord(x[0], y[0]);
			break;
		case 2:
			j.setCoord(x[1], y[1]);
			break;
		case 3:
			j.setCoord(x[2], y[2]);
			break;
		case 4:
			j.setCoord(x[3], y[3]);
			break;
		case 5:
			j.setCoord(x[4], y[4]);
			break;
		case 6:
			j.setCoord(x[5], y[5]);
			break;
		}
	}
	
	public void jogada(int numero_jogador)
	{	
		for (int i=0; i<dado.somaDados; i++)
		{
			if (jogadores.get(numero_jogador).getCasa() == 0)
				jogadores.get(numero_jogador).y -= 110;
			if (jogadores.get(numero_jogador).getCasa() > 0 && jogadores.get(numero_jogador).getCasa() < 8)
				jogadores.get(numero_jogador).y -= 92;
			if (jogadores.get(numero_jogador).getCasa() == 8)
				jogadores.get(numero_jogador).y -= 110;
			if (jogadores.get(numero_jogador).getCasa() == 9)
				jogadores.get(numero_jogador).x += 110;
			if (jogadores.get(numero_jogador).getCasa() > 9 && jogadores.get(numero_jogador).getCasa() < 17 )
				jogadores.get(numero_jogador).x += 92;
			if (jogadores.get(numero_jogador).getCasa() == 17)
				jogadores.get(numero_jogador).x += 110;
			if (jogadores.get(numero_jogador).getCasa() == 18)
				jogadores.get(numero_jogador).y += 110;
			if (jogadores.get(numero_jogador).getCasa() > 18 && jogadores.get(numero_jogador).getCasa() < 26 )
				jogadores.get(numero_jogador).y += 92;
			if (jogadores.get(numero_jogador).getCasa() == 26)
				jogadores.get(numero_jogador).y += 110;
			if (jogadores.get(numero_jogador).getCasa() == 27)
				jogadores.get(numero_jogador).x -= 110;
			if (jogadores.get(numero_jogador).getCasa() > 27 && jogadores.get(numero_jogador).getCasa() < 35 )
				jogadores.get(numero_jogador).x -= 92;
			if (jogadores.get(numero_jogador).getCasa() == 35)
			{
				jogadores.get(numero_jogador).x -= 110;
				jogadores.get(numero_jogador).setCasa (jogadores.get(numero_jogador).getCasa() -1);
				jogadores.get(numero_jogador).setDinheiro(+200);
			}
			
			jogadores.get(numero_jogador).setCasa(jogadores.get(numero_jogador).getCasa()+1);
			repaint();
		}
	}
	
	private Territorio[] vetorTerritorio()
	{
		Territorio vet[] = new Territorio[36];
		
		//Casas verticais da esquerda
		vet[0] = new Territorio(8); vet[0].setNome("PONTO DE PARTIDA");
		vet[1] = new Territorio(1); vet[1].setPreco(220); vet[1].setNome("CURICICA"); vet[1].setImagem("src/territorios/curicica.jpg");
		vet[1].setTaxas(28, 150, 450, 1000, 1200, 1400); vet[1].setCor(1); vet[1].setPrecoSede(200); vet[1].setHipoteca(160);vet[1].setTaxaAtual(0);
		vet[2] = new Territorio(3); vet[2].setNome("SORTE OU REVES 1");
		vet[3] = new Territorio(2); vet[3].setPreco(200); vet[3].setNome("MÁQUINAS DE CAÇA-NÍQUEL");vet[3].setImagem("src/territorios/empresa3.jpg");
		vet[3].setTaxaUnica(50);
		vet[4] = new Territorio(1); vet[4].setPreco(300); vet[4].setNome("LEME"); vet[4].setImagem("src/territorios/leme.jpg");
		vet[4].setTaxas(26, 130, 390, 900, 1100, 1275); vet[4].setCor(2); vet[4].setPrecoSede(200); vet[4].setHipoteca(150);vet[4].setTaxaAtual(0);
		vet[5] = new Territorio(1); vet[5].setPreco(220); vet[5].setNome("VILAR CARIOCA");vet[5].setImagem("src/territorios/vilarcarioca.jpg");
		vet[5].setTaxas(18, 90, 250, 700, 875, 1050); vet[5].setCor(3);vet[5].setPrecoSede(150); vet[5].setHipoteca(110);vet[5].setTaxaAtual(0);
		vet[6] = new Territorio(3); vet[6].setNome("SORTE OU REVES 2");
		vet[7] = new Territorio(2); vet[7].setPreco(150); vet[7].setNome("BOTIJÃO DE GÁS");vet[7].setImagem("src/territorios/empresa2.jpg");
		vet[7].setTaxaUnica(40);
		vet[8] = new Territorio(1); vet[8].setPreco(140); vet[8].setNome("MORRO DO 18");vet[8].setImagem("src/territorios/morro18.jpg");
		vet[8].setTaxas(10, 50, 150, 450, 625, 750); vet[8].setCor(4); vet[8].setPrecoSede(100); vet[8].setHipoteca(70);vet[8].setTaxaAtual(0);
		
		//Casas horizontais de cima
		vet[9] = new Territorio(6); vet[9].setNome("BANGU 1");
		vet[10] = new Territorio(1); vet[10].setPreco(60); vet[10].setNome("GUAPORÉ");vet[10].setImagem("src/territorios/guapore.jpg");
		vet[10].setTaxas(4, 20, 60, 180, 320, 450); vet[10].setCor(5);vet[10].setPrecoSede(50); vet[10].setHipoteca(30);vet[10].setTaxaAtual(0);
		vet[11] = new Territorio(1); vet[11].setPreco(180); vet[11].setNome("TANQUE");vet[11].setImagem("src/territorios/tanque.jpg");
		vet[11].setTaxas(14, 70, 200, 550, 750, 950); vet[11].setCor(1);vet[11].setPrecoSede(100); vet[11].setHipoteca(90);vet[11].setTaxaAtual(0);
		vet[12] = new Territorio(1); vet[12].setPreco(300); vet[12].setNome("BOTAFOGO");vet[12].setImagem("src/territorios/botafogo.jpg");
		vet[12].setTaxas(26, 130, 390, 900, 1100, 1275); vet[12].setCor(2);vet[12].setPrecoSede(200); vet[12].setHipoteca(150);vet[12].setTaxaAtual(0);
		vet[13] = new Territorio(3); vet[13].setNome("SORTE OU REVES 3");
		vet[14] = new Territorio(1); vet[14].setPreco(260); vet[14].setNome("BATAN");vet[14].setImagem("src/territorios/batan.jpg");
		vet[14].setTaxas(22, 110, 330, 800, 975, 1150); vet[14].setCor(6);vet[14].setPrecoSede(150); vet[14].setHipoteca(130);vet[14].setTaxaAtual(0);
		vet[15] = new Territorio(2); vet[15].setPreco(200); vet[15].setNome("TRANSPORTE ALTERNATIVO");vet[15].setImagem("src/territorios/empresa6.jpg");
		vet[15].setTaxaUnica(50);
		vet[16] = new Territorio(1); vet[16].setPreco(220); vet[16].setNome("BARBANTE");vet[16].setImagem("src/territorios/barbante.jpg");
		vet[16].setTaxas(18, 90, 250, 700, 875, 1050); vet[16].setCor(3);vet[16].setPrecoSede(150); vet[16].setHipoteca(110);vet[16].setTaxaAtual(0);
		vet[17] = new Territorio(4); vet[17].setNome("PROPINAS E EXTORSÕES"); // Receba 200
		
		//Casas verticais da direita
		vet[18] = new Territorio(7); vet[18].setNome("PASSE LIVRE"); // Passe Livre
		vet[19] = new Territorio(2); vet[19].setPreco(200); vet[19].setNome("SEGURANÇA PATRIMONIAL");vet[19].setImagem("src/territorios/empresa5.jpg");
		vet[19].setTaxaUnica(50);
		vet[20] = new Territorio(1); vet[20].setPreco(180); vet[20].setNome("GARDÊNIA AZUL");vet[20].setImagem("src/territorios/gardeniaazul.jpg");
		vet[20].setTaxas(14, 70, 200, 550, 750, 950); vet[20].setCor(1);vet[20].setPrecoSede(100); vet[20].setHipoteca(90);vet[20].setTaxaAtual(0);
		vet[21] = new Territorio(1); vet[21].setPreco(140); vet[21].setNome("CAIXA D'ÁGUA");vet[21].setImagem("src/territorios/caixaagua.jpg");
		vet[21].setTaxas(10, 50, 150, 450, 625, 750); vet[21].setCor(4);vet[21].setPrecoSede(100); vet[21].setHipoteca(70);vet[21].setTaxaAtual(0);
		vet[22] = new Territorio(1); vet[22].setPreco(120); vet[22].setNome("KELSON'S");vet[22].setImagem("src/territorios/kelsons.jpg");
		vet[22].setTaxas(8, 40, 100, 300, 450, 600); vet[22].setCor(6);vet[22].setPrecoSede(50); vet[22].setHipoteca(60);vet[22].setTaxaAtual(0);
		vet[23] = new Territorio(3); vet[23].setNome("SORTE OU REVES 4"); // Sorte ou Reves
		vet[24] = new Territorio(2); vet[24].setPreco(200); vet[24].setNome("SERVIÇO DE MOTO-TÁXI");vet[24].setImagem("src/territorios/empresa4.jpg");
		vet[24].setTaxaUnica(50);
		vet[25] = new Territorio(1); vet[25].setPreco(60);  vet[25].setNome("QUITUNGO");vet[25].setImagem("src/territorios/quitungo.jpg");
		vet[25].setTaxas(4, 20, 60, 180, 320, 450); vet[25].setCor(5);vet[25].setPrecoSede(50); vet[25].setHipoteca(30);vet[25].setTaxaAtual(0);
		vet[26] = new Territorio(1); vet[26].setPreco(260); vet[26].setNome("RIO DAS PEDRAS");vet[26].setImagem("src/territorios/riodaspedras.jpg");
		vet[26].setTaxas(22, 110, 330, 800, 975, 1150); vet[26].setCor(2);vet[26].setPrecoSede(150); vet[26].setHipoteca(130);vet[26].setTaxaAtual(0);
		
		//Casas horizontais de baixo
		vet[27] = new Territorio(5); vet[27].setNome("VÁ PARA BANGU 1"); // Vai para prisao
		vet[28] = new Territorio(1); vet[28].setPreco(160); vet[28].setNome("FUBÁ");vet[28].setImagem("src/territorios/fuba.jpg");
		vet[28].setTaxas(12, 60, 180, 500, 700, 900); vet[28].setCor(4);vet[28].setPrecoSede(100); vet[28].setHipoteca(80);vet[28].setTaxaAtual(0);
		vet[29] = new Territorio(3); vet[29].setNome("SORTE OU REVES 5"); // Sorte ou Reves
		vet[30] = new Territorio(1); vet[30].setPreco(240); vet[30].setNome("CAROBINHA");vet[30].setImagem("src/territorios/carobinha.jpg");
		vet[30].setTaxas(20, 100, 300, 750, 925, 1100); vet[30].setCor(3);vet[30].setPrecoSede(150); vet[30].setHipoteca(120);vet[30].setTaxaAtual(0);
		vet[31] = new Territorio(2); vet[31].setPreco(150); vet[31].setNome("SINAL DE TV À GATO");vet[31].setImagem("src/territorios/empresa1.jpg");
		vet[31].setTaxaUnica(40);
		vet[32] = new Territorio(1); vet[32].setPreco(100); vet[32].setNome("FUMACÊ");vet[32].setImagem("src/territorios/fumace.jpg");
		vet[32].setTaxas(6, 30, 90, 270, 400, 500); vet[32].setCor(6);vet[32].setPrecoSede(50); vet[32].setHipoteca(50);vet[32].setTaxaAtual(0);
		vet[33] = new Territorio(3); vet[33].setNome("SORTE OU REVES 6"); // Sorte ou Reves
		vet[34] = new Territorio(9); vet[34].setNome("CUSTOS DE CAMPANHA"); // Pague 200
		vet[35] = new Territorio(1); vet[35].setPreco(100); vet[35].setNome("CIDADE ALTA");vet[35].setImagem("src/territorios/cidadealta.jpg");
		vet[35].setTaxas(6, 30, 90, 270, 400, 500); vet[35].setCor(5);vet[35].setPrecoSede(50); vet[35].setHipoteca(50);vet[35].setTaxaAtual(0);
		
		return vet;
	}
	
	private SorteOuReves[] vetorSorteReves()
	{
		SorteOuReves vet[] = new SorteOuReves[30];
		//Sorte
		vet[0] = new SorteOuReves(150); vet[0].setImagem("src/sorteReves/sorte01.jpg");
		vet[1] = new SorteOuReves(100); vet[1].setImagem("src/sorteReves/sorte02.jpg");
		vet[2] = new SorteOuReves(0); vet[2].setImagem("src/sorteReves/sorte03.jpg"); vet[2].setPasse();
		vet[3] = new SorteOuReves(80); vet[3].setImagem("src/sorteReves/sorte04.jpg");
		vet[4] = new SorteOuReves(100); vet[4].setImagem("src/sorteReves/sorte05.jpg");
		vet[5] = new SorteOuReves(0); vet[5].setImagem("src/sorteReves/sorte06.jpg"); vet[5].setRecebeOutros();
		vet[6] = new SorteOuReves(50); vet[6].setImagem("src/sorteReves/sorte07.jpg"); 
		vet[7] = new SorteOuReves(20); vet[7].setImagem("src/sorteReves/sorte08.jpg");
		vet[8] = new SorteOuReves(25); vet[8].setImagem("src/sorteReves/sorte09.jpg");
		vet[9] = new SorteOuReves(200); vet[9].setImagem("src/sorteReves/sorte10.jpg"); vet[9].setPartida();
		vet[10] = new SorteOuReves(100); vet[10].setImagem("src/sorteReves/sorte11.jpg");
		vet[11] = new SorteOuReves(100); vet[11].setImagem("src/sorteReves/sorte12.jpg");
		vet[12] = new SorteOuReves(45); vet[12].setImagem("src/sorteReves/sorte13.jpg");
		vet[13] = new SorteOuReves(50); vet[13].setImagem("src/sorteReves/sorte14.jpg");
		vet[14] = new SorteOuReves(200); vet[14].setImagem("src/sorteReves/sorte15.jpg");
		
		//Reves
		vet[15] = new SorteOuReves(-25); vet[15].setImagem("src/sorteReves/reves01.jpg");
		vet[16] = new SorteOuReves(-45); vet[16].setImagem("src/sorteReves/reves02.jpg");
		vet[17] = new SorteOuReves(-45); vet[17].setImagem("src/sorteReves/reves03.jpg");
		vet[18] = new SorteOuReves(-30); vet[18].setImagem("src/sorteReves/reves04.jpg");
		vet[19] = new SorteOuReves(-40); vet[19].setImagem("src/sorteReves/reves05.jpg");
		vet[20] = new SorteOuReves(-50); vet[20].setImagem("src/sorteReves/reves06.jpg");
		vet[21] = new SorteOuReves(-100); vet[21].setImagem("src/sorteReves/reves07.jpg");
		vet[22] = new SorteOuReves(-50); vet[22].setImagem("src/sorteReves/reves08.jpg");
		vet[23] = new SorteOuReves(-30); vet[23].setImagem("src/sorteReves/reves09.jpg");
		vet[24] = new SorteOuReves(-30); vet[24].setImagem("src/sorteReves/reves10.jpg");
		vet[25] = new SorteOuReves(-25); vet[25].setImagem("src/sorteReves/reves11.jpg");
		vet[26] = new SorteOuReves(0); vet[26].setImagem("src/sorteReves/reves12.jpg"); vet[26].setIrPrisao();
		vet[27] = new SorteOuReves(-100); vet[27].setImagem("src/sorteReves/reves13.jpg");
		vet[28] = new SorteOuReves(-50); vet[28].setImagem("src/sorteReves/reves14.jpg");
		vet[29] = new SorteOuReves(-15); vet[29].setImagem("src/sorteReves/reves15.jpg");
		
		return vet;
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		desenha(g);
	}	
}
