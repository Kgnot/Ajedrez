package game.ui.view.juego;

import game.core.controller.ControllerJuegoVista;

import java.awt.*;
import java.util.Objects;
import javax.swing.ImageIcon;

import game.util.fontCode.FontClass;
import lombok.Getter;

@Getter
public class InicioLogin extends javax.swing.JPanel {

    private ImageIcon image;
    private String path = "/iconos/inicio.jpg";
    private ControllerJuegoVista controlador;

    public InicioLogin(ControllerJuegoVista controlador) {
        System.out.println("BIEN");
        this.controlador = controlador;
        try {
            image = new ImageIcon(Objects.requireNonNull(getClass().getResource(path)));
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen");
        }

        initComponents();
        PPL.setBackground(new Color(223, 223, 223, 225));
        initFontLabel();
        initListeners();
    }

    private void initFontLabel(){
        FontClass f1 = FontClass.getPpxlFont();
        FontClass f2 = FontClass.getPpxlFont();
        Titulo.setFont(f2.getFont());
        f1.setTamFuente(20);
        TXT_User.setFont(f1.getFont());
        TXT_Password.setFont(f1.getFont());
        // Parte de los inputs
        TF_User.setFont(f1.getFont());
        TF_Password.setFont(f1.getFont());
        Ingresar.setFont(f1.getFont());
    }

    private void initListeners() {
        Ingresar.addActionListener(controlador);
    }

    private void initComponents() {

        PPL = new javax.swing.JPanel();
        Ingresar = new javax.swing.JButton();
        TF_Password = new javax.swing.JPasswordField();
        TXT_User = new javax.swing.JLabel();
        TXT_Password = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        TF_User = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        PPL.setBackground(new java.awt.Color(255, 255, 255));
        PPL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ingresar.setText("Ingresar");
        Ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PPL.add(Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 442, 159, 53));


        TXT_User.setText("User: ");
        PPL.add(TXT_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 120, 40));

        TXT_Password.setText("Password: ");
        PPL.add(TXT_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 259, 120, 40));

        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("JAQUE EN EL POLO");
        PPL.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 10, 680, 66));

        TF_User.setBackground(new java.awt.Color(255, 255, 255,240));
        TF_User.setBorder(null);
        PPL.add(TF_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 300, 40));
        PPL.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 300, 20));

        TF_Password.setBackground(new java.awt.Color(255, 255, 255,240));
        TF_Password.setBorder(null);
        PPL.add(TF_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 300, 40));
        PPL.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 300, 20));


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
    private javax.swing.JLabel TXT_User;
    private javax.swing.JLabel TXT_Password;
    private javax.swing.JLabel Titulo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        }

    }

}
