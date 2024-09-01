package game.ui.view.juego.tab;

import game.core.controller.ControladorCasilla;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class Casilla extends JPanel {

    @Getter
    private final TableroV tablero; // las casillas necesitan meterse a algún modelo
    private final JLabel imagen;
    @Getter
    @Setter
    private boolean seleccionado;
    @Getter
    @Setter
    private Point puntoInicial;

    public Casilla(TableroV tablero) {
        ControladorCasilla controlador = new ControladorCasilla(this);
        this.tablero = tablero;
        imagen = new JLabel();
        imagen.setBounds(0,0,getWidth(),getHeight());
        imagen.setFont(new Font("Serif", Font.PLAIN, 54));
        add(imagen); // añadimos el JLabel
        seleccionado = false; // lo inicializamos falso
        //Añadimos los controladores o Handlers.
        addMouseListener(controlador);
        addMouseMotionListener(controlador);
    }



    public void setImagen(String imagen) { // No es una imagen pero por ahora
        // recibirá una dirección de imagen o imagen
        this.imagen.setText(imagen); // usar setIcon para el icono por ahora esto
    }

}
