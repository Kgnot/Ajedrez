package game.ui.view.juego;

import game.core.controller.ControllerJuegoVista;
import game.model.Modelo;
import game.ui.view.juego.tab.TableroV;
import lombok.Getter;

import java.awt.*;

@Getter
public class JuegoVista extends javax.swing.JPanel {

    private final Modelo modelo;
    @Getter
    private final TableroV vistaTablero;
    private ControllerJuegoVista controlador;

    public JuegoVista(Modelo modelo) {
        this.modelo = modelo;
        initComponents();
        initListener();
        vistaTablero = new TableroV(AjedrezJuego.getPreferredSize().width / 8, this.modelo);
        AjedrezJuego.add(vistaTablero);
    }

    private void initListener() {
        Negras.addActionListener(getControlador());
        Blancas.addActionListener(getControlador());
    }

    public void cambiarPanelJuego() {
        CardLayout layout = (CardLayout) this.getLayout();
        layout.show(this, "GameTablero");
    }

    public void CambiarPanelEleccion() {
        CardLayout layout = (CardLayout) this.getLayout();
        layout.show(this, "PanelEleccion");
    }

    private ControllerJuegoVista getControlador() {
        if (controlador == null) {
            controlador = new ControllerJuegoVista(this);
        }
        return controlador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JPanel();
        inicioLogin1 = new game.ui.view.juego.InicioLogin(getControlador());
        PanelEleccion = new javax.swing.JPanel();
        Blancas = new javax.swing.JButton();
        Negras = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        PanelTablero = new javax.swing.JPanel();
        AjedrezJuego = new javax.swing.JPanel();
        PanelFichasMuertas = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1200, 820));
        setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicioLogin1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(inicioLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(Login, "PanelLogin");

        Blancas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/pixelArt/Bander/ImagenBlancas.png"))); // NOI18N

        Negras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/pixelArt/Bander/ImagenNegras.jpeg"))); // NOI18N

        javax.swing.GroupLayout PanelEleccionLayout = new javax.swing.GroupLayout(PanelEleccion);
        PanelEleccion.setLayout(PanelEleccionLayout);
        PanelEleccionLayout.setHorizontalGroup(
            PanelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEleccionLayout.createSequentialGroup()
                .addComponent(Blancas, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Negras, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        PanelEleccionLayout.setVerticalGroup(
            PanelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Blancas, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Negras, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(PanelEleccion, "PanelEleccion");

        PanelMenu.setBackground(new java.awt.Color(39, 55, 70));

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1188, Short.MAX_VALUE)
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );

        PanelTablero.setBackground(new java.awt.Color(133, 146, 158));

        AjedrezJuego.setBackground(new java.awt.Color(255, 255, 255));
        AjedrezJuego.setPreferredSize(new java.awt.Dimension(720, 720));
        AjedrezJuego.setLayout(new java.awt.CardLayout());

        PanelFichasMuertas.setPreferredSize(new java.awt.Dimension(180, 720));

        javax.swing.GroupLayout PanelFichasMuertasLayout = new javax.swing.GroupLayout(PanelFichasMuertas);
        PanelFichasMuertas.setLayout(PanelFichasMuertasLayout);
        PanelFichasMuertasLayout.setHorizontalGroup(
            PanelFichasMuertasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        PanelFichasMuertasLayout.setVerticalGroup(
            PanelFichasMuertasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelTableroLayout = new javax.swing.GroupLayout(PanelTablero);
        PanelTablero.setLayout(PanelTableroLayout);
        PanelTableroLayout.setHorizontalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTableroLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(AjedrezJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelFichasMuertas, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        PanelTableroLayout.setVerticalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableroLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelFichasMuertas, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AjedrezJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelTablero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(MainPanel, "GameTablero");
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AjedrezJuego;
    private javax.swing.JButton Blancas;
    private javax.swing.JPanel Login;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton Negras;
    private javax.swing.JPanel PanelEleccion;
    private javax.swing.JPanel PanelFichasMuertas;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelTablero;
    private game.ui.view.juego.InicioLogin inicioLogin1;
    // End of variables declaration//GEN-END:variables

}
