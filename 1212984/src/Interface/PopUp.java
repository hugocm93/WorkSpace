package Interface;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class PopUp extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	
	JMenuItem anItem;
    
    public PopUp(String s){
        anItem = new JMenuItem(s);
        anItem.setEnabled(false);
        add(anItem);
    }
    
    public PopUp(){
        anItem = new JMenuItem("Atacante");
        add(anItem);
        
        anItem = new JMenuItem("Defensor");
        add(anItem);

    }
}