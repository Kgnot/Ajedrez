package game.ui.view.juego.tab;

import game.core.controller.ControladorCasilla;
import javax.swing.*;
import java.awt.*;

public class Casilla extends JPanel {

    private final TableroV tablero; // las casillas necesitan meterse a algún modelo
    private final JLabel imagen;

    public Casilla(TableroV tablero) {
        ControladorCasilla controlador = new ControladorCasilla(this);
        this.tablero = tablero;
        imagen = new JLabel();
        imagen.setBounds(0,0,getWidth(),getHeight());
        imagen.setFont(new Font("Serif", Font.PLAIN, 54));
        add(imagen);
        addMouseListener(controlador);
    }
    public TableroV getTablero() {
        return tablero;
    }

    public void setImagen(String imagen) {
        // recibirá una dirección de imagen o imagen
        this.imagen.setText(imagen); // usar setIcon para el icono por ahora esto
    }

}
