package game.ui.view.juego;

import game.model.Modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EleccionLado extends javax.swing.JPanel {

    private Modelo modelo;
    public EleccionLado(Modelo modelo) {
        this.modelo = modelo;
        initComponents();

    }

    private void initControlador(){
        Negras.addActionListener((ActionEvent e) -> {
            modelo.inicioLado = 1;
            notifyAll();
        });
        Blancas.addActionListener((ActionEvent e) ->{
            modelo.inicioLado =2;
            notifyAll();
        } );
    }

    private void initComponents() {

        Negras = new javax.swing.JButton();
        Blancas = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1200, 890));

        Negras.setText("NEGRAS");
        Blancas.setText("BLANCAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Negras, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Blancas, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Negras, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
            .addComponent(Blancas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }


    private javax.swing.JButton Blancas;
    private javax.swing.JButton Negras;
}
