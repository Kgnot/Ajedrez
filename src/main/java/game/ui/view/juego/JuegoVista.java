package game.ui.view.juego;


import game.model.Modelo;
import game.ui.view.juego.tab.TableroV;
import lombok.Getter;

public class JuegoVista extends javax.swing.JPanel {

    private final Modelo modelo;
    @Getter
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

        PanelTablero = new javax.swing.JPanel();
        AjedrezJuego = new javax.swing.JPanel();
        PanelFichasMuertas = new javax.swing.JPanel();
        PanelLateral = new javax.swing.JPanel();
        BTN_Enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_Chat = new javax.swing.JTextArea();
        TF_Chat = new javax.swing.JTextField();
        PanelMenu = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1200, 890));

        PanelTablero.setBackground(new java.awt.Color(133, 146, 158));

        AjedrezJuego.setBackground(new java.awt.Color(255, 255, 255));
        AjedrezJuego.setPreferredSize(new java.awt.Dimension(720, 720));
        AjedrezJuego.setLayout(new java.awt.CardLayout());

        PanelFichasMuertas.setPreferredSize(new java.awt.Dimension(180, 720));

        javax.swing.GroupLayout PanelFichasMuertasLayout = new javax.swing.GroupLayout(PanelFichasMuertas);
        PanelFichasMuertas.setLayout(PanelFichasMuertasLayout);
        PanelFichasMuertasLayout.setHorizontalGroup(
            PanelFichasMuertasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );
        PanelFichasMuertasLayout.setVerticalGroup(
            PanelFichasMuertasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelTableroLayout = new javax.swing.GroupLayout(PanelTablero);
        PanelTablero.setLayout(PanelTableroLayout);
        PanelTableroLayout.setHorizontalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTableroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelFichasMuertas, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(AjedrezJuego, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        PanelTableroLayout.setVerticalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelFichasMuertas, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AjedrezJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        PanelLateral.setBackground(new java.awt.Color(255, 255, 255));

        BTN_Enviar.setText("Enviar");
        BTN_Enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        TA_Chat.setEditable(false);
        TA_Chat.setBackground(new java.awt.Color(255, 255, 255));
        TA_Chat.setColumns(20);
        TA_Chat.setLineWrap(true);
        TA_Chat.setRows(5);
        jScrollPane1.setViewportView(TA_Chat);

        javax.swing.GroupLayout PanelLateralLayout = new javax.swing.GroupLayout(PanelLateral);
        PanelLateral.setLayout(PanelLateralLayout);
        PanelLateralLayout.setHorizontalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralLayout.createSequentialGroup()
                .addGroup(PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLateralLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(BTN_Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TF_Chat))
                    .addGroup(PanelLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelLateralLayout.setVerticalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLateralLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_Chat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTN_Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
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
            .addGap(0, 55, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(PanelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AjedrezJuego;
    private javax.swing.JButton BTN_Enviar;
    private javax.swing.JPanel PanelFichasMuertas;
    private javax.swing.JPanel PanelLateral;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelTablero;
    private javax.swing.JTextArea TA_Chat;
    private javax.swing.JTextField TF_Chat;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
