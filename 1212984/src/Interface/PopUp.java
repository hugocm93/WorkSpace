package Interface;

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
		add(anItem);

		anItem = new JMenuItem("Atacante");
		add(anItem);
		anItem.addActionListener(this);

		anItem = new JMenuItem("Defensor");
		add(anItem);
		anItem.addActionListener(this);

		anItem = new JMenuItem("Add exer.");
		add(anItem);
		anItem.addActionListener(this);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Add exer.")){
			this.getComponent(0);
			System.out.println("Selected: " + e.getActionCommand() + this.getComponent(0).getName());
			ControladorMapa.addExer(this.getComponent(0).getName());
			painel.nExer();
		}

	}

	public PainelMapa getPainel() {
		return painel;
	}

	public void setPainel(PainelMapa painel) {
		this.painel = painel;
	}



}