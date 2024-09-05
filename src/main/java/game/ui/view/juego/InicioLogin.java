package game.ui.view.juego;

import game.core.controller.ControllerJuegoVista;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;
import javax.swing.ImageIcon;
import lombok.Getter;

@Getter
public class InicioLogin extends javax.swing.JPanel {

    private ImageIcon image;
    private String path = "/iconos/inicio.jpeg";
    private ControllerJuegoVista controlador;

    public InicioLogin(ControllerJuegoVista controlador) {
        this.controlador = controlador;
        System.out.println("Entre a inicioLogin");
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource(path)));
        System.out.println("image: " + image);
        initComponents();
        PPL.setBackground(new Color(255, 255, 255, 245));
        initListeners();
    }
    
    
    private void initListeners(){
        Ingresar.addActionListener(controlador);
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PPL = new javax.swing.JPanel();
        Ingresar = new javax.swing.JButton();
        TF_Password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        TF_User = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        PPL.setBackground(new java.awt.Color(255, 255, 255));
        PPL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ingresar.setText("Ingresar");
        Ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PPL.add(Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 442, 159, 53));

        TF_Password.setBackground(new java.awt.Color(245, 245, 245));
        TF_Password.setBorder(null);
        PPL.add(TF_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 300, 40));

        jLabel1.setText("User: ");
        PPL.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 86, 40));

        jLabel2.setText("Password: ");
        PPL.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 259, 86, 40));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AJEDREZ ");
        PPL.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 10, 680, 66));
        PPL.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 300, 20));

        TF_User.setBackground(new java.awt.Color(245, 245, 245));
        TF_User.setBorder(null);
        PPL.add(TF_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 300, 40));
        PPL.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 300, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addComponent(PPL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(PPL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ingresar;
    private javax.swing.JPanel PPL;
    private javax.swing.JPasswordField TF_Password;
    private javax.swing.JTextField TF_User;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
