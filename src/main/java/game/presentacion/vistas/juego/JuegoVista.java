package game.presentacion.vistas.juego;


import game.presentacion.Modelo;
import game.presentacion.vistas.juego.tab.TableroV;

public class JuegoVista extends javax.swing.JPanel {

    private final Modelo modelo;
    private final TableroV vistaTablero;

    public JuegoVista(Modelo modelo) {
        this.modelo = modelo;
        initComponents();
        vistaTablero = new TableroV(AjedrezJuego.getPreferredSize().width/8,this.modelo);
        AjedrezJuego.add(vistaTablero);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PanelTablero = new javax.swing.JPanel();
        AjedrezJuego = new javax.swing.JPanel();
        PanelLateral = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();

        PanelTablero.setBackground(new java.awt.Color(133, 146, 158));
        PanelTablero.setLayout(new java.awt.GridBagLayout());

        AjedrezJuego.setBackground(new java.awt.Color(255, 255, 255));
        AjedrezJuego.setPreferredSize(new java.awt.Dimension(584, 584));

        javax.swing.GroupLayout AjedrezJuegoLayout = new javax.swing.GroupLayout(AjedrezJuego);
        AjedrezJuego.setLayout(AjedrezJuegoLayout);
        AjedrezJuegoLayout.setHorizontalGroup(
            AjedrezJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        AjedrezJuegoLayout.setVerticalGroup(
            AjedrezJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 580.0;
        gridBagConstraints.weighty = 580.0;
        PanelTablero.add(AjedrezJuego, gridBagConstraints);

        javax.swing.GroupLayout PanelLateralLayout = new javax.swing.GroupLayout(PanelLateral);
        PanelLateral.setLayout(PanelLateralLayout);
        PanelLateralLayout.setHorizontalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        PanelLateralLayout.setVerticalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );

        PanelMenu.setBackground(new java.awt.Color(39, 55, 70));

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(PanelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelLateral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTablero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AjedrezJuego;
    private javax.swing.JPanel PanelLateral;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelTablero;
    // End of variables declaration//GEN-END:variables

    public TableroV getVistaTablero(){
        return vistaTablero;
    }
}
