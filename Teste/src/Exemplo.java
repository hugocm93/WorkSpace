import javax.swing.JOptionPane;  
  
public class Exemplo extends javax.swing.JFrame {  
  
    private javax.swing.JButton botao1;  
    private javax.swing.JButton botao2;  
    private javax.swing.JButton botao3;  
    private javax.swing.JButton botao4;  
      
    public Exemplo() {  
        initComponents();  
    }  
      
    private void initComponents() {  
        botao1 = new javax.swing.JButton();  
        botao2 = new javax.swing.JButton();  
        botao3 = new javax.swing.JButton();  
        botao4 = new javax.swing.JButton();  
  
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.X_AXIS));  
  
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);  
        botao1.setText("INFO");  
        botao1.addActionListener(new java.awt.event.ActionListener() {  
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                botao1ActionPerformed(evt);  
            }  
        });  
  
        getContentPane().add(botao1);  
  
        botao2.setText("WARNING");  
        botao2.addActionListener(new java.awt.event.ActionListener() {  
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                botao2ActionPerformed(evt);  
            }  
        });  
  
        getContentPane().add(botao2);  
  
        botao3.setText("ERROR");  
        botao3.addActionListener(new java.awt.event.ActionListener() {  
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                botao3ActionPerformed(evt);  
            }  
        });  
  
        getContentPane().add(botao3);  
  
        botao4.setText("CONFIRM");  
        botao4.addActionListener(new java.awt.event.ActionListener() {  
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                botao4ActionPerformed(evt);  
            }  
        });  
  
        getContentPane().add(botao4);  
  
        pack();  
    }  
  
    private void botao4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int i = JOptionPane.showConfirmDialog( this, "Confirmação",   
                "Titulo", JOptionPane.YES_NO_CANCEL_OPTION  );  
    }                                        
  
    private void botao3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JOptionPane.showMessageDialog( this, "Mensagem de Erro",   
                "Action...", JOptionPane.ERROR_MESSAGE);  
    }                                        
  
    private void botao2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JOptionPane.showMessageDialog( this, "Mensagem de Aviso",   
                "Action...", JOptionPane.WARNING_MESSAGE);  
    }                                        
  
    private void botao1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JOptionPane.showMessageDialog( this, "Mensagem de Informação",   
                "Action...", JOptionPane.INFORMATION_MESSAGE);  
    }                                        
      
    public static void main(String args[]) {  
        java.awt.EventQueue.invokeLater(new Runnable() {  
            public void run() {  
                new Exemplo().setVisible(true);  
            }  
        });  
    }  
      
} 