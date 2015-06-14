package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Controladores.ControladorMapa;

class PopUp extends JPopupMenu implements ActionListener{
	private static final long serialVersionUID = 1L;

	JMenuItem anItem;

	PainelMapa painel;

	public PopUp(String s){
		anItem = new JMenuItem(s);
		anItem.setEnabled(false);
		anItem.setName(s);
		anItem.setBackground(new Color(0,0 ,255));
		anItem.setFont(new Font("default", 18,15));
		add(anItem);

		anItem = new JMenuItem("Atacante");
		add(anItem);
		anItem.addActionListener(this);
		
		if(!ControladorMapa.permitidoAtacar(this.getComponent(0).getName())){
			anItem.setEnabled(false);
		}

		anItem = new JMenuItem("Defensor");
		add(anItem);
		anItem.addActionListener(this);
		
		if(!ControladorMapa.permitidoDefender(this.getComponent(0).getName())){
			anItem.setEnabled(false);
		}
		

		anItem = new JMenuItem("Add exer.");
		add(anItem);
		anItem.addActionListener(this);
		
		if(!ControladorMapa.permitido(this.getComponent(0).getName())){
			anItem.setEnabled(false);
		}
		
		anItem = new JMenuItem("Add tudo");
		add(anItem);
		anItem.addActionListener(this);
		
		if(!ControladorMapa.permitido(this.getComponent(0).getName())){
			anItem.setEnabled(false);
		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Add exer.")){
			System.out.println("Selected: " + e.getActionCommand() + this.getComponent(0).getName());
			ControladorMapa.addExer(this.getComponent(0).getName());
			painel.nExer();
		}
		
		if(e.getActionCommand().equals("Add tudo")){
			System.out.println("Selected: " + e.getActionCommand() + this.getComponent(0).getName());
			
			while(true){
				if(ControladorMapa.permitido(this.getComponent(0).getName())){
					ControladorMapa.addExer(this.getComponent(0).getName());
					painel.nExer();
				}
				else{
					break;
				}
			}
			
		}

	}

	public PainelMapa getPainel() {
		return painel;
	}

	public void setPainel(PainelMapa painel) {
		this.painel = painel;
	}


}